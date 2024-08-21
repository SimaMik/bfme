package net.sima.bfme.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class GondorianRecipe implements Recipe<CraftingInput> {
    public final ShapedRecipePattern pattern;
    final ItemStack result;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;

    public GondorianRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.showNotification = showNotification;
    }

    public GondorianRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
        this(group, category, pattern, result, true);
    }
@Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.GONDORIAN_CRAFTING_SERIALIZER.get();
    }
    @Override
    public RecipeType<?> getType() {
        return ModRecipes.GONDORIAN_CRAFTING_TYPE.get();
    }
    public String getGroup() {
        return this.group;
    }

    public CraftingBookCategory category() {
        return this.category;
    }

    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.pattern.ingredients();
    }

    public boolean showNotification() {
        return this.showNotification;
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    public boolean matches(CraftingInput input, Level level) {
        return this.pattern.matches(input);
    }

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        return this.getResultItem(registries).copy();
    }

    public int getWidth() {
        return this.pattern.width();
    }

    public int getHeight() {
        return this.pattern.height();
    }

    public boolean isIncomplete() {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter((p_151277_) -> {
            return !p_151277_.isEmpty();
        }).anyMatch(Ingredient::hasNoItems);
    }
}







//        extends ShapedRecipe {
//
//    public CraftingBookCategory category;
//    public ItemStack result;
//    public GondorianRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification, boolean showNotification1) {
//        super(group, category, pattern, result, showNotification);
//    }
//
//    public GondorianRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
//        this(group, category, pattern, result, true);
//    }
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return ModRecipes.GONDORIAN_CRAFTING_SERIALIZER.get();
//    }
//
//    @Override
//    public String getGroup() {
//        return super.getGroup();
//    }
//    public boolean showNotification() {
//        return this.showNotification;
//    }
//
//    @Override
//    public ItemStack getResultItem(HolderLookup.Provider registries) {
//        return super.getResultItem(registries);
//    }
//}