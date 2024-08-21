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

                        output.accept(ModBlocks.DURIN_STONE.get());
                        output.accept(ModBlocks.DURIN_STONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_STONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_STONE_WALL.get());
                        output.accept(ModBlocks.DURIN_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_STONE_BUTTON.get());

                        output.accept(ModBlocks.DURIN_MOSSY_STONE.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_WALL.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_MOSSY_STONE_BUTTON.get());

                        output.accept(ModBlocks.DURIN_CRACKED_STONE.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_WALL.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_CRACKED_STONE_BUTTON.get());

                        output.accept(ModBlocks.DURIN_SMOOTH_STONE.get());
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE_WALL.get());
                        output.accept(ModBlocks.DURIN_SMOOTH_STONE_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_COBBLESTONE.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_COBBLESTONE_BUTTON.get());

                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COBBLESTONE_BUTTON.get());

                        output.accept(ModBlocks.DURIN_BRICK.get());
                        output.accept(ModBlocks.DURIN_BRICK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_BRICK_SLAB.get());
                        output.accept(ModBlocks.DURIN_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_BRICK_WALL.get());
                        output.accept(ModBlocks.DURIN_BRICK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_BRICK_BUTTON.get());

                        output.accept(ModBlocks.DURIN_GOLD_BRICK.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK_SLAB.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK_WALL.get());
                        output.accept(ModBlocks.DURIN_GOLD_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_BRICKWORK.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.DURIN_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_MOSSY_BRICK.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK_WALL.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.DURIN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_CRACKED_BRICK.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK_WALL.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.DURIN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_CHISELED_BRICK.get());
                        output.accept(ModBlocks.DURIN_MOSSY_CHISELED_BRICK.get());

                        output.accept(ModBlocks.DURIN_CHISELED_BRICK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DURIN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.DURIN_PILLAR.get());
                        output.accept(ModBlocks.DURIN_PILLAR_SLAB.get());
                        output.accept(ModBlocks.DURIN_MOSSY_PILLAR.get());
                        output.accept(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get());
                        output.accept(ModBlocks.DURIN_CRACKED_PILLAR.get());
                        output.accept(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get());
                        output.accept(ModBlocks.DURIN_COLUMN.get());
                        output.accept(ModBlocks.DURIN_MOSSY_COLUMN.get());
                        output.accept(ModBlocks.DURIN_CRACKED_COLUMN.get());
                    })
                    .build()
    );
    public static final Supplier<CreativeModeTab> ROHAN_TAB = CREATIVE_MODE_TABS.register("rohan_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.rohan_tab")).icon(() -> new ItemStack(ModBlocks.ROHAN_STONE.get()))
                    .displayItems((params, output) -> {

                        output.accept(ModBlocks.ROHAN_STONE.get());
                        output.accept(ModBlocks.ROHAN_STONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_STONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_STONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_STONE_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE.get());
                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_SMOOTH_STONE_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_MOSSY_STONE.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_STONE_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_CRACKED_STONE.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_STONE_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_COBBLESTONE.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_COBBLESTONE_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COBBLESTONE_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_BRICK.get());
                        output.accept(ModBlocks.ROHAN_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_BRICK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_BRICK_WALL.get());
                        output.accept(ModBlocks.ROHAN_BRICK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_BRICK_BUTTON.get());

                        output.accept(ModBlocks.ROHAN_BRICKWORK.get());
                        output.accept(ModBlocks.ROHAN_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.ROHAN_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK_WALL.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK_WALL.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_CHISELED_BRICK.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK.get());

                        output.accept(ModBlocks.ROHAN_CHISELED_BRICK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ROHAN_PILLAR.get());
                        output.accept(ModBlocks.ROHAN_PILLAR_SLAB.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_PILLAR.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_PILLAR.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get());
                        output.accept(ModBlocks.ROHAN_COLUMN.get());
                        output.accept(ModBlocks.ROHAN_MOSSY_COLUMN.get());
                        output.accept(ModBlocks.ROHAN_CRACKED_COLUMN.get());
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
    public static final Supplier<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.APPLE.get()))
                    .title(Component.translatable("creativetab.food_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.APPLE.get());
                        output.accept(ModItems.PEAR.get());
                        output.accept(ModItems.PLUM.get());
                        output.accept(ModItems.CHESTNUT.get());
                        output.accept(ModItems.ALMOND.get());
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.LEMON.get());
                        output.accept(ModItems.MANGO.get());
                        output.accept(ModItems.OLIVE.get());
                        output.accept(ModItems.ORANGE.get());
                        output.accept(ModItems.POMERGRANATE.get());
                    }).build());
    public static final Supplier<CreativeModeTab> WOOD_TAB = CREATIVE_MODE_TABS.register("wood_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.APPLE_LOG.get()))
                    .title(Component.translatable("creativetab.wood_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModBlocks.ALMOND_LOG.get());
                        output.accept(ModBlocks.ALMOND_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_ALMOND_LOG.get());
                        output.accept(ModBlocks.STRIPPED_ALMOND_WOOD.get());
                        output.accept(ModBlocks.ALMOND_PLANKS.get());
                        output.accept(ModBlocks.ALMOND_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.ALMOND_PLANKS_SLAB.get());
                        output.accept(ModBlocks.ALMOND_FENCE.get());
                        output.accept(ModBlocks.ALMOND_FENCE_GATE.get());
                        output.accept(ModBlocks.ALMOND_DOOR.get());
                        output.accept(ModBlocks.ALMOND_TRAPDOOR.get());
                        output.accept(ModBlocks.ALMOND_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ALMOND_BUTTON.get());
                        output.accept(ModBlocks.ALMOND_LEAVES.get());
                        output.accept(ModBlocks.ALMOND_SAPLING.get());

                        output.accept(ModBlocks.APPLE_LOG.get());
                        output.accept(ModBlocks.APPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_APPLE_WOOD.get());
                        output.accept(ModBlocks.APPLE_PLANKS.get());
                        output.accept(ModBlocks.APPLE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.APPLE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.APPLE_FENCE.get());
                        output.accept(ModBlocks.APPLE_FENCE_GATE.get());
                        output.accept(ModBlocks.APPLE_DOOR.get());
                        output.accept(ModBlocks.APPLE_TRAPDOOR.get());
                        output.accept(ModBlocks.APPLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.APPLE_BUTTON.get());
                        output.accept(ModBlocks.APPLE_LEAVES.get());
                        output.accept(ModBlocks.APPLE_SAPLING.get());

                        output.accept(ModBlocks.ASPEN_LOG.get());
                        output.accept(ModBlocks.ASPEN_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_ASPEN_LOG.get());
                        output.accept(ModBlocks.STRIPPED_ASPEN_WOOD.get());
                        output.accept(ModBlocks.ASPEN_PLANKS.get());
                        output.accept(ModBlocks.ASPEN_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.ASPEN_PLANKS_SLAB.get());
                        output.accept(ModBlocks.ASPEN_FENCE.get());
                        output.accept(ModBlocks.ASPEN_FENCE_GATE.get());
                        output.accept(ModBlocks.ASPEN_DOOR.get());
                        output.accept(ModBlocks.ASPEN_TRAPDOOR.get());
                        output.accept(ModBlocks.ASPEN_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ASPEN_BUTTON.get());
                        output.accept(ModBlocks.ASPEN_LEAVES.get());
                        output.accept(ModBlocks.ASPEN_SAPLING.get());

                        output.accept(ModBlocks.BANANA_LOG.get());
                        output.accept(ModBlocks.BANANA_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BANANA_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BANANA_WOOD.get());
                        output.accept(ModBlocks.BANANA_PLANKS.get());
                        output.accept(ModBlocks.BANANA_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.BANANA_PLANKS_SLAB.get());
                        output.accept(ModBlocks.BANANA_FENCE.get());
                        output.accept(ModBlocks.BANANA_FENCE_GATE.get());
                        output.accept(ModBlocks.BANANA_DOOR.get());
                        output.accept(ModBlocks.BANANA_TRAPDOOR.get());
                        output.accept(ModBlocks.BANANA_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BANANA_BUTTON.get());
                        output.accept(ModBlocks.BANANA_LEAVES.get());
                        output.accept(ModBlocks.BANANA_SAPLING.get());

                        output.accept(ModBlocks.BAOBAB_LOG.get());
                        output.accept(ModBlocks.BAOBAB_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BAOBAB_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
                        output.accept(ModBlocks.BAOBAB_PLANKS.get());
                        output.accept(ModBlocks.BAOBAB_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.BAOBAB_PLANKS_SLAB.get());
                        output.accept(ModBlocks.BAOBAB_FENCE.get());
                        output.accept(ModBlocks.BAOBAB_FENCE_GATE.get());
                        output.accept(ModBlocks.BAOBAB_DOOR.get());
                        output.accept(ModBlocks.BAOBAB_TRAPDOOR.get());
                        output.accept(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BAOBAB_BUTTON.get());
                        output.accept(ModBlocks.BAOBAB_LEAVES.get());
                        output.accept(ModBlocks.BAOBAB_SAPLING.get());

                        output.accept(ModBlocks.BEECH_LOG.get());
                        output.accept(ModBlocks.BEECH_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BEECH_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BEECH_WOOD.get());
                        output.accept(ModBlocks.BEECH_PLANKS.get());
                        output.accept(ModBlocks.BEECH_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.BEECH_PLANKS_SLAB.get());
                        output.accept(ModBlocks.BEECH_FENCE.get());
                        output.accept(ModBlocks.BEECH_FENCE_GATE.get());
                        output.accept(ModBlocks.BEECH_DOOR.get());
                        output.accept(ModBlocks.BEECH_TRAPDOOR.get());
                        output.accept(ModBlocks.BEECH_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BEECH_BUTTON.get());
                        output.accept(ModBlocks.BEECH_LEAVES.get());
                        output.accept(ModBlocks.BEECH_SAPLING.get());

                        output.accept(ModBlocks.CEDAR_LOG.get());
                        output.accept(ModBlocks.CEDAR_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_CEDAR_LOG.get());
                        output.accept(ModBlocks.STRIPPED_CEDAR_WOOD.get());
                        output.accept(ModBlocks.CEDAR_PLANKS.get());
                        output.accept(ModBlocks.CEDAR_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.CEDAR_PLANKS_SLAB.get());
                        output.accept(ModBlocks.CEDAR_FENCE.get());
                        output.accept(ModBlocks.CEDAR_FENCE_GATE.get());
                        output.accept(ModBlocks.CEDAR_DOOR.get());
                        output.accept(ModBlocks.CEDAR_TRAPDOOR.get());
                        output.accept(ModBlocks.CEDAR_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CEDAR_BUTTON.get());
                        output.accept(ModBlocks.CEDAR_LEAVES.get());
                        output.accept(ModBlocks.CEDAR_SAPLING.get());

                        output.accept(ModBlocks.CHARRED_LOG.get());
                        output.accept(ModBlocks.CHARRED_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_CHARRED_LOG.get());
                        output.accept(ModBlocks.STRIPPED_CHARRED_WOOD.get());
                        output.accept(ModBlocks.CHARRED_PLANKS.get());
                        output.accept(ModBlocks.CHARRED_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.CHARRED_PLANKS_SLAB.get());
                        output.accept(ModBlocks.CHARRED_FENCE.get());
                        output.accept(ModBlocks.CHARRED_FENCE_GATE.get());
                        output.accept(ModBlocks.CHARRED_DOOR.get());
                        output.accept(ModBlocks.CHARRED_TRAPDOOR.get());
                        output.accept(ModBlocks.CHARRED_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CHARRED_BUTTON.get());

                        output.accept(ModBlocks.CHESTNUT_LOG.get());
                        output.accept(ModBlocks.CHESTNUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_CHESTNUT_LOG.get());
                        output.accept(ModBlocks.STRIPPED_CHESTNUT_WOOD.get());
                        output.accept(ModBlocks.CHESTNUT_PLANKS.get());
                        output.accept(ModBlocks.CHESTNUT_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.CHESTNUT_PLANKS_SLAB.get());
                        output.accept(ModBlocks.CHESTNUT_FENCE.get());
                        output.accept(ModBlocks.CHESTNUT_FENCE_GATE.get());
                        output.accept(ModBlocks.CHESTNUT_DOOR.get());
                        output.accept(ModBlocks.CHESTNUT_TRAPDOOR.get());
                        output.accept(ModBlocks.CHESTNUT_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CHESTNUT_BUTTON.get());
                        output.accept(ModBlocks.CHESTNUT_LEAVES.get());
                        output.accept(ModBlocks.CHESTNUT_SAPLING.get());

                        output.accept(ModBlocks.CYPRESS_LOG.get());
                        output.accept(ModBlocks.CYPRESS_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_CYPRESS_LOG.get());
                        output.accept(ModBlocks.STRIPPED_CYPRESS_WOOD.get());
                        output.accept(ModBlocks.CYPRESS_PLANKS.get());
                        output.accept(ModBlocks.CYPRESS_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.CYPRESS_PLANKS_SLAB.get());
                        output.accept(ModBlocks.CYPRESS_FENCE.get());
                        output.accept(ModBlocks.CYPRESS_FENCE_GATE.get());
                        output.accept(ModBlocks.CYPRESS_DOOR.get());
                        output.accept(ModBlocks.CYPRESS_TRAPDOOR.get());
                        output.accept(ModBlocks.CYPRESS_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CYPRESS_BUTTON.get());
                        output.accept(ModBlocks.CYPRESS_LEAVES.get());
                        output.accept(ModBlocks.CYPRESS_SAPLING.get());

                        output.accept(ModBlocks.DATE_PALM_LOG.get());
                        output.accept(ModBlocks.DATE_PALM_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_DATE_PALM_LOG.get());
                        output.accept(ModBlocks.STRIPPED_DATE_PALM_WOOD.get());
                        output.accept(ModBlocks.DATE_PALM_PLANKS.get());
                        output.accept(ModBlocks.DATE_PALM_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.DATE_PALM_PLANKS_SLAB.get());
                        output.accept(ModBlocks.DATE_PALM_FENCE.get());
                        output.accept(ModBlocks.DATE_PALM_FENCE_GATE.get());
                        output.accept(ModBlocks.DATE_PALM_DOOR.get());
                        output.accept(ModBlocks.DATE_PALM_TRAPDOOR.get());
                        output.accept(ModBlocks.DATE_PALM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DATE_PALM_BUTTON.get());
                        output.accept(ModBlocks.DATE_PALM_LEAVES.get());
                        output.accept(ModBlocks.DATE_PALM_SAPLING.get());

                        output.accept(ModBlocks.FIR_LOG.get());
                        output.accept(ModBlocks.FIR_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_FIR_LOG.get());
                        output.accept(ModBlocks.STRIPPED_FIR_WOOD.get());
                        output.accept(ModBlocks.FIR_PLANKS.get());
                        output.accept(ModBlocks.FIR_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.FIR_PLANKS_SLAB.get());
                        output.accept(ModBlocks.FIR_FENCE.get());
                        output.accept(ModBlocks.FIR_FENCE_GATE.get());
                        output.accept(ModBlocks.FIR_DOOR.get());
                        output.accept(ModBlocks.FIR_TRAPDOOR.get());
                        output.accept(ModBlocks.FIR_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.FIR_BUTTON.get());
                        output.accept(ModBlocks.FIR_LEAVES.get());
                        output.accept(ModBlocks.FIR_SAPLING.get());

                        output.accept(ModBlocks.GREEN_OAK_LOG.get());
                        output.accept(ModBlocks.GREEN_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_GREEN_OAK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_GREEN_OAK_WOOD.get());
                        output.accept(ModBlocks.GREEN_OAK_PLANKS.get());
                        output.accept(ModBlocks.GREEN_OAK_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.GREEN_OAK_PLANKS_SLAB.get());
                        output.accept(ModBlocks.GREEN_OAK_FENCE.get());
                        output.accept(ModBlocks.GREEN_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.GREEN_OAK_DOOR.get());
                        output.accept(ModBlocks.GREEN_OAK_TRAPDOOR.get());
                        output.accept(ModBlocks.GREEN_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.GREEN_OAK_BUTTON.get());
                        output.accept(ModBlocks.GREEN_OAK_LEAVES.get());
                        output.accept(ModBlocks.GREEN_OAK_SAPLING.get());

                        output.accept(ModBlocks.HOLLY_LOG.get());
                        output.accept(ModBlocks.HOLLY_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_HOLLY_LOG.get());
                        output.accept(ModBlocks.STRIPPED_HOLLY_WOOD.get());
                        output.accept(ModBlocks.HOLLY_PLANKS.get());
                        output.accept(ModBlocks.HOLLY_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.HOLLY_PLANKS_SLAB.get());
                        output.accept(ModBlocks.HOLLY_FENCE.get());
                        output.accept(ModBlocks.HOLLY_FENCE_GATE.get());
                        output.accept(ModBlocks.HOLLY_DOOR.get());
                        output.accept(ModBlocks.HOLLY_TRAPDOOR.get());
                        output.accept(ModBlocks.HOLLY_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.HOLLY_BUTTON.get());
                        output.accept(ModBlocks.HOLLY_LEAVES.get());
                        output.accept(ModBlocks.HOLLY_SAPLING.get());

                        output.accept(ModBlocks.KUNTZ_LOG.get());
                        output.accept(ModBlocks.KUNTZ_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_KUNTZ_LOG.get());
                        output.accept(ModBlocks.STRIPPED_KUNTZ_WOOD.get());
                        output.accept(ModBlocks.KUNTZ_PLANKS.get());
                        output.accept(ModBlocks.KUNTZ_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.KUNTZ_PLANKS_SLAB.get());
                        output.accept(ModBlocks.KUNTZ_FENCE.get());
                        output.accept(ModBlocks.KUNTZ_FENCE_GATE.get());
                        output.accept(ModBlocks.KUNTZ_DOOR.get());
                        output.accept(ModBlocks.KUNTZ_TRAPDOOR.get());
                        output.accept(ModBlocks.KUNTZ_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.KUNTZ_BUTTON.get());
                        output.accept(ModBlocks.KUNTZ_LEAVES.get());
                        output.accept(ModBlocks.KUNTZ_SAPLING.get());

                        output.accept(ModBlocks.LAIRELOSSE_LOG.get());
                        output.accept(ModBlocks.LAIRELOSSE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LAIRELOSSE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LAIRELOSSE_WOOD.get());
                        output.accept(ModBlocks.LAIRELOSSE_PLANKS.get());
                        output.accept(ModBlocks.LAIRELOSSE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.LAIRELOSSE_FENCE.get());
                        output.accept(ModBlocks.LAIRELOSSE_FENCE_GATE.get());
                        output.accept(ModBlocks.LAIRELOSSE_DOOR.get());
                        output.accept(ModBlocks.LAIRELOSSE_TRAPDOOR.get());
                        output.accept(ModBlocks.LAIRELOSSE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LAIRELOSSE_BUTTON.get());
                        output.accept(ModBlocks.LAIRELOSSE_LEAVES.get());
                        output.accept(ModBlocks.LAIRELOSSE_SAPLING.get());

                        output.accept(ModBlocks.LARCH_LOG.get());
                        output.accept(ModBlocks.LARCH_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LARCH_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LARCH_WOOD.get());
                        output.accept(ModBlocks.LARCH_PLANKS.get());
                        output.accept(ModBlocks.LARCH_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.LARCH_PLANKS_SLAB.get());
                        output.accept(ModBlocks.LARCH_FENCE.get());
                        output.accept(ModBlocks.LARCH_FENCE_GATE.get());
                        output.accept(ModBlocks.LARCH_DOOR.get());
                        output.accept(ModBlocks.LARCH_TRAPDOOR.get());
                        output.accept(ModBlocks.LARCH_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LARCH_BUTTON.get());
                        output.accept(ModBlocks.LARCH_LEAVES.get());
                        output.accept(ModBlocks.LARCH_SAPLING.get());

                        output.accept(ModBlocks.LEBETHRON_LOG.get());
                        output.accept(ModBlocks.LEBETHRON_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LEBETHRON_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LEBETHRON_WOOD.get());
                        output.accept(ModBlocks.LEBETHRON_PLANKS.get());
                        output.accept(ModBlocks.LEBETHRON_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.LEBETHRON_PLANKS_SLAB.get());
                        output.accept(ModBlocks.LEBETHRON_FENCE.get());
                        output.accept(ModBlocks.LEBETHRON_FENCE_GATE.get());
                        output.accept(ModBlocks.LEBETHRON_DOOR.get());
                        output.accept(ModBlocks.LEBETHRON_TRAPDOOR.get());
                        output.accept(ModBlocks.LEBETHRON_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LEBETHRON_BUTTON.get());
                        output.accept(ModBlocks.LEBETHRON_LEAVES.get());
                        output.accept(ModBlocks.LEBETHRON_SAPLING.get());

                        output.accept(ModBlocks.LEMON_LOG.get());
                        output.accept(ModBlocks.LEMON_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LEMON_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LEMON_WOOD.get());
                        output.accept(ModBlocks.LEMON_PLANKS.get());
                        output.accept(ModBlocks.LEMON_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.LEMON_PLANKS_SLAB.get());
                        output.accept(ModBlocks.LEMON_FENCE.get());
                        output.accept(ModBlocks.LEMON_FENCE_GATE.get());
                        output.accept(ModBlocks.LEMON_DOOR.get());
                        output.accept(ModBlocks.LEMON_TRAPDOOR.get());
                        output.accept(ModBlocks.LEMON_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LEMON_BUTTON.get());
                        output.accept(ModBlocks.LEMON_LEAVES.get());
                        output.accept(ModBlocks.LEMON_SAPLING.get());

                        output.accept(ModBlocks.LIME_LOG.get());
                        output.accept(ModBlocks.LIME_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LIME_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LIME_WOOD.get());
                        output.accept(ModBlocks.LIME_PLANKS.get());
                        output.accept(ModBlocks.LIME_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.LIME_PLANKS_SLAB.get());
                        output.accept(ModBlocks.LIME_FENCE.get());
                        output.accept(ModBlocks.LIME_FENCE_GATE.get());
                        output.accept(ModBlocks.LIME_DOOR.get());
                        output.accept(ModBlocks.LIME_TRAPDOOR.get());
                        output.accept(ModBlocks.LIME_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.LIME_BUTTON.get());
                        output.accept(ModBlocks.LIME_LEAVES.get());
                        output.accept(ModBlocks.LIME_SAPLING.get());

                        output.accept(ModBlocks.MALLORN_LOG.get());
                        output.accept(ModBlocks.MALLORN_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MALLORN_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MALLORN_WOOD.get());
                        output.accept(ModBlocks.MALLORN_PLANKS.get());
                        output.accept(ModBlocks.MALLORN_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.MALLORN_PLANKS_SLAB.get());
                        output.accept(ModBlocks.MALLORN_FENCE.get());
                        output.accept(ModBlocks.MALLORN_FENCE_GATE.get());
                        output.accept(ModBlocks.MALLORN_DOOR.get());
                        output.accept(ModBlocks.MALLORN_TRAPDOOR.get());
                        output.accept(ModBlocks.MALLORN_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MALLORN_BUTTON.get());
                        output.accept(ModBlocks.MALLORN_LEAVES.get());
                        output.accept(ModBlocks.MALLORN_SAPLING.get());

                        output.accept(ModBlocks.MANGO_LOG.get());
                        output.accept(ModBlocks.MANGO_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MANGO_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MANGO_WOOD.get());
                        output.accept(ModBlocks.MANGO_PLANKS.get());
                        output.accept(ModBlocks.MANGO_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.MANGO_PLANKS_SLAB.get());
                        output.accept(ModBlocks.MANGO_FENCE.get());
                        output.accept(ModBlocks.MANGO_FENCE_GATE.get());
                        output.accept(ModBlocks.MANGO_DOOR.get());
                        output.accept(ModBlocks.MANGO_TRAPDOOR.get());
                        output.accept(ModBlocks.MANGO_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MANGO_BUTTON.get());
                        output.accept(ModBlocks.MANGO_LEAVES.get());
                        output.accept(ModBlocks.MANGO_SAPLING.get());

                        output.accept(ModBlocks.MAPLE_LOG.get());
                        output.accept(ModBlocks.MAPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MAPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MAPLE_WOOD.get());
                        output.accept(ModBlocks.MAPLE_PLANKS.get());
                        output.accept(ModBlocks.MAPLE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.MAPLE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.MAPLE_FENCE.get());
                        output.accept(ModBlocks.MAPLE_FENCE_GATE.get());
                        output.accept(ModBlocks.MAPLE_DOOR.get());
                        output.accept(ModBlocks.MAPLE_TRAPDOOR.get());
                        output.accept(ModBlocks.MAPLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MAPLE_BUTTON.get());
                        output.accept(ModBlocks.MAPLE_LEAVES.get());
                        output.accept(ModBlocks.MAPLE_SAPLING.get());

                        output.accept(ModBlocks.MIRK_OAK_LOG.get());
                        output.accept(ModBlocks.MIRK_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MIRK_OAK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MIRK_OAK_WOOD.get());
                        output.accept(ModBlocks.MIRK_OAK_PLANKS.get());
                        output.accept(ModBlocks.MIRK_OAK_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.MIRK_OAK_PLANKS_SLAB.get());
                        output.accept(ModBlocks.MIRK_OAK_FENCE.get());
                        output.accept(ModBlocks.MIRK_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.MIRK_OAK_DOOR.get());
                        output.accept(ModBlocks.MIRK_OAK_TRAPDOOR.get());
                        output.accept(ModBlocks.MIRK_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MIRK_OAK_BUTTON.get());
                        output.accept(ModBlocks.MIRK_OAK_LEAVES.get());
                        output.accept(ModBlocks.MIRK_OAK_SAPLING.get());

                        output.accept(ModBlocks.OLIVE_LOG.get());
                        output.accept(ModBlocks.OLIVE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_OLIVE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_OLIVE_WOOD.get());
                        output.accept(ModBlocks.OLIVE_PLANKS.get());
                        output.accept(ModBlocks.OLIVE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.OLIVE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.OLIVE_FENCE.get());
                        output.accept(ModBlocks.OLIVE_FENCE_GATE.get());
                        output.accept(ModBlocks.OLIVE_DOOR.get());
                        output.accept(ModBlocks.OLIVE_TRAPDOOR.get());
                        output.accept(ModBlocks.OLIVE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.OLIVE_BUTTON.get());
                        output.accept(ModBlocks.OLIVE_LEAVES.get());
                        output.accept(ModBlocks.OLIVE_SAPLING.get());

                        output.accept(ModBlocks.ORANGE_LOG.get());
                        output.accept(ModBlocks.ORANGE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_ORANGE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_ORANGE_WOOD.get());
                        output.accept(ModBlocks.ORANGE_PLANKS.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.ORANGE_FENCE.get());
                        output.accept(ModBlocks.ORANGE_FENCE_GATE.get());
                        output.accept(ModBlocks.ORANGE_DOOR.get());
                        output.accept(ModBlocks.ORANGE_TRAPDOOR.get());
                        output.accept(ModBlocks.ORANGE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ORANGE_BUTTON.get());
                        output.accept(ModBlocks.ORANGE_LEAVES.get());
                        output.accept(ModBlocks.ORANGE_SAPLING.get());

                        output.accept(ModBlocks.PALM_LOG.get());
                        output.accept(ModBlocks.PALM_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PALM_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PALM_WOOD.get());
                        output.accept(ModBlocks.PALM_PLANKS.get());
                        output.accept(ModBlocks.PALM_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.PALM_PLANKS_SLAB.get());
                        output.accept(ModBlocks.PALM_FENCE.get());
                        output.accept(ModBlocks.PALM_FENCE_GATE.get());
                        output.accept(ModBlocks.PALM_DOOR.get());
                        output.accept(ModBlocks.PALM_TRAPDOOR.get());
                        output.accept(ModBlocks.PALM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PALM_BUTTON.get());
                        output.accept(ModBlocks.PALM_LEAVES.get());
                        output.accept(ModBlocks.PALM_SAPLING.get());

                        output.accept(ModBlocks.PEAR_LOG.get());
                        output.accept(ModBlocks.PEAR_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PEAR_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PEAR_WOOD.get());
                        output.accept(ModBlocks.PEAR_PLANKS.get());
                        output.accept(ModBlocks.PEAR_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.PEAR_PLANKS_SLAB.get());
                        output.accept(ModBlocks.PEAR_FENCE.get());
                        output.accept(ModBlocks.PEAR_FENCE_GATE.get());
                        output.accept(ModBlocks.PEAR_DOOR.get());
                        output.accept(ModBlocks.PEAR_TRAPDOOR.get());
                        output.accept(ModBlocks.PEAR_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PEAR_BUTTON.get());
                        output.accept(ModBlocks.PEAR_LEAVES.get());
                        output.accept(ModBlocks.PEAR_SAPLING.get());

                        output.accept(ModBlocks.PINE_LOG.get());
                        output.accept(ModBlocks.PINE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PINE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PINE_WOOD.get());
                        output.accept(ModBlocks.PINE_PLANKS.get());
                        output.accept(ModBlocks.PINE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.PINE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.PINE_FENCE.get());
                        output.accept(ModBlocks.PINE_FENCE_GATE.get());
                        output.accept(ModBlocks.PINE_DOOR.get());
                        output.accept(ModBlocks.PINE_TRAPDOOR.get());
                        output.accept(ModBlocks.PINE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PINE_BUTTON.get());
                        output.accept(ModBlocks.PINE_LEAVES.get());
                        output.accept(ModBlocks.PINE_SAPLING.get());

                        output.accept(ModBlocks.PLUM_LOG.get());
                        output.accept(ModBlocks.PLUM_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PLUM_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PLUM_WOOD.get());
                        output.accept(ModBlocks.PLUM_PLANKS.get());
                        output.accept(ModBlocks.PLUM_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.PLUM_PLANKS_SLAB.get());
                        output.accept(ModBlocks.PLUM_FENCE.get());
                        output.accept(ModBlocks.PLUM_FENCE_GATE.get());
                        output.accept(ModBlocks.PLUM_DOOR.get());
                        output.accept(ModBlocks.PLUM_TRAPDOOR.get());
                        output.accept(ModBlocks.PLUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PLUM_BUTTON.get());
                        output.accept(ModBlocks.PLUM_LEAVES.get());
                        output.accept(ModBlocks.PLUM_SAPLING.get());

                        output.accept(ModBlocks.POMERGRANATE_LOG.get());
                        output.accept(ModBlocks.POMERGRANATE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_POMERGRANATE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_POMERGRANATE_WOOD.get());
                        output.accept(ModBlocks.POMERGRANATE_PLANKS.get());
                        output.accept(ModBlocks.POMERGRANATE_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.POMERGRANATE_PLANKS_SLAB.get());
                        output.accept(ModBlocks.POMERGRANATE_FENCE.get());
                        output.accept(ModBlocks.POMERGRANATE_FENCE_GATE.get());
                        output.accept(ModBlocks.POMERGRANATE_DOOR.get());
                        output.accept(ModBlocks.POMERGRANATE_TRAPDOOR.get());
                        output.accept(ModBlocks.POMERGRANATE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.POMERGRANATE_BUTTON.get());
                        output.accept(ModBlocks.POMERGRANATE_LEAVES.get());
                        output.accept(ModBlocks.POMERGRANATE_SAPLING.get());

                        output.accept(ModBlocks.RED_MAHOGANY_LOG.get());
                        output.accept(ModBlocks.RED_MAHOGANY_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_RED_MAHOGANY_LOG.get());
                        output.accept(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD.get());
                        output.accept(ModBlocks.RED_MAHOGANY_PLANKS.get());
                        output.accept(ModBlocks.RED_MAHOGANY_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get());
                        output.accept(ModBlocks.RED_MAHOGANY_FENCE.get());
                        output.accept(ModBlocks.RED_MAHOGANY_FENCE_GATE.get());
                        output.accept(ModBlocks.RED_MAHOGANY_DOOR.get());
                        output.accept(ModBlocks.RED_MAHOGANY_TRAPDOOR.get());
                        output.accept(ModBlocks.RED_MAHOGANY_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RED_MAHOGANY_BUTTON.get());
                        output.accept(ModBlocks.RED_MAHOGANY_LEAVES.get());
                        output.accept(ModBlocks.RED_MAHOGANY_SAPLING.get());

                        output.accept(ModBlocks.RED_OAK_LOG.get());
                        output.accept(ModBlocks.RED_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_RED_OAK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_RED_OAK_WOOD.get());
                        output.accept(ModBlocks.RED_OAK_PLANKS.get());
                        output.accept(ModBlocks.RED_OAK_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.RED_OAK_PLANKS_SLAB.get());
                        output.accept(ModBlocks.RED_OAK_FENCE.get());
                        output.accept(ModBlocks.RED_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.RED_OAK_DOOR.get());
                        output.accept(ModBlocks.RED_OAK_TRAPDOOR.get());
                        output.accept(ModBlocks.RED_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RED_OAK_BUTTON.get());
                        output.accept(ModBlocks.RED_OAK_LEAVES.get());
                        output.accept(ModBlocks.RED_OAK_SAPLING.get());

                        output.accept(ModBlocks.REDWOOD_LOG.get());
                        output.accept(ModBlocks.REDWOOD_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_REDWOOD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
                        output.accept(ModBlocks.REDWOOD_PLANKS.get());
                        output.accept(ModBlocks.REDWOOD_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.REDWOOD_PLANKS_SLAB.get());
                        output.accept(ModBlocks.REDWOOD_FENCE.get());
                        output.accept(ModBlocks.REDWOOD_FENCE_GATE.get());
                        output.accept(ModBlocks.REDWOOD_DOOR.get());
                        output.accept(ModBlocks.REDWOOD_TRAPDOOR.get());
                        output.accept(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.REDWOOD_BUTTON.get());
                        output.accept(ModBlocks.REDWOOD_LEAVES.get());
                        output.accept(ModBlocks.REDWOOD_SAPLING.get());

                        output.accept(ModBlocks.WILLOW_LOG.get());
                        output.accept(ModBlocks.WILLOW_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WILLOW_LOG.get());
                        output.accept(ModBlocks.STRIPPED_WILLOW_WOOD.get());
                        output.accept(ModBlocks.WILLOW_PLANKS.get());
                        output.accept(ModBlocks.WILLOW_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.WILLOW_PLANKS_SLAB.get());
                        output.accept(ModBlocks.WILLOW_FENCE.get());
                        output.accept(ModBlocks.WILLOW_FENCE_GATE.get());
                        output.accept(ModBlocks.WILLOW_DOOR.get());
                        output.accept(ModBlocks.WILLOW_TRAPDOOR.get());
                        output.accept(ModBlocks.WILLOW_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.WILLOW_BUTTON.get());
                        output.accept(ModBlocks.WILLOW_LEAVES.get());
                        output.accept(ModBlocks.WILLOW_SAPLING.get());
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
                        output.accept(ModItems.GONDORIAN_PIKE.get());
                        output.accept(ModItems.GONDORIAN_PIKE1.get());
//                        output.accept(ModItems.GONDORIAN_PIKE.get());
//                        output.accept(ModBlocks.GONDORIAN_GATE.get());

                        output.accept(ModItems.SMALL_POUCH.get());
                        output.accept(ModItems.MEDIUM_POUCH.get());
                        output.accept(ModItems.LARGE_POUCH.get());

//                        output.accept(ModBlocks.INKWELL.get());


                    }).build());

}
