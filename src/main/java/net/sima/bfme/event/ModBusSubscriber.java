package net.sima.bfme.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.player.PlayerDataProvider;

@EventBusSubscriber(modid = BFME.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusSubscriber {

    @SubscribeEvent
    public static void attachCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(PlayerDataProvider.PLAYER_DATA_CAPABILITY, EntityType.PLAYER, new PlayerDataProvider());
    }

}
