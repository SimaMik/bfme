package net.sima.bfme.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sima.bfme.BFME;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_GONDORIAN_TOOL = createTag("incorrect_for_gondorian_tool");
        public static final TagKey<Block> NEEDS_GONDORIAN_TOOL = createTag("needs_gondorian_tool");

        public static final TagKey<Block> STONES = createTag("miner_blocks");
        public static final TagKey<Block> ORES = createTag("ores");
        public static final TagKey<Block> PAXEL_MINEABLE = createTag("mineable/paxel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(BFME.resource(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(BFME.resource(name));
        }
    }

}
