package net.sima.bfme.screen_menus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.sima.bfme.item.custom.PouchItem;

public class LargePouchContainer extends AbstractContainerMenu {
    private final IItemHandler itemHandler;
    private final ItemStack pouchStack;

    public LargePouchContainer(int id, Inventory playerInventory, IItemHandler itemHandler, ItemStack pouchStackr) {
        super(ModMenuTypes.LARGE_POUCH.get(), id);
        this.itemHandler = itemHandler;
        this.pouchStack = pouchStackr;

        int startX = 8;
        int startY = 19;
        int slotSizePlus2 = 18;

        // Slots for large pouch (3 rows of 9 slots)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new SlotItemHandler(itemHandler, col + row * 9, startX + col * slotSizePlus2, startY + row * slotSizePlus2));
            }
        }

        // Player inventory slots
        int playerInventoryStartY = startY + 68;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, startX + col * slotSizePlus2, playerInventoryStartY + row * slotSizePlus2));
            }
        }

        int hotbarY = playerInventoryStartY + slotSizePlus2 * 3 + 4;
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, startX + col * slotSizePlus2, hotbarY));
        }
    }

    public LargePouchContainer(int id, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(id, playerInventory, PouchItem.getHandler(playerInventory.player.getMainHandItem()), playerInventory.player.getMainHandItem());
    }
    public LargePouchContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, PouchItem.getHandler(playerInventory.player.getMainHandItem()), playerInventory.player.getMainHandItem());
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (index < this.itemHandler.getSlots()) {
                if (!this.moveItemStackTo(itemstack1, this.itemHandler.getSlots(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.itemHandler.getSlots(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
        if (!playerIn.level().isClientSide) {
            PouchItem.saveItems(pouchStack, (ItemStackHandler) itemHandler);
        }
    }
}