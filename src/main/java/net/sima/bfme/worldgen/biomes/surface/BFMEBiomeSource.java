package net.sima.bfme.worldgen.biomes.surface;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biomes;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.biomes.caves.ModCaveBiomes;
import net.sima.bfme.worldgen.chunkgen.map.BFMEHeightMapV11;
import net.sima.bfme.worldgen.map.BFMEMapRuntime;
import net.sima.bfme.worldgen.noise.OpenSimplex2S;
import org.joml.Vector2f;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * ОПТИМИЗИРОВАННЫЙ BFMEBiomeSource
 *
 * Изменения:
 * 1. Long-based кэш вместо String — в 10-20 раз быстрее
 * 2. Предварительный маппинг ResourceKey -> Holder для O(1) поиска
 * 3. ConcurrentHashMap для thread-safety
 * 4. Ограничение размера кэша
 */
public class BFMEBiomeSource extends BiomeSource {

    public static final MapCodec<BFMEBiomeSource> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            RegistryCodecs.homogeneousList(Registries.BIOME).fieldOf("biomes").forGetter(o -> o.biomeHolderSet)
    ).apply(instance, instance.stable(BFMEBiomeSource::new)));

    private final HolderSet<Biome> biomeHolderSet;
    private final BFMEMapRuntime mapRuntime;

    // ОПТИМИЗАЦИЯ 1: Предварительный маппинг биомов для O(1) поиска
    private final Map<ResourceKey<Biome>, Holder<Biome>> biomeKeyToHolder = new HashMap<>();

    // ОПТИМИЗАЦИЯ 2: Long-based кэш вместо String
    private final ConcurrentHashMap<Long, Holder<Biome>> biomeCache = new ConcurrentHashMap<>();
    private static final int CACHE_MAX_SIZE = 65536;

    // Дефолтный биом для быстрого доступа
    private Holder<Biome> defaultBiome;

    // Cave biome noise
    private long caveBiomeSeed = 0L;
    private boolean caveSeedInitialized = false;

    private static final int SCALE = 4;

    public BFMEBiomeSource(HolderSet<Biome> biomeHolderSet) {
        this.biomeHolderSet = biomeHolderSet;
        this.mapRuntime = BFMEMapRuntime.getInstance();

        // Строим маппинг ResourceKey -> Holder один раз при создании
        biomeHolderSet.stream().forEach(holder -> {
            holder.unwrapKey().ifPresent(key -> biomeKeyToHolder.put(key, holder));
        });

        // Сохраняем дефолтный биом
        this.defaultBiome = biomeHolderSet.stream().findFirst().orElse(null);

        LoggerUtil.getInstance().logDebugMsg("BFMEBiomeSource initialized with " + biomeKeyToHolder.size() + " biomes");
    }

    @Override
    protected MapCodec<? extends BiomeSource> codec() {
        return MAP_CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return this.biomeHolderSet.stream();
    }

    public void initCaveSeed(long worldSeed) {
        this.caveBiomeSeed = worldSeed + 85001L;
        this.caveSeedInitialized = true;
        ModCaveBiomes.init();
    }

    private ResourceKey<Biome> getCaveBiome(int worldX, int worldY, int worldZ) {
        if (!caveSeedInitialized) return null;

        float temperature = (float) OpenSimplex2S.noise3_ImproveXY(caveBiomeSeed,
                worldX * 0.001, worldZ * 0.001, worldY * 0.003);
        float humidity = (float) OpenSimplex2S.noise3_ImproveXY(caveBiomeSeed + 7220L,
                worldX * 0.001, worldZ * 0.001, worldY * 0.003);

        // Близко к центру → default (наземный биом, без пещерного декора)
        float dist = (float) Math.sqrt(temperature * temperature + humidity * humidity);
        if (dist < 0.35f) return null;

        return ModCaveBiomes.getBiome(new Vector2f(temperature, humidity));
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int worldX = x * SCALE;
        int worldY = y * SCALE;
        int worldZ = z * SCALE;

        BFMEHeightMapV11 heightMap = BFMEHeightMapV11.getInstance();
        if (heightMap.isFullyReady()) {
            // Минимальная высота по углам секции 4×4×4 — чтобы cave biome
            // не вылезал на поверхность из-за квантизации
            float h0 = heightMap.getHeight(worldX, worldZ);
            float h1 = heightMap.getHeight(worldX + SCALE, worldZ);
            float h2 = heightMap.getHeight(worldX, worldZ + SCALE);
            float h3 = heightMap.getHeight(worldX + SCALE, worldZ + SCALE);
            float minSurface = Math.min(Math.min(h0, h1), Math.min(h2, h3));

            // Защита cave биома от поверхности — 15 блоков. На крутых склонах
            // features cave биома (мох/азалия из lush_caves) могут "торчать" из горы,
            // нужен запас больше чем 12 для гор.
            if (worldY < minSurface - 15) {
                ResourceKey<Biome> caveBiomeKey = getCaveBiome(worldX, worldY, worldZ);
                if (caveBiomeKey != null) {
                    Holder<Biome> caveHolder = biomeKeyToHolder.get(caveBiomeKey);
                    if (caveHolder != null) return caveHolder;
                }
                // null → проваливаемся в обычную логику → surface biome
            }

            // Под водой → ВОДНЫЙ биом (RIVER_ANDUIN). Морей пока нет → любая поверхность ниже воды = река.
            // Убирает земные фичи/деревья под водой, отдаёт подводную часть реке. Геометрию НЕ меняет:
            // height-блюр идёт через getBiomeKey/PNG, а не через getNoiseBiome.
            float waterH = heightMap.getRiverWaterHeight(worldX, worldZ);
            if (h0 < waterH) {
                Holder<Biome> riverHolder = biomeKeyToHolder.get(BFMEBiomeKeys.RIVER_ANDUIN);
                if (riverHolder != null) return riverHolder;
            }
        }

        // Обычная логика для поверхности
        long cacheKey = packCoords(worldX, worldZ);

        Holder<Biome> cached = biomeCache.get(cacheKey);
        if (cached != null) {
            return cached;
        }

        BFMEBiome biomeFromMap = mapRuntime.getBiome(worldX, worldZ);

        Holder<Biome> result;
        if (biomeFromMap == null) {
            result = defaultBiome;
        } else {
            result = biomeKeyToHolder.get(biomeFromMap.biome);
            if (result == null) {
                result = defaultBiome;
            }
        }

        evictPartial(biomeCache, CACHE_MAX_SIZE);
        biomeCache.put(cacheKey, result);

        return result;
    }

    /**
     * Быстрое получение ResourceKey биома (для HeightMap)
     * ВНИМАНИЕ: принимает ПИКСЕЛЬНЫЕ координаты карты, НЕ мировые!
     */
    public ResourceKey<Biome> getBiomeKey(int pixelX, int pixelZ) {
        int worldX = pixelX * SCALE;
        int worldZ = pixelZ * SCALE;

        BFMEBiome biomeFromMap = mapRuntime.getBiome(worldX, worldZ);
        return biomeFromMap != null ? biomeFromMap.biome : null;
    }

    /**
     * Получение ResourceKey биома по МИРОВЫМ координатам.
     * Используется в density-based генерации.
     */
    public ResourceKey<Biome> getBiomeKeyWorld(int worldX, int worldZ) {
        BFMEBiome biomeFromMap = mapRuntime.getBiome(worldX, worldZ);
        return biomeFromMap != null ? biomeFromMap.biome : null;
    }

    private static <K, V> void evictPartial(java.util.concurrent.ConcurrentHashMap<K, V> cache, int maxSize) {
        if (cache.size() < maxSize) return;
        int toRemove = maxSize / 4;
        var iterator = cache.keySet().iterator();
        int removed = 0;
        while (iterator.hasNext() && removed < toRemove) {
            iterator.next();
            iterator.remove();
            removed++;
        }
    }

    private static long packCoords(int x, int z) {
        return ((long) x << 32) | (z & 0xFFFFFFFFL);
    }

    public void clearCache() {
        biomeCache.clear();
    }
}