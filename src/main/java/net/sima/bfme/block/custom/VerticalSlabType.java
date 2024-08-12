package net.sima.bfme.block.custom;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

public enum VerticalSlabType implements StringRepresentable {
    NORTH("north"),
    SOUTH("south"),
    WEST("west"),
    EAST("east"),
    DOUBLE("double");

    private final String name;

    VerticalSlabType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public static VerticalSlabType fromDirection(Direction direction) {
        switch (direction) {
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            case EAST:
                return EAST;
            default:
                return NORTH;
        }
    }
}