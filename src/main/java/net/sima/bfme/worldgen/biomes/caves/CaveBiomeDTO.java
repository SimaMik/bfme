package net.sima.bfme.worldgen.biomes.caves;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.joml.Vector2f;

public class CaveBiomeDTO {
    ResourceKey<Biome> biome;
    Vector2f coordinates;

    public CaveBiomeDTO(ResourceKey<Biome> biome, Vector2f coordinates) {
        this.biome = biome;
        this.coordinates = coordinates;
    }
}
