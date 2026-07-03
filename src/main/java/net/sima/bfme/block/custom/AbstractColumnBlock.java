package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractColumnBlock extends Block {
    public static final EnumProperty<ColumnPart> PART = EnumProperty.create("part", ColumnPart.class);

    public AbstractColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, ColumnPart.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return calcPart(context.getLevel(), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return direction.getAxis() == Direction.Axis.Y ? calcPart(level, pos) : state;
    }

    private BlockState calcPart(LevelAccessor level, BlockPos pos) {
        boolean below = level.getBlockState(pos.below()).is(this);
        boolean above = level.getBlockState(pos.above()).is(this);

        ColumnPart part;
        if (below && above) part = ColumnPart.MIDDLE;
        else if (below) part = ColumnPart.TOP;
        else if (above) part = ColumnPart.BOTTOM;
        else part = ColumnPart.SINGLE;

        return this.defaultBlockState().setValue(PART, part);
    }

    protected abstract VoxelShape getShapeForPart(ColumnPart part);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return getShapeForPart(state.getValue(PART));
    }
}