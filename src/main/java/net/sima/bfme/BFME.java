package net.sima.bfme;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.block.entity.ModBlockEntities;
import net.sima.bfme.datagen.ModCreativeModeTabs;
import net.sima.bfme.effect.ModEffects;
import net.sima.bfme.entity.ModEntities;
import net.sima.bfme.entity.client.EagleRenderer;
import net.sima.bfme.entity.client.ModBoatRenderer;
import net.sima.bfme.item.ModArmorMaterials;
import net.sima.bfme.item.ModItemProperties;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.item.custom.PouchItem;
import net.sima.bfme.network.ModPackets;
import net.sima.bfme.recipe.ModRecipes;
import net.sima.bfme.screen_menus.ModMenuTypes;
import net.sima.bfme.util.ModWoodTypes;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomesData;
import net.sima.bfme.worldgen.map.BFMEMapGeneration;
import net.sima.bfme.worldgen.structures.BFMEStructurePieceTypes;
import net.sima.bfme.worldgen.structures.BFMEStructureTypes;
import net.sima.bfme.worldgen.features.ModFeatures;
import net.sima.bfme.worldgen.tree.ModFoliagePlacerTypes;
import net.sima.bfme.worldgen.tree.ModTrunkPlacerTypes;
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

//import static net.sima.bfme.screen_menus.ModMenuTypes.GONDORIAN_CRAFTING_TABLE_MENU;

@Mod(BFME.MOD_ID)
public class BFME
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bfme";
    public static final String MOD_VERSION = "0.7-1.21";
    public static final boolean IS_DEBUG = true;

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public BFME(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        ModRecipes.RECIPE_TYPES.register(modEventBus);
        ModEffects.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacerTypes.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        BFMEStructureTypes.TYPES.register(modEventBus);
        BFMEStructurePieceTypes.PIECE_TYPES.register(modEventBus);
        BFMEBiomeKeys.registerModBiomes();
        BFMEBiomesData.loadBiomes();
        try {
            new BFMEMapGeneration();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        modEventBus.addListener(ModPackets::register);
        modEventBus.addListener(ModEntities::registerAttributes);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Путь для диск-кэша эрозии (если включён DISK_CACHE_ENABLED) — папка в сейве мира.
        net.sima.bfme.worldgen.erosion.ErosionRegionManager.setDiskDir(
                event.getServer().getWorldPath(net.minecraft.world.level.storage.LevelResource.ROOT));
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> {
            if (tintIndex == 0) {
                return PouchItem.getColor(stack);
            }
            return -1;
        }, ModItems.SMALL_POUCH.get(), ModItems.MEDIUM_POUCH.get(), ModItems.LARGE_POUCH.get());
    }



        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                Sheets.addWoodType(ModWoodTypes.CHARRED_WOOD);
                ModItemProperties.addCustomItemProperties();
                EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
                EntityRenderers.register(ModEntities.EAGLE.get(), EagleRenderer::new);
            });
        }

    }

    public static ResourceLocation resource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
