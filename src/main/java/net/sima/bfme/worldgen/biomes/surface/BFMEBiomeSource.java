package net.sima.bfme.worldgen.biomes.surface;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.util.SimplexNoise;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.biomes.caves.ModCaveBiomes;
import net.sima.bfme.worldgen.map.BFMEMapRuntime;
import org.joml.Vector2f;

import java.util.*;
import java.util.stream.Stream;

public class BFMEBiomeSource extends BiomeSource {
    public static final MapCodec<BFMEBiomeSource> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            RegistryCodecs.homogeneousList(Registries.BIOME).fieldOf("biomes").forGetter(o -> o.biomeHolderSet)
    ).apply(instance, instance.stable(BFMEBiomeSource::new)));

    private final HolderSet<Biome> biomeHolderSet;
    private final BFMEMapRuntime mapRuntime;
    private final LoggerUtil loggerUtil;


    public BFMEBiomeSource(HolderSet<Biome> biomeHolderSet) {
        this.biomeHolderSet = biomeHolderSet;
        this.mapRuntime = BFMEMapRuntime.getInstance();
        loggerUtil = LoggerUtil.getInstance();

        loggerUtil.logDebugMsg("Loaded Biomes in HolderSet:");
        biomeHolderSet.stream().forEach(holder -> {
            ResourceKey<Biome> key = holder.unwrapKey().orElseThrow();
            loggerUtil.logDebugMsg("- Biome: %s".formatted(key.location()));
        });
    }


    @Override
    protected MapCodec<? extends BiomeSource> codec() {
        return MAP_CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return this.biomeHolderSet.stream();
    }
    private final Set<String> loggedBiomes = new HashSet<>();
    private final Map<String, Holder<Biome>> biomeCache = new HashMap<>();
    private static final int SCALE = 4; // Масштаб 4: увеличиваем координаты в 4 раза

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        // Перевод координат в мировые
        int worldX = x * SCALE;
        int worldZ = z * SCALE;

        // Ключ для кэширования по мировым координатам
        String cacheKey = "%d,%d,%d".formatted(worldX, y, worldZ);
        if (biomeCache.containsKey(cacheKey)) {
            return biomeCache.get(cacheKey);
        }

        // Получаем биом из карты

        BFMEBiome biomeFromMap = mapRuntime.getBiome(worldX, worldZ);

        if (biomeFromMap == null) {
            LoggerUtil.getInstance().logError("BiomeSource -> Default biome used for missing biome at WorldX: %d, WorldZ: %d".formatted(worldX, worldZ));
            Holder<Biome> defaultBiome = biomeHolderSet.stream().findFirst().orElseThrow();
            biomeCache.put(cacheKey, defaultBiome);
            return defaultBiome;
        }

        // Сопоставление биома

        Holder<Biome> resultBiome = biomeHolderSet.stream()
                .filter(holder -> holder.is(biomeFromMap.biome))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "BiomeSource -> Biome %s not found in HolderSet!".formatted(biomeFromMap.biome.location())));

        // Кэширование результата
        biomeCache.put(cacheKey, resultBiome);

        return resultBiome;
    }


    private ResourceKey<Biome> getDefaultBiome(int y) {
        if (y > 120) {
            return BFMEBiomeKeys.WHITE_MOUNTAINS;
        } else if (y < 60) {
            return BFMEBiomeKeys.ANDUIN_BANKS;
        }
        return BFMEBiomeKeys.PELENNOR_PLAINS;
    }

    private ResourceKey<Biome> getCaveBiome(int x, int z, BFMEBiome surfaceBiome) {
        float temperature = (float) SimplexNoise.noise((double) x / 96, (double) z / 96);
        float humidity = (float) SimplexNoise.noise((double) (x + 7220) / 96, (double) (z + 7220) / 96);
        return ModCaveBiomes.getBiome(new Vector2f(temperature, humidity), surfaceBiome);
    }
}
