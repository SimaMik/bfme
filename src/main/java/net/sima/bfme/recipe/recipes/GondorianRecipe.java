package net.sima.bfme.recipe.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.sima.bfme.recipe.BaseRecipe;
import net.sima.bfme.recipe.BaseRecipeSerializer;
import net.sima.bfme.recipe.ModRecipes;

public class GondorianRecipe extends BaseRecipe {

    public GondorianRecipe(ShapedRecipePattern pattern, ItemStack result) {
        super(ModRecipes.GONDORIAN_TYPE.get(), ModRecipes.GONDORIAN_SERIALIZER.get(), pattern, result);
    }

    public static final RecipeSerializer<GondorianRecipe> SERIALIZER =
            new BaseRecipeSerializer<>(GondorianRecipe::new);
    }
