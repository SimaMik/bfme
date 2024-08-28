package net.sima.bfme.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.block.custom.*;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BFME.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
                                    //Гондорские камни
        workbench(ModBlocks.GONDORIAN_WORKBENCH.get());

        blockWithItem(ModBlocks.GONDORIAN_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_COBBLESTONE.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
        blockWithItem(ModBlocks.GONDORIAN_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());

        slab(ModBlocks.GONDORIAN_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get());
        slab(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get());

        verticalSlab(ModBlocks.GONDORIAN_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());

        stairs(ModBlocks.GONDORIAN_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());

        pillar(ModBlocks.GONDORIAN_PILLAR.get());
        pillar(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
        pillar(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
        column(ModBlocks.GONDORIAN_COLUMN.get());
        column(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
        column(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
        pillarSlab(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());

        wall(ModBlocks.GONDORIAN_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
        wall(ModBlocks.GONDORIAN_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());

        button(ModBlocks.GONDORIAN_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_BRICK_BUTTON.get());

        pressurePlate(ModBlocks.GONDORIAN_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

        blockWithItem(ModBlocks.DURIN_STONE.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_STONE.get());
        blockWithItem(ModBlocks.DURIN_CRACKED_STONE.get());
        blockWithItem(ModBlocks.DURIN_COBBLESTONE.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_COBBLESTONE.get());
        blockWithItem(ModBlocks.DURIN_BRICK.get());
        blockWithItem(ModBlocks.DURIN_BRICKWORK.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_BRICK.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
        blockWithItem(ModBlocks.DURIN_CRACKED_BRICK.get());
        blockWithItem(ModBlocks.DURIN_CRACKED_BRICKWORK.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_CHISELED_BRICK.get());
        blockWithItem(ModBlocks.DURIN_SMOOTH_STONE.get());
        blockWithItem(ModBlocks.DURIN_GOLD_BRICK.get());

        slab(ModBlocks.DURIN_STONE_SLAB.get());
        slab(ModBlocks.DURIN_MOSSY_STONE_SLAB.get());
        slab(ModBlocks.DURIN_CRACKED_STONE_SLAB.get());
        slab(ModBlocks.DURIN_COBBLESTONE_SLAB.get());
        slab(ModBlocks.DURIN_MOSSY_COBBLESTONE_SLAB.get());
        slab(ModBlocks.DURIN_BRICK_SLAB.get());
        slab(ModBlocks.DURIN_CRACKED_BRICK_SLAB.get());
        slab(ModBlocks.DURIN_CRACKED_BRICKWORK_SLAB.get());
        slab(ModBlocks.DURIN_BRICKWORK_SLAB.get());
        slab(ModBlocks.DURIN_MOSSY_BRICK_SLAB.get());
        slab(ModBlocks.DURIN_MOSSY_BRICKWORK_SLAB.get());
        slab(ModBlocks.DURIN_SMOOTH_STONE_SLAB.get());
        slab(ModBlocks.DURIN_GOLD_BRICK_SLAB.get());

        verticalSlab(ModBlocks.DURIN_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_MOSSY_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_CRACKED_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_CRACKED_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_MOSSY_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_SMOOTH_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.DURIN_GOLD_BRICK_VERTICAL_SLAB.get());

        stairs(ModBlocks.DURIN_STONE_STAIRS.get());
        stairs(ModBlocks.DURIN_MOSSY_STONE_STAIRS.get());
        stairs(ModBlocks.DURIN_CRACKED_STONE_STAIRS.get());
        stairs(ModBlocks.DURIN_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.DURIN_MOSSY_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.DURIN_BRICK_STAIRS.get());
        stairs(ModBlocks.DURIN_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.DURIN_MOSSY_BRICK_STAIRS.get());
        stairs(ModBlocks.DURIN_MOSSY_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.DURIN_CRACKED_BRICK_STAIRS.get());
        stairs(ModBlocks.DURIN_CRACKED_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.DURIN_SMOOTH_STONE_STAIRS.get());
        stairs(ModBlocks.DURIN_GOLD_BRICK_STAIRS.get());

        pillar(ModBlocks.DURIN_PILLAR.get());
        pillar(ModBlocks.DURIN_MOSSY_PILLAR.get());
        pillar(ModBlocks.DURIN_CRACKED_PILLAR.get());
        pillar(ModBlocks.DURIN_CHISELED_BRICK.get());
        column(ModBlocks.DURIN_COLUMN.get());
        column(ModBlocks.DURIN_MOSSY_COLUMN.get());
        column(ModBlocks.DURIN_CRACKED_COLUMN.get());
        pillarSlab(ModBlocks.DURIN_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get());

        wall(ModBlocks.DURIN_STONE_WALL.get());
        wall(ModBlocks.DURIN_MOSSY_STONE_WALL.get());
        wall(ModBlocks.DURIN_CRACKED_STONE_WALL.get());
        wall(ModBlocks.DURIN_COBBLESTONE_WALL.get());
        wall(ModBlocks.DURIN_MOSSY_COBBLESTONE_WALL.get());
        wall(ModBlocks.DURIN_BRICK_WALL.get());
        wall(ModBlocks.DURIN_BRICKWORK_WALL.get());
        wall(ModBlocks.DURIN_MOSSY_BRICK_WALL.get());
        wall(ModBlocks.DURIN_MOSSY_BRICKWORK_WALL.get());
        wall(ModBlocks.DURIN_CRACKED_BRICK_WALL.get());
        wall(ModBlocks.DURIN_CRACKED_BRICKWORK_WALL.get());
        wall(ModBlocks.DURIN_GOLD_BRICK_WALL.get());
        wall(ModBlocks.DURIN_SMOOTH_STONE_WALL.get());

        button(ModBlocks.DURIN_STONE_BUTTON.get());
        button(ModBlocks.DURIN_MOSSY_STONE_BUTTON.get());
        button(ModBlocks.DURIN_CRACKED_STONE_BUTTON.get());
        button(ModBlocks.DURIN_COBBLESTONE_BUTTON.get());
        button(ModBlocks.DURIN_MOSSY_COBBLESTONE_BUTTON.get());
        button(ModBlocks.DURIN_BRICK_BUTTON.get());

        pressurePlate(ModBlocks.DURIN_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_MOSSY_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_CRACKED_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_MOSSY_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_CRACKED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_CHISELED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_GOLD_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.DURIN_SMOOTH_STONE_PRESSURE_PLATE.get());

        blockWithItem(ModBlocks.ROHAN_STONE.get());
        blockWithItem(ModBlocks.ROHAN_SMOOTH_STONE.get());
        blockWithItem(ModBlocks.ROHAN_MOSSY_STONE.get());
        blockWithItem(ModBlocks.ROHAN_CRACKED_STONE.get());
        blockWithItem(ModBlocks.ROHAN_COBBLESTONE.get());
        blockWithItem(ModBlocks.ROHAN_MOSSY_COBBLESTONE.get());
        blockWithItem(ModBlocks.ROHAN_BRICK.get());
        blockWithItem(ModBlocks.ROHAN_BRICKWORK.get());
        blockWithItem(ModBlocks.ROHAN_MOSSY_BRICK.get());
        blockWithItem(ModBlocks.ROHAN_MOSSY_BRICKWORK.get());
        blockWithItem(ModBlocks.ROHAN_CRACKED_BRICK.get());
        blockWithItem(ModBlocks.ROHAN_CRACKED_BRICKWORK.get());
        blockWithItem(ModBlocks.ROHAN_CHISELED_BRICK.get());
        blockWithItem(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK.get());

        slab(ModBlocks.ROHAN_STONE_SLAB.get());
        slab(ModBlocks.ROHAN_SMOOTH_STONE_SLAB.get());
        slab(ModBlocks.ROHAN_MOSSY_STONE_SLAB.get());
        slab(ModBlocks.ROHAN_CRACKED_STONE_SLAB.get());
        slab(ModBlocks.ROHAN_COBBLESTONE_SLAB.get());
        slab(ModBlocks.ROHAN_MOSSY_COBBLESTONE_SLAB.get());
        slab(ModBlocks.ROHAN_BRICK_SLAB.get());
        slab(ModBlocks.ROHAN_CRACKED_BRICK_SLAB.get());
        slab(ModBlocks.ROHAN_CRACKED_BRICKWORK_SLAB.get());
        slab(ModBlocks.ROHAN_BRICKWORK_SLAB.get());
        slab(ModBlocks.ROHAN_MOSSY_BRICK_SLAB.get());
        slab(ModBlocks.ROHAN_MOSSY_BRICKWORK_SLAB.get());

        verticalSlab(ModBlocks.ROHAN_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_SMOOTH_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_MOSSY_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_CRACKED_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_CRACKED_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_MOSSY_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());

        stairs(ModBlocks.ROHAN_STONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_SMOOTH_STONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_MOSSY_STONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_CRACKED_STONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_MOSSY_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.ROHAN_BRICK_STAIRS.get());
        stairs(ModBlocks.ROHAN_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.ROHAN_MOSSY_BRICK_STAIRS.get());
        stairs(ModBlocks.ROHAN_MOSSY_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.ROHAN_CRACKED_BRICK_STAIRS.get());
        stairs(ModBlocks.ROHAN_CRACKED_BRICKWORK_STAIRS.get());

        pillarExtend(ModBlocks.ROHAN_PILLAR.get());
        pillar(ModBlocks.ROHAN_MOSSY_PILLAR.get());
        pillar(ModBlocks.ROHAN_CRACKED_PILLAR.get());
        column(ModBlocks.ROHAN_COLUMN.get());
        column(ModBlocks.ROHAN_MOSSY_COLUMN.get());
        column(ModBlocks.ROHAN_CRACKED_COLUMN.get());
        pillarExtendSlab(ModBlocks.ROHAN_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get());

        wall(ModBlocks.ROHAN_STONE_WALL.get());
        wall(ModBlocks.ROHAN_SMOOTH_STONE_WALL.get());
        wall(ModBlocks.ROHAN_MOSSY_STONE_WALL.get());
        wall(ModBlocks.ROHAN_CRACKED_STONE_WALL.get());
        wall(ModBlocks.ROHAN_COBBLESTONE_WALL.get());
        wall(ModBlocks.ROHAN_MOSSY_COBBLESTONE_WALL.get());
        wall(ModBlocks.ROHAN_BRICK_WALL.get());
        wall(ModBlocks.ROHAN_BRICKWORK_WALL.get());
        wall(ModBlocks.ROHAN_MOSSY_BRICK_WALL.get());
        wall(ModBlocks.ROHAN_MOSSY_BRICKWORK_WALL.get());
        wall(ModBlocks.ROHAN_CRACKED_BRICK_WALL.get());
        wall(ModBlocks.ROHAN_CRACKED_BRICKWORK_WALL.get());

        button(ModBlocks.ROHAN_STONE_BUTTON.get());
        button(ModBlocks.ROHAN_MOSSY_STONE_BUTTON.get());
        button(ModBlocks.ROHAN_CRACKED_STONE_BUTTON.get());
        button(ModBlocks.ROHAN_COBBLESTONE_BUTTON.get());
        button(ModBlocks.ROHAN_MOSSY_COBBLESTONE_BUTTON.get());
        button(ModBlocks.ROHAN_BRICK_BUTTON.get());

        pressurePlate(ModBlocks.ROHAN_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_SMOOTH_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_MOSSY_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_CRACKED_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

        /* WOOD */

        log(ModBlocks.APPLE_LOG.get());
        log(ModBlocks.APPLE_BEAM.get());
        wood(ModBlocks.APPLE_WOOD.get());
        log(ModBlocks.STRIPPED_APPLE_LOG.get());
        wood(ModBlocks.STRIPPED_APPLE_WOOD.get());
        blockWithItem(ModBlocks.APPLE_PLANKS.get());
        stairs(ModBlocks.APPLE_PLANKS_STAIRS.get());
        slab(ModBlocks.APPLE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.APPLE_BUTTON.get());
        fence(ModBlocks.APPLE_FENCE.get());
        fenceGate(ModBlocks.APPLE_FENCE_GATE.get());
        door(ModBlocks.APPLE_DOOR.get());
        trapdoor(ModBlocks.APPLE_TRAPDOOR.get());
        fruitLeaves(ModBlocks.APPLE_LEAVES.get());
        woodenPressurePlate(ModBlocks.APPLE_PRESSURE_PLATE.get());
        sapling(ModBlocks.APPLE_SAPLING.get());
        signBlock((StandingSignBlock) ModBlocks.APPLE_SIGN.get(), (WallSignBlock) ModBlocks.APPLE_WALL_SIGN.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
//        signBlock(((StandingSignBlock) ModBlocks.APPLE_SIGN.get()), ((WallSignBlock) ModBlocks.APPLE_WALL_SIGN.get()),
//                blockTexture(ModBlocks.APPLE_PLANKS.get()));
        hangingSignBlock(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.APPLE_PLANKS.get()));

        log(ModBlocks.PEAR_LOG.get());
        log(ModBlocks.PEAR_BEAM.get());
        wood(ModBlocks.PEAR_WOOD.get());
        log(ModBlocks.STRIPPED_PEAR_LOG.get());
        wood(ModBlocks.STRIPPED_PEAR_WOOD.get());
        blockWithItem(ModBlocks.PEAR_PLANKS.get());
        stairs(ModBlocks.PEAR_PLANKS_STAIRS.get());
        slab(ModBlocks.PEAR_PLANKS_SLAB.get());
        woodenButton(ModBlocks.PEAR_BUTTON.get());
        fence(ModBlocks.PEAR_FENCE.get());
        fenceGate(ModBlocks.PEAR_FENCE_GATE.get());
        door(ModBlocks.PEAR_DOOR.get());
        trapdoor(ModBlocks.PEAR_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.PEAR_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.PEAR_LEAVES.get());
        sapling(ModBlocks.PEAR_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.PEAR_SIGN.get()), ((WallSignBlock) ModBlocks.PEAR_WALL_SIGN.get()),
                blockTexture(ModBlocks.PEAR_PLANKS.get()));
        hangingSignBlock(ModBlocks.PEAR_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.PEAR_PLANKS.get()));

        log(ModBlocks.PLUM_LOG.get());
        log(ModBlocks.PLUM_BEAM.get());
        wood(ModBlocks.PLUM_WOOD.get());
        log(ModBlocks.STRIPPED_PLUM_LOG.get());
        wood(ModBlocks.STRIPPED_PLUM_WOOD.get());
        blockWithItem(ModBlocks.PLUM_PLANKS.get());
        stairs(ModBlocks.PLUM_PLANKS_STAIRS.get());
        slab(ModBlocks.PLUM_PLANKS_SLAB.get());
        woodenButton(ModBlocks.PLUM_BUTTON.get());
        fence(ModBlocks.PLUM_FENCE.get());
        fenceGate(ModBlocks.PLUM_FENCE_GATE.get());
        door(ModBlocks.PLUM_DOOR.get());
        trapdoor(ModBlocks.PLUM_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.PLUM_PRESSURE_PLATE.get());
        sapling(ModBlocks.PLUM_SAPLING.get());
        fruitLeaves(ModBlocks.PLUM_LEAVES.get());
        signBlock(((StandingSignBlock) ModBlocks.PLUM_SIGN.get()), ((WallSignBlock) ModBlocks.PLUM_WALL_SIGN.get()),
                blockTexture(ModBlocks.PLUM_PLANKS.get()));
        hangingSignBlock(ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.PLUM_PLANKS.get()));

        log(ModBlocks.MALLORN_LOG.get());
        log(ModBlocks.MALLORN_BEAM.get());
        wood(ModBlocks.MALLORN_WOOD.get());
        log(ModBlocks.STRIPPED_MALLORN_LOG.get());
        wood(ModBlocks.STRIPPED_MALLORN_WOOD.get());
        blockWithItem(ModBlocks.MALLORN_PLANKS.get());
        stairs(ModBlocks.MALLORN_PLANKS_STAIRS.get());
        slab(ModBlocks.MALLORN_PLANKS_SLAB.get());
        woodenButton(ModBlocks.MALLORN_BUTTON.get());
        fence(ModBlocks.MALLORN_FENCE.get());
        fenceGate(ModBlocks.MALLORN_FENCE_GATE.get());
        door(ModBlocks.MALLORN_DOOR.get());
        trapdoor(ModBlocks.MALLORN_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.MALLORN_PRESSURE_PLATE.get());
        leaves(ModBlocks.MALLORN_LEAVES.get());
        sapling(ModBlocks.MALLORN_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.MALLORN_SIGN.get()), ((WallSignBlock) ModBlocks.MALLORN_WALL_SIGN.get()),
                blockTexture(ModBlocks.MALLORN_PLANKS.get()));
        hangingSignBlock(ModBlocks.MALLORN_HANGING_SIGN.get(), ModBlocks.MALLORN_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.MALLORN_PLANKS.get()));

        log(ModBlocks.CHARRED_LOG.get());
        log(ModBlocks.CHARRED_BEAM.get());
        wood(ModBlocks.CHARRED_WOOD.get());
        log(ModBlocks.STRIPPED_CHARRED_LOG.get());
        wood(ModBlocks.STRIPPED_CHARRED_WOOD.get());
        blockWithItem(ModBlocks.CHARRED_PLANKS.get());
        stairs(ModBlocks.CHARRED_PLANKS_STAIRS.get());
        slab(ModBlocks.CHARRED_PLANKS_SLAB.get());
        woodenButton(ModBlocks.CHARRED_BUTTON.get());
        fence(ModBlocks.CHARRED_FENCE.get());
        fenceGate(ModBlocks.CHARRED_FENCE_GATE.get());
        door(ModBlocks.CHARRED_DOOR.get());
        trapdoor(ModBlocks.CHARRED_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.CHARRED_PRESSURE_PLATE.get());
        signBlock(((StandingSignBlock) ModBlocks.CHARRED_SIGN.get()), ((WallSignBlock) ModBlocks.CHARRED_WALL_SIGN.get()),
                blockTexture(ModBlocks.CHARRED_PLANKS.get()));
        hangingSignBlock(ModBlocks.CHARRED_HANGING_SIGN.get(), ModBlocks.CHARRED_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.CHARRED_PLANKS.get()));

        log(ModBlocks.WILLOW_LOG.get());
        log(ModBlocks.WILLOW_BEAM.get());
        wood(ModBlocks.WILLOW_WOOD.get());
        log(ModBlocks.STRIPPED_WILLOW_LOG.get());
        wood(ModBlocks.STRIPPED_WILLOW_WOOD.get());
        blockWithItem(ModBlocks.WILLOW_PLANKS.get());
        stairs(ModBlocks.WILLOW_PLANKS_STAIRS.get());
        slab(ModBlocks.WILLOW_PLANKS_SLAB.get());
        woodenButton(ModBlocks.WILLOW_BUTTON.get());
        fence(ModBlocks.WILLOW_FENCE.get());
        fenceGate(ModBlocks.WILLOW_FENCE_GATE.get());
        door(ModBlocks.WILLOW_DOOR.get());
        trapdoor(ModBlocks.WILLOW_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.WILLOW_PRESSURE_PLATE.get());
        leaves(ModBlocks.WILLOW_LEAVES.get());
        sapling(ModBlocks.WILLOW_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.WILLOW_SIGN.get()), ((WallSignBlock) ModBlocks.WILLOW_WALL_SIGN.get()),
                blockTexture(ModBlocks.WILLOW_PLANKS.get()));
        hangingSignBlock(ModBlocks.WILLOW_HANGING_SIGN.get(), ModBlocks.WILLOW_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.WILLOW_PLANKS.get()));

        log(ModBlocks.BEECH_LOG.get());
        log(ModBlocks.BEECH_BEAM.get());
        wood(ModBlocks.BEECH_WOOD.get());
        log(ModBlocks.STRIPPED_BEECH_LOG.get());
        wood(ModBlocks.STRIPPED_BEECH_WOOD.get());
        blockWithItem(ModBlocks.BEECH_PLANKS.get());
        stairs(ModBlocks.BEECH_PLANKS_STAIRS.get());
        slab(ModBlocks.BEECH_PLANKS_SLAB.get());
        woodenButton(ModBlocks.BEECH_BUTTON.get());
        fence(ModBlocks.BEECH_FENCE.get());
        fenceGate(ModBlocks.BEECH_FENCE_GATE.get());
        door(ModBlocks.BEECH_DOOR.get());
        trapdoor(ModBlocks.BEECH_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.BEECH_PRESSURE_PLATE.get());
        leaves(ModBlocks.BEECH_LEAVES.get());
        sapling(ModBlocks.BEECH_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.BEECH_SIGN.get()), ((WallSignBlock) ModBlocks.BEECH_WALL_SIGN.get()),
                blockTexture(ModBlocks.BEECH_PLANKS.get()));
        hangingSignBlock(ModBlocks.BEECH_HANGING_SIGN.get(), ModBlocks.BEECH_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.BEECH_PLANKS.get()));

        log(ModBlocks.BAOBAB_LOG.get());
        log(ModBlocks.BAOBAB_BEAM.get());
        wood(ModBlocks.BAOBAB_WOOD.get());
        log(ModBlocks.STRIPPED_BAOBAB_LOG.get());
        wood(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        blockWithItem(ModBlocks.BAOBAB_PLANKS.get());
        stairs(ModBlocks.BAOBAB_PLANKS_STAIRS.get());
        slab(ModBlocks.BAOBAB_PLANKS_SLAB.get());
        woodenButton(ModBlocks.BAOBAB_BUTTON.get());
        fence(ModBlocks.BAOBAB_FENCE.get());
        fenceGate(ModBlocks.BAOBAB_FENCE_GATE.get());
        door(ModBlocks.BAOBAB_DOOR.get());
        trapdoor(ModBlocks.BAOBAB_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
        leaves(ModBlocks.BAOBAB_LEAVES.get());
        sapling(ModBlocks.BAOBAB_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.BAOBAB_SIGN.get()), ((WallSignBlock) ModBlocks.BAOBAB_WALL_SIGN.get()),
                blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        hangingSignBlock(ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.BAOBAB_PLANKS.get()));

        log(ModBlocks.PINE_LOG.get());
        log(ModBlocks.PINE_BEAM.get());
        wood(ModBlocks.PINE_WOOD.get());
        log(ModBlocks.STRIPPED_PINE_LOG.get());
        wood(ModBlocks.STRIPPED_PINE_WOOD.get());
        blockWithItem(ModBlocks.PINE_PLANKS.get());
        stairs(ModBlocks.PINE_PLANKS_STAIRS.get());
        slab(ModBlocks.PINE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.PINE_BUTTON.get());
        fence(ModBlocks.PINE_FENCE.get());
        fenceGate(ModBlocks.PINE_FENCE_GATE.get());
        door(ModBlocks.PINE_DOOR.get());
        trapdoor(ModBlocks.PINE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.PINE_PRESSURE_PLATE.get());
        leaves(ModBlocks.PINE_LEAVES.get());
        sapling(ModBlocks.PINE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()), ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                blockTexture(ModBlocks.PINE_PLANKS.get()));
        hangingSignBlock(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.PINE_PLANKS.get()));

        log(ModBlocks.HOLLY_LOG.get());
        log(ModBlocks.HOLLY_BEAM.get());
        wood(ModBlocks.HOLLY_WOOD.get());
        log(ModBlocks.STRIPPED_HOLLY_LOG.get());
        wood(ModBlocks.STRIPPED_HOLLY_WOOD.get());
        blockWithItem(ModBlocks.HOLLY_PLANKS.get());
        stairs(ModBlocks.HOLLY_PLANKS_STAIRS.get());
        slab(ModBlocks.HOLLY_PLANKS_SLAB.get());
        woodenButton(ModBlocks.HOLLY_BUTTON.get());
        fence(ModBlocks.HOLLY_FENCE.get());
        fenceGate(ModBlocks.HOLLY_FENCE_GATE.get());
        door(ModBlocks.HOLLY_DOOR.get());
        trapdoor(ModBlocks.HOLLY_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.HOLLY_PRESSURE_PLATE.get());
        leaves(ModBlocks.HOLLY_LEAVES.get());
        sapling(ModBlocks.HOLLY_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.HOLLY_SIGN.get()), ((WallSignBlock) ModBlocks.HOLLY_WALL_SIGN.get()),
                blockTexture(ModBlocks.HOLLY_PLANKS.get()));
        hangingSignBlock(ModBlocks.HOLLY_HANGING_SIGN.get(), ModBlocks.HOLLY_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.HOLLY_PLANKS.get()));

        log(ModBlocks.GREEN_OAK_LOG.get());
        log(ModBlocks.GREEN_OAK_BEAM.get());
        wood(ModBlocks.GREEN_OAK_WOOD.get());
        log(ModBlocks.STRIPPED_GREEN_OAK_LOG.get());
        wood(ModBlocks.STRIPPED_GREEN_OAK_WOOD.get());
        blockWithItem(ModBlocks.GREEN_OAK_PLANKS.get());
        stairs(ModBlocks.GREEN_OAK_PLANKS_STAIRS.get());
        slab(ModBlocks.GREEN_OAK_PLANKS_SLAB.get());
        woodenButton(ModBlocks.GREEN_OAK_BUTTON.get());
        fence(ModBlocks.GREEN_OAK_FENCE.get());
        fenceGate(ModBlocks.GREEN_OAK_FENCE_GATE.get());
        door(ModBlocks.GREEN_OAK_DOOR.get());
        trapdoor(ModBlocks.GREEN_OAK_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.GREEN_OAK_PRESSURE_PLATE.get());
        leaves(ModBlocks.GREEN_OAK_LEAVES.get());
        sapling(ModBlocks.GREEN_OAK_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.GREEN_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.GREEN_OAK_WALL_SIGN.get()),
                blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));
        hangingSignBlock(ModBlocks.GREEN_OAK_HANGING_SIGN.get(), ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));

        log(ModBlocks.RED_OAK_LOG.get());
        log(ModBlocks.RED_OAK_BEAM.get());
        wood(ModBlocks.RED_OAK_WOOD.get());
        log(ModBlocks.STRIPPED_RED_OAK_LOG.get());
        wood(ModBlocks.STRIPPED_RED_OAK_WOOD.get());
        blockWithItem(ModBlocks.RED_OAK_PLANKS.get());
        stairs(ModBlocks.RED_OAK_PLANKS_STAIRS.get());
        slab(ModBlocks.RED_OAK_PLANKS_SLAB.get());
        woodenButton(ModBlocks.RED_OAK_BUTTON.get());
        fence(ModBlocks.RED_OAK_FENCE.get());
        fenceGate(ModBlocks.RED_OAK_FENCE_GATE.get());
        door(ModBlocks.RED_OAK_DOOR.get());
        trapdoor(ModBlocks.RED_OAK_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.RED_OAK_PRESSURE_PLATE.get());
        leaves(ModBlocks.RED_OAK_LEAVES.get());
        sapling(ModBlocks.RED_OAK_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.RED_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.RED_OAK_WALL_SIGN.get()),
                blockTexture(ModBlocks.RED_OAK_PLANKS.get()));
        hangingSignBlock(ModBlocks.RED_OAK_HANGING_SIGN.get(), ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.RED_OAK_PLANKS.get()));

        log(ModBlocks.MIRK_OAK_LOG.get());
        log(ModBlocks.MIRK_OAK_BEAM.get());
        wood(ModBlocks.MIRK_OAK_WOOD.get());
        log(ModBlocks.STRIPPED_MIRK_OAK_LOG.get());
        wood(ModBlocks.STRIPPED_MIRK_OAK_WOOD.get());
        blockWithItem(ModBlocks.MIRK_OAK_PLANKS.get());
        stairs(ModBlocks.MIRK_OAK_PLANKS_STAIRS.get());
        slab(ModBlocks.MIRK_OAK_PLANKS_SLAB.get());
        woodenButton(ModBlocks.MIRK_OAK_BUTTON.get());
        fence(ModBlocks.MIRK_OAK_FENCE.get());
        fenceGate(ModBlocks.MIRK_OAK_FENCE_GATE.get());
        door(ModBlocks.MIRK_OAK_DOOR.get());
        trapdoor(ModBlocks.MIRK_OAK_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.MIRK_OAK_PRESSURE_PLATE.get());
        leaves(ModBlocks.MIRK_OAK_LEAVES.get());
        sapling(ModBlocks.MIRK_OAK_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.MIRK_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.MIRK_OAK_WALL_SIGN.get()),
                blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));
        hangingSignBlock(ModBlocks.MIRK_OAK_HANGING_SIGN.get(), ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));

        log(ModBlocks.MAPLE_LOG.get());
        log(ModBlocks.MAPLE_BEAM.get());
        wood(ModBlocks.MAPLE_WOOD.get());
        log(ModBlocks.STRIPPED_MAPLE_LOG.get());
        wood(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        blockWithItem(ModBlocks.MAPLE_PLANKS.get());
        stairs(ModBlocks.MAPLE_PLANKS_STAIRS.get());
        slab(ModBlocks.MAPLE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.MAPLE_BUTTON.get());
        fence(ModBlocks.MAPLE_FENCE.get());
        fenceGate(ModBlocks.MAPLE_FENCE_GATE.get());
        door(ModBlocks.MAPLE_DOOR.get());
        trapdoor(ModBlocks.MAPLE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        leaves(ModBlocks.MAPLE_LEAVES.get());
        sapling(ModBlocks.MAPLE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get()),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        hangingSignBlock(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));

        log(ModBlocks.PALM_LOG.get());
        log(ModBlocks.PALM_BEAM.get());
        wood(ModBlocks.PALM_WOOD.get());
        log(ModBlocks.STRIPPED_PALM_LOG.get());
        wood(ModBlocks.STRIPPED_PALM_WOOD.get());
        blockWithItem(ModBlocks.PALM_PLANKS.get());
        stairs(ModBlocks.PALM_PLANKS_STAIRS.get());
        slab(ModBlocks.PALM_PLANKS_SLAB.get());
        woodenButton(ModBlocks.PALM_BUTTON.get());
        fence(ModBlocks.PALM_FENCE.get());
        fenceGate(ModBlocks.PALM_FENCE_GATE.get());
        door(ModBlocks.PALM_DOOR.get());
        trapdoor(ModBlocks.PALM_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.PALM_PRESSURE_PLATE.get());
        leaves(ModBlocks.PALM_LEAVES.get());
        sapling(ModBlocks.PALM_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.PALM_SIGN.get()), ((WallSignBlock) ModBlocks.PALM_WALL_SIGN.get()),
                blockTexture(ModBlocks.PALM_PLANKS.get()));
        hangingSignBlock(ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.PALM_PLANKS.get()));

        log(ModBlocks.CHESTNUT_LOG.get());
        log(ModBlocks.CHESTNUT_BEAM.get());
        wood(ModBlocks.CHESTNUT_WOOD.get());
        log(ModBlocks.STRIPPED_CHESTNUT_LOG.get());
        wood(ModBlocks.STRIPPED_CHESTNUT_WOOD.get());
        blockWithItem(ModBlocks.CHESTNUT_PLANKS.get());
        stairs(ModBlocks.CHESTNUT_PLANKS_STAIRS.get());
        slab(ModBlocks.CHESTNUT_PLANKS_SLAB.get());
        woodenButton(ModBlocks.CHESTNUT_BUTTON.get());
        fence(ModBlocks.CHESTNUT_FENCE.get());
        fenceGate(ModBlocks.CHESTNUT_FENCE_GATE.get());
        door(ModBlocks.CHESTNUT_DOOR.get());
        trapdoor(ModBlocks.CHESTNUT_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.CHESTNUT_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.CHESTNUT_LEAVES.get());
        sapling(ModBlocks.CHESTNUT_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.CHESTNUT_SIGN.get()), ((WallSignBlock) ModBlocks.CHESTNUT_WALL_SIGN.get()),
                blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));
        hangingSignBlock(ModBlocks.CHESTNUT_HANGING_SIGN.get(), ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));

        log(ModBlocks.ASPEN_LOG.get());
        log(ModBlocks.ASPEN_BEAM.get());
        wood(ModBlocks.ASPEN_WOOD.get());
        log(ModBlocks.STRIPPED_ASPEN_LOG.get());
        wood(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        blockWithItem(ModBlocks.ASPEN_PLANKS.get());
        stairs(ModBlocks.ASPEN_PLANKS_STAIRS.get());
        slab(ModBlocks.ASPEN_PLANKS_SLAB.get());
        woodenButton(ModBlocks.ASPEN_BUTTON.get());
        fence(ModBlocks.ASPEN_FENCE.get());
        fenceGate(ModBlocks.ASPEN_FENCE_GATE.get());
        door(ModBlocks.ASPEN_DOOR.get());
        trapdoor(ModBlocks.ASPEN_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.ASPEN_PRESSURE_PLATE.get());
        leaves(ModBlocks.ASPEN_LEAVES.get());
        sapling(ModBlocks.ASPEN_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.ASPEN_SIGN.get()), ((WallSignBlock) ModBlocks.ASPEN_WALL_SIGN.get()),
                blockTexture(ModBlocks.ASPEN_PLANKS.get()));
        hangingSignBlock(ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.ASPEN_PLANKS.get()));

        log(ModBlocks.CEDAR_LOG.get());
        log(ModBlocks.CEDAR_BEAM.get());
        wood(ModBlocks.CEDAR_WOOD.get());
        log(ModBlocks.STRIPPED_CEDAR_LOG.get());
        wood(ModBlocks.STRIPPED_CEDAR_WOOD.get());
        blockWithItem(ModBlocks.CEDAR_PLANKS.get());
        stairs(ModBlocks.CEDAR_PLANKS_STAIRS.get());
        slab(ModBlocks.CEDAR_PLANKS_SLAB.get());
        woodenButton(ModBlocks.CEDAR_BUTTON.get());
        fence(ModBlocks.CEDAR_FENCE.get());
        fenceGate(ModBlocks.CEDAR_FENCE_GATE.get());
        door(ModBlocks.CEDAR_DOOR.get());
        trapdoor(ModBlocks.CEDAR_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.CEDAR_PRESSURE_PLATE.get());
        leaves(ModBlocks.CEDAR_LEAVES.get());
        sapling(ModBlocks.CEDAR_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.CEDAR_SIGN.get()), ((WallSignBlock) ModBlocks.CEDAR_WALL_SIGN.get()),
                blockTexture(ModBlocks.CEDAR_PLANKS.get()));
        hangingSignBlock(ModBlocks.CEDAR_HANGING_SIGN.get(), ModBlocks.CEDAR_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.CEDAR_PLANKS.get()));

        log(ModBlocks.FIR_LOG.get());
        log(ModBlocks.FIR_BEAM.get());
        wood(ModBlocks.FIR_WOOD.get());
        log(ModBlocks.STRIPPED_FIR_LOG.get());
        wood(ModBlocks.STRIPPED_FIR_WOOD.get());
        blockWithItem(ModBlocks.FIR_PLANKS.get());
        stairs(ModBlocks.FIR_PLANKS_STAIRS.get());
        slab(ModBlocks.FIR_PLANKS_SLAB.get());
        woodenButton(ModBlocks.FIR_BUTTON.get());
        fence(ModBlocks.FIR_FENCE.get());
        fenceGate(ModBlocks.FIR_FENCE_GATE.get());
        door(ModBlocks.FIR_DOOR.get());
        trapdoor(ModBlocks.FIR_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.FIR_PRESSURE_PLATE.get());
        leaves(ModBlocks.FIR_LEAVES.get());
        sapling(ModBlocks.FIR_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.FIR_SIGN.get()), ((WallSignBlock) ModBlocks.FIR_WALL_SIGN.get()),
                blockTexture(ModBlocks.FIR_PLANKS.get()));
        hangingSignBlock(ModBlocks.FIR_HANGING_SIGN.get(), ModBlocks.FIR_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.FIR_PLANKS.get()));

        log(ModBlocks.LARCH_LOG.get());
        log(ModBlocks.LARCH_BEAM.get());
        wood(ModBlocks.LARCH_WOOD.get());
        log(ModBlocks.STRIPPED_LARCH_LOG.get());
        wood(ModBlocks.STRIPPED_LARCH_WOOD.get());
        blockWithItem(ModBlocks.LARCH_PLANKS.get());
        stairs(ModBlocks.LARCH_PLANKS_STAIRS.get());
        slab(ModBlocks.LARCH_PLANKS_SLAB.get());
        woodenButton(ModBlocks.LARCH_BUTTON.get());
        fence(ModBlocks.LARCH_FENCE.get());
        fenceGate(ModBlocks.LARCH_FENCE_GATE.get());
        door(ModBlocks.LARCH_DOOR.get());
        trapdoor(ModBlocks.LARCH_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.LARCH_PRESSURE_PLATE.get());
        leaves(ModBlocks.LARCH_LEAVES.get());
        sapling(ModBlocks.LARCH_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.LARCH_SIGN.get()), ((WallSignBlock) ModBlocks.LARCH_WALL_SIGN.get()),
                blockTexture(ModBlocks.LARCH_PLANKS.get()));
        hangingSignBlock(ModBlocks.LARCH_HANGING_SIGN.get(), ModBlocks.LARCH_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.LARCH_PLANKS.get()));

        log(ModBlocks.LAIRELOSSE_LOG.get());
        log(ModBlocks.LAIRELOSSE_BEAM.get());
        wood(ModBlocks.LAIRELOSSE_WOOD.get());
        log(ModBlocks.STRIPPED_LAIRELOSSE_LOG.get());
        wood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD.get());
        blockWithItem(ModBlocks.LAIRELOSSE_PLANKS.get());
        stairs(ModBlocks.LAIRELOSSE_PLANKS_STAIRS.get());
        slab(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.LAIRELOSSE_BUTTON.get());
        fence(ModBlocks.LAIRELOSSE_FENCE.get());
        fenceGate(ModBlocks.LAIRELOSSE_FENCE_GATE.get());
        door(ModBlocks.LAIRELOSSE_DOOR.get());
        trapdoor(ModBlocks.LAIRELOSSE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.LAIRELOSSE_PRESSURE_PLATE.get());
        leaves(ModBlocks.LAIRELOSSE_LEAVES.get());
        sapling(ModBlocks.LAIRELOSSE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.LAIRELOSSE_SIGN.get()), ((WallSignBlock) ModBlocks.LAIRELOSSE_WALL_SIGN.get()),
                blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));
        hangingSignBlock(ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));

        log(ModBlocks.ALMOND_LOG.get());
        log(ModBlocks.ALMOND_BEAM.get());
        wood(ModBlocks.ALMOND_WOOD.get());
        log(ModBlocks.STRIPPED_ALMOND_LOG.get());
        wood(ModBlocks.STRIPPED_ALMOND_WOOD.get());
        blockWithItem(ModBlocks.ALMOND_PLANKS.get());
        stairs(ModBlocks.ALMOND_PLANKS_STAIRS.get());
        slab(ModBlocks.ALMOND_PLANKS_SLAB.get());
        woodenButton(ModBlocks.ALMOND_BUTTON.get());
        fence(ModBlocks.ALMOND_FENCE.get());
        fenceGate(ModBlocks.ALMOND_FENCE_GATE.get());
        door(ModBlocks.ALMOND_DOOR.get());
        trapdoor(ModBlocks.ALMOND_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.ALMOND_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.ALMOND_LEAVES.get());
        sapling(ModBlocks.ALMOND_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.ALMOND_SIGN.get()), ((WallSignBlock) ModBlocks.ALMOND_WALL_SIGN.get()),
                blockTexture(ModBlocks.ALMOND_PLANKS.get()));
        hangingSignBlock(ModBlocks.ALMOND_HANGING_SIGN.get(), ModBlocks.ALMOND_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.ALMOND_PLANKS.get()));

        log(ModBlocks.BANANA_LOG.get());
        log(ModBlocks.BANANA_BEAM.get());
        wood(ModBlocks.BANANA_WOOD.get());
        log(ModBlocks.STRIPPED_BANANA_LOG.get());
        wood(ModBlocks.STRIPPED_BANANA_WOOD.get());
        blockWithItem(ModBlocks.BANANA_PLANKS.get());
        stairs(ModBlocks.BANANA_PLANKS_STAIRS.get());
        slab(ModBlocks.BANANA_PLANKS_SLAB.get());
        woodenButton(ModBlocks.BANANA_BUTTON.get());
        fence(ModBlocks.BANANA_FENCE.get());
        fenceGate(ModBlocks.BANANA_FENCE_GATE.get());
        door(ModBlocks.BANANA_DOOR.get());
        trapdoor(ModBlocks.BANANA_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.BANANA_PRESSURE_PLATE.get());
        leaves(ModBlocks.BANANA_LEAVES.get());
        sapling(ModBlocks.BANANA_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.BANANA_SIGN.get()), ((WallSignBlock) ModBlocks.BANANA_WALL_SIGN.get()),
                blockTexture(ModBlocks.BANANA_PLANKS.get()));
        hangingSignBlock(ModBlocks.BANANA_HANGING_SIGN.get(), ModBlocks.BANANA_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.BANANA_PLANKS.get()));

        log(ModBlocks.CYPRESS_LOG.get());
        log(ModBlocks.CYPRESS_BEAM.get());
        wood(ModBlocks.CYPRESS_WOOD.get());
        log(ModBlocks.STRIPPED_CYPRESS_LOG.get());
        wood(ModBlocks.STRIPPED_CYPRESS_WOOD.get());
        blockWithItem(ModBlocks.CYPRESS_PLANKS.get());
        stairs(ModBlocks.CYPRESS_PLANKS_STAIRS.get());
        slab(ModBlocks.CYPRESS_PLANKS_SLAB.get());
        woodenButton(ModBlocks.CYPRESS_BUTTON.get());
        fence(ModBlocks.CYPRESS_FENCE.get());
        fenceGate(ModBlocks.CYPRESS_FENCE_GATE.get());
        door(ModBlocks.CYPRESS_DOOR.get());
        trapdoor(ModBlocks.CYPRESS_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.CYPRESS_PRESSURE_PLATE.get());
        leaves(ModBlocks.CYPRESS_LEAVES.get());
        sapling(ModBlocks.CYPRESS_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.CYPRESS_SIGN.get()), ((WallSignBlock) ModBlocks.CYPRESS_WALL_SIGN.get()),
                blockTexture(ModBlocks.CYPRESS_PLANKS.get()));
        hangingSignBlock(ModBlocks.CYPRESS_HANGING_SIGN.get(), ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.CYPRESS_PLANKS.get()));

        log(ModBlocks.DATE_PALM_LOG.get());
        log(ModBlocks.DATE_PALM_BEAM.get());
        wood(ModBlocks.DATE_PALM_WOOD.get());
        log(ModBlocks.STRIPPED_DATE_PALM_LOG.get());
        wood(ModBlocks.STRIPPED_DATE_PALM_WOOD.get());
        blockWithItem(ModBlocks.DATE_PALM_PLANKS.get());
        stairs(ModBlocks.DATE_PALM_PLANKS_STAIRS.get());
        slab(ModBlocks.DATE_PALM_PLANKS_SLAB.get());
        woodenButton(ModBlocks.DATE_PALM_BUTTON.get());
        fence(ModBlocks.DATE_PALM_FENCE.get());
        fenceGate(ModBlocks.DATE_PALM_FENCE_GATE.get());
        door(ModBlocks.DATE_PALM_DOOR.get());
        trapdoor(ModBlocks.DATE_PALM_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.DATE_PALM_PRESSURE_PLATE.get());
        leaves(ModBlocks.DATE_PALM_LEAVES.get());
        sapling(ModBlocks.DATE_PALM_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.DATE_PALM_SIGN.get()), ((WallSignBlock) ModBlocks.DATE_PALM_WALL_SIGN.get()),
                blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));
        hangingSignBlock(ModBlocks.DATE_PALM_HANGING_SIGN.get(), ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));

        log(ModBlocks.KUNTZ_LOG.get());
        log(ModBlocks.KUNTZ_BEAM.get());
        wood(ModBlocks.KUNTZ_WOOD.get());
        log(ModBlocks.STRIPPED_KUNTZ_LOG.get());
        wood(ModBlocks.STRIPPED_KUNTZ_WOOD.get());
        blockWithItem(ModBlocks.KUNTZ_PLANKS.get());
        stairs(ModBlocks.KUNTZ_PLANKS_STAIRS.get());
        slab(ModBlocks.KUNTZ_PLANKS_SLAB.get());
        woodenButton(ModBlocks.KUNTZ_BUTTON.get());
        fence(ModBlocks.KUNTZ_FENCE.get());
        fenceGate(ModBlocks.KUNTZ_FENCE_GATE.get());
        door(ModBlocks.KUNTZ_DOOR.get());
        trapdoor(ModBlocks.KUNTZ_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.KUNTZ_PRESSURE_PLATE.get());
        leaves(ModBlocks.KUNTZ_LEAVES.get());
        sapling(ModBlocks.KUNTZ_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.KUNTZ_SIGN.get()), ((WallSignBlock) ModBlocks.KUNTZ_WALL_SIGN.get()),
                blockTexture(ModBlocks.KUNTZ_PLANKS.get()));
        hangingSignBlock(ModBlocks.KUNTZ_HANGING_SIGN.get(), ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.KUNTZ_PLANKS.get()));

        log(ModBlocks.LEBETHRON_LOG.get());
        log(ModBlocks.LEBETHRON_BEAM.get());
        wood(ModBlocks.LEBETHRON_WOOD.get());
        log(ModBlocks.STRIPPED_LEBETHRON_LOG.get());
        wood(ModBlocks.STRIPPED_LEBETHRON_WOOD.get());
        blockWithItem(ModBlocks.LEBETHRON_PLANKS.get());
        stairs(ModBlocks.LEBETHRON_PLANKS_STAIRS.get());
        slab(ModBlocks.LEBETHRON_PLANKS_SLAB.get());
        woodenButton(ModBlocks.LEBETHRON_BUTTON.get());
        fence(ModBlocks.LEBETHRON_FENCE.get());
        fenceGate(ModBlocks.LEBETHRON_FENCE_GATE.get());
        door(ModBlocks.LEBETHRON_DOOR.get());
        trapdoor(ModBlocks.LEBETHRON_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.LEBETHRON_PRESSURE_PLATE.get());
        leaves(ModBlocks.LEBETHRON_LEAVES.get());
        sapling(ModBlocks.LEBETHRON_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.LEBETHRON_SIGN.get()), ((WallSignBlock) ModBlocks.LEBETHRON_WALL_SIGN.get()),
                blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));
        hangingSignBlock(ModBlocks.LEBETHRON_HANGING_SIGN.get(), ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));

        log(ModBlocks.LEMON_LOG.get());
        log(ModBlocks.LEMON_BEAM.get());
        wood(ModBlocks.LEMON_WOOD.get());
        log(ModBlocks.STRIPPED_LEMON_LOG.get());
        wood(ModBlocks.STRIPPED_LEMON_WOOD.get());
        blockWithItem(ModBlocks.LEMON_PLANKS.get());
        stairs(ModBlocks.LEMON_PLANKS_STAIRS.get());
        slab(ModBlocks.LEMON_PLANKS_SLAB.get());
        woodenButton(ModBlocks.LEMON_BUTTON.get());
        fence(ModBlocks.LEMON_FENCE.get());
        fenceGate(ModBlocks.LEMON_FENCE_GATE.get());
        door(ModBlocks.LEMON_DOOR.get());
        trapdoor(ModBlocks.LEMON_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.LEMON_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.LEMON_LEAVES.get());
        sapling(ModBlocks.LEMON_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.LEMON_SIGN.get()), ((WallSignBlock) ModBlocks.LEMON_WALL_SIGN.get()),
                blockTexture(ModBlocks.LEMON_PLANKS.get()));
        hangingSignBlock(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.LEMON_PLANKS.get()));

        log(ModBlocks.LIME_LOG.get());
        log(ModBlocks.LIME_BEAM.get());
        wood(ModBlocks.LIME_WOOD.get());
        log(ModBlocks.STRIPPED_LIME_LOG.get());
        wood(ModBlocks.STRIPPED_LIME_WOOD.get());
        blockWithItem(ModBlocks.LIME_PLANKS.get());
        stairs(ModBlocks.LIME_PLANKS_STAIRS.get());
        slab(ModBlocks.LIME_PLANKS_SLAB.get());
        woodenButton(ModBlocks.LIME_BUTTON.get());
        fence(ModBlocks.LIME_FENCE.get());
        fenceGate(ModBlocks.LIME_FENCE_GATE.get());
        door(ModBlocks.LIME_DOOR.get());
        trapdoor(ModBlocks.LIME_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.LIME_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.LIME_LEAVES.get());
        sapling(ModBlocks.LIME_SAPLING.get());

        log(ModBlocks.MANGO_LOG.get());
        log(ModBlocks.MANGO_BEAM.get());
        wood(ModBlocks.MANGO_WOOD.get());
        log(ModBlocks.STRIPPED_MANGO_LOG.get());
        wood(ModBlocks.STRIPPED_MANGO_WOOD.get());
        blockWithItem(ModBlocks.MANGO_PLANKS.get());
        stairs(ModBlocks.MANGO_PLANKS_STAIRS.get());
        slab(ModBlocks.MANGO_PLANKS_SLAB.get());
        woodenButton(ModBlocks.MANGO_BUTTON.get());
        fence(ModBlocks.MANGO_FENCE.get());
        fenceGate(ModBlocks.MANGO_FENCE_GATE.get());
        door(ModBlocks.MANGO_DOOR.get());
        trapdoor(ModBlocks.MANGO_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.MANGO_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.MANGO_LEAVES.get());
        sapling(ModBlocks.MANGO_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.MANGO_SIGN.get()), ((WallSignBlock) ModBlocks.MANGO_WALL_SIGN.get()),
                blockTexture(ModBlocks.MANGO_PLANKS.get()));
        hangingSignBlock(ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.MANGO_PLANKS.get()));

        log(ModBlocks.ORANGE_LOG.get());
        log(ModBlocks.ORANGE_BEAM.get());
        wood(ModBlocks.ORANGE_WOOD.get());
        log(ModBlocks.STRIPPED_ORANGE_LOG.get());
        wood(ModBlocks.STRIPPED_ORANGE_WOOD.get());
        blockWithItem(ModBlocks.ORANGE_PLANKS.get());
        stairs(ModBlocks.ORANGE_PLANKS_STAIRS.get());
        slab(ModBlocks.ORANGE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.ORANGE_BUTTON.get());
        fence(ModBlocks.ORANGE_FENCE.get());
        fenceGate(ModBlocks.ORANGE_FENCE_GATE.get());
        door(ModBlocks.ORANGE_DOOR.get());
        trapdoor(ModBlocks.ORANGE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.ORANGE_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.ORANGE_LEAVES.get());
        sapling(ModBlocks.ORANGE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.ORANGE_SIGN.get()), ((WallSignBlock) ModBlocks.ORANGE_WALL_SIGN.get()),
                blockTexture(ModBlocks.ORANGE_PLANKS.get()));
        hangingSignBlock(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.ORANGE_PLANKS.get()));

        log(ModBlocks.POMERGRANATE_LOG.get());
        log(ModBlocks.POMERGRANATE_BEAM.get());
        wood(ModBlocks.POMERGRANATE_WOOD.get());
        log(ModBlocks.STRIPPED_POMERGRANATE_LOG.get());
        wood(ModBlocks.STRIPPED_POMERGRANATE_WOOD.get());
        blockWithItem(ModBlocks.POMERGRANATE_PLANKS.get());
        stairs(ModBlocks.POMERGRANATE_PLANKS_STAIRS.get());
        slab(ModBlocks.POMERGRANATE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.POMERGRANATE_BUTTON.get());
        fence(ModBlocks.POMERGRANATE_FENCE.get());
        fenceGate(ModBlocks.POMERGRANATE_FENCE_GATE.get());
        door(ModBlocks.POMERGRANATE_DOOR.get());
        trapdoor(ModBlocks.POMERGRANATE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.POMERGRANATE_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.POMERGRANATE_LEAVES.get());
        sapling(ModBlocks.POMERGRANATE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.POMERGRANATE_SIGN.get()), ((WallSignBlock) ModBlocks.POMERGRANATE_WALL_SIGN.get()),
                blockTexture(ModBlocks.POMERGRANATE_PLANKS.get()));
        hangingSignBlock(ModBlocks.POMERGRANATE_HANGING_SIGN.get(), ModBlocks.POMERGRANATE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.POMERGRANATE_PLANKS.get()));

        log(ModBlocks.REDWOOD_LOG.get());
        log(ModBlocks.REDWOOD_BEAM.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.REDWOOD_WOOD.get()), blockTexture(ModBlocks.REDWOOD_LOG.get()), blockTexture(ModBlocks.REDWOOD_LOG.get()));
        log(ModBlocks.STRIPPED_REDWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_REDWOOD_WOOD.get(), ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "block/stripped_redwood_log"),
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "block/stripped_redwood_log"));
        blockItem(ModBlocks.REDWOOD_WOOD.get());
        blockItem(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
        blockWithItem(ModBlocks.REDWOOD_PLANKS.get());
        stairs(ModBlocks.REDWOOD_PLANKS_STAIRS.get());
        slab(ModBlocks.REDWOOD_PLANKS_SLAB.get());
        woodenButton(ModBlocks.REDWOOD_BUTTON.get());
        fence(ModBlocks.REDWOOD_FENCE.get());
        fenceGate(ModBlocks.REDWOOD_FENCE_GATE.get());
        door(ModBlocks.REDWOOD_DOOR.get());
        trapdoor(ModBlocks.REDWOOD_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
        leaves(ModBlocks.REDWOOD_LEAVES.get());
        sapling(ModBlocks.REDWOOD_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.REDWOOD_SIGN.get()), ((WallSignBlock) ModBlocks.REDWOOD_WALL_SIGN.get()),
                blockTexture(ModBlocks.REDWOOD_PLANKS.get()));
        hangingSignBlock(ModBlocks.REDWOOD_HANGING_SIGN.get(), ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.REDWOOD_PLANKS.get()));

        log(ModBlocks.RED_MAHOGANY_LOG.get());
        log(ModBlocks.RED_MAHOGANY_BEAM.get());
        wood(ModBlocks.RED_MAHOGANY_WOOD.get());
        log(ModBlocks.STRIPPED_RED_MAHOGANY_LOG.get());
        wood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD.get());
        blockWithItem(ModBlocks.RED_MAHOGANY_PLANKS.get());
        stairs(ModBlocks.RED_MAHOGANY_PLANKS_STAIRS.get());
        slab(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get());
        woodenButton(ModBlocks.RED_MAHOGANY_BUTTON.get());
        fence(ModBlocks.RED_MAHOGANY_FENCE.get());
        fenceGate(ModBlocks.RED_MAHOGANY_FENCE_GATE.get());
        door(ModBlocks.RED_MAHOGANY_DOOR.get());
        trapdoor(ModBlocks.RED_MAHOGANY_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.RED_MAHOGANY_PRESSURE_PLATE.get());
        leaves(ModBlocks.RED_MAHOGANY_LEAVES.get());
        sapling(ModBlocks.RED_MAHOGANY_SAPLING.get());

        log(ModBlocks.OLIVE_LOG.get());
        log(ModBlocks.OLIVE_BEAM.get());
        wood(ModBlocks.OLIVE_WOOD.get());
        log(ModBlocks.STRIPPED_OLIVE_LOG.get());
        wood(ModBlocks.STRIPPED_OLIVE_WOOD.get());
        blockWithItem(ModBlocks.OLIVE_PLANKS.get());
        stairs(ModBlocks.OLIVE_PLANKS_STAIRS.get());
        slab(ModBlocks.OLIVE_PLANKS_SLAB.get());
        woodenButton(ModBlocks.OLIVE_BUTTON.get());
        fence(ModBlocks.OLIVE_FENCE.get());
        fenceGate(ModBlocks.OLIVE_FENCE_GATE.get());
        door(ModBlocks.OLIVE_DOOR.get());
        trapdoor(ModBlocks.OLIVE_TRAPDOOR.get());
        woodenPressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE.get());
        fruitLeaves(ModBlocks.OLIVE_LEAVES.get());
        sapling(ModBlocks.OLIVE_SAPLING.get());
        signBlock(((StandingSignBlock) ModBlocks.OLIVE_SIGN.get()), ((WallSignBlock) ModBlocks.OLIVE_WALL_SIGN.get()),
                blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        hangingSignBlock(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(),
                blockTexture(ModBlocks.OLIVE_PLANKS.get()));


        /* ORES */
        oreBlockWithItem(ModBlocks.AMBER_ORE.get());
        blockWithItem(ModBlocks.AMBER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE.get());
        oreBlockWithItem(ModBlocks.AMETHYST_ORE.get());
        blockWithItem(ModBlocks.AMETHYST_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_AMETHYST_ORE.get());
        oreBlockWithItem(ModBlocks.DIAMOND_ORE.get());
        blockWithItem(ModBlocks.DIAMOND_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_DIAMOND_ORE.get());
        oreBlockWithItem(ModBlocks.EMERALD_ORE.get());
        blockWithItem(ModBlocks.EMERALD_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_EMERALD_ORE.get());
        oreBlockWithItem(ModBlocks.OPAL_ORE.get());
        blockWithItem(ModBlocks.OPAL_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_OPAL_ORE.get());
        oreBlockWithItem(ModBlocks.RUBY_ORE.get());
        blockWithItem(ModBlocks.RUBY_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE.get());
        oreBlockWithItem(ModBlocks.SAPPHIRE_ORE.get());
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        oreBlockWithItem(ModBlocks.TOPAZ_ORE.get());
        blockWithItem(ModBlocks.TOPAZ_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        oreBlockWithItem(ModBlocks.MITHRIL_ORE.get());
        blockWithItem(ModBlocks.MITHRIL_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
        oreBlockWithItem(ModBlocks.SILVER_ORE.get());
        blockWithItem(ModBlocks.SILVER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        oreBlockWithItem(ModBlocks.SALT_ORE.get());
        blockWithItem(ModBlocks.SALT_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SALT_ORE.get());
        oreBlockWithItem(ModBlocks.SALTPETER_ORE.get());
        blockWithItem(ModBlocks.SALTPETER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SALTPETER_ORE.get());
        oreBlockWithItem(ModBlocks.SULFUR_ORE.get());
        blockWithItem(ModBlocks.SULFUR_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
        blockWithItem(ModBlocks.BRONZE_BLOCK.get());
        oreBlockWithItem(ModBlocks.GLOWSTONE_ORE.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_GLOWSTONE_ORE.get());
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void oreBlockWithItem(Block block) {
        ModelFile model0 = models().cubeAll(name(block), blockTexture(block));
        ModelFile model1 = models().cubeAll(name(block) + "0", extend(blockTexture(block), "0"));
        ModelFile model2 = models().cubeAll(name(block) + "1", extend(blockTexture(block), "1"));
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(model0).nextModel()
                .modelFile(model1).nextModel()
                .modelFile(model2).build());
        blockItem(block);
    }
    public void wall(Block block) {
        wallBlock((WallBlock) block, models().wallPost(name(block) + "_post", change(block, "_wall", "")),
                models().wallSide(name(block) + "_side", change(block, "_wall", "")),
                models().wallSideTall(name(block) + "_side_tall", change(block, "_wall", "")));
    }
    private void slab(Block block){
        slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""));
        blockItem(block);
    }
    public void button(Block block) {
        ModelFile button = models().button(name(block), change(block, "_button", ""));
        ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", change(block, "_button", ""));
        buttonBlock((ButtonBlock) block, button, buttonPressed);
    }
    public void pressurePlate(Block block) {
        ModelFile pressurePlate = models().pressurePlate(name(block), change(block, "_pressure_plate", ""));
        ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", change(block, "_pressure_plate", ""));
        pressurePlateBlock(((PressurePlateBlock) block), pressurePlate, pressurePlateDown);
        blockItem(block);
    }
    public void woodenPressurePlate(Block block) {
        ModelFile pressurePlate = models().pressurePlate(name(block), change(block, "pressure_plate", "planks"));
        ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", change(block, "pressure_plate", "planks"));
        pressurePlateBlock(((PressurePlateBlock) block), pressurePlate, pressurePlateDown);
        blockItem(block);
    }
    public void woodenButton(Block block) {
        ModelFile button = models().button(name(block), change(block, "button", "planks"));
        ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", change(block, "button", "planks"));
        buttonBlock((ButtonBlock) block, button, buttonPressed);
    } public void fence(Block block) {
        fourWayBlock((FenceBlock)block,
                models().fencePost(key(block) + "_post", change(block, "fence", "planks")),
                models().fenceSide(key(block) + "_side", change(block, "fence", "planks")));
    }
    private void fenceGate(Block block) {
        ModelFile gate = models().fenceGate(name(block), change(block, "fence_gate", "planks"));
        ModelFile gateOpen = models().fenceGateOpen(key(block) + "_open", change(block, "fence_gate", "planks"));
        ModelFile gateWall = models().fenceGateWall(key(block) + "_wall", change(block, "fence_gate", "planks"));
        ModelFile gateWallOpen = models().fenceGateWallOpen(key(block) + "_wall_open", change(block, "fence_gate", "planks"));
        fenceGateBlock((FenceGateBlock) block, gate, gateOpen, gateWall, gateWallOpen);
        blockItem(block);
    }
    private void wood(Block block) {
        axisBlock((RotatedPillarBlock) block,
                models().cubeColumn(name(block), change(block,"wood", "log"), change(block,"wood", "log")),
                models().cubeColumnHorizontal(name(block),change(block, "wood", "log"),change(block, "wood", "log")));
        blockItem(block);
    }
    public void door(Block block){
        doorBlockWithRenderType((DoorBlock) block, extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top"), "cutout");
    }
    public void trapdoor(Block block){
        trapdoorBlockWithRenderType((TrapDoorBlock) block, blockTexture(block), true, "cutout");
        blockItem(block, "_bottom");
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }
    public void log(Block block) {
        axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
        blockItem(block);
    }
    private ConfiguredModel[] states(BlockState state, Block block) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().singleTexture(name(block) + "_stage" + state.getValue(((ModFruitLeaves) block).getAgeProperty()),ResourceLocation.withDefaultNamespace("block/leaves"),
                "all", extend(blockTexture(block), "_stage" + state.getValue(((ModFruitLeaves) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
    public void fruitLeaves(Block modFruitLeaves) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modFruitLeaves);
        getVariantBuilder(modFruitLeaves).forAllStates(function);
        simpleBlockItem(modFruitLeaves, new ModelFile.UncheckedModelFile("bfme:block/" + name(modFruitLeaves) + "_stage0"));
    }
    private void leaves(Block block) {
        simpleBlockWithItem(block,
                models().singleTexture(name(block), ResourceLocation.withDefaultNamespace("block/leaves"),
                        "all", blockTexture(block)).renderType("cutout"));
    }
    private void sapling(Block block) {
        simpleBlock(block,
                models().cross(name(block), blockTexture(block)).renderType("cutout"));
    }
    public void chair(Block block){
        horizontalBlock(block, new ModelFile.UncheckedModelFile(modLoc("block/woodchair")));
        blockTexture(block);
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    public void pillar(Block block) {
        axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
        blockItem(block);
    }
    private void pillarSlab(Block block){
        slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
        blockItem(block);
    }
    private void pillarExtendSlab(Block block){
        slabBlock((SlabBlock) block, change(block, "slab", "single"), change(block, "slab", "single"), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
        blockItem(block);
    }
    public void stairs(Block block) {
        stairsBlock((StairBlock) block, change(block, "_stairs", ""));
        blockItem(block);
    }
    public void workbench(Block block){
            ResourceLocation side = extend(blockTexture(block), "_side");
            ResourceLocation top = extend(blockTexture(block), "_top");

            BlockModelBuilder model = models().cube(name(block), change(block, "workbench", "stone"), top, side, side, side, side);
        simpleBlockWithItem(block, model);
        }

    private void verticalSlab(Block block) {

        createVerticalSlabModels(block);

        // Register block state and model
        getVariantBuilder(block).forAllStates(state -> {
            VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
            ResourceLocation modelLocation = getModelLocation(type, block);
            return ConfiguredModel.builder()
                    .modelFile(models().getExistingFile(modelLocation))
                    .build();
        });
        verticalBlockItem(block);
    }

    private ResourceLocation getModelLocation(VerticalSlabType type, Block block) {
        switch (type) {
            case SOUTH:
                return extend(blockTexture(block), "_south");
            case WEST:
                return extend(blockTexture(block), "_west");
            case EAST:
                return extend(blockTexture(block), "_east");
            case DOUBLE:
                return change(block, "_vertical_slab", "");
            case NORTH:
            default:
                return extend(blockTexture(block), "_north");
        }
    }

    private void createVerticalSlabModels(Block block) {
        ResourceLocation texture = change(block, "_vertical_slab", "");
        createVerticalSlabModel(name(block) + "_north", texture, Direction.NORTH, 0, 0, 0, 16, 16, 8);
        createVerticalSlabModel(name(block) + "_south", texture, Direction.SOUTH, 0, 0, 8, 16, 16, 16);
        createVerticalSlabModel(name(block) + "_west", texture, Direction.WEST, 0, 0, 0, 8, 16, 16);
        createVerticalSlabModel(name(block) + "_east", texture, Direction.EAST, 8, 0, 0, 16, 16, 16);
        createDoubleVerticalSlabModel(name(block) + "_double", texture);
    }

    private void createVerticalSlabModel(String name, ResourceLocation texture, Direction direction, int x, int y, int z, int x1, int y1, int z1) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("all", texture).texture("particle", texture);
        builder.element().from(x, y, z).to(x1, y1, z1).textureAll("#all").end();
    }

    private void createDoubleVerticalSlabModel(String name, ResourceLocation texture) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("all", texture);
        builder.element().from(0, 0, 0).to(16, 16, 16).textureAll("#all").end();
    }
    private void column(Block block) {
        createColumnModels(block);
        getVariantBuilder(block)
                .partialState().with(TinyColumnBlock.PART, ColumnPart.SINGLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_single"))).addModel()
                .partialState().with(TinyColumnBlock.PART, ColumnPart.BOTTOM)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_bottom"))).addModel()
                .partialState().with(TinyColumnBlock.PART, ColumnPart.MIDDLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_middle"))).addModel()
                .partialState().with(TinyColumnBlock.PART, ColumnPart.TOP)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_top"))).addModel();
        ColumnBlockItem(block);
    }
    private void createColumnModels(Block block) {
        createSingleColumnModel(block, name(block) + "_single");
        createBottomColumnModel(block, name(block) + "_bottom");
        createMiddleColumnModel(block, name(block) + "_middle");
        createTopColumnModel(block, name(block) + "_top");
    }

    private void createSingleColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                .element().from(3, 3, 3).to(13, 13, 13).textureAll("#3").end()
                .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
                .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();
    }
    private void createBottomColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                .element().from(3, 3, 3).to(13, 16, 13).textureAll("#3").end();
    }
    private void createMiddleColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(3, 0, 3).to(13, 16, 13).textureAll("#3").end();
    }

    private void createTopColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder
                .element().from(3, 0, 3).to(13, 13, 13).textureAll("#3").end()
                .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
                .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();
    }

    private void pillarExtend(Block block) {
        createPillarModels(block);
        getVariantBuilder(block)
                .partialState().with(ColumnBlock.PART, ColumnPart.SINGLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_single"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.BOTTOM)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_bottom"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.MIDDLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_middle"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.TOP)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_top"))).addModel();
        ColumnBlockItem(block);
    }

    private void createPillarModels(Block block){
        ResourceLocation end = extend(blockTexture(block), "_end");
        ResourceLocation single = extend(blockTexture(block), "_single");
        ResourceLocation top = extend(blockTexture(block), "_top");
        ResourceLocation middle = extend(blockTexture(block), "_middle");
        ResourceLocation bottom = extend(blockTexture(block), "_bottom");
        BlockModelBuilder singleModel = models().cube(name(block) + "_single", end, end, single, single, single, single).texture("particle", blockTexture(block));
        BlockModelBuilder topModel = models().cube(name(block) + "_top", end, end, top, top, top, top).texture("particle", blockTexture(block));
        BlockModelBuilder middleModel = models().cube(name(block) + "_middle", end, end, middle, middle, middle, middle).texture("particle", blockTexture(block));
        BlockModelBuilder bottomModel = models().cube(name(block) + "_bottom", end, end, bottom, bottom, bottom, bottom).texture("particle", blockTexture(block));

    }

    private void verticalBlockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + "_south"));
    }
    private void ColumnBlockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + "_single"));
    }
















    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    private ResourceLocation change(Block block, String replaced, String replace) {
        return ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"block/" +  key(block).getPath().replaceAll(replaced, replace));
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = this.key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath());
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
    }
    private void blockItem(Block block, String appendix) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + appendix));
    }

    private void blockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block)));
    }

}
