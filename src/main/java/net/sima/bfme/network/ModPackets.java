package net.sima.bfme.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.PrivateBlockEntity;

public class ModPackets {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0.0");
        registrar.playBidirectional(
                PrivateBlockPayload.TYPE,
                PrivateBlockPayload.STREAM_CODEC,
                (payload, context) -> {
                    context.enqueueWork(() -> {
                        BFME.LOGGER.info("Processing PrivateBlockPayload: {}", payload);

                        Player player = context.player();
                        if (player != null) {
                            BlockEntity blockEntity = player.level().getBlockEntity(payload.blockPos());
                            if (blockEntity instanceof PrivateBlockEntity privateBlockEntity) {
                                if (!payload.playerName().isEmpty()) {
                                    if (payload.playerName().startsWith("-")) {
                                        // Удаление игрока
                                        String playerToRemove = payload.playerName().substring(1); // Убираем префикс '-'
                                        BFME.LOGGER.info("Removing player {} from block at {}", playerToRemove, payload.blockPos());
                                        privateBlockEntity.removeAllowedPlayer(playerToRemove);
                                    } else {
                                        // Добавление нового игрока
                                        BFME.LOGGER.info("Adding player {} to block at {}", payload.playerName(), payload.blockPos());
                                        privateBlockEntity.addAllowedPlayer(payload.playerName());
                                    }
                                } else {
                                    // Логирование полученных данных
                                    BFME.LOGGER.info("Получен пакет с сервера: interaction={}, breaking={}, placing={}",
                                            payload.allowInteraction(), payload.allowBreaking(), payload.allowPlacing());

                                    // Обновление параметров блока
                                    privateBlockEntity.setCoordinates(
                                            payload.xPositive(),
                                            payload.xNegative(),
                                            payload.yPositive(),
                                            payload.yNegative(),
                                            payload.zPositive(),
                                            payload.zNegative()
                                    );
                                    privateBlockEntity.setAllowInteraction(payload.allowInteraction());
                                    privateBlockEntity.setAllowBreaking(payload.allowBreaking());
                                    privateBlockEntity.setAllowPlacing(payload.allowPlacing());

                                    // Логирование обновленного состояния блока
                                    BFME.LOGGER.info("Обновлено состояние PrivateBlockEntity на сервере: interaction={}, breaking={}, placing={}",
                                            privateBlockEntity.isAllowInteraction(), privateBlockEntity.isAllowBreaking(), privateBlockEntity.isAllowPlacing());
                                }
                                privateBlockEntity.setChanged();
                                player.level().sendBlockUpdated(privateBlockEntity.getBlockPos(), privateBlockEntity.getBlockState(), privateBlockEntity.getBlockState(), 3);
                            }
                        }
                    });
                }
        );
    }

    public static void sendToAll(CustomPacketPayload payload) {
        BFME.LOGGER.info("Отправка пакета всем игрокам: {}", payload);
        PacketDistributor.sendToAllPlayers(payload);
    }
}
