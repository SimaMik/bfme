package net.sima.bfme.worldgen.noise;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;

/**
 * ГЛАВНЫЙ ГЕНЕРАТОР ШУМОВ МИРА
 *
 * Medium и Large cheese работают на ванильном ImprovedNoise (Perlin).
 * Pillars — ванильная 1:1 формула на OpenSimplex2S, MAX-композиция в CaveInterpolator.
 * Остальные noise (carvers, terrain) на OpenSimplex2S.
 */
public class WorldNoiseGenerator {

    private static WorldNoiseGenerator instance;

    private long worldSeed;
    private boolean initialized = false;

    private WorldNoiseGenerator() {}

    public static synchronized WorldNoiseGenerator getInstance() {
        if (instance == null) {
            instance = new WorldNoiseGenerator();
        }
        return instance;
    }

    // === CARVER TOGGLES ===
    public static boolean CARVER_SPAG2D_ENABLED = true;
    public static boolean CARVER_SPAG3D_ENABLED = true;
    public static boolean CARVER_NOODLE_ENABLED = true;
    public static boolean CARVER_ENTRANCE_ENABLED = true;

    // === CHEESE/PILLAR TOGGLES ===
    public static boolean CHEESE_MEDIUM_ENABLED = true;
    public static boolean CHEESE_LARGE_ENABLED = true;
    // Noise-based pillars отключены — заменены feature-based через CavePillarFeature.
    // LargeDripstone-style алгоритм даёт точную форму без aliasing, лучше perf.
    public static boolean PILLARS_ENABLED = false;

    // === CAVE TUNING (Medium — ванильные значения) ===
    public static float CAVE_OFFSET = 0.35f;
    public static float CAVE_LAYER_POWER = 4.0f;
    public static float CAVE_LAYER_Y_SCALE = 8.0f;
    public static float CAVE_Y_COMPRESSION = 0.67f;

    // === LARGE CAVE TUNING ===
    // Layer_power=1.5 (среднее gating, чаще регионы по XZ), offset=0.33 (средний размер),
    // округлая форма (Y_COMPRESSION=1.0, XZ_STRETCH=0.90 — почти не растянуто).
    public static float CAVE_OFFSET_LARGE        = 0.33f;
    public static float CAVE_LAYER_POWER_LARGE   = 1.1f;
    public static float CAVE_LAYER_Y_SCALE_LARGE = 1.75f;
    public static float CAVE_Y_COMPRESSION_LARGE = 1.0f;
    public static float CAVE_LARGE_XZ_STRETCH    = 0.80f;

    // === SPAGHETTI 2D ===
    public static float CAVE_SPAGHETTI_THRESHOLD = 0.055f;
    public static float CAVE_SPAGHETTI_RARENESS = -0.03f;
    public static float CAVE_SPAGHETTI_Y_RANGE = 24f;
    public static float CAVE_SPAGHETTI_THICK_BOOST = 0.08f;

    // === SPAGHETTI 3D (vanilla NormalNoise constants) ===

    // === NOODLE (Y range адаптирован под BFME мир) ===
    // Ваниль: -60 до 320 (на 4 блока выше bedrock=-64, до world top=320).
    // BFME: bedrock=-190 → MIN=-186, world top=430 → MAX=430.
    public static int CAVE_NOODLE_Y_MIN = -186;
    public static int CAVE_NOODLE_Y_MAX = 430;

    /** Y-range за пределами которого spag2D yPenalty всегда saturates → result = 1.0 (не cave).
     *  Полоса определяется yClampedGradient: yGradient=0 при y≈-53, активна на 150 блоков вокруг. */
    public static final int SPAG2D_ACTIVE_Y_MIN = -140;
    public static final int SPAG2D_ACTIVE_Y_MAX = 30;

    // === ENTRANCES ===
    public static float CAVE_ENTRANCE_STRENGTH = 1.0f;
    public static float CAVE_ENTRANCE_DEPTH = 50f;

    public static float CAVE_FADE_DEPTH = 15f;
    public static float CAVE_FADE_STRENGTH = 0.3f;

    // === PILLARS (ванильная 1:1 формула) ===
    /** Gate — ниже этого значения pillar не доминирует. Ванильное значение. */
    // Gate 0.04 — отсекает marginal pillars (тонкие borderline), но не отрезает
    // edges нормальных pillars (толщина теперь через mid 0.7 + halfRange 0.75).
    // Меньше количество всего, толщина каждого сохраняется.
    public static float CAVE_PILLAR_GATE = 0.04f;

    public static float CAVE_BEDROCK_FADE = 15f;
    public static float CAVE_BEDROCK_STRENGTH = 0.25f;


    // ============================================================
    // TERRAIN NOISES
    // ============================================================

    private OctaveNoise continentNoise;
    private OctaveNoise mountainMaskNoise;
    private OctaveNoise valleyNoise;

    private OctaveNoise[] simplexNoises;
    private OctaveNoise[] ridgeNoises;
    private OctaveNoise[] billowNoises;
    private OctaveNoise[] cellularNoises;
    private OctaveNoise detailNoiseHF;

    private OctaveNoise warpXNoise;
    private OctaveNoise warpZNoise;
    private OctaveNoise warpXNoise2;
    private OctaveNoise warpZNoise2;

    private OctaveNoise cliffNoise3D;
    private OctaveNoise overhangNoise3D;
    private OctaveNoise creviceNoise3D;

    // ============================================================
    // CAVE SEEDS
    // ============================================================

    private long caveLayerSeed;
    private long[] cheeseOctaveSeeds;
    private long[] cheeseOctaveSeeds2;

    private long caveLayerLargeSeed;
    private long[] cheeseLargeSeeds;
    private long[] cheeseLargeSeeds2;

    // Pillars — ванильный NormalNoise (2 PerlinNoise inst, по 2 octaves для PILLAR, по 1 для RARENESS/THICKNESS)
    private long[] pillarSeeds1;          // PILLAR PerlinNoise 1, 2 октавы
    private long[] pillarSeeds2;          // PILLAR PerlinNoise 2, 2 октавы
    private long pillarRarenessSeed1;     // PILLAR_RARENESS PerlinNoise 1, 1 октава
    private long pillarRarenessSeed2;     // PILLAR_RARENESS PerlinNoise 2, 1 октава
    private long pillarThicknessSeed1;    // PILLAR_THICKNESS PerlinNoise 1, 1 октава
    private long pillarThicknessSeed2;    // PILLAR_THICKNESS PerlinNoise 2, 1 октава

    private long spag2d1Seed;
    private long spag2d2Seed;
    private long spag2dRarenessSeed;
    private long spag2dElevationSeed;
    private long spag2dThicknessSeed;
    // NormalNoise second PerlinNoise seeds (для double Perlin как в ванилле)
    private long spag2d1Seed2;
    private long spag2d2Seed2;
    private long spag2dRarenessSeed2;
    private long spag2dElevationSeed2;
    private long spag2dThicknessSeed2;
    // Spaghetti roughness seeds (NormalNoise pairs)
    private long spagRoughnessSeed1;
    private long spagRoughnessSeed2;
    private long spagRoughnessModSeed1;
    private long spagRoughnessModSeed2;

    // Spaghetti 3D seeds (NormalNoise pairs — two PerlinNoise per noise source)
    private long spag3d1Seed1;
    private long spag3d1Seed2;
    private long spag3d2Seed1;
    private long spag3d2Seed2;
    private long spag3dRaritySeed1;
    private long spag3dRaritySeed2;
    private long spag3dThicknessSeed1;
    private long spag3dThicknessSeed2;

    // Noodle seeds (NormalNoise pairs — two PerlinNoise per noise source)
    private long noodleSelectorSeed1;
    private long noodleSelectorSeed2;
    private long noodleThicknessSeed1;
    private long noodleThicknessSeed2;
    private long noodleRidgeASeed1;
    private long noodleRidgeASeed2;
    private long noodleRidgeBSeed1;
    private long noodleRidgeBSeed2;

    // Cave entrance seeds — NormalNoise 3 октавы × 2 PerlinNoise = 6 seeds
    private long[] caveEntranceSeeds1; // первый PerlinNoise (3 октавы)
    private long[] caveEntranceSeeds2; // второй PerlinNoise (3 октавы)

    // ============================================================
    // AQUIFER NOISES — 4 шума на основе OctaveNoise (1 октава каждый)
    // Ванильные параметры:
    //   barrier:      firstOctave=-3 → scale 8   (тонкие стенки между аквиферами)
    //   floodedness:  firstOctave=-7 → scale 128 (большие зоны затопления)
    //   spread:       firstOctave=-5 → scale 32  (вариация уровня воды)
    //   lava:         firstOctave=-1 → scale 2   (точечные пятна лавы)
    // ============================================================
    // Aquifer NormalNoise seeds (2 PerlinNoise per noise = 8 seeds total).
    // Каждый шум = (perlin1 + perlin2 with INPUT_FACTOR) * valueFactor — как ваниль.
    private long aquiferBarrierSeed1, aquiferBarrierSeed2;
    private long aquiferFloodednessSeed1, aquiferFloodednessSeed2;
    private long aquiferSpreadSeed1, aquiferSpreadSeed2;
    private long aquiferLavaSeed1, aquiferLavaSeed2;

    // ============================================================
    // ORE VEIN NOISES — ванильный NormalNoise (2 PerlinNoise + valueFactor).
    // Параметры 1:1 ваниль:
    //   ore_veininess: firstOctave=-8, amps=[1]          → scale 256, 1 oct
    //   ore_vein_a/b:  firstOctave=-7, amps=[1,1,1,1]    → scale 128, 4 oct
    //   ore_gap:       firstOctave=-5, amps=[1]          → scale 32, 1 oct
    // ============================================================
    // ore_veininess (1 octave) — 2 PerlinNoise
    private long oreVeininessSeed1, oreVeininessSeed2;
    // ore_vein_a (4 octaves) — 2 PerlinNoise × 4 octaves = 8 seeds
    private long[] oreVeinASeeds1, oreVeinASeeds2;
    // ore_vein_b (4 octaves)
    private long[] oreVeinBSeeds1, oreVeinBSeeds2;
    // ore_gap (1 octave)
    private long oreGapSeed1, oreGapSeed2;

    // ============================================================
    // CAVE CONSTANTS
    // ============================================================

    public static final int CAVE_MIN_Y = -190;
    public static final int CAVE_MAX_Y = 430;

    private static final double CHEESE_VALUE_FACTOR_MEDIUM = 1.481;
    private static final double CHEESE_VALUE_FACTOR_LARGE = 1.481;
    private static final double VANILLA_INPUT_FACTOR = 1.0181268882175227;

    /** Ванильные scale параметры для pillars (1:1 как в Mojang NoiseRouterData.pillars()).
     *
     *  PILLAR (тело столба):
     *    JSON: firstOctave=-7, amplitudes=[1, 1] → base freq = 1/128.
     *    NoiseRouterData: noise(PILLAR, xz_scale=25, y_scale=0.3).
     *    Эффективные частоты:
     *      sampleX = x * 25 / 128 = x * 0.1953  (period ~5 блоков по XZ)
     *      sampleY = y * 0.3 / 128 = y * 0.00234 (period ~430 блоков по Y)
     *    → тонкие вертикальные столбы.
     *
     *  PILLAR_RARENESS / PILLAR_THICKNESS:
     *    JSON: firstOctave=-8, amplitudes=[1] → base freq = 1/256.
     *    NoiseRouterData: mappedNoise() без scale → xz=1, y=1, изотропно.
     *    → period ~256 блоков, плавная регионализация. */
    // === PILLARS — NormalNoise константы ===
    // PILLAR: noise(PILLAR, xz=25, y=0.01) — Y почти константа (anti-aliasing для cheeseGrid).
    // Натуральные утолщения у потолка/пола получаются через MAX с cheese density в
    // computeCaveDensity (cheese variability у потолка → pillar "впаивается" в стену).
    private static final double PILLAR_XZ_SCALE = 25.0;
    private static final double PILLAR_Y_SCALE = 0.01;
    // PILLAR PerlinNoise: firstOctave=-7, amplitudes=[1, 1] → 2 октавы
    private static final double PILLAR_BASE_FREQ = 1.0 / 128.0;          // 2^(-7)
    private static final double PILLAR_LOWEST_VF = 2.0 / 3.0;            // 2^(N-1) / (2^N - 1) = 2/3
    // PILLAR NormalNoise valueFactor: (1/6) / expectedDeviation(N-1) where N=2
    // expectedDeviation(1) = 0.1 * (1 + 1/2) = 0.15 → vf = (1/6) / 0.15 = 10/9
    private static final double PILLAR_VF = 10.0 / 9.0;
    // PILLAR_RARENESS / PILLAR_THICKNESS: firstOctave=-8, xz=1/256, Y супер-медленный.
    // Wavelength XZ = 256 как ваниль (сохраняет ту же топологию zones).
    private static final double PILLAR_RT_FREQ_XZ = 1.0 / 256.0;
    private static final double PILLAR_RT_FREQ_Y  = 1.0 / 16384.0;
    // valueFactor: (1/6) / expectedDeviation(0) = (1/6) / 0.2 = 5/6
    private static final double PILLAR_RT_VF = 5.0 / 6.0;

    // ============================================================
    // INITIALIZATION
    // ============================================================

    public void initialize(long seed) {
        if (initialized && this.worldSeed == seed) return;

        this.worldSeed = seed;
        RandomSource random = new XoroshiroRandomSource(seed);
        System.out.println("[WorldNoiseGenerator] Initializing, seed: " + seed);

        // === TERRAIN ===
        continentNoise = new OctaveNoise(random.nextLong(), 3, 4000.0, 0.5, 2.0);
        mountainMaskNoise = new OctaveNoise(random.nextLong(), 3, 2500.0, 0.5, 2.0);
        valleyNoise = new OctaveNoise(random.nextLong(), 3, 2000.0, 0.5, 2.0);

        simplexNoises = new OctaveNoise[] {
                new OctaveNoise(random.nextLong(), 5, 500.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 4, 200.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 3, 80.0, 0.5, 2.0)
        };

        ridgeNoises = new OctaveNoise[] {
                new OctaveNoise(random.nextLong(), 4, 900.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 7, 380.0, 0.5, 2.0),   // 3 → 7
                new OctaveNoise(random.nextLong(), 2, 160.0, 0.5, 2.0)
        };

        billowNoises = new OctaveNoise[] {
                new OctaveNoise(random.nextLong(), 4, 700.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 3, 280.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 2, 110.0, 0.5, 2.0)
        };

        cellularNoises = new OctaveNoise[] {
                new OctaveNoise(random.nextLong(), 3, 350.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 2, 150.0, 0.5, 2.0),
                new OctaveNoise(random.nextLong(), 2, 65.0, 0.5, 2.0)
        };

        detailNoiseHF = new OctaveNoise(random.nextLong(), 4, 60.0, 0.5, 2.0);

        warpXNoise = new OctaveNoise(random.nextLong(), 3, 300.0, 0.5, 2.0);
        warpZNoise = new OctaveNoise(random.nextLong(), 3, 300.0, 0.5, 2.0);
        warpXNoise2 = new OctaveNoise(random.nextLong(), 3, 60.0, 0.5, 3.0);
        warpZNoise2 = new OctaveNoise(random.nextLong(), 3, 60.0, 0.5, 3.0);

        // === CAVES ===
        java.util.Random cheeseRng = new java.util.Random(seed + 80000L);

        caveLayerSeed = cheeseRng.nextLong();

        cheeseOctaveSeeds = new long[9];
        cheeseOctaveSeeds2 = new long[9];
        for (int i = 0; i < 9; i++) cheeseOctaveSeeds[i] = cheeseRng.nextLong();
        for (int i = 0; i < 9; i++) cheeseOctaveSeeds2[i] = cheeseRng.nextLong();

        caveLayerLargeSeed = cheeseRng.nextLong();
        cheeseLargeSeeds  = new long[9];
        cheeseLargeSeeds2 = new long[9];
        for (int i = 0; i < 9; i++) cheeseLargeSeeds[i]  = cheeseRng.nextLong();
        for (int i = 0; i < 9; i++) cheeseLargeSeeds2[i] = cheeseRng.nextLong();

        // Pillars — NormalNoise: PILLAR (2 octaves × 2 PerlinNoise = 4 seeds),
        // RARENESS (1 oct × 2 = 2 seeds), THICKNESS (1 oct × 2 = 2 seeds)
        pillarSeeds1 = new long[]{seed + 80050L, seed + 80051L};
        pillarSeeds2 = new long[]{seed + 80052L, seed + 80053L};
        pillarRarenessSeed1 = seed + 80054L;
        pillarRarenessSeed2 = seed + 80055L;
        pillarThicknessSeed1 = seed + 80056L;
        pillarThicknessSeed2 = seed + 80057L;

        spag2d1Seed = seed + 80010L;
        spag2d2Seed = seed + 80011L;
        spag2dRarenessSeed = seed + 80015L;
        spag2dElevationSeed = seed + 80016L;
        spag2dThicknessSeed = seed + 80017L;
        spag2d1Seed2 = seed + 80018L;
        spag2d2Seed2 = seed + 80019L;
        spag2dRarenessSeed2 = seed + 80020L;
        spag2dElevationSeed2 = seed + 80021L;
        spag2dThicknessSeed2 = seed + 80022L;
        spagRoughnessSeed1 = seed + 80023L;
        spagRoughnessSeed2 = seed + 80024L;
        spagRoughnessModSeed1 = seed + 80025L;
        spagRoughnessModSeed2 = seed + 80026L;

        spag3d1Seed1 = seed + 80030L;
        spag3d1Seed2 = seed + 80031L;
        spag3d2Seed1 = seed + 80032L;
        spag3d2Seed2 = seed + 80033L;
        spag3dRaritySeed1 = seed + 80034L;
        spag3dRaritySeed2 = seed + 80035L;
        spag3dThicknessSeed1 = seed + 80036L;
        spag3dThicknessSeed2 = seed + 80037L;

        noodleSelectorSeed1 = seed + 80040L;
        noodleSelectorSeed2 = seed + 80041L;
        noodleThicknessSeed1 = seed + 80042L;
        noodleThicknessSeed2 = seed + 80043L;
        noodleRidgeASeed1 = seed + 80044L;
        noodleRidgeASeed2 = seed + 80045L;
        noodleRidgeBSeed1 = seed + 80046L;
        noodleRidgeBSeed2 = seed + 80047L;

        // Cave entrance: 3 октавы × 2 PerlinNoise = 6 seeds
        caveEntranceSeeds1 = new long[3];
        caveEntranceSeeds2 = new long[3];
        for (int i = 0; i < 3; i++) {
            caveEntranceSeeds1[i] = seed + 80060L + i;
            caveEntranceSeeds2[i] = seed + 80070L + i;
        }

        cliffNoise3D = new OctaveNoise(random.nextLong(), 2, 150.0, 0.5, 2.0);
        overhangNoise3D = new OctaveNoise(random.nextLong(), 2, 80.0, 0.5, 2.0);
        creviceNoise3D = new OctaveNoise(random.nextLong(), 2, 60.0, 0.5, 2.0);

        // Aquifer noises — ванильные scale (1 октава каждый)
        // Aquifer NormalNoise seeds (2 PerlinNoise per noise) — 1:1 ваниль pattern
        aquiferBarrierSeed1     = seed + 90001L;
        aquiferBarrierSeed2     = seed + 90011L;
        aquiferFloodednessSeed1 = seed + 90002L;
        aquiferFloodednessSeed2 = seed + 90012L;
        aquiferSpreadSeed1      = seed + 90003L;
        aquiferSpreadSeed2      = seed + 90013L;
        aquiferLavaSeed1        = seed + 90004L;
        aquiferLavaSeed2        = seed + 90014L;

        // Ore vein noises — ванильный NormalNoise: 2 PerlinNoise + valueFactor.
        // Каждый NormalNoise = (perlin1 + perlin2) * valueFactor
        oreVeininessSeed1 = seed + 91001L;
        oreVeininessSeed2 = seed + 91002L;
        oreGapSeed1       = seed + 91003L;
        oreGapSeed2       = seed + 91004L;
        oreVeinASeeds1 = new long[4];
        oreVeinASeeds2 = new long[4];
        oreVeinBSeeds1 = new long[4];
        oreVeinBSeeds2 = new long[4];
        for (int i = 0; i < 4; i++) {
            oreVeinASeeds1[i] = seed + 91100L + i;
            oreVeinASeeds2[i] = seed + 91110L + i;
            oreVeinBSeeds1[i] = seed + 91200L + i;
            oreVeinBSeeds2[i] = seed + 91210L + i;
        }

        initialized = true;
    }

    private void checkInit() {
        if (!initialized) throw new IllegalStateException("WorldNoiseGenerator не инициализирован!");
    }

    // ============================================================
    // TERRAIN GETTERS (не тронуты)
    // ============================================================

    public double getContinent(double x, double z) { checkInit(); return continentNoise.sample2D(x, z); }
    public double getMountainMask(double x, double z) { checkInit(); return mountainMaskNoise.sample2D(x, z); }
    public double getValley(double x, double z) { checkInit(); return valleyNoise.sample2D(x, z); }

    public double getSimplex(double x, double z) { checkInit(); return simplexNoises[0].sample2D(x, z); }
    public double getRidge(double x, double z) { checkInit(); return ridgeNoises[0].sampleRidged2D(x, z); }
    public double getBillow(double x, double z) { checkInit(); return billowNoises[0].sampleBillow2D(x, z); }
    public double getCellular(double x, double z) { checkInit(); return cellularNoises[0].sampleCellular2D(x, z); }

    public double getWarpX(int x, int z) { checkInit(); return warpXNoise.sample2D(x, z); }
    public double getWarpZ(int x, int z) { checkInit(); return warpZNoise.sample2D(x, z); }
    public double getDetailHF(double x, double z) { checkInit(); return detailNoiseHF.sample2D(x, z); }

    public double getMultiScaleTerrain(double x, double z, float[] weights,
                                       float warpStrength, float lacunarity, float persistence, float baseScale) {
        return getMultiScaleTerrain(x, z, weights, 0, warpStrength, lacunarity, persistence, baseScale);
    }

    public double getMultiScaleTerrain(double x, double z, float[] weights, int weightsOffset,
                                       float warpStrength, float lacunarity, float persistence, float baseScale) {
        checkInit();

        double wx = x, wz = z;
        if (warpStrength > 0) {
            wx += warpXNoise.sample2D(x, z) * warpStrength * 150.0;
            wz += warpZNoise.sample2D(x, z) * warpStrength * 150.0;
            wx += warpXNoise2.sample2D(x, z) * warpStrength * 30.0;
            wz += warpZNoise2.sample2D(x, z) * warpStrength * 30.0;
        }

        double sx = wx * baseScale;
        double sz = wz * baseScale;
        boolean custom = Math.abs(persistence - 0.5) > 0.001 || Math.abs(lacunarity - 2.0) > 0.001;

        double total = 0;

        for (int s = 0; s < 3; s++) {
            float w = weights[weightsOffset + s];
            if (w > 0) {
                double v = custom ? simplexNoises[s].sample2D(sx, sz, persistence, lacunarity)
                        : simplexNoises[s].sample2D(sx, sz);
                total += v * w;
            }
        }
        for (int s = 0; s < 3; s++) {
            float w = weights[weightsOffset + 3 + s];
            if (w > 0) {
                double v = custom ? ridgeNoises[s].sampleRidged2D(sx, sz, persistence, lacunarity)
                        : ridgeNoises[s].sampleRidged2D(sx, sz);
                v -= 0.33;
                total += v * w;
            }
        }
        for (int s = 0; s < 3; s++) {
            float w = weights[weightsOffset + 6 + s];
            if (w > 0) {
                double v = custom ? billowNoises[s].sampleBillow2D(sx, sz, persistence, lacunarity)
                        : billowNoises[s].sampleBillow2D(sx, sz);
                v -= 0.5;
                total += v * w;
            }
        }
        for (int s = 0; s < 3; s++) {
            float w = weights[weightsOffset + 9 + s];
            if (w > 0) {
                double v = custom ? cellularNoises[s].sampleCellular2D(sx, sz, persistence, lacunarity)
                        : cellularNoises[s].sampleCellular2D(sx, sz);
                v -= 0.4;
                total += v * w;
            }
        }

        return total;
    }

    public double getDetailNoise(double x, double z, float strength) {
        checkInit();
        if (strength <= 0) return 0;
        return detailNoiseHF.sample2D(x, z) * strength;
    }

    public static double applyCurveAndBias(double value, float curve, float bias) {
        double biased = value + bias;
        if (curve != 1.0f && biased != 0) {
            double sign = Math.signum(biased);
            biased = sign * Math.pow(Math.abs(biased), curve);
        }
        return biased;
    }

    // ============================================================
    // CAVE SYSTEM — MEDIUM CHEESE
    // ============================================================

    private double sampleCaveLayer(int x, int y, int z) {
        double freq = 1.0 / 256.0;
        return ImprovedNoise.noise3_ImproveXY(caveLayerSeed,
                x * freq, z * freq, y * freq * CAVE_LAYER_Y_SCALE);
    }

    private double sampleCheeseNoise(double x, double y, double z) {
        // BFME ребаланс: октава 3 (период 32) усилена 1.0 → 3.0 — компенсирует
        // больший Y-объём пещер (260 vs ванильные 96), где медленные октавы доминируют.
        double[] amplitudes = {0.5, 1.0, 2.0, 3.0, 2.0, 1.0, 0.0, 2.0, 0.0};
        int numOctaves = 9;
        double cy = y * CAVE_Y_COMPRESSION;
        double firstTotal = 0, secondTotal = 0;
        double d1 = Math.pow(2, -8);
        double d2 = Math.pow(2, numOctaves - 1) / (Math.pow(2, numOctaves) - 1.0);
        for (int i = 0; i < numOctaves; i++) {
            if (amplitudes[i] != 0) {
                firstTotal += ImprovedNoise.noise3_ImproveXY(cheeseOctaveSeeds[i],
                        x * d1, z * d1, cy * d1) * amplitudes[i] * d2;
                secondTotal += ImprovedNoise.noise3_ImproveXY(cheeseOctaveSeeds2[i],
                        x * VANILLA_INPUT_FACTOR * d1,
                        z * VANILLA_INPUT_FACTOR * d1,
                        cy * VANILLA_INPUT_FACTOR * d1) * amplitudes[i] * d2;
            }
            d1 *= 2.0;
            d2 /= 2.0;
        }
        return (firstTotal + secondTotal) * CHEESE_VALUE_FACTOR_MEDIUM;
    }

    // ============================================================
    // CAVE SYSTEM — LARGE CHEESE
    // ============================================================

    private double sampleCaveLayerLarge(int x, int y, int z) {
        double freq = 1.0 / 256.0;
        return ImprovedNoise.noise3_ImproveXY(caveLayerLargeSeed,
                x * freq, z * freq, y * freq * CAVE_LAYER_Y_SCALE_LARGE);
    }

    private double sampleCheeseLarge(double x, double y, double z) {
        double[] amplitudes = {0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0};
        int n = 9;
        double cy = y * CAVE_Y_COMPRESSION_LARGE;
        double total = 0;
        double d1 = Math.pow(2, -9);
        double d2 = Math.pow(2, n - 1) / (Math.pow(2, n) - 1.0);
        double xzStretch = CAVE_LARGE_XZ_STRETCH;
        for (int i = 0; i < n; i++) {
            if (amplitudes[i] != 0) {
                total += ImprovedNoise.noise3_ImproveXY(cheeseLargeSeeds[i],
                        x * d1 * xzStretch, z * d1 * xzStretch, cy * d1) * amplitudes[i] * d2;
            }
            d1 *= 2.0;
            d2 /= 2.0;
        }
        return total * CHEESE_VALUE_FACTOR_LARGE;
    }

    private float computeLargeDensity(int x, int y, int z, float largeOffset) {
        double caveLayer = sampleCaveLayerLarge(x, y, z);
        double cheese = sampleCheeseLarge(x, y, z);
        double cheeseClamped = Math.max(-1.0, Math.min(1.0, largeOffset + cheese));

        // Layer ослабляется где cheese сильно хочет cave (slopedBoost из medium).
        double layerWeight = cheeseClamped < 0 ? 1.0 + cheeseClamped * 0.45 : 1.0;
        double layerGate = CAVE_LAYER_POWER_LARGE * caveLayer * caveLayer * layerWeight;

        return (float) (layerGate + cheeseClamped);
    }

    public float computeCaveDensity(int x, int y, int z, int surfaceHeight,
                                     float mediumOffset, float largeOffset,
                                     float fadeDepth, float fadeStrength) {
        float densityMedium;
        if (CHEESE_MEDIUM_ENABLED) {
            double caveLayer = sampleCaveLayer(x, y, z);
            double cheese = sampleCheeseNoise((double) x, (double) y, (double) z);
            double cheeseClamped = Math.max(-1.0, Math.min(1.0, mediumOffset + cheese));

// Layer ослабляется в местах где cheese хочет быть пещерой (аналог ванильного slopedBoost)
            double layerWeight = cheeseClamped < 0 ? 1.0 + cheeseClamped * 0.45 : 1.0;
            double layerGate = CAVE_LAYER_POWER * caveLayer * caveLayer * layerWeight;

            densityMedium = (float) (layerGate + cheeseClamped);
        } else {
            densityMedium = 10f;
        }

        float densityLarge = CHEESE_LARGE_ENABLED ? computeLargeDensity(x, y, z, largeOffset) : 10f;

        float density;
        if (CHEESE_MEDIUM_ENABLED && CHEESE_LARGE_ENABLED) {
            density = smoothMin(densityMedium, densityLarge, 0.2f);
        } else if (CHEESE_MEDIUM_ENABLED) {
            density = densityMedium;
        } else if (CHEESE_LARGE_ENABLED) {
            density = densityLarge;
        } else {
            density = 10f;
        }

        // Surface fade — селективная защита: блокирует только слабые caves (мелкие дыры),
        // но пропускает сильные (cheese density < BREAKTHROUGH_THRESHOLD).
        // Это даёт ваниль-like поведение: огромные прорези редко, мелких дыр нет.
        int depth = surfaceHeight - y;
        if (fadeDepth > 0 && depth < fadeDepth) {
            float fadeFactor = 1f - depth / fadeDepth;  // 1 на surface, 0 на границе
            float fadeAdd = fadeStrength * fadeFactor;
            // Threshold: ниже которого cheese "пробивает" защиту.
            // На surface самый строгий, глубже мягче. -0.6 base, до -0.3 на границе.
            float breakthroughThreshold = -0.6f + 0.3f * (1f - fadeFactor);
            if (density > breakthroughThreshold) {
                // Слабая cave → применяем защиту полностью
                density += fadeAdd;
            } else {
                // Сильная cave → защита частично (не блокирует совсем, но смягчает резкие края)
                density += fadeAdd * 0.3f;
            }
        }

        float bedrockFade = smoothstep(CAVE_MIN_Y + CAVE_BEDROCK_FADE, CAVE_MIN_Y, y);
        density += bedrockFade * CAVE_BEDROCK_STRENGTH;

        // Pillars MAX-композиция с cheese — для натуральных утолщений у потолка/пола.
        // В центре больших cheese комнат pillar сужается (cheese cave съедает edges),
        // но базовая толщина pillars увеличена (низкий gate + большой halfRange) чтобы
        // сужение не доходило до 1-блочного palki.
        // Отдельно pillar сэмплируется в pillarGrid для защиты от carvers.
        if (PILLARS_ENABLED) {
            float pillar = computePillarContribution(x, y, z);
            if (pillar > CAVE_PILLAR_GATE) {
                density = Math.max(density, pillar);
            }
        }

        return density;
    }

    // ============================================================
    // PILLARS — ванильная 1:1 формула (Mojang NoiseRouterData.pillars())
    // ============================================================

    /**
     * Точная ванильная 1:1 формула Mojang NoiseRouterData.pillars():
     *
     *   pillar     = NormalNoise(PILLAR, xz=25, y=0.3) — 2 октавы amps=[1,1], firstOctave=-7
     *   rareness   = mappedNoise(PILLAR_RARENESS, 0, -2) = -1 - normalNoiseRaw
     *   thickness  = mappedNoise(PILLAR_THICKNESS, 0, 1.1) = 0.55 + 0.55 * normalNoiseRaw
     *   result     = (2 * pillar + rareness) * thickness³
     *
     * Все 3 шума — настоящий NormalNoise (2 PerlinNoise + INPUT_FACTOR + valueFactor).
     * Gate (>0.03) и MAX-композиция применяются в computeCaveDensity.
     */
    public float computePillarContribution(int x, int y, int z) {
        if (!PILLARS_ENABLED) return 0f;

        // === PILLAR NormalNoise (2 октавы, xz=25, y=0.3) ===
        double bx = x * PILLAR_XZ_SCALE;
        double by = y * PILLAR_Y_SCALE;
        double bz = z * PILLAR_XZ_SCALE;

        double pillarFirst = 0, pillarSecond = 0;
        double d1 = PILLAR_BASE_FREQ;
        double d2 = PILLAR_LOWEST_VF;
        for (int i = 0; i < 2; i++) {
            pillarFirst += ImprovedNoise.noise3(pillarSeeds1[i],
                    bx * d1, by * d1, bz * d1) * d2;
            pillarSecond += ImprovedNoise.noise3(pillarSeeds2[i],
                    bx * d1 * VANILLA_INPUT_FACTOR,
                    by * d1 * VANILLA_INPUT_FACTOR,
                    bz * d1 * VANILLA_INPUT_FACTOR) * d2;
            d1 *= 2.0;
            d2 /= 2.0;
        }
        double pillar = (pillarFirst + pillarSecond) * PILLAR_VF;

        // === PILLAR_RARENESS NormalNoise (1 октава, BFME: XZ ванильный, Y супер-медленный) ===
        // mapped (0, -2): rareness = -1 - normalNoiseRaw
        double rX = x * PILLAR_RT_FREQ_XZ;
        double rY = y * PILLAR_RT_FREQ_Y;
        double rZ = z * PILLAR_RT_FREQ_XZ;
        double rareFirst = ImprovedNoise.noise3(pillarRarenessSeed1, rX, rY, rZ);
        double rareSecond = ImprovedNoise.noise3(pillarRarenessSeed2,
                rX * VANILLA_INPUT_FACTOR, rY * VANILLA_INPUT_FACTOR, rZ * VANILLA_INPUT_FACTOR);
        double rarenessRaw = (rareFirst + rareSecond) * PILLAR_RT_VF;
        // mid -1.30 вместо ваниль -1.0 — pillars значительно реже (~×1.4 расстояние).
        // Не меняет толщину активных pillar (это thickness + gate).
        double rareness = -1.30 - rarenessRaw;

        // === PILLAR_THICKNESS NormalNoise (1 октава) ===
        // mappedNoise(0, 1.1) ваниль: mid 0.55, halfRange 0.55, cubed [0, 1.33].
        // BFME: mid 0.7 (vs ваниль 0.55) — pillars толще базово (cubed mid 0.343 vs 0.166).
        // HalfRange 0.7 → range [0, 1.4], cubed [0, 2.74]. В редких peaks массивные pillars.
        double tX = x * PILLAR_RT_FREQ_XZ;
        double tY = y * PILLAR_RT_FREQ_Y;
        double tZ = z * PILLAR_RT_FREQ_XZ;
        double thickFirst = ImprovedNoise.noise3(pillarThicknessSeed1, tX, tY, tZ);
        double thickSecond = ImprovedNoise.noise3(pillarThicknessSeed2,
                tX * VANILLA_INPUT_FACTOR, tY * VANILLA_INPUT_FACTOR, tZ * VANILLA_INPUT_FACTOR);
        double thicknessRaw = (thickFirst + thickSecond) * PILLAR_RT_VF;
        double thickness = 0.7 + 0.75 * thicknessRaw;
        double thicknessCubed = thickness * thickness * thickness;

        // === Final: (2 * pillar + rareness) * thickness³ ===
        double result = (2.0 * pillar + rareness) * thicknessCubed;

        return (float) result;
    }

    // ============================================================
    // CARVERS — SPAGHETTI 2D (OpenSimplex)
    // ============================================================

    // --- Spaghetti 2D: ванильные константы NormalNoise ---

    // NormalNoise INPUT_FACTOR (уже есть VANILLA_INPUT_FACTOR выше, используем его)

    // Modulator: firstOctave=-11, amps=[1]
    private static final double SPAG2D_MOD_FREQ = 1.0 / 2048.0;        // 2^(-11)
    // NormalNoise valueFactor = (1/6) / expectedDeviation(0) = 0.16667 / 0.2
    private static final double SPAG2D_MOD_VF = 0.8333333333333334;

    // SPAGHETTI_2D: firstOctave=-7, amps=[1.0] (1 октава, ваниль JSON spaghetti_2d.json)
    private static final double SPAG2D_FREQ = 1.0 / 128.0;             // 2^(-7)
    // NormalNoise valueFactor = (1/6) / expectedDeviation(0) = 0.16667 / 0.2 = 5/6
    private static final double SPAG2D_NOISE_VF = 5.0 / 6.0;

    // Elevation: firstOctave=-8, amps=[1]
    private static final double SPAG2D_ELEV_FREQ = 1.0 / 256.0;        // 2^(-8)
    private static final double SPAG2D_ELEV_VF = 0.8333333333333334;

    // Thickness: firstOctave=-11, amps=[1]
    private static final double SPAG2D_THICK_FREQ = 1.0 / 2048.0;      // 2^(-11)
    private static final double SPAG2D_THICK_VF = 0.8333333333333334;

    // Roughness: firstOctave=-5, amps=[1], xzScale=1, yScale=1
    private static final double SPAG_ROUGH_FREQ = 1.0 / 32.0;          // 2^(-5)
    private static final double SPAG_ROUGH_VF = 0.8333333333333334;
    // Roughness modulator: firstOctave=-8, amps=[1], xzScale=1, yScale=1
    private static final double SPAG_ROUGH_MOD_FREQ = 1.0 / 256.0;     // 2^(-8)
    private static final double SPAG_ROUGH_MOD_VF = 0.8333333333333334;

    /**
     * Ванильная 1:1 формула Mojang NoiseRouterData.spaghetti2D().
     *
     * Каждый шум — полный NormalNoise (два PerlinNoise + INPUT_FACTOR + valueFactor).
     * ImprovedNoise — ванильная реализация (Perlin gradient noise, NOT OpenSimplex).
     *
     * result < 0 → пещера (совпадает с конвенцией computeCombinedCarver).
     */
    public float computeSpaghetti2D(int x, int y, int z) {
        // === 1. Modulator — NormalNoise(firstOctave=-11, amps=[1]), xzScale=2, yScale=1 ===
        double mX = x * 2.0 * SPAG2D_MOD_FREQ;
        double mY = y * SPAG2D_MOD_FREQ;
        double mZ = z * 2.0 * SPAG2D_MOD_FREQ;
        double modFirst  = ImprovedNoise.noise3(spag2dRarenessSeed,  mX, mY, mZ);
        double modSecond = ImprovedNoise.noise3(spag2dRarenessSeed2, mX * VANILLA_INPUT_FACTOR, mY * VANILLA_INPUT_FACTOR, mZ * VANILLA_INPUT_FACTOR);
        double modulator = (modFirst + modSecond) * SPAG2D_MOD_VF;

        // === 2. Rarity (TYPE2 квантизация) ===
        double rarity = getSphaghettiRarity2D(modulator);

        // === 3. WeirdScaledSampler — NormalNoise(firstOctave=-7, amps=[1.0]) — 1 octave ваниль ===
        //   transform(ctx, modVal): d0=rarity; return d0 * |noise(x/d0, y/d0, z/d0)|
        double invR = 1.0 / rarity;
        double sx = x * invR, sy = y * invR, sz = z * invR;
        double perlinFirst  = ImprovedNoise.noise3(spag2d1Seed,
                sx * SPAG2D_FREQ, sy * SPAG2D_FREQ, sz * SPAG2D_FREQ);
        double perlinSecond = ImprovedNoise.noise3(spag2d1Seed2,
                sx * SPAG2D_FREQ * VANILLA_INPUT_FACTOR,
                sy * SPAG2D_FREQ * VANILLA_INPUT_FACTOR,
                sz * SPAG2D_FREQ * VANILLA_INPUT_FACTOR);
        double tunnelNoise = rarity * Math.abs((perlinFirst + perlinSecond) * SPAG2D_NOISE_VF);

        // === 4. Elevation — NormalNoise(firstOctave=-8, amps=[1]), xzScale=1, yScale=0 (2D) ===
        //   mappedNoise(fromY=-8, toY=8) → mid=0, halfRange=8
        double eX = x * SPAG2D_ELEV_FREQ, eZ = z * SPAG2D_ELEV_FREQ;
        double elevFirst  = ImprovedNoise.noise3(spag2dElevationSeed,  eX, 0, eZ);
        double elevSecond = ImprovedNoise.noise3(spag2dElevationSeed2, eX * VANILLA_INPUT_FACTOR, 0, eZ * VANILLA_INPUT_FACTOR);
        double elevation = 8.0 * (elevFirst + elevSecond) * SPAG2D_ELEV_VF;

        // === 5. Thickness — NormalNoise(firstOctave=-11, amps=[1]), xzScale=2, yScale=1 ===
        //   mappedNoise(fromY=-0.6, toY=-1.3) → mid=-0.95, halfRange=-0.35
        double tX = x * 2.0 * SPAG2D_THICK_FREQ;
        double tY = y * SPAG2D_THICK_FREQ;
        double tZ = z * 2.0 * SPAG2D_THICK_FREQ;
        double thickFirst  = ImprovedNoise.noise3(spag2dThicknessSeed,  tX, tY, tZ);
        double thickSecond = ImprovedNoise.noise3(spag2dThicknessSeed2, tX * VANILLA_INPUT_FACTOR, tY * VANILLA_INPUT_FACTOR, tZ * VANILLA_INPUT_FACTOR);
        double thicknessMod = -0.95 + (-0.35) * (thickFirst + thickSecond) * SPAG2D_THICK_VF;

        // === 6. yClampedGradient(-190, 430, 17.0, -60.0) — адаптировано под BFME ===
        // Slope ≈0.124/блок (как в ванильном 0.125, мягкий).
        // gradient = 0 на y≈-55 → активная полоса spag2D на y=-130..20 (~150 блоков),
        // в глубоком underground. Не лезет на поверхность плейнов (~70-100).
        double yGradient;
        if (y <= -190) {
            yGradient = 17.0;
        } else if (y >= 430) {
            yGradient = -60.0;
        } else {
            yGradient = 17.0 - 77.0 * (y + 190) / 620.0;
        }

        // === 7. yDistance = |elevation + yGradient|, yPenalty = (yDistance + thicknessMod)³ ===
        double yDistance = Math.abs(elevation + yGradient);
        double yPenaltyBase = yDistance + thicknessMod;
        double yPenalty = yPenaltyBase * yPenaltyBase * yPenaltyBase;

        // === 8. tunnel = tunnelNoise + 0.083 * thicknessMod ===
        double tunnel = tunnelNoise + 0.083 * thicknessMod;

        // === 9. result = clamp(max(tunnel, yPenalty), -1, 1) ===
        double spaghetti2D = Math.max(-1.0, Math.min(1.0, Math.max(tunnel, yPenalty)));

        return (float) spaghetti2D;
    }

    /**
     * Vanilla spaghetti_roughness_function (shared by spaghetti 2D and 3D).
     * roughness = NormalNoise(SPAGHETTI_ROUGHNESS, firstOctave=-5, amps=[1])
     * roughnessMod = mappedNoise(SPAGHETTI_ROUGHNESS_MODULATOR, 0, -0.1)
     *             = -0.05 + (-0.05) * NormalNoise(modulator)
     * return roughnessMod * (|roughness| - 0.4)
     */
    public double computeRoughness(int x, int y, int z) {
        double rX = x * SPAG_ROUGH_FREQ, rY = y * SPAG_ROUGH_FREQ, rZ = z * SPAG_ROUGH_FREQ;
        double roughFirst  = ImprovedNoise.noise3(spagRoughnessSeed1, rX, rY, rZ);
        double roughSecond = ImprovedNoise.noise3(spagRoughnessSeed2,
                rX * VANILLA_INPUT_FACTOR, rY * VANILLA_INPUT_FACTOR, rZ * VANILLA_INPUT_FACTOR);
        double roughness = (roughFirst + roughSecond) * SPAG_ROUGH_VF;

        double rmX = x * SPAG_ROUGH_MOD_FREQ, rmY = y * SPAG_ROUGH_MOD_FREQ, rmZ = z * SPAG_ROUGH_MOD_FREQ;
        double roughModFirst  = ImprovedNoise.noise3(spagRoughnessModSeed1, rmX, rmY, rmZ);
        double roughModSecond = ImprovedNoise.noise3(spagRoughnessModSeed2,
                rmX * VANILLA_INPUT_FACTOR, rmY * VANILLA_INPUT_FACTOR, rmZ * VANILLA_INPUT_FACTOR);
        double roughModNoise = (roughModFirst + roughModSecond) * SPAG_ROUGH_MOD_VF;
        double roughnessMod = -0.05 + (-0.05) * roughModNoise;

        return roughnessMod * (Math.abs(roughness) - 0.4);
    }

    /** Ванильная квантизация NoiseRouterData.QuantizedSpaghettiRarity.getSphaghettiRarity2D */
    private static double getSphaghettiRarity2D(double value) {
        if (value < -0.75) return 0.5;
        if (value < -0.5)  return 0.75;
        if (value < 0.5)   return 1.0;
        if (value < 0.75)  return 2.0;
        return 3.0;
    }

    // ============================================================
    // CARVERS — SPAGHETTI 3D (vanilla NormalNoise 1:1)
    // ============================================================

    // --- Spaghetti 3D: ванильные константы NormalNoise ---

    // Rarity: firstOctave=-11, amps=[1], xzScale=2.0, yScale=1.0
    // PerlinNoise freq = 1/2048, but xzScale=2 → effective xz freq = 2/2048 = 1/1024
    private static final double SPAG3D_RARITY_XZ_FREQ = 2.0 / 2048.0;   // xzScale=2, 2^(-11)
    private static final double SPAG3D_RARITY_Y_FREQ = 1.0 / 2048.0;    // yScale=1, 2^(-11)
    private static final double SPAG3D_RARITY_VF = 0.8333333333333334;   // (1/6) / 0.2

    // Spaghetti_3d_1 and _2: firstOctave=-7, amps=[1]
    // Sampled through WeirdScaledSampler TYPE1 — coords divided by rarity
    private static final double SPAG3D_NOISE_BASE_FREQ = 1.0 / 128.0;   // 2^(-7) ванильное
    private static final double SPAG3D_NOISE_VF = 0.8333333333333334;    // (1/6) / 0.2

    // Thickness: firstOctave=-8, amps=[1], xzScale=1, yScale=1
    private static final double SPAG3D_THICK_FREQ = 1.0 / 256.0;        // 2^(-8)
    private static final double SPAG3D_THICK_VF = 0.8333333333333334;    // (1/6) / 0.2

    /**
     * Ванильная 1:1 формула Mojang NoiseRouterData.entrances() — часть spaghetti 3D.
     *
     * Формула (из NoiseRouterData.java:240-249):
     *   rarityNoise = NormalNoise(spaghetti_3d_rarity, xzScale=2.0, yScale=1.0)  [cacheOnce]
     *   thickness   = mappedNoise(spaghetti_3d_thickness, -0.065, -0.088)
     *               = -0.0765 + (-0.0115) * NormalNoise(thickness)
     *   tunnel1     = WeirdScaledSampler(TYPE1, rarityNoise, spaghetti_3d_1)
     *   tunnel2     = WeirdScaledSampler(TYPE1, rarityNoise, spaghetti_3d_2)
     *   result      = clamp(max(tunnel1, tunnel2) + thickness, -1, 1)
     *
     * TYPE1 rarity quantization: {<-0.5→0.75, <0.0→1.0, <0.5→1.5, else→2.0}
     * WeirdScaledSampler: rarity * |noise(x/rarity, y/rarity, z/rarity)|
     *
     * Roughness is added externally in computeCombinedCarver (same as spaghetti 2D).
     */
    public float computeSpaghetti3D(int x, int y, int z) {
        // === 1. Rarity NormalNoise (firstOctave=-11, xzScale=2, yScale=1) ===
        double rX = x * SPAG3D_RARITY_XZ_FREQ;
        double rY = y * SPAG3D_RARITY_Y_FREQ;
        double rZ = z * SPAG3D_RARITY_XZ_FREQ;
        double rarFirst  = ImprovedNoise.noise3(spag3dRaritySeed1, rX, rY, rZ);
        double rarSecond = ImprovedNoise.noise3(spag3dRaritySeed2,
                rX * VANILLA_INPUT_FACTOR, rY * VANILLA_INPUT_FACTOR, rZ * VANILLA_INPUT_FACTOR);
        double rarityNoise = (rarFirst + rarSecond) * SPAG3D_RARITY_VF;

        // === 2. TYPE1 rarity quantization ===
        double rarity = getSpaghettiRarity3D(rarityNoise);

        // === 3. WeirdScaledSampler TYPE1 for tunnel1 (spaghetti_3d_1) ===
        // NormalNoise sampled at coords / rarity, result = rarity * |noise|
        double sx = x / rarity;
        double sy = y / rarity;
        double sz = z / rarity;

        double freq = SPAG3D_NOISE_BASE_FREQ;
        double t1First  = ImprovedNoise.noise3(spag3d1Seed1, sx * freq, sy * freq, sz * freq);
        double t1Second = ImprovedNoise.noise3(spag3d1Seed2,
                sx * freq * VANILLA_INPUT_FACTOR, sy * freq * VANILLA_INPUT_FACTOR, sz * freq * VANILLA_INPUT_FACTOR);
        double tunnel1 = rarity * Math.abs((t1First + t1Second) * SPAG3D_NOISE_VF);

        // === 4. WeirdScaledSampler TYPE1 for tunnel2 (spaghetti_3d_2) ===
        double t2First  = ImprovedNoise.noise3(spag3d2Seed1, sx * freq, sy * freq, sz * freq);
        double t2Second = ImprovedNoise.noise3(spag3d2Seed2,
                sx * freq * VANILLA_INPUT_FACTOR, sy * freq * VANILLA_INPUT_FACTOR, sz * freq * VANILLA_INPUT_FACTOR);
        double tunnel2 = rarity * Math.abs((t2First + t2Second) * SPAG3D_NOISE_VF);

        // === 5. Thickness NormalNoise (firstOctave=-8, xzScale=1, yScale=1) ===
        // BFME: слегка ужато с ванильного [-0.088, -0.065] до [-0.07, -0.05].
        // Чуть тоньше тоннели и меньше "ложки" в пересечениях, но не доходит до
        // обрывов от интерполяции.
        double tX = x * SPAG3D_THICK_FREQ;
        double tY = y * SPAG3D_THICK_FREQ;
        double tZ = z * SPAG3D_THICK_FREQ;
        double thickFirst  = ImprovedNoise.noise3(spag3dThicknessSeed1, tX, tY, tZ);
        double thickSecond = ImprovedNoise.noise3(spag3dThicknessSeed2,
                tX * VANILLA_INPUT_FACTOR, tY * VANILLA_INPUT_FACTOR, tZ * VANILLA_INPUT_FACTOR);
        double thicknessNoise = (thickFirst + thickSecond) * SPAG3D_THICK_VF;
        double thickness = -0.06 + (-0.01) * thicknessNoise;

        // === 6. Final: clamp(max(tunnel1, tunnel2) + thickness, -1, 1) ===
        double result = Math.max(tunnel1, tunnel2) + thickness;
        return (float) Math.max(-1.0, Math.min(1.0, result));
    }

    /** Vanilla TYPE1 rarity quantization for spaghetti 3D */
    private static double getSpaghettiRarity3D(double value) {
        // BFME: убран rarity=2.0 (ванильный) — он создавал гигантские "ложки" 30+ блоков
        // на пересечениях из-за периода 256 блоков. Теперь max rarity = 1.5.
        if (value < -0.5) return 0.75;
        if (value < 0.0)  return 1.0;
        return 1.5;
    }

    // ============================================================
    // CARVERS — NOODLE (vanilla NormalNoise 1:1)
    // ============================================================

    // --- Noodle: ванильные константы NormalNoise ---

    // Selector (NOODLE): firstOctave=-8, amps=[1], xzScale=1, yScale=1
    private static final double NOODLE_SEL_FREQ = 1.0 / 256.0;          // 2^(-8)
    private static final double NOODLE_SEL_VF = 0.8333333333333334;     // (1/6) / 0.2

    // Thickness (NOODLE_THICKNESS): firstOctave=-8, amps=[1], xzScale=1, yScale=1
    private static final double NOODLE_THICK_FREQ = 1.0 / 256.0;        // 2^(-8)
    private static final double NOODLE_THICK_VF = 0.8333333333333334;

    // Ridge A/B (NOODLE_RIDGE_A/B): firstOctave=-7, amps=[1], xzScale=2.6667, yScale=2.6667
    private static final double NOODLE_RIDGE_XZ_FREQ = 2.6666666666666665 / 128.0;  // xzScale * 2^(-7)
    private static final double NOODLE_RIDGE_Y_FREQ = 2.6666666666666665 / 128.0;   // yScale * 2^(-7)
    private static final double NOODLE_RIDGE_VF = 0.8333333333333334;

    // Ваниль: mult=1.5, thicknessBase=-0.075. Mult чуть ниже (1.35) — дешёвый
    // рычаг частоты: расширяет полосу пересечения ridge (больше тонких нитей),
    // но НЕ раздувает ширину как глубокий thickness. Всё на grid 4×8.
    public static final float NOODLE_RIDGE_MULT = 1.35f;
    private static final double NOODLE_THICKNESS_BASE = -0.075;
    private static final double NOODLE_THICKNESS_AMP = -0.025;

    /**
     * Ванильная 1:1 формула Mojang NoiseRouterData.noodle().
     *
     * Формула:
     *   selector = NormalNoise(NOODLE, xzScale=1, yScale=1)  — firstOctave=-8
     *   if selector >= 0 → return 64 (no cave)
     *
     *   thickness = NOODLE_THICKNESS_BASE + NOODLE_THICKNESS_AMP * NormalNoise
     *               (ваниль: -0.075 + (-0.025)*noise; у нас глубже для частоты)
     *
     *   ridgeA = NormalNoise(NOODLE_RIDGE_A, xzScale=2.6667, yScale=2.6667) — firstOctave=-7
     *   ridgeB = NormalNoise(NOODLE_RIDGE_B, xzScale=2.6667, yScale=2.6667) — firstOctave=-7
     *   ridges = NOODLE_RIDGE_MULT * max(|ridgeA|, |ridgeB|)  (ваниль: 1.5)
     *
     *   result = thickness + ridges
     *
     * Y-range: vanilla [-60, 320], returns 64 outside (solid, no cave).
     * Cave where result < 0.
     */
    public float computeNoodle(int x, int y, int z) {
        if (y < CAVE_NOODLE_Y_MIN || y > CAVE_NOODLE_Y_MAX) return 64.0f;
        double selector = computeNoodleSelector(x, y, z);
        // Vanilla: rangeChoice(selector, -1e6, 0, constant(64), thickness+ridges)
        // selector < 0 → no cave (return 64), selector >= 0 → potential cave
        if (selector < 0.0) return 64.0f;
        double thickness = computeNoodleThickness(x, y, z);
        double ridgeA = computeNoodleRidgeA(x, y, z);
        double ridgeB = computeNoodleRidgeB(x, y, z);
        double ridges = NOODLE_RIDGE_MULT * Math.max(Math.abs(ridgeA), Math.abs(ridgeB));
        return (float) (thickness + ridges);
    }

    // ============================================================
    // NOODLE подкомпоненты (для grid-based интерполяции в CaveInterpolator)
    // Vanilla паттерн: каждый шум интерполируется отдельно на 4×4×8,
    // финальная формула применяется per-block (без noise calls).
    // ============================================================

    /** NOODLE selector — NormalNoise(firstOctave=-8). Cave-possible когда < 0. */
    public double computeNoodleSelector(int x, int y, int z) {
        double sX = x * NOODLE_SEL_FREQ;
        double sY = y * NOODLE_SEL_FREQ;
        double sZ = z * NOODLE_SEL_FREQ;
        double first  = ImprovedNoise.noise3(noodleSelectorSeed1, sX, sY, sZ);
        double second = ImprovedNoise.noise3(noodleSelectorSeed2,
                sX * VANILLA_INPUT_FACTOR, sY * VANILLA_INPUT_FACTOR, sZ * VANILLA_INPUT_FACTOR);
        return (first + second) * NOODLE_SEL_VF;
    }

    /** NOODLE thickness — уже преобразовано mappedNoise(-0.05, -0.1) = -0.075 + (-0.025) * noise. */
    public double computeNoodleThickness(int x, int y, int z) {
        double tX = x * NOODLE_THICK_FREQ;
        double tY = y * NOODLE_THICK_FREQ;
        double tZ = z * NOODLE_THICK_FREQ;
        double first  = ImprovedNoise.noise3(noodleThicknessSeed1, tX, tY, tZ);
        double second = ImprovedNoise.noise3(noodleThicknessSeed2,
                tX * VANILLA_INPUT_FACTOR, tY * VANILLA_INPUT_FACTOR, tZ * VANILLA_INPUT_FACTOR);
        double thicknessNoise = (first + second) * NOODLE_THICK_VF;
        return NOODLE_THICKNESS_BASE + NOODLE_THICKNESS_AMP * thicknessNoise;
    }

    /** NOODLE ridge A — NormalNoise(firstOctave=-7, xz/y=2.6667). */
    public double computeNoodleRidgeA(int x, int y, int z) {
        double raX = x * NOODLE_RIDGE_XZ_FREQ;
        double raY = y * NOODLE_RIDGE_Y_FREQ;
        double raZ = z * NOODLE_RIDGE_XZ_FREQ;
        double first  = ImprovedNoise.noise3(noodleRidgeASeed1, raX, raY, raZ);
        double second = ImprovedNoise.noise3(noodleRidgeASeed2,
                raX * VANILLA_INPUT_FACTOR, raY * VANILLA_INPUT_FACTOR, raZ * VANILLA_INPUT_FACTOR);
        return (first + second) * NOODLE_RIDGE_VF;
    }

    /** NOODLE ridge B — NormalNoise(firstOctave=-7, xz/y=2.6667). */
    public double computeNoodleRidgeB(int x, int y, int z) {
        double rbX = x * NOODLE_RIDGE_XZ_FREQ;
        double rbY = y * NOODLE_RIDGE_Y_FREQ;
        double rbZ = z * NOODLE_RIDGE_XZ_FREQ;
        double first  = ImprovedNoise.noise3(noodleRidgeBSeed1, rbX, rbY, rbZ);
        double second = ImprovedNoise.noise3(noodleRidgeBSeed2,
                rbX * VANILLA_INPUT_FACTOR, rbY * VANILLA_INPUT_FACTOR, rbZ * VANILLA_INPUT_FACTOR);
        return (first + second) * NOODLE_RIDGE_VF;
    }

    // ============================================================
    // CARVERS — ENTRANCES (vanilla NormalNoise 1:1)
    // ============================================================

    // Vanilla cave_entrance: firstOctave=-7, amplitudes=[0.4, 0.5, 1.0] — 1:1 ваниль
    // Noise function called with xz_scale=0.75, y_scale=0.5
    private static final double CAVE_ENTRANCE_XZ_SCALE = 0.75;
    private static final double CAVE_ENTRANCE_Y_SCALE = 0.5;
    private static final double[] CAVE_ENTRANCE_AMPS = {0.4, 0.5, 1.0};
    private static final double CAVE_ENTRANCE_BASE_FREQ = 1.0 / 128.0;     // 2^(-7)
    private static final double CAVE_ENTRANCE_LOWEST_VF = 4.0 / 7.0;       // 2^2 / (2^3 - 1)
    private static final double CAVE_ENTRANCE_VF = 1.25;                    // (1/6) / 0.1333

    // Depth-based gradient (vanilla: yClampedGradient(-10, 30, 0.3, 0.0))
    // BFME: использует depth from surface вместо абсолютного Y.
    // depth < ENTRANCE_FADE_START: gradient = 0 (входы активны)
    // depth > ENTRANCE_FADE_END: gradient = 0.3 (входы заглушены)
    private static final float ENTRANCE_FADE_START = 30f;
    private static final float ENTRANCE_FADE_END = 100f;
    private static final double ENTRANCE_FADE_VALUE = 0.3;

    /**
     * Ванильная 1:1 формула entrance gradient (часть NoiseRouterData.entrances()).
     *
     * Формула:
     *   noise = NormalNoise(cave_entrance, xz=0.75, y=0.5) — 3 октавы amps=[0.4, 0.5, 1.0]
     *   depthGradient = depth-based fade (вместо ванильного yClampedGradient)
     *   result = 0.37 + (1 - strength) * 2.0 + noise + depthGradient
     *
     * @param strength Per-biome множитель: 1.0 = ванильно, 0.0 = почти нет входов
     * @return density-like значение, < 0 → пещера/вход
     */
    public float computeEntrance(int x, int y, int z, int surfaceHeight, float strength) {
        if (strength <= 0f) return 1.0f;
        double noise = computeEntranceNoise(x, y, z);
        double depthGradient = computeEntranceDepthGradient(y, surfaceHeight);
        // strength=1.0 → ванильное 0.37, strength=0.5 → 2.37, strength=0.0 → 4.37
        // Усилен (×4) чтобы slight reduction давала видимый эффект на крупном BFME мире.
        double offset = 0.37 + (1.0 - strength) * 4.0;
        return (float) (offset + noise + depthGradient);
    }

    /** Только noise часть entrance (3 октавы). Для интерполируемого grid'а. */
    public double computeEntranceNoise(int x, int y, int z) {
        checkInit();
        double bx = x * CAVE_ENTRANCE_XZ_SCALE;
        double by = y * CAVE_ENTRANCE_Y_SCALE;
        double bz = z * CAVE_ENTRANCE_XZ_SCALE;

        double first = 0, second = 0;
        double d1 = CAVE_ENTRANCE_BASE_FREQ;
        double d2 = CAVE_ENTRANCE_LOWEST_VF;
        for (int i = 0; i < 3; i++) {
            double amp = CAVE_ENTRANCE_AMPS[i];
            first += amp * ImprovedNoise.noise3(caveEntranceSeeds1[i],
                    bx * d1, by * d1, bz * d1) * d2;
            second += amp * ImprovedNoise.noise3(caveEntranceSeeds2[i],
                    bx * d1 * VANILLA_INPUT_FACTOR,
                    by * d1 * VANILLA_INPUT_FACTOR,
                    bz * d1 * VANILLA_INPUT_FACTOR) * d2;
            d1 *= 2.0;
            d2 /= 2.0;
        }
        return (first + second) * CAVE_ENTRANCE_VF;
    }

    /** Depth-based gradient часть entrance (per-block, не интерполируется). */
    public double computeEntranceDepthGradient(int y, int surfaceHeight) {
        int depth = surfaceHeight - y;
        if (depth < ENTRANCE_FADE_START) return 0.0;
        if (depth >= ENTRANCE_FADE_END) return ENTRANCE_FADE_VALUE;
        double t = (depth - ENTRANCE_FADE_START) / (double)(ENTRANCE_FADE_END - ENTRANCE_FADE_START);
        return ENTRANCE_FADE_VALUE * t;
    }

    // ============================================================
    // AQUIFER NOISES — ванильный NormalNoise (2 PerlinNoise + INPUT_FACTOR + valueFactor)
    // ============================================================
    //
    // Ваниль NoiseRouterData строки 341-344:
    //   barrier      = noise(AQUIFER_BARRIER, 0.5)         — firstOctave=-3, xz=0.5
    //   floodedness  = noise(AQUIFER_FLUID_LEVEL_FLOODEDNESS, 0.67)  — firstOctave=-7, xz=0.67
    //   spread       = noise(AQUIFER_FLUID_LEVEL_SPREAD, 0.71)        — firstOctave=-5, xz=0.71
    //   lava         = noise(AQUIFER_LAVA)                  — firstOctave=-1, xz=1.0
    // Все 1-oct, valueFactor = 5/6.

    private static final double AQ_BARRIER_FREQ      = 1.0 / 8.0;   // 2^(-3)
    private static final double AQ_BARRIER_SCALE     = 0.5;
    private static final double AQ_FLOOD_FREQ        = 1.0 / 128.0; // 2^(-7)
    private static final double AQ_FLOOD_SCALE       = 0.67;
    private static final double AQ_SPREAD_FREQ       = 1.0 / 32.0;  // 2^(-5)
    private static final double AQ_SPREAD_SCALE      = 0.7142857142857143;
    private static final double AQ_LAVA_FREQ         = 1.0 / 2.0;   // 2^(-1)
    private static final double AQ_LAVA_SCALE        = 1.0;
    private static final double AQ_VF                = 5.0 / 6.0;   // (1/6) / 0.2 — 1 octave

    /** Барьер между аквиферами. NormalNoise(barrier, xz=0.5). Wavelength ~16 блоков. */
    public double computeAquiferBarrier(int x, int y, int z) {
        checkInit();
        double k = AQ_BARRIER_FREQ * AQ_BARRIER_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(aquiferBarrierSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(aquiferBarrierSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * AQ_VF;
    }

    /** Floodedness — NormalNoise(flood, xz=0.67). Wavelength ~191 блок. */
    public double computeAquiferFloodedness(int x, int y, int z) {
        checkInit();
        double k = AQ_FLOOD_FREQ * AQ_FLOOD_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(aquiferFloodednessSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(aquiferFloodednessSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * AQ_VF;
    }

    /** Spread — NormalNoise(spread, xz=0.71). Wavelength ~45 блоков. */
    public double computeAquiferSpread(int x, int y, int z) {
        checkInit();
        double k = AQ_SPREAD_FREQ * AQ_SPREAD_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(aquiferSpreadSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(aquiferSpreadSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * AQ_VF;
    }

    /** Lava — NormalNoise(lava, xz=1.0). Wavelength 2 блока (точечный). */
    public double computeAquiferLava(int x, int y, int z) {
        checkInit();
        double k = AQ_LAVA_FREQ * AQ_LAVA_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(aquiferLavaSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(aquiferLavaSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * AQ_VF;
    }

    // ============================================================
    // ORE VEIN NOISES — публичный API
    // ============================================================

    // === ORE VEIN NormalNoise константы (1:1 ваниль NoiseRouterData) ===
    // ИНФО про "координатные scale" из ванильного `DensityFunctions.noise(noise, xzScale, yScale)`:
    //   noise(VEININESS, 1.5, 1.5) → координаты * 1.5 перед сэмплированием
    //   noise(VEIN_A/B,  4.0, 4.0) → координаты * 4.0
    //   noise(GAP)               → координаты * 1.0 (без scale)
    // ВСЕ vein noises — 1 octave (проверено по ванильному JSON ore_*.json).
    // veininess: firstOctave=-8, amps=[1.0] → freq=1/256, valueFactor=5/6, scale 1.5
    private static final double VEIN_VEININESS_FREQ  = 1.0 / 256.0;
    private static final double VEIN_VEININESS_SCALE = 1.5;
    private static final double VEIN_VEININESS_VF    = 5.0 / 6.0;
    // vein_a/b: firstOctave=-7, amps=[1.0] → freq=1/128, valueFactor=5/6, scale 4.0
    private static final double VEIN_AB_FREQ         = 1.0 / 128.0;
    private static final double VEIN_AB_SCALE        = 4.0;
    private static final double VEIN_AB_VF           = 5.0 / 6.0;
    // gap: firstOctave=-5, amps=[1.0] → freq=1/32, valueFactor=5/6, scale 1.0
    private static final double VEIN_GAP_FREQ        = 1.0 / 32.0;
    private static final double VEIN_GAP_SCALE       = 1.0;
    private static final double VEIN_GAP_VF          = 5.0 / 6.0;

    /** Veininess (NormalNoise, freq 1/256, scale 1.5, 1 oct). Знак определяет тип vein.
     *  ВАЖНО: INPUT_FACTOR применяется ТОЛЬКО ко второй noise (как в ваниль NormalNoise.getValue). */
    public double computeOreVeininess(int x, int y, int z) {
        checkInit();
        double k = VEIN_VEININESS_FREQ * VEIN_VEININESS_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(oreVeininessSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(oreVeininessSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * VEIN_VEININESS_VF;
    }

    /** Vein A (NormalNoise, freq 1/128, scale 4.0, 1 oct). max(|A|,|B|) — центр vs край жилы. */
    public double computeOreVeinA(int x, int y, int z) {
        checkInit();
        double k = VEIN_AB_FREQ * VEIN_AB_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(oreVeinASeeds1[0], sx, sy, sz);
        double n2 = ImprovedNoise.noise3(oreVeinASeeds2[0],
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * VEIN_AB_VF;
    }

    /** Vein B (NormalNoise, freq 1/128, scale 4.0, 1 oct). */
    public double computeOreVeinB(int x, int y, int z) {
        checkInit();
        double k = VEIN_AB_FREQ * VEIN_AB_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(oreVeinBSeeds1[0], sx, sy, sz);
        double n2 = ImprovedNoise.noise3(oreVeinBSeeds2[0],
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * VEIN_AB_VF;
    }

    /** Vein gap (NormalNoise, freq 1/32, scale 1.0, 1 oct). gap > -0.3 → блок может быть ore. */
    public double computeOreGap(int x, int y, int z) {
        checkInit();
        double k = VEIN_GAP_FREQ * VEIN_GAP_SCALE;
        double sx = x * k, sy = y * k, sz = z * k;
        double n1 = ImprovedNoise.noise3(oreGapSeed1, sx, sy, sz);
        double n2 = ImprovedNoise.noise3(oreGapSeed2,
                sx * VANILLA_INPUT_FACTOR, sy * VANILLA_INPUT_FACTOR, sz * VANILLA_INPUT_FACTOR);
        return (n1 + n2) * VEIN_GAP_VF;
    }

    // ============================================================
    // COMBINED CARVER
    // ============================================================

    public float computeCombinedCarver(int x, int y, int z, int surfaceHeight,
                                        float entranceStrength, float spag3DStrength) {
        float result = 1.0f;

        // Vanilla underground() composition:
        //   min(cheese, ENTRANCES, spag2d + roughness)
        // where ENTRANCES = min(caveEntranceGradient, spag3d + roughness)
        // Roughness is shared between spaghetti 2D and 3D.
        double roughness = (CARVER_SPAG2D_ENABLED || (CARVER_SPAG3D_ENABLED && spag3DStrength > 0f))
                ? computeRoughness(x, y, z) : 0.0;

        // === ENTRANCES = min(entranceGradient, spag3D + roughness) ===
        // spag3D живёт ВНУТРИ entrances (как в ванилле), а не отдельным carver'ом.
        float entrances = 1.0f;
        if (CARVER_ENTRANCE_ENABLED && entranceStrength > 0f) {
            entrances = computeEntrance(x, y, z, surfaceHeight, entranceStrength);
        }
        if (CARVER_SPAG3D_ENABLED && spag3DStrength > 0f) {
            // spag3DStrength bias: shift result by (1 - strength) * 0.05.
            // strength=1.0 → +0 (vanilla). strength=0.5 → +0.025 (rarer). strength=1.5 → -0.025 (denser).
            double s3dBias = (1.0 - spag3DStrength) * 0.05;
            float s3d = (float) (computeSpaghetti3D(x, y, z) + roughness + s3dBias);
            if (s3d < entrances) entrances = s3d;
        }
        if (entrances < result) result = entrances;

        // === spag2D + roughness (отдельная ветка underground composition) ===
        if (CARVER_SPAG2D_ENABLED) {
            float s2d = (float) (computeSpaghetti2D(x, y, z) + roughness);
            if (s2d < result) result = s2d;
        }

        // Noodle вынесен из carver grid — вычисляется per-block в CaveInterpolator.isCave().
        // Ваниль на 4×4×8 даёт "stubs" из-за константы 64 в noodle формуле, плохо интерполируется.
        return result;
    }

    // ============================================================
    // LEGACY isCave (для per-block fallback)
    //
    // Ванильная композиция: max(cheeseDensity, pillarGated)
    // pillarGated = pillar если pillar > 0.03, иначе -∞
    // ============================================================

    public boolean isCave(int x, int y, int z, int surfaceHeight, float surfaceFadeDepth, float surfaceFadeStrength, boolean cavesEnabled) {
        if (!cavesEnabled) return false;
        if (y > surfaceHeight || y < CAVE_MIN_Y || y > CAVE_MAX_Y) return false;

        // computeCaveDensity уже включает pillar (MAX-композиция внутри). Legacy: default offsets + global fade.
        float density = computeCaveDensity(x, y, z, surfaceHeight, CAVE_OFFSET, CAVE_OFFSET_LARGE, CAVE_FADE_DEPTH, CAVE_FADE_STRENGTH);

        if (density < 0f) return true;

        if (density > 0.08f) {
            float carver = computeCombinedCarver(x, y, z, surfaceHeight, 1.0f, 1.0f);
            if (carver < 0f) return true;
        }

        return false;
    }


    // ============================================================
    // 3D CLIFF DETAIL (не тронут)
    // ============================================================

    public boolean shouldCarveCliff(int x, int y, int z, int surfaceHeight, float slopeAngle) {
        checkInit();
        int depthFromSurface = surfaceHeight - y;
        if (depthFromSurface < 0 || depthFromSurface > 20) return false;
        if (slopeAngle < 30) return false;

        float slopeFactor = Math.min((slopeAngle - 30) / 60f, 1.0f);
        double cliff = cliffNoise3D.sample3D(x, y, z);
        double overhang = overhangNoise3D.sample3D(x, y * 1.5, z);
        float overhangFactor = Math.max(0, 1.0f - (depthFromSurface / 10f));
        double crevice = creviceNoise3D.sample3D(x, y * 0.5, z);

        double threshold = 0.3 + (1.0 - slopeFactor) * 0.4;

        if (cliff > threshold) return true;
        if (overhang > 0.5 && overhangFactor > 0.3 && depthFromSurface < 5) return true;
        if (Math.abs(crevice) < 0.08 * slopeFactor && slopeAngle > 50) return true;

        return false;
    }

    public double getCliffDensity(int x, int y, int z, int surfaceHeight, float slopeAngle) {
        checkInit();
        int depthFromSurface = surfaceHeight - y;
        if (slopeAngle < 20 || depthFromSurface > 15 || depthFromSurface < 0) return 10;

        double mainNoise = cliffNoise3D.sample3D(x, y * 0.5, z);
        if (mainNoise > 0.2) return -(mainNoise - 0.2) * 20.0;

        return 10;
    }

    private static float smoothMin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0f) / k;
        return Math.min(a, b) - h * h * k * 0.25f;
    }

    private static float smoothstep(float edge0, float edge1, float x) {
        float t = (x - edge0) / (edge1 - edge0);
        if (t < 0f) t = 0f;
        else if (t > 1f) t = 1f;
        return t * t * (3f - 2f * t);
    }

    // ============================================================
    // UTILITY
    // ============================================================

    public boolean isInitialized() { return initialized; }
    public long getWorldSeed() { return worldSeed; }
    public void reset() { initialized = false; }
}