package net.sima.bfme.screen_menus.crafting_menus;

import net.minecraft.world.entity.player.Inventory;
import net.sima.bfme.handler.BaseItemStackHandler;
import net.sima.bfme.recipe.ModRecipes;
import net.sima.bfme.screen_menus.ModMenuTypes;
import net.sima.bfme.screen_menus.custom.BaseCraftingContainerMenu;

public class GondorianCraftingMenu extends BaseCraftingContainerMenu {

    public GondorianCraftingMenu(int id, Inventory playerInventory, BaseItemStackHandler inventory) {
        super(ModMenuTypes.GONDORIAN_CRAFTING.get(), id, playerInventory, inventory, 3, ModRecipes.GONDORIAN_TYPE.get());
    }

    public static GondorianCraftingMenu create(int windowId, Inventory playerInventory, BaseItemStackHandler inventory) {
        return new GondorianCraftingMenu(windowId, playerInventory, inventory);
    }

    public static GondorianCraftingMenu create(int windowId, Inventory playerInventory) {
        BaseItemStackHandler inventory = new BaseItemStackHandler(9, slot -> {});
        return new GondorianCraftingMenu(windowId, playerInventory, inventory);
    }
}
