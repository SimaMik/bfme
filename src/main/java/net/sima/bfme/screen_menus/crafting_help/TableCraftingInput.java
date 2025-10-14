package net.sima.bfme.screen_menus.crafting_help;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import java.util.List;

public class TableCraftingInput extends CraftingInput {
    private final int top;
    private final int left;

    private TableCraftingInput(int width, int height, List<ItemStack> items, int top, int left) {
        super(width, height, items);
        this.top = top;
        this.left = left;
    }

    public int top() {
        return this.top;
    }

    public int left() {
        return this.left;
    }

    public static TableCraftingInput of(int width, int height, List<ItemStack> items) {
        CraftingInput.Positioned positioned = CraftingInput.ofPositioned(width, height, items);
        CraftingInput input = positioned.input();
        return new TableCraftingInput(input.width(), input.height(), input.items(), positioned.top(), positioned.left());
    }
}