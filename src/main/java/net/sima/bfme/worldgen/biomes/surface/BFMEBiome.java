package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sima.bfme.worldgen.biomes.caves.CaveType;

import java.awt.*;

public class BFMEBiome {
    public int height;
    public Color color;
    public ResourceKey<Biome> biome;
    public Block surfaceBlock;
    public Block underSurfaceBlock;
    public Block upperStoneBlock;
    public Block stoneBlock;
    public DeferredBlock<Block> deferredSurfaceBlock;
    public DeferredBlock<Block> deferredUnderSurfaceBlock;
    public DeferredBlock<Block> deferredUpperStoneBlock;
    public DeferredBlock<Block> deferredStoneBlock;
    public CaveType caveType;

    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, stoneBlock, stoneBlock, CaveType.DEFAULT);
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock, CaveType caveType) {
        this(height, biome, surfaceBlock, underSurfaceBlock, stoneBlock, stoneBlock, caveType);
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block upperStoneBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, upperStoneBlock, stoneBlock, CaveType.DEFAULT);
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block upperStoneBlock, Block stoneBlock, CaveType caveType) {
        this.height = height;
        this.biome = biome;
        this.surfaceBlock = surfaceBlock;
        this.underSurfaceBlock = underSurfaceBlock;
        this.upperStoneBlock = upperStoneBlock;
        this.stoneBlock = stoneBlock;
        this.caveType = caveType;
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, DeferredBlock<Block> deferredSurfaceBlock, DeferredBlock<Block> deferredUnderSurfaceBlock, DeferredBlock<Block> deferredUpperStoneBlock, DeferredBlock<Block> deferredStoneBlock) {
        this.height = height;
        this.biome = biome;
        this.deferredSurfaceBlock = deferredSurfaceBlock;
        this.deferredUnderSurfaceBlock = deferredUnderSurfaceBlock;
        this.deferredUpperStoneBlock = deferredUpperStoneBlock;
        this.deferredStoneBlock = deferredStoneBlock;
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, DeferredBlock surfaceBlock, DeferredBlock underSurfaceBlock, DeferredBlock upperStoneBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, upperStoneBlock, stoneBlock, CaveType.DEFAULT);
    }
    public BFMEBiome(int height, ResourceKey<Biome> biome, DeferredBlock<Block> deferredSurfaceBlock, DeferredBlock<Block> deferredUnderSurfaceBlock, DeferredBlock<Block> deferredUpperStoneBlock, Block stoneBlock, CaveType caveType) {
        this.height = height;
        this.biome = biome;
        this.deferredSurfaceBlock = deferredSurfaceBlock;
        this.deferredUnderSurfaceBlock = deferredUnderSurfaceBlock;
        this.deferredUpperStoneBlock = deferredUpperStoneBlock;
        this.stoneBlock = stoneBlock;
        this.caveType = caveType;
    }
    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, DeferredBlock underSurfaceBlock, DeferredBlock upperStoneBlock, Block stoneBlock) {
        this(height, biome, surfaceBlock, underSurfaceBlock, upperStoneBlock, stoneBlock, CaveType.DEFAULT);
    }
    public BFMEBiome(int height, ResourceKey<Biome> biome, Block surfaceBlock, DeferredBlock<Block> deferredUnderSurfaceBlock, DeferredBlock<Block> deferredUpperStoneBlock, Block stoneBlock, CaveType caveType) {
        this.height = height;
        this.biome = biome;
        this.surfaceBlock = surfaceBlock;
        this.deferredUnderSurfaceBlock = deferredUnderSurfaceBlock;
        this.deferredUpperStoneBlock = deferredUpperStoneBlock;
        this.stoneBlock = stoneBlock;
        this.caveType = caveType;
    }

    public BFMEBiome(int height, ResourceKey<Biome> biome, DeferredBlock<Block> deferredSurfaceBlock, DeferredBlock<Block> deferredUnderSurfaceBlock, DeferredBlock<Block> deferredUpperStoneBlock, DeferredBlock<Block> deferredStoneBlock, CaveType caveType) {
        this.height = height;
        this.biome = biome;
        this.deferredSurfaceBlock = deferredSurfaceBlock;
        this.deferredUnderSurfaceBlock = deferredUnderSurfaceBlock;
        this.deferredUpperStoneBlock = deferredUpperStoneBlock;
        this.deferredStoneBlock = deferredStoneBlock;
        this.caveType = caveType;
    }

    public String getKey() {
        return biome != null ? biome.location().toString() : "null";
    }
    public Block getSurfaceBlock() {
        return deferredSurfaceBlock != null && deferredSurfaceBlock.get() != null
                ? deferredSurfaceBlock.get()
                : (surfaceBlock != null ? surfaceBlock : Blocks.STONE);
    }

    public Block getUnderSurfaceBlock() {
        return deferredUnderSurfaceBlock != null && deferredUnderSurfaceBlock.get() != null
                ? deferredUnderSurfaceBlock.get()
                : (underSurfaceBlock != null ? underSurfaceBlock : Blocks.DIRT);
    }

    public Block getStoneBlock() {
        return deferredStoneBlock != null && deferredStoneBlock.get() != null
                ? deferredStoneBlock.get()
                : (stoneBlock != null ? stoneBlock : Blocks.STONE);
    }

    public Block getUpperStoneBlock() {
        return deferredUpperStoneBlock != null && deferredUpperStoneBlock.get() != null
                ? deferredUpperStoneBlock.get()
                : (upperStoneBlock != null ? upperStoneBlock : Blocks.STONE);
    }

}
