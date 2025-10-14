package net.sima.bfme.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.sima.bfme.BFME;

@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
public class HealthHUDRenderer {
    private static final ResourceLocation BAR_FRAME_TEXTURE = BFME.resource("textures/gui/bar_frame.png");
    private static final ResourceLocation BAR_BACKGROUND_TEXTURE = BFME.resource("textures/gui/bar_background.png");
    private static final ResourceLocation BAR_FILL_TEXTURE = BFME.resource("textures/gui/bar_fill.png");
    private static final int BAR_WIDTH = 182;
    private static final int BAR_HEIGHT = 11;
    private static final int BAR_SPACING = 1;
    public static final ResourceLocation BACKGROUND_LAYER = BFME.resource("background");
    public static final ResourceLocation FILL_LAYER = BFME.resource("fill");
    public static final ResourceLocation FRAME_LAYER = BFME.resource("frame");

    private static final int FILL_OFFSET_X = 10;
    private static final int FILL_OFFSET_Y = 3;
    private static final int FRAME_OFFSET_X = 1;
    private static final int FRAME_OFFSET_Y = 1;

    @SubscribeEvent
    public static void offRenderGuiOverlay(RenderGuiLayerEvent.Pre event) {
        if (event.getName().equals(VanillaGuiLayers.PLAYER_HEALTH)
                || event.getName().equals(VanillaGuiLayers.EXPERIENCE_BAR)
                || event.getName().equals(VanillaGuiLayers.EXPERIENCE_LEVEL)
                || event.getName().equals(VanillaGuiLayers.FOOD_LEVEL)) {
            event.setCanceled(true);
        }
    }

    public static void renderBG(GuiGraphics guiGraphics) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        int scaledWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int scaledHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        int x = (scaledWidth - BAR_WIDTH) / 2;
        int y = scaledHeight  - 5*BAR_HEIGHT - BAR_SPACING + 9;
        renderBG(guiGraphics, x, y);

        y += BAR_HEIGHT + BAR_SPACING;
        renderBG(guiGraphics, x, y);
    }

    public static void renderFR(GuiGraphics guiGraphics) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        int scaledWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int scaledHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        int x = (scaledWidth - BAR_WIDTH) / 2 + FRAME_OFFSET_X;
        int y = scaledHeight - 5*BAR_HEIGHT  - BAR_SPACING + FRAME_OFFSET_Y + 9;
        renderFrame(guiGraphics, x, y);

        y += BAR_HEIGHT + BAR_SPACING;
        renderFrame(guiGraphics, x, y);
    }

    private static void renderBG(GuiGraphics guiGraphics, int x, int y){
        RenderSystem.setShaderTexture(0, BAR_BACKGROUND_TEXTURE);
        RenderSystem.enableBlend();
        guiGraphics.blit(BAR_BACKGROUND_TEXTURE, x, y, 0, 0, BAR_WIDTH, BAR_HEIGHT);
        RenderSystem.disableBlend();
    }
    private static void renderFrame(GuiGraphics guiGraphics, int x, int y){
        RenderSystem.setShaderTexture(0, BAR_FRAME_TEXTURE);
        RenderSystem.enableBlend();
        guiGraphics.blit(BAR_FRAME_TEXTURE, x, y, 0, 0, BAR_WIDTH, BAR_HEIGHT);
        RenderSystem.disableBlend();
    }
    public static void renderCustomHealth(GuiGraphics guiGraphics) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        int scaledWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int scaledHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        int health = (int) player.getHealth();
        int maxHealth = (int) player.getMaxHealth();
        float fillRatio = health / (float) maxHealth;

        int x = (scaledWidth - BAR_WIDTH) / 2;
        int y = scaledHeight - 5*BAR_HEIGHT - BAR_SPACING + 9;

        renderFill(guiGraphics, x, y, fillRatio, health + " / " + maxHealth);

        // Сдвигаем полосу насыщения ближе к инвентарю
        y += BAR_HEIGHT + BAR_SPACING;
        int foodLevel = player.getFoodData().getFoodLevel();
        int maxFoodLevel = 20;
        float saturationRatio = foodLevel / (float) maxFoodLevel;
        renderFill(guiGraphics, x, y, saturationRatio, foodLevel + " / " + maxFoodLevel);
    }
    private static void renderFill(GuiGraphics guiGraphics, int x, int y, float fillRatio, String text) {
        // Рисуем заполненную часть с учётом смещения
        int fillWidth = (int) (BAR_WIDTH * fillRatio);
        RenderSystem.setShaderTexture(0, BAR_FILL_TEXTURE);
        RenderSystem.enableBlend();
        guiGraphics.blit(BAR_FILL_TEXTURE, x + FILL_OFFSET_X, y + FILL_OFFSET_Y, 0, 0, fillWidth, BAR_HEIGHT);
        RenderSystem.disableBlend();

        // Отрисовка текста с измененным размером
        Font font = Minecraft.getInstance().font;
        int textWidth = font.width(text);
        float scale = 0.75f; // Измените масштаб (1.0f = оригинальный размер, 0.75f = меньше на 25%)

        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(scale, scale, scale);

        guiGraphics.drawString(
                font,
                text,
                (int) ((x + (BAR_WIDTH - textWidth) / 2 + 5) / scale), // Пересчет координат с учетом масштаба
                (int) ((y + (BAR_HEIGHT / 2) - 2) / scale),
                0xFFFFFF
        );

        guiGraphics.pose().popPose();
    }

}
