package net.sima.bfme.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.client.gui.MapScreen;

@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
public class ClientInputHandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player == null || mc.screen != null) {
            return;
        }

        // Проверяем нажатие клавиши карты
        while (ModKeyBindings.OPEN_MAP.consumeClick()) {
            mc.setScreen(new MapScreen());
        }
    }
}