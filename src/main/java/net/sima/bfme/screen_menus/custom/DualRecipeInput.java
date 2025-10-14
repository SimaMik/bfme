package net.sima.bfme.screen_menus.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record DualRecipeInput(ItemStack topItem, ItemStack bottomItem) implements RecipeInput {

    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> topItem;
            case 1 -> bottomItem;
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

    @Override
    public int size() {
        return 2; // Пара входных предметов
    }
}
