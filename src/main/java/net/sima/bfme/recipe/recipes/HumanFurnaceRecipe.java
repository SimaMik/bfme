package net.sima.bfme.recipe.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.sima.bfme.recipe.BaseFurnaceRecipe;
import net.sima.bfme.recipe.BaseFurnaceRecipeSerializer;
import net.sima.bfme.recipe.BaseRecipeSerializer;
import net.sima.bfme.recipe.ModRecipes;

public class HumanFurnaceRecipe extends BaseFurnaceRecipe {

    public HumanFurnaceRecipe(Ingredient topIngredient, Ingredient bottomIngredient, ItemStack result, int cookingTime) {
        super(ModRecipes.HUMAN_TYPE.get(), ModRecipes.HUMAN_SERIALIZER.get(), topIngredient, bottomIngredient, result, cookingTime);
    }

    public static final RecipeSerializer<HumanFurnaceRecipe> SERIALIZER =
            new BaseFurnaceRecipeSerializer<>(HumanFurnaceRecipe::new);
}

