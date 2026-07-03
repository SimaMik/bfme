package net.sima.bfme.worldgen.noise;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ИмprovedNoise — точная адаптация ванильной Mojang реализации Perlin noise
 * (net.minecraft.world.level.levelgen.synth.ImprovedNoise).
 *
 * Использует ванильную GRADIENT таблицу (16 векторов из SimplexNoise.GRADIENT),
 * ванильный permutation shuffle (Fisher-Yates через random.nextInt(256-k)),
 * ванильный smoothstep t*t*t*(t*(t*6-15)+10), ванильный trilinear lerp.
 *
 * API: static методы с seed параметром для совместимости с текущими
 * вызовами OpenSimplex2S.noise3_ImproveXY в WorldNoiseGenerator.
 *
 * Per-seed state (permutation table + xo/yo/zo offsets) кэшируется в
 * ConcurrentHashMap — seed'ы cave noise фиксированные, кэш не растёт.
 *
 * Output range: ~[-0.866, 0.866] для 3D, stddev ~0.21 per octave
 * (меньше OpenSimplex 0.30 → меньше clamping в cheese density,
 * меньше летающих островов при multi-octave).
 */
public final class ImprovedNoise {

    /** Ванильная gradient table из SimplexNoise.GRADIENT */
    private static final int[][] GRADIENT = {
            {1, 1, 0}, {-1, 1, 0}, {1, -1, 0}, {-1, -1, 0},
            {1, 0, 1}, {-1, 0, 1}, {1, 0, -1}, {-1, 0, -1},
            {0, 1, 1}, {0, -1, 1}, {0, 1, -1}, {0, -1, -1},
            {1, 1, 0}, {0, -1, 1}, {-1, 1, 0}, {0, -1, -1}
    };

    /** Per-seed state: permutation + coordinate offsets */
    private static final class State {
        final byte[] p = new byte[256];
        final double xo, yo, zo;

        State(long seed) {
            Random random = new Random(seed);
            this.xo = random.nextDouble() * 256.0;
            this.yo = random.nextDouble() * 256.0;
            this.zo = random.nextDouble() * 256.0;
            for (int i = 0; i < 256; i++) p[i] = (byte) i;
            // Ванильный Fisher-Yates shuffle
            for (int k = 0; k < 256; k++) {
                int j = random.nextInt(256 - k);
                byte b0 = p[k];
                p[k] = p[k + j];
                p[k + j] = b0;
            }
        }
    }

    private static final ConcurrentHashMap<Long, State> STATE_CACHE = new ConcurrentHashMap<>();
    private static final int MAX_CACHE_SIZE = 512;

    private static State getState(long seed) {
        State s = STATE_CACHE.get(seed);
        if (s != null) return s;
        if (STATE_CACHE.size() > MAX_CACHE_SIZE) {
            STATE_CACHE.clear();
        }
        s = new State(seed);
        STATE_CACHE.put(seed, s);
        return s;
    }

    private static int floor(double v) {
        int i = (int) v;
        return v < i ? i - 1 : i;
    }

    private static int p(byte[] perm, int index) {
        return perm[index & 0xFF] & 0xFF;
    }

    private static double gradDot(int gradIndex, double x, double y, double z) {
        int[] g = GRADIENT[gradIndex & 15];
        return g[0] * x + g[1] * y + g[2] * z;
    }

    private static double smoothstep(double t) {
        return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);
    }

    private static double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    /**
     * 3D Perlin noise (классический порядок параметров x, y, z).
     * @return значение в [-0.866, 0.866]
     */
    public static double noise3(long seed, double x, double y, double z) {
        State s = getState(seed);
        byte[] perm = s.p;

        double d0 = x + s.xo;
        double d1 = y + s.yo;
        double d2 = z + s.zo;
        int gridX = floor(d0);
        int gridY = floor(d1);
        int gridZ = floor(d2);
        double dx = d0 - gridX;
        double dy = d1 - gridY;
        double dz = d2 - gridZ;

        int i  = p(perm, gridX);
        int j  = p(perm, gridX + 1);
        int k  = p(perm, i + gridY);
        int l  = p(perm, i + gridY + 1);
        int i1 = p(perm, j + gridY);
        int j1 = p(perm, j + gridY + 1);

        double g0 = gradDot(p(perm, k  + gridZ),     dx,     dy,     dz);
        double g1 = gradDot(p(perm, i1 + gridZ),     dx - 1, dy,     dz);
        double g2 = gradDot(p(perm, l  + gridZ),     dx,     dy - 1, dz);
        double g3 = gradDot(p(perm, j1 + gridZ),     dx - 1, dy - 1, dz);
        double g4 = gradDot(p(perm, k  + gridZ + 1), dx,     dy,     dz - 1);
        double g5 = gradDot(p(perm, i1 + gridZ + 1), dx - 1, dy,     dz - 1);
        double g6 = gradDot(p(perm, l  + gridZ + 1), dx,     dy - 1, dz - 1);
        double g7 = gradDot(p(perm, j1 + gridZ + 1), dx - 1, dy - 1, dz - 1);

        double u = smoothstep(dx);
        double v = smoothstep(dy);
        double w = smoothstep(dz);

        double x00 = lerp(u, g0, g1);
        double x10 = lerp(u, g2, g3);
        double x01 = lerp(u, g4, g5);
        double x11 = lerp(u, g6, g7);
        double y0 = lerp(v, x00, x10);
        double y1 = lerp(v, x01, x11);
        return lerp(w, y0, y1);
    }

    /**
     * OpenSimplex2S.noise3_ImproveXY-совместимый API — порядок параметров (seed, x, z, y),
     * где Y подразумевается как вертикальная ось в Minecraft.
     *
     * В Perlin (изотропен в отличие от OpenSimplex) "ImproveXY" не имеет особого смысла,
     * но для минимизации изменений в WorldNoiseGenerator сохраняем сигнатуру:
     * третий параметр здесь — это "Y в Minecraft смысле", используется как Z координата
     * для noise3, а второй параметр (Z в Minecraft) — как Y координата для noise3.
     *
     * На практике для Perlin порядок осей не важен — форма симметрична.
     */
    public static double noise3_ImproveXY(long seed, double x, double z, double y) {
        return noise3(seed, x, z, y);
    }

    /**
     * OpenSimplex2S.noise3_ImproveXZ-совместимый API.
     */
    public static double noise3_ImproveXZ(long seed, double x, double y, double z) {
        return noise3(seed, x, y, z);
    }

    public static void clearCache() {
        STATE_CACHE.clear();
    }

    private ImprovedNoise() {}
}