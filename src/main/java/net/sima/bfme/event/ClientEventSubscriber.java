    package net.sima.bfme.event;

    import net.minecraft.client.model.BoatModel;
    import net.minecraft.client.model.ChestBoatModel;
    import net.sima.bfme.entity.client.EagleModel;
    import net.neoforged.api.distmarker.Dist;
    import net.neoforged.bus.api.SubscribeEvent;
    import net.neoforged.fml.common.EventBusSubscriber;
    import net.neoforged.neoforge.client.event.EntityRenderersEvent;
    import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
    import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
    import net.sima.bfme.BFME;
    import net.sima.bfme.entity.layers.ModModelLayers;
    import net.sima.bfme.screen_menus.*;
    import net.sima.bfme.screen_menus.crafting_screens.GondorianWorkbenchScreen;
    import net.sima.bfme.screen_menus.crafting_screens.HumanFurnaceScreen;
    import net.sima.bfme.screen_menus.custom.PrivateBlockScreen;

    import static net.sima.bfme.renderer.HealthHUDRenderer.*;

    @EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
    public class ClientEventSubscriber {
        @SubscribeEvent
        public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.GONDORIAN_CRAFTING.get(), GondorianWorkbenchScreen::new);
            event.register(ModMenuTypes.HUMAN_FURNACE.get(), HumanFurnaceScreen::new);
            event.register(ModMenuTypes.POUCH.get(), PouchScreen::new);
            event.register(ModMenuTypes.POUCH_CHEST.get(), PouchChestScreen::new);
            event.register(ModMenuTypes.PRIVATE_BLOCK_MENU.get(), PrivateBlockScreen::new);
        }

        @SubscribeEvent
        public static void onRenderGuiOverlay(RegisterGuiLayersEvent event) {
            event.registerBelowAll(BACKGROUND_LAYER, (guiGraphics, delta) -> {
                renderBG(guiGraphics);
            });
            event.registerAbove(BACKGROUND_LAYER, FILL_LAYER, (guiGraphics, delta) -> {
                renderCustomHealth(guiGraphics);
            });
            event.registerAbove(FILL_LAYER, FRAME_LAYER, (guiGraphics, delta) -> {
                renderFR(guiGraphics);
            });
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.ALMOND_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.APPLE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.ASPEN_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BANANA_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BAOBAB_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BEECH_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CEDAR_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CHESTNUT_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CYPRESS_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.DATE_PALM_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.FIR_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.GREEN_OAK_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.HOLLY_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.KUNTZ_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LAIRELOSSE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LARCH_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LEBETHRON_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LEMON_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LIME_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MALLORN_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MANGO_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MAPLE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MIRK_OAK_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.OLIVE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.ORANGE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PALM_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PEAR_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PINE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PLUM_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.POMEGRANATE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.RED_OAK_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.RED_MAHOGANY_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.REDWOOD_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.WILLOW_BOAT_LAYER, BoatModel::createBodyModel);

            event.registerLayerDefinition(ModModelLayers.ALMOND_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.APPLE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.ASPEN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BANANA_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BAOBAB_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.BEECH_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CEDAR_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CHESTNUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.CYPRESS_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.DATE_PALM_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.FIR_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.GREEN_OAK_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.HOLLY_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.KUNTZ_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LAIRELOSSE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LARCH_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LEBETHRON_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LEMON_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LIME_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MALLORN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MANGO_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MAPLE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.MIRK_OAK_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.OLIVE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.ORANGE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PALM_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PEAR_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PINE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.PLUM_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.POMEGRANATE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.RED_OAK_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.RED_MAHOGANY_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.REDWOOD_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.WILLOW_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            event.registerLayerDefinition(ModModelLayers.EAGLE_LAYER, EagleModel::createBodyLayer);
        }
    }
