package net.sima.bfme.worldgen.dimension;

import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.worldgen.biomes.BFMEBiomeKeys;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomeSource;
import net.sima.bfme.worldgen.chunkgen.BFMEChunkGenerator;

import java.util.List;
import java.util.OptionalLong;

import static net.minecraft.world.level.biome.Biomes.DRIPSTONE_CAVES;
import static net.minecraft.world.level.biome.Biomes.LUSH_CAVES;

public class ModDimensions {
    public static final ResourceKey<LevelStem> BFME_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "bfme"));
    public static final ResourceKey<Level> BFME_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "bfme"));
    public static final ResourceKey<DimensionType> BFME_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "bfme_type"));

    public static final BlockPos SPAWN_LOCATION = new BlockPos(100, 70, 100);

    // Регистрация типа измерения
    public static void bootstrapType(BootstrapContext<DimensionType> context) {
        context.register(BFME_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -128, // minY
                576, // height
                448, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    // Регистрация генератора чанков
    public static void registerChunkGenerator(RegisterEvent event) {
        event.register(Registries.CHUNK_GENERATOR, helper ->
                helper.register(BFME.resource("bfme_chunk_generator"), BFMEChunkGenerator.MAP_CODEC));
    }

    // Регистрация источника биомов
    public static void registerBiomeSource(RegisterEvent event) {
        event.register(Registries.BIOME_SOURCE, helper ->
                helper.register(BFME.resource("bfme_biome_source"), BFMEBiomeSource.MAP_CODEC));
    }

    // Регистрация измерения
    public static void bootstrapStem(BootstrapContext<LevelStem> context) {
        HolderGetter<DimensionType> dimensionTypeGetter = context.lookup(Registries.DIMENSION_TYPE);
        Holder.Reference<DimensionType> dimensionTypeHolder = dimensionTypeGetter.getOrThrow(BFME_TYPE);

        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);

        List<Holder.Reference<Biome>> biomes = List.of(
                biomeGetter.getOrThrow(BFMEBiomeKeys.PELENNOR_PLAINS),
                biomeGetter.getOrThrow(BFMEBiomeKeys.FIRIEN_WOOD),
                biomeGetter.getOrThrow(BFMEBiomeKeys.DRUADAN_FOREST),
                biomeGetter.getOrThrow(BFMEBiomeKeys.GREYWOOD),
                biomeGetter.getOrThrow(BFMEBiomeKeys.ANDUIN_BANKS),
                biomeGetter.getOrThrow(BFMEBiomeKeys.ENTWASH),
                biomeGetter.getOrThrow(BFMEBiomeKeys.WHITE_MOUNTAINS),
                biomeGetter.getOrThrow(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS),
                biomeGetter.getOrThrow(LUSH_CAVES),
                biomeGetter.getOrThrow(DRIPSTONE_CAVES)

        );

        HolderSet<Biome> biomeHolderSet = HolderSet.direct(biomes);

        BFMEBiomeSource biomeSource = new BFMEBiomeSource(biomeHolderSet);

        // Создаем LevelStem
        LevelStem bfmeLevelStem = new LevelStem(
                dimensionTypeHolder,
                new BFMEChunkGenerator(biomeSource)
        );

        context.register(BFME_KEY, bfmeLevelStem);
    }

    // Метод для телепортации игрока в измерение BFME
    public static void teleportPlayerToBFME(ServerPlayer player) {
        ServerLevel bfmeWorld = player.getServer().getLevel(BFME_LEVEL_KEY);
        if (bfmeWorld == null) {
            player.displayClientMessage(Component.literal("Измерение не загружено!"), true);
            return;
        }

        player.teleportTo(
                bfmeWorld,
                SPAWN_LOCATION.getX(),
                SPAWN_LOCATION.getY(),
                SPAWN_LOCATION.getZ(),
                player.getYRot(),
                player.getXRot()
        );

        player.displayClientMessage(Component.literal("Добро пожаловать в BFME!"), true);
    }

    // Проверка: находится ли игрок в измерении BFME
    public static boolean isInBFME(ServerLevel world) {
        return world.dimension().equals(BFME_LEVEL_KEY);
    }
}
