package net.sima.bfme.worldgen.chunkgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.sima.bfme.util.BlendedNoise;
import net.sima.bfme.util.SimplexNoise;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomeSource;
import net.sima.bfme.worldgen.chunkgen.map.BFMEHeightMap;
import net.sima.bfme.worldgen.map.BFMEMapRuntime;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BFMEChunkGenerator extends ChunkGenerator {
    public static final int DEEPSLATE_LEVEL = 32;
    public static final int STONE_HEIGHT = 36;
    public static final int WATER_HEIGHT = 64;
    public static final int LAVA_HEIGHT = -119;
    public static final int HEIGHT = 27 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;
    public static final int CAVE_NOISE = 5;
    public static final int BEDROCK_LAYERS = 1;
    private static final int CAVE_STRETCH_H = 60;
    private static final int CAVE_STRETCH_V = 50;

    public static final MapCodec<BFMEChunkGenerator> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BFMEBiomeSource.MAP_CODEC.fieldOf("bfme_biome_source").forGetter(generator -> generator.bfmeBiomeSource)
    ).apply(instance, BFMEChunkGenerator::new));

    protected final BFMEBiomeSource bfmeBiomeSource;

    public BFMEChunkGenerator(BFMEBiomeSource biomeSource) {
        super(biomeSource, biome -> biome.value().getGenerationSettings());
        this.bfmeBiomeSource = biomeSource;
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return MAP_CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion worldGenRegion, long l, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carving) {

    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunkAccess) {
//
//        ChunkPos chunkPos = chunkAccess.getPos();
//        int xStart = chunkPos.getMinBlockX();
//        int zStart = chunkPos.getMinBlockZ();
//        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
//
//        int minY = chunkAccess.getMinBuildHeight();
//
//        // Генерация бедрока
//        generateBedrock(chunkAccess, minY, xStart, zStart);
//
//        // Генерация обычных блоков
//        for (int x = 0; x < 16; x++) {
//            for (int z = 0; z < 16; z++) {
//                int worldX = xStart + x;
//                int worldZ = zStart + z;
//
//                BFMEBiome biome = BFMEMapRuntime.getInstance().getBiome(worldX, worldZ);
//                float height = BFMEHeightMap.getHeight(worldX, worldZ);
//
//                generateTerrain(chunkAccess, mutablePos, worldX, worldZ, biome, height);
//            }
//        }

        return CompletableFuture.completedFuture(chunkAccess);
 }

    private void generateBedrock(ChunkAccess chunkAccess, int minY, int xStart, int zStart) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = minY; y < minY + BEDROCK_LAYERS; y++) {
                    pos.set(xStart + x, y, zStart + z);
                    chunkAccess.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
                }
            }
        }
    }

    private void generateTerrain(ChunkAccess chunkAccess, BlockPos.MutableBlockPos pos, int worldX, int worldZ, BFMEBiome biome, float height) {
        int surfaceHeight = (int) height + BFMEHeightMap.HEIGHT;

        for (int y = chunkAccess.getMinBuildHeight() + BEDROCK_LAYERS; y <= surfaceHeight; y++) {
            pos.set(worldX, y, worldZ);
            BlockState blockState = biome.getStoneBlock().defaultBlockState();
            chunkAccess.setBlockState(pos, blockState, false);
        }
    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structureManager, RandomState randomState, ChunkAccess chunk) {
        ChunkPos chunkPos = chunk.getPos();
        int bottomY = chunk.getMinBuildHeight();
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkPos.getMinBlockX() + x;
                int worldZ = chunkPos.getMinBlockZ() + z;

                BFMEBiome biome = BFMEMapRuntime.getInstance().getBiome(worldX, worldZ);
                float height = BFMEHeightMap.getHeight(worldX, worldZ);

                float caveBlendNoise = (float) ((2 * CAVE_NOISE * BlendedNoise.noise((double) worldX / 24,  (double) worldZ / 24)) - CAVE_NOISE);

                chunk.setBlockState(mutablePos.set(x, bottomY, z), Blocks.BEDROCK.defaultBlockState(), false);
                for(int y = bottomY + 1; y <= LAVA_HEIGHT; y++) {
                    chunk.setBlockState(mutablePos.set(x, y, z), Blocks.LAVA.defaultBlockState(), false);
                }
                for(int y = bottomY + 1 + (int) caveBlendNoise; y < DEEPSLATE_LEVEL + caveBlendNoise; y++) {
                    trySetBlock(chunk, mutablePos.set(x, y, z), Blocks.DEEPSLATE.defaultBlockState());
                }

                float dirtHeight = HEIGHT + height - 1;
                for(int y = DEEPSLATE_LEVEL + (int) caveBlendNoise; y < (dirtHeight / 2); y++) {
                    trySetBlock(chunk, mutablePos.set(x, y, z), biome.getStoneBlock().defaultBlockState());
                }
                for(int y = (int) (dirtHeight / 2); y < dirtHeight; y++) {
                    trySetBlock(chunk, mutablePos.set(x, y, z), biome.getUpperStoneBlock().defaultBlockState());
                }

                chunk.setBlockState(mutablePos.set(x, (int) (HEIGHT + height - 1), z), biome.getStoneBlock().defaultBlockState(), false);
                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(mutablePos.set(x, y, z), biome.getUnderSurfaceBlock().defaultBlockState(), false);
                }

                BlockState surfaceBlock = biome.getSurfaceBlock().defaultBlockState();

                if(DIRT_HEIGHT + height < WATER_HEIGHT && biome.surfaceBlock == Blocks.GRASS_BLOCK) {
                    surfaceBlock = Blocks.DIRT.defaultBlockState();
                }

                chunk.setBlockState(mutablePos.set(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);

                for(int y = (int) (DIRT_HEIGHT + height + 1); y <= WATER_HEIGHT; y++) {
                    chunk.setBlockState(mutablePos.set(x, y, z), Blocks.WATER.defaultBlockState(), false);
                }
            }
        }
    }


    private void trySetBlock(ChunkAccess chunk, BlockPos.MutableBlockPos blockPos, BlockState blockState) {
        float noise = 0;
        if(blockPos.getY() < WATER_HEIGHT) {
            noise =(float) SimplexNoise.noise(
                    (float) blockPos.getX() / CAVE_STRETCH_H, Math.tan((float) blockPos.getY() / CAVE_STRETCH_V), (float) blockPos.getZ() / CAVE_STRETCH_H);
            noise += 0.5f * (float) SimplexNoise.noise(
                    (float) blockPos.getX() / (CAVE_STRETCH_H * 0.5f), (float) blockPos.getY() / (CAVE_STRETCH_V * 0.5f), (float) blockPos.getZ() / (CAVE_STRETCH_H * 0.5f));
            noise = noise / (1 + 0.5f);
        }
        float noise3 = (float) SimplexNoise.noise((float) blockPos.getX() / 90, (float) blockPos.getY() / 60, (float) blockPos.getZ() / 90);
        float miniNoise = (float) SimplexNoise.noise((float) blockPos.getX() / 40, (float) blockPos.getY() / 30, (float) blockPos.getZ() / 40);

        if(noise < 0.3f && noise3 < 0.65f && miniNoise < 0.7f) { //
            chunk.setBlockState(blockPos, blockState, false);
        }
    }
    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types heightmapType, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        float height = BFMEHeightMap.getHeight(x, z);
        return (int) (height + BFMEHeightMap.HEIGHT);
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        int height = (int) BFMEHeightMap.getHeight(x, z);
        BlockState[] states = new BlockState[height];
        for (int i = 0; i < height; i++) {
            states[i] = Blocks.STONE.defaultBlockState();
        }
        return new NoiseColumn(height, states);
    }

    @Override
    public void addDebugScreenInfo(List<String> list, RandomState randomState, BlockPos blockPos) {
        list.add("Debug Info Placeholder");
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion worldGenRegion) {

    }

    @Override
    public int getGenDepth() {
        return 576;
    }

    @Override
    public int getSeaLevel() {
        return WATER_HEIGHT;
    }

    @Override
    public int getMinY() {
        return -128;
    }
}
