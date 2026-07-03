package net.sima.bfme.block.custom;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColumnBlock extends AbstractColumnBlock {

    private static final VoxelShape FULL = Shapes.block(); // полный блок

    public ColumnBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShapeForPart(ColumnPart part) {
        return FULL;
    }
}