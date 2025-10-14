package net.sima.bfme.event;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@EventBusSubscriber(modid = BFME.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VanillaCreativeTab {
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            // Список блоков шерсти, после которых добавляем слэбы
            List<Block> woolBlocks = Arrays.asList(
                    Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL,
                    Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL,
                    Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL,
                    Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL
            );

            // Список блоков слэбов, которые добавляем
            List<DeferredBlock<Block>> woolSlabs = Arrays.asList(
                    ModBlocks.WHITE_WOOL_SLAB, ModBlocks.ORANGE_WOOL_SLAB, ModBlocks.MAGENTA_WOOL_SLAB,
                    ModBlocks.LIGHT_BLUE_WOOL_SLAB, ModBlocks.YELLOW_WOOL_SLAB, ModBlocks.LIME_WOOL_SLAB,
                    ModBlocks.PINK_WOOL_SLAB, ModBlocks.GRAY_WOOL_SLAB, ModBlocks.LIGHT_GRAY_WOOL_SLAB,
                    ModBlocks.CYAN_WOOL_SLAB, ModBlocks.PURPLE_WOOL_SLAB, ModBlocks.BLUE_WOOL_SLAB,
                    ModBlocks.BROWN_WOOL_SLAB, ModBlocks.GREEN_WOOL_SLAB, ModBlocks.RED_WOOL_SLAB,
                    ModBlocks.BLACK_WOOL_SLAB
            );

            List<DeferredBlock<Block>> woolStairs = Arrays.asList(
                    ModBlocks.WHITE_WOOL_STAIRS, ModBlocks.ORANGE_WOOL_STAIRS, ModBlocks.MAGENTA_WOOL_STAIRS,
                    ModBlocks.LIGHT_BLUE_WOOL_STAIRS, ModBlocks.YELLOW_WOOL_STAIRS, ModBlocks.LIME_WOOL_STAIRS,
                    ModBlocks.PINK_WOOL_STAIRS, ModBlocks.GRAY_WOOL_STAIRS, ModBlocks.LIGHT_GRAY_WOOL_STAIRS,
                    ModBlocks.CYAN_WOOL_STAIRS, ModBlocks.PURPLE_WOOL_STAIRS, ModBlocks.BLUE_WOOL_STAIRS,
                    ModBlocks.BROWN_WOOL_STAIRS, ModBlocks.GREEN_WOOL_STAIRS, ModBlocks.RED_WOOL_STAIRS,
                    ModBlocks.BLACK_WOOL_STAIRS
            );

            List<DeferredBlock<Block>> woolVerticalSlab = Arrays.asList(
                    ModBlocks.WHITE_WOOL_VERTICAL_SLAB, ModBlocks.ORANGE_WOOL_VERTICAL_SLAB, ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB,
                    ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB, ModBlocks.YELLOW_WOOL_VERTICAL_SLAB, ModBlocks.LIME_WOOL_VERTICAL_SLAB,
                    ModBlocks.PINK_WOOL_VERTICAL_SLAB, ModBlocks.GRAY_WOOL_VERTICAL_SLAB, ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB,
                    ModBlocks.CYAN_WOOL_VERTICAL_SLAB, ModBlocks.PURPLE_WOOL_VERTICAL_SLAB, ModBlocks.BLUE_WOOL_VERTICAL_SLAB,
                    ModBlocks.BROWN_WOOL_VERTICAL_SLAB, ModBlocks.GREEN_WOOL_VERTICAL_SLAB, ModBlocks.RED_WOOL_VERTICAL_SLAB,
                    ModBlocks.BLACK_WOOL_VERTICAL_SLAB
            );
            // Цикл добавления слэбов после блоков шерсти
            for (int i = 0; i < woolBlocks.size(); i++) {
                event.insertAfter(new ItemStack(woolBlocks.get(i)), new ItemStack(woolStairs.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(new ItemStack(woolStairs.get(i)), new ItemStack(woolSlabs.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(new ItemStack(woolSlabs.get(i)), new ItemStack(woolVerticalSlab.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            List<Block> log = Arrays.asList(
                    Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD,
                    Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD,
                    Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD,
                    Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD,
                    Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD,
                    Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD,
                    Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD,
                    Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD
            );
            List<DeferredBlock<Block>> stairs = Arrays.asList(
                    ModBlocks.OAK_LOG_STAIRS, ModBlocks.OAK_WOOD_STAIRS, ModBlocks.STRIPPED_OAK_LOG_STAIRS, ModBlocks.STRIPPED_OAK_WOOD_STAIRS,
                    ModBlocks.SPRUCE_LOG_STAIRS, ModBlocks.SPRUCE_WOOD_STAIRS, ModBlocks.STRIPPED_SPRUCE_LOG_STAIRS, ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS,
                    ModBlocks.BIRCH_LOG_STAIRS, ModBlocks.BIRCH_WOOD_STAIRS, ModBlocks.STRIPPED_BIRCH_LOG_STAIRS, ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS,
                    ModBlocks.JUNGLE_LOG_STAIRS, ModBlocks.JUNGLE_WOOD_STAIRS, ModBlocks.STRIPPED_JUNGLE_LOG_STAIRS, ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS,
                    ModBlocks.ACACIA_LOG_STAIRS, ModBlocks.ACACIA_WOOD_STAIRS, ModBlocks.STRIPPED_ACACIA_LOG_STAIRS, ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS,
                    ModBlocks.DARK_OAK_LOG_STAIRS, ModBlocks.DARK_OAK_WOOD_STAIRS, ModBlocks.STRIPPED_DARK_OAK_LOG_STAIRS, ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS,
                    ModBlocks.MANGROVE_LOG_STAIRS, ModBlocks.MANGROVE_WOOD_STAIRS, ModBlocks.STRIPPED_MANGROVE_LOG_STAIRS, ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS,
                    ModBlocks.CHERRY_LOG_STAIRS, ModBlocks.CHERRY_WOOD_STAIRS, ModBlocks.STRIPPED_CHERRY_LOG_STAIRS, ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS
            );
            List<DeferredBlock<Block>> slab = Arrays.asList(
                    ModBlocks.OAK_LOG_SLAB, ModBlocks.OAK_WOOD_SLAB, ModBlocks.STRIPPED_OAK_LOG_SLAB, ModBlocks.STRIPPED_OAK_WOOD_SLAB,
                    ModBlocks.SPRUCE_LOG_SLAB, ModBlocks.SPRUCE_WOOD_SLAB, ModBlocks.STRIPPED_SPRUCE_LOG_SLAB, ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB,
                    ModBlocks.BIRCH_LOG_SLAB, ModBlocks.BIRCH_WOOD_SLAB, ModBlocks.STRIPPED_BIRCH_LOG_SLAB, ModBlocks.STRIPPED_BIRCH_WOOD_SLAB,
                    ModBlocks.JUNGLE_LOG_SLAB, ModBlocks.JUNGLE_WOOD_SLAB, ModBlocks.STRIPPED_JUNGLE_LOG_SLAB, ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB,
                    ModBlocks.ACACIA_LOG_SLAB, ModBlocks.ACACIA_WOOD_SLAB, ModBlocks.STRIPPED_ACACIA_LOG_SLAB, ModBlocks.STRIPPED_ACACIA_WOOD_SLAB,
                    ModBlocks.DARK_OAK_LOG_SLAB, ModBlocks.DARK_OAK_WOOD_SLAB, ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB, ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB,
                    ModBlocks.MANGROVE_LOG_SLAB, ModBlocks.MANGROVE_WOOD_SLAB, ModBlocks.STRIPPED_MANGROVE_LOG_SLAB, ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB,
                    ModBlocks.CHERRY_LOG_SLAB, ModBlocks.CHERRY_WOOD_SLAB, ModBlocks.STRIPPED_CHERRY_LOG_SLAB, ModBlocks.STRIPPED_CHERRY_WOOD_SLAB
            );
            List<DeferredBlock<Block>> verticalslab = Arrays.asList(
                    ModBlocks.OAK_LOG_VERTICAL_SLAB, ModBlocks.OAK_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB,
                    ModBlocks.SPRUCE_LOG_VERTICAL_SLAB, ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB,
                    ModBlocks.BIRCH_LOG_VERTICAL_SLAB, ModBlocks.BIRCH_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB,
                    ModBlocks.JUNGLE_LOG_VERTICAL_SLAB, ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB,
                    ModBlocks.ACACIA_LOG_VERTICAL_SLAB, ModBlocks.ACACIA_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB,
                    ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB, ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB,
                    ModBlocks.MANGROVE_LOG_VERTICAL_SLAB, ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB,
                    ModBlocks.CHERRY_LOG_VERTICAL_SLAB, ModBlocks.CHERRY_WOOD_VERTICAL_SLAB, ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB, ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB
            );
            for (int i = 0; i < log.size(); i++) {
                event.insertAfter(new ItemStack(log.get(i)), new ItemStack(stairs.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(new ItemStack(stairs.get(i)), new ItemStack(slab.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(new ItemStack(slab.get(i)), new ItemStack(verticalslab.get(i).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            List<Block> planks = Arrays.asList(
                    Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS,
                    Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.CHERRY_PLANKS
            );
            List<DeferredBlock<Block>> vertical = Arrays.asList(
                    ModBlocks.OAK_PLANKS_VERTICAL_SLAB, ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB, ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB, ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB,
                    ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB, ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB, ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB, ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB
            );
            for (int i = 0; i < planks.size(); i++){
                event.insertAfter(new ItemStack(planks.get(i)), new ItemStack(vertical.get(i)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }
}
