package net.sima.bfme.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.block.custom.ModFruitLeaves;
import net.sima.bfme.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
                                //Гондорские камни
        this.dropSelf(ModBlocks.GONDORIAN_CRAFTING_TABLE.get());
        this.dropSelf(ModBlocks.HUMAN_FURNACE.get());
        this.dropSelf(ModBlocks.PRIVATE_BLOCK.get());

        this.dropSelf(ModBlocks.GONDORIAN_STONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_SMOOTH_STONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_COBBLESTONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICK.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICKWORK.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
        this.dropSelf(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());

        this.dropSelf(ModBlocks.GONDORIAN_PILLAR.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
        this.add(ModBlocks.GONDORIAN_MOSSY_PILLAR_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_PILLAR_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.GONDORIAN_COLUMN.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());

        this.add(ModBlocks.GONDORIAN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_SMOOTH_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_SMOOTH_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_PILLAR_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get()));


        this.add(ModBlocks.GONDORIAN_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_SMOOTH_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_SMOOTH_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get()));

        this.dropSelf(ModBlocks.GONDORIAN_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_SMOOTH_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());

        this.dropSelf(ModBlocks.GONDORIAN_STONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_SMOOTH_STONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());

        this.dropSelf(ModBlocks.GONDORIAN_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICK_BUTTON.get());

        this.dropSelf(ModBlocks.GONDORIAN_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_SMOOTH_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

        this.dropSelf(ModBlocks.DURIN_STONE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_STONE.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_STONE.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DURIN_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_BRICKWORK.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICKWORK.get());
        this.dropSelf(ModBlocks.DURIN_CHISELED_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_CHISELED_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_SMOOTH_STONE.get());
        this.dropSelf(ModBlocks.DURIN_GOLD_BRICK.get());

        this.dropSelf(ModBlocks.DURIN_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_COLUMN.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COLUMN.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_COLUMN.get());

        this.add(ModBlocks.DURIN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_STONE_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_STONE_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_STONE_SLAB.get()));
        this.add(ModBlocks.DURIN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.DURIN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_BRICK_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_BRICK_SLAB.get()));
        this.add(ModBlocks.DURIN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_BRICK_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.DURIN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_PILLAR_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get()));
        this.add(ModBlocks.DURIN_SMOOTH_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_SMOOTH_STONE_SLAB.get()));
        this.add(ModBlocks.DURIN_GOLD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_GOLD_BRICK_SLAB.get()));


        this.add(ModBlocks.DURIN_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_GOLD_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_GOLD_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DURIN_SMOOTH_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DURIN_SMOOTH_STONE_VERTICAL_SLAB.get()));

        this.dropSelf(ModBlocks.DURIN_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_GOLD_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.DURIN_SMOOTH_STONE_STAIRS.get());

        this.dropSelf(ModBlocks.DURIN_STONE_WALL.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_STONE_WALL.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_STONE_WALL.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.DURIN_BRICK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_GOLD_BRICK_WALL.get());
        this.dropSelf(ModBlocks.DURIN_SMOOTH_STONE_WALL.get());

        this.dropSelf(ModBlocks.DURIN_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.DURIN_BRICK_BUTTON.get());

        this.dropSelf(ModBlocks.DURIN_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_CHISELED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_GOLD_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DURIN_SMOOTH_STONE_PRESSURE_PLATE.get());

        this.dropSelf(ModBlocks.ROHAN_STONE.get());
        this.dropSelf(ModBlocks.ROHAN_SMOOTH_STONE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_STONE.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_STONE.get());
        this.dropSelf(ModBlocks.ROHAN_COBBLESTONE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COBBLESTONE.get());
        this.dropSelf(ModBlocks.ROHAN_BRICK.get());
        this.dropSelf(ModBlocks.ROHAN_BRICKWORK.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICKWORK.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICK.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICKWORK.get());
        this.dropSelf(ModBlocks.ROHAN_CHISELED_BRICK.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK.get());

        this.dropSelf(ModBlocks.ROHAN_PILLAR.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_PILLAR.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.ROHAN_COLUMN.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COLUMN.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_COLUMN.get());

        this.add(ModBlocks.ROHAN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_STONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_SMOOTH_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_SMOOTH_STONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_STONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_STONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.ROHAN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_BRICK_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_BRICK_SLAB.get()));
        this.add(ModBlocks.ROHAN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_BRICK_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.ROHAN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_PILLAR_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get()));


        this.add(ModBlocks.ROHAN_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_SMOOTH_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_SMOOTH_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get()));

        this.dropSelf(ModBlocks.ROHAN_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_SMOOTH_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICKWORK_STAIRS.get());

        this.dropSelf(ModBlocks.ROHAN_STONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_SMOOTH_STONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_STONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_STONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_BRICK_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICK_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICK_WALL.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICKWORK_WALL.get());

        this.dropSelf(ModBlocks.ROHAN_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.ROHAN_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.ROHAN_BRICK_BUTTON.get());

        this.dropSelf(ModBlocks.ROHAN_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_SMOOTH_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());

        this.dropSelf(ModBlocks.NUMENOREAN_STONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_SMOOTH_STONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_STONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_STONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COBBLESTONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICKWORK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CHISELED_BRICK.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_CHISELED_BRICK.get());

        this.dropSelf(ModBlocks.NUMENOREAN_PILLAR.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_PILLAR.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COLUMN.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COLUMN.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_COLUMN.get());

        this.add(ModBlocks.NUMENOREAN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_STONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_SMOOTH_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_SMOOTH_STONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_STONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_STONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_BRICK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_BRICK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_BRICK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_PILLAR_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_PILLAR_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_PILLAR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_PILLAR_SLAB.get()));


        this.add(ModBlocks.NUMENOREAN_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_SMOOTH_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_SMOOTH_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_STONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_STONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_BRICK_VERTICAL_SLAB.get()));
        this.add(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get()));

        this.dropSelf(ModBlocks.NUMENOREAN_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_SMOOTH_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_STAIRS.get());

        this.dropSelf(ModBlocks.NUMENOREAN_STONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_SMOOTH_STONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_STONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_STONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICK_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICK_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICK_WALL.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_WALL.get());

        this.dropSelf(ModBlocks.NUMENOREAN_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICK_BUTTON.get());

        this.dropSelf(ModBlocks.NUMENOREAN_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_SMOOTH_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NUMENOREAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());



        this.dropSelf(ModBlocks.TERRACOTTA_BRICK.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLACK.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_BLACK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BLACK_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_BLACK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BLACK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLACK_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLACK_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLUE.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_BLUE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BLUE_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_BLUE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BLUE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLUE_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BLUE_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BROWN.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_BROWN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BROWN_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_BROWN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_BROWN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BROWN_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_BROWN_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_CYAN.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_CYAN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_CYAN_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_CYAN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_CYAN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_CYAN_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_CYAN_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GRAY.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_GRAY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_GRAY_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_GRAY_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_GRAY_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GRAY_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GRAY_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GREEN.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_GREEN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_GREEN_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_GREEN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_GREEN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GREEN_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_GREEN_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIME.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_LIME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIME_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_LIME_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_LIME_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIME_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_LIME_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_MAGENTA.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_MAGENTA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_MAGENTA_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_MAGENTA_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_MAGENTA_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_MAGENTA_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_MAGENTA_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_ORANGE.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_ORANGE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_ORANGE_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_ORANGE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_ORANGE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_ORANGE_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_ORANGE_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PINK.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_PINK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_PINK_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_PINK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_PINK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PINK_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PINK_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PURPLE.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_PURPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_PURPLE_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_PURPLE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_PURPLE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PURPLE_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_PURPLE_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_RED.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_RED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_RED_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_RED_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_RED_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_RED_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_RED_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_WHITE.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_WHITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_WHITE_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_WHITE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_WHITE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_WHITE_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_WHITE_WALL.get());

        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_YELLOW.get());
        this.add(ModBlocks.TERRACOTTA_BRICK_YELLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_YELLOW_SLAB.get()));
        this.add(ModBlocks.TERRACOTTA_BRICK_YELLOW_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_YELLOW_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_YELLOW_STAIRS.get());
        this.dropSelf(ModBlocks.TERRACOTTA_BRICK_YELLOW_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLACK.get());
        this.add(ModBlocks.CONCRETE_BRICK_BLACK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BLACK_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_BLACK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BLACK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLACK_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLACK_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLUE.get());
        this.add(ModBlocks.CONCRETE_BRICK_BLUE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BLUE_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_BLUE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BLUE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLUE_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BLUE_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_BROWN.get());
        this.add(ModBlocks.CONCRETE_BRICK_BROWN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BROWN_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_BROWN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_BROWN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BROWN_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_BROWN_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_CYAN.get());
        this.add(ModBlocks.CONCRETE_BRICK_CYAN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_CYAN_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_CYAN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_CYAN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_CYAN_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_CYAN_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_GRAY.get());
        this.add(ModBlocks.CONCRETE_BRICK_GRAY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_GRAY_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_GRAY_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_GRAY_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_GRAY_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_GRAY_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_GREEN.get());
        this.add(ModBlocks.CONCRETE_BRICK_GREEN_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_GREEN_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_GREEN_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_GREEN_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_GREEN_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_GREEN_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE.get());
        this.add(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY.get());
        this.add(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIME.get());
        this.add(ModBlocks.CONCRETE_BRICK_LIME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIME_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_LIME_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_LIME_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIME_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_LIME_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_MAGENTA.get());
        this.add(ModBlocks.CONCRETE_BRICK_MAGENTA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_MAGENTA_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_MAGENTA_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_MAGENTA_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_MAGENTA_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_MAGENTA_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_ORANGE.get());
        this.add(ModBlocks.CONCRETE_BRICK_ORANGE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_ORANGE_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_ORANGE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_ORANGE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_ORANGE_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_ORANGE_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_PINK.get());
        this.add(ModBlocks.CONCRETE_BRICK_PINK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_PINK_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_PINK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_PINK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_PINK_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_PINK_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_PURPLE.get());
        this.add(ModBlocks.CONCRETE_BRICK_PURPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_PURPLE_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_PURPLE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_PURPLE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_PURPLE_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_PURPLE_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_RED.get());
        this.add(ModBlocks.CONCRETE_BRICK_RED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_RED_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_RED_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_RED_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_RED_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_RED_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_WHITE.get());
        this.add(ModBlocks.CONCRETE_BRICK_WHITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_WHITE_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_WHITE_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_WHITE_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_WHITE_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_WHITE_WALL.get());

        this.dropSelf(ModBlocks.CONCRETE_BRICK_YELLOW.get());
        this.add(ModBlocks.CONCRETE_BRICK_YELLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_YELLOW_SLAB.get()));
        this.add(ModBlocks.CONCRETE_BRICK_YELLOW_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CONCRETE_BRICK_YELLOW_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CONCRETE_BRICK_YELLOW_STAIRS.get());
        this.dropSelf(ModBlocks.CONCRETE_BRICK_YELLOW_WALL.get());

        this.dropWhenSilkTouch(ModBlocks.GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.WHITE_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.ORANGE_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.MAGENTA_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.YELLOW_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.LIME_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.PINK_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.GRAY_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.CYAN_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.PURPLE_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.BLUE_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.BROWN_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.GREEN_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.RED_STAINED_GLASS.get());
        this.dropWhenSilkTouch(ModBlocks.BLACK_STAINED_GLASS.get());

        this.dropWhenSilkTouch(ModBlocks.GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.WHITE_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.MAGENTA_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.YELLOW_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.LIME_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.PINK_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.GRAY_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.CYAN_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.PURPLE_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.BROWN_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.RED_STAINED_GLASS_PANE.get());
        this.dropWhenSilkTouch(ModBlocks.BLACK_STAINED_GLASS_PANE.get());

        this.dropSelf(ModBlocks.GOLD_BARS.get());
        this.dropSelf(ModBlocks.SILVER_BARS.get());
        this.dropSelf(ModBlocks.REED_BARS.get());
        /* WOOD */
        this.dropSelf(ModBlocks.APPLE_LOG.get());
        this.dropSelf(ModBlocks.APPLE_LOG_STAIRS.get());
        this.add(ModBlocks.APPLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_PLANKS_SLAB.get()));
        this.dropSelf(ModBlocks.APPLE_BEAM.get());
        this.dropSelf(ModBlocks.APPLE_BEAM_STAIRS.get());
        this.add(ModBlocks.APPLE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.APPLE_WOOD.get());
        this.dropSelf(ModBlocks.APPLE_WOOD_STAIRS.get());
        this.add(ModBlocks.APPLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_APPLE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_APPLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_APPLE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_APPLE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_APPLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_APPLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.APPLE_PLANKS.get());
        this.dropSelf(ModBlocks.APPLE_PLANKS_STAIRS.get());
        this.add(ModBlocks.APPLE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_PLANKS_SLAB.get()));
        this.add(ModBlocks.APPLE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.APPLE_BUTTON.get());
        this.dropSelf(ModBlocks.APPLE_FENCE.get());
        this.dropSelf(ModBlocks.APPLE_FENCE_GATE.get());
        this.add(ModBlocks.APPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.APPLE_DOOR.get()));
        this.dropSelf(ModBlocks.APPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.APPLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.APPLE_SAPLING.get());
        this.add(ModBlocks.APPLE_LEAVES.get(), createFruitLeavesDrops(ModBlocks.APPLE_LEAVES.get(), ModItems.APPLE.get(), ModBlocks.APPLE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.APPLE_SIGN.get(), block ->
                createSingleItemTable(ModItems.APPLE_SIGN.get()));
        this.add(ModBlocks.APPLE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.APPLE_SIGN.get()));
        this.add(ModBlocks.APPLE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.APPLE_HANGING_SIGN.get()));
        this.add(ModBlocks.APPLE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.APPLE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.PEAR_LOG.get());
        this.dropSelf(ModBlocks.PEAR_LOG_STAIRS.get());
        this.add(ModBlocks.PEAR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.PEAR_BEAM.get());
        this.dropSelf(ModBlocks.PEAR_BEAM_STAIRS.get());
        this.add(ModBlocks.PEAR_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.PEAR_WOOD.get());
        this.dropSelf(ModBlocks.PEAR_WOOD_STAIRS.get());
        this.add(ModBlocks.PEAR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PEAR_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PEAR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PEAR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PEAR_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PEAR_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PEAR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PEAR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.PEAR_PLANKS.get());
        this.dropSelf(ModBlocks.PEAR_PLANKS_STAIRS.get());
        this.add(ModBlocks.PEAR_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_PLANKS_SLAB.get()));
        this.add(ModBlocks.PEAR_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.PEAR_BUTTON.get());
        this.dropSelf(ModBlocks.PEAR_FENCE.get());
        this.dropSelf(ModBlocks.PEAR_FENCE_GATE.get());
        this.add(ModBlocks.PEAR_DOOR.get(),
                block -> createDoorTable(ModBlocks.PEAR_DOOR.get()));
        this.dropSelf(ModBlocks.PEAR_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PEAR_PRESSURE_PLATE.get());
        this.add(ModBlocks.PEAR_LEAVES.get(), createFruitLeavesDrops(ModBlocks.PEAR_LEAVES.get(), ModItems.PEAR.get(), ModBlocks.PEAR_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.PEAR_SAPLING.get());
        this.add(ModBlocks.PEAR_SIGN.get(), block ->
                createSingleItemTable(ModItems.PEAR_SIGN.get()));
        this.add(ModBlocks.PEAR_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PEAR_SIGN.get()));
        this.add(ModBlocks.PEAR_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PEAR_HANGING_SIGN.get()));
        this.add(ModBlocks.PEAR_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PEAR_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.PLUM_LOG.get());
        this.dropSelf(ModBlocks.PLUM_LOG_STAIRS.get());
        this.add(ModBlocks.PLUM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.PLUM_BEAM.get());
        this.dropSelf(ModBlocks.PLUM_BEAM_STAIRS.get());
        this.add(ModBlocks.PLUM_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.PLUM_WOOD.get());
        this.dropSelf(ModBlocks.PLUM_WOOD_STAIRS.get());
        this.add(ModBlocks.PLUM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PLUM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PLUM_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PLUM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PLUM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PLUM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PLUM_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PLUM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PLUM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.PLUM_PLANKS.get());
        this.dropSelf(ModBlocks.PLUM_PLANKS_STAIRS.get());
        this.add(ModBlocks.PLUM_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_PLANKS_SLAB.get()));
        this.add(ModBlocks.PLUM_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.PLUM_BUTTON.get());
        this.dropSelf(ModBlocks.PLUM_FENCE.get());
        this.dropSelf(ModBlocks.PLUM_FENCE_GATE.get());
        this.add(ModBlocks.PLUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLUM_DOOR.get()));
        this.dropSelf(ModBlocks.PLUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PLUM_PRESSURE_PLATE.get());
        this.add(ModBlocks.PLUM_LEAVES.get(), createFruitLeavesDrops(ModBlocks.PLUM_LEAVES.get(), ModItems.PLUM.get(), ModBlocks.PLUM_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.PLUM_SAPLING.get());
        this.add(ModBlocks.PLUM_SIGN.get(), block ->
                createSingleItemTable(ModItems.PLUM_SIGN.get()));
        this.add(ModBlocks.PLUM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PLUM_SIGN.get()));
        this.add(ModBlocks.PLUM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PLUM_HANGING_SIGN.get()));
        this.add(ModBlocks.PLUM_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PLUM_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.MALLORN_LOG.get());
        this.dropSelf(ModBlocks.MALLORN_LOG_STAIRS.get());
        this.add(ModBlocks.MALLORN_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.MALLORN_BEAM.get());
        this.dropSelf(ModBlocks.MALLORN_BEAM_STAIRS.get());
        this.add(ModBlocks.MALLORN_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.MALLORN_WOOD.get());
        this.dropSelf(ModBlocks.MALLORN_WOOD_STAIRS.get());
        this.add(ModBlocks.MALLORN_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MALLORN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MALLORN_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MALLORN_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MALLORN_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MALLORN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MALLORN_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MALLORN_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MALLORN_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.MALLORN_PLANKS.get());
        this.dropSelf(ModBlocks.MALLORN_PLANKS_STAIRS.get());
        this.add(ModBlocks.MALLORN_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_PLANKS_SLAB.get()));
        this.add(ModBlocks.MALLORN_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.MALLORN_BUTTON.get());
        this.dropSelf(ModBlocks.MALLORN_FENCE.get());
        this.dropSelf(ModBlocks.MALLORN_FENCE_GATE.get());
        this.add(ModBlocks.MALLORN_DOOR.get(),
                block -> createDoorTable(ModBlocks.MALLORN_DOOR.get()));
        this.dropSelf(ModBlocks.MALLORN_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MALLORN_PRESSURE_PLATE.get());
        this.add(ModBlocks.MALLORN_LEAVES.get(), createLeavesDrops(ModBlocks.MALLORN_LEAVES.get(), ModBlocks.MALLORN_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MALLORN_SAPLING.get());
        this.add(ModBlocks.MALLORN_SIGN.get(), block ->
                createSingleItemTable(ModItems.MALLORN_SIGN.get()));
        this.add(ModBlocks.MALLORN_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.MALLORN_SIGN.get()));
        this.add(ModBlocks.MALLORN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MALLORN_HANGING_SIGN.get()));
        this.add(ModBlocks.MALLORN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MALLORN_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.WILLOW_LOG.get());
        this.dropSelf(ModBlocks.WILLOW_LOG_STAIRS.get());
        this.add(ModBlocks.WILLOW_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.WILLOW_BEAM.get());
        this.dropSelf(ModBlocks.WILLOW_BEAM_STAIRS.get());
        this.add(ModBlocks.WILLOW_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.WILLOW_WOOD_STAIRS.get());
        this.add(ModBlocks.WILLOW_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_WILLOW_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_WILLOW_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WILLOW_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_WILLOW_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_WILLOW_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.WILLOW_PLANKS.get());
        this.dropSelf(ModBlocks.WILLOW_PLANKS_STAIRS.get());
        this.add(ModBlocks.WILLOW_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_PLANKS_SLAB.get()));
        this.add(ModBlocks.WILLOW_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.WILLOW_BUTTON.get());
        this.dropSelf(ModBlocks.WILLOW_FENCE.get());
        this.dropSelf(ModBlocks.WILLOW_FENCE_GATE.get());
        this.add(ModBlocks.WILLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.WILLOW_DOOR.get()));
        this.dropSelf(ModBlocks.WILLOW_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WILLOW_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WILLOW_SAPLING.get());
        this.add(ModBlocks.WILLOW_LEAVES.get(), createLeavesDrops(ModBlocks.WILLOW_LEAVES.get(), ModBlocks.WILLOW_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.WILLOW_SIGN.get(), block ->
                createSingleItemTable(ModItems.WILLOW_SIGN.get()));
        this.add(ModBlocks.WILLOW_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.WILLOW_SIGN.get()));
        this.add(ModBlocks.WILLOW_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.WILLOW_HANGING_SIGN.get()));
        this.add(ModBlocks.WILLOW_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.WILLOW_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.CHARRED_LOG.get());
        this.dropSelf(ModBlocks.CHARRED_LOG_STAIRS.get());
        this.add(ModBlocks.CHARRED_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.CHARRED_BEAM.get());
        this.dropSelf(ModBlocks.CHARRED_BEAM_STAIRS.get());
        this.add(ModBlocks.CHARRED_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.CHARRED_WOOD.get());
        this.dropSelf(ModBlocks.CHARRED_WOOD_STAIRS.get());
        this.add(ModBlocks.CHARRED_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHARRED_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHARRED_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHARRED_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHARRED_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.CHARRED_PLANKS.get());
        this.dropSelf(ModBlocks.CHARRED_PLANKS_STAIRS.get());
        this.add(ModBlocks.CHARRED_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_PLANKS_SLAB.get()));
        this.add(ModBlocks.CHARRED_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CHARRED_BUTTON.get());
        this.dropSelf(ModBlocks.CHARRED_FENCE.get());
        this.dropSelf(ModBlocks.CHARRED_FENCE_GATE.get());
        this.add(ModBlocks.CHARRED_DOOR.get(),
                block -> createDoorTable(ModBlocks.CHARRED_DOOR.get()));
        this.dropSelf(ModBlocks.CHARRED_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CHARRED_PRESSURE_PLATE.get());
        this.add(ModBlocks.CHARRED_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHARRED_SIGN.get()));
        this.add(ModBlocks.CHARRED_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHARRED_SIGN.get()));
        this.add(ModBlocks.CHARRED_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHARRED_HANGING_SIGN.get()));
        this.add(ModBlocks.CHARRED_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHARRED_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.BEECH_LOG.get());
        this.dropSelf(ModBlocks.BEECH_LOG_STAIRS.get());
        this.add(ModBlocks.BEECH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.BEECH_BEAM.get());
        this.dropSelf(ModBlocks.BEECH_BEAM_STAIRS.get());
        this.add(ModBlocks.BEECH_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.BEECH_WOOD.get());
        this.dropSelf(ModBlocks.BEECH_WOOD_STAIRS.get());
        this.add(ModBlocks.BEECH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BEECH_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BEECH_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BEECH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BEECH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BEECH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BEECH_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BEECH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BEECH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.BEECH_PLANKS.get());
        this.dropSelf(ModBlocks.BEECH_PLANKS_STAIRS.get());
        this.add(ModBlocks.BEECH_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_PLANKS_SLAB.get()));
        this.add(ModBlocks.BEECH_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.BEECH_BUTTON.get());
        this.dropSelf(ModBlocks.BEECH_FENCE.get());
        this.dropSelf(ModBlocks.BEECH_FENCE_GATE.get());
        this.add(ModBlocks.BEECH_DOOR.get(),
                block -> createDoorTable(ModBlocks.BEECH_DOOR.get()));
        this.dropSelf(ModBlocks.BEECH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BEECH_PRESSURE_PLATE.get());
        this.add(ModBlocks.BEECH_LEAVES.get(), createLeavesDrops(ModBlocks.BEECH_LEAVES.get(), ModBlocks.BEECH_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.BEECH_SAPLING.get());
        this.add(ModBlocks.BEECH_SIGN.get(), block ->
                createSingleItemTable(ModItems.BEECH_SIGN.get()));
        this.add(ModBlocks.BEECH_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.BEECH_SIGN.get()));
        this.add(ModBlocks.BEECH_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BEECH_HANGING_SIGN.get()));
        this.add(ModBlocks.BEECH_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BEECH_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.BAOBAB_LOG.get());
        this.dropSelf(ModBlocks.BAOBAB_LOG_STAIRS.get());
        this.add(ModBlocks.BAOBAB_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.BAOBAB_BEAM.get());
        this.dropSelf(ModBlocks.BAOBAB_BEAM_STAIRS.get());
        this.add(ModBlocks.BAOBAB_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.BAOBAB_WOOD.get());
        this.dropSelf(ModBlocks.BAOBAB_WOOD_STAIRS.get());
        this.add(ModBlocks.BAOBAB_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BAOBAB_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BAOBAB_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BAOBAB_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BAOBAB_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.BAOBAB_PLANKS.get());
        this.dropSelf(ModBlocks.BAOBAB_PLANKS_STAIRS.get());
        this.add(ModBlocks.BAOBAB_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_PLANKS_SLAB.get()));
        this.add(ModBlocks.BAOBAB_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.BAOBAB_BUTTON.get());
        this.dropSelf(ModBlocks.BAOBAB_FENCE.get());
        this.dropSelf(ModBlocks.BAOBAB_FENCE_GATE.get());
        this.add(ModBlocks.BAOBAB_DOOR.get(),
                block -> createDoorTable(ModBlocks.BAOBAB_DOOR.get()));
        this.dropSelf(ModBlocks.BAOBAB_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
        this.add(ModBlocks.BAOBAB_LEAVES.get(), createLeavesDrops(ModBlocks.BAOBAB_LEAVES.get(), ModBlocks.BAOBAB_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.BAOBAB_SAPLING.get());
        this.add(ModBlocks.BAOBAB_SIGN.get(), block ->
                createSingleItemTable(ModItems.BAOBAB_SIGN.get()));
        this.add(ModBlocks.BAOBAB_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.BAOBAB_SIGN.get()));
        this.add(ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BAOBAB_HANGING_SIGN.get()));
        this.add(ModBlocks.BAOBAB_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BAOBAB_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.PINE_LOG.get());
        this.dropSelf(ModBlocks.PINE_LOG_STAIRS.get());
        this.add(ModBlocks.PINE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.PINE_BEAM.get());
        this.dropSelf(ModBlocks.PINE_BEAM_STAIRS.get());
        this.add(ModBlocks.PINE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.PINE_WOOD.get());
        this.dropSelf(ModBlocks.PINE_WOOD_STAIRS.get());
        this.add(ModBlocks.PINE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PINE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PINE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PINE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PINE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PINE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PINE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PINE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PINE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.PINE_PLANKS.get());
        this.dropSelf(ModBlocks.PINE_PLANKS_STAIRS.get());
        this.add(ModBlocks.PINE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_PLANKS_SLAB.get()));
        this.add(ModBlocks.PINE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.PINE_BUTTON.get());
        this.dropSelf(ModBlocks.PINE_FENCE.get());
        this.dropSelf(ModBlocks.PINE_FENCE_GATE.get());
        this.add(ModBlocks.PINE_DOOR.get(),
                block -> createDoorTable(ModBlocks.PINE_DOOR.get()));
        this.dropSelf(ModBlocks.PINE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PINE_PRESSURE_PLATE.get());
        this.add(ModBlocks.PINE_LEAVES.get(), createLeavesDrops(ModBlocks.PINE_LEAVES.get(), ModBlocks.PINE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.PINE_SAPLING.get());
        this.add(ModBlocks.PINE_SIGN.get(), block ->
                createSingleItemTable(ModItems.PINE_SIGN.get()));
        this.add(ModBlocks.PINE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PINE_SIGN.get()));
        this.add(ModBlocks.PINE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PINE_HANGING_SIGN.get()));
        this.add(ModBlocks.PINE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PINE_HANGING_SIGN.get()));


        this.dropSelf(ModBlocks.HOLLY_LOG.get());
        this.dropSelf(ModBlocks.HOLLY_LOG_STAIRS.get());
        this.add(ModBlocks.HOLLY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.HOLLY_BEAM.get());
        this.dropSelf(ModBlocks.HOLLY_BEAM_STAIRS.get());
        this.add(ModBlocks.HOLLY_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.HOLLY_WOOD.get());
        this.dropSelf(ModBlocks.HOLLY_WOOD_STAIRS.get());
        this.add(ModBlocks.HOLLY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_HOLLY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_HOLLY_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_HOLLY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_HOLLY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_HOLLY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HOLLY_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_HOLLY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_HOLLY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.HOLLY_PLANKS.get());
        this.dropSelf(ModBlocks.HOLLY_PLANKS_STAIRS.get());
        this.add(ModBlocks.HOLLY_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_PLANKS_SLAB.get()));
        this.add(ModBlocks.HOLLY_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.HOLLY_BUTTON.get());
        this.dropSelf(ModBlocks.HOLLY_FENCE.get());
        this.dropSelf(ModBlocks.HOLLY_FENCE_GATE.get());
        this.add(ModBlocks.HOLLY_DOOR.get(),
                block -> createDoorTable(ModBlocks.HOLLY_DOOR.get()));
        this.dropSelf(ModBlocks.HOLLY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.HOLLY_PRESSURE_PLATE.get());
        this.add(ModBlocks.HOLLY_LEAVES.get(), createLeavesDrops(ModBlocks.HOLLY_LEAVES.get(), ModBlocks.HOLLY_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.HOLLY_SAPLING.get());
        this.add(ModBlocks.HOLLY_SIGN.get(), block ->
                createSingleItemTable(ModItems.HOLLY_SIGN.get()));
        this.add(ModBlocks.HOLLY_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.HOLLY_SIGN.get()));
        this.add(ModBlocks.HOLLY_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HOLLY_HANGING_SIGN.get()));
        this.add(ModBlocks.HOLLY_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.HOLLY_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.GREEN_OAK_LOG.get());
        this.dropSelf(ModBlocks.GREEN_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.GREEN_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.GREEN_OAK_BEAM.get());
        this.dropSelf(ModBlocks.GREEN_OAK_BEAM_STAIRS.get());
        this.add(ModBlocks.GREEN_OAK_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.GREEN_OAK_WOOD.get());
        this.dropSelf(ModBlocks.GREEN_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.GREEN_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_GREEN_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GREEN_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_GREEN_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_GREEN_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_GREEN_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_GREEN_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_GREEN_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_GREEN_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.GREEN_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.GREEN_OAK_PLANKS_STAIRS.get());
        this.add(ModBlocks.GREEN_OAK_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_PLANKS_SLAB.get()));
        this.add(ModBlocks.GREEN_OAK_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.GREEN_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.GREEN_OAK_FENCE.get());
        this.dropSelf(ModBlocks.GREEN_OAK_FENCE_GATE.get());
        this.add(ModBlocks.GREEN_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.GREEN_OAK_DOOR.get()));
        this.dropSelf(ModBlocks.GREEN_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.GREEN_OAK_PRESSURE_PLATE.get());
        this.add(ModBlocks.GREEN_OAK_LEAVES.get(), createLeavesDrops(ModBlocks.GREEN_OAK_LEAVES.get(), ModBlocks.GREEN_OAK_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.GREEN_OAK_SAPLING.get());
        this.add(ModBlocks.GREEN_OAK_SIGN.get(), block ->
                createSingleItemTable(ModItems.GREEN_OAK_SIGN.get()));
        this.add(ModBlocks.GREEN_OAK_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.GREEN_OAK_SIGN.get()));
        this.add(ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.GREEN_OAK_HANGING_SIGN.get()));
        this.add(ModBlocks.GREEN_OAK_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.GREEN_OAK_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.RED_OAK_LOG.get());
        this.dropSelf(ModBlocks.RED_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.RED_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.RED_OAK_BEAM.get());
        this.dropSelf(ModBlocks.RED_OAK_BEAM_STAIRS.get());
        this.add(ModBlocks.RED_OAK_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.RED_OAK_WOOD.get());
        this.dropSelf(ModBlocks.RED_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.RED_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_RED_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_RED_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_RED_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_RED_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.RED_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.RED_OAK_PLANKS_STAIRS.get());
        this.add(ModBlocks.RED_OAK_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_PLANKS_SLAB.get()));
        this.add(ModBlocks.RED_OAK_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.RED_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.RED_OAK_FENCE.get());
        this.dropSelf(ModBlocks.RED_OAK_FENCE_GATE.get());
        this.add(ModBlocks.RED_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.RED_OAK_DOOR.get()));
        this.dropSelf(ModBlocks.RED_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RED_OAK_PRESSURE_PLATE.get());
        this.add(ModBlocks.RED_OAK_LEAVES.get(), createLeavesDrops(ModBlocks.RED_OAK_LEAVES.get(), ModBlocks.RED_OAK_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.RED_OAK_SAPLING.get());
        this.add(ModBlocks.RED_OAK_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_OAK_SIGN.get()));
        this.add(ModBlocks.RED_OAK_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_OAK_SIGN.get()));
        this.add(ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_OAK_HANGING_SIGN.get()));
        this.add(ModBlocks.RED_OAK_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_OAK_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.MIRK_OAK_LOG.get());
        this.dropSelf(ModBlocks.MIRK_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.MIRK_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.MIRK_OAK_BEAM.get());
        this.dropSelf(ModBlocks.MIRK_OAK_BEAM_STAIRS.get());
        this.add(ModBlocks.MIRK_OAK_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.MIRK_OAK_WOOD.get());
        this.dropSelf(ModBlocks.MIRK_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.MIRK_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MIRK_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MIRK_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MIRK_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MIRK_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MIRK_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MIRK_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MIRK_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MIRK_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.MIRK_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.MIRK_OAK_PLANKS_STAIRS.get());
        this.add(ModBlocks.MIRK_OAK_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_PLANKS_SLAB.get()));
        this.add(ModBlocks.MIRK_OAK_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.MIRK_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.MIRK_OAK_FENCE.get());
        this.dropSelf(ModBlocks.MIRK_OAK_FENCE_GATE.get());
        this.add(ModBlocks.MIRK_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.MIRK_OAK_DOOR.get()));
        this.dropSelf(ModBlocks.MIRK_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MIRK_OAK_PRESSURE_PLATE.get());
        this.add(ModBlocks.MIRK_OAK_LEAVES.get(), createLeavesDrops(ModBlocks.MIRK_OAK_LEAVES.get(), ModBlocks.MIRK_OAK_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MIRK_OAK_SAPLING.get());
        this.add(ModBlocks.MIRK_OAK_SIGN.get(), block ->
                createSingleItemTable(ModItems.MIRK_OAK_SIGN.get()));
        this.add(ModBlocks.MIRK_OAK_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.MIRK_OAK_SIGN.get()));
        this.add(ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MIRK_OAK_HANGING_SIGN.get()));
        this.add(ModBlocks.MIRK_OAK_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MIRK_OAK_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_LOG_STAIRS.get());
        this.add(ModBlocks.MAPLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.MAPLE_BEAM.get());
        this.dropSelf(ModBlocks.MAPLE_BEAM_STAIRS.get());
        this.add(ModBlocks.MAPLE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD_STAIRS.get());
        this.add(ModBlocks.MAPLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MAPLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MAPLE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MAPLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MAPLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.MAPLE_PLANKS_STAIRS.get());
        this.add(ModBlocks.MAPLE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_PLANKS_SLAB.get()));
        this.add(ModBlocks.MAPLE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE_GATE.get());
        this.add(ModBlocks.MAPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAPLE_DOOR.get()));
        this.dropSelf(ModBlocks.MAPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.add(ModBlocks.MAPLE_LEAVES.get(), createLeavesDrops(ModBlocks.MAPLE_LEAVES.get(), ModBlocks.MAPLE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MAPLE_SAPLING.get());
        this.add(ModBlocks.MAPLE_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAPLE_SIGN.get()));
        this.add(ModBlocks.MAPLE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAPLE_SIGN.get()));
        this.add(ModBlocks.MAPLE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAPLE_HANGING_SIGN.get()));
        this.add(ModBlocks.MAPLE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAPLE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.PALM_LOG.get());
        this.dropSelf(ModBlocks.PALM_LOG_STAIRS.get());
        this.add(ModBlocks.PALM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.PALM_BEAM.get());
        this.dropSelf(ModBlocks.PALM_BEAM_STAIRS.get());
        this.add(ModBlocks.PALM_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.PALM_WOOD.get());
        this.dropSelf(ModBlocks.PALM_WOOD_STAIRS.get());
        this.add(ModBlocks.PALM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PALM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PALM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_PALM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PALM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.PALM_PLANKS.get());
        this.dropSelf(ModBlocks.PALM_PLANKS_STAIRS.get());
        this.add(ModBlocks.PALM_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_PLANKS_SLAB.get()));
        this.add(ModBlocks.PALM_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.PALM_BUTTON.get());
        this.dropSelf(ModBlocks.PALM_FENCE.get());
        this.dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        this.add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));
        this.dropSelf(ModBlocks.PALM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        this.add(ModBlocks.PALM_LEAVES.get(), createLeavesDrops(ModBlocks.PALM_LEAVES.get(), ModBlocks.PALM_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.PALM_SAPLING.get());
        this.add(ModBlocks.PALM_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_SIGN.get()));
        this.add(ModBlocks.PALM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_SIGN.get()));
        this.add(ModBlocks.PALM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_HANGING_SIGN.get()));
        this.add(ModBlocks.PALM_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.CHESTNUT_LOG.get());
        this.dropSelf(ModBlocks.CHESTNUT_LOG_STAIRS.get());
        this.add(ModBlocks.CHESTNUT_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.CHESTNUT_BEAM.get());
        this.dropSelf(ModBlocks.CHESTNUT_BEAM_STAIRS.get());
        this.add(ModBlocks.CHESTNUT_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.CHESTNUT_WOOD.get());
        this.dropSelf(ModBlocks.CHESTNUT_WOOD_STAIRS.get());
        this.add(ModBlocks.CHESTNUT_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHESTNUT_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CHESTNUT_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHESTNUT_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHESTNUT_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHESTNUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHESTNUT_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHESTNUT_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHESTNUT_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.CHESTNUT_PLANKS.get());
        this.dropSelf(ModBlocks.CHESTNUT_PLANKS_STAIRS.get());
        this.add(ModBlocks.CHESTNUT_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_PLANKS_SLAB.get()));
        this.add(ModBlocks.CHESTNUT_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CHESTNUT_BUTTON.get());
        this.dropSelf(ModBlocks.CHESTNUT_FENCE.get());
        this.dropSelf(ModBlocks.CHESTNUT_FENCE_GATE.get());
        this.add(ModBlocks.CHESTNUT_DOOR.get(),
                block -> createDoorTable(ModBlocks.CHESTNUT_DOOR.get()));
        this.dropSelf(ModBlocks.CHESTNUT_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CHESTNUT_PRESSURE_PLATE.get());
        this.add(ModBlocks.CHESTNUT_LEAVES.get(), createFruitLeavesDrops(ModBlocks.CHESTNUT_LEAVES.get(), ModItems.CHESTNUT.get(), ModBlocks.CHESTNUT_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.CHESTNUT_SAPLING.get());
        this.add(ModBlocks.CHESTNUT_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHESTNUT_SIGN.get()));
        this.add(ModBlocks.CHESTNUT_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHESTNUT_SIGN.get()));
        this.add(ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHESTNUT_HANGING_SIGN.get()));
        this.add(ModBlocks.CHESTNUT_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CHESTNUT_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.ASPEN_LOG.get());
        this.dropSelf(ModBlocks.ASPEN_LOG_STAIRS.get());
        this.add(ModBlocks.ASPEN_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.ASPEN_BEAM.get());
        this.dropSelf(ModBlocks.ASPEN_BEAM_STAIRS.get());
        this.add(ModBlocks.ASPEN_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.ASPEN_WOOD_STAIRS.get());
        this.add(ModBlocks.ASPEN_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ASPEN_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ASPEN_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ASPEN_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ASPEN_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.ASPEN_PLANKS.get());
        this.dropSelf(ModBlocks.ASPEN_PLANKS_STAIRS.get());
        this.add(ModBlocks.ASPEN_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_PLANKS_SLAB.get()));
        this.add(ModBlocks.ASPEN_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.ASPEN_BUTTON.get());
        this.dropSelf(ModBlocks.ASPEN_FENCE.get());
        this.dropSelf(ModBlocks.ASPEN_FENCE_GATE.get());
        this.add(ModBlocks.ASPEN_DOOR.get(),
                block -> createDoorTable(ModBlocks.ASPEN_DOOR.get()));
        this.dropSelf(ModBlocks.ASPEN_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ASPEN_PRESSURE_PLATE.get());
        this.add(ModBlocks.ASPEN_LEAVES.get(), createLeavesDrops(ModBlocks.ASPEN_LEAVES.get(), ModBlocks.ASPEN_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.ASPEN_SAPLING.get());
        this.add(ModBlocks.ASPEN_SIGN.get(), block ->
                createSingleItemTable(ModItems.ASPEN_SIGN.get()));
        this.add(ModBlocks.ASPEN_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.ASPEN_SIGN.get()));
        this.add(ModBlocks.ASPEN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ASPEN_HANGING_SIGN.get()));
        this.add(ModBlocks.ASPEN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ASPEN_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.CEDAR_LOG.get());
        this.dropSelf(ModBlocks.CEDAR_LOG_STAIRS.get());
        this.add(ModBlocks.CEDAR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.CEDAR_BEAM.get());
        this.dropSelf(ModBlocks.CEDAR_BEAM_STAIRS.get());
        this.add(ModBlocks.CEDAR_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.CEDAR_WOOD.get());
        this.dropSelf(ModBlocks.CEDAR_WOOD_STAIRS.get());
        this.add(ModBlocks.CEDAR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CEDAR_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CEDAR_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CEDAR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CEDAR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CEDAR_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CEDAR_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CEDAR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CEDAR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.CEDAR_PLANKS.get());
        this.dropSelf(ModBlocks.CEDAR_PLANKS_STAIRS.get());
        this.add(ModBlocks.CEDAR_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_PLANKS_SLAB.get()));
        this.add(ModBlocks.CEDAR_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CEDAR_BUTTON.get());
        this.dropSelf(ModBlocks.CEDAR_FENCE.get());
        this.dropSelf(ModBlocks.CEDAR_FENCE_GATE.get());
        this.add(ModBlocks.CEDAR_DOOR.get(),
                block -> createDoorTable(ModBlocks.CEDAR_DOOR.get()));
        this.dropSelf(ModBlocks.CEDAR_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CEDAR_PRESSURE_PLATE.get());
        this.add(ModBlocks.CEDAR_LEAVES.get(), createLeavesDrops(ModBlocks.CEDAR_LEAVES.get(), ModBlocks.CEDAR_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.CEDAR_SAPLING.get());
        this.add(ModBlocks.CEDAR_SIGN.get(), block ->
                createSingleItemTable(ModItems.CEDAR_SIGN.get()));
        this.add(ModBlocks.CEDAR_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.CEDAR_SIGN.get()));
        this.add(ModBlocks.CEDAR_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CEDAR_HANGING_SIGN.get()));
        this.add(ModBlocks.CEDAR_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CEDAR_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.FIR_LOG.get());
        this.dropSelf(ModBlocks.FIR_LOG_STAIRS.get());
        this.add(ModBlocks.FIR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.FIR_BEAM.get());
        this.dropSelf(ModBlocks.FIR_BEAM_STAIRS.get());
        this.add(ModBlocks.FIR_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.FIR_WOOD.get());
        this.dropSelf(ModBlocks.FIR_WOOD_STAIRS.get());
        this.add(ModBlocks.FIR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_FIR_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_FIR_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_FIR_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_FIR_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_FIR_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_FIR_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_FIR_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_FIR_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.FIR_PLANKS.get());
        this.dropSelf(ModBlocks.FIR_PLANKS_STAIRS.get());
        this.add(ModBlocks.FIR_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_PLANKS_SLAB.get()));
        this.add(ModBlocks.FIR_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.FIR_BUTTON.get());
        this.dropSelf(ModBlocks.FIR_FENCE.get());
        this.dropSelf(ModBlocks.FIR_FENCE_GATE.get());
        this.add(ModBlocks.FIR_DOOR.get(),
                block -> createDoorTable(ModBlocks.FIR_DOOR.get()));
        this.dropSelf(ModBlocks.FIR_TRAPDOOR.get());
        this.dropSelf(ModBlocks.FIR_PRESSURE_PLATE.get());
        this.add(ModBlocks.FIR_LEAVES.get(), createLeavesDrops(ModBlocks.FIR_LEAVES.get(), ModBlocks.FIR_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.FIR_SAPLING.get());
        this.add(ModBlocks.FIR_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIR_SIGN.get()));
        this.add(ModBlocks.FIR_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIR_SIGN.get()));
        this.add(ModBlocks.FIR_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIR_HANGING_SIGN.get()));
        this.add(ModBlocks.FIR_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIR_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.LARCH_LOG.get());
        this.dropSelf(ModBlocks.LARCH_LOG_STAIRS.get());
        this.add(ModBlocks.LARCH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.LARCH_BEAM.get());
        this.dropSelf(ModBlocks.LARCH_BEAM_STAIRS.get());
        this.add(ModBlocks.LARCH_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.LARCH_WOOD.get());
        this.dropSelf(ModBlocks.LARCH_WOOD_STAIRS.get());
        this.add(ModBlocks.LARCH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LARCH_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LARCH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LARCH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LARCH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LARCH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LARCH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.LARCH_PLANKS.get());
        this.dropSelf(ModBlocks.LARCH_PLANKS_STAIRS.get());
        this.add(ModBlocks.LARCH_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_PLANKS_SLAB.get()));
        this.add(ModBlocks.LARCH_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.LARCH_BUTTON.get());
        this.dropSelf(ModBlocks.LARCH_FENCE.get());
        this.dropSelf(ModBlocks.LARCH_FENCE_GATE.get());
        this.add(ModBlocks.LARCH_DOOR.get(),
                block -> createDoorTable(ModBlocks.LARCH_DOOR.get()));
        this.dropSelf(ModBlocks.LARCH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LARCH_PRESSURE_PLATE.get());
        this.add(ModBlocks.LARCH_LEAVES.get(), createLeavesDrops(ModBlocks.LARCH_LEAVES.get(), ModBlocks.LARCH_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LARCH_SAPLING.get());
        this.add(ModBlocks.LARCH_SIGN.get(), block ->
                createSingleItemTable(ModItems.LARCH_SIGN.get()));
        this.add(ModBlocks.LARCH_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.LARCH_SIGN.get()));
        this.add(ModBlocks.LARCH_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LARCH_HANGING_SIGN.get()));
        this.add(ModBlocks.LARCH_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LARCH_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.LAIRELOSSE_LOG.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_LOG_STAIRS.get());
        this.add(ModBlocks.LAIRELOSSE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.LAIRELOSSE_BEAM.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_BEAM_STAIRS.get());
        this.add(ModBlocks.LAIRELOSSE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.LAIRELOSSE_WOOD.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_WOOD_STAIRS.get());
        this.add(ModBlocks.LAIRELOSSE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LAIRELOSSE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LAIRELOSSE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LAIRELOSSE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LAIRELOSSE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LAIRELOSSE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.LAIRELOSSE_PLANKS.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_PLANKS_STAIRS.get());
        this.add(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get()));
        this.add(ModBlocks.LAIRELOSSE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.LAIRELOSSE_BUTTON.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_FENCE.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_FENCE_GATE.get());
        this.add(ModBlocks.LAIRELOSSE_DOOR.get(),
                block -> createDoorTable(ModBlocks.LAIRELOSSE_DOOR.get()));
        this.dropSelf(ModBlocks.LAIRELOSSE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LAIRELOSSE_PRESSURE_PLATE.get());
        this.add(ModBlocks.LAIRELOSSE_LEAVES.get(), createLeavesDrops(ModBlocks.LAIRELOSSE_LEAVES.get(), ModBlocks.LAIRELOSSE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LAIRELOSSE_SAPLING.get());
        this.add(ModBlocks.LAIRELOSSE_SIGN.get(), block ->
                createSingleItemTable(ModItems.LAIRELOSSE_SIGN.get()));
        this.add(ModBlocks.LAIRELOSSE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.LAIRELOSSE_SIGN.get()));
        this.add(ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LAIRELOSSE_HANGING_SIGN.get()));
        this.add(ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LAIRELOSSE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.ALMOND_LOG.get());
        this.dropSelf(ModBlocks.ALMOND_LOG_STAIRS.get());
        this.add(ModBlocks.ALMOND_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.ALMOND_BEAM.get());
        this.dropSelf(ModBlocks.ALMOND_BEAM_STAIRS.get());
        this.add(ModBlocks.ALMOND_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.ALMOND_WOOD.get());
        this.dropSelf(ModBlocks.ALMOND_WOOD_STAIRS.get());
        this.add(ModBlocks.ALMOND_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ALMOND_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ALMOND_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ALMOND_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ALMOND_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ALMOND_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ALMOND_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ALMOND_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ALMOND_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.ALMOND_PLANKS.get());
        this.dropSelf(ModBlocks.ALMOND_PLANKS_STAIRS.get());
        this.add(ModBlocks.ALMOND_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_PLANKS_SLAB.get()));
        this.add(ModBlocks.ALMOND_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.ALMOND_BUTTON.get());
        this.dropSelf(ModBlocks.ALMOND_FENCE.get());
        this.dropSelf(ModBlocks.ALMOND_FENCE_GATE.get());
        this.add(ModBlocks.ALMOND_DOOR.get(),
                block -> createDoorTable(ModBlocks.ALMOND_DOOR.get()));
        this.dropSelf(ModBlocks.ALMOND_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ALMOND_PRESSURE_PLATE.get());
        this.add(ModBlocks.ALMOND_LEAVES.get(), createFruitLeavesDrops(ModBlocks.ALMOND_LEAVES.get(), ModItems.ALMOND.get(), ModBlocks.ALMOND_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.ALMOND_SAPLING.get());
        this.add(ModBlocks.ALMOND_SIGN.get(), block ->
                createSingleItemTable(ModItems.ALMOND_SIGN.get()));
        this.add(ModBlocks.ALMOND_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.ALMOND_SIGN.get()));
        this.add(ModBlocks.ALMOND_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ALMOND_HANGING_SIGN.get()));
        this.add(ModBlocks.ALMOND_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ALMOND_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.BANANA_LOG.get());
        this.dropSelf(ModBlocks.BANANA_LOG_STAIRS.get());
        this.add(ModBlocks.BANANA_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.BANANA_BEAM.get());
        this.dropSelf(ModBlocks.BANANA_BEAM_STAIRS.get());
        this.add(ModBlocks.BANANA_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.BANANA_WOOD.get());
        this.dropSelf(ModBlocks.BANANA_WOOD_STAIRS.get());
        this.add(ModBlocks.BANANA_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BANANA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BANANA_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BANANA_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BANANA_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BANANA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BANANA_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BANANA_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BANANA_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.BANANA_PLANKS.get());
        this.dropSelf(ModBlocks.BANANA_PLANKS_STAIRS.get());
        this.add(ModBlocks.BANANA_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_PLANKS_SLAB.get()));
        this.add(ModBlocks.BANANA_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.BANANA_BUTTON.get());
        this.dropSelf(ModBlocks.BANANA_FENCE.get());
        this.dropSelf(ModBlocks.BANANA_FENCE_GATE.get());
        this.add(ModBlocks.BANANA_DOOR.get(),
                block -> createDoorTable(ModBlocks.BANANA_DOOR.get()));
        this.dropSelf(ModBlocks.BANANA_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BANANA_PRESSURE_PLATE.get());
        this.add(ModBlocks.BANANA_LEAVES.get(), createLeavesDrops(ModBlocks.BANANA_LEAVES.get(), ModBlocks.BANANA_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.BANANA_SAPLING.get());
        this.add(ModBlocks.BANANA_SIGN.get(), block ->
                createSingleItemTable(ModItems.BANANA_SIGN.get()));
        this.add(ModBlocks.BANANA_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.BANANA_SIGN.get()));
        this.add(ModBlocks.BANANA_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BANANA_HANGING_SIGN.get()));
        this.add(ModBlocks.BANANA_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BANANA_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.CYPRESS_LOG.get());
        this.dropSelf(ModBlocks.CYPRESS_LOG_STAIRS.get());
        this.add(ModBlocks.CYPRESS_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.CYPRESS_BEAM.get());
        this.dropSelf(ModBlocks.CYPRESS_BEAM_STAIRS.get());
        this.add(ModBlocks.CYPRESS_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.CYPRESS_WOOD.get());
        this.dropSelf(ModBlocks.CYPRESS_WOOD_STAIRS.get());
        this.add(ModBlocks.CYPRESS_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CYPRESS_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CYPRESS_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CYPRESS_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CYPRESS_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CYPRESS_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CYPRESS_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CYPRESS_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.CYPRESS_PLANKS.get());
        this.dropSelf(ModBlocks.CYPRESS_PLANKS_STAIRS.get());
        this.add(ModBlocks.CYPRESS_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_PLANKS_SLAB.get()));
        this.add(ModBlocks.CYPRESS_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.CYPRESS_BUTTON.get());
        this.dropSelf(ModBlocks.CYPRESS_FENCE.get());
        this.dropSelf(ModBlocks.CYPRESS_FENCE_GATE.get());
        this.add(ModBlocks.CYPRESS_DOOR.get(),
                block -> createDoorTable(ModBlocks.CYPRESS_DOOR.get()));
        this.dropSelf(ModBlocks.CYPRESS_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CYPRESS_PRESSURE_PLATE.get());
        this.add(ModBlocks.CYPRESS_LEAVES.get(), createLeavesDrops(ModBlocks.CYPRESS_LEAVES.get(), ModBlocks.CYPRESS_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.CYPRESS_SAPLING.get());
        this.add(ModBlocks.CYPRESS_SIGN.get(), block ->
                createSingleItemTable(ModItems.CYPRESS_SIGN.get()));
        this.add(ModBlocks.CYPRESS_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.CYPRESS_SIGN.get()));
        this.add(ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CYPRESS_HANGING_SIGN.get()));
        this.add(ModBlocks.CYPRESS_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CYPRESS_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.DATE_PALM_LOG.get());
        this.dropSelf(ModBlocks.DATE_PALM_LOG_STAIRS.get());
        this.add(ModBlocks.DATE_PALM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.DATE_PALM_BEAM.get());
        this.dropSelf(ModBlocks.DATE_PALM_BEAM_STAIRS.get());
        this.add(ModBlocks.DATE_PALM_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.DATE_PALM_WOOD.get());
        this.dropSelf(ModBlocks.DATE_PALM_WOOD_STAIRS.get());
        this.add(ModBlocks.DATE_PALM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_DATE_PALM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DATE_PALM_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_DATE_PALM_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DATE_PALM_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_DATE_PALM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DATE_PALM_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_DATE_PALM_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DATE_PALM_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.DATE_PALM_PLANKS.get());
        this.dropSelf(ModBlocks.DATE_PALM_PLANKS_STAIRS.get());
        this.add(ModBlocks.DATE_PALM_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_PLANKS_SLAB.get()));
        this.add(ModBlocks.DATE_PALM_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.DATE_PALM_BUTTON.get());
        this.dropSelf(ModBlocks.DATE_PALM_FENCE.get());
        this.dropSelf(ModBlocks.DATE_PALM_FENCE_GATE.get());
        this.add(ModBlocks.DATE_PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.DATE_PALM_DOOR.get()));
        this.dropSelf(ModBlocks.DATE_PALM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DATE_PALM_PRESSURE_PLATE.get());
        this.add(ModBlocks.DATE_PALM_LEAVES.get(), createLeavesDrops(ModBlocks.DATE_PALM_LEAVES.get(), ModBlocks.DATE_PALM_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.DATE_PALM_SAPLING.get());
        this.add(ModBlocks.DATE_PALM_SIGN.get(), block ->
                createSingleItemTable(ModItems.DATE_PALM_SIGN.get()));
        this.add(ModBlocks.DATE_PALM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.DATE_PALM_SIGN.get()));
        this.add(ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.DATE_PALM_HANGING_SIGN.get()));
        this.add(ModBlocks.DATE_PALM_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.DATE_PALM_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.KUNTZ_LOG.get());
        this.dropSelf(ModBlocks.KUNTZ_LOG_STAIRS.get());
        this.add(ModBlocks.KUNTZ_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.KUNTZ_BEAM.get());
        this.dropSelf(ModBlocks.KUNTZ_BEAM_STAIRS.get());
        this.add(ModBlocks.KUNTZ_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.KUNTZ_WOOD.get());
        this.dropSelf(ModBlocks.KUNTZ_WOOD_STAIRS.get());
        this.add(ModBlocks.KUNTZ_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_KUNTZ_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_KUNTZ_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_KUNTZ_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_KUNTZ_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_KUNTZ_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_KUNTZ_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_KUNTZ_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_KUNTZ_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.KUNTZ_PLANKS.get());
        this.dropSelf(ModBlocks.KUNTZ_PLANKS_STAIRS.get());
        this.add(ModBlocks.KUNTZ_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_PLANKS_SLAB.get()));
        this.add(ModBlocks.KUNTZ_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.KUNTZ_BUTTON.get());
        this.dropSelf(ModBlocks.KUNTZ_FENCE.get());
        this.dropSelf(ModBlocks.KUNTZ_FENCE_GATE.get());
        this.add(ModBlocks.KUNTZ_DOOR.get(),
                block -> createDoorTable(ModBlocks.KUNTZ_DOOR.get()));
        this.dropSelf(ModBlocks.KUNTZ_TRAPDOOR.get());
        this.dropSelf(ModBlocks.KUNTZ_PRESSURE_PLATE.get());
        this.add(ModBlocks.KUNTZ_LEAVES.get(), createLeavesDrops(ModBlocks.KUNTZ_LEAVES.get(), ModBlocks.KUNTZ_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.KUNTZ_SAPLING.get());
        this.add(ModBlocks.KUNTZ_SIGN.get(), block ->
                createSingleItemTable(ModItems.KUNTZ_SIGN.get()));
        this.add(ModBlocks.KUNTZ_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.KUNTZ_SIGN.get()));
        this.add(ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.KUNTZ_HANGING_SIGN.get()));
        this.add(ModBlocks.KUNTZ_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.KUNTZ_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.LEBETHRON_LOG.get());
        this.dropSelf(ModBlocks.LEBETHRON_LOG_STAIRS.get());
        this.add(ModBlocks.LEBETHRON_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.LEBETHRON_BEAM.get());
        this.dropSelf(ModBlocks.LEBETHRON_BEAM_STAIRS.get());
        this.add(ModBlocks.LEBETHRON_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.LEBETHRON_WOOD.get());
        this.dropSelf(ModBlocks.LEBETHRON_WOOD_STAIRS.get());
        this.add(ModBlocks.LEBETHRON_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LEBETHRON_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LEBETHRON_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LEBETHRON_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEBETHRON_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LEBETHRON_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LEBETHRON_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LEBETHRON_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEBETHRON_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.LEBETHRON_PLANKS.get());
        this.dropSelf(ModBlocks.LEBETHRON_PLANKS_STAIRS.get());
        this.add(ModBlocks.LEBETHRON_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_PLANKS_SLAB.get()));
        this.add(ModBlocks.LEBETHRON_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.LEBETHRON_BUTTON.get());
        this.dropSelf(ModBlocks.LEBETHRON_FENCE.get());
        this.dropSelf(ModBlocks.LEBETHRON_FENCE_GATE.get());
        this.add(ModBlocks.LEBETHRON_DOOR.get(),
                block -> createDoorTable(ModBlocks.LEBETHRON_DOOR.get()));
        this.dropSelf(ModBlocks.LEBETHRON_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LEBETHRON_PRESSURE_PLATE.get());
        this.add(ModBlocks.LEBETHRON_LEAVES.get(), createLeavesDrops(ModBlocks.LEBETHRON_LEAVES.get(), ModBlocks.LEBETHRON_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LEBETHRON_SAPLING.get());
        this.add(ModBlocks.LEBETHRON_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEBETHRON_SIGN.get()));
        this.add(ModBlocks.LEBETHRON_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEBETHRON_SIGN.get()));
        this.add(ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEBETHRON_HANGING_SIGN.get()));
        this.add(ModBlocks.LEBETHRON_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEBETHRON_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.LEMON_LOG.get());
        this.dropSelf(ModBlocks.LEMON_LOG_STAIRS.get());
        this.add(ModBlocks.LEMON_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.LEMON_BEAM.get());
        this.dropSelf(ModBlocks.LEMON_BEAM_STAIRS.get());
        this.add(ModBlocks.LEMON_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.LEMON_WOOD.get());
        this.dropSelf(ModBlocks.LEMON_WOOD_STAIRS.get());
        this.add(ModBlocks.LEMON_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LEMON_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LEMON_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LEMON_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEMON_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LEMON_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LEMON_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LEMON_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEMON_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.LEMON_PLANKS.get());
        this.dropSelf(ModBlocks.LEMON_PLANKS_STAIRS.get());
        this.add(ModBlocks.LEMON_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_PLANKS_SLAB.get()));
        this.add(ModBlocks.LEMON_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.LEMON_BUTTON.get());
        this.dropSelf(ModBlocks.LEMON_FENCE.get());
        this.dropSelf(ModBlocks.LEMON_FENCE_GATE.get());
        this.add(ModBlocks.LEMON_DOOR.get(),
                block -> createDoorTable(ModBlocks.LEMON_DOOR.get()));
        this.dropSelf(ModBlocks.LEMON_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LEMON_PRESSURE_PLATE.get());
        this.add(ModBlocks.LEMON_LEAVES.get(), createFruitLeavesDrops(ModBlocks.LEMON_LEAVES.get(), ModItems.LEMON.get(), ModBlocks.LEMON_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LEMON_SAPLING.get());
        this.add(ModBlocks.LEMON_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEMON_SIGN.get()));
        this.add(ModBlocks.LEMON_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEMON_SIGN.get()));
        this.add(ModBlocks.LEMON_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEMON_HANGING_SIGN.get()));
        this.add(ModBlocks.LEMON_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LEMON_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.LIME_LOG.get());
        this.dropSelf(ModBlocks.LIME_LOG_STAIRS.get());
        this.add(ModBlocks.LIME_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.LIME_BEAM.get());
        this.dropSelf(ModBlocks.LIME_BEAM_STAIRS.get());
        this.add(ModBlocks.LIME_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.LIME_WOOD.get());
        this.dropSelf(ModBlocks.LIME_WOOD_STAIRS.get());
        this.add(ModBlocks.LIME_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LIME_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LIME_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LIME_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LIME_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_LIME_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LIME_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_LIME_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LIME_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.LIME_PLANKS.get());
        this.dropSelf(ModBlocks.LIME_PLANKS_STAIRS.get());
        this.add(ModBlocks.LIME_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_PLANKS_SLAB.get()));
        this.add(ModBlocks.LIME_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.LIME_BUTTON.get());
        this.dropSelf(ModBlocks.LIME_FENCE.get());
        this.dropSelf(ModBlocks.LIME_FENCE_GATE.get());
        this.add(ModBlocks.LIME_DOOR.get(),
                block -> createDoorTable(ModBlocks.LIME_DOOR.get()));
        this.dropSelf(ModBlocks.LIME_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LIME_PRESSURE_PLATE.get());
        this.add(ModBlocks.LIME_LEAVES.get(), createFruitLeavesDrops(ModBlocks.LIME_LEAVES.get(), ModItems.LIME.get(), ModBlocks.LIME_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LIME_SAPLING.get());
        this.add(ModBlocks.LIME_SIGN.get(), block ->
                createSingleItemTable(ModItems.LIME_SIGN.get()));
        this.add(ModBlocks.LIME_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.LIME_SIGN.get()));
        this.add(ModBlocks.LIME_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LIME_HANGING_SIGN.get()));
        this.add(ModBlocks.LIME_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.LIME_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.MANGO_LOG.get());
        this.dropSelf(ModBlocks.MANGO_LOG_STAIRS.get());
        this.add(ModBlocks.MANGO_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.MANGO_BEAM.get());
        this.dropSelf(ModBlocks.MANGO_BEAM_STAIRS.get());
        this.add(ModBlocks.MANGO_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.MANGO_WOOD.get());
        this.dropSelf(ModBlocks.MANGO_WOOD_STAIRS.get());
        this.add(ModBlocks.MANGO_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MANGO_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGO_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MANGO_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGO_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MANGO_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGO_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MANGO_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGO_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.MANGO_PLANKS.get());
        this.dropSelf(ModBlocks.MANGO_PLANKS_STAIRS.get());
        this.add(ModBlocks.MANGO_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_PLANKS_SLAB.get()));
        this.add(ModBlocks.MANGO_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.MANGO_BUTTON.get());
        this.dropSelf(ModBlocks.MANGO_FENCE.get());
        this.dropSelf(ModBlocks.MANGO_FENCE_GATE.get());
        this.add(ModBlocks.MANGO_DOOR.get(),
                block -> createDoorTable(ModBlocks.MANGO_DOOR.get()));
        this.dropSelf(ModBlocks.MANGO_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MANGO_PRESSURE_PLATE.get());
        this.add(ModBlocks.MANGO_LEAVES.get(), createFruitLeavesDrops(ModBlocks.MANGO_LEAVES.get(), ModItems.MANGO.get(), ModBlocks.MANGO_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MANGO_SAPLING.get());
        this.add(ModBlocks.MANGO_SIGN.get(), block ->
                createSingleItemTable(ModItems.MANGO_SIGN.get()));
        this.add(ModBlocks.MANGO_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.MANGO_SIGN.get()));
        this.add(ModBlocks.MANGO_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MANGO_HANGING_SIGN.get()));
        this.add(ModBlocks.MANGO_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MANGO_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.ORANGE_LOG.get());
        this.dropSelf(ModBlocks.ORANGE_LOG_STAIRS.get());
        this.add(ModBlocks.ORANGE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.ORANGE_BEAM.get());
        this.dropSelf(ModBlocks.ORANGE_BEAM_STAIRS.get());
        this.add(ModBlocks.ORANGE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.ORANGE_WOOD.get());
        this.dropSelf(ModBlocks.ORANGE_WOOD_STAIRS.get());
        this.add(ModBlocks.ORANGE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ORANGE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ORANGE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ORANGE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ORANGE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.ORANGE_PLANKS.get());
        this.dropSelf(ModBlocks.ORANGE_PLANKS_STAIRS.get());
        this.add(ModBlocks.ORANGE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_PLANKS_SLAB.get()));
        this.add(ModBlocks.ORANGE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.ORANGE_BUTTON.get());
        this.dropSelf(ModBlocks.ORANGE_FENCE.get());
        this.dropSelf(ModBlocks.ORANGE_FENCE_GATE.get());
        this.add(ModBlocks.ORANGE_DOOR.get(),
                block -> createDoorTable(ModBlocks.ORANGE_DOOR.get()));
        this.dropSelf(ModBlocks.ORANGE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ORANGE_PRESSURE_PLATE.get());
        this.add(ModBlocks.ORANGE_LEAVES.get(), createFruitLeavesDrops(ModBlocks.ORANGE_LEAVES.get(), ModItems.ORANGE.get(), ModBlocks.ORANGE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.ORANGE_SAPLING.get());
        this.add(ModBlocks.ORANGE_SIGN.get(), block ->
                createSingleItemTable(ModItems.ORANGE_SIGN.get()));
        this.add(ModBlocks.ORANGE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.ORANGE_SIGN.get()));
        this.add(ModBlocks.ORANGE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ORANGE_HANGING_SIGN.get()));
        this.add(ModBlocks.ORANGE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.ORANGE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.POMEGRANATE_LOG.get());
        this.dropSelf(ModBlocks.POMEGRANATE_LOG_STAIRS.get());
        this.add(ModBlocks.POMEGRANATE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.POMEGRANATE_BEAM.get());
        this.dropSelf(ModBlocks.POMEGRANATE_BEAM_STAIRS.get());
        this.add(ModBlocks.POMEGRANATE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.POMEGRANATE_WOOD.get());
        this.dropSelf(ModBlocks.POMEGRANATE_WOOD_STAIRS.get());
        this.add(ModBlocks.POMEGRANATE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_POMEGRANATE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_POMEGRANATE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_POMEGRANATE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_POMEGRANATE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_POMEGRANATE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.POMEGRANATE_PLANKS.get());
        this.dropSelf(ModBlocks.POMEGRANATE_PLANKS_STAIRS.get());
        this.add(ModBlocks.POMEGRANATE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_PLANKS_SLAB.get()));
        this.add(ModBlocks.POMEGRANATE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.POMEGRANATE_BUTTON.get());
        this.dropSelf(ModBlocks.POMEGRANATE_FENCE.get());
        this.dropSelf(ModBlocks.POMEGRANATE_FENCE_GATE.get());
        this.add(ModBlocks.POMEGRANATE_DOOR.get(),
                block -> createDoorTable(ModBlocks.POMEGRANATE_DOOR.get()));
        this.dropSelf(ModBlocks.POMEGRANATE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.POMEGRANATE_PRESSURE_PLATE.get());
        this.add(ModBlocks.POMEGRANATE_LEAVES.get(), createFruitLeavesDrops(ModBlocks.POMEGRANATE_LEAVES.get(), ModItems.POMEGRANATE.get(), ModBlocks.POMEGRANATE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.POMEGRANATE_SAPLING.get());
        this.add(ModBlocks.POMEGRANATE_SIGN.get(), block ->
                createSingleItemTable(ModItems.POMEGRANATE_SIGN.get()));
        this.add(ModBlocks.POMEGRANATE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.POMEGRANATE_SIGN.get()));
        this.add(ModBlocks.POMEGRANATE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.POMEGRANATE_HANGING_SIGN.get()));
        this.add(ModBlocks.POMEGRANATE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.POMEGRANATE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.REDWOOD_LOG.get());
        this.dropSelf(ModBlocks.REDWOOD_LOG_STAIRS.get());
        this.add(ModBlocks.REDWOOD_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.REDWOOD_BEAM.get());
        this.dropSelf(ModBlocks.REDWOOD_BEAM_STAIRS.get());
        this.add(ModBlocks.REDWOOD_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.REDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.REDWOOD_WOOD_STAIRS.get());
        this.add(ModBlocks.REDWOOD_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_REDWOOD_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_REDWOOD_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_REDWOOD_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_REDWOOD_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.REDWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.REDWOOD_PLANKS_STAIRS.get());
        this.add(ModBlocks.REDWOOD_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_PLANKS_SLAB.get()));
        this.add(ModBlocks.REDWOOD_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.REDWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.REDWOOD_FENCE.get());
        this.dropSelf(ModBlocks.REDWOOD_FENCE_GATE.get());
        this.add(ModBlocks.REDWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.REDWOOD_DOOR.get()));
        this.dropSelf(ModBlocks.REDWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
        this.add(ModBlocks.REDWOOD_LEAVES.get(), createLeavesDrops(ModBlocks.REDWOOD_LEAVES.get(), ModBlocks.REDWOOD_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.REDWOOD_SAPLING.get());
        this.add(ModBlocks.REDWOOD_SIGN.get(), block ->
                createSingleItemTable(ModItems.REDWOOD_SIGN.get()));
        this.add(ModBlocks.REDWOOD_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.REDWOOD_SIGN.get()));
        this.add(ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.REDWOOD_HANGING_SIGN.get()));
        this.add(ModBlocks.REDWOOD_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.REDWOOD_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.RED_MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_LOG_STAIRS.get());
        this.add(ModBlocks.RED_MAHOGANY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.RED_MAHOGANY_BEAM.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_BEAM_STAIRS.get());
        this.add(ModBlocks.RED_MAHOGANY_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.RED_MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_WOOD_STAIRS.get());
        this.add(ModBlocks.RED_MAHOGANY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_RED_MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.RED_MAHOGANY_PLANKS.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_PLANKS_STAIRS.get());
        this.add(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get()));
        this.add(ModBlocks.RED_MAHOGANY_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.RED_MAHOGANY_BUTTON.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_FENCE.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_FENCE_GATE.get());
        this.add(ModBlocks.RED_MAHOGANY_DOOR.get(),
                block -> createDoorTable(ModBlocks.RED_MAHOGANY_DOOR.get()));
        this.dropSelf(ModBlocks.RED_MAHOGANY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RED_MAHOGANY_PRESSURE_PLATE.get());
        this.add(ModBlocks.RED_MAHOGANY_LEAVES.get(), createLeavesDrops(ModBlocks.RED_MAHOGANY_LEAVES.get(), ModBlocks.RED_MAHOGANY_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.RED_MAHOGANY_SAPLING.get());
        this.add(ModBlocks.RED_MAHOGANY_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAHOGANY_SIGN.get()));
        this.add(ModBlocks.RED_MAHOGANY_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAHOGANY_SIGN.get()));
        this.add(ModBlocks.RED_MAHOGANY_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAHOGANY_HANGING_SIGN.get()));
        this.add(ModBlocks.RED_MAHOGANY_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAHOGANY_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.OLIVE_LOG.get());
        this.dropSelf(ModBlocks.OLIVE_LOG_STAIRS.get());
        this.add(ModBlocks.OLIVE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.OLIVE_BEAM.get());
        this.dropSelf(ModBlocks.OLIVE_BEAM_STAIRS.get());
        this.add(ModBlocks.OLIVE_BEAM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_BEAM_SLAB.get()));
        this.dropSelf(ModBlocks.OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.OLIVE_WOOD_STAIRS.get());
        this.add(ModBlocks.OLIVE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_OLIVE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OLIVE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_OLIVE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OLIVE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.OLIVE_PLANKS.get());
        this.dropSelf(ModBlocks.OLIVE_PLANKS_STAIRS.get());
        this.add(ModBlocks.OLIVE_PLANKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_PLANKS_SLAB.get()));
        this.add(ModBlocks.OLIVE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_PLANKS_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.OLIVE_BUTTON.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE_GATE.get());
        this.add(ModBlocks.OLIVE_DOOR.get(),
                block -> createDoorTable(ModBlocks.OLIVE_DOOR.get()));
        this.dropSelf(ModBlocks.OLIVE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.OLIVE_PRESSURE_PLATE.get());
        this.add(ModBlocks.OLIVE_LEAVES.get(), createFruitLeavesDrops(ModBlocks.OLIVE_LEAVES.get(), ModItems.OLIVE.get(), ModBlocks.OLIVE_SAPLING.get(), HIGH_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.OLIVE_SAPLING.get());
        this.add(ModBlocks.OLIVE_SIGN.get(), block ->
                createSingleItemTable(ModItems.OLIVE_SIGN.get()));
        this.add(ModBlocks.OLIVE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.OLIVE_SIGN.get()));
        this.add(ModBlocks.OLIVE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.OLIVE_HANGING_SIGN.get()));
        this.add(ModBlocks.OLIVE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.OLIVE_HANGING_SIGN.get()));
        
        /* ORES */
        this.add(ModBlocks.AMBER_ORE.get(),
                block -> createOreDrop(ModBlocks.AMBER_ORE.get(), ModItems.RAW_AMBER.get()));
        this.add(ModBlocks.DEEPSLATE_AMBER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_AMBER_ORE.get(), ModItems.RAW_AMBER.get()));
        this.dropSelf(ModBlocks.AMBER_BLOCK.get());
        this.add(ModBlocks.AMETHYST_ORE.get(),
                block -> createOreDrop(ModBlocks.AMETHYST_ORE.get(), ModItems.RAW_AMETHYST.get()));
        this.add(ModBlocks.DEEPSLATE_AMETHYST_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_AMETHYST_ORE.get(), ModItems.RAW_AMETHYST.get()));
        this.dropSelf(ModBlocks.AMETHYST_BLOCK.get());
        this.add(ModBlocks.DIAMOND_ORE.get(),
                block -> createOreDrop(ModBlocks.DIAMOND_ORE.get(), ModItems.RAW_DIAMOND.get()));
        this.add(ModBlocks.DEEPSLATE_DIAMOND_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_DIAMOND_ORE.get(), ModItems.RAW_DIAMOND.get()));
        this.dropSelf(ModBlocks.DIAMOND_BLOCK.get());
        this.add(ModBlocks.EMERALD_ORE.get(),
                block -> createOreDrop(ModBlocks.EMERALD_ORE.get(), ModItems.RAW_EMERALD.get()));
        this.add(ModBlocks.DEEPSLATE_EMERALD_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_EMERALD_ORE.get(), ModItems.RAW_EMERALD.get()));
        this.dropSelf(ModBlocks.EMERALD_BLOCK.get());
        this.add(ModBlocks.OPAL_ORE.get(),
                block -> createOreDrop(ModBlocks.OPAL_ORE.get(), ModItems.RAW_OPAL.get()));
        this.add(ModBlocks.DEEPSLATE_OPAL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_OPAL_ORE.get(), ModItems.RAW_OPAL.get()));
        this.dropSelf(ModBlocks.OPAL_BLOCK.get());
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.add(ModBlocks.TOPAZ_ORE.get(),
                block -> createOreDrop(ModBlocks.TOPAZ_ORE.get(), ModItems.RAW_TOPAZ.get()));
        this.add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), ModItems.RAW_TOPAZ.get()));
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));
        this.dropSelf(ModBlocks.MITHRIL_BLOCK.get());
        this.add(ModBlocks.SALT_ORE.get(),
                block -> createOreDrop(ModBlocks.SALT_ORE.get(), ModItems.RAW_SALT.get()));
        this.add(ModBlocks.DEEPSLATE_SALT_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SALT_ORE.get(), ModItems.RAW_SALT.get()));
        this.dropSelf(ModBlocks.SALT_BLOCK.get());
        this.add(ModBlocks.SALTPETER_ORE.get(),
                block -> createOreDrop(ModBlocks.SALTPETER_ORE.get(), ModItems.RAW_SALTPETER.get()));
        this.add(ModBlocks.DEEPSLATE_SALTPETER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SALTPETER_ORE.get(), ModItems.RAW_SALTPETER.get()));
        this.dropSelf(ModBlocks.SALTPETER_BLOCK.get());
        this.add(ModBlocks.SULFUR_ORE.get(),
                block -> createOreDrop(ModBlocks.SULFUR_ORE.get(), ModItems.RAW_SULFUR.get()));
        this.add(ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SULFUR_ORE.get(), ModItems.RAW_SULFUR.get()));
        this.dropSelf(ModBlocks.SULFUR_BLOCK.get());
        this.add(ModBlocks.GLOWSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.GLOWSTONE_ORE.get(), Items.GLOWSTONE_DUST));
        this.add(ModBlocks.DEEPSLATE_GLOWSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SALTPETER_ORE.get(), Items.GLOWSTONE_DUST));
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());

        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));
        this.dropSelf(ModBlocks.MITHRIL_BLOCK.get());

        this.dropSelf(ModBlocks.THATCH_BLOCK.get());
        this.dropSelf(ModBlocks.THATCH_BLOCK_STAIRS.get());
        this.add(ModBlocks.THATCH_BLOCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.THATCH_BLOCK_SLAB.get()));
        this.add(ModBlocks.THATCH_BLOCK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.THATCH_BLOCK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.THATCH_MUSTY_BLOCK.get());
        this.dropSelf(ModBlocks.THATCH_MUSTY_BLOCK_STAIRS.get());
        this.add(ModBlocks.THATCH_MUSTY_BLOCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.THATCH_MUSTY_BLOCK_SLAB.get()));
        this.add(ModBlocks.THATCH_MUSTY_BLOCK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.THATCH_MUSTY_BLOCK_VERTICAL_SLAB.get()));
        this.dropSelf(ModBlocks.REED_BLOCK.get());
        this.dropSelf(ModBlocks.REED_BLOCK_STAIRS.get());
        this.add(ModBlocks.REED_BLOCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REED_BLOCK_SLAB.get()));
        this.add(ModBlocks.REED_BLOCK_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REED_BLOCK_VERTICAL_SLAB.get()));


        this.add(ModBlocks.WHITE_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_WOOL_SLAB.get()));
        this.add(ModBlocks.ORANGE_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_WOOL_SLAB.get()));
        this.add(ModBlocks.MAGENTA_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGENTA_WOOL_SLAB.get()));
        this.add(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get()));
        this.add(ModBlocks.YELLOW_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YELLOW_WOOL_SLAB.get()));
        this.add(ModBlocks.LIME_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_WOOL_SLAB.get()));
        this.add(ModBlocks.PINK_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINK_WOOL_SLAB.get()));
        this.add(ModBlocks.GRAY_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GRAY_WOOL_SLAB.get()));
        this.add(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get()));
        this.add(ModBlocks.CYAN_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYAN_WOOL_SLAB.get()));
        this.add(ModBlocks.PURPLE_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PURPLE_WOOL_SLAB.get()));
        this.add(ModBlocks.BLUE_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUE_WOOL_SLAB.get()));
        this.add(ModBlocks.BROWN_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BROWN_WOOL_SLAB.get()));
        this.add(ModBlocks.GREEN_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_WOOL_SLAB.get()));
        this.add(ModBlocks.RED_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_WOOL_SLAB.get()));
        this.add(ModBlocks.BLACK_WOOL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLACK_WOOL_SLAB.get()));


        this.add(ModBlocks.WHITE_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ORANGE_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.YELLOW_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YELLOW_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIME_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PINK_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINK_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GRAY_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GRAY_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CYAN_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYAN_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PURPLE_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PURPLE_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BLUE_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUE_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BROWN_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BROWN_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GREEN_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_WOOL_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BLACK_WOOL_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLACK_WOOL_VERTICAL_SLAB.get()));

        this.dropSelf(ModBlocks.WHITE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.MAGENTA_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.YELLOW_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.GRAY_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.CYAN_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.PURPLE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.BROWN_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.GREEN_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.RED_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.BLACK_WOOL_STAIRS.get());

        this.add(ModBlocks.ALMOND_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ALMOND_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.APPLE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.APPLE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ASPEN_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ASPEN_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BANANA_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BANANA_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BAOBAB_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BAOBAB_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CEDAR_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CEDAR_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BEECH_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BEECH_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHARRED_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CHARRED_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHESTNUT_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CHESTNUT_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CYPRESS_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CYPRESS_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DATE_PALM_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.DATE_PALM_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.FIR_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.FIR_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GREEN_OAK_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.GREEN_OAK_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.HOLLY_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.HOLLY_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.KUNTZ_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.KUNTZ_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LAIRELOSSE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LAIRELOSSE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LARCH_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LARCH_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEBETHRON_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LEBETHRON_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEMON_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LEMON_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIME_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LIME_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_MAHOGANY_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MALLORN_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MALLORN_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MANGO_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MANGO_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MAPLE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MAPLE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MIRK_OAK_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MIRK_OAK_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.OLIVE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.OLIVE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ORANGE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ORANGE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PALM_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PALM_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PEAR_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PEAR_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PINE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PINE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PLUM_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PLUM_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.POMEGRANATE_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.POMEGRANATE_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.REDWOOD_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.REDWOOD_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_OAK_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.RED_OAK_BEAM_VERTICAL_SLAB.get()));
        this.add(ModBlocks.WILLOW_BEAM_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.WILLOW_BEAM_VERTICAL_SLAB.get()));

        this.add(ModBlocks.ALMOND_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ALMOND_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.APPLE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.APPLE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ASPEN_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ASPEN_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BANANA_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BANANA_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BAOBAB_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BAOBAB_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CEDAR_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CEDAR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BEECH_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.BEECH_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHARRED_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CHARRED_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHESTNUT_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CHESTNUT_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CYPRESS_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.CYPRESS_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DATE_PALM_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.DATE_PALM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.FIR_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.FIR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GREEN_OAK_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.GREEN_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.HOLLY_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.HOLLY_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.KUNTZ_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.KUNTZ_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LAIRELOSSE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LAIRELOSSE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LARCH_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LARCH_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEBETHRON_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LEBETHRON_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEMON_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LEMON_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIME_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.LIME_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_MAHOGANY_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MALLORN_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MALLORN_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MANGO_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MANGO_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MAPLE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MAPLE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MIRK_OAK_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.MIRK_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.OLIVE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.OLIVE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ORANGE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.ORANGE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PALM_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PALM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PEAR_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PEAR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PINE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PINE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PLUM_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.PLUM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.POMEGRANATE_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.POMEGRANATE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.REDWOOD_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.REDWOOD_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_OAK_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.RED_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.WILLOW_LOG_VERTICAL_SLAB.get(), block -> createSlabItemTable(ModBlocks.WILLOW_LOG_VERTICAL_SLAB.get()));

        // STRIPPED_LOG_VERTICAL_SLAB
        this.add(ModBlocks.STRIPPED_ALMOND_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ALMOND_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_APPLE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_APPLE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_ASPEN_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ASPEN_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BAOBAB_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BAOBAB_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BANANA_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BANANA_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BEECH_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BEECH_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CEDAR_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CEDAR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CHARRED_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHARRED_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CYPRESS_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CYPRESS_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_FIR_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_FIR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_HOLLY_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_HOLLY_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_KUNTZ_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_KUNTZ_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LARCH_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LARCH_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LEMON_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEMON_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LIME_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LIME_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MALLORN_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MALLORN_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MANGO_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGO_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MAPLE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MAPLE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_OLIVE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OLIVE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_ORANGE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ORANGE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PALM_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PALM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PEAR_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PEAR_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PINE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PINE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PLUM_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PLUM_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_RED_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_OAK_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_REDWOOD_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_REDWOOD_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_WILLOW_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_WILLOW_LOG_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ALMOND_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALMOND_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.APPLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.APPLE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ASPEN_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ASPEN_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BAOBAB_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BAOBAB_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BANANA_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BANANA_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.BEECH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BEECH_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CEDAR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CEDAR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHARRED_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHARRED_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CHESTNUT_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHESTNUT_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.CYPRESS_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYPRESS_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.DATE_PALM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DATE_PALM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.FIR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.GREEN_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.HOLLY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLY_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.KUNTZ_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KUNTZ_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LAIRELOSSE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LAIRELOSSE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LARCH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LARCH_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEBETHRON_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEBETHRON_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LEMON_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LEMON_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.LIME_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MANGO_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGO_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MALLORN_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALLORN_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MAPLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.MIRK_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MIRK_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.OLIVE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.ORANGE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PALM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PEAR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PEAR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PINE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.PLUM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.POMEGRANATE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POMEGRANATE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_MAHOGANY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAHOGANY_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.RED_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.REDWOOD_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.REDWOOD_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.WILLOW_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOW_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_ALMOND_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ALMOND_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_APPLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_APPLE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_ASPEN_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ASPEN_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BANANA_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BANANA_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_BEECH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BEECH_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CEDAR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CEDAR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CHARRED_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHARRED_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_FIR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_FIR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_HOLLY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_HOLLY_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LARCH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LARCH_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LEMON_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LEMON_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_LIME_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_LIME_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MANGO_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGO_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MALLORN_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MALLORN_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MAPLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MAPLE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_OLIVE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OLIVE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_ORANGE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ORANGE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PALM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PALM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PEAR_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PEAR_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PINE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PINE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_PLUM_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_PLUM_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB.get()));
        this.add(ModBlocks.STRIPPED_WILLOW_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_WILLOW_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.OAK_LOG_STAIRS.get());
        this.add(ModBlocks.OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OAK_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OAK_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.OAK_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OAK_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_SPRUCE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_SPRUCE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.SPRUCE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPRUCE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.SPRUCE_LOG_STAIRS.get());
        this.add(ModBlocks.SPRUCE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPRUCE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.SPRUCE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPRUCE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        this.add(ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_BIRCH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BIRCH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.BIRCH_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BIRCH_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.BIRCH_LOG_STAIRS.get());
        this.add(ModBlocks.BIRCH_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BIRCH_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.BIRCH_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BIRCH_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.BIRCH_WOOD_STAIRS.get());
        this.add(ModBlocks.BIRCH_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BIRCH_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_JUNGLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_JUNGLE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.JUNGLE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JUNGLE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.JUNGLE_LOG_STAIRS.get());
        this.add(ModBlocks.JUNGLE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JUNGLE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.JUNGLE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JUNGLE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        this.add(ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_ACACIA_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ACACIA_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.ACACIA_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ACACIA_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.ACACIA_LOG_STAIRS.get());
        this.add(ModBlocks.ACACIA_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ACACIA_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.ACACIA_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ACACIA_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.ACACIA_WOOD_STAIRS.get());
        this.add(ModBlocks.ACACIA_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ACACIA_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.DARK_OAK_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_OAK_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.DARK_OAK_LOG_STAIRS.get());
        this.add(ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.DARK_OAK_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_OAK_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        this.add(ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_MANGROVE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGROVE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.MANGROVE_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGROVE_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.MANGROVE_LOG_STAIRS.get());
        this.add(ModBlocks.MANGROVE_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGROVE_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.MANGROVE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGROVE_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.MANGROVE_WOOD_STAIRS.get());
        this.add(ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_CHERRY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHERRY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_LOG_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get());
        this.add(ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.CHERRY_LOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHERRY_LOG_SLAB.get()));
        this.dropSelf(ModBlocks.CHERRY_LOG_STAIRS.get());
        this.add(ModBlocks.CHERRY_LOG_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHERRY_LOG_VERTICAL_SLAB.get()));

        this.add(ModBlocks.CHERRY_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHERRY_WOOD_SLAB.get()));
        this.dropSelf(ModBlocks.CHERRY_WOOD_STAIRS.get());
        this.add(ModBlocks.CHERRY_WOOD_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHERRY_WOOD_VERTICAL_SLAB.get()));

        this.add(ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB.get()));

    }

    @Override
    protected LootItemCondition.Builder hasSilkTouch() {
        return super.hasSilkTouch();
    }


    private final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(hasSilkTouch());
    private final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    protected static final float[] HIGH_LEAVES_SAPLING_CHANCES = new float[]{0.5F, 0.625F, 0.83333336F, 1F};
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    protected LootTable.Builder createFruitLeavesDrops(Block pLeavesBlock, Item fruitItem, Block pSaplingBlock, float... pChances){
        return createSilkTouchOrShearsDispatchTable(pLeavesBlock, this.applyExplosionCondition(pLeavesBlock,
                        LootItem.lootTableItem(pSaplingBlock))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), pChances)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionDecay(pLeavesBlock, LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pLeavesBlock)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModFruitLeaves.AGE, 4)))
                        .add(LootItem.lootTableItem(fruitItem)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))));
    }
    HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
