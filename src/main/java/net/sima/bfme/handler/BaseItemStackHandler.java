package net.sima.bfme.handler;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.neoforged.neoforge.common.util.DataComponentUtil;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sima.bfme.BFME;
import net.sima.bfme.util.CanExtractFunction;
import net.sima.bfme.util.CanInsertFunction;
import net.sima.bfme.util.OnContentsChangedFunction;
import org.apache.commons.lang3.ArrayUtils;

public class BaseItemStackHandler extends ItemStackHandler {
    private static final Codec<ItemStack> ITEM_STACK_CODEC = Codec.lazyInitialized(() -> {
        return RecordCodecBuilder.create((builder) -> {
            return builder.group(ItemStack.ITEM_NON_AIR_CODEC.fieldOf("id").forGetter(ItemStack::getItemHolder), Codec.INT.optionalFieldOf("count", 1).forGetter(ItemStack::getCount), DataComponentPatch.CODEC.optionalFieldOf("components", DataComponentPatch.EMPTY).forGetter(ItemStack::getComponentsPatch)).apply(builder, ItemStack::new);
        });
    });
    private final OnContentsChangedFunction onContentsChanged;
    private final Map<Integer, Integer> slotSizeMap;
    private CanInsertFunction canInsert = null;
    private CanExtractFunction canExtract = null;
    private int maxStackSize = 64;
    private int[] outputSlots = null;

    public BaseItemStackHandler(int size, OnContentsChangedFunction onContentsChanged) {
        super(size);
        this.onContentsChanged = onContentsChanged;
        this.slotSizeMap = new HashMap();
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return this.insertItem(slot, stack, simulate, false);
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate, boolean container) {
        return !container && this.outputSlots != null && ArrayUtils.contains(this.outputSlots, slot) ? stack : super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return this.extractItem(slot, amount, simulate, false);
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate, boolean container) {
        if (!container) {
            if (this.canExtract != null && !this.canExtract.apply(slot)) {
                return ItemStack.EMPTY;
            }

            if (this.outputSlots != null && !ArrayUtils.contains(this.outputSlots, slot)) {
                return ItemStack.EMPTY;
            }
        }

        return super.extractItem(slot, amount, simulate);
    }

    public int getSlotLimit(int slot) {
        return this.slotSizeMap.containsKey(slot) ? (Integer)this.slotSizeMap.get(slot) : this.maxStackSize;
    }

    public boolean isItemValid(int slot, ItemStack stack) {
        return this.canInsert == null || this.canInsert.apply(slot, stack);
    }

    protected void onContentsChanged(int slot) {
        if (this.onContentsChanged != null) {
            this.onContentsChanged.apply(slot);
        }

    }

    public CompoundTag serializeNBT(HolderLookup.Provider lookup) {
        ListTag items = new ListTag();

        for(int i = 0; i < this.stacks.size(); ++i) {
            ItemStack stack = (ItemStack)this.stacks.get(i);
            if (!stack.isEmpty()) {
                CompoundTag item = new CompoundTag();
                item.putInt("Slot", i);
                items.add(DataComponentUtil.wrapEncodingExceptions(stack, ITEM_STACK_CODEC, lookup, item));
            }
        }

        CompoundTag nbt = new CompoundTag();
        nbt.put("Items", items);
        nbt.putInt("Size", this.stacks.size());
        return nbt;
    }

    public void deserializeNBT(HolderLookup.Provider lookup, CompoundTag nbt) {
        int size = nbt.contains("Size", 3) ? nbt.getInt("Size") : this.stacks.size();
        this.setSize(Math.max(size, this.stacks.size()));
        ListTag items = nbt.getList("Items", 10);

        for(int i = 0; i < items.size(); ++i) {
            CompoundTag item = items.getCompound(i);
            int slot = item.getInt("Slot");
            if (slot >= 0 && slot < this.stacks.size()) {
                ITEM_STACK_CODEC.parse(lookup.createSerializationContext(NbtOps.INSTANCE), item).resultOrPartial((error) -> {
                    BFME.LOGGER.error("Tried to load invalid item: '{}'", error);
                }).ifPresent((stack) -> {
                    this.stacks.set(slot, stack);
                });
            }
        }

        this.onLoad();
    }

    public NonNullList<ItemStack> getStacks() {
        return this.stacks;
    }

    public int[] getOutputSlots() {
        return this.outputSlots;
    }

    public void setDefaultSlotLimit(int size) {
        this.maxStackSize = size;
    }

    public void addSlotLimit(int slot, int size) {
        if (size > 64 && size % 64 != 0) {
            throw new IllegalArgumentException("Slot limits above 64 must be a multiple of 64");
        } else {
            this.slotSizeMap.put(slot, size);
        }
    }

    public void setCanInsert(CanInsertFunction canInsert) {
        this.canInsert = canInsert;
    }

    public void setCanExtract(CanExtractFunction canExtract) {
        this.canExtract = canExtract;
    }

    public void setOutputSlots(int... slots) {
        this.outputSlots = slots;
    }


    public BaseItemStackHandler copy() {
        BaseItemStackHandler newInventory = new BaseItemStackHandler(this.getSlots(), this.onContentsChanged);
        newInventory.setDefaultSlotLimit(this.maxStackSize);
        newInventory.setCanInsert(this.canInsert);
        newInventory.setCanExtract(this.canExtract);
        newInventory.setOutputSlots(this.outputSlots);
        Objects.requireNonNull(newInventory);
        this.slotSizeMap.forEach(newInventory::addSlotLimit);;

        for(int i = 0; i < this.getSlots(); ++i) {
            ItemStack stack = this.getStackInSlot(i);
            newInventory.setStackInSlot(i, stack.copy());
        }

        return newInventory;
    }

    public static BaseItemStackHandler create(int size) {
        return create(size, (builder) -> {
        });
    }

    public static BaseItemStackHandler create(int size, Consumer<BaseItemStackHandler> builder) {
        return create(size, (OnContentsChangedFunction)null, builder);
    }

    public static BaseItemStackHandler create(int size, OnContentsChangedFunction onContentsChanged, Consumer<BaseItemStackHandler> builder) {
        BaseItemStackHandler handler = new BaseItemStackHandler(size, onContentsChanged);
        builder.accept(handler);
        return handler;
    }
}
