package net.sima.bfme.screen_menus.custom;

import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.sima.bfme.recipe.BaseFurnaceRecipe;
import net.sima.bfme.screen_menus.crafting_help.ModFurnaceFuelSlot;

public abstract class BaseFurnaceMenu extends AbstractContainerMenu {

    private static final int TOTAL_INPUT_SLOTS = 8; // 4 верхних + 4 нижних
    private static final int TOTAL_OUTPUT_SLOTS = 4;
    private static final int FUEL_SLOT = TOTAL_INPUT_SLOTS + TOTAL_OUTPUT_SLOTS; // Слот топлива
    private static final int SLOT_COUNT = FUEL_SLOT + 1;
    private static final int INV_SLOT_START = SLOT_COUNT;
    private static final int INV_SLOT_END = INV_SLOT_START + 27;
    private static final int USE_ROW_SLOT_START = INV_SLOT_END;
    private static final int USE_ROW_SLOT_END = USE_ROW_SLOT_START + 9;

    private final Container container;
    private final ContainerData data;
    private final Level level;
    private final RecipeType<? extends BaseFurnaceRecipe> recipeType;

    protected BaseFurnaceMenu(MenuType<?> menuType, RecipeType<? extends BaseFurnaceRecipe> recipeType, int containerId, Inventory playerInventory) {
        this(menuType, recipeType, containerId, playerInventory, new SimpleContainer(13), new SimpleContainerData(4));
    }
    protected BaseFurnaceMenu(
            MenuType<?> menuType,
            RecipeType<? extends BaseFurnaceRecipe> recipeType,
            int containerId,
            Inventory playerInventory,
            Container container,
            ContainerData data) {
        super(menuType, containerId);
        this.recipeType = recipeType;
        this.container = container;
        this.data = data;
        this.level = playerInventory.player.level();
        checkContainerSize(container, SLOT_COUNT);
        checkContainerDataCount(data, 4);

        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {
            int x = 53 + i * 18;
            int y = 21;
            this.addSlot(new Slot(container, i, x, y));
        }

        // Нижний ряд инпут слотов
        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {
            int x = 53 + i * 18;
            int y = 39;
            this.addSlot(new Slot(container, TOTAL_INPUT_SLOTS / 2 + i, x, y));
        }

        // Слоты результата
        for (int i = 0; i < TOTAL_OUTPUT_SLOTS; i++) {
            int x = 53 + i * 18;
            int y = 85;
            this.addSlot(new FurnaceResultSlot(playerInventory.player, container, TOTAL_INPUT_SLOTS + i, x, y));
        }

        // Слот топлива
        this.addSlot(new ModFurnaceFuelSlot(this, container, FUEL_SLOT, 80, 129));

        // Слоты инвентаря игрока
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 151 + row * 18));
            }
        }

        // Быстрая строка
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 209));
        }


        this.addDataSlots(data);
    }

    public float getBurnProgress() {
        int progress = this.data.get(2);
        int totalTime = this.data.get(3);
        return totalTime != 0 && progress != 0 ? Mth.clamp((float) progress / (float) totalTime, 0.0F, 1.0F) : 0.0F;
    }

    public float getLitProgress() {
        int duration = this.data.get(1);
        if (duration == 0) {
            duration = 200; // Стандартное значение
        }
        return Mth.clamp((float) this.data.get(0) / (float) duration, 0.0F, 1.0F);
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();

            if (index < SLOT_COUNT) {
                // Перемещение из печи в инвентарь
                if (!this.moveItemStackTo(stackInSlot, SLOT_COUNT, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Перемещение в печь
                if (this.canSmelt(stackInSlot)) {
                    if (!this.moveItemStackTo(stackInSlot, 0, TOTAL_INPUT_SLOTS, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(stackInSlot)) {
                    if (!this.moveItemStackTo(stackInSlot, FUEL_SLOT, FUEL_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < SLOT_COUNT + 27) {
                    if (!this.moveItemStackTo(stackInSlot, SLOT_COUNT + 27, this.slots.size(), false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(stackInSlot, SLOT_COUNT, SLOT_COUNT + 27, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stackInSlot.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stackInSlot);
        }

        return itemstack;
    }
    private boolean canSmelt(ItemStack stack) {
        return this.level.getRecipeManager()
                .getRecipeFor(this.recipeType, new DualRecipeInput(stack, ItemStack.EMPTY), this.level)
                .isPresent();
    }

    public boolean isFuel(ItemStack stack) {
        return stack.getBurnTime(null) > 0;
    }
}
