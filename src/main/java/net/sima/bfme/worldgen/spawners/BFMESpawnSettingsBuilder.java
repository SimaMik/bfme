package net.sima.bfme.worldgen.spawners;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

/**
 * Класс для упрощенного управления настройками спавна мобов в биомах.
 */
public class BFMESpawnSettingsBuilder {
    private final MobSpawnSettings.Builder builder;

    /**
     * Конструктор, создающий новый объект {@link MobSpawnSettings.Builder}.
     */
    public BFMESpawnSettingsBuilder() {
        this.builder = new MobSpawnSettings.Builder();
    }

    /**
     * Добавляет стандартных океанических животных.
     *
     * @param builder {@link MobSpawnSettings.Builder} для добавления спавна.
     */
    public static void addOceanAnimals(MobSpawnSettings.Builder builder) {
        addWaterAmbient(builder, EntityType.COD, 10, 1, 5);
        addWaterCreature(builder, EntityType.SQUID, 6, 1, 4);
        addWaterCreature(builder, EntityType.TURTLE, 4, 1, 2);
        addWaterCreature(builder, EntityType.DOLPHIN, 3, 1, 2);
    }

    /**
     * Добавляет стандартных животных фермы.
     */
    public static void addFarmAnimals(MobSpawnSettings.Builder builder) {
        addCreature(builder, EntityType.SHEEP, 12, 4, 4);
        addCreature(builder, EntityType.PIG, 10, 4, 4);
        addCreature(builder, EntityType.CHICKEN, 10, 4, 4);
        addCreature(builder, EntityType.COW, 8, 4, 4);
    }

    /**
     * Добавляет моба категории WATER_AMBIENT в переданный билдер.
     */
    public static void addWaterAmbient(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Добавляет моба категории WATER_CREATURE в переданный билдер.
     */
    public static void addWaterCreature(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Добавляет моба категории CREATURE в переданный билдер.
     */
    public static void addCreature(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Добавляет моба категории MONSTER в переданный билдер.
     */
    public static void addMonster(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Добавляет моба категории AMBIENT в переданный билдер.
     */
    public static void addAmbient(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Добавляет моба категории WATER_AMBIENT.
     */
    public BFMESpawnSettingsBuilder addWaterAmbient(EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
        return this;
    }

    /**
     * Добавляет моба категории WATER_CREATURE.
     */
    public BFMESpawnSettingsBuilder addWaterCreature(EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
        return this;
    }

    /**
     * Добавляет моба категории MONSTER.
     */
    public BFMESpawnSettingsBuilder addMonster(EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
        return this;
    }

    /**
     * Добавляет моба категории CREATURE.
     */
    public BFMESpawnSettingsBuilder addCreature(EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
        return this;
    }

    /**
     * Добавляет моба категории AMBIENT.
     */
    public BFMESpawnSettingsBuilder addAmbient(EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
        return this;
    }

    /**
     * Устанавливает вероятность появления существ категории CREATURE.
     */
    public BFMESpawnSettingsBuilder setCreatureProbability(float probability) {
        builder.creatureGenerationProbability(probability);
        return this;
    }

    /**
     * Добавляет затраты на спавн моба.
     */
    public BFMESpawnSettingsBuilder addMobSpawnCost(EntityType<?> entityType, double charge, double energyBudget) {
        builder.addMobCharge(entityType, charge, energyBudget);
        return this;
    }

    /**
     * Возвращает собранный объект {@link MobSpawnSettings}.
     *
     * @return Собранный объект {@link MobSpawnSettings}.
     */
    public MobSpawnSettings build() {
        return builder.build();
    }
}
