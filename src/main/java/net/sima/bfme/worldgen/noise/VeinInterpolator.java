package net.sima.bfme.worldgen.noise;

/**
 * Интерполятор vein noise — 1:1 ваниль {@code yLimitedInterpolatable} паттерн.
 *
 * <p>Ваниль (NoiseRouterData строки 367-378) обёртывает veininess/vein_a/vein_b в
 * {@code DensityFunctions.interpolated(rangeChoice(...))} → сэмплируется на cellGrid
 * 4×4×8, trilinear между точками. Это даёт ~20× выигрыш по сравнению с per-block.
 *
 * <p>Gap НЕ интерполируется в ваниль (NoiseRouterData строка 380) — он считается
 * per-block, но вызывается только когда блок прошёл все предыдущие checks
 * (~0.03% блоков → ~20 вызовов на чанк).
 *
 * <p>Y range берётся как union всех VeinType (IRON.minY до COPPER.maxY).
 * Вне Y range grid содержит 0 (как ваниль whenOutOfRange=0).
 */
public class VeinInterpolator {

    private static final int STEP_XZ = 4;
    private static final int STEP_Y = 8;
    private static final int GX = 16 / STEP_XZ + 1;  // 5
    private static final int GZ = 16 / STEP_XZ + 1;  // 5

    // Union Y range всех vein types
    private static final int Y_MIN = -170;  // IRON_DEEP.minY
    private static final int Y_MAX = 50;    // COPPER.maxY

    private final int gridY;
    private final int chunkStartX;
    private final int chunkStartZ;

    // Гриды расплющены в 1D (float[GX*GZ*gridY], индекс = (gx*GZ+gz)*gridY+gy) — одна загрузка
    // вместо 3 деерефов 3D-массива (как в CaveInterpolator).
    private final float[] veininessGrid;
    private final float[] veinAGrid;
    private final float[] veinBGrid;

    public VeinInterpolator(WorldNoiseGenerator noise, int chunkX, int chunkZ) {
        this.chunkStartX = chunkX * 16;
        this.chunkStartZ = chunkZ * 16;
        // (Y_MAX - Y_MIN) / STEP_Y + 1 = 270/8 + 1 = 34
        this.gridY = (Y_MAX - Y_MIN) / STEP_Y + 2; // +2 для безопасности на upper boundary

        int gridLen = GX * GZ * gridY;
        this.veininessGrid = new float[gridLen];
        this.veinAGrid     = new float[gridLen];
        this.veinBGrid     = new float[gridLen];

        precompute(noise);
    }

    private void precompute(WorldNoiseGenerator noise) {
        for (int gx = 0; gx < GX; gx++) {
            for (int gz = 0; gz < GZ; gz++) {
                int worldX = chunkStartX + gx * STEP_XZ;
                int worldZ = chunkStartZ + gz * STEP_XZ;
                int cellBase = (gx * GZ + gz) * gridY;
                for (int gy = 0; gy < gridY; gy++) {
                    int worldY = Y_MIN + gy * STEP_Y;
                    int i = cellBase + gy;
                    // Внутри Y range — sample noise. Вне — 0 (ваниль whenOutOfRange).
                    if (worldY < Y_MIN || worldY > Y_MAX) {
                        veininessGrid[i] = 0f;
                        veinAGrid[i]     = 0f;
                        veinBGrid[i]     = 0f;
                    } else {
                        veininessGrid[i] = (float) noise.computeOreVeininess(worldX, worldY, worldZ);
                        veinAGrid[i]     = (float) noise.computeOreVeinA(worldX, worldY, worldZ);
                        veinBGrid[i]     = (float) noise.computeOreVeinB(worldX, worldY, worldZ);
                    }
                }
            }
        }
    }

    /** Интерполированный veininess в локальных координатах чанка. */
    public float getVeininess(int localX, int localZ, int y) {
        if (y < Y_MIN || y > Y_MAX) return 0f;
        return interpolate(veininessGrid, localX, localZ, y);
    }

    /** Интерполированный vein A в локальных координатах чанка. */
    public float getVeinA(int localX, int localZ, int y) {
        if (y < Y_MIN || y > Y_MAX) return 0f;
        return interpolate(veinAGrid, localX, localZ, y);
    }

    /** Интерполированный vein B в локальных координатах чанка. */
    public float getVeinB(int localX, int localZ, int y) {
        if (y < Y_MIN || y > Y_MAX) return 0f;
        return interpolate(veinBGrid, localX, localZ, y);
    }

    /** Trilinear на 1D-гриде. 8 углов через base + страйды (sX=GZ*gridY, sZ=gridY, 1). Бит-в-бит как 3D. */
    private float interpolate(float[] grid, int localX, int localZ, int y) {
        float gxF = (float) localX / STEP_XZ;
        float gzF = (float) localZ / STEP_XZ;
        float gyF = (float) (y - Y_MIN) / STEP_Y;

        int gx0 = Math.min((int) gxF, GX - 2);
        int gz0 = Math.min((int) gzF, GZ - 2);
        int gy0 = Math.min((int) gyF, gridY - 2);
        if (gy0 < 0) gy0 = 0;

        float fx = gxF - gx0;
        float fz = gzF - gz0;
        float fy = gyF - gy0;

        int sX = GZ * gridY;                 // страйд по gx
        int sZ = gridY;                      // страйд по gz
        int base = gx0 * sX + gz0 * sZ + gy0;

        float c000 = grid[base];
        float c100 = grid[base + sX];
        float c010 = grid[base + sZ];
        float c110 = grid[base + sX + sZ];
        float c001 = grid[base + 1];
        float c101 = grid[base + sX + 1];
        float c011 = grid[base + sZ + 1];
        float c111 = grid[base + sX + sZ + 1];

        float c00 = c000 + (c100 - c000) * fx;
        float c10 = c010 + (c110 - c010) * fx;
        float c01 = c001 + (c101 - c001) * fx;
        float c11 = c011 + (c111 - c011) * fx;

        float c0 = c00 + (c10 - c00) * fz;
        float c1 = c01 + (c11 - c01) * fz;

        return c0 + (c1 - c0) * fy;
    }
}
