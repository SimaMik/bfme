package net.sima.bfme.screen_menus;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.sima.bfme.BFME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallPouchScreen extends AbstractContainerScreen<SmallPouchContainer> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "textures/gui/small_pouch.png");
    private static final Logger LOGGER = LoggerFactory.getLogger(SmallPouchScreen.class);
    private EditBox nameField;

    public SmallPouchScreen(SmallPouchContainer container, Inventory inv, Component title) {
        super(container, inv, title);
        this.imageHeight = 133;
        this.imageWidth = 176;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void init() {
        super.init();
        this.nameField = new EditBox(this.font, this.leftPos + 62, this.topPos + 6, 103, 10, Component.literal(""));
        this.nameField.setMaxLength(32);
        this.nameField.setBordered(true);
        this.nameField.setVisible(true);
        this.nameField.setTextColor(0xFFFFFF);
        this.addWidget(this.nameField);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.nameField.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(GUI_TEXTURE, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
