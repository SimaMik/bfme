package net.sima.bfme.screen_menus.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.BFME;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

@OnlyIn(Dist.CLIENT)
public class RedBookOfWestmarchScreen extends Screen {
    private static final ResourceLocation BOOK_TEXTURE = ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "textures/gui/red_book_of_westmarch.png");
    private EditBox nameInput;
    private Button confirmButton;

    public RedBookOfWestmarchScreen() {
        super(Component.literal("Алая книга"));
    }

    @Override
    protected void init() {
        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        // Поле для ввода имени на второй странице
        this.nameInput = new EditBox(this.font, x + 20, y + 80, 140, 20, Component.literal("Enter name"));
        this.nameInput.setMaxLength(20);
        this.addRenderableWidget(this.nameInput);

        // Кнопка для подтверждения имени
        this.confirmButton = Button.builder(Component.literal("Confirm"), button -> setPlayerName())
                .bounds(x + 70, y + 110, 60, 20)
                .createNarration(narration -> narration.get())
                .build();
        this.addRenderableWidget(this.confirmButton);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int x = (this.width - 192) / 2;
        int y = (this.height - 192) / 2;

        // Рендер текстуры книги
        guiGraphics.blit(BOOK_TEXTURE, x, y, 0, 0, 192, 192);

        // Рендер текстового поля и кнопки
        this.nameInput.render(guiGraphics, mouseX, mouseY, partialTick);
        this.confirmButton.render(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private void setPlayerName() {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null) {
            String newName = this.nameInput.getValue().trim();

            if (newName.isEmpty()) {
                player.displayClientMessage(Component.literal("Имя не может быть пустым!"), false);
                return; // Прекратить выполнение, если имя пустое
            }

            // Получаем данные игрока через PlayerDataProvider
            PlayerData playerData = PlayerDataProvider.PLAYER_DATA_CAPABILITY.getCapability(player, null);
            if (playerData != null) {
                // Устанавливаем новое имя
                playerData.setCustomName(newName, player);
                player.displayClientMessage(Component.literal("Ваше имя установлено как " + newName), false);
            } else {
                player.displayClientMessage(Component.literal("Не удалось установить имя"), false);
            }
        }

    }
}
