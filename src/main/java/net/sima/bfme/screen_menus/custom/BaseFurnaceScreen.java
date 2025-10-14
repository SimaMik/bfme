package net.sima.bfme.screen_menus.custom;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public abstract class BaseFurnaceScreen<T extends BaseFurnaceMenu> extends AbstractContainerScreen<T> {
    private final ResourceLocation texture;
    private final ResourceLocation litProgressSprite;
    private final ResourceLocation burnProgressSprite;

    public BaseFurnaceScreen(
            T menu,
            Inventory playerInventory,
            Component title,
            ResourceLocation texture,
            ResourceLocation listProgressSprite,
            ResourceLocation burnProgressSprite
    ) {
        super(menu, playerInventory, title);
        this.texture = texture;
        this.litProgressSprite = listProgressSprite;
        this.burnProgressSprite = burnProgressSprite;
        this.imageWidth = 176;
        this.imageHeight = 233;
    }

    @Override
    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    /**
     * Renders the graphical user interface (GUI) element.
     *
     * @param guiGraphics the GuiGraphics object used for rendering.
     * @param mouseX      the x-coordinate of the mouse cursor.
     * @param mouseY      the y-coordinate of the mouse cursor.
     * @param partialTick the partial tick time.
     */
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
    @Override
    protected void renderLabels(GuiGraphics gfx, int mouseX, int mouseY) {
        String title = this.getTitle().getString();
        gfx.drawString(this.font, title, (this.imageWidth - this.font.width(this.title)) / 2, 6, 4210752, false);
        gfx.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 4210752, false);
    }
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        // Рендер основного фона
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(this.texture, i, j, 0, 0, this.imageWidth, this.imageHeight);

        // Рендер индикатора горения топлива
        if (this.menu.isLit()) {
            int litHeight = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1; // Высота прогресса
            guiGraphics.blitSprite(
                    this.litProgressSprite,  // Текстура
                    14,                     // Ширина текстуры
                    14,              // Высота текстуры
                    0,                      // Смещение по X в текстуре
                    14 - litHeight,         // Смещение по Y в текстуре
                    i + 81,                 // Позиция по X на экране
                    j + 127 - litHeight, // Позиция по Y на экране
                    14,                     // Ширина отображаемой области
                    litHeight               // Высота отображаемой области
            );
        }

        // Рендер индикатора прогресса переплавки
        int burnHeight = Mth.ceil(this.menu.getBurnProgress() * 24.0F); // Ширина прогресса
        guiGraphics.blit(
                this.burnProgressSprite,
                i + 80,
                j + 59,
                0,
                0,
                16,
                burnHeight,
                16,
                24
        );
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeft, int guiTop, int mouseButton) {
        return mouseX < guiLeft || mouseY < guiTop || mouseX >= guiLeft + this.imageWidth || mouseY >= guiTop + this.imageHeight;
    }
}
