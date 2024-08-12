package net.sima.bfme.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.screen_menus.*;


@EventBusSubscriber(modid = BFME.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusSubscriber {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
//        event.register(ModMenuTypes.GONDORIAN_WORKBENCH_MENU.get(), GondorianWorkbenchScreen::new);
        event.register(ModMenuTypes.SMALL_POUCH.get(), SmallPouchScreen::new);
        event.register(ModMenuTypes.MEDIUM_POUCH.get(), MediumPouchScreen::new);
        event.register(ModMenuTypes.LARGE_POUCH.get(), LargePouchScreen::new);
    }

}
