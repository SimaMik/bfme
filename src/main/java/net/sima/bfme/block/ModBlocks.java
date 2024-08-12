package net.sima.bfme.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sima.bfme.BFME;
import net.sima.bfme.block.custom.ColumnBlock;
import net.sima.bfme.block.custom.GondorianCraftingTable;
import net.sima.bfme.block.custom.VerticalSlabBlock;
import net.sima.bfme.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BFME.MOD_ID);

    public static final DeferredBlock<Block> GONDORIAN_WORKBENCH = registerBlock("gondorian_workbench",
            () -> new GondorianCraftingTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE = registerBlock("gondorian_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE = registerBlock("gondorian_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE = registerBlock("gondorian_cracked_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE = registerBlock("gondorian_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE = registerBlock("gondorian_mossy_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK = registerBlock("gondorian_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK = registerBlock("gondorian_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK = registerBlock("gondorian_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK = registerBlock("gondorian_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK = registerBlock("gondorian_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK = registerBlock("gondorian_cracked_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CHISELED_BRICK = registerBlock("gondorian_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_CHISELED_BRICK = registerBlock("gondorian_mossy_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_PILLAR = registerBlock("gondorian_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_PILLAR = registerBlock("gondorian_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_PILLAR = registerBlock("gondorian_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_COLUMN = registerBlock("gondorian_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COLUMN = registerBlock("gondorian_mossy_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_COLUMN = registerBlock("gondorian_cracked_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_STAIRS = registerBlock("gondorian_stone_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_STAIRS = registerBlock("gondorian_mossy_stone_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));;
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_STAIRS = registerBlock("gondorian_cracked_stone_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_CRACKED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_STAIRS = registerBlock("gondorian_cobblestone_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_STAIRS = registerBlock("gondorian_mossy_cobblestone_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_STAIRS = registerBlock("gondorian_brick_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_STAIRS = registerBlock("gondorian_brickwork_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_STAIRS = registerBlock("gondorian_mossy_brick_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_STAIRS = registerBlock("gondorian_mossy_brickwork_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_STAIRS = registerBlock("gondorian_cracked_brick_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_STAIRS = registerBlock("gondorian_cracked_brickwork_stairs",
            () -> new StairBlock(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_SLAB = registerBlock("gondorian_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_SLAB = registerBlock("gondorian_mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_SLAB = registerBlock("gondorian_cracked_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_SLAB = registerBlock("gondorian_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_SLAB = registerBlock("gondorian_mossy_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_SLAB = registerBlock("gondorian_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_SLAB = registerBlock("gondorian_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_SLAB = registerBlock("gondorian_cracked_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_SLAB = registerBlock("gondorian_cracked_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_SLAB = registerBlock("gondorian_mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_SLAB = registerBlock("gondorian_mossy_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_PILLAR_SLAB = registerBlock("gondorian_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_PILLAR_SLAB = registerBlock("gondorian_mossy_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_PILLAR_SLAB = registerBlock("gondorian_cracked_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_VERTICAL_SLAB = registerBlock("gondorian_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_VERTICAL_SLAB = registerBlock("gondorian_mossy_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_VERTICAL_SLAB = registerBlock("gondorian_cracked_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_VERTICAL_SLAB = registerBlock("gondorian_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB = registerBlock("gondorian_mossy_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_VERTICAL_SLAB = registerBlock("gondorian_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_VERTICAL_SLAB = registerBlock("gondorian_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB = registerBlock("gondorian_cracked_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB = registerBlock("gondorian_cracked_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB = registerBlock("gondorian_mossy_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB = registerBlock("gondorian_mossy_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_WALL = registerBlock("gondorian_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_WALL = registerBlock("gondorian_mossy_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_WALL = registerBlock("gondorian_cracked_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_WALL = registerBlock("gondorian_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_WALL = registerBlock("gondorian_mossy_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_WALL = registerBlock("gondorian_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_WALL = registerBlock("gondorian_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_WALL = registerBlock("gondorian_mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_WALL = registerBlock("gondorian_mossy_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_WALL = registerBlock("gondorian_cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_WALL = registerBlock("gondorian_cracked_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_BUTTON = registerBlock("gondorian_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_BUTTON = registerBlock("gondorian_mossy_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_BUTTON = registerBlock("gondorian_cracked_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_BUTTON = registerBlock("gondorian_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_BUTTON = registerBlock("gondorian_mossy_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_BUTTON = registerBlock("gondorian_brick_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_PRESSURE_PLATE = registerBlock("gondorian_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_PRESSURE_PLATE = registerBlock("gondorian_mossy_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_PRESSURE_PLATE = registerBlock("gondorian_cracked_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_PRESSURE_PLATE = registerBlock("gondorian_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE = registerBlock("gondorian_mossy_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_PRESSURE_PLATE = registerBlock("gondorian_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_PRESSURE_PLATE = registerBlock("gondorian_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE = registerBlock("gondorian_mossy_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE = registerBlock("gondorian_mossy_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE = registerBlock("gondorian_cracked_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE = registerBlock("gondorian_cracked_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("gondorian_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("gondorian_mossy_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));


    public static final DeferredBlock<Block> DURIN_STONE = registerBlock("durin_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE = registerBlock("durin_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE = registerBlock("durin_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_BRICK = registerBlock("durin_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK = registerBlock("durin_gold_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK = registerBlock("durin_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK = registerBlock("durin_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK = registerBlock("durin_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK = registerBlock("durin_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_PILLAR = registerBlock("durin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_PILLAR = registerBlock("durin_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_PILLAR = registerBlock("durin_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_COLUMN = registerBlock("durin_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_COLUMN = registerBlock("durin_cracked_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COLUMN = registerBlock("durin_mossy_column",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CARVED_STONE = registerBlock("durin_carved_stone",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));





    /* ORES */
    public static final DeferredBlock<Block> AMBER_ORE = registerBlock("amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_AMBER_ORE = registerBlock("deepslate_amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AMBER_BLOCK = registerBlock("amber_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_AMETHYST_ORE = registerBlock("deepslate_amethyst_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AMETHYST_BLOCK = registerBlock("amethyst_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> DIAMOND_ORE = registerBlock("diamond_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_DIAMOND_ORE = registerBlock("deepslate_diamond_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DIAMOND_BLOCK = registerBlock("diamond_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> EMERALD_ORE = registerBlock("emerald_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_EMERALD_ORE = registerBlock("deepslate_emerald_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> EMERALD_BLOCK = registerBlock("emerald_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> OPAL_ORE = registerBlock("opal_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_OPAL_ORE = registerBlock("deepslate_opal_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> OPAL_BLOCK = registerBlock("opal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> SALT_ORE = registerBlock("salt_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> SALTPETER_ORE = registerBlock("saltpeter_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SALTPETER_ORE = registerBlock("deepslate_saltpeter_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SALTPETER_BLOCK = registerBlock("saltpeter_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
    public static final DeferredBlock<Block> GLOWSTONE_ORE = registerBlock("glowstone_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_GLOWSTONE_ORE = registerBlock("deepslate_glowstone_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
