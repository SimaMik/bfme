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

    public ColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, ColumnPart.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return updateState(state, level, pos);
    }

    private BlockState updateState(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean belowIsSameClass = level.getBlockState(pos.below()).getBlock().getClass() == this.getClass();
        boolean aboveIsSameClass = level.getBlockState(pos.above()).getBlock().getClass() == this.getClass();

        ColumnPart part;
        if (belowIsSameClass && aboveIsSameClass) {
            part = ColumnPart.MIDDLE;
        } else if (belowIsSameClass) {
            part = ColumnPart.TOP;
        } else if (aboveIsSameClass) {
            part = ColumnPart.BOTTOM;
        } else {
            part = ColumnPart.SINGLE;
        }

        return state.setValue(PART, part);
    }

}
