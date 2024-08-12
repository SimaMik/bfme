package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
    }

//    protected static void brick(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
//        GondorianRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 4)
//                .pattern("AA")
//                .pattern("AA")
//                .define('A', baseBlock)
//                .unlockedBy(getHasName(baseBlock), has(baseBlock))
//                .save(pRecipeOutput);
//    }
    protected static void brick1(RecipeOutput pRecipeOutput, Block baseBlock, Block resultBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock, 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', baseBlock)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(pRecipeOutput);
    }
//    protected static void combat(RecipeOutput pRecipeOutput, Item resultItem) {
//        GondorianRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultItem)
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("BBB")
//                .define('A', ModItems.AMBER)
//                .define('B', ModItems.DIAMOND)
//                .unlockedBy(getHasName(ModItems.AMBER), has(ModItems.AMBER))
//                .save(pRecipeOutput);
//    }
}
