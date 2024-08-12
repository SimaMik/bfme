package net.sima.bfme.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BFME.MOD_ID);

    public static final Supplier<CreativeModeTab> GONDORIAN_TAB = CREATIVE_MODE_TABS.register("gondorian_tab",
            () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.gondorian_tab")).icon(() -> new ItemStack(ModBlocks.GONDORIAN_STONE.get()))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.GONDORIAN_WORKBENCH.get());

                output.accept(ModBlocks.GONDORIAN_STONE.get());
                output.accept(ModBlocks.GONDORIAN_STONE_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_STONE_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_STONE_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_STONE_WALL.get());
                output.accept(ModBlocks.GONDORIAN_STONE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_STONE_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_COBBLESTONE.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_BRICK.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_BRICK_BUTTON.get());

                output.accept(ModBlocks.GONDORIAN_BRICKWORK.get());
                output.accept(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_BRICKWORK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_BRICKWORK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());

                output.accept(ModBlocks.GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

                output.accept(ModBlocks.GONDORIAN_PILLAR.get());
                output.accept(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());
                output.accept(ModBlocks.GONDORIAN_COLUMN.get());
                output.accept(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
                output.accept(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
            })
            .build()
    );
    public static final Supplier<CreativeModeTab> DURIN_TAB = CREATIVE_MODE_TABS.register("durin_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.durin_tab")).icon(() -> new ItemStack(ModBlocks.DURIN_BRICK.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE.get());
                        output.accept(ModBlocks.DURIN_STONE.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE.get());
                        output.accept(ModBlocks.DURIN_BRICK.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
                        output.accept(ModBlocks.DURIN_PILLAR.get());
                        output.accept(ModBlocks.DURIN_COLUMN.get());
                        output.accept(ModBlocks.DURIN_CRACKED_PILLAR.get());
                        output.accept(ModBlocks.DURIN_CRACKED_COLUMN.get());
                        output.accept(ModBlocks.DURIN_MOSSY_PILLAR.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COLUMN.get());
                    })
                    .build()
    );
    public static final Supplier<CreativeModeTab> ORE_TAB = CREATIVE_MODE_TABS.register("ore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DIAMOND.get()))
                    .title(Component.translatable("creativetab.ore_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModBlocks.AMBER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AMBER_ORE.get());
                        output.accept(ModItems.RAW_AMBER.get());
                        output.accept(ModItems.AMBER.get());
                        output.accept(ModBlocks.AMBER_BLOCK.get());
                        output.accept(ModBlocks.AMETHYST_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AMETHYST_ORE.get());
                        output.accept(ModItems.RAW_AMETHYST.get());
                        output.accept(ModItems.AMETHYST.get());
                        output.accept(ModBlocks.AMETHYST_BLOCK.get());
                        output.accept(ModBlocks.DIAMOND_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_DIAMOND_ORE.get());
                        output.accept(ModItems.RAW_DIAMOND.get());
                        output.accept(ModItems.DIAMOND.get());
                        output.accept(ModBlocks.DIAMOND_BLOCK.get());
                        output.accept(ModBlocks.EMERALD_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_EMERALD_ORE.get());
                        output.accept(ModItems.RAW_EMERALD.get());
                        output.accept(ModItems.EMERALD.get());
                        output.accept(ModBlocks.EMERALD_BLOCK.get());
                        output.accept(ModBlocks.OPAL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_OPAL_ORE.get());
                        output.accept(ModItems.RAW_OPAL.get());
                        output.accept(ModItems.OPAL.get());
                        output.accept(ModBlocks.OPAL_BLOCK.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModItems.RAW_RUBY.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.TOPAZ_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
                        output.accept(ModItems.RAW_TOPAZ.get());
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());
                        output.accept(ModBlocks.MITHRIL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
                        output.accept(ModItems.RAW_MITHRIL.get());
                        output.accept(ModItems.MITHRIL_NUGGET.get());
                        output.accept(ModItems.MITHRIL_INGOT.get());
                        output.accept(ModBlocks.MITHRIL_BLOCK.get());
                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModItems.SILVER_NUGGET.get());
                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.SALT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SALT_ORE.get());
                        output.accept(ModItems.RAW_SALT.get());
                        output.accept(ModItems.SALT.get());
                        output.accept(ModBlocks.SALT_BLOCK.get());
                        output.accept(ModBlocks.SALTPETER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SALTPETER_ORE.get());
                        output.accept(ModItems.RAW_SALTPETER.get());
                        output.accept(ModItems.SALTPETER.get());
                        output.accept(ModBlocks.SALTPETER_BLOCK.get());
                        output.accept(ModBlocks.SULFUR_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(ModItems.RAW_SULFUR.get());
                        output.accept(ModItems.SULFUR.get());
                        output.accept(ModBlocks.SULFUR_BLOCK.get());
                        output.accept(ModBlocks.GLOWSTONE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_GLOWSTONE_ORE.get());
                        output.accept(Items.GLOWSTONE_DUST);

                        output.accept(ModItems.BRONZE_NUGGET.get());
                        output.accept(ModItems.BRONZE_INGOT.get());
                        output.accept(ModBlocks.BRONZE_BLOCK.get());


                    }).build());
    public static final Supplier<CreativeModeTab> TEST = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GONDORIAN_WORKBENCH.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((displayParameters, output) -> {
//                        output.accept(ModBlocks.GONDORIAN_CRAFTING_TABLE.get());
//                        output.accept(ModBlocks.CHAIR.get());
//                        output.accept(ModBlocks.SMALL_WOOD_SHELF.get());
//                        output.accept(ModBlocks.BIG_WOOD_SHELF.get());
//                        output.accept(ModItems.RHINO_SPAWN_EGG.get());
//                        output.accept(ModBlocks.OAK_CHEST.get());
                        output.accept(ModItems.GONDORIAN_HAMMER.get());
//                        output.accept(ModItems.GONDORIAN_PIKE.get());
//                        output.accept(ModBlocks.GONDORIAN_GATE.get());

                        output.accept(ModItems.SMALL_POUCH.get());
                        output.accept(ModItems.MEDIUM_POUCH.get());
                        output.accept(ModItems.LARGE_POUCH.get());

//                        output.accept(ModBlocks.INKWELL.get());


                    }).build());

}
