package net.sima.bfme.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.sima.bfme.worldgen.tree.ModTrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class RootedBranchingTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<RootedBranchingTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            trunkPlacerParts(instance)
                    .and(BranchSettings.CODEC.fieldOf("branches").forGetter(p -> p.branches))
                    .and(RootSettings.CODEC.fieldOf("roots").forGetter(p -> p.roots))
                    .and(TrunkShapeSettings.CODEC.optionalFieldOf("trunk_shape", TrunkShapeSettings.DEFAULT).forGetter(p -> p.trunkShape))
                    .apply(instance, RootedBranchingTrunkPlacer::new)
    );

    private final BranchSettings branches;
    private final RootSettings roots;
    private final TrunkShapeSettings trunkShape;

    /**
     * Старый конструктор. Оставлен, чтобы не сломать уже созданные деревья.
     * По умолчанию ствол обычный 1x1.
     */
    public RootedBranchingTrunkPlacer(int baseHeight,
                                      int heightRandA,
                                      int heightRandB,
                                      int branchCountMin,
                                      int branchCountMax,
                                      int branchLengthMin,
                                      int branchLengthMax,
                                      int bendStrength,
                                      int branchStartPercent,
                                      int branchUpPercent,
                                      int rootCountMin,
                                      int rootCountMax,
                                      int rootLengthMin,
                                      int rootLengthMax,
                                      boolean wideBase) {
        this(
                baseHeight,
                heightRandA,
                heightRandB,
                branchCountMin,
                branchCountMax,
                branchLengthMin,
                branchLengthMax,
                bendStrength,
                branchStartPercent,
                branchUpPercent,
                rootCountMin,
                rootCountMax,
                rootLengthMin,
                rootLengthMax,
                wideBase,
                0,
                0,
                0
        );
    }

    /**
     * Новый конструктор с толщиной ствола.
     *
     * trunkRadiusMin / trunkRadiusMax:
     * 0 = обычный тонкий ствол 1x1
     * 1 = толстый ствол
     * 2 = супер толстый ствол
     *
     * Если указать 0..2, дерево будет иногда тонким, иногда толстым, иногда супер толстым.
     */
    public RootedBranchingTrunkPlacer(int baseHeight,
                                      int heightRandA,
                                      int heightRandB,
                                      int branchCountMin,
                                      int branchCountMax,
                                      int branchLengthMin,
                                      int branchLengthMax,
                                      int bendStrength,
                                      int branchStartPercent,
                                      int branchUpPercent,
                                      int rootCountMin,
                                      int rootCountMax,
                                      int rootLengthMin,
                                      int rootLengthMax,
                                      boolean wideBase,
                                      int trunkRadiusMin,
                                      int trunkRadiusMax,
                                      int baseFlareHeight) {
        this(
                baseHeight,
                heightRandA,
                heightRandB,
                new BranchSettings(
                        branchCountMin,
                        branchCountMax,
                        branchLengthMin,
                        branchLengthMax,
                        bendStrength,
                        branchStartPercent,
                        branchUpPercent
                ),
                new RootSettings(
                        rootCountMin,
                        rootCountMax,
                        rootLengthMin,
                        rootLengthMax,
                        wideBase
                ),
                new TrunkShapeSettings(
                        trunkRadiusMin,
                        trunkRadiusMax,
                        baseFlareHeight
                )
        );
    }

    public RootedBranchingTrunkPlacer(int baseHeight,
                                      int heightRandA,
                                      int heightRandB,
                                      BranchSettings branches,
                                      RootSettings roots) {
        this(baseHeight, heightRandA, heightRandB, branches, roots, TrunkShapeSettings.DEFAULT);
    }

    public RootedBranchingTrunkPlacer(int baseHeight,
                                      int heightRandA,
                                      int heightRandB,
                                      BranchSettings branches,
                                      RootSettings roots,
                                      TrunkShapeSettings trunkShape) {
        super(baseHeight, heightRandA, heightRandB);
        this.branches = branches;
        this.roots = roots;
        this.trunkShape = trunkShape;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.ROOTED_BRANCHING_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level,
                                                            BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource random,
                                                            int freeTreeHeight,
                                                            BlockPos startPos,
                                                            TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();
        List<BlockPos> trunkPath = new ArrayList<>();

        setDirtAt(level, blockSetter, random, startPos.below(), config);

        int selectedTrunkRadius = chooseTrunkRadius(random);

        placeRoots(level, blockSetter, random, startPos, config);

        /*
         * Важная логика:
         * - тонкий ствол может быть слегка кривым;
         * - толстый и супер толстый ствол делаем прямым, как ты и хотел.
         */
        boolean thickTrunk = selectedTrunkRadius > 0;

        double bendAngle = random.nextDouble() * Math.PI * 2.0;
        double bendStrengthBlocks = thickTrunk ? 0.0 : branches.bendStrength() / 100.0;

        BlockPos previousCenter = startPos;

        for (int y = 0; y < freeTreeHeight; y++) {
            double t = freeTreeHeight <= 1 ? 0.0 : (double) y / (double) (freeTreeHeight - 1);

            double curve = Math.sin(t * Math.PI * 0.85);
            int dx = Mth.floor(Math.cos(bendAngle) * bendStrengthBlocks * curve);
            int dz = Mth.floor(Math.sin(bendAngle) * bendStrengthBlocks * curve);
// Первые блоки ствола всегда стоят строго над саженцем.
// Иначе дерево может начать изгибаться уже на 1-2 блоке,
// и получается "ствол в воздухе" рядом с нижним блоком.
            if (y < 3) {
                dx = 0;
                dz = 0;
            }
            BlockPos center = startPos.offset(dx, y, dz);

            if (!center.equals(previousCenter)) {
                placeLogLine(level, blockSetter, random, previousCenter, center, config, Direction.Axis.Y);
            }

            placeTrunkLayer(level, blockSetter, random, center, config, selectedTrunkRadius, y);

            trunkPath.add(center);
            previousCenter = center;
        }

        if (roots.wideBase()) {
            placeWideBase(level, blockSetter, random, startPos, config);
        }

        BlockPos topPos = trunkPath.isEmpty() ? startPos.above(freeTreeHeight) : trunkPath.get(trunkPath.size() - 1);

        int branchCount = randomBetween(random, branches.countMin(), branches.countMax());

        if (branchCount > 0 && trunkPath.size() > 3) {
            double firstBranchAngle = random.nextDouble() * Math.PI * 2.0;

            int minBranchY = Mth.clamp(
                    Mth.floor(freeTreeHeight * (branches.startPercent() / 100.0)),
                    1,
                    Math.max(1, freeTreeHeight - 2)
            );

            for (int i = 0; i < branchCount; i++) {
                int branchLength = randomBetween(random, branches.lengthMin(), branches.lengthMax());

                int startIndex = Mth.clamp(
                        minBranchY + random.nextInt(Math.max(1, freeTreeHeight - minBranchY)),
                        1,
                        trunkPath.size() - 1
                );

                double angle = firstBranchAngle
                        + ((Math.PI * 2.0) / Math.max(1, branchCount)) * i
                        + randomBetweenDouble(random, -0.45, 0.45);

                BlockPos branchStartCenter = trunkPath.get(startIndex);
                BlockPos branchStart = getBranchStartAtTrunkEdge(branchStartCenter, angle, selectedTrunkRadius);

                /*
                 * Если ствол толстый, ветка начинается не из центра ствола,
                 * а с края, чтобы визуально выходила из дерева.
                 */
                BlockPos branchEnd = placeBranch(
                        level,
                        blockSetter,
                        random,
                        branchStart,
                        angle,
                        branchLength,
                        branches.upPercent(),
                        config
                );

                foliageAttachments.add(new FoliagePlacer.FoliageAttachment(branchEnd.above(), -2, false));
            }
        }
        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(topPos.above(), 0, false));

        return foliageAttachments;
    }

    private int chooseTrunkRadius(RandomSource random) {
        int min = Math.min(trunkShape.radiusMin(), trunkShape.radiusMax());
        int max = Math.max(trunkShape.radiusMin(), trunkShape.radiusMax());

        min = Mth.clamp(min, 0, 3);
        max = Mth.clamp(max, 0, 3);

        return randomBetween(random, min, max);
    }

    private void placeTrunkLayer(LevelSimulatedReader level,
                                 BiConsumer<BlockPos, BlockState> blockSetter,
                                 RandomSource random,
                                 BlockPos center,
                                 TreeConfiguration config,
                                 int selectedTrunkRadius,
                                 int yFromGround) {
        if (selectedTrunkRadius <= 0) {
            placeVerticalLog(level, blockSetter, random, center, config);
            return;
        }

        int radius = selectedTrunkRadius;

        /*
         * Утолщение у основания:
         * первые несколько блоков имеют чуть более широкую форму.
         * Это не корни, а именно массивное основание ствола.
         */
        if (trunkShape.baseFlareHeight() > 0 && yFromGround < trunkShape.baseFlareHeight()) {
            if (yFromGround == 0) {
                radius = selectedTrunkRadius + 1;
            } else if (yFromGround == 1 && selectedTrunkRadius >= 2) {
                radius = selectedTrunkRadius + 1;
            }
        }

        placeOrganicTrunkDisc(level, blockSetter, random, center, config, radius, yFromGround);
    }
    private void placeOrganicTrunkDisc(LevelSimulatedReader level,
                                       BiConsumer<BlockPos, BlockState> blockSetter,
                                       RandomSource random,
                                       BlockPos center,
                                       TreeConfiguration config,
                                       int radius,
                                       int yFromGround) {
        if (radius <= 0) {
            placeVerticalLog(level, blockSetter, random, center, config);
            return;
        }

        // radius 1 = аккуратный 2x2 ствол.
        // Не режем углы, не делаем зубцы.
        if (radius == 1) {
            placeVerticalLog(level, blockSetter, random, center, config);
            placeVerticalLog(level, blockSetter, random, center.east(), config);
            placeVerticalLog(level, blockSetter, random, center.south(), config);
            placeVerticalLog(level, blockSetter, random, center.east().south(), config);

            // Небольшое утолщение только у самой земли.
            if (yFromGround == 0) {
                placeVerticalLog(level, blockSetter, random, center.west(), config);
                placeVerticalLog(level, blockSetter, random, center.north(), config);
            }

            return;
        }

        // radius 2 = нормальный 3x3 ствол.
        // Для баобаба, маллорна, секвойи.
        if (radius == 2) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    placeVerticalLog(level, blockSetter, random, center.offset(dx, 0, dz), config);
                }
            }

            // Утолщение основания: только нижний слой, без зубчатых дырок.
            if (yFromGround == 0) {
                placeVerticalLog(level, blockSetter, random, center.offset(2, 0, 0), config);
                placeVerticalLog(level, blockSetter, random, center.offset(-2, 0, 0), config);
                placeVerticalLog(level, blockSetter, random, center.offset(0, 0, 2), config);
                placeVerticalLog(level, blockSetter, random, center.offset(0, 0, -2), config);
            }

            return;
        }

        // На будущее: radius 3 = 5x5, но без дырок.
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                if (Math.abs(dx) == 2 && Math.abs(dz) == 2) {
                    continue;
                }

                placeVerticalLog(level, blockSetter, random, center.offset(dx, 0, dz), config);
            }
        }
    }

    private boolean isInsideOrganicTrunkShape(int dx, int dz, int radius, int yFromGround) {
        int ax = Math.abs(dx);
        int az = Math.abs(dz);

        if (radius <= 0) {
            return dx == 0 && dz == 0;
        }

        /*
         * radius 1:
         *  XXX
         *  XXX
         *  XXX
         *
         * Но выше основания иногда срезаем дальние углы,
         * чтобы ствол не был идеальным квадратом.
         */
        if (radius == 1) {
            if (ax <= 1 && az <= 1) {
                if (ax == 1 && az == 1 && yFromGround > 1) {
                    return yFromGround % 3 != 0;
                }

                return true;
            }

            return false;
        }

        /*
         * radius 2:
         *   XXX
         *  XXXXX
         *  XXXXX
         *  XXXXX
         *   XXX
         *
         * Это уже супер толстый органичный ствол.
         */
        if (radius == 2) {
            return ax + az <= 3 && ax <= 2 && az <= 2;
        }

        /*
         * radius 3:
         * очень массивный ствол, если вдруг понадобится для огромного маллорна/секвойи.
         */
        int distanceSq = dx * dx + dz * dz;
        int limit = radius * radius + 1;

        if (distanceSq > limit) {
            return false;
        }

        // Самые дальние углы убираем.
        return !(ax == radius && az >= radius - 1) && !(az == radius && ax >= radius - 1);
    }

    private BlockPos getBranchStartAtTrunkEdge(BlockPos center, double angle, int selectedTrunkRadius) {
        if (selectedTrunkRadius <= 0) {
            return center;
        }

        int dx = Mth.floor(Math.cos(angle) * selectedTrunkRadius);
        int dz = Mth.floor(Math.sin(angle) * selectedTrunkRadius);

        return center.offset(dx, 0, dz);
    }

    private void placeRoots(LevelSimulatedReader level,
                            BiConsumer<BlockPos, BlockState> blockSetter,
                            RandomSource random,
                            BlockPos startPos,
                            TreeConfiguration config) {
        int rootCount = randomBetween(random, roots.countMin(), roots.countMax());

        if (rootCount <= 0) {
            return;
        }

        BlockPos rootBase = startPos.below();

        double baseAngle = random.nextDouble() * Math.PI * 2.0;

        for (int i = 0; i < rootCount; i++) {
            double angle = baseAngle
                    + ((Math.PI * 2.0) / Math.max(1, rootCount)) * i
                    + randomBetweenDouble(random, -0.35, 0.35);

            int rootLength = randomBetween(random, roots.lengthMin(), roots.lengthMax());

            BlockPos previous = rootBase;

            for (int step = 1; step <= rootLength; step++) {
                int dx = Mth.floor(Math.cos(angle) * step);
                int dz = Mth.floor(Math.sin(angle) * step);

                int dy = -1;

                if (step > 2 && random.nextFloat() < 0.35f) {
                    dy = -2;
                }

                BlockPos current = startPos.offset(dx, dy, dz);
                Direction.Axis axis = axisFromAngle(angle);

                placeRootLogLine(level, blockSetter, random, previous, current, config, axis);

                previous = current;

                if (step >= 2 && random.nextFloat() < 0.18f) {
                    break;
                }
            }
        }
    }

    private void placeWideBase(LevelSimulatedReader level,
                               BiConsumer<BlockPos, BlockState> blockSetter,
                               RandomSource random,
                               BlockPos startPos,
                               TreeConfiguration config) {
        BlockPos base = startPos.below();

        forcePlaceAxisLog(level, blockSetter, random, base.north(), config, Direction.Axis.Z);
        forcePlaceAxisLog(level, blockSetter, random, base.south(), config, Direction.Axis.Z);
        forcePlaceAxisLog(level, blockSetter, random, base.west(), config, Direction.Axis.X);
        forcePlaceAxisLog(level, blockSetter, random, base.east(), config, Direction.Axis.X);

        if (random.nextFloat() < 0.45f) {
            forcePlaceAxisLog(level, blockSetter, random, base.north().west(), config, Direction.Axis.X);
        }

        if (random.nextFloat() < 0.45f) {
            forcePlaceAxisLog(level, blockSetter, random, base.south().east(), config, Direction.Axis.X);
        }
    }

    private BlockPos placeBranch(LevelSimulatedReader level,
                                 BiConsumer<BlockPos, BlockState> blockSetter,
                                 RandomSource random,
                                 BlockPos start,
                                 double angle,
                                 int length,
                                 int upPercent,
                                 TreeConfiguration config) {
        BlockPos previous = start;
        BlockPos last = start;

        double up = length * (upPercent / 100.0);
        double arcHeight = 0.75 + random.nextDouble() * 1.25;

        Direction.Axis axis = axisFromAngle(angle);

        for (int step = 1; step <= length; step++) {
            double t = (double) step / (double) length;

            int dx = Mth.floor(Math.cos(angle) * step);
            int dz = Mth.floor(Math.sin(angle) * step);

            int dy = Mth.floor(t * up + Math.sin(t * Math.PI) * arcHeight);

            BlockPos current = start.offset(dx, dy, dz);

            placeLogLine(level, blockSetter, random, previous, current, config, axis);

            previous = current;
            last = current;
        }

        return last;
    }

    private void placeLogLine(LevelSimulatedReader level,
                              BiConsumer<BlockPos, BlockState> blockSetter,
                              RandomSource random,
                              BlockPos from,
                              BlockPos to,
                              TreeConfiguration config,
                              Direction.Axis axis) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();

        int steps = Math.max(Math.max(Math.abs(dx), Math.abs(dy)), Math.abs(dz));

        if (steps == 0) {
            tryPlaceAxisLog(level, blockSetter, random, from, config, axis);
            return;
        }

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / (double) steps;

            int x = Mth.floor(from.getX() + dx * t + 0.5);
            int y = Mth.floor(from.getY() + dy * t + 0.5);
            int z = Mth.floor(from.getZ() + dz * t + 0.5);

            tryPlaceAxisLog(level, blockSetter, random, new BlockPos(x, y, z), config, axis);
        }
    }

    private void placeRootLogLine(LevelSimulatedReader level,
                                  BiConsumer<BlockPos, BlockState> blockSetter,
                                  RandomSource random,
                                  BlockPos from,
                                  BlockPos to,
                                  TreeConfiguration config,
                                  Direction.Axis axis) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();

        int steps = Math.max(Math.max(Math.abs(dx), Math.abs(dy)), Math.abs(dz));

        if (steps == 0) {
            forcePlaceAxisLog(level, blockSetter, random, from, config, axis);
            return;
        }

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / (double) steps;

            int x = Mth.floor(from.getX() + dx * t + 0.5);
            int y = Mth.floor(from.getY() + dy * t + 0.5);
            int z = Mth.floor(from.getZ() + dz * t + 0.5);

            forcePlaceAxisLog(level, blockSetter, random, new BlockPos(x, y, z), config, axis);
        }
    }

    private void placeVerticalLog(LevelSimulatedReader level,
                                  BiConsumer<BlockPos, BlockState> blockSetter,
                                  RandomSource random,
                                  BlockPos pos,
                                  TreeConfiguration config) {
        tryPlaceAxisLog(level, blockSetter, random, pos, config, Direction.Axis.Y);
    }

    private void tryPlaceAxisLog(LevelSimulatedReader level,
                                 BiConsumer<BlockPos, BlockState> blockSetter,
                                 RandomSource random,
                                 BlockPos pos,
                                 TreeConfiguration config,
                                 Direction.Axis axis) {
        placeLog(level, blockSetter, random, pos, config, state -> {
            if (state.hasProperty(RotatedPillarBlock.AXIS)) {
                return state.setValue(RotatedPillarBlock.AXIS, axis);
            }

            return state;
        });
    }

    private void forcePlaceAxisLog(LevelSimulatedReader level,
                                   BiConsumer<BlockPos, BlockState> blockSetter,
                                   RandomSource random,
                                   BlockPos pos,
                                   TreeConfiguration config,
                                   Direction.Axis axis) {
        BlockState state = config.trunkProvider.getState(random, pos);

        if (state.hasProperty(RotatedPillarBlock.AXIS)) {
            state = state.setValue(RotatedPillarBlock.AXIS, axis);
        }

        blockSetter.accept(pos, state);
    }

    private Direction.Axis axisFromAngle(double angle) {
        double x = Math.abs(Math.cos(angle));
        double z = Math.abs(Math.sin(angle));

        return x >= z ? Direction.Axis.X : Direction.Axis.Z;
    }

    private int randomBetween(RandomSource random, int min, int max) {
        if (max <= min) {
            return min;
        }

        return min + random.nextInt(max - min + 1);
    }

    private double randomBetweenDouble(RandomSource random, double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    public record BranchSettings(
            int countMin,
            int countMax,
            int lengthMin,
            int lengthMax,
            int bendStrength,
            int startPercent,
            int upPercent
    ) {
        public static final Codec<BranchSettings> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.intRange(0, 16).fieldOf("count_min").forGetter(BranchSettings::countMin),
                        Codec.intRange(0, 16).fieldOf("count_max").forGetter(BranchSettings::countMax),
                        Codec.intRange(1, 24).fieldOf("length_min").forGetter(BranchSettings::lengthMin),
                        Codec.intRange(1, 24).fieldOf("length_max").forGetter(BranchSettings::lengthMax),
                        Codec.intRange(0, 600).fieldOf("bend_strength").forGetter(BranchSettings::bendStrength),
                        Codec.intRange(0, 100).fieldOf("start_percent").forGetter(BranchSettings::startPercent),
                        Codec.intRange(-100, 200).fieldOf("up_percent").forGetter(BranchSettings::upPercent)
                ).apply(instance, BranchSettings::new)
        );
    }

    public record RootSettings(
            int countMin,
            int countMax,
            int lengthMin,
            int lengthMax,
            boolean wideBase
    ) {
        public static final Codec<RootSettings> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.intRange(0, 12).fieldOf("count_min").forGetter(RootSettings::countMin),
                        Codec.intRange(0, 12).fieldOf("count_max").forGetter(RootSettings::countMax),
                        Codec.intRange(1, 12).fieldOf("length_min").forGetter(RootSettings::lengthMin),
                        Codec.intRange(1, 12).fieldOf("length_max").forGetter(RootSettings::lengthMax),
                        Codec.BOOL.fieldOf("wide_base").forGetter(RootSettings::wideBase)
                ).apply(instance, RootSettings::new)
        );
    }

    public record TrunkShapeSettings(
            int radiusMin,
            int radiusMax,
            int baseFlareHeight
    ) {
        public static final TrunkShapeSettings DEFAULT = new TrunkShapeSettings(0, 0, 0);

        public static final Codec<TrunkShapeSettings> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.intRange(0, 3).fieldOf("radius_min").forGetter(TrunkShapeSettings::radiusMin),
                        Codec.intRange(0, 3).fieldOf("radius_max").forGetter(TrunkShapeSettings::radiusMax),
                        Codec.intRange(0, 8).fieldOf("base_flare_height").forGetter(TrunkShapeSettings::baseFlareHeight)
                ).apply(instance, TrunkShapeSettings::new)
        );
    }
}