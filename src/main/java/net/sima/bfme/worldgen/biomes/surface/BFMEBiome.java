package net.sima.bfme.worldgen.biomes.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sima.bfme.worldgen.surface.SurfaceConfig;

import java.awt.Color;
import java.util.function.Supplier;

public class BFMEBiome {

    public final Color color;
    public final ResourceKey<Biome> biome;

    private final Supplier<Block> upperStoneBlock;
    private final Supplier<Block> stoneBlock;
    private final SurfaceConfig surfaceConfig;

    private BFMEBiome(Builder builder) {
        this.color = builder.color;
        this.biome = builder.biome;
        this.upperStoneBlock = builder.upperStoneBlock;
        this.stoneBlock = builder.stoneBlock;
        this.surfaceConfig = builder.surfaceConfig;
    }

    public Block getUpperStoneBlock() {
        return upperStoneBlock != null ? upperStoneBlock.get() : Blocks.STONE;
    }

    public Block getStoneBlock() {
        return stoneBlock != null ? stoneBlock.get() : Blocks.STONE;
    }

    public SurfaceConfig getSurfaceConfig() {
        return surfaceConfig;
    }

    public String getKey() {
        return biome != null ? biome.location().toString() : "null";
    }


    public static class Builder {
        private final ResourceKey<Biome> biome;

        private Color color = null;

        private Supplier<Block> upperStoneBlock = () -> Blocks.STONE;
        private Supplier<Block> stoneBlock = () -> Blocks.STONE;
        private SurfaceConfig surfaceConfig = null;

        public Builder(ResourceKey<Biome> biome) {
            this.biome = biome;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder surfaceConfig(SurfaceConfig config) {
            this.surfaceConfig = config;
            return this;
        }

        public Builder upperStone(Block block) {
            this.upperStoneBlock = () -> block;
            return this;
        }

        public Builder upperStone(DeferredBlock<Block> block) {
            this.upperStoneBlock = block::get;
            return this;
        }

        public Builder stone(Block block) {
            this.stoneBlock = () -> block;
            return this;
        }

        public Builder stone(DeferredBlock<Block> block) {
            this.stoneBlock = block::get;
            return this;
        }

        public BFMEBiome build() {
            return new BFMEBiome(this);
        }
    }
}
