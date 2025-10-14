package net.sima.bfme.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.tree.custom.StraightFoliagePlacer;

import java.util.function.Supplier;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, BFME.MOD_ID);


    public static final Supplier<FoliagePlacerType<StraightFoliagePlacer>> STRAIGHT_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("straight_foliage_placer",
                    () -> new FoliagePlacerType<>(StraightFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
