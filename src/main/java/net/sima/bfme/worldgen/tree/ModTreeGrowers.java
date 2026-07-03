package net.sima.bfme.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.features.ModConfiguredFeatures;

import java.util.Optional;

/**
 * TreeGrower-ы для sapling-блоков.
 *
 * Использование в ModBlocks:
 * new SaplingBlock(ModTreeGrowers.PINE, properties)
 */
public class ModTreeGrowers {

    public static final TreeGrower ALMOND = tree("almond", ModConfiguredFeatures.ALMOND_KEY);
    public static final TreeGrower APPLE = tree("apple", ModConfiguredFeatures.APPLE_KEY);
    public static final TreeGrower ASPEN = tree("aspen", ModConfiguredFeatures.ASPEN_KEY);
    public static final TreeGrower BANANA = tree("banana", ModConfiguredFeatures.BANANA_KEY);
    public static final TreeGrower BAOBAB = tree("baobab", ModConfiguredFeatures.BAOBAB_KEY);
    public static final TreeGrower BEECH = tree("beech", ModConfiguredFeatures.BEECH_KEY);
    public static final TreeGrower CEDAR = tree("cedar", ModConfiguredFeatures.CEDAR_KEY);
    public static final TreeGrower CHESTNUT = tree("chestnut", ModConfiguredFeatures.CHESTNUT_KEY);
    public static final TreeGrower CYPRESS = tree("cypress", ModConfiguredFeatures.CYPRESS_KEY);
    public static final TreeGrower DATE_PALM = tree("date_palm", ModConfiguredFeatures.DATE_PALM_KEY);
    public static final TreeGrower FIR = tree("fir", ModConfiguredFeatures.FIR_KEY);
    public static final TreeGrower GREEN_OAK = tree("green_oak", ModConfiguredFeatures.GREEN_OAK_KEY);
    public static final TreeGrower HOLLY = tree("holly", ModConfiguredFeatures.HOLLY_KEY);
    public static final TreeGrower KUNTZ = tree("kuntz", ModConfiguredFeatures.KUNTZ_KEY);
    public static final TreeGrower LAIRELOSSE = tree("lairelosse", ModConfiguredFeatures.LAIRELOSSE_KEY);
    public static final TreeGrower LARCH = tree("larch", ModConfiguredFeatures.LARCH_KEY);
    public static final TreeGrower LEBETHRON = tree("lebethron", ModConfiguredFeatures.LEBETHRON_KEY);
    public static final TreeGrower LEMON = tree("lemon", ModConfiguredFeatures.LEMON_KEY);
    public static final TreeGrower LIME = tree("lime", ModConfiguredFeatures.LIME_KEY);
    public static final TreeGrower MALLORN = tree("mallorn", ModConfiguredFeatures.MALLORN_KEY);
    public static final TreeGrower MANGO = tree("mango", ModConfiguredFeatures.MANGO_KEY);
    public static final TreeGrower MAPLE = tree("maple", ModConfiguredFeatures.MAPLE_KEY);
    public static final TreeGrower MIRK_OAK = tree("mirk_oak", ModConfiguredFeatures.MIRK_OAK_KEY);
    public static final TreeGrower OLIVE = tree("olive", ModConfiguredFeatures.OLIVE_KEY);
    public static final TreeGrower ORANGE = tree("orange", ModConfiguredFeatures.ORANGE_KEY);
    public static final TreeGrower PALM = tree("palm", ModConfiguredFeatures.PALM_KEY);
    public static final TreeGrower PEAR = tree("pear", ModConfiguredFeatures.PEAR_KEY);
    public static final TreeGrower PINE = tree("pine", ModConfiguredFeatures.PINE_KEY);
    public static final TreeGrower PLUM = tree("plum", ModConfiguredFeatures.PLUM_KEY);
    public static final TreeGrower POMEGRANATE = tree("pomegranate", ModConfiguredFeatures.POMEGRANATE_KEY);
    public static final TreeGrower RED_OAK = tree("red_oak", ModConfiguredFeatures.RED_OAK_KEY);
    public static final TreeGrower REDWOOD = tree("redwood", ModConfiguredFeatures.REDWOOD_KEY);
    public static final TreeGrower RED_MAHOGANY = tree("red_mahogany", ModConfiguredFeatures.RED_MAHOGANY_KEY);
    public static final TreeGrower WILLOW = tree("willow", ModConfiguredFeatures.WILLOW_KEY);
    public static final TreeGrower SEQUOIA = tree("sequoia", ModConfiguredFeatures.SEQUOIA_KEY);
    public static final TreeGrower SHIRE_SPRUCE = tree("shire_spruce", ModConfiguredFeatures.SHIRE_SPRUCE_KEY);
    public static final TreeGrower CHERRY = tree("cherry", ModConfiguredFeatures.CHERRY_KEY);
    public static final TreeGrower MANGROVE = tree("mangrove", ModConfiguredFeatures.MANGROVE_KEY);
    public static final TreeGrower DRAGON = tree("dragon", ModConfiguredFeatures.DRAGON_KEY);

    private static TreeGrower tree(String name, net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> key) {
        return new TreeGrower(BFME.MOD_ID + ":" + name, Optional.empty(), Optional.of(key), Optional.empty());
    }
}
