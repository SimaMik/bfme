package net.sima.bfme.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

public class ModStairs extends StairBlock {

    private final DeferredBlock<Block> strippedStairs;

    public ModStairs(BlockState pBaseState, Properties pProperties, DeferredBlock<Block> strippedStairs) {
        super(pBaseState, pProperties);
        this.strippedStairs = strippedStairs;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (!simulate && itemAbility == ItemAbilities.AXE_STRIP) {
            // Возвращаем состояние "очищенных" лестниц
            return this.strippedStairs.get()
                    .defaultBlockState()
                    .setValue(FACING, state.getValue(FACING))
                    .setValue(HALF, state.getValue(HALF))
                    .setValue(SHAPE, state.getValue(SHAPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
        }
        return null;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
}
