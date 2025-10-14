package net.sima.bfme.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.sima.bfme.screen_menus.crafting_help.TableCraftingInput;

public class BaseRecipe implements Recipe<TableCraftingInput> {
    protected final ShapedRecipePattern pattern;
    protected final ItemStack result;
    protected final RecipeType<?> type;
    protected final RecipeSerializer<?> serializer;

    public BaseRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, ShapedRecipePattern pattern, ItemStack result) {
        this.type = type;
        this.serializer = serializer;
        this.pattern = pattern;
        this.result = result;
    }

    public boolean matches(TableCraftingInput inventory, Level level) {
        return this.pattern.matches(inventory);
    }

    public ItemStack assemble(TableCraftingInput inventory, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    public ItemStack getResultItem(HolderLookup.Provider lookup) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.pattern.ingredients();
    }


    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    public RecipeType<?> getType() {
        return this.type;
    }

    public boolean isSpecial() {
        return true;
    }

    public int getWidth() {
        return this.pattern.width();
    }

    public int getHeight() {
        return this.pattern.height();
    }

}
