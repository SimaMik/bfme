package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.recipe.recipe_builders.GondorianRecipeBuilder;
import net.sima.bfme.recipe.recipe_builders.HumanFurnaceRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        brick(pRecipeOutput, ModBlocks.GONDORIAN_BRICK.get(), ModBlocks.GONDORIAN_STONE.get());
        gondorianBrick(pRecipeOutput, ModBlocks.GONDORIAN_STONE.get(), ModBlocks.GONDORIAN_BRICK.get());
        GondorianRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GONDORIAN_HAMMER, 1).pattern("AA").pattern("AX")
                .pattern(" X").define('A', ModItems.AMBER.get()).define('X', Items.MILK_BUCKET).unlockedBy(getHasName(ModItems.AMBER.get()), has(ModItems.AMBER.get()))
                .save(pRecipeOutput);

        slab(pRecipeOutput, Blocks.OAK_LOG, ModBlocks.OAK_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.OAK_LOG, ModBlocks.OAK_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.OAK_LOG, ModBlocks.OAK_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_OAK_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_OAK_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.OAK_WOOD, ModBlocks.OAK_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.OAK_WOOD, ModBlocks.OAK_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.OAK_WOOD, ModBlocks.OAK_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.SPRUCE_WOOD, ModBlocks.SPRUCE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.SPRUCE_WOOD, ModBlocks.SPRUCE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.SPRUCE_WOOD, ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.BIRCH_LOG, ModBlocks.BIRCH_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.BIRCH_LOG, ModBlocks.BIRCH_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.BIRCH_LOG, ModBlocks.BIRCH_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.BIRCH_WOOD, ModBlocks.BIRCH_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.BIRCH_WOOD, ModBlocks.BIRCH_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.BIRCH_WOOD, ModBlocks.BIRCH_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.STRIPPED_JUNGLE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.STRIPPED_JUNGLE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.JUNGLE_WOOD, ModBlocks.JUNGLE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.JUNGLE_WOOD, ModBlocks.JUNGLE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.JUNGLE_WOOD, ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_JUNGLE_WOOD, ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_JUNGLE_WOOD, ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_JUNGLE_WOOD, ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.ACACIA_LOG, ModBlocks.ACACIA_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.ACACIA_LOG, ModBlocks.ACACIA_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.ACACIA_LOG, ModBlocks.ACACIA_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.ACACIA_WOOD, ModBlocks.ACACIA_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.ACACIA_WOOD, ModBlocks.ACACIA_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.ACACIA_WOOD, ModBlocks.ACACIA_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.DARK_OAK_WOOD, ModBlocks.DARK_OAK_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.DARK_OAK_WOOD, ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.DARK_OAK_WOOD, ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.MANGROVE_WOOD, ModBlocks.MANGROVE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.MANGROVE_WOOD, ModBlocks.MANGROVE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.MANGROVE_WOOD, ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.CHERRY_LOG, ModBlocks.CHERRY_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.CHERRY_LOG, ModBlocks.CHERRY_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.CHERRY_LOG, ModBlocks.CHERRY_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.CHERRY_WOOD, ModBlocks.CHERRY_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.CHERRY_WOOD, ModBlocks.CHERRY_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.CHERRY_WOOD, ModBlocks.CHERRY_WOOD_VERTICAL_SLAB.get());

        slab(pRecipeOutput, Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get());
        stair(pRecipeOutput, Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get());
        verticalSlab(pRecipeOutput, Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB.get());

        verticalSlab(pRecipeOutput, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB.get());


        splav(pRecipeOutput, RecipeCategory.MISC, Items.IRON_INGOT, Items.GOLD_INGOT, Items.DIAMOND, 1);
        splav(pRecipeOutput, RecipeCategory.MISC, ModItems.AMBER.get(), ModItems.DIAMOND.get(), ModItems.MITHRIL_INGOT.get(), 1);
    }

    protected static void stair(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }

    protected static void verticalSlab(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 6)
                .pattern("A")
                .pattern("A")
                .pattern("A")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }
    protected static void slab(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 6)
                .pattern("AAA")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }
    protected static void brick(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }
    protected static void gondorianBrick(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        GondorianRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }
    protected static void splav(RecipeOutput recipeOutput, RecipeCategory category, Item input1, Item input2, Item result, int count) {
        HumanFurnaceRecipeBuilder.recipeBuilder(category, result, count)
                .top(Ingredient.of(input1))
                .bottom(Ingredient.of(input2))
                .unlockedBy(getHasName(input1), has(input1))
                .unlockedBy(getHasName(input2), has(input2))
                .save(recipeOutput);
    }
}
