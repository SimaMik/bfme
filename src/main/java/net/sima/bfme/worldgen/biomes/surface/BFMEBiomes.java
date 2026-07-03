package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
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
        // Gondor / Anórien / Pelennor
        context.register(BFMEBiomeKeys.PELENNOR_PLAINS, createPelennorPlains(context));
        context.register(BFMEBiomeKeys.LOSSARNACH_FARMLANDS, createLossarnachFarmlands(context));
        context.register(BFMEBiomeKeys.ANORIEN_OPEN_LANDS, createAnorienOpenLands(context));

        // Ithilien + local forests
        context.register(BFMEBiomeKeys.NORTH_ITHILIEN, createNorthIthilien(context));
        context.register(BFMEBiomeKeys.SOUTH_ITHILIEN, createSouthIthilien(context));
        context.register(BFMEBiomeKeys.DRUADAN_FOREST, createDruadanForest(context));
        context.register(BFMEBiomeKeys.GREY_WOOD, createGreyWood(context));

        // Rivers & floodplains
        context.register(BFMEBiomeKeys.RIVER_ANDUIN, createRiverAnduin(context));
        context.register(BFMEBiomeKeys.ANDUIN_BANKS, createAnduinFloodplains(context)); // у тебя ключ называется ANDUIN_BANKS

        // Hills / transitional
        context.register(BFMEBiomeKeys.EMYN_ARNEN_HILLS, createEmynArnenHills(context));
        context.register(BFMEBiomeKeys.AMON_DIN_HILLS, createAmonDinHills(context));
        context.register(BFMEBiomeKeys.EILENACH_MOORLANDS, createEilenachMoorlands(context));

        // White Mountains
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS, createWhiteMountainsFoothills(context));
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS, createWhiteMountains(context));
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS_PEAKS, createWhiteMountainsPeaks(context));
        context.register(BFMEBiomeKeys.WHITE_MOUNTAINS_HIGH_PEAKS, createWhiteMountainsHighPeaks(context));

        // Special
        context.register(BFMEBiomeKeys.CAIR_ANDROS, createCairAndros(context));

        // Mordor
        context.register(BFMEBiomeKeys.DAGORLAD_WASTES, createDagorladWastes(context));
        context.register(BFMEBiomeKeys.GORGOROTH_PLAINS, createGorgorothPlains(context));
        context.register(BFMEBiomeKeys.EPHEL_DUATH, createEphelDuath(context));
        context.register(BFMEBiomeKeys.EPHEL_DUATH_PEAKS, createEphelDuathPeaks(context));
        context.register(BFMEBiomeKeys.EPHEL_DUATH_BLACK_PEAKS, createEphelDuathBlackPeaks(context));

        // Cave biomes
        context.register(BFMEBiomeKeys.CAVE_LUSH, createCaveLush(context));
        context.register(BFMEBiomeKeys.CAVE_DRIPSTONE, createCaveDripstone(context));
        context.register(BFMEBiomeKeys.CAVE_CRYSTAL, createCaveCrystal(context));
    }

    private static Biome createEphelDuathBlackPeaks(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x5A5546, 0x504B3C),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createEphelDuathPeaks(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x6E6955, 0x625E4A),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createEphelDuath(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x646450, 0x585846),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createGorgorothPlains(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x78735A, 0x6C6750),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createDagorladWastes(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x918C64, 0x857F58),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createCairAndros(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x6EC34B, 0x5EB840),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createWhiteMountainsHighPeaks(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x969678, 0x8A8A6C),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createWhiteMountainsPeaks(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x8C9B6E, 0x7F8F62),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createEilenachMoorlands(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x87A55A, 0x7A9850),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createAmonDinHills(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x8CAF5F, 0x7EA352),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createEmynArnenHills(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x78B950, 0x68AE45),
                settings -> {
                },
                generation -> {
                });
    }

    private static Biome createAnduinFloodplains(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x78C358, 0x6AB84D),
            settings -> {
            },
            generation -> {
            });
    }

    private static Biome createRiverAnduin(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x6EBE50, 0x60B245),
            settings -> {
            },
            generation -> {
            });
    }
    private static Biome createGreyWood(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x6E9B55, 0x5E8E48),
            settings -> {
            },
            generation -> {
            });
    }

    private static Biome createSouthIthilien(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x64B84A, 0x55AC40),
            settings -> {
            },
            generation -> {
            });
    }

    private static Biome createNorthIthilien(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x5FB446, 0x4FA83C),
            settings -> {
            },
            generation -> {
            });
    }

    private static Biome createAnorienOpenLands(BootstrapContext<Biome> context) { return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x96C355, 0x88B84A),
            settings -> {
            },
            generation -> {
            });
    }

    private static Biome createLossarnachFarmlands(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x7DC350, 0x6DB845),
                settings -> {
                },
                generation -> {
                });
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
                        .grassColorOverride(0x8CC85A)
                        .foliageColorOverride(0x7BBF52)
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }


    private static Biome createDruadanForest(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x4B9637, 0x3D8A2E),
                settings -> {
                },
                generation -> {
                });
    }


    private static Biome createWhiteMountainsFoothills(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x78AA5A, 0x6B9E50),
                settings -> {
                },
                generation -> {
                });
    }


    private static Biome createWhiteMountains(BootstrapContext<Biome> context) {
        return createBiome(context, new BiomeColorsDTO(DEFAULT_SKY, DEFAULT_FOG, DEFAULT_WATER, DEFAULT_WATER_FOG, 0x82A064, 0x769558),
                settings -> {

                },
                generation -> {

                });
    }

    // === CAVE BIOMES ===

    private static Biome createCaveLush(BootstrapContext<Biome> context) {
        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // addDefaultOres УБРАН — руды теперь управляются через BFMEChunkGenerator.applyOres()
        // на основе SURFACE biome, не cave biome. См. ModOreFeatures.
        // UNDERWATER_MAGMA отдельно — раньше шла в addDefaultOres.
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
        // Cave pillars (LargeDripstone-style каменные колонны)
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_STONE);
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_DEEPSLATE);
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(genSettings);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.5f)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4).waterFogColor(0x050533)
                        .fogColor(0xC0D8FF).skyColor(0x7BA5FF)
                        .grassColorOverride(0x59AE30).foliageColorOverride(0x59AE30)
                        .build())
                .generationSettings(genSettings.build())
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .build();
    }

    private static Biome createCaveDripstone(BootstrapContext<Biome> context) {
        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // addDefaultOres УБРАН — руды теперь управляются через BFMEChunkGenerator.applyOres()
        // UNDERWATER_MAGMA отдельно — раньше шла в addDefaultOres.
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
        // Cave pillars (LargeDripstone-style каменные колонны)
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_STONE);
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_DEEPSLATE);
        BiomeDefaultFeatures.addDripstone(genSettings);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.5f)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4).waterFogColor(0x050533)
                        .fogColor(0xC0D8FF).skyColor(0x7BA5FF)
                        .build())
                .generationSettings(genSettings.build())
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .build();
    }

    private static Biome createCaveCrystal(BootstrapContext<Biome> context) {
        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // addDefaultOres УБРАН — руды теперь управляются через BFMEChunkGenerator.applyOres()
        // UNDERWATER_MAGMA отдельно — раньше шла в addDefaultOres.
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
        // Cave pillars (LargeDripstone-style каменные колонны)
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_STONE);
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_DEEPSLATE);

        // Толстые аметистовые колонны (как LargeDripstone)
        genSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CRYSTAL_COLUMN);
        // Кальцитовые озёра/патчи
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CALCITE_POOL);
        // Пятна аметиста на потолке и полу
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.AMETHYST_CEILING);
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.AMETHYST_FLOOR);
        // Скопления кальцита и диорита в стенах
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.ORE_CALCITE_CRYSTAL);
        genSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.ORE_DIORITE_CRYSTAL);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.3f)
                .downfall(0.3f)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4).waterFogColor(0x050533)
                        .fogColor(0xD0C8FF).skyColor(0x9B8FFF)
                        .build())
                .generationSettings(genSettings.build())
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .build();
    }

    // Универсальный метод для создания биома с кастомными функциями
    private static Biome createBiome(BootstrapContext<Biome> context, BiomeColorsDTO colors,
                                     java.util.function.Consumer<MobSpawnSettings.Builder> mobSettingsCustomizer,
                                     java.util.function.Consumer<BiomeGenerationSettings.Builder> generationCustomizer) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        mobSettingsCustomizer.accept(spawnSettings);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        generationCustomizer.accept(generationSettings);
        // Ванильная UNDERWATER_MAGMA — magma_block в подводных пещерах (на 2+ блока ниже surface).
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
        // Cave pillars — natural каменные колонны (LargeDripstone-style).
        generationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_STONE);
        generationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                net.sima.bfme.worldgen.features.ModPlacedFeatures.CAVE_PILLAR_DEEPSLATE);

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
