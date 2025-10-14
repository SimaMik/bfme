package net.sima.bfme.worldgen.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.sima.bfme.BFME;
import net.sima.bfme.util.LoggerUtil;

public class BFMEBiomeKeys {

    public static final ResourceKey<Biome> PELENNOR_PLAINS = create("pelennor_plains");
    public static final ResourceKey<Biome> FIRIEN_WOOD = create("firien_wood");
    public static final ResourceKey<Biome> DRUADAN_FOREST = create("druadan_forest");
    public static final ResourceKey<Biome> GREYWOOD = create("greywood");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS_FOOTHILLS = create("white_mountains_foothills");
    public static final ResourceKey<Biome> ANDUIN_BANKS = create("anduin_banks");
    public static final ResourceKey<Biome> ENTWASH = create("entwash");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS = create("white_mountains");

    private static ResourceKey<Biome> create(String name) {
        return ResourceKey.create(Registries.BIOME, BFME.resource(name));
    }

    public static void registerModBiomes() {
        LoggerUtil.getInstance().logDebugMsg("Registering ModBiomes for " + BFME.MOD_ID);
    }
}
