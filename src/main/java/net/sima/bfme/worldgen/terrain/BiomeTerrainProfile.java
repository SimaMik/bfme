package net.sima.bfme.worldgen.terrain;

import net.sima.bfme.worldgen.pattern.PatternEntry;
import net.sima.bfme.worldgen.pattern.PatternParams;
import net.sima.bfme.worldgen.pattern.TerrainPattern;
import net.sima.bfme.worldgen.terrain.voronoi.MountainShape;
import net.sima.bfme.worldgen.terrain.voronoi.RidgeConnectionConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Профиль рельефа для биома v5.0 (V11 HeightMap)
 *
 * Только используемые параметры:
 * - Базовые: baseHeight
 * - Холмы: hillsLarge/Small/Detail weights
 * - Voronoi: все параметры гор
 */
public class BiomeTerrainProfile {

    /**
     * Режим расчёта рельефа.
     * <ul>
     *   <li>{@link #LEGACY_12_WEIGHTS} — старая система: линейная сумма 12 noise-каналов
     *       (4 типа × 3 масштаба), управляется {@code noiseWeights} / {@code heightCurve} / etc.
     *       Это дефолт для всех существующих биомов.</li>
     *   <li>{@link #PATTERN_LIST} — pattern-стиль (RTF-inspired): рельеф собирается из
     *       одного или нескольких {@link PatternEntry}, выбираемых Voronoi-сеткой
     *       в {@code TerrainPatternBlender}. В Фазе 1 — заглушка, делегирует обратно
     *       в LEGACY путь, чтобы переключение биома было безопасным smoke-test'ом.</li>
     * </ul>
     */
    public enum TerrainMode {
        LEGACY_12_WEIGHTS,
        PATTERN_LIST
    }

    // === БАЗОВЫЕ ПАРАМЕТРЫ ВЫСОТЫ ===
    private int baseHeight;          // non-final для debug команд

    // === NOISE WEIGHTS (4 types × 3 scales = 12 channels, амплитуды в блоках) ===
    // Индексы: [simplexL, simplexM, simplexS, ridgeL, ridgeM, ridgeS, billowL, billowM, billowS, cellularL, cellularM, cellularS]
    public static final int W_SIMPLEX_L = 0, W_SIMPLEX_M = 1, W_SIMPLEX_S = 2;
    public static final int W_RIDGE_L = 3, W_RIDGE_M = 4, W_RIDGE_S = 5;
    public static final int W_BILLOW_L = 6, W_BILLOW_M = 7, W_BILLOW_S = 8;
    public static final int W_CELLULAR_L = 9, W_CELLULAR_M = 10, W_CELLULAR_S = 11;
    public static final int NOISE_WEIGHT_COUNT = 12;

    private final float[] noiseWeights; // float[12]

    // === CURVE & TRANSFORM ===
    private float heightCurve;    // Power curve: >1 = острее вершины, <1 = плоские  (non-final для debug)
    private final float heightBias;     // Сдвиг: <0 больше низин, >0 больше возвышенностей
    private final float clampMax;       // Максимальная высота (для плато), 0 = без ограничения
    private float warpStrength;   // Сила domain warp (non-final для debug)
    private final float erosionStrength; // Сила distance-field эрозии (0 = выкл, 1 = полная)

    // === РЕКИ (explicit carve) ===
    // riverWaterHeight — высота ВОДЫ реки в этом биоме (лорная константа, убывает вниз по течению).
    // 0 = в биоме рек нет. Блюрится тем же Gaussian, что baseHeight → плавный уклон реки по карте.
    private final float riverWaterHeight;     // уровень воды реки (0 = нет реки)
    private final float riverTargetCarveDepth; // желаемая глубина русла ниже воды
    private final float riverMinCarveDepth;   // минимум глубины
    private final float riverCoreRadius;      // ширина чистого русла (блоки)
    private final float riverInfluenceRadius; // зона влияния берега (блоки)

    // === ПАРАМЕТРЫ ШУМА ===
    private final float noiseLacunarity;   // Lacunarity (2.0 = стандарт, 2.8 = хаотичный)
    private final float noisePersistence;  // Persistence (0.5 = стандарт, 0.6 = грубый)
    private final float noiseBaseScale;    // Множитель к масштабу шумов (1.0 = стандарт)

    // === VORONOI ПАРАМЕТРЫ ===
    private final int voronoiGridSize;
    private final float voronoiWarpStrength;
    private final float mountainChance;
    private final float peakHeightMin;
    private final float peakHeightMax;
    private final float mountainRadiusMin;
    private final float mountainRadiusMax;
    private final MountainShape[] allowedShapes;
    private final float[] shapeWeights;

    // === VALLEY MODULATION (рельеф в низинах) ===
    private final boolean valleyModulationEnabled;
    private final float valleyReliefFactor;  // Минимальный рельеф в долинах (0.0-1.0)

    // === RIDGES BETWEEN PEAKS (хребты между горами) ===
    private final RidgeConnectionConfig ridgeConnectionConfig;  // null = выключено

    // === PEAK VARIATION (зубцы на вершинах) ===
    private boolean peakVariationEnabled;         // non-final для debug
    private float peakVariationAmplitude;         // non-final для debug

    // === CAVE PARAMETERS ===
    private final float caveSurfaceFadeDepth;
    private final float caveSurfaceFadeStrength;
    private final boolean cavesEnabled;
    /** Множитель силы вертикальных шахт-входов. 1.0 = ванильно, 0.0 = почти нет. */
    private final float caveEntranceStrength;
    /** Прямое значение medium cheese offset. NaN = использовать глобальный CAVE_OFFSET. */
    private final float caveMediumOffset;
    /** Прямое значение large cheese offset. NaN = использовать глобальный CAVE_OFFSET_LARGE. */
    private final float caveLargeOffset;
    /** Множитель силы spag3D. 1.0 = ванильно, 0.0 = выкл, 1.5 = чаще. */
    private final float caveSpag3DStrength;

    // === VEIN FLAGS — побиомные настройки гигантских жил ===
    /** Разрешить iron veins (tuff/iron_ore/raw_iron) в этом биоме. */
    private final boolean ironVeinsEnabled;
    /** Разрешить silver veins (andesite/silver_ore) в этом биоме. */
    private final boolean silverVeinsEnabled;
    /** Разрешить copper veins (granite/copper_ore/raw_copper) в этом биоме. */
    private final boolean copperVeinsEnabled;
    /** Множитель плотности ore vs filler внутри жилы. 1.0 = ваниль, 0.5 = бедно, 2.0 = богато. */
    private final float veinRichness;
    /** Множитель шанса raw_ore_block. 1.0 = ваниль (2%), 0 = нет raw, 5.0 = 10%. */
    private final float veinRawChance;
    /** Множитель количества жил. 1.0 = ваниль, 1.5 = на 50% больше patches, 0.5 = меньше. */
    private final float veinDensity;
    /** Множитель толщины жилы. 1.0 = ваниль, 1.5 = шире, 0.5 = тоньше. */
    private final float veinSize;

    // === ORES — список руд для этого биома (ResourceKey<PlacedFeature>) ===
    /** Список ore PlacedFeatures для биома. Применяется в BFMEChunkGenerator.applyOres(). */
    private final java.util.List<net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature>> ores;

    // === TERRAIN MODE / PATTERN LIST ===
    /** Режим расчёта рельефа. Дефолт LEGACY_12_WEIGHTS — обратная совместимость. */
    private final TerrainMode terrainMode;
    /** Список pattern'ов. Используется только в режиме PATTERN_LIST. Immutable. */
    private final List<PatternEntry> patterns;

    private BiomeTerrainProfile(Builder builder) {
        this.baseHeight = builder.baseHeight;
        // Noise weights (12 channels)
        this.noiseWeights = builder.noiseWeights.clone();
        this.heightCurve = builder.heightCurve;
        this.heightBias = builder.heightBias;
        this.clampMax = builder.clampMax;
        this.warpStrength = builder.warpStrength;
        this.erosionStrength = builder.erosionStrength;
        this.riverWaterHeight = builder.riverWaterHeight;
        this.riverTargetCarveDepth = builder.riverTargetCarveDepth;
        this.riverMinCarveDepth = builder.riverMinCarveDepth;
        this.riverCoreRadius = builder.riverCoreRadius;
        this.riverInfluenceRadius = builder.riverInfluenceRadius;
        this.noiseLacunarity = builder.noiseLacunarity;
        this.noisePersistence = builder.noisePersistence;
        this.noiseBaseScale = builder.noiseBaseScale;
        this.voronoiGridSize = builder.voronoiGridSize;
        this.voronoiWarpStrength = builder.voronoiWarpStrength;
        this.mountainChance = builder.mountainChance;
        this.peakHeightMin = builder.peakHeightMin;
        this.peakHeightMax = builder.peakHeightMax;
        this.mountainRadiusMin = builder.mountainRadiusMin;
        this.mountainRadiusMax = builder.mountainRadiusMax;
        this.allowedShapes = builder.allowedShapes;
        this.shapeWeights = builder.shapeWeights;
        // V12 optional features
        this.valleyModulationEnabled = builder.valleyModulationEnabled;
        this.valleyReliefFactor = builder.valleyReliefFactor;
        this.ridgeConnectionConfig = builder.ridgeConnectionConfig;
        this.peakVariationEnabled = builder.peakVariationEnabled;
        this.peakVariationAmplitude = builder.peakVariationAmplitude;
        this.caveSurfaceFadeDepth = builder.caveSurfaceFadeDepth;
        this.caveSurfaceFadeStrength = builder.caveSurfaceFadeStrength;
        this.cavesEnabled = builder.cavesEnabled;
        this.caveEntranceStrength = builder.caveEntranceStrength;
        this.caveMediumOffset = builder.caveMediumOffset;
        this.caveLargeOffset = builder.caveLargeOffset;
        this.caveSpag3DStrength = builder.caveSpag3DStrength;
        this.ironVeinsEnabled = builder.ironVeinsEnabled;
        this.silverVeinsEnabled = builder.silverVeinsEnabled;
        this.copperVeinsEnabled = builder.copperVeinsEnabled;
        this.veinRichness = builder.veinRichness;
        this.veinRawChance = builder.veinRawChance;
        this.veinDensity = builder.veinDensity;
        this.veinSize = builder.veinSize;
        this.ores = builder.ores;
        this.terrainMode = builder.terrainMode;
        this.patterns = builder.patterns.isEmpty()
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(builder.patterns));
    }

    // ========== TERRAIN MODE / PATTERNS ==========

    /** Режим расчёта рельефа: LEGACY_12_WEIGHTS (дефолт) или PATTERN_LIST. */
    public TerrainMode getTerrainMode() { return terrainMode; }

    /** Список pattern'ов (immutable). Пустой если режим LEGACY_12_WEIGHTS. */
    public List<PatternEntry> getPatterns() { return patterns; }

    /** Список ore PlacedFeatures для этого биома. */
    public java.util.List<net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature>> getOres() {
        return ores;
    }

    // ========== ГЕТТЕРЫ ==========

    public int getBaseHeight() { return baseHeight; }

    // Noise weight getters (12 channels)
    public float[] getNoiseWeights() { return noiseWeights.clone(); }
    /** Без clone — НЕ модифицировать возвращённый массив! Для hot path. */
    public float[] getNoiseWeightsRef() { return noiseWeights; }
    public float getNoiseWeight(int index) { return noiseWeights[index]; }
    public float getHeightCurve() { return heightCurve; }
    public float getHeightBias() { return heightBias; }
    public float getClampMax() { return clampMax; }
    public float getWarpStrength() { return warpStrength; }
    public float getErosionStrength() { return erosionStrength; }
    public float getRiverWaterHeight() { return riverWaterHeight; }
    public float getRiverTargetCarveDepth() { return riverTargetCarveDepth; }
    public float getRiverMinCarveDepth() { return riverMinCarveDepth; }
    public float getRiverCoreRadius() { return riverCoreRadius; }
    public float getRiverInfluenceRadius() { return riverInfluenceRadius; }

    public float getNoiseLacunarity() { return noiseLacunarity; }
    public float getNoisePersistence() { return noisePersistence; }
    public float getNoiseBaseScale() { return noiseBaseScale; }

    // Voronoi геттеры
    public int getVoronoiGridSize() { return voronoiGridSize; }
    public float getVoronoiWarpStrength() { return voronoiWarpStrength; }
    public float getMountainChance() { return mountainChance; }
    public float getPeakHeightMin() { return peakHeightMin; }
    public float getPeakHeightMax() { return peakHeightMax; }
    public float getMountainRadiusMin() { return mountainRadiusMin; }
    public float getMountainRadiusMax() { return mountainRadiusMax; }
    public MountainShape[] getAllowedShapes() { return allowedShapes; }
    public float[] getShapeWeights() { return shapeWeights; }

    public boolean usesVoronoiMountains() { return mountainChance > 0 && voronoiGridSize > 0; }

    // V12 optional features getters
    public boolean isValleyModulationEnabled() { return valleyModulationEnabled; }
    public float getValleyReliefFactor() { return valleyReliefFactor; }

    public boolean isRidgeConnectionsEnabled() { return ridgeConnectionConfig != null && !ridgeConnectionConfig.isEmpty(); }
    public RidgeConnectionConfig getRidgeConnectionConfig() { return ridgeConnectionConfig; }

    public boolean isPeakVariationEnabled() { return peakVariationEnabled; }
    public float getPeakVariationAmplitude() { return peakVariationAmplitude; }

    public float getCaveSurfaceFadeDepth() { return caveSurfaceFadeDepth; }
    public float getCaveSurfaceFadeStrength() { return caveSurfaceFadeStrength; }
    public boolean isCavesEnabled() { return cavesEnabled; }
    public boolean isIronVeinsEnabled()   { return ironVeinsEnabled; }
    public boolean isSilverVeinsEnabled() { return silverVeinsEnabled; }
    public boolean isCopperVeinsEnabled() { return copperVeinsEnabled; }
    public float getVeinRichness()  { return veinRichness; }
    public float getVeinRawChance() { return veinRawChance; }
    public float getVeinDensity()   { return veinDensity; }
    public float getVeinSize()      { return veinSize; }

    /** Готовый конфиг для передачи в BFMEVeinSampler. */
    public net.sima.bfme.worldgen.noise.VeinBiomeConfig getVeinConfig() {
        return new net.sima.bfme.worldgen.noise.VeinBiomeConfig(
                ironVeinsEnabled, silverVeinsEnabled, copperVeinsEnabled,
                veinRichness, veinRawChance, veinDensity, veinSize);
    }
    public float getCaveEntranceStrength() { return caveEntranceStrength; }
    /** Возвращает medium cheese offset для биома. Если не задан — глобальный CAVE_OFFSET. */
    public float getCaveMediumOffset() {
        return Float.isNaN(caveMediumOffset) ? net.sima.bfme.worldgen.noise.WorldNoiseGenerator.CAVE_OFFSET : caveMediumOffset;
    }
    /** Возвращает large cheese offset для биома. Если не задан — глобальный CAVE_OFFSET_LARGE. */
    public float getCaveLargeOffset() {
        return Float.isNaN(caveLargeOffset) ? net.sima.bfme.worldgen.noise.WorldNoiseGenerator.CAVE_OFFSET_LARGE : caveLargeOffset;
    }
    public float getCaveSpag3DStrength() { return caveSpag3DStrength; }

    // ========== DEBUG SETTERS (для /bfme profile команды) ==========

    public void setBaseHeight(int val) { this.baseHeight = val; }
    public void setNoiseWeight(int index, float val) {
        if (index >= 0 && index < NOISE_WEIGHT_COUNT) noiseWeights[index] = val;
    }
    public void setHeightCurve(float val) { this.heightCurve = val; }
    public void setWarpStrength(float val) { this.warpStrength = val; }
    public void setPeakVariationAmplitude(float val) {
        this.peakVariationAmplitude = val;
        this.peakVariationEnabled = val > 0;
    }

    // ========== BUILDER ==========

    public static class Builder {
        private int baseHeight = 70;

        // Noise weights: 4 types × 3 scales = 12. Амплитуды в блоках.
        private float[] noiseWeights = {0.6f, 0.3f, 0.1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
        private float heightCurve = 1.0f;    // 1.0 = без изменений
        private float heightBias = 0.0f;     // 0.0 = без смещения
        private float clampMax = 0.0f;       // 0.0 = без ограничения
        private float warpStrength = 0.0f;   // 0.0 = без warp
        private float erosionStrength = 0.0f; // 0.0 = без эрозии
        private float riverWaterHeight = 0f;       // 0 = биом не речной
        private float riverTargetCarveDepth = 20f; // желаемая глубина русла ниже воды
        private float riverMinCarveDepth = 5f;
        private float riverCoreRadius = 8f;        // ширина чистого русла
        private float riverInfluenceRadius = 120f; // зона влияния берега

        private float noiseLacunarity = 2.0f;
        private float noisePersistence = 0.5f;
        private float noiseBaseScale = 1.0f;

        // Voronoi параметры
        private int voronoiGridSize = 0;
        private float voronoiWarpStrength = 0f;
        private float mountainChance = 0f;
        private float peakHeightMin = 0f;
        private float peakHeightMax = 0f;
        private float mountainRadiusMin = 0f;
        private float mountainRadiusMax = 0f;
        private MountainShape[] allowedShapes = null;
        private float[] shapeWeights = null;

        // V12 optional features (all disabled by default)
        private boolean valleyModulationEnabled = false;
        private float valleyReliefFactor = 0.3f;  // Default: 30% relief in valleys
        private RidgeConnectionConfig ridgeConnectionConfig = null;  // null = disabled
        private boolean peakVariationEnabled = false;
        private float peakVariationAmplitude = 15f;  // Default: 15 blocks variation
        private float caveSurfaceFadeDepth = 15f;
        private float caveSurfaceFadeStrength = 0.3f;
        private boolean cavesEnabled = true;
        private float caveEntranceStrength = 1.0f;
        /** NaN = использовать глобальный CAVE_OFFSET (default). Иначе прямое значение. */
        private float caveMediumOffset = Float.NaN;
        /** NaN = использовать глобальный CAVE_OFFSET_LARGE (default). Иначе прямое значение. */
        private float caveLargeOffset = Float.NaN;
        private float caveSpag3DStrength = 1.0f;
        // Vein flags — по умолчанию все три включены, ваниль плотность ore
        private boolean ironVeinsEnabled   = true;
        private boolean silverVeinsEnabled = true;
        private boolean copperVeinsEnabled = true;
        private float veinRichness  = 1.0f;
        private float veinRawChance = 1.0f;
        private float veinDensity   = 1.0f;
        private float veinSize      = 1.0f;
        private java.util.List<net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature>> ores = java.util.List.of();

        // Pattern system (дефолт — LEGACY, пустой список pattern'ов).
        // Все существующие билдер-цепочки без addPattern продолжают работать как раньше.
        private TerrainMode terrainMode = TerrainMode.LEGACY_12_WEIGHTS;
        private final List<PatternEntry> patterns = new ArrayList<>();

        public Builder baseHeight(int val) { baseHeight = val; return this; }

        // Noise weight setters — individual type (distributes 60/30/10 across scales)
        public Builder simplexWeight(float val) {
            noiseWeights[W_SIMPLEX_L] = val * 0.6f; noiseWeights[W_SIMPLEX_M] = val * 0.3f; noiseWeights[W_SIMPLEX_S] = val * 0.1f; return this;
        }
        public Builder ridgeWeight(float val) {
            noiseWeights[W_RIDGE_L] = val * 0.6f; noiseWeights[W_RIDGE_M] = val * 0.3f; noiseWeights[W_RIDGE_S] = val * 0.1f; return this;
        }
        public Builder billowWeight(float val) {
            noiseWeights[W_BILLOW_L] = val * 0.6f; noiseWeights[W_BILLOW_M] = val * 0.3f; noiseWeights[W_BILLOW_S] = val * 0.1f; return this;
        }
        public Builder cellularWeight(float val) {
            noiseWeights[W_CELLULAR_L] = val * 0.6f; noiseWeights[W_CELLULAR_M] = val * 0.3f; noiseWeights[W_CELLULAR_S] = val * 0.1f; return this;
        }
        public Builder heightCurve(float val) { heightCurve = val; return this; }
        public Builder heightBias(float val) { heightBias = val; return this; }
        public Builder clampMax(float val) { clampMax = val; return this; }
        public Builder warpStrength(float val) { warpStrength = val; return this; }
        public Builder erosionStrength(float val) { erosionStrength = val; return this; }
        public Builder riverWaterHeight(float val) { riverWaterHeight = val; return this; }
        public Builder riverTargetCarveDepth(float val) { riverTargetCarveDepth = val; return this; }
        public Builder riverMinCarveDepth(float val) { riverMinCarveDepth = val; return this; }
        public Builder riverCoreRadius(float val) { riverCoreRadius = val; return this; }
        public Builder riverInfluenceRadius(float val) { riverInfluenceRadius = val; return this; }

        public Builder noiseLacunarity(float val) { noiseLacunarity = val; return this; }
        public Builder noisePersistence(float val) { noisePersistence = val; return this; }
        public Builder noiseBaseScale(float val) { noiseBaseScale = val; return this; }

        /**
         * Удобный метод: 4 веса → автораспределение по 3 масштабам (60/30/10).
         * @param simplex вес simplex (холмы)
         * @param ridge вес ridge (острые гребни)
         * @param billow вес billow (округлые формы)
         * @param cellular вес cellular (скалистые формы)
         */
        public Builder blendWeights(float simplex, float ridge, float billow, float cellular) {
            noiseWeights[W_SIMPLEX_L] = simplex * 0.6f; noiseWeights[W_SIMPLEX_M] = simplex * 0.3f; noiseWeights[W_SIMPLEX_S] = simplex * 0.1f;
            noiseWeights[W_RIDGE_L] = ridge * 0.6f; noiseWeights[W_RIDGE_M] = ridge * 0.3f; noiseWeights[W_RIDGE_S] = ridge * 0.1f;
            noiseWeights[W_BILLOW_L] = billow * 0.6f; noiseWeights[W_BILLOW_M] = billow * 0.3f; noiseWeights[W_BILLOW_S] = billow * 0.1f;
            noiseWeights[W_CELLULAR_L] = cellular * 0.6f; noiseWeights[W_CELLULAR_M] = cellular * 0.3f; noiseWeights[W_CELLULAR_S] = cellular * 0.1f;
            return this;
        }

        /**
         * Прямая установка всех 12 весов.
         * Порядок: [sL, sM, sS, rL, rM, rS, bL, bM, bS, cL, cM, cS]
         */
        public Builder noiseWeights(float... weights) {
            System.arraycopy(weights, 0, noiseWeights, 0, Math.min(weights.length, NOISE_WEIGHT_COUNT));
            return this;
        }

        // Voronoi сеттеры
        public Builder voronoiGridSize(int val) { voronoiGridSize = val; return this; }
        public Builder voronoiWarpStrength(float val) { voronoiWarpStrength = val; return this; }
        public Builder mountainChance(float val) { mountainChance = val; return this; }
        public Builder peakHeightRange(float min, float max) {
            peakHeightMin = min; peakHeightMax = max; return this;
        }
        public Builder mountainRadiusRange(float min, float max) {
            mountainRadiusMin = min; mountainRadiusMax = max; return this;
        }
        public Builder allowedShapes(MountainShape... shapes) { allowedShapes = shapes; return this; }
        public Builder shapeWeights(float... weights) { shapeWeights = weights; return this; }

        // V12 optional features setters
        public Builder valleyModulation(boolean enabled, float reliefFactor) {
            valleyModulationEnabled = enabled;
            valleyReliefFactor = reliefFactor;
            return this;
        }
        public Builder valleyModulation(boolean enabled) {
            valleyModulationEnabled = enabled;
            return this;
        }

        /**
         * Устанавливает конфигурацию хребтов между горами.
         * Используйте RidgeConnectionConfig.builder() для создания или пресеты.
         *
         * Пример:
         * .ridgeConnections(RidgeConnectionConfig.builder()
         *     .addLevel(1.2f, 0.85f, 0.70f)  // До 1.2 радиуса: 85% высоты, ширина 70%
         *     .addLevel(2.0f, 0.50f, 0.40f)  // До 2.0 радиусов: 50% высоты
         *     .build())
         *
         * Или используйте пресет:
         * .ridgeConnections(RidgeConnectionConfig.Presets.STANDARD_MOUNTAINS)
         */
        public Builder ridgeConnections(RidgeConnectionConfig config) {
            ridgeConnectionConfig = config;
            return this;
        }

        public Builder peakVariation(boolean enabled, float amplitude) {
            peakVariationEnabled = enabled;
            peakVariationAmplitude = amplitude;
            return this;
        }
        public Builder peakVariation(boolean enabled) {
            peakVariationEnabled = enabled;
            return this;
        }

        public Builder caveSurfaceFade(float depth, float strength) {
            caveSurfaceFadeDepth = depth;
            caveSurfaceFadeStrength = strength;
            return this;
        }
        public Builder cavesEnabled(boolean enabled) { cavesEnabled = enabled; return this; }
        /** Сила входов-шахт. 1.0 = ванильно, 0.5 = реже, 0.0 = почти нет (равнины), 1.5+ = больше (горы). */
        public Builder caveEntranceStrength(float val) { caveEntranceStrength = val; return this; }
        /** Прямое значение medium cheese offset. Меньше = больше пещер, больше = меньше. */
        public Builder caveMediumOffset(float val) { caveMediumOffset = val; return this; }
        /** Прямое значение large cheese offset. Меньше = большие залы чаще, больше = реже. */
        public Builder caveLargeOffset(float val) { caveLargeOffset = val; return this; }
        /** Множитель spag3D. 1.0 = ванильно, 0.0 = выкл, 1.5 = чаще. */
        public Builder caveSpag3DStrength(float val) { caveSpag3DStrength = val; return this; }

        // === VEIN FLAGS ===
        /** Разрешить iron veins (tuff/iron_ore) — по умолчанию true. */
        public Builder ironVeins(boolean enabled)   { ironVeinsEnabled = enabled; return this; }
        /** Разрешить silver veins (andesite/silver_ore) — по умолчанию true. */
        public Builder silverVeins(boolean enabled) { silverVeinsEnabled = enabled; return this; }
        /** Разрешить copper veins (granite/copper_ore) — по умолчанию true. */
        public Builder copperVeins(boolean enabled) { copperVeinsEnabled = enabled; return this; }
        /** Удобный shortcut: выключить все vein-флаги (для биомов без массивных жил). */
        public Builder noVeins() {
            ironVeinsEnabled = false;
            silverVeinsEnabled = false;
            copperVeinsEnabled = false;
            return this;
        }
        /** Удобный shortcut: разрешить только указанные типы (остальные false). */
        public Builder onlyVeins(boolean iron, boolean silver, boolean copper) {
            ironVeinsEnabled = iron;
            silverVeinsEnabled = silver;
            copperVeinsEnabled = copper;
            return this;
        }
        /**
         * Множитель плотности ore vs filler внутри жилы. 1.0 = ваниль (10-30% ore),
         * 0.0 = вся жила filler (нет ore), 2.0 = богатая жила (20-60% ore).
         * Применяется ко всем 3 типам vein (iron/silver/copper). Не влияет на геометрию.
         */
        public Builder veinRichness(float val) {
            if (val < 0f) val = 0f;
            veinRichness = val;
            return this;
        }
        /**
         * Множитель шанса raw_ore_block внутри ore. 1.0 = ваниль (2%), 0 = нет raw, 5.0 = 10%.
         * Влияет только на iron и copper (у silver raw_block нет).
         */
        public Builder veinRawChance(float val) {
            if (val < 0f) val = 0f;
            veinRawChance = val;
            return this;
        }
        /**
         * Множитель количества жил. 1.0 = ваниль (threshold 0.4), 1.5 = на 50% больше patches
         * (threshold 0.27), 0.5 = в 2 раза меньше (threshold 0.8). Может создать seams на границе биома.
         */
        public Builder veinDensity(float val) {
            if (val < 0.1f) val = 0.1f;
            veinDensity = val;
            return this;
        }
        /**
         * Множитель толщины жилы. 1.0 = ваниль (ridge_thickness 0.08), 1.5 = шире (0.12),
         * 0.5 = тоньше (0.04). Может создать seams на границе биома.
         */
        public Builder veinSize(float val) {
            if (val < 0f) val = 0f;
            veinSize = val;
            return this;
        }
        /**
         * Shortcut: умеренное увеличение всех 4 параметров для горных биомов.
         * intensity: 1=hills (+20%), 2=mountains (+30%), 3=peaks (+40%), 4=high peaks (+50%).
         * Применяется как множитель на все 4 числовых параметра.
         */
        public Builder mountainVeins(int intensity) {
            float bump = 1.0f + 0.1f * intensity;       // 1.1, 1.2, 1.3, 1.4, 1.5
            veinDensity   = bump;
            veinSize      = 1.0f + 0.05f * intensity;   // 1.05, 1.10, 1.15, 1.20, 1.25
            veinRichness  = bump;
            veinRawChance = 1.0f + 0.25f * intensity;   // 1.25, 1.5, 1.75, 2.0
            return this;
        }

        /** Список ore PlacedFeatures для биома. Используй preset методы ModOreFeatures.commonOres() и т.д. */
        public Builder ores(java.util.List<net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature>> oreList) {
            this.ores = oreList;
            return this;
        }

        // === PATTERN SYSTEM (Фаза 1: инфраструктура, реализации в Фазе 2) ===

        /** Явное переключение режима. По умолчанию LEGACY_12_WEIGHTS. */
        public Builder terrainMode(TerrainMode mode) {
            this.terrainMode = mode;
            return this;
        }

        /**
         * Добавить pattern в список. Автоматически переводит профиль в режим
         * {@link TerrainMode#PATTERN_LIST}: достаточно вызвать addPattern хотя бы
         * раз, отдельно вызывать terrainMode(PATTERN_LIST) не нужно.
         */
        public Builder addPattern(TerrainPattern type, float weight, PatternParams params) {
            this.patterns.add(new PatternEntry(type, weight, params));
            this.terrainMode = TerrainMode.PATTERN_LIST;
            return this;
        }

        public BiomeTerrainProfile build() { return new BiomeTerrainProfile(this); }
    }

    // ========== ПРЕСЕТЫ ==========

    public static class Presets {

        /** Равнины — мягкие округлые формы, очень низкий рельеф */
        public static final BiomeTerrainProfile V12_PLAINS = new Builder()
                .baseHeight(70)
                .blendWeights(4.5f, 0.0f, 10.5f, 0.0f)  // simplex 30%, billow 70%
                .warpStrength(0.2f)
                .build();

        /** Холмы — смесь стандартного и округлого рельефа */
        public static final BiomeTerrainProfile V12_HILLS = new Builder()
                .baseHeight(72)
                .blendWeights(18f, 3.6f, 14.4f, 0.0f)  // simplex 50%, ridge 10%, billow 40%
                .warpStrength(0.3f)
                .build();

        /** Горы — острые гребни доминируют */
        public static final BiomeTerrainProfile V12_MOUNTAINS = new Builder()
                .baseHeight(75)
                .blendWeights(14.4f, 50.4f, 7.2f, 0.0f)  // ridge 70%
                .warpStrength(0.5f)
                .heightCurve(1.3f)  // Острее вершины
                .build();

        /** Острые горные пики — максимум ridge */
        public static final BiomeTerrainProfile V12_SHARP_PEAKS = new Builder()
                .baseHeight(80)
                .blendWeights(9f, 76.5f, 4.5f, 0.0f)  // ridge 85%
                .warpStrength(0.6f)
                .heightCurve(1.5f)
                .build();

        /** Предгорья — переход между равнинами и горами */
        public static final BiomeTerrainProfile V12_FOOTHILLS = new Builder()
                .baseHeight(73)
                .blendWeights(16.8f, 12.6f, 12.6f, 0.0f)  // смесь всего
                .warpStrength(0.4f)
                .build();

        /** Mesa/Badlands — скалистые столовые горы */
        public static final BiomeTerrainProfile V12_MESA = new Builder()
                .baseHeight(75)
                .blendWeights(9.6f, 9.6f, 4.8f, 24f)  // cellular 50%
                .warpStrength(0.3f)
                .build();

        /** Badlands — более резкие скалистые формы */
        public static final BiomeTerrainProfile V12_BADLANDS = new Builder()
                .baseHeight(72)
                .blendWeights(8.1f, 16.2f, 0.0f, 29.7f)  // cellular + ridge
                .warpStrength(0.4f)
                .heightCurve(1.2f)
                .build();

        /** Плато — плоская вершина */
        public static final BiomeTerrainProfile V12_PLATEAU = new Builder()
                .baseHeight(85)
                .blendWeights(9.6f, 2.4f, 12f, 0.0f)
                .clampMax(25f)  // Ограничиваем высоту для плоской вершины
                .warpStrength(0.3f)
                .build();

        /** Болота — очень плоские с мелкой текстурой */
        public static final BiomeTerrainProfile V12_SWAMP = new Builder()
                .baseHeight(64)
                .blendWeights(1.8f, 0.0f, 7.2f, 0.0f)  // в основном billow
                .warpStrength(0.1f)
                .heightBias(-0.2f)  // Больше низин
                .build();
    }
}
