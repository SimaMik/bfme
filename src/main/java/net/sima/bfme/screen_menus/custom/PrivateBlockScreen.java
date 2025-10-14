
package net.sima.bfme.screen_menus.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.PrivateBlockEntity;
import net.sima.bfme.network.ModPackets;
import net.sima.bfme.network.PrivateBlockPayload;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PrivateBlockScreen extends Screen implements MenuAccess<PrivateBlockMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "textures/gui/private_block_menu.png");
    private static final int IMAGE_WIDTH = 192;
    private static final int IMAGE_HEIGHT = 192;

    private final PrivateBlockMenu menu;
    private final PrivateBlockEntity blockEntity;

    private EditBox xPositiveField, xNegativeField, yPositiveField, yNegativeField, zPositiveField, zNegativeField, playerField;
    private Button interactionButton, breakingButton, placingButton;

    public PrivateBlockScreen(PrivateBlockMenu menu, Inventory inventory, Component title) {
        super(title);
        this.menu = menu;
        this.blockEntity = menu.blockEntity;
    }

    @Override
    protected void init() {
        int centerX = (this.width - IMAGE_WIDTH) / 2;
        int centerY = (this.height - IMAGE_HEIGHT) / 2;

        // Поля для координат
        playerField = createEditBox(centerX, centerY + 110, "Игрок", false);
        xPositiveField = createEditBox(centerX + 120, centerY + 20, "X+", true);
        xNegativeField = createEditBox(centerX - 60, centerY + 20, "X-", true);
        yPositiveField = createEditBox(centerX + 120, centerY + 50, "Y+", true);
        yNegativeField = createEditBox(centerX - 60, centerY + 50, "Y-", true);
        zPositiveField = createEditBox(centerX + 120, centerY + 80, "Z+", true);
        zNegativeField = createEditBox(centerX - 60, centerY + 80, "Z-", true);


        addRenderableWidget(xPositiveField);
        addRenderableWidget(xNegativeField);
        addRenderableWidget(yPositiveField);
        addRenderableWidget(yNegativeField);
        addRenderableWidget(zPositiveField);
        addRenderableWidget(zNegativeField);
        addRenderableWidget(playerField);

        interactionButton = addRenderableWidget(Button.builder(Component.literal(getFlagButtonLabel("Взаимодействие", blockEntity.isAllowInteraction())), button -> {
            blockEntity.setAllowInteraction(!blockEntity.isAllowInteraction());
            updateButtonLabel(interactionButton, "Взаимодействие", blockEntity.isAllowInteraction());
            BFME.LOGGER.info("Кнопка 'Взаимодействие' нажата. Новое состояние: {}", blockEntity.isAllowInteraction());
        }).pos(centerX, centerY + 140).width(150).build());

        breakingButton = addRenderableWidget(Button.builder(Component.literal(getFlagButtonLabel("Ломание", blockEntity.isAllowBreaking())), button -> {
            blockEntity.setAllowBreaking(!blockEntity.isAllowBreaking());
            updateButtonLabel(breakingButton, "Ломание", blockEntity.isAllowBreaking());
            BFME.LOGGER.info("Кнопка 'Ломание' нажата. Новое состояние: {}", blockEntity.isAllowBreaking());
        }).pos(centerX, centerY + 170).width(150).build());

        placingButton = addRenderableWidget(Button.builder(Component.literal(getFlagButtonLabel("Установка", blockEntity.isAllowPlacing())), button -> {
            blockEntity.setAllowPlacing(!blockEntity.isAllowPlacing());
            updateButtonLabel(placingButton, "Установка", blockEntity.isAllowPlacing());
            BFME.LOGGER.info("Кнопка 'Установка' нажата. Новое состояние: {}", blockEntity.isAllowPlacing());
        }).pos(centerX, centerY + 200).width(150).build());

        // Кнопки для сохранения и добавления игрока
        addRenderableWidget(Button.builder(Component.literal("Добавить игрока"), button -> addPlayer())
                .pos(centerX, centerY + 230)
                .width(150)
                .build());
        addRenderableWidget(Button.builder(Component.literal("Удалить игрока"), button -> removePlayer())
                .pos(centerX, centerY + 260) // Расположим ниже других кнопок
                .width(150)
                .build());

        addRenderableWidget(Button.builder(Component.literal("Сохранить"), button -> saveAll())
                .pos(centerX, centerY + 290)
                .width(150)
                .build());

        loadInitialValues();
    }

    private void saveAll() {
        try {
            int xPositive = Integer.parseInt(xPositiveField.getValue());
            int xNegative = Integer.parseInt(xNegativeField.getValue());
            int yPositive = Integer.parseInt(yPositiveField.getValue());
            int yNegative = Integer.parseInt(yNegativeField.getValue());
            int zPositive = Integer.parseInt(zPositiveField.getValue());
            int zNegative = Integer.parseInt(zNegativeField.getValue());

            // Проверка на минимальные значения
            if (xPositive < 1 || xNegative < 1 || yPositive < 1 || yNegative < 1 || zPositive < 1 || zNegative < 1) {
                minecraft.player.displayClientMessage(Component.literal("Значения должны быть больше 0!"), true);
                return;
            }

            if (blockEntity != null) {
                // Обновляем координаты
                blockEntity.setCoordinates(xPositive, xNegative, yPositive, yNegative, zPositive, zNegative);

                // Логирование текущего состояния для отладки
                BFME.LOGGER.info("Saving all settings for PrivateBlockEntity at {}: x+={}, x-={}, y+={}, y-={}, z+={}, z-={}, interaction={}, breaking={}, placing={}",
                        blockEntity.getBlockPos(), xPositive, xNegative, yPositive, yNegative, zPositive, zNegative,
                        blockEntity.isAllowInteraction(), blockEntity.isAllowBreaking(), blockEntity.isAllowPlacing());

                // Отправка данных на сервер
                PacketDistributor.sendToServer(new PrivateBlockPayload(
                        xPositive,
                        xNegative,
                        yPositive,
                        yNegative,
                        zPositive,
                        zNegative,
                        "", // Пустое имя игрока
                        blockEntity.getBlockPos(),
                        blockEntity.isAllowInteraction(),
                        blockEntity.isAllowBreaking(),
                        blockEntity.isAllowPlacing()
                ));

                minecraft.player.displayClientMessage(Component.literal("Все изменения отправлены на сервер!"), true);
            }
        } catch (NumberFormatException e) {
            minecraft.player.displayClientMessage(Component.literal("Введите корректные данные!"), true);
            BFME.LOGGER.error("Error parsing coordinate values: {}", e.getMessage());
        }
    }



    private void addPlayer() {
        String playerName = playerField.getValue().trim().toLowerCase();
        if (!playerName.isEmpty() && blockEntity != null) {
            blockEntity.addAllowedPlayer(playerName); // Локальное обновление

            // Отправка данных на сервер
            PacketDistributor.sendToServer(new PrivateBlockPayload(
                    0, 0, 0, 0, 0, 0, // Координаты не важны
                    playerName, // Имя игрока
                    blockEntity.getBlockPos(),
                    false, false, false // Флаги не важны
            ));
            minecraft.player.displayClientMessage(Component.literal("Игрок добавлен: " + playerName), true);
            playerField.setValue(""); // Очистка поля
        } else {
            minecraft.player.displayClientMessage(Component.literal("Введите корректное имя!"), true);
        }
    }

    private void removePlayer() {
        String playerName = playerField.getValue().trim().toLowerCase(); // Приведение имени к нижнему регистру
        if (!playerName.isEmpty()) {
            if (blockEntity.getAllowedPlayers().contains(playerName)) {
                // Удаляем игрока локально и отправляем данные на сервер
                blockEntity.removeAllowedPlayer(playerName); // Обновляем локально для текущего клиента
                PacketDistributor.sendToServer(new PrivateBlockPayload(
                        0, 0, 0, 0, 0, 0, // Координаты не нужны
                        "-" + playerName, // Используем префикс '-' для указания на удаление игрока
                        blockEntity.getBlockPos(),
                        false, false, false // Флаги не важны
                ));
                minecraft.player.displayClientMessage(Component.literal("Игрок удалён: " + playerName), true);
            } else {
                minecraft.player.displayClientMessage(Component.literal("Игрок не найден: " + playerName), true);
            }
            playerField.setValue(""); // Очистка поля
        } else {
            minecraft.player.displayClientMessage(Component.literal("Введите корректное имя!"), true);
        }
    }



    private EditBox createEditBox(int x, int y, String hint, boolean isNumeric) {
        int width = hint.equals("Игрок") ? 150 : 40; // Для поля "Игрок" устанавливаем ширину 150, для остальных — 40
        EditBox editBox = new EditBox(this.font, x, y, width, 20, Component.literal(hint));
        if (isNumeric) {
            // Устанавливаем фильтр для чисел
            editBox.setFilter(s -> s.matches("\\d*")); // Разрешаем только числа
        } else {
            // Убираем фильтр для текстового ввода
            editBox.setFilter(s -> true);
        }
        editBox.setValue(""); // Устанавливаем пустое значение по умолчанию
        return editBox;
    }



    private void loadInitialValues() {
        if (blockEntity == null) {
            BFME.LOGGER.error("BlockEntity is null");
            minecraft.player.displayClientMessage(Component.literal("Блок привата не найден."), true);
            return;
        }

        int[] coords = blockEntity.getCoordinates();
        xPositiveField.setValue(String.valueOf(coords[0]));
        xNegativeField.setValue(String.valueOf(coords[1]));
        yPositiveField.setValue(String.valueOf(coords[2]));
        yNegativeField.setValue(String.valueOf(coords[3]));
        zPositiveField.setValue(String.valueOf(coords[4]));
        zNegativeField.setValue(String.valueOf(coords[5]));
    }

    private String getFlagButtonLabel(String label, boolean state) {
        return label + ": " + (state ? "Включено" : "Выключено");
    }

    private void updateButtonLabel(Button button, String label, boolean state) {
        button.setMessage(Component.literal(getFlagButtonLabel(label, state)));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        guiGraphics.drawCenteredString(this.font, this.title.getString(), this.width / 2, 10, 0xFFFFFF);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderTransparentBackground(guiGraphics);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int centerX = (this.width - IMAGE_WIDTH) / 2;
        int centerY = (this.height - IMAGE_HEIGHT) / 2;
        guiGraphics.blit(GUI_TEXTURE, centerX, centerY, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }

    @Override
    public PrivateBlockMenu getMenu() {
        return menu;
    }
}