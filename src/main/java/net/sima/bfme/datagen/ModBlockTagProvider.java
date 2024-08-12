package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BFME.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GONDORIAN_STONE.get(),
                        ModBlocks.GONDORIAN_STONE_STAIRS.get(),
                        ModBlocks.GONDORIAN_STONE_SLAB.get(),
                        ModBlocks.GONDORIAN_STONE_WALL.get(),
                        ModBlocks.GONDORIAN_STONE_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_STONE_BUTTON.get(),

                        ModBlocks.GONDORIAN_MOSSY_STONE.get(),
                        ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get(),
                        ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get(),
                        ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get(),
                        ModBlocks.GONDORIAN_MOSSY_STONE_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get(),

                        ModBlocks.GONDORIAN_CRACKED_STONE.get(),
                        ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get(),
                        ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get(),
                        ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get(),
                        ModBlocks.GONDORIAN_CRACKED_STONE_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get(),

                        ModBlocks.GONDORIAN_COBBLESTONE.get(),
                        ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get(),
                        ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get(),
                        ModBlocks.GONDORIAN_COBBLESTONE_WALL.get(),
                        ModBlocks.GONDORIAN_COBBLESTONE_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get(),

                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get(),
                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get(),
                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get(),
                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get(),
                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get(),

                        ModBlocks.GONDORIAN_BRICK.get(),
                        ModBlocks.GONDORIAN_BRICK_STAIRS.get(),
                        ModBlocks.GONDORIAN_BRICK_SLAB.get(),
                        ModBlocks.GONDORIAN_BRICK_WALL.get(),
                        ModBlocks.GONDORIAN_BRICK_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_BRICK_BUTTON.get(),

                        ModBlocks.GONDORIAN_BRICKWORK.get(),
                        ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get(),
                        ModBlocks.GONDORIAN_BRICKWORK_SLAB.get(),
                        ModBlocks.GONDORIAN_BRICKWORK_WALL.get(),
                        ModBlocks.GONDORIAN_BRICKWORK_PRESSURE_PLATE.get(),

                        ModBlocks.GONDORIAN_MOSSY_BRICK.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE.get(),

                        ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get(),
                        ModBlocks.GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get(),

                        ModBlocks.GONDORIAN_CRACKED_BRICK.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE.get(),

                        ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get(),
                        ModBlocks.GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get(),

                        ModBlocks.GONDORIAN_CHISELED_BRICK.get(),
                        ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get(),

                        ModBlocks.GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE.get(),
                        ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get(),


                        ModBlocks.GONDORIAN_PILLAR.get(),
                        ModBlocks.GONDORIAN_PILLAR_SLAB.get(),
                        ModBlocks.GONDORIAN_MOSSY_PILLAR.get(),
                        ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get(),
                        ModBlocks.GONDORIAN_CRACKED_PILLAR.get(),
                        ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get(),
                        ModBlocks.GONDORIAN_COLUMN.get(),
                        ModBlocks.GONDORIAN_MOSSY_COLUMN.get(),
                        ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.GONDORIAN_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get())
                .add(ModBlocks.GONDORIAN_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_BRICKWORK_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AMBER_ORE.get(),
                        ModBlocks.AMBER_BLOCK.get(),
                        ModBlocks.DEEPSLATE_AMBER_ORE.get(),
                        ModBlocks.AMETHYST_ORE.get(),
                        ModBlocks.AMETHYST_BLOCK.get(),
                        ModBlocks.DEEPSLATE_AMETHYST_ORE.get(),
                        ModBlocks.DIAMOND_ORE.get(),
                        ModBlocks.DIAMOND_BLOCK.get(),
                        ModBlocks.DEEPSLATE_DIAMOND_ORE.get(),
                        ModBlocks.EMERALD_ORE.get(),
                        ModBlocks.EMERALD_BLOCK.get(),
                        ModBlocks.DEEPSLATE_EMERALD_ORE.get(),
                        ModBlocks.OPAL_ORE.get(),
                        ModBlocks.OPAL_BLOCK.get(),
                        ModBlocks.DEEPSLATE_OPAL_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.TOPAZ_BLOCK.get(),
                        ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                        ModBlocks.SILVER_ORE.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                        ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
    }
    @Override
    public String getName() {
        return "Block Tags";
    }
}