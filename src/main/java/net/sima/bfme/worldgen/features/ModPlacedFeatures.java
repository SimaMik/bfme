package net.sima.bfme.worldgen.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CAVE_PILLAR_STONE = registerKey("cave_pillar_stone");
    public static final ResourceKey<PlacedFeature> CAVE_PILLAR_DEEPSLATE = registerKey("cave_pillar_deepslate");
    public static final ResourceKey<PlacedFeature> CRYSTAL_COLUMN = registerKey("crystal_column");
    public static final ResourceKey<PlacedFeature> CALCITE_POOL = registerKey("calcite_pool");
    public static final ResourceKey<PlacedFeature> AMETHYST_CEILING = registerKey("amethyst_ceiling");
    public static final ResourceKey<PlacedFeature> AMETHYST_FLOOR = registerKey("amethyst_floor");
    public static final ResourceKey<PlacedFeature> ORE_CALCITE_CRYSTAL = registerKey("ore_calcite_crystal");
    public static final ResourceKey<PlacedFeature> ORE_DIORITE_CRYSTAL = registerKey("ore_diorite_crystal");

    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> ALMOND_PLACED_KEY = registerKey("almond_placed");
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final ResourceKey<PlacedFeature> ASPEN_PLACED_KEY = registerKey("aspen_placed");
    public static final ResourceKey<PlacedFeature> BANANA_PLACED_KEY = registerKey("banana_placed");
    public static final ResourceKey<PlacedFeature> BAOBAB_PLACED_KEY = registerKey("baobab_placed");
    public static final ResourceKey<PlacedFeature> BEECH_PLACED_KEY = registerKey("beech_placed");
    public static final ResourceKey<PlacedFeature> CEDAR_PLACED_KEY = registerKey("cedar_placed");
    public static final ResourceKey<PlacedFeature> CHESTNUT_PLACED_KEY = registerKey("chestnut_placed");
    public static final ResourceKey<PlacedFeature> CYPRESS_PLACED_KEY = registerKey("cypress_placed");
    public static final ResourceKey<PlacedFeature> DATE_PALM_PLACED_KEY = registerKey("date_palm_placed");
    public static final ResourceKey<PlacedFeature> FIR_PLACED_KEY = registerKey("fir_placed");
    public static final ResourceKey<PlacedFeature> GREEN_OAK_PLACED_KEY = registerKey("green_oak_placed");
    public static final ResourceKey<PlacedFeature> HOLLY_PLACED_KEY = registerKey("holly_placed");
    public static final ResourceKey<PlacedFeature> KUNTZ_PLACED_KEY = registerKey("kuntz_placed");
    public static final ResourceKey<PlacedFeature> LAIRELOSSE_PLACED_KEY = registerKey("lairelosse_placed");
    public static final ResourceKey<PlacedFeature> LARCH_PLACED_KEY = registerKey("larch_placed");
    public static final ResourceKey<PlacedFeature> LEBETHRON_PLACED_KEY = registerKey("lebethron_placed");
    public static final ResourceKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final ResourceKey<PlacedFeature> LIME_PLACED_KEY = registerKey("lime_placed");
    public static final ResourceKey<PlacedFeature> MALLORN_PLACED_KEY = registerKey("mallorn_placed");
    public static final ResourceKey<PlacedFeature> MANGO_PLACED_KEY = registerKey("mango_placed");
    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");
    public static final ResourceKey<PlacedFeature> MIRK_OAK_PLACED_KEY = registerKey("mirk_oak_placed");
    public static final ResourceKey<PlacedFeature> OLIVE_PLACED_KEY = registerKey("olive_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final ResourceKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_placed");
    public static final ResourceKey<PlacedFeature> PEAR_PLACED_KEY = registerKey("pear_placed");
    public static final ResourceKey<PlacedFeature> PINE_PLACED_KEY = registerKey("pine_placed");
    public static final ResourceKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");
    public static final ResourceKey<PlacedFeature> POMEGRANATE_PLACED_KEY = registerKey("pomegranate_placed");
    public static final ResourceKey<PlacedFeature> RED_OAK_PLACED_KEY = registerKey("red_oak_placed");
    public static final ResourceKey<PlacedFeature> RED_WOOD_PLACED_KEY = registerKey("red_wood_placed");
    public static final ResourceKey<PlacedFeature> RED_MAHOGANY_PLACED_KEY = registerKey("red_mahogany_placed");
    public static final ResourceKey<PlacedFeature> WILLOW_PLACED_KEY = registerKey("willow_placed");
  
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> cf = context.lookup(Registries.CONFIGURED_FEATURE);
        // Cave pillars stone (Y > 0, верхние cheese комнаты)
        context.register(CAVE_PILLAR_STONE, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.CAVE_PILLAR_STONE),
                List.of(
                        CountPlacement.of(UniformInt.of(0, 1)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)),
                        BiomeFilter.biome()
                )));
        // Cave pillars deepslate (Y < 0, нижние cheese комнаты)
        context.register(CAVE_PILLAR_DEEPSLATE, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.CAVE_PILLAR_DEEPSLATE),
                List.of(
                        CountPlacement.of(UniformInt.of(0, 1)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-180), VerticalAnchor.absolute(0)),
                        BiomeFilter.biome()
                )));

        // Толстые колонны — как ванильный LARGE_DRIPSTONE (10-48 попыток, фича сама ищет пещеру)
        context.register(CRYSTAL_COLUMN, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.CRYSTAL_COLUMN),
                List.of(
                        CountPlacement.of(UniformInt.of(10, 48)),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                )));

        // Кальцитовые озёра/патчи — как lush clay но реже (было 62, теперь 32)
        context.register(CALCITE_POOL, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.CALCITE_POOL_OR_PATCH),
                List.of(
                        CountPlacement.of(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(
                                Direction.DOWN,
                                BlockPredicate.solid(),
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                )));

        // Потолочные пятна аметиста
        context.register(AMETHYST_CEILING, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.AMETHYST_CEILING),
                List.of(
                        CountPlacement.of(40),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP,
                                BlockPredicate.solid(),
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                        BiomeFilter.biome()
                )));

        // Напольные пятна аметиста
        context.register(AMETHYST_FLOOR, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.AMETHYST_FLOOR),
                List.of(
                        CountPlacement.of(40),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(
                                Direction.DOWN,
                                BlockPredicate.solid(),
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                )));

        // Рудные патчи кальцита (большие скопления в стенах)
        context.register(ORE_CALCITE_CRYSTAL, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.ORE_CALCITE_CRYSTAL),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                )));

        // Рудные патчи диорита
        context.register(ORE_DIORITE_CRYSTAL, new PlacedFeature(
                cf.getOrThrow(ModConfiguredFeatures.ORE_DIORITE_CRYSTAL),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                )));
        registerTree(context, cf, ALMOND_PLACED_KEY, ModConfiguredFeatures.ALMOND_KEY, ModBlocks.ALMOND_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, APPLE_PLACED_KEY, ModConfiguredFeatures.APPLE_KEY, ModBlocks.APPLE_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, ASPEN_PLACED_KEY, ModConfiguredFeatures.ASPEN_KEY, ModBlocks.ASPEN_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, BANANA_PLACED_KEY, ModConfiguredFeatures.BANANA_KEY, ModBlocks.BANANA_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, BAOBAB_PLACED_KEY, ModConfiguredFeatures.BAOBAB_KEY, ModBlocks.BAOBAB_SAPLING, 1, 0.025F, 1);
        registerTree(context, cf, BEECH_PLACED_KEY, ModConfiguredFeatures.BEECH_KEY, ModBlocks.BEECH_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, CEDAR_PLACED_KEY, ModConfiguredFeatures.CEDAR_KEY, ModBlocks.CEDAR_SAPLING, 5, 0.125F, 1);
        registerTree(context, cf, CHESTNUT_PLACED_KEY, ModConfiguredFeatures.CHESTNUT_KEY, ModBlocks.CHESTNUT_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, CYPRESS_PLACED_KEY, ModConfiguredFeatures.CYPRESS_KEY, ModBlocks.CYPRESS_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, DATE_PALM_PLACED_KEY, ModConfiguredFeatures.DATE_PALM_KEY, ModBlocks.DATE_PALM_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, FIR_PLACED_KEY, ModConfiguredFeatures.FIR_KEY, ModBlocks.FIR_SAPLING, 5, 0.125F, 1);
        registerTree(context, cf, GREEN_OAK_PLACED_KEY, ModConfiguredFeatures.GREEN_OAK_KEY, ModBlocks.GREEN_OAK_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, HOLLY_PLACED_KEY, ModConfiguredFeatures.HOLLY_KEY, ModBlocks.HOLLY_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, KUNTZ_PLACED_KEY, ModConfiguredFeatures.KUNTZ_KEY, ModBlocks.KUNTZ_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, LAIRELOSSE_PLACED_KEY, ModConfiguredFeatures.LAIRELOSSE_KEY, ModBlocks.LAIRELOSSE_SAPLING, 1, 0.04F, 1);
        registerTree(context, cf, LARCH_PLACED_KEY, ModConfiguredFeatures.LARCH_KEY, ModBlocks.LARCH_SAPLING, 5, 0.125F, 1);
        registerTree(context, cf, LEBETHRON_PLACED_KEY, ModConfiguredFeatures.LEBETHRON_KEY, ModBlocks.LEBETHRON_SAPLING, 1, 0.04F, 1);
        registerTree(context, cf, LEMON_PLACED_KEY, ModConfiguredFeatures.LEMON_KEY, ModBlocks.LEMON_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, LIME_PLACED_KEY, ModConfiguredFeatures.LIME_KEY, ModBlocks.LIME_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, MALLORN_PLACED_KEY, ModConfiguredFeatures.MALLORN_KEY, ModBlocks.MALLORN_SAPLING, 1, 0.04F, 1);
        registerTree(context, cf, MANGO_PLACED_KEY, ModConfiguredFeatures.MANGO_KEY, ModBlocks.MANGO_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, MAPLE_PLACED_KEY, ModConfiguredFeatures.MAPLE_KEY, ModBlocks.MAPLE_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, MIRK_OAK_PLACED_KEY, ModConfiguredFeatures.MIRK_OAK_KEY, ModBlocks.MIRK_OAK_SAPLING, 1, 0.04F, 1);
        registerTree(context, cf, OLIVE_PLACED_KEY, ModConfiguredFeatures.OLIVE_KEY, ModBlocks.OLIVE_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, ORANGE_PLACED_KEY, ModConfiguredFeatures.ORANGE_KEY, ModBlocks.ORANGE_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, PALM_PLACED_KEY, ModConfiguredFeatures.PALM_KEY, ModBlocks.PALM_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, PEAR_PLACED_KEY, ModConfiguredFeatures.PEAR_KEY, ModBlocks.PEAR_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, PINE_PLACED_KEY, ModConfiguredFeatures.PINE_KEY, ModBlocks.PINE_SAPLING, 5, 0.125F, 1);
        registerTree(context, cf, PLUM_PLACED_KEY, ModConfiguredFeatures.PLUM_KEY, ModBlocks.PLUM_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, POMEGRANATE_PLACED_KEY, ModConfiguredFeatures.POMEGRANATE_KEY, ModBlocks.POMEGRANATE_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, RED_OAK_PLACED_KEY, ModConfiguredFeatures.RED_OAK_KEY, ModBlocks.RED_OAK_SAPLING, 3, 0.1F, 1);
        registerTree(context, cf, RED_WOOD_PLACED_KEY, ModConfiguredFeatures.REDWOOD_KEY, ModBlocks.REDWOOD_SAPLING, 5, 0.125F, 1);
        registerTree(context, cf, RED_MAHOGANY_PLACED_KEY, ModConfiguredFeatures.RED_MAHOGANY_KEY, ModBlocks.RED_MAHOGANY_SAPLING, 2, 0.05F, 1);
        registerTree(context, cf, WILLOW_PLACED_KEY, ModConfiguredFeatures.WILLOW_KEY, ModBlocks.WILLOW_SAPLING, 1, 0.04F, 1);
          }

    private static void registerTree(BootstrapContext<PlacedFeature> context,
                                     HolderGetter<ConfiguredFeature<?, ?>> cf,
                                     ResourceKey<PlacedFeature> placedKey,
                                     ResourceKey<ConfiguredFeature<?, ?>> configuredKey,
                                     Supplier<? extends Block> sapling,
                                     int count,
                                     float extraChance,
                                     int extraCount) {
        register(context,
                placedKey,
                cf.getOrThrow(configuredKey),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(count, extraChance, extraCount),
                        sapling.get()
                ));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuredFeature,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuredFeature, modifiers));
    }
}
