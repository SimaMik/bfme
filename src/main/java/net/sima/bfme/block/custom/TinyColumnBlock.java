package net.sima.bfme.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TinyColumnBlock extends AbstractColumnBlock {

    private static final VoxelShape SHAPE_SINGLE = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(1, 2, 1, 15, 3, 15),
            Block.box(3, 3, 3, 13, 13, 13),
            Block.box(1, 13, 1, 15, 14, 15),
            Block.box(0, 14, 0, 16, 16, 16)
    );

    private static final VoxelShape SHAPE_BOTTOM = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(1, 2, 1, 15, 3, 15),
            Block.box(3, 3, 3, 13, 16, 13)
    );

    private static final VoxelShape SHAPE_MIDDLE = Block.box(3, 0, 3, 13, 16, 13);

    private static final VoxelShape SHAPE_TOP = Shapes.or(
            Block.box(3, 0, 3, 13, 13, 13),
            Block.box(1, 13, 1, 15, 14, 15),
            Block.box(0, 14, 0, 16, 16, 16)
    );

    public TinyColumnBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShapeForPart(ColumnPart part) {
        return switch (part) {
            case BOTTOM -> SHAPE_BOTTOM;
            case MIDDLE -> SHAPE_MIDDLE;
            case TOP -> SHAPE_TOP;
            case SINGLE -> SHAPE_SINGLE;
        };
    }
}