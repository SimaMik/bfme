package net.sima.bfme.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;

import java.util.Objects;

import static net.sima.bfme.block.ModBlocks.BLOCKS;
import static net.sima.bfme.block.ModBlocks.GONDORIAN_BRICK;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BFME.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallItem(ModBlocks.GONDORIAN_STONE_WALL.get());
        wallItem(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
        wallItem(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
        wallItem(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
        wallItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
        wallItem(ModBlocks.GONDORIAN_BRICK_WALL.get());
        wallItem(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
        wallItem(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
        wallItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
        wallItem(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
        wallItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());

        buttonItem(ModBlocks.GONDORIAN_STONE_BUTTON.get());
        buttonItem(ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get());
        buttonItem(ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get());
        buttonItem(ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get());
        buttonItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get());
        buttonItem(ModBlocks.GONDORIAN_BRICK_BUTTON.get());

        pouchItem(ModItems.SMALL_POUCH);
        pouchItem(ModItems.MEDIUM_POUCH);
        pouchItem(ModItems.LARGE_POUCH);


        basicItem(ModItems.RAW_AMBER.get());
        basicItem(ModItems.RAW_AMETHYST.get());
        basicItem(ModItems.RAW_DIAMOND.get());
        basicItem(ModItems.RAW_EMERALD.get());
        basicItem(ModItems.RAW_OPAL.get());
        basicItem(ModItems.RAW_RUBY.get());
        basicItem(ModItems.RAW_SAPPHIRE.get());
        basicItem(ModItems.RAW_TOPAZ.get());
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.AMETHYST.get());
        basicItem(ModItems.DIAMOND.get());
        basicItem(ModItems.EMERALD.get());
        basicItem(ModItems.OPAL.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.SAPPHIRE.get());
        basicItem(ModItems.TOPAZ.get());
        basicItem(ModItems.RAW_MITHRIL.get());
        basicItem(ModItems.MITHRIL_INGOT.get());
        basicItem(ModItems.MITHRIL_NUGGET.get());
        basicItem(ModItems.RAW_SILVER.get());
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.SILVER_NUGGET.get());
        basicItem(ModItems.BRONZE_INGOT.get());
        basicItem(ModItems.BRONZE_NUGGET.get());
        basicItem(ModItems.RAW_SALT.get());
        basicItem(ModItems.SALT.get());
        basicItem(ModItems.RAW_SALTPETER.get());
        basicItem(ModItems.SALTPETER.get());
        basicItem(ModItems.RAW_SULFUR.get());
        basicItem(ModItems.SULFUR.get());
    }


    private ItemModelBuilder pouchItem(DeferredItem item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"item/" + item.getId().getPath())).texture("layer1",
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"item/" + item.getId().getPath() + "_overlay"));
    }
    public void wallItem(Block block){
        this.withExistingParent(name(block), mcLoc("block/wall_inventory"))
                .texture("wall", change(block, "_wall", ""));
    }

    public void buttonItem(Block block){
        this.withExistingParent(name(block), mcLoc("block/button_inventory"))
                .texture("texture", change(block, "_button", ""));
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    private ResourceLocation change(Block block, String replaced, String replace) {
        ResourceLocation name = this.key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace().replaceAll(replaced, replace), name.getPath().replaceAll(replaced, replace));
    }
}