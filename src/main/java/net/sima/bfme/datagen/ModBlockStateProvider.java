package net.sima.bfme.datagen;

import com.google.gson.JsonElement;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.block.custom.LampBlock;
import net.sima.bfme.block.custom.CattailCropBlock;
import net.sima.bfme.block.custom.KohlrabiCropBlock;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BFME.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {

      blockWithItem(ModBlocks.GONDORIAN_STONE);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_STONE);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_STONE);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_STONE);
      blockWithItem(ModBlocks.GONDORIAN_COBBLESTONE);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE);
      blockWithItem(ModBlocks.GONDORIAN_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_BRICKWORK);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK);
      blockWithItem(ModBlocks.GONDORIAN_CHISELED_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_CHISELED_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_CHISELED_BRICK);

      blockWithItem(ModBlocks.GONDORIAN_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_THIN_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_OVERGROWN_THIN_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_MOSSY_THIN_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_PILLAR);
      blockWithItem(ModBlocks.GONDORIAN_CRACKED_THIN_PILLAR);

      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_STONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_STONE.get()), blockTexture(ModBlocks.GONDORIAN_STONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_OVERGROWN_STONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_STONE.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_STONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_STONE.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_STONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_CRACKED_STONE.get()), blockTexture(ModBlocks.GONDORIAN_CRACKED_STONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_COBBLESTONE.get()), blockTexture(ModBlocks.GONDORIAN_COBBLESTONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_BRICK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_BRICK.get()), blockTexture(ModBlocks.GONDORIAN_BRICK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_BRICKWORK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_BRICKWORK.get()), blockTexture(ModBlocks.GONDORIAN_BRICKWORK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_OVERGROWN_BRICK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICK.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_PILLAR_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_PILLAR.get()), blockTexture(ModBlocks.GONDORIAN_PILLAR.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_OVERGROWN_PILLAR_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_PILLAR.get()), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_PILLAR.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_PILLAR.get()), blockTexture(ModBlocks.GONDORIAN_MOSSY_PILLAR.get()));
      slabBlock(((SlabBlock)ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get()), blockTexture(ModBlocks.GONDORIAN_CRACKED_PILLAR.get()), blockTexture(ModBlocks.GONDORIAN_CRACKED_PILLAR.get()));

      blockItem(ModBlocks.GONDORIAN_STONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_STONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_COBBLESTONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB);
      blockItem(ModBlocks.GONDORIAN_BRICK_SLAB);
      blockItem(ModBlocks.GONDORIAN_BRICKWORK_SLAB);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_BRICK_SLAB);
      blockItem(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_SLAB);
      blockItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB);
      blockItem(ModBlocks.GONDORIAN_PILLAR_SLAB);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_PILLAR_SLAB);
      blockItem(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB);
      blockItem(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB);

      stairsBlock((StairBlock)ModBlocks.GONDORIAN_STONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_STONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_OVERGROWN_STONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_STONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_STONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_STONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_COBBLESTONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_BRICK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_BRICK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_BRICKWORK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_OVERGROWN_BRICK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_BRICK.get()));
      stairsBlock((StairBlock)ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get()));

      blockItem(ModBlocks.GONDORIAN_STONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_STONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS);
      blockItem(ModBlocks.GONDORIAN_BRICK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_BRICKWORK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_BRICK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS);
      blockItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS);

      wallBlock((WallBlock) ModBlocks.GONDORIAN_STONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_STONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_OVERGROWN_STONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_STONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_STONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_STONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_COBBLESTONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_COBBLESTONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_BRICK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_BRICK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_BRICKWORK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_BRICKWORK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_OVERGROWN_BRICK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_BRICK.get()));
      wallBlock((WallBlock) ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get(), blockTexture(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get()));

//      buttonBlock((ButtonBlock) ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));















    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                new ResourceLocation(BFME.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCattailCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cattailStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cattailStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CattailCropBlock) block).getAgeProperty()),
                new ResourceLocation(BFME.MOD_ID, "block/" + textureName + state.getValue(((CattailCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

//    private void customLamp() {
//        getVariantBuilder(ModBlocks.ALEXANDRITE_LAMP.get()).forAllStates(state -> {
//            if(state.getValue(AlexandriteLampBlock.CLICKED)) {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_on",
//                        new ResourceLocation(BFME.MOD_ID, "block/" + "alexandrite_lamp_on")))};
//            } else {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_off",
//                        new ResourceLocation(BFME.MOD_ID, "block/" +"alexandrite_lamp_off")))};
//            }
//        });
//        simpleBlockItem(ModBlocks.ALEXANDRITE_LAMP.get(), models().cubeAll("alexandrite_lamp_on",
//                new ResourceLocation(BFME.MOD_ID, "block/" +"alexandrite_lamp_on")));
//    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("bfme:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("bfme:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}