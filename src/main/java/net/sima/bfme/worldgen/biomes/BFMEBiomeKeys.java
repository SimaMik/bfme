package net.sima.bfme.worldgen.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.sima.bfme.BFME;
import net.sima.bfme.util.LoggerUtil;

public class BFMEBiomeKeys {
    // Pelennor & Anórien
    public static final ResourceKey<Biome> PELENNOR_PLAINS = create("pelennor_plains");
    public static final ResourceKey<Biome> LOSSARNACH_FARMLANDS = create("lossarnach_farmlands");
    public static final ResourceKey<Biome> ANORIEN_OPEN_LANDS = create("anorien_open_lands");

    // Ithilien
    public static final ResourceKey<Biome> NORTH_ITHILIEN = create("north_ithilien");
    public static final ResourceKey<Biome> SOUTH_ITHILIEN = create("south_ithilien");

    public static final ResourceKey<Biome> DRUADAN_FOREST = create("druadan_forest");
    public static final ResourceKey<Biome> GREY_WOOD = create("grey_wood");

    // Rivers & floodplains
    public static final ResourceKey<Biome> RIVER_ANDUIN = create("river_anduin");
    public static final ResourceKey<Biome> ANDUIN_BANKS = create("anduin_banks");

    // Hills & transitional lands
    public static final ResourceKey<Biome> EMYN_ARNEN_HILLS = create("emyn_arnen_hills");
    public static final ResourceKey<Biome> AMON_DIN_HILLS = create("amon_din_hills");
    public static final ResourceKey<Biome> EILENACH_MOORLANDS = create("eilenach_moorlands");
    // White Mountains
    public static final ResourceKey<Biome> WHITE_MOUNTAINS_FOOTHILLS = create("white_mountains_foothills");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS = create("white_mountains");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS_PEAKS = create("white_mountains_peaks");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS_HIGH_PEAKS = create("white_mountains_high_peaks");
    // Special locations
    public static final ResourceKey<Biome> CAIR_ANDROS = create("cair_andros");
    // Mordor
    public static final ResourceKey<Biome> DAGORLAD_WASTES = create("dagorlad_wastes");
    public static final ResourceKey<Biome> GORGOROTH_PLAINS = create("gorgoroth_plains");
    public static final ResourceKey<Biome> EPHEL_DUATH = create("ephel_duath");
    public static final ResourceKey<Biome> EPHEL_DUATH_PEAKS = create("ephel_duath_peaks");
    public static final ResourceKey<Biome> EPHEL_DUATH_BLACK_PEAKS = create("ephel_duath_black_peaks");

    // Cave biomes
    public static final ResourceKey<Biome> CAVE_LUSH = create("cave_lush");
    public static final ResourceKey<Biome> CAVE_DRIPSTONE = create("cave_dripstone");
    public static final ResourceKey<Biome> CAVE_CRYSTAL = create("cave_crystal");

    private static ResourceKey<Biome> create(String name) {
        return ResourceKey.create(Registries.BIOME, BFME.resource(name));
    }

    public static void registerModBiomes() {
        LoggerUtil.getInstance().logDebugMsg("Registering ModBiomes for " + BFME.MOD_ID);
    }
}
