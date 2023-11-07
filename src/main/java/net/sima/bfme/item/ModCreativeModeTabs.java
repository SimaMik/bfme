package net.sima.bfme.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BFME.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GONDORIAN_TAB = CREATIVE_MODE_TABS.register("gondorian_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GONDORIAN_STONE.get()))
                    .title(Component.translatable("creativetab.gondorian_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModBlocks.GONDORIAN_STONE.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_STONE.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_STONE.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_STONE.get());
                        output.accept(ModBlocks.GONDORIAN_COBBLESTONE.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
                        output.accept(ModBlocks.GONDORIAN_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_BRICKWORK.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
                        output.accept(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_CHISELED_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_CHISELED_BRICK.get());

                        output.accept(ModBlocks.GONDORIAN_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_THIN_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_THIN_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_THIN_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_THIN_PILLAR.get());

                        output.accept(ModBlocks.GONDORIAN_STONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_STONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_BRICK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_PILLAR_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());

                        output.accept(ModBlocks.GONDORIAN_STONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_STONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());

                        output.accept(ModBlocks.GONDORIAN_STONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_STONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_BRICK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
                        output.accept(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());


                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
