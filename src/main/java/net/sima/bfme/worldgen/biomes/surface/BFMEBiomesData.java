package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;

import java.awt.*;
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

    public static void addBiome(Color color, BFMEBiome biome) {
        biome.color = color;
        biomes.add(biome);
    }

    public static void loadBiomes() {
        // Основные биомы
        addBiome(new Color (16, 184, 23), new BFMEBiome(5, BFMEBiomeKeys.FIRIEN_WOOD, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));
        addBiome(new Color(91, 189, 85), new BFMEBiome(6, BFMEBiomeKeys.PELENNOR_PLAINS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));
        addBiome(new Color(242, 255, 240), new BFMEBiome(50, BFMEBiomeKeys.WHITE_MOUNTAINS, ModBlocks.GONDORIAN_STONE, ModBlocks.GONDORIAN_STONE, ModBlocks.GONDORIAN_STONE, Blocks.STONE));
        addBiome(new Color(219, 245, 215), new BFMEBiome(30, BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS, Blocks.GRASS_BLOCK, ModBlocks.GONDORIAN_STONE, ModBlocks.GONDORIAN_STONE, Blocks.STONE));
        addBiome(new Color(91, 132, 184), new BFMEBiome(-10, BFMEBiomeKeys.ANDUIN_BANKS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND));
        addBiome(new Color(65, 135, 61), new BFMEBiome(7, BFMEBiomeKeys.DRUADAN_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));

        addBiome(new Color(104, 148, 90), new BFMEBiome(5, BFMEBiomeKeys.GREYWOOD, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE));
        addBiome(new Color(79, 123, 168), new BFMEBiome(-9, BFMEBiomeKeys.ENTWASH, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND));
        defaultBiome = getBiomeByKey(BFMEBiomeKeys.ENTWASH);

    }

    public static BFMEBiome getBiomeByKey(ResourceKey<Biome> key) {
        return biomes.stream()
                .filter(b -> b.biome.equals(key))
                .findFirst()
                .orElse(defaultBiome);

    }

    public static BFMEBiome getBiomeByColor(Integer rgb){
        try{
            return biomes.stream().filter(x -> x.color.getRGB() == rgb).findFirst().get();
        } catch (Exception e){
            System.out.println("MeBiomes::No registered biome has %s for color".formatted(rgb));
        }
        return null;
    }

}
