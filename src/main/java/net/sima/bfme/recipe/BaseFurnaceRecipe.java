package net.sima.bfme.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.sima.bfme.BFME;
import net.sima.bfme.screen_menus.custom.DualRecipeInput;

public class BaseFurnaceRecipe implements Recipe<DualRecipeInput> {
    protected final Ingredient topIngredient;
    protected final Ingredient bottomIngredient;
    protected final ItemStack result;
    protected final int cookingTime;
    protected final RecipeType<?> type;
    protected final RecipeSerializer<?> serializer;

    public BaseFurnaceRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, Ingredient topIngredient, Ingredient bottomIngredient, ItemStack result, int cookingTime) {
        this.type = type;
        this.serializer = serializer;
        this.topIngredient = topIngredient;
        this.bottomIngredient = bottomIngredient;
        this.result = result;
        this.cookingTime = cookingTime;
    }
    @Override
    public boolean matches(DualRecipeInput input, Level level) {
        boolean directMatch = this.topIngredient.test(input.topItem()) && this.bottomIngredient.test(input.bottomItem());
        boolean reverseMatch = this.topIngredient.test(input.bottomItem()) && this.bottomIngredient.test(input.topItem());

        BFME.LOGGER.info("Checking recipe match: ");
        BFME.LOGGER.info("  Input TopItem: {}", input.topItem());
        BFME.LOGGER.info("  Input BottomItem: {}", input.bottomItem());
        BFME.LOGGER.info("  Recipe TopIngredient: {}", this.topIngredient);
        BFME.LOGGER.info("  Recipe BottomIngredient: {}", this.bottomIngredient);
        BFME.LOGGER.info("  Direct Match: {}", directMatch);
        BFME.LOGGER.info("  Reverse Match: {}", reverseMatch);

        return directMatch || reverseMatch;
    }




    @Override
    public ItemStack assemble(DualRecipeInput container, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(topIngredient);
        ingredients.add(bottomIngredient);
        return ingredients;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result;
    }

    @Override
    public RecipeType<?> getType() {
        return type;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return serializer;
    }

    public interface Factory<T extends BaseFurnaceRecipe> {
        T create(Ingredient var2, Ingredient var3, ItemStack var4, int var6);
    }
}
