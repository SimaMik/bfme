package net.sima.bfme.worldgen.chunkgen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomeSource;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomesData;
import net.sima.bfme.worldgen.terrain.BiomeProfileRegistry;
import net.sima.bfme.worldgen.terrain.BiomeTerrainProfile;
import net.sima.bfme.worldgen.chunkgen.map.BFMEHeightMapV11;
import net.sima.bfme.worldgen.map.BFMEMapRuntime;
import net.sima.bfme.worldgen.noise.BFMEAquiferSampler;
import net.sima.bfme.worldgen.noise.BFMEVeinSampler;
import net.sima.bfme.worldgen.noise.VeinInterpolator;
import net.sima.bfme.worldgen.noise.CaveInterpolator;
import net.sima.bfme.worldgen.noise.OpenSimplex2S;
import net.sima.bfme.worldgen.noise.WorldNoiseGenerator;
import net.sima.bfme.worldgen.surface.SurfaceConfig;
import net.sima.bfme.worldgen.surface.SurfaceConfigs;
import net.sima.bfme.worldgen.surface.SurfaceNoise;

import static net.sima.bfme.worldgen.map.BFMEMapConfigs.PIXEL_WEIGHT;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Главный генератор чанков BFME
 *
 * Pipeline:
 * 1. fillFromNoise → generateColumn() для каждого столбца
 *    - Bedrock → Deepslate → Stone → Surface → Patches
 *    - isCave() вырезает пещеры на каждом слое
 *    - Water fill ниже SEA_LEVEL
 *    - Cave biome декор (пол/потолок)
 *    - Snow
 * 2. buildSurface → пусто (всё в fillFromNoise)
 * 3. applyCarvers → пусто (кастомная система пещер)
 */
public class BFMEChunkGenerator extends ChunkGenerator {

    // === Константы мира ===
    public static final int MIN_Y = -192;
    public static final int MAX_Y = 448;
    public static final int SEA_LEVEL = 64;

    // Пещеры у реки: чаще в долине (на ЗЕМЛЕ — стены/берега), но дно реки снизу не прорезаем.
    private static final boolean RIVER_CAVE_BOOST_ENABLED = false;
    private static final float RIVER_CAVE_BONUS_DIST = 40f;   // блоки от реки — где бустим пещеры в долине
    private static final float RIVER_CAVE_BONUS_MULT = 1.5f;  // множитель entranceStrength у реки (на земле)
    private static final int RIVER_BED_CAVE_PROTECT = 6;      // блоки солидной пробки под дном реки (вода не утечёт)

    /** Толщина плоского бедрока на дне мира. 2 блока чтобы исключить
     *  возможность провалиться через одиночный бедрок. */
    public static final int BEDROCK_LAYERS = 2;

    public static final int LAVA_LEVEL = -178;

    /** Граница где deepslate уже точно есть (ниже этой Y — всё deepslate). */
    public static final int DEEPSLATE_TOP = 0;

    /** Граница где stone уже точно есть (выше этой Y — всё stone). */
    public static final int STONE_BLEND_HEIGHT = 16;

    /** Seed-смещение для noise который выбирает blend deepslate/stone.
     *  Не должен пересекаться с другими noise seeds в проекте. */
    private static final long DEEPSLATE_BLEND_SEED_OFFSET = 90100L;

    /** Частота noise для blend. Period ~32 блока (XZ) → связные пятна
     *  одного блока размером ~16 блоков в плане. Выглядит органично. */
    private static final double DEEPSLATE_BLEND_FREQ = 1.0 / 32.0;

    // === CODEC ===
    public static final MapCodec<BFMEChunkGenerator> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    BFMEBiomeSource.MAP_CODEC.fieldOf("bfme_biome_source").forGetter(gen -> gen.bfmeBiomeSource)
            ).apply(instance, BFMEChunkGenerator::new)
    );

    private final BFMEBiomeSource bfmeBiomeSource;
    private final BFMEMapRuntime mapRuntime;
    private final BFMEHeightMapV11 heightMapV11;
    private final WorldNoiseGenerator noise = WorldNoiseGenerator.getInstance();
    // Кэшируем синглтоны в поля — их getInstance() это synchronized static (монитор класса).
    // Вызов в per-column hot-path сериализовал бы worldgen-потоки. Инстанс стабилен → кэш безопасен.
    private final SurfaceNoise surfaceNoise = SurfaceNoise.getInstance();
    private final BiomeProfileRegistry profileRegistry = BiomeProfileRegistry.getInstance();

    /**
     * DEBUG: визуализация Voronoi pattern-ячеек. Когда true — верхний блок PATTERN_LIST-биома
     * заменяется цветным бетоном по типу выбранного pattern:
     *   PLAINS_SMOOTH → белый, PLAINS_LIVELY → жёлтый, HILLS_GENTLE → красный, mixed → оранжевый.
     * Сверху видны формы ячеек и их границы (проверка извилистости после warp).
     * Переключить здесь (одна константа). По умолчанию false.
     */
    public static final boolean VISUALIZE_CELLS = false;

    /**
     * DEBUG: профилирование генерации (поэтапные тайминги). static final → при false
     * JIT вычищает инструментацию (нулевой overhead). true → каждые 200 чанков печать
     * разбивки heightmap/caves/surface + per-biome в System.out (см. {@link GenProfiler}).
     */
    public static final boolean PROFILE_GEN = false;

    // === DIAG: column-разбор (A/B — выключи компонент, сравни стадию column между прогонами).
    // Cave-компоненты togglятся в WorldNoiseGenerator (CHEESE_MEDIUM/LARGE_ENABLED,
    // CARVER_SPAG2D/SPAG3D/NOODLE/ENTRANCE_ENABLED, PILLARS_ENABLED) → влияют на cave-setup/cave-fill.
    /** Тупая заливка stone minY..surface, БЕЗ surface-config/cave/vein/aquifer/slope/snow/water → baseline чистой записи. */
    public static final boolean DIAG_DUMB_FILL = false;  // нормальная генерация поверхности (пещеры/снег/палитра). true = чистый камень + раскраска эрозии для отладки
    /** computeVein не вызывается, кладём stone слоя → стоимость vein = (full − этот прогон). */
    public static final boolean DIAG_SKIP_VEIN = false;
    /** computeSubstance не вызывается, cave-блоки = AIR (не пишем) → стоимость aquifer. */
    public static final boolean DIAG_SKIP_AQUIFER = false;
    /** getSlopeAngle возвращает 0 (без 8× getHeight) → стоимость slope-сэмплинга. */
    public static final boolean DIAG_SKIP_SLOPE = false;

    private long worldSeed = 0L;
    private boolean seedInitialized = false;

    public BFMEChunkGenerator(BFMEBiomeSource biomeSource) {
        super(biomeSource, biome -> biome.value().getGenerationSettings());
        this.bfmeBiomeSource = biomeSource;
        this.mapRuntime = BFMEMapRuntime.getInstance();
        this.heightMapV11 = BFMEHeightMapV11.getInstance();
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return MAP_CODEC;
    }

    private synchronized void ensureSeedInitialized(RandomState randomState) {
        if (!seedInitialized) {
            PositionalRandomFactory factory = randomState.getOrCreateRandomFactory(
                    ResourceLocation.fromNamespaceAndPath("bfme", "seed_extract")
            );
            this.worldSeed = factory.at(0, 0, 0).nextLong();

            this.heightMapV11.initialize(worldSeed);
            this.heightMapV11.setBiomeSource(bfmeBiomeSource);
            surfaceNoise.initialize(worldSeed);

            this.seedInitialized = true;
            bfmeBiomeSource.initCaveSeed(worldSeed);
            System.out.println("[BFMEChunkGenerator] Seed: " + worldSeed);
        }
    }

    private int getHeight(int x, int z) {
        return heightMapV11.getHeight(x, z);
    }

    private float getSlopeAngle(int x, int z) {
        // было: getHeight (int, floor) → ступеньки → шум
        // стало: getBaseHeight (float) → гладкая производная
        float dx = (heightMapV11.getBaseHeight(x+2,z) + heightMapV11.getBaseHeight(x+1,z)
                - heightMapV11.getBaseHeight(x-1,z) - heightMapV11.getBaseHeight(x-2,z)) / 4f;
        float dz = (heightMapV11.getBaseHeight(x,z+2) + heightMapV11.getBaseHeight(x,z+1)
                - heightMapV11.getBaseHeight(x,z-1) - heightMapV11.getBaseHeight(x,z-2)) / 4f;
        float gradient = (float) Math.sqrt(dx*dx + dz*dz) / 2f;
        return (float) Math.toDegrees(Math.atan(gradient));
    }

    /**
     * Решает какой блок ставить в зоне blend [DEEPSLATE_TOP .. STONE_BLEND_HEIGHT].
     *
     * Использует coherent noise (OpenSimplex) вместо white noise (Random) — даёт
     * связные пятна одного блока вместо визуального шума. Threshold смещается
     * линейно по Y: внизу почти всё deepslate, вверху почти всё stone.
     */
    private boolean isStoneInBlendZone(int worldX, int y, int worldZ) {
        // Линейный bias по Y: -1 на дне blend zone (deepslate), +1 наверху (stone)
        double yProgress = (double)(y - DEEPSLATE_TOP) / (STONE_BLEND_HEIGHT - DEEPSLATE_TOP);
        double bias = yProgress * 2.0 - 1.0;  // [-1, +1]

        // Coherent noise [-0.866, +0.866]
        double n = OpenSimplex2S.noise3_ImproveXY(
                worldSeed + DEEPSLATE_BLEND_SEED_OFFSET,
                worldX * DEEPSLATE_BLEND_FREQ,
                worldZ * DEEPSLATE_BLEND_FREQ,
                y * DEEPSLATE_BLEND_FREQ * 0.5);  // Y чуть медленнее → пятна вытянуты вертикально

        // Stone если noise + bias > 0
        return (n + bias) > 0;
    }

    // ============================================================
    // CHUNK GENERATION
    // ============================================================

    @Override
    public CompletableFuture<ChunkAccess> createBiomes(
            RandomState randomState,
            Blender blender,
            StructureManager structureManager,
            ChunkAccess chunk) {
        ensureSeedInitialized(randomState);
        return super.createBiomes(randomState, blender, structureManager, chunk);
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(
            Blender blender, RandomState randomState,
            StructureManager structureManager, ChunkAccess chunk) {

        ensureSeedInitialized(randomState);

        ChunkPos chunkPos = chunk.getPos();
        int startX = chunkPos.getMinBlockX();
        int startZ = chunkPos.getMinBlockZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        long _chunkT0 = PROFILE_GEN ? System.nanoTime() : 0L;
        long _t = PROFILE_GEN ? System.nanoTime() : 0L;

        // Предвычисляем высоты и per-biome cave параметры для всего чанка с biome smoothing.
        // Sample biome в 3×3 точках вокруг каждой column (offset 4 блока), gaussian weights.
        int[][] surfaceHeights = new int[16][16];
        float[][] entranceStrengths = new float[16][16];
        float[][] mediumOffsets = new float[16][16];
        float[][] largeOffsets = new float[16][16];
        float[][] spag3DStrengths = new float[16][16];
        float[][] surfaceFadeDepths = new float[16][16];
        float[][] surfaceFadeStrengths = new float[16][16];
        float[][] aquiferFloodednessBias = new float[16][16];
        float[][] aquiferLavaChance = new float[16][16];
        // Gaussian 3x3 weights: corners=1, edges=2, center=4 (sum=16)
        final int SAMPLE_OFFSET = 4;
        final int[][] WEIGHTS = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };
        final float WEIGHT_SUM = 16f;
        for (int lx = 0; lx < 16; lx++) {
            for (int lz = 0; lz < 16; lz++) {
                int worldX = startX + lx;
                int worldZ = startZ + lz;
                surfaceHeights[lx][lz] = Mth.floor(getHeight(worldX, worldZ));

                // Sample biome at 9 points (3×3) for smoothing
                float entSum = 0f, medSum = 0f, lgSum = 0f, s3dSum = 0f;
                float fadeDSum = 0f, fadeStrSum = 0f;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        int sampleX = worldX + dx * SAMPLE_OFFSET;
                        int sampleZ = worldZ + dz * SAMPLE_OFFSET;
                        BFMEBiome b = mapRuntime.getBiome(sampleX, sampleZ);
                        BiomeTerrainProfile p = profileRegistry.getProfile(
                                b != null ? b.biome : null);
                        int w = WEIGHTS[dx + 1][dz + 1];
                        entSum += p.getCaveEntranceStrength() * w;
                        medSum += p.getCaveMediumOffset() * w;
                        lgSum  += p.getCaveLargeOffset() * w;
                        s3dSum += p.getCaveSpag3DStrength() * w;
                        fadeDSum += p.getCaveSurfaceFadeDepth() * w;
                        fadeStrSum += p.getCaveSurfaceFadeStrength() * w;
                    }
                }
                entranceStrengths[lx][lz]   = entSum / WEIGHT_SUM;
                mediumOffsets[lx][lz]       = medSum / WEIGHT_SUM;
                largeOffsets[lx][lz]        = lgSum / WEIGHT_SUM;
                spag3DStrengths[lx][lz]     = s3dSum / WEIGHT_SUM;
                surfaceFadeDepths[lx][lz]   = fadeDSum / WEIGHT_SUM;
                surfaceFadeStrengths[lx][lz] = fadeStrSum / WEIGHT_SUM;
                // Буст пещер в долине реки (на ЗЕМЛЕ — стены/берега, где красиво). НЕ под дном (surf<вода).
                if (RIVER_CAVE_BOOST_ENABLED && surfaceHeights[lx][lz] >= SEA_LEVEL
                        && heightMapV11.getRiverDistBlocks(worldX, worldZ) <= RIVER_CAVE_BONUS_DIST) {
                    entranceStrengths[lx][lz] *= RIVER_CAVE_BONUS_MULT;
                }
                // Aquifer per-biome (пока default — step 4 добавит per-biome тюнинг)
                aquiferFloodednessBias[lx][lz] = 0.0f;
                aquiferLavaChance[lx][lz]      = 1.0f;
            }
        }
        if (PROFILE_GEN) { GenProfiler.recordStage(GenProfiler.HEIGHTMAP, System.nanoTime() - _t); _t = System.nanoTime(); }

        // Aquifer sampler — заменяет глобальный LAVA_LEVEL fill на ванильную логику
        BFMEAquiferSampler.FluidPicker aquiferPicker =
                BFMEAquiferSampler.createDefaultPicker(SEA_LEVEL, LAVA_LEVEL);
        BFMEAquiferSampler aquifer = new BFMEAquiferSampler(
                noise, chunkPos, surfaceHeights,
                WorldNoiseGenerator.CAVE_MIN_Y,
                WorldNoiseGenerator.CAVE_MAX_Y - WorldNoiseGenerator.CAVE_MIN_Y,
                worldSeed, aquiferPicker,
                aquiferFloodednessBias, aquiferLavaChance);

        // Vein sampler — гигантские жилы iron/silver/copper.
        // Sampler stateless, interpolator на cellGrid 4×4×8 для veininess/vein_a/vein_b (1:1 ваниль).
        BFMEVeinSampler veinSampler = new BFMEVeinSampler(noise, worldSeed);
        VeinInterpolator veinInterpolator = new VeinInterpolator(noise, chunkPos.x, chunkPos.z);

        // Создаём интерполятор — предвычисляет сетку density
        CaveInterpolator caveInterpolator = new CaveInterpolator(noise, chunkPos.x, chunkPos.z, surfaceHeights,
                entranceStrengths, mediumOffsets, largeOffsets, spag3DStrengths,
                surfaceFadeDepths, surfaceFadeStrengths);

        // Flood-fill: собираем карту пещер, удаляем летающие островки
        int caveMinY = WorldNoiseGenerator.CAVE_MIN_Y;
        int caveMaxY = WorldNoiseGenerator.CAVE_MAX_Y;
        int caveHeight = caveMaxY - caveMinY;
        boolean[][][] isCaveBlock = new boolean[16][16][caveHeight];
        if (PROFILE_GEN) { GenProfiler.recordStage(GenProfiler.CAVE_SETUP, System.nanoTime() - _t); _t = System.nanoTime(); }

        // ОПТИМИЗАЦИЯ: isCave (3D-шум) считается ТОЛЬКО ниже/на поверхности (необходимо — пещеры
        // -190..surface полностью сохранены). Весь регион ВЫШЕ поверхности = воздух → bulk
        // Arrays.fill(true) вместо ручного цикла ~230-340 итераций с веткой на столбец.
        // Arrays.fill векторизован (memset-подобный) — быстрее поэлементного, инвариант сохранён.
        for (int lx = 0; lx < 16; lx++) {
            for (int lz = 0; lz < 16; lz++) {
                int surfH = surfaceHeights[lx][lz];
                int belowEnd = Math.min(surfH, caveMaxY - 1);   // последний y ≤ surf в пределах массива
                boolean[] col = isCaveBlock[lx][lz];            // hoist под-массив колонны (1 деереф вместо 3 на запись)
                for (int y = caveMinY; y <= belowEnd; y++) {
                    col[y - caveMinY] = caveInterpolator.isCave(lx, lz, y, surfH);
                }
                // Выше поверхности — воздух, bulk-заполнение (без noise, без поэлементной ветки).
                int airStartYi = Math.max(0, belowEnd + 1 - caveMinY);
                if (airStartYi < caveHeight) {
                    java.util.Arrays.fill(col, airStartYi, caveHeight, true);
                }
            }
        }

        if (PROFILE_GEN) { GenProfiler.recordStage(GenProfiler.CAVE_FILL, System.nanoTime() - _t); _t = System.nanoTime(); }

        // Erosion pass: блоки с 6 air соседями (полностью изолированные) → cave.
        // Граница чанка считается air. Делается ДО декораций.
        for (int lx = 0; lx < 16; lx++) {
            for (int lz = 0; lz < 16; lz++) {
                boolean[] col = isCaveBlock[lx][lz];   // центр-колонна (yi, yi±1) — 1 деереф
                for (int yi = 0; yi < caveHeight; yi++) {
                    if (col[yi]) continue; // уже cave

                    // Проверяем 6 соседей. Out-of-chunk и out-of-Y трактуем как air.
                    boolean airUp    = (yi == caveHeight - 1) || col[yi + 1];
                    boolean airDown  = (yi == 0)              || col[yi - 1];
                    boolean airXPlus = (lx == 15)             || isCaveBlock[lx + 1][lz][yi];
                    boolean airXMin  = (lx == 0)              || isCaveBlock[lx - 1][lz][yi];
                    boolean airZPlus = (lz == 15)             || isCaveBlock[lx][lz + 1][yi];
                    boolean airZMin  = (lz == 0)              || isCaveBlock[lx][lz - 1][yi];

                    if (airUp && airDown && airXPlus && airXMin && airZPlus && airZMin) {
                        col[yi] = true;
                    }
                }
            }
        }

        if (PROFILE_GEN) { GenProfiler.recordStage(GenProfiler.CAVE_EROSION, System.nanoTime() - _t); _t = System.nanoTime(); }

        // Защита дна реки: под руслом (поверхность ниже воды у реки) НЕ режем пещеры на
        // RIVER_BED_CAVE_PROTECT блоков вглубь — солидная пробка, чтобы вода не утекала в пещеру.
        for (int lx = 0; lx < 16; lx++) {
            for (int lz = 0; lz < 16; lz++) {
                int surfH = surfaceHeights[lx][lz];
                if (surfH >= SEA_LEVEL) continue;                   // не дно реки (выше воды)
                if (heightMapV11.getRiverDistBlocks(startX + lx, startZ + lz)
                        > heightMapV11.getRiverInfluenceRadius()) continue;
                boolean[] col = isCaveBlock[lx][lz];
                int protectBottom = Math.max(caveMinY, surfH - RIVER_BED_CAVE_PROTECT);
                int top = Math.min(surfH, caveMaxY - 1);
                for (int y = protectBottom; y <= top; y++) {
                    col[y - caveMinY] = false;                      // солид под дном
                }
            }
        }

        // Pre-create unprimed WG heightmaps (как vanilla doFill): глубокие base-блоки пишутся
        // прямо в секцию (section.setBlockState) и НЕ трогают heightmap; near-surface блоки
        // (undersurface/surface/water/snow) идут через chunk.setBlockState и поддерживают эти
        // heightmap'ы автоматически. Pre-create избегает дорогого prime на первом setBlockState.
        chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
        chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);

        // Bulk-заливка однородных cave-free секций вне vein-полосы (palette single-value, 1 op
        // вместо 4096 записей). generateColumn пропустит их Y (bare continue). Carve в них НЕ идёт
        // (cave-free) → resize-storm нет. Выигрыш на высоких колоннах (White Mountains: камень >Y=50).
        boolean[] secBulk = bulkFillCaveFreeSections(chunk, surfaceHeights, startX, startZ, isCaveBlock, caveMinY, caveMaxY);

        for (int localX = 0; localX < 16; localX++) {
            for (int localZ = 0; localZ < 16; localZ++) {
                int worldX = startX + localX;
                int worldZ = startZ + localZ;

                int surfaceHeight = surfaceHeights[localX][localZ];
                BFMEBiome biome = mapRuntime.getBiome(worldX, worldZ);

                generateColumn(chunk, pos, localX, localZ, worldX, worldZ, surfaceHeight, biome, caveInterpolator, isCaveBlock, caveMinY, aquifer, veinSampler, veinInterpolator, secBulk);
            }
        }

        if (PROFILE_GEN) {
            GenProfiler.recordStage(GenProfiler.COLUMN, System.nanoTime() - _t);
            BFMEBiome centerBiome = mapRuntime.getBiome(startX + 8, startZ + 8);
            String biomeKey = centerBiome != null ? centerBiome.getKey().toString() : "null";
            GenProfiler.chunkDone(biomeKey, System.nanoTime() - _chunkT0);
        }

        return CompletableFuture.completedFuture(chunk);
    }

    // ============================================================
    // COLUMN GENERATION
    // ============================================================

    // caveColumn = isCaveBlock[localX][localZ] — захойщен раз на колонну (1 деереф вместо 5 на вызов).
    private boolean isCaveAt(boolean cavesEnabled, boolean[] caveColumn, int caveMinY, int y) {
        if (!cavesEnabled) return false;
        int yi = y - caveMinY;
        if (yi < 0 || yi >= caveColumn.length) return false;
        return caveColumn[yi];
    }

    /**
     * Размещает aquifer-блок ПРЯМО в секцию (вода/лава/barrier=stone). Воздух НЕ пишем
     * (секция стартует пустой — vanilla doFill путь, без resize/lock-overhead).
     * Использует финальную cave density (min из cheese/carver/noodle) как substance —
     * это даёт правильное поведение barriers для всех типов пещер (ваниль final_density).
     */
    private void placeAquiferBlock(ChunkAccess chunk, LevelChunkSection section, BlockPos.MutableBlockPos pos,
                                    int localX, int y, int localZ,
                                    int worldX, int worldZ,
                                    CaveInterpolator caveInterpolator,
                                    BFMEAquiferSampler aquifer,
                                    BlockState stoneBlockForLayer) {
        if (DIAG_SKIP_AQUIFER) return;                                     // diag: cave=AIR, не считаем aquifer
        double density = caveInterpolator.getFinalCaveDensity(localX, localZ, y);
        BlockState fill = aquifer.computeSubstance(worldX, y, worldZ, density);
        if (fill == null) {
            // BARRIER — камень между аквиферами (или substance + pressure > 0)
            section.setBlockState(localX, y & 15, localZ, stoneBlockForLayer, false);
        } else if (!fill.isAir()) {
            section.setBlockState(localX, y & 15, localZ, fill, false);
            // Для воды/лавы на границе — пометить для fluid tick (растекание)
            if (!fill.getFluidState().isEmpty() && aquifer.shouldScheduleFluidUpdate()) {
                chunk.markPosForPostprocessing(pos.set(localX, y, localZ));
            }
        }
        // fill.isAir() → пропускаем (воздух не пишем)
    }

    /**
     * Размещает stone-блок (или mineral vein) ПРЯМО в секцию.
     * Если в позиции есть жила (iron/silver/copper) — ставит соответствующий vein block,
     * иначе — обычный stone слоя.
     */
    private void placeStoneOrVein(LevelChunkSection section,
                                   int localX, int y, int localZ,
                                   int worldX, int worldZ,
                                   BFMEVeinSampler veinSampler,
                                   VeinInterpolator veinInterp,
                                   net.sima.bfme.worldgen.noise.VeinBiomeConfig veinConfig,
                                   BlockState stoneBlockForLayer) {
        BlockState veinBlock = DIAG_SKIP_VEIN ? null
                : veinSampler.computeVein(worldX, localX, y, worldZ, localZ, veinInterp, veinConfig);
        section.setBlockState(localX, y & 15, localZ, veinBlock != null ? veinBlock : stoneBlockForLayer, false);
    }

    /**
     * Bulk-заливка однородных cave-free секций ВНЕ vein-полосы через palette single-value
     * (1 операция вместо 4096 section.setBlockState). Возвращает secBulk[idx] — залитые секции
     * (generateColumn пропускает их Y через bare continue).
     *
     * Eligible секция: строго ниже minSurf−8 (heightmap кладётся near-surface поблочно),
     * не bedrock, не deepslate↔stone blend, НЕ пересекает vein-полосу [−170,50] (там нужны
     * руды per-block), чистый deepslate ИЛИ один stone-band (singleBiome + не straddle upperStone),
     * и БЕЗ пещер (скан isCaveBlock). Cave-free → carve в неё не идёт → нет resize-storm палитры.
     *
     * Безопасность: секции глубокие; биомы сохранены (old.getBiomes()); recalcBlockCounts() обязателен.
     */
    private boolean[] bulkFillCaveFreeSections(ChunkAccess chunk, int[][] surfaceHeights, int startX, int startZ,
                                               boolean[][][] isCaveBlock, int caveMinY, int caveMaxY) {
        int sectionsCount = chunk.getSections().length;
        boolean[] secBulk = new boolean[sectionsCount];
        int caveHeight = caveMaxY - caveMinY;

        // Vein-полоса [-170,50] (IRON_DEEP.minY .. COPPER.maxY): секции, её пересекающие,
        // идут per-block ради руд. SURFACE_BULK_MARGIN=8: bulk строго ниже under-surface зоны.
        final int VEIN_BAND_MIN = -170, VEIN_BAND_MAX = 50;
        final int SURFACE_BULK_MARGIN = 8;

        int minSurf = Integer.MAX_VALUE;
        for (int lx = 0; lx < 16; lx++)
            for (int lz = 0; lz < 16; lz++)
                if (surfaceHeights[lx][lz] < minSurf) minSurf = surfaceHeights[lx][lz];

        // upperStone boundary диапазон (underLayers≈4 — оценка)
        int minUSS = Integer.MAX_VALUE, maxUSS = Integer.MIN_VALUE;
        for (int lx = 0; lx < 16; lx++)
            for (int lz = 0; lz < 16; lz++) {
                int uss = Math.max(STONE_BLEND_HEIGHT, (STONE_BLEND_HEIGHT + (surfaceHeights[lx][lz] - 4)) / 2);
                if (uss < minUSS) minUSS = uss;
                if (uss > maxUSS) maxUSS = uss;
            }

        // singleBiome (центр + 4 угла) + центр-биом stone-блоки
        boolean singleBiome = true;
        BFMEBiome cb = mapRuntime.getBiome(startX + 8, startZ + 8);
        net.minecraft.resources.ResourceKey<net.minecraft.world.level.biome.Biome> cbk = cb != null ? cb.biome : null;
        int[][] corners = {{0,0},{15,0},{0,15},{15,15}};
        for (int[] c : corners) {
            BFMEBiome b = mapRuntime.getBiome(startX + c[0], startZ + c[1]);
            net.minecraft.resources.ResourceKey<net.minecraft.world.level.biome.Biome> bk = b != null ? b.biome : null;
            if (bk != cbk) { singleBiome = false; break; }
        }
        BlockState centerStone = (cb != null) ? cb.getStoneBlock().defaultBlockState() : Blocks.STONE.defaultBlockState();
        BlockState centerUpperStone = (cb != null) ? cb.getUpperStoneBlock().defaultBlockState() : Blocks.STONE.defaultBlockState();
        BlockState deepslateState = Blocks.DEEPSLATE.defaultBlockState();

        for (int secBot = MIN_Y; secBot + 16 <= MAX_Y; secBot += 16) {
            int secTop = secBot + 16; // exclusive
            if (secTop > minSurf - SURFACE_BULK_MARGIN) break;             // строго ниже поверхности+зап
            if (secBot < MIN_Y + BEDROCK_LAYERS) continue;                 // bedrock → поблочно
            if (secBot < STONE_BLEND_HEIGHT && secTop > DEEPSLATE_TOP) continue; // blend граница
            if (secBot <= VEIN_BAND_MAX && secTop > VEIN_BAND_MIN) continue;     // пересекает vein-полосу → руды per-block

            BlockState fill;
            if (secTop <= DEEPSLATE_TOP) {                                 // чистый deepslate
                fill = deepslateState;
            } else if (secBot >= STONE_BLEND_HEIGHT && singleBiome) {       // stone-зона
                boolean straddle = secBot < maxUSS && secTop > minUSS;
                if (straddle) continue;                                    // stone↔upperStone граница → поблочно
                fill = (secTop <= minUSS) ? centerStone : centerUpperStone;
            } else {
                continue;                                                  // мультибиом stone / прочее → поблочно
            }

            // cave-free: секция с пещерами → НЕ bulk (поблочно). Иначе carve внутрь = resize-storm.
            boolean hasCave = false;
            scan:
            for (int lx = 0; lx < 16; lx++)
                for (int lz = 0; lz < 16; lz++)
                    for (int y = secBot; y < secTop; y++) {
                        int yi = y - caveMinY;
                        if (yi >= 0 && yi < caveHeight && isCaveBlock[lx][lz][yi]) { hasCave = true; break scan; }
                    }
            if (hasCave) continue;

            int idx = chunk.getSectionIndex(secBot);
            if (idx < 0 || idx >= sectionsCount) continue;
            LevelChunkSection old = chunk.getSection(idx);
            PalettedContainer<BlockState> states = new PalettedContainer<>(
                    Block.BLOCK_STATE_REGISTRY, fill, PalettedContainer.Strategy.SECTION_STATES);
            LevelChunkSection filled = new LevelChunkSection(states, old.getBiomes());
            filled.recalcBlockCounts();
            chunk.getSections()[idx] = filled;
            secBulk[idx] = true;
        }
        return secBulk;
    }

    private void generateColumn(ChunkAccess chunk, BlockPos.MutableBlockPos pos,
                                int localX, int localZ, int worldX, int worldZ,
                                int surfaceHeight, BFMEBiome biome, CaveInterpolator caveInterpolator,
                                boolean[][][] isCaveBlock, int caveMinY,
                                BFMEAquiferSampler aquifer, BFMEVeinSampler veinSampler,
                                VeinInterpolator veinInterp, boolean[] secBulk) {

        int minY = chunk.getMinBuildHeight();

        // DIAG: тупая заливка — baseline чистой записи (без surface-config/cave/vein/aquifer/slope/snow).
        if (DIAG_DUMB_FILL) {
            BlockState stone = Blocks.STONE.defaultBlockState();
            // DEBUG: красим ВЕРХНИЙ блок по глубине эрозии → сеть русел видна как цветные вены на камне.
            float erDelta = heightMapV11.getErosionDelta(worldX, worldZ);
            BlockState topState = stone;
            if (erDelta < -5f)        topState = Blocks.RED_WOOL.defaultBlockState();      // глубокие магистрали
            else if (erDelta < -2f)   topState = Blocks.ORANGE_WOOL.defaultBlockState();   // средние русла
            else if (erDelta < -0.5f) topState = Blocks.YELLOW_WOOL.defaultBlockState();   // мелкие ручьи
            int dCurIdx = -1; LevelChunkSection dSec = null;
            for (int y = minY; y <= surfaceHeight; y++) {
                int si = chunk.getSectionIndex(y);
                if (secBulk[si]) continue;
                if (si != dCurIdx) { dCurIdx = si; dSec = chunk.getSection(si); }
                BlockState st = (y == surfaceHeight) ? topState : stone;
                dSec.setBlockState(localX, y & 15, localZ, st, false);
            }
            return;
        }

        RandomSource random = RandomSource.create(
                worldSeed ^ ((long) worldX * 341873128712L) ^ ((long) worldZ * 132897987541L)
        );

        BlockState stoneBlock = biome.getStoneBlock().defaultBlockState();
        BlockState upperStoneBlock = biome.getUpperStoneBlock().defaultBlockState();

        // === Surface config ===
        ResourceKey<Biome> terrainOwnerKey = heightMapV11.getTerrainOwner(worldX, worldZ);
        BFMEBiome terrainOwnerBiome = BFMEBiomesData.getBiomeByKey(terrainOwnerKey);

        float slopeAngle = getSlopeAngle(worldX, worldZ);
        float riverWeight = heightMapV11.getRiverWeight(worldX, worldZ);

        SurfaceConfig surfaceConfig;

        ResourceKey<Biome> realBiome = bfmeBiomeSource.getBiomeKey(
                Math.floorDiv(worldX, PIXEL_WEIGHT), Math.floorDiv(worldZ, PIXEL_WEIGHT));
        // Русло реки = вся подводная часть у реки (surfaceHeight < вода И в зоне реки). Признак русла —
        // НЕ riverWeight (узкие реки дают ~0.3), а дистанция до реки + что carve опустил ниже воды.
        // Согласовано с getNoiseBiome: под водой у реки = водный биом (нет земных фич, русловый surface).
        if (surfaceHeight < SEA_LEVEL
                && heightMapV11.getRiverDistBlocks(worldX, worldZ) <= heightMapV11.getRiverInfluenceRadius()
                && slopeAngle < 15) {
            surfaceConfig = SurfaceConfigs.RIVER_ANDUIN;
        } else {
            SurfaceNoise sNoise = surfaceNoise;
            float biomeWarpX = sNoise.getBoundaryBias(worldX * 2 + 7000, worldZ * 5 + 7000) * 3f;
            float biomeWarpZ = sNoise.getBoundaryBias(worldX * 5 + 8000, worldZ * 2 + 8000) * 3f;

            int warpedPx = Math.floorDiv(worldX + Math.round(biomeWarpX), PIXEL_WEIGHT);
            int warpedPz = Math.floorDiv(worldZ + Math.round(biomeWarpZ), PIXEL_WEIGHT);
            ResourceKey<Biome> warpedBiome = bfmeBiomeSource.getBiomeKey(warpedPx, warpedPz);

            BFMEBiome warpedBiomeObj = BFMEBiomesData.getBiomeByKey(warpedBiome);
            surfaceConfig = warpedBiomeObj.getSurfaceConfig();
        }

        SurfaceConfig.SurfaceResult surfaceResult;
        if (surfaceConfig != null) {
            surfaceResult = surfaceConfig.evaluate(surfaceHeight, slopeAngle, worldX, worldZ);
        } else {
            surfaceResult = new SurfaceConfig.SurfaceResult(Blocks.GRASS_BLOCK, 1);
        }

        Block surfaceBlockRaw = surfaceResult.block();
        int patchDepth = surfaceResult.depth();
        BlockState surfaceBlock = surfaceBlockRaw.defaultBlockState();

        if (surfaceHeight < SEA_LEVEL && surfaceBlock.is(Blocks.GRASS_BLOCK)) {
            surfaceBlock = Blocks.DIRT.defaultBlockState();
            surfaceBlockRaw = Blocks.DIRT;
            patchDepth = 1;
        }

        // DEBUG: визуализация pattern-ячеек цветным бетоном
        if (VISUALIZE_CELLS) {
            BlockState vis = cellVisualizationBlock(realBiome, worldX, worldZ);
            if (vis != null) surfaceBlock = vis;
        }

        Block underBlockRaw = SurfaceConfig.getUnderBlock(surfaceBlockRaw);
        BlockState underSurface = underBlockRaw.defaultBlockState();
        int underLayers = SurfaceConfig.getUnderLayers(surfaceBlockRaw);

        // Cave параметры из terrain profile
        BiomeTerrainProfile terrainProfile = profileRegistry.getProfile(
                terrainOwnerBiome != null ? terrainOwnerBiome.biome : null);
        boolean cavesEnabled = terrainProfile.isCavesEnabled();
        // Под-массив пещер этой колонны — фетчим раз (isCaveAt тогда 1 деереф вместо 5).
        boolean[] caveColumn = isCaveBlock[localX][localZ];

        // Vein-конфиг per биом (используется в placeStoneOrVein)
        final net.sima.bfme.worldgen.noise.VeinBiomeConfig veinConfig = terrainProfile.getVeinConfig();

        // Глубокие base-блоки пишем ПРЯМО в секцию (vanilla doFill путь): section.setBlockState(...,false)
        // — без per-block lock и ProtoChunk-overhead. Секция кэшируется, перечитывается только при
        // переходе через границу 16 (y монотонно растёт по всем глубоким циклам). Heightmap НЕ нужен:
        // эти блоки всегда ниже under-surface, а near-surface (undersurface/surface/water/snow ниже)
        // идут через chunk.setBlockState и обновляют WG-heightmap'ы автоматически.
        int curSecIdx = -1;
        LevelChunkSection sec = null;

        // === 1. Bedrock — плоский слой 2 блока ===
        for (int y = minY; y < minY + BEDROCK_LAYERS; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            sec.setBlockState(localX, y & 15, localZ, Blocks.BEDROCK.defaultBlockState(), false);
        }

        // === 2. Deepslate (low) ===
        BlockState deepslate = Blocks.DEEPSLATE.defaultBlockState();
        for (int y = minY + BEDROCK_LAYERS; y <= LAVA_LEVEL; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                placeStoneOrVein(sec, localX, y, localZ, worldX, worldZ, veinSampler, veinInterp, veinConfig, deepslate);
            } else {
                placeAquiferBlock(chunk, sec, pos, localX, y, localZ, worldX, worldZ, caveInterpolator, aquifer, deepslate);
            }
        }

        // === 3. Deepslate (upper) ===
        for (int y = LAVA_LEVEL + 1; y < DEEPSLATE_TOP; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                placeStoneOrVein(sec, localX, y, localZ, worldX, worldZ, veinSampler, veinInterp, veinConfig, deepslate);
            } else {
                placeAquiferBlock(chunk, sec, pos, localX, y, localZ, worldX, worldZ, caveInterpolator, aquifer, deepslate);
            }
        }

        // === 4. Deepslate → Stone blend ===
        for (int y = DEEPSLATE_TOP; y < STONE_BLEND_HEIGHT; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            BlockState layerBlock = isStoneInBlendZone(worldX, y, worldZ) ? stoneBlock : deepslate;
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                placeStoneOrVein(sec, localX, y, localZ, worldX, worldZ, veinSampler, veinInterp, veinConfig, layerBlock);
            } else {
                placeAquiferBlock(chunk, sec, pos, localX, y, localZ, worldX, worldZ, caveInterpolator, aquifer, layerBlock);
            }
        }

        // === 5. Stone ===
        int materialDepth = Math.max(underLayers, patchDepth);
        int underStart = surfaceHeight - materialDepth;
        int upperStoneStart = Math.max(STONE_BLEND_HEIGHT, (STONE_BLEND_HEIGHT + underStart) / 2);

        for (int y = STONE_BLEND_HEIGHT; y < upperStoneStart; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                placeStoneOrVein(sec, localX, y, localZ, worldX, worldZ, veinSampler, veinInterp, veinConfig, stoneBlock);
            } else {
                placeAquiferBlock(chunk, sec, pos, localX, y, localZ, worldX, worldZ, caveInterpolator, aquifer, stoneBlock);
            }
        }

        for (int y = upperStoneStart; y < underStart; y++) {
            int si = chunk.getSectionIndex(y);
            if (secBulk[si]) continue;                                     // bulk-залито целиком (cave-free)
            if (si != curSecIdx) { curSecIdx = si; sec = chunk.getSection(si); }
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                placeStoneOrVein(sec, localX, y, localZ, worldX, worldZ, veinSampler, veinInterp, veinConfig, upperStoneBlock);
            } else {
                placeAquiferBlock(chunk, sec, pos, localX, y, localZ, worldX, worldZ, caveInterpolator, aquifer, upperStoneBlock);
            }
        }

        // === 6. Under-surface ===
        for (int y = underStart; y < surfaceHeight; y++) {
            if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,y)) {
                chunk.setBlockState(pos.set(localX, y, localZ), underSurface, false);
            }
        }

        // === 7. Surface ===
        if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,surfaceHeight)) {
            chunk.setBlockState(pos.set(localX, surfaceHeight, localZ), surfaceBlock, false);
        }

        // === 8. Patch depth ===
        if (patchDepth > 1) {
            for (int d = 1; d < patchDepth && d <= underLayers; d++) {
                if (!isCaveAt(cavesEnabled, caveColumn, caveMinY,surfaceHeight - d)) {
                    chunk.setBlockState(pos.set(localX, surfaceHeight - d, localZ), surfaceBlock, false);
                }
            }
        }

        // === 9. Water fill === (тот же floor что carve; в реке — до её уровня воды)
        // Зону заливки берём ТУ ЖЕ, что у carve (расстояние до реки), а не riverWeight: carve
        // выравнивает дно на всю зону, и залить водой надо всю эту зону, иначе у берега остаётся
        // сухое плоское дно («пустота») — заливалось только до моря, а дно выше.
        int waterLevel = SEA_LEVEL;
        if (heightMapV11.getRiverDistBlocks(worldX, worldZ) <= heightMapV11.getRiverInfluenceRadius()) {
            int wh = Math.round(heightMapV11.getRiverWaterHeight(worldX, worldZ));
            if (wh > waterLevel) waterLevel = wh;
        }
        if (surfaceHeight < waterLevel) {
            for (int y = surfaceHeight + 1; y <= waterLevel; y++) {
                chunk.setBlockState(pos.set(localX, y, localZ), Blocks.WATER.defaultBlockState(), false);
            }
        }

        // === 10. Snow ===
        float snowLine = surfaceConfig != null ? surfaceConfig.getSnowLineHeight() : 999;
        if (snowLine < 999 && surfaceHeight > snowLine - 30 && surfaceHeight > SEA_LEVEL) {
            SurfaceNoise sNoise = surfaceNoise;
            float snowNoise = sNoise.getBoundaryBias(worldX, worldZ);
            float effectiveSnowLine = snowLine + snowNoise * 8f;
            float heightAboveSnow = surfaceHeight - effectiveSnowLine;

            if (heightAboveSnow > 0) {
                float maxSlope;
                if (heightAboveSnow > 50) maxSlope = 55f;
                else if (heightAboveSnow > 30) maxSlope = 45f;
                else if (heightAboveSnow > 15) maxSlope = 38f;
                else maxSlope = 30f;

                if (slopeAngle <= maxSlope) {
                    float patchVal = sNoise.getPatchNoise(worldX, worldZ, 99);
                    boolean isPowder = patchVal > 0.94f;
                    Block snowBlockType = isPowder ? Blocks.POWDER_SNOW : Blocks.SNOW_BLOCK;

                    int snowDepth;
                    if (heightAboveSnow > 50 && slopeAngle < 35) snowDepth = 4;
                    else if (heightAboveSnow > 30 && slopeAngle < 40) snowDepth = 3;
                    else if (heightAboveSnow > 15 && slopeAngle < 42) snowDepth = 2;
                    else snowDepth = 1;

                    float stoneNoise = sNoise.getPatchNoise(worldX, worldZ, 98);
                    if (stoneNoise > 0.92f && slopeAngle > 30 && snowDepth > 1) {
                        snowDepth = 0;
                    }

                    if (snowDepth > 0 && !isCaveAt(cavesEnabled, caveColumn, caveMinY,surfaceHeight)) {
                        for (int d = 0; d < snowDepth; d++) {
                            chunk.setBlockState(pos.set(localX, surfaceHeight - d, localZ),
                                    snowBlockType.defaultBlockState(), false);
                        }

                        int layers = Math.max(1, Math.min(8, Math.round(6 * (1f - slopeAngle / maxSlope))));
                        chunk.setBlockState(pos.set(localX, surfaceHeight + 1, localZ),
                                Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, layers), false);
                    }
                }
            }
        }

    }

    // ============================================================
    // UNUSED OVERRIDES (handled in fillFromNoise)
    // ============================================================

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structureManager,
                             RandomState randomState, ChunkAccess chunk) {}

    @Override
    public void applyCarvers(WorldGenRegion region, long seed, RandomState randomState,
                             BiomeManager biomeManager, StructureManager structureManager,
                             ChunkAccess chunk, GenerationStep.Carving step) {}

    @Override
    public void applyBiomeDecoration(net.minecraft.world.level.WorldGenLevel level,
                                      ChunkAccess chunk,
                                      StructureManager structureManager) {
        // Сначала ванильный biome decoration (features из самих биомов: cave decorations, trees, etc.)
        super.applyBiomeDecoration(level, chunk, structureManager);
        // Затем — наши per-surface-biome ores (вместо ванильных addDefaultOres)
        applyOres(level, chunk);
    }

    /**
     * Размещает ore features из surface biome (не cave biome!).
     * Для каждого XZ в чанке: смотрит наземный биом → берёт его profile.getOres() →
     * вызывает каждую PlacedFeature.place() с правильными seeds.
     */
    private void applyOres(net.minecraft.world.level.WorldGenLevel level, ChunkAccess chunk) {
        ChunkPos chunkPos = chunk.getPos();
        int chunkOriginX = chunkPos.getMinBlockX();
        int chunkOriginZ = chunkPos.getMinBlockZ();

        // Surface biome берётся для центра чанка (через biome map, не cave biome)
        int centerX = chunkOriginX + 8;
        int centerZ = chunkOriginZ + 8;
        ResourceKey<Biome> surfBiomeKey = bfmeBiomeSource.getBiomeKey(
                Math.floorDiv(centerX, PIXEL_WEIGHT),
                Math.floorDiv(centerZ, PIXEL_WEIGHT));

        BiomeTerrainProfile profile = profileRegistry.getProfile(surfBiomeKey);
        if (profile == null) return;

        java.util.List<ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature>> oreList = profile.getOres();
        if (oreList == null || oreList.isEmpty()) return;

        var placedFeatureRegistry = level.registryAccess()
                .registryOrThrow(net.minecraft.core.registries.Registries.PLACED_FEATURE);

        BlockPos chunkOrigin = new BlockPos(chunkOriginX, chunk.getMinBuildHeight(), chunkOriginZ);
        var worldgenRandom = new net.minecraft.world.level.levelgen.WorldgenRandom(
                new net.minecraft.world.level.levelgen.XoroshiroRandomSource(worldSeed));
        long featureSeed = worldgenRandom.setDecorationSeed(worldSeed, chunkOriginX, chunkOriginZ);

        int featureIndex = 0;
        int decorationStep = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
        for (ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature> key : oreList) {
            var holder = placedFeatureRegistry.getHolder(key).orElse(null);
            if (holder == null) continue;
            worldgenRandom.setFeatureSeed(featureSeed, featureIndex, decorationStep);
            holder.value().place(level, this, worldgenRandom, chunkOrigin);
            featureIndex++;
        }
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion region) {}

    // ============================================================
    // HEIGHT & COLUMN INFO
    // ============================================================

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types type,
                             LevelHeightAccessor level, RandomState randomState) {
        ensureSeedInitialized(randomState);
        return getHeight(x, z);
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor level, RandomState randomState) {
        ensureSeedInitialized(randomState);

        int height = getHeight(x, z);
        int columnHeight = Math.max(1, height - MIN_Y);
        BlockState[] states = new BlockState[columnHeight];

        for (int i = 0; i < columnHeight; i++) {
            int y = MIN_Y + i;
            if (y < DEEPSLATE_TOP) states[i] = Blocks.DEEPSLATE.defaultBlockState();
            else if (y < height - 4) states[i] = Blocks.STONE.defaultBlockState();
            else if (y < height) states[i] = Blocks.DIRT.defaultBlockState();
            else states[i] = Blocks.GRASS_BLOCK.defaultBlockState();
        }

        return new NoiseColumn(MIN_Y, states);
    }

    /**
     * DEBUG (VISUALIZE_CELLS): возвращает цветной бетон по pattern в точке, или null если
     * биом не PATTERN_LIST (тогда обычная поверхность). Использует ту же getDebugInfo что и F3.
     */
    private BlockState cellVisualizationBlock(ResourceKey<Biome> realBiome, int worldX, int worldZ) {
        var pb = heightMapV11.getPatternBlender();
        if (pb == null) return null;
        BiomeTerrainProfile profile = profileRegistry.getProfile(realBiome);
        if (profile.getTerrainMode() != BiomeTerrainProfile.TerrainMode.PATTERN_LIST) return null;
        var dbg = pb.getDebugInfo(worldX, worldZ, profile);
        if (dbg == null) return null;

        if (dbg.secondType() != null) {
            return Blocks.ORANGE_CONCRETE.defaultBlockState();   // mixed cell
        }
        switch (dbg.type()) {
            case PLAINS_SMOOTH: return Blocks.WHITE_CONCRETE.defaultBlockState();
            case PLAINS_LIVELY: return Blocks.YELLOW_CONCRETE.defaultBlockState();
            case HILLS_GENTLE:  return Blocks.RED_CONCRETE.defaultBlockState();
            default:            return Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState();
        }
    }
    @Override
    public void addDebugScreenInfo(List<String> list, RandomState randomState, BlockPos pos) {
        list.add("§eBFME WorldGen");

        try {
            ensureSeedInitialized(randomState);

            if (!heightMapV11.isFullyReady()) {
                list.add("§7HeightMap: not ready");
                return;
            }

            int x = pos.getX();
            int z = pos.getZ();
            int height = getHeight(x, z);
            BFMEBiome biome = mapRuntime.getBiome(x, z);

            list.add("Surface: " + height);
            list.add("Biome: " + (biome != null ? biome.getKey() : "null"));

            // Pattern-system info
            net.sima.bfme.worldgen.chunkgen.map.BFMEHeightMapV11.HeightDebugInfo dbg =
                    heightMapV11.getDebugComponents(x, z);

            if (dbg == null || dbg.profile() == null) {
                list.add("§7Mode: N/A");
                return;
            }

            BiomeTerrainProfile profile = dbg.profile();
            list.add(String.format("§7Mode: %s | base=%.1f voro=%.1f pattern=%.1f → %.1f",
                    profile.getTerrainMode(),
                    dbg.baseHeight(), dbg.voronoiHeight(), dbg.patternHeight(), dbg.total()));

            if (profile.getTerrainMode() == BiomeTerrainProfile.TerrainMode.PATTERN_LIST) {
                var pb = heightMapV11.getPatternBlender();

                if (pb != null) {
                    var pdbg = pb.getDebugInfo(x, z, profile);

                    if (pdbg != null) {
                        int cs = net.sima.bfme.worldgen.pattern.TerrainPatternBlender.getCellSize();
                        String patternLine;

                        if (pdbg.secondType() == null) {
                            patternLine = String.format("§bPattern: %s | Cell(%d,%d) c(%d,%d) sz=%d",
                                    pdbg.type(), pdbg.cellX(), pdbg.cellY(),
                                    pdbg.centerX(), pdbg.centerY(), cs);
                        } else {
                            patternLine = String.format("§bPattern: %s+%s (t=%.2f) | Cell(%d,%d) c(%d,%d)",
                                    pdbg.type(), pdbg.secondType(), pdbg.selectorT(),
                                    pdbg.cellX(), pdbg.cellY(),
                                    pdbg.centerX(), pdbg.centerY());
                        }

                        list.add(patternLine);
                        list.add(String.format("§7Cell hash=0x%X id=%.3f d=%.2f",
                                pdbg.hash() & 0xFFFFFFFFL, pdbg.identity(), pdbg.distClosest()));

                        // Multi-cell blend info
                        if (pdbg.inBlendZone()) {
                            list.add(String.format("§dBlend: %s(%.0f%%) + %s[Cell(%d,%d)](%.0f%%)",
                                    pdbg.type(), pdbg.weightClosest() * 100f,
                                    pdbg.neighborType(),
                                    pdbg.neighborCellX(), pdbg.neighborCellY(),
                                    pdbg.weightNeighbor() * 100f));
                        } else {
                            list.add(String.format("§7Inside cell (next: %s d=%.2f)",
                                    pdbg.neighborType(), pdbg.distSecond()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            list.add("§cBFME debug error: " + e.getClass().getSimpleName());

            if (e.getMessage() != null) {
                list.add("§7" + e.getMessage());
            }
        }
    }
    @Override
    public int getGenDepth() { return MAX_Y - MIN_Y; }

    @Override
    public int getSeaLevel() { return SEA_LEVEL; }

    @Override
    public int getMinY() { return MIN_Y; }
}