package net.sima.bfme.entity.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootTable;
import net.sima.bfme.entity.ModEntities;
import net.sima.bfme.item.ModItems;

import javax.annotation.Nullable;

public class ModChestBoatEntity extends ModBoatEntity implements HasCustomInventoryScreen, ContainerEntity {
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    @Nullable
    private ResourceKey<LootTable> lootTable;
    private long lootTableSeed;

    public ModChestBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.MOD_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }
    protected float getSinglePassengerXOffset() {
        return 0.15F;
    }

    protected int getMaxPassengers() {
        return 1;
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addChestVehicleSaveData(tag, this.registryAccess());
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readChestVehicleSaveData(tag, this.registryAccess());
    }

    public void destroy(DamageSource source) {
        super.destroy(source);
        this.chestVehicleDestroyed(source, this.level(), this);
    }

    public void remove(Entity.RemovalReason reason) {
        if (!this.level().isClientSide && reason.shouldDestroy()) {
            Containers.dropContents(this.level(), this, this);
        }

        super.remove(reason);
    }

    public InteractionResult interact(Player player, InteractionHand hand) {
        if (this.canAddPassenger(player) && !player.isSecondaryUseActive()) {
            return super.interact(player, hand);
        } else {
            InteractionResult interactionresult = this.interactWithContainerVehicle(player);
            if (interactionresult.consumesAction()) {
                this.gameEvent(GameEvent.CONTAINER_OPEN, player);
                PiglinAi.angerNearbyPiglins(player, true);
            }

            return interactionresult;
        }
    }

    public void openCustomInventoryScreen(Player player) {
        player.openMenu(this);
        if (!player.level().isClientSide) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);
        }

    }

    @Override
    public Item getDropItem() {
        return switch (this.getModVariant()) {
            case ALMOND -> ModItems.ALMOND_CHEST_BOAT.get();
            case APPLE -> ModItems.APPLE_CHEST_BOAT.get();
            case ASPEN -> ModItems.ASPEN_CHEST_BOAT.get();
            case BAOBAB -> ModItems.BAOBAB_CHEST_BOAT.get();
            case BANANA -> ModItems.BANANA_CHEST_BOAT.get();
            case BEECH -> ModItems.BEECH_CHEST_BOAT.get();
            case CEDAR -> ModItems.CEDAR_CHEST_BOAT.get();
            case CHESTNUT -> ModItems.CHESTNUT_CHEST_BOAT.get();
            case CYPRESS -> ModItems.CYPRESS_CHEST_BOAT.get();
            case DATE_PALM -> ModItems.DATE_PALM_CHEST_BOAT.get();
            case FIR -> ModItems.FIR_CHEST_BOAT.get();
            case GREEN_OAK -> ModItems.GREEN_OAK_CHEST_BOAT.get();
            case HOLLY -> ModItems.HOLLY_CHEST_BOAT.get();
            case KUNTZ -> ModItems.KUNTZ_CHEST_BOAT.get();
            case LAIRELOSSE -> ModItems.LAIRELOSSE_CHEST_BOAT.get();
            case LARCH -> ModItems.LARCH_CHEST_BOAT.get();
            case LEBETHRON -> ModItems.LEBETHRON_CHEST_BOAT.get();
            case LEMON -> ModItems.LEMON_CHEST_BOAT.get();
            case LIME -> ModItems.LIME_CHEST_BOAT.get();
            case MALLORN -> ModItems.MALLORN_CHEST_BOAT.get();
            case MANGO -> ModItems.MANGO_CHEST_BOAT.get();
            case MAPLE -> ModItems.MAPLE_CHEST_BOAT.get();
            case MIRK_OAK -> ModItems.MIRK_OAK_CHEST_BOAT.get();
            case OLIVE -> ModItems.OLIVE_CHEST_BOAT.get();
            case ORANGE -> ModItems.ORANGE_CHEST_BOAT.get();
            case PALM -> ModItems.PALM_CHEST_BOAT.get();
            case PEAR -> ModItems.PEAR_CHEST_BOAT.get();
            case PINE -> ModItems.PINE_CHEST_BOAT.get();
            case PLUM -> ModItems.PLUM_CHEST_BOAT.get();
            case POMEGRANATE -> ModItems.POMEGRANATE_CHEST_BOAT.get();
            case RED_OAK -> ModItems.RED_OAK_CHEST_BOAT.get();
            case REDWOOD -> ModItems.REDWOOD_CHEST_BOAT.get();
            case RED_MAHOGANY -> ModItems.RED_MAHOGANY_CHEST_BOAT.get();
            case WILLOW -> ModItems.WILLOW_CHEST_BOAT.get();
        };
    }

    @Override
    public void clearContent() {
        this.clearChestVehicleContent();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.getChestVehicleItem(index);
    }

    @Override
    public ItemStack removeItem(int index, int amount) {
        return this.removeChestVehicleItem(index, amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return this.removeChestVehicleItemNoUpdate(index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.setChestVehicleItem(index, stack);
    }

    @Override
    public SlotAccess getSlot(int index) {
        return this.getChestVehicleSlot(index);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player player) {
        return this.isChestVehicleStillValid(player);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        if (this.lootTable != null && player.isSpectator()) {
            return null;
        } else {
            this.unpackLootTable(inventory.player);
            return ChestMenu.threeRows(id, inventory, this);
        }
    }

    public void unpackLootTable(@Nullable Player player) {
        this.unpackChestVehicleLootTable(player);
    }

    @Nullable
    @Override
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceKey<LootTable> resourceKey) {
        this.lootTable = resourceKey;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    @Override
    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }
}
