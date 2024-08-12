package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public VerticalSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, VerticalSlabType.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(TYPE)) {
            case DOUBLE:
                return Shapes.block();
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
            default:
                return NORTH_AABB;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState state = context.getLevel().getBlockState(pos);
        FluidState fluidState = context.getLevel().getFluidState(pos);
        Direction clickedFace = context.getClickedFace();

        if (state.is(this)) {
            return state.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, Boolean.FALSE);
        } else {
            Direction placementDirection = clickedFace.getAxis().isHorizontal() ? context.getHorizontalDirection() : clickedFace;
            double hitX = context.getClickLocation().x - pos.getX();
            double hitZ = context.getClickLocation().z - pos.getZ();

            VerticalSlabType type;
            if (clickedFace == Direction.UP || clickedFace == Direction.DOWN) {
                Direction playerDirection = context.getHorizontalDirection();
                if (clickedFace == Direction.UP) {
                    type = (hitX > 0.5 && playerDirection == Direction.EAST) || (hitX <= 0.5 && playerDirection == Direction.WEST) ||
                            (hitZ > 0.5 && playerDirection == Direction.SOUTH) || (hitZ <= 0.5 && playerDirection == Direction.NORTH)
                            ? VerticalSlabType.fromDirection(playerDirection) : VerticalSlabType.fromDirection(playerDirection.getOpposite());
                } else {
                    type = (hitX > 0.5 && playerDirection == Direction.EAST) || (hitX <= 0.5 && playerDirection == Direction.WEST) ||
                            (hitZ > 0.5 && playerDirection == Direction.SOUTH) || (hitZ <= 0.5 && playerDirection == Direction.NORTH)
                            ? VerticalSlabType.fromDirection(playerDirection) : VerticalSlabType.fromDirection(playerDirection.getOpposite());
                }
            } else {
                type = VerticalSlabType.fromDirection(placementDirection);
            }

            return this.defaultBlockState().setValue(TYPE, type).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE ? SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluidState) : false;
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player pPlayer, BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return pState.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(pPlayer, pLevel, pPos, pState, pFluid);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        ItemStack itemStack = useContext.getItemInHand();
        VerticalSlabType slabType = state.getValue(TYPE);
        Direction clickedFace = useContext.getClickedFace();
        BlockPos pos = useContext.getClickedPos();
        double hitX = useContext.getClickLocation().x - pos.getX();
        double hitY = useContext.getClickLocation().y - pos.getY();
        double hitZ = useContext.getClickLocation().z - pos.getZ();

        if (slabType != VerticalSlabType.DOUBLE && itemStack.is(this.asItem())) {
            if (useContext.replacingClickedOnBlock()) {
                // Проверка нажатия на внутреннюю часть вертикального полублока
                switch (slabType) {
                    case NORTH:
                        if (clickedFace == Direction.SOUTH) {
                            return true;
                        }
                        break;
                    case SOUTH:
                        if (clickedFace == Direction.NORTH) {
                            return true;
                        }
                        break;
                    case WEST:
                        if (clickedFace == Direction.EAST) {
                            return true;
                        }
                        break;
                    case EAST:
                        if (clickedFace == Direction.WEST) {
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            } else {
                // Проверка нажатия на свободную часть блока под или над полублоком
                if (clickedFace == Direction.UP || clickedFace == Direction.DOWN) {
                    switch (slabType) {
                        case NORTH: if ((clickedFace == Direction.UP && hitZ > 0.5) || (clickedFace == Direction.DOWN && hitZ > 0.5)) {
                            return true;
                        }
                        break;
                        case SOUTH:
                            if ((clickedFace == Direction.UP && hitZ <= 0.5) || (clickedFace == Direction.DOWN && hitZ <= 0.5)) {
                            return true;
                        }
                            break;
                        case WEST: if ((clickedFace == Direction.UP && hitX > 0.5) || (clickedFace == Direction.DOWN && hitX > 0.5)) {
                            return true;
                        }
                        break;
                        case EAST:
                            if ((clickedFace == Direction.UP && hitX <= 0.5) || (clickedFace == Direction.DOWN && hitX <= 0.5)) {
                                return true;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}