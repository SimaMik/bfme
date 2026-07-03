package net.sima.bfme.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.tree.custom.LayeredConiferFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.OvalClusterFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.PalmCrownFoliagePlacer;
import net.sima.bfme.worldgen.tree.custom.StraightFoliagePlacer;

public class ModFoliagePlacerTypes {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, BFME.MOD_ID);

    // Твой старый ручной placer. Оставляем, чтобы не сломать уже существующие деревья.
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<StraightFoliagePlacer>> STRAIGHT_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("straight_foliage_placer",
                    () -> new FoliagePlacerType<>(StraightFoliagePlacer.CODEC));

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<OvalClusterFoliagePlacer>> OVAL_CLUSTER_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("oval_cluster_foliage_placer",
                    () -> new FoliagePlacerType<>(OvalClusterFoliagePlacer.CODEC));

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<LayeredConiferFoliagePlacer>> LAYERED_CONIFER_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("layered_conifer_foliage_placer",
                    () -> new FoliagePlacerType<>(LayeredConiferFoliagePlacer.CODEC));


    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<PalmCrownFoliagePlacer>> PALM_CROWN_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("palm_crown_foliage_placer",
                    () -> new FoliagePlacerType<>(PalmCrownFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}
