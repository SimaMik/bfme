package net.sima.bfme.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.GONDORIAN_STONE.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_STONE.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE.get());
        dropSelf(ModBlocks.GONDORIAN_COBBLESTONE.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
        dropSelf(ModBlocks.GONDORIAN_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_BRICKWORK.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
        dropSelf(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_CHISELED_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_CHISELED_BRICK.get());

        dropSelf(ModBlocks.GONDORIAN_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_THIN_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_THIN_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_THIN_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_THIN_PILLAR.get());

        this.add(ModBlocks.GONDORIAN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_OVERGROWN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_OVERGROWN_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_OVERGROWN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_OVERGROWN_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_PILLAR_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_OVERGROWN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_OVERGROWN_PILLAR_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get()));


        dropSelf(ModBlocks.GONDORIAN_STONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_STONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());

        dropSelf(ModBlocks.GONDORIAN_STONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_STONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_BRICK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
        dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());

//        dropSelf(ModBlocks..get());
//        dropSelf(ModBlocks..get());
//        dropSelf(ModBlocks..get());
//        dropSelf(ModBlocks..get());
//        dropSelf(ModBlocks..get());
    }




    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
