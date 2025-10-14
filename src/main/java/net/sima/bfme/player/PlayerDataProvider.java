package net.sima.bfme.player;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.common.util.Lazy;
import net.sima.bfme.BFME;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class PlayerDataProvider implements ICapabilityProvider<Entity, Void, PlayerData>, INBTSerializable<CompoundTag> {

    public static final EntityCapability<PlayerData, Void> PLAYER_DATA_CAPABILITY =
            EntityCapability.create(ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "player_data"), PlayerData.class, Void.TYPE);

    private final Lazy<PlayerData> playerData = Lazy.of(this::createPlayerData);

    private PlayerData createPlayerData() {
        return new PlayerData();
    }

    @Nullable
    @Override
    public PlayerData getCapability(Entity entity, Void context) {
        return playerData.get();
    }

    // Реализация методов INBTSerializable для сериализации и десериализации

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag nbt = new CompoundTag();
        // Сохраняем данные игрока в NBT
        playerData.get().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        // Загружаем данные игрока из NBT
        playerData.get().loadNBTData(nbt);
    }
}
