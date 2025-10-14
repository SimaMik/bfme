package net.sima.bfme.screen_menus.custom;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.sima.bfme.handler.BaseItemStackHandler;
import net.sima.bfme.screen_menus.crafting_help.ExtendedCraftingInventory;
import net.sima.bfme.screen_menus.crafting_help.TableCraftingInput;
import net.sima.bfme.screen_menus.crafting_help.TableOutputSlot;

import java.util.Optional;

public class BaseCraftingContainerMenu extends AbstractContainerMenu {
    private boolean isVanillaRecipe;
    protected final Level level;
    protected final Container result;
    protected final ExtendedCraftingInventory matrix;
    private final RecipeType<?> modRecipeType;

    public BaseCraftingContainerMenu(MenuType<?> type, int id, Inventory playerInventory, BaseItemStackHandler inventory, int size, RecipeType<?> modRecipeType) {
        super(type, id);
        this.isVanillaRecipe = false;
        this.level = playerInventory.player.level();
        this.result = new ResultContainer();
        this.matrix = new ExtendedCraftingInventory(this, inventory, size);
        this.modRecipeType = modRecipeType;
        this.addSlot(new TableOutputSlot(this, this.matrix, this.result, 0, 124, 35, modRecipeType));
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.matrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        // Добавление слотов инвентаря игрока
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 142));
        }

        this.slotsChanged(this.matrix);
    }

    public void slotsChanged(Container matrix) {
        TableCraftingInput inventory = this.matrix.asCraft();

        Optional<RecipeHolder<Recipe<TableCraftingInput>>> recipe = this.level.getRecipeManager()
                .getRecipeFor((RecipeType)modRecipeType, inventory, this.level);


        setVanillaRecipe(false);

        if (recipe.isPresent()) {
            ItemStack result = recipe.get().value().assemble(inventory, this.level.registryAccess());
            this.result.setItem(0, result);
        } else {
            // Проверка ванильного рецепта
            Optional<RecipeHolder<CraftingRecipe>> vanilla = this.level.getRecipeManager()
                    .getRecipeFor(RecipeType.CRAFTING, inventory, this.level);

            if (vanilla.isPresent()) {
                ItemStack result = vanilla.get().value().assemble(inventory, this.level.registryAccess());
                setVanillaRecipe(true);
                this.result.setItem(0, result);
            } else {
                this.result.setItem(0, ItemStack.EMPTY);
            }
        }

        // Вызов родительского метода для обновления интерфейса
        super.slotsChanged(matrix);
    }

    public ItemStack quickMoveStack(Player player, int slotNumber) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotNumber);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (slotNumber == 0) {
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (slotNumber >= 10 && slotNumber < 46) {
                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    public boolean stillValid(Player player) {
        return true;
    }


    @Override
    public void removed(Player player) {
        super.removed(player);

        // Переносим все оставшиеся предметы из сетки крафта в инвентарь игрока
        for (int i = 0; i < matrix.getContainerSize(); ++i) {
            ItemStack stack = matrix.removeItemNoUpdate(i);
            if (!stack.isEmpty()) {
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false); // Если инвентарь полный, выбрасываем предмет на землю
                }
            }
        }
    }

    public boolean isVanillaRecipe() {
        return this.isVanillaRecipe;
    }
    public void setVanillaRecipe(boolean isVanillaRecipe) {
        this.isVanillaRecipe = isVanillaRecipe;
    }
}
