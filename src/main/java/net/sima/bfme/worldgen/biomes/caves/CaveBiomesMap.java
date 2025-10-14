package net.sima.bfme.worldgen.biomes.caves;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.joml.Vector2f;

import java.util.ArrayList;

public class CaveBiomesMap {
    private final ArrayList<CaveBiomeDTO> caves;

    public CaveBiomesMap() {
        this.caves = new ArrayList<>();
    }

    public void addCave(CaveBiomeDTO caveBiomeDTO) {
        caves.add(caveBiomeDTO);
    }

    public ResourceKey<Biome> getClosestBiome(Vector2f coordinates) {
        ResourceKey<Biome> biome = null;
        float currentDistance = Float.MAX_VALUE; // Используем максимальное значение для поиска минимального расстояния
        for (CaveBiomeDTO biomeDTO : caves) {
            float distance = biomeDTO.coordinates.distanceSquared(coordinates);
            if (distance < currentDistance) {
                currentDistance = distance;
                biome = biomeDTO.biome;
            }
        }
        return biome;
    }
}
