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

    import javax.annotation.Nullable;
    import java.util.List;
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
            slabSmooth(ModBlocks.GONDORIAN_SMOOTH_STONE_SLAB.get());
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
    
            column(ModBlocks.GONDORIAN_PILLAR.get());
            pillar(ModBlocks.GONDORIAN_MOSSY_PILLAR.get());
            verticalSlabHorizontal(ModBlocks.GONDORIAN_MOSSY_PILLAR_VERTICAL_SLAB.get());
            pillar(ModBlocks.GONDORIAN_CRACKED_PILLAR.get());
            tinyColumn(ModBlocks.GONDORIAN_COLUMN.get());
            tinyColumn(ModBlocks.GONDORIAN_MOSSY_COLUMN.get());
            tinyColumn(ModBlocks.GONDORIAN_CRACKED_COLUMN.get());
            slabPillarExtend(ModBlocks.GONDORIAN_PILLAR_SLAB.get());
            slabPillar(ModBlocks.GONDORIAN_MOSSY_PILLAR_SLAB.get());
            slabPillar(ModBlocks.GONDORIAN_CRACKED_PILLAR_SLAB.get());
    
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
            tinyColumn(ModBlocks.DURIN_COLUMN.get());
            tinyColumn(ModBlocks.DURIN_MOSSY_COLUMN.get());
            tinyColumn(ModBlocks.DURIN_CRACKED_COLUMN.get());
            slabPillar(ModBlocks.DURIN_PILLAR_SLAB.get());
            slabPillar(ModBlocks.DURIN_MOSSY_PILLAR_SLAB.get());
            slabPillar(ModBlocks.DURIN_CRACKED_PILLAR_SLAB.get());
    
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
    
            column(ModBlocks.ROHAN_PILLAR.get());
            pillar(ModBlocks.ROHAN_MOSSY_PILLAR.get());
            pillar(ModBlocks.ROHAN_CRACKED_PILLAR.get());
            tinyColumn(ModBlocks.ROHAN_COLUMN.get());
            tinyColumn(ModBlocks.ROHAN_MOSSY_COLUMN.get());
            tinyColumn(ModBlocks.ROHAN_CRACKED_COLUMN.get());
            slabPillarExtend(ModBlocks.ROHAN_PILLAR_SLAB.get());
            slabPillar(ModBlocks.ROHAN_MOSSY_PILLAR_SLAB.get());
            slabPillar(ModBlocks.ROHAN_CRACKED_PILLAR_SLAB.get());
    
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
            slabSmooth(ModBlocks.NUMENOREAN_SMOOTH_STONE_SLAB.get());
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
            tinyColumn(ModBlocks.NUMENOREAN_COLUMN.get());
            tinyColumn(ModBlocks.NUMENOREAN_MOSSY_COLUMN.get());
            tinyColumn(ModBlocks.NUMENOREAN_CRACKED_COLUMN.get());
            slabPillar(ModBlocks.NUMENOREAN_PILLAR_SLAB.get());
            slabPillar(ModBlocks.NUMENOREAN_MOSSY_PILLAR_SLAB.get());
            slabPillar(ModBlocks.NUMENOREAN_CRACKED_PILLAR_SLAB.get());
    
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
            slabRotated(ModBlocks.APPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.APPLE_LOG_STAIRS.get());
            log(ModBlocks.APPLE_BEAM.get());
            slabRotated(ModBlocks.APPLE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.APPLE_BEAM_STAIRS.get());
            wood(ModBlocks.APPLE_WOOD.get());
            slabWood(ModBlocks.APPLE_WOOD_SLAB.get());
            stairsWood(ModBlocks.APPLE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_APPLE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_APPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_APPLE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_APPLE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_APPLE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_APPLE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.APPLE_PLANKS.get());
            stairs(ModBlocks.APPLE_PLANKS_STAIRS.get());
            slab(ModBlocks.APPLE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.APPLE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.APPLE_BUTTON.get());
            fence(ModBlocks.APPLE_FENCE.get());
            fenceGate(ModBlocks.APPLE_FENCE_GATE.get());
            door(ModBlocks.APPLE_DOOR.get());
            trapdoor(ModBlocks.APPLE_TRAPDOOR.get());
            fruitLeaves(ModBlocks.APPLE_LEAVES.get());
            pressurePlateWooden(ModBlocks.APPLE_PRESSURE_PLATE.get());
            sapling(ModBlocks.APPLE_SAPLING.get());
            signBlock((StandingSignBlock) ModBlocks.APPLE_SIGN.get(), (WallSignBlock) ModBlocks.APPLE_WALL_SIGN.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            hangingSign(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.APPLE_PLANKS.get()));

            log(ModBlocks.PEAR_LOG.get());
            slabRotated(ModBlocks.PEAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.PEAR_LOG_STAIRS.get());
            log(ModBlocks.PEAR_BEAM.get());
            slabRotated(ModBlocks.PEAR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PEAR_BEAM_STAIRS.get());
            wood(ModBlocks.PEAR_WOOD.get());
            slabWood(ModBlocks.PEAR_WOOD_SLAB.get());
            stairsWood(ModBlocks.PEAR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PEAR_LOG.get());
            slabRotated(ModBlocks.STRIPPED_PEAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PEAR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PEAR_WOOD.get());
            slabWood(ModBlocks.STRIPPED_PEAR_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_PEAR_WOOD_STAIRS.get());

            blockWithItem(ModBlocks.PEAR_PLANKS.get());
            stairs(ModBlocks.PEAR_PLANKS_STAIRS.get());
            slab(ModBlocks.PEAR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PEAR_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.PEAR_BUTTON.get());
            fence(ModBlocks.PEAR_FENCE.get());
            fenceGate(ModBlocks.PEAR_FENCE_GATE.get());
            door(ModBlocks.PEAR_DOOR.get());
            trapdoor(ModBlocks.PEAR_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.PEAR_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.PEAR_LEAVES.get());
            sapling(ModBlocks.PEAR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PEAR_SIGN.get()), ((WallSignBlock) ModBlocks.PEAR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PEAR_PLANKS.get()));
            hangingSign(ModBlocks.PEAR_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PEAR_PLANKS.get()));
            log(ModBlocks.PLUM_LOG.get());
            slabRotated(ModBlocks.PLUM_LOG_SLAB.get());
            stairsRotated(ModBlocks.PLUM_LOG_STAIRS.get());
            log(ModBlocks.PLUM_BEAM.get());
            slabRotated(ModBlocks.PLUM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PLUM_BEAM_STAIRS.get());
            wood(ModBlocks.PLUM_WOOD.get());
            slabWood(ModBlocks.PLUM_WOOD_SLAB.get());
            stairsWood(ModBlocks.PLUM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PLUM_LOG.get());
            slabRotated(ModBlocks.STRIPPED_PLUM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PLUM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PLUM_WOOD.get());
            slabWood(ModBlocks.STRIPPED_PLUM_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_PLUM_WOOD_STAIRS.get());

            blockWithItem(ModBlocks.PLUM_PLANKS.get());
            stairs(ModBlocks.PLUM_PLANKS_STAIRS.get());
            slab(ModBlocks.PLUM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PLUM_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.PLUM_BUTTON.get());
            fence(ModBlocks.PLUM_FENCE.get());
            fenceGate(ModBlocks.PLUM_FENCE_GATE.get());
            door(ModBlocks.PLUM_DOOR.get());
            trapdoor(ModBlocks.PLUM_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.PLUM_PRESSURE_PLATE.get());
            sapling(ModBlocks.PLUM_SAPLING.get());
            fruitLeaves(ModBlocks.PLUM_LEAVES.get());
            signBlock(((StandingSignBlock) ModBlocks.PLUM_SIGN.get()), ((WallSignBlock) ModBlocks.PLUM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PLUM_PLANKS.get()));
            hangingSign(ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PLUM_PLANKS.get()));

            log(ModBlocks.MALLORN_LOG.get());
            slabRotated(ModBlocks.MALLORN_LOG_SLAB.get());
            stairsRotated(ModBlocks.MALLORN_LOG_STAIRS.get());
            log(ModBlocks.MALLORN_BEAM.get());
            slabRotated(ModBlocks.MALLORN_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MALLORN_BEAM_STAIRS.get());
            wood(ModBlocks.MALLORN_WOOD.get());
            slabWood(ModBlocks.MALLORN_WOOD_SLAB.get());
            stairsWood(ModBlocks.MALLORN_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MALLORN_LOG.get());
            slabRotated(ModBlocks.STRIPPED_MALLORN_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MALLORN_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MALLORN_WOOD.get());
            slabWood(ModBlocks.STRIPPED_MALLORN_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_MALLORN_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MALLORN_PLANKS.get());
            stairs(ModBlocks.MALLORN_PLANKS_STAIRS.get());
            slab(ModBlocks.MALLORN_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MALLORN_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.MALLORN_BUTTON.get());
            fence(ModBlocks.MALLORN_FENCE.get());
            fenceGate(ModBlocks.MALLORN_FENCE_GATE.get());
            door(ModBlocks.MALLORN_DOOR.get());
            trapdoor(ModBlocks.MALLORN_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.MALLORN_PRESSURE_PLATE.get());
            leaves(ModBlocks.MALLORN_LEAVES.get());
            sapling(ModBlocks.MALLORN_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MALLORN_SIGN.get()), ((WallSignBlock) ModBlocks.MALLORN_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MALLORN_PLANKS.get()));
            hangingSign(ModBlocks.MALLORN_HANGING_SIGN.get(), ModBlocks.MALLORN_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MALLORN_PLANKS.get()));

            log(ModBlocks.CHARRED_LOG.get());
            slabRotated(ModBlocks.CHARRED_LOG_SLAB.get());
            stairsRotated(ModBlocks.CHARRED_LOG_STAIRS.get());
            log(ModBlocks.CHARRED_BEAM.get());
            slabRotated(ModBlocks.CHARRED_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CHARRED_BEAM_STAIRS.get());
            wood(ModBlocks.CHARRED_WOOD.get());
            slabWood(ModBlocks.CHARRED_WOOD_SLAB.get());
            stairsWood(ModBlocks.CHARRED_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CHARRED_LOG.get());
            slabRotated(ModBlocks.STRIPPED_CHARRED_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CHARRED_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CHARRED_WOOD.get());
            slabWood(ModBlocks.STRIPPED_CHARRED_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_CHARRED_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CHARRED_PLANKS.get());
            stairs(ModBlocks.CHARRED_PLANKS_STAIRS.get());
            slab(ModBlocks.CHARRED_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CHARRED_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.CHARRED_BUTTON.get());
            fence(ModBlocks.CHARRED_FENCE.get());
            fenceGate(ModBlocks.CHARRED_FENCE_GATE.get());
            door(ModBlocks.CHARRED_DOOR.get());
            trapdoor(ModBlocks.CHARRED_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.CHARRED_PRESSURE_PLATE.get());
            signBlock(((StandingSignBlock) ModBlocks.CHARRED_SIGN.get()), ((WallSignBlock) ModBlocks.CHARRED_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CHARRED_PLANKS.get()));
            hangingSign(ModBlocks.CHARRED_HANGING_SIGN.get(), ModBlocks.CHARRED_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CHARRED_PLANKS.get()));

            log(ModBlocks.WILLOW_LOG.get());
            slabRotated(ModBlocks.WILLOW_LOG_SLAB.get());
            stairsRotated(ModBlocks.WILLOW_LOG_STAIRS.get());
            log(ModBlocks.WILLOW_BEAM.get());
            slabRotated(ModBlocks.WILLOW_BEAM_SLAB.get());
            stairsRotated(ModBlocks.WILLOW_BEAM_STAIRS.get());
            wood(ModBlocks.WILLOW_WOOD.get());
            slabWood(ModBlocks.WILLOW_WOOD_SLAB.get());
            stairsWood(ModBlocks.WILLOW_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_WILLOW_LOG.get());
            slabRotated(ModBlocks.STRIPPED_WILLOW_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_WILLOW_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_WILLOW_WOOD.get());
            slabWood(ModBlocks.STRIPPED_WILLOW_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_WILLOW_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.WILLOW_PLANKS.get());
            stairs(ModBlocks.WILLOW_PLANKS_STAIRS.get());
            slab(ModBlocks.WILLOW_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.WILLOW_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.WILLOW_BUTTON.get());
            fence(ModBlocks.WILLOW_FENCE.get());
            fenceGate(ModBlocks.WILLOW_FENCE_GATE.get());
            door(ModBlocks.WILLOW_DOOR.get());
            trapdoor(ModBlocks.WILLOW_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.WILLOW_PRESSURE_PLATE.get());
            leaves(ModBlocks.WILLOW_LEAVES.get());
            sapling(ModBlocks.WILLOW_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.WILLOW_SIGN.get()), ((WallSignBlock) ModBlocks.WILLOW_WALL_SIGN.get()),
                    blockTexture(ModBlocks.WILLOW_PLANKS.get()));
            hangingSign(ModBlocks.WILLOW_HANGING_SIGN.get(), ModBlocks.WILLOW_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.WILLOW_PLANKS.get()));

            log(ModBlocks.BEECH_LOG.get());
            slabRotated(ModBlocks.BEECH_LOG_SLAB.get());
            stairsRotated(ModBlocks.BEECH_LOG_STAIRS.get());
            log(ModBlocks.BEECH_BEAM.get());
            slabRotated(ModBlocks.BEECH_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BEECH_BEAM_STAIRS.get());
            wood(ModBlocks.BEECH_WOOD.get());
            slabWood(ModBlocks.BEECH_WOOD_SLAB.get());
            stairsWood(ModBlocks.BEECH_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BEECH_LOG.get());
            slabRotated(ModBlocks.STRIPPED_BEECH_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BEECH_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BEECH_WOOD.get());
            slabWood(ModBlocks.STRIPPED_BEECH_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_BEECH_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BEECH_PLANKS.get());
            stairs(ModBlocks.BEECH_PLANKS_STAIRS.get());
            slab(ModBlocks.BEECH_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BEECH_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.BEECH_BUTTON.get());
            fence(ModBlocks.BEECH_FENCE.get());
            fenceGate(ModBlocks.BEECH_FENCE_GATE.get());
            door(ModBlocks.BEECH_DOOR.get());
            trapdoor(ModBlocks.BEECH_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.BEECH_PRESSURE_PLATE.get());
            leaves(ModBlocks.BEECH_LEAVES.get());
            sapling(ModBlocks.BEECH_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BEECH_SIGN.get()), ((WallSignBlock) ModBlocks.BEECH_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BEECH_PLANKS.get()));
            hangingSign(ModBlocks.BEECH_HANGING_SIGN.get(), ModBlocks.BEECH_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BEECH_PLANKS.get()));

            log(ModBlocks.BAOBAB_LOG.get());
            slabRotated(ModBlocks.BAOBAB_LOG_SLAB.get());
            stairsRotated(ModBlocks.BAOBAB_LOG_STAIRS.get());
            log(ModBlocks.BAOBAB_BEAM.get());
            slabRotated(ModBlocks.BAOBAB_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BAOBAB_BEAM_STAIRS.get());
            wood(ModBlocks.BAOBAB_WOOD.get());
            slabWood(ModBlocks.BAOBAB_WOOD_SLAB.get());
            stairsWood(ModBlocks.BAOBAB_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BAOBAB_LOG.get());
            slabRotated(ModBlocks.STRIPPED_BAOBAB_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BAOBAB_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
            slabWood(ModBlocks.STRIPPED_BAOBAB_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_BAOBAB_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BAOBAB_PLANKS.get());
            stairs(ModBlocks.BAOBAB_PLANKS_STAIRS.get());
            slab(ModBlocks.BAOBAB_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BAOBAB_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.BAOBAB_BUTTON.get());
            fence(ModBlocks.BAOBAB_FENCE.get());
            fenceGate(ModBlocks.BAOBAB_FENCE_GATE.get());
            door(ModBlocks.BAOBAB_DOOR.get());
            trapdoor(ModBlocks.BAOBAB_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
            leaves(ModBlocks.BAOBAB_LEAVES.get());
            sapling(ModBlocks.BAOBAB_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BAOBAB_SIGN.get()), ((WallSignBlock) ModBlocks.BAOBAB_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
            hangingSign(ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BAOBAB_PLANKS.get()));

            log(ModBlocks.PINE_LOG.get());
            slabRotated(ModBlocks.PINE_LOG_SLAB.get());
            stairsRotated(ModBlocks.PINE_LOG_STAIRS.get());
            log(ModBlocks.PINE_BEAM.get());
            slabRotated(ModBlocks.PINE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PINE_BEAM_STAIRS.get());
            wood(ModBlocks.PINE_WOOD.get());
            slabWood(ModBlocks.PINE_WOOD_SLAB.get());
            stairsWood(ModBlocks.PINE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PINE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_PINE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PINE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PINE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_PINE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_PINE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.PINE_PLANKS.get());
            stairs(ModBlocks.PINE_PLANKS_STAIRS.get());
            slab(ModBlocks.PINE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PINE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.PINE_BUTTON.get());
            fence(ModBlocks.PINE_FENCE.get());
            fenceGate(ModBlocks.PINE_FENCE_GATE.get());
            door(ModBlocks.PINE_DOOR.get());
            trapdoor(ModBlocks.PINE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.PINE_PRESSURE_PLATE.get());
            leaves(ModBlocks.PINE_LEAVES.get());
            sapling(ModBlocks.PINE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()), ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PINE_PLANKS.get()));
            hangingSign(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PINE_PLANKS.get()));

            log(ModBlocks.HOLLY_LOG.get());
            slabRotated(ModBlocks.HOLLY_LOG_SLAB.get());
            stairsRotated(ModBlocks.HOLLY_LOG_STAIRS.get());
            log(ModBlocks.HOLLY_BEAM.get());
            slabRotated(ModBlocks.HOLLY_BEAM_SLAB.get());
            stairsRotated(ModBlocks.HOLLY_BEAM_STAIRS.get());
            wood(ModBlocks.HOLLY_WOOD.get());
            slabWood(ModBlocks.HOLLY_WOOD_SLAB.get());
            stairsWood(ModBlocks.HOLLY_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_HOLLY_LOG.get());
            slabRotated(ModBlocks.STRIPPED_HOLLY_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_HOLLY_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_HOLLY_WOOD.get());
            slabWood(ModBlocks.STRIPPED_HOLLY_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_HOLLY_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.HOLLY_PLANKS.get());
            stairs(ModBlocks.HOLLY_PLANKS_STAIRS.get());
            slab(ModBlocks.HOLLY_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.HOLLY_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.HOLLY_BUTTON.get());
            fence(ModBlocks.HOLLY_FENCE.get());
            fenceGate(ModBlocks.HOLLY_FENCE_GATE.get());
            door(ModBlocks.HOLLY_DOOR.get());
            trapdoor(ModBlocks.HOLLY_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.HOLLY_PRESSURE_PLATE.get());
            leaves(ModBlocks.HOLLY_LEAVES.get());
            sapling(ModBlocks.HOLLY_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.HOLLY_SIGN.get()), ((WallSignBlock) ModBlocks.HOLLY_WALL_SIGN.get()),
                    blockTexture(ModBlocks.HOLLY_PLANKS.get()));
            hangingSign(ModBlocks.HOLLY_HANGING_SIGN.get(), ModBlocks.HOLLY_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.HOLLY_PLANKS.get()));

            log(ModBlocks.GREEN_OAK_LOG.get());
            slabRotated(ModBlocks.GREEN_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.GREEN_OAK_LOG_STAIRS.get());
            log(ModBlocks.GREEN_OAK_BEAM.get());
            slabRotated(ModBlocks.GREEN_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.GREEN_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.GREEN_OAK_WOOD.get());
            slabWood(ModBlocks.GREEN_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.GREEN_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_GREEN_OAK_LOG.get());
            slabRotated(ModBlocks.STRIPPED_GREEN_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_GREEN_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_GREEN_OAK_WOOD.get());
            slabWood(ModBlocks.STRIPPED_GREEN_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_GREEN_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.GREEN_OAK_PLANKS.get());
            stairs(ModBlocks.GREEN_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.GREEN_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.GREEN_OAK_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.GREEN_OAK_BUTTON.get());
            fence(ModBlocks.GREEN_OAK_FENCE.get());
            fenceGate(ModBlocks.GREEN_OAK_FENCE_GATE.get());
            door(ModBlocks.GREEN_OAK_DOOR.get());
            trapdoor(ModBlocks.GREEN_OAK_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.GREEN_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.GREEN_OAK_LEAVES.get());
            sapling(ModBlocks.GREEN_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.GREEN_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.GREEN_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));
            hangingSign(ModBlocks.GREEN_OAK_HANGING_SIGN.get(), ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.GREEN_OAK_PLANKS.get()));

            log(ModBlocks.RED_OAK_LOG.get());
            slabRotated(ModBlocks.RED_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.RED_OAK_LOG_STAIRS.get());
            log(ModBlocks.RED_OAK_BEAM.get());
            slabRotated(ModBlocks.RED_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.RED_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.RED_OAK_WOOD.get());
            slabWood(ModBlocks.RED_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.RED_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_RED_OAK_LOG.get());
            slabRotated(ModBlocks.STRIPPED_RED_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_RED_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_RED_OAK_WOOD.get());
            slabWood(ModBlocks.STRIPPED_RED_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_RED_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.RED_OAK_PLANKS.get());
            stairs(ModBlocks.RED_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.RED_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.RED_OAK_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.RED_OAK_BUTTON.get());
            fence(ModBlocks.RED_OAK_FENCE.get());
            fenceGate(ModBlocks.RED_OAK_FENCE_GATE.get());
            door(ModBlocks.RED_OAK_DOOR.get());
            trapdoor(ModBlocks.RED_OAK_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.RED_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.RED_OAK_LEAVES.get());
            sapling(ModBlocks.RED_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.RED_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.RED_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.RED_OAK_PLANKS.get()));
            hangingSign(ModBlocks.RED_OAK_HANGING_SIGN.get(), ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.RED_OAK_PLANKS.get()));

            log(ModBlocks.MIRK_OAK_LOG.get());
            slabRotated(ModBlocks.MIRK_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.MIRK_OAK_LOG_STAIRS.get());
            log(ModBlocks.MIRK_OAK_BEAM.get());
            slabRotated(ModBlocks.MIRK_OAK_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MIRK_OAK_BEAM_STAIRS.get());
            wood(ModBlocks.MIRK_OAK_WOOD.get());
            slabWood(ModBlocks.MIRK_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.MIRK_OAK_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MIRK_OAK_LOG.get());
            slabRotated(ModBlocks.STRIPPED_MIRK_OAK_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MIRK_OAK_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MIRK_OAK_WOOD.get());
            slabWood(ModBlocks.STRIPPED_MIRK_OAK_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_MIRK_OAK_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MIRK_OAK_PLANKS.get());
            stairs(ModBlocks.MIRK_OAK_PLANKS_STAIRS.get());
            slab(ModBlocks.MIRK_OAK_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MIRK_OAK_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.MIRK_OAK_BUTTON.get());
            fence(ModBlocks.MIRK_OAK_FENCE.get());
            fenceGate(ModBlocks.MIRK_OAK_FENCE_GATE.get());
            door(ModBlocks.MIRK_OAK_DOOR.get());
            trapdoor(ModBlocks.MIRK_OAK_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.MIRK_OAK_PRESSURE_PLATE.get());
            leaves(ModBlocks.MIRK_OAK_LEAVES.get());
            sapling(ModBlocks.MIRK_OAK_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MIRK_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.MIRK_OAK_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));
            hangingSign(ModBlocks.MIRK_OAK_HANGING_SIGN.get(), ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MIRK_OAK_PLANKS.get()));

            log(ModBlocks.MAPLE_LOG.get());
            slabRotated(ModBlocks.MAPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.MAPLE_LOG_STAIRS.get());
            log(ModBlocks.MAPLE_BEAM.get());
            slabRotated(ModBlocks.MAPLE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MAPLE_BEAM_STAIRS.get());
            wood(ModBlocks.MAPLE_WOOD.get());
            slabWood(ModBlocks.MAPLE_WOOD_SLAB.get());
            stairsWood(ModBlocks.MAPLE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MAPLE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_MAPLE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MAPLE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MAPLE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_MAPLE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_MAPLE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MAPLE_PLANKS.get());
            stairs(ModBlocks.MAPLE_PLANKS_STAIRS.get());
            slab(ModBlocks.MAPLE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MAPLE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.MAPLE_BUTTON.get());
            fence(ModBlocks.MAPLE_FENCE.get());
            fenceGate(ModBlocks.MAPLE_FENCE_GATE.get());
            door(ModBlocks.MAPLE_DOOR.get());
            trapdoor(ModBlocks.MAPLE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.MAPLE_PRESSURE_PLATE.get());
            leaves(ModBlocks.MAPLE_LEAVES.get());
            sapling(ModBlocks.MAPLE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MAPLE_PLANKS.get()));
            hangingSign(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MAPLE_PLANKS.get()));

            log(ModBlocks.PALM_LOG.get());
            slabRotated(ModBlocks.PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.PALM_LOG_STAIRS.get());
            log(ModBlocks.PALM_BEAM.get());
            slabRotated(ModBlocks.PALM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.PALM_BEAM_STAIRS.get());
            wood(ModBlocks.PALM_WOOD.get());
            slabWood(ModBlocks.PALM_WOOD_SLAB.get());
            stairsWood(ModBlocks.PALM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_PALM_LOG.get());
            slabRotated(ModBlocks.STRIPPED_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_PALM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_PALM_WOOD.get());
            slabWood(ModBlocks.STRIPPED_PALM_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_PALM_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.PALM_PLANKS.get());
            stairs(ModBlocks.PALM_PLANKS_STAIRS.get());
            slab(ModBlocks.PALM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.PALM_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.PALM_BUTTON.get());
            fence(ModBlocks.PALM_FENCE.get());
            fenceGate(ModBlocks.PALM_FENCE_GATE.get());
            door(ModBlocks.PALM_DOOR.get());
            trapdoor(ModBlocks.PALM_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.PALM_PRESSURE_PLATE.get());
            leaves(ModBlocks.PALM_LEAVES.get());
            sapling(ModBlocks.PALM_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.PALM_SIGN.get()), ((WallSignBlock) ModBlocks.PALM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.PALM_PLANKS.get()));
            hangingSign(ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.PALM_PLANKS.get()));

            log(ModBlocks.CHESTNUT_LOG.get());
            slabRotated(ModBlocks.CHESTNUT_LOG_SLAB.get());
            stairsRotated(ModBlocks.CHESTNUT_LOG_STAIRS.get());
            log(ModBlocks.CHESTNUT_BEAM.get());
            slabRotated(ModBlocks.CHESTNUT_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CHESTNUT_BEAM_STAIRS.get());
            wood(ModBlocks.CHESTNUT_WOOD.get());
            slabWood(ModBlocks.CHESTNUT_WOOD_SLAB.get());
            stairsWood(ModBlocks.CHESTNUT_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CHESTNUT_LOG.get());
            slabRotated(ModBlocks.STRIPPED_CHESTNUT_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CHESTNUT_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CHESTNUT_WOOD.get());
            slabWood(ModBlocks.STRIPPED_CHESTNUT_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_CHESTNUT_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CHESTNUT_PLANKS.get());
            stairs(ModBlocks.CHESTNUT_PLANKS_STAIRS.get());
            slab(ModBlocks.CHESTNUT_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CHESTNUT_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.CHESTNUT_BUTTON.get());
            fence(ModBlocks.CHESTNUT_FENCE.get());
            fenceGate(ModBlocks.CHESTNUT_FENCE_GATE.get());
            door(ModBlocks.CHESTNUT_DOOR.get());
            trapdoor(ModBlocks.CHESTNUT_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.CHESTNUT_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.CHESTNUT_LEAVES.get());
            sapling(ModBlocks.CHESTNUT_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CHESTNUT_SIGN.get()), ((WallSignBlock) ModBlocks.CHESTNUT_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));
            hangingSign(ModBlocks.CHESTNUT_HANGING_SIGN.get(), ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CHESTNUT_PLANKS.get()));

            log(ModBlocks.ASPEN_LOG.get());
            slabRotated(ModBlocks.ASPEN_LOG_SLAB.get());
            stairsRotated(ModBlocks.ASPEN_LOG_STAIRS.get());
            log(ModBlocks.ASPEN_BEAM.get());
            slabRotated(ModBlocks.ASPEN_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ASPEN_BEAM_STAIRS.get());
            wood(ModBlocks.ASPEN_WOOD.get());
            slabWood(ModBlocks.ASPEN_WOOD_SLAB.get());
            stairsWood(ModBlocks.ASPEN_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ASPEN_LOG.get());
            slabRotated(ModBlocks.STRIPPED_ASPEN_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ASPEN_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ASPEN_WOOD.get());
            slabWood(ModBlocks.STRIPPED_ASPEN_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_ASPEN_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ASPEN_PLANKS.get());
            stairs(ModBlocks.ASPEN_PLANKS_STAIRS.get());
            slab(ModBlocks.ASPEN_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ASPEN_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.ASPEN_BUTTON.get());
            fence(ModBlocks.ASPEN_FENCE.get());
            fenceGate(ModBlocks.ASPEN_FENCE_GATE.get());
            door(ModBlocks.ASPEN_DOOR.get());
            trapdoor(ModBlocks.ASPEN_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.ASPEN_PRESSURE_PLATE.get());
            leaves(ModBlocks.ASPEN_LEAVES.get());
            sapling(ModBlocks.ASPEN_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ASPEN_SIGN.get()), ((WallSignBlock) ModBlocks.ASPEN_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ASPEN_PLANKS.get()));
            hangingSign(ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ASPEN_PLANKS.get()));

            log(ModBlocks.CEDAR_LOG.get());
            slabRotated(ModBlocks.CEDAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.CEDAR_LOG_STAIRS.get());
            log(ModBlocks.CEDAR_BEAM.get());
            slabRotated(ModBlocks.CEDAR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CEDAR_BEAM_STAIRS.get());
            wood(ModBlocks.CEDAR_WOOD.get());
            slabWood(ModBlocks.CEDAR_WOOD_SLAB.get());
            stairsWood(ModBlocks.CEDAR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CEDAR_LOG.get());
            slabRotated(ModBlocks.STRIPPED_CEDAR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CEDAR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CEDAR_WOOD.get());
            slabWood(ModBlocks.STRIPPED_CEDAR_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_CEDAR_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CEDAR_PLANKS.get());
            stairs(ModBlocks.CEDAR_PLANKS_STAIRS.get());
            slab(ModBlocks.CEDAR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CEDAR_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.CEDAR_BUTTON.get());
            fence(ModBlocks.CEDAR_FENCE.get());
            fenceGate(ModBlocks.CEDAR_FENCE_GATE.get());
            door(ModBlocks.CEDAR_DOOR.get());
            trapdoor(ModBlocks.CEDAR_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.CEDAR_PRESSURE_PLATE.get());
            leaves(ModBlocks.CEDAR_LEAVES.get());
            sapling(ModBlocks.CEDAR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CEDAR_SIGN.get()), ((WallSignBlock) ModBlocks.CEDAR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CEDAR_PLANKS.get()));
            hangingSign(ModBlocks.CEDAR_HANGING_SIGN.get(), ModBlocks.CEDAR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CEDAR_PLANKS.get()));

            log(ModBlocks.FIR_LOG.get());
            slabRotated(ModBlocks.FIR_LOG_SLAB.get());
            stairsRotated(ModBlocks.FIR_LOG_STAIRS.get());
            log(ModBlocks.FIR_BEAM.get());
            slabRotated(ModBlocks.FIR_BEAM_SLAB.get());
            stairsRotated(ModBlocks.FIR_BEAM_STAIRS.get());
            wood(ModBlocks.FIR_WOOD.get());
            slabWood(ModBlocks.FIR_WOOD_SLAB.get());
            stairsWood(ModBlocks.FIR_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_FIR_LOG.get());
            slabRotated(ModBlocks.STRIPPED_FIR_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_FIR_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_FIR_WOOD.get());
            slabWood(ModBlocks.STRIPPED_FIR_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_FIR_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.FIR_PLANKS.get());
            stairs(ModBlocks.FIR_PLANKS_STAIRS.get());
            slab(ModBlocks.FIR_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.FIR_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.FIR_BUTTON.get());
            fence(ModBlocks.FIR_FENCE.get());
            fenceGate(ModBlocks.FIR_FENCE_GATE.get());
            door(ModBlocks.FIR_DOOR.get());
            trapdoor(ModBlocks.FIR_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.FIR_PRESSURE_PLATE.get());
            leaves(ModBlocks.FIR_LEAVES.get());
            sapling(ModBlocks.FIR_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.FIR_SIGN.get()), ((WallSignBlock) ModBlocks.FIR_WALL_SIGN.get()),
                    blockTexture(ModBlocks.FIR_PLANKS.get()));
            hangingSign(ModBlocks.FIR_HANGING_SIGN.get(), ModBlocks.FIR_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.FIR_PLANKS.get()));

            log(ModBlocks.LARCH_LOG.get());
            slabRotated(ModBlocks.LARCH_LOG_SLAB.get());
            stairsRotated(ModBlocks.LARCH_LOG_STAIRS.get());
            log(ModBlocks.LARCH_BEAM.get());
            slabRotated(ModBlocks.LARCH_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LARCH_BEAM_STAIRS.get());
            wood(ModBlocks.LARCH_WOOD.get());
            slabWood(ModBlocks.LARCH_WOOD_SLAB.get());
            stairsWood(ModBlocks.LARCH_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LARCH_LOG.get());
            slabRotated(ModBlocks.STRIPPED_LARCH_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LARCH_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LARCH_WOOD.get());
            slabWood(ModBlocks.STRIPPED_LARCH_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_LARCH_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LARCH_PLANKS.get());
            stairs(ModBlocks.LARCH_PLANKS_STAIRS.get());
            slab(ModBlocks.LARCH_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LARCH_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.LARCH_BUTTON.get());
            fence(ModBlocks.LARCH_FENCE.get());
            fenceGate(ModBlocks.LARCH_FENCE_GATE.get());
            door(ModBlocks.LARCH_DOOR.get());
            trapdoor(ModBlocks.LARCH_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.LARCH_PRESSURE_PLATE.get());
            leaves(ModBlocks.LARCH_LEAVES.get());
            sapling(ModBlocks.LARCH_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LARCH_SIGN.get()), ((WallSignBlock) ModBlocks.LARCH_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LARCH_PLANKS.get()));
            hangingSign(ModBlocks.LARCH_HANGING_SIGN.get(), ModBlocks.LARCH_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LARCH_PLANKS.get()));

            log(ModBlocks.LAIRELOSSE_LOG.get());
            slabRotated(ModBlocks.LAIRELOSSE_LOG_SLAB.get());
            stairsRotated(ModBlocks.LAIRELOSSE_LOG_STAIRS.get());
            log(ModBlocks.LAIRELOSSE_BEAM.get());
            slabRotated(ModBlocks.LAIRELOSSE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LAIRELOSSE_BEAM_STAIRS.get());
            wood(ModBlocks.LAIRELOSSE_WOOD.get());
            slabWood(ModBlocks.LAIRELOSSE_WOOD_SLAB.get());
            stairsWood(ModBlocks.LAIRELOSSE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LAIRELOSSE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_LAIRELOSSE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LAIRELOSSE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LAIRELOSSE_PLANKS.get());
            stairs(ModBlocks.LAIRELOSSE_PLANKS_STAIRS.get());
            slab(ModBlocks.LAIRELOSSE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LAIRELOSSE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.LAIRELOSSE_BUTTON.get());
            fence(ModBlocks.LAIRELOSSE_FENCE.get());
            fenceGate(ModBlocks.LAIRELOSSE_FENCE_GATE.get());
            door(ModBlocks.LAIRELOSSE_DOOR.get());
            trapdoor(ModBlocks.LAIRELOSSE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.LAIRELOSSE_PRESSURE_PLATE.get());
            leaves(ModBlocks.LAIRELOSSE_LEAVES.get());
            sapling(ModBlocks.LAIRELOSSE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LAIRELOSSE_SIGN.get()), ((WallSignBlock) ModBlocks.LAIRELOSSE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));
            hangingSign(ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LAIRELOSSE_PLANKS.get()));

            log(ModBlocks.ALMOND_LOG.get());
            slabRotated(ModBlocks.ALMOND_LOG_SLAB.get());
            stairsRotated(ModBlocks.ALMOND_LOG_STAIRS.get());
            log(ModBlocks.ALMOND_BEAM.get());
            slabRotated(ModBlocks.ALMOND_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ALMOND_BEAM_STAIRS.get());
            wood(ModBlocks.ALMOND_WOOD.get());
            slabWood(ModBlocks.ALMOND_WOOD_SLAB.get());
            stairsWood(ModBlocks.ALMOND_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ALMOND_LOG.get());
            slabRotated(ModBlocks.STRIPPED_ALMOND_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ALMOND_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ALMOND_WOOD.get());
            slabWood(ModBlocks.STRIPPED_ALMOND_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_ALMOND_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ALMOND_PLANKS.get());
            stairs(ModBlocks.ALMOND_PLANKS_STAIRS.get());
            slab(ModBlocks.ALMOND_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ALMOND_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.ALMOND_BUTTON.get());
            fence(ModBlocks.ALMOND_FENCE.get());
            fenceGate(ModBlocks.ALMOND_FENCE_GATE.get());
            door(ModBlocks.ALMOND_DOOR.get());
            trapdoor(ModBlocks.ALMOND_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.ALMOND_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.ALMOND_LEAVES.get());
            sapling(ModBlocks.ALMOND_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ALMOND_SIGN.get()), ((WallSignBlock) ModBlocks.ALMOND_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ALMOND_PLANKS.get()));
            hangingSign(ModBlocks.ALMOND_HANGING_SIGN.get(), ModBlocks.ALMOND_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ALMOND_PLANKS.get()));

            log(ModBlocks.BANANA_LOG.get());
            slabRotated(ModBlocks.BANANA_LOG_SLAB.get());
            stairsRotated(ModBlocks.BANANA_LOG_STAIRS.get());
            log(ModBlocks.BANANA_BEAM.get());
            slabRotated(ModBlocks.BANANA_BEAM_SLAB.get());
            stairsRotated(ModBlocks.BANANA_BEAM_STAIRS.get());
            wood(ModBlocks.BANANA_WOOD.get());
            slabWood(ModBlocks.BANANA_WOOD_SLAB.get());
            stairsWood(ModBlocks.BANANA_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_BANANA_LOG.get());
            slabRotated(ModBlocks.STRIPPED_BANANA_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_BANANA_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_BANANA_WOOD.get());
            slabWood(ModBlocks.STRIPPED_BANANA_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_BANANA_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.BANANA_PLANKS.get());
            stairs(ModBlocks.BANANA_PLANKS_STAIRS.get());
            slab(ModBlocks.BANANA_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.BANANA_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.BANANA_BUTTON.get());
            fence(ModBlocks.BANANA_FENCE.get());
            fenceGate(ModBlocks.BANANA_FENCE_GATE.get());
            door(ModBlocks.BANANA_DOOR.get());
            trapdoor(ModBlocks.BANANA_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.BANANA_PRESSURE_PLATE.get());
            leaves(ModBlocks.BANANA_LEAVES.get());
            sapling(ModBlocks.BANANA_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.BANANA_SIGN.get()), ((WallSignBlock) ModBlocks.BANANA_WALL_SIGN.get()),
                    blockTexture(ModBlocks.BANANA_PLANKS.get()));
            hangingSign(ModBlocks.BANANA_HANGING_SIGN.get(), ModBlocks.BANANA_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.BANANA_PLANKS.get()));

            log(ModBlocks.CYPRESS_LOG.get());
            slabRotated(ModBlocks.CYPRESS_LOG_SLAB.get());
            stairsRotated(ModBlocks.CYPRESS_LOG_STAIRS.get());
            log(ModBlocks.CYPRESS_BEAM.get());
            slabRotated(ModBlocks.CYPRESS_BEAM_SLAB.get());
            stairsRotated(ModBlocks.CYPRESS_BEAM_STAIRS.get());
            wood(ModBlocks.CYPRESS_WOOD.get());
            slabWood(ModBlocks.CYPRESS_WOOD_SLAB.get());
            stairsWood(ModBlocks.CYPRESS_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_CYPRESS_LOG.get());
            slabRotated(ModBlocks.STRIPPED_CYPRESS_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_CYPRESS_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_CYPRESS_WOOD.get());
            slabWood(ModBlocks.STRIPPED_CYPRESS_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_CYPRESS_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.CYPRESS_PLANKS.get());
            stairs(ModBlocks.CYPRESS_PLANKS_STAIRS.get());
            slab(ModBlocks.CYPRESS_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.CYPRESS_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.CYPRESS_BUTTON.get());
            fence(ModBlocks.CYPRESS_FENCE.get());
            fenceGate(ModBlocks.CYPRESS_FENCE_GATE.get());
            door(ModBlocks.CYPRESS_DOOR.get());
            trapdoor(ModBlocks.CYPRESS_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.CYPRESS_PRESSURE_PLATE.get());
            leaves(ModBlocks.CYPRESS_LEAVES.get());
            sapling(ModBlocks.CYPRESS_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.CYPRESS_SIGN.get()), ((WallSignBlock) ModBlocks.CYPRESS_WALL_SIGN.get()),
                    blockTexture(ModBlocks.CYPRESS_PLANKS.get()));
            hangingSign(ModBlocks.CYPRESS_HANGING_SIGN.get(), ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.CYPRESS_PLANKS.get()));

            log(ModBlocks.DATE_PALM_LOG.get());
            slabRotated(ModBlocks.DATE_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.DATE_PALM_LOG_STAIRS.get());
            log(ModBlocks.DATE_PALM_BEAM.get());
            slabRotated(ModBlocks.DATE_PALM_BEAM_SLAB.get());
            stairsRotated(ModBlocks.DATE_PALM_BEAM_STAIRS.get());
            wood(ModBlocks.DATE_PALM_WOOD.get());
            slabWood(ModBlocks.DATE_PALM_WOOD_SLAB.get());
            stairsWood(ModBlocks.DATE_PALM_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_DATE_PALM_LOG.get());
            slabRotated(ModBlocks.STRIPPED_DATE_PALM_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_DATE_PALM_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_DATE_PALM_WOOD.get());
            slabWood(ModBlocks.STRIPPED_DATE_PALM_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_DATE_PALM_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.DATE_PALM_PLANKS.get());
            stairs(ModBlocks.DATE_PALM_PLANKS_STAIRS.get());
            slab(ModBlocks.DATE_PALM_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.DATE_PALM_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.DATE_PALM_BUTTON.get());
            fence(ModBlocks.DATE_PALM_FENCE.get());
            fenceGate(ModBlocks.DATE_PALM_FENCE_GATE.get());
            door(ModBlocks.DATE_PALM_DOOR.get());
            trapdoor(ModBlocks.DATE_PALM_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.DATE_PALM_PRESSURE_PLATE.get());
            leaves(ModBlocks.DATE_PALM_LEAVES.get());
            sapling(ModBlocks.DATE_PALM_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.DATE_PALM_SIGN.get()), ((WallSignBlock) ModBlocks.DATE_PALM_WALL_SIGN.get()),
                    blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));
            hangingSign(ModBlocks.DATE_PALM_HANGING_SIGN.get(), ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.DATE_PALM_PLANKS.get()));

            log(ModBlocks.KUNTZ_LOG.get());
            slabRotated(ModBlocks.KUNTZ_LOG_SLAB.get());
            stairsRotated(ModBlocks.KUNTZ_LOG_STAIRS.get());
            log(ModBlocks.KUNTZ_BEAM.get());
            slabRotated(ModBlocks.KUNTZ_BEAM_SLAB.get());
            stairsRotated(ModBlocks.KUNTZ_BEAM_STAIRS.get());
            wood(ModBlocks.KUNTZ_WOOD.get());
            slabWood(ModBlocks.KUNTZ_WOOD_SLAB.get());
            stairsWood(ModBlocks.KUNTZ_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_KUNTZ_LOG.get());
            slabRotated(ModBlocks.STRIPPED_KUNTZ_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_KUNTZ_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_KUNTZ_WOOD.get());
            slabWood(ModBlocks.STRIPPED_KUNTZ_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_KUNTZ_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.KUNTZ_PLANKS.get());
            stairs(ModBlocks.KUNTZ_PLANKS_STAIRS.get());
            slab(ModBlocks.KUNTZ_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.KUNTZ_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.KUNTZ_BUTTON.get());
            fence(ModBlocks.KUNTZ_FENCE.get());
            fenceGate(ModBlocks.KUNTZ_FENCE_GATE.get());
            door(ModBlocks.KUNTZ_DOOR.get());
            trapdoor(ModBlocks.KUNTZ_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.KUNTZ_PRESSURE_PLATE.get());
            leaves(ModBlocks.KUNTZ_LEAVES.get());
            sapling(ModBlocks.KUNTZ_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.KUNTZ_SIGN.get()), ((WallSignBlock) ModBlocks.KUNTZ_WALL_SIGN.get()),
                    blockTexture(ModBlocks.KUNTZ_PLANKS.get()));
            hangingSign(ModBlocks.KUNTZ_HANGING_SIGN.get(), ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.KUNTZ_PLANKS.get()));

            log(ModBlocks.LEBETHRON_LOG.get());
            slabRotated(ModBlocks.LEBETHRON_LOG_SLAB.get());
            stairsRotated(ModBlocks.LEBETHRON_LOG_STAIRS.get());
            log(ModBlocks.LEBETHRON_BEAM.get());
            slabRotated(ModBlocks.LEBETHRON_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LEBETHRON_BEAM_STAIRS.get());
            wood(ModBlocks.LEBETHRON_WOOD.get());
            slabWood(ModBlocks.LEBETHRON_WOOD_SLAB.get());
            stairsWood(ModBlocks.LEBETHRON_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LEBETHRON_LOG.get());
            slabRotated(ModBlocks.STRIPPED_LEBETHRON_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LEBETHRON_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LEBETHRON_WOOD.get());
            slabWood(ModBlocks.STRIPPED_LEBETHRON_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_LEBETHRON_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LEBETHRON_PLANKS.get());
            stairs(ModBlocks.LEBETHRON_PLANKS_STAIRS.get());
            slab(ModBlocks.LEBETHRON_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LEBETHRON_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.LEBETHRON_BUTTON.get());
            fence(ModBlocks.LEBETHRON_FENCE.get());
            fenceGate(ModBlocks.LEBETHRON_FENCE_GATE.get());
            door(ModBlocks.LEBETHRON_DOOR.get());
            trapdoor(ModBlocks.LEBETHRON_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.LEBETHRON_PRESSURE_PLATE.get());
            leaves(ModBlocks.LEBETHRON_LEAVES.get());
            sapling(ModBlocks.LEBETHRON_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LEBETHRON_SIGN.get()), ((WallSignBlock) ModBlocks.LEBETHRON_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));
            hangingSign(ModBlocks.LEBETHRON_HANGING_SIGN.get(), ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LEBETHRON_PLANKS.get()));

            log(ModBlocks.LEMON_LOG.get());
            slabRotated(ModBlocks.LEMON_LOG_SLAB.get());
            stairsRotated(ModBlocks.LEMON_LOG_STAIRS.get());
            log(ModBlocks.LEMON_BEAM.get());
            slabRotated(ModBlocks.LEMON_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LEMON_BEAM_STAIRS.get());
            wood(ModBlocks.LEMON_WOOD.get());
            slabWood(ModBlocks.LEMON_WOOD_SLAB.get());
            stairsWood(ModBlocks.LEMON_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LEMON_LOG.get());
            slabRotated(ModBlocks.STRIPPED_LEMON_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LEMON_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LEMON_WOOD.get());
            slabWood(ModBlocks.STRIPPED_LEMON_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_LEMON_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LEMON_PLANKS.get());
            stairs(ModBlocks.LEMON_PLANKS_STAIRS.get());
            slab(ModBlocks.LEMON_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LEMON_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.LEMON_BUTTON.get());
            fence(ModBlocks.LEMON_FENCE.get());
            fenceGate(ModBlocks.LEMON_FENCE_GATE.get());
            door(ModBlocks.LEMON_DOOR.get());
            trapdoor(ModBlocks.LEMON_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.LEMON_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.LEMON_LEAVES.get());
            sapling(ModBlocks.LEMON_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LEMON_SIGN.get()), ((WallSignBlock) ModBlocks.LEMON_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));
            hangingSign(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));

            log(ModBlocks.LIME_LOG.get());
            slabRotated(ModBlocks.LIME_LOG_SLAB.get());
            stairsRotated(ModBlocks.LIME_LOG_STAIRS.get());
            log(ModBlocks.LIME_BEAM.get());
            slabRotated(ModBlocks.LIME_BEAM_SLAB.get());
            stairsRotated(ModBlocks.LIME_BEAM_STAIRS.get());
            wood(ModBlocks.LIME_WOOD.get());
            slabWood(ModBlocks.LIME_WOOD_SLAB.get());
            stairsWood(ModBlocks.LIME_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_LIME_LOG.get());
            slabRotated(ModBlocks.STRIPPED_LIME_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_LIME_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_LIME_WOOD.get());
            slabWood(ModBlocks.STRIPPED_LIME_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_LIME_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.LIME_PLANKS.get());
            stairs(ModBlocks.LIME_PLANKS_STAIRS.get());
            slab(ModBlocks.LIME_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.LIME_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.LIME_BUTTON.get());
            fence(ModBlocks.LIME_FENCE.get());
            fenceGate(ModBlocks.LIME_FENCE_GATE.get());
            door(ModBlocks.LIME_DOOR.get());
            trapdoor(ModBlocks.LIME_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.LIME_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.LIME_LEAVES.get());
            sapling(ModBlocks.LIME_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.LIME_SIGN.get()), ((WallSignBlock) ModBlocks.LIME_WALL_SIGN.get()),
                    blockTexture(ModBlocks.LIME_PLANKS.get()));
            hangingSign(ModBlocks.LIME_HANGING_SIGN.get(), ModBlocks.LIME_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LIME_PLANKS.get()));

            log(ModBlocks.MANGO_LOG.get());
            slabRotated(ModBlocks.MANGO_LOG_SLAB.get());
            stairsRotated(ModBlocks.MANGO_LOG_STAIRS.get());
            log(ModBlocks.MANGO_BEAM.get());
            slabRotated(ModBlocks.MANGO_BEAM_SLAB.get());
            stairsRotated(ModBlocks.MANGO_BEAM_STAIRS.get());
            wood(ModBlocks.MANGO_WOOD.get());
            slabWood(ModBlocks.MANGO_WOOD_SLAB.get());
            stairsWood(ModBlocks.MANGO_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_MANGO_LOG.get());
            slabRotated(ModBlocks.STRIPPED_MANGO_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_MANGO_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_MANGO_WOOD.get());
            slabWood(ModBlocks.STRIPPED_MANGO_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_MANGO_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.MANGO_PLANKS.get());
            stairs(ModBlocks.MANGO_PLANKS_STAIRS.get());
            slab(ModBlocks.MANGO_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.MANGO_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.MANGO_BUTTON.get());
            fence(ModBlocks.MANGO_FENCE.get());
            fenceGate(ModBlocks.MANGO_FENCE_GATE.get());
            door(ModBlocks.MANGO_DOOR.get());
            trapdoor(ModBlocks.MANGO_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.MANGO_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.MANGO_LEAVES.get());
            sapling(ModBlocks.MANGO_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.MANGO_SIGN.get()), ((WallSignBlock) ModBlocks.MANGO_WALL_SIGN.get()),
                    blockTexture(ModBlocks.MANGO_PLANKS.get()));
            hangingSign(ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.MANGO_PLANKS.get()));

            log(ModBlocks.ORANGE_LOG.get());
            slabRotated(ModBlocks.ORANGE_LOG_SLAB.get());
            stairsRotated(ModBlocks.ORANGE_LOG_STAIRS.get());
            log(ModBlocks.ORANGE_BEAM.get());
            slabRotated(ModBlocks.ORANGE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.ORANGE_BEAM_STAIRS.get());
            wood(ModBlocks.ORANGE_WOOD.get());
            slabWood(ModBlocks.ORANGE_WOOD_SLAB.get());
            stairsWood(ModBlocks.ORANGE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_ORANGE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_ORANGE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_ORANGE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_ORANGE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_ORANGE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_ORANGE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.ORANGE_PLANKS.get());
            stairs(ModBlocks.ORANGE_PLANKS_STAIRS.get());
            slab(ModBlocks.ORANGE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.ORANGE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.ORANGE_BUTTON.get());
            fence(ModBlocks.ORANGE_FENCE.get());
            fenceGate(ModBlocks.ORANGE_FENCE_GATE.get());
            door(ModBlocks.ORANGE_DOOR.get());
            trapdoor(ModBlocks.ORANGE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.ORANGE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.ORANGE_LEAVES.get());
            sapling(ModBlocks.ORANGE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.ORANGE_SIGN.get()), ((WallSignBlock) ModBlocks.ORANGE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));
            hangingSign(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            log(ModBlocks.POMEGRANATE_LOG.get());
            slabRotated(ModBlocks.POMEGRANATE_LOG_SLAB.get());
            stairsRotated(ModBlocks.POMEGRANATE_LOG_STAIRS.get());
            log(ModBlocks.POMEGRANATE_BEAM.get());
            slabRotated(ModBlocks.POMEGRANATE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.POMEGRANATE_BEAM_STAIRS.get());
            wood(ModBlocks.POMEGRANATE_WOOD.get());
            slabWood(ModBlocks.POMEGRANATE_WOOD_SLAB.get());
            stairsWood(ModBlocks.POMEGRANATE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_POMEGRANATE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_POMEGRANATE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_POMEGRANATE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_POMEGRANATE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_POMEGRANATE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_POMEGRANATE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.POMEGRANATE_PLANKS.get());
            stairs(ModBlocks.POMEGRANATE_PLANKS_STAIRS.get());
            slab(ModBlocks.POMEGRANATE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.POMEGRANATE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.POMEGRANATE_BUTTON.get());
            fence(ModBlocks.POMEGRANATE_FENCE.get());
            fenceGate(ModBlocks.POMEGRANATE_FENCE_GATE.get());
            door(ModBlocks.POMEGRANATE_DOOR.get());
            trapdoor(ModBlocks.POMEGRANATE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.POMEGRANATE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.POMEGRANATE_LEAVES.get());
            sapling(ModBlocks.POMEGRANATE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.POMEGRANATE_SIGN.get()), ((WallSignBlock) ModBlocks.POMEGRANATE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.POMEGRANATE_PLANKS.get()));
            hangingSign(ModBlocks.POMEGRANATE_HANGING_SIGN.get(), ModBlocks.POMEGRANATE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.POMEGRANATE_PLANKS.get()));

            log(ModBlocks.REDWOOD_LOG.get());
            slabRotated(ModBlocks.REDWOOD_LOG_SLAB.get());
            stairsRotated(ModBlocks.REDWOOD_LOG_STAIRS.get());
            log(ModBlocks.REDWOOD_BEAM.get());
            slabRotated(ModBlocks.REDWOOD_BEAM_SLAB.get());
            stairsRotated(ModBlocks.REDWOOD_BEAM_STAIRS.get());
            wood(ModBlocks.REDWOOD_WOOD.get());
            slabWood(ModBlocks.REDWOOD_WOOD_SLAB.get());
            stairsWood(ModBlocks.REDWOOD_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_REDWOOD_LOG.get());
            slabRotated(ModBlocks.STRIPPED_REDWOOD_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_REDWOOD_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
            slabWood(ModBlocks.STRIPPED_REDWOOD_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_REDWOOD_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.REDWOOD_PLANKS.get());
            stairs(ModBlocks.REDWOOD_PLANKS_STAIRS.get());
            slab(ModBlocks.REDWOOD_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.REDWOOD_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.REDWOOD_BUTTON.get());
            fence(ModBlocks.REDWOOD_FENCE.get());
            fenceGate(ModBlocks.REDWOOD_FENCE_GATE.get());
            door(ModBlocks.REDWOOD_DOOR.get());
            trapdoor(ModBlocks.REDWOOD_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
            leaves(ModBlocks.REDWOOD_LEAVES.get());
            sapling(ModBlocks.REDWOOD_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.REDWOOD_SIGN.get()), ((WallSignBlock) ModBlocks.REDWOOD_WALL_SIGN.get()),
                    blockTexture(ModBlocks.REDWOOD_PLANKS.get()));
            hangingSign(ModBlocks.REDWOOD_HANGING_SIGN.get(), ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.REDWOOD_PLANKS.get()));

            log(ModBlocks.RED_MAHOGANY_LOG.get());
            slabRotated(ModBlocks.RED_MAHOGANY_LOG_SLAB.get());
            stairsRotated(ModBlocks.RED_MAHOGANY_LOG_STAIRS.get());
            log(ModBlocks.RED_MAHOGANY_BEAM.get());
            slabRotated(ModBlocks.RED_MAHOGANY_BEAM_SLAB.get());
            stairsRotated(ModBlocks.RED_MAHOGANY_BEAM_STAIRS.get());
            wood(ModBlocks.RED_MAHOGANY_WOOD.get());
            slabWood(ModBlocks.RED_MAHOGANY_WOOD_SLAB.get());
            stairsWood(ModBlocks.RED_MAHOGANY_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_RED_MAHOGANY_LOG.get());
            slabRotated(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD.get());
            slabWood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.RED_MAHOGANY_PLANKS.get());
            stairs(ModBlocks.RED_MAHOGANY_PLANKS_STAIRS.get());
            slab(ModBlocks.RED_MAHOGANY_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.RED_MAHOGANY_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.RED_MAHOGANY_BUTTON.get());
            fence(ModBlocks.RED_MAHOGANY_FENCE.get());
            fenceGate(ModBlocks.RED_MAHOGANY_FENCE_GATE.get());
            door(ModBlocks.RED_MAHOGANY_DOOR.get());
            trapdoor(ModBlocks.RED_MAHOGANY_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.RED_MAHOGANY_PRESSURE_PLATE.get());
            leaves(ModBlocks.RED_MAHOGANY_LEAVES.get());
            sapling(ModBlocks.RED_MAHOGANY_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.RED_MAHOGANY_SIGN.get()), ((WallSignBlock) ModBlocks.RED_MAHOGANY_WALL_SIGN.get()),
                    blockTexture(ModBlocks.RED_MAHOGANY_PLANKS.get()));
            hangingSign(ModBlocks.RED_MAHOGANY_HANGING_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.RED_MAHOGANY_PLANKS.get()));

            log(ModBlocks.OLIVE_LOG.get());
            slabRotated(ModBlocks.OLIVE_LOG_SLAB.get());
            stairsRotated(ModBlocks.OLIVE_LOG_STAIRS.get());
            log(ModBlocks.OLIVE_BEAM.get());
            slabRotated(ModBlocks.OLIVE_BEAM_SLAB.get());
            stairsRotated(ModBlocks.OLIVE_BEAM_STAIRS.get());
            wood(ModBlocks.OLIVE_WOOD.get());
            slabWood(ModBlocks.OLIVE_WOOD_SLAB.get());
            stairsWood(ModBlocks.OLIVE_WOOD_STAIRS.get());
            log(ModBlocks.STRIPPED_OLIVE_LOG.get());
            slabRotated(ModBlocks.STRIPPED_OLIVE_LOG_SLAB.get());
            stairsRotated(ModBlocks.STRIPPED_OLIVE_LOG_STAIRS.get());
            wood(ModBlocks.STRIPPED_OLIVE_WOOD.get());
            slabWood(ModBlocks.STRIPPED_OLIVE_WOOD_SLAB.get());
            stairsWood(ModBlocks.STRIPPED_OLIVE_WOOD_STAIRS.get());
            blockWithItem(ModBlocks.OLIVE_PLANKS.get());
            stairs(ModBlocks.OLIVE_PLANKS_STAIRS.get());
            slab(ModBlocks.OLIVE_PLANKS_SLAB.get());
            verticalSlab(ModBlocks.OLIVE_PLANKS_VERTICAL_SLAB.get());
            buttonWooden(ModBlocks.OLIVE_BUTTON.get());
            fence(ModBlocks.OLIVE_FENCE.get());
            fenceGate(ModBlocks.OLIVE_FENCE_GATE.get());
            door(ModBlocks.OLIVE_DOOR.get());
            trapdoor(ModBlocks.OLIVE_TRAPDOOR.get());
            pressurePlateWooden(ModBlocks.OLIVE_PRESSURE_PLATE.get());
            fruitLeaves(ModBlocks.OLIVE_LEAVES.get());
            sapling(ModBlocks.OLIVE_SAPLING.get());
            signBlock(((StandingSignBlock) ModBlocks.OLIVE_SIGN.get()), ((WallSignBlock) ModBlocks.OLIVE_WALL_SIGN.get()),
                    blockTexture(ModBlocks.OLIVE_PLANKS.get()));
            hangingSign(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.OLIVE_PLANKS.get()));
    
    
            /* ORES */
            oreBlock(ModBlocks.AMBER_ORE.get());
            blockWithItem(ModBlocks.AMBER_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_AMBER_ORE.get());
            oreBlock(ModBlocks.AMETHYST_ORE.get());
            blockWithItem(ModBlocks.AMETHYST_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_AMETHYST_ORE.get());
            oreBlock(ModBlocks.DIAMOND_ORE.get());
            blockWithItem(ModBlocks.DIAMOND_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_DIAMOND_ORE.get());
            oreBlock(ModBlocks.EMERALD_ORE.get());
            blockWithItem(ModBlocks.EMERALD_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_EMERALD_ORE.get());
            oreBlock(ModBlocks.OPAL_ORE.get());
            blockWithItem(ModBlocks.OPAL_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_OPAL_ORE.get());
            oreBlock(ModBlocks.RUBY_ORE.get());
            blockWithItem(ModBlocks.RUBY_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_RUBY_ORE.get());
            oreBlock(ModBlocks.SAPPHIRE_ORE.get());
            blockWithItem(ModBlocks.SAPPHIRE_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
            oreBlock(ModBlocks.TOPAZ_ORE.get());
            blockWithItem(ModBlocks.TOPAZ_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
            oreBlock(ModBlocks.MITHRIL_ORE.get());
            blockWithItem(ModBlocks.MITHRIL_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
            oreBlock(ModBlocks.SILVER_ORE.get());
            blockWithItem(ModBlocks.SILVER_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_SILVER_ORE.get());
            oreBlock(ModBlocks.SALT_ORE.get());
            blockWithItem(ModBlocks.SALT_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_SALT_ORE.get());
            oreBlock(ModBlocks.SALTPETER_ORE.get());
            blockWithItem(ModBlocks.SALTPETER_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_SALTPETER_ORE.get());
            oreBlock(ModBlocks.SULFUR_ORE.get());
            blockWithItem(ModBlocks.SULFUR_BLOCK.get());
            oreBlock(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
            blockWithItem(ModBlocks.BRONZE_BLOCK.get());
            oreBlock(ModBlocks.GLOWSTONE_ORE.get());
            oreBlock(ModBlocks.DEEPSLATE_GLOWSTONE_ORE.get());
    
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
    
            pane(ModBlocks.GLASS_PANE.get());
            pane(ModBlocks.WHITE_STAINED_GLASS_PANE.get());
            pane(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
            pane(ModBlocks.MAGENTA_STAINED_GLASS_PANE.get());
            pane(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE.get());
            pane(ModBlocks.YELLOW_STAINED_GLASS_PANE.get());
            pane(ModBlocks.LIME_STAINED_GLASS_PANE.get());
            pane(ModBlocks.PINK_STAINED_GLASS_PANE.get());
            pane(ModBlocks.GRAY_STAINED_GLASS_PANE.get());
            pane(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE.get());
            pane(ModBlocks.CYAN_STAINED_GLASS_PANE.get());
            pane(ModBlocks.PURPLE_STAINED_GLASS_PANE.get());
            pane(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
            pane(ModBlocks.BROWN_STAINED_GLASS_PANE.get());
            pane(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
            pane(ModBlocks.RED_STAINED_GLASS_PANE.get());
            pane(ModBlocks.BLACK_STAINED_GLASS_PANE.get());
    
            bars(ModBlocks.GOLD_BARS.get());
            bars(ModBlocks.SILVER_BARS.get());
            bars(ModBlocks.REED_BARS.get());
    
            log(ModBlocks.THATCH_BLOCK.get());
            stairsRotated(ModBlocks.THATCH_BLOCK_STAIRS.get());
            slabRotated(ModBlocks.THATCH_BLOCK_SLAB.get());
            verticalSlabHorizontal(ModBlocks.THATCH_BLOCK_VERTICAL_SLAB.get());
            log(ModBlocks.THATCH_MUSTY_BLOCK.get());
            stairsRotated(ModBlocks.THATCH_MUSTY_BLOCK_STAIRS.get());
            slabRotated(ModBlocks.THATCH_MUSTY_BLOCK_SLAB.get());
            verticalSlabHorizontal(ModBlocks.THATCH_MUSTY_BLOCK_VERTICAL_SLAB.get());
            log(ModBlocks.REED_BLOCK.get());
            stairsRotated(ModBlocks.REED_BLOCK_STAIRS.get());
            slabRotated(ModBlocks.REED_BLOCK_SLAB.get());
            verticalSlabHorizontal(ModBlocks.REED_BLOCK_VERTICAL_SLAB.get());


            // BEAM
            verticalSlabHorizontal(ModBlocks.ALMOND_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.APPLE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.ASPEN_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BANANA_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BAOBAB_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BEECH_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CHARRED_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CEDAR_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CHESTNUT_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CYPRESS_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.DATE_PALM_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.FIR_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.GREEN_OAK_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.HOLLY_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.KUNTZ_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LAIRELOSSE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LARCH_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LEBETHRON_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LEMON_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LIME_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MALLORN_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MANGO_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MAPLE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MIRK_OAK_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.OLIVE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.ORANGE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PALM_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PEAR_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PINE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PLUM_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.POMEGRANATE_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.REDWOOD_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.RED_OAK_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.RED_MAHOGANY_BEAM_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.WILLOW_BEAM_VERTICAL_SLAB.get());

// LOG
            verticalSlabHorizontal(ModBlocks.ALMOND_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.APPLE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.ASPEN_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BANANA_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BAOBAB_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.BEECH_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CEDAR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CHARRED_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CHESTNUT_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.CYPRESS_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.DATE_PALM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.FIR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.GREEN_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.HOLLY_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.KUNTZ_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LAIRELOSSE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LARCH_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LEBETHRON_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LEMON_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.LIME_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MALLORN_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MANGO_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MAPLE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.MIRK_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.OLIVE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.ORANGE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PALM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PEAR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PINE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.PLUM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.POMEGRANATE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.REDWOOD_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.RED_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.RED_MAHOGANY_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.WILLOW_LOG_VERTICAL_SLAB.get());

// STRIPPED LOG
            verticalSlabHorizontal(ModBlocks.STRIPPED_ALMOND_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_APPLE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_ASPEN_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_BANANA_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_BAOBAB_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_BEECH_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_CEDAR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_CHARRED_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_CHESTNUT_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_CYPRESS_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_DATE_PALM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_FIR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_GREEN_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_HOLLY_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_KUNTZ_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_LAIRELOSSE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_LARCH_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_LEBETHRON_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_LEMON_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_LIME_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_MALLORN_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_MANGO_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_MAPLE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_MIRK_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_OLIVE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_ORANGE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_PALM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_PEAR_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_PINE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_PLUM_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_POMEGRANATE_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_REDWOOD_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_RED_OAK_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_RED_MAHOGANY_LOG_VERTICAL_SLAB.get());
            verticalSlabHorizontal(ModBlocks.STRIPPED_WILLOW_LOG_VERTICAL_SLAB.get());

// WOOD
            verticalSlabWood(ModBlocks.ALMOND_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.APPLE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.ASPEN_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.BANANA_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.BAOBAB_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.BEECH_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.CHARRED_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.CEDAR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.CHESTNUT_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.CYPRESS_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.DATE_PALM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.FIR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.GREEN_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.HOLLY_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.KUNTZ_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.LAIRELOSSE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.LARCH_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.LEBETHRON_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.LEMON_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.LIME_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.MALLORN_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.MANGO_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.MAPLE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.MIRK_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.OLIVE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.ORANGE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.PALM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.PEAR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.PINE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.PLUM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.POMEGRANATE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.REDWOOD_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.RED_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.RED_MAHOGANY_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.WILLOW_WOOD_VERTICAL_SLAB.get());

// STRIPPED WOOD
            verticalSlabWood(ModBlocks.STRIPPED_ALMOND_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_APPLE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_ASPEN_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_BANANA_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_BAOBAB_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_BEECH_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_CEDAR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_CHARRED_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_CHESTNUT_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_CYPRESS_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_DATE_PALM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_FIR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_GREEN_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_HOLLY_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_KUNTZ_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_LAIRELOSSE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_LARCH_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_LEBETHRON_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_LEMON_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_LIME_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_MALLORN_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_MANGO_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_MAPLE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_MIRK_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_OLIVE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_ORANGE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_PALM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_PEAR_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_PINE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_PLUM_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_POMEGRANATE_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_REDWOOD_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_RED_OAK_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_RED_MAHOGANY_WOOD_VERTICAL_SLAB.get());
            verticalSlabWood(ModBlocks.STRIPPED_WILLOW_WOOD_VERTICAL_SLAB.get());


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

            verticalSlabVanilla(ModBlocks.WHITE_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.ORANGE_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.YELLOW_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.LIME_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.PINK_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.GRAY_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.CYAN_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.PURPLE_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.BLUE_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.BROWN_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.GREEN_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.RED_WOOL_VERTICAL_SLAB.get());
            verticalSlabVanilla(ModBlocks.BLACK_WOOL_VERTICAL_SLAB.get());

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

            slabVanillaRotated(ModBlocks.STRIPPED_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_OAK_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_OAK_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.OAK_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.OAK_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_OAK_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_OAK_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_OAK_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.OAK_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.OAK_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.OAK_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.OAK_PLANKS_VERTICAL_SLAB.get());


            slabVanillaRotated(ModBlocks.STRIPPED_SPRUCE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_SPRUCE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_SPRUCE_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.SPRUCE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.SPRUCE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.SPRUCE_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_SPRUCE_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.SPRUCE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.SPRUCE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.SPRUCE_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.SPRUCE_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_BIRCH_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_BIRCH_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_BIRCH_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.BIRCH_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.BIRCH_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.BIRCH_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_BIRCH_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.BIRCH_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.BIRCH_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.BIRCH_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.BIRCH_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_JUNGLE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_JUNGLE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_JUNGLE_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.JUNGLE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.JUNGLE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.JUNGLE_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_JUNGLE_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.JUNGLE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.JUNGLE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.JUNGLE_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.JUNGLE_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_ACACIA_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_ACACIA_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_ACACIA_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.ACACIA_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.ACACIA_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.ACACIA_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_ACACIA_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.ACACIA_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.ACACIA_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.ACACIA_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.ACACIA_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_DARK_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_DARK_OAK_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_DARK_OAK_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.DARK_OAK_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.DARK_OAK_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.DARK_OAK_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_DARK_OAK_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.DARK_OAK_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.DARK_OAK_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.DARK_OAK_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_MANGROVE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_MANGROVE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_MANGROVE_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.MANGROVE_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.MANGROVE_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.MANGROVE_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_MANGROVE_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.MANGROVE_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.MANGROVE_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.MANGROVE_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.MANGROVE_PLANKS_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.STRIPPED_CHERRY_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.STRIPPED_CHERRY_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.STRIPPED_CHERRY_LOG_VERTICAL_SLAB.get());

            slabVanillaRotated(ModBlocks.CHERRY_LOG_SLAB.get());
            stairsVanillaRotated(ModBlocks.CHERRY_LOG_STAIRS.get());
            verticalSlabHorizontalVanilla(ModBlocks.CHERRY_LOG_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.STRIPPED_CHERRY_WOOD_VERTICAL_SLAB.get());

            slabWoodVanilla(ModBlocks.CHERRY_WOOD_SLAB.get());
            stairsWoodVanilla(ModBlocks.CHERRY_WOOD_STAIRS.get());
            verticalSlabWoodVanilla(ModBlocks.CHERRY_WOOD_VERTICAL_SLAB.get());

            verticalSlabVanilla(ModBlocks.CHERRY_PLANKS_VERTICAL_SLAB.get());

            // White limestone
            blockWithItem(ModBlocks.WHITE_LIMESTONE.get());
            blockWithItem(ModBlocks.WHITE_LIMESTONE_BRICKS.get());
            blockWithItem(ModBlocks.WHITE_LIMESTONE_BRICKWORK.get());
            blockWithItem(ModBlocks.POLISHED_WHITE_LIMESTONE.get());
            columnNoMiddle(ModBlocks.WHITE_LIMESTONE_PILLAR.get());

            // Crops
            cropCross(ModBlocks.TOMATO_CROP.get());
            cropCross(ModBlocks.CABBAGE_CROP.get());
            crop(ModBlocks.ONION_CROP.get());
            crop(ModBlocks.CUCUMBER_CROP.get());
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
// ═══════════════════════════════════════════════════════════════════════════════
// УТИЛИТЫ
// ═══════════════════════════════════════════════════════════════════════════════

        private String name(Block block) {
            return key(block).getPath();
        }

        private ResourceLocation key(Block block) {
            return BuiltInRegistries.BLOCK.getKey(block);
        }

        // blockTexture уже есть в родительском классе BlockStateProvider — удали свой!
// Если нужна кастомная логика:
        @Override
        public ResourceLocation blockTexture(Block block) {
            ResourceLocation name = key(block);
            return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath());
        }

        private ResourceLocation extend(ResourceLocation rl, String suffix) {
            return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
        }

        private ResourceLocation change(Block block, String replaced, String replace) {
            return resource("block/" + name(block).replace(replaced, replace));
        }

        private ResourceLocation vanilla(String path) {
            return ResourceLocation.withDefaultNamespace("block/" + path);
        }

        private ResourceLocation resource(String path) {
            return ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, path);
        }

        private void blockItem(Block block) {
            simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block)));
        }

        private void blockItem(Block block, String suffix) {
            simpleBlockItem(block, new ModelFile.UncheckedModelFile("bfme:block/" + name(block) + suffix));
        }



        private enum TextureSource { MOD, VANILLA }

        private enum TextureStyle {
            UNIFORM,   // Одна текстура (камень, кирпич)
            ROTATED,   // Side + End (брёвна с разными торцами)
            WOOD       // Wood — log текстура
        }
// ═══════════════════════════════════════════════════════════════════════════════
// ПРОСТЫЕ БЛОКИ
// ═══════════════════════════════════════════════════════════════════════════════

        private void blockWithItem(Block block) {
            simpleBlockWithItem(block, cubeAll(block));
        }

        private void oreBlock(Block block) {
            ModelFile model0 = models().cubeAll(name(block), blockTexture(block));
            ModelFile model1 = models().cubeAll(name(block) + "0", extend(blockTexture(block), "0"));
            ModelFile model2 = models().cubeAll(name(block) + "1", extend(blockTexture(block), "1"));

            getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                    .modelFile(model0).nextModel()
                    .modelFile(model1).nextModel()
                    .modelFile(model2).build());
            blockItem(block);
        }

        private void glass(Block block) {
            simpleBlockWithItem(block, models().cubeAll(name(block), blockTexture(block)).renderType("translucent"));
        }

// ═══════════════════════════════════════════════════════════════════════════════
// СЛЭБЫ (ГОРИЗОНТАЛЬНЫЕ)
// ═══════════════════════════════════════════════════════════════════════════════

        private void slab(Block block, TextureStyle style, TextureSource source) {
            ResourceLocation side = getSlabSideTexture(block, style, source);
            ResourceLocation end = getSlabEndTexture(block, style, source);

            if (style == TextureStyle.UNIFORM || style == TextureStyle.WOOD) {
                slabBlock((SlabBlock) block, side, side);
            } else {
                slabBlock((SlabBlock) block, side, side, end, end);
            }
            blockItem(block);
        }

        public void slab(Block block) { slab(block, TextureStyle.UNIFORM, TextureSource.MOD); }
        public void slabVanilla(Block block) { slab(block, TextureStyle.UNIFORM, TextureSource.VANILLA); }
        public void slabRotated(Block block) { slab(block, TextureStyle.ROTATED, TextureSource.MOD); }
        public void slabVanillaRotated(Block block) { slab(block, TextureStyle.ROTATED, TextureSource.VANILLA); }
        public void slabWood(Block block) { slab(block, TextureStyle.WOOD, TextureSource.MOD); }
        public void slabWoodVanilla(Block block) { slab(block, TextureStyle.WOOD, TextureSource.VANILLA); }

        private void slabSmooth(Block block) {
            ResourceLocation side = change(block, "_slab", "_side");
            ResourceLocation top = change(block, "_slab", "");

            slabBlock((SlabBlock) block,
                    models().slab(name(block), side, top, top),
                    models().slabTop(name(block) + "_top", side, top, top),
                    models().cubeColumn(name(block) + "_double", side, top));
            blockItem(block);
        }

        private void slabPillar(Block block) {
            slabBlock((SlabBlock) block, change(block, "_slab", ""), change(block, "_slab", ""),
                    change(block, "_slab", "_end"), change(block, "_slab", "_end"));
            blockItem(block);
        }

        private void slabPillarExtend(Block block) {
            slabBlock((SlabBlock) block, change(block, "slab", "single"), change(block, "slab", "single"),
                    change(block, "_slab", "_end"), change(block, "_slab", "_end"));
            blockItem(block);
        }

        private ResourceLocation getSlabSideTexture(Block block, TextureStyle style, TextureSource source) {
            String baseName = switch (style) {
                case WOOD -> name(block).replace("wood_slab", "log");
                default -> name(block).replace("_slab", "");
            };
            return source == TextureSource.VANILLA ? vanilla(baseName) : resource("block/" + baseName);
        }

        private ResourceLocation getSlabEndTexture(Block block, TextureStyle style, TextureSource source) {
            if (style == TextureStyle.UNIFORM || style == TextureStyle.WOOD) {
                return getSlabSideTexture(block, style, source);
            }
            String baseName = name(block).replace("_slab", "");
            String endSuffix = source == TextureSource.VANILLA ? "_top" : "_end";
            return source == TextureSource.VANILLA
                    ? vanilla(baseName + endSuffix)
                    : resource("block/" + baseName + endSuffix);
        }

        // ═══════════════════════════════════════════════════════════════════════════════
// ЛЕСТНИЦЫ
// ═══════════════════════════════════════════════════════════════════════════════

        private void stairs(Block block, TextureStyle style, TextureSource source) {
            ResourceLocation side = getStairsSideTexture(block, style, source);
            ResourceLocation end = getStairsEndTexture(block, style, source);

            if (style == TextureStyle.UNIFORM || style == TextureStyle.WOOD) {
                stairsBlock((StairBlock) block, side);
            } else {
                stairsBlock((StairBlock) block, side, end, end);
            }
            blockItem(block);
        }

        public void stairs(Block block) { stairs(block, TextureStyle.UNIFORM, TextureSource.MOD); }
        public void stairsVanilla(Block block) { stairs(block, TextureStyle.UNIFORM, TextureSource.VANILLA); }
        public void stairsRotated(Block block) { stairs(block, TextureStyle.ROTATED, TextureSource.MOD); }
        public void stairsVanillaRotated(Block block) { stairs(block, TextureStyle.ROTATED, TextureSource.VANILLA); }
        public void stairsWood(Block block) { stairs(block, TextureStyle.WOOD, TextureSource.MOD); }
        public void stairsWoodVanilla(Block block) { stairs(block, TextureStyle.WOOD, TextureSource.VANILLA); }

        private ResourceLocation getStairsSideTexture(Block block, TextureStyle style, TextureSource source) {
            String baseName = switch (style) {
                case WOOD -> name(block).replace("wood_stairs", "log");
                default -> name(block).replace("_stairs", "");
            };
            return source == TextureSource.VANILLA ? vanilla(baseName) : resource("block/" + baseName);
        }

        private ResourceLocation getStairsEndTexture(Block block, TextureStyle style, TextureSource source) {
            if (style == TextureStyle.UNIFORM || style == TextureStyle.WOOD) {
                return getStairsSideTexture(block, style, source);
            }
            String baseName = name(block).replace("_stairs", "");
            String endSuffix = source == TextureSource.VANILLA ? "_top" : "_end";
            return source == TextureSource.VANILLA
                    ? vanilla(baseName + endSuffix)
                    : resource("block/" + baseName + endSuffix);
        }
// ═══════════════════════════════════════════════════════════════════════════════
// ВЕРТИКАЛЬНЫЕ СЛЭБЫ
// ═══════════════════════════════════════════════════════════════════════════════

        private enum VerticalSlabStyle {
            UNIFORM,     // Однородная текстура (камень, wool)
            HORIZONTAL,  // Side + End (pillar, брёвна)
            WOOD         // Wood — log текстура
        }

        private void verticalSlab(Block block, VerticalSlabStyle style, TextureSource source, boolean hasDirectionalDouble) {
            createVerticalSlabModels(block, style, source);

            if (hasDirectionalDouble) {
                // Блоки с FACING (pillar, wood)
                getVariantBuilder(block).forAllStates(state -> {
                    VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                    Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(getVerticalSlabModel(block, type, facing, source)))
                            .build();
                });
            } else {
                // Блоки без FACING (камень, wool)
                getVariantBuilder(block).forAllStates(state -> {
                    VerticalSlabType type = state.getValue(VerticalSlabBlock.TYPE);
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(getVerticalSlabModel(block, type, null, source)))
                            .build();
                });
            }

            blockItem(block, "_south");
        }

// === Обёртки ===

        public void verticalSlab(Block block) {
            verticalSlab(block, VerticalSlabStyle.UNIFORM, TextureSource.MOD, false);
        }

        public void verticalSlabVanilla(Block block) {
            verticalSlab(block, VerticalSlabStyle.UNIFORM, TextureSource.VANILLA, false);
        }

        public void verticalSlabHorizontal(Block block) {
            verticalSlab(block, VerticalSlabStyle.HORIZONTAL, TextureSource.MOD, true);
        }

        public void verticalSlabHorizontalVanilla(Block block) {
            verticalSlab(block, VerticalSlabStyle.HORIZONTAL, TextureSource.VANILLA, true);
        }

        public void verticalSlabWood(Block block) {
            verticalSlab(block, VerticalSlabStyle.WOOD, TextureSource.MOD, true);
        }

        public void verticalSlabWoodVanilla(Block block) {
            verticalSlab(block, VerticalSlabStyle.WOOD, TextureSource.VANILLA, true);
        }

// === Создание моделей ===

        private void createVerticalSlabModels(Block block, VerticalSlabStyle style, TextureSource source) {
            String blockName = name(block);

            if (style == VerticalSlabStyle.UNIFORM) {
                ResourceLocation texture = getVerticalSlabUniformTexture(block, source);
                for (String dir : List.of("north", "south", "west", "east")) {
                    models().withExistingParent(blockName + "_" + dir, resource("block/vertical_slab_" + dir))
                            .texture("all", texture);
                }
            } else {
                ResourceLocation side = getVerticalSlabSideTexture(block, style, source);
                ResourceLocation end = getVerticalSlabEndTexture(block, style, source);

                for (String dir : List.of("north", "south", "west", "east")) {
                    models().withExistingParent(blockName + "_" + dir, resource("block/vertical_slab_" + dir + "_horizontal"))
                            .texture("side", side)
                            .texture("end", end);
                }
                models().withExistingParent(blockName + "_northsouth", resource("block/vertical_slab_northsouth"))
                        .texture("side", side).texture("end", end);
                models().withExistingParent(blockName + "_westeast", resource("block/vertical_slab_westeast"))
                        .texture("side", side).texture("end", end);
            }
        }

// === Получение текстур ===

        private ResourceLocation getVerticalSlabUniformTexture(Block block, TextureSource source) {
            String baseName = name(block).replace("_vertical_slab", "");
            return source == TextureSource.VANILLA ? vanilla(baseName) : resource("block/" + baseName);
        }

        private ResourceLocation getVerticalSlabSideTexture(Block block, VerticalSlabStyle style, TextureSource source) {
            String blockName = name(block);
            String baseName = style == VerticalSlabStyle.WOOD
                    ? blockName.replace("wood_vertical_slab", "log")
                    : blockName.replace("_vertical_slab", "");
            return source == TextureSource.VANILLA ? vanilla(baseName) : resource("block/" + baseName);
        }

        private ResourceLocation getVerticalSlabEndTexture(Block block, VerticalSlabStyle style, TextureSource source) {
            if (style == VerticalSlabStyle.WOOD) {
                return getVerticalSlabSideTexture(block, style, source);
            }
            String baseName = name(block).replace("_vertical_slab", "");
            String endSuffix = source == TextureSource.VANILLA ? "_top" : "_end";
            return source == TextureSource.VANILLA
                    ? vanilla(baseName + endSuffix)
                    : resource("block/" + baseName + endSuffix);
        }

// === Получение модели для blockstate ===

        private ResourceLocation getVerticalSlabModel(Block block, VerticalSlabType type,
                                                      @Nullable Direction facing, TextureSource source) {
            String blockName = name(block);

            return switch (type) {
                case NORTH -> resource("block/" + blockName + "_north");
                case SOUTH -> resource("block/" + blockName + "_south");
                case WEST -> resource("block/" + blockName + "_west");
                case EAST -> resource("block/" + blockName + "_east");
                case DOUBLE -> {
                    if (facing != null && (facing == Direction.NORTH || facing == Direction.SOUTH)) {
                        yield resource("block/" + blockName + "_northsouth");
                    } else if (facing != null) {
                        yield resource("block/" + blockName + "_westeast");
                    } else {
                        // UNIFORM — базовый блок (vanilla или mod)
                        String baseName = blockName.replace("_vertical_slab", "");
                        yield source == TextureSource.VANILLA
                                ? vanilla(baseName)
                                : resource("block/" + baseName);
                    }
                }
            };
        }   
// ═══════════════════════════════════════════════════════════════════════════════
// СТЕНЫ
// ═══════════════════════════════════════════════════════════════════════════════

        public void wall(Block block) {
            ResourceLocation texture = change(block, "_wall", "");
            wallBlock((WallBlock) block,
                    models().wallPost(name(block) + "_post", texture),
                    models().wallSide(name(block) + "_side", texture),
                    models().wallSideTall(name(block) + "_side_tall", texture));
        }

        public void wallRotated(Block block) {
            ResourceLocation texture = change(block, "_wall", "_side");
            wallBlock((WallBlock) block,
                    models().wallPost(name(block) + "_post", texture),
                    models().wallSide(name(block) + "_side", texture),
                    models().wallSideTall(name(block) + "_side_tall", texture));
        }

// ═══════════════════════════════════════════════════════════════════════════════
// КНОПКИ И НАЖИМНЫЕ ПЛИТЫ
// ═══════════════════════════════════════════════════════════════════════════════

        public void button(Block block) {
            ResourceLocation texture = change(block, "_button", "");
            buttonBlock((ButtonBlock) block,
                    models().button(name(block), texture),
                    models().buttonPressed(name(block) + "_pressed", texture));
        }

        public void buttonWooden(Block block) {
            ResourceLocation texture = change(block, "button", "planks");
            buttonBlock((ButtonBlock) block,
                    models().button(name(block), texture),
                    models().buttonPressed(name(block) + "_pressed", texture));
        }

        public void pressurePlate(Block block) {
            ResourceLocation texture = change(block, "_pressure_plate", "");
            pressurePlateBlock((PressurePlateBlock) block,
                    models().pressurePlate(name(block), texture),
                    models().pressurePlateDown(name(block) + "_down", texture));
            blockItem(block);
        }

        public void pressurePlateWooden(Block block) {
            ResourceLocation texture = change(block, "pressure_plate", "planks");
            pressurePlateBlock((PressurePlateBlock) block,
                    models().pressurePlate(name(block), texture),
                    models().pressurePlateDown(name(block) + "_down", texture));
            blockItem(block);
        }

        // ═══════════════════════════════════════════════════════════════════════════════
// ЗАБОРЫ
// ═══════════════════════════════════════════════════════════════════════════════

        public void fence(Block block) {
            ResourceLocation texture = change(block, "fence", "planks");
            fourWayBlock((FenceBlock) block,
                    models().fencePost(name(block) + "_post", texture),
                    models().fenceSide(name(block) + "_side", texture));
        }

        public void fenceGate(Block block) {
            ResourceLocation texture = change(block, "fence_gate", "planks");
            fenceGateBlock((FenceGateBlock) block,
                    models().fenceGate(name(block), texture),
                    models().fenceGateOpen(name(block) + "_open", texture),
                    models().fenceGateWall(name(block) + "_wall", texture),
                    models().fenceGateWallOpen(name(block) + "_wall_open", texture));
            blockItem(block);
        }
        // ═══════════════════════════════════════════════════════════════════════════════
// ДВЕРИ И ЛЮКИ
// ═══════════════════════════════════════════════════════════════════════════════

        public void door(Block block) {
            doorBlockWithRenderType((DoorBlock) block,
                    extend(blockTexture(block), "_bottom"),
                    extend(blockTexture(block), "_top"),
                    "cutout");
        }

        public void trapdoor(Block block) {
            trapdoorBlockWithRenderType((TrapDoorBlock) block, blockTexture(block), true, "cutout");
            blockItem(block, "_bottom");
        }
        // ═══════════════════════════════════════════════════════════════════════════════
// ДЕРЕВО
// ═══════════════════════════════════════════════════════════════════════════════

        public void log(Block block) {
            axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
            blockItem(block);
        }

        public void wood(Block block) {
            ResourceLocation logTexture = change(block, "_wood", "_log");
            axisBlock((RotatedPillarBlock) block, logTexture, logTexture);
            blockItem(block);
        }

        public void pillar(Block block) {
            axisBlock((RotatedPillarBlock) block, blockTexture(block), extend(blockTexture(block), "_end"));
            blockItem(block);
        }
// ═══════════════════════════════════════════════════════════════════════════════
// ЛИСТВА
// ═══════════════════════════════════════════════════════════════════════════════

        public void leaves(Block block) {
            simpleBlockWithItem(block, models()
                    .singleTexture(name(block), vanilla("leaves"), "all", blockTexture(block))
                    .renderType("cutout"));
        }

        public void fruitLeaves(Block block) {
            VariantBlockStateBuilder builder = getVariantBuilder(block);

            for (int age = 0; age <= ModFruitLeaves.MAX_AGE; age++) {
                ModelFile model = models()
                        .singleTexture(name(block) + "_stage" + age, vanilla("leaves"), "all",
                                extend(blockTexture(block), "_stage" + age))
                        .renderType("cutout");

                builder.partialState()
                        .with(ModFruitLeaves.AGE, age)
                        .modelForState()
                        .modelFile(model)
                        .addModel();
            }

            simpleBlockItem(block, models().getExistingFile(extend(blockTexture(block), "_stage0")));
        }
        // ═══════════════════════════════════════════════════════════════════════════════
// КОЛОННЫ
// ═══════════════════════════════════════════════════════════════════════════════

        public void tinyColumn(Block block) {
            createTinyColumnModels(block);
            columnBlockstate(block);
            blockItem(block, "_single");
        }

        public void column(Block block) {
            createPillarColumnModels(block);
            columnBlockstate(block);
            blockItem(block, "_single");
        }

        private void columnBlockstate(Block block) {
            VariantBlockStateBuilder builder = getVariantBuilder(block);
            for (ColumnPart part : ColumnPart.values()) {
                builder.partialState()
                        .with(ColumnBlock.PART, part)
                        .modelForState()
                        .modelFile(models().getExistingFile(extend(blockTexture(block), "_" + part.getSerializedName())))
                        .addModel();
            }
        }

        private void createTinyColumnModels(Block block) {
            ResourceLocation stone = change(block, "column", "stone");
            ResourceLocation cobble = change(block, "column", "cobblestone");
            ResourceLocation pillarTex = change(block, "column", "pillar");

            models().withExistingParent(name(block) + "_single", "block/block")
                    .texture("1", stone).texture("2", cobble).texture("3", pillarTex).texture("particle", pillarTex)
                    .element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                    .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                    .element().from(3, 3, 3).to(13, 13, 13).textureAll("#3").end()
                    .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
                    .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();

            models().withExistingParent(name(block) + "_bottom", "block/block")
                    .texture("1", stone).texture("2", cobble).texture("3", pillarTex).texture("particle", pillarTex)
                    .element().from(0, 0, 0).to(16, 2, 16).textureAll("#1").end()
                    .element().from(1, 2, 1).to(15, 3, 15).textureAll("#2").end()
                    .element().from(3, 3, 3).to(13, 16, 13).textureAll("#3").end();

            models().withExistingParent(name(block) + "_middle", "block/block")
                    .texture("3", pillarTex).texture("particle", pillarTex)
                    .element().from(3, 0, 3).to(13, 16, 13).textureAll("#3").end();

            models().withExistingParent(name(block) + "_top", "block/block")
                    .texture("1", stone).texture("2", cobble).texture("3", pillarTex).texture("particle", pillarTex)
                    .element().from(3, 0, 3).to(13, 13, 13).textureAll("#3").end()
                    .element().from(1, 13, 1).to(15, 14, 15).textureAll("#2").end()
                    .element().from(0, 14, 0).to(16, 16, 16).textureAll("#1").end();
        }

        private void createPillarColumnModels(Block block) {
            ResourceLocation end = extend(blockTexture(block), "_end");
            for (String part : List.of("single", "top", "middle", "bottom")) {
                ResourceLocation side = extend(blockTexture(block), "_" + part);
                models().cube(name(block) + "_" + part, end, end, side, side, side, side)
                        .texture("particle", blockTexture(block));
            }
        }

        public void columnNoMiddle(Block block) {
            createPillarColumnModelsNoMiddle(block);
            columnBlockstate(block);
            blockItem(block, "_single");
        }

        private void createPillarColumnModelsNoMiddle(Block block) {
            ResourceLocation base = blockTexture(block);
            ResourceLocation end = extend(base, "_end");
            for (String part : List.of("single", "top", "middle", "bottom")) {
                ResourceLocation side = part.equals("middle") ? base : extend(base, "_" + part);
                models().cube(name(block) + "_" + part, end, end, side, side, side, side)
                        .texture("particle", base);
            }
        }

// ═══════════════════════════════════════════════════════════════════════════════
// СТЁКЛА И РЕШЁТКИ
// ═══════════════════════════════════════════════════════════════════════════════

        public void pane(Block block) {
            paneBlockWithRenderType((IronBarsBlock) block,
                    change(block, "_pane", ""),
                    resource("block/glass_pane_top"),
                    "translucent");
        }

        public void bars(Block block) {
            paneBlockWithRenderType((IronBarsBlock) block, blockTexture(block), blockTexture(block), "cutout");
        }


// ═══════════════════════════════════════════════════════════════════════════════
// РАСТЕНИЯ
// ═══════════════════════════════════════════════════════════════════════════════

        public void sapling(Block block) {
            simpleBlock(block, models().cross(name(block), blockTexture(block)).renderType("cutout"));
        }

// ═══════════════════════════════════════════════════════════════════════════════
// ТАБЛИЧКИ
// ═══════════════════════════════════════════════════════════════════════════════

        public void hangingSign(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
            ModelFile sign = models().sign(name(signBlock), texture);
            simpleBlock(signBlock, sign);
            simpleBlock(wallSignBlock, sign);
        }

        public void chair(Block block){
            horizontalBlock(block, new ModelFile.UncheckedModelFile(modLoc("block/woodchair")));
            blockTexture(block);
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

// ═══════════════════════════════════════════════════════════════════════════════
// КУЛЬТУРЫ (CROPS)
// ═══════════════════════════════════════════════════════════════════════════════

        public void crop(Block block) {
            ModCropBlock cropBlock = (ModCropBlock) block;
            VariantBlockStateBuilder builder = getVariantBuilder(block);
            int maxAge = cropBlock.getMaxAge();

            // Определяем базовое имя текстуры
            String textureName = cropBlock.getTextureName();
            if (textureName == null) {
                // Убираем "_crop" из имени блока для текстуры
                textureName = name(block).replace("_crop", "");
            }

            // Используем правильный IntegerProperty для этого maxAge
            var ageProperty = ModCropBlock.getAgePropertyForMax(maxAge);

            for (int age = 0; age <= maxAge; age++) {
                String modelName = name(block) + "_stage" + age;
                ResourceLocation texture = modLoc("block/" + textureName + "_stage" + age);

                ModelFile model = models().getBuilder(modelName)
                        .parent(new ModelFile.UncheckedModelFile(mcLoc("block/crop")))
                        .texture("crop", texture)
                        .renderType("cutout");

                builder.partialState()
                        .with(ageProperty, age)
                        .modelForState()
                        .modelFile(model)
                        .addModel();
            }
        }

        // Крестом как ягоды (sweet_berry_bush)
        public void cropCross(Block block) {
            ModCropBlock cropBlock = (ModCropBlock) block;
            VariantBlockStateBuilder builder = getVariantBuilder(block);
            int maxAge = cropBlock.getMaxAge();

            String textureName = cropBlock.getTextureName();
            if (textureName == null) {
                textureName = name(block).replace("_crop", "").replace("_bush", "");
            }

            var ageProperty = ModCropBlock.getAgePropertyForMax(maxAge);

            for (int age = 0; age <= maxAge; age++) {
                String modelName = name(block) + "_stage" + age;
                ResourceLocation texture = modLoc("block/" + textureName + "_stage" + age);

                ModelFile model = models().getBuilder(modelName)
                        .parent(new ModelFile.UncheckedModelFile(mcLoc("block/cross")))
                        .texture("cross", texture)
                        .renderType("cutout");

                builder.partialState()
                        .with(ageProperty, age)
                        .modelForState()
                        .modelFile(model)
                        .addModel();
            }
        }

    }
