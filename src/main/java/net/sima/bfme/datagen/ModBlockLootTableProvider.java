package net.sima.bfme.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
                                //Гондорские камни
        this.dropSelf(ModBlocks.GONDORIAN_WORKBENCH.get());

        this.dropSelf(ModBlocks.GONDORIAN_STONE.get());
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
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.GONDORIAN_COLUMN.get());
        this.dropSelf(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
        this.dropSelf(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());

        this.add(ModBlocks.GONDORIAN_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GONDORIAN_STONE_SLAB.get()));
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

        this.dropSelf(ModBlocks.DURIN_SMOOTH_STONE.get());
        this.dropSelf(ModBlocks.DURIN_STONE.get());
        this.dropSelf(ModBlocks.DURIN_CARVED_STONE.get());
        this.dropSelf(ModBlocks.DURIN_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DURIN_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_GOLD_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_BRICKWORK.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_BRICK.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
        this.dropSelf(ModBlocks.DURIN_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_COLUMN.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_CRACKED_COLUMN.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_PILLAR.get());
        this.dropSelf(ModBlocks.DURIN_MOSSY_COLUMN.get());


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
    }
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
