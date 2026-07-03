package net.sima.bfme.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

public enum VerticalSlabType implements StringRepresentable {
    NORTH("north", Direction.NORTH),
    SOUTH("south", Direction.SOUTH),
    WEST("west", Direction.WEST),
    EAST("east", Direction.EAST),
    DOUBLE("double", null);

    private final String name;
    private final Direction direction;

    VerticalSlabType(String name, Direction direction) {
        this.name = name;
        this.direction = direction;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    public Direction toDirection() {
        return direction;
    }

    public Direction getOpenFace() {
        return direction != null ? direction.getOpposite() : null;
    }

    public static VerticalSlabType fromDirection(Direction dir) {
        return switch (dir) {
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
            default -> NORTH;
        };
    }
}