package net.sima.bfme.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingConversionEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;
import net.sima.bfme.BFME;
import net.sima.bfme.command.*;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.faction.FactionRelationship;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;
import net.sima.bfme.worldgen.dimension.ModDimensions;

import static net.sima.bfme.worldgen.dimension.ModDimensions.BFME_LEVEL_KEY;

@EventBusSubscriber(modid = BFME.MOD_ID)
public class ModEvents {

    /**
     * Общий метод для получения ServerPlayer и PlayerData.
     */
    private static PlayerData getPlayerData(Entity entity) {
        if (entity instanceof ServerPlayer serverPlayer) {
            return PlayerDataProvider.PLAYER_DATA_CAPABILITY.getCapability(serverPlayer, null);
        }
        return null;
    }
    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Post event) {
        Player player = event.getEntity();
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource bufferSource = event.getMultiBufferSource();
        HumanoidModel<?> model = event.getRenderer().getModel();

        // Интерполяция для плавного вращения туловища
        float interpolatedYaw = Mth.lerp(event.getPartialTick(), player.yBodyRotO, player.yBodyRot);

        // === МЕЧ НА ПОЯСЕ ===
        if (player.getInventory().items.get(0).getItem() == ModItems.GONDORIAN_CLAYMORE.get()
                && !player.getMainHandItem().is(ModItems.GONDORIAN_CLAYMORE.get())) {

            poseStack.pushPose();

            // Привязка к туловищу
            poseStack.translate(model.body.x / 16.0, model.body.y / 16.0, model.body.z / 16.0);
            poseStack.mulPose(Axis.YP.rotationDegrees(-interpolatedYaw));

            // Корректировка при присяде
            if (player.isCrouching()) {
                poseStack.translate(0, -0.15, -0.5);
                poseStack.mulPose(Axis.XP.rotationDegrees(model.body.xRot * 57.2958f));
            }

            // Сдвиг меча на пояс
            poseStack.translate(0.25, 0.65, -0.1);
            poseStack.mulPose(Axis.YP.rotationDegrees(270));
            poseStack.mulPose(Axis.ZP.rotationDegrees(90));

            // Масштабирование меча
            poseStack.scale(1.3f, 1.3f, 1f);

            // Рендер меча
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    player.getInventory().items.get(0),
                    ItemDisplayContext.FIXED,
                    LevelRenderer.getLightColor(player.level(), player.blockPosition()),  // Освещение теперь динамическое
                    OverlayTexture.NO_OVERLAY,
                    poseStack,
                    bufferSource,
                    player.level(),
                    player.getId()
            );

            poseStack.popPose();
        }

        if (player.getInventory().items.get(1).getItem() == ModItems.GONDORIAN_SHIELD.get()
                && !player.getMainHandItem().is(ModItems.GONDORIAN_SHIELD.get())) {

            poseStack.pushPose();

            // Привязка к туловищу
            poseStack.translate(model.body.x / 16.0, model.body.y / 16.0, model.body.z / 16.0);
            poseStack.mulPose(Axis.YP.rotationDegrees(-interpolatedYaw));

            // Если игрок приседает, наклоняем щит вместе с телом
            if (player.isCrouching()) {
                poseStack.mulPose(Axis.XP.rotationDegrees(model.body.xRot * 57.2958f)); // Преобразование радиан в градусы
                poseStack.translate(0.0, 0.35, -0.6);  // Коррекция позиции щита в присяде
            } else {
                poseStack.translate(0.0, 0.9, -0.2);  // Позиция в обычном состоянии
            }

              poseStack.scale(0.48f, 0.48f, 0.48f);

            // Рендер щита
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    player.getInventory().items.get(1),
                    ItemDisplayContext.FIXED,
                    LevelRenderer.getLightColor(player.level(), player.blockPosition()),  // Освещение теперь динамическое
                    OverlayTexture.NO_OVERLAY,
                    poseStack,
                    bufferSource,
                    player.level(),
                    player.getId()
            );

            poseStack.popPose();
        }
    }

    @SubscribeEvent
    public static void onLivingConvert(LivingConversionEvent.Post event) {
        event.getOutcome().copyAttachmentsFrom(event.getEntity(), true);
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetFactionCommand(event.getDispatcher());
        new GetFactionCommand(event.getDispatcher());
        new SetProfessionCommand(event.getDispatcher());
        new GetProfessionCommand(event.getDispatcher());
        new SetReputationCommand(event.getDispatcher());
        new GetReputationCommand(event.getDispatcher());
        new TeleportToBFMECommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
        BFMEDebugCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getEntity().copyAttachmentsFrom(event.getOriginal(), event.isWasDeath());
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        PlayerData playerData = getPlayerData(event.getEntity());
        if (playerData != null && event.getTo() == BFME_LEVEL_KEY) {
            BlockPos factionSpawn = getFactionSpawn(playerData.getFaction());
            ServerPlayer player = (ServerPlayer) event.getEntity();
            player.teleportTo(factionSpawn.getX(), factionSpawn.getY(), factionSpawn.getZ());
            player.setRespawnPosition(BFME_LEVEL_KEY, factionSpawn, 0.0F, true, false);
        }
    }

    private static BlockPos getFactionSpawn(Faction faction) {
        if (faction == null) return new BlockPos(0, 64, 0);
        return switch (faction.getFactionName().toLowerCase()) {
            case "gondor" -> new BlockPos(100, 64, 100);
            case "rohan" -> new BlockPos(-200, 64, 150);
            case "mordor" -> new BlockPos(300, 64, -100);
            default -> new BlockPos(0, 64, 0);
        };
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerData playerData = getPlayerData(event.getEntity());
        if (playerData != null) {
            CompoundTag nbt = event.getEntity().getPersistentData();
            playerData.loadNBTData(nbt);
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        PlayerData playerData = getPlayerData(event.getEntity());
        if (playerData != null) {
            CompoundTag nbt = event.getEntity().getPersistentData();
            playerData.saveNBTData(nbt);
        }
    }

    @SubscribeEvent
    public static void onMobKill(LivingDeathEvent event) {
        Entity source = event.getSource().getEntity();
        LivingEntity target = event.getEntity();

        if (source instanceof ServerPlayer player) {
            Faction mobFaction = getMobFaction(target);

            if (mobFaction != null) {
                PlayerData playerData = getPlayerData(player);
                if (playerData != null) {

                    for (Faction faction : Faction.values()) {
                        FactionRelationship.Relationship relationship = FactionRelationship.getRelationship(faction, mobFaction);

                        if (relationship == FactionRelationship.Relationship.FRIEND) {
                            playerData.changeReputation(faction, -10);
                            player.sendSystemMessage(Component.literal("Your reputation with " + faction.getFactionName() + " decreased by 10."));
                        } else if (relationship == FactionRelationship.Relationship.ENEMY) {
                            playerData.changeReputation(faction, 10);
                            player.sendSystemMessage(Component.literal("Your reputation with " + faction.getFactionName() + " increased by 10."));
                        }
                    }
                }
            }
        }
    }

    private static Faction getMobFaction(LivingEntity entity) {
        if (entity instanceof Zombie) {
            return Faction.MORDOR;
        } else if (entity instanceof Cow) {
            return Faction.GONDOR;
        }
        return null;
    }
}
