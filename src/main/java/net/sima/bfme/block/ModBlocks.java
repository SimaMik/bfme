package net.sima.bfme.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.block.custom.*;
import net.sima.bfme.block.custom.furnace.HumanFurnace;
import net.sima.bfme.block.wood.*;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.util.ModWoodTypes;
import net.sima.bfme.worldgen.tree.ModTreeGrowers;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BFME.MOD_ID);

    public static final DeferredBlock<Block> GONDORIAN_CRAFTING_TABLE = registerBlock("gondorian_crafting_table",
            () -> new GondorianCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

    public static final DeferredBlock<Block> HUMAN_FURNACE = registerBlock("human_furnace",
            () -> new HumanFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE).noOcclusion()));
    public static final DeferredBlock<Block> PRIVATE_BLOCK = registerBlock("private_block",
            () -> new PrivateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));


    public static final DeferredBlock<Block> GONDORIAN_STONE = registerBlock("gondorian_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE = registerBlock("gondorian_smooth_stone",
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
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_PILLAR = registerBlock("gondorian_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_PILLAR_VERTICAL_SLAB = registerBlock("gondorian_mossy_pillar_vertical_slab",
            () -> new HorizontalVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_PILLAR = registerBlock("gondorian_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_COLUMN = registerBlock("gondorian_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COLUMN = registerBlock("gondorian_mossy_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_COLUMN = registerBlock("gondorian_cracked_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_STAIRS = registerBlock("gondorian_stone_stairs",
            () -> new StairBlock(GONDORIAN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE_STAIRS = registerBlock("gondorian_smooth_stone_stairs",
            () -> new StairBlock(GONDORIAN_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_STONE_STAIRS = registerBlock("gondorian_mossy_stone_stairs",
            () -> new StairBlock(GONDORIAN_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));;
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_STONE_STAIRS = registerBlock("gondorian_cracked_stone_stairs",
            () -> new StairBlock(GONDORIAN_CRACKED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_COBBLESTONE_STAIRS = registerBlock("gondorian_cobblestone_stairs",
            () -> new StairBlock(GONDORIAN_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_COBBLESTONE_STAIRS = registerBlock("gondorian_mossy_cobblestone_stairs",
            () -> new StairBlock(GONDORIAN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICK_STAIRS = registerBlock("gondorian_brick_stairs",
            () -> new StairBlock(GONDORIAN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_BRICKWORK_STAIRS = registerBlock("gondorian_brickwork_stairs",
            () -> new StairBlock(GONDORIAN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICK_STAIRS = registerBlock("gondorian_mossy_brick_stairs",
            () -> new StairBlock(GONDORIAN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_MOSSY_BRICKWORK_STAIRS = registerBlock("gondorian_mossy_brickwork_stairs",
            () -> new StairBlock(GONDORIAN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICK_STAIRS = registerBlock("gondorian_cracked_brick_stairs",
            () -> new StairBlock(GONDORIAN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_CRACKED_BRICKWORK_STAIRS = registerBlock("gondorian_cracked_brickwork_stairs",
            () -> new StairBlock(GONDORIAN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> GONDORIAN_STONE_SLAB = registerBlock("gondorian_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE_SLAB = registerBlock("gondorian_smooth_stone_slab",
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
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE_VERTICAL_SLAB = registerBlock("gondorian_smooth_stone_vertical_slab",
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
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE_WALL = registerBlock("gondorian_smooth_stone_wall",
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
    public static final DeferredBlock<Block> GONDORIAN_SMOOTH_STONE_PRESSURE_PLATE = registerBlock("gondorian_smooth_stone_pressure_plate",
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
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE = registerBlock("durin_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE = registerBlock("durin_cracked_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE = registerBlock("durin_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE = registerBlock("durin_mossy_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICK = registerBlock("durin_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK = registerBlock("durin_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK = registerBlock("durin_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK = registerBlock("durin_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK = registerBlock("durin_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK = registerBlock("durin_cracked_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CHISELED_BRICK = registerBlock("durin_chiseled_brick",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_CHISELED_BRICK = registerBlock("durin_mossy_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK = registerBlock("durin_gold_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE = registerBlock("durin_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_PILLAR = registerBlock("durin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_PILLAR = registerBlock("durin_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_PILLAR = registerBlock("durin_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_COLUMN = registerBlock("durin_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COLUMN = registerBlock("durin_mossy_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_COLUMN = registerBlock("durin_cracked_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_STONE_STAIRS = registerBlock("durin_stone_stairs",
            () -> new StairBlock(DURIN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_STAIRS = registerBlock("durin_mossy_stone_stairs",
            () -> new StairBlock(DURIN_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));;
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_STAIRS = registerBlock("durin_cracked_stone_stairs",
            () -> new StairBlock(DURIN_CRACKED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_STAIRS = registerBlock("durin_cobblestone_stairs",
            () -> new StairBlock(DURIN_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_STAIRS = registerBlock("durin_mossy_cobblestone_stairs",
            () -> new StairBlock(DURIN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICK_STAIRS = registerBlock("durin_brick_stairs",
            () -> new StairBlock(DURIN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK_STAIRS = registerBlock("durin_brickwork_stairs",
            () -> new StairBlock(DURIN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK_STAIRS = registerBlock("durin_mossy_brick_stairs",
            () -> new StairBlock(DURIN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK_STAIRS = registerBlock("durin_mossy_brickwork_stairs",
            () -> new StairBlock(DURIN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK_STAIRS = registerBlock("durin_cracked_brick_stairs",
            () -> new StairBlock(DURIN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK_STAIRS = registerBlock("durin_cracked_brickwork_stairs",
            () -> new StairBlock(DURIN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE_STAIRS = registerBlock("durin_smooth_stone_stairs",
            () -> new StairBlock(DURIN_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK_STAIRS = registerBlock("durin_gold_brick_stairs",
            () -> new StairBlock(DURIN_GOLD_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_STONE_SLAB = registerBlock("durin_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_SLAB = registerBlock("durin_mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_SLAB = registerBlock("durin_cracked_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_SLAB = registerBlock("durin_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_SLAB = registerBlock("durin_mossy_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICK_SLAB = registerBlock("durin_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK_SLAB = registerBlock("durin_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK_SLAB = registerBlock("durin_cracked_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK_SLAB = registerBlock("durin_cracked_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK_SLAB = registerBlock("durin_mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK_SLAB = registerBlock("durin_mossy_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_PILLAR_SLAB = registerBlock("durin_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_PILLAR_SLAB = registerBlock("durin_mossy_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_PILLAR_SLAB = registerBlock("durin_cracked_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE_SLAB = registerBlock("durin_smooth_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK_SLAB = registerBlock("durin_gold_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_STONE_VERTICAL_SLAB = registerBlock("durin_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_VERTICAL_SLAB = registerBlock("durin_mossy_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_VERTICAL_SLAB = registerBlock("durin_cracked_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_VERTICAL_SLAB = registerBlock("durin_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB = registerBlock("durin_mossy_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICK_VERTICAL_SLAB = registerBlock("durin_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK_VERTICAL_SLAB = registerBlock("durin_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK_VERTICAL_SLAB = registerBlock("durin_cracked_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB = registerBlock("durin_cracked_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK_VERTICAL_SLAB = registerBlock("durin_mossy_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB = registerBlock("durin_mossy_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE_VERTICAL_SLAB = registerBlock("durin_smooth_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK_VERTICAL_SLAB = registerBlock("durin_gold_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> DURIN_STONE_WALL = registerBlock("durin_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_WALL = registerBlock("durin_mossy_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_WALL = registerBlock("durin_cracked_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_WALL = registerBlock("durin_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_WALL = registerBlock("durin_mossy_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_BRICK_WALL = registerBlock("durin_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK_WALL = registerBlock("durin_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK_WALL = registerBlock("durin_mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK_WALL = registerBlock("durin_mossy_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK_WALL = registerBlock("durin_cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK_WALL = registerBlock("durin_cracked_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE_WALL = registerBlock("durin_smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK_WALL = registerBlock("durin_gold_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> DURIN_STONE_BUTTON = registerBlock("durin_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_BUTTON = registerBlock("durin_mossy_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_BUTTON = registerBlock("durin_cracked_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_BUTTON = registerBlock("durin_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_BUTTON = registerBlock("durin_mossy_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> DURIN_BRICK_BUTTON = registerBlock("durin_brick_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

    public static final DeferredBlock<Block> DURIN_STONE_PRESSURE_PLATE = registerBlock("durin_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_STONE_PRESSURE_PLATE = registerBlock("durin_mossy_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_STONE_PRESSURE_PLATE = registerBlock("durin_cracked_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_COBBLESTONE_PRESSURE_PLATE = registerBlock("durin_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_COBBLESTONE_PRESSURE_PLATE = registerBlock("durin_mossy_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_BRICK_PRESSURE_PLATE = registerBlock("durin_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_BRICKWORK_PRESSURE_PLATE = registerBlock("durin_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICK_PRESSURE_PLATE = registerBlock("durin_mossy_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_BRICKWORK_PRESSURE_PLATE = registerBlock("durin_mossy_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICK_PRESSURE_PLATE = registerBlock("durin_cracked_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_CRACKED_BRICKWORK_PRESSURE_PLATE = registerBlock("durin_cracked_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("durin_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("durin_mossy_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_SMOOTH_STONE_PRESSURE_PLATE = registerBlock("durin_smooth_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DURIN_GOLD_BRICK_PRESSURE_PLATE = registerBlock("durin_gold_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));

    /* ROHAN */


    public static final DeferredBlock<Block> ROHAN_STONE = registerBlock("rohan_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE = registerBlock("rohan_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE = registerBlock("rohan_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE = registerBlock("rohan_cracked_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE = registerBlock("rohan_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE = registerBlock("rohan_mossy_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICK = registerBlock("rohan_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK = registerBlock("rohan_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK = registerBlock("rohan_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK = registerBlock("rohan_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK = registerBlock("rohan_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK = registerBlock("rohan_cracked_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CHISELED_BRICK = registerBlock("rohan_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_CHISELED_BRICK = registerBlock("rohan_mossy_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_PILLAR = registerBlock("rohan_pillar",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_PILLAR = registerBlock("rohan_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_PILLAR = registerBlock("rohan_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_COLUMN = registerBlock("rohan_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COLUMN = registerBlock("rohan_mossy_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_COLUMN = registerBlock("rohan_cracked_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_STONE_STAIRS = registerBlock("rohan_stone_stairs",
            () -> new StairBlock(ROHAN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE_STAIRS = registerBlock("rohan_smooth_stone_stairs",
            () -> new StairBlock(ROHAN_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_STAIRS = registerBlock("rohan_mossy_stone_stairs",
            () -> new StairBlock(ROHAN_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));;
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_STAIRS = registerBlock("rohan_cracked_stone_stairs",
            () -> new StairBlock(ROHAN_CRACKED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_STAIRS = registerBlock("rohan_cobblestone_stairs",
            () -> new StairBlock(ROHAN_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_STAIRS = registerBlock("rohan_mossy_cobblestone_stairs",
            () -> new StairBlock(ROHAN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICK_STAIRS = registerBlock("rohan_brick_stairs",
            () -> new StairBlock(ROHAN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK_STAIRS = registerBlock("rohan_brickwork_stairs",
            () -> new StairBlock(ROHAN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK_STAIRS = registerBlock("rohan_mossy_brick_stairs",
            () -> new StairBlock(ROHAN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK_STAIRS = registerBlock("rohan_mossy_brickwork_stairs",
            () -> new StairBlock(ROHAN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK_STAIRS = registerBlock("rohan_cracked_brick_stairs",
            () -> new StairBlock(ROHAN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK_STAIRS = registerBlock("rohan_cracked_brickwork_stairs",
            () -> new StairBlock(ROHAN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_STONE_SLAB = registerBlock("rohan_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE_SLAB = registerBlock("rohan_smooth_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_SLAB = registerBlock("rohan_mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_SLAB = registerBlock("rohan_cracked_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_SLAB = registerBlock("rohan_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_SLAB = registerBlock("rohan_mossy_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICK_SLAB = registerBlock("rohan_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK_SLAB = registerBlock("rohan_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK_SLAB = registerBlock("rohan_cracked_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK_SLAB = registerBlock("rohan_cracked_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK_SLAB = registerBlock("rohan_mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK_SLAB = registerBlock("rohan_mossy_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_PILLAR_SLAB = registerBlock("rohan_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_PILLAR_SLAB = registerBlock("rohan_mossy_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_PILLAR_SLAB = registerBlock("rohan_cracked_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_STONE_VERTICAL_SLAB = registerBlock("rohan_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE_VERTICAL_SLAB = registerBlock("rohan_smooth_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_VERTICAL_SLAB = registerBlock("rohan_mossy_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_VERTICAL_SLAB = registerBlock("rohan_cracked_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_VERTICAL_SLAB = registerBlock("rohan_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB = registerBlock("rohan_mossy_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICK_VERTICAL_SLAB = registerBlock("rohan_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK_VERTICAL_SLAB = registerBlock("rohan_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK_VERTICAL_SLAB = registerBlock("rohan_cracked_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB = registerBlock("rohan_cracked_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK_VERTICAL_SLAB = registerBlock("rohan_mossy_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB = registerBlock("rohan_mossy_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_STONE_WALL = registerBlock("rohan_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE_WALL = registerBlock("rohan_smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_WALL = registerBlock("rohan_mossy_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_WALL = registerBlock("rohan_cracked_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_WALL = registerBlock("rohan_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_WALL = registerBlock("rohan_mossy_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICK_WALL = registerBlock("rohan_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK_WALL = registerBlock("rohan_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK_WALL = registerBlock("rohan_mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK_WALL = registerBlock("rohan_mossy_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK_WALL = registerBlock("rohan_cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK_WALL = registerBlock("rohan_cracked_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> ROHAN_STONE_BUTTON = registerBlock("rohan_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_BUTTON = registerBlock("rohan_mossy_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_BUTTON = registerBlock("rohan_cracked_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_BUTTON = registerBlock("rohan_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_BUTTON = registerBlock("rohan_mossy_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> ROHAN_BRICK_BUTTON = registerBlock("rohan_brick_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

    public static final DeferredBlock<Block> ROHAN_STONE_PRESSURE_PLATE = registerBlock("rohan_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_SMOOTH_STONE_PRESSURE_PLATE = registerBlock("rohan_smooth_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_STONE_PRESSURE_PLATE = registerBlock("rohan_mossy_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_STONE_PRESSURE_PLATE = registerBlock("rohan_cracked_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_COBBLESTONE_PRESSURE_PLATE = registerBlock("rohan_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_COBBLESTONE_PRESSURE_PLATE = registerBlock("rohan_mossy_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_BRICK_PRESSURE_PLATE = registerBlock("rohan_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_BRICKWORK_PRESSURE_PLATE = registerBlock("rohan_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICK_PRESSURE_PLATE = registerBlock("rohan_mossy_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_BRICKWORK_PRESSURE_PLATE = registerBlock("rohan_mossy_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICK_PRESSURE_PLATE = registerBlock("rohan_cracked_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_CRACKED_BRICKWORK_PRESSURE_PLATE = registerBlock("rohan_cracked_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("rohan_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROHAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("rohan_mossy_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));


    public static final DeferredBlock<Block> NUMENOREAN_STONE = registerBlock("numenorean_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE = registerBlock("numenorean_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE = registerBlock("numenorean_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE = registerBlock("numenorean_cracked_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE = registerBlock("numenorean_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE = registerBlock("numenorean_mossy_cobblestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK = registerBlock("numenorean_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK = registerBlock("numenorean_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK = registerBlock("numenorean_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK = registerBlock("numenorean_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK = registerBlock("numenorean_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK = registerBlock("numenorean_cracked_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CHISELED_BRICK = registerBlock("numenorean_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_CHISELED_BRICK = registerBlock("numenorean_mossy_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_PILLAR = registerBlock("numenorean_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_PILLAR = registerBlock("numenorean_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_PILLAR = registerBlock("numenorean_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_COLUMN = registerBlock("numenorean_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COLUMN = registerBlock("numenorean_mossy_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_COLUMN = registerBlock("numenorean_cracked_column",
            () -> new TinyColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_STAIRS = registerBlock("numenorean_stone_stairs",
            () -> new StairBlock(NUMENOREAN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE_STAIRS = registerBlock("numenorean_smooth_stone_stairs",
            () -> new StairBlock(NUMENOREAN_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_STAIRS = registerBlock("numenorean_mossy_stone_stairs",
            () -> new StairBlock(NUMENOREAN_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));;
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_STAIRS = registerBlock("numenorean_cracked_stone_stairs",
            () -> new StairBlock(NUMENOREAN_CRACKED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_STAIRS = registerBlock("numenorean_cobblestone_stairs",
            () -> new StairBlock(NUMENOREAN_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_STAIRS = registerBlock("numenorean_mossy_cobblestone_stairs",
            () -> new StairBlock(NUMENOREAN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_STAIRS = registerBlock("numenorean_brick_stairs",
            () -> new StairBlock(NUMENOREAN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK_STAIRS = registerBlock("numenorean_brickwork_stairs",
            () -> new StairBlock(NUMENOREAN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK_STAIRS = registerBlock("numenorean_mossy_brick_stairs",
            () -> new StairBlock(NUMENOREAN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK_STAIRS = registerBlock("numenorean_mossy_brickwork_stairs",
            () -> new StairBlock(NUMENOREAN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK_STAIRS = registerBlock("numenorean_cracked_brick_stairs",
            () -> new StairBlock(NUMENOREAN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK_STAIRS = registerBlock("numenorean_cracked_brickwork_stairs",
            () -> new StairBlock(NUMENOREAN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_SLAB = registerBlock("numenorean_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE_SLAB = registerBlock("numenorean_smooth_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_SLAB = registerBlock("numenorean_mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_SLAB = registerBlock("numenorean_cracked_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_SLAB = registerBlock("numenorean_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_SLAB = registerBlock("numenorean_mossy_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_SLAB = registerBlock("numenorean_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK_SLAB = registerBlock("numenorean_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK_SLAB = registerBlock("numenorean_cracked_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK_SLAB = registerBlock("numenorean_cracked_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK_SLAB = registerBlock("numenorean_mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK_SLAB = registerBlock("numenorean_mossy_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_PILLAR_SLAB = registerBlock("numenorean_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_PILLAR_SLAB = registerBlock("numenorean_mossy_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_PILLAR_SLAB = registerBlock("numenorean_cracked_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_VERTICAL_SLAB = registerBlock("numenorean_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE_VERTICAL_SLAB = registerBlock("numenorean_smooth_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_VERTICAL_SLAB = registerBlock("numenorean_mossy_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_VERTICAL_SLAB = registerBlock("numenorean_cracked_stone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_VERTICAL_SLAB = registerBlock("numenorean_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_VERTICAL_SLAB = registerBlock("numenorean_mossy_cobblestone_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_VERTICAL_SLAB = registerBlock("numenorean_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK_VERTICAL_SLAB = registerBlock("numenorean_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK_VERTICAL_SLAB = registerBlock("numenorean_cracked_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK_VERTICAL_SLAB = registerBlock("numenorean_cracked_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK_VERTICAL_SLAB = registerBlock("numenorean_mossy_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK_VERTICAL_SLAB = registerBlock("numenorean_mossy_brickwork_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_WALL = registerBlock("numenorean_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE_WALL = registerBlock("numenorean_smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_WALL = registerBlock("numenorean_mossy_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_WALL = registerBlock("numenorean_cracked_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_WALL = registerBlock("numenorean_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_WALL = registerBlock("numenorean_mossy_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_WALL = registerBlock("numenorean_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK_WALL = registerBlock("numenorean_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK_WALL = registerBlock("numenorean_mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK_WALL = registerBlock("numenorean_mossy_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK_WALL = registerBlock("numenorean_cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK_WALL = registerBlock("numenorean_cracked_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_BUTTON = registerBlock("numenorean_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_BUTTON = registerBlock("numenorean_mossy_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_BUTTON = registerBlock("numenorean_cracked_stone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_BUTTON = registerBlock("numenorean_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_BUTTON = registerBlock("numenorean_mossy_cobblestone_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_BUTTON = registerBlock("numenorean_brick_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

    public static final DeferredBlock<Block> NUMENOREAN_STONE_PRESSURE_PLATE = registerBlock("numenorean_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_SMOOTH_STONE_PRESSURE_PLATE = registerBlock("numenorean_smooth_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_STONE_PRESSURE_PLATE = registerBlock("numenorean_mossy_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_STONE_PRESSURE_PLATE = registerBlock("numenorean_cracked_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_COBBLESTONE_PRESSURE_PLATE = registerBlock("numenorean_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_COBBLESTONE_PRESSURE_PLATE = registerBlock("numenorean_mossy_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICK_PRESSURE_PLATE = registerBlock("numenorean_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_BRICKWORK_PRESSURE_PLATE = registerBlock("numenorean_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICK_PRESSURE_PLATE = registerBlock("numenorean_mossy_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_BRICKWORK_PRESSURE_PLATE = registerBlock("numenorean_mossy_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICK_PRESSURE_PLATE = registerBlock("numenorean_cracked_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_CRACKED_BRICKWORK_PRESSURE_PLATE = registerBlock("numenorean_cracked_brickwork_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("numenorean_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NUMENOREAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE = registerBlock("numenorean_mossy_chiseled_brick_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE)));

    /* WOOD */
    public static final DeferredBlock<Block> ALMOND_BEAM = registerBlock("almond_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ALMOND_BEAM_SLAB = registerBlock("almond_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ALMOND_BEAM_STAIRS = registerBlock("almond_beam_stairs",
            () -> new ModStrippedStairs(ALMOND_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ALMOND_BEAM_VERTICAL_SLAB = registerBlock("almond_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ALMOND_LOG = registerBlock("stripped_almond_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_LOG_SLAB = registerBlock("stripped_almond_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_LOG_STAIRS = registerBlock("stripped_almond_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_ALMOND_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_LOG_VERTICAL_SLAB = registerBlock("stripped_almond_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ALMOND_WOOD = registerBlock("stripped_almond_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_WOOD_SLAB = registerBlock("stripped_almond_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_WOOD_STAIRS = registerBlock("stripped_almond_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_ALMOND_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ALMOND_WOOD_VERTICAL_SLAB = registerBlock("stripped_almond_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> ALMOND_LOG = registerBlock("almond_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_LOG));
    public static final DeferredBlock<Block> ALMOND_LOG_SLAB = registerBlock("almond_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_LOG_SLAB));
    public static final DeferredBlock<Block> ALMOND_LOG_STAIRS = registerBlock("almond_log_stairs",
            () -> new ModStairs(ALMOND_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_LOG_STAIRS));
    public static final DeferredBlock<Block> ALMOND_LOG_VERTICAL_SLAB = registerBlock("almond_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ALMOND_WOOD = registerBlock("almond_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_WOOD));
    public static final DeferredBlock<Block> ALMOND_WOOD_SLAB = registerBlock("almond_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_WOOD_SLAB));
    public static final DeferredBlock<Block> ALMOND_WOOD_STAIRS = registerBlock("almond_wood_stairs",
            () -> new ModStairs(ALMOND_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_WOOD_STAIRS));
    public static final DeferredBlock<Block> ALMOND_WOOD_VERTICAL_SLAB = registerBlock("almond_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ALMOND_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ALMOND_PLANKS = registerBlock("almond_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ALMOND_PLANKS_VERTICAL_SLAB = registerBlock("almond_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(ALMOND_PLANKS.get())));

    public static final DeferredBlock<Block> ALMOND_PLANKS_STAIRS = registerBlock("almond_planks_stairs",
            () -> new ModStrippedStairs(ALMOND_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(ALMOND_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ALMOND_PLANKS_SLAB = registerBlock("almond_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(ALMOND_PLANKS.get())));
    public static final DeferredBlock<Block> ALMOND_FENCE = registerBlock("almond_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> ALMOND_FENCE_GATE = registerBlock("almond_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.ALMOND, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> ALMOND_DOOR = registerBlock("almond_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> ALMOND_TRAPDOOR = registerBlock("almond_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> ALMOND_PRESSURE_PLATE = registerBlock("almond_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> ALMOND_BUTTON = registerBlock("almond_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> ALMOND_LEAVES = registerBlock("almond_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.ALMOND));
    public static final DeferredBlock<Block> ALMOND_SAPLING = registerBlock("almond_sapling",
            () -> new SaplingBlock(ModTreeGrowers.ALMOND, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ALMOND_SIGN = BLOCKS.register("almond_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.ALMOND));
    public static final DeferredBlock<Block> ALMOND_WALL_SIGN = BLOCKS.register("almond_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ALMOND));
    public static final DeferredBlock<Block> ALMOND_HANGING_SIGN = BLOCKS.register("almond_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ALMOND));
    public static final DeferredBlock<Block> ALMOND_WALL_HANGING_SIGN = BLOCKS.register("almond_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ALMOND));

    public static final DeferredBlock<Block> APPLE_BEAM = registerBlock("apple_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> APPLE_BEAM_SLAB = registerBlock("apple_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> APPLE_BEAM_STAIRS = registerBlock("apple_beam_stairs",
            () -> new ModStrippedStairs(APPLE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> APPLE_BEAM_VERTICAL_SLAB = registerBlock("apple_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_LOG_SLAB = registerBlock("stripped_apple_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_LOG_STAIRS = registerBlock("stripped_apple_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_APPLE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_LOG_VERTICAL_SLAB = registerBlock("stripped_apple_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_WOOD_SLAB = registerBlock("stripped_apple_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_WOOD_STAIRS = registerBlock("stripped_apple_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_APPLE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_APPLE_WOOD_VERTICAL_SLAB = registerBlock("stripped_apple_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> APPLE_LOG = registerBlock("apple_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_LOG));
    public static final DeferredBlock<Block> APPLE_LOG_SLAB = registerBlock("apple_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_LOG_SLAB));
    public static final DeferredBlock<Block> APPLE_LOG_STAIRS = registerBlock("apple_log_stairs",
            () -> new ModStairs(APPLE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_LOG_STAIRS));
    public static final DeferredBlock<Block> APPLE_LOG_VERTICAL_SLAB = registerBlock("apple_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_APPLE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> APPLE_WOOD = registerBlock("apple_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_WOOD));
    public static final DeferredBlock<Block> APPLE_WOOD_SLAB = registerBlock("apple_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_WOOD_SLAB));
    public static final DeferredBlock<Block> APPLE_WOOD_STAIRS = registerBlock("apple_wood_stairs",
            () -> new ModStairs(APPLE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_APPLE_WOOD_STAIRS));
    public static final DeferredBlock<Block> APPLE_WOOD_VERTICAL_SLAB = registerBlock("apple_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_APPLE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> APPLE_PLANKS = registerBlock("apple_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> APPLE_PLANKS_VERTICAL_SLAB = registerBlock("apple_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(APPLE_PLANKS.get())));
    public static final DeferredBlock<Block> APPLE_PLANKS_STAIRS = registerBlock("apple_planks_stairs",
            () -> new ModStrippedStairs(APPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(APPLE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> APPLE_PLANKS_SLAB = registerBlock("apple_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(APPLE_PLANKS.get())));
    public static final DeferredBlock<Block> APPLE_FENCE = registerBlock("apple_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> APPLE_FENCE_GATE = registerBlock("apple_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> APPLE_DOOR = registerBlock("apple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> APPLE_TRAPDOOR = registerBlock("apple_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> APPLE_PRESSURE_PLATE = registerBlock("apple_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> APPLE_BUTTON = registerBlock("apple_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.APPLE));
    public static final DeferredBlock<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.APPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> APPLE_SIGN = BLOCKS.register("apple_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.APPLE));
    public static final DeferredBlock<Block> APPLE_WALL_SIGN = BLOCKS.register("apple_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.APPLE));
    public static final DeferredBlock<Block> APPLE_HANGING_SIGN = BLOCKS.register("apple_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.APPLE));
    public static final DeferredBlock<Block> APPLE_WALL_HANGING_SIGN = BLOCKS.register("apple_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.APPLE));

    public static final DeferredBlock<Block> ASPEN_BEAM = registerBlock("aspen_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ASPEN_BEAM_SLAB = registerBlock("aspen_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ASPEN_BEAM_STAIRS = registerBlock("aspen_beam_stairs",
            () -> new ModStrippedStairs(ASPEN_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ASPEN_BEAM_VERTICAL_SLAB = registerBlock("aspen_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_LOG_SLAB = registerBlock("stripped_aspen_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_LOG_STAIRS = registerBlock("stripped_aspen_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_ASPEN_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_LOG_VERTICAL_SLAB = registerBlock("stripped_aspen_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_WOOD_SLAB = registerBlock("stripped_aspen_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_WOOD_STAIRS = registerBlock("stripped_aspen_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_ASPEN_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_WOOD_VERTICAL_SLAB = registerBlock("stripped_aspen_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> ASPEN_LOG = registerBlock("aspen_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_LOG));
    public static final DeferredBlock<Block> ASPEN_LOG_SLAB = registerBlock("aspen_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_LOG_SLAB));
    public static final DeferredBlock<Block> ASPEN_LOG_STAIRS = registerBlock("aspen_log_stairs",
            () -> new ModStairs(ASPEN_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_LOG_STAIRS));
    public static final DeferredBlock<Block> ASPEN_LOG_VERTICAL_SLAB = registerBlock("aspen_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_ASPEN_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ASPEN_WOOD = registerBlock("aspen_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_WOOD));
    public static final DeferredBlock<Block> ASPEN_WOOD_SLAB = registerBlock("aspen_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_WOOD_SLAB));
    public static final DeferredBlock<Block> ASPEN_WOOD_STAIRS = registerBlock("aspen_wood_stairs",
            () -> new ModStairs(ASPEN_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ASPEN_WOOD_STAIRS));
    public static final DeferredBlock<Block> ASPEN_WOOD_VERTICAL_SLAB = registerBlock("aspen_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_ASPEN_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ASPEN_PLANKS = registerBlock("aspen_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ASPEN_PLANKS_VERTICAL_SLAB = registerBlock("aspen_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(ASPEN_PLANKS.get())));
    public static final DeferredBlock<Block> ASPEN_PLANKS_STAIRS = registerBlock("aspen_planks_stairs",
            () -> new ModStrippedStairs(ASPEN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(ASPEN_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ASPEN_PLANKS_SLAB = registerBlock("aspen_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(ASPEN_PLANKS.get())));
    public static final DeferredBlock<Block> ASPEN_FENCE = registerBlock("aspen_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> ASPEN_DOOR = registerBlock("aspen_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> ASPEN_TRAPDOOR = registerBlock("aspen_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> ASPEN_PRESSURE_PLATE = registerBlock("aspen_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> ASPEN_BUTTON = registerBlock("aspen_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> ASPEN_LEAVES = registerBlock("aspen_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> ASPEN_SAPLING = registerBlock("aspen_sapling",
            () -> new SaplingBlock(ModTreeGrowers.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.ASPEN));
    public static final DeferredBlock<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ASPEN));
    public static final DeferredBlock<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ASPEN));
    public static final DeferredBlock<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ASPEN));

    public static final DeferredBlock<Block> BANANA_BEAM = registerBlock("banana_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BANANA_BEAM_SLAB = registerBlock("banana_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BANANA_BEAM_STAIRS = registerBlock("banana_beam_stairs",
            () -> new ModStrippedStairs(BANANA_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BANANA_BEAM_VERTICAL_SLAB = registerBlock("banana_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BANANA_LOG = registerBlock("stripped_banana_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_LOG_SLAB = registerBlock("stripped_banana_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_LOG_STAIRS = registerBlock("stripped_banana_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_BANANA_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_LOG_VERTICAL_SLAB = registerBlock("stripped_banana_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BANANA_WOOD = registerBlock("stripped_banana_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_WOOD_SLAB = registerBlock("stripped_banana_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_WOOD_STAIRS = registerBlock("stripped_banana_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_BANANA_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BANANA_WOOD_VERTICAL_SLAB = registerBlock("stripped_banana_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> BANANA_LOG = registerBlock("banana_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_LOG));
    public static final DeferredBlock<Block> BANANA_LOG_SLAB = registerBlock("banana_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_LOG_SLAB));
    public static final DeferredBlock<Block> BANANA_LOG_STAIRS = registerBlock("banana_log_stairs",
            () -> new ModStairs(BANANA_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_LOG_STAIRS));
    public static final DeferredBlock<Block> BANANA_LOG_VERTICAL_SLAB = registerBlock("banana_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BANANA_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BANANA_WOOD = registerBlock("banana_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_WOOD));
    public static final DeferredBlock<Block> BANANA_WOOD_SLAB = registerBlock("banana_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_WOOD_SLAB));
    public static final DeferredBlock<Block> BANANA_WOOD_STAIRS = registerBlock("banana_wood_stairs",
            () -> new ModStairs(BANANA_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BANANA_WOOD_STAIRS));
    public static final DeferredBlock<Block> BANANA_WOOD_VERTICAL_SLAB = registerBlock("banana_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BANANA_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BANANA_PLANKS = registerBlock("banana_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BANANA_PLANKS_VERTICAL_SLAB = registerBlock("banana_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(BANANA_PLANKS.get())));

    public static final DeferredBlock<Block> BANANA_PLANKS_STAIRS = registerBlock("banana_planks_stairs",
            () -> new ModStrippedStairs(BANANA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(BANANA_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> BANANA_PLANKS_SLAB = registerBlock("banana_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(BANANA_PLANKS.get())));
    public static final DeferredBlock<Block> BANANA_FENCE = registerBlock("banana_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> BANANA_FENCE_GATE = registerBlock("banana_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> BANANA_DOOR = registerBlock("banana_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> BANANA_TRAPDOOR = registerBlock("banana_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> BANANA_PRESSURE_PLATE = registerBlock("banana_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> BANANA_BUTTON = registerBlock("banana_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BANANA_SAPLING = registerBlock("banana_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BANANA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BANANA_SIGN = BLOCKS.register("banana_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.BANANA));
    public static final DeferredBlock<Block> BANANA_WALL_SIGN = BLOCKS.register("banana_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.BANANA));
    public static final DeferredBlock<Block> BANANA_HANGING_SIGN = BLOCKS.register("banana_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.BANANA));
    public static final DeferredBlock<Block> BANANA_WALL_HANGING_SIGN = BLOCKS.register("banana_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.BANANA));

    public static final DeferredBlock<Block> BAOBAB_BEAM = registerBlock("baobab_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BAOBAB_BEAM_SLAB = registerBlock("baobab_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BAOBAB_BEAM_STAIRS = registerBlock("baobab_beam_stairs",
            () -> new ModStrippedStairs(BAOBAB_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BAOBAB_BEAM_VERTICAL_SLAB = registerBlock("baobab_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BAOBAB_LOG = registerBlock("stripped_baobab_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_LOG_SLAB = registerBlock("stripped_baobab_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_LOG_STAIRS = registerBlock("stripped_baobab_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_BAOBAB_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_LOG_VERTICAL_SLAB = registerBlock("stripped_baobab_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BAOBAB_WOOD = registerBlock("stripped_baobab_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_WOOD_SLAB = registerBlock("stripped_baobab_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_WOOD_STAIRS = registerBlock("stripped_baobab_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_BAOBAB_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB = registerBlock("stripped_baobab_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> BAOBAB_LOG = registerBlock("baobab_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_LOG));
    public static final DeferredBlock<Block> BAOBAB_LOG_SLAB = registerBlock("baobab_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_LOG_SLAB));
    public static final DeferredBlock<Block> BAOBAB_LOG_STAIRS = registerBlock("baobab_log_stairs",
            () -> new ModStairs(BAOBAB_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_LOG_STAIRS));
    public static final DeferredBlock<Block> BAOBAB_LOG_VERTICAL_SLAB = registerBlock("baobab_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BAOBAB_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BAOBAB_WOOD = registerBlock("baobab_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_WOOD));
    public static final DeferredBlock<Block> BAOBAB_WOOD_SLAB = registerBlock("baobab_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_WOOD_SLAB));
    public static final DeferredBlock<Block> BAOBAB_WOOD_STAIRS = registerBlock("baobab_wood_stairs",
            () -> new ModStairs(BAOBAB_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BAOBAB_WOOD_STAIRS));
    public static final DeferredBlock<Block> BAOBAB_WOOD_VERTICAL_SLAB = registerBlock("baobab_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BAOBAB_PLANKS = registerBlock("baobab_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BAOBAB_PLANKS_VERTICAL_SLAB = registerBlock("baobab_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(BAOBAB_PLANKS.get())));

    public static final DeferredBlock<Block> BAOBAB_PLANKS_STAIRS = registerBlock("baobab_planks_stairs",
            () -> new ModStrippedStairs(BAOBAB_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(BAOBAB_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> BAOBAB_PLANKS_SLAB = registerBlock("baobab_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(BAOBAB_PLANKS.get())));
    public static final DeferredBlock<Block> BAOBAB_FENCE = registerBlock("baobab_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> BAOBAB_FENCE_GATE = registerBlock("baobab_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.BAOBAB, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> BAOBAB_DOOR = registerBlock("baobab_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> BAOBAB_TRAPDOOR = registerBlock("baobab_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> BAOBAB_PRESSURE_PLATE = registerBlock("baobab_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> BAOBAB_BUTTON = registerBlock("baobab_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> BAOBAB_LEAVES = registerBlock("baobab_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BAOBAB_SAPLING = registerBlock("baobab_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BAOBAB, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BAOBAB_SIGN = BLOCKS.register("baobab_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.BAOBAB));
    public static final DeferredBlock<Block> BAOBAB_WALL_SIGN = BLOCKS.register("baobab_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.BAOBAB));
    public static final DeferredBlock<Block> BAOBAB_HANGING_SIGN = BLOCKS.register("baobab_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.BAOBAB));
    public static final DeferredBlock<Block> BAOBAB_WALL_HANGING_SIGN = BLOCKS.register("baobab_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.BAOBAB));

    public static final DeferredBlock<Block> BEECH_BEAM = registerBlock("beech_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BEECH_BEAM_SLAB = registerBlock("beech_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BEECH_BEAM_STAIRS = registerBlock("beech_beam_stairs",
            () -> new ModStrippedStairs(BEECH_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BEECH_BEAM_VERTICAL_SLAB = registerBlock("beech_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BEECH_LOG = registerBlock("stripped_beech_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_LOG_SLAB = registerBlock("stripped_beech_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_LOG_STAIRS = registerBlock("stripped_beech_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_BEECH_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_LOG_VERTICAL_SLAB = registerBlock("stripped_beech_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BEECH_WOOD = registerBlock("stripped_beech_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_WOOD_SLAB = registerBlock("stripped_beech_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_WOOD_STAIRS = registerBlock("stripped_beech_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_BEECH_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BEECH_WOOD_VERTICAL_SLAB = registerBlock("stripped_beech_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> BEECH_LOG = registerBlock("beech_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_LOG));
    public static final DeferredBlock<Block> BEECH_LOG_SLAB = registerBlock("beech_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_LOG_SLAB));
    public static final DeferredBlock<Block> BEECH_LOG_STAIRS = registerBlock("beech_log_stairs",
            () -> new ModStairs(BEECH_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_LOG_STAIRS));
    public static final DeferredBlock<Block> BEECH_LOG_VERTICAL_SLAB = registerBlock("beech_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BEECH_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BEECH_WOOD = registerBlock("beech_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_WOOD));
    public static final DeferredBlock<Block> BEECH_WOOD_SLAB = registerBlock("beech_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_WOOD_SLAB));
    public static final DeferredBlock<Block> BEECH_WOOD_STAIRS = registerBlock("beech_wood_stairs",
            () -> new ModStairs(BEECH_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_BEECH_WOOD_STAIRS));
    public static final DeferredBlock<Block> BEECH_WOOD_VERTICAL_SLAB = registerBlock("beech_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_BEECH_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BEECH_PLANKS = registerBlock("beech_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BEECH_PLANKS_VERTICAL_SLAB = registerBlock("beech_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(BEECH_PLANKS.get())));

    public static final DeferredBlock<Block> BEECH_PLANKS_STAIRS = registerBlock("beech_planks_stairs",
            () -> new ModStrippedStairs(BEECH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(BEECH_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> BEECH_PLANKS_SLAB = registerBlock("beech_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(BEECH_PLANKS.get())));
    public static final DeferredBlock<Block> BEECH_FENCE = registerBlock("beech_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> BEECH_FENCE_GATE = registerBlock("beech_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.BEECH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> BEECH_DOOR = registerBlock("beech_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> BEECH_TRAPDOOR = registerBlock("beech_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> BEECH_PRESSURE_PLATE = registerBlock("beech_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> BEECH_BUTTON = registerBlock("beech_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> BEECH_LEAVES = registerBlock("beech_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BEECH_SAPLING = registerBlock("beech_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BEECH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BEECH_SIGN = BLOCKS.register("beech_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.BEECH));
    public static final DeferredBlock<Block> BEECH_WALL_SIGN = BLOCKS.register("beech_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.BEECH));
    public static final DeferredBlock<Block> BEECH_HANGING_SIGN = BLOCKS.register("beech_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.BEECH));
    public static final DeferredBlock<Block> BEECH_WALL_HANGING_SIGN = BLOCKS.register("beech_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.BEECH));
    public static final DeferredBlock<Block> CEDAR_BEAM = registerBlock("cedar_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CEDAR_BEAM_SLAB = registerBlock("cedar_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CEDAR_BEAM_STAIRS = registerBlock("cedar_beam_stairs",
            () -> new ModStrippedStairs(CEDAR_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CEDAR_BEAM_VERTICAL_SLAB = registerBlock("cedar_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CEDAR_LOG = registerBlock("stripped_cedar_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_LOG_SLAB = registerBlock("stripped_cedar_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_LOG_STAIRS = registerBlock("stripped_cedar_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_CEDAR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_LOG_VERTICAL_SLAB = registerBlock("stripped_cedar_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CEDAR_WOOD = registerBlock("stripped_cedar_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_WOOD_SLAB = registerBlock("stripped_cedar_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_WOOD_STAIRS = registerBlock("stripped_cedar_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_CEDAR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CEDAR_WOOD_VERTICAL_SLAB = registerBlock("stripped_cedar_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> CEDAR_LOG = registerBlock("cedar_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_LOG));
    public static final DeferredBlock<Block> CEDAR_LOG_SLAB = registerBlock("cedar_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_LOG_SLAB));
    public static final DeferredBlock<Block> CEDAR_LOG_STAIRS = registerBlock("cedar_log_stairs",
            () -> new ModStairs(CEDAR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_LOG_STAIRS));
    public static final DeferredBlock<Block> CEDAR_LOG_VERTICAL_SLAB = registerBlock("cedar_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CEDAR_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CEDAR_WOOD = registerBlock("cedar_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_WOOD));
    public static final DeferredBlock<Block> CEDAR_WOOD_SLAB = registerBlock("cedar_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_WOOD_SLAB));
    public static final DeferredBlock<Block> CEDAR_WOOD_STAIRS = registerBlock("cedar_wood_stairs",
            () -> new ModStairs(CEDAR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CEDAR_WOOD_STAIRS));
    public static final DeferredBlock<Block> CEDAR_WOOD_VERTICAL_SLAB = registerBlock("cedar_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CEDAR_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CEDAR_PLANKS = registerBlock("cedar_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CEDAR_PLANKS_VERTICAL_SLAB = registerBlock("cedar_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS.get())));

    public static final DeferredBlock<Block> CEDAR_PLANKS_STAIRS = registerBlock("cedar_planks_stairs",
            () -> new ModStrippedStairs(CEDAR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CEDAR_PLANKS_SLAB = registerBlock("cedar_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS.get())));
    public static final DeferredBlock<Block> CEDAR_FENCE = registerBlock("cedar_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> CEDAR_FENCE_GATE = registerBlock("cedar_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.CEDAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> CEDAR_DOOR = registerBlock("cedar_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> CEDAR_TRAPDOOR = registerBlock("cedar_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> CEDAR_PRESSURE_PLATE = registerBlock("cedar_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> CEDAR_BUTTON = registerBlock("cedar_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> CEDAR_LEAVES = registerBlock("cedar_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CEDAR_SAPLING = registerBlock("cedar_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CEDAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CEDAR_SIGN = BLOCKS.register("cedar_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.CEDAR));
    public static final DeferredBlock<Block> CEDAR_WALL_SIGN = BLOCKS.register("cedar_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CEDAR));
    public static final DeferredBlock<Block> CEDAR_HANGING_SIGN = BLOCKS.register("cedar_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CEDAR));
    public static final DeferredBlock<Block> CEDAR_WALL_HANGING_SIGN = BLOCKS.register("cedar_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CEDAR));

    public static final DeferredBlock<Block> CHARRED_BEAM = registerBlock("charred_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHARRED_BEAM_SLAB = registerBlock("charred_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHARRED_BEAM_STAIRS = registerBlock("charred_beam_stairs",
            () -> new ModStrippedStairs(CHARRED_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHARRED_BEAM_VERTICAL_SLAB = registerBlock("charred_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_LOG_SLAB = registerBlock("stripped_charred_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_LOG_STAIRS = registerBlock("stripped_charred_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_CHARRED_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_LOG_VERTICAL_SLAB = registerBlock("stripped_charred_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_WOOD_SLAB = registerBlock("stripped_charred_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_WOOD_STAIRS = registerBlock("stripped_charred_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_CHARRED_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_WOOD_VERTICAL_SLAB = registerBlock("stripped_charred_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> CHARRED_LOG = registerBlock("charred_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_LOG));
    public static final DeferredBlock<Block> CHARRED_LOG_SLAB = registerBlock("charred_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_LOG_SLAB));
    public static final DeferredBlock<Block> CHARRED_LOG_STAIRS = registerBlock("charred_log_stairs",
            () -> new ModStairs(CHARRED_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_LOG_STAIRS));
    public static final DeferredBlock<Block> CHARRED_LOG_VERTICAL_SLAB = registerBlock("charred_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CHARRED_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CHARRED_WOOD = registerBlock("charred_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_WOOD));
    public static final DeferredBlock<Block> CHARRED_WOOD_SLAB = registerBlock("charred_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_WOOD_SLAB));
    public static final DeferredBlock<Block> CHARRED_WOOD_STAIRS = registerBlock("charred_wood_stairs",
            () -> new ModStairs(CHARRED_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHARRED_WOOD_STAIRS));
    public static final DeferredBlock<Block> CHARRED_WOOD_VERTICAL_SLAB = registerBlock("charred_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CHARRED_WOOD_VERTICAL_SLAB));
    public static final DeferredBlock<Block> CHARRED_PLANKS = registerBlock("charred_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CHARRED_PLANKS_VERTICAL_SLAB = registerBlock("charred_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(CHARRED_PLANKS.get())));

    public static final DeferredBlock<Block> CHARRED_PLANKS_STAIRS = registerBlock("charred_planks_stairs",
            () -> new ModStrippedStairs(CHARRED_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(CHARRED_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CHARRED_PLANKS_SLAB = registerBlock("charred_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(CHARRED_PLANKS.get())));
    public static final DeferredBlock<Block> CHARRED_FENCE = registerBlock("charred_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> CHARRED_FENCE_GATE = registerBlock("charred_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.CHARRED_WOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> CHARRED_DOOR = registerBlock("charred_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> CHARRED_TRAPDOOR = registerBlock("charred_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> CHARRED_BUTTON = registerBlock("charred_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> CHARRED_SIGN = BLOCKS.register("charred_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.CHARRED_WOOD));
    public static final DeferredBlock<Block> CHARRED_WALL_SIGN = BLOCKS.register("charred_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHARRED_WOOD));
    public static final DeferredBlock<Block> CHARRED_HANGING_SIGN = BLOCKS.register("charred_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CHARRED_WOOD));
    public static final DeferredBlock<Block> CHARRED_WALL_HANGING_SIGN = BLOCKS.register("charred_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CHARRED_WOOD));

    public static final DeferredBlock<Block> CHESTNUT_BEAM = registerBlock("chestnut_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHESTNUT_BEAM_SLAB = registerBlock("chestnut_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHESTNUT_BEAM_STAIRS = registerBlock("chestnut_beam_stairs",
            () -> new ModStrippedStairs(CHESTNUT_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CHESTNUT_BEAM_VERTICAL_SLAB = registerBlock("chestnut_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_LOG = registerBlock("stripped_chestnut_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_LOG_SLAB = registerBlock("stripped_chestnut_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_LOG_STAIRS = registerBlock("stripped_chestnut_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_CHESTNUT_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB = registerBlock("stripped_chestnut_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_WOOD = registerBlock("stripped_chestnut_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_WOOD_SLAB = registerBlock("stripped_chestnut_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_WOOD_STAIRS = registerBlock("stripped_chestnut_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_CHESTNUT_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB = registerBlock("stripped_chestnut_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> CHESTNUT_LOG = registerBlock("chestnut_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_LOG));
    public static final DeferredBlock<Block> CHESTNUT_LOG_SLAB = registerBlock("chestnut_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_LOG_SLAB));
    public static final DeferredBlock<Block> CHESTNUT_LOG_STAIRS = registerBlock("chestnut_log_stairs",
            () -> new ModStairs(CHESTNUT_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_LOG_STAIRS));
    public static final DeferredBlock<Block> CHESTNUT_LOG_VERTICAL_SLAB = registerBlock("chestnut_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CHESTNUT_WOOD = registerBlock("chestnut_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_WOOD));
    public static final DeferredBlock<Block> CHESTNUT_WOOD_SLAB = registerBlock("chestnut_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_WOOD_SLAB));
    public static final DeferredBlock<Block> CHESTNUT_WOOD_STAIRS = registerBlock("chestnut_wood_stairs",
            () -> new ModStairs(CHESTNUT_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CHESTNUT_WOOD_STAIRS));
    public static final DeferredBlock<Block> CHESTNUT_WOOD_VERTICAL_SLAB = registerBlock("chestnut_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CHESTNUT_PLANKS = registerBlock("chestnut_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CHESTNUT_PLANKS_VERTICAL_SLAB = registerBlock("chestnut_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(CHESTNUT_PLANKS.get())));

    public static final DeferredBlock<Block> CHESTNUT_PLANKS_STAIRS = registerBlock("chestnut_planks_stairs",
            () -> new ModStrippedStairs(CHESTNUT_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(CHESTNUT_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CHESTNUT_PLANKS_SLAB = registerBlock("chestnut_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(CHESTNUT_PLANKS.get())));
    public static final DeferredBlock<Block> CHESTNUT_FENCE = registerBlock("chestnut_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> CHESTNUT_FENCE_GATE = registerBlock("chestnut_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.CHESTNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> CHESTNUT_DOOR = registerBlock("chestnut_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> CHESTNUT_TRAPDOOR = registerBlock("chestnut_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> CHESTNUT_PRESSURE_PLATE = registerBlock("chestnut_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> CHESTNUT_BUTTON = registerBlock("chestnut_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> CHESTNUT_LEAVES = registerBlock("chestnut_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.CHESTNUT));
    public static final DeferredBlock<Block> CHESTNUT_SAPLING = registerBlock("chestnut_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CHESTNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CHESTNUT_SIGN = BLOCKS.register("chestnut_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.CHESTNUT));
    public static final DeferredBlock<Block> CHESTNUT_WALL_SIGN = BLOCKS.register("chestnut_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHESTNUT));
    public static final DeferredBlock<Block> CHESTNUT_HANGING_SIGN = BLOCKS.register("chestnut_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CHESTNUT));
    public static final DeferredBlock<Block> CHESTNUT_WALL_HANGING_SIGN = BLOCKS.register("chestnut_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CHESTNUT));

    public static final DeferredBlock<Block> CYPRESS_BEAM = registerBlock("cypress_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CYPRESS_BEAM_SLAB = registerBlock("cypress_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CYPRESS_BEAM_STAIRS = registerBlock("cypress_beam_stairs",
            () -> new ModStrippedStairs(CYPRESS_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CYPRESS_BEAM_VERTICAL_SLAB = registerBlock("cypress_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CYPRESS_LOG = registerBlock("stripped_cypress_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_LOG_SLAB = registerBlock("stripped_cypress_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_LOG_STAIRS = registerBlock("stripped_cypress_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_CYPRESS_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_LOG_VERTICAL_SLAB = registerBlock("stripped_cypress_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CYPRESS_WOOD = registerBlock("stripped_cypress_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_WOOD_SLAB = registerBlock("stripped_cypress_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_WOOD_STAIRS = registerBlock("stripped_cypress_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_CYPRESS_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB = registerBlock("stripped_cypress_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> CYPRESS_LOG = registerBlock("cypress_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_LOG));
    public static final DeferredBlock<Block> CYPRESS_LOG_SLAB = registerBlock("cypress_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_LOG_SLAB));
    public static final DeferredBlock<Block> CYPRESS_LOG_STAIRS = registerBlock("cypress_log_stairs",
            () -> new ModStairs(CYPRESS_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_LOG_STAIRS));
    public static final DeferredBlock<Block> CYPRESS_LOG_VERTICAL_SLAB = registerBlock("cypress_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CYPRESS_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CYPRESS_WOOD = registerBlock("cypress_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_WOOD));
    public static final DeferredBlock<Block> CYPRESS_WOOD_SLAB = registerBlock("cypress_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_WOOD_SLAB));
    public static final DeferredBlock<Block> CYPRESS_WOOD_STAIRS = registerBlock("cypress_wood_stairs",
            () -> new ModStairs(CYPRESS_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_CYPRESS_WOOD_STAIRS));
    public static final DeferredBlock<Block> CYPRESS_WOOD_VERTICAL_SLAB = registerBlock("cypress_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CYPRESS_PLANKS = registerBlock("cypress_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CYPRESS_PLANKS_VERTICAL_SLAB = registerBlock("cypress_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(CYPRESS_PLANKS.get())));

    public static final DeferredBlock<Block> CYPRESS_PLANKS_STAIRS = registerBlock("cypress_planks_stairs",
            () -> new ModStrippedStairs(CYPRESS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(CYPRESS_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CYPRESS_PLANKS_SLAB = registerBlock("cypress_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(CYPRESS_PLANKS.get())));
    public static final DeferredBlock<Block> CYPRESS_FENCE = registerBlock("cypress_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> CYPRESS_FENCE_GATE = registerBlock("cypress_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.CYPRESS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> CYPRESS_DOOR = registerBlock("cypress_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> CYPRESS_TRAPDOOR = registerBlock("cypress_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> CYPRESS_PRESSURE_PLATE = registerBlock("cypress_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> CYPRESS_BUTTON = registerBlock("cypress_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> CYPRESS_LEAVES = registerBlock("cypress_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CYPRESS_SAPLING = registerBlock("cypress_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CYPRESS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CYPRESS_SIGN = BLOCKS.register("cypress_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.CYPRESS));
    public static final DeferredBlock<Block> CYPRESS_WALL_SIGN = BLOCKS.register("cypress_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CYPRESS));
    public static final DeferredBlock<Block> CYPRESS_HANGING_SIGN = BLOCKS.register("cypress_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CYPRESS));
    public static final DeferredBlock<Block> CYPRESS_WALL_HANGING_SIGN = BLOCKS.register("cypress_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CYPRESS));

    public static final DeferredBlock<Block> DATE_PALM_BEAM = registerBlock("date_palm_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> DATE_PALM_BEAM_SLAB = registerBlock("date_palm_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> DATE_PALM_BEAM_STAIRS = registerBlock("date_palm_beam_stairs",
            () -> new ModStrippedStairs(DATE_PALM_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> DATE_PALM_BEAM_VERTICAL_SLAB = registerBlock("date_palm_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_LOG = registerBlock("stripped_date_palm_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_LOG_SLAB = registerBlock("stripped_date_palm_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_LOG_STAIRS = registerBlock("stripped_date_palm_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_DATE_PALM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB = registerBlock("stripped_date_palm_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_WOOD = registerBlock("stripped_date_palm_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_WOOD_SLAB = registerBlock("stripped_date_palm_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_WOOD_STAIRS = registerBlock("stripped_date_palm_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_DATE_PALM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB = registerBlock("stripped_date_palm_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> DATE_PALM_LOG = registerBlock("date_palm_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_LOG));
    public static final DeferredBlock<Block> DATE_PALM_LOG_SLAB = registerBlock("date_palm_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_LOG_SLAB));
    public static final DeferredBlock<Block> DATE_PALM_LOG_STAIRS = registerBlock("date_palm_log_stairs",
            () -> new ModStairs(DATE_PALM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_LOG_STAIRS));
    public static final DeferredBlock<Block> DATE_PALM_LOG_VERTICAL_SLAB = registerBlock("date_palm_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> DATE_PALM_WOOD = registerBlock("date_palm_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_WOOD));
    public static final DeferredBlock<Block> DATE_PALM_WOOD_SLAB = registerBlock("date_palm_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_WOOD_SLAB));
    public static final DeferredBlock<Block> DATE_PALM_WOOD_STAIRS = registerBlock("date_palm_wood_stairs",
            () -> new ModStairs(DATE_PALM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_DATE_PALM_WOOD_STAIRS));
    public static final DeferredBlock<Block> DATE_PALM_WOOD_VERTICAL_SLAB = registerBlock("date_palm_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB));
    public static final DeferredBlock<Block> DATE_PALM_PLANKS = registerBlock("date_palm_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> DATE_PALM_PLANKS_VERTICAL_SLAB = registerBlock("date_palm_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(DATE_PALM_PLANKS.get())));

    public static final DeferredBlock<Block> DATE_PALM_PLANKS_STAIRS = registerBlock("date_palm_planks_stairs",
            () -> new ModStrippedStairs(DATE_PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(DATE_PALM_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> DATE_PALM_PLANKS_SLAB = registerBlock("date_palm_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(DATE_PALM_PLANKS.get())));
    public static final DeferredBlock<Block> DATE_PALM_FENCE = registerBlock("date_palm_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> DATE_PALM_FENCE_GATE = registerBlock("date_palm_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.DATE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> DATE_PALM_DOOR = registerBlock("date_palm_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> DATE_PALM_TRAPDOOR = registerBlock("date_palm_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> DATE_PALM_PRESSURE_PLATE = registerBlock("date_palm_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> DATE_PALM_BUTTON = registerBlock("date_palm_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> DATE_PALM_LEAVES = registerBlock("date_palm_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> DATE_PALM_SAPLING = registerBlock("date_palm_sapling",
            () -> new SaplingBlock(ModTreeGrowers.DATE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> DATE_PALM_SIGN = BLOCKS.register("date_palm_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.DATE_PALM));
    public static final DeferredBlock<Block> DATE_PALM_WALL_SIGN = BLOCKS.register("date_palm_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.DATE_PALM));
    public static final DeferredBlock<Block> DATE_PALM_HANGING_SIGN = BLOCKS.register("date_palm_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.DATE_PALM));
    public static final DeferredBlock<Block> DATE_PALM_WALL_HANGING_SIGN = BLOCKS.register("date_palm_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.DATE_PALM));

    public static final DeferredBlock<Block> FIR_BEAM = registerBlock("fir_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> FIR_BEAM_SLAB = registerBlock("fir_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> FIR_BEAM_STAIRS = registerBlock("fir_beam_stairs",
            () -> new ModStrippedStairs(FIR_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> FIR_BEAM_VERTICAL_SLAB = registerBlock("fir_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_FIR_LOG = registerBlock("stripped_fir_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_LOG_SLAB = registerBlock("stripped_fir_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_LOG_STAIRS = registerBlock("stripped_fir_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_FIR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_LOG_VERTICAL_SLAB = registerBlock("stripped_fir_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_FIR_WOOD = registerBlock("stripped_fir_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_WOOD_SLAB = registerBlock("stripped_fir_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_WOOD_STAIRS = registerBlock("stripped_fir_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_FIR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FIR_WOOD_VERTICAL_SLAB = registerBlock("stripped_fir_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> FIR_LOG = registerBlock("fir_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_LOG));
    public static final DeferredBlock<Block> FIR_LOG_SLAB = registerBlock("fir_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_LOG_SLAB));
    public static final DeferredBlock<Block> FIR_LOG_STAIRS = registerBlock("fir_log_stairs",
            () -> new ModStairs(FIR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_LOG_STAIRS));
    public static final DeferredBlock<Block> FIR_LOG_VERTICAL_SLAB = registerBlock("fir_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_FIR_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> FIR_WOOD = registerBlock("fir_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_WOOD));
    public static final DeferredBlock<Block> FIR_WOOD_SLAB = registerBlock("fir_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_WOOD_SLAB));
    public static final DeferredBlock<Block> FIR_WOOD_STAIRS = registerBlock("fir_wood_stairs",
            () -> new ModStairs(FIR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_FIR_WOOD_STAIRS));
    public static final DeferredBlock<Block> FIR_WOOD_VERTICAL_SLAB = registerBlock("fir_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_FIR_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> FIR_PLANKS = registerBlock("fir_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FIR_PLANKS_VERTICAL_SLAB = registerBlock("fir_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(FIR_PLANKS.get())));

    public static final DeferredBlock<Block> FIR_PLANKS_STAIRS = registerBlock("fir_planks_stairs",
            () -> new ModStrippedStairs(FIR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(FIR_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> FIR_PLANKS_SLAB = registerBlock("fir_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(FIR_PLANKS.get())));
    public static final DeferredBlock<Block> FIR_FENCE = registerBlock("fir_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> FIR_FENCE_GATE = registerBlock("fir_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.FIR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> FIR_DOOR = registerBlock("fir_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> FIR_TRAPDOOR = registerBlock("fir_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> FIR_PRESSURE_PLATE = registerBlock("fir_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> FIR_BUTTON = registerBlock("fir_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> FIR_LEAVES = registerBlock("fir_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> FIR_SAPLING = registerBlock("fir_sapling",
            () -> new SaplingBlock(ModTreeGrowers.FIR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> FIR_SIGN = BLOCKS.register("fir_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.FIR));
    public static final DeferredBlock<Block> FIR_WALL_SIGN = BLOCKS.register("fir_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.FIR));
    public static final DeferredBlock<Block> FIR_HANGING_SIGN = BLOCKS.register("fir_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.FIR));
    public static final DeferredBlock<Block> FIR_WALL_HANGING_SIGN = BLOCKS.register("fir_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.FIR));

    public static final DeferredBlock<Block> GREEN_OAK_BEAM = registerBlock("green_oak_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> GREEN_OAK_BEAM_SLAB = registerBlock("green_oak_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> GREEN_OAK_BEAM_STAIRS = registerBlock("green_oak_beam_stairs",
            () -> new ModStrippedStairs(GREEN_OAK_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> GREEN_OAK_BEAM_VERTICAL_SLAB = registerBlock("green_oak_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_LOG = registerBlock("stripped_green_oak_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_LOG_SLAB = registerBlock("stripped_green_oak_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_LOG_STAIRS = registerBlock("stripped_green_oak_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_GREEN_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB = registerBlock("stripped_green_oak_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_WOOD = registerBlock("stripped_green_oak_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_WOOD_SLAB = registerBlock("stripped_green_oak_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_WOOD_STAIRS = registerBlock("stripped_green_oak_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_GREEN_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB = registerBlock("stripped_green_oak_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> GREEN_OAK_LOG = registerBlock("green_oak_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_LOG));
    public static final DeferredBlock<Block> GREEN_OAK_LOG_SLAB = registerBlock("green_oak_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_LOG_SLAB));
    public static final DeferredBlock<Block> GREEN_OAK_LOG_STAIRS = registerBlock("green_oak_log_stairs",
            () -> new ModStairs(GREEN_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_LOG_STAIRS));
    public static final DeferredBlock<Block> GREEN_OAK_LOG_VERTICAL_SLAB = registerBlock("green_oak_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> GREEN_OAK_WOOD = registerBlock("green_oak_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_WOOD));
    public static final DeferredBlock<Block> GREEN_OAK_WOOD_SLAB = registerBlock("green_oak_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_WOOD_SLAB));
    public static final DeferredBlock<Block> GREEN_OAK_WOOD_STAIRS = registerBlock("green_oak_wood_stairs",
            () -> new ModStairs(GREEN_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_GREEN_OAK_WOOD_STAIRS));
    public static final DeferredBlock<Block> GREEN_OAK_WOOD_VERTICAL_SLAB = registerBlock("green_oak_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB));
    public static final DeferredBlock<Block> GREEN_OAK_PLANKS = registerBlock("green_oak_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> GREEN_OAK_PLANKS_VERTICAL_SLAB = registerBlock("green_oak_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(GREEN_OAK_PLANKS.get())));

    public static final DeferredBlock<Block> GREEN_OAK_PLANKS_STAIRS = registerBlock("green_oak_planks_stairs",
            () -> new ModStrippedStairs(GREEN_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(GREEN_OAK_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> GREEN_OAK_PLANKS_SLAB = registerBlock("green_oak_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(GREEN_OAK_PLANKS.get())));
    public static final DeferredBlock<Block> GREEN_OAK_FENCE = registerBlock("green_oak_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> GREEN_OAK_FENCE_GATE = registerBlock("green_oak_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.GREEN_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> GREEN_OAK_DOOR = registerBlock("green_oak_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> GREEN_OAK_TRAPDOOR = registerBlock("green_oak_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> GREEN_OAK_PRESSURE_PLATE = registerBlock("green_oak_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> GREEN_OAK_BUTTON = registerBlock("green_oak_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> GREEN_OAK_LEAVES = registerBlock("green_oak_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> GREEN_OAK_SAPLING = registerBlock("green_oak_sapling",
            () -> new SaplingBlock(ModTreeGrowers.GREEN_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> GREEN_OAK_SIGN = BLOCKS.register("green_oak_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.GREEN_OAK));
    public static final DeferredBlock<Block> GREEN_OAK_WALL_SIGN = BLOCKS.register("green_oak_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.GREEN_OAK));
    public static final DeferredBlock<Block> GREEN_OAK_HANGING_SIGN = BLOCKS.register("green_oak_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.GREEN_OAK));
    public static final DeferredBlock<Block> GREEN_OAK_WALL_HANGING_SIGN = BLOCKS.register("green_oak_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.GREEN_OAK));

    public static final DeferredBlock<Block> HOLLY_BEAM = registerBlock("holly_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> HOLLY_BEAM_SLAB = registerBlock("holly_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> HOLLY_BEAM_STAIRS = registerBlock("holly_beam_stairs",
            () -> new ModStrippedStairs(HOLLY_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> HOLLY_BEAM_VERTICAL_SLAB = registerBlock("holly_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_HOLLY_LOG = registerBlock("stripped_holly_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_LOG_SLAB = registerBlock("stripped_holly_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_LOG_STAIRS = registerBlock("stripped_holly_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_HOLLY_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_LOG_VERTICAL_SLAB = registerBlock("stripped_holly_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_HOLLY_WOOD = registerBlock("stripped_holly_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_WOOD_SLAB = registerBlock("stripped_holly_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_WOOD_STAIRS = registerBlock("stripped_holly_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_HOLLY_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HOLLY_WOOD_VERTICAL_SLAB = registerBlock("stripped_holly_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> HOLLY_LOG = registerBlock("holly_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_LOG));
    public static final DeferredBlock<Block> HOLLY_LOG_SLAB = registerBlock("holly_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_LOG_SLAB));
    public static final DeferredBlock<Block> HOLLY_LOG_STAIRS = registerBlock("holly_log_stairs",
            () -> new ModStairs(HOLLY_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_LOG_STAIRS));
    public static final DeferredBlock<Block> HOLLY_LOG_VERTICAL_SLAB = registerBlock("holly_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_HOLLY_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> HOLLY_WOOD = registerBlock("holly_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_WOOD));
    public static final DeferredBlock<Block> HOLLY_WOOD_SLAB = registerBlock("holly_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_WOOD_SLAB));
    public static final DeferredBlock<Block> HOLLY_WOOD_STAIRS = registerBlock("holly_wood_stairs",
            () -> new ModStairs(HOLLY_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_HOLLY_WOOD_STAIRS));
    public static final DeferredBlock<Block> HOLLY_WOOD_VERTICAL_SLAB = registerBlock("holly_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_HOLLY_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> HOLLY_PLANKS = registerBlock("holly_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> HOLLY_PLANKS_VERTICAL_SLAB = registerBlock("holly_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(HOLLY_PLANKS.get())));

    public static final DeferredBlock<Block> HOLLY_PLANKS_STAIRS = registerBlock("holly_planks_stairs",
            () -> new ModStrippedStairs(HOLLY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(HOLLY_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> HOLLY_PLANKS_SLAB = registerBlock("holly_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(HOLLY_PLANKS.get())));
    public static final DeferredBlock<Block> HOLLY_FENCE = registerBlock("holly_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> HOLLY_FENCE_GATE = registerBlock("holly_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.HOLLY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> HOLLY_DOOR = registerBlock("holly_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> HOLLY_TRAPDOOR = registerBlock("holly_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> HOLLY_PRESSURE_PLATE = registerBlock("holly_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> HOLLY_BUTTON = registerBlock("holly_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> HOLLY_LEAVES = registerBlock("holly_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> HOLLY_SAPLING = registerBlock("holly_sapling",
            () -> new SaplingBlock(ModTreeGrowers.HOLLY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> HOLLY_SIGN = BLOCKS.register("holly_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.HOLLY));
    public static final DeferredBlock<Block> HOLLY_WALL_SIGN = BLOCKS.register("holly_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.HOLLY));
    public static final DeferredBlock<Block> HOLLY_HANGING_SIGN = BLOCKS.register("holly_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.HOLLY));
    public static final DeferredBlock<Block> HOLLY_WALL_HANGING_SIGN = BLOCKS.register("holly_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.HOLLY));

    public static final DeferredBlock<Block> KUNTZ_BEAM = registerBlock("kuntz_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> KUNTZ_BEAM_SLAB = registerBlock("kuntz_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> KUNTZ_BEAM_STAIRS = registerBlock("kuntz_beam_stairs",
            () -> new ModStrippedStairs(KUNTZ_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> KUNTZ_BEAM_VERTICAL_SLAB = registerBlock("kuntz_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_KUNTZ_LOG = registerBlock("stripped_kuntz_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_LOG_SLAB = registerBlock("stripped_kuntz_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_LOG_STAIRS = registerBlock("stripped_kuntz_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_KUNTZ_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_LOG_VERTICAL_SLAB = registerBlock("stripped_kuntz_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_KUNTZ_WOOD = registerBlock("stripped_kuntz_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_WOOD_SLAB = registerBlock("stripped_kuntz_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_WOOD_STAIRS = registerBlock("stripped_kuntz_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_KUNTZ_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB = registerBlock("stripped_kuntz_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> KUNTZ_LOG = registerBlock("kuntz_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_LOG));
    public static final DeferredBlock<Block> KUNTZ_LOG_SLAB = registerBlock("kuntz_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_LOG_SLAB));
    public static final DeferredBlock<Block> KUNTZ_LOG_STAIRS = registerBlock("kuntz_log_stairs",
            () -> new ModStairs(KUNTZ_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_LOG_STAIRS));
    public static final DeferredBlock<Block> KUNTZ_LOG_VERTICAL_SLAB = registerBlock("kuntz_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_KUNTZ_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> KUNTZ_WOOD = registerBlock("kuntz_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_WOOD));
    public static final DeferredBlock<Block> KUNTZ_WOOD_SLAB = registerBlock("kuntz_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_WOOD_SLAB));
    public static final DeferredBlock<Block> KUNTZ_WOOD_STAIRS = registerBlock("kuntz_wood_stairs",
            () -> new ModStairs(KUNTZ_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_KUNTZ_WOOD_STAIRS));
    public static final DeferredBlock<Block> KUNTZ_WOOD_VERTICAL_SLAB = registerBlock("kuntz_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> KUNTZ_PLANKS = registerBlock("kuntz_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> KUNTZ_PLANKS_VERTICAL_SLAB = registerBlock("kuntz_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(KUNTZ_PLANKS.get())));

    public static final DeferredBlock<Block> KUNTZ_PLANKS_STAIRS = registerBlock("kuntz_planks_stairs",
            () -> new ModStrippedStairs(KUNTZ_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(KUNTZ_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> KUNTZ_PLANKS_SLAB = registerBlock("kuntz_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(KUNTZ_PLANKS.get())));
    public static final DeferredBlock<Block> KUNTZ_FENCE = registerBlock("kuntz_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> KUNTZ_FENCE_GATE = registerBlock("kuntz_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.KUNTZ, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> KUNTZ_DOOR = registerBlock("kuntz_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> KUNTZ_TRAPDOOR = registerBlock("kuntz_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> KUNTZ_PRESSURE_PLATE = registerBlock("kuntz_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> KUNTZ_BUTTON = registerBlock("kuntz_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> KUNTZ_LEAVES = registerBlock("kuntz_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> KUNTZ_SAPLING = registerBlock("kuntz_sapling",
            () -> new SaplingBlock(ModTreeGrowers.KUNTZ, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> KUNTZ_SIGN = BLOCKS.register("kuntz_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.KUNTZ));
    public static final DeferredBlock<Block> KUNTZ_WALL_SIGN = BLOCKS.register("kuntz_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.KUNTZ));
    public static final DeferredBlock<Block> KUNTZ_HANGING_SIGN = BLOCKS.register("kuntz_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.KUNTZ));
    public static final DeferredBlock<Block> KUNTZ_WALL_HANGING_SIGN = BLOCKS.register("kuntz_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.KUNTZ));

    public static final DeferredBlock<Block> LAIRELOSSE_BEAM = registerBlock("lairelosse_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LAIRELOSSE_BEAM_SLAB = registerBlock("lairelosse_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LAIRELOSSE_BEAM_STAIRS = registerBlock("lairelosse_beam_stairs",
            () -> new ModStrippedStairs(LAIRELOSSE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LAIRELOSSE_BEAM_VERTICAL_SLAB = registerBlock("lairelosse_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_LOG = registerBlock("stripped_lairelosse_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_LOG_SLAB = registerBlock("stripped_lairelosse_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_LOG_STAIRS = registerBlock("stripped_lairelosse_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_LAIRELOSSE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB = registerBlock("stripped_lairelosse_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_WOOD = registerBlock("stripped_lairelosse_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_WOOD_SLAB = registerBlock("stripped_lairelosse_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_WOOD_STAIRS = registerBlock("stripped_lairelosse_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_LAIRELOSSE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB = registerBlock("stripped_lairelosse_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> LAIRELOSSE_LOG = registerBlock("lairelosse_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_LOG));
    public static final DeferredBlock<Block> LAIRELOSSE_LOG_SLAB = registerBlock("lairelosse_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_LOG_SLAB));
    public static final DeferredBlock<Block> LAIRELOSSE_LOG_STAIRS = registerBlock("lairelosse_log_stairs",
            () -> new ModStairs(LAIRELOSSE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_LOG_STAIRS));
    public static final DeferredBlock<Block> LAIRELOSSE_LOG_VERTICAL_SLAB = registerBlock("lairelosse_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LAIRELOSSE_WOOD = registerBlock("lairelosse_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_WOOD));
    public static final DeferredBlock<Block> LAIRELOSSE_WOOD_SLAB = registerBlock("lairelosse_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_WOOD_SLAB));
    public static final DeferredBlock<Block> LAIRELOSSE_WOOD_STAIRS = registerBlock("lairelosse_wood_stairs",
            () -> new ModStairs(LAIRELOSSE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LAIRELOSSE_WOOD_STAIRS));
    public static final DeferredBlock<Block> LAIRELOSSE_WOOD_VERTICAL_SLAB = registerBlock("lairelosse_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LAIRELOSSE_PLANKS = registerBlock("lairelosse_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LAIRELOSSE_PLANKS_VERTICAL_SLAB = registerBlock("lairelosse_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(LAIRELOSSE_PLANKS.get())));

    public static final DeferredBlock<Block> LAIRELOSSE_PLANKS_STAIRS = registerBlock("lairelosse_planks_stairs",
            () -> new ModStrippedStairs(LAIRELOSSE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(LAIRELOSSE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> LAIRELOSSE_PLANKS_SLAB = registerBlock("lairelosse_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(LAIRELOSSE_PLANKS.get())));
    public static final DeferredBlock<Block> LAIRELOSSE_FENCE = registerBlock("lairelosse_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> LAIRELOSSE_FENCE_GATE = registerBlock("lairelosse_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.LAIRELOSSE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> LAIRELOSSE_DOOR = registerBlock("lairelosse_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> LAIRELOSSE_TRAPDOOR = registerBlock("lairelosse_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> LAIRELOSSE_PRESSURE_PLATE = registerBlock("lairelosse_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> LAIRELOSSE_BUTTON = registerBlock("lairelosse_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> LAIRELOSSE_LEAVES = registerBlock("lairelosse_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LAIRELOSSE_SAPLING = registerBlock("lairelosse_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LAIRELOSSE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LAIRELOSSE_SIGN = BLOCKS.register("lairelosse_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.LAIRELOSSE));
    public static final DeferredBlock<Block> LAIRELOSSE_WALL_SIGN = BLOCKS.register("lairelosse_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LAIRELOSSE));
    public static final DeferredBlock<Block> LAIRELOSSE_HANGING_SIGN = BLOCKS.register("lairelosse_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.LAIRELOSSE));
    public static final DeferredBlock<Block> LAIRELOSSE_WALL_HANGING_SIGN = BLOCKS.register("lairelosse_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.LAIRELOSSE));

    public static final DeferredBlock<Block> LARCH_BEAM = registerBlock("larch_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LARCH_BEAM_SLAB = registerBlock("larch_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LARCH_BEAM_STAIRS = registerBlock("larch_beam_stairs",
            () -> new ModStrippedStairs(LARCH_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LARCH_BEAM_VERTICAL_SLAB = registerBlock("larch_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LARCH_LOG = registerBlock("stripped_larch_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_LOG_SLAB = registerBlock("stripped_larch_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_LOG_STAIRS = registerBlock("stripped_larch_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_LARCH_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_LOG_VERTICAL_SLAB = registerBlock("stripped_larch_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LARCH_WOOD = registerBlock("stripped_larch_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_WOOD_SLAB = registerBlock("stripped_larch_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_WOOD_STAIRS = registerBlock("stripped_larch_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_LARCH_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LARCH_WOOD_VERTICAL_SLAB = registerBlock("stripped_larch_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> LARCH_LOG = registerBlock("larch_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_LOG));
    public static final DeferredBlock<Block> LARCH_LOG_SLAB = registerBlock("larch_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_LOG_SLAB));
    public static final DeferredBlock<Block> LARCH_LOG_STAIRS = registerBlock("larch_log_stairs",
            () -> new ModStairs(LARCH_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_LOG_STAIRS));
    public static final DeferredBlock<Block> LARCH_LOG_VERTICAL_SLAB = registerBlock("larch_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LARCH_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LARCH_WOOD = registerBlock("larch_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_WOOD));
    public static final DeferredBlock<Block> LARCH_WOOD_SLAB = registerBlock("larch_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_WOOD_SLAB));
    public static final DeferredBlock<Block> LARCH_WOOD_STAIRS = registerBlock("larch_wood_stairs",
            () -> new ModStairs(LARCH_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LARCH_WOOD_STAIRS));
    public static final DeferredBlock<Block> LARCH_WOOD_VERTICAL_SLAB = registerBlock("larch_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LARCH_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LARCH_PLANKS = registerBlock("larch_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LARCH_PLANKS_VERTICAL_SLAB = registerBlock("larch_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(LARCH_PLANKS.get())));

    public static final DeferredBlock<Block> LARCH_PLANKS_STAIRS = registerBlock("larch_planks_stairs",
            () -> new ModStrippedStairs(LARCH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(LARCH_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> LARCH_PLANKS_SLAB = registerBlock("larch_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(LARCH_PLANKS.get())));
    public static final DeferredBlock<Block> LARCH_FENCE = registerBlock("larch_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> LARCH_FENCE_GATE = registerBlock("larch_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.LARCH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> LARCH_DOOR = registerBlock("larch_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> LARCH_TRAPDOOR = registerBlock("larch_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> LARCH_PRESSURE_PLATE = registerBlock("larch_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> LARCH_BUTTON = registerBlock("larch_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> LARCH_LEAVES = registerBlock("larch_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LARCH_SAPLING = registerBlock("larch_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LARCH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LARCH_SIGN = BLOCKS.register("larch_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.LARCH));
    public static final DeferredBlock<Block> LARCH_WALL_SIGN = BLOCKS.register("larch_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LARCH));
    public static final DeferredBlock<Block> LARCH_HANGING_SIGN = BLOCKS.register("larch_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.LARCH));
    public static final DeferredBlock<Block> LARCH_WALL_HANGING_SIGN = BLOCKS.register("larch_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.LARCH));
    public static final DeferredBlock<Block> LEBETHRON_BEAM = registerBlock("lebethron_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEBETHRON_BEAM_SLAB = registerBlock("lebethron_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEBETHRON_BEAM_STAIRS = registerBlock("lebethron_beam_stairs",
            () -> new ModStrippedStairs(LEBETHRON_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEBETHRON_BEAM_VERTICAL_SLAB = registerBlock("lebethron_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_LOG = registerBlock("stripped_lebethron_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_LOG_SLAB = registerBlock("stripped_lebethron_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_LOG_STAIRS = registerBlock("stripped_lebethron_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_LEBETHRON_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB = registerBlock("stripped_lebethron_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_WOOD = registerBlock("stripped_lebethron_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_WOOD_SLAB = registerBlock("stripped_lebethron_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_WOOD_STAIRS = registerBlock("stripped_lebethron_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_LEBETHRON_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB = registerBlock("stripped_lebethron_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> LEBETHRON_LOG = registerBlock("lebethron_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_LOG));
    public static final DeferredBlock<Block> LEBETHRON_LOG_SLAB = registerBlock("lebethron_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_LOG_SLAB));
    public static final DeferredBlock<Block> LEBETHRON_LOG_STAIRS = registerBlock("lebethron_log_stairs",
            () -> new ModStairs(LEBETHRON_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_LOG_STAIRS));
    public static final DeferredBlock<Block> LEBETHRON_LOG_VERTICAL_SLAB = registerBlock("lebethron_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LEBETHRON_WOOD = registerBlock("lebethron_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_WOOD));
    public static final DeferredBlock<Block> LEBETHRON_WOOD_SLAB = registerBlock("lebethron_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_WOOD_SLAB));
    public static final DeferredBlock<Block> LEBETHRON_WOOD_STAIRS = registerBlock("lebethron_wood_stairs",
            () -> new ModStairs(LEBETHRON_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEBETHRON_WOOD_STAIRS));
    public static final DeferredBlock<Block> LEBETHRON_WOOD_VERTICAL_SLAB = registerBlock("lebethron_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LEBETHRON_PLANKS = registerBlock("lebethron_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LEBETHRON_PLANKS_VERTICAL_SLAB = registerBlock("lebethron_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(LEBETHRON_PLANKS.get())));

    public static final DeferredBlock<Block> LEBETHRON_PLANKS_STAIRS = registerBlock("lebethron_planks_stairs",
            () -> new ModStrippedStairs(LEBETHRON_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(LEBETHRON_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> LEBETHRON_PLANKS_SLAB = registerBlock("lebethron_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(LEBETHRON_PLANKS.get())));
    public static final DeferredBlock<Block> LEBETHRON_FENCE = registerBlock("lebethron_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> LEBETHRON_FENCE_GATE = registerBlock("lebethron_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.LEBETHRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> LEBETHRON_DOOR = registerBlock("lebethron_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> LEBETHRON_TRAPDOOR = registerBlock("lebethron_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> LEBETHRON_PRESSURE_PLATE = registerBlock("lebethron_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> LEBETHRON_BUTTON = registerBlock("lebethron_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> LEBETHRON_LEAVES = registerBlock("lebethron_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> LEBETHRON_SAPLING = registerBlock("lebethron_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LEBETHRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LEBETHRON_SIGN = BLOCKS.register("lebethron_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.LEBETHRON));
    public static final DeferredBlock<Block> LEBETHRON_WALL_SIGN = BLOCKS.register("lebethron_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LEBETHRON));
    public static final DeferredBlock<Block> LEBETHRON_HANGING_SIGN = BLOCKS.register("lebethron_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.LEBETHRON));
    public static final DeferredBlock<Block> LEBETHRON_WALL_HANGING_SIGN = BLOCKS.register("lebethron_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.LEBETHRON));

    public static final DeferredBlock<Block> LEMON_BEAM = registerBlock("lemon_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEMON_BEAM_SLAB = registerBlock("lemon_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEMON_BEAM_STAIRS = registerBlock("lemon_beam_stairs",
            () -> new ModStrippedStairs(LEMON_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LEMON_BEAM_VERTICAL_SLAB = registerBlock("lemon_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_LOG_SLAB = registerBlock("stripped_lemon_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_LOG_STAIRS = registerBlock("stripped_lemon_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_LEMON_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_LOG_VERTICAL_SLAB = registerBlock("stripped_lemon_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_WOOD_SLAB = registerBlock("stripped_lemon_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_WOOD_STAIRS = registerBlock("stripped_lemon_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_LEMON_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LEMON_WOOD_VERTICAL_SLAB = registerBlock("stripped_lemon_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> LEMON_LOG = registerBlock("lemon_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_LOG));
    public static final DeferredBlock<Block> LEMON_LOG_SLAB = registerBlock("lemon_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_LOG_SLAB));
    public static final DeferredBlock<Block> LEMON_LOG_STAIRS = registerBlock("lemon_log_stairs",
            () -> new ModStairs(LEMON_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_LOG_STAIRS));
    public static final DeferredBlock<Block> LEMON_LOG_VERTICAL_SLAB = registerBlock("lemon_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LEMON_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LEMON_WOOD = registerBlock("lemon_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_WOOD));
    public static final DeferredBlock<Block> LEMON_WOOD_SLAB = registerBlock("lemon_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_WOOD_SLAB));
    public static final DeferredBlock<Block> LEMON_WOOD_STAIRS = registerBlock("lemon_wood_stairs",
            () -> new ModStairs(LEMON_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LEMON_WOOD_STAIRS));
    public static final DeferredBlock<Block> LEMON_WOOD_VERTICAL_SLAB = registerBlock("lemon_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LEMON_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LEMON_PLANKS = registerBlock("lemon_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LEMON_PLANKS_VERTICAL_SLAB = registerBlock("lemon_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(LEMON_PLANKS.get())));

    public static final DeferredBlock<Block> LEMON_PLANKS_STAIRS = registerBlock("lemon_planks_stairs",
            () -> new ModStrippedStairs(LEMON_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(LEMON_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> LEMON_PLANKS_SLAB = registerBlock("lemon_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(LEMON_PLANKS.get())));
    public static final DeferredBlock<Block> LEMON_FENCE = registerBlock("lemon_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> LEMON_FENCE_GATE = registerBlock("lemon_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.LEMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> LEMON_DOOR = registerBlock("lemon_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> LEMON_TRAPDOOR = registerBlock("lemon_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> LEMON_PRESSURE_PLATE = registerBlock("lemon_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> LEMON_BUTTON = registerBlock("lemon_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.LEMON));
    public static final DeferredBlock<Block> LEMON_SAPLING = registerBlock("lemon_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LEMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LEMON_SIGN = BLOCKS.register("lemon_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.LEMON));
    public static final DeferredBlock<Block> LEMON_WALL_SIGN = BLOCKS.register("lemon_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LEMON));
    public static final DeferredBlock<Block> LEMON_HANGING_SIGN = BLOCKS.register("lemon_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.LEMON));
    public static final DeferredBlock<Block> LEMON_WALL_HANGING_SIGN = BLOCKS.register("lemon_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.LEMON));

    public static final DeferredBlock<Block> LIME_BEAM = registerBlock("lime_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LIME_BEAM_SLAB = registerBlock("lime_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LIME_BEAM_STAIRS = registerBlock("lime_beam_stairs",
            () -> new ModStrippedStairs(LIME_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LIME_BEAM_VERTICAL_SLAB = registerBlock("lime_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LIME_LOG = registerBlock("stripped_lime_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_LOG_SLAB = registerBlock("stripped_lime_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_LOG_STAIRS = registerBlock("stripped_lime_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_LIME_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_LOG_VERTICAL_SLAB = registerBlock("stripped_lime_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LIME_WOOD = registerBlock("stripped_lime_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_WOOD_SLAB = registerBlock("stripped_lime_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_WOOD_STAIRS = registerBlock("stripped_lime_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_LIME_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIME_WOOD_VERTICAL_SLAB = registerBlock("stripped_lime_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> LIME_LOG = registerBlock("lime_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_LOG));
    public static final DeferredBlock<Block> LIME_LOG_SLAB = registerBlock("lime_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_LOG_SLAB));
    public static final DeferredBlock<Block> LIME_LOG_STAIRS = registerBlock("lime_log_stairs",
            () -> new ModStairs(LIME_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_LOG_STAIRS));
    public static final DeferredBlock<Block> LIME_LOG_VERTICAL_SLAB = registerBlock("lime_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LIME_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LIME_WOOD = registerBlock("lime_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_WOOD));
    public static final DeferredBlock<Block> LIME_WOOD_SLAB = registerBlock("lime_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_WOOD_SLAB));
    public static final DeferredBlock<Block> LIME_WOOD_STAIRS = registerBlock("lime_wood_stairs",
            () -> new ModStairs(LIME_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_LIME_WOOD_STAIRS));
    public static final DeferredBlock<Block> LIME_WOOD_VERTICAL_SLAB = registerBlock("lime_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_LIME_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> LIME_PLANKS = registerBlock("lime_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LIME_PLANKS_VERTICAL_SLAB = registerBlock("lime_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(LIME_PLANKS.get())));

    public static final DeferredBlock<Block> LIME_PLANKS_STAIRS = registerBlock("lime_planks_stairs",
            () -> new ModStrippedStairs(LIME_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(LIME_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> LIME_PLANKS_SLAB = registerBlock("lime_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(LIME_PLANKS.get())));
    public static final DeferredBlock<Block> LIME_FENCE = registerBlock("lime_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> LIME_FENCE_GATE = registerBlock("lime_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> LIME_DOOR = registerBlock("lime_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> LIME_TRAPDOOR = registerBlock("lime_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> LIME_PRESSURE_PLATE = registerBlock("lime_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> LIME_BUTTON = registerBlock("lime_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> LIME_LEAVES = registerBlock("lime_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.LIME));
    public static final DeferredBlock<Block> LIME_SAPLING = registerBlock("lime_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LIME_SIGN = BLOCKS.register("lime_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.LIME));
    public static final DeferredBlock<Block> LIME_WALL_SIGN = BLOCKS.register("lime_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.LIME));
    public static final DeferredBlock<Block> LIME_HANGING_SIGN = BLOCKS.register("lime_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.LIME));
    public static final DeferredBlock<Block> LIME_WALL_HANGING_SIGN = BLOCKS.register("lime_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.LIME));

    public static final DeferredBlock<Block> RED_MAHOGANY_BEAM = registerBlock("red_mahogany_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_MAHOGANY_BEAM_SLAB = registerBlock("red_mahogany_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_MAHOGANY_BEAM_STAIRS = registerBlock("red_mahogany_beam_stairs",
            () -> new ModStrippedStairs(RED_MAHOGANY_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_MAHOGANY_BEAM_VERTICAL_SLAB = registerBlock("red_mahogany_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_LOG = registerBlock("stripped_red_mahogany_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_LOG_SLAB = registerBlock("stripped_red_mahogany_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_LOG_STAIRS = registerBlock("stripped_red_mahogany_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_RED_MAHOGANY_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB = registerBlock("stripped_red_mahogany_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_WOOD = registerBlock("stripped_red_mahogany_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_WOOD_SLAB = registerBlock("stripped_red_mahogany_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_WOOD_STAIRS = registerBlock("stripped_red_mahogany_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_RED_MAHOGANY_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB = registerBlock("stripped_red_mahogany_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> RED_MAHOGANY_LOG = registerBlock("red_mahogany_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_LOG));
    public static final DeferredBlock<Block> RED_MAHOGANY_LOG_SLAB = registerBlock("red_mahogany_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_LOG_SLAB));
    public static final DeferredBlock<Block> RED_MAHOGANY_LOG_STAIRS = registerBlock("red_mahogany_log_stairs",
            () -> new ModStairs(RED_MAHOGANY_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_LOG_STAIRS));
    public static final DeferredBlock<Block> RED_MAHOGANY_LOG_VERTICAL_SLAB = registerBlock("red_mahogany_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> RED_MAHOGANY_WOOD = registerBlock("red_mahogany_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_WOOD));
    public static final DeferredBlock<Block> RED_MAHOGANY_WOOD_SLAB = registerBlock("red_mahogany_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_WOOD_SLAB));
    public static final DeferredBlock<Block> RED_MAHOGANY_WOOD_STAIRS = registerBlock("red_mahogany_wood_stairs",
            () -> new ModStairs(RED_MAHOGANY_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_MAHOGANY_WOOD_STAIRS));
    public static final DeferredBlock<Block> RED_MAHOGANY_WOOD_VERTICAL_SLAB = registerBlock("red_mahogany_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> RED_MAHOGANY_PLANKS = registerBlock("red_mahogany_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> RED_MAHOGANY_PLANKS_VERTICAL_SLAB = registerBlock("red_mahogany_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(RED_MAHOGANY_PLANKS.get())));

    public static final DeferredBlock<Block> RED_MAHOGANY_PLANKS_STAIRS = registerBlock("red_mahogany_planks_stairs",
            () -> new ModStrippedStairs(RED_MAHOGANY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(RED_MAHOGANY_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> RED_MAHOGANY_PLANKS_SLAB = registerBlock("red_mahogany_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(RED_MAHOGANY_PLANKS.get())));
    public static final DeferredBlock<Block> RED_MAHOGANY_FENCE = registerBlock("red_mahogany_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> RED_MAHOGANY_FENCE_GATE = registerBlock("red_mahogany_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.RED_MAHOGANY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> RED_MAHOGANY_DOOR = registerBlock("red_mahogany_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> RED_MAHOGANY_TRAPDOOR = registerBlock("red_mahogany_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> RED_MAHOGANY_PRESSURE_PLATE = registerBlock("red_mahogany_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> RED_MAHOGANY_BUTTON = registerBlock("red_mahogany_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> RED_MAHOGANY_LEAVES = registerBlock("red_mahogany_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> RED_MAHOGANY_SAPLING = registerBlock("red_mahogany_sapling",
            () -> new SaplingBlock(ModTreeGrowers.RED_MAHOGANY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> RED_MAHOGANY_SIGN = BLOCKS.register("red_mahogany_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.RED_MAHOGANY));
    public static final DeferredBlock<Block> RED_MAHOGANY_WALL_SIGN = BLOCKS.register("red_mahogany_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.RED_MAHOGANY));
    public static final DeferredBlock<Block> RED_MAHOGANY_HANGING_SIGN = BLOCKS.register("red_mahogany_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.RED_MAHOGANY));
    public static final DeferredBlock<Block> RED_MAHOGANY_WALL_HANGING_SIGN = BLOCKS.register("red_mahogany_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.RED_MAHOGANY));

    public static final DeferredBlock<Block> MALLORN_BEAM = registerBlock("mallorn_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MALLORN_BEAM_SLAB = registerBlock("mallorn_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MALLORN_BEAM_STAIRS = registerBlock("mallorn_beam_stairs",
            () -> new ModStrippedStairs(MALLORN_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MALLORN_BEAM_VERTICAL_SLAB = registerBlock("mallorn_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MALLORN_LOG = registerBlock("stripped_mallorn_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_LOG_SLAB = registerBlock("stripped_mallorn_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_LOG_STAIRS = registerBlock("stripped_mallorn_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_MALLORN_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_LOG_VERTICAL_SLAB = registerBlock("stripped_mallorn_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MALLORN_WOOD = registerBlock("stripped_mallorn_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_WOOD_SLAB = registerBlock("stripped_mallorn_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_WOOD_STAIRS = registerBlock("stripped_mallorn_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_MALLORN_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MALLORN_WOOD_VERTICAL_SLAB = registerBlock("stripped_mallorn_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> MALLORN_LOG = registerBlock("mallorn_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_LOG));
    public static final DeferredBlock<Block> MALLORN_LOG_SLAB = registerBlock("mallorn_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_LOG_SLAB));
    public static final DeferredBlock<Block> MALLORN_LOG_STAIRS = registerBlock("mallorn_log_stairs",
            () -> new ModStairs(MALLORN_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_LOG_STAIRS));
    public static final DeferredBlock<Block> MALLORN_LOG_VERTICAL_SLAB = registerBlock("mallorn_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MALLORN_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MALLORN_WOOD = registerBlock("mallorn_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_WOOD));
    public static final DeferredBlock<Block> MALLORN_WOOD_SLAB = registerBlock("mallorn_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_WOOD_SLAB));
    public static final DeferredBlock<Block> MALLORN_WOOD_STAIRS = registerBlock("mallorn_wood_stairs",
            () -> new ModStairs(MALLORN_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MALLORN_WOOD_STAIRS));
    public static final DeferredBlock<Block> MALLORN_WOOD_VERTICAL_SLAB = registerBlock("mallorn_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MALLORN_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MALLORN_PLANKS = registerBlock("mallorn_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MALLORN_PLANKS_VERTICAL_SLAB = registerBlock("mallorn_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(MALLORN_PLANKS.get())));

    public static final DeferredBlock<Block> MALLORN_PLANKS_STAIRS = registerBlock("mallorn_planks_stairs",
            () -> new ModStrippedStairs(MALLORN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MALLORN_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> MALLORN_PLANKS_SLAB = registerBlock("mallorn_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(MALLORN_PLANKS.get())));
    public static final DeferredBlock<Block> MALLORN_FENCE = registerBlock("mallorn_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> MALLORN_FENCE_GATE = registerBlock("mallorn_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.MALLORN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> MALLORN_DOOR = registerBlock("mallorn_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> MALLORN_TRAPDOOR = registerBlock("mallorn_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> MALLORN_PRESSURE_PLATE = registerBlock("mallorn_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> MALLORN_BUTTON = registerBlock("mallorn_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> MALLORN_LEAVES = registerBlock("mallorn_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MALLORN_SAPLING = registerBlock("mallorn_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MALLORN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> MALLORN_SIGN = BLOCKS.register("mallorn_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.MALLORN));
    public static final DeferredBlock<Block> MALLORN_WALL_SIGN = BLOCKS.register("mallorn_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MALLORN));
    public static final DeferredBlock<Block> MALLORN_HANGING_SIGN = BLOCKS.register("mallorn_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MALLORN));
    public static final DeferredBlock<Block> MALLORN_WALL_HANGING_SIGN = BLOCKS.register("mallorn_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MALLORN));

    public static final DeferredBlock<Block> MANGO_BEAM = registerBlock("mango_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MANGO_BEAM_SLAB = registerBlock("mango_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MANGO_BEAM_STAIRS = registerBlock("mango_beam_stairs",
            () -> new ModStrippedStairs(MANGO_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MANGO_BEAM_VERTICAL_SLAB = registerBlock("mango_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG_SLAB = registerBlock("stripped_mango_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG_STAIRS = registerBlock("stripped_mango_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_MANGO_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG_VERTICAL_SLAB = registerBlock("stripped_mango_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MANGO_WOOD = registerBlock("stripped_mango_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_WOOD_SLAB = registerBlock("stripped_mango_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_WOOD_STAIRS = registerBlock("stripped_mango_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_MANGO_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGO_WOOD_VERTICAL_SLAB = registerBlock("stripped_mango_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> MANGO_LOG = registerBlock("mango_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_LOG));
    public static final DeferredBlock<Block> MANGO_LOG_SLAB = registerBlock("mango_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_LOG_SLAB));
    public static final DeferredBlock<Block> MANGO_LOG_STAIRS = registerBlock("mango_log_stairs",
            () -> new ModStairs(MANGO_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_LOG_STAIRS));
    public static final DeferredBlock<Block> MANGO_LOG_VERTICAL_SLAB = registerBlock("mango_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MANGO_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MANGO_WOOD = registerBlock("mango_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_WOOD));
    public static final DeferredBlock<Block> MANGO_WOOD_SLAB = registerBlock("mango_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_WOOD_SLAB));
    public static final DeferredBlock<Block> MANGO_WOOD_STAIRS = registerBlock("mango_wood_stairs",
            () -> new ModStairs(MANGO_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MANGO_WOOD_STAIRS));
    public static final DeferredBlock<Block> MANGO_WOOD_VERTICAL_SLAB = registerBlock("mango_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MANGO_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MANGO_PLANKS = registerBlock("mango_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGO_PLANKS_VERTICAL_SLAB = registerBlock("mango_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));

    public static final DeferredBlock<Block> MANGO_PLANKS_STAIRS = registerBlock("mango_planks_stairs",
            () -> new ModStrippedStairs(MANGO_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> MANGO_PLANKS_SLAB = registerBlock("mango_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS.get())));
    public static final DeferredBlock<Block> MANGO_FENCE = registerBlock("mango_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.MANGO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> MANGO_DOOR = registerBlock("mango_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> MANGO_BUTTON = registerBlock("mango_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.MANGO));
    public static final DeferredBlock<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MANGO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> MANGO_SIGN = BLOCKS.register("mango_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.MANGO));
    public static final DeferredBlock<Block> MANGO_WALL_SIGN = BLOCKS.register("mango_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MANGO));
    public static final DeferredBlock<Block> MANGO_HANGING_SIGN = BLOCKS.register("mango_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MANGO));
    public static final DeferredBlock<Block> MANGO_WALL_HANGING_SIGN = BLOCKS.register("mango_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MANGO));

    public static final DeferredBlock<Block> MAPLE_BEAM = registerBlock("maple_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MAPLE_BEAM_SLAB = registerBlock("maple_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MAPLE_BEAM_STAIRS = registerBlock("maple_beam_stairs",
            () -> new ModStrippedStairs(MAPLE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MAPLE_BEAM_VERTICAL_SLAB = registerBlock("maple_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG_SLAB = registerBlock("stripped_maple_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG_STAIRS = registerBlock("stripped_maple_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_MAPLE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG_VERTICAL_SLAB = registerBlock("stripped_maple_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD_SLAB = registerBlock("stripped_maple_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD_STAIRS = registerBlock("stripped_maple_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_MAPLE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD_VERTICAL_SLAB = registerBlock("stripped_maple_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_LOG));
    public static final DeferredBlock<Block> MAPLE_LOG_SLAB = registerBlock("maple_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_LOG_SLAB));
    public static final DeferredBlock<Block> MAPLE_LOG_STAIRS = registerBlock("maple_log_stairs",
            () -> new ModStairs(MAPLE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_LOG_STAIRS));
    public static final DeferredBlock<Block> MAPLE_LOG_VERTICAL_SLAB = registerBlock("maple_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MAPLE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_WOOD));
    public static final DeferredBlock<Block> MAPLE_WOOD_SLAB = registerBlock("maple_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_WOOD_SLAB));
    public static final DeferredBlock<Block> MAPLE_WOOD_STAIRS = registerBlock("maple_wood_stairs",
            () -> new ModStairs(MAPLE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MAPLE_WOOD_STAIRS));
    public static final DeferredBlock<Block> MAPLE_WOOD_VERTICAL_SLAB = registerBlock("maple_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MAPLE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MAPLE_PLANKS_VERTICAL_SLAB = registerBlock("maple_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(MAPLE_PLANKS.get())));

    public static final DeferredBlock<Block> MAPLE_PLANKS_STAIRS = registerBlock("maple_planks_stairs",
            () -> new ModStrippedStairs(MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MAPLE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> MAPLE_PLANKS_SLAB = registerBlock("maple_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(MAPLE_PLANKS.get())));
    public static final DeferredBlock<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> MAPLE_SIGN = BLOCKS.register("maple_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.MAPLE));
    public static final DeferredBlock<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MAPLE));
    public static final DeferredBlock<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MAPLE));
    public static final DeferredBlock<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MAPLE));

    public static final DeferredBlock<Block> MIRK_OAK_BEAM = registerBlock("mirk_oak_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MIRK_OAK_BEAM_SLAB = registerBlock("mirk_oak_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MIRK_OAK_BEAM_STAIRS = registerBlock("mirk_oak_beam_stairs",
            () -> new ModStrippedStairs(MIRK_OAK_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MIRK_OAK_BEAM_VERTICAL_SLAB = registerBlock("mirk_oak_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_LOG = registerBlock("stripped_mirk_oak_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_LOG_SLAB = registerBlock("stripped_mirk_oak_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_LOG_STAIRS = registerBlock("stripped_mirk_oak_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_MIRK_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB = registerBlock("stripped_mirk_oak_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_WOOD = registerBlock("stripped_mirk_oak_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_WOOD_SLAB = registerBlock("stripped_mirk_oak_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_WOOD_STAIRS = registerBlock("stripped_mirk_oak_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_MIRK_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB = registerBlock("stripped_mirk_oak_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> MIRK_OAK_LOG = registerBlock("mirk_oak_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_LOG));
    public static final DeferredBlock<Block> MIRK_OAK_LOG_SLAB = registerBlock("mirk_oak_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_LOG_SLAB));
    public static final DeferredBlock<Block> MIRK_OAK_LOG_STAIRS = registerBlock("mirk_oak_log_stairs",
            () -> new ModStairs(MIRK_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_LOG_STAIRS));
    public static final DeferredBlock<Block> MIRK_OAK_LOG_VERTICAL_SLAB = registerBlock("mirk_oak_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MIRK_OAK_WOOD = registerBlock("mirk_oak_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_WOOD));
    public static final DeferredBlock<Block> MIRK_OAK_WOOD_SLAB = registerBlock("mirk_oak_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_WOOD_SLAB));
    public static final DeferredBlock<Block> MIRK_OAK_WOOD_STAIRS = registerBlock("mirk_oak_wood_stairs",
            () -> new ModStairs(MIRK_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_MIRK_OAK_WOOD_STAIRS));
    public static final DeferredBlock<Block> MIRK_OAK_WOOD_VERTICAL_SLAB = registerBlock("mirk_oak_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MIRK_OAK_PLANKS = registerBlock("mirk_oak_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MIRK_OAK_PLANKS_VERTICAL_SLAB = registerBlock("mirk_oak_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(MIRK_OAK_PLANKS.get())));

    public static final DeferredBlock<Block> MIRK_OAK_PLANKS_STAIRS = registerBlock("mirk_oak_planks_stairs",
            () -> new ModStrippedStairs(MIRK_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MIRK_OAK_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> MIRK_OAK_PLANKS_SLAB = registerBlock("mirk_oak_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(MIRK_OAK_PLANKS.get())));
    public static final DeferredBlock<Block> MIRK_OAK_FENCE = registerBlock("mirk_oak_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> MIRK_OAK_FENCE_GATE = registerBlock("mirk_oak_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.MIRK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> MIRK_OAK_DOOR = registerBlock("mirk_oak_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> MIRK_OAK_TRAPDOOR = registerBlock("mirk_oak_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> MIRK_OAK_PRESSURE_PLATE = registerBlock("mirk_oak_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> MIRK_OAK_BUTTON = registerBlock("mirk_oak_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> MIRK_OAK_LEAVES = registerBlock("mirk_oak_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MIRK_OAK_SAPLING = registerBlock("mirk_oak_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MIRK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> MIRK_OAK_SIGN = BLOCKS.register("mirk_oak_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.MIRK_OAK));
    public static final DeferredBlock<Block> MIRK_OAK_WALL_SIGN = BLOCKS.register("mirk_oak_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MIRK_OAK));
    public static final DeferredBlock<Block> MIRK_OAK_HANGING_SIGN = BLOCKS.register("mirk_oak_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MIRK_OAK));
    public static final DeferredBlock<Block> MIRK_OAK_WALL_HANGING_SIGN = BLOCKS.register("mirk_oak_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MIRK_OAK));

    public static final DeferredBlock<Block> OLIVE_BEAM = registerBlock("olive_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> OLIVE_BEAM_SLAB = registerBlock("olive_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> OLIVE_BEAM_STAIRS = registerBlock("olive_beam_stairs",
            () -> new ModStrippedStairs(OLIVE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> OLIVE_BEAM_VERTICAL_SLAB = registerBlock("olive_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_LOG_SLAB = registerBlock("stripped_olive_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_LOG_STAIRS = registerBlock("stripped_olive_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_OLIVE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_LOG_VERTICAL_SLAB = registerBlock("stripped_olive_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_WOOD_SLAB = registerBlock("stripped_olive_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_WOOD_STAIRS = registerBlock("stripped_olive_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_OLIVE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OLIVE_WOOD_VERTICAL_SLAB = registerBlock("stripped_olive_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> OLIVE_LOG = registerBlock("olive_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_LOG));
    public static final DeferredBlock<Block> OLIVE_LOG_SLAB = registerBlock("olive_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_LOG_SLAB));
    public static final DeferredBlock<Block> OLIVE_LOG_STAIRS = registerBlock("olive_log_stairs",
            () -> new ModStairs(OLIVE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_LOG_STAIRS));
    public static final DeferredBlock<Block> OLIVE_LOG_VERTICAL_SLAB = registerBlock("olive_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_OLIVE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> OLIVE_WOOD = registerBlock("olive_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_WOOD));
    public static final DeferredBlock<Block> OLIVE_WOOD_SLAB = registerBlock("olive_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_WOOD_SLAB));
    public static final DeferredBlock<Block> OLIVE_WOOD_STAIRS = registerBlock("olive_wood_stairs",
            () -> new ModStairs(OLIVE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OLIVE_WOOD_STAIRS));
    public static final DeferredBlock<Block> OLIVE_WOOD_VERTICAL_SLAB = registerBlock("olive_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_OLIVE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> OLIVE_PLANKS = registerBlock("olive_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OLIVE_PLANKS_VERTICAL_SLAB = registerBlock("olive_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(OLIVE_PLANKS.get())));

    public static final DeferredBlock<Block> OLIVE_PLANKS_STAIRS = registerBlock("olive_planks_stairs",
            () -> new ModStrippedStairs(OLIVE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(OLIVE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> OLIVE_PLANKS_SLAB = registerBlock("olive_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(OLIVE_PLANKS.get())));
    public static final DeferredBlock<Block> OLIVE_FENCE = registerBlock("olive_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.OLIVE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> OLIVE_DOOR = registerBlock("olive_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> OLIVE_BUTTON = registerBlock("olive_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> OLIVE_LEAVES = registerBlock("olive_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.OLIVE));
    public static final DeferredBlock<Block> OLIVE_SAPLING = registerBlock("olive_sapling",
            () -> new SaplingBlock(ModTreeGrowers.OLIVE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> OLIVE_SIGN = BLOCKS.register("olive_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.OLIVE));
    public static final DeferredBlock<Block> OLIVE_WALL_SIGN = BLOCKS.register("olive_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.OLIVE));
    public static final DeferredBlock<Block> OLIVE_HANGING_SIGN = BLOCKS.register("olive_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.OLIVE));
    public static final DeferredBlock<Block> OLIVE_WALL_HANGING_SIGN = BLOCKS.register("olive_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.OLIVE));

    public static final DeferredBlock<Block> ORANGE_BEAM = registerBlock("orange_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ORANGE_BEAM_SLAB = registerBlock("orange_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ORANGE_BEAM_STAIRS = registerBlock("orange_beam_stairs",
            () -> new ModStrippedStairs(ORANGE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> ORANGE_BEAM_VERTICAL_SLAB = registerBlock("orange_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG_SLAB = registerBlock("stripped_orange_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG_STAIRS = registerBlock("stripped_orange_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_ORANGE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG_VERTICAL_SLAB = registerBlock("stripped_orange_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD_SLAB = registerBlock("stripped_orange_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD_STAIRS = registerBlock("stripped_orange_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_ORANGE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD_VERTICAL_SLAB = registerBlock("stripped_orange_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> ORANGE_LOG = registerBlock("orange_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_LOG));
    public static final DeferredBlock<Block> ORANGE_LOG_SLAB = registerBlock("orange_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_LOG_SLAB));
    public static final DeferredBlock<Block> ORANGE_LOG_STAIRS = registerBlock("orange_log_stairs",
            () -> new ModStairs(ORANGE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_LOG_STAIRS));
    public static final DeferredBlock<Block> ORANGE_LOG_VERTICAL_SLAB = registerBlock("orange_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_ORANGE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ORANGE_WOOD = registerBlock("orange_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_WOOD));
    public static final DeferredBlock<Block> ORANGE_WOOD_SLAB = registerBlock("orange_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_WOOD_SLAB));
    public static final DeferredBlock<Block> ORANGE_WOOD_STAIRS = registerBlock("orange_wood_stairs",
            () -> new ModStairs(ORANGE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_ORANGE_WOOD_STAIRS));
    public static final DeferredBlock<Block> ORANGE_WOOD_VERTICAL_SLAB = registerBlock("orange_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_ORANGE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ORANGE_PLANKS = registerBlock("orange_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ORANGE_PLANKS_VERTICAL_SLAB = registerBlock("orange_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));

    public static final DeferredBlock<Block> ORANGE_PLANKS_STAIRS = registerBlock("orange_planks_stairs",
            () -> new ModStrippedStairs(ORANGE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> ORANGE_PLANKS_SLAB = registerBlock("orange_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get())));
    public static final DeferredBlock<Block> ORANGE_FENCE = registerBlock("orange_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> ORANGE_FENCE_GATE = registerBlock("orange_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> ORANGE_DOOR = registerBlock("orange_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_TRAPDOOR = registerBlock("orange_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> ORANGE_PRESSURE_PLATE = registerBlock("orange_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> ORANGE_BUTTON = registerBlock("orange_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.ORANGE));
    public static final DeferredBlock<Block> ORANGE_SAPLING = registerBlock("orange_sapling",
            () -> new SaplingBlock(ModTreeGrowers.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ORANGE_SIGN = BLOCKS.register("orange_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.ORANGE));
    public static final DeferredBlock<Block> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ORANGE));
    public static final DeferredBlock<Block> ORANGE_HANGING_SIGN = BLOCKS.register("orange_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.ORANGE));
    public static final DeferredBlock<Block> ORANGE_WALL_HANGING_SIGN = BLOCKS.register("orange_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.ORANGE));

    public static final DeferredBlock<Block> PALM_BEAM = registerBlock("palm_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PALM_BEAM_SLAB = registerBlock("palm_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PALM_BEAM_STAIRS = registerBlock("palm_beam_stairs",
            () -> new ModStrippedStairs(PALM_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PALM_BEAM_VERTICAL_SLAB = registerBlock("palm_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG_SLAB = registerBlock("stripped_palm_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG_STAIRS = registerBlock("stripped_palm_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_PALM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG_VERTICAL_SLAB = registerBlock("stripped_palm_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD_SLAB = registerBlock("stripped_palm_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD_STAIRS = registerBlock("stripped_palm_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_PALM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD_VERTICAL_SLAB = registerBlock("stripped_palm_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_LOG));
    public static final DeferredBlock<Block> PALM_LOG_SLAB = registerBlock("palm_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_LOG_SLAB));
    public static final DeferredBlock<Block> PALM_LOG_STAIRS = registerBlock("palm_log_stairs",
            () -> new ModStairs(PALM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_LOG_STAIRS));
    public static final DeferredBlock<Block> PALM_LOG_VERTICAL_SLAB = registerBlock("palm_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PALM_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_WOOD));
    public static final DeferredBlock<Block> PALM_WOOD_SLAB = registerBlock("palm_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_WOOD_SLAB));
    public static final DeferredBlock<Block> PALM_WOOD_STAIRS = registerBlock("palm_wood_stairs",
            () -> new ModStairs(PALM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PALM_WOOD_STAIRS));
    public static final DeferredBlock<Block> PALM_WOOD_VERTICAL_SLAB = registerBlock("palm_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PALM_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PALM_PLANKS_VERTICAL_SLAB = registerBlock("palm_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));

    public static final DeferredBlock<Block> PALM_PLANKS_STAIRS = registerBlock("palm_planks_stairs",
            () -> new ModStrippedStairs(PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> PALM_PLANKS_SLAB = registerBlock("palm_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS.get())));
    public static final DeferredBlock<Block> PALM_FENCE = registerBlock("palm_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> PALM_BUTTON = registerBlock("palm_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PALM_SIGN = BLOCKS.register("palm_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.PALM));
    public static final DeferredBlock<Block> PALM_WALL_SIGN = BLOCKS.register("palm_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PALM));
    public static final DeferredBlock<Block> PALM_HANGING_SIGN = BLOCKS.register("palm_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PALM));
    public static final DeferredBlock<Block> PALM_WALL_HANGING_SIGN = BLOCKS.register("palm_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PALM));

    public static final DeferredBlock<Block> PEAR_BEAM = registerBlock("pear_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PEAR_BEAM_SLAB = registerBlock("pear_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PEAR_BEAM_STAIRS = registerBlock("pear_beam_stairs",
            () -> new ModStrippedStairs(PEAR_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PEAR_BEAM_VERTICAL_SLAB = registerBlock("pear_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG = registerBlock("stripped_pear_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG_SLAB = registerBlock("stripped_pear_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG_STAIRS = registerBlock("stripped_pear_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_PEAR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG_VERTICAL_SLAB = registerBlock("stripped_pear_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD = registerBlock("stripped_pear_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD_SLAB = registerBlock("stripped_pear_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD_STAIRS = registerBlock("stripped_pear_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_PEAR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD_VERTICAL_SLAB = registerBlock("stripped_pear_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PEAR_LOG = registerBlock("pear_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_LOG));
    public static final DeferredBlock<Block> PEAR_LOG_SLAB = registerBlock("pear_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_LOG_SLAB));
    public static final DeferredBlock<Block> PEAR_LOG_STAIRS = registerBlock("pear_log_stairs",
            () -> new ModStairs(PEAR_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_LOG_STAIRS));
    public static final DeferredBlock<Block> PEAR_LOG_VERTICAL_SLAB = registerBlock("pear_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PEAR_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PEAR_WOOD = registerBlock("pear_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_WOOD));
    public static final DeferredBlock<Block> PEAR_WOOD_SLAB = registerBlock("pear_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_WOOD_SLAB));
    public static final DeferredBlock<Block> PEAR_WOOD_STAIRS = registerBlock("pear_wood_stairs",
            () -> new ModStairs(PEAR_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PEAR_WOOD_STAIRS));
    public static final DeferredBlock<Block> PEAR_WOOD_VERTICAL_SLAB = registerBlock("pear_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PEAR_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PEAR_PLANKS = registerBlock("pear_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PEAR_PLANKS_VERTICAL_SLAB = registerBlock("pear_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));

    public static final DeferredBlock<Block> PEAR_PLANKS_STAIRS = registerBlock("pear_planks_stairs",
            () -> new ModStrippedStairs(PEAR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> PEAR_PLANKS_SLAB = registerBlock("pear_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get())));
    public static final DeferredBlock<Block> PEAR_FENCE = registerBlock("pear_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> PEAR_FENCE_GATE = registerBlock("pear_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> PEAR_DOOR = registerBlock("pear_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> PEAR_TRAPDOOR = registerBlock("pear_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> PEAR_PRESSURE_PLATE = registerBlock("pear_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> PEAR_BUTTON = registerBlock("pear_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.PEAR));
    public static final DeferredBlock<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PEAR_SIGN = BLOCKS.register("pear_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.PEAR));
    public static final DeferredBlock<Block> PEAR_WALL_SIGN = BLOCKS.register("pear_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PEAR));
    public static final DeferredBlock<Block> PEAR_HANGING_SIGN = BLOCKS.register("pear_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PEAR));
    public static final DeferredBlock<Block> PEAR_WALL_HANGING_SIGN = BLOCKS.register("pear_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PEAR));

    public static final DeferredBlock<Block> PINE_BEAM = registerBlock("pine_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PINE_BEAM_SLAB = registerBlock("pine_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PINE_BEAM_STAIRS = registerBlock("pine_beam_stairs",
            () -> new ModStrippedStairs(PINE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PINE_BEAM_VERTICAL_SLAB = registerBlock("pine_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG_SLAB = registerBlock("stripped_pine_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG_STAIRS = registerBlock("stripped_pine_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_PINE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG_VERTICAL_SLAB = registerBlock("stripped_pine_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD_SLAB = registerBlock("stripped_pine_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD_STAIRS = registerBlock("stripped_pine_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_PINE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD_VERTICAL_SLAB = registerBlock("stripped_pine_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PINE_LOG = registerBlock("pine_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_LOG));
    public static final DeferredBlock<Block> PINE_LOG_SLAB = registerBlock("pine_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_LOG_SLAB));
    public static final DeferredBlock<Block> PINE_LOG_STAIRS = registerBlock("pine_log_stairs",
            () -> new ModStairs(PINE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_LOG_STAIRS));
    public static final DeferredBlock<Block> PINE_LOG_VERTICAL_SLAB = registerBlock("pine_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PINE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_WOOD));
    public static final DeferredBlock<Block> PINE_WOOD_SLAB = registerBlock("pine_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_WOOD_SLAB));
    public static final DeferredBlock<Block> PINE_WOOD_STAIRS = registerBlock("pine_wood_stairs",
            () -> new ModStairs(PINE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PINE_WOOD_STAIRS));
    public static final DeferredBlock<Block> PINE_WOOD_VERTICAL_SLAB = registerBlock("pine_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PINE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PINE_PLANKS_VERTICAL_SLAB = registerBlock("pine_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get())));

    public static final DeferredBlock<Block> PINE_PLANKS_STAIRS = registerBlock("pine_planks_stairs",
            () -> new ModStrippedStairs(PINE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> PINE_PLANKS_SLAB = registerBlock("pine_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get())));
    public static final DeferredBlock<Block> PINE_FENCE = registerBlock("pine_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> PINE_DOOR = registerBlock("pine_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> PINE_BUTTON = registerBlock("pine_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PINE_SIGN = BLOCKS.register("pine_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.PINE));
    public static final DeferredBlock<Block> PINE_WALL_SIGN = BLOCKS.register("pine_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PINE));
    public static final DeferredBlock<Block> PINE_HANGING_SIGN = BLOCKS.register("pine_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PINE));
    public static final DeferredBlock<Block> PINE_WALL_HANGING_SIGN = BLOCKS.register("pine_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PINE));

    public static final DeferredBlock<Block> PLUM_BEAM = registerBlock("plum_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PLUM_BEAM_SLAB = registerBlock("plum_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PLUM_BEAM_STAIRS = registerBlock("plum_beam_stairs",
            () -> new ModStrippedStairs(PLUM_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PLUM_BEAM_VERTICAL_SLAB = registerBlock("plum_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_LOG_SLAB = registerBlock("stripped_plum_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_LOG_STAIRS = registerBlock("stripped_plum_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_PLUM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_LOG_VERTICAL_SLAB = registerBlock("stripped_plum_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_WOOD_SLAB = registerBlock("stripped_plum_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_WOOD_STAIRS = registerBlock("stripped_plum_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_PLUM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PLUM_WOOD_VERTICAL_SLAB = registerBlock("stripped_plum_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PLUM_LOG = registerBlock("plum_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_LOG));
    public static final DeferredBlock<Block> PLUM_LOG_SLAB = registerBlock("plum_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_LOG_SLAB));
    public static final DeferredBlock<Block> PLUM_LOG_STAIRS = registerBlock("plum_log_stairs",
            () -> new ModStairs(PLUM_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_LOG_STAIRS));
    public static final DeferredBlock<Block> PLUM_LOG_VERTICAL_SLAB = registerBlock("plum_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PLUM_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PLUM_WOOD = registerBlock("plum_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_WOOD));
    public static final DeferredBlock<Block> PLUM_WOOD_SLAB = registerBlock("plum_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_WOOD_SLAB));
    public static final DeferredBlock<Block> PLUM_WOOD_STAIRS = registerBlock("plum_wood_stairs",
            () -> new ModStairs(PLUM_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_PLUM_WOOD_STAIRS));
    public static final DeferredBlock<Block> PLUM_WOOD_VERTICAL_SLAB = registerBlock("plum_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_PLUM_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> PLUM_PLANKS = registerBlock("plum_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PLUM_PLANKS_VERTICAL_SLAB = registerBlock("plum_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(PLUM_PLANKS.get())));

    public static final DeferredBlock<Block> PLUM_PLANKS_STAIRS = registerBlock("plum_planks_stairs",
            () -> new ModStrippedStairs(PLUM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(PLUM_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> PLUM_PLANKS_SLAB = registerBlock("plum_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(PLUM_PLANKS.get())));
    public static final DeferredBlock<Block> PLUM_FENCE = registerBlock("plum_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> PLUM_FENCE_GATE = registerBlock("plum_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.PLUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> PLUM_DOOR = registerBlock("plum_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> PLUM_TRAPDOOR = registerBlock("plum_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> PLUM_PRESSURE_PLATE = registerBlock("plum_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> PLUM_BUTTON = registerBlock("plum_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> PLUM_LEAVES = registerBlock("plum_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.PLUM));
    public static final DeferredBlock<Block> PLUM_SAPLING = registerBlock("plum_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PLUM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PLUM_SIGN = BLOCKS.register("plum_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.PLUM));
    public static final DeferredBlock<Block> PLUM_WALL_SIGN = BLOCKS.register("plum_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PLUM));
    public static final DeferredBlock<Block> PLUM_HANGING_SIGN = BLOCKS.register("plum_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PLUM));
    public static final DeferredBlock<Block> PLUM_WALL_HANGING_SIGN = BLOCKS.register("plum_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PLUM));

    public static final DeferredBlock<Block> POMEGRANATE_BEAM = registerBlock("pomegranate_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> POMEGRANATE_BEAM_SLAB = registerBlock("pomegranate_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> POMEGRANATE_BEAM_STAIRS = registerBlock("pomegranate_beam_stairs",
            () -> new ModStrippedStairs(POMEGRANATE_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> POMEGRANATE_BEAM_VERTICAL_SLAB = registerBlock("pomegranate_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_LOG = registerBlock("stripped_pomegranate_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_LOG_SLAB = registerBlock("stripped_pomegranate_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_LOG_STAIRS = registerBlock("stripped_pomegranate_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_POMEGRANATE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB = registerBlock("stripped_pomegranate_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_WOOD = registerBlock("stripped_pomegranate_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_WOOD_SLAB = registerBlock("stripped_pomegranate_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_WOOD_STAIRS = registerBlock("stripped_pomegranate_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_POMEGRANATE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB = registerBlock("stripped_pomegranate_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> POMEGRANATE_LOG = registerBlock("pomegranate_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_LOG));
    public static final DeferredBlock<Block> POMEGRANATE_LOG_SLAB = registerBlock("pomegranate_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_LOG_SLAB));
    public static final DeferredBlock<Block> POMEGRANATE_LOG_STAIRS = registerBlock("pomegranate_log_stairs",
            () -> new ModStairs(POMEGRANATE_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_LOG_STAIRS));
    public static final DeferredBlock<Block> POMEGRANATE_LOG_VERTICAL_SLAB = registerBlock("pomegranate_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> POMEGRANATE_WOOD = registerBlock("pomegranate_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_WOOD));
    public static final DeferredBlock<Block> POMEGRANATE_WOOD_SLAB = registerBlock("pomegranate_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_WOOD_SLAB));
    public static final DeferredBlock<Block> POMEGRANATE_WOOD_STAIRS = registerBlock("pomegranate_wood_stairs",
            () -> new ModStairs(POMEGRANATE_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_POMEGRANATE_WOOD_STAIRS));
    public static final DeferredBlock<Block> POMEGRANATE_WOOD_VERTICAL_SLAB = registerBlock("pomegranate_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> POMEGRANATE_PLANKS = registerBlock("pomegranate_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> POMEGRANATE_PLANKS_VERTICAL_SLAB = registerBlock("pomegranate_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));

    public static final DeferredBlock<Block> POMEGRANATE_PLANKS_STAIRS = registerBlock("pomegranate_planks_stairs",
            () -> new ModStrippedStairs(POMEGRANATE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> POMEGRANATE_PLANKS_SLAB = registerBlock("pomegranate_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(POMEGRANATE_PLANKS.get())));
    public static final DeferredBlock<Block> POMEGRANATE_FENCE = registerBlock("pomegranate_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> POMEGRANATE_FENCE_GATE = registerBlock("pomegranate_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> POMEGRANATE_DOOR = registerBlock("pomegranate_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> POMEGRANATE_TRAPDOOR = registerBlock("pomegranate_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> POMEGRANATE_PRESSURE_PLATE = registerBlock("pomegranate_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> POMEGRANATE_BUTTON = registerBlock("pomegranate_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> POMEGRANATE_LEAVES = registerBlock("pomegranate_leaves",
            () -> new ModFruitLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), ModItems.POMEGRANATE));
    public static final DeferredBlock<Block> POMEGRANATE_SAPLING = registerBlock("pomegranate_sapling",
            () -> new SaplingBlock(ModTreeGrowers.POMEGRANATE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POMEGRANATE_SIGN = BLOCKS.register("pomegranate_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.POMEGRANATE));
    public static final DeferredBlock<Block> POMEGRANATE_WALL_SIGN = BLOCKS.register("pomegranate_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.POMEGRANATE));
    public static final DeferredBlock<Block> POMEGRANATE_HANGING_SIGN = BLOCKS.register("pomegranate_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.POMEGRANATE));
    public static final DeferredBlock<Block> POMEGRANATE_WALL_HANGING_SIGN = BLOCKS.register("pomegranate_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.POMEGRANATE));

    public static final DeferredBlock<Block> REDWOOD_BEAM = registerBlock("redwood_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> REDWOOD_BEAM_SLAB = registerBlock("redwood_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> REDWOOD_BEAM_STAIRS = registerBlock("redwood_beam_stairs",
            () -> new ModStrippedStairs(REDWOOD_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> REDWOOD_BEAM_VERTICAL_SLAB = registerBlock("redwood_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_LOG_SLAB = registerBlock("stripped_redwood_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_LOG_STAIRS = registerBlock("stripped_redwood_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_REDWOOD_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_LOG_VERTICAL_SLAB = registerBlock("stripped_redwood_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_WOOD_SLAB = registerBlock("stripped_redwood_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_WOOD_STAIRS = registerBlock("stripped_redwood_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_REDWOOD_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB = registerBlock("stripped_redwood_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> REDWOOD_LOG = registerBlock("redwood_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_LOG));
    public static final DeferredBlock<Block> REDWOOD_LOG_SLAB = registerBlock("redwood_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_LOG_SLAB));
    public static final DeferredBlock<Block> REDWOOD_LOG_STAIRS = registerBlock("redwood_log_stairs",
            () -> new ModStairs(REDWOOD_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_LOG_STAIRS));
    public static final DeferredBlock<Block> REDWOOD_LOG_VERTICAL_SLAB = registerBlock("redwood_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_REDWOOD_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> REDWOOD_WOOD = registerBlock("redwood_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_WOOD));
    public static final DeferredBlock<Block> REDWOOD_WOOD_SLAB = registerBlock("redwood_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_WOOD_SLAB));
    public static final DeferredBlock<Block> REDWOOD_WOOD_STAIRS = registerBlock("redwood_wood_stairs",
            () -> new ModStairs(REDWOOD_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_REDWOOD_WOOD_STAIRS));
    public static final DeferredBlock<Block> REDWOOD_WOOD_VERTICAL_SLAB = registerBlock("redwood_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> REDWOOD_PLANKS_VERTICAL_SLAB = registerBlock("redwood_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(REDWOOD_PLANKS.get())));

    public static final DeferredBlock<Block> REDWOOD_PLANKS_STAIRS = registerBlock("redwood_planks_stairs",
            () -> new ModStrippedStairs(REDWOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(REDWOOD_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> REDWOOD_PLANKS_SLAB = registerBlock("redwood_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(REDWOOD_PLANKS.get())));
    public static final DeferredBlock<Block> REDWOOD_FENCE = registerBlock("redwood_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> REDWOOD_DOOR = registerBlock("redwood_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> REDWOOD_BUTTON = registerBlock("redwood_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling",
            () -> new SaplingBlock(ModTreeGrowers.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.REDWOOD));
    public static final DeferredBlock<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.REDWOOD));
    public static final DeferredBlock<Block> REDWOOD_HANGING_SIGN = BLOCKS.register("redwood_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.REDWOOD));
    public static final DeferredBlock<Block> REDWOOD_WALL_HANGING_SIGN = BLOCKS.register("redwood_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.REDWOOD));

    public static final DeferredBlock<Block> RED_OAK_BEAM = registerBlock("red_oak_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_OAK_BEAM_SLAB = registerBlock("red_oak_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_OAK_BEAM_STAIRS = registerBlock("red_oak_beam_stairs",
            () -> new ModStrippedStairs(RED_OAK_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_OAK_BEAM_VERTICAL_SLAB = registerBlock("red_oak_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_RED_OAK_LOG = registerBlock("stripped_red_oak_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_LOG_SLAB = registerBlock("stripped_red_oak_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_LOG_STAIRS = registerBlock("stripped_red_oak_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_RED_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_LOG_VERTICAL_SLAB = registerBlock("stripped_red_oak_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_RED_OAK_WOOD = registerBlock("stripped_red_oak_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_WOOD_SLAB = registerBlock("stripped_red_oak_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_WOOD_STAIRS = registerBlock("stripped_red_oak_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_RED_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB = registerBlock("stripped_red_oak_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> RED_OAK_LOG = registerBlock("red_oak_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_LOG));
    public static final DeferredBlock<Block> RED_OAK_LOG_SLAB = registerBlock("red_oak_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_LOG_SLAB));
    public static final DeferredBlock<Block> RED_OAK_LOG_STAIRS = registerBlock("red_oak_log_stairs",
            () -> new ModStairs(RED_OAK_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_LOG_STAIRS));
    public static final DeferredBlock<Block> RED_OAK_LOG_VERTICAL_SLAB = registerBlock("red_oak_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_RED_OAK_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> RED_OAK_WOOD = registerBlock("red_oak_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_WOOD));
    public static final DeferredBlock<Block> RED_OAK_WOOD_SLAB = registerBlock("red_oak_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_WOOD_SLAB));
    public static final DeferredBlock<Block> RED_OAK_WOOD_STAIRS = registerBlock("red_oak_wood_stairs",
            () -> new ModStairs(RED_OAK_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_RED_OAK_WOOD_STAIRS));
    public static final DeferredBlock<Block> RED_OAK_WOOD_VERTICAL_SLAB = registerBlock("red_oak_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> RED_OAK_PLANKS = registerBlock("red_oak_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> RED_OAK_PLANKS_VERTICAL_SLAB = registerBlock("red_oak_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(RED_OAK_PLANKS.get())));

    public static final DeferredBlock<Block> RED_OAK_PLANKS_STAIRS = registerBlock("red_oak_planks_stairs",
            () -> new ModStrippedStairs(RED_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(RED_OAK_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> RED_OAK_PLANKS_SLAB = registerBlock("red_oak_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(RED_OAK_PLANKS.get())));
    public static final DeferredBlock<Block> RED_OAK_FENCE = registerBlock("red_oak_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> RED_OAK_FENCE_GATE = registerBlock("red_oak_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.RED_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> RED_OAK_DOOR = registerBlock("red_oak_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> RED_OAK_TRAPDOOR = registerBlock("red_oak_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> RED_OAK_PRESSURE_PLATE = registerBlock("red_oak_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> RED_OAK_BUTTON = registerBlock("red_oak_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> RED_OAK_LEAVES = registerBlock("red_oak_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> RED_OAK_SAPLING = registerBlock("red_oak_sapling",
            () -> new SaplingBlock(ModTreeGrowers.RED_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> RED_OAK_SIGN = BLOCKS.register("red_oak_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.RED_OAK));
    public static final DeferredBlock<Block> RED_OAK_WALL_SIGN = BLOCKS.register("red_oak_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.RED_OAK));
    public static final DeferredBlock<Block> RED_OAK_HANGING_SIGN = BLOCKS.register("red_oak_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.RED_OAK));
    public static final DeferredBlock<Block> RED_OAK_WALL_HANGING_SIGN = BLOCKS.register("red_oak_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.RED_OAK));

    public static final DeferredBlock<Block> WILLOW_BEAM = registerBlock("willow_beam",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> WILLOW_BEAM_SLAB = registerBlock("willow_beam_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> WILLOW_BEAM_STAIRS = registerBlock("willow_beam_stairs",
            () -> new ModStrippedStairs(WILLOW_BEAM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> WILLOW_BEAM_VERTICAL_SLAB = registerBlock("willow_beam_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_LOG_SLAB = registerBlock("stripped_willow_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_LOG_STAIRS = registerBlock("stripped_willow_log_stairs",
            () -> new ModStrippedStairs(STRIPPED_WILLOW_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_LOG_VERTICAL_SLAB = registerBlock("stripped_willow_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood",
            () -> new ModStrippedLog(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_WOOD_SLAB = registerBlock("stripped_willow_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_WOOD_STAIRS = registerBlock("stripped_willow_wood_stairs",
            () -> new ModStrippedStairs(STRIPPED_WILLOW_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WILLOW_WOOD_VERTICAL_SLAB = registerBlock("stripped_willow_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> WILLOW_LOG = registerBlock("willow_log",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_LOG));
    public static final DeferredBlock<Block> WILLOW_LOG_SLAB = registerBlock("willow_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_LOG_SLAB));
    public static final DeferredBlock<Block> WILLOW_LOG_STAIRS = registerBlock("willow_log_stairs",
            () -> new ModStairs(WILLOW_LOG.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_LOG_STAIRS));
    public static final DeferredBlock<Block> WILLOW_LOG_VERTICAL_SLAB = registerBlock("willow_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_WILLOW_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> WILLOW_WOOD = registerBlock("willow_wood",
            () -> new ModLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_WOOD));
    public static final DeferredBlock<Block> WILLOW_WOOD_SLAB = registerBlock("willow_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_WOOD_SLAB));
    public static final DeferredBlock<Block> WILLOW_WOOD_STAIRS = registerBlock("willow_wood_stairs",
            () -> new ModStairs(WILLOW_WOOD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_WILLOW_WOOD_STAIRS));
    public static final DeferredBlock<Block> WILLOW_WOOD_VERTICAL_SLAB = registerBlock("willow_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_WILLOW_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> WILLOW_PLANKS = registerBlock("willow_planks",
            () -> new ModPlanks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> WILLOW_PLANKS_VERTICAL_SLAB = registerBlock("willow_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(WILLOW_PLANKS.get())));

    public static final DeferredBlock<Block> WILLOW_PLANKS_STAIRS = registerBlock("willow_planks_stairs",
            () -> new ModStrippedStairs(WILLOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(WILLOW_PLANKS.get()).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> WILLOW_PLANKS_SLAB = registerBlock("willow_planks_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(WILLOW_PLANKS.get())));
    public static final DeferredBlock<Block> WILLOW_FENCE = registerBlock("willow_fence",
            () -> new ModFence(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> WILLOW_FENCE_GATE = registerBlock("willow_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> WILLOW_DOOR = registerBlock("willow_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));
    public static final DeferredBlock<Block> WILLOW_TRAPDOOR = registerBlock("willow_trapdoor",
            () -> new ModTrapDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion(),BlockSetType.OAK));
    public static final DeferredBlock<Block> WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate",
            () -> new ModPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final DeferredBlock<Block> WILLOW_BUTTON = registerBlock("willow_button",
            () -> new ModButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10));
    public static final DeferredBlock<Block> WILLOW_LEAVES = registerBlock("willow_leaves",
            () -> new ModLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> WILLOW_SAPLING = registerBlock("willow_sapling",
            () -> new SaplingBlock(ModTreeGrowers.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> WILLOW_SIGN = BLOCKS.register("willow_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), ModWoodTypes.WILLOW));
    public static final DeferredBlock<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), ModWoodTypes.WILLOW));
    public static final DeferredBlock<Block> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.WILLOW));
    public static final DeferredBlock<Block> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.WILLOW));



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

    public static final DeferredBlock<Block> TERRACOTTA_BRICK = registerBlock("terracotta_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_STAIRS = registerBlock("terracotta_brick_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_SLAB = registerBlock("terracotta_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_VERTICAL_SLAB = registerBlock("terracotta_brick_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WALL = registerBlock("terracotta_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLACK = registerBlock("terracotta_brick_black",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLACK_STAIRS = registerBlock("terracotta_brick_black_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_BLACK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLACK_SLAB = registerBlock("terracotta_brick_black_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLACK_VERTICAL_SLAB = registerBlock("terracotta_brick_black_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLACK_WALL = registerBlock("terracotta_brick_black_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLUE = registerBlock("terracotta_brick_blue",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLUE_STAIRS = registerBlock("terracotta_brick_blue_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_BLUE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLUE_SLAB = registerBlock("terracotta_brick_blue_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLUE_VERTICAL_SLAB = registerBlock("terracotta_brick_blue_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BLUE_WALL = registerBlock("terracotta_brick_blue_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BLUE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BROWN = registerBlock("terracotta_brick_brown",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BROWN_STAIRS = registerBlock("terracotta_brick_brown_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_BROWN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BROWN_SLAB = registerBlock("terracotta_brick_brown_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BROWN_VERTICAL_SLAB = registerBlock("terracotta_brick_brown_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_BROWN_WALL = registerBlock("terracotta_brick_brown_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_CYAN = registerBlock("terracotta_brick_cyan",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_CYAN_STAIRS = registerBlock("terracotta_brick_cyan_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_CYAN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_CYAN_SLAB = registerBlock("terracotta_brick_cyan_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_CYAN_VERTICAL_SLAB = registerBlock("terracotta_brick_cyan_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_CYAN_WALL = registerBlock("terracotta_brick_cyan_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.CYAN)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GRAY = registerBlock("terracotta_brick_gray",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GRAY_STAIRS = registerBlock("terracotta_brick_gray_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_GRAY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GRAY_SLAB = registerBlock("terracotta_brick_gray_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GRAY_VERTICAL_SLAB = registerBlock("terracotta_brick_gray_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GRAY_WALL = registerBlock("terracotta_brick_gray_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GREEN = registerBlock("terracotta_brick_green",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GREEN_STAIRS = registerBlock("terracotta_brick_green_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_GREEN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GREEN_SLAB = registerBlock("terracotta_brick_green_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GREEN_VERTICAL_SLAB = registerBlock("terracotta_brick_green_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_GREEN_WALL = registerBlock("terracotta_brick_green_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.GREEN)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_BLUE = registerBlock("terracotta_brick_light_blue",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_BLUE_STAIRS = registerBlock("terracotta_brick_light_blue_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_LIGHT_BLUE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_BLUE_SLAB = registerBlock("terracotta_brick_light_blue_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_BLUE_VERTICAL_SLAB = registerBlock("terracotta_brick_light_blue_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_BLUE_WALL = registerBlock("terracotta_brick_light_blue_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIGHT_BLUE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_GRAY = registerBlock("terracotta_brick_light_gray",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_GRAY_STAIRS = registerBlock("terracotta_brick_light_gray_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_LIGHT_GRAY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_GRAY_SLAB = registerBlock("terracotta_brick_light_gray_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_GRAY_VERTICAL_SLAB = registerBlock("terracotta_brick_light_gray_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIGHT_GRAY_WALL = registerBlock("terracotta_brick_light_gray_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIGHT_GRAY)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIME = registerBlock("terracotta_brick_lime",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIME_STAIRS = registerBlock("terracotta_brick_lime_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_LIME.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIME_SLAB = registerBlock("terracotta_brick_lime_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIME_VERTICAL_SLAB = registerBlock("terracotta_brick_lime_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_LIME_WALL = registerBlock("terracotta_brick_lime_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIME)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_MAGENTA = registerBlock("terracotta_brick_magenta",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_MAGENTA_STAIRS = registerBlock("terracotta_brick_magenta_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_MAGENTA.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_MAGENTA_SLAB = registerBlock("terracotta_brick_magenta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_MAGENTA_VERTICAL_SLAB = registerBlock("terracotta_brick_magenta_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_MAGENTA_WALL = registerBlock("terracotta_brick_magenta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.MAGENTA)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_ORANGE = registerBlock("terracotta_brick_orange",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_ORANGE_STAIRS = registerBlock("terracotta_brick_orange_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_ORANGE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_ORANGE_SLAB = registerBlock("terracotta_brick_orange_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_ORANGE_VERTICAL_SLAB = registerBlock("terracotta_brick_orange_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_ORANGE_WALL = registerBlock("terracotta_brick_orange_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.ORANGE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PINK = registerBlock("terracotta_brick_pink",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PINK_STAIRS = registerBlock("terracotta_brick_pink_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_PINK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PINK_SLAB = registerBlock("terracotta_brick_pink_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PINK_VERTICAL_SLAB = registerBlock("terracotta_brick_pink_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PINK_WALL = registerBlock("terracotta_brick_pink_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.PINK)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PURPLE = registerBlock("terracotta_brick_purple",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PURPLE_STAIRS = registerBlock("terracotta_brick_purple_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_PURPLE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PURPLE_SLAB = registerBlock("terracotta_brick_purple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PURPLE_VERTICAL_SLAB = registerBlock("terracotta_brick_purple_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_PURPLE_WALL = registerBlock("terracotta_brick_purple_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.PURPLE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_RED = registerBlock("terracotta_brick_red",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_RED_STAIRS = registerBlock("terracotta_brick_red_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_RED.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_RED_SLAB = registerBlock("terracotta_brick_red_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_RED_VERTICAL_SLAB = registerBlock("terracotta_brick_red_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_RED_WALL = registerBlock("terracotta_brick_red_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.RED)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WHITE = registerBlock("terracotta_brick_white",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WHITE_STAIRS = registerBlock("terracotta_brick_white_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_WHITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WHITE_SLAB = registerBlock("terracotta_brick_white_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WHITE_VERTICAL_SLAB = registerBlock("terracotta_brick_white_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_WHITE_WALL = registerBlock("terracotta_brick_white_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> TERRACOTTA_BRICK_YELLOW = registerBlock("terracotta_brick_yellow",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_YELLOW_STAIRS = registerBlock("terracotta_brick_yellow_stairs",
            () -> new StairBlock(TERRACOTTA_BRICK_YELLOW.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_YELLOW_SLAB = registerBlock("terracotta_brick_yellow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_YELLOW_VERTICAL_SLAB = registerBlock("terracotta_brick_yellow_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> TERRACOTTA_BRICK_YELLOW_WALL = registerBlock("terracotta_brick_yellow_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.YELLOW)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_BLACK = registerBlock("concrete_brick_black",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLACK_STAIRS = registerBlock("concrete_brick_black_stairs",
            () -> new StairBlock(CONCRETE_BRICK_BLACK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLACK_SLAB = registerBlock("concrete_brick_black_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLACK_VERTICAL_SLAB = registerBlock("concrete_brick_black_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLACK_WALL = registerBlock("concrete_brick_black_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_BLUE = registerBlock("concrete_brick_blue",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLUE_STAIRS = registerBlock("concrete_brick_blue_stairs",
            () -> new StairBlock(CONCRETE_BRICK_BLUE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLUE_SLAB = registerBlock("concrete_brick_blue_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLUE_VERTICAL_SLAB = registerBlock("concrete_brick_blue_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BLUE_WALL = registerBlock("concrete_brick_blue_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BLUE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_BROWN = registerBlock("concrete_brick_brown",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BROWN_STAIRS = registerBlock("concrete_brick_brown_stairs",
            () -> new StairBlock(CONCRETE_BRICK_BROWN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BROWN_SLAB = registerBlock("concrete_brick_brown_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BROWN_VERTICAL_SLAB = registerBlock("concrete_brick_brown_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_BROWN_WALL = registerBlock("concrete_brick_brown_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.BROWN)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_CYAN = registerBlock("concrete_brick_cyan",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_CYAN_STAIRS = registerBlock("concrete_brick_cyan_stairs",
            () -> new StairBlock(CONCRETE_BRICK_CYAN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_CYAN_SLAB = registerBlock("concrete_brick_cyan_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_CYAN_VERTICAL_SLAB = registerBlock("concrete_brick_cyan_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.CYAN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_CYAN_WALL = registerBlock("concrete_brick_cyan_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.CYAN)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_GRAY = registerBlock("concrete_brick_gray",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GRAY_STAIRS = registerBlock("concrete_brick_gray_stairs",
            () -> new StairBlock(CONCRETE_BRICK_GRAY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GRAY_SLAB = registerBlock("concrete_brick_gray_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GRAY_VERTICAL_SLAB = registerBlock("concrete_brick_gray_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GRAY_WALL = registerBlock("concrete_brick_gray_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.GRAY)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_GREEN = registerBlock("concrete_brick_green",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GREEN_STAIRS = registerBlock("concrete_brick_green_stairs",
            () -> new StairBlock(CONCRETE_BRICK_GREEN.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GREEN_SLAB = registerBlock("concrete_brick_green_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GREEN_VERTICAL_SLAB = registerBlock("concrete_brick_green_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.GREEN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_GREEN_WALL = registerBlock("concrete_brick_green_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.GREEN)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_BLUE = registerBlock("concrete_brick_light_blue",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_BLUE_STAIRS = registerBlock("concrete_brick_light_blue_stairs",
            () -> new StairBlock(CONCRETE_BRICK_LIGHT_BLUE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_BLUE_SLAB = registerBlock("concrete_brick_light_blue_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_BLUE_VERTICAL_SLAB = registerBlock("concrete_brick_light_blue_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_BLUE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_BLUE_WALL = registerBlock("concrete_brick_light_blue_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIGHT_BLUE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_GRAY = registerBlock("concrete_brick_light_gray",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_GRAY_STAIRS = registerBlock("concrete_brick_light_gray_stairs",
            () -> new StairBlock(CONCRETE_BRICK_LIGHT_GRAY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_GRAY_SLAB = registerBlock("concrete_brick_light_gray_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_GRAY_VERTICAL_SLAB = registerBlock("concrete_brick_light_gray_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIGHT_GRAY)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIGHT_GRAY_WALL = registerBlock("concrete_brick_light_gray_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIGHT_GRAY)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_LIME = registerBlock("concrete_brick_lime",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIME_STAIRS = registerBlock("concrete_brick_lime_stairs",
            () -> new StairBlock(CONCRETE_BRICK_LIME.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIME_SLAB = registerBlock("concrete_brick_lime_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIME_VERTICAL_SLAB = registerBlock("concrete_brick_lime_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.LIME)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_LIME_WALL = registerBlock("concrete_brick_lime_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.LIME)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_MAGENTA = registerBlock("concrete_brick_magenta",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_MAGENTA_STAIRS = registerBlock("concrete_brick_magenta_stairs",
            () -> new StairBlock(CONCRETE_BRICK_MAGENTA.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_MAGENTA_SLAB = registerBlock("concrete_brick_magenta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_MAGENTA_VERTICAL_SLAB = registerBlock("concrete_brick_magenta_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.MAGENTA)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_MAGENTA_WALL = registerBlock("concrete_brick_magenta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.MAGENTA)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_ORANGE = registerBlock("concrete_brick_orange",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_ORANGE_STAIRS = registerBlock("concrete_brick_orange_stairs",
            () -> new StairBlock(CONCRETE_BRICK_ORANGE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_ORANGE_SLAB = registerBlock("concrete_brick_orange_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_ORANGE_VERTICAL_SLAB = registerBlock("concrete_brick_orange_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_ORANGE_WALL = registerBlock("concrete_brick_orange_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.ORANGE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_PINK = registerBlock("concrete_brick_pink",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PINK_STAIRS = registerBlock("concrete_brick_pink_stairs",
            () -> new StairBlock(CONCRETE_BRICK_PINK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PINK_SLAB = registerBlock("concrete_brick_pink_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PINK_VERTICAL_SLAB = registerBlock("concrete_brick_pink_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PINK)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PINK_WALL = registerBlock("concrete_brick_pink_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.PINK)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_PURPLE = registerBlock("concrete_brick_purple",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PURPLE_STAIRS = registerBlock("concrete_brick_purple_stairs",
            () -> new StairBlock(CONCRETE_BRICK_PURPLE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PURPLE_SLAB = registerBlock("concrete_brick_purple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PURPLE_VERTICAL_SLAB = registerBlock("concrete_brick_purple_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.PURPLE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_PURPLE_WALL = registerBlock("concrete_brick_purple_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.PURPLE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_RED = registerBlock("concrete_brick_red",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_RED_STAIRS = registerBlock("concrete_brick_red_stairs",
            () -> new StairBlock(CONCRETE_BRICK_RED.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_RED_SLAB = registerBlock("concrete_brick_red_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_RED_VERTICAL_SLAB = registerBlock("concrete_brick_red_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.RED)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_RED_WALL = registerBlock("concrete_brick_red_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.RED)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_WHITE = registerBlock("concrete_brick_white",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_WHITE_STAIRS = registerBlock("concrete_brick_white_stairs",
            () -> new StairBlock(CONCRETE_BRICK_WHITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.BROWN)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_WHITE_SLAB = registerBlock("concrete_brick_white_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_WHITE_VERTICAL_SLAB = registerBlock("concrete_brick_white_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_WHITE_WALL = registerBlock("concrete_brick_white_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<Block> CONCRETE_BRICK_YELLOW = registerBlock("concrete_brick_yellow",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_YELLOW_STAIRS = registerBlock("concrete_brick_yellow_stairs",
            () -> new StairBlock(CONCRETE_BRICK_YELLOW.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_YELLOW_SLAB = registerBlock("concrete_brick_yellow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_YELLOW_VERTICAL_SLAB = registerBlock("concrete_brick_yellow_vertical_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(DyeColor.YELLOW)));
    public static final DeferredBlock<Block> CONCRETE_BRICK_YELLOW_WALL = registerBlock("concrete_brick_yellow_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.YELLOW)));

    public static final DeferredBlock<Block> GLASS = registerBlock("glass",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_STAINED_GLASS = registerBlock("white_stained_glass",
            () -> new StainedGlassBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_STAINED_GLASS = registerBlock("orange_stained_glass",
            () -> new StainedGlassBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS = registerBlock("magenta_stained_glass",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS = registerBlock("light_blue_stained_glass",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> YELLOW_STAINED_GLASS = registerBlock("yellow_stained_glass",
            () -> new StainedGlassBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LIME_STAINED_GLASS = registerBlock("lime_stained_glass",
            () -> new StainedGlassBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> PINK_STAINED_GLASS = registerBlock("pink_stained_glass",
            () -> new StainedGlassBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> GRAY_STAINED_GLASS = registerBlock("gray_stained_glass",
            () -> new StainedGlassBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS = registerBlock("light_gray_stained_glass",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_STAINED_GLASS = registerBlock("cyan_stained_glass",
            () -> new StainedGlassBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> PURPLE_STAINED_GLASS = registerBlock("purple_stained_glass",
            () -> new StainedGlassBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> BLUE_STAINED_GLASS = registerBlock("blue_stained_glass",
            () -> new StainedGlassBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> BROWN_STAINED_GLASS = registerBlock("brown_stained_glass",
            () -> new StainedGlassBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> GREEN_STAINED_GLASS = registerBlock("green_stained_glass",
            () -> new StainedGlassBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RED_STAINED_GLASS = registerBlock("red_stained_glass",
            () -> new StainedGlassBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_STAINED_GLASS = registerBlock("black_stained_glass",
            () -> new StainedGlassBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS).noOcclusion()));

    public static final DeferredBlock<Block> GLASS_PANE = registerBlock("glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_STAINED_GLASS_PANE = registerBlock("white_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_STAINED_GLASS_PANE = registerBlock("orange_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS_PANE = registerBlock("magenta_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS_PANE = registerBlock("light_blue_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> YELLOW_STAINED_GLASS_PANE = registerBlock("yellow_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> LIME_STAINED_GLASS_PANE = registerBlock("lime_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PINK_STAINED_GLASS_PANE = registerBlock("pink_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> GRAY_STAINED_GLASS_PANE = registerBlock("gray_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS_PANE = registerBlock("light_gray_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_STAINED_GLASS_PANE = registerBlock("cyan_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PURPLE_STAINED_GLASS_PANE = registerBlock("purple_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BLUE_STAINED_GLASS_PANE = registerBlock("blue_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BROWN_STAINED_GLASS_PANE = registerBlock("brown_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> GREEN_STAINED_GLASS_PANE = registerBlock("green_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RED_STAINED_GLASS_PANE = registerBlock("red_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_STAINED_GLASS_PANE = registerBlock("black_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));


    public static final DeferredBlock<Block> WHITE_WOOL_SLAB = registerBlock("white_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> ORANGE_WOOL_SLAB = registerBlock("orange_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_WOOL_SLAB = registerBlock("magenta_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_WOOL_SLAB = registerBlock("light_blue_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> YELLOW_WOOL_SLAB = registerBlock("yellow_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIME_WOOL_SLAB = registerBlock("lime_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PINK_WOOL_SLAB = registerBlock("pink_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GRAY_WOOL_SLAB = registerBlock("gray_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_WOOL_SLAB = registerBlock("light_gray_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CYAN_WOOL_SLAB = registerBlock("cyan_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_WOOL_SLAB = registerBlock("purple_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLUE_WOOL_SLAB = registerBlock("blue_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BROWN_WOOL_SLAB = registerBlock("brown_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GREEN_WOOL_SLAB = registerBlock("green_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RED_WOOL_SLAB = registerBlock("red_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLACK_WOOL_SLAB = registerBlock("black_wool_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    public static final DeferredBlock<Block> WHITE_WOOL_VERTICAL_SLAB = registerBlock("white_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> ORANGE_WOOL_VERTICAL_SLAB = registerBlock("orange_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_WOOL_VERTICAL_SLAB = registerBlock("magenta_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_WOOL_VERTICAL_SLAB = registerBlock("light_blue_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> YELLOW_WOOL_VERTICAL_SLAB = registerBlock("yellow_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIME_WOOL_VERTICAL_SLAB = registerBlock("lime_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PINK_WOOL_VERTICAL_SLAB = registerBlock("pink_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GRAY_WOOL_VERTICAL_SLAB = registerBlock("gray_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_WOOL_VERTICAL_SLAB = registerBlock("light_gray_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CYAN_WOOL_VERTICAL_SLAB = registerBlock("cyan_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_WOOL_VERTICAL_SLAB = registerBlock("purple_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLUE_WOOL_VERTICAL_SLAB = registerBlock("blue_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BROWN_WOOL_VERTICAL_SLAB = registerBlock("brown_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GREEN_WOOL_VERTICAL_SLAB = registerBlock("green_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RED_WOOL_VERTICAL_SLAB = registerBlock("red_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLACK_WOOL_VERTICAL_SLAB = registerBlock("black_wool_vertical_slab",
            () -> new FlammableVerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));


    public static final DeferredBlock<Block> WHITE_WOOL_STAIRS = registerBlock("white_wool_stairs",
            () -> new ModStrippedStairs(Blocks.WHITE_WOOL.defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> ORANGE_WOOL_STAIRS = registerBlock("orange_wool_stairs",
            () -> new ModStrippedStairs(Blocks.ORANGE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_WOOL_STAIRS = registerBlock("magenta_wool_stairs",
            () -> new ModStrippedStairs(Blocks.MAGENTA_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_WOOL_STAIRS = registerBlock("light_blue_wool_stairs",
            () -> new ModStrippedStairs(Blocks.LIGHT_BLUE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> YELLOW_WOOL_STAIRS = registerBlock("yellow_wool_stairs",
            () -> new ModStrippedStairs(Blocks.YELLOW_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIME_WOOL_STAIRS = registerBlock("lime_wool_stairs",
            () -> new ModStrippedStairs(Blocks.LIME_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PINK_WOOL_STAIRS = registerBlock("pink_wool_stairs",
            () -> new ModStrippedStairs(Blocks.PINK_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GRAY_WOOL_STAIRS = registerBlock("gray_wool_stairs",
            () -> new ModStrippedStairs(Blocks.GRAY_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_WOOL_STAIRS = registerBlock("light_gray_wool_stairs",
            () -> new ModStrippedStairs(Blocks.LIGHT_GRAY_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CYAN_WOOL_STAIRS = registerBlock("cyan_wool_stairs",
            () -> new ModStrippedStairs(Blocks.CYAN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_WOOL_STAIRS = registerBlock("purple_wool_stairs",
            () -> new ModStrippedStairs(Blocks.PURPLE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLUE_WOOL_STAIRS = registerBlock("blue_wool_stairs",
            () -> new ModStrippedStairs(Blocks.BLUE_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BROWN_WOOL_STAIRS = registerBlock("brown_wool_stairs",
            () -> new ModStrippedStairs(Blocks.BROWN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GREEN_WOOL_STAIRS = registerBlock("green_wool_stairs",
            () -> new ModStrippedStairs(Blocks.GREEN_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RED_WOOL_STAIRS = registerBlock("red_wool_stairs",
            () -> new ModStrippedStairs(Blocks.RED_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BLACK_WOOL_STAIRS = registerBlock("black_wool_stairs",
            () -> new ModStrippedStairs(Blocks.BLACK_WOOL.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));


    public static final DeferredBlock<Block> GOLD_BARS = registerBlock("gold_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).noOcclusion()));
    public static final DeferredBlock<Block> SILVER_BARS = registerBlock("silver_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).noOcclusion()));
    public static final DeferredBlock<Block> REED_BARS = registerBlock("reed_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).noOcclusion()));
    public static final DeferredBlock<Block> THATCH_BLOCK = registerBlock("thatch_block",
            () -> new HayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_BLOCK_STAIRS = registerBlock("thatch_block_stairs",
            () -> new ModStrippedStairs(THATCH_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_BLOCK_SLAB = registerBlock("thatch_block_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_BLOCK_VERTICAL_SLAB = registerBlock("thatch_block_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_MUSTY_BLOCK = registerBlock("thatch_musty_block",
            () -> new HayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_MUSTY_BLOCK_STAIRS = registerBlock("thatch_musty_block_stairs",
            () -> new ModStrippedStairs(THATCH_MUSTY_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_MUSTY_BLOCK_SLAB = registerBlock("thatch_musty_block_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> THATCH_MUSTY_BLOCK_VERTICAL_SLAB = registerBlock("thatch_musty_block_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> REED_BLOCK = registerBlock("reed_block",
            () -> new HayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> REED_BLOCK_STAIRS = registerBlock("reed_block_stairs",
            () -> new ModStrippedStairs(REED_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> REED_BLOCK_SLAB = registerBlock("reed_block_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> REED_BLOCK_VERTICAL_SLAB = registerBlock("reed_block_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));

/**
 *
 * VANILLA BLOCKS
 *
 **/

    public static final DeferredBlock<Block> STRIPPED_OAK_LOG_SLAB = registerBlock("stripped_oak_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OAK_LOG_STAIRS = registerBlock("stripped_oak_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_OAK_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OAK_LOG_VERTICAL_SLAB = registerBlock("stripped_oak_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_OAK_WOOD_SLAB = registerBlock("stripped_oak_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OAK_WOOD_STAIRS = registerBlock("stripped_oak_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_OAK_WOOD_VERTICAL_SLAB = registerBlock("stripped_oak_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> OAK_LOG_SLAB = registerBlock("oak_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OAK_LOG_SLAB));
    public static final DeferredBlock<Block> OAK_LOG_STAIRS = registerBlock("oak_log_stairs",
            () -> new ModStairs(Blocks.OAK_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OAK_LOG_STAIRS));
    public static final DeferredBlock<Block> OAK_LOG_VERTICAL_SLAB = registerBlock("oak_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_OAK_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> OAK_WOOD_SLAB = registerBlock("oak_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OAK_WOOD_SLAB));
    public static final DeferredBlock<Block> OAK_WOOD_STAIRS = registerBlock("oak_wood_stairs",
            () -> new ModStairs(Blocks.OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), STRIPPED_OAK_WOOD_STAIRS));
    public static final DeferredBlock<Block> OAK_WOOD_VERTICAL_SLAB = registerBlock("oak_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    STRIPPED_OAK_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> OAK_PLANKS_VERTICAL_SLAB = registerBlock("oak_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));


    public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_SLAB = registerBlock("stripped_spruce_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_STAIRS = registerBlock("stripped_spruce_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_VERTICAL_SLAB = registerBlock("stripped_spruce_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_SPRUCE_WOOD_SLAB = registerBlock("stripped_spruce_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_WOOD_STAIRS = registerBlock("stripped_spruce_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_SPRUCE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB = registerBlock("stripped_spruce_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final DeferredBlock<Block> SPRUCE_LOG_SLAB = registerBlock("spruce_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), STRIPPED_SPRUCE_LOG_SLAB));
    public static final DeferredBlock<Block> SPRUCE_LOG_STAIRS = registerBlock("spruce_log_stairs",
            () -> new ModStairs(Blocks.SPRUCE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), STRIPPED_SPRUCE_LOG_STAIRS));
    public static final DeferredBlock<Block> SPRUCE_LOG_VERTICAL_SLAB = registerBlock("spruce_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD),
                    STRIPPED_SPRUCE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> SPRUCE_WOOD_SLAB = registerBlock("spruce_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), STRIPPED_SPRUCE_WOOD_SLAB));
    public static final DeferredBlock<Block> SPRUCE_WOOD_STAIRS = registerBlock("spruce_wood_stairs",
            () -> new ModStairs(Blocks.SPRUCE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), STRIPPED_SPRUCE_WOOD_STAIRS));
    public static final DeferredBlock<Block> SPRUCE_WOOD_VERTICAL_SLAB = registerBlock("spruce_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD),
                    STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> SPRUCE_PLANKS_VERTICAL_SLAB = registerBlock("spruce_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));


    public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_SLAB = registerBlock("stripped_birch_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_STAIRS = registerBlock("stripped_birch_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_BIRCH_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_VERTICAL_SLAB = registerBlock("stripped_birch_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_BIRCH_WOOD_SLAB = registerBlock("stripped_birch_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_WOOD_STAIRS = registerBlock("stripped_birch_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_BIRCH_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_WOOD_VERTICAL_SLAB = registerBlock("stripped_birch_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));

    public static final DeferredBlock<Block> BIRCH_LOG_SLAB = registerBlock("birch_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD), STRIPPED_BIRCH_LOG_SLAB));
    public static final DeferredBlock<Block> BIRCH_LOG_STAIRS = registerBlock("birch_log_stairs",
            () -> new ModStairs(Blocks.BIRCH_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD), STRIPPED_BIRCH_LOG_STAIRS));
    public static final DeferredBlock<Block> BIRCH_LOG_VERTICAL_SLAB = registerBlock("birch_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD),
                    STRIPPED_BIRCH_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BIRCH_WOOD_SLAB = registerBlock("birch_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD), STRIPPED_BIRCH_WOOD_SLAB));
    public static final DeferredBlock<Block> BIRCH_WOOD_STAIRS = registerBlock("birch_wood_stairs",
            () -> new ModStairs(Blocks.BIRCH_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD), STRIPPED_BIRCH_WOOD_STAIRS));
    public static final DeferredBlock<Block> BIRCH_WOOD_VERTICAL_SLAB = registerBlock("birch_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD),
                    STRIPPED_BIRCH_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> BIRCH_PLANKS_VERTICAL_SLAB = registerBlock("birch_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_SLAB = registerBlock("stripped_jungle_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_STAIRS = registerBlock("stripped_jungle_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_VERTICAL_SLAB = registerBlock("stripped_jungle_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_JUNGLE_WOOD_SLAB = registerBlock("stripped_jungle_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_WOOD_STAIRS = registerBlock("stripped_jungle_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB = registerBlock("stripped_jungle_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));

    public static final DeferredBlock<Block> JUNGLE_LOG_SLAB = registerBlock("jungle_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD), STRIPPED_JUNGLE_LOG_SLAB));
    public static final DeferredBlock<Block> JUNGLE_LOG_STAIRS = registerBlock("jungle_log_stairs",
            () -> new ModStairs(Blocks.JUNGLE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD), STRIPPED_JUNGLE_LOG_STAIRS));
    public static final DeferredBlock<Block> JUNGLE_LOG_VERTICAL_SLAB = registerBlock("jungle_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD),
                    STRIPPED_JUNGLE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> JUNGLE_WOOD_SLAB = registerBlock("jungle_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD), STRIPPED_JUNGLE_WOOD_SLAB));
    public static final DeferredBlock<Block> JUNGLE_WOOD_STAIRS = registerBlock("jungle_wood_stairs",
            () -> new ModStairs(Blocks.JUNGLE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD), STRIPPED_JUNGLE_WOOD_STAIRS));
    public static final DeferredBlock<Block> JUNGLE_WOOD_VERTICAL_SLAB = registerBlock("jungle_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD),
                    STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> JUNGLE_PLANKS_VERTICAL_SLAB = registerBlock("jungle_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_SLAB = registerBlock("stripped_acacia_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_STAIRS = registerBlock("stripped_acacia_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_ACACIA_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_VERTICAL_SLAB = registerBlock("stripped_acacia_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_ACACIA_WOOD_SLAB = registerBlock("stripped_acacia_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_WOOD_STAIRS = registerBlock("stripped_acacia_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_ACACIA_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_WOOD_VERTICAL_SLAB = registerBlock("stripped_acacia_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));

    public static final DeferredBlock<Block> ACACIA_LOG_SLAB = registerBlock("acacia_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD), STRIPPED_ACACIA_LOG_SLAB));
    public static final DeferredBlock<Block> ACACIA_LOG_STAIRS = registerBlock("acacia_log_stairs",
            () -> new ModStairs(Blocks.ACACIA_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD), STRIPPED_ACACIA_LOG_STAIRS));
    public static final DeferredBlock<Block> ACACIA_LOG_VERTICAL_SLAB = registerBlock("acacia_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD),
                    STRIPPED_ACACIA_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ACACIA_WOOD_SLAB = registerBlock("acacia_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD), STRIPPED_ACACIA_WOOD_SLAB));
    public static final DeferredBlock<Block> ACACIA_WOOD_STAIRS = registerBlock("acacia_wood_stairs",
            () -> new ModStairs(Blocks.ACACIA_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD), STRIPPED_ACACIA_WOOD_STAIRS));
    public static final DeferredBlock<Block> ACACIA_WOOD_VERTICAL_SLAB = registerBlock("acacia_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD),
                    STRIPPED_ACACIA_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> ACACIA_PLANKS_VERTICAL_SLAB = registerBlock("acacia_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));


    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_SLAB = registerBlock("stripped_dark_oak_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_STAIRS = registerBlock("stripped_dark_oak_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB = registerBlock("stripped_dark_oak_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_WOOD_SLAB = registerBlock("stripped_dark_oak_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_WOOD_STAIRS = registerBlock("stripped_dark_oak_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_DARK_OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB = registerBlock("stripped_dark_oak_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final DeferredBlock<Block> DARK_OAK_LOG_SLAB = registerBlock("dark_oak_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD), STRIPPED_DARK_OAK_LOG_SLAB));
    public static final DeferredBlock<Block> DARK_OAK_LOG_STAIRS = registerBlock("dark_oak_log_stairs",
            () -> new ModStairs(Blocks.DARK_OAK_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD), STRIPPED_DARK_OAK_LOG_STAIRS));
    public static final DeferredBlock<Block> DARK_OAK_LOG_VERTICAL_SLAB = registerBlock("dark_oak_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD),
                    STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> DARK_OAK_WOOD_SLAB = registerBlock("dark_oak_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD), STRIPPED_DARK_OAK_WOOD_SLAB));
    public static final DeferredBlock<Block> DARK_OAK_WOOD_STAIRS = registerBlock("dark_oak_wood_stairs",
            () -> new ModStairs(Blocks.DARK_OAK_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD), STRIPPED_DARK_OAK_WOOD_STAIRS));
    public static final DeferredBlock<Block> DARK_OAK_WOOD_VERTICAL_SLAB = registerBlock("dark_oak_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD),
                    STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> DARK_OAK_PLANKS_VERTICAL_SLAB = registerBlock("dark_oak_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));


    public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_SLAB = registerBlock("stripped_mangrove_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_STAIRS = registerBlock("stripped_mangrove_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_MANGROVE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_VERTICAL_SLAB = registerBlock("stripped_mangrove_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_MANGROVE_WOOD_SLAB = registerBlock("stripped_mangrove_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_WOOD_STAIRS = registerBlock("stripped_mangrove_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_MANGROVE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB = registerBlock("stripped_mangrove_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD)));

    public static final DeferredBlock<Block> MANGROVE_LOG_SLAB = registerBlock("mangrove_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD), STRIPPED_MANGROVE_LOG_SLAB));
    public static final DeferredBlock<Block> MANGROVE_LOG_STAIRS = registerBlock("mangrove_log_stairs",
            () -> new ModStairs(Blocks.MANGROVE_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD), STRIPPED_MANGROVE_LOG_STAIRS));
    public static final DeferredBlock<Block> MANGROVE_LOG_VERTICAL_SLAB = registerBlock("mangrove_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD),
                    STRIPPED_MANGROVE_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MANGROVE_WOOD_SLAB = registerBlock("mangrove_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD), STRIPPED_MANGROVE_WOOD_SLAB));
    public static final DeferredBlock<Block> MANGROVE_WOOD_STAIRS = registerBlock("mangrove_wood_stairs",
            () -> new ModStairs(Blocks.MANGROVE_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD), STRIPPED_MANGROVE_WOOD_STAIRS));
    public static final DeferredBlock<Block> MANGROVE_WOOD_VERTICAL_SLAB = registerBlock("mangrove_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD),
                    STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> MANGROVE_PLANKS_VERTICAL_SLAB = registerBlock("mangrove_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_SLAB = registerBlock("stripped_cherry_log_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_STAIRS = registerBlock("stripped_cherry_log_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_CHERRY_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_VERTICAL_SLAB = registerBlock("stripped_cherry_log_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_CHERRY_WOOD_SLAB = registerBlock("stripped_cherry_wood_slab",
            () -> new ModStrippedSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_WOOD_STAIRS = registerBlock("stripped_cherry_wood_stairs",
            () -> new ModStrippedStairs(Blocks.STRIPPED_CHERRY_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_WOOD_VERTICAL_SLAB = registerBlock("stripped_cherry_wood_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final DeferredBlock<Block> CHERRY_LOG_SLAB = registerBlock("cherry_log_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), STRIPPED_CHERRY_LOG_SLAB));
    public static final DeferredBlock<Block> CHERRY_LOG_STAIRS = registerBlock("cherry_log_stairs",
            () -> new ModStairs(Blocks.CHERRY_LOG.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), STRIPPED_CHERRY_LOG_STAIRS));
    public static final DeferredBlock<Block> CHERRY_LOG_VERTICAL_SLAB = registerBlock("cherry_log_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD),
                    STRIPPED_CHERRY_LOG_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CHERRY_WOOD_SLAB = registerBlock("cherry_wood_slab",
            () -> new ModSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), STRIPPED_CHERRY_WOOD_SLAB));
    public static final DeferredBlock<Block> CHERRY_WOOD_STAIRS = registerBlock("cherry_wood_stairs",
            () -> new ModStairs(Blocks.CHERRY_WOOD.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), STRIPPED_CHERRY_WOOD_STAIRS));
    public static final DeferredBlock<Block> CHERRY_WOOD_VERTICAL_SLAB = registerBlock("cherry_wood_vertical_slab",
            () -> new WoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD),
                    STRIPPED_CHERRY_WOOD_VERTICAL_SLAB));

    public static final DeferredBlock<Block> CHERRY_PLANKS_VERTICAL_SLAB = registerBlock("cherry_planks_vertical_slab",
            () -> new StrippedWoodVerticalSlab(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    // White limestone
    public static final DeferredBlock<Block> WHITE_LIMESTONE = registerBlock("white_limestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> WHITE_LIMESTONE_BRICKS = registerBlock("white_limestone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> WHITE_LIMESTONE_BRICKWORK = registerBlock("white_limestone_brickwork",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> POLISHED_WHITE_LIMESTONE = registerBlock("polished_white_limestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.WHITE)));
    public static final DeferredBlock<Block> WHITE_LIMESTONE_PILLAR = registerBlock("white_limestone_pillar",
            () -> new ColumnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
//
//    public static final DeferredBlock<Block> STONE_VERTICAL_SLAB = registerBlock("stone_vertical_slab",
//            () -> new VerticalSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
//    public static final DeferredBlock<Block> STONE_WALL = registerBlock("stone_vertical_slab",
//            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));


    // Crops
    public static final DeferredBlock<Block> TOMATO_CROP = registerBlockWithoutItem("tomato_crop",
            () -> new ModCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), () -> ModItems.TOMATO_SEEDS.get(), 4));
    public static final DeferredBlock<Block> CABBAGE_CROP = registerBlockWithoutItem("cabbage_crop",
            () -> new ModCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), () -> ModItems.CABBAGE_SEEDS.get()));
    public static final DeferredBlock<Block> ONION_CROP = registerBlockWithoutItem("onion_crop",
            () -> new ModCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), () -> ModItems.ONION_SEEDS.get()));
    public static final DeferredBlock<Block> CUCUMBER_CROP = registerBlockWithoutItem("cucumber_crop",
                () -> new ModCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), () -> ModItems.CUCUMBER_SEEDS.get()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
