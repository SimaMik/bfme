package net.sima.bfme.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.sima.bfme.util.ModTags;

public class ModToolTiers {
    public static final Tier GONDORIAN = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_GONDORIAN_TOOL,
            1000, 7f, 2.5f, 20,
            () -> Ingredient.of(ModItems.GONDORIAN_INGOT.get()));
}
