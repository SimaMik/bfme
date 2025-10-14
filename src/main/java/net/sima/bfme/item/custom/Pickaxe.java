package net.sima.bfme.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

import java.util.List;

public class Pickaxe extends DiggerItem {
    public Pickaxe(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (!this.isCorrectToolForDrops(stack, state)) {
            return 1.0F;
        }

        if (stack.getEntityRepresentation() instanceof ServerPlayer serverPlayer) {
            PlayerData data = serverPlayer.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY);
            if (data != null) {
                float speedMultiplier = data.getMiningSpeedMultiplier();
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

        // Убедимся, что выполняем на серверной стороне, так как нам нужны данные игрока
        if (context.registries() == null) {
            tooltipComponents.add(Component.literal("Cannot calculate speed on client side."));
            return;
        }
        if (stack.getEntityRepresentation() instanceof ServerPlayer serverPlayer) {
            // Получаем данные игрока
            PlayerData data = serverPlayer.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY);
            if (data != null) {
                // Получаем базовую скорость кирки
                float baseSpeed = this.getTier().getSpeed();
                // Получаем множитель скорости
                float multiplier = data.getMiningSpeedMultiplier();
                // Рассчитываем реальную скорость
                float effectiveSpeed = this.getDestroySpeed(stack, serverPlayer.level().getBlockState(serverPlayer.blockPosition()));

                // Добавляем информацию в подсказку
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
