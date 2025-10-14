    package net.sima.bfme.datagen;
    
    import net.minecraft.core.Direction;
    import net.minecraft.core.registries.BuiltInRegistries;
    import net.minecraft.data.PackOutput;
    import net.minecraft.resources.ResourceLocation;
    import net.minecraft.world.level.block.*;
    import net.minecraft.world.level.block.state.BlockState;
    import net.minecraft.world.level.block.state.properties.BlockStateProperties;
    import net.neoforged.neoforge.client.model.generators.*;
    import net.neoforged.neoforge.common.data.ExistingFileHelper;
    import net.sima.bfme.BFME;
    import net.sima.bfme.block.ModBlocks;
    import net.sima.bfme.block.custom.*;
    
    import java.util.function.Function;

    import static net.sima.bfme.BFME.resource;

    public class ModBlockStateProvider extends BlockStateProvider {
        public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, BFME.MOD_ID, exFileHelper);
        }
        @Override
        protected void registerStatesAndModels() {
                                        //Гондорские камни
            workbench(ModBlocks.GONDORIAN_CRAFTING_TABLE.get());
            gate(ModBlocks.HUMAN_FURNACE.get());
            privateBlock(ModBlocks.PRIVATE_BLOCK.get());

            blockWithItem(ModBlocks.GONDORIAN_STONE.get());
            blockWithItem(ModBlocks.GONDORIAN_SMOOTH_STONE.get());
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
            smoothSlab(ModBlocks.GONDORIAN_SMOOTH_STONE_SLAB.get());
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
            verticalSlab(ModBlocks.GONDORIAN_SMOOTH_STONE_VERTICAL_SLAB.get());
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
            stairs(ModBlocks.GONDORIAN_SMOOTH_STONE_STAIRS.get());
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
    
            pillarExtend(ModBlocks.GONDORIAN_PILLAR.get());
            pillar(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
            verticalHorizontalSlab(ModBlocks.GONDORIAN_MOSSY_PILLAR_VERTICAL_SLAB.get());
            pillar(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
            column(ModBlocks.GONDORIAN_COLUMN.get());
            column(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
            column(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
            pillarExtendSlab(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());
    
            wall(ModBlocks.GONDORIAN_STONE_WALL.get());
            wall(ModBlocks.GONDORIAN_SMOOTH_STONE_WALL.get());
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
            pressurePlate(ModBlocks.GONDORIAN_SMOOTH_STONE_PRESSURE_PLATE.get());
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
    
            blockWithItem(ModBlocks.DURIN_STONE.get());
            blockWithItem(ModBlocks.DURIN_MOSSY_STONE.get());
            blockWithItem(ModBlocks.DURIN_CRACKED_STONE.get());
            blockWithItem(ModBlocks.DURIN_COBBLESTONE.get());
            blockWithItem(ModBlocks.DURIN_MOSSY_COBBLESTONE.get());
            blockWithItem(ModBlocks.DURIN_BRICK.get());
            blockWithItem(ModBlocks.DURIN_BRICKWORK.get());
            blockWithItem(ModBlocks.DURIN_MOSSY_BRICK.get());
            blockWithItem(ModBlocks.DURIN_MOSSY_BRICKWORK.get());
            blockWithItem(ModBlocks.DURIN_CRACKED_BRICK.get());
            blockWithItem(ModBlocks.DURIN_CRACKED_BRICKWORK.get());
            blockWithItem(ModBlocks.DURIN_MOSSY_CHISELED_BRICK.get());
            blockWithItem(ModBlocks.DURIN_SMOOTH_STONE.get());
            blockWithItem(ModBlocks.DURIN_GOLD_BRICK.get());
    
            slab(ModBlocks.DURIN_STONE_SLAB.get());
            slab(ModBlocks.DURIN_MOSSY_STONE_SLAB.get());
            slab(ModBlocks.DURIN_CRACKED_STONE_SLAB.get());
            slab(ModBlocks.DURIN_COBBLESTONE_SLAB.get());
            slab(ModBlocks.DURIN_MOSSY_COBBLESTONE_SLAB.get());
            slab(ModBlocks.DURIN_BRICK_SLAB.get());
            slab(ModBlocks.DURIN_CRACKED_BRICK_SLAB.get());
            slab(ModBlocks.DURIN_CRACKED_BRICKWORK_SLAB.get());
            slab(ModBlocks.DURIN_BRICKWORK_SLAB.get());
            slab(ModBlocks.DURIN_MOSSY_BRICK_SLAB.get());
            slab(ModBlocks.DURIN_MOSSY_BRICKWORK_SLAB.get());
            slab(ModBlocks.DURIN_SMOOTH_STONE_SLAB.get());
            slab(ModBlocks.DURIN_GOLD_BRICK_SLAB.get());
    
            verticalSlab(ModBlocks.DURIN_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_MOSSY_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_CRACKED_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_CRACKED_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_MOSSY_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_SMOOTH_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.DURIN_GOLD_BRICK_VERTICAL_SLAB.get());
    
            stairs(ModBlocks.DURIN_STONE_STAIRS.get());
            stairs(ModBlocks.DURIN_MOSSY_STONE_STAIRS.get());
            stairs(ModBlocks.DURIN_CRACKED_STONE_STAIRS.get());
            stairs(ModBlocks.DURIN_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.DURIN_MOSSY_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.DURIN_BRICK_STAIRS.get());
            stairs(ModBlocks.DURIN_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.DURIN_MOSSY_BRICK_STAIRS.get());
            stairs(ModBlocks.DURIN_MOSSY_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.DURIN_CRACKED_BRICK_STAIRS.get());
            stairs(ModBlocks.DURIN_CRACKED_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.DURIN_SMOOTH_STONE_STAIRS.get());
            stairs(ModBlocks.DURIN_GOLD_BRICK_STAIRS.get());
    
            pillar(ModBlocks.DURIN_PILLAR.get());
            pillar(ModBlocks.DURIN_MOSSY_PILLAR.get());
            pillar(ModBlocks.DURIN_CRACKED_PILLAR.get());
            pillar(ModBlocks.DURIN_CHISELED_BRICK.get());
            column(ModBlocks.DURIN_COLUMN.get());
            column(ModBlocks.DURIN_MOSSY_COLUMN.get());
            column(ModBlocks.DURIN_CRACKED_COLUMN.get());
            pillarSlab(ModBlocks.DURIN_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get());
    
            wall(ModBlocks.DURIN_STONE_WALL.get());
            wall(ModBlocks.DURIN_MOSSY_STONE_WALL.get());
            wall(ModBlocks.DURIN_CRACKED_STONE_WALL.get());
            wall(ModBlocks.DURIN_COBBLESTONE_WALL.get());
            wall(ModBlocks.DURIN_MOSSY_COBBLESTONE_WALL.get());
            wall(ModBlocks.DURIN_BRICK_WALL.get());
            wall(ModBlocks.DURIN_BRICKWORK_WALL.get());
            wall(ModBlocks.DURIN_MOSSY_BRICK_WALL.get());
            wall(ModBlocks.DURIN_MOSSY_BRICKWORK_WALL.get());
            wall(ModBlocks.DURIN_CRACKED_BRICK_WALL.get());
            wall(ModBlocks.DURIN_CRACKED_BRICKWORK_WALL.get());
            wall(ModBlocks.DURIN_GOLD_BRICK_WALL.get());
            wall(ModBlocks.DURIN_SMOOTH_STONE_WALL.get());
    
            button(ModBlocks.DURIN_STONE_BUTTON.get());
            button(ModBlocks.DURIN_MOSSY_STONE_BUTTON.get());
            button(ModBlocks.DURIN_CRACKED_STONE_BUTTON.get());
            button(ModBlocks.DURIN_COBBLESTONE_BUTTON.get());
            button(ModBlocks.DURIN_MOSSY_COBBLESTONE_BUTTON.get());
            button(ModBlocks.DURIN_BRICK_BUTTON.get());
    
            pressurePlate(ModBlocks.DURIN_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_MOSSY_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_CRACKED_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_MOSSY_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_CRACKED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_CHISELED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_GOLD_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.DURIN_SMOOTH_STONE_PRESSURE_PLATE.get());
    
            blockWithItem(ModBlocks.ROHAN_STONE.get());
            blockWithItem(ModBlocks.ROHAN_SMOOTH_STONE.get());
            blockWithItem(ModBlocks.ROHAN_MOSSY_STONE.get());
            blockWithItem(ModBlocks.ROHAN_CRACKED_STONE.get());
            blockWithItem(ModBlocks.ROHAN_COBBLESTONE.get());
            blockWithItem(ModBlocks.ROHAN_MOSSY_COBBLESTONE.get());
            blockWithItem(ModBlocks.ROHAN_BRICK.get());
            blockWithItem(ModBlocks.ROHAN_BRICKWORK.get());
            blockWithItem(ModBlocks.ROHAN_MOSSY_BRICK.get());
            blockWithItem(ModBlocks.ROHAN_MOSSY_BRICKWORK.get());
            blockWithItem(ModBlocks.ROHAN_CRACKED_BRICK.get());
            blockWithItem(ModBlocks.ROHAN_CRACKED_BRICKWORK.get());
            blockWithItem(ModBlocks.ROHAN_CHISELED_BRICK.get());
            blockWithItem(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK.get());
    
            slab(ModBlocks.ROHAN_STONE_SLAB.get());
            slab(ModBlocks.ROHAN_SMOOTH_STONE_SLAB.get());
            slab(ModBlocks.ROHAN_MOSSY_STONE_SLAB.get());
            slab(ModBlocks.ROHAN_CRACKED_STONE_SLAB.get());
            slab(ModBlocks.ROHAN_COBBLESTONE_SLAB.get());
            slab(ModBlocks.ROHAN_MOSSY_COBBLESTONE_SLAB.get());
            slab(ModBlocks.ROHAN_BRICK_SLAB.get());
            slab(ModBlocks.ROHAN_CRACKED_BRICK_SLAB.get());
            slab(ModBlocks.ROHAN_CRACKED_BRICKWORK_SLAB.get());
            slab(ModBlocks.ROHAN_BRICKWORK_SLAB.get());
            slab(ModBlocks.ROHAN_MOSSY_BRICK_SLAB.get());
            slab(ModBlocks.ROHAN_MOSSY_BRICKWORK_SLAB.get());
    
            verticalSlab(ModBlocks.ROHAN_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_SMOOTH_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_MOSSY_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_CRACKED_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_CRACKED_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_MOSSY_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.ROHAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
    
            stairs(ModBlocks.ROHAN_STONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_SMOOTH_STONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_MOSSY_STONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_CRACKED_STONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_MOSSY_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.ROHAN_BRICK_STAIRS.get());
            stairs(ModBlocks.ROHAN_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.ROHAN_MOSSY_BRICK_STAIRS.get());
            stairs(ModBlocks.ROHAN_MOSSY_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.ROHAN_CRACKED_BRICK_STAIRS.get());
            stairs(ModBlocks.ROHAN_CRACKED_BRICKWORK_STAIRS.get());
    
            pillarExtend(ModBlocks.ROHAN_PILLAR.get());
            pillar(ModBlocks.ROHAN_MOSSY_PILLAR.get());
            pillar(ModBlocks.ROHAN_CRACKED_PILLAR.get());
            column(ModBlocks.ROHAN_COLUMN.get());
            column(ModBlocks.ROHAN_MOSSY_COLUMN.get());
            column(ModBlocks.ROHAN_CRACKED_COLUMN.get());
            pillarExtendSlab(ModBlocks.ROHAN_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get());
    
            wall(ModBlocks.ROHAN_STONE_WALL.get());
            wall(ModBlocks.ROHAN_SMOOTH_STONE_WALL.get());
            wall(ModBlocks.ROHAN_MOSSY_STONE_WALL.get());
            wall(ModBlocks.ROHAN_CRACKED_STONE_WALL.get());
            wall(ModBlocks.ROHAN_COBBLESTONE_WALL.get());
            wall(ModBlocks.ROHAN_MOSSY_COBBLESTONE_WALL.get());
            wall(ModBlocks.ROHAN_BRICK_WALL.get());
            wall(ModBlocks.ROHAN_BRICKWORK_WALL.get());
            wall(ModBlocks.ROHAN_MOSSY_BRICK_WALL.get());
            wall(ModBlocks.ROHAN_MOSSY_BRICKWORK_WALL.get());
            wall(ModBlocks.ROHAN_CRACKED_BRICK_WALL.get());
            wall(ModBlocks.ROHAN_CRACKED_BRICKWORK_WALL.get());
    
            button(ModBlocks.ROHAN_STONE_BUTTON.get());
            button(ModBlocks.ROHAN_MOSSY_STONE_BUTTON.get());
            button(ModBlocks.ROHAN_CRACKED_STONE_BUTTON.get());
            button(ModBlocks.ROHAN_COBBLESTONE_BUTTON.get());
            button(ModBlocks.ROHAN_MOSSY_COBBLESTONE_BUTTON.get());
            button(ModBlocks.ROHAN_BRICK_BUTTON.get());
    
            pressurePlate(ModBlocks.ROHAN_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_SMOOTH_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_MOSSY_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_CRACKED_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_MOSSY_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_CRACKED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_CHISELED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.ROHAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());
    
            blockWithItem(ModBlocks.NUMENOREAN_STONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_SMOOTH_STONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_MOSSY_STONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_CRACKED_STONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_COBBLESTONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE.get());
            blockWithItem(ModBlocks.NUMENOREAN_BRICK.get());
            blockWithItem(ModBlocks.NUMENOREAN_BRICKWORK.get());
            blockWithItem(ModBlocks.NUMENOREAN_MOSSY_BRICK.get());
            blockWithItem(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK.get());
            blockWithItem(ModBlocks.NUMENOREAN_CRACKED_BRICK.get());
            blockWithItem(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK.get());
            blockWithItem(ModBlocks.NUMENOREAN_CHISELED_BRICK.get());
            blockWithItem(ModBlocks.NUMENOREAN_MOSSY_CHISELED_BRICK.get());
    
            slab(ModBlocks.NUMENOREAN_STONE_SLAB.get());
            smoothSlab(ModBlocks.NUMENOREAN_SMOOTH_STONE_SLAB.get());
            slab(ModBlocks.NUMENOREAN_MOSSY_STONE_SLAB.get());
            slab(ModBlocks.NUMENOREAN_CRACKED_STONE_SLAB.get());
            slab(ModBlocks.NUMENOREAN_COBBLESTONE_SLAB.get());
            slab(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_SLAB.get());
            slab(ModBlocks.NUMENOREAN_BRICK_SLAB.get());
            slab(ModBlocks.NUMENOREAN_CRACKED_BRICK_SLAB.get());
            slab(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_SLAB.get());
            slab(ModBlocks.NUMENOREAN_BRICKWORK_SLAB.get());
            slab(ModBlocks.NUMENOREAN_MOSSY_BRICK_SLAB.get());
            slab(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_SLAB.get());
    
            verticalSlab(ModBlocks.NUMENOREAN_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_SMOOTH_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_MOSSY_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_CRACKED_STONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_CRACKED_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_BRICKWORK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_MOSSY_BRICK_VERTICAL_SLAB.get());
            verticalSlab(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_VERTICAL_SLAB.get());
    
            stairs(ModBlocks.NUMENOREAN_STONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_SMOOTH_STONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_MOSSY_STONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_CRACKED_STONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_BRICK_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_MOSSY_BRICK_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_CRACKED_BRICK_STAIRS.get());
            stairs(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_STAIRS.get());
    
            pillar(ModBlocks.NUMENOREAN_PILLAR.get());
            pillar(ModBlocks.NUMENOREAN_MOSSY_PILLAR.get());
            pillar(ModBlocks.NUMENOREAN_CRACKED_PILLAR.get());
            column(ModBlocks.NUMENOREAN_COLUMN.get());
            column(ModBlocks.NUMENOREAN_MOSSY_COLUMN.get());
            column(ModBlocks.NUMENOREAN_CRACKED_COLUMN.get());
            pillarSlab(ModBlocks.NUMENOREAN_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.NUMENOREAN_MOSSY_PILLAR_SLAB.get());
            pillarSlab(ModBlocks.NUMENOREAN_CRACKED_PILLAR_SLAB.get());
    
            wall(ModBlocks.NUMENOREAN_STONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_SMOOTH_STONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_MOSSY_STONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_CRACKED_STONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_COBBLESTONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_WALL.get());
            wall(ModBlocks.NUMENOREAN_BRICK_WALL.get());
            wall(ModBlocks.NUMENOREAN_BRICKWORK_WALL.get());
            wall(ModBlocks.NUMENOREAN_MOSSY_BRICK_WALL.get());
            wall(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_WALL.get());
            wall(ModBlocks.NUMENOREAN_CRACKED_BRICK_WALL.get());
            wall(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_WALL.get());
    
            button(ModBlocks.NUMENOREAN_STONE_BUTTON.get());
            button(ModBlocks.NUMENOREAN_MOSSY_STONE_BUTTON.get());
            button(ModBlocks.NUMENOREAN_CRACKED_STONE_BUTTON.get());
            button(ModBlocks.NUMENOREAN_COBBLESTONE_BUTTON.get());
            button(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_BUTTON.get());
            button(ModBlocks.NUMENOREAN_BRICK_BUTTON.get());
    
            pressurePlate(ModBlocks.NUMENOREAN_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_SMOOTH_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_MOSSY_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_CRACKED_STONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_MOSSY_COBBLESTONE_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_MOSSY_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_MOSSY_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_CRACKED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_CRACKED_BRICKWORK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_CHISELED_BRICK_PRESSURE_PLATE.get());
            pressurePlate(ModBlocks.NUMENOREAN_MOSSY_CHISELED_BRICK_PRESSURE_PLATE.get());
    
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK.get());
            slab(ModBlocks.TERRACOTTA_BRICK_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_BLACK.get());
            slab(ModBlocks.TERRACOTTA_BRICK_BLACK_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_BLACK_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_BLACK_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_BLACK_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_BLUE.get());
            slab(ModBlocks.TERRACOTTA_BRICK_BLUE_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_BLUE_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_BLUE_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_BLUE_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_BROWN.get());
            slab(ModBlocks.TERRACOTTA_BRICK_BROWN_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_BROWN_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_BROWN_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_BROWN_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_CYAN.get());
            slab(ModBlocks.TERRACOTTA_BRICK_CYAN_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_CYAN_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_CYAN_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_CYAN_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_GRAY.get());
            slab(ModBlocks.TERRACOTTA_BRICK_GRAY_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_GRAY_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_GRAY_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_GRAY_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_GREEN.get());
            slab(ModBlocks.TERRACOTTA_BRICK_GREEN_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_GREEN_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_GREEN_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_GREEN_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE.get());
            slab(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_LIGHT_BLUE_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY.get());
            slab(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_LIGHT_GRAY_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_LIME.get());
            slab(ModBlocks.TERRACOTTA_BRICK_LIME_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_LIME_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_LIME_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_LIME_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_MAGENTA.get());
            slab(ModBlocks.TERRACOTTA_BRICK_MAGENTA_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_MAGENTA_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_MAGENTA_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_MAGENTA_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_ORANGE.get());
            slab(ModBlocks.TERRACOTTA_BRICK_ORANGE_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_ORANGE_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_ORANGE_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_ORANGE_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_PINK.get());
            slab(ModBlocks.TERRACOTTA_BRICK_PINK_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_PINK_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_PINK_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_PINK_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_PURPLE.get());
            slab(ModBlocks.TERRACOTTA_BRICK_PURPLE_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_PURPLE_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_PURPLE_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_PURPLE_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_RED.get());
            slab(ModBlocks.TERRACOTTA_BRICK_RED_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_RED_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_RED_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_RED_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_WHITE.get());
            slab(ModBlocks.TERRACOTTA_BRICK_WHITE_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_WHITE_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_WHITE_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_WHITE_WALL.get());
    
            blockWithItem(ModBlocks.TERRACOTTA_BRICK_YELLOW.get());
            slab(ModBlocks.TERRACOTTA_BRICK_YELLOW_SLAB.get());
            verticalSlab(ModBlocks.TERRACOTTA_BRICK_YELLOW_VERTICAL_SLAB.get());
            stairs(ModBlocks.TERRACOTTA_BRICK_YELLOW_STAIRS.get());
            wall(ModBlocks.TERRACOTTA_BRICK_YELLOW_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_BLACK.get());
            slab(ModBlocks.CONCRETE_BRICK_BLACK_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_BLACK_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_BLACK_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_BLACK_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_BLUE.get());
            slab(ModBlocks.CONCRETE_BRICK_BLUE_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_BLUE_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_BLUE_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_BLUE_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_BROWN.get());
            slab(ModBlocks.CONCRETE_BRICK_BROWN_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_BROWN_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_BROWN_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_BROWN_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_CYAN.get());
            slab(ModBlocks.CONCRETE_BRICK_CYAN_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_CYAN_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_CYAN_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_CYAN_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_GRAY.get());
            slab(ModBlocks.CONCRETE_BRICK_GRAY_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_GRAY_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_GRAY_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_GRAY_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_GREEN.get());
            slab(ModBlocks.CONCRETE_BRICK_GREEN_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_GREEN_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_GREEN_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_GREEN_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE.get());
            slab(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_LIGHT_BLUE_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY.get());
            slab(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_LIGHT_GRAY_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_LIME.get());
            slab(ModBlocks.CONCRETE_BRICK_LIME_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_LIME_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_LIME_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_LIME_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_MAGENTA.get());
            slab(ModBlocks.CONCRETE_BRICK_MAGENTA_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_MAGENTA_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_MAGENTA_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_MAGENTA_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_ORANGE.get());
            slab(ModBlocks.CONCRETE_BRICK_ORANGE_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_ORANGE_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_ORANGE_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_ORANGE_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_PINK.get());
            slab(ModBlocks.CONCRETE_BRICK_PINK_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_PINK_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_PINK_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_PINK_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_PURPLE.get());
            slab(ModBlocks.CONCRETE_BRICK_PURPLE_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_PURPLE_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_PURPLE_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_PURPLE_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_RED.get());
            slab(ModBlocks.CONCRETE_BRICK_RED_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_RED_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_RED_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_RED_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_WHITE.get());
            slab(ModBlocks.CONCRETE_BRICK_WHITE_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_WHITE_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_WHITE_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_WHITE_WALL.get());
    
            blockWithItem(ModBlocks.CONCRETE_BRICK_YELLOW.get());
            slab(ModBlocks.CONCRETE_BRICK_YELLOW_SLAB.get());
            verticalSlab(ModBlocks.CONCRETE_BRICK_YELLOW_VERTICAL_SLAB.get());
            stairs(ModBlocks.CONCRETE_BRICK_YELLOW_STAIRS.get());
            wall(ModBlocks.CONCRETE_BRICK_YELLOW_WALL.get());
    
            /* WOOD */
    
            log(ModBlocks.APPLE_LOG.get());
            rotatedSlab(ModBlocks.APPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.APPLE_LOG_STAIRS.get());
            log(ModBlocks.APPLE_BEAM.get());
            rotatedSlab(ModBlocks.APPLE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.APPLE_BEAM_STAIRS.get());
            wood(ModBlocks.APPLE_WOOD.get());
            wrotatedSlab(ModBlocks.APPLE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.APPLE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_APPLE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_APPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_APPLE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_APPLE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_APPLE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_APPLE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.APPLE_PLANKS.get());
            stairs(ModBlocks.APPLE_PLANKS_STAIRS.get());
            slab(ModBlocks.APPLE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.APPLE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.APPLE_BUTTON.get());
            fence(ModBlocks.APPLE_FENCE.get());
            fenceGate(ModBlocks.APPLE_FENCE_GATE.get());
            door(ModBlocks.APPLE_DOOR.get());
            trapdoor(ModBlocks.APPLE_TRAPDOOR.get());
            fruitLeaves(ModBlocks.APPLE_LEAVES.get());
            woodenPressurePlate(ModBlocks.APPLE_PRESSURE_PLATE.get());
            sapling(ModBlocks.APPLE_SAPLING.get());
            signBlock((StandingSignBlock) ModBlocks.APPLE_SIGN.get(), (WallSignBlock) ModBlocks.APPLE_WALL_SIGN.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            hangingSignBlock(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.APPLE_PLANKS.get()));

            log(ModBlocks.PEAR_LOG.get());
            rotatedSlab(ModBlocks.PEAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.PEAR_LOG_STAIRS.get());
            log(ModBlocks.PEAR_BEAM.get());
            rotatedSlab(ModBlocks.PEAR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PEAR_BEAM_STAIRS.get());
            wood(ModBlocks.PEAR_WOOD.get());
            wrotatedSlab(ModBlocks.PEAR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.PEAR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PEAR_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_PEAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PEAR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PEAR_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_PEAR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_PEAR_WOOD_STAIRS.get());

            blockWithItem(ModBlocks.PEAR_PLANKS.get());
            stairs(ModBlocks.PEAR_PLANKS_STAIRS.get());
            slab(ModBlocks.PEAR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PEAR_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.PEAR_BUTTON.get());
            fence(ModBlocks.PEAR_FENCE.get());
            fenceGate(ModBlocks.PEAR_FENCE_GATE.get());
            door(ModBlocks.PEAR_DOOR.get());
            trapdoor(ModBlocks.PEAR_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.PEAR_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.PEAR_LEAVES.get());
            sapling(ModBlocks.PEAR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PEAR_SIGN.get()), ((WallSignBlock) ModBlocks.PEAR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PEAR_PLANKS.get()));
            hangingSignBlock(ModBlocks.PEAR_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PEAR_PLANKS.get()));
            log(ModBlocks.PLUM_LOG.get());
            rotatedSlab(ModBlocks.PLUM_LOG_SLAB.get());
            stairsRotated(ModBlocks.PLUM_LOG_STAIRS.get());
            log(ModBlocks.PLUM_BEAM.get());
            rotatedSlab(ModBlocks.PLUM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PLUM_BEAM_STAIRS.get());
            wood(ModBlocks.PLUM_WOOD.get());
            wrotatedSlab(ModBlocks.PLUM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.PLUM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PLUM_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_PLUM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PLUM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PLUM_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_PLUM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_PLUM_WOOD_STAIRS.get());

            blockWithItem(ModBlocks.PLUM_PLANKS.get());
            stairs(ModBlocks.PLUM_PLANKS_STAIRS.get());
            slab(ModBlocks.PLUM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PLUM_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.PLUM_BUTTON.get());
            fence(ModBlocks.PLUM_FENCE.get());
            fenceGate(ModBlocks.PLUM_FENCE_GATE.get());
            door(ModBlocks.PLUM_DOOR.get());
            trapdoor(ModBlocks.PLUM_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.PLUM_PRESSURE_PLATE.get());
            sapling(ModBlocks.PLUM_SAPLING.get());
            fruitLeaves(ModBlocks.PLUM_LEAVES.get());
            signBlock(((StandingSignBlock) ModBlocks.PLUM_SIGN.get()), ((WallSignBlock) ModBlocks.PLUM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PLUM_PLANKS.get()));
            hangingSignBlock(ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PLUM_PLANKS.get()));

            log(ModBlocks.MALLORN_LOG.get());
            rotatedSlab(ModBlocks.MALLORN_LOG_SLAB.get());
            stairsRotated(ModBlocks.MALLORN_LOG_STAIRS.get());
            log(ModBlocks.MALLORN_BEAM.get());
            rotatedSlab(ModBlocks.MALLORN_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MALLORN_BEAM_STAIRS.get());
            wood(ModBlocks.MALLORN_WOOD.get());
            wrotatedSlab(ModBlocks.MALLORN_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.MALLORN_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MALLORN_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_MALLORN_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MALLORN_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MALLORN_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_MALLORN_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_MALLORN_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MALLORN_PLANKS.get());
            stairs(ModBlocks.MALLORN_PLANKS_STAIRS.get());
            slab(ModBlocks.MALLORN_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MALLORN_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.MALLORN_BUTTON.get());
            fence(ModBlocks.MALLORN_FENCE.get());
            fenceGate(ModBlocks.MALLORN_FENCE_GATE.get());
            door(ModBlocks.MALLORN_DOOR.get());
            trapdoor(ModBlocks.MALLORN_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.MALLORN_PRESSURE_PLATE.get());
            leaves(ModBlocks.MALLORN_LEAVES.get());
            sapling(ModBlocks.MALLORN_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MALLORN_SIGN.get()), ((WallSignBlock) ModBlocks.MALLORN_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MALLORN_PLANKS.get()));
            hangingSignBlock(ModBlocks.MALLORN_HANGING_SIGN.get(), ModBlocks.MALLORN_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MALLORN_PLANKS.get()));

            log(ModBlocks.CHARRED_LOG.get());
            rotatedSlab(ModBlocks.CHARRED_LOG_SLAB.get());
            stairsRotated(ModBlocks.CHARRED_LOG_STAIRS.get());
            log(ModBlocks.CHARRED_BEAM.get());
            rotatedSlab(ModBlocks.CHARRED_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CHARRED_BEAM_STAIRS.get());
            wood(ModBlocks.CHARRED_WOOD.get());
            wrotatedSlab(ModBlocks.CHARRED_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.CHARRED_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CHARRED_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_CHARRED_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CHARRED_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CHARRED_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_CHARRED_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_CHARRED_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CHARRED_PLANKS.get());
            stairs(ModBlocks.CHARRED_PLANKS_STAIRS.get());
            slab(ModBlocks.CHARRED_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CHARRED_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.CHARRED_BUTTON.get());
            fence(ModBlocks.CHARRED_FENCE.get());
            fenceGate(ModBlocks.CHARRED_FENCE_GATE.get());
            door(ModBlocks.CHARRED_DOOR.get());
            trapdoor(ModBlocks.CHARRED_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.CHARRED_PRESSURE_PLATE.get());
            signBlock(((StandingSignBlock) ModBlocks.CHARRED_SIGN.get()), ((WallSignBlock) ModBlocks.CHARRED_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CHARRED_PLANKS.get()));
            hangingSignBlock(ModBlocks.CHARRED_HANGING_SIGN.get(), ModBlocks.CHARRED_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CHARRED_PLANKS.get()));

            log(ModBlocks.WILLOW_LOG.get());
            rotatedSlab(ModBlocks.WILLOW_LOG_SLAB.get());
            stairsRotated(ModBlocks.WILLOW_LOG_STAIRS.get());
            log(ModBlocks.WILLOW_BEAM.get());
            rotatedSlab(ModBlocks.WILLOW_BEAM_SLAB.get());
            stairsRotated(ModBlocks.WILLOW_BEAM_STAIRS.get());
            wood(ModBlocks.WILLOW_WOOD.get());
            wrotatedSlab(ModBlocks.WILLOW_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.WILLOW_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_WILLOW_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_WILLOW_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_WILLOW_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_WILLOW_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_WILLOW_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_WILLOW_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.WILLOW_PLANKS.get());
            stairs(ModBlocks.WILLOW_PLANKS_STAIRS.get());
            slab(ModBlocks.WILLOW_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.WILLOW_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.WILLOW_BUTTON.get());
            fence(ModBlocks.WILLOW_FENCE.get());
            fenceGate(ModBlocks.WILLOW_FENCE_GATE.get());
            door(ModBlocks.WILLOW_DOOR.get());
            trapdoor(ModBlocks.WILLOW_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.WILLOW_PRESSURE_PLATE.get());
            leaves(ModBlocks.WILLOW_LEAVES.get());
            sapling(ModBlocks.WILLOW_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.WILLOW_SIGN.get()), ((WallSignBlock) ModBlocks.WILLOW_WALL_SIGN.get()),
                    blockTexture(ModBlocks.WILLOW_PLANKS.get()));
            hangingSignBlock(ModBlocks.WILLOW_HANGING_SIGN.get(), ModBlocks.WILLOW_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.WILLOW_PLANKS.get()));

            log(ModBlocks.BEECH_LOG.get());
            rotatedSlab(ModBlocks.BEECH_LOG_SLAB.get());
            stairsRotated(ModBlocks.BEECH_LOG_STAIRS.get());
            log(ModBlocks.BEECH_BEAM.get());
            rotatedSlab(ModBlocks.BEECH_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BEECH_BEAM_STAIRS.get());
            wood(ModBlocks.BEECH_WOOD.get());
            wrotatedSlab(ModBlocks.BEECH_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.BEECH_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BEECH_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_BEECH_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BEECH_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BEECH_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_BEECH_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_BEECH_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BEECH_PLANKS.get());
            stairs(ModBlocks.BEECH_PLANKS_STAIRS.get());
            slab(ModBlocks.BEECH_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BEECH_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.BEECH_BUTTON.get());
            fence(ModBlocks.BEECH_FENCE.get());
            fenceGate(ModBlocks.BEECH_FENCE_GATE.get());
            door(ModBlocks.BEECH_DOOR.get());
            trapdoor(ModBlocks.BEECH_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.BEECH_PRESSURE_PLATE.get());
            leaves(ModBlocks.BEECH_LEAVES.get());
            sapling(ModBlocks.BEECH_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BEECH_SIGN.get()), ((WallSignBlock) ModBlocks.BEECH_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BEECH_PLANKS.get()));
            hangingSignBlock(ModBlocks.BEECH_HANGING_SIGN.get(), ModBlocks.BEECH_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BEECH_PLANKS.get()));

            log(ModBlocks.BAOBAB_LOG.get());
            rotatedSlab(ModBlocks.BAOBAB_LOG_SLAB.get());
            stairsRotated(ModBlocks.BAOBAB_LOG_STAIRS.get());
            log(ModBlocks.BAOBAB_BEAM.get());
            rotatedSlab(ModBlocks.BAOBAB_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BAOBAB_BEAM_STAIRS.get());
            wood(ModBlocks.BAOBAB_WOOD.get());
            wrotatedSlab(ModBlocks.BAOBAB_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.BAOBAB_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BAOBAB_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_BAOBAB_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BAOBAB_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_BAOBAB_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_BAOBAB_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BAOBAB_PLANKS.get());
            stairs(ModBlocks.BAOBAB_PLANKS_STAIRS.get());
            slab(ModBlocks.BAOBAB_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BAOBAB_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.BAOBAB_BUTTON.get());
            fence(ModBlocks.BAOBAB_FENCE.get());
            fenceGate(ModBlocks.BAOBAB_FENCE_GATE.get());
            door(ModBlocks.BAOBAB_DOOR.get());
            trapdoor(ModBlocks.BAOBAB_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
            leaves(ModBlocks.BAOBAB_LEAVES.get());
            sapling(ModBlocks.BAOBAB_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BAOBAB_SIGN.get()), ((WallSignBlock) ModBlocks.BAOBAB_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
            hangingSignBlock(ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BAOBAB_PLANKS.get()));

            log(ModBlocks.PINE_LOG.get());
            rotatedSlab(ModBlocks.PINE_LOG_SLAB.get());
            stairsRotated(ModBlocks.PINE_LOG_STAIRS.get());
            log(ModBlocks.PINE_BEAM.get());
            rotatedSlab(ModBlocks.PINE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PINE_BEAM_STAIRS.get());
            wood(ModBlocks.PINE_WOOD.get());
            wrotatedSlab(ModBlocks.PINE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.PINE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PINE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_PINE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PINE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PINE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_PINE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_PINE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.PINE_PLANKS.get());
            stairs(ModBlocks.PINE_PLANKS_STAIRS.get());
            slab(ModBlocks.PINE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PINE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.PINE_BUTTON.get());
            fence(ModBlocks.PINE_FENCE.get());
            fenceGate(ModBlocks.PINE_FENCE_GATE.get());
            door(ModBlocks.PINE_DOOR.get());
            trapdoor(ModBlocks.PINE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.PINE_PRESSURE_PLATE.get());
            leaves(ModBlocks.PINE_LEAVES.get());
            sapling(ModBlocks.PINE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()), ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PINE_PLANKS.get()));
            hangingSignBlock(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PINE_PLANKS.get()));

            log(ModBlocks.HOLLY_LOG.get());
            rotatedSlab(ModBlocks.HOLLY_LOG_SLAB.get());
            stairsRotated(ModBlocks.HOLLY_LOG_STAIRS.get());
            log(ModBlocks.HOLLY_BEAM.get());
            rotatedSlab(ModBlocks.HOLLY_BEAM_SLAB.get());
            stairsRotated(ModBlocks.HOLLY_BEAM_STAIRS.get());
            wood(ModBlocks.HOLLY_WOOD.get());
            wrotatedSlab(ModBlocks.HOLLY_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.HOLLY_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_HOLLY_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_HOLLY_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_HOLLY_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_HOLLY_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_HOLLY_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_HOLLY_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.HOLLY_PLANKS.get());
            stairs(ModBlocks.HOLLY_PLANKS_STAIRS.get());
            slab(ModBlocks.HOLLY_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.HOLLY_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.HOLLY_BUTTON.get());
            fence(ModBlocks.HOLLY_FENCE.get());
            fenceGate(ModBlocks.HOLLY_FENCE_GATE.get());
            door(ModBlocks.HOLLY_DOOR.get());
            trapdoor(ModBlocks.HOLLY_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.HOLLY_PRESSURE_PLATE.get());
            leaves(ModBlocks.HOLLY_LEAVES.get());
            sapling(ModBlocks.HOLLY_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.HOLLY_SIGN.get()), ((WallSignBlock) ModBlocks.HOLLY_WALL_SIGN.get()),
                    blockTexture(ModBlocks.HOLLY_PLANKS.get()));
            hangingSignBlock(ModBlocks.HOLLY_HANGING_SIGN.get(), ModBlocks.HOLLY_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.HOLLY_PLANKS.get()));

            log(ModBlocks.GREEN_OAK_LOG.get());
            rotatedSlab(ModBlocks.GREEN_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.GREEN_OAK_LOG_STAIRS.get());
            log(ModBlocks.GREEN_OAK_BEAM.get());
            rotatedSlab(ModBlocks.GREEN_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.GREEN_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.GREEN_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.GREEN_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.GREEN_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_GREEN_OAK_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_GREEN_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_GREEN_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_GREEN_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_GREEN_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_GREEN_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.GREEN_OAK_PLANKS.get());
            stairs(ModBlocks.GREEN_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.GREEN_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.GREEN_OAK_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.GREEN_OAK_BUTTON.get());
            fence(ModBlocks.GREEN_OAK_FENCE.get());
            fenceGate(ModBlocks.GREEN_OAK_FENCE_GATE.get());
            door(ModBlocks.GREEN_OAK_DOOR.get());
            trapdoor(ModBlocks.GREEN_OAK_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.GREEN_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.GREEN_OAK_LEAVES.get());
            sapling(ModBlocks.GREEN_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.GREEN_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.GREEN_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));
            hangingSignBlock(ModBlocks.GREEN_OAK_HANGING_SIGN.get(), ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));

            log(ModBlocks.RED_OAK_LOG.get());
            rotatedSlab(ModBlocks.RED_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.RED_OAK_LOG_STAIRS.get());
            log(ModBlocks.RED_OAK_BEAM.get());
            rotatedSlab(ModBlocks.RED_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.RED_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.RED_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.RED_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.RED_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_RED_OAK_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_RED_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_RED_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_RED_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_RED_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_RED_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.RED_OAK_PLANKS.get());
            stairs(ModBlocks.RED_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.RED_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.RED_OAK_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.RED_OAK_BUTTON.get());
            fence(ModBlocks.RED_OAK_FENCE.get());
            fenceGate(ModBlocks.RED_OAK_FENCE_GATE.get());
            door(ModBlocks.RED_OAK_DOOR.get());
            trapdoor(ModBlocks.RED_OAK_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.RED_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.RED_OAK_LEAVES.get());
            sapling(ModBlocks.RED_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.RED_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.RED_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.RED_OAK_PLANKS.get()));
            hangingSignBlock(ModBlocks.RED_OAK_HANGING_SIGN.get(), ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.RED_OAK_PLANKS.get()));

            log(ModBlocks.MIRK_OAK_LOG.get());
            rotatedSlab(ModBlocks.MIRK_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.MIRK_OAK_LOG_STAIRS.get());
            log(ModBlocks.MIRK_OAK_BEAM.get());
            rotatedSlab(ModBlocks.MIRK_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MIRK_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.MIRK_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.MIRK_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.MIRK_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MIRK_OAK_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_MIRK_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MIRK_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MIRK_OAK_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_MIRK_OAK_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_MIRK_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MIRK_OAK_PLANKS.get());
            stairs(ModBlocks.MIRK_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.MIRK_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MIRK_OAK_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.MIRK_OAK_BUTTON.get());
            fence(ModBlocks.MIRK_OAK_FENCE.get());
            fenceGate(ModBlocks.MIRK_OAK_FENCE_GATE.get());
            door(ModBlocks.MIRK_OAK_DOOR.get());
            trapdoor(ModBlocks.MIRK_OAK_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.MIRK_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.MIRK_OAK_LEAVES.get());
            sapling(ModBlocks.MIRK_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MIRK_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.MIRK_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));
            hangingSignBlock(ModBlocks.MIRK_OAK_HANGING_SIGN.get(), ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));

            log(ModBlocks.MAPLE_LOG.get());
            rotatedSlab(ModBlocks.MAPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.MAPLE_LOG_STAIRS.get());
            log(ModBlocks.MAPLE_BEAM.get());
            rotatedSlab(ModBlocks.MAPLE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MAPLE_BEAM_STAIRS.get());
            wood(ModBlocks.MAPLE_WOOD.get());
            wrotatedSlab(ModBlocks.MAPLE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.MAPLE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MAPLE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_MAPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MAPLE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MAPLE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_MAPLE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_MAPLE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MAPLE_PLANKS.get());
            stairs(ModBlocks.MAPLE_PLANKS_STAIRS.get());
            slab(ModBlocks.MAPLE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MAPLE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.MAPLE_BUTTON.get());
            fence(ModBlocks.MAPLE_FENCE.get());
            fenceGate(ModBlocks.MAPLE_FENCE_GATE.get());
            door(ModBlocks.MAPLE_DOOR.get());
            trapdoor(ModBlocks.MAPLE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE.get());
            leaves(ModBlocks.MAPLE_LEAVES.get());
            sapling(ModBlocks.MAPLE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MAPLE_PLANKS.get()));
            hangingSignBlock(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MAPLE_PLANKS.get()));

            log(ModBlocks.PALM_LOG.get());
            rotatedSlab(ModBlocks.PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.PALM_LOG_STAIRS.get());
            log(ModBlocks.PALM_BEAM.get());
            rotatedSlab(ModBlocks.PALM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PALM_BEAM_STAIRS.get());
            wood(ModBlocks.PALM_WOOD.get());
            wrotatedSlab(ModBlocks.PALM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.PALM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PALM_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PALM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PALM_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_PALM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_PALM_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.PALM_PLANKS.get());
            stairs(ModBlocks.PALM_PLANKS_STAIRS.get());
            slab(ModBlocks.PALM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PALM_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.PALM_BUTTON.get());
            fence(ModBlocks.PALM_FENCE.get());
            fenceGate(ModBlocks.PALM_FENCE_GATE.get());
            door(ModBlocks.PALM_DOOR.get());
            trapdoor(ModBlocks.PALM_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.PALM_PRESSURE_PLATE.get());
            leaves(ModBlocks.PALM_LEAVES.get());
            sapling(ModBlocks.PALM_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PALM_SIGN.get()), ((WallSignBlock) ModBlocks.PALM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PALM_PLANKS.get()));
            hangingSignBlock(ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PALM_PLANKS.get()));

            log(ModBlocks.CHESTNUT_LOG.get());
            rotatedSlab(ModBlocks.CHESTNUT_LOG_SLAB.get());
            stairsRotated(ModBlocks.CHESTNUT_LOG_STAIRS.get());
            log(ModBlocks.CHESTNUT_BEAM.get());
            rotatedSlab(ModBlocks.CHESTNUT_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CHESTNUT_BEAM_STAIRS.get());
            wood(ModBlocks.CHESTNUT_WOOD.get());
            wrotatedSlab(ModBlocks.CHESTNUT_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.CHESTNUT_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CHESTNUT_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_CHESTNUT_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CHESTNUT_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CHESTNUT_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_CHESTNUT_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_CHESTNUT_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CHESTNUT_PLANKS.get());
            stairs(ModBlocks.CHESTNUT_PLANKS_STAIRS.get());
            slab(ModBlocks.CHESTNUT_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CHESTNUT_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.CHESTNUT_BUTTON.get());
            fence(ModBlocks.CHESTNUT_FENCE.get());
            fenceGate(ModBlocks.CHESTNUT_FENCE_GATE.get());
            door(ModBlocks.CHESTNUT_DOOR.get());
            trapdoor(ModBlocks.CHESTNUT_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.CHESTNUT_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.CHESTNUT_LEAVES.get());
            sapling(ModBlocks.CHESTNUT_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CHESTNUT_SIGN.get()), ((WallSignBlock) ModBlocks.CHESTNUT_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));
            hangingSignBlock(ModBlocks.CHESTNUT_HANGING_SIGN.get(), ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));

            log(ModBlocks.ASPEN_LOG.get());
            rotatedSlab(ModBlocks.ASPEN_LOG_SLAB.get());
            stairsRotated(ModBlocks.ASPEN_LOG_STAIRS.get());
            log(ModBlocks.ASPEN_BEAM.get());
            rotatedSlab(ModBlocks.ASPEN_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ASPEN_BEAM_STAIRS.get());
            wood(ModBlocks.ASPEN_WOOD.get());
            wrotatedSlab(ModBlocks.ASPEN_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.ASPEN_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ASPEN_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_ASPEN_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ASPEN_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ASPEN_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_ASPEN_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_ASPEN_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ASPEN_PLANKS.get());
            stairs(ModBlocks.ASPEN_PLANKS_STAIRS.get());
            slab(ModBlocks.ASPEN_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ASPEN_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.ASPEN_BUTTON.get());
            fence(ModBlocks.ASPEN_FENCE.get());
            fenceGate(ModBlocks.ASPEN_FENCE_GATE.get());
            door(ModBlocks.ASPEN_DOOR.get());
            trapdoor(ModBlocks.ASPEN_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.ASPEN_PRESSURE_PLATE.get());
            leaves(ModBlocks.ASPEN_LEAVES.get());
            sapling(ModBlocks.ASPEN_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ASPEN_SIGN.get()), ((WallSignBlock) ModBlocks.ASPEN_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ASPEN_PLANKS.get()));
            hangingSignBlock(ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ASPEN_PLANKS.get()));

            log(ModBlocks.CEDAR_LOG.get());
            rotatedSlab(ModBlocks.CEDAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.CEDAR_LOG_STAIRS.get());
            log(ModBlocks.CEDAR_BEAM.get());
            rotatedSlab(ModBlocks.CEDAR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CEDAR_BEAM_STAIRS.get());
            wood(ModBlocks.CEDAR_WOOD.get());
            wrotatedSlab(ModBlocks.CEDAR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.CEDAR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CEDAR_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_CEDAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CEDAR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CEDAR_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_CEDAR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_CEDAR_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CEDAR_PLANKS.get());
            stairs(ModBlocks.CEDAR_PLANKS_STAIRS.get());
            slab(ModBlocks.CEDAR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CEDAR_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.CEDAR_BUTTON.get());
            fence(ModBlocks.CEDAR_FENCE.get());
            fenceGate(ModBlocks.CEDAR_FENCE_GATE.get());
            door(ModBlocks.CEDAR_DOOR.get());
            trapdoor(ModBlocks.CEDAR_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.CEDAR_PRESSURE_PLATE.get());
            leaves(ModBlocks.CEDAR_LEAVES.get());
            sapling(ModBlocks.CEDAR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CEDAR_SIGN.get()), ((WallSignBlock) ModBlocks.CEDAR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CEDAR_PLANKS.get()));
            hangingSignBlock(ModBlocks.CEDAR_HANGING_SIGN.get(), ModBlocks.CEDAR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CEDAR_PLANKS.get()));

            log(ModBlocks.FIR_LOG.get());
            rotatedSlab(ModBlocks.FIR_LOG_SLAB.get());
            stairsRotated(ModBlocks.FIR_LOG_STAIRS.get());
            log(ModBlocks.FIR_BEAM.get());
            rotatedSlab(ModBlocks.FIR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.FIR_BEAM_STAIRS.get());
            wood(ModBlocks.FIR_WOOD.get());
            wrotatedSlab(ModBlocks.FIR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.FIR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_FIR_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_FIR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_FIR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_FIR_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_FIR_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_FIR_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.FIR_PLANKS.get());
            stairs(ModBlocks.FIR_PLANKS_STAIRS.get());
            slab(ModBlocks.FIR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.FIR_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.FIR_BUTTON.get());
            fence(ModBlocks.FIR_FENCE.get());
            fenceGate(ModBlocks.FIR_FENCE_GATE.get());
            door(ModBlocks.FIR_DOOR.get());
            trapdoor(ModBlocks.FIR_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.FIR_PRESSURE_PLATE.get());
            leaves(ModBlocks.FIR_LEAVES.get());
            sapling(ModBlocks.FIR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.FIR_SIGN.get()), ((WallSignBlock) ModBlocks.FIR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.FIR_PLANKS.get()));
            hangingSignBlock(ModBlocks.FIR_HANGING_SIGN.get(), ModBlocks.FIR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.FIR_PLANKS.get()));

            log(ModBlocks.LARCH_LOG.get());
            rotatedSlab(ModBlocks.LARCH_LOG_SLAB.get());
            stairsRotated(ModBlocks.LARCH_LOG_STAIRS.get());
            log(ModBlocks.LARCH_BEAM.get());
            rotatedSlab(ModBlocks.LARCH_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LARCH_BEAM_STAIRS.get());
            wood(ModBlocks.LARCH_WOOD.get());
            wrotatedSlab(ModBlocks.LARCH_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.LARCH_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LARCH_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_LARCH_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LARCH_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LARCH_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_LARCH_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_LARCH_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LARCH_PLANKS.get());
            stairs(ModBlocks.LARCH_PLANKS_STAIRS.get());
            slab(ModBlocks.LARCH_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LARCH_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.LARCH_BUTTON.get());
            fence(ModBlocks.LARCH_FENCE.get());
            fenceGate(ModBlocks.LARCH_FENCE_GATE.get());
            door(ModBlocks.LARCH_DOOR.get());
            trapdoor(ModBlocks.LARCH_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.LARCH_PRESSURE_PLATE.get());
            leaves(ModBlocks.LARCH_LEAVES.get());
            sapling(ModBlocks.LARCH_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LARCH_SIGN.get()), ((WallSignBlock) ModBlocks.LARCH_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LARCH_PLANKS.get()));
            hangingSignBlock(ModBlocks.LARCH_HANGING_SIGN.get(), ModBlocks.LARCH_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LARCH_PLANKS.get()));

            log(ModBlocks.LAIRELOSSE_LOG.get());
            rotatedSlab(ModBlocks.LAIRELOSSE_LOG_SLAB.get());
            stairsRotated(ModBlocks.LAIRELOSSE_LOG_STAIRS.get());
            log(ModBlocks.LAIRELOSSE_BEAM.get());
            rotatedSlab(ModBlocks.LAIRELOSSE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LAIRELOSSE_BEAM_STAIRS.get());
            wood(ModBlocks.LAIRELOSSE_WOOD.get());
            wrotatedSlab(ModBlocks.LAIRELOSSE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.LAIRELOSSE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LAIRELOSSE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_LAIRELOSSE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LAIRELOSSE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LAIRELOSSE_PLANKS.get());
            stairs(ModBlocks.LAIRELOSSE_PLANKS_STAIRS.get());
            slab(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LAIRELOSSE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.LAIRELOSSE_BUTTON.get());
            fence(ModBlocks.LAIRELOSSE_FENCE.get());
            fenceGate(ModBlocks.LAIRELOSSE_FENCE_GATE.get());
            door(ModBlocks.LAIRELOSSE_DOOR.get());
            trapdoor(ModBlocks.LAIRELOSSE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.LAIRELOSSE_PRESSURE_PLATE.get());
            leaves(ModBlocks.LAIRELOSSE_LEAVES.get());
            sapling(ModBlocks.LAIRELOSSE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LAIRELOSSE_SIGN.get()), ((WallSignBlock) ModBlocks.LAIRELOSSE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));
            hangingSignBlock(ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));

            log(ModBlocks.ALMOND_LOG.get());
            rotatedSlab(ModBlocks.ALMOND_LOG_SLAB.get());
            stairsRotated(ModBlocks.ALMOND_LOG_STAIRS.get());
            log(ModBlocks.ALMOND_BEAM.get());
            rotatedSlab(ModBlocks.ALMOND_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ALMOND_BEAM_STAIRS.get());
            wood(ModBlocks.ALMOND_WOOD.get());
            wrotatedSlab(ModBlocks.ALMOND_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.ALMOND_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ALMOND_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_ALMOND_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ALMOND_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ALMOND_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_ALMOND_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_ALMOND_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ALMOND_PLANKS.get());
            stairs(ModBlocks.ALMOND_PLANKS_STAIRS.get());
            slab(ModBlocks.ALMOND_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ALMOND_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.ALMOND_BUTTON.get());
            fence(ModBlocks.ALMOND_FENCE.get());
            fenceGate(ModBlocks.ALMOND_FENCE_GATE.get());
            door(ModBlocks.ALMOND_DOOR.get());
            trapdoor(ModBlocks.ALMOND_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.ALMOND_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.ALMOND_LEAVES.get());
            sapling(ModBlocks.ALMOND_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ALMOND_SIGN.get()), ((WallSignBlock) ModBlocks.ALMOND_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ALMOND_PLANKS.get()));
            hangingSignBlock(ModBlocks.ALMOND_HANGING_SIGN.get(), ModBlocks.ALMOND_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ALMOND_PLANKS.get()));

            log(ModBlocks.BANANA_LOG.get());
            rotatedSlab(ModBlocks.BANANA_LOG_SLAB.get());
            stairsRotated(ModBlocks.BANANA_LOG_STAIRS.get());
            log(ModBlocks.BANANA_BEAM.get());
            rotatedSlab(ModBlocks.BANANA_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BANANA_BEAM_STAIRS.get());
            wood(ModBlocks.BANANA_WOOD.get());
            wrotatedSlab(ModBlocks.BANANA_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.BANANA_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BANANA_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_BANANA_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BANANA_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BANANA_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_BANANA_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_BANANA_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BANANA_PLANKS.get());
            stairs(ModBlocks.BANANA_PLANKS_STAIRS.get());
            slab(ModBlocks.BANANA_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BANANA_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.BANANA_BUTTON.get());
            fence(ModBlocks.BANANA_FENCE.get());
            fenceGate(ModBlocks.BANANA_FENCE_GATE.get());
            door(ModBlocks.BANANA_DOOR.get());
            trapdoor(ModBlocks.BANANA_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.BANANA_PRESSURE_PLATE.get());
            leaves(ModBlocks.BANANA_LEAVES.get());
            sapling(ModBlocks.BANANA_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BANANA_SIGN.get()), ((WallSignBlock) ModBlocks.BANANA_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BANANA_PLANKS.get()));
            hangingSignBlock(ModBlocks.BANANA_HANGING_SIGN.get(), ModBlocks.BANANA_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BANANA_PLANKS.get()));

            log(ModBlocks.CYPRESS_LOG.get());
            rotatedSlab(ModBlocks.CYPRESS_LOG_SLAB.get());
            stairsRotated(ModBlocks.CYPRESS_LOG_STAIRS.get());
            log(ModBlocks.CYPRESS_BEAM.get());
            rotatedSlab(ModBlocks.CYPRESS_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CYPRESS_BEAM_STAIRS.get());
            wood(ModBlocks.CYPRESS_WOOD.get());
            wrotatedSlab(ModBlocks.CYPRESS_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.CYPRESS_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CYPRESS_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_CYPRESS_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CYPRESS_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CYPRESS_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_CYPRESS_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_CYPRESS_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CYPRESS_PLANKS.get());
            stairs(ModBlocks.CYPRESS_PLANKS_STAIRS.get());
            slab(ModBlocks.CYPRESS_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CYPRESS_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.CYPRESS_BUTTON.get());
            fence(ModBlocks.CYPRESS_FENCE.get());
            fenceGate(ModBlocks.CYPRESS_FENCE_GATE.get());
            door(ModBlocks.CYPRESS_DOOR.get());
            trapdoor(ModBlocks.CYPRESS_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.CYPRESS_PRESSURE_PLATE.get());
            leaves(ModBlocks.CYPRESS_LEAVES.get());
            sapling(ModBlocks.CYPRESS_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CYPRESS_SIGN.get()), ((WallSignBlock) ModBlocks.CYPRESS_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CYPRESS_PLANKS.get()));
            hangingSignBlock(ModBlocks.CYPRESS_HANGING_SIGN.get(), ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CYPRESS_PLANKS.get()));

            log(ModBlocks.DATE_PALM_LOG.get());
            rotatedSlab(ModBlocks.DATE_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.DATE_PALM_LOG_STAIRS.get());
            log(ModBlocks.DATE_PALM_BEAM.get());
            rotatedSlab(ModBlocks.DATE_PALM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.DATE_PALM_BEAM_STAIRS.get());
            wood(ModBlocks.DATE_PALM_WOOD.get());
            wrotatedSlab(ModBlocks.DATE_PALM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.DATE_PALM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_DATE_PALM_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_DATE_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_DATE_PALM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_DATE_PALM_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_DATE_PALM_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_DATE_PALM_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.DATE_PALM_PLANKS.get());
            stairs(ModBlocks.DATE_PALM_PLANKS_STAIRS.get());
            slab(ModBlocks.DATE_PALM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.DATE_PALM_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.DATE_PALM_BUTTON.get());
            fence(ModBlocks.DATE_PALM_FENCE.get());
            fenceGate(ModBlocks.DATE_PALM_FENCE_GATE.get());
            door(ModBlocks.DATE_PALM_DOOR.get());
            trapdoor(ModBlocks.DATE_PALM_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.DATE_PALM_PRESSURE_PLATE.get());
            leaves(ModBlocks.DATE_PALM_LEAVES.get());
            sapling(ModBlocks.DATE_PALM_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.DATE_PALM_SIGN.get()), ((WallSignBlock) ModBlocks.DATE_PALM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));
            hangingSignBlock(ModBlocks.DATE_PALM_HANGING_SIGN.get(), ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));

            log(ModBlocks.KUNTZ_LOG.get());
            rotatedSlab(ModBlocks.KUNTZ_LOG_SLAB.get());
            stairsRotated(ModBlocks.KUNTZ_LOG_STAIRS.get());
            log(ModBlocks.KUNTZ_BEAM.get());
            rotatedSlab(ModBlocks.KUNTZ_BEAM_SLAB.get());
            stairsRotated(ModBlocks.KUNTZ_BEAM_STAIRS.get());
            wood(ModBlocks.KUNTZ_WOOD.get());
            wrotatedSlab(ModBlocks.KUNTZ_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.KUNTZ_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_KUNTZ_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_KUNTZ_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_KUNTZ_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_KUNTZ_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_KUNTZ_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_KUNTZ_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.KUNTZ_PLANKS.get());
            stairs(ModBlocks.KUNTZ_PLANKS_STAIRS.get());
            slab(ModBlocks.KUNTZ_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.KUNTZ_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.KUNTZ_BUTTON.get());
            fence(ModBlocks.KUNTZ_FENCE.get());
            fenceGate(ModBlocks.KUNTZ_FENCE_GATE.get());
            door(ModBlocks.KUNTZ_DOOR.get());
            trapdoor(ModBlocks.KUNTZ_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.KUNTZ_PRESSURE_PLATE.get());
            leaves(ModBlocks.KUNTZ_LEAVES.get());
            sapling(ModBlocks.KUNTZ_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.KUNTZ_SIGN.get()), ((WallSignBlock) ModBlocks.KUNTZ_WALL_SIGN.get()),
                    blockTexture(ModBlocks.KUNTZ_PLANKS.get()));
            hangingSignBlock(ModBlocks.KUNTZ_HANGING_SIGN.get(), ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.KUNTZ_PLANKS.get()));

            log(ModBlocks.LEBETHRON_LOG.get());
            rotatedSlab(ModBlocks.LEBETHRON_LOG_SLAB.get());
            stairsRotated(ModBlocks.LEBETHRON_LOG_STAIRS.get());
            log(ModBlocks.LEBETHRON_BEAM.get());
            rotatedSlab(ModBlocks.LEBETHRON_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LEBETHRON_BEAM_STAIRS.get());
            wood(ModBlocks.LEBETHRON_WOOD.get());
            wrotatedSlab(ModBlocks.LEBETHRON_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.LEBETHRON_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LEBETHRON_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_LEBETHRON_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LEBETHRON_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LEBETHRON_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_LEBETHRON_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_LEBETHRON_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LEBETHRON_PLANKS.get());
            stairs(ModBlocks.LEBETHRON_PLANKS_STAIRS.get());
            slab(ModBlocks.LEBETHRON_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LEBETHRON_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.LEBETHRON_BUTTON.get());
            fence(ModBlocks.LEBETHRON_FENCE.get());
            fenceGate(ModBlocks.LEBETHRON_FENCE_GATE.get());
            door(ModBlocks.LEBETHRON_DOOR.get());
            trapdoor(ModBlocks.LEBETHRON_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.LEBETHRON_PRESSURE_PLATE.get());
            leaves(ModBlocks.LEBETHRON_LEAVES.get());
            sapling(ModBlocks.LEBETHRON_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LEBETHRON_SIGN.get()), ((WallSignBlock) ModBlocks.LEBETHRON_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));
            hangingSignBlock(ModBlocks.LEBETHRON_HANGING_SIGN.get(), ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));

            log(ModBlocks.LEMON_LOG.get());
            rotatedSlab(ModBlocks.LEMON_LOG_SLAB.get());
            stairsRotated(ModBlocks.LEMON_LOG_STAIRS.get());
            log(ModBlocks.LEMON_BEAM.get());
            rotatedSlab(ModBlocks.LEMON_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LEMON_BEAM_STAIRS.get());
            wood(ModBlocks.LEMON_WOOD.get());
            wrotatedSlab(ModBlocks.LEMON_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.LEMON_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LEMON_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_LEMON_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LEMON_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LEMON_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_LEMON_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_LEMON_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LEMON_PLANKS.get());
            stairs(ModBlocks.LEMON_PLANKS_STAIRS.get());
            slab(ModBlocks.LEMON_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LEMON_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.LEMON_BUTTON.get());
            fence(ModBlocks.LEMON_FENCE.get());
            fenceGate(ModBlocks.LEMON_FENCE_GATE.get());
            door(ModBlocks.LEMON_DOOR.get());
            trapdoor(ModBlocks.LEMON_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.LEMON_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.LEMON_LEAVES.get());
            sapling(ModBlocks.LEMON_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LEMON_SIGN.get()), ((WallSignBlock) ModBlocks.LEMON_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));
            hangingSignBlock(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));

            log(ModBlocks.LIME_LOG.get());
            rotatedSlab(ModBlocks.LIME_LOG_SLAB.get());
            stairsRotated(ModBlocks.LIME_LOG_STAIRS.get());
            log(ModBlocks.LIME_BEAM.get());
            rotatedSlab(ModBlocks.LIME_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LIME_BEAM_STAIRS.get());
            wood(ModBlocks.LIME_WOOD.get());
            wrotatedSlab(ModBlocks.LIME_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.LIME_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LIME_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_LIME_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LIME_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LIME_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_LIME_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_LIME_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LIME_PLANKS.get());
            stairs(ModBlocks.LIME_PLANKS_STAIRS.get());
            slab(ModBlocks.LIME_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LIME_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.LIME_BUTTON.get());
            fence(ModBlocks.LIME_FENCE.get());
            fenceGate(ModBlocks.LIME_FENCE_GATE.get());
            door(ModBlocks.LIME_DOOR.get());
            trapdoor(ModBlocks.LIME_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.LIME_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.LIME_LEAVES.get());
            sapling(ModBlocks.LIME_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LIME_SIGN.get()), ((WallSignBlock) ModBlocks.LIME_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LIME_PLANKS.get()));
            hangingSignBlock(ModBlocks.LIME_HANGING_SIGN.get(), ModBlocks.LIME_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LIME_PLANKS.get()));

            log(ModBlocks.MANGO_LOG.get());
            rotatedSlab(ModBlocks.MANGO_LOG_SLAB.get());
            stairsRotated(ModBlocks.MANGO_LOG_STAIRS.get());
            log(ModBlocks.MANGO_BEAM.get());
            rotatedSlab(ModBlocks.MANGO_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MANGO_BEAM_STAIRS.get());
            wood(ModBlocks.MANGO_WOOD.get());
            wrotatedSlab(ModBlocks.MANGO_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.MANGO_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MANGO_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_MANGO_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MANGO_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MANGO_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_MANGO_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_MANGO_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MANGO_PLANKS.get());
            stairs(ModBlocks.MANGO_PLANKS_STAIRS.get());
            slab(ModBlocks.MANGO_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MANGO_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.MANGO_BUTTON.get());
            fence(ModBlocks.MANGO_FENCE.get());
            fenceGate(ModBlocks.MANGO_FENCE_GATE.get());
            door(ModBlocks.MANGO_DOOR.get());
            trapdoor(ModBlocks.MANGO_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.MANGO_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.MANGO_LEAVES.get());
            sapling(ModBlocks.MANGO_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MANGO_SIGN.get()), ((WallSignBlock) ModBlocks.MANGO_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MANGO_PLANKS.get()));
            hangingSignBlock(ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MANGO_PLANKS.get()));

            log(ModBlocks.ORANGE_LOG.get());
            rotatedSlab(ModBlocks.ORANGE_LOG_SLAB.get());
            stairsRotated(ModBlocks.ORANGE_LOG_STAIRS.get());
            log(ModBlocks.ORANGE_BEAM.get());
            rotatedSlab(ModBlocks.ORANGE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ORANGE_BEAM_STAIRS.get());
            wood(ModBlocks.ORANGE_WOOD.get());
            wrotatedSlab(ModBlocks.ORANGE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.ORANGE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ORANGE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_ORANGE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ORANGE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ORANGE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_ORANGE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_ORANGE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ORANGE_PLANKS.get());
            stairs(ModBlocks.ORANGE_PLANKS_STAIRS.get());
            slab(ModBlocks.ORANGE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ORANGE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.ORANGE_BUTTON.get());
            fence(ModBlocks.ORANGE_FENCE.get());
            fenceGate(ModBlocks.ORANGE_FENCE_GATE.get());
            door(ModBlocks.ORANGE_DOOR.get());
            trapdoor(ModBlocks.ORANGE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.ORANGE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.ORANGE_LEAVES.get());
            sapling(ModBlocks.ORANGE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ORANGE_SIGN.get()), ((WallSignBlock) ModBlocks.ORANGE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));
            hangingSignBlock(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            log(ModBlocks.POMEGRANATE_LOG.get());
            rotatedSlab(ModBlocks.POMEGRANATE_LOG_SLAB.get());
            stairsRotated(ModBlocks.POMEGRANATE_LOG_STAIRS.get());
            log(ModBlocks.POMEGRANATE_BEAM.get());
            rotatedSlab(ModBlocks.POMEGRANATE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.POMEGRANATE_BEAM_STAIRS.get());
            wood(ModBlocks.POMEGRANATE_WOOD.get());
            wrotatedSlab(ModBlocks.POMEGRANATE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.POMEGRANATE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_POMEGRANATE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_POMEGRANATE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_POMEGRANATE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_POMEGRANATE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_POMEGRANATE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.POMEGRANATE_PLANKS.get());
            stairs(ModBlocks.POMEGRANATE_PLANKS_STAIRS.get());
            slab(ModBlocks.POMEGRANATE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.POMEGRANATE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.POMEGRANATE_BUTTON.get());
            fence(ModBlocks.POMEGRANATE_FENCE.get());
            fenceGate(ModBlocks.POMEGRANATE_FENCE_GATE.get());
            door(ModBlocks.POMEGRANATE_DOOR.get());
            trapdoor(ModBlocks.POMEGRANATE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.POMEGRANATE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.POMEGRANATE_LEAVES.get());
            sapling(ModBlocks.POMEGRANATE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.POMEGRANATE_SIGN.get()), ((WallSignBlock) ModBlocks.POMEGRANATE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.POMEGRANATE_PLANKS.get()));
            hangingSignBlock(ModBlocks.POMEGRANATE_HANGING_SIGN.get(), ModBlocks.POMEGRANATE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.POMEGRANATE_PLANKS.get()));

            log(ModBlocks.REDWOOD_LOG.get());
            rotatedSlab(ModBlocks.REDWOOD_LOG_SLAB.get());
            stairsRotated(ModBlocks.REDWOOD_LOG_STAIRS.get());
            log(ModBlocks.REDWOOD_BEAM.get());
            rotatedSlab(ModBlocks.REDWOOD_BEAM_SLAB.get());
            stairsRotated(ModBlocks.REDWOOD_BEAM_STAIRS.get());
            wood(ModBlocks.REDWOOD_WOOD.get());
            wrotatedSlab(ModBlocks.REDWOOD_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.REDWOOD_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_REDWOOD_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_REDWOOD_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_REDWOOD_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_REDWOOD_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_REDWOOD_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.REDWOOD_PLANKS.get());
            stairs(ModBlocks.REDWOOD_PLANKS_STAIRS.get());
            slab(ModBlocks.REDWOOD_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.REDWOOD_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.REDWOOD_BUTTON.get());
            fence(ModBlocks.REDWOOD_FENCE.get());
            fenceGate(ModBlocks.REDWOOD_FENCE_GATE.get());
            door(ModBlocks.REDWOOD_DOOR.get());
            trapdoor(ModBlocks.REDWOOD_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
            leaves(ModBlocks.REDWOOD_LEAVES.get());
            sapling(ModBlocks.REDWOOD_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.REDWOOD_SIGN.get()), ((WallSignBlock) ModBlocks.REDWOOD_WALL_SIGN.get()),
                    blockTexture(ModBlocks.REDWOOD_PLANKS.get()));
            hangingSignBlock(ModBlocks.REDWOOD_HANGING_SIGN.get(), ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.REDWOOD_PLANKS.get()));

            log(ModBlocks.RED_MAHOGANY_LOG.get());
            rotatedSlab(ModBlocks.RED_MAHOGANY_LOG_SLAB.get());
            stairsRotated(ModBlocks.RED_MAHOGANY_LOG_STAIRS.get());
            log(ModBlocks.RED_MAHOGANY_BEAM.get());
            rotatedSlab(ModBlocks.RED_MAHOGANY_BEAM_SLAB.get());
            stairsRotated(ModBlocks.RED_MAHOGANY_BEAM_STAIRS.get());
            wood(ModBlocks.RED_MAHOGANY_WOOD.get());
            wrotatedSlab(ModBlocks.RED_MAHOGANY_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.RED_MAHOGANY_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_RED_MAHOGANY_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.RED_MAHOGANY_PLANKS.get());
            stairs(ModBlocks.RED_MAHOGANY_PLANKS_STAIRS.get());
            slab(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.RED_MAHOGANY_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.RED_MAHOGANY_BUTTON.get());
            fence(ModBlocks.RED_MAHOGANY_FENCE.get());
            fenceGate(ModBlocks.RED_MAHOGANY_FENCE_GATE.get());
            door(ModBlocks.RED_MAHOGANY_DOOR.get());
            trapdoor(ModBlocks.RED_MAHOGANY_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.RED_MAHOGANY_PRESSURE_PLATE.get());
            leaves(ModBlocks.RED_MAHOGANY_LEAVES.get());
            sapling(ModBlocks.RED_MAHOGANY_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.RED_MAHOGANY_SIGN.get()), ((WallSignBlock) ModBlocks.RED_MAHOGANY_WALL_SIGN.get()),
                    blockTexture(ModBlocks.RED_MAHOGANY_PLANKS.get()));
            hangingSignBlock(ModBlocks.RED_MAHOGANY_HANGING_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.RED_MAHOGANY_PLANKS.get()));

            log(ModBlocks.OLIVE_LOG.get());
            rotatedSlab(ModBlocks.OLIVE_LOG_SLAB.get());
            stairsRotated(ModBlocks.OLIVE_LOG_STAIRS.get());
            log(ModBlocks.OLIVE_BEAM.get());
            rotatedSlab(ModBlocks.OLIVE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.OLIVE_BEAM_STAIRS.get());
            wood(ModBlocks.OLIVE_WOOD.get());
            wrotatedSlab(ModBlocks.OLIVE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.OLIVE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_OLIVE_LOG.get());
            rotatedSlab(ModBlocks.STRIPPED_OLIVE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_OLIVE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_OLIVE_WOOD.get());
            wrotatedSlab(ModBlocks.STRIPPED_OLIVE_WOOD_SLAB.get());
            wstairsRotated(ModBlocks.STRIPPED_OLIVE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.OLIVE_PLANKS.get());
            stairs(ModBlocks.OLIVE_PLANKS_STAIRS.get());
            slab(ModBlocks.OLIVE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.OLIVE_PLANKS_VERTICAL_SLAB.get());
            woodenButton(ModBlocks.OLIVE_BUTTON.get());
            fence(ModBlocks.OLIVE_FENCE.get());
            fenceGate(ModBlocks.OLIVE_FENCE_GATE.get());
            door(ModBlocks.OLIVE_DOOR.get());
            trapdoor(ModBlocks.OLIVE_TRAPDOOR.get());
            woodenPressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.OLIVE_LEAVES.get());
            sapling(ModBlocks.OLIVE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.OLIVE_SIGN.get()), ((WallSignBlock) ModBlocks.OLIVE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.OLIVE_PLANKS.get()));
            hangingSignBlock(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.OLIVE_PLANKS.get()));
    
    
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
    
            glass(ModBlocks.GLASS.get());
            glass(ModBlocks.WHITE_STAINED_GLASS.get());
            glass(ModBlocks.ORANGE_STAINED_GLASS.get());
            glass(ModBlocks.MAGENTA_STAINED_GLASS.get());
            glass(ModBlocks.LIGHT_BLUE_STAINED_GLASS.get());
            glass(ModBlocks.YELLOW_STAINED_GLASS.get());
            glass(ModBlocks.LIME_STAINED_GLASS.get());
            glass(ModBlocks.PINK_STAINED_GLASS.get());
            glass(ModBlocks.GRAY_STAINED_GLASS.get());
            glass(ModBlocks.LIGHT_GRAY_STAINED_GLASS.get());
            glass(ModBlocks.CYAN_STAINED_GLASS.get());
            glass(ModBlocks.PURPLE_STAINED_GLASS.get());
            glass(ModBlocks.BLUE_STAINED_GLASS.get());
            glass(ModBlocks.BROWN_STAINED_GLASS.get());
            glass(ModBlocks.GREEN_STAINED_GLASS.get());
            glass(ModBlocks.RED_STAINED_GLASS.get());
            glass(ModBlocks.BLACK_STAINED_GLASS.get());
    
            paneBlock(ModBlocks.GLASS_PANE.get());
            paneBlock(ModBlocks.WHITE_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.MAGENTA_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.YELLOW_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.LIME_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.PINK_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.GRAY_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.CYAN_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.PURPLE_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.BROWN_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.RED_STAINED_GLASS_PANE.get());
            paneBlock(ModBlocks.BLACK_STAINED_GLASS_PANE.get());
    
            bar(ModBlocks.GOLD_BARS.get());
            bar(ModBlocks.SILVER_BARS.get());
            bar(ModBlocks.REED_BARS.get());
    
            log(ModBlocks.THATCH_BLOCK.get());
            stairsRotated(ModBlocks.THATCH_BLOCK_STAIRS.get());
            rotatedSlab(ModBlocks.THATCH_BLOCK_SLAB.get());
            verticalHorizontalSlab(ModBlocks.THATCH_BLOCK_VERTICAL_SLAB.get());
            log(ModBlocks.THATCH_MUSTY_BLOCK.get());
            stairsRotated(ModBlocks.THATCH_MUSTY_BLOCK_STAIRS.get());
            rotatedSlab(ModBlocks.THATCH_MUSTY_BLOCK_SLAB.get());
            verticalHorizontalSlab(ModBlocks.THATCH_MUSTY_BLOCK_VERTICAL_SLAB.get());
            log(ModBlocks.REED_BLOCK.get());
            stairsRotated(ModBlocks.REED_BLOCK_STAIRS.get());
            rotatedSlab(ModBlocks.REED_BLOCK_SLAB.get());
            verticalHorizontalSlab(ModBlocks.REED_BLOCK_VERTICAL_SLAB.get());


            // BEAM
            verticalHorizontalSlab(ModBlocks.ALMOND_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.APPLE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.ASPEN_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BANANA_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BAOBAB_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BEECH_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CHARRED_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CEDAR_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CHESTNUT_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CYPRESS_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.DATE_PALM_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.FIR_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.GREEN_OAK_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.HOLLY_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.KUNTZ_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LAIRELOSSE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LARCH_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LEBETHRON_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LEMON_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LIME_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MALLORN_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MANGO_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MAPLE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MIRK_OAK_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.OLIVE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.ORANGE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PALM_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PEAR_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PINE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PLUM_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.POMEGRANATE_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.REDWOOD_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.RED_OAK_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.RED_MAHOGANY_BEAM_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.WILLOW_BEAM_VERTICAL_SLAB.get());

// LOG
            verticalHorizontalSlab(ModBlocks.ALMOND_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.APPLE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.ASPEN_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BANANA_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BAOBAB_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.BEECH_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CEDAR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CHARRED_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CHESTNUT_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.CYPRESS_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.DATE_PALM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.FIR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.GREEN_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.HOLLY_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.KUNTZ_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LAIRELOSSE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LARCH_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LEBETHRON_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LEMON_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.LIME_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MALLORN_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MANGO_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MAPLE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.MIRK_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.OLIVE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.ORANGE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PALM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PEAR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PINE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.PLUM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.POMEGRANATE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.REDWOOD_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.RED_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.RED_MAHOGANY_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.WILLOW_LOG_VERTICAL_SLAB.get());

// STRIPPED LOG
            verticalHorizontalSlab(ModBlocks.STRIPPED_ALMOND_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_APPLE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_ASPEN_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_BANANA_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_BAOBAB_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_BEECH_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_CEDAR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_CHARRED_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_CYPRESS_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_FIR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_HOLLY_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_KUNTZ_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_LARCH_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_LEMON_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_LIME_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_MALLORN_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_MANGO_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_MAPLE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_OLIVE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_ORANGE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_PALM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_PEAR_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_PINE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_PLUM_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_REDWOOD_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_RED_OAK_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB.get());
            verticalHorizontalSlab(ModBlocks.STRIPPED_WILLOW_LOG_VERTICAL_SLAB.get());

// WOOD
            wverticalHorizontalSlab(ModBlocks.ALMOND_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.APPLE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.ASPEN_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.BANANA_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.BAOBAB_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.BEECH_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.CHARRED_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.CEDAR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.CHESTNUT_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.CYPRESS_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.DATE_PALM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.FIR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.GREEN_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.HOLLY_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.KUNTZ_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.LAIRELOSSE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.LARCH_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.LEBETHRON_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.LEMON_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.LIME_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.MALLORN_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.MANGO_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.MAPLE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.MIRK_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.OLIVE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.ORANGE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.PALM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.PEAR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.PINE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.PLUM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.POMEGRANATE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.REDWOOD_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.RED_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.RED_MAHOGANY_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.WILLOW_WOOD_VERTICAL_SLAB.get());

// STRIPPED WOOD
            wverticalHorizontalSlab(ModBlocks.STRIPPED_ALMOND_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_APPLE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_ASPEN_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_BANANA_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_BEECH_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_CEDAR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_CHARRED_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_FIR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_HOLLY_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_LARCH_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_LEMON_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_LIME_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_MALLORN_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_MANGO_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_MAPLE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_OLIVE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_ORANGE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_PALM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_PEAR_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_PINE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_PLUM_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB.get());
            wverticalHorizontalSlab(ModBlocks.STRIPPED_WILLOW_WOOD_VERTICAL_SLAB.get());


            slabVanilla(ModBlocks.WHITE_WOOL_SLAB.get());
            slabVanilla(ModBlocks.ORANGE_WOOL_SLAB.get());
            slabVanilla(ModBlocks.MAGENTA_WOOL_SLAB.get());
            slabVanilla(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get());
            slabVanilla(ModBlocks.YELLOW_WOOL_SLAB.get());
            slabVanilla(ModBlocks.LIME_WOOL_SLAB.get());
            slabVanilla(ModBlocks.PINK_WOOL_SLAB.get());
            slabVanilla(ModBlocks.GRAY_WOOL_SLAB.get());
            slabVanilla(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get());
            slabVanilla(ModBlocks.CYAN_WOOL_SLAB.get());
            slabVanilla(ModBlocks.PURPLE_WOOL_SLAB.get());
            slabVanilla(ModBlocks.BLUE_WOOL_SLAB.get());
            slabVanilla(ModBlocks.BROWN_WOOL_SLAB.get());
            slabVanilla(ModBlocks.GREEN_WOOL_SLAB.get());
            slabVanilla(ModBlocks.RED_WOOL_SLAB.get());
            slabVanilla(ModBlocks.BLACK_WOOL_SLAB.get());

            verticalVanillaSlab(ModBlocks.WHITE_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.ORANGE_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.YELLOW_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.LIME_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.PINK_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.GRAY_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.CYAN_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.PURPLE_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.BLUE_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.BROWN_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.GREEN_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.RED_WOOL_VERTICAL_SLAB.get());
            verticalVanillaSlab(ModBlocks.BLACK_WOOL_VERTICAL_SLAB.get());

            stairsVanilla(ModBlocks.WHITE_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.ORANGE_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.MAGENTA_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.YELLOW_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.LIME_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.PINK_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.GRAY_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.CYAN_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.PURPLE_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.BLUE_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.BROWN_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.GREEN_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.RED_WOOL_STAIRS.get());
            stairsVanilla(ModBlocks.BLACK_WOOL_STAIRS.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_OAK_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.OAK_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.OAK_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.OAK_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.OAK_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.OAK_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.OAK_PLANKS_VERTICAL_SLAB.get());


            vanillaRotatedSlab(ModBlocks.STRIPPED_SPRUCE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_SPRUCE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.SPRUCE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.SPRUCE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.SPRUCE_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.SPRUCE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.SPRUCE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_BIRCH_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_BIRCH_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.BIRCH_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.BIRCH_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.BIRCH_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.BIRCH_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.BIRCH_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.BIRCH_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_JUNGLE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_JUNGLE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.JUNGLE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.JUNGLE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.JUNGLE_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.JUNGLE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.JUNGLE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_ACACIA_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_ACACIA_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.ACACIA_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.ACACIA_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.ACACIA_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.ACACIA_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.ACACIA_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.ACACIA_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_DARK_OAK_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.DARK_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.DARK_OAK_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.DARK_OAK_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_MANGROVE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_MANGROVE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.MANGROVE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.MANGROVE_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.MANGROVE_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.MANGROVE_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.MANGROVE_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.STRIPPED_CHERRY_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_CHERRY_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB.get());

            vanillaRotatedSlab(ModBlocks.CHERRY_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.CHERRY_LOG_STAIRS.get());
            verticalVanillaHorizontalSlab(ModBlocks.CHERRY_LOG_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB.get());

            wvanillaRotatedSlab(ModBlocks.CHERRY_WOOD_SLAB.get());
            wstairsVanillaRotated(ModBlocks.CHERRY_WOOD_STAIRS.get());
            wverticalVanillaHorizontalSlab(ModBlocks.CHERRY_WOOD_VERTICAL_SLAB.get());

            verticalVanillaSlab(ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB.get());
        }
        private void gate(Block block) {
            String name = name(block);

            // Определяем текстуры слоёв
            ResourceLocation baseTexture = blockTexture(block); // Фоновая текстура
            ResourceLocation edgeTexture = extend(baseTexture, "_edge"); // Рёбра
            ResourceLocation cornerTexture = extend(baseTexture, "_corner"); // Углы

            // Создаём модель с 3 слоями, накладывающимися друг на друга
            ModelFile multiLayerModel = models().getBuilder(name)
                    .parent(models().getExistingFile(mcLoc("block/block")))
                    .texture("base", baseTexture)
                    .texture("edge", edgeTexture)
                    .texture("corner", cornerTexture)

                    // Первый слой (основная текстура)
                    .element()
                    .from(0, 0, 0).to(16, 16, 16)
                    .allFaces((face, builder) -> builder.texture("#base").tintindex(0)) // Добавление прозрачности
                    .end()

                    // Второй слой (рёбра) - прозрачный, накладывается поверх первого
                    .element()
                    .from(0, 0, 0).to(16, 16, 16)
                    .allFaces((face, builder) -> builder.texture("#edge").tintindex(1))
                    .end()

                    // Третий слой (углы) - прозрачный, накладывается поверх второго
                    .element()
                    .from(0, 0, 0).to(16, 16, 16)
                    .allFaces((face, builder) -> builder.texture("#corner").tintindex(2))
                    .end()

                    // Указываем RenderType
                    .renderType("cutout");

            // Добавляем модель в блок
            simpleBlock(block, multiLayerModel);
            simpleBlockItem(block, multiLayerModel);
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
        public void wallRotated(Block block) {
            wallBlock((WallBlock) block, models().wallPost(name(block) + "_post", change(block, "_wall", "_side")),
                    models().wallSide(name(block) + "_side", change(block, "_wall", "_side")),
                    models().wallSideTall(name(block) + "_side_tall", change(block, "_wall", "_side")));
        }
        private void slab(Block block){
            slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""));
            blockItem(block);
        }
        private void slabVanilla(Block block) {
            // Определяем текстуру для ванильных блоков с префиксом `minecraft:`
            ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("_slab", ""));
            slabBlock((SlabBlock) block, textureLocation, textureLocation);
            blockItem(block);
        }



        private void rotatedSlab(Block block){
            slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
            blockItem(block);
        }
        private void vanillaRotatedSlab(Block block){
            ResourceLocation side = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("_slab", ""));
            ResourceLocation end = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("slab", "top"));
            slabBlock((SlabBlock) block, side, side, end, end);
            blockItem(block);
        }
        private void wrotatedSlab(Block block){
            slabBlock((SlabBlock) block, change(block, "wood_slab", "log"), change(block, "wood_slab", "log"));
            blockItem(block);
        }
        private void wvanillaRotatedSlab(Block block){
            ResourceLocation side = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("wood_slab", "log"));
            slabBlock((SlabBlock) block, side, side);
            blockItem(block);
        }
        private void smoothSlab(Block block){
            slabBlock(
                    (SlabBlock) block,
                    models().slab(name(block), change(block, "_slab", "_side"), change(block, "_slab", ""), change(block, "_slab", "")), // нижняя часть
                    models().slabTop(name(block) + "_top", change(block, "_slab", "_side"), change(block, "_slab", ""), change(block, "_slab", "")), // верхняя часть
                    models().cubeColumn(name(block) + "_double", change(block, "_slab", "_side"), change(block, "_slab", "")) // двойной полублок
            );
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
        public void woodenPressurePlate(Block block) {
            ModelFile pressurePlate = models().pressurePlate(name(block), change(block, "pressure_plate", "planks"));
            ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", change(block, "pressure_plate", "planks"));
            pressurePlateBlock(((PressurePlateBlock) block), pressurePlate, pressurePlateDown);
            blockItem(block);
        }
        public void woodenButton(Block block) {
            ModelFile button = models().button(name(block), change(block, "button", "planks"));
            ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", change(block, "button", "planks"));
            buttonBlock((ButtonBlock) block, button, buttonPressed);
        } public void fence(Block block) {
            fourWayBlock((FenceBlock)block,
                    models().fencePost(key(block) + "_post", change(block, "fence", "planks")),
                    models().fenceSide(key(block) + "_side", change(block, "fence", "planks")));
        }
    
        private void fenceGate(Block block) {
            ModelFile gate = models().fenceGate(name(block), change(block, "fence_gate", "planks"));
            ModelFile gateOpen = models().fenceGateOpen(key(block) + "_open", change(block, "fence_gate", "planks"));
            ModelFile gateWall = models().fenceGateWall(key(block) + "_wall", change(block, "fence_gate", "planks"));
            ModelFile gateWallOpen = models().fenceGateWallOpen(key(block) + "_wall_open", change(block, "fence_gate", "planks"));
            fenceGateBlock((FenceGateBlock) block, gate, gateOpen, gateWall, gateWallOpen);
            blockItem(block);
        }
    
        private void wood(Block block) {
            axisBlock((RotatedPillarBlock) block, change(block, "_wood", "_log"), change(block, "_wood", "_log"));
                       blockItem(block);
        }
        public void door(Block block){
            doorBlockWithRenderType((DoorBlock) block, extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top"), "cutout");
        }
        public void trapdoor(Block block){
            trapdoorBlockWithRenderType((TrapDoorBlock) block, blockTexture(block), true, "cutout");
            blockItem(block, "_bottom");
        }
        public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
            ModelFile sign = models().sign(name(signBlock), texture);
            hangingSignBlock(signBlock, wallSignBlock, sign);
        }
        public void log(Block block) {
            axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
            blockItem(block);
        }

        private ConfiguredModel[] states(BlockState state, Block block) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().singleTexture(name(block) + "_stage" + state.getValue(((ModFruitLeaves) block).getAgeProperty()),ResourceLocation.withDefaultNamespace("block/leaves"),
                    "all", extend(blockTexture(block), "_stage" + state.getValue(((ModFruitLeaves) block).getAgeProperty()))).renderType("cutout"));
            return models;
        }
        public void fruitLeaves(Block modFruitLeaves) {
            Function<BlockState, ConfiguredModel[]> function = state -> states(state, modFruitLeaves);
            getVariantBuilder(modFruitLeaves).forAllStates(function);
            simpleBlockItem(modFruitLeaves, new ModelFile.UncheckedModelFile("bfme:block/" + name(modFruitLeaves) + "_stage0"));
        }
        private void leaves(Block block) {
            simpleBlockWithItem(block,
                    models().singleTexture(name(block), ResourceLocation.withDefaultNamespace("block/leaves"),
                            "all", blockTexture(block)).renderType("cutout"));
        }
        private void sapling(Block block) {
            simpleBlock(block,
                    models().cross(name(block), blockTexture(block)).renderType("cutout"));
        }
    
        private void glass(Block block) {
            simpleBlockWithItem(block, models().cubeAll(name(block), blockTexture(block)).renderType("translucent"));
        }
        public void bar(Block block){
            paneBlockWithRenderType((IronBarsBlock) block, blockTexture(block), blockTexture(block), "cutout");
        }
        public void paneBlock(Block block) {
            paneBlockWithRenderType((IronBarsBlock) block, change(block, "_pane", ""),  ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID ,"block/glass_pane_top"), "translucent");
    
    //        simpleBlockItem(block, models().pane(name(block), change(block, "_pane", ""), change(block, "_pane", "")).renderType("translucent"));
        }
        public void chair(Block block){
            horizontalBlock(block, new ModelFile.UncheckedModelFile(modLoc("block/woodchair")));
            blockTexture(block);
        }
        public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
            simpleBlock(signBlock, sign);
            simpleBlock(wallSignBlock, sign);
        }
        public void pillar(Block block) {
            axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
            blockItem(block);
        }
        private void pillarSlab(Block block){
            slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
            blockItem(block);
        }
        private void pillarExtendSlab(Block block){
            slabBlock((SlabBlock) block, change(block, "slab", "single"), change(block, "slab", "single"), change(block, "_slab", "_end"), change(block, "_slab", "_end"));
            blockItem(block);
        }
        public void stairs(Block block) {
            stairsBlock((StairBlock) block, change(block, "_stairs", ""));
            blockItem(block);
        }
        public void stairsRotated(Block block) {
            stairsBlock((StairBlock) block, change(block, "_stairs", ""), change(block, "_stairs", "_end"), change(block, "_stairs", "_end"));
            blockItem(block);
        }
        public void wstairsRotated(Block block) {
            stairsBlock((StairBlock) block, change(block, "wood_stairs", "log"));
            blockItem(block);
        }

        private void stairsVanilla(Block block) {

            ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("_stairs", ""));
            stairsBlock((StairBlock) block, textureLocation);
            blockItem(block);
        }
        public void stairsVanillaRotated(Block block) {
            ResourceLocation side = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("_stairs", ""));
            ResourceLocation end = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("stairs", "top"));
            stairsBlock((StairBlock) block, side, end, end);
            blockItem(block);
        }
        public void wstairsVanillaRotated(Block block) {
            ResourceLocation side = ResourceLocation.fromNamespaceAndPath(
                    "minecraft", "block/" + name(block).replaceAll("wood_stairs", "log"));

            stairsBlock((StairBlock) block, side);
            blockItem(block);
        }
        private void workbench(Block block){
                ResourceLocation side = extend(blockTexture(block), "_side");
                ResourceLocation top = extend(blockTexture(block), "_top");
    
                BlockModelBuilder model = models().cube(name(block), change(block, "crafting_table", "stone"), top, side, side, side, side);
            simpleBlockWithItem(block, model);
            }

        private void privateBlock(Block block){
            BlockModelBuilder model = models().cube(name(block), ResourceLocation.withDefaultNamespace("block/deepslate"),
                    change(block, "_block", "_top"),
                    change(block,"_block", "_side_north"),
                    change(block,"_block", "_side_south"),
                    change(block,"_block", "_side_east"),
                    change(block,"_block", "_side_west"));
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

        private void verticalVanillaSlab(Block block) {
            createVanillaVerticalSlabModels(block);

            // Register block state and model
            getVariantBuilder(block).forAllStates(state -> {
                VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                ResourceLocation modelLocation = getVanillaModelLocation(type, block);
                return ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modelLocation))
                        .build();
            });
            verticalBlockItem(block);
        }

        private void verticalHorizontalSlab(Block block) {
            createVerticaHorizontalSlabModels(block);

            getVariantBuilder(block).forAllStates(state -> {
                VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                ResourceLocation modelLocation = getHorizontalModelLocation(type, direction, block);

                return ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modelLocation))
                        .build();
            });

            // Генерация предметной модели
            verticalBlockItem(block);
        }
        private void verticalVanillaHorizontalSlab(Block block) {
            createVanillaVerticalHorizontalSlabModels(block);

            getVariantBuilder(block).forAllStates(state -> {
                VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                ResourceLocation modelLocation = getHorizontalModelLocation(type, direction, block);

                return ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modelLocation))
                        .build();
            });

            // Генерация предметной модели
            verticalBlockItem(block);
        }
        private void wverticalHorizontalSlab(Block block) {
            wcreateVerticaHorizontalSlabModels(block);

            getVariantBuilder(block).forAllStates(state -> {
                VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                ResourceLocation modelLocation = getHorizontalModelLocation(type, direction, block);

                return ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modelLocation))
                        .build();
            });

            verticalBlockItem(block);
        }
        private void wverticalVanillaHorizontalSlab(Block block) {
            wcreateVanillaVerticalHorizontalSlabModels(block);

            getVariantBuilder(block).forAllStates(state -> {
                VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                ResourceLocation modelLocation = getHorizontalModelLocation(type, direction, block);

                return ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modelLocation))
                        .build();
            });

            verticalBlockItem(block);
        }


        private void createVerticalSlabModels(Block block) {
            ResourceLocation texture = change(block, "_vertical_slab", "");;

            createVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north"), texture);
            createVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south"), texture);
            createVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west"), texture);
            createVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east"), texture);
        }

        private void createVanillaVerticalSlabModels(Block block) {
            ResourceLocation texture = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name(block).replaceAll("_vertical_slab", ""));

            createVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north"), texture);
            createVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south"), texture);
            createVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west"), texture);
            createVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east"), texture);
        }

        private void createVanillaVerticalHorizontalSlabModels(Block block) {
            ResourceLocation sideTexture = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name(block).replaceAll("_vertical_slab", ""));
            ResourceLocation endTexture = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name(block).replaceAll("_vertical_slab", "_top")); // Текстура торца

            createHorizontalVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_westeast", resource("block/vertical_slab_westeast"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_northsouth", resource("block/vertical_slab_northsouth"), sideTexture, endTexture);
        }
        private void wcreateVanillaVerticalHorizontalSlabModels(Block block) {
            ResourceLocation sideTexture = ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + name(block).replaceAll("wood_vertical_slab", "log"));

            createHorizontalVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_westeast", resource("block/vertical_slab_westeast"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_northsouth", resource("block/vertical_slab_northsouth"), sideTexture, sideTexture);
        }



        private void createVerticaHorizontalSlabModels(Block block) {
            ResourceLocation sideTexture = change(block, "_vertical_slab", ""); // Текстура боковой поверхности
            ResourceLocation endTexture = change(block, "_vertical_slab", "_end"); // Текстура торца

            createHorizontalVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east_horizontal"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_westeast", resource("block/vertical_slab_westeast"), sideTexture, endTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_northsouth", resource("block/vertical_slab_northsouth"), sideTexture, endTexture);
        }
        private void wcreateVerticaHorizontalSlabModels(Block block) {
            ResourceLocation sideTexture = change(block, "wood_vertical_slab", "log");

            createHorizontalVerticalSlabParentModel(name(block) + "_north", resource("block/vertical_slab_north_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_south", resource("block/vertical_slab_south_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_west", resource("block/vertical_slab_west_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_east", resource("block/vertical_slab_east_horizontal"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_westeast", resource("block/vertical_slab_westeast"), sideTexture, sideTexture);
            createHorizontalVerticalSlabParentModel(name(block) + "_northsouth", resource("block/vertical_slab_northsouth"), sideTexture, sideTexture);
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

        private ResourceLocation getVanillaModelLocation(VerticalSlabType type, Block block) {
            String baseTexturePath = "block/" + name(block).replaceAll("_vertical_slab", "");
            switch (type) {
                case SOUTH:
                    return extend(blockTexture(block), "_south");
                case WEST:
                    return extend(blockTexture(block), "_west");
                case EAST:
                    return extend(blockTexture(block), "_east");
                case DOUBLE:
                    return ResourceLocation.fromNamespaceAndPath("minecraft", baseTexturePath);
                case NORTH:
                default:
                    return extend(blockTexture(block), "_north");
                              }
        }

        private ResourceLocation getHorizontalModelLocation(VerticalSlabType type, Direction direction, Block block) {
            switch (type) {
                case SOUTH:
                    return extend(blockTexture(block), "_south");
                case WEST:
                    return extend(blockTexture(block), "_west");
                case EAST:
                    return extend(blockTexture(block), "_east");
                case DOUBLE:
                    return (direction == Direction.NORTH || direction == Direction.SOUTH)
                            ? extend(blockTexture(block), "_northsouth")
                            : extend(blockTexture(block), "_westeast");
                case NORTH:
                    default:
                    return extend(blockTexture(block), "_north");
            }
        }



        private void createVerticalSlabParentModel(String name, ResourceLocation parent, ResourceLocation texture) {
            BlockModelBuilder builder = models().withExistingParent(name, parent);
            builder.texture("all", texture);
        }


        private void createHorizontalVerticalSlabParentModel(String name, ResourceLocation parent, ResourceLocation sideTexture, ResourceLocation endTexture) {
            BlockModelBuilder builder = models().withExistingParent(name, parent);
            builder.texture("side", sideTexture)
                    .texture("end", endTexture);
        }


        private void column(Block block) {
            createColumnModels(block);
            getVariantBuilder(block)
                    .partialState().with(TinyColumnBlock.PART, ColumnPart.SINGLE)
                    .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_single"))).addModel()
                    .partialState().with(TinyColumnBlock.PART, ColumnPart.BOTTOM)
                    .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_bottom"))).addModel()
                    .partialState().with(TinyColumnBlock.PART, ColumnPart.MIDDLE)
                    .modelForState().modelFile(models().getExistingFile(extend(blockTexture(block), "_middle"))).addModel()
                    .partialState().with(TinyColumnBlock.PART, ColumnPart.TOP)
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
                    .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
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

        private void pillarExtend(Block block) {
            createPillarModels(block);
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

        private void createPillarModels(Block block){
            ResourceLocation end = extend(blockTexture(block), "_end");
            ResourceLocation single = extend(blockTexture(block), "_single");
            ResourceLocation top = extend(blockTexture(block), "_top");
            ResourceLocation middle = extend(blockTexture(block), "_middle");
            ResourceLocation bottom = extend(blockTexture(block), "_bottom");
            BlockModelBuilder singleModel = models().cube(name(block) + "_single", end, end, single, single, single, single).texture("particle", blockTexture(block));
            BlockModelBuilder topModel = models().cube(name(block) + "_top", end, end, top, top, top, top).texture("particle", blockTexture(block));
            BlockModelBuilder middleModel = models().cube(name(block) + "_middle", end, end, middle, middle, middle, middle).texture("particle", blockTexture(block));
            BlockModelBuilder bottomModel = models().cube(name(block) + "_bottom", end, end, bottom, bottom, bottom, bottom).texture("particle", blockTexture(block));

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
            return ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID,"block/" +  key(block).getPath().replaceAll(replaced, replace));
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
