package net.sima.bfme.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.PrivateBlockEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.DEDICATED_SERVER)
public class PrivateBlockEventHandler {

    /**
     * Проверка на возможность взаимодействия с блоками.
     */
    @SubscribeEvent
    public static void onBlockInteract(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        Level level = player.level();

        boolean blockItemInHand = event.getItemStack().getItem() instanceof BlockItem;

        // Проверяем доступ на взаимодействие
        if (isBlocked(player, pos, ActionType.INTERACTION)) {
            player.displayClientMessage(Component.literal("Вы не можете взаимодействовать с этим блоком!"), true);
            event.setUseBlock(TriState.FALSE); // Блокируем взаимодействие с блоком
            return; // Прерываем, чтобы не проверять установку блока
        }

        // Проверяем доступ на установку блока, если игрок держит блок
        if (blockItemInHand && isBlocked(player, pos, ActionType.PLACING)) {
            player.displayClientMessage(Component.literal("Вы не можете ставить блоки здесь!"), true);
            event.setUseItem(TriState.FALSE); // Блокируем использование предмета (установку блока)
        }
    }




    /**
     * Проверка на возможность ломания блоков.
     */
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();

        if (isBlocked(player, pos, ActionType.BREAKING)) {
            player.displayClientMessage(Component.literal("Вы не можете ломать этот блок!"), true);
            event.setCanceled(true);
        }
    }


    /**
     * Проверка на возможность установки блоков.
     */
    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof Player player) {
            BlockPos pos = event.getPos();

            if (isBlocked(player, pos, ActionType.PLACING)) {
                player.displayClientMessage(Component.literal("Вы не можете ставить блоки здесь!"), true);
                event.setCanceled(true);
            }
        }
    }



    /**
     * Основная проверка доступа игрока.
     */
    private static boolean isBlocked(Player player, BlockPos pos, ActionType actionType) {
        if (player.level().isClientSide()) return false;

        BlockEntity blockEntity = findPrivateBlockAt(pos, player.level());
        if (!(blockEntity instanceof PrivateBlockEntity privateBlock)) {
            BFME.LOGGER.info("Приват отсутствует для позиции {}", pos);
            return false;
        }

        BFME.LOGGER.info("Проверка доступа игрока {} для действия {}: owner={}, players={}, flags={}",
                player.getName().getString(),
                actionType,
                privateBlock.getOwner(),
                privateBlock.getAllowedPlayers(),
                new boolean[]{privateBlock.isAllowInteraction(), privateBlock.isAllowBreaking(), privateBlock.isAllowPlacing()}
        );

        // Если игрок владелец или добавленный игрок, разрешить доступ
        if (privateBlock.getOwner().equalsIgnoreCase(player.getName().getString()) ||
                privateBlock.getAllowedPlayers().stream().anyMatch(name -> name.equalsIgnoreCase(player.getName().getString()))) {
            return false; // Игрок имеет доступ
        }

        // Проверяем конкретное действие
        switch (actionType) {
            case INTERACTION:
                return !privateBlock.isAllowInteraction();
            case BREAKING:
                return !privateBlock.isAllowBreaking();
            case PLACING:
                return !privateBlock.isAllowPlacing();
            default:
                return false; // Разрешить другие действия по умолчанию
        }
    }

    public enum ActionType {
        INTERACTION,
        BREAKING,
        PLACING
    }


    /**
     * Найти блок привата в кэше.
     */
    private static BlockEntity findPrivateBlockAt(BlockPos pos, Level level) {
        // Обход всех блоков привата в пределах радиуса
        for (BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-64, -64, -64), pos.offset(64, 64, 64))) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof PrivateBlockEntity privateBlock) {
                int[] coords = privateBlock.getCoordinates();
                if (isWithinRegion(pos, blockPos, coords)) {
                    BFME.LOGGER.info("Блок привата найден: {} для позиции {}", blockPos, pos);
                    return privateBlock;
                }
            }
        }
        BFME.LOGGER.warn("Блок привата не найден для позиции {}", pos);
        return null;
    }

    /**
     * Проверить, находится ли точка внутри региона привата.
     */private static boolean isWithinRegion(BlockPos point, BlockPos privatePos, int[] coords) {
        boolean inX = point.getX() >= privatePos.getX() - coords[1] && point.getX() <= privatePos.getX() + coords[0];
        boolean inY = point.getY() >= privatePos.getY() - coords[3] && point.getY() <= privatePos.getY() + coords[2];
        boolean inZ = point.getZ() >= privatePos.getZ() - coords[5] && point.getZ() <= privatePos.getZ() + coords[4];
        BFME.LOGGER.info("isWithinRegion: inX={}, inY={}, inZ={}, point={}, region={}",
                inX, inY, inZ, point, privatePos);
        return inX && inY && inZ;
    }

}
