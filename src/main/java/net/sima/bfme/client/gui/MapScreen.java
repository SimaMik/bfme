package net.sima.bfme.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.sima.bfme.BFME;
import net.neoforged.neoforge.network.PacketDistributor;
import net.sima.bfme.client.ModKeyBindings;
import net.sima.bfme.network.MapTeleportPayload;
import net.sima.bfme.worldgen.map.BFMEMapConfigs;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

/**
 * Экран карты мира для дебага и навигации.
 *
 * Управление:
 * - Колёсико мыши: зум
 * - ЛКМ + перетаскивание: перемещение карты (при зуме > 1)
 * - R: сброс к виду целой карты
 * - M/ESC: закрыть
 */
public class MapScreen extends Screen {

    private static final ResourceLocation MAP_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            BFME.MOD_ID, "textures/map.png"
    );

    private static final int MAP_PIXEL_SIZE = BFMEMapConfigs.REGION_SIZE; // 1000
    private static final int PIXEL_WEIGHT = BFMEMapConfigs.PIXEL_WEIGHT; // 4

    // Карта делится 3 раза (8x8), размер мира = 1000 * 4 * 8 = 32000
    private static final int WORLD_SIZE = MAP_PIXEL_SIZE * PIXEL_WEIGHT * 8; // 32000

    // Зум: 1.0 = вся карта видна, >1 = приближение
    private float zoom = 1.0f;
    private static final float MIN_ZOOM = 1.0f;
    private static final float MAX_ZOOM = 10.0f;

    // Offset в нормализованных координатах (0-1)
    // При зуме 1.0 offset игнорируется
    private float viewCenterX = 0.5f;
    private float viewCenterZ = 0.5f;

    // Перетаскивание
    private boolean dragging = false;
    private double dragStartX, dragStartZ;
    private float dragStartCenterX, dragStartCenterZ;

    // Размеры отображения
    private int mapDisplaySize;
    private int mapStartX, mapStartY;

    public MapScreen() {
        super(Component.translatable("screen.bfme.map"));
    }

    @Override
    protected void init() {
        super.init();
        // Рассчитываем размер карты — квадрат, помещающийся на экране
        mapDisplaySize = Math.min(this.width, this.height) - 60;
        mapStartX = (this.width - mapDisplaySize) / 2;
        mapStartY = (this.height - mapDisplaySize) / 2 - 20;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Рамка карты
        graphics.fill(mapStartX - 2, mapStartY - 2,
                mapStartX + mapDisplaySize + 2, mapStartY + mapDisplaySize + 2,
                0xFF444444);
        graphics.fill(mapStartX - 1, mapStartY - 1,
                mapStartX + mapDisplaySize + 1, mapStartY + mapDisplaySize + 1,
                0xFF222222);

        // Включаем scissor
        enableScissor(mapStartX, mapStartY, mapDisplaySize, mapDisplaySize);

        // Рисуем карту
        renderMap(graphics);

        // Рисуем позицию игрока
        renderPlayerMarker(graphics);

        disableScissor();

        // Информация
        renderInfo(graphics);
        renderHints(graphics);

        // Тултип под курсором
        renderCursorInfo(graphics, mouseX, mouseY);

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    private void renderMap(GuiGraphics graphics) {
        RenderSystem.setShaderTexture(0, MAP_TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        // Отключаем интерполяцию для чётких пикселей
        RenderSystem.texParameter(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        RenderSystem.texParameter(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        // При зуме 1.0 — вся карта в окне
        // При зуме > 1.0 — показываем часть карты вокруг viewCenter

        float visibleSize = 1.0f / zoom; // Какая часть карты видна (0-1)

        // UV координаты — какую часть текстуры показываем
        float u0, v0, u1, v1;

        if (zoom <= 1.0f) {
            // Вся карта
            u0 = 0; v0 = 0; u1 = 1; v1 = 1;
        } else {
            // Часть карты вокруг viewCenter
            float halfVisible = visibleSize / 2;

            u0 = viewCenterX - halfVisible;
            v0 = viewCenterZ - halfVisible;
            u1 = viewCenterX + halfVisible;
            v1 = viewCenterZ + halfVisible;

            // Клампим чтобы не выходить за границы
            if (u0 < 0) { u1 -= u0; u0 = 0; }
            if (v0 < 0) { v1 -= v0; v0 = 0; }
            if (u1 > 1) { u0 -= (u1 - 1); u1 = 1; }
            if (v1 > 1) { v0 -= (v1 - 1); v1 = 1; }

            u0 = Math.max(0, u0);
            v0 = Math.max(0, v0);
            u1 = Math.min(1, u1);
            v1 = Math.min(1, v1);
        }

        // Рисуем
        Matrix4f matrix = graphics.pose().last().pose();
        BufferBuilder buffer = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

        buffer.addVertex(matrix, mapStartX, mapStartY, 0).setUv(u0, v0);
        buffer.addVertex(matrix, mapStartX, mapStartY + mapDisplaySize, 0).setUv(u0, v1);
        buffer.addVertex(matrix, mapStartX + mapDisplaySize, mapStartY + mapDisplaySize, 0).setUv(u1, v1);
        buffer.addVertex(matrix, mapStartX + mapDisplaySize, mapStartY, 0).setUv(u1, v0);

        BufferUploader.drawWithShader(buffer.buildOrThrow());
    }

    private void renderPlayerMarker(GuiGraphics graphics) {
        if (minecraft == null || minecraft.player == null) return;

        double playerX = minecraft.player.getX();
        double playerZ = minecraft.player.getZ();

        // Позиция игрока в нормализованных координатах карты (0-1)
        // Мир = 32000 x 32000 блоков
        float playerNormX = (float) (playerX / WORLD_SIZE);
        float playerNormZ = (float) (playerZ / WORLD_SIZE);

        // Клампим к границам карты
        playerNormX = Math.max(0, Math.min(1, playerNormX));
        playerNormZ = Math.max(0, Math.min(1, playerNormZ));

        // Конвертируем в экранные координаты
        float screenX, screenY;

        if (zoom <= 1.0f) {
            // Вся карта видна — просто масштабируем
            screenX = mapStartX + playerNormX * mapDisplaySize;
            screenY = mapStartY + playerNormZ * mapDisplaySize;
        } else {
            // Приближение — нужно учитывать viewCenter
            float visibleSize = 1.0f / zoom;
            float halfVisible = visibleSize / 2;

            float u0 = viewCenterX - halfVisible;
            float v0 = viewCenterZ - halfVisible;

            // Клампим как в renderMap
            if (u0 < 0) u0 = 0;
            if (v0 < 0) v0 = 0;
            if (u0 + visibleSize > 1) u0 = 1 - visibleSize;
            if (v0 + visibleSize > 1) v0 = 1 - visibleSize;

            // Позиция игрока относительно видимой области
            float relX = (playerNormX - u0) / visibleSize;
            float relZ = (playerNormZ - v0) / visibleSize;

            // Если игрок за пределами видимой области
            if (relX < 0 || relX > 1 || relZ < 0 || relZ > 1) {
                return; // Не рисуем
            }

            screenX = mapStartX + relX * mapDisplaySize;
            screenY = mapStartY + relZ * mapDisplaySize;
        }

        // Размер маркера
        int markerSize = 2;

        // Белая обводка
        graphics.fill((int) screenX - markerSize - 1, (int) screenY - markerSize - 1,
                (int) screenX + markerSize + 1, (int) screenY + markerSize + 1,
                0xFFFFFFFF);

        // Красный квадрат
        graphics.fill((int) screenX - markerSize, (int) screenY - markerSize,
                (int) screenX + markerSize, (int) screenY + markerSize,
                0xFFFF0000);
    }

    private void renderInfo(GuiGraphics graphics) {
        if (minecraft == null || minecraft.player == null) return;

        int playerX = (int) minecraft.player.getX();
        int playerY = (int) minecraft.player.getY();
        int playerZ = (int) minecraft.player.getZ();

        int pixelX = playerX / PIXEL_WEIGHT;
        int pixelZ = playerZ / PIXEL_WEIGHT;

        String coordsText = String.format("X: %d  Y: %d  Z: %d", playerX, playerY, playerZ);
        String pixelText = String.format("Pixel: %d, %d  |  Zoom: %.1fx", pixelX, pixelZ, zoom);

        int y = mapStartY + mapDisplaySize + 8;

        // Центрируем
        graphics.drawString(font, coordsText, (this.width - font.width(coordsText)) / 2, y, 0xFFFFFF);
        graphics.drawString(font, pixelText, (this.width - font.width(pixelText)) / 2, y + 12, 0xAAAAAA);
    }

    private void renderCursorInfo(GuiGraphics graphics, int mouseX, int mouseY) {
        // Проверяем, что курсор над картой
        if (mouseX < mapStartX || mouseX > mapStartX + mapDisplaySize ||
                mouseY < mapStartY || mouseY > mapStartY + mapDisplaySize) {
            return;
        }

        // Позиция курсора относительно карты (0-1)
        float relX = (float)(mouseX - mapStartX) / mapDisplaySize;
        float relZ = (float)(mouseY - mapStartY) / mapDisplaySize;

        // Конвертируем в нормализованные координаты карты с учётом зума
        float normX, normZ;

        if (zoom <= 1.0f) {
            normX = relX;
            normZ = relZ;
        } else {
            float visibleSize = 1.0f / zoom;
            float halfVisible = visibleSize / 2;

            float u0 = viewCenterX - halfVisible;
            float v0 = viewCenterZ - halfVisible;

            // Клампим как в renderMap
            if (u0 < 0) u0 = 0;
            if (v0 < 0) v0 = 0;
            if (u0 + visibleSize > 1) u0 = 1 - visibleSize;
            if (v0 + visibleSize > 1) v0 = 1 - visibleSize;

            normX = u0 + relX * visibleSize;
            normZ = v0 + relZ * visibleSize;
        }

        // Мировые координаты (32000 x 32000)
        int worldX = (int)(normX * WORLD_SIZE);
        int worldZ = (int)(normZ * WORLD_SIZE);

        // Пиксель карты (1000 x 1000)
        int pixelX = (int)(normX * MAP_PIXEL_SIZE);
        int pixelZ = (int)(normZ * MAP_PIXEL_SIZE);

        // Получаем биом
        String biomeName = getBiomeName(worldX, worldZ);

        // Формируем текст
        String line1 = String.format("Cursor: X=%d, Z=%d", worldX, worldZ);
        String line2 = String.format("Biome: %s", biomeName);

        // Рисуем тултип рядом с курсором
        int tooltipX = mouseX + 12;
        int tooltipY = mouseY - 20;

        // Не даём выйти за экран
        int maxWidth = Math.max(font.width(line1), font.width(line2));
        if (tooltipX + maxWidth + 6 > this.width) {
            tooltipX = mouseX - maxWidth - 12;
        }
        if (tooltipY < 5) {
            tooltipY = mouseY + 15;
        }

        // Фон тултипа
        graphics.fill(tooltipX - 3, tooltipY - 2,
                tooltipX + maxWidth + 3, tooltipY + 22,
                0xCC000000);
        graphics.fill(tooltipX - 2, tooltipY - 1,
                tooltipX + maxWidth + 2, tooltipY + 21,
                0xCC222222);

        // Текст
        graphics.drawString(font, line1, tooltipX, tooltipY, 0xFFFFFF);
        graphics.drawString(font, line2, tooltipX, tooltipY + 10, 0x88FF88);
    }

    /**
     * Получает название биома по координатам пикселя карты
     */
    private String getBiomeName(int pixelX, int pixelZ) {
        try {
            var mapRuntime = net.sima.bfme.worldgen.map.BFMEMapRuntime.getInstance();
            if (mapRuntime != null) {
                var bfmeBiome = mapRuntime.getBiome(pixelX, pixelZ);
                if (bfmeBiome != null && bfmeBiome.biome != null) {
                    // Берём path из ResourceKey: "white_mountains_peaks"
                    String path = bfmeBiome.biome.location().getPath();
                    return formatBiomeName(path);
                }
            }
        } catch (Exception e) {
            // Игнорируем
        }
        return "Unknown";
    }

    private String formatBiomeName(String path) {
        // white_mountains_peaks -> White Mountains Peaks
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : path.toCharArray()) {
            if (c == '_') {
                result.append(' ');
                capitalizeNext = true;
            } else {
                result.append(capitalizeNext ? Character.toUpperCase(c) : c);
                capitalizeNext = false;
            }
        }

        return result.toString();
    }

    private void renderHints(GuiGraphics graphics) {
        String hints = "[Scroll] Zoom  [Drag] Move  [RMB] Teleport  [R] Reset  [M] Close";
        graphics.drawString(font, hints, (this.width - font.width(hints)) / 2, this.height - 15, 0x666666);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        float oldZoom = zoom;

        if (scrollY > 0) {
            zoom = Math.min(MAX_ZOOM, zoom * 1.25f);
        } else if (scrollY < 0) {
            zoom = Math.max(MIN_ZOOM, zoom / 1.25f);
        }

        // При первом приближении — центрируем на игроке
        if (oldZoom == 1.0f && zoom > 1.0f && minecraft != null && minecraft.player != null) {
            viewCenterX = (float) (minecraft.player.getX() / WORLD_SIZE);
            viewCenterZ = (float) (minecraft.player.getZ() / WORLD_SIZE);
            viewCenterX = Math.max(0, Math.min(1, viewCenterX));
            viewCenterZ = Math.max(0, Math.min(1, viewCenterZ));
        }

        return true;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0 && zoom > 1.0f) {
            dragging = true;
            dragStartX = mouseX;
            dragStartZ = mouseY;
            dragStartCenterX = viewCenterX;
            dragStartCenterZ = viewCenterZ;
            return true;
        }

        // ПКМ — телепорт на точку карты
        if (button == 1) {
            if (mouseX >= mapStartX && mouseX <= mapStartX + mapDisplaySize &&
                    mouseY >= mapStartY && mouseY <= mapStartY + mapDisplaySize) {

                float relX = (float) (mouseX - mapStartX) / mapDisplaySize;
                float relZ = (float) (mouseY - mapStartY) / mapDisplaySize;

                float normX, normZ;
                if (zoom <= 1.0f) {
                    normX = relX;
                    normZ = relZ;
                } else {
                    float visibleSize = 1.0f / zoom;
                    float halfVisible = visibleSize / 2;
                    float u0 = viewCenterX - halfVisible;
                    float v0 = viewCenterZ - halfVisible;
                    if (u0 < 0) u0 = 0;
                    if (v0 < 0) v0 = 0;
                    if (u0 + visibleSize > 1) u0 = 1 - visibleSize;
                    if (v0 + visibleSize > 1) v0 = 1 - visibleSize;
                    normX = u0 + relX * visibleSize;
                    normZ = v0 + relZ * visibleSize;
                }

                int worldX = (int) (normX * WORLD_SIZE);
                int worldZ = (int) (normZ * WORLD_SIZE);

                PacketDistributor.sendToServer(new MapTeleportPayload(worldX, worldZ));
                this.onClose();
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            dragging = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (dragging && button == 0 && zoom > 1.0f) {
            // Сколько мы сдвинули мышь в пикселях экрана
            double dx = mouseX - dragStartX;
            double dz = mouseY - dragStartZ;

            // Конвертируем в нормализованные координаты карты
            float visibleSize = 1.0f / zoom;
            float moveX = (float) (-dx / mapDisplaySize) * visibleSize;
            float moveZ = (float) (-dz / mapDisplaySize) * visibleSize;

            viewCenterX = dragStartCenterX + moveX;
            viewCenterZ = dragStartCenterZ + moveZ;

            // Клампим
            float halfVisible = visibleSize / 2;
            viewCenterX = Math.max(halfVisible, Math.min(1 - halfVisible, viewCenterX));
            viewCenterZ = Math.max(halfVisible, Math.min(1 - halfVisible, viewCenterZ));

            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        // M — закрыть
        if (keyCode == 77 || ModKeyBindings.OPEN_MAP.matches(keyCode, scanCode)) {
            this.onClose();
            return true;
        }
        // R — сброс
        if (keyCode == 82) {
            zoom = 1.0f;
            viewCenterX = 0.5f;
            viewCenterZ = 0.5f;
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Пустой — отключаем блюр полностью
    }

    private void enableScissor(int x, int y, int width, int height) {
        double scale = minecraft.getWindow().getGuiScale();
        int scaledX = (int) (x * scale);
        int scaledY = (int) ((minecraft.getWindow().getGuiScaledHeight() - y - height) * scale);
        int scaledWidth = (int) (width * scale);
        int scaledHeight = (int) (height * scale);
        RenderSystem.enableScissor(scaledX, scaledY, scaledWidth, scaledHeight);
    }

    private void disableScissor() {
        RenderSystem.disableScissor();
    }
}