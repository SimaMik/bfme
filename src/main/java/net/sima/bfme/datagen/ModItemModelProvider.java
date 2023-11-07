package net.sima.bfme.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BFME.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        wallItem(ModBlocks.GONDORIAN_STONE_WALL, ModBlocks.GONDORIAN_STONE);
        wallItem(ModBlocks.GONDORIAN_OVERGROWN_STONE_WALL, ModBlocks.GONDORIAN_OVERGROWN_STONE);
        wallItem(ModBlocks.GONDORIAN_MOSSY_STONE_WALL, ModBlocks.GONDORIAN_MOSSY_STONE);
        wallItem(ModBlocks.GONDORIAN_CRACKED_STONE_WALL, ModBlocks.GONDORIAN_CRACKED_STONE);
        wallItem(ModBlocks.GONDORIAN_COBBLESTONE_WALL, ModBlocks.GONDORIAN_COBBLESTONE);
        wallItem(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_WALL, ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE);
        wallItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL, ModBlocks.GONDORIAN_MOSSY_COBBLESTONE);
        wallItem(ModBlocks.GONDORIAN_BRICK_WALL, ModBlocks.GONDORIAN_BRICK);
        wallItem(ModBlocks.GONDORIAN_BRICKWORK_WALL, ModBlocks.GONDORIAN_BRICKWORK);
        wallItem(ModBlocks.GONDORIAN_OVERGROWN_BRICK_WALL, ModBlocks.GONDORIAN_OVERGROWN_BRICK);
        wallItem(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_WALL, ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK);
        wallItem(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL, ModBlocks.GONDORIAN_MOSSY_BRICK);
        wallItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL, ModBlocks.GONDORIAN_MOSSY_BRICKWORK);
        wallItem(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL, ModBlocks.GONDORIAN_CRACKED_BRICK);
        wallItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL, ModBlocks.GONDORIAN_CRACKED_BRICKWORK);




    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BFME.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(BFME.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BFME.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(BFME.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(BFME.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(BFME.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BFME.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BFME.MOD_ID,"item/" + item.getId().getPath()));
    }
}
