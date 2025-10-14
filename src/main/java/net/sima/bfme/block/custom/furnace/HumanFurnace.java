package net.sima.bfme.block.custom.furnace;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.block.custom.BaseFurnaceBlock;
import net.sima.bfme.block.entity.BaseFurnaceBlockEntity;
import net.sima.bfme.block.entity.ModBlockEntities;
import net.sima.bfme.block.entity.furnace.HumanFurnaceBlockEntity;
import net.sima.bfme.recipe.ModRecipes;
import org.jetbrains.annotations.Nullable;

public class HumanFurnace extends BaseFurnaceBlock {

    public static final MapCodec<HumanFurnace> CODEC = simpleCodec(HumanFurnace::new);

    public HumanFurnace(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new HumanFurnaceBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntities.HUMAN_FURNACE.get(), BaseFurnaceBlockEntity::serverTick);
    }

}
