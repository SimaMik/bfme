package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BFME.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
        this.tag(BlockTags.NEEDS_IRON_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);


        this.tag(BlockTags.LOGS);

        this.tag(BlockTags.FENCES);
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.GONDORIAN_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_OVERGROWN_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_STONE_WALL.get())
                .add(ModBlocks.GONDORIAN_COBBLESTONE_WALL.get())
                .add(ModBlocks.GONDORIAN_OVERGROWN_COBBLESTONE_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_COBBLESTONE_WALL.get()   )
                .add(ModBlocks.GONDORIAN_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_BRICKWORK_WALL.get())
                .add(ModBlocks.GONDORIAN_OVERGROWN_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_OVERGROWN_BRICKWORK_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_MOSSY_BRICKWORK_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_BRICK_WALL.get())
                .add(ModBlocks.GONDORIAN_CRACKED_BRICKWORK_WALL.get());
        this.tag(BlockTags.FENCE_GATES);

        this.tag(BlockTags.LOGS_THAT_BURN);

        this.tag(BlockTags.PLANKS);
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
