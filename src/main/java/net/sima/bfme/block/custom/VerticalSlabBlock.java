package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
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

    protected static final VoxelShape NORTH_AABB = Block.box(0, 0, 0, 16, 16, 8);
    protected static final VoxelShape SOUTH_AABB = Block.box(0, 0, 8, 16, 16, 16);
    protected static final VoxelShape WEST_AABB = Block.box(0, 0, 0, 8, 16, 16);
    protected static final VoxelShape EAST_AABB = Block.box(8, 0, 0, 16, 16, 16);

    public VerticalSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState()
                .setValue(TYPE, VerticalSlabType.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return switch (state.getValue(TYPE)) {
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            case EAST -> EAST_AABB;
            case DOUBLE -> Shapes.block();
            default -> NORTH_AABB;
        };
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos pos = ctx.getClickedPos();
        BlockState existing = ctx.getLevel().getBlockState(pos);

        if (existing.is(this)) {
            return existing.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);
        }

        VerticalSlabType type = calcPlacementType(ctx);
        boolean waterlogged = ctx.getLevel().getFluidState(pos).getType() == Fluids.WATER;

        return defaultBlockState()
                .setValue(TYPE, type)
                .setValue(WATERLOGGED, waterlogged);
    }

    protected VerticalSlabType calcPlacementType(BlockPlaceContext ctx) {
        Direction clickedFace = ctx.getClickedFace();

        if (clickedFace.getAxis().isHorizontal()) {
            return VerticalSlabType.fromDirection(ctx.getHorizontalDirection());
        }

        BlockPos pos = ctx.getClickedPos();
        double hitX = ctx.getClickLocation().x - pos.getX();
        double hitZ = ctx.getClickLocation().z - pos.getZ();
        Direction playerDir = ctx.getHorizontalDirection();

        boolean onPlayerSide = switch (playerDir) {
            case NORTH -> hitZ <= 0.5;
            case SOUTH -> hitZ > 0.5;
            case WEST -> hitX <= 0.5;
            case EAST -> hitX > 0.5;
            default -> true;
        };

        return onPlayerSide
                ? VerticalSlabType.fromDirection(playerDir)
                : VerticalSlabType.fromDirection(playerDir.getOpposite());
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
        VerticalSlabType type = state.getValue(TYPE);
        if (type == VerticalSlabType.DOUBLE || !ctx.getItemInHand().is(this.asItem())) {
            return false;
        }

        Direction clickedFace = ctx.getClickedFace();

        if (ctx.replacingClickedOnBlock() && clickedFace == type.getOpenFace()) {
            return true;
        }

        if (clickedFace == Direction.UP || clickedFace == Direction.DOWN) {
            BlockPos pos = ctx.getClickedPos();
            double hitX = ctx.getClickLocation().x - pos.getX();
            double hitZ = ctx.getClickLocation().z - pos.getZ();

            return switch (type) {
                case NORTH -> hitZ > 0.5;
                case SOUTH -> hitZ <= 0.5;
                case WEST -> hitX > 0.5;
                case EAST -> hitX <= 0.5;
                default -> false;
            };
        }
        return false;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        VerticalSlabType type = state.getValue(TYPE);
        if (type == VerticalSlabType.DOUBLE) return state;
        return state.setValue(TYPE, VerticalSlabType.fromDirection(rotation.rotate(type.toDirection())));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState,
                                  LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, facing, facingState, level, pos, facingPos);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluid) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE
                && SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluid);
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter level, BlockPos pos,
                                  BlockState state, Fluid fluid) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE
                && SimpleWaterloggedBlock.super.canPlaceLiquid(player, level, pos, state, fluid);
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }
}