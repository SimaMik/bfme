package net.sima.bfme.util;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

@FunctionalInterface
public interface CanInsertFunction {
    boolean apply(int var1, ItemStack var2);

    @FunctionalInterface
    public interface Sided {
        boolean apply(int var1, ItemStack var2, Direction var3);
    }
}
