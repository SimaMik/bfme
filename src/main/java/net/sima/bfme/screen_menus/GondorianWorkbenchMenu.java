//package net.sima.bfme.screen_menus;
//
//import net.minecraft.core.NonNullList;
//import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.Container;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.player.StackedContents;
//import net.minecraft.world.inventory.*;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.CraftingRecipe;
//import net.minecraft.world.item.crafting.Recipe;
//import net.minecraft.world.item.crafting.RecipeHolder;
//import net.minecraft.world.item.crafting.RecipeType;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.sima.bfme.block.ModBlocks;
//import net.sima.bfme.recipe.GondorianRecipe;
//import net.sima.bfme.recipe.GondorianRecipeType;
//
//import java.util.Optional;
//
//public class GondorianWorkbenchMenu extends RecipeBookMenu<CraftingContainer> {
//    private final CraftingContainer craftSlots = new TransientCraftingContainer(this, 3, 3);
//    private final ResultContainer resultSlots = new ResultContainer();
//    private final ContainerLevelAccess access;
//    private final Player player;
//
//    public GondorianWorkbenchMenu(int pContainerId, Inventory pPlayerInventory) {
//        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
//    }
//
//    public GondorianWorkbenchMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
//        super(MenuType.CRAFTING, pContainerId);
//        this.access = pAccess;
//        this.player = pPlayerInventory.player;
//        this.addSlot(new ResultSlot(pPlayerInventory.player, this.craftSlots, this.resultSlots, 0, 124, 35) {
//            @Override
//            public void onTake(Player pPlayer, ItemStack pStack) {
//                this.checkTakeAchievements(pStack);
//                net.neoforged.neoforge.common.CommonHooks.setCraftingPlayer(pPlayer);
//                NonNullList<ItemStack> remainingStacks = pPlayer.level().getRecipeManager().getRemainingItemsFor(GondorianRecipeType.INSTANCE, GondorianWorkbenchMenu.this.craftSlots, pPlayer.level());
//                net.neoforged.neoforge.common.CommonHooks.setCraftingPlayer(null);
//
//                for (int i = 0; i < remainingStacks.size(); i++) {
//                    ItemStack inputStack = GondorianWorkbenchMenu.this.craftSlots.getItem(i);
//                    ItemStack remainingStack = remainingStacks.get(i);
//                    if (!inputStack.isEmpty()) {
//                        GondorianWorkbenchMenu.this.craftSlots.removeItem(i, 1);
//                        inputStack = GondorianWorkbenchMenu.this.craftSlots.getItem(i);
//                    }
//
//                    if (!remainingStack.isEmpty()) {
//                        if (inputStack.isEmpty()) {
//                            GondorianWorkbenchMenu.this.craftSlots.setItem(i, remainingStack);
//                        } else if (ItemStack.isSameItemSameComponents(inputStack, remainingStack)) {
//                            remainingStack.grow(inputStack.getCount());
//                            GondorianWorkbenchMenu.this.craftSlots.setItem(i, remainingStack);
//                        } else if (!GondorianWorkbenchMenu.this.player.getInventory().add(remainingStack)) {
//                            GondorianWorkbenchMenu.this.player.drop(remainingStack, false);
//                        }
//                    }
//                }
//            }
//        });
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
//            }
//        }
//
//        for (int k = 0; k < 3; k++) {
//            for (int i1 = 0; i1 < 9; i1++) {
//                this.addSlot(new Slot(pPlayerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
//            }
//        }
//
//        for (int l = 0; l < 9; l++) {
//            this.addSlot(new Slot(pPlayerInventory, l, 8 + l * 18, 142));
//        }
//    }
//    @Override
//    public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
//        this.craftSlots.fillStackedContents(pItemHelper);
//    }
//    @Override
//    public void clearCraftingContent() {
//        this.craftSlots.clearContent();
//        this.resultSlots.clearContent();
//    }
//    @Override
//    public boolean recipeMatches(RecipeHolder<? extends Recipe<CraftingContainer>> pRecipe) {
//        return pRecipe.value().matches(this.craftSlots, this.player.level());
//    }
//    @Override
//    public void removed(Player pPlayer) {
//        super.removed(pPlayer);
//        this.access.execute((level, blockPos) -> this.clearContainer(pPlayer, this.craftSlots));
//    }
//    @Override
//    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
//        ItemStack itemstack = ItemStack.EMPTY;
//        Slot slot = this.slots.get(pIndex);
//        if (slot != null && slot.hasItem()) {
//            ItemStack itemstack1 = slot.getItem();
//            itemstack = itemstack1.copy();
//            if (pIndex == 0) {
//                this.access.execute((p_39378_, p_39379_) -> itemstack1.getItem().onCraftedBy(itemstack1, p_39378_, pPlayer));
//                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
//                    return ItemStack.EMPTY;
//                }
//
//                slot.onQuickCraft(itemstack1, itemstack);
//            } else if (pIndex >= 10 && pIndex < 46) {
//                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
//                    if (pIndex < 37) {
//                        if (!this.moveItemStackTo(itemstack1, 37, 46, false)) {
//                            return ItemStack.EMPTY;
//                        }
//                    } else if (!this.moveItemStackTo(itemstack1, 10, 37, false)) {
//                        return ItemStack.EMPTY;
//                    }
//                }
//            } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (itemstack1.isEmpty()) {
//                slot.setByPlayer(ItemStack.EMPTY);
//            } else {
//                slot.setChanged();
//            }
//
//            if (itemstack1.getCount() == itemstack.getCount()) {
//                return ItemStack.EMPTY;
//            }
//
//            slot.onTake(pPlayer, itemstack1);
//            if (pIndex == 0) {
//                pPlayer.drop(itemstack1, false);
//            }
//        }
//
//        return itemstack;
//    }
//    @Override
//    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
//        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
//    }
//    @Override
//    public boolean stillValid(Player player) {
//        return stillValid(this.access, player, ModBlocks.GONDORIAN_WORKBENCH.get());
//    }
//    @Override
//    public void slotsChanged(Container pInventory) {
//        this.access.execute((level, pos) -> slotChangedCraftingGrid(this, level, this.player, this.craftSlots, this.resultSlots));
//    }
//
//    protected static void slotChangedCraftingGrid(
//            AbstractContainerMenu pMenu, Level pLevel, Player pPlayer, CraftingContainer pContainer, ResultContainer pResult
//    ) {
//        if (!pLevel.isClientSide) {
//            ServerPlayer serverplayer = (ServerPlayer)pPlayer;
//            ItemStack itemstack = ItemStack.EMPTY;
//            Optional<RecipeHolder<GondorianRecipe>> optional = pLevel.getServer().getRecipeManager().getRecipeFor(GondorianRecipeType.INSTANCE, pContainer, pLevel);
//            if (optional.isPresent()) {
//                RecipeHolder<GondorianRecipe> recipeholder = optional.get();
//                GondorianRecipe craftingrecipe = recipeholder.value();
//                if (pResult.setRecipeUsed(pLevel, serverplayer, recipeholder)) {
//                    ItemStack itemstack1 = craftingrecipe.assemble(pContainer, pLevel.registryAccess());
//                    if (itemstack1.isItemEnabled(pLevel.enabledFeatures())) {
//                        itemstack = itemstack1;
//                    }
//                }
//            }
//
//            pResult.setItem(0, itemstack);
//            pMenu.setRemoteSlot(0, itemstack);
//            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(pMenu.containerId, pMenu.incrementStateId(), 0, itemstack));
//        }
//    }
//    @Override
//    public int getResultSlotIndex() {
//        return 0;
//    }
//
//    @Override
//    public int getGridWidth() {
//        return this.craftSlots.getWidth();
//    }
//
//    @Override
//    public int getGridHeight() {
//        return this.craftSlots.getHeight();
//    }
//
//    @Override
//    public int getSize() {
//        return 10;
//    }
//
//    @Override
//    public RecipeBookType getRecipeBookType() {
//        return RecipeBookType.CRAFTING;
//    }
//
//    @Override
//    public boolean shouldMoveToInventory(int pSlotIndex) {
//        return pSlotIndex != this.getResultSlotIndex();
//    }
//}
//
//
//
