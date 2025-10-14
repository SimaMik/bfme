package net.sima.bfme.worldgen.biomes.caves;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

/**
 * Класс для управления настройками спавна в пещерных биомах.
 */
public class ModCaveBiomeFeatures {

    /**
     * Добавляет аксолотлей в настройки спавна.
     */
    public static void addAxolotls(MobSpawnSettings.Builder builder) {
        addWaterCreature(builder, EntityType.AXOLOTL, 12, 2, 5);
    }

    /**
     * Добавляет летучих мышей в настройки спавна.
     */
    public static void addBats(MobSpawnSettings.Builder builder) {
        addAmbient(builder, EntityType.BAT, 3, 1, 2);
    }

    /**
     * Добавляет лягушек в настройки спавна.
     */
    public static void addFrogs(MobSpawnSettings.Builder builder) {
        addCreature(builder, EntityType.FROG, 4, 1, 4);
    }

    /**
     * Утилита для добавления мобов категории WATER_CREATURE.
     */
    private static void addWaterCreature(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Утилита для добавления мобов категории AMBIENT.
     */
    private static void addAmbient(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }

    /**
     * Утилита для добавления мобов категории CREATURE.
     */
    private static void addCreature(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroup, int maxGroup) {
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(entityType, weight, minGroup, maxGroup));
    }
}
