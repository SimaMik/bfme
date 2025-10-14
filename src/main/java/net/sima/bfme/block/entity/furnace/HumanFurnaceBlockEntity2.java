package net.sima.bfme.block.entity.furnace;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.ModBlockEntities;
import net.sima.bfme.recipe.BaseFurnaceRecipe;
import net.sima.bfme.recipe.ModRecipes;
import net.sima.bfme.recipe.recipes.HumanFurnaceRecipe;
import net.sima.bfme.screen_menus.crafting_menus.HumanFurnaceMenu;
import net.sima.bfme.screen_menus.custom.DualRecipeInput;

import javax.annotation.Nullable;
import java.util.Optional;

public class HumanFurnaceBlockEntity2 extends BaseContainerBlockEntity implements RecipeCraftingHolder {
    private static final int TOTAL_INPUT_SLOTS = 8;
    private static final int TOTAL_OUTPUT_SLOTS = 4;
    private static final int FUEL_SLOT = TOTAL_INPUT_SLOTS + TOTAL_OUTPUT_SLOTS; // Последний слот
    private static final int TOTAL_SLOTS = FUEL_SLOT + 1; // Все слоты

    private NonNullList<ItemStack> items;
    protected final ContainerData dataAccess;

    private final RecipeHolder<?>[] activeRecipes = new RecipeHolder<?>[TOTAL_INPUT_SLOTS / 2];

    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime;

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<DualRecipeInput, HumanFurnaceRecipe> quickCheck;

    public HumanFurnaceBlockEntity2(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HUMAN_FURNACE.get(), pos, state);
        this.items = NonNullList.withSize(TOTAL_SLOTS, ItemStack.EMPTY);
        this.dataAccess = new ContainerData() {
            public int get(int p_58431_) {
                switch (p_58431_) {
                    case 0:
                        if (HumanFurnaceBlockEntity2.this.litDuration > 32767) {
                            return Mth.floor((double) HumanFurnaceBlockEntity2.this.litTime / (double) HumanFurnaceBlockEntity2.this.litDuration * 32767.0);
                        }

                        return HumanFurnaceBlockEntity2.this.litTime;
                    case 1:
                        return Math.min(HumanFurnaceBlockEntity2.this.litDuration, 32767);
                    case 2:
                        return HumanFurnaceBlockEntity2.this.cookingProgress;
                    case 3:
                        return HumanFurnaceBlockEntity2.this.cookingTotalTime;
                    default:
                        return 0;
                }
            }

            public void set(int p_58433_, int p_58434_) {
                switch (p_58433_) {
                    case 0 -> HumanFurnaceBlockEntity2.this.litTime = p_58434_;
                    case 1 -> HumanFurnaceBlockEntity2.this.litDuration = p_58434_;
                    case 2 -> HumanFurnaceBlockEntity2.this.cookingProgress = p_58434_;
                    case 3 -> HumanFurnaceBlockEntity2.this.cookingTotalTime = p_58434_;
                }

            }

            public int getCount() {
                return 4;
            }
        };
        this.recipesUsed = new Object2IntOpenHashMap<>();
        this.quickCheck = RecipeManager.createCheck(ModRecipes.HUMAN_TYPE.get());
    }

    private boolean isLit() {
        return litTime > 0;
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, HumanFurnaceBlockEntity2 blockEntity) {
        boolean wasLit = blockEntity.isLit();
        boolean stateChanged = false;

        // Обработка топлива
        blockEntity.handleFuel();

        // Обработка готовки
        if (blockEntity.isLit() && blockEntity.canBurn()) {
            blockEntity.cookingProgress++;
            if (blockEntity.cookingProgress >= blockEntity.cookingTotalTime) {
                blockEntity.burnAllPairs();
                blockEntity.cookingProgress = 0;
                stateChanged = true;
            }
        } else {
            blockEntity.cookingProgress = 0;
        }

        // Обновление состояния блока
        if (wasLit != blockEntity.isLit()) {
            stateChanged = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (stateChanged) {
            setChanged(level, pos, state);
        }
    }

    private void handleFuel() {
        if (isLit()) {
            litTime--;
        }

        ItemStack fuelStack = items.get(FUEL_SLOT);
        if (!isLit() && !fuelStack.isEmpty() && canBurn()) {
            litTime = getBurnDuration(fuelStack);
            litDuration = litTime;

            if (isLit()) {
                fuelStack.shrink(1);
            }
        }
    }

    private boolean canBurn() {
        return getCurrentRecipe().isPresent();
    }


    private int getFirstBurnableSlot() {
        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {
            if (canBurnSlotPair(i)) {
                return i;
            }
        }
        return -1;
    }
    private boolean canBurnSlotPair(int pairIndex) {
        int topIndex = pairIndex * 2;
        int bottomIndex = topIndex + 1;

        ItemStack topStack = items.get(topIndex);
        ItemStack bottomStack = items.get(bottomIndex);

        return !topStack.isEmpty() && !bottomStack.isEmpty() &&
                getCurrentRecipe().isPresent();
    }


    private void burnAllPairs() {
        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {
            if (canBurnSlotPair(i)) {
                burnSlotPair(i);
            }
        }
    }

    private void burnSlotPair(int pairIndex) {
        int topIndex = pairIndex * 2;
        int bottomIndex = topIndex + 1;
        int outputIndex = TOTAL_INPUT_SLOTS + pairIndex;

        ItemStack topStack = items.get(topIndex);
        ItemStack bottomStack = items.get(bottomIndex);

        Optional<RecipeHolder<HumanFurnaceRecipe>> optionalRecipe = getCurrentRecipe();
        if (optionalRecipe.isPresent()) {
            BaseFurnaceRecipe recipe = optionalRecipe.get().value();
            ItemStack result = recipe.assemble(null, null);
            ItemStack outputStack = items.get(outputIndex);

            if (outputStack.isEmpty()) {
                items.set(outputIndex, result);
            } else {
                outputStack.grow(result.getCount());
            }

            topStack.shrink(1);
            bottomStack.shrink(1);
            activeRecipes[pairIndex] = optionalRecipe.get();
            setRecipeUsed(optionalRecipe.get());
        }
    }

    private Optional<RecipeHolder<HumanFurnaceRecipe>> getCurrentRecipe() {
        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {
            int topIndex = i * 2;
            int bottomIndex = topIndex + 1;

            ItemStack topStack = items.get(topIndex);
            ItemStack bottomStack = items.get(bottomIndex);

            if (!topStack.isEmpty() && !bottomStack.isEmpty()) {
                Optional<RecipeHolder<HumanFurnaceRecipe>> recipe = level.getRecipeManager()
                        .getRecipeFor(ModRecipes.HUMAN_TYPE.get(), new DualRecipeInput(topStack, bottomStack), level);

                if (recipe.isPresent()) {
                    return recipe;
                }
            }
        }
        return Optional.empty();
    }



    private int getBurnDuration(ItemStack fuel) {
        return fuel.getBurnTime(ModRecipes.HUMAN_TYPE.get());
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, items, true, registries);
        tag.putInt("LitTime", litTime);
        tag.putInt("LitDuration", litDuration);
        tag.putInt("CookingProgress", cookingProgress);
        tag.putInt("CookingTotalTime", cookingTotalTime);

        CompoundTag recipesTag = new CompoundTag();
        this.recipesUsed.forEach((recipeId, count) -> recipesTag.putInt(recipeId.toString(), count));
        tag.put("RecipesUsed", recipesTag);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        ContainerHelper.loadAllItems(tag, items, registries);
        litTime = tag.getInt("LitTime");
        litDuration = tag.getInt("LitDuration");
        cookingProgress = tag.getInt("CookingProgress");
        cookingTotalTime = tag.getInt("CookingTotalTime");

        CompoundTag recipesTag = tag.getCompound("RecipesUsed");
        this.recipesUsed.clear();
        for (String key : recipesTag.getAllKeys()) {
            this.recipesUsed.put(BFME.resource(key), recipesTag.getInt(key));
        }
    }


    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = getItem(i);
            if(!stack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new HumanFurnaceMenu(id, player, this, this.dataAccess);

    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Custom Furnace");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }
    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipeHolder) {
        if (recipeHolder != null) {
            ResourceLocation recipeId = recipeHolder.id();
            this.recipesUsed.addTo(recipeId, 1); // Увеличиваем счётчик использования для этого рецепта
        }
    }

    @Override
    @Nullable
    public RecipeHolder<?> getRecipeUsed() {
        for (RecipeHolder<?> recipe : activeRecipes) {
            if (recipe != null) {
                return recipe; // Возвращаем первый найденный активный рецепт
            }
        }
        return null; // Если активных рецептов нет
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}
