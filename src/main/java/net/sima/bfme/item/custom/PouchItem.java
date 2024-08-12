package net.sima.bfme.item.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sima.bfme.handler.RestrictedItemStackHandler;
import net.sima.bfme.item.ModItems;
import net.sima.bfme.screen_menus.LargePouchContainer;
import net.sima.bfme.screen_menus.MediumPouchContainer;
import net.sima.bfme.screen_menus.SmallPouchContainer;

public class PouchItem extends Item {
    private final int slotCount;

    public PouchItem(Properties properties, int slotCount) {
        super(properties);
        this.slotCount = slotCount;
    }

    public static int getSlotCount(ItemStack stack) {
        if (stack.getItem() == ModItems.SMALL_POUCH.get()) {
            return 9; // Example slot count for small pouch
        } else if (stack.getItem() == ModItems.MEDIUM_POUCH.get()) {
            return 18; // Example slot count for medium pouch
        } else if (stack.getItem() == ModItems.LARGE_POUCH.get()) {
            return 27; // Example slot count for large pouch
        }
        return 0; // Default value, should not happen
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            ItemStackHandler handler = getHandler(stack);
            if (this.slotCount == 9) {
                player.openMenu(new SimpleMenuProvider(
                        (id, inventory, p) -> new SmallPouchContainer(id, inventory, handler, stack),
                        Component.translatable("container.small_pouch")
                ));
            } else if (this.slotCount == 18) {
                player.openMenu(new SimpleMenuProvider(
                        (id, inventory, p) -> new MediumPouchContainer(id, inventory, handler, stack),
                        Component.translatable("container.medium_pouch")
                ));
            } else if (this.slotCount == 27) {
                player.openMenu(new SimpleMenuProvider(
                        (id, inventory, p) -> new LargePouchContainer(id, inventory, handler, stack),
                        Component.translatable("container.large_pouch")
                ));
            }
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    public static void saveItems(ItemStack stack, ItemStackHandler handler) {
        ItemContainerContents contents = ItemContainerContents.fromItems(handlerToList(handler));
        stack.set(DataComponents.CONTAINER, contents);
    }

    public static ItemStackHandler getHandler(ItemStack stack) {
        int slots = stack.getItem() instanceof PouchItem ? ((PouchItem) stack.getItem()).slotCount : 27; // default to large size
        ItemStackHandler handler = new RestrictedItemStackHandler(slots);
        ItemContainerContents contents = stack.get(DataComponents.CONTAINER);
        if (contents != null && contents != ItemContainerContents.EMPTY) {
            NonNullList<ItemStack> itemList = NonNullList.withSize(slots, ItemStack.EMPTY);
            contents.copyInto(itemList);
            for (int i = 0; i < itemList.size(); i++) {
                handler.setStackInSlot(i, itemList.get(i));
            }
        }
        return handler;
    }

    public static void copyContents(ItemStack sourceStack, ItemStack targetStack) {
        ItemStackHandler sourceHandler = getHandler(sourceStack);
        ItemStackHandler targetHandler = getHandler(targetStack);

        for (int i = 0; i < sourceHandler.getSlots(); i++) {
            ItemStack stackInSlot = sourceHandler.getStackInSlot(i);
            if (!stackInSlot.isEmpty()) {
                targetHandler.setStackInSlot(i, stackInSlot.copy());
            }
        }

        saveItems(targetStack, targetHandler);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return super.getName(pStack);
    }

    public static final DataComponentType<DyeColor> BASE_COLOR = DataComponents.BASE_COLOR;

    public static void setColor(ItemStack stack, DyeColor color) {
        stack.set(BASE_COLOR, color);
    }

    public static int getColor(ItemStack stack) {
        DyeColor color = stack.get(BASE_COLOR);
        if (color == null) {
            color = DyeColor.WHITE; // Set default color if not present
            setColor(stack, color); // Save default color
        }
        return color.getTextColor();
    }

    private static NonNullList<ItemStack> handlerToList(ItemStackHandler handler) {
        NonNullList<ItemStack> list = NonNullList.withSize(handler.getSlots(), ItemStack.EMPTY);
        for (int i = 0; i < handler.getSlots(); i++) {
            list.set(i, handler.getStackInSlot(i));
        }
        return list;
    }
}
