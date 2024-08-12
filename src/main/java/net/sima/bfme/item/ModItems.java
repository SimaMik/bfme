package net.sima.bfme.item;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
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


    public static final DeferredItem<Item> GONDORIAN_HAMMER = ITEMS.register("gondorian_hammer",
            () -> new HammerItem(1,2,5,3,1000, 10, new Item.Properties()));

}
