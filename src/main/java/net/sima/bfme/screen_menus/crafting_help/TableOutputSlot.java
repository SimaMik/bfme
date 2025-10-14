package net.sima.bfme.screen_menus.crafting_help;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.CommonHooks;
import net.sima.bfme.screen_menus.custom.BaseCraftingContainerMenu;

public class TableOutputSlot extends Slot {
    private final AbstractContainerMenu container;
    private final ExtendedCraftingInventory matrix;
    private final RecipeType<?> modRecipeType;
    public TableOutputSlot(AbstractContainerMenu container, ExtendedCraftingInventory matrix, Container inventory, int index, int xPosition, int yPosition, RecipeType<?> modRecipeType) {
        super(inventory, index, xPosition, yPosition);
        this.container = container;
        this.matrix = matrix;
        this.modRecipeType = modRecipeType;
    }

    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    public void onTake(Player player, ItemStack stack) {
        boolean isVanilla = false;
        AbstractContainerMenu var6 = this.container;
        if (var6 instanceof BaseCraftingContainerMenu table) {
            isVanilla = table.isVanillaRecipe();
        } else {
            var6 = this.container;
        }

        CommonHooks.setCraftingPlayer(player);
        Level level = player.level();
        TableCraftingInput inventory = this.matrix.asCraft();
        NonNullList remaining;
        if (isVanilla) {
            remaining = level.getRecipeManager().getRemainingItemsFor(RecipeType.CRAFTING, inventory, level);
        } else {
            remaining = level.getRecipeManager().getRemainingItemsFor((RecipeType)this.modRecipeType, inventory, level);
        }

        CommonHooks.setCraftingPlayer((Player)null);

        for(int k = 0; k < inventory.height(); ++k) {
            for(int l = 0; l < inventory.width(); ++l) {
                int index = l + inventory.left() + (k + inventory.top()) * this.matrix.getWidth();
                ItemStack slotStack = this.matrix.getItem(index);
                if (!slotStack.isEmpty()) {
                    this.matrix.removeItem(index, 1);
                    slotStack = this.matrix.getItem(index);
                }

                ItemStack remainingStack = (ItemStack)remaining.get(l + k * inventory.width());
                if (!remainingStack.isEmpty()) {
                    if (slotStack.isEmpty()) {
                        this.matrix.setItem(index, remainingStack);
                    } else if (ItemStack.isSameItemSameComponents(slotStack, remainingStack)) {
                        remainingStack.grow(slotStack.getCount());
                        this.matrix.setItem(index, remainingStack);
                    } else if (!player.getInventory().add(remainingStack)) {
                        player.drop(remainingStack, false);
                    }
                }
            }
        }

        this.container.slotsChanged(this.matrix);
    }
}
