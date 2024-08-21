package net.sima.bfme.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
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

        wallItem(ModBlocks.DURIN_STONE_WALL.get());
        wallItem(ModBlocks.DURIN_MOSSY_STONE_WALL.get());
        wallItem(ModBlocks.DURIN_CRACKED_STONE_WALL.get());
        wallItem(ModBlocks.DURIN_COBBLESTONE_WALL.get());
        wallItem(ModBlocks.DURIN_MOSSY_COBBLESTONE_WALL.get());
        wallItem(ModBlocks.DURIN_BRICK_WALL.get());
        wallItem(ModBlocks.DURIN_BRICKWORK_WALL.get());
        wallItem(ModBlocks.DURIN_MOSSY_BRICK_WALL.get());
        wallItem(ModBlocks.DURIN_MOSSY_BRICKWORK_WALL.get());
        wallItem(ModBlocks.DURIN_CRACKED_BRICK_WALL.get());
        wallItem(ModBlocks.DURIN_CRACKED_BRICKWORK_WALL.get());
        wallItem(ModBlocks.DURIN_GOLD_BRICK_WALL.get());
        wallItem(ModBlocks.DURIN_SMOOTH_STONE_WALL.get());

        buttonItem(ModBlocks.DURIN_STONE_BUTTON.get());
        buttonItem(ModBlocks.DURIN_MOSSY_STONE_BUTTON.get());
        buttonItem(ModBlocks.DURIN_CRACKED_STONE_BUTTON.get());
        buttonItem(ModBlocks.DURIN_COBBLESTONE_BUTTON.get());
        buttonItem(ModBlocks.DURIN_MOSSY_COBBLESTONE_BUTTON.get());
        buttonItem(ModBlocks.DURIN_BRICK_BUTTON.get());

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

        basicItem(ModItems.APPLE.get());
        basicItem(ModItems.PEAR.get());
        basicItem(ModItems.PLUM.get());
        basicItem(ModItems.CHESTNUT.get());
        basicItem(ModItems.ALMOND.get());
        basicItem(ModItems.BANANA.get());
        basicItem(ModItems.LEMON.get());
        basicItem(ModItems.LIME.get());
        basicItem(ModItems.MANGO.get());
        basicItem(ModItems.OLIVE.get());
        basicItem(ModItems.ORANGE.get());
        basicItem(ModItems.POMERGRANATE.get());
        buttonItem(ModBlocks.APPLE_BUTTON, ModBlocks.APPLE_PLANKS);
        fenceItem(ModBlocks.APPLE_FENCE, ModBlocks.APPLE_PLANKS);
        simpleBlockItem(ModBlocks.APPLE_DOOR);
        saplingItem(ModBlocks.APPLE_SAPLING);
        basicItem(ModItems.APPLE_SIGN.get());
        basicItem(ModItems.APPLE_HANGING_SIGN.get());

        buttonItem(ModBlocks.PEAR_BUTTON, ModBlocks.PEAR_PLANKS);
        fenceItem(ModBlocks.PEAR_FENCE, ModBlocks.PEAR_PLANKS);
        simpleBlockItem(ModBlocks.PEAR_DOOR);
        saplingItem(ModBlocks.PEAR_SAPLING);
        basicItem(ModItems.PEAR_SIGN.get());
        basicItem(ModItems.PEAR_HANGING_SIGN.get());

        buttonItem(ModBlocks.PLUM_BUTTON, ModBlocks.PLUM_PLANKS);
        fenceItem(ModBlocks.PLUM_FENCE, ModBlocks.PLUM_PLANKS);
        simpleBlockItem(ModBlocks.PLUM_DOOR);
        saplingItem(ModBlocks.PLUM_SAPLING);
        basicItem(ModItems.PLUM_SIGN.get());
        basicItem(ModItems.PLUM_HANGING_SIGN.get());

        buttonItem(ModBlocks.MALLORN_BUTTON, ModBlocks.MALLORN_PLANKS);
        fenceItem(ModBlocks.MALLORN_FENCE, ModBlocks.MALLORN_PLANKS);
        simpleBlockItem(ModBlocks.MALLORN_DOOR);
        saplingItem(ModBlocks.MALLORN_SAPLING);
        basicItem(ModItems.MALLORN_SIGN.get());
        basicItem(ModItems.MALLORN_HANGING_SIGN.get());

        buttonItem(ModBlocks.CHARRED_BUTTON, ModBlocks.CHARRED_PLANKS);
        fenceItem(ModBlocks.CHARRED_FENCE, ModBlocks.CHARRED_PLANKS);
        simpleBlockItem(ModBlocks.CHARRED_DOOR);
        basicItem(ModItems.CHARRED_SIGN.get());
        basicItem(ModItems.CHARRED_HANGING_SIGN.get());

        buttonItem(ModBlocks.WILLOW_BUTTON, ModBlocks.WILLOW_PLANKS);
        fenceItem(ModBlocks.WILLOW_FENCE, ModBlocks.WILLOW_PLANKS);
        simpleBlockItem(ModBlocks.WILLOW_DOOR);
        saplingItem(ModBlocks.WILLOW_SAPLING);
        basicItem(ModItems.WILLOW_SIGN.get());
        basicItem(ModItems.WILLOW_HANGING_SIGN.get());

        buttonItem(ModBlocks.BEECH_BUTTON, ModBlocks.BEECH_PLANKS);
        fenceItem(ModBlocks.BEECH_FENCE, ModBlocks.BEECH_PLANKS);
        simpleBlockItem(ModBlocks.BEECH_DOOR);
        saplingItem(ModBlocks.BEECH_SAPLING);
        basicItem(ModItems.BEECH_SIGN.get());
        basicItem(ModItems.BEECH_HANGING_SIGN.get());

        buttonItem(ModBlocks.BAOBAB_BUTTON, ModBlocks.BAOBAB_PLANKS);
        fenceItem(ModBlocks.BAOBAB_FENCE, ModBlocks.BAOBAB_PLANKS);
        simpleBlockItem(ModBlocks.BAOBAB_DOOR);
        saplingItem(ModBlocks.BAOBAB_SAPLING);
        basicItem(ModItems.BAOBAB_SIGN.get());
        basicItem(ModItems.BAOBAB_HANGING_SIGN.get());

        buttonItem(ModBlocks.PINE_BUTTON, ModBlocks.PINE_PLANKS);
        fenceItem(ModBlocks.PINE_FENCE, ModBlocks.PINE_PLANKS);
        simpleBlockItem(ModBlocks.PINE_DOOR);
        saplingItem(ModBlocks.PINE_SAPLING);
        basicItem(ModItems.PINE_SIGN.get());
        basicItem(ModItems.PINE_HANGING_SIGN.get());

        buttonItem(ModBlocks.HOLLY_BUTTON, ModBlocks.HOLLY_PLANKS);
        fenceItem(ModBlocks.HOLLY_FENCE, ModBlocks.HOLLY_PLANKS);
        simpleBlockItem(ModBlocks.HOLLY_DOOR);
        saplingItem(ModBlocks.HOLLY_SAPLING);
        basicItem(ModItems.HOLLY_SIGN.get());
        basicItem(ModItems.HOLLY_HANGING_SIGN.get());

        buttonItem(ModBlocks.GREEN_OAK_BUTTON, ModBlocks.GREEN_OAK_PLANKS);
        fenceItem(ModBlocks.GREEN_OAK_FENCE, ModBlocks.GREEN_OAK_PLANKS);
        simpleBlockItem(ModBlocks.GREEN_OAK_DOOR);
        saplingItem(ModBlocks.GREEN_OAK_SAPLING);
        basicItem(ModItems.GREEN_OAK_SIGN.get());
        basicItem(ModItems.GREEN_OAK_HANGING_SIGN.get());

        buttonItem(ModBlocks.RED_OAK_BUTTON, ModBlocks.RED_OAK_PLANKS);
        fenceItem(ModBlocks.RED_OAK_FENCE, ModBlocks.RED_OAK_PLANKS);
        simpleBlockItem(ModBlocks.RED_OAK_DOOR);
        saplingItem(ModBlocks.RED_OAK_SAPLING);
        basicItem(ModItems.RED_OAK_SIGN.get());
        basicItem(ModItems.RED_OAK_HANGING_SIGN.get());

        buttonItem(ModBlocks.MIRK_OAK_BUTTON, ModBlocks.MIRK_OAK_PLANKS);
        fenceItem(ModBlocks.MIRK_OAK_FENCE, ModBlocks.MIRK_OAK_PLANKS);
        simpleBlockItem(ModBlocks.MIRK_OAK_DOOR);
        saplingItem(ModBlocks.MIRK_OAK_SAPLING);
        basicItem(ModItems.MIRK_OAK_SIGN.get());
        basicItem(ModItems.MIRK_OAK_HANGING_SIGN.get());

        buttonItem(ModBlocks.MAPLE_BUTTON, ModBlocks.MAPLE_PLANKS);
        fenceItem(ModBlocks.MAPLE_FENCE, ModBlocks.MAPLE_PLANKS);
        simpleBlockItem(ModBlocks.MAPLE_DOOR);
        saplingItem(ModBlocks.MAPLE_SAPLING);
        basicItem(ModItems.MAPLE_SIGN.get());
        basicItem(ModItems.MAPLE_HANGING_SIGN.get());

        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        simpleBlockItem(ModBlocks.PALM_DOOR);
        saplingItem(ModBlocks.PALM_SAPLING);
        basicItem(ModItems.PALM_SIGN.get());
        basicItem(ModItems.PALM_HANGING_SIGN.get());

        buttonItem(ModBlocks.CHESTNUT_BUTTON, ModBlocks.CHESTNUT_PLANKS);
        fenceItem(ModBlocks.CHESTNUT_FENCE, ModBlocks.CHESTNUT_PLANKS);
        simpleBlockItem(ModBlocks.CHESTNUT_DOOR);
        saplingItem(ModBlocks.CHESTNUT_SAPLING);
        basicItem(ModItems.CHESTNUT_SIGN.get());
        basicItem(ModItems.CHESTNUT_HANGING_SIGN.get());

        buttonItem(ModBlocks.ASPEN_BUTTON, ModBlocks.ASPEN_PLANKS);
        fenceItem(ModBlocks.ASPEN_FENCE, ModBlocks.ASPEN_PLANKS);
        simpleBlockItem(ModBlocks.ASPEN_DOOR);
        saplingItem(ModBlocks.ASPEN_SAPLING);
        basicItem(ModItems.ASPEN_SIGN.get());
        basicItem(ModItems.ASPEN_HANGING_SIGN.get());

        buttonItem(ModBlocks.CEDAR_BUTTON, ModBlocks.CEDAR_PLANKS);
        fenceItem(ModBlocks.CEDAR_FENCE, ModBlocks.CEDAR_PLANKS);
        simpleBlockItem(ModBlocks.CEDAR_DOOR);
        saplingItem(ModBlocks.CEDAR_SAPLING);
        basicItem(ModItems.CEDAR_SIGN.get());
        basicItem(ModItems.CEDAR_HANGING_SIGN.get());

        buttonItem(ModBlocks.FIR_BUTTON, ModBlocks.FIR_PLANKS);
        fenceItem(ModBlocks.FIR_FENCE, ModBlocks.FIR_PLANKS);
        simpleBlockItem(ModBlocks.FIR_DOOR);
        saplingItem(ModBlocks.FIR_SAPLING);
        basicItem(ModItems.FIR_SIGN.get());
        basicItem(ModItems.FIR_HANGING_SIGN.get());

        buttonItem(ModBlocks.LARCH_BUTTON, ModBlocks.LARCH_PLANKS);
        fenceItem(ModBlocks.LARCH_FENCE, ModBlocks.LARCH_PLANKS);
        simpleBlockItem(ModBlocks.LARCH_DOOR);
        saplingItem(ModBlocks.LARCH_SAPLING);
        basicItem(ModItems.LARCH_SIGN.get());
        basicItem(ModItems.LARCH_HANGING_SIGN.get());

        buttonItem(ModBlocks.LAIRELOSSE_BUTTON, ModBlocks.LAIRELOSSE_PLANKS);
        fenceItem(ModBlocks.LAIRELOSSE_FENCE, ModBlocks.LAIRELOSSE_PLANKS);
        simpleBlockItem(ModBlocks.LAIRELOSSE_DOOR);
        saplingItem(ModBlocks.LAIRELOSSE_SAPLING);
        basicItem(ModItems.LAIRELOSSE_SIGN.get());
        basicItem(ModItems.LAIRELOSSE_HANGING_SIGN.get());

        buttonItem(ModBlocks.ALMOND_BUTTON, ModBlocks.ALMOND_PLANKS);
        fenceItem(ModBlocks.ALMOND_FENCE, ModBlocks.ALMOND_PLANKS);
        simpleBlockItem(ModBlocks.ALMOND_DOOR);
        saplingItem(ModBlocks.ALMOND_SAPLING);
        basicItem(ModItems.ALMOND_SIGN.get());
        basicItem(ModItems.ALMOND_HANGING_SIGN.get());

        buttonItem(ModBlocks.BANANA_BUTTON, ModBlocks.BANANA_PLANKS);
        fenceItem(ModBlocks.BANANA_FENCE, ModBlocks.BANANA_PLANKS);
        simpleBlockItem(ModBlocks.BANANA_DOOR);
        saplingItem(ModBlocks.BANANA_SAPLING);
        basicItem(ModItems.BANANA_SIGN.get());
        basicItem(ModItems.BANANA_HANGING_SIGN.get());

        buttonItem(ModBlocks.CYPRESS_BUTTON, ModBlocks.CYPRESS_PLANKS);
        fenceItem(ModBlocks.CYPRESS_FENCE, ModBlocks.CYPRESS_PLANKS);
        simpleBlockItem(ModBlocks.CYPRESS_DOOR);
        saplingItem(ModBlocks.CYPRESS_SAPLING);
        basicItem(ModItems.CYPRESS_SIGN.get());
        basicItem(ModItems.CYPRESS_HANGING_SIGN.get());

        buttonItem(ModBlocks.DATE_PALM_BUTTON, ModBlocks.DATE_PALM_PLANKS);
        fenceItem(ModBlocks.DATE_PALM_FENCE, ModBlocks.DATE_PALM_PLANKS);
        simpleBlockItem(ModBlocks.DATE_PALM_DOOR);
        saplingItem(ModBlocks.DATE_PALM_SAPLING);
        basicItem(ModItems.DATE_PALM_SIGN.get());
        basicItem(ModItems.DATE_PALM_HANGING_SIGN.get());

        buttonItem(ModBlocks.KUNTZ_BUTTON, ModBlocks.KUNTZ_PLANKS);
        fenceItem(ModBlocks.KUNTZ_FENCE, ModBlocks.KUNTZ_PLANKS);
        simpleBlockItem(ModBlocks.KUNTZ_DOOR);
        saplingItem(ModBlocks.KUNTZ_SAPLING);
        basicItem(ModItems.KUNTZ_SIGN.get());
        basicItem(ModItems.KUNTZ_HANGING_SIGN.get());

        buttonItem(ModBlocks.LEBETHRON_BUTTON, ModBlocks.LEBETHRON_PLANKS);
        fenceItem(ModBlocks.LEBETHRON_FENCE, ModBlocks.LEBETHRON_PLANKS);
        simpleBlockItem(ModBlocks.LEBETHRON_DOOR);
        saplingItem(ModBlocks.LEBETHRON_SAPLING);
        basicItem(ModItems.LEBETHRON_SIGN.get());
        basicItem(ModItems.LEBETHRON_HANGING_SIGN.get());

        buttonItem(ModBlocks.LEMON_BUTTON, ModBlocks.LEMON_PLANKS);
        fenceItem(ModBlocks.LEMON_FENCE, ModBlocks.LEMON_PLANKS);
        simpleBlockItem(ModBlocks.LEMON_DOOR);
        saplingItem(ModBlocks.LEMON_SAPLING);
        basicItem(ModItems.LEMON_SIGN.get());
        basicItem(ModItems.LEMON_HANGING_SIGN.get());

        buttonItem(ModBlocks.LIME_BUTTON, ModBlocks.LIME_PLANKS);
        fenceItem(ModBlocks.LIME_FENCE, ModBlocks.LIME_PLANKS);
        simpleBlockItem(ModBlocks.LIME_DOOR);
        saplingItem(ModBlocks.LIME_SAPLING);
        basicItem(ModItems.LIME_SIGN.get());
        basicItem(ModItems.LIME_HANGING_SIGN.get());

        buttonItem(ModBlocks.MANGO_BUTTON, ModBlocks.MANGO_PLANKS);
        fenceItem(ModBlocks.MANGO_FENCE, ModBlocks.MANGO_PLANKS);
        simpleBlockItem(ModBlocks.MANGO_DOOR);
        saplingItem(ModBlocks.MANGO_SAPLING);
        basicItem(ModItems.MANGO_SIGN.get());
        basicItem(ModItems.MANGO_HANGING_SIGN.get());

        buttonItem(ModBlocks.ORANGE_BUTTON, ModBlocks.ORANGE_PLANKS);
        fenceItem(ModBlocks.ORANGE_FENCE, ModBlocks.ORANGE_PLANKS);
        simpleBlockItem(ModBlocks.ORANGE_DOOR);
        saplingItem(ModBlocks.ORANGE_SAPLING);
        basicItem(ModItems.ORANGE_SIGN.get());
        basicItem(ModItems.ORANGE_HANGING_SIGN.get());

        buttonItem(ModBlocks.POMERGRANATE_BUTTON, ModBlocks.POMERGRANATE_PLANKS);
        fenceItem(ModBlocks.POMERGRANATE_FENCE, ModBlocks.POMERGRANATE_PLANKS);
        simpleBlockItem(ModBlocks.POMERGRANATE_DOOR);
        saplingItem(ModBlocks.POMERGRANATE_SAPLING);
        basicItem(ModItems.POMERGRANATE_SIGN.get());
        basicItem(ModItems.POMERGRANATE_HANGING_SIGN.get());

        buttonItem(ModBlocks.REDWOOD_BUTTON, ModBlocks.REDWOOD_PLANKS);
        fenceItem(ModBlocks.REDWOOD_FENCE, ModBlocks.REDWOOD_PLANKS);
        simpleBlockItem(ModBlocks.REDWOOD_DOOR);
        saplingItem(ModBlocks.REDWOOD_SAPLING);
        basicItem(ModItems.REDWOOD_SIGN.get());
        basicItem(ModItems.REDWOOD_HANGING_SIGN.get());

        buttonItem(ModBlocks.RED_MAHOGANY_BUTTON, ModBlocks.RED_MAHOGANY_PLANKS);
        fenceItem(ModBlocks.RED_MAHOGANY_FENCE, ModBlocks.RED_MAHOGANY_PLANKS);
        simpleBlockItem(ModBlocks.RED_MAHOGANY_DOOR);
        saplingItem(ModBlocks.RED_MAHOGANY_SAPLING);
        basicItem(ModItems.RED_MAHOGANY_SIGN.get());
        basicItem(ModItems.RED_MAHOGANY_HANGING_SIGN.get());

        buttonItem(ModBlocks.OLIVE_BUTTON, ModBlocks.OLIVE_PLANKS);
        fenceItem(ModBlocks.OLIVE_FENCE, ModBlocks.OLIVE_PLANKS);
            simpleBlockItem(ModBlocks.OLIVE_DOOR);
        saplingItem(ModBlocks.OLIVE_SAPLING);
        basicItem(ModItems.OLIVE_SIGN.get());
        basicItem(ModItems.OLIVE_HANGING_SIGN.get());
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder weapon2d(DeferredItem item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"item/" + item.getId().getPath()));
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
    private ItemModelBuilder simpleBlockItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    private ResourceLocation change(Block block, String replaced, String replace) {
        return ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"block/" +  key(block).getPath().replaceAll(replaced, replace));
    }
}