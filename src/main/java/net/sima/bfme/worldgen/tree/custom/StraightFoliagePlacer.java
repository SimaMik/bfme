package net.sima.bfme.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.sima.bfme.worldgen.tree.ModFoliagePlacerTypes;

public class StraightFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<StraightFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
                    .apply(instance, StraightFoliagePlacer::new)
    );

    protected final int height;

    public StraightFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.STRAIGHT_FOLIAGE_PLACER.get();
    }
    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight,
                                 FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {

        // Начало листвы теперь строго на вершине ствола
        BlockPos topOfTrunk = attachment.pos();
        // Верхушка
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.above(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.above(2));
        // 1 слой
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk);
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.north(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.south(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.west(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.east(1));
        // 2 слой
        placeLeavesRow(level, foliageSetter, random, config, topOfTrunk.below(1), 1, 0, false);

        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(1).north(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(1).south(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(1).west(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(1).east(2));

        // 3 слой
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(2).north(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(2).south(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(2).west(1));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(2).east(1));

        // 4 слой
        for (int dx = -3; dx <= 3; dx++) {
            for (int dz = -3; dz <= 3; dz++) {
                // Манхэттенское расстояние, создающее ромб
                if (Math.abs(dx) + Math.abs(dz) <= 3) {
                    BlockPos leafPos = topOfTrunk.below(3).offset(dx, 0, dz); // Один слой, Y фиксированный
                    tryPlaceLeaf(level, foliageSetter, random, config, leafPos);
                }
            }
        }

        // 5 слой
        placeLeavesRow(level, foliageSetter, random, config, topOfTrunk.below(4), 1, 0, false);

        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(4).north(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(4).south(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(4).west(2));
        tryPlaceLeaf(level, foliageSetter, random, config, topOfTrunk.below(4).east(2));

        // 6 слой
        for (int dx = -4; dx <= 4; dx++) {
            for (int dz = -4; dz <= 4; dz++) {
                // Манхэттенское расстояние, создающее ромб
                if (Math.abs(dx) + Math.abs(dz) <= 4) {
                    BlockPos leafPos = topOfTrunk.below(5).offset(dx, 0, dz); // Один слой, Y фиксированный
                    tryPlaceLeaf(level, foliageSetter, random, config, leafPos);
                }
            }
        }

        // 7 слой

        for (int dx = -3; dx <= 3; dx++) {
            for (int dz = -3; dz <= 3; dz++) {
                // Манхэттенское расстояние, создающее ромб
                if (Math.abs(dx) + Math.abs(dz) <= 3) {
                    BlockPos leafPos = topOfTrunk.below(6).offset(dx, 0, dz); // Один слой, Y фиксированный
                    tryPlaceLeaf(level, foliageSetter, random, config, leafPos);
                }
            }
        }

    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }
}
