package net.sima.bfme.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.tree.custom.RootedBranchingTrunkPlacer;

public class ModTrunkPlacerTypes {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, BFME.MOD_ID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<RootedBranchingTrunkPlacer>> ROOTED_BRANCHING_TRUNK_PLACER =
            TRUNK_PLACER_TYPES.register("rooted_branching_trunk_placer",
                    () -> new TrunkPlacerType<>(RootedBranchingTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}
