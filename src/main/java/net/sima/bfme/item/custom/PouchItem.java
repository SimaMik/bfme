package net.sima.bfme.item.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sima.bfme.event.PouchChestInteractHandler;
import net.sima.bfme.handler.RestrictedItemStackHandler;
import net.sima.bfme.screen_menus.PouchChestMenu;
import net.sima.bfme.screen_menus.PouchContainer;

import java.util.ArrayList;
import java.util.List;

public class PouchItem extends Item {
    private final int slotCount;

    public PouchItem(Properties properties, int slotCount) {
        super(properties);
        this.slotCount = slotCount;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public int getRows() {
        return slotCount / 9;
    }

    public static int getSlotCount(ItemStack stack) {
        if (stack.getItem() instanceof PouchItem p) return p.slotCount;
        return 0;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            openPouchMenu(player, stack, hand);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        if (player == null) return InteractionResult.PASS;

        BlockState state = level.getBlockState(context.getClickedPos());
        if (!PouchChestInteractHandler.isContainerBlock(state, level, context.getClickedPos())) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            Container chest = PouchChestInteractHandler.resolveChest(state, level, context.getClickedPos());
            if (chest == null) return InteractionResult.PASS;

            ItemStack heldStack = context.getItemInHand();
            ItemStackHandler pouchHandler = getHandler(heldStack);
            int pouchRows = getRows();
            int chestSize = chest.getContainerSize();
            Component title = state.getBlock().getName();
            InteractionHand hand = context.getHand();
            net.minecraft.core.BlockPos clickedPos = context.getClickedPos();
            final Container fc = chest;
            final ItemStack fp = heldStack;

            player.openMenu(new SimpleMenuProvider(
                    (id, inv, p) -> new PouchChestMenu(id, inv, fc, pouchHandler, fp, pouchRows, hand, clickedPos),
                    title
            ), buf -> {
                buf.writeVarInt(chestSize);
                buf.writeVarInt(pouchRows);
                buf.writeBoolean(hand == InteractionHand.MAIN_HAND);
            });
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private void openPouchMenu(Player player, ItemStack stack, InteractionHand hand) {
        ItemStackHandler handler = getHandler(stack);
        int rows = getRows();
        Component title = stack.getHoverName();
        MenuProvider provider = new SimpleMenuProvider(
                (id, inv, p) -> new PouchContainer(id, inv, handler, stack, rows, hand),
                title
        );
        player.openMenu(provider, buf -> {
            buf.writeVarInt(rows);
            buf.writeBoolean(hand == InteractionHand.MAIN_HAND);
        });
    }

    public static void saveItems(ItemStack stack, ItemStackHandler handler) {
        if (stack.isEmpty()) return;
        ItemContainerContents contents = ItemContainerContents.fromItems(handlerToList(handler));
        stack.set(DataComponents.CONTAINER, contents);
    }

    public static ItemStackHandler getHandler(ItemStack stack) {
        int slots = stack.getItem() instanceof PouchItem ? ((PouchItem) stack.getItem()).slotCount : 27;
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
        ItemContainerContents contents = sourceStack.get(DataComponents.CONTAINER);
        if (contents != null) {
            targetStack.set(DataComponents.CONTAINER, contents);
        }
    }

    public static final DataComponentType<DyeColor> BASE_COLOR = DataComponents.BASE_COLOR;

    public static void setColor(ItemStack stack, DyeColor color) {
        stack.set(BASE_COLOR, color);
    }

    public static final int DEFAULT_COLOR = 0xC4915F;

    public static int getColor(ItemStack stack) {
        DyeColor color = stack.get(BASE_COLOR);
        if (color == null) {
            return 0xFF000000 | DEFAULT_COLOR;
        }
        return 0xFF000000 | color.getTextureDiffuseColor();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        ItemContainerContents contents = stack.get(DataComponents.CONTAINER);
        if (contents == null || contents == ItemContainerContents.EMPTY) {
            tooltip.add(Component.translatable("tooltip.bfme.pouch.empty").withStyle(s -> s.withColor(0xAAAAAA)));
            return;
        }

        int distinct = 0;
        int totalCount = 0;
        List<ItemStack> shown = new ArrayList<>();
        for (ItemStack inner : contents.nonEmptyItems()) {
            distinct++;
            totalCount += inner.getCount();
            if (shown.size() < 5) {
                shown.add(inner);
            }
        }

        for (ItemStack inner : shown) {
            tooltip.add(Component.translatable("tooltip.bfme.pouch.entry",
                    inner.getHoverName(), inner.getCount()).withStyle(s -> s.withColor(0xDDDDDD)));
        }
        if (distinct > shown.size()) {
            tooltip.add(Component.translatable("tooltip.bfme.pouch.more", distinct - shown.size())
                    .withStyle(s -> s.withColor(0xAAAAAA)));
        }
        tooltip.add(Component.translatable("tooltip.bfme.pouch.summary", distinct, this.slotCount, totalCount)
                .withStyle(s -> s.withColor(0x888888)));
    }

    private static NonNullList<ItemStack> handlerToList(ItemStackHandler handler) {
        NonNullList<ItemStack> list = NonNullList.withSize(handler.getSlots(), ItemStack.EMPTY);
        for (int i = 0; i < handler.getSlots(); i++) {
            list.set(i, handler.getStackInSlot(i));
        }
        return list;
    }
}
