package net.sima.bfme.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomBooleanFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.worldgen.tree.custom.LayeredConiferFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.OvalClusterFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.PalmCrownFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.RootedBranchingTrunkPlacer;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    // === Trees ===
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND_KEY = registerKey("almond");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_KEY = registerKey("banana");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_KEY = registerKey("baobab");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEECH_KEY = registerKey("beech");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEDAR_KEY = registerKey("cedar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT_KEY = registerKey("chestnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_KEY = registerKey("cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DATE_PALM_KEY = registerKey("date_palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_KEY = registerKey("fir");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_OAK_KEY = registerKey("green_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_KEY = registerKey("holly");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KUNTZ_KEY = registerKey("kuntz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAIRELOSSE_KEY = registerKey("lairelosse");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_KEY = registerKey("larch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEBETHRON_KEY = registerKey("lebethron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_KEY = registerKey("lime");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MALLORN_KEY = registerKey("mallorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_KEY = registerKey("mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MIRK_OAK_KEY = registerKey("mirk_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_KEY = registerKey("olive");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY = registerKey("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_KEY = registerKey("pear");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POMEGRANATE_KEY = registerKey("pomegranate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_KEY = registerKey("red_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_KEY = registerKey("red_wood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAHOGANY_KEY = registerKey("red_mahogany");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registerKey("willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEQUOIA_KEY = registerKey("sequoia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHIRE_SPRUCE_KEY = registerKey("shire_spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_KEY = registerKey("cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGROVE_KEY = registerKey("mangrove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGON_KEY = registerKey("dragon");

    // Cave pillars — натуральные каменные колонны через CavePillarFeature (LargeDripstone-style).
    // Заменяют noise-based pillars (NoiseRouterData.pillars()) — лучше perf, без aliasing.
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_PILLAR_STONE = registerKey("cave_pillar_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_PILLAR_DEEPSLATE = registerKey("cave_pillar_deepslate");

    // Crystal cave features
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_COLUMN = registerKey("crystal_column");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_PATCH = registerKey("calcite_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_POOL = registerKey("calcite_pool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_POOL_OR_PATCH = registerKey("calcite_pool_or_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_CEILING = registerKey("amethyst_ceiling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_FLOOR = registerKey("amethyst_floor");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CALCITE_CRYSTAL = registerKey("ore_calcite_crystal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIORITE_CRYSTAL = registerKey("ore_diorite_crystal");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // === Trees ===
        register(context, ALMOND_KEY, Feature.TREE, almondTree(ModBlocks.ALMOND_LOG, ModBlocks.ALMOND_LEAVES));
        register(context, APPLE_KEY, Feature.TREE, appleTree(ModBlocks.APPLE_LOG, ModBlocks.APPLE_LEAVES));
        register(context, ASPEN_KEY, Feature.TREE, aspenTree(ModBlocks.ASPEN_LOG, ModBlocks.ASPEN_LEAVES));

        register(context, BANANA_KEY, Feature.TREE, bananaTree(ModBlocks.BANANA_LOG, ModBlocks.BANANA_LEAVES));
        register(context, BAOBAB_KEY, Feature.TREE, baobabTree(ModBlocks.BAOBAB_LOG, ModBlocks.BAOBAB_LEAVES));

        register(context, BEECH_KEY, Feature.TREE, beechTree(ModBlocks.BEECH_LOG, ModBlocks.BEECH_LEAVES));
        register(context, CEDAR_KEY, Feature.TREE, cedarTree(ModBlocks.CEDAR_LOG, ModBlocks.CEDAR_LEAVES));
        register(context, CHESTNUT_KEY, Feature.TREE, chestnutTree(ModBlocks.CHESTNUT_LOG, ModBlocks.CHESTNUT_LEAVES));
        register(context, CYPRESS_KEY, Feature.TREE, cypressTree(ModBlocks.CYPRESS_LOG, ModBlocks.CYPRESS_LEAVES));
        register(context, DATE_PALM_KEY, Feature.TREE, datePalmTree(ModBlocks.DATE_PALM_LOG, ModBlocks.DATE_PALM_LEAVES));
        register(context, FIR_KEY, Feature.TREE, firTree(ModBlocks.FIR_LOG, ModBlocks.FIR_LEAVES));

        register(context, GREEN_OAK_KEY, Feature.TREE, greenOakTree(ModBlocks.GREEN_OAK_LOG, ModBlocks.GREEN_OAK_LEAVES));
        register(context, HOLLY_KEY, Feature.TREE, hollyTree(ModBlocks.HOLLY_LOG, ModBlocks.HOLLY_LEAVES));
        register(context, KUNTZ_KEY, Feature.TREE, kuntzTree(ModBlocks.KUNTZ_LOG, ModBlocks.KUNTZ_LEAVES));
        register(context, LAIRELOSSE_KEY, Feature.TREE, lairelosseTree(ModBlocks.LAIRELOSSE_LOG, ModBlocks.LAIRELOSSE_LEAVES));
        register(context, LARCH_KEY, Feature.TREE, larchTree(ModBlocks.LARCH_LOG, ModBlocks.LARCH_LEAVES));
        register(context, LEBETHRON_KEY, Feature.TREE, lebethronTree(ModBlocks.LEBETHRON_LOG, ModBlocks.LEBETHRON_LEAVES));

        register(context, LEMON_KEY, Feature.TREE, lemonTree(ModBlocks.LEMON_LOG, ModBlocks.LEMON_LEAVES));
        register(context, LIME_KEY, Feature.TREE, limeTree(ModBlocks.LIME_LOG, ModBlocks.LIME_LEAVES));
        register(context, MALLORN_KEY, Feature.TREE, mallornTree(ModBlocks.MALLORN_LOG, ModBlocks.MALLORN_LEAVES));
        register(context, MANGO_KEY, Feature.TREE, mangoTree(ModBlocks.MANGO_LOG, ModBlocks.MANGO_LEAVES));
        register(context, MAPLE_KEY, Feature.TREE, mapleTree(ModBlocks.MAPLE_LOG, ModBlocks.MAPLE_LEAVES));
        register(context, MIRK_OAK_KEY, Feature.TREE, mirkOakTree(ModBlocks.MIRK_OAK_LOG, ModBlocks.MIRK_OAK_LEAVES));

        register(context, OLIVE_KEY, Feature.TREE, oliveTree(ModBlocks.OLIVE_LOG, ModBlocks.OLIVE_LEAVES));
        register(context, ORANGE_KEY, Feature.TREE, orangeTree(ModBlocks.ORANGE_LOG, ModBlocks.ORANGE_LEAVES));
        register(context, PALM_KEY, Feature.TREE, palmTree(ModBlocks.PALM_LOG, ModBlocks.PALM_LEAVES));
        register(context, PEAR_KEY, Feature.TREE, pearTree(ModBlocks.PEAR_LOG, ModBlocks.PEAR_LEAVES));
        register(context, PINE_KEY, Feature.TREE, pineTree(ModBlocks.PINE_LOG, ModBlocks.PINE_LEAVES));
        register(context, PLUM_KEY, Feature.TREE, plumTree(ModBlocks.PLUM_LOG, ModBlocks.PLUM_LEAVES));
        register(context, POMEGRANATE_KEY, Feature.TREE, pomegranateTree(ModBlocks.POMEGRANATE_LOG, ModBlocks.POMEGRANATE_LEAVES));

        register(context, RED_OAK_KEY, Feature.TREE, redOakTree(ModBlocks.RED_OAK_LOG, ModBlocks.RED_OAK_LEAVES));
        register(context, REDWOOD_KEY, Feature.TREE, redwoodTree(ModBlocks.REDWOOD_LOG, ModBlocks.REDWOOD_LEAVES));
        register(context, RED_MAHOGANY_KEY, Feature.TREE, redMahoganyTree(ModBlocks.RED_MAHOGANY_LOG, ModBlocks.RED_MAHOGANY_LEAVES));
        register(context, WILLOW_KEY, Feature.TREE, willowTree(ModBlocks.WILLOW_LOG, ModBlocks.WILLOW_LEAVES));

        // === Cave pillars — square body + accumulating flare layers у концов ===
        // Высота 6..150, radius 1..10, multimodal distribution.
        register(context, CAVE_PILLAR_STONE, ModFeatures.CAVE_PILLAR.get(),
                new CavePillarFeature.Config(Blocks.STONE.defaultBlockState(), 0, 4, 4, 150));
        register(context, CAVE_PILLAR_DEEPSLATE, ModFeatures.CAVE_PILLAR.get(),
                new CavePillarFeature.Config(Blocks.DEEPSLATE.defaultBlockState(), 0, 4, 4, 150));

        // === Толстые колонны (как LargeDripstone) ===
        register(context, CRYSTAL_COLUMN, ModFeatures.CRYSTAL_COLUMN.get(),
                new CrystalColumnFeature.Config(0));

        // === Кальцитовые патчи/озёра (как lush caves clay) ===
        Holder<PlacedFeature> noVegetation = PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.AIR)));

        // Сухой патч кальцита
        register(context, CALCITE_PATCH, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.LUSH_GROUND_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.CALCITE),
                        noVegetation,
                        CaveSurface.FLOOR,
                        ConstantInt.of(3),
                        0.8F, 2, 0.0F,
                        UniformInt.of(4, 7), 0.7F));

        // Кальцитовое озеро
        register(context, CALCITE_POOL, Feature.WATERLOGGED_VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.LUSH_GROUND_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.CALCITE),
                        noVegetation,
                        CaveSurface.FLOOR,
                        ConstantInt.of(3),
                        0.8F, 5, 0.0F,
                        UniformInt.of(4, 7), 0.7F));

        // 50/50 патч или озеро
        register(context, CALCITE_POOL_OR_PATCH, Feature.RANDOM_BOOLEAN_SELECTOR,
                new RandomBooleanFeatureConfiguration(
                        PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CALCITE_PATCH)),
                        PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(CALCITE_POOL))));

        // === Потолочные пятна (меньше, разнообразнее) ===
        BlockStateProvider patchBlocks = new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder()
                        .add(Blocks.AMETHYST_BLOCK.defaultBlockState(), 6)
                        .add(Blocks.CALCITE.defaultBlockState(), 2)
                        .add(Blocks.DIORITE.defaultBlockState(), 1)
                        .add(Blocks.BUDDING_AMETHYST.defaultBlockState(), 1)
                        .build());

        register(context, AMETHYST_CEILING, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.BASE_STONE_OVERWORLD,
                        patchBlocks,
                        noVegetation,
                        CaveSurface.CEILING,
                        UniformInt.of(1, 2),
                        0.0F, 5, 0.08F,
                        UniformInt.of(2, 5), 0.3F));

        // === Напольные пятна (меньше, разнообразнее) ===
        register(context, AMETHYST_FLOOR, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.BASE_STONE_OVERWORLD,
                        patchBlocks,
                        noVegetation,
                        CaveSurface.FLOOR,
                        UniformInt.of(1, 2),
                        0.0F, 5, 0.08F,
                        UniformInt.of(2, 5), 0.3F));

        // === Рудные патчи кальцита и диорита ===
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);

        register(context, ORE_CALCITE_CRYSTAL, Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(stoneReplaceable, Blocks.CALCITE.defaultBlockState())
                ), 64));

        register(context, ORE_DIORITE_CRYSTAL, Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(stoneReplaceable, Blocks.DIORITE.defaultBlockState())
                ), 64));
    }

    // =========================
// Tree profiles
// =========================

    private static TreeConfiguration pineTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Сосна: высокая, узкая, прямой ствол, крона начинается высоко, нижняя часть ствола видна.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        16, 5, 4,
                        0, 1,
                        2, 3,
                        25,
                        78,
                        25,
                        2, 4,
                        2, 4,
                        false
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        15, 0, 3, 3, 38),
                2, 0, 2);
    }

    private static TreeConfiguration firTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Пихта: плотнее и ниже сосны, конус более полный.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        13, 4, 4,
                        0, 1,
                        2, 3,
                        15,
                        72,
                        25,
                        3, 5,
                        2, 4,
                        false
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        13, 1, 4, 2, 26),
                2, 0, 2);
    }

    private static TreeConfiguration cedarTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Кедр: высокий хвойный, но шире сосны, более массивная верхняя крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        15, 5, 5,
                        1, 2,
                        3, 5,
                        20,
                        66,
                        30,
                        4, 6,
                        2, 5,
                        true
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        15, 1, 4, 2, 30),
                2, 0, 2);
    }

    private static TreeConfiguration larchTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Лиственница: высокая, легче и воздушнее ели/пихты.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        14, 5, 4,
                        1, 2,
                        2, 4,
                        30,
                        68,
                        25,
                        3, 5,
                        2, 4,
                        false
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        13, 0, 3, 3, 48),
                2, 0, 2);
    }

    private static TreeConfiguration shireSpruceTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Ширская ель: уютная, не гигантская, плотная нижняя крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        10, 4, 3,
                        0, 1,
                        2, 3,
                        20,
                        66,
                        25,
                        3, 5,
                        2, 4,
                        false
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        11, 1, 3, 1, 24),
                2, 0, 2);
    }

    private static TreeConfiguration cypressTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Кипарис: очень узкий вертикальный силуэт.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        16, 5, 4,
                        0, 0,
                        1, 1,
                        8,
                        85,
                        20,
                        1, 3,
                        1, 2,
                        false
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        17, 1, 2, 0, 12),
                2, 0, 2);
    }

    private static TreeConfiguration redwoodTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Redwood / красное дерево: высокое хвойное, не такое огромное как секвойя.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        18, 6, 5,
                        1, 3,
                        3, 5,
                        18,
                        68,
                        30,
                        5, 8,
                        3, 6,
                        true,
                        0, 1,
                        2
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        18, 1, 4, 2, 32),
                2, 1, 2);
    }

    private static TreeConfiguration sequoiaTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Секвойя: очень высокий прямой ствол, иногда толстый/супер толстый.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        25, 9, 8,
                        1, 3,
                        4, 6,
                        8,
                        72,
                        25,
                        7, 11,
                        4, 8,
                        true,
                        1, 2,
                        4
                ),
                new LayeredConiferFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        24, 1, 5, 3, 34),
                2, 1, 3);
    }

    private static TreeConfiguration aspenTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Осина: высокий тонкий ствол, лёгкая вытянутая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        11, 5, 3,
                        3, 5,
                        2, 4,
                        55,
                        60,
                        75,
                        1, 3,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        2, 3, 2, 2, 74, 42, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration beechTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Бук: ровный ствол, широкая куполообразная крона, умеренно густая.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        9, 4, 3,
                        5, 8,
                        3, 5,
                        55,
                        54,
                        62,
                        3, 5,
                        2, 4,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 3, 76, 34, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration mapleTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Клён: округлая, аккуратная, чуть асимметричная крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 3, 3,
                        5, 8,
                        3, 5,
                        75,
                        50,
                        65,
                        3, 5,
                        2, 4,
                        true
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 3, 4, 3, 78, 30, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration hollyTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Падуб: ниже, плотнее, кустистее.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        5, 2, 2,
                        4, 7,
                        2, 4,
                        95,
                        42,
                        50,
                        2, 4,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 2, 3, 3, 82, 32, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration walnutTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Орех: широкий тяжёлый ствол, раскидистая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 4, 3,
                        6, 9,
                        4, 7,
                        110,
                        45,
                        55,
                        5, 8,
                        3, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 4, 74, 34, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration chestnutTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Каштан: мощный, широкий, но аккуратнее старого дуба.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        9, 4, 3,
                        6, 9,
                        4, 7,
                        95,
                        46,
                        55,
                        5, 8,
                        3, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 3, 4, 3, 76, 32, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration greenOakTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Зелёный дуб: классический широкий дуб.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 4, 3,
                        6, 9,
                        4, 7,
                        120,
                        45,
                        52,
                        5, 8,
                        3, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 4, 74, 32, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration redOakTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Красный дуб: выше и стройнее зелёного дуба.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        10, 4, 3,
                        5, 8,
                        4, 7,
                        85,
                        50,
                        60,
                        4, 7,
                        3, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 3, 4, 3, 74, 34, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration mirkOakTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Лиходуб / Мирквуд: старый, мрачный, кривой, массивный.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        10, 5, 4,
                        8, 12,
                        5, 8,
                        185,
                        40,
                        42,
                        7, 11,
                        4, 7,
                        true,
                        0, 2,
                        3
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        5, 3, 5, 4, 68, 40, 0, 0),
                1, 1, 2);
    }

    private static TreeConfiguration appleTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return orchardTree(log, leaves, 5, 2, 2, 3, 5, 2, 4, 80);
    }

    private static TreeConfiguration pearTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return orchardTree(log, leaves, 6, 2, 2, 3, 5, 2, 4, 70);
    }

    private static TreeConfiguration plumTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return orchardTree(log, leaves, 5, 2, 2, 4, 6, 2, 4, 90);
    }

    private static TreeConfiguration cherryTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Вишня: чуть шире и мягче, чем яблоня.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        6, 2, 2,
                        5, 7,
                        2, 4,
                        95,
                        45,
                        55,
                        2, 4,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 3, 76, 34, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration almondTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Миндаль: сухой южный силуэт, легче яблони.
        return orchardTree(log, leaves, 5, 2, 1, 3, 5, 3, 5, 110);
    }

    private static TreeConfiguration lemonTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return citrusTree(log, leaves, 5, 2, 2);
    }

    private static TreeConfiguration limeTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return citrusTree(log, leaves, 4, 2, 2);
    }

    private static TreeConfiguration orangeTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        return citrusTree(log, leaves, 5, 2, 2);
    }

    private static TreeConfiguration mangoTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Манго: тропическое, плотнее и выше цитрусов.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 3, 3,
                        5, 8,
                        4, 6,
                        110,
                        48,
                        65,
                        4, 6,
                        2, 4,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 3, 4, 4, 78, 30, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration pomegranateTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Гранат: невысокий, сухой, кустистый.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        4, 2, 1,
                        4, 7,
                        2, 4,
                        130,
                        35,
                        35,
                        2, 4,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 2, 3, 3, 72, 42, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration oliveTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Олива: низкая, старая, кривая, плоская серебристая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        5, 2, 1,
                        4, 6,
                        4, 7,
                        260,
                        42,
                        28,
                        5, 8,
                        2, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 1, 4, 3, 66, 48, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration palmTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Пальма: высокий ствол, крона-перья.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        10, 4, 3,
                        0, 0,
                        1, 1,
                        80,
                        80,
                        20,
                        1, 3,
                        1, 2,
                        false
                ),
                new PalmCrownFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        10, 5, 8, 2, 4),
                1, 0, 1);
    }

    private static TreeConfiguration datePalmTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Финиковая пальма: плотнее обычной, листья чуть сильнее свисают.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        9, 4, 3,
                        0, 0,
                        1, 1,
                        70,
                        80,
                        20,
                        2, 4,
                        1, 3,
                        false
                ),
                new PalmCrownFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        12, 4, 7, 2, 5),
                1, 0, 1);
    }

    private static TreeConfiguration bananaTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Банан: ниже пальмы, широкие листья.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        5, 2, 2,
                        0, 0,
                        1, 1,
                        35,
                        80,
                        20,
                        1, 2,
                        1, 2,
                        false
                ),
                new PalmCrownFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        8, 3, 5, 1, 3),
                1, 0, 1);
    }

    private static TreeConfiguration baobabTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Баобаб: прямой, толстый/супер толстый, низкая широкая крона сверху.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 3, 2,
                        7, 11,
                        4, 7,
                        30,
                        60,
                        35,
                        8, 12,
                        4, 7,
                        true,
                        1, 2,
                        4
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        5, 2, 5, 4, 62, 48, 0, 0),
                2, 1, 2);
    }

    private static TreeConfiguration willowTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Ива: широкие ветви, свисающая листва.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        7, 3, 3,
                        7, 11,
                        4, 7,
                        130,
                        42,
                        25,
                        6, 10,
                        3, 6,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 3, 4, 4, 68, 36, 70, 4),
                1, 0, 1);
    }

    private static TreeConfiguration mangroveTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Мангр: низкий, корявый, много корней и тяжёлая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        6, 3, 3,
                        5, 9,
                        3, 6,
                        180,
                        42,
                        35,
                        9, 12,
                        4, 7,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 4, 72, 36, 20, 2),
                1, 0, 1);
    }

    private static TreeConfiguration lebethronTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Лебетрон: благородное гондорское дерево, стройное, не слишком дикое.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        11, 4, 3,
                        5, 8,
                        4, 6,
                        45,
                        55,
                        80,
                        3, 5,
                        2, 4,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 4, 3, 3, 74, 30, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration lairelosseTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Лайрелоссэ: светлое эльфийское дерево, выше и изящнее лебетрона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        13, 4, 4,
                        5, 8,
                        4, 7,
                        35,
                        58,
                        90,
                        3, 5,
                        2, 4,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 5, 3, 3, 72, 32, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration mallornTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Маллорн: высокий, величественный, иногда толстый/супер толстый, большая высокая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        16, 5, 5,
                        7, 11,
                        5, 9,
                        35,
                        52,
                        85,
                        6, 10,
                        4, 7,
                        true,
                        0, 2,
                        4
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        5, 4, 5, 4, 70, 34, 0, 0),
                1, 1, 2);
    }

    private static TreeConfiguration kuntzTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Кунцовое дерево: редкое, декоративное, немного странное.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 3, 3,
                        5, 8,
                        4, 6,
                        110,
                        50,
                        60,
                        3, 5,
                        2, 4,
                        true
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        4, 2, 4, 3, 72, 38, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration dragonTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Драконье дерево: зонтичная крона сверху, прямой/слегка ветвящийся ствол.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        8, 3, 2,
                        5, 8,
                        4, 7,
                        45,
                        65,
                        35,
                        3, 5,
                        2, 4,
                        false,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        5, 1, 5, 3, 62, 54, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration redMahoganyTree(Supplier<? extends Block> log, Supplier<? extends Block> leaves) {
        // Красное махагони: тропическое, высокое, широкая тяжёлая крона.
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        11, 4, 4,
                        5, 8,
                        5, 8,
                        65,
                        50,
                        70,
                        5, 8,
                        3, 5,
                        true,
                        0, 1,
                        2
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        5, 3, 5, 4, 72, 34, 0, 0),
                1, 0, 1);
    }

// =========================
// Small helper profiles
// =========================

    private static TreeConfiguration orchardTree(Supplier<? extends Block> log,
                                                 Supplier<? extends Block> leaves,
                                                 int baseHeight,
                                                 int heightRandA,
                                                 int heightRandB,
                                                 int branchMin,
                                                 int branchMax,
                                                 int branchLengthMin,
                                                 int branchLengthMax,
                                                 int bend) {
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        baseHeight, heightRandA, heightRandB,
                        branchMin, branchMax,
                        branchLengthMin, branchLengthMax,
                        bend,
                        42,
                        52,
                        2, 4,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 2, 3, 3, 76, 36, 0, 0),
                1, 0, 1);
    }

    private static TreeConfiguration citrusTree(Supplier<? extends Block> log,
                                                Supplier<? extends Block> leaves,
                                                int baseHeight,
                                                int heightRandA,
                                                int heightRandB) {
        return tree(log, leaves,
                new RootedBranchingTrunkPlacer(
                        baseHeight, heightRandA, heightRandB,
                        4, 6,
                        2, 4,
                        70,
                        42,
                        50,
                        2, 4,
                        1, 3,
                        false
                ),
                new OvalClusterFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0),
                        3, 2, 3, 3, 80, 30, 0, 0),
                1, 0, 1);
    }
    private static TreeConfiguration tree(Supplier<? extends Block> log,
                                          Supplier<? extends Block> leaves,
                                          TrunkPlacer trunkPlacer,
                                          FoliagePlacer foliagePlacer,
                                          int limit,
                                          int lowerSize,
                                          int upperSize) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log.get()),
                trunkPlacer,
                BlockStateProvider.simple(leaves.get()),
                foliagePlacer,
                new TwoLayersFeatureSize(limit, lowerSize, upperSize)
        ).ignoreVines().build();
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature,
                                                                                          FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
