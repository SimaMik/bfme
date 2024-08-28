package net.sima.bfme.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

public class ModLog extends RotatedPillarBlock {

    private final DeferredBlock<Block> strippedLog;


    public ModLog(Properties pProperties, DeferredBlock<Block> strippedLog) {
        super(pProperties);
        this.strippedLog = strippedLog;
    }
//    public ModLog(Properties pProperties) {
//        super(pProperties);
//    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (!simulate && itemAbility == ItemAbilities.AXE_STRIP) {
            state = this.strippedLog.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        return state;
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
