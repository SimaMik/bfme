package net.sima.bfme.block.entity;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.ResourceLocationException;
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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.BFME;
import net.sima.bfme.recipe.BaseFurnaceRecipe;
import net.sima.bfme.screen_menus.custom.DualRecipeInput;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class BaseFurnaceBlockEntity extends BaseContainerBlockEntity implements RecipeCraftingHolder {
    private static final int TOTAL_INPUT_SLOTS = 8;
    private static final int TOTAL_OUTPUT_SLOTS = 4;
    private static final int FUEL_SLOT = TOTAL_INPUT_SLOTS + TOTAL_OUTPUT_SLOTS; // Последний слот
    private static final int TOTAL_SLOTS = FUEL_SLOT + 1; // Все слоты

    private final RecipeType<? extends BaseFurnaceRecipe> recipeType;
    private NonNullList<ItemStack> items;
    protected final ContainerData dataAccess;

    private final RecipeHolder<?>[] activeRecipes = new RecipeHolder<?>[TOTAL_INPUT_SLOTS / 2];

    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime = 200;

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<DualRecipeInput, BaseFurnaceRecipe> quickCheck;

    protected BaseFurnaceBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, RecipeType<? extends BaseFurnaceRecipe> recipeType) {
        super(type, pos, state);
        this.items = NonNullList.withSize(TOTAL_SLOTS, ItemStack.EMPTY);
        this.dataAccess = new ContainerData() {
            public int get(int p_58431_) {
                switch (p_58431_) {
                    case 0:
                        if (BaseFurnaceBlockEntity.this.litDuration > 32767) {
                            return Mth.floor((double) BaseFurnaceBlockEntity.this.litTime / (double) BaseFurnaceBlockEntity.this.litDuration * 32767.0);
                        }

                        return BaseFurnaceBlockEntity.this.litTime;
                    case 1:
                        return Math.min(BaseFurnaceBlockEntity.this.litDuration, 32767);
                    case 2:
                        return BaseFurnaceBlockEntity.this.cookingProgress;
                    case 3:
                        return BaseFurnaceBlockEntity.this.cookingTotalTime;
                    default:
                        return 0;
                }
            }

            public void set(int p_58433_, int p_58434_) {
                switch (p_58433_) {
                    case 0 -> BaseFurnaceBlockEntity.this.litTime = p_58434_;
                    case 1 -> BaseFurnaceBlockEntity.this.litDuration = p_58434_;
                    case 2 -> BaseFurnaceBlockEntity.this.cookingProgress = p_58434_;
                    case 3 -> BaseFurnaceBlockEntity.this.cookingTotalTime = p_58434_;
                }

            }

            public int getCount() {
                return 4;
            }
        };
        this.recipesUsed = new Object2IntOpenHashMap<>();
        this.recipeType = recipeType;
        this.quickCheck = RecipeManager.createCheck((RecipeType)recipeType);
    }

    private boolean isLit() {
        return litTime > 0;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BaseFurnaceBlockEntity blockEntity) {
        BFME.LOGGER.info("ServerTick: LitTime={}, IsLit={}, CookingProgress={}/{}", blockEntity.litTime, blockEntity.isLit(), blockEntity.cookingProgress, blockEntity.cookingTotalTime);
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
        BFME.LOGGER.info("Handling fuel: LitTime={}, IsLit={}, FuelStack={}", litTime, isLit(), items.get(FUEL_SLOT));
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
        boolean result = getCurrentRecipe().isPresent();
        BFME.LOGGER.info("Can Burn: {}", result);
        return result;
    }
    private Optional<RecipeHolder<BaseFurnaceRecipe>> getCurrentRecipeForIndex(int pairIndex) {
        // Верхние слоты: 0, 1, 2, 3
        int topIndex = pairIndex;
        // Нижние слоты: 4, 5, 6, 7
        int bottomIndex = TOTAL_INPUT_SLOTS / 2 + pairIndex;

        ItemStack topStack = items.get(topIndex);
        ItemStack bottomStack = items.get(bottomIndex);

        if (!topStack.isEmpty() && !bottomStack.isEmpty()) {
            return level.getRecipeManager()
                            .getRecipeFor((RecipeType)recipeType, new DualRecipeInput(topStack, bottomStack), level);
        }
        return Optional.empty();
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
        int topIndex = pairIndex;
        int bottomIndex = TOTAL_INPUT_SLOTS / 2 + pairIndex;

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
        int topIndex = pairIndex;
        int bottomIndex = TOTAL_INPUT_SLOTS / 2 + pairIndex;
        int outputIndex = TOTAL_INPUT_SLOTS + pairIndex;

        Optional<RecipeHolder<BaseFurnaceRecipe>> optionalRecipe = getCurrentRecipeForIndex(pairIndex);

        if (optionalRecipe.isPresent()) {
            BaseFurnaceRecipe recipe = optionalRecipe.get().value();
            DualRecipeInput input = new DualRecipeInput(items.get(topIndex), items.get(bottomIndex));
            ItemStack result = recipe.assemble(input, null); // Создаём результат рецепта

            ItemStack outputStack = items.get(outputIndex);

            // **Исправление ошибки:** Проверяем, пуст ли слот или совпадает ли предмет
            if (outputStack.isEmpty()) {
                items.set(outputIndex, result.copy());
            } else if (ItemStack.isSameItemSameComponents(outputStack, result)) {
                outputStack.grow(result.getCount());
            } else {
                // Если в выходном слоте другой предмет, то не выполняем крафт
                return;
            }

            // Уменьшаем количество ингредиентов только если они есть
            if (!items.get(topIndex).isEmpty()) items.get(topIndex).shrink(1);
            if (!items.get(bottomIndex).isEmpty()) items.get(bottomIndex).shrink(1);

            activeRecipes[pairIndex] = optionalRecipe.get();
            setRecipeUsed(optionalRecipe.get());
        }
    }



    Optional<RecipeHolder<BaseFurnaceRecipe>> getCurrentRecipe() {
        for (int i = 0; i < TOTAL_INPUT_SLOTS / 2; i++) {

            int topIndex = i;
            int bottomIndex = TOTAL_INPUT_SLOTS / 2 + i;

            ItemStack topStack = items.get(topIndex);
            ItemStack bottomStack = items.get(bottomIndex);

            BFME.LOGGER.info("Checking slots: PairIndex={}, TopIndex={}, BottomIndex={}, TopStack={}, BottomStack={}", i, topIndex, bottomIndex, topStack, bottomStack);

            if (!topStack.isEmpty() && !bottomStack.isEmpty()) {
                Optional<RecipeHolder<BaseFurnaceRecipe>> recipe = level.getRecipeManager()
                        .getRecipeFor((RecipeType)recipeType, new DualRecipeInput(topStack, bottomStack), level);

                if (recipe.isPresent()) {
                    BFME.LOGGER.info("Recipe found: {}", recipe.get().id());
                    return recipe;
                }
            }
        }
        BFME.LOGGER.info("No matching recipe found.");
        return Optional.empty();
    }



    private int getBurnDuration(ItemStack fuel) {
        return fuel.getBurnTime(recipeType);
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
            try {
                ResourceLocation recipeId = ResourceLocation.parse(key);
                this.recipesUsed.put(recipeId, recipesTag.getInt(key));
            } catch (ResourceLocationException e) {
                BFME.LOGGER.error("Invalid ResourceLocation in RecipesUsed: {}", key, e);
            }
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
