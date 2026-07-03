package net.sima.bfme.worldgen.noise;

/**
 * Интерполятор пещер (vanilla pattern: input noises интерполируются, композиция per-block).
 *
 * <p>Все шумы вычисляются на одном grid'е <b>4×4×8</b> как в ванильном NoiseChunk.NoiseInterpolator.
 * Для тонких ridge-based туннелей (spag2D, noodle) хранятся <b>отдельные input noises</b>,
 * а финальная формула <code>min(entrances, spag2D+roughness)</code> и <code>thickness + ridges</code>
 * вычисляется per-block после интерполяции. Это:</p>
 *
 * <ul>
 *   <li>Сохраняет тонкие туннели (нет потери деталей при интерполяции min/max композиций)</li>
 *   <li>Дешевле precompute (нет min/max на gridpoint, только raw noise sampling)</li>
 *   <li>Точно соответствует vanilla NoiseRouterData.underground() и noodle() поведению</li>
 * </ul>
 *
 * <p><b>Логика isCave (ванильная underground composition):</b></p>
 * <pre>
 *   entrances = min(entranceGradient, spag3D + roughness)
 *   underground = min(cheese, entrances, spag2D + roughness)
 *   if underground &lt; 0 → cave
 *   if noodle &lt; 0 (selector активен) → cave
 *   if pillar &gt; gate → stone (защита pillar'а от carve)
 * </pre>
 */
public class CaveInterpolator {

    /** Единый grid step как в ванильном NoiseChunk (4 по XZ, 8 по Y). */
    private static final int STEP_XZ = 4;
    private static final int STEP_Y = 8;
    private static final int GX = 16 / STEP_XZ + 1;
    private static final int GZ = 16 / STEP_XZ + 1;

    private final int minY;
    private final int maxY;
    private final int gridY;

    // Гриды расплющены в 1D (float[GX*GZ*gridY], индекс = (gx*GZ+gz)*gridY+gy) — одна загрузка
    // вместо 3 деерефов 3D-массива + сплошная память (cache-friendly для 8 углов ячейки).
    private final float[] cheeseGrid;

    // Carver input noises — каждый интерполируется отдельно, композиция per-block.
    // Если соответствующий carver выключен глобально (CARVER_*_ENABLED = false), grid = null.
    private final float[] spag2DGrid;       // computeSpaghetti2D (без roughness)
    private final float[] spag3DGrid;       // computeSpaghetti3D (без roughness, без bias)
    private final float[] entranceNoiseGrid; // computeEntranceNoise (без depthGradient, без strength)
    private final float[] roughnessGrid;    // computeRoughness (shared между spag2D и spag3D)

    // Pillar grid — final density (composition внутри computePillarContribution OK для интерполяции,
    // т.к. pillars не имеют ridge-based тонких структур).
    private final float[] pillarGrid;

    // Noodle input noises — все на grid 4×8 (ваниль-паттерн, дёшево).
    private final float[] noodleSelectorGrid;
    private final float[] noodleThicknessGrid;
    private final float[] noodleRidgeAGrid;
    private final float[] noodleRidgeBGrid;

    private final int chunkStartX;
    private final int chunkStartZ;

    private final int[][] surfaceHeights;  // для per-block entrance depthGradient
    private final float[][] entranceStrengths;
    private final float[][] mediumOffsets;
    private final float[][] largeOffsets;
    private final float[][] spag3DStrengths;
    private final float[][] surfaceFadeDepths;
    private final float[][] surfaceFadeStrengths;

    private final WorldNoiseGenerator noise;

    public CaveInterpolator(WorldNoiseGenerator noise, int chunkX, int chunkZ, int[][] surfaceHeights,
                            float[][] entranceStrengths, float[][] mediumOffsets,
                            float[][] largeOffsets, float[][] spag3DStrengths,
                            float[][] surfaceFadeDepths, float[][] surfaceFadeStrengths) {
        this.noise = noise;
        this.chunkStartX = chunkX * 16;
        this.chunkStartZ = chunkZ * 16;
        this.surfaceHeights = surfaceHeights;
        this.entranceStrengths = entranceStrengths;
        this.mediumOffsets = mediumOffsets;
        this.largeOffsets = largeOffsets;
        this.spag3DStrengths = spag3DStrengths;
        this.surfaceFadeDepths = surfaceFadeDepths;
        this.surfaceFadeStrengths = surfaceFadeStrengths;
        this.minY = WorldNoiseGenerator.CAVE_MIN_Y;

        int chunkMaxHeight = Integer.MIN_VALUE;
        for (int lx = 0; lx < 16; lx++) {
            for (int lz = 0; lz < 16; lz++) {
                if (surfaceHeights[lx][lz] > chunkMaxHeight) chunkMaxHeight = surfaceHeights[lx][lz];
            }
        }
        this.maxY = Math.min(WorldNoiseGenerator.CAVE_MAX_Y, chunkMaxHeight + STEP_Y);
        this.gridY = (maxY - minY) / STEP_Y + 1;

        int gridLen = GX * GZ * gridY;
        this.cheeseGrid = new float[gridLen];

        boolean s2dEnabled = WorldNoiseGenerator.CARVER_SPAG2D_ENABLED;
        boolean s3dEnabled = WorldNoiseGenerator.CARVER_SPAG3D_ENABLED;
        boolean entEnabled = WorldNoiseGenerator.CARVER_ENTRANCE_ENABLED;

        // Per-chunk skip: если все strengths == 0 в этом чанке → noise grid не нужен.
        // Биом-уровневое выключение entrance/spag3D через config.
        if (entEnabled && !anyPositive(entranceStrengths)) entEnabled = false;
        if (s3dEnabled && !anyPositive(spag3DStrengths))  s3dEnabled = false;

        boolean needRoughness = s2dEnabled || s3dEnabled;
        this.spag2DGrid        = s2dEnabled ? new float[gridLen] : null;
        this.spag3DGrid        = s3dEnabled ? new float[gridLen] : null;
        this.entranceNoiseGrid = entEnabled ? new float[gridLen] : null;
        this.roughnessGrid     = needRoughness ? new float[gridLen] : null;

        this.pillarGrid = WorldNoiseGenerator.PILLARS_ENABLED ? new float[gridLen] : null;

        boolean noodleEnabled = WorldNoiseGenerator.CARVER_NOODLE_ENABLED;
        this.noodleSelectorGrid  = noodleEnabled ? new float[gridLen] : null;
        this.noodleThicknessGrid = noodleEnabled ? new float[gridLen] : null;
        this.noodleRidgeAGrid    = noodleEnabled ? new float[gridLen] : null;
        this.noodleRidgeBGrid    = noodleEnabled ? new float[gridLen] : null;

        precompute();
    }

    private void precompute() {
        boolean s2dEnabled = spag2DGrid != null;
        boolean s3dEnabled = spag3DGrid != null;
        boolean entEnabled = entranceNoiseGrid != null;
        boolean roughEnabled = roughnessGrid != null;
        boolean noodleEnabled = WorldNoiseGenerator.CARVER_NOODLE_ENABLED;
        boolean pillarEnabled = pillarGrid != null;
        int noodleYMin = WorldNoiseGenerator.CAVE_NOODLE_Y_MIN;
        int noodleYMax = WorldNoiseGenerator.CAVE_NOODLE_Y_MAX;

        for (int gx = 0; gx < GX; gx++) {
            for (int gz = 0; gz < GZ; gz++) {
                int worldX = chunkStartX + gx * STEP_XZ;
                int worldZ = chunkStartZ + gz * STEP_XZ;
                int localX = Math.min(gx * STEP_XZ, 15);
                int localZ = Math.min(gz * STEP_XZ, 15);
                int surfaceHeight = surfaceHeights[localX][localZ];

                float mediumOffset = mediumOffsets[localX][localZ];
                float largeOffset = largeOffsets[localX][localZ];
                float fadeDepth = surfaceFadeDepths[localX][localZ];
                float fadeStrength = surfaceFadeStrengths[localX][localZ];

                int cellBase = (gx * GZ + gz) * gridY;  // 1D base для этой (gx,gz) колонки

                for (int gy = 0; gy < gridY; gy++) {
                    int worldY = minY + gy * STEP_Y;
                    int i = cellBase + gy;

                    // === Cheese (включает свой bedrock fade и pillar MAX внутри) ===
                    cheeseGrid[i] = noise.computeCaveDensity(worldX, worldY, worldZ, surfaceHeight,
                            mediumOffset, largeOffset, fadeDepth, fadeStrength);

                    // === Carver inputs — raw noise без composition ===
                    if (s2dEnabled) {
                        // Spag2D yPenalty saturates вне активной Y полосы → result = 1.0 (no cave).
                        // Можно skip noise sampling и подставить 1.0 (~75% точек на чанк скипается).
                        if (worldY < WorldNoiseGenerator.SPAG2D_ACTIVE_Y_MIN || worldY > WorldNoiseGenerator.SPAG2D_ACTIVE_Y_MAX) {
                            spag2DGrid[i] = 1.0f;
                        } else {
                            spag2DGrid[i] = noise.computeSpaghetti2D(worldX, worldY, worldZ);
                        }
                    }
                    if (s3dEnabled)  spag3DGrid[i] = noise.computeSpaghetti3D(worldX, worldY, worldZ);
                    if (entEnabled)  entranceNoiseGrid[i] = (float) noise.computeEntranceNoise(worldX, worldY, worldZ);
                    if (roughEnabled) roughnessGrid[i] = (float) noise.computeRoughness(worldX, worldY, worldZ);

                    // === Pillar (final density — composition внутри OK, нет ridge-туннелей) ===
                    if (pillarEnabled) pillarGrid[i] = noise.computePillarContribution(worldX, worldY, worldZ);

                    // === Noodle inputs (vanilla pattern — все на grid) ===
                    if (noodleEnabled) {
                        if (worldY < noodleYMin || worldY > noodleYMax) {
                            noodleSelectorGrid[i]  = -1.0f;
                            noodleThicknessGrid[i] = -0.075f;
                            noodleRidgeAGrid[i]    = 0f;
                            noodleRidgeBGrid[i]    = 0f;
                        } else {
                            noodleSelectorGrid[i]  = (float) noise.computeNoodleSelector(worldX, worldY, worldZ);
                            noodleThicknessGrid[i] = (float) noise.computeNoodleThickness(worldX, worldY, worldZ);
                            noodleRidgeAGrid[i]    = (float) noise.computeNoodleRidgeA(worldX, worldY, worldZ);
                            noodleRidgeBGrid[i]    = (float) noise.computeNoodleRidgeB(worldX, worldY, worldZ);
                        }
                    }
                }
            }
        }
    }

    public boolean isCave(int localX, int localZ, int y, int surfaceHeight) {
        if (y > surfaceHeight) return false;
        if (y < minY || y > maxY) return false;

        // Веса trilinear считаем ОДИН раз — общие для всех гридов (хойстинг, vanilla-style).
        float gx = (float) localX / STEP_XZ;
        float gz = (float) localZ / STEP_XZ;
        float gy = (float) (y - minY) / STEP_Y;
        int gx0 = Math.min((int) gx, GX - 2);
        int gz0 = Math.min((int) gz, GZ - 2);
        int gy0 = Math.min((int) gy, gridY - 2);
        float fx = gx - gx0, fz = gz - gz0, fy = gy - gy0;

        // Pillar protection (1:1 ваниль NoiseRouterData строка 327-330):
        // pillars >= gate (active) → защищает от carve через max → блок stone
        if (pillarGrid != null) {
            float pillar = interpolateAt(pillarGrid, gx0, gz0, gy0, fx, fz, fy);
            if (pillar > WorldNoiseGenerator.CAVE_PILLAR_GATE) return false;
        }

        // Bedrock fade добавляется к carver/noodle (cheese уже имеет свой bedrock fade внутри).
        float bedrockAdd = computeBedrockAdd(y);

        float cheese = interpolateAt(cheeseGrid, gx0, gz0, gy0, fx, fz, fy);
        if (cheese < 0f) return true;

        // === Vanilla underground composition per-block ===
        //   entrances = min(entranceGradient, spag3D + roughness)
        //   carver = min(entrances, spag2D + roughness)
        float roughness = (roughnessGrid != null) ? interpolateAt(roughnessGrid, gx0, gz0, gy0, fx, fz, fy) : 0f;

        float entrances = Float.MAX_VALUE;
        float entranceStrength = entranceStrengths[localX][localZ];
        if (entranceNoiseGrid != null && entranceStrength > 0f) {
            float entNoise = interpolateAt(entranceNoiseGrid, gx0, gz0, gy0, fx, fz, fy);
            float depthGrad = (float) noise.computeEntranceDepthGradient(y, surfaceHeight);
            float offset = 0.37f + (1f - entranceStrength) * 4f;
            entrances = entNoise + depthGrad + offset;
        }
        float spag3DStrength = spag3DStrengths[localX][localZ];
        if (spag3DGrid != null && spag3DStrength > 0f) {
            float s3d = interpolateAt(spag3DGrid, gx0, gz0, gy0, fx, fz, fy) + roughness + (1f - spag3DStrength) * 0.05f;
            if (s3d < entrances) entrances = s3d;
        }
        if (entrances + bedrockAdd < 0f) return true;

        if (spag2DGrid != null) {
            float s2d = interpolateAt(spag2DGrid, gx0, gz0, gy0, fx, fz, fy) + roughness + bedrockAdd;
            if (s2d < 0f) return true;
        }

        // === Noodle (vanilla rangeChoice + thickness+ridges формула per-block) ===
        if (noodleSelectorGrid != null) {
            float selector = interpolateAt(noodleSelectorGrid, gx0, gz0, gy0, fx, fz, fy);
            if (selector >= 0f) {
                float thickness = interpolateAt(noodleThicknessGrid, gx0, gz0, gy0, fx, fz, fy);
                float rA = interpolateAt(noodleRidgeAGrid, gx0, gz0, gy0, fx, fz, fy);
                float rB = interpolateAt(noodleRidgeBGrid, gx0, gz0, gy0, fx, fz, fy);
                float ridges = WorldNoiseGenerator.NOODLE_RIDGE_MULT * Math.max(Math.abs(rA), Math.abs(rB));
                float noodle = thickness + ridges + bedrockAdd;
                if (noodle < 0f) return true;
            }
        }

        return false;
    }

    /** True если в массиве 16×16 есть хотя бы один positive элемент. */
    private static boolean anyPositive(float[][] arr) {
        for (int x = 0; x < 16; x++)
            for (int z = 0; z < 16; z++)
                if (arr[x][z] > 0f) return true;
        return false;
    }

    /** Bedrock fade smoothstep — добавляется к non-cheese density вблизи бедрока. */
    private float computeBedrockAdd(int y) {
        float bedrockFadeTop = minY + WorldNoiseGenerator.CAVE_BEDROCK_FADE;
        if (y >= bedrockFadeTop) return 0f;
        float t = (bedrockFadeTop - y) / WorldNoiseGenerator.CAVE_BEDROCK_FADE;
        t = t * t * (3f - 2f * t);
        return t * WorldNoiseGenerator.CAVE_BEDROCK_STRENGTH;
    }

    /** Публичный доступ к интерполированной cheese density для aquifer sampler. */
    public float getCheeseDensity(int localX, int localZ, int y) {
        if (y < minY || y > maxY) return 1.0f;
        return interpolate(cheeseGrid, localX, localZ, y);
    }

    /**
     * Финальная cave density для aquifer.computeSubstance() (ванильный final_density подход).
     * Возвращает MIN из cheese / carver / noodle — самая "сильная" cave density для блока.
     */
    public float getFinalCaveDensity(int localX, int localZ, int y) {
        if (y < minY || y > maxY) return 1.0f;

        // Веса trilinear считаем ОДИН раз — общие для всех гридов (хойстинг).
        float gx = (float) localX / STEP_XZ;
        float gz = (float) localZ / STEP_XZ;
        float gyv = (float) (y - minY) / STEP_Y;
        int gx0 = Math.min((int) gx, GX - 2);
        int gz0 = Math.min((int) gz, GZ - 2);
        int gy0 = Math.min((int) gyv, gridY - 2);
        float fx = gx - gx0, fz = gz - gz0, fy = gyv - gy0;

        if (pillarGrid != null) {
            float pillar = interpolateAt(pillarGrid, gx0, gz0, gy0, fx, fz, fy);
            if (pillar > WorldNoiseGenerator.CAVE_PILLAR_GATE) return Math.max(pillar, 0.1f);
        }

        float bedrockAdd = computeBedrockAdd(y);
        float result = interpolateAt(cheeseGrid, gx0, gz0, gy0, fx, fz, fy);

        // Carver composition per-block (same logic как в isCave).
        int surfaceHeight = surfaceHeights[localX][localZ];
        float roughness = (roughnessGrid != null) ? interpolateAt(roughnessGrid, gx0, gz0, gy0, fx, fz, fy) : 0f;

        float entrances = Float.MAX_VALUE;
        float entranceStrength = entranceStrengths[localX][localZ];
        if (entranceNoiseGrid != null && entranceStrength > 0f) {
            float entNoise = interpolateAt(entranceNoiseGrid, gx0, gz0, gy0, fx, fz, fy);
            float depthGrad = (float) noise.computeEntranceDepthGradient(y, surfaceHeight);
            float offset = 0.37f + (1f - entranceStrength) * 4f;
            entrances = entNoise + depthGrad + offset;
        }
        float spag3DStrength = spag3DStrengths[localX][localZ];
        if (spag3DGrid != null && spag3DStrength > 0f) {
            float s3d = interpolateAt(spag3DGrid, gx0, gz0, gy0, fx, fz, fy) + roughness + (1f - spag3DStrength) * 0.05f;
            if (s3d < entrances) entrances = s3d;
        }
        float entrancesFinal = entrances + bedrockAdd;
        if (entrancesFinal < result) result = entrancesFinal;

        if (spag2DGrid != null) {
            float s2d = interpolateAt(spag2DGrid, gx0, gz0, gy0, fx, fz, fy) + roughness + bedrockAdd;
            if (s2d < result) result = s2d;
        }

        if (noodleSelectorGrid != null) {
            float selector = interpolateAt(noodleSelectorGrid, gx0, gz0, gy0, fx, fz, fy);
            if (selector >= 0f) {
                float thickness = interpolateAt(noodleThicknessGrid, gx0, gz0, gy0, fx, fz, fy);
                float rA = interpolateAt(noodleRidgeAGrid, gx0, gz0, gy0, fx, fz, fy);
                float rB = interpolateAt(noodleRidgeBGrid, gx0, gz0, gy0, fx, fz, fy);
                float ridges = WorldNoiseGenerator.NOODLE_RIDGE_MULT * Math.max(Math.abs(rA), Math.abs(rB));
                float noodle = thickness + ridges + bedrockAdd;
                if (noodle < result) result = noodle;
            }
        }

        return result;
    }

    /**
     * Trilinear интерполяция на едином 4×4×8 grid'е — одиночный вызов (сам считает веса).
     * Для multi-grid точек (isCave/getFinalCaveDensity) используется {@link #interpolateAt}
     * с предпосчитанными весами (все гриды одной размерности → индексы/дроби общие).
     */
    private float interpolate(float[] grid, int localX, int localZ, int y) {
        float gx = (float) localX / STEP_XZ;
        float gz = (float) localZ / STEP_XZ;
        float gy = (float) (y - minY) / STEP_Y;

        int gx0 = Math.min((int) gx, GX - 2);
        int gz0 = Math.min((int) gz, GZ - 2);
        int gy0 = Math.min((int) gy, gridY - 2);

        return interpolateAt(grid, gx0, gz0, gy0, gx - gx0, gz - gz0, gy - gy0);
    }

    /**
     * Trilinear на 1D-гриде с УЖЕ посчитанными индексами ячейки + дробями. Веса считаются
     * один раз на блок в isCave/getFinalCaveDensity и переиспользуются для всех гридов.
     * 8 углов читаются через base + страйды (sX=GZ*gridY по gx, sZ=gridY по gz, 1 по gy) —
     * одна загрузка на угол, сплошная память. Результат бит-в-бит как старый 3D вариант.
     */
    private float interpolateAt(float[] grid, int gx0, int gz0, int gy0, float fx, float fz, float fy) {
        int sX = GZ * gridY;                 // страйд по gx
        int sZ = gridY;                      // страйд по gz
        int base = gx0 * sX + gz0 * sZ + gy0;

        float c000 = grid[base];
        float c100 = grid[base + sX];
        float c010 = grid[base + sZ];
        float c110 = grid[base + sX + sZ];
        float c001 = grid[base + 1];
        float c101 = grid[base + sX + 1];
        float c011 = grid[base + sZ + 1];
        float c111 = grid[base + sX + sZ + 1];

        float c00 = c000 + (c100 - c000) * fx;
        float c10 = c010 + (c110 - c010) * fx;
        float c01 = c001 + (c101 - c001) * fx;
        float c11 = c011 + (c111 - c011) * fx;

        float c0 = c00 + (c10 - c00) * fz;
        float c1 = c01 + (c11 - c01) * fz;

        return c0 + (c1 - c0) * fy;
    }
}
