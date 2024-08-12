package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColumnBlock extends Block {
    public static final EnumProperty<ColumnPart> PART = EnumProperty.create("part", ColumnPart.class);

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
            Block.box(0, 14, 0, 16, 16, 16),
            Block.box(1, 13, 1, 15, 14, 15)
    );

    public ColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, ColumnPart.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        switch (state.getValue(PART)) {
            case BOTTOM:
                return SHAPE_BOTTOM;
            case MIDDLE:
                return SHAPE_MIDDLE;
            case TOP:
                return SHAPE_TOP;
            case SINGLE:
            default:
                return SHAPE_SINGLE;
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return updateState(state, level, pos);
    }

    private BlockState updateState(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean belowIsSame = level.getBlockState(pos.below()).getBlock() == this;
        boolean aboveIsSame = level.getBlockState(pos.above()).getBlock() == this;

        ColumnPart part;
        if (belowIsSame && aboveIsSame) {
            part = ColumnPart.MIDDLE;
        } else if (belowIsSame) {
            part = ColumnPart.TOP;
        } else if (aboveIsSame) {
            part = ColumnPart.BOTTOM;
        } else {
            part = ColumnPart.SINGLE;
        }

        return state.setValue(PART, part);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 2;
    }
}
