package net.sima.bfme.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.BFME;
import net.sima.bfme.network.ModPackets;
import net.sima.bfme.network.PrivateBlockPayload;
import net.sima.bfme.screen_menus.custom.PrivateBlockMenu;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PrivateBlockEntity extends BlockEntity implements MenuProvider {
    private int sizeXPositive;
    private int sizeXNegative;
    private int sizeYPositive;
    private int sizeYNegative;
    private int sizeZPositive;
    private int sizeZNegative;

    private boolean allowInteraction = false;
    private boolean allowBreaking = false;
    private boolean allowPlacing = true;

    private final List<String> allowedPlayers = new ArrayList<>();
    private String owner = ""; // Владелец привата


    public PrivateBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PRIVATE_BLOCK_ENTITY.get(), pos, state);
    }

    // Геттеры и сеттеры
    public boolean isAllowInteraction() {
        return allowInteraction;
    }
    // Геттер и сеттер
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        setChanged();
    }

    public boolean isAllowBreaking() {
        return allowBreaking;
    }


    public boolean isAllowPlacing() {
        return allowPlacing;
    }
    public void setAllowInteraction(boolean allowInteraction) {
        BFME.LOGGER.info("Установка флага 'Взаимодействие': {} -> {}", this.allowInteraction, allowInteraction);
        this.allowInteraction = allowInteraction;
        setChanged();
    }

    public void setAllowBreaking(boolean allowBreaking) {
        BFME.LOGGER.info("Установка флага 'Ломание': {} -> {}", this.allowBreaking, allowBreaking);
        this.allowBreaking = allowBreaking;
        setChanged();
    }

    public void setAllowPlacing(boolean allowPlacing) {
        BFME.LOGGER.info("Установка флага 'Установка': {} -> {}", this.allowPlacing, allowPlacing);
        this.allowPlacing = allowPlacing;
        setChanged();
    }

    public int[] getCoordinates() {
        return new int[]{
                sizeXPositive,
                sizeXNegative,
                sizeYPositive,
                sizeYNegative,
                sizeZPositive,
                sizeZNegative
        };
    }
    public void setCoordinates(int xPositive, int xNegative, int yPositive, int yNegative, int zPositive, int zNegative) {
        BFME.LOGGER.info("Setting coordinates for PrivateBlockEntity at {}: x+={}, x-={}, y+={}, y-={}, z+={}, z-={}",
                worldPosition, xPositive, xNegative, yPositive, yNegative, zPositive, zNegative);

        this.sizeXPositive = Math.min(xPositive, 64);
        this.sizeXNegative = Math.min(xNegative, 64);
        this.sizeYPositive = Math.min(yPositive, 64);
        this.sizeYNegative = Math.min(yNegative, 64);
        this.sizeZPositive = Math.min(zPositive, 64);
        this.sizeZNegative = Math.min(zNegative, 64);

        setChanged(); // Пометка для сохранения
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);

        BFME.LOGGER.info("Coordinates after setting: x+={}, x-={}, y+={}, y-={}, z+={}, z-={}",
                sizeXPositive, sizeXNegative, sizeYPositive, sizeYNegative, sizeZPositive, sizeZNegative);

    }



    public void addAllowedPlayer(String playerName) {
        String normalizedPlayerName = playerName.trim().toLowerCase();
        if (!allowedPlayers.contains(normalizedPlayerName)) {
            allowedPlayers.add(normalizedPlayerName);
            setChanged();
            syncAllowedPlayersToClients(); // Синхронизация с клиентами
        }
    }

    public void removeAllowedPlayer(String playerName) {
        String normalizedPlayerName = playerName.trim().toLowerCase();
        if (allowedPlayers.remove(normalizedPlayerName)) {
            setChanged();
            syncAllowedPlayersToClients(); // Синхронизация с клиентами
        }
    }



    public List<String> getAllowedPlayers() {
        return allowedPlayers;
    }



    @Override
    public Component getDisplayName() {
        return Component.translatable("menu.private_block.title");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new PrivateBlockMenu(i, inventory, this);

    }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        if (pkt.getTag() != null) {
            loadAdditional(pkt.getTag(), lookupProvider);
            BFME.LOGGER.info("Received data packet for PrivateBlockEntity at {}: {}", this.worldPosition, pkt.getTag());
        } else {
            BFME.LOGGER.warn("Empty data packet for PrivateBlockEntity at {}", this.worldPosition);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        tag.putInt("sizeXPositive", sizeXPositive);
        tag.putInt("sizeXNegative", sizeXNegative);
        tag.putInt("sizeYPositive", sizeYPositive);
        tag.putInt("sizeYNegative", sizeYNegative);
        tag.putInt("sizeZPositive", sizeZPositive);
        tag.putInt("sizeZNegative", sizeZNegative);

        // Сохраняем игроков
        tag.putString("allowedPlayers", String.join(",", allowedPlayers));
        BFME.LOGGER.info("Saving players for {}: {}", worldPosition, String.join(",", allowedPlayers));

        tag.putBoolean("AllowInteraction", allowInteraction);
        tag.putBoolean("AllowBreaking", allowBreaking);
        tag.putBoolean("AllowPlacing", allowPlacing);
        tag.putString("Owner", owner);
        BFME.LOGGER.info("Сохранение флагов: interaction={}, breaking={}, placing={}", allowInteraction, allowBreaking, allowPlacing);

    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        sizeXPositive = tag.getInt("sizeXPositive");
        sizeXNegative = tag.getInt("sizeXNegative");
        sizeYPositive = tag.getInt("sizeYPositive");
        sizeYNegative = tag.getInt("sizeYNegative");
        sizeZPositive = tag.getInt("sizeZPositive");
        sizeZNegative = tag.getInt("sizeZNegative");

        allowInteraction = tag.getBoolean("AllowInteraction");
        allowBreaking = tag.getBoolean("AllowBreaking");
        allowPlacing = tag.getBoolean("AllowPlacing");
        owner = tag.getString("Owner");

        // Загружаем список игроков
        allowedPlayers.clear();
        if (tag.contains("allowedPlayers")) {
            String[] players = tag.getString("allowedPlayers").split(",");
            for (String player : players) {
                allowedPlayers.add(player.toLowerCase());
            }
        }
        BFME.LOGGER.info("Loaded players for {}: {}", worldPosition, allowedPlayers);
        BFME.LOGGER.info("Загрузка флагов: interaction={}, breaking={}, placing={}", allowInteraction, allowBreaking, allowPlacing);

    }


    public void syncAllowedPlayersToClients() {
        if (level != null && !level.isClientSide) {
            ModPackets.sendToAll(new PrivateBlockPayload(
                    sizeXPositive, sizeXNegative,
                    sizeYPositive, sizeYNegative,
                    sizeZPositive, sizeZNegative,
                    String.join(",", allowedPlayers), // Список игроков
                    getBlockPos(),
                    allowInteraction, allowBreaking, allowPlacing
            ));
        }
    }



}
