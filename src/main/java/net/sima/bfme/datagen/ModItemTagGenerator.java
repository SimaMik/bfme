package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, BFME.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Item Tags here

        this.tag(ItemTags.MUSIC_DISCS);


//        this.tag(ItemTags.LOGS_THAT_BURN)
//                .add(ModBlocks.WALNUT_LOG.get().asItem())
//                .add(ModBlocks.WALNUT_WOOD.get().asItem())
//                .add(ModBlocks.STRIPPED_WALNUT_LOG.get().asItem())
//                .add(ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem());
//
//        this.tag(ItemTags.PLANKS)
//                .add(ModBlocks.WALNUT_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
