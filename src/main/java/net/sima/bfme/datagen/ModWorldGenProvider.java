package net.sima.bfme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomes;
import net.sima.bfme.worldgen.dimension.ModDimensions;
import net.sima.bfme.worldgen.features.ModConfiguredFeatures;
import net.sima.bfme.worldgen.features.ModOreFeatures;
import net.sima.bfme.worldgen.features.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, BFMEBiomes::bootstrapBiomes)
            .add(Registries.CONFIGURED_FEATURE, ctx -> {
                ModConfiguredFeatures.bootstrap(ctx);
                ModOreFeatures.bootstrapConfigured(ctx);
            })
            .add(Registries.PLACED_FEATURE, ctx -> {
                ModPlacedFeatures.bootstrap(ctx);
                ModOreFeatures.bootstrapPlaced(ctx);
            })
            // NOISE_SETTINGS загружается из JSON: data/bfme/worldgen/noise_settings/bfme_overworld.json
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            ;

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(BFME.MOD_ID));
    }
}