package net.sima.bfme.worldgen.biomes.caves;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import org.joml.Vector2f;

public class ModCaveBiomes {

    public static CaveBiomesMap defaultCaves = new CaveBiomesMap();

    public static void init() {
        defaultCaves.addCave(new CaveBiomeDTO(BFMEBiomeKeys.CAVE_LUSH, new Vector2f(-1.0f, 0.5f)));
        defaultCaves.addCave(new CaveBiomeDTO(BFMEBiomeKeys.CAVE_DRIPSTONE, new Vector2f(1.0f, 0.5f)));
        defaultCaves.addCave(new CaveBiomeDTO(BFMEBiomeKeys.CAVE_CRYSTAL, new Vector2f(0.0f, -1.0f)));
    }

    public static ResourceKey<Biome> getBiome(Vector2f coordinates) {
        return defaultCaves.getClosestBiome(coordinates);
    }
}
