package net.sima.bfme.util;

import net.minecraft.core.Direction;

@FunctionalInterface
public interface CanExtractFunction {
    boolean apply(int var1);

    @FunctionalInterface
    public interface Sided {
        boolean apply(int var1, Direction var2);
    }
}
