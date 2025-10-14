package net.sima.bfme.screen_menus.crafting_screens;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.BFME;
import net.sima.bfme.screen_menus.crafting_menus.HumanFurnaceMenu;
import net.sima.bfme.screen_menus.custom.BaseFurnaceMenu;
import net.sima.bfme.screen_menus.custom.BaseFurnaceScreen;
@OnlyIn(Dist.CLIENT)
public class HumanFurnaceScreen extends BaseFurnaceScreen<HumanFurnaceMenu> {
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = BFME.resource("textures/gui/burn_progress.png");
    private static final ResourceLocation TEXTURE = BFME.resource("textures/gui/forge.png");

    public HumanFurnaceScreen(HumanFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE);
    }
}
