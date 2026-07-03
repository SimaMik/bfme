package net.sima.bfme.worldgen.terrain;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.features.ModOreFeatures;
import net.sima.bfme.worldgen.pattern.PatternParams;
import net.sima.bfme.worldgen.pattern.TerrainPattern;
import net.sima.bfme.worldgen.terrain.voronoi.MountainShape;
import net.sima.bfme.worldgen.terrain.voronoi.RidgeConnectionConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Реестр профилей биомов v6.0 — V12 Blend System
 *
 * Все биомы используют V12 систему шумов:
 * - simplex: стандартный рельеф
 * - ridge: острые гребни (горы)
 * - billow: округлые формы (равнины, холмы)
 * - cellular: скалистые выступы (badlands)
 */
public class BiomeProfileRegistry {

    private static BiomeProfileRegistry instance;
    private final Map<ResourceKey<Biome>, BiomeTerrainProfile> profiles = new HashMap<>();
    private Set<ResourceKey<Biome>> mountainBiomes = Set.of();
    private boolean initialized = false;

    private BiomeProfileRegistry() {}

    public static synchronized BiomeProfileRegistry getInstance() {
        if (instance == null) instance = new BiomeProfileRegistry();
        return instance;
    }

    public synchronized void initialize() {
        profiles.clear();
        mountainBiomes = Set.of();

        // =============================================================
        // RIVERS — очень плоские, почти без рельефа
        // =============================================================

        // === RIVERS — простые common ores ===
        profiles.put(BFMEBiomeKeys.RIVER_ANDUIN, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.commonOres())
                .baseHeight(66)                 // как окружение (было 35) — русло прорезает CARVE, не низкий base
                .noiseWeights(                  // спокойный рельеф — русло задаёт carve, не шум
                        4f, 2f, 0f,
                        0f, 0f, 0f,
                        2f, 1f, 0f,
                        0f, 0f, 0f
                )
                .warpStrength(0.3f)
                // riverWaterHeight НЕ задаём: река наследует уровень от рельефа вокруг (горы 90/равнина 70)
                // → вода плоская поперёк русла. Свой низкий уровень давал провал в центре = «шумовые линии».
                .riverTargetCarveDepth(20)
                .build());

        // ANDUIN_BANKS — пойма у воды: почти плоско, PLAINS_SMOOTH доминанта,
        // очень низкий amplitude (5), baseHeight 65 (у воды). centerMean 0.39 (PLAINS).
        profiles.put(BFMEBiomeKeys.ANDUIN_BANKS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.commonOres())
                .baseHeight(65)
                // riverWaterHeight НЕ задаём: банки наследуют уровень воды от рельефа (горы/равнина) → плоско поперёк
                .noiseWeights(                  // LEGACY — для отката
                        3f, 1.2f, 0.3f,
                        0f, 0f, 0f,
                        0.9f, 0.48f, 0.12f,
                        0f, 0f, 0f
                )
                .warpStrength(0.1f)
                .addPattern(TerrainPattern.PLAINS_SMOOTH, 0.8f, PatternParams.builder()
                        .scale(250).amplitude(5f).centerMean(0.39f).maskAlpha(0.45f).warpBig(256, 256f).build())
                .addPattern(TerrainPattern.PLAINS_LIVELY, 0.2f, PatternParams.builder()
                        .scale(280).amplitude(5f).centerMean(0.39f).maskAlpha(0.5f).warpBig(256, 256f).build())
                .build());
        // =============================================================
        // GONDOR CORE — равнины и поля
        // =============================================================

        // PELENNOR_PLAINS — ровные поля: PLAINS_SMOOTH доминанта, низкий amplitude (8),
        // baseHeight 70. Площе чем Lossarnach, выше чем пойма.
        profiles.put(BFMEBiomeKeys.PELENNOR_PLAINS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.plainsOres())
                .baseHeight(70)
                .riverWaterHeight(70)          // данные для блюра уровня воды реки
                .noiseWeights(                  // LEGACY — для отката
                        6f, 6f, 4f,
                        0f, 0f, 0f,
                        0f, 0f, 0f,
                        0f, 0f, 0f
                )
                .warpStrength(0.35f)
                // МАЛО ПЕЩЕР — спокойные обработанные поля
                .caveMediumOffset(0.44f)
                .caveLargeOffset(0.44f)
                .caveEntranceStrength(0.1f)            // минимум выходов на равнинах
                .caveSurfaceFade(35f, 0.6f)            // строгая защита поверхности
                .addPattern(TerrainPattern.PLAINS_SMOOTH, 0.7f, PatternParams.builder()
                        .scale(250).amplitude(8f).centerMean(0.39f).maskAlpha(0.45f).warpBig(256, 256f).build())
                .addPattern(TerrainPattern.PLAINS_LIVELY, 0.3f, PatternParams.builder()
                        .scale(280).amplitude(8f).centerMean(0.39f).maskAlpha(0.5f).warpBig(256, 256f).build())
                .build());


        // LOSSARNACH_FARMLANDS — мягкие волны: PLAINS_LIVELY доминанта, amplitude выше (15),
        // baseHeight 72. Самый «волнистый» из равнинных — заметно отличается от Pelennor.
        profiles.put(BFMEBiomeKeys.LOSSARNACH_FARMLANDS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.plainsOres())
                .baseHeight(72)
                .riverWaterHeight(70)          // данные для блюра уровня воды реки
                .noiseWeights(                  // LEGACY — для отката
                        7f, 2.8f, 0.56f,
                        0f, 0f, 0f,
                        14f, 2.8f, 0.84f,
                        0f, 0f, 0f
                )
                .warpStrength(0.2f)
                .caveEntranceStrength(0.15f)
                .caveSurfaceFade(30f, 0.55f)
                .addPattern(TerrainPattern.PLAINS_LIVELY, 0.6f, PatternParams.builder()
                        .scale(280).amplitude(15f).centerMean(0.39f).maskAlpha(0.5f).warpBig(256, 256f).build())
                .addPattern(TerrainPattern.PLAINS_SMOOTH, 0.4f, PatternParams.builder()
                        .scale(250).amplitude(15f).centerMean(0.39f).maskAlpha(0.45f).warpBig(256, 256f).build())
                .build());
        // === ANORIEN_OPEN_LANDS — пилот pattern-системы (Фаза 2) ===
        // Переведён на TerrainMode.PATTERN_LIST: рельеф внутри биома собирается из
        // Voronoi-ячеек 600×600 блоков, в каждой ячейке выбирается один из трёх
        // pattern'ов с указанными весами. Старые поля (noiseWeights, warpStrength)
        // остаются для совместимости / отката, но не используются в PATTERN_LIST режиме.
        // Швы на границах Voronoi-ячеек ожидаемы до Фазы 2.5 (combine через blend).
        profiles.put(BFMEBiomeKeys.ANORIEN_OPEN_LANDS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.plainsOres())
                .baseHeight(78)
                .riverWaterHeight(70)          // данные для блюра уровня воды реки
                .noiseWeights(                  // LEGACY-поля сохранены для отката
                        0f, 0f, 0f,
                        0f, 30f, 0f,
                        0f, 0f, 0f,
                        0f, 0f, 0f
                )
                .warpStrength(0.0f)
                .cavesEnabled(true)                    // ВРЕМЕННО включены для профилирования (был false для визуального теста pattern)
                .caveEntranceStrength(0.0f)            // шахты-входы всё ещё выкл (поверхность чистая)
                .caveSurfaceFade(40f, 1.0f)            // максимальная защита поверхности
                // Pattern-список (addPattern автоматически ставит terrainMode=PATTERN_LIST)
                // Centering: средние weirdness для каждого pattern найдены через WeirdnessStats:
                //   PLAINS_SMOOTH mean=0.388, min=0.007
                //   PLAINS_LIVELY mean=0.374, min=0.000
                //   HILLS_GENTLE  mean=0.350, min=0.058
                // centerMean подобран так что все три pattern имеют delta_mean ≈ +10, delta_min ≈ -3
                // → нет стенок ~15 блоков на границах patterns с разной amp.
                .addPattern(TerrainPattern.PLAINS_SMOOTH, 0.5f, PatternParams.builder()
                        .scale(250)
                        .amplitude(35f)
                        .centerMean(0.10f)         // → mean=+10.1, range [-3.3, +25.5]
                        .bias(-0.77f)              // RTF Plains intrinsic bias
                        .maskAlpha(0.45f)
                        .warpBig(256, 256f)
                        .build())
                .addPattern(TerrainPattern.PLAINS_LIVELY, 0.3f, PatternParams.builder()
                        .scale(280)
                        .amplitude(40f)            // снижено с 55 для match mean с другими
                        .centerMean(0.10f)         // → mean=+11.0, range [-4.0, +29.3]
                        .bias(-0.77f)
                        .maskAlpha(0.5f)
                        .warpBig(256, 256f)
                        .build())
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.2f, PatternParams.builder()
                        .scale(200)
                        .amplitude(50f)            // снижено с 85 для match mean
                        .centerMean(0.12f)         // → mean=+11.5, range [-3.1, +33.6]
                        .maskAlpha(0.5f)
                        .maskScale(400)
                        .warpSmall(30, 20f)
                        .warpBig(400, 200f)
                        .build())
                .build());
        // =============================================================
        // ITHILIEN — лесистые холмы
        // =============================================================

        // === ЛЕСА ГОНДОРА — pattern: HILLS_GENTLE (волнистые лесные холмы) + DALES (долины
        // между ними). centerMean даёт долинам опускаться ≈ −7 (сцепка с равнинами, без ям).
        // HILLS_GENTLE: scale/maskScale/maskAlpha/warp ДОЛЖНЫ совпадать с calc (200/400/0.5/30/400).
        profiles.put(BFMEBiomeKeys.NORTH_ITHILIEN, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.forestOres())
                .baseHeight(82)
                .noiseWeights(22f, 6f, 1.2f, 0f, 0f, 0f, 6f, 2.8f, 0.8f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.3f)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.6f, PatternParams.builder()
                        .scale(200).amplitude(26f).centerMean(0.337f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.DALES, 0.4f, PatternParams.builder()
                        .amplitude(26f).centerMean(0.269f).warpBig(300, 100f).build())
                .build());
        // South Ithilien — террасные лесистые холмы ближе к Эфель Дуат. HIGHLANDS(Torridonian)
        // даёт «пласты» (advancedTerrace), HILLS_GENTLE — мягкую лесную основу. По лору:
        // «terraces of climbing woods» (TTT). Поверхность зелёная (surface не зависит от профиля).
        // HIGHLANDS читает только amplitude/centerMean (масштабы/warp фиксированы RTF makeTorridonian).
        profiles.put(BFMEBiomeKeys.SOUTH_ITHILIEN, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.forestOres())
                .baseHeight(80)
                .noiseWeights(22f, 7.92f, 1.76f, 0f, 0f, 0f, 7.92f, 3.08f, 1.32f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.3f)
                // Сильная защита поверхности от пещерных выходов (сад Итилиэна — мало входов).
                .caveEntranceStrength(0.05f)           // минимум входов-выходов на поверхности
                .caveSurfaceFade(40f, 0.7f)            // глубокая строгая защита поверхности
                .caveMediumOffset(0.44f)
                .caveLargeOffset(0.44f)
                // Террасы видны только при высокой amplitude (RTF Torridonian = высокий рельеф).
                // amp 80 → шаг террасы ~6 бл, рельеф ~24. HIGHLANDS 0.85 — меньше размытия HILLS_GENTLE.
                .addPattern(TerrainPattern.HIGHLANDS, 0.6f, PatternParams.builder()
                        .amplitude(80f).centerMean(0.111f).terraceSlope(0.15f).build())  // 0.15 → плоские уровни, высота в ступенях
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.4f, PatternParams.builder()  // больше веса → заметные холмы
                        .scale(200).amplitude(95f).centerMean(0.142f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .build());

        profiles.put(BFMEBiomeKeys.GREY_WOOD, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.forestOres())
                .baseHeight(80)
                .noiseWeights(18f, 6.48f, 1.44f, 0f, 0f, 0f, 6.48f, 2.52f, 1.08f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.3f)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.6f, PatternParams.builder()
                        .scale(200).amplitude(24f).centerMean(0.360f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.DALES, 0.4f, PatternParams.builder()
                        .amplitude(24f).centerMean(0.292f).warpBig(300, 100f).build())
                .build());
        profiles.put(BFMEBiomeKeys.DRUADAN_FOREST, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.forestOres())
                .baseHeight(82)
                .noiseWeights(17.1f, 7.6f, 1.9f, 0f, 0f, 0f, 6.84f, 3.04f, 1.52f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.4f)
                // Дикий лес — самый рельефный из лесов (amp 32, 50/50)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.5f, PatternParams.builder()
                        .scale(200).amplitude(32f).centerMean(0.287f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.DALES, 0.5f, PatternParams.builder()
                        .amplitude(32f).centerMean(0.219f).warpBig(300, 100f).build())
                .build());
        // =============================================================
        // HILLS / TRANSITIONAL — переходные холмистые зоны
        // =============================================================
        // === ХОЛМЫ — более выраженный рельеф (выше amp, baseHeight) ===
        // Emyn Arnen: HILLS_GENTLE + FOOTHILLS (грубее поднимается). centerMean → долины ≈ −7.
        profiles.put(BFMEBiomeKeys.EMYN_ARNEN_HILLS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.hillsOres())
                .baseHeight(88)
                .noiseWeights(27.5f, 12.1f, 2.75f, 0f, 0f, 0f, 8.25f, 2.75f, 1.65f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.3f)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.6f, PatternParams.builder()
                        .scale(200).amplitude(36f).centerMean(0.262f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.FOOTHILLS, 0.4f, PatternParams.builder()
                        .scale(220).amplitude(36f).centerMean(0.195f).maskAlpha(0.5f).maskScale(400).warpSmall(40, 25f).warpBig(400, 200f).build())
                .erosionStrength(0.5f)
                .build());

        // Amon Din: маяковые холмы — HILLS_GENTLE + HILLS_SHARP (острые гребни). Самые высокие.
        profiles.put(BFMEBiomeKeys.AMON_DIN_HILLS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.hillsOres())
                .baseHeight(92)
                .noiseWeights(30f, 12f, 3f, 3f, 1.8f, 0f, 6f, 3f, 1.2f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.35f)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.55f, PatternParams.builder()
                        .scale(200).amplitude(40f).centerMean(0.243f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.HILLS_SHARP, 0.45f, PatternParams.builder()
                        .amplitude(40f).centerMean(0.230f).build())
                .erosionStrength(0.5f)
                .build());

        // Eilenach: торфяники вокруг Voronoi-пика. Pattern = мягкие моховые холмы
        // (HILLS_GENTLE + DALES, низкий amp 22), Voronoi даёт сам пик (не трогаю).
        profiles.put(BFMEBiomeKeys.EILENACH_MOORLANDS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.hillsOres())
                .baseHeight(85)
                .noiseWeights(17.5f, 6.3f, 1.4f, 2.8f, 1.4f, 0f, 3.5f, 1.4f, 0.7f, 0f, 0f, 0f)  // LEGACY
                .warpStrength(0.3f)
                .addPattern(TerrainPattern.HILLS_GENTLE, 0.6f, PatternParams.builder()
                        .scale(200).amplitude(22f).centerMean(0.386f).maskAlpha(0.5f).maskScale(400).warpSmall(30, 20f).warpBig(400, 200f).build())
                .addPattern(TerrainPattern.DALES, 0.4f, PatternParams.builder()
                        .amplitude(22f).centerMean(0.318f).warpBig(300, 100f).build())
                // Voronoi — создаёт сам пик Эйленаха
                .voronoiGridSize(300)
                .voronoiWarpStrength(40f)
                .mountainChance(0.7f)
                .peakHeightRange(80, 130)
                .mountainRadiusRange(100, 160)
                .allowedShapes(MountainShape.ALPINE, MountainShape.JAGGED)
                .shapeWeights(0.5f, 0.5f)
                .peakVariation(true, 20f)
                .erosionStrength(0.6f)
                .build());
        // =============================================================
        // WHITE MOUNTAINS FOOTHILLS — предгорья (2-й пилот pattern-системы)
        // =============================================================
        // PATTERN_LIST: combine FOOTHILLS (округлые увалы, доминанта) + HILLS_SHARP
        // (резкие холмы) внутри ячеек. Контрастный характер к Anórien (степь
        // SMOOTH-доминанта) для будущего теста Слоя 3 на границе биомов.
        // baseHeight 95 — между Anórien 78 и White Mountains 120.
        // centerMean = 0 (НЕ mean): рельеф колеблется В ОСНОВНОМ ВВЕРХ от базы.
        //   delta = weirdness*amp >= 0 → минимум ≈ база, НЕ проседает ниже степи.
        //   (Раньше cm=mean давал delta до -21/-26 → ямки на въезде, где база ещё ~78-85.)
        //   FOOTHILLS  (amp 48): delta [0,  +41], mean +14
        //   HILLS_SHARP(amp 50): delta [+2, +41], mean +18
        // LEGACY-поля (noiseWeights, warpStrength, valleyModulation) — для отката.
        profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.hillsOres())
                .baseHeight(95)
                .riverWaterHeight(80)           // уровень воды реки в предгорье (уклон: горы 90 → предгорье 80 → равнина 70)
                .noiseWeights(                  // LEGACY — сохранено для отката
                        15f, 20f, 5f,
                        5f, 10f, 8f,
                        9f, 9f, 5f,
                        0f, 0f, 0f
                )
                .warpStrength(0.35f)
                .valleyModulation(true, 0.4f)
                .caveMediumOffset(0.35f)
                .caveLargeOffset(0.35f)
                .caveEntranceStrength(0.9f)
                .caveSurfaceFade(18f, 0.45f)           // средняя защита
                .mountainVeins(1)                      // предгорья +20%
                // Pattern-список. scale/maskScale/maskAlpha/warp ДОЛЖНЫ совпадать с
                // теми, на которых считался centerMean (calc) — иначе паттерн поедет.
                // centerMean даёт дельте опускаться до ≈ −9: долины ВРЕЗАЮТСЯ и сцепляются
                // с равниной (нет сплошной стенки-кромки), но не пробивают ямы (worst-case
                // у границы base~78 − 9 = 69 ≈ уровень Pelennor, выше воды 64).
                .addPattern(TerrainPattern.FOOTHILLS, 0.6f, PatternParams.builder()
                        .scale(220)
                        .amplitude(48f)            // cm=0.19 → delta [−9,+32], mean +5
                        .centerMean(0.19f)
                        .maskAlpha(0.5f)
                        .maskScale(400)
                        .warpSmall(40, 25f)
                        .warpBig(400, 200f)
                        .build())
                .addPattern(TerrainPattern.HILLS_SHARP, 0.4f, PatternParams.builder()
                        // HILLS_SHARP = RTF makeHills2 (фикс. масштабы cubic128/perlin32/ridge512,
                        // warps 30/400) — scale/maskScale/maskAlpha/warp ИГНОРЯТСЯ, важны amp/cm.
                        .amplitude(50f)            // cm=0.235 → delta [−9,+25], mean +5
                        .centerMean(0.235f)
                        .build())
                .erosionStrength(0.8f)
                .build());

        // =============================================================
        // WHITE MOUNTAINS — основной хребет
        // =============================================================

        profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mountainOres())
                .baseHeight(100)
                .riverWaterHeight(90)           // уровень воды реки в горах (исток выше — уклон вниз по течению)
                .noiseWeights(
                        15f, 24f, 11f,     // simplex: крупные выпуклости на склонах
                        10f, 14f, 5f,     // ridge: острые гребни
                        0f, 9f, 1f,       // billow: чуть
                        0f, 11f, 4f          // cellular: скалы
                )
                .ridgeConnections(RidgeConnectionConfig.builder()
                        .addLevel(0.7f, 0.98f, 0.95f)
                        .addLevel(1.0f, 0.68f, 0.65f)
                        .build())
                .warpStrength(0.5f)
                .heightCurve(1.2f)
                // noiseLacunarity УБРАН — дефолт 2.0, без колонн на границе
                .valleyModulation(true, 0.3f)
                .peakVariation(true, 35f)
                // Voronoi — массивные горы
                .voronoiGridSize(230)
                .voronoiWarpStrength(70f)
                .mountainChance(1.0f)
                .peakHeightRange(140, 200)
                .mountainRadiusRange(210, 270)
                .allowedShapes(MountainShape.ALPINE)
                .shapeWeights(1.0f)
                .caveSurfaceFade(24f, 0.35f)            // глубокая защита: пробьёт только сильный cheese — редкие крупные прорези
                .caveMediumOffset(0.34f)
                .caveLargeOffset(0.34f)                // выше = реже огромные пещеры (0.30 прорезает горы насквозь)
                // entrance — оставляем дефолт (1.0). При 1.5+ шахты-входы превращают гору в выкусанный сыр.
                .mountainVeins(2)                      // горы +30%
                // MOUNTAIN_DETAIL — скальная фактура ПОВЕРХ Voronoi-макроформы (пики/хребты остаются).
                // Деталь склонов на pattern-пути → Слой 3 сшивает стык гора↔предгорье.
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(130).amplitude(80f).centerMean(0.42f).build())   // мельче+выше: больше скальных деталей
                .erosionStrength(1.0f)
                .build());
        // =============================================================
        // WHITE MOUNTAINS PEAKS
        // =============================================================

        profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS_PEAKS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mountainOres())
                .baseHeight(100)
                .riverWaterHeight(90)           // уровень воды реки в горах
                .noiseWeights(
                        28f, 16.8f, 5.6f,      // simplex: выпуклости на склонах
                        42f, 25.2f, 8.4f,      // ridge: острые гребни, доминирует
                        5.6f, 4.2f, 2.8f,      // billow: чуть
                        0f, 1.4f, 0f           // cellular: скалы
                )
                .warpStrength(0.5f)
                .heightCurve(1.3f)
                .valleyModulation(true, 0.25f)
                .peakVariation(true, 50f)
                // Voronoi — выше и уже чем WHITE_MOUNTAINS
                .voronoiGridSize(260)
                .voronoiWarpStrength(50f)
                .mountainChance(1.0f)
                .peakHeightRange(210, 300)
                .mountainRadiusRange(200, 300)
                .allowedShapes(MountainShape.ALPINE, MountainShape.JAGGED)
                .shapeWeights(0.7f, 0.3f)
                .ridgeConnections(RidgeConnectionConfig.builder()
                        .addLevel(0.7f, 0.95f, 0.90f)
                        .addLevel(1.0f, 0.65f, 0.60f)
                        .build())
                .caveSurfaceFade(24f, 0.5f)
                .mountainVeins(3)                      // пики +40%
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(115).amplitude(100f).centerMean(0.42f).build())
                .erosionStrength(1.0f)
                .build());

        profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS_HIGH_PEAKS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mountainOres())
                .baseHeight(100)
                .riverWaterHeight(90)           // уровень воды реки в горах
                .noiseWeights(
                        19.5f, 13f, 6.5f,      // simplex: выпуклости
                        45.5f, 26f, 10.4f,     // ridge: сильный — самые острые пики
                        3.9f, 2.6f, 2.6f,      // billow: минимум
                        0f, 2.6f, 0f           // cellular: скалы
                )
                .warpStrength(0.6f)
                .heightCurve(1.4f)
                .valleyModulation(true, 0.2f)
                .peakVariation(true, 60f)
                // Voronoi — самые высокие, узкие пики
                .voronoiGridSize(190)
                .voronoiWarpStrength(50f)
                .mountainChance(1.0f)
                .peakHeightRange(220, 350)
                .mountainRadiusRange(150, 230)
                .allowedShapes(MountainShape.ALPINE, MountainShape.JAGGED)
                .shapeWeights(0.6f, 0.4f)
                .ridgeConnections(RidgeConnectionConfig.builder()
                        .addLevel(0.7f, 0.90f, 0.85f)
                        .addLevel(1.0f, 0.60f, 0.55f)
                        .build())
                .caveSurfaceFade(24f, 0.5f)
                .mountainVeins(4)                      // высокие пики +50%
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(100).amplitude(120f).centerMean(0.42f).build())
                .erosionStrength(1.0f)
                .build());
        // =============================================================
        // SPECIAL: Cair Andros — остров
        // =============================================================
// === CAIR ANDROS — укреплённый остров в Андуине ===
        // CAIR_ANDROS — остров на Андуине: ровный, PLAINS пара сбалансирована (0.6/0.4),
        // amplitude низкий (9), baseHeight 67. Между поймой 65 и Pelennor 70.
        profiles.put(BFMEBiomeKeys.CAIR_ANDROS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.plainsOres())
                .baseHeight(67)
                .noiseWeights(                  // LEGACY — для отката
                        7.2f, 2.4f, 0.6f,
                        0f, 0f, 0f,
                        1.2f, 0.6f, 0f,
                        0f, 0f, 0f
                )
                .warpStrength(0.15f)
                .caveEntranceStrength(0.15f)
                .caveSurfaceFade(30f, 0.55f)
                .addPattern(TerrainPattern.PLAINS_SMOOTH, 0.6f, PatternParams.builder()
                        .scale(250).amplitude(9f).centerMean(0.39f).maskAlpha(0.45f).warpBig(256, 256f).build())
                .addPattern(TerrainPattern.PLAINS_LIVELY, 0.4f, PatternParams.builder()
                        .scale(280).amplitude(9f).centerMean(0.39f).maskAlpha(0.5f).warpBig(256, 256f).build())
                .build());

// === DAGORLAD WASTES — Битвенная Равнина ===
// КАНОН (Tolkien Gateway): плоская пыльная пустынная равнина к северу от Чёрных Врат,
// бесплодная, покрыта пеплом Ородруина + «холмы выжженной земли». ПЛОСКАЯ (не badlands —
// мезы противоречат лору). Pattern: STEPPE (сухая ровная) + FOOTHILLS (низкие пепельные бугры).
        profiles.put(BFMEBiomeKeys.DAGORLAD_WASTES, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mordorOres())
                .baseHeight(78)
                .noiseWeights(6f, 2.25f, 0.75f, 0f, 0f, 0f, 2.25f, 1.2f, 0.45f, 0.75f, 0.75f, 0.6f)  // LEGACY
                .warpStrength(0.2f)
                .caveEntranceStrength(0.15f)
                .caveSurfaceFade(30f, 0.55f)
                // Плоско: amp 12, centerMean=mean (delta ±~5, без глубоких долин — ровная равнина).
                .addPattern(TerrainPattern.STEPPE, 0.7f, PatternParams.builder()
                        .scale(250).amplitude(12f).centerMean(0.39f).maskAlpha(0.45f).warpBig(256, 200f).build())
                .addPattern(TerrainPattern.FOOTHILLS, 0.3f, PatternParams.builder()
                        .scale(220).amplitude(12f).centerMean(0.30f).maskAlpha(0.5f).maskScale(400).warpSmall(40, 25f).warpBig(400, 200f).build())
                .build());

// === GORGOROTH PLAINS — Высокое пустынное плато ===
// КАНОН (Tolkien Gateway): ВЫСОКОЕ плато северо-зап. Мордора, базальт и застывшая лава,
// пепел Ородруина; «лабиринты камня с множеством ям и трещин», истерзанная земля, расщелины.
// Pattern: PLATEAU (приподнятое террасное) + BADLANDS (трещиноватый камень-лабиринт, ямы).
        profiles.put(BFMEBiomeKeys.GORGOROTH_PLAINS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mordorOres())
                .baseHeight(95)
                .noiseWeights(5f, 2f, 1f, 1f, 0.6f, 0f, 2f, 1f, 0.6f, 3f, 2f, 1.8f)  // LEGACY
                .warpStrength(0.3f)
                .noisePersistence(0.6f)
                .caveEntranceStrength(0.2f)
                .caveSurfaceFade(28f, 0.5f)
                // amp 35, долины/ямы −7. PLATEAU/BADLANDS читают только amplitude/centerMean.
                .addPattern(TerrainPattern.PLATEAU, 0.55f, PatternParams.builder()
                        .amplitude(30f).centerMean(0.237f).build())   // чуть ниже плато
                .addPattern(TerrainPattern.BADLANDS, 0.45f, PatternParams.builder()
                        .amplitude(35f).centerMean(0.2f).build())
                .build());

// === EPHEL DUATH — Горы Тени, основной хребет ===
// Мрачная западная стена Мордора. Тёмные, угнетающие.
// Не округлые DOME — нужно JAGGED, угрожающие формы.
        profiles.put(BFMEBiomeKeys.EPHEL_DUATH, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mordorMountainOres())
                .baseHeight(90)
                .noiseWeights(
                        18f, 12f, 6f,          // simplex: фон
                        30f, 18f, 7.2f,        // ridge: острые хребты
                        3.6f, 3.6f, 2.4f,      // billow: минимум
                        6f, 7.2f, 6f           // cellular: скалистая мордорская текстура
                )
                .warpStrength(0.5f)
                .heightCurve(1.2f)
                // Voronoi
                .voronoiGridSize(150)
                .voronoiWarpStrength(70f)
                .mountainChance(0.8f)
                .peakHeightRange(140, 220)
                .mountainRadiusRange(120, 190)
                .allowedShapes(MountainShape.JAGGED, MountainShape.ALPINE)
                .shapeWeights(0.6f, 0.4f)
                .caveSurfaceFade(0f, 0f)
                .mountainVeins(2)                      // мордорские горы +30%
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(115).amplitude(90f).centerMean(0.42f).build())
                .erosionStrength(1.0f)
                .build());

// === EPHEL DUATH PEAKS ===
        profiles.put(BFMEBiomeKeys.EPHEL_DUATH_PEAKS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mordorMountainOres())
                .baseHeight(90)
                .noiseWeights(
                        16.8f, 11.2f, 7f,      // simplex
                        42f, 25.2f, 11.2f,     // ridge: острее
                        2.8f, 2.8f, 2.8f,      // billow
                        5.6f, 7f, 5.6f         // cellular: скалы
                )
                .warpStrength(0.55f)
                .heightCurve(1.3f)
                .peakVariation(true, 45f)
                // Voronoi
                .voronoiGridSize(170)
                .voronoiWarpStrength(65f)
                .mountainChance(0.9f)
                .peakHeightRange(180, 280)
                .mountainRadiusRange(130, 180)
                .allowedShapes(MountainShape.JAGGED, MountainShape.ALPINE)
                .shapeWeights(0.7f, 0.3f)
                .caveSurfaceFade(0f, 0f)
                .mountainVeins(3)                      // мордорские пики +40%
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(100).amplitude(110f).centerMean(0.42f).build())
                .erosionStrength(1.0f)
                .build());

// === EPHEL DUATH BLACK PEAKS — Чёрные Вершины ===
        profiles.put(BFMEBiomeKeys.EPHEL_DUATH_BLACK_PEAKS, new BiomeTerrainProfile.Builder()
                .ores(ModOreFeatures.mordorMountainOres())
                .baseHeight(90)
                .noiseWeights(
                        16f, 12.8f, 8f,        // simplex
                        56f, 32f, 12.8f,       // ridge: максимум — самые жёсткие формы
                        3.2f, 3.2f, 1.6f,      // billow: почти нет
                        4.8f, 6.4f, 3.2f       // cellular: скалы
                )
                .warpStrength(0.6f)
                .heightCurve(1.4f)
                .peakVariation(true, 60f)
                // Voronoi
                .voronoiGridSize(190)
                .voronoiWarpStrength(60f)
                .mountainChance(0.95f)
                .peakHeightRange(240, 380)
                .mountainRadiusRange(100, 170)
                .allowedShapes(MountainShape.JAGGED)
                .shapeWeights(1.0f)
                .caveSurfaceFade(0f, 0f)
                .mountainVeins(4)                      // чёрные пики +50%
                .addPattern(TerrainPattern.MOUNTAIN_DETAIL, 1.0f, PatternParams.builder()
                        .scale(90).amplitude(130f).centerMean(0.42f).build())
                .erosionStrength(1.0f)
                .build());

        // Кэшируем горные биомы
        Set<ResourceKey<Biome>> mtns = new HashSet<>();
        for (var entry : profiles.entrySet()) {
            if (entry.getValue().usesVoronoiMountains()) {
                mtns.add(entry.getKey());
            }
        }
        mountainBiomes = Set.copyOf(mtns);

        initialized = true;
        System.out.println("[BiomeProfileRegistry] V7.0 — " + profiles.size() + " profiles, " + mountainBiomes.size() + " mountain biomes");
    }

    public BiomeTerrainProfile getProfile(ResourceKey<Biome> biomeKey) {
        if (!initialized) initialize();
        if (biomeKey == null) return BiomeTerrainProfile.Presets.V12_PLAINS;
        BiomeTerrainProfile profile = profiles.get(biomeKey);
        if (profile == null) {
            return BiomeTerrainProfile.Presets.V12_PLAINS;
        }
        return profile;
    }

    public void registerProfile(ResourceKey<Biome> biomeKey, BiomeTerrainProfile profile) {
        profiles.put(biomeKey, profile);
    }

    public boolean hasProfile(ResourceKey<Biome> biomeKey) {
        return profiles.containsKey(biomeKey);
    }

    /** Все биомы, которые могут создавать Voronoi горы */
    public Set<ResourceKey<Biome>> getMountainBiomes() {
        if (!initialized) initialize();
        return mountainBiomes;
    }

    public boolean isMountainBiome(ResourceKey<Biome> biomeKey) {
        if (!initialized) initialize();
        return mountainBiomes.contains(biomeKey);
    }

    public void reset() {
        profiles.clear();
        mountainBiomes = Set.of();
        initialized = false;
    }
}
