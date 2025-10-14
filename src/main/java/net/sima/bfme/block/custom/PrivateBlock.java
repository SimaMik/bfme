package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.sima.bfme.BFME;
import net.sima.bfme.event.PrivateBlockEventHandler;
import org.jetbrains.annotations.Nullable;
import net.sima.bfme.block.entity.PrivateBlockEntity;
import net.sima.bfme.screen_menus.custom.PrivateBlockMenu;

public class PrivateBlock extends Block implements EntityBlock {

    public PrivateBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        BFME.LOGGER.info("Creating PrivateBlockEntity at position: {}", pos);
        return new PrivateBlockEntity(pos, state);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof PrivateBlockEntity privateBlockEntity) {
            if (!player.getName().getString().toLowerCase().equals(privateBlockEntity.getOwner())) {
                player.displayClientMessage(Component.literal("Вы не являетесь владельцем этого блока!"), true);
                return ItemInteractionResult.FAIL;
            }
                    player.openMenu(new SimpleMenuProvider(privateBlockEntity, Component.translatable("menu.private_block.title")), pos);

            }
        return ItemInteractionResult.SUCCESS;
    }
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (placer instanceof Player player) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PrivateBlockEntity privateBlockEntity) {
                 privateBlockEntity.setOwner(player.getName().getString().toLowerCase());
            }
        }
        super.setPlacedBy(level, pos, state, placer, stack);
    }

}
