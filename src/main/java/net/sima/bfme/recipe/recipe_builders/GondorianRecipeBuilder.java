package net.sima.bfme.recipe.recipe_builders;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import net.sima.bfme.recipe.BaseRecipeBuilder;
import net.sima.bfme.recipe.recipes.GondorianRecipe;

public class GondorianRecipeBuilder extends BaseRecipeBuilder<GondorianRecipe> {

    public GondorianRecipeBuilder(RecipeCategory category, ItemStack result) {
        super(category, result);
    }

    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemLike result) {
        return shaped(category, result, 1);
    }

    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count) {
        return new GondorianRecipeBuilder(category, new ItemStack(result, count));
    }

    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemStack result) {
        return new GondorianRecipeBuilder(category, result);
    }

    @Override
    protected GondorianRecipe createRecipe(ShapedRecipePattern pattern, ItemStack result) {
        return new GondorianRecipe(pattern, result);
    }
}
