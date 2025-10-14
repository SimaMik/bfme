package net.sima.bfme.recipe.recipe_builders;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sima.bfme.recipe.BaseFurnaceRecipeBuilder;
import net.sima.bfme.recipe.recipes.HumanFurnaceRecipe;

public class HumanFurnaceRecipeBuilder extends BaseFurnaceRecipeBuilder<HumanFurnaceRecipe> {
    public HumanFurnaceRecipeBuilder(RecipeCategory category, ItemStack result) {
        super(category, result);
    }

    public static HumanFurnaceRecipeBuilder recipeBuilder(RecipeCategory category, ItemLike result, int count) {
        return new HumanFurnaceRecipeBuilder(category, new ItemStack(result, count));
    }

    @Override
    protected HumanFurnaceRecipe createRecipe(Ingredient top, Ingredient bottom, ItemStack result, int cookingTime) {
        return new HumanFurnaceRecipe(top, bottom, result, cookingTime);
    }

}
