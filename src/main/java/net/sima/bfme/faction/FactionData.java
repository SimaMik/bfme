package net.sima.bfme.faction;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.sima.bfme.player.PlayerData;

public class FactionData {
    private PlayerData playerData;
    private Faction theFaction;
    private int npcsKilled;
    private int enemiesKilled;

    public FactionData(PlayerData data, Faction faction) {
        this.playerData = data;
        this.theFaction = faction;
    }


    public void save(CompoundTag nbt) {
        nbt.putInt("NPCKill", this.npcsKilled);
        nbt.putInt("EnemyKill", this.enemiesKilled);
    }

    public void load(CompoundTag nbt) {
        this.npcsKilled = nbt.getInt("NPCKill");
        this.enemiesKilled = nbt.getInt("EnemyKill");
    }

    private void updateFactionData() {
        //this.playerData.updateFactionData(this.theFaction, this);
    }

    public int getNPCsKilled() {
        return this.npcsKilled;
    }

    public void addNPCKill() {
        ++this.npcsKilled;
        this.updateFactionData();
    }

    public int getEnemiesKilled() {
        return this.enemiesKilled;
    }

    public void addEnemyKill() {
        ++this.enemiesKilled;
        this.updateFactionData();
    }

}
