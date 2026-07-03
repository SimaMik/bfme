package net.sima.bfme.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.block.custom.HorizontalVerticalSlabBlock;

public class StrippedWoodVerticalSlab extends HorizontalVerticalSlabBlock {

    public StrippedWoodVerticalSlab(Properties properties) {
        super(properties);
    }

    // === Flammable ===

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction dir) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction dir) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction dir) {
        return 5;
    }
}