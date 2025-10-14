package net.sima.bfme.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.features.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PINE = new TreeGrower(BFME.MOD_ID + ":pine",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PINE_KEY), Optional.empty());

}
