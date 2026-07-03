package net.sima.bfme.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.sima.bfme.worldgen.tree.ModFoliagePlacerTypes;

/**
 * Радиальная крона для пальм, финиковых пальм и банановых деревьев.
 * Делает не шар, а длинные листовые "перья" от верхушки.
 */
public class PalmCrownFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<PalmCrownFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(4, 16).fieldOf("frond_count").forGetter(p -> p.frondCount))
                    .and(Codec.intRange(2, 10).fieldOf("frond_length_min").forGetter(p -> p.frondLengthMin))
                    .and(Codec.intRange(2, 12).fieldOf("frond_length_max").forGetter(p -> p.frondLengthMax))
                    .and(Codec.intRange(0, 6).fieldOf("upward_start").forGetter(p -> p.upwardStart))
                    .and(Codec.intRange(0, 8).fieldOf("droop").forGetter(p -> p.droop))
                    .apply(instance, PalmCrownFoliagePlacer::new)
    );

    private final int frondCount;
    private final int frondLengthMin;
    private final int frondLengthMax;
    private final int upwardStart;
    private final int droop;

    public PalmCrownFoliagePlacer(IntProvider radius,
                                  IntProvider offset,
                                  int frondCount,
                                  int frondLengthMin,
                                  int frondLengthMax,
                                  int upwardStart,
                                  int droop) {
        super(radius, offset);
        this.frondCount = frondCount;
        this.frondLengthMin = frondLengthMin;
        this.frondLengthMax = Math.max(frondLengthMin, frondLengthMax);
        this.upwardStart = upwardStart;
        this.droop = droop;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.PALM_CROWN_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level,
                                 FoliageSetter foliageSetter,
                                 RandomSource random,
                                 TreeConfiguration config,
                                 int maxFreeTreeHeight,
                                 FoliageAttachment attachment,
                                 int foliageHeight,
                                 int foliageRadius,
                                 int offset) {
        BlockPos top = attachment.pos();

        tryPlaceLeaf(level, foliageSetter, random, config, top);
        tryPlaceLeaf(level, foliageSetter, random, config, top.above());

        double baseAngle = random.nextDouble() * Math.PI * 2.0;

        for (int i = 0; i < this.frondCount; i++) {
            double angle = baseAngle
                    + (Math.PI * 2.0 * i / Math.max(1, this.frondCount))
                    + randomBetween(random, -0.18, 0.18);

            int length = this.frondLengthMin + random.nextInt(this.frondLengthMax - this.frondLengthMin + 1);
            placeFrond(level, foliageSetter, random, config, top, angle, length);
        }
    }

    private void placeFrond(LevelSimulatedReader level,
                            FoliageSetter foliageSetter,
                            RandomSource random,
                            TreeConfiguration config,
                            BlockPos top,
                            double angle,
                            int length) {
        for (int step = 1; step <= length; step++) {
            double t = (double) step / (double) length;

            int dx = Mth.floor(Math.cos(angle) * step);
            int dz = Mth.floor(Math.sin(angle) * step);

            int dy = Mth.floor((1.0 - t) * this.upwardStart - (t * t) * this.droop);
            BlockPos leaf = top.offset(dx, dy, dz);

            tryPlaceLeaf(level, foliageSetter, random, config, leaf);

            // Ширина листа: в середине фрагмент шире, на конце уже.
            if (step > 1 && step < length - 1) {
                int sideX = Math.abs(Math.cos(angle)) < 0.5 ? 1 : 0;
                int sideZ = Math.abs(Math.sin(angle)) < 0.5 ? 1 : 0;

                if (random.nextFloat() < 0.78f) {
                    tryPlaceLeaf(level, foliageSetter, random, config, leaf.offset(sideX, 0, sideZ));
                }

                if (random.nextFloat() < 0.78f) {
                    tryPlaceLeaf(level, foliageSetter, random, config, leaf.offset(-sideX, 0, -sideZ));
                }
            }

            // Концы иногда свисают на один блок.
            if (step > length * 0.72 && random.nextFloat() < 0.35f) {
                tryPlaceLeaf(level, foliageSetter, random, config, leaf.below());
            }
        }
    }

    private double randomBetween(RandomSource random, double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.frondLengthMax + this.droop + 2;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random,
                                         int localX,
                                         int localY,
                                         int localZ,
                                         int range,
                                         boolean large) {
        return false;
    }
}
