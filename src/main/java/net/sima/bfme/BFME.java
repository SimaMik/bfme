package net.sima.bfme;

import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.datagen.ModCreativeModeTabs;
import net.sima.bfme.effect.ModEffects;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.item.custom.PouchItem;
import net.sima.bfme.screen_menus.ModMenuTypes;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

//import static net.sima.bfme.screen_menus.ModMenuTypes.GONDORIAN_WORKBENCH_MENU;

@Mod(BFME.MOD_ID)
public class BFME
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bfme";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BFME(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
//        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
//        ModRecipes.TYPES.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        ModEffects.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> {
            if (tintIndex == 1) {
                return PouchItem.getColor(stack);
            }
            return 0xFFFFFF;
        }, ModItems.SMALL_POUCH.get(), ModItems.MEDIUM_POUCH.get(), ModItems.LARGE_POUCH.get());
    }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
