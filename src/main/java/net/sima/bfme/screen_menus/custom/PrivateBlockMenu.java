package net.sima.bfme.screen_menus.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.sima.bfme.block.entity.PrivateBlockEntity;
import net.sima.bfme.screen_menus.ModMenuTypes;

public class PrivateBlockMenu extends AbstractContainerMenu {
    public final PrivateBlockEntity blockEntity;


    /**
     * Основной конструктор для создания меню.
     */
    public PrivateBlockMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }


    public PrivateBlockMenu(int containerId, Inventory inventory, BlockEntity blockEntity) {
        super(ModMenuTypes.PRIVATE_BLOCK_MENU.get(), containerId);
        this.blockEntity = ((PrivateBlockEntity)blockEntity); // Устанавливаем позицию блока

    }


    @Override
    public boolean stillValid(Player player) {
        return true; // Вы можете добавить проверку на расстояние до блока, если необходимо.
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY; // Логика для перемещения предметов, если понадобится.
    }
}
