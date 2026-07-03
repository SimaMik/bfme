package net.sima.bfme.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.sima.bfme.BFME;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
public class ModKeyBindings {

    public static final KeyMapping OPEN_MAP = new KeyMapping(
            "key.bfme.open_map",           // Ключ перевода
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_M,                // Клавиша M
            "key.categories.bfme"           // Категория
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_MAP);
    }
}