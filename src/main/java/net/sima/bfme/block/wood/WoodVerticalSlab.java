package net.sima.bfme.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sima.bfme.block.custom.HorizontalVerticalSlabBlock;
import net.sima.bfme.block.custom.VerticalSlabBlock;

import javax.annotation.Nullable;

public class WoodVerticalSlab extends HorizontalVerticalSlabBlock {

    private final DeferredBlock<Block> strippedVariant;

    public WoodVerticalSlab(Properties properties, DeferredBlock<Block> strippedVariant) {
        super(properties);
        this.strippedVariant = strippedVariant;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext ctx,
                                                     ItemAbility ability, boolean simulate) {
        if (!simulate && ability == ItemAbilities.AXE_STRIP) {
            return strippedVariant.get().defaultBlockState()
                    .setValue(VerticalSlabBlock.TYPE, state.getValue(TYPE))
                    .setValue(VerticalSlabBlock.WATERLOGGED, state.getValue(WATERLOGGED))
                    .setValue(FACING, state.getValue(FACING));
        }
        return null;
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