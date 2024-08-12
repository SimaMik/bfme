package net.sima.bfme.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.block.custom.ColumnBlock;
import net.sima.bfme.block.custom.ColumnPart;
import net.sima.bfme.block.custom.VerticalSlabBlock;
import net.sima.bfme.block.custom.VerticalSlabType;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BFME.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
                                    //Гондорские камни
        workbench(ModBlocks.GONDORIAN_WORKBENCH.get());

        blockWithItem(ModBlocks.GONDORIAN_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_STONE.get());
        blockWithItem(ModBlocks.GONDORIAN_COBBLESTONE.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE.get());
        blockWithItem(ModBlocks.GONDORIAN_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_CRACKED_BRICKWORK.get());
        blockWithItem(ModBlocks.GONDORIAN_CHISELED_BRICK.get());
        blockWithItem(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK.get());

        slab(ModBlocks.GONDORIAN_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_STONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_COBBLESTONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_SLAB.get());
        slab(ModBlocks.GONDORIAN_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_SLAB.get());
        slab(ModBlocks.GONDORIAN_BRICKWORK_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_BRICK_SLAB.get());
        slab(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_SLAB.get());

        verticalSlab(ModBlocks.GONDORIAN_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_STONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_BRICKWORK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_BRICK_VERTICAL_SLAB.get());
        verticalSlab(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());

        stairs(ModBlocks.GONDORIAN_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_STONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_BRICK_STAIRS.get());
        stairs(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_STAIRS.get());

        pillar(ModBlocks.GONDORIAN_PILLAR.get());
        pillar(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
        pillar(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
        column(ModBlocks.GONDORIAN_COLUMN.get());
        column(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
        column(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
        pillarSlab(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
        pillarSlab(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());

        wall(ModBlocks.GONDORIAN_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get());
        wall(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get());
        wall(ModBlocks.GONDORIAN_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_BRICKWORK_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get());
        wall(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());

        button(ModBlocks.GONDORIAN_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_MOSSY_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_CRACKED_STONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_COBBLESTONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_BUTTON.get());
        button(ModBlocks.GONDORIAN_BRICK_BUTTON.get());

        pressurePlate(ModBlocks.GONDORIAN_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_STONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_CHISELED_BRICK_PRESSURE_PLATE.get());
        pressurePlate(ModBlocks.GONDORIAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());



        blockWithItem(ModBlocks.DURIN_SMOOTH_STONE.get());
        blockWithItem(ModBlocks.DURIN_STONE.get());
        blockWithItem(ModBlocks.DURIN_COBBLESTONE.get());
        blockWithItem(ModBlocks.DURIN_BRICK.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_BRICK.get());
        blockWithItem(ModBlocks.DURIN_CRACKED_BRICK.get());
        blockWithItem(ModBlocks.DURIN_BRICKWORK.get());
        blockWithItem(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
        pillar(ModBlocks.DURIN_PILLAR.get());
        pillar(ModBlocks.DURIN_CRACKED_PILLAR.get());
        pillar(ModBlocks.DURIN_MOSSY_PILLAR.get());
        pillar(ModBlocks.DURIN_CARVED_STONE.get());
        column(ModBlocks.DURIN_COLUMN.get());
        column(ModBlocks.DURIN_CRACKED_COLUMN.get());
        column(ModBlocks.DURIN_MOSSY_COLUMN.get());
        blockWithItem(ModBlocks.DURIN_GOLD_BRICK.get());


        /* ORES */
        oreBlockWithItem(ModBlocks.AMBER_ORE.get());
        blockWithItem(ModBlocks.AMBER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE.get());
        oreBlockWithItem(ModBlocks.AMETHYST_ORE.get());
        blockWithItem(ModBlocks.AMETHYST_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_AMETHYST_ORE.get());
        oreBlockWithItem(ModBlocks.DIAMOND_ORE.get());
        blockWithItem(ModBlocks.DIAMOND_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_DIAMOND_ORE.get());
        oreBlockWithItem(ModBlocks.EMERALD_ORE.get());
        blockWithItem(ModBlocks.EMERALD_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_EMERALD_ORE.get());
        oreBlockWithItem(ModBlocks.OPAL_ORE.get());
        blockWithItem(ModBlocks.OPAL_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_OPAL_ORE.get());
        oreBlockWithItem(ModBlocks.RUBY_ORE.get());
        blockWithItem(ModBlocks.RUBY_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE.get());
        oreBlockWithItem(ModBlocks.SAPPHIRE_ORE.get());
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        oreBlockWithItem(ModBlocks.TOPAZ_ORE.get());
        blockWithItem(ModBlocks.TOPAZ_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        oreBlockWithItem(ModBlocks.MITHRIL_ORE.get());
        blockWithItem(ModBlocks.MITHRIL_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
        oreBlockWithItem(ModBlocks.SILVER_ORE.get());
        blockWithItem(ModBlocks.SILVER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        oreBlockWithItem(ModBlocks.SALT_ORE.get());
        blockWithItem(ModBlocks.SALT_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SALT_ORE.get());
        oreBlockWithItem(ModBlocks.SALTPETER_ORE.get());
        blockWithItem(ModBlocks.SALTPETER_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SALTPETER_ORE.get());
        oreBlockWithItem(ModBlocks.SULFUR_ORE.get());
        blockWithItem(ModBlocks.SULFUR_BLOCK.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
        blockWithItem(ModBlocks.BRONZE_BLOCK.get());
        oreBlockWithItem(ModBlocks.GLOWSTONE_ORE.get());
        oreBlockWithItem(ModBlocks.DEEPSLATE_GLOWSTONE_ORE.get());
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void oreBlockWithItem(Block block) {
        ModelFile model0 = models().cubeAll(name(block), blockTexture(block));
        ModelFile model1 = models().cubeAll(name(block) + "0", extend(blockTexture(block), "0"));
        ModelFile model2 = models().cubeAll(name(block) + "1", extend(blockTexture(block), "1"));
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(model0).nextModel()
                .modelFile(model1).nextModel()
                .modelFile(model2).build());
        blockItem(block);
    }
    public void wall(Block block) {
        wallBlock((WallBlock) block, models().wallPost(name(block) + "_post", change(block, "_wall", "")),
                models().wallSide(name(block) + "_side", change(block, "_wall", "")),
                models().wallSideTall(name(block) + "_side_tall", change(block, "_wall", "")));
    }
    private void slab(Block block){
        slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""));
        blockItem(block);
    }
    public void button(Block block) {
        ModelFile button = models().button(name(block), change(block, "_button", ""));
        ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", change(block, "_button", ""));
        buttonBlock((ButtonBlock) block, button, buttonPressed);
    }
    public void pressurePlate(Block block) {
        ModelFile pressurePlate = models().pressurePlate(name(block), change(block, "_pressure_plate", ""));
        ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", change(block, "_pressure_plate", ""));
        pressurePlateBlock(((PressurePlateBlock) block), pressurePlate, pressurePlateDown);
        blockItem(block);
    }

    public void pillar(Block block) {
        axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
        blockItem(block);
    }
    private void pillarSlab(Block block){
        slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
        blockItem(block);
    }
    public void stairs(Block block) {
        stairsBlock((StairBlock) block, change(block, "_stairs", ""));
        blockItem(block);
    }
    public void workbench(Block block){
            ResourceLocation side = extend(blockTexture(block), "_side");
            ResourceLocation top = extend(blockTexture(block), "_top");

            BlockModelBuilder model = models().cube(name(block), change(block, "workbench", "stone"), top, side, side, side, side);
        simpleBlockWithItem(block, model);
        }

    private void verticalSlab(Block block) {

        createVerticalSlabModels(block);

        // Register block state and model
        getVariantBuilder(block).forAllStates(state -> {
            VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
            ResourceLocation modelLocation = getModelLocation(type, block);
            return ConfiguredModel.builder()
                    .modelFile(models().getExistingFile(modelLocation))
                    .build();
        });
        verticalBlockItem(block);
    }

    private ResourceLocation getModelLocation(VerticalSlabType type, Block block) {
        switch (type) {
            case SOUTH:
                return extend(blockTexture(block), "_south");
            case WEST:
                return extend(blockTexture(block), "_west");
            case EAST:
                return extend(blockTexture(block), "_east");
            case DOUBLE:
                return change(block, "_vertical_slab", "");
            case NORTH:
            default:
                return extend(blockTexture(block), "_north");
        }
    }

    private void createVerticalSlabModels(Block block) {
        ResourceLocation texture = change(block, "_vertical_slab", "");
        createVerticalSlabModel(name(block) + "_north", texture, Direction.NORTH, 0, 0, 0, 16, 16, 8);
        createVerticalSlabModel(name(block) + "_south", texture, Direction.SOUTH, 0, 0, 8, 16, 16, 16);
        createVerticalSlabModel(name(block) + "_west", texture, Direction.WEST, 0, 0, 0, 8, 16, 16);
        createVerticalSlabModel(name(block) + "_east", texture, Direction.EAST, 8, 0, 0, 16, 16, 16);
        createDoubleVerticalSlabModel(name(block) + "_double", texture);
    }

    private void createVerticalSlabModel(String name, ResourceLocation texture, Direction direction, int x, int y, int z, int x1, int y1, int z1) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("all", texture).texture("particle", texture);
        builder.element().from(x, y, z).to(x1, y1, z1).textureAll("#all").end();
    }

    private void createDoubleVerticalSlabModel(String name, ResourceLocation texture) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("all", texture);
        builder.element().from(0, 0, 0).to(16, 16, 16).textureAll("#all").end();
    }
    private void column(Block block) {
        createColumnModels(block);
        getVariantBuilder(block)
                .partialState().with(ColumnBlock.PART, ColumnPart.SINGLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_single"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.BOTTOM)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_bottom"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.MIDDLE)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_middle"))).addModel()
                .partialState().with(ColumnBlock.PART, ColumnPart.TOP)
                .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_top"))).addModel();
        ColumnBlockItem(block);
    }
    private void createColumnModels(Block block) {
        createSingleColumnModel(block, name(block) + "_single");
        createBottomColumnModel(block, name(block) + "_bottom");
        createMiddleColumnModel(block, name(block) + "_middle");
        createTopColumnModel(block, name(block) + "_top");
    }

    private void createSingleColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                .element().from(3, 3, 3).to(13, 13, 13).textureAll("#3").end()
                .element().from(1, 13, 1).to(14, 14, 14).textureAll("#2").end()
                .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();
    }
    private void createBottomColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                .element().from(3, 3, 3).to(13, 16, 13).textureAll("#3").end();
    }
    private void createMiddleColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder.element().from(3, 0, 3).to(13, 16, 13).textureAll("#3").end();
    }

    private void createTopColumnModel(Block block, String name) {
        BlockModelBuilder builder = models().withExistingParent(name, "block/block");
        builder.texture("1", change(block, "column", "stone"));
        builder.texture("2", change(block, "column", "cobblestone"));
        builder.texture("3", change(block, "column", "pillar"))
                .texture("particle", change(block, "column", "pillar"));
        builder
                .element().from(3, 0, 3).to(13, 13, 13).textureAll("#3").end()
                .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
                .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();
    }
    private void verticalBlockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + "_south"));
    }
    private void ColumnBlockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + "_single"));
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

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = this.key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath());
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
    }
    private void blockItem(Block block, String appendix) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + appendix));
    }

    private void blockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block)));
    }

}
