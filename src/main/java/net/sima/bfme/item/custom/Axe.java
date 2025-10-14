package net.sima.bfme.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

import java.util.List;

public class Axe extends DiggerItem {
    public Axe(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_AXE, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (!this.isCorrectToolForDrops(stack, state)) {
            return 1.0F;
        }

        if (stack.getEntityRepresentation() instanceof ServerPlayer serverPlayer) {
            PlayerData data = serverPlayer.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY);
            if (data != null && data.getProfession() == net.sima.bfme.profession.Professions.LUMBERJACK) {
                float speedMultiplier = data.getLumberjackSpeedMultiplier();
                float baseSpeed = this.getTier().getSpeed();
                return baseSpeed * speedMultiplier;
            }
        }
        return super.getDestroySpeed(stack, state);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        if (stack.getEntityRepresentation() instanceof ServerPlayer serverPlayer) {
            PlayerData data = serverPlayer.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY);
            if (data != null) {
                float baseSpeed = this.getTier().getSpeed();
                float multiplier = data.getLumberjackSpeedMultiplier();
                float effectiveSpeed = this.getDestroySpeed(stack, serverPlayer.level().getBlockState(serverPlayer.blockPosition()));

                tooltipComponents.add(Component.literal("Base Speed: " + baseSpeed));
                tooltipComponents.add(Component.literal("Speed Multiplier: " + multiplier));
                tooltipComponents.add(Component.literal("Effective Speed: " + effectiveSpeed));
            } else {
                tooltipComponents.add(Component.literal("No player data available."));
            }
        } else {
            tooltipComponents.add(Component.literal("Not held by a player."));
        }
    }
}
