package net.sima.bfme.screen_menus.crafting_menus;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;
import net.sima.bfme.recipe.ModRecipes;
import net.sima.bfme.screen_menus.ModMenuTypes;
import net.sima.bfme.screen_menus.custom.BaseFurnaceMenu;

public class HumanFurnaceMenu extends BaseFurnaceMenu {
    public HumanFurnaceMenu(int containerId, Inventory playerInventory) {
        super(ModMenuTypes.HUMAN_FURNACE.get(), ModRecipes.HUMAN_TYPE.get(), containerId, playerInventory);
    }

    public HumanFurnaceMenu(int containerId, Inventory playerInventory, Container furnaceContainer, ContainerData furnaceData) {
        super(ModMenuTypes.HUMAN_FURNACE.get(), ModRecipes.HUMAN_TYPE.get(), containerId, playerInventory, furnaceContainer, furnaceData);
    }
}
