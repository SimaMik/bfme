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

/**
 * Узкая слоёная хвойная крона.
 *
 * Подходит для сосны, ели, пихты, кедра, кипариса и других высоких деревьев,
 * где крона должна быть не шаром, а конусом/колонной.
 */
public class LayeredConiferFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<LayeredConiferFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(3, 32).fieldOf("height").forGetter(p -> p.height))
                    .and(Codec.intRange(0, 6).fieldOf("min_radius").forGetter(p -> p.minRadius))
                    .and(Codec.intRange(1, 8).fieldOf("max_radius").forGetter(p -> p.maxRadius))
                    .and(Codec.intRange(0, 8).fieldOf("trunk_clearance").forGetter(p -> p.trunkClearance))
                    .and(Codec.intRange(0, 100).fieldOf("ragged_chance").forGetter(p -> p.raggedChance))
                    .apply(instance, LayeredConiferFoliagePlacer::new)
    );

    private final int height;
    private final int minRadius;
    private final int maxRadius;
    private final int trunkClearance;
    private final int raggedChance;

    public LayeredConiferFoliagePlacer(IntProvider radius,
                                       IntProvider offset,
                                       int height,
                                       int minRadius,
                                       int maxRadius,
                                       int trunkClearance,
                                       int raggedChance) {
        super(radius, offset);
        this.height = height;
        this.minRadius = minRadius;
        this.maxRadius = Math.max(minRadius, maxRadius);
        this.trunkClearance = trunkClearance;
        this.raggedChance = raggedChance;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.LAYERED_CONIFER_FOLIAGE_PLACER.get();
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
        if (attachment.radiusOffset() < 0) {
            return;
        }

        BlockPos top = attachment.pos();

        tryPlaceLeaf(level, foliageSetter, random, config, top.above());

        for (int layer = 0; layer < this.height; layer++) {
            BlockPos center = top.below(layer);
            double t = (double) layer / (double) Math.max(1, this.height - 1);

            int radius = this.minRadius + (int) Math.round(t * (this.maxRadius - this.minRadius));
            if (layer % 3 == 1 && radius > 0) {
                radius--;
            }

            boolean sparseLayer = layer > this.height * 0.65 && random.nextFloat() < 0.25f;

            placeConiferLayer(level, foliageSetter, random, config, center, radius, sparseLayer);
        }
    }
    private void placeConiferLayer(LevelSimulatedReader level,
                                   FoliageSetter foliageSetter,
                                   RandomSource random,
                                   TreeConfiguration config,
                                   BlockPos center,
                                   int radius,
                                   boolean sparseLayer) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                int manhattan = Math.abs(dx) + Math.abs(dz);
                int square = Math.max(Math.abs(dx), Math.abs(dz));

                if (manhattan > radius + 1 || square > radius) {
                    continue;
                }

                boolean trunkColumn = Math.abs(dx) <= 0 && Math.abs(dz) <= 0;
                if (trunkColumn && this.trunkClearance > 0) {
                    // Центральные листья всё равно иногда ставим, иначе в конусе будут дырки.
                    if (random.nextInt(100) < 55) {
                        continue;
                    }
                }

                boolean edge = square == radius || manhattan >= radius;
                if (edge && random.nextInt(100) < this.raggedChance) {
                    continue;
                }

                if (sparseLayer && random.nextInt(100) < 22) {
                    continue;
                }

                tryPlaceLeaf(level, foliageSetter, random, config, center.offset(dx, 0, dz));
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.height;
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
