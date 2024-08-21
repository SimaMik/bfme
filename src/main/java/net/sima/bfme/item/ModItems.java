package net.sima.bfme.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.custom.HammerItem;
import net.sima.bfme.item.custom.PouchItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BFME.MOD_ID);


    public static final DeferredItem<Item> SMALL_POUCH = ITEMS.register("small_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), 9));
    public static final DeferredItem<Item> MEDIUM_POUCH = ITEMS.register("medium_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), 18));
    public static final DeferredItem<Item> LARGE_POUCH = ITEMS.register("large_pouch",
            () -> new PouchItem(new Item.Properties().stacksTo(1), 27));

    public static final DeferredItem<Item> RAW_AMBER = ITEMS.register("raw_amber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_AMETHYST = ITEMS.register("raw_amethyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_DIAMOND = ITEMS.register("raw_diamond",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_EMERALD = ITEMS.register("raw_emerald",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_OPAL = ITEMS.register("raw_opal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_RUBY = ITEMS.register("raw_ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TOPAZ = ITEMS.register("raw_topaz",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND = ITEMS.register("diamond",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EMERALD = ITEMS.register("emerald",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SALT = ITEMS.register("raw_salt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SALTPETER = ITEMS.register("raw_saltpeter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SALTPETER = ITEMS.register("saltpeter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SULFUR = ITEMS.register("raw_sulfur",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> APPLE = ITEMS.register("apple",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> PLUM = ITEMS.register("plum",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> CHESTNUT = ITEMS.register("chestnut",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> ALMOND = ITEMS.register("almond",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> LIME = ITEMS.register("lime",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> OLIVE = ITEMS.register("olive",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));
    public static final DeferredItem<Item> POMERGRANATE = ITEMS.register("pomergranate",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).build())));

    public static final DeferredItem<Item> APPLE_SIGN = ITEMS.register("apple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.APPLE_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get()));
    public static final DeferredItem<Item> APPLE_HANGING_SIGN = ITEMS.register("apple_hanging_sign",
            () -> new HangingSignItem(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PEAR_SIGN = ITEMS.register("pear_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PEAR_SIGN.get(), ModBlocks.PEAR_WALL_SIGN.get()));
    public static final DeferredItem<Item> PEAR_HANGING_SIGN = ITEMS.register("pear_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PEAR_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PLUM_SIGN = ITEMS.register("plum_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get()));
    public static final DeferredItem<Item> PLUM_HANGING_SIGN = ITEMS.register("plum_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MALLORN_SIGN = ITEMS.register("mallorn_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MALLORN_SIGN.get(), ModBlocks.MALLORN_WALL_SIGN.get()));
    public static final DeferredItem<Item> MALLORN_HANGING_SIGN = ITEMS.register("mallorn_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MALLORN_HANGING_SIGN.get(), ModBlocks.MALLORN_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CHARRED_SIGN = ITEMS.register("charred_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CHARRED_SIGN.get(), ModBlocks.CHARRED_WALL_SIGN.get()));
    public static final DeferredItem<Item> CHARRED_HANGING_SIGN = ITEMS.register("charred_hanging_sign",
            () -> new HangingSignItem(ModBlocks.CHARRED_HANGING_SIGN.get(), ModBlocks.CHARRED_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> WILLOW_SIGN = ITEMS.register("willow_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.WILLOW_SIGN.get(), ModBlocks.WILLOW_WALL_SIGN.get()));
    public static final DeferredItem<Item> WILLOW_HANGING_SIGN = ITEMS.register("willow_hanging_sign",
            () -> new HangingSignItem(ModBlocks.WILLOW_HANGING_SIGN.get(), ModBlocks.WILLOW_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> BEECH_SIGN = ITEMS.register("beech_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.BEECH_SIGN.get(), ModBlocks.BEECH_WALL_SIGN.get()));
    public static final DeferredItem<Item> BEECH_HANGING_SIGN = ITEMS.register("beech_hanging_sign",
            () -> new HangingSignItem(ModBlocks.BEECH_HANGING_SIGN.get(), ModBlocks.BEECH_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> BAOBAB_SIGN = ITEMS.register("baobab_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.BAOBAB_SIGN.get(), ModBlocks.BAOBAB_WALL_SIGN.get()));
    public static final DeferredItem<Item> BAOBAB_HANGING_SIGN = ITEMS.register("baobab_hanging_sign",
            () -> new HangingSignItem(ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PINE_SIGN = ITEMS.register("pine_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PINE_SIGN.get(), ModBlocks.PINE_WALL_SIGN.get()));
    public static final DeferredItem<Item> PINE_HANGING_SIGN = ITEMS.register("pine_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> HOLLY_SIGN = ITEMS.register("holly_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HOLLY_SIGN.get(), ModBlocks.HOLLY_WALL_SIGN.get()));
    public static final DeferredItem<Item> HOLLY_HANGING_SIGN = ITEMS.register("holly_hanging_sign",
            () -> new HangingSignItem(ModBlocks.HOLLY_HANGING_SIGN.get(), ModBlocks.HOLLY_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> GREEN_OAK_SIGN = ITEMS.register("green_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.GREEN_OAK_SIGN.get(), ModBlocks.GREEN_OAK_WALL_SIGN.get()));
    public static final DeferredItem<Item> GREEN_OAK_HANGING_SIGN = ITEMS.register("green_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.GREEN_OAK_HANGING_SIGN.get(), ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> RED_OAK_SIGN = ITEMS.register("red_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.RED_OAK_SIGN.get(), ModBlocks.RED_OAK_WALL_SIGN.get()));
    public static final DeferredItem<Item> RED_OAK_HANGING_SIGN = ITEMS.register("red_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.RED_OAK_HANGING_SIGN.get(), ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MIRK_OAK_SIGN = ITEMS.register("mirk_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MIRK_OAK_SIGN.get(), ModBlocks.MIRK_OAK_WALL_SIGN.get()));
    public static final DeferredItem<Item> MIRK_OAK_HANGING_SIGN = ITEMS.register("mirk_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MIRK_OAK_HANGING_SIGN.get(), ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));
    public static final DeferredItem<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> PALM_SIGN = ITEMS.register("palm_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PALM_SIGN.get(), ModBlocks.PALM_WALL_SIGN.get()));
    public static final DeferredItem<Item> PALM_HANGING_SIGN = ITEMS.register("palm_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CHESTNUT_SIGN = ITEMS.register("chestnut_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CHESTNUT_SIGN.get(), ModBlocks.CHESTNUT_WALL_SIGN.get()));
    public static final DeferredItem<Item> CHESTNUT_HANGING_SIGN = ITEMS.register("chestnut_hanging_sign",
            () -> new HangingSignItem(ModBlocks.CHESTNUT_HANGING_SIGN.get(), ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ASPEN_SIGN = ITEMS.register("aspen_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ASPEN_SIGN.get(), ModBlocks.ASPEN_WALL_SIGN.get()));
    public static final DeferredItem<Item> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign",
            () -> new HangingSignItem(ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CEDAR_SIGN = ITEMS.register("cedar_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CEDAR_SIGN.get(), ModBlocks.CEDAR_WALL_SIGN.get()));
    public static final DeferredItem<Item> CEDAR_HANGING_SIGN = ITEMS.register("cedar_hanging_sign",
            () -> new HangingSignItem(ModBlocks.CEDAR_HANGING_SIGN.get(), ModBlocks.CEDAR_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> FIR_SIGN = ITEMS.register("fir_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.FIR_SIGN.get(), ModBlocks.FIR_WALL_SIGN.get()));
    public static final DeferredItem<Item> FIR_HANGING_SIGN = ITEMS.register("fir_hanging_sign",
            () -> new HangingSignItem(ModBlocks.FIR_HANGING_SIGN.get(), ModBlocks.FIR_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LARCH_SIGN = ITEMS.register("larch_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.LARCH_SIGN.get(), ModBlocks.LARCH_WALL_SIGN.get()));
    public static final DeferredItem<Item> LARCH_HANGING_SIGN = ITEMS.register("larch_hanging_sign",
            () -> new HangingSignItem(ModBlocks.LARCH_HANGING_SIGN.get(), ModBlocks.LARCH_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LAIRELOSSE_SIGN = ITEMS.register("lairelosse_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.LAIRELOSSE_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_SIGN.get()));
    public static final DeferredItem<Item> LAIRELOSSE_HANGING_SIGN = ITEMS.register("lairelosse_hanging_sign",
            () -> new HangingSignItem(ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ALMOND_SIGN = ITEMS.register("almond_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ALMOND_SIGN.get(), ModBlocks.ALMOND_WALL_SIGN.get()));
    public static final DeferredItem<Item> ALMOND_HANGING_SIGN = ITEMS.register("almond_hanging_sign",
            () -> new HangingSignItem(ModBlocks.ALMOND_HANGING_SIGN.get(), ModBlocks.ALMOND_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> BANANA_SIGN = ITEMS.register("banana_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.BANANA_SIGN.get(), ModBlocks.BANANA_WALL_SIGN.get()));
    public static final DeferredItem<Item> BANANA_HANGING_SIGN = ITEMS.register("banana_hanging_sign",
            () -> new HangingSignItem(ModBlocks.BANANA_HANGING_SIGN.get(), ModBlocks.BANANA_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CYPRESS_SIGN = ITEMS.register("cypress_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CYPRESS_SIGN.get(), ModBlocks.CYPRESS_WALL_SIGN.get()));
    public static final DeferredItem<Item> CYPRESS_HANGING_SIGN = ITEMS.register("cypress_hanging_sign",
            () -> new HangingSignItem(ModBlocks.CYPRESS_HANGING_SIGN.get(), ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> DATE_PALM_SIGN = ITEMS.register("date_palm_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.DATE_PALM_SIGN.get(), ModBlocks.DATE_PALM_WALL_SIGN.get()));
    public static final DeferredItem<Item> DATE_PALM_HANGING_SIGN = ITEMS.register("date_palm_hanging_sign",
            () -> new HangingSignItem(ModBlocks.DATE_PALM_HANGING_SIGN.get(), ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> KUNTZ_SIGN = ITEMS.register("kuntz_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.KUNTZ_SIGN.get(), ModBlocks.KUNTZ_WALL_SIGN.get()));
    public static final DeferredItem<Item> KUNTZ_HANGING_SIGN = ITEMS.register("kuntz_hanging_sign",
            () -> new HangingSignItem(ModBlocks.KUNTZ_HANGING_SIGN.get(), ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LEBETHRON_SIGN = ITEMS.register("lebethron_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.LEBETHRON_SIGN.get(), ModBlocks.LEBETHRON_WALL_SIGN.get()));
    public static final DeferredItem<Item> LEBETHRON_HANGING_SIGN = ITEMS.register("lebethron_hanging_sign",
            () -> new HangingSignItem(ModBlocks.LEBETHRON_HANGING_SIGN.get(), ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LEMON_SIGN = ITEMS.register("lemon_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.LEMON_SIGN.get(), ModBlocks.LEMON_WALL_SIGN.get()));
    public static final DeferredItem<Item> LEMON_HANGING_SIGN = ITEMS.register("lemon_hanging_sign",
            () -> new HangingSignItem(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> LIME_SIGN = ITEMS.register("lime_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.LIME_SIGN.get(), ModBlocks.LIME_WALL_SIGN.get()));
    public static final DeferredItem<Item> LIME_HANGING_SIGN = ITEMS.register("lime_hanging_sign",
            () -> new HangingSignItem(ModBlocks.LIME_HANGING_SIGN.get(), ModBlocks.LIME_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MANGO_SIGN = ITEMS.register("mango_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MANGO_SIGN.get(), ModBlocks.MANGO_WALL_SIGN.get()));
    public static final DeferredItem<Item> MANGO_HANGING_SIGN = ITEMS.register("mango_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ORANGE_SIGN = ITEMS.register("orange_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get()));
    public static final DeferredItem<Item> ORANGE_HANGING_SIGN = ITEMS.register("orange_hanging_sign",
            () -> new HangingSignItem(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> POMERGRANATE_SIGN = ITEMS.register("pomergranate_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.POMERGRANATE_SIGN.get(), ModBlocks.POMERGRANATE_WALL_SIGN.get()));
    public static final DeferredItem<Item> POMERGRANATE_HANGING_SIGN = ITEMS.register("pomergranate_hanging_sign",
            () -> new HangingSignItem(ModBlocks.POMERGRANATE_HANGING_SIGN.get(), ModBlocks.POMERGRANATE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get()));
    public static final DeferredItem<Item> REDWOOD_HANGING_SIGN = ITEMS.register("redwood_hanging_sign",
            () -> new HangingSignItem(ModBlocks.REDWOOD_HANGING_SIGN.get(), ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> RED_MAHOGANY_SIGN = ITEMS.register("red_mahogany_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.RED_MAHOGANY_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_SIGN.get()));
    public static final DeferredItem<Item> RED_MAHOGANY_HANGING_SIGN = ITEMS.register("red_mahogany_hanging_sign",
            () -> new HangingSignItem(ModBlocks.RED_MAHOGANY_HANGING_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> OLIVE_SIGN = ITEMS.register("olive_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.OLIVE_SIGN.get(), ModBlocks.OLIVE_WALL_SIGN.get()));
    public static final DeferredItem<Item> OLIVE_HANGING_SIGN = ITEMS.register("olive_hanging_sign",
            () -> new HangingSignItem(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> GONDORIAN_HAMMER = ITEMS.register("gondorian_hammer",
            () -> new HammerItem(1,2,5,3,1000, 10, new Item.Properties()));

    public static final DeferredItem<Item> GONDORIAN_PIKE = ITEMS.register("gondorian_pike",
            () -> new HammerItem(1,2,5,3,1000, 10, new Item.Properties()));
    public static final DeferredItem<Item> GONDORIAN_PIKE1 = ITEMS.register("gondorian_pike1",
            () -> new HammerItem(1,2,5,3,1000, 10, new Item.Properties()));

}
