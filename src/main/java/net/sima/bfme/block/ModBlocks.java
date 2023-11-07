package net.sima.bfme.block;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BFME.MOD_ID);

    public static final RegistryObject<Block> GONDORIAN_STONE = registerBlock("gondorian_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_STONE = registerBlock("gondorian_overgrown_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_STONE = registerBlock("gondorian_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_STONE = registerBlock("gondorian_cracked_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_COBBLESTONE = registerBlock("gondorian_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_COBBLESTONE = registerBlock("gondorian_overgrown_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_COBBLESTONE = registerBlock("gondorian_mossy_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICK = registerBlock("gondorian_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICKWORK = registerBlock("gondorian_brickwork",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICK = registerBlock("gondorian_overgrown_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICK = registerBlock("gondorian_mossy_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICKWORK = registerBlock("gondorian_overgrown_brickwork",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICKWORK = registerBlock("gondorian_mossy_brickwork",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICK = registerBlock("gondorian_cracked_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICKWORK = registerBlock("gondorian_cracked_brickwork",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CHISELED_BRICK = registerBlock("gondorian_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_CHISELED_BRICK = registerBlock("gondorian_overgrown_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_CHISELED_BRICK = registerBlock("gondorian_mossy_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_CHISELED_BRICK = registerBlock("gondorian_cracked_chiseled_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));

  public static final RegistryObject<Block> GONDORIAN_PILLAR = registerBlock("gondorian_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_THIN_PILLAR = registerBlock("gondorian_thin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_PILLAR = registerBlock("gondorian_overgrown_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_THIN_PILLAR = registerBlock("gondorian_overgrown_thin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_PILLAR = registerBlock("gondorian_mossy_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_THIN_PILLAR = registerBlock("gondorian_mossy_thin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_PILLAR = registerBlock("gondorian_cracked_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_THIN_PILLAR = registerBlock("gondorian_cracked_thin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).mapColor(DyeColor.WHITE)));

  public static final RegistryObject<Block> GONDORIAN_STONE_SLAB = registerBlock("gondorian_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_STONE_SLAB = registerBlock("gondorian_overgrown_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_STONE_SLAB = registerBlock("gondorian_mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_STONE_SLAB = registerBlock("gondorian_cracked_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_COBBLESTONE_SLAB = registerBlock("gondorian_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_COBBLESTONE_SLAB = registerBlock("gondorian_overgrown_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_COBBLESTONE_SLAB = registerBlock("gondorian_mossy_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICK_SLAB = registerBlock("gondorian_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICKWORK_SLAB = registerBlock("gondorian_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICK_SLAB = registerBlock("gondorian_overgrown_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICK_SLAB = registerBlock("gondorian_mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICKWORK_SLAB = registerBlock("gondorian_overgrown_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICKWORK_SLAB = registerBlock("gondorian_mossy_brickwork_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_PILLAR_SLAB = registerBlock("gondorian_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_PILLAR_SLAB = registerBlock("gondorian_overgrown_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_PILLAR_SLAB = registerBlock("gondorian_mossy_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_PILLAR_SLAB = registerBlock("gondorian_cracked_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB).mapColor(DyeColor.WHITE)));

  public static final RegistryObject<Block> GONDORIAN_STONE_STAIRS = registerBlock("gondorian_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_STONE_STAIRS = registerBlock("gondorian_overgrown_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_OVERGROWN_STONE.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_STONE_STAIRS = registerBlock("gondorian_mossy_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_MOSSY_STONE.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));;
  public static final RegistryObject<Block> GONDORIAN_CRACKED_STONE_STAIRS = registerBlock("gondorian_cracked_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_CRACKED_STONE.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_COBBLESTONE_STAIRS = registerBlock("gondorian_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_COBBLESTONE.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_COBBLESTONE_STAIRS = registerBlock("gondorian_overgrown_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_COBBLESTONE_STAIRS = registerBlock("gondorian_mossy_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICK_STAIRS = registerBlock("gondorian_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICKWORK_STAIRS = registerBlock("gondorian_brickwork_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICK_STAIRS = registerBlock("gondorian_overgrown_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_OVERGROWN_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICKWORK_STAIRS = registerBlock("gondorian_overgrown_brickwork_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICK_STAIRS = registerBlock("gondorian_mossy_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICKWORK_STAIRS = registerBlock("gondorian_mossy_brickwork_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICK_STAIRS = registerBlock("gondorian_cracked_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_CRACKED_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICKWORK_STAIRS = registerBlock("gondorian_cracked_brickwork_stairs",
            () -> new StairBlock(() -> ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).mapColor(DyeColor.WHITE)));

  public static final RegistryObject<Block> GONDORIAN_STONE_WALL = registerBlock("gondorian_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_STONE_WALL = registerBlock("gondorian_overgrown_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_STONE_WALL = registerBlock("gondorian_mossy_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_STONE_WALL = registerBlock("gondorian_cracked_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_COBBLESTONE_WALL = registerBlock("gondorian_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_COBBLESTONE_WALL = registerBlock("gondorian_overgrown_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_COBBLESTONE_WALL = registerBlock("gondorian_mossy_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICK_WALL = registerBlock("gondorian_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_BRICKWORK_WALL = registerBlock("gondorian_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICK_WALL = registerBlock("gondorian_overgrown_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_OVERGROWN_BRICKWORK_WALL = registerBlock("gondorian_overgrown_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICK_WALL = registerBlock("gondorian_mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_MOSSY_BRICKWORK_WALL = registerBlock("gondorian_mossy_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICK_WALL = registerBlock("gondorian_cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));
  public static final RegistryObject<Block> GONDORIAN_CRACKED_BRICKWORK_WALL = registerBlock("gondorian_cracked_brickwork_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).mapColor(DyeColor.WHITE)));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
