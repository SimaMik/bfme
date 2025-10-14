package net.sima.bfme.screen_menus.crafting_screens;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.BFME;
import net.sima.bfme.screen_menus.crafting_menus.GondorianCraftingMenu;
import net.sima.bfme.screen_menus.custom.BaseContainerScreen;

@OnlyIn(Dist.CLIENT)
public class GondorianWorkbenchScreen extends BaseContainerScreen<GondorianCraftingMenu> {
    public static final ResourceLocation BACKGROUND = BFME.resource("textures/gui/gondorian_workbench.png");

    public GondorianWorkbenchScreen(GondorianCraftingMenu container, Inventory inventory, Component title) {
        super(container, inventory, title, BACKGROUND, 176, 166);
    }

    protected void renderLabels(GuiGraphics gfx, int mouseX, int mouseY) {
        String title = this.getTitle().getString();
        gfx.drawString(this.font, title, 32, 6, 4210752, false);
        gfx.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 4210752, false);
    }
}