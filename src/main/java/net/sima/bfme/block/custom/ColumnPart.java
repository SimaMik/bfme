package net.sima.bfme.block.custom;

import net.minecraft.util.StringRepresentable;

public enum ColumnPart implements StringRepresentable {
    SINGLE("single"),
    BOTTOM("bottom"),
    MIDDLE("middle"),
    TOP("top");

    private final String name;

    private ColumnPart(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
