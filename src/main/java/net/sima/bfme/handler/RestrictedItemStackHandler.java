package net.sima.bfme.handler;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sima.bfme.item.custom.PouchItem;

public class RestrictedItemStackHandler extends ItemStackHandler {

    public RestrictedItemStackHandler(int size) {
        super(size);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return !(stack.getItem() instanceof PouchItem);
    }
}