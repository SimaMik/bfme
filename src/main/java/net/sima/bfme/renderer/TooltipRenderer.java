package net.sima.bfme.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.sima.bfme.BFME;

@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
public class TooltipRenderer {
    @SubscribeEvent
    public static void onRenderTooltipPre(RenderTooltipEvent.Pre event) {
        ItemStack stack = event.getItemStack();

        // Проверяем, является ли предмет мечом (наследником `SwordItem`)
        if (!stack.isEmpty() && stack.getItem() instanceof SwordItem) {
            event.setCanceled(true); // Отменяем стандартный тултип

            GuiGraphics graphics = event.getGraphics();
            int mouseX = event.getX();
            int mouseY = event.getY();

            // Получаем данные предмета
            String itemName = stack.getHoverName().getString(); // Имя предмета
            int currentDurability = stack.getMaxDamage() - stack.getDamageValue(); // Текущая прочность
            int maxDurability = stack.getMaxDamage(); // Максимальная прочность

            // Форматируем строки для отображения
            String durabilityInfo = "Прочность: " + currentDurability + "/" + maxDurability;

            // Вычисляем размеры тултипа
            int textPadding = 5; // Отступ между текстом и краем тултипа
            int tooltipWidth = Math.max(
                    event.getFont().width(itemName),
                    event.getFont().width(durabilityInfo)
            ) + textPadding * 2;

            int lineHeight = event.getFont().lineHeight; // Высота строки текста
            int tooltipHeight = lineHeight * 2 + textPadding * 2; // Высота тултипа

            // Корректируем позицию тултипа (смещаем вправо и немного ниже курсора)
            int tooltipX = mouseX + 10;
            int tooltipY = mouseY + 10;

            // Если тултип выходит за границы экрана, корректируем его позицию
            int screenWidth = graphics.guiWidth();
            int screenHeight = graphics.guiHeight();

            if (tooltipX + tooltipWidth > screenWidth) {
                tooltipX = mouseX - tooltipWidth - 10;
            }
            if (tooltipY + tooltipHeight > screenHeight) {
                tooltipY = mouseY - tooltipHeight - 10;
            }

            // Поднимаем тултип на передний план
            PoseStack poseStack = graphics.pose();
            poseStack.pushPose();
            poseStack.translate(0, 0, 500); // Перемещаем тултип "вверх" по оси Z

            // Включаем режимы рендеринга
            RenderSystem.enableDepthTest();
            RenderSystem.enableBlend();

            // Рендерим ванильный фон тултипа
            renderVanillaTooltipBackground(graphics, tooltipX, tooltipY, tooltipWidth, tooltipHeight);

            // Рендерим текст тултипа
            graphics.drawString(event.getFont(), itemName, tooltipX + textPadding, tooltipY + textPadding, 0xFFFFFF);
            graphics.drawString(event.getFont(), durabilityInfo, tooltipX + textPadding, tooltipY + textPadding + lineHeight, 0xFFFFFF);

            // Завершаем рендер тултипа
            poseStack.popPose();
            graphics.flush();
        }
    }

    // Метод для рендера фона тултипа, как в ванилле
    private static void renderVanillaTooltipBackground(GuiGraphics graphics, int x, int y, int width, int height) {
        int borderColorStart = 0x505000FF; // Верхний левый цвет границы
        int borderColorEnd = 0x5028007F;   // Нижний правый цвет границы
        int backgroundColor = 0xF0100010; // Цвет фона тултипа

        // Рисуем фон тултипа
        graphics.fill(x, y, x + width, y + height, backgroundColor);

        // Рисуем границы тултипа
        graphics.fillGradient(x - 1, y - 1, x + width + 1, y, borderColorStart, borderColorEnd);
        graphics.fillGradient(x - 1, y + height, x + width + 1, y + height + 1, borderColorStart, borderColorEnd);
        graphics.fillGradient(x - 1, y, x, y + height, borderColorStart, borderColorEnd);
        graphics.fillGradient(x + width, y, x + width + 1, y + height, borderColorStart, borderColorEnd);
    }

}
