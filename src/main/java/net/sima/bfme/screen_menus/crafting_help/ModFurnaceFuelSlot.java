package net.sima.bfme.screen_menus.crafting_help;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.sima.bfme.screen_menus.custom.BaseFurnaceMenu;

public class ModFurnaceFuelSlot extends Slot {
    private final BaseFurnaceMenu menu;

    public ModFurnaceFuelSlot(BaseFurnaceMenu furnaceMenu, Container furnaceContainer, int slot, int xPosition, int yPosition) {
        super(furnaceContainer, slot, xPosition, yPosition);
        this.menu = furnaceMenu;
    }

    public boolean mayPlace(ItemStack stack) {
        return this.menu.isFuel(stack) || isBucket(stack);
    }

    public int getMaxStackSize(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxStackSize(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.is(Items.BUCKET);
    }
}
