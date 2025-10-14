package net.sima.bfme.worldgen.biomes.caves;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для управления пещерными биомами в моде BFME.
 */
public class ModCaveBiomes {

    private static final List<ResourceKey<Biome>> caveBiomes = new ArrayList<>();
    public static CaveBiomesMap defaultCaves = new CaveBiomesMap();
    public static CaveBiomesMap ashCaves = new CaveBiomesMap();
    public static CaveBiomesMap forodCaves = new CaveBiomesMap();
    public static CaveBiomesMap haradCaves = new CaveBiomesMap();

    /**
     * Инициализация списка пещерных биомов.
     * В будущем можно добавлять кастомные пещерные биомы.
     */
    public static void init() {
        // Пример добавления биомов (заменить своими ключами в будущем)
        defaultCaves.addCave(new CaveBiomeDTO(Biomes.LUSH_CAVES, new Vector2f(-1.0f,0f)));
        defaultCaves.addCave(new CaveBiomeDTO(Biomes.DRIPSTONE_CAVES, new Vector2f(1.0f,0f)));
    }

    /**
     * Возвращает список всех зарегистрированных пещерных биомов.
     *
     * @return Список {@link ResourceKey<Biome>} для пещерных биомов.
     */
    public static List<ResourceKey<Biome>> getCaveBiomes() {
        return new ArrayList<>(caveBiomes);
    }

    public static ResourceKey<Biome> getBiome(Vector2f coordinates, BFMEBiome surfaceBiome) {
        return switch (surfaceBiome.caveType) {
            case DEFAULT -> defaultCaves.getClosestBiome(coordinates);
            default -> defaultCaves.getClosestBiome(coordinates);
        };
    }

}
