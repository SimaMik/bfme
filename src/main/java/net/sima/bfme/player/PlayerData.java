package net.sima.bfme.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.faction.FactionData;
import net.sima.bfme.profession.Professions;

import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    private int kill;
    private final int MIN_KILL = 0;
    private final int MAX_KILL = 1000;

    private Faction faction;
    private Professions profession; // Текущая профессия игрока
    private int professionLevel; // Уровень профессии
    private int professionExperience; // Опыт профессии
    private float miningSpeedMultiplier = 1.0f; // Базовый множитель скорости
    private float lumberjackSpeedMultiplier = 1.0f;
    private String customName = ""; // Поле для кастомного имени

    private Map<Faction, Integer> reputationMap = new HashMap<>();
    private Map<Faction, FactionData> factionDataMap = new HashMap<>();

    public PlayerData() {
        for (Faction faction : Faction.values()) {
            reputationMap.put(faction, 0);
        }
    }
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }
    public float getLumberjackSpeedMultiplier() {
        return lumberjackSpeedMultiplier;
    }
    public void updateMiningSpeedMultiplier() {
        if (profession != Professions.MINER) {
            this.miningSpeedMultiplier = 1.0f;
            System.out.println("Mining Speed Multiplier set to default (1.0) - Not a Miner");
            return;
        }

        this.miningSpeedMultiplier = switch (professionLevel) {
            case 1 -> 1.1f;
            case 2 -> 1.25f;
            case 3 -> 1.5f;
            case 4 -> 1.75f;
            case 5 -> 2.0f;
            default -> 1.0f;
        };

        System.out.println("Updated Mining Speed Multiplier: " + miningSpeedMultiplier + " (Level: " + professionLevel + ")");
    }

    public void updateLumberjackSpeedMultiplier() {
        if (profession != Professions.LUMBERJACK) {
            this.lumberjackSpeedMultiplier = 1.0f;
            return;
        }

        this.lumberjackSpeedMultiplier = switch (professionLevel) {
            case 1 -> 1.1f;
            case 2 -> 1.25f;
            case 3 -> 1.5f;
            case 4 -> 1.75f;
            case 5 -> 2.0f;
            default -> 1.0f;
        };
    }
    // Методы для работы с профессией
    public Professions getProfession() {
        return profession;
    }

    public void setProfession(Professions profession) {
        this.profession = profession;
        this.professionLevel = 0;
        this.professionExperience = 0;
    }

    public int getProfessionLevel() {
        return professionLevel;
    }

    public int getProfessionExperience() {
        return professionExperience;
    }
    public void addProfessionExperience(int amount) {
        if (profession == null || amount <= 0) return;

        this.professionExperience += amount;

        while (professionLevel < profession.getMaxLevel() &&
                this.professionExperience >= profession.getLevel(professionLevel + 1).getExperienceRequired()) {
            this.professionExperience -= profession.getLevel(professionLevel + 1).getExperienceRequired();
            this.professionLevel++;

            // Обновляем множители скорости в зависимости от профессии
            switch (profession) {
                case MINER -> updateMiningSpeedMultiplier();
                case LUMBERJACK -> updateLumberjackSpeedMultiplier();
                // Добавь сюда обновления для других профессий, когда они появятся
            }

            System.out.println("Profession Level Up! New Level: " + professionLevel);
        }
    }



    public int getExperienceToNextLevel() {
        if (profession == null || professionLevel >= profession.getMaxLevel()) {
            return 0; // Если профессия не выбрана или достигнут максимальный уровень, опыт не нужен
        }
        return profession.getLevel(professionLevel + 1).getExperienceRequired() - professionExperience;
    }

    // Методы для работы с именем
    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String name, Player player) {
        this.customName = name; // Присваиваем переданное имя
        updateDisplayName(player);
    }

    public void updateDisplayName(Player player) {
        if (customName != null && !customName.isEmpty()) {
            player.setCustomName(Component.literal(customName));

            // Обновляем отображаемое имя в табе и чате
            player.refreshDisplayName();

            // Если player является серверным игроком, отправляем обновление клиентам
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.connection.send(new ClientboundSetEntityDataPacket(player.getId(), player.getEntityData().getNonDefaultValues()));
            }
        } else {
            // Если customName пустое, возвращаем стандартное имя
            player.setCustomName(player.getName());
            player.refreshDisplayName();
        }
    }

    public int getKill() {
        return kill;
    }

    public Faction getFaction() {
        return faction;
    }
    public String getPlayerFaction(){
        return getFaction().getFactionName();
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public void addKill(int add) {
        this.kill = Math.min(kill + add, MAX_KILL);
    }

    public void subKill(int sub) {
        this.kill = Math.max(kill - sub, MIN_KILL);
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("kill", kill);
        nbt.putString("customName", customName);
        nbt.putString("profession", profession != null ? profession.name() : "");
        nbt.putFloat("miningSpeedMultiplier", miningSpeedMultiplier);
        nbt.putFloat("lumberjackSpeedMultiplier", lumberjackSpeedMultiplier); // Добавлено сохранение
        nbt.putInt("professionLevel", professionLevel);
        nbt.putInt("professionExperience", professionExperience);

        if (faction != null) {
            nbt.putString("faction", faction.name());
        } else {
            nbt.putString("faction", "");
        }

        for (Map.Entry<Faction, Integer> entry : reputationMap.entrySet()) {
            nbt.putInt("reputation_" + entry.getKey().name(), entry.getValue());
        }
    }
    public void loadNBTData(CompoundTag nbt) {
        kill = nbt.getInt("kill");
        customName = nbt.getString("customName");
        String professionName = nbt.getString("profession");
        profession = professionName.isEmpty() ? null : Professions.valueOf(professionName);
        professionLevel = nbt.getInt("professionLevel");
        professionExperience = nbt.getInt("professionExperience");
        miningSpeedMultiplier = nbt.contains("miningSpeedMultiplier") ? nbt.getFloat("miningSpeedMultiplier") : 1.0f;
        lumberjackSpeedMultiplier = nbt.contains("lumberjackSpeedMultiplier") ? nbt.getFloat("lumberjackSpeedMultiplier") : 1.0f; // Добавлено чтение

        String factionName = nbt.getString("faction");
        if (!factionName.isEmpty()) {
            try {
                faction = Faction.valueOf(factionName);
            } catch (IllegalArgumentException e) {
                faction = null;
            }
        } else {
            faction = null;
        }

        for (Faction faction : Faction.values()) {
            reputationMap.put(faction, nbt.getInt("reputation_" + faction.name()));
        }
    }

    public int getReputation(Faction faction) {
        return reputationMap.getOrDefault(faction, 0);
    }

    public void changeReputation(Faction faction, int amount) {
        reputationMap.put(faction, reputationMap.getOrDefault(faction, 0) + amount);
    }

    public void setReputation(Faction faction, int amount) {
        reputationMap.put(faction, amount);
    }

}
