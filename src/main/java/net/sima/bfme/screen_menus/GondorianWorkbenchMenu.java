package net.sima.bfme.screen_menus;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.Blocks;
import net.sima.bfme.block.ModBlocks;


public class GondorianWorkbenchMenu extends CraftingMenu {

    private final ContainerLevelAccess access;
    public GondorianWorkbenchMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public GondorianWorkbenchMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(containerId, playerInventory, access);
        this.access = access;
    }

    @Override
    public MenuType<?> getType() {
        return ModMenuTypes.GONDORIAN_WORKBENCH_MENU.get();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.GONDORIAN_WORKBENCH.get());
    }

}
