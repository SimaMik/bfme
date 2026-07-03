package net.sima.bfme.network;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.PrivateBlockEntity;
import net.sima.bfme.item.custom.PouchItem;

public class ModPackets {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0.0");
        registrar.playToServer(
                MapTeleportPayload.TYPE,
                MapTeleportPayload.STREAM_CODEC,
                (payload, context) -> {
                    context.enqueueWork(() -> {
                        Player player = context.player();
                        if (player instanceof ServerPlayer serverPlayer) {
                            ServerLevel level = serverPlayer.serverLevel();
                            int x = payload.targetX();
                            int z = payload.targetZ();
                            // Загружаем чанк чтобы heightmap был актуален
                            level.getChunk(x >> 4, z >> 4);
                            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z);
                            serverPlayer.teleportTo(level, x + 0.5, y + 1.0, z + 0.5,
                                    serverPlayer.getYRot(), serverPlayer.getXRot());
                            BFME.LOGGER.info("Map teleport: {} -> {}, {}, {}", serverPlayer.getName().getString(), x, y, z);
                        }
                    });
                }
        );

        registrar.playToServer(
                RenamePouchPayload.TYPE,
                RenamePouchPayload.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(() -> {
                    if (context.player() instanceof ServerPlayer serverPlayer) {
                        ItemStack stack = findPouchInHands(serverPlayer);
                        if (stack.isEmpty()) return;
                        String name = payload.name();
                        if (name == null || name.trim().isEmpty()) {
                            stack.remove(DataComponents.CUSTOM_NAME);
                        } else {
                            stack.set(DataComponents.CUSTOM_NAME, Component.literal(name).copy().withStyle(s -> s.withItalic(false)));
                        }
                    }
                })
        );

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

    private static ItemStack findPouchInHands(ServerPlayer player) {
        ItemStack main = player.getMainHandItem();
        if (main.getItem() instanceof PouchItem) return main;
        ItemStack off = player.getOffhandItem();
        if (off.getItem() instanceof PouchItem) return off;
        return ItemStack.EMPTY;
    }
}
