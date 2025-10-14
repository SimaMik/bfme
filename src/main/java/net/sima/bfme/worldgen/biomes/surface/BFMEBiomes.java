package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.biomes.BiomeColorsDTO;
import net.sima.bfme.worldgen.spawners.BFMESpawnSettingsBuilder;

import java.util.Comparator;
import java.util.List;

public class BFMEBiomes {

    public static final int DEFAULT_SKY = 7907327;
    public static final int DEFAULT_FOG = 12638463;
    public static final int DEFAULT_WATER = 4159204;
    public static final int DEFAULT_WATER_FOG = 329011;

    public static void bootstrapBiomes(BootstrapContext<Biome> context) {
        registerPelennorPlains(context);
        registerFirienWood(context);
        registerDruadanForest(context);
        registerGreywood(context);
        registerWhiteMountainsFoothills(context);
        registerAnduinBanks(context);
        registerEntwash(context);
        registerWhiteMountains(context);
    }

    // Отдельный метод для регистрации каждого биома
    private static void registerPelennorPlains(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.PELENNOR_PLAINS, createPelennorPlains(context));
    }

    private static void registerFirienWood(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.FIRIEN_WOOD, createFirienWood(context));
    }

    private static void registerDruadanForest(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.DRUADAN_FOREST, createDruadanForest(context));
    }

    private static void registerGreywood(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.GREYWOOD, createGreywood(context));
    }

    private static void registerWhiteMountainsFoothills(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS, createWhiteMountainsFoothills(context));
    }

    private static void registerAnduinBanks(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.ANDUIN_BANKS, createAnduinBanks(context));
    }

    private static void registerEntwash(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.ENTWASH, createEntwash(context));
    }

    private static void registerWhiteMountains(BootstrapContext<Biome> context) {
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS, createWhiteMountains(context));
    }

    // Методы создания уникальных биомов
    private static Biome createPelennorPlains(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(DEFAULT_SKY)
                        .fogColor(DEFAULT_FOG)
                        .waterColor(DEFAULT_WATER)
                        .waterFogColor(DEFAULT_WATER_FOG)
                        .grassColorOverride(8703593)
                        .foliageColorOverride(8703593)
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome createFirienWood(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 5163746, 4974145),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createDruadanForest(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 7039851, 6141189),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createGreywood(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 5921582, 4606833),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createWhiteMountainsFoothills(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 7976602, 7368816),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createAnduinBanks(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 4237920, 2922065),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createEntwash(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 3456269, 2142527),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createWhiteMountains(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 7976602, 8098933),
                settings -> {

                },
                generation -> {

                });
    }

    // Универсальный метод для создания биома с кастомными функциями
    private static Biome createBiome(BootstrapContext<Biome> context, BiomeColorsDTO colors,
                                     java.util.function.Consumer<MobSpawnSettings.Builder> mobSettingsCustomizer,
                                     java.util.function.Consumer<BiomeGenerationSettings.Builder> generationCustomizer) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        mobSettingsCustomizer.accept(spawnSettings);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        generationCustomizer.accept(generationSettings);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(colors.skyColor)
                        .fogColor(colors.fogColor)
                        .waterColor(colors.waterColor)
                        .waterFogColor(colors.waterFogColor)
                        .grassColorOverride(colors.grassColor)
                        .foliageColorOverride(colors.foliageColor)
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static void addDefaultOres(BiomeGenerationSettings.Builder generationSettings) {
        List<ResourceKey<PlacedFeature>> undergroundOres = List.of(
                OrePlacements.ORE_DIRT,
                OrePlacements.ORE_GRAVEL,
                OrePlacements.ORE_GRANITE_UPPER,
                OrePlacements.ORE_GRANITE_LOWER,
                OrePlacements.ORE_DIORITE_UPPER,
                OrePlacements.ORE_DIORITE_LOWER,
                OrePlacements.ORE_ANDESITE_UPPER,
                OrePlacements.ORE_ANDESITE_LOWER,
                OrePlacements.ORE_TUFF,
                OrePlacements.ORE_COAL_UPPER
        );

        undergroundOres.stream()
                .sorted(Comparator.comparing(ResourceKey::toString))
                .forEach(feature -> generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature));
    }

    private static void addDefaultVegetation(BiomeGenerationSettings.Builder generationSettings) {
        List<ResourceKey<PlacedFeature>> vegetation = List.of(
                VegetationPlacements.PATCH_GRASS_FOREST,
                VegetationPlacements.FLOWER_DEFAULT,
                VegetationPlacements.BROWN_MUSHROOM_NORMAL,
                VegetationPlacements.RED_MUSHROOM_NORMAL,
                VegetationPlacements.PATCH_SUGAR_CANE,
                VegetationPlacements.PATCH_PUMPKIN
        );

        vegetation.stream()
                .sorted(Comparator.comparing(ResourceKey::toString))
                .forEach(feature -> generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature));
    }
    public static void addCarversAndLakes(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
    }

    public static void addUndergroundFeatures(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }
    public static void addSurfaceFeatures(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}
