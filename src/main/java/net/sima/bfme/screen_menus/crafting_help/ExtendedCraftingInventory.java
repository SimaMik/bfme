package net.sima.bfme.screen_menus.crafting_help;

import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.sima.bfme.handler.BaseItemStackHandler;
import net.sima.bfme.screen_menus.custom.BaseCraftingContainerMenu;

public class ExtendedCraftingInventory extends TransientCraftingContainer {
    private final BaseCraftingContainerMenu container;
    private final BaseItemStackHandler inventory;

    public ExtendedCraftingInventory(BaseCraftingContainerMenu container, BaseItemStackHandler inventory, int size) {
        super(container, size, size);
        this.container = container;
        this.inventory = inventory;
    }

    public boolean isEmpty() {
        for(int i = 0; i < this.getContainerSize(); ++i) {
            if (!this.inventory.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getItem(int slot) {
        return this.inventory.getStackInSlot(slot);
    }

    public ItemStack removeItem(int slot, int amount) {
        ItemStack stack = this.inventory.extractItem(slot, amount, false, true);
        this.container.slotsChanged(this);
        return stack;
    }

    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = this.inventory.getStackInSlot(slot);
        this.inventory.setStackInSlot(slot, ItemStack.EMPTY);
        return stack;
    }

    public void setItem(int slot, ItemStack stack) {
        this.inventory.setStackInSlot(slot, stack);
        this.container.slotsChanged(this);
    }

    public void clearContent() {
        for(int i = 0; i < this.getContainerSize(); ++i) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }

    }

    public TableCraftingInput asCraft() {
        return TableCraftingInput.of(this.getWidth(), this.getHeight(), this.inventory.getStacks());
    }
}
