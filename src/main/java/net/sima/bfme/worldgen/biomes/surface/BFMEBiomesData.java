package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.surface.SurfaceConfigs;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class BFMEBiomesData {
    public static final List<BFMEBiome> biomes = new ArrayList<>();
    public static final List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static final List<ResourceKey<Biome>> frozenBiomes = new ArrayList<>();
    public static final List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static final List<ResourceKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static final List<ResourceKey<Biome>> oasisBiomes = new ArrayList<>();

    public static BFMEBiome defaultBiome;

    public static void addBiome(BFMEBiome biome) {
        biomes.add(biome);
    }

    public static void loadBiomes() {
        biomes.clear();
        waterBiomes.clear();
        frozenBiomes.clear();
        wastePondBiomes.clear();
        mirkwoodSwampBiomes.clear();
        oasisBiomes.clear();

        // ------------------------------------------------------------
        // Gondor / Anórien / Pelennor / Lossarnach
        // ------------------------------------------------------------

        // 1) Pelennor Plains
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.PELENNOR_PLAINS)
                .color(new Color(90, 190, 85))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.PELENNOR_PLAINS)
                .build());

        // 2) Lossarnach Farmlands
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.LOSSARNACH_FARMLANDS)
                .color(new Color(90, 200, 85))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.LOSSARNACH_FARMLANDS)
                .build());

        // 3) Anórien Open Lands
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.ANORIEN_OPEN_LANDS)
                .color(new Color(95, 195, 90))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.ANORIEN_OPEN_LANDS)
                .build());

        // ------------------------------------------------------------
        // Ithilien
        // ------------------------------------------------------------

        // 4) South Ithilien
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.SOUTH_ITHILIEN)
                .color(new Color(90, 210, 85))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.SOUTH_ITHILIEN)
                .build());

        // 5) North Ithilien
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.NORTH_ITHILIEN)
                .color(new Color(165, 185, 150))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.NORTH_ITHILIEN)
                .build());

        // 7) Grey Wood
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.GREY_WOOD)
                .color(new Color(40, 180, 80))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.GREY_WOOD)
                .build());

        // 8) Druadan Forest
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.DRUADAN_FOREST)
                .color(new Color(35, 180, 75))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.DRUADAN_FOREST)
                .build());

        // ------------------------------------------------------------
        // Rivers & Floodplains
        // ------------------------------------------------------------

        // 12) Anduin River
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.RIVER_ANDUIN)
                .color(new Color(90, 130, 185))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.RIVER_ANDUIN)
                .build());
        waterBiomes.add(BFMEBiomeKeys.RIVER_ANDUIN);

        // 6) Anduin Banks
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.ANDUIN_BANKS)
                .color(new Color(160, 195, 150))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.ANDUIN_BANKS)
                .build());

        // ------------------------------------------------------------
        // Hills & transitional lands
        // ------------------------------------------------------------

        // 9) Emyn Arnen Hills
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.EMYN_ARNEN_HILLS)
                .color(new Color(170, 150, 120))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.EMYN_ARNEN_HILLS)
                .build());

        // 10) Amon Din Hills
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.AMON_DIN_HILLS)
                .color(new Color(175, 155, 125))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.AMON_DIN_HILLS)
                .build());

        // 11) Eilenach Moorlands
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.EILENACH_MOORLANDS)
                .color(new Color(180, 160, 130))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.EILENACH_MOORLANDS)
                .build());

        // ------------------------------------------------------------
        // White Mountains
        // ------------------------------------------------------------

        // 13) White Mountains Foothills
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS)
                .color(new Color(220, 245, 215))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.WHITE_MOUNTAINS_FOOTHILLS)
                .build());

        // 14) White Mountains
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.WHITE_MOUNTAINS)
                .color(new Color(195, 195, 195))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.WHITE_MOUNTAINS)
                .build());

        // 15) White Mountains Peaks
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.WHITE_MOUNTAINS_PEAKS)
                .color(new Color(215, 215, 215))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.WHITE_MOUNTAINS_PEAKS)
                .build());

        // 16) White Mountains High Peaks
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.WHITE_MOUNTAINS_HIGH_PEAKS)
                .color(new Color(255, 255, 255))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.WHITE_MOUNTAINS_HIGH_PEAKS)
                .build());

        // ------------------------------------------------------------
        // Special locations
        // ------------------------------------------------------------

        // 17) Cair Andros
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.CAIR_ANDROS)
                .color(new Color(210, 215, 205))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.CAIR_ANDROS)
                .build());

        // ------------------------------------------------------------
        // Mordor
        // ------------------------------------------------------------

        // 18) Dagorlad Wastes
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.DAGORLAD_WASTES)
                .color(new Color(140, 100, 40))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.DAGORLAD_WASTES)
                .build());

        // 22) Gorgoroth Plains
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.GORGOROTH_PLAINS)
                .color(new Color(185, 170, 135))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.GORGOROTH_PLAINS)
                .build());

        // 19) Ephel Dúath
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.EPHEL_DUATH)
                .color(new Color(100, 70, 30))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.EPHEL_DUATH)
                .build());

        // 20) Ephel Dúath Peaks
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.EPHEL_DUATH_PEAKS)
                .color(new Color(70, 50, 20))
                .upperStone(Blocks.STONE)
                .stone(Blocks.STONE)
                .surfaceConfig(SurfaceConfigs.EPHEL_DUATH_PEAKS)
                .build());

        // 21) Ephel Dúath Black Peaks
        addBiome(new BFMEBiome.Builder(BFMEBiomeKeys.EPHEL_DUATH_BLACK_PEAKS)
                .color(new Color(0, 0, 0))
                .upperStone(Blocks.BLACKSTONE)
                .stone(Blocks.BLACKSTONE)
                .surfaceConfig(SurfaceConfigs.EPHEL_DUATH_BLACK_PEAKS)
                .build());

        // ------------------------------------------------------------
        // Default
        // ------------------------------------------------------------
        defaultBiome = getBiomeByKey(BFMEBiomeKeys.PELENNOR_PLAINS);
    }

    public static BFMEBiome getBiomeByKey(ResourceKey<Biome> key) {
        return biomes.stream()
                .filter(b -> b.biome.equals(key))
                .findFirst()
                .orElse(defaultBiome);
    }

    public static BFMEBiome getBiomeByColor(Integer rgb) {
        try {
            return biomes.stream()
                    .filter(x -> x.color != null && x.color.getRGB() == rgb)
                    .findFirst()
                    .orElse(defaultBiome);
        } catch (Exception e) {
            System.out.println("BFMEBiomes::No registered biome has %s for color".formatted(rgb));
        }
        return defaultBiome;
    }
}
