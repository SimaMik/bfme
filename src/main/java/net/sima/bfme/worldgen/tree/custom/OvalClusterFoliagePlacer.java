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

public class OvalClusterFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<OvalClusterFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(ShapeSettings.CODEC.fieldOf("shape").forGetter(p -> p.shape))
                    .apply(instance, OvalClusterFoliagePlacer::new)
    );

    private final ShapeSettings shape;

    public OvalClusterFoliagePlacer(IntProvider radius,
                                    IntProvider offset,
                                    int radiusX,
                                    int radiusY,
                                    int radiusZ,
                                    int clusterCount,
                                    int density,
                                    int edgeCutChance,
                                    int hangingChance,
                                    int hangingLength) {
        this(
                radius,
                offset,
                new ShapeSettings(
                        radiusX,
                        radiusY,
                        radiusZ,
                        clusterCount,
                        density,
                        edgeCutChance,
                        hangingChance,
                        hangingLength
                )
        );
    }

    public OvalClusterFoliagePlacer(IntProvider radius,
                                    IntProvider offset,
                                    ShapeSettings shape) {
        super(radius, offset);
        this.shape = shape;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.OVAL_CLUSTER_FOLIAGE_PLACER.get();
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
        BlockPos center = attachment.pos();

        // 0 = главная верхняя крона
        // -2 = боковая веточная крона, должна быть меньше
        int attachmentOffset = attachment.radiusOffset();

        int baseRx = Math.max(1, shape.radiusX() + attachmentOffset);
        int baseRy = Math.max(1, shape.radiusY() + Math.min(0, attachmentOffset));
        int baseRz = Math.max(1, shape.radiusZ() + attachmentOffset);

        int clusterCount = Math.max(1, shape.clusterCount() + attachmentOffset);

        for (int i = 0; i < clusterCount; i++) {
            BlockPos clusterCenter = center;

            int rx = baseRx;
            int ry = baseRy;
            int rz = baseRz;

            if (i > 0) {
                double angle = random.nextDouble() * Math.PI * 2.0;

                int maxDistance = Math.max(1, Math.min(2, baseRx - 1));
                int distance = 1 + random.nextInt(maxDistance);

                int dx = Mth.floor(Math.cos(angle) * distance);
                int dz = Mth.floor(Math.sin(angle) * distance);
                int dy = random.nextInt(3) - 1;

                clusterCenter = center.offset(dx, dy, dz);

                rx = Math.max(1, rx - random.nextInt(2));
                ry = Math.max(1, ry - random.nextInt(2));
                rz = Math.max(1, rz - random.nextInt(2));
            }

            placeOval(level, foliageSetter, random, config, clusterCenter, rx, ry, rz);
        }
    }
    private void placeOval(LevelSimulatedReader level,
                           FoliageSetter foliageSetter,
                           RandomSource random,
                           TreeConfiguration config,
                           BlockPos center,
                           int rx,
                           int ry,
                           int rz) {
        for (int dy = -ry; dy <= ry; dy++) {
            for (int dx = -rx; dx <= rx; dx++) {
                for (int dz = -rz; dz <= rz; dz++) {
                    double value =
                            (dx * dx) / (double) (rx * rx)
                                    + (dy * dy) / (double) (ry * ry)
                                    + (dz * dz) / (double) (rz * rz);

                    // Было 1.15 — это делало крону раздутой.
                    // 1.0 даёт более аккуратный эллипсоид.
                    if (value > 1.0) {
                        continue;
                    }

                    boolean edge =
                            Math.abs(dx) >= rx - 1 ||
                                    Math.abs(dy) >= ry ||
                                    Math.abs(dz) >= rz - 1;

                    int effectiveDensity = shape.density();

                    // Края делаем более рваными и воздушными.
                    if (edge) {
                        effectiveDensity -= 18;
                    }

                    // Нижнюю часть тоже чуть прореживаем, чтобы не было комка.
                    if (dy < 0) {
                        effectiveDensity -= 8;
                    }

                    // Самые углы почти всегда убираем.
                    if (Math.abs(dx) >= rx - 1 && Math.abs(dz) >= rz - 1) {
                        effectiveDensity -= 20;
                    }

                    effectiveDensity = Mth.clamp(effectiveDensity, 5, 100);

                    if (edge && random.nextInt(100) < shape.edgeCutChance()) {
                        continue;
                    }

                    if (random.nextInt(100) >= effectiveDensity) {
                        continue;
                    }

                    BlockPos leafPos = center.offset(dx, dy, dz);
                    tryPlaceLeaf(level, foliageSetter, random, config, leafPos);

                    if (shape.hangingLength() > 0 && dy <= 0 && random.nextInt(100) < shape.hangingChance()) {
                        placeHangingLeaves(level, foliageSetter, random, config, leafPos);
                    }
                }
            }
        }
    }

    private void placeHangingLeaves(LevelSimulatedReader level,
                                    FoliageSetter foliageSetter,
                                    RandomSource random,
                                    TreeConfiguration config,
                                    BlockPos startPos) {
        int length = 1 + random.nextInt(shape.hangingLength());

        for (int i = 1; i <= length; i++) {
            BlockPos pos = startPos.below(i);

            if (random.nextFloat() < 0.2f) {
                break;
            }

            tryPlaceLeaf(level, foliageSetter, random, config, pos);
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return shape.radiusY() * 2 + shape.hangingLength() + 1;
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

    public record ShapeSettings(
            int radiusX,
            int radiusY,
            int radiusZ,
            int clusterCount,
            int density,
            int edgeCutChance,
            int hangingChance,
            int hangingLength
    ) {
        public static final Codec<ShapeSettings> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.intRange(1, 10).fieldOf("radius_x").forGetter(ShapeSettings::radiusX),
                        Codec.intRange(1, 10).fieldOf("radius_y").forGetter(ShapeSettings::radiusY),
                        Codec.intRange(1, 10).fieldOf("radius_z").forGetter(ShapeSettings::radiusZ),
                        Codec.intRange(1, 8).fieldOf("cluster_count").forGetter(ShapeSettings::clusterCount),
                        Codec.intRange(1, 100).fieldOf("density").forGetter(ShapeSettings::density),
                        Codec.intRange(0, 100).fieldOf("edge_cut_chance").forGetter(ShapeSettings::edgeCutChance),
                        Codec.intRange(0, 100).fieldOf("hanging_chance").forGetter(ShapeSettings::hangingChance),
                        Codec.intRange(0, 6).fieldOf("hanging_length").forGetter(ShapeSettings::hangingLength)
                ).apply(instance, ShapeSettings::new)
        );
    }
}