package net.sima.bfme.worldgen.noise;

import java.util.Random;

/**
 * ОКТАВНЫЙ ШУМ v3 — на базе OpenSimplex2S (SMOOTH variant)
 *
 * Изменения v3:
 * - OpenSimplex2S вместо OpenSimplex2
 * - Лучше для террейна: плавнее, без диагональных артефактов
 * - RSQUARED = 2/3 даёт более мягкие переходы
 */
public class OctaveNoise {

    // === MUSGRAVE HYBRID MULTIFRACTAL ===
    private static final boolean ENABLE_MULTIFRACTAL = false;
    private static final double MULTIFRACTAL_GAIN = 0.6;
    private static final double MULTIFRACTAL_H = 1.0;

    private final long baseSeed;
    private final int octaves;
    private final double scale;
    private final double persistence;
    private final double lacunarity;

    // Уникальные seed'ы для каждой октавы
    private final long[] octaveSeeds;

    // Pre-computed spectral weights для multifractal (h=1.0, 1/f спектр)
    private final double[] spectralWeights;
    private final double normalizationMax;

    public OctaveNoise(long seed, int octaves, double scale, double persistence, double lacunarity) {
        this.baseSeed = seed;
        this.octaves = octaves;
        this.scale = scale;
        this.persistence = persistence;
        this.lacunarity = lacunarity;

        // Генерируем уникальный seed для каждой октавы
        octaveSeeds = new long[octaves];
        Random random = new Random(seed);
        for (int i = 0; i < octaves; i++) {
            octaveSeeds[i] = random.nextLong();
        }

        // Pre-compute spectral weights: spectralWeights[i] = freq^(-h)
        spectralWeights = new double[octaves];
        double freq = 1.0;
        double maxAccum = 0;
        for (int i = 0; i < octaves; i++) {
            spectralWeights[i] = Math.pow(freq, -MULTIFRACTAL_H);
            maxAccum += spectralWeights[i];  // signal=1 на каждой октаве в худшем случае
            freq *= lacunarity;
        }
        normalizationMax = maxAccum;
    }

    /**
     * 2D шум — для heightmap, континентов, всего террейна
     * Использует OpenSimplex2S для плавности
     */
    public double sample2D(double x, double z) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            total += OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ) * amplitude;

            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return total / maxValue;
    }

    /**
     * 2D шум с кастомными параметрами октав.
     */
    public double sample2D(double x, double z, double overridePersistence, double overrideLacunarity) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            total += OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ) * amplitude;

            maxValue += amplitude;
            amplitude *= overridePersistence;
            frequency *= overrideLacunarity;
        }

        return total / maxValue;
    }

    /**
     * 2D ridged шум — Musgrave Hybrid Multifractal (TerraForged RidgeNoise.java:70-93).
     * Динамический weight даёт мульти-фрактальный эффект: на плоских участках
     * мелкие октавы автоматически давятся, на гребнях — полная детализация.
     */
    public double sampleRidged2D(double x, double z) {
        if (!ENABLE_MULTIFRACTAL) {
            return sampleRidged2DLegacy(x, z);
        }

        double value = 0;
        double weight = 1.0;
        double amp = 1.0;
        double sx = x / scale;
        double sz = z / scale;

        for (int i = 0; i < octaves; i++) {
            double n = OpenSimplex2S.noise2(octaveSeeds[i], sx, sz);
            double ridge = 1.0 - Math.abs(n);
            double signal = ridge * ridge;        // (1 - |n|)^2

            signal *= weight;
            weight = Math.min(1.0, Math.max(0.0, signal * amp));

            value += signal * spectralWeights[i];

            sx *= lacunarity;
            sz *= lacunarity;
            amp *= MULTIFRACTAL_GAIN;
        }

        return value / normalizationMax;
    }

    public double sampleRidged2D(double x, double z, double overridePersistence, double overrideLacunarity) {
        if (!ENABLE_MULTIFRACTAL) {
            return sampleRidged2DLegacy(x, z, overridePersistence, overrideLacunarity);
        }

        // Пересчитываем spectralWeights и normalizationMax для override lacunarity
        // (h=1.0 и gain фиксированы)
        double freq = 1.0;
        double maxAccum = 0;
        double[] localWeights = new double[octaves];
        for (int i = 0; i < octaves; i++) {
            localWeights[i] = Math.pow(freq, -MULTIFRACTAL_H);
            maxAccum += localWeights[i];
            freq *= overrideLacunarity;
        }

        double value = 0;
        double weight = 1.0;
        double amp = 1.0;
        double sx = x / scale;
        double sz = z / scale;

        for (int i = 0; i < octaves; i++) {
            double n = OpenSimplex2S.noise2(octaveSeeds[i], sx, sz);
            double ridge = 1.0 - Math.abs(n);
            double signal = ridge * ridge;
            signal *= weight;
            weight = Math.min(1.0, Math.max(0.0, signal * amp));
            value += signal * localWeights[i];
            sx *= overrideLacunarity;
            sz *= overrideLacunarity;
            amp *= MULTIFRACTAL_GAIN;
        }

        return value / maxAccum;
    }

    // OLD: simple ridged fBm, replaced by Musgrave Hybrid Multifractal
    private double sampleRidged2DLegacy(double x, double z) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;
        double weight = 1;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double noiseValue = OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ);
            noiseValue = 1.0 - Math.abs(noiseValue);
            noiseValue = noiseValue * noiseValue * weight;

            weight = Math.min(1.0, Math.max(0.0, noiseValue * 1.5));

            total += noiseValue * amplitude;
            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return total / maxValue;
    }

    // OLD: simple ridged fBm with override (lacunarity / persistence)
    private double sampleRidged2DLegacy(double x, double z, double overridePersistence, double overrideLacunarity) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;
        double weight = 1;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double noiseValue = OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ);
            noiseValue = 1.0 - Math.abs(noiseValue);
            noiseValue = noiseValue * noiseValue * weight;
            weight = Math.min(1.0, Math.max(0.0, noiseValue * 1.5));

            total += noiseValue * amplitude;
            maxValue += amplitude;
            amplitude *= overridePersistence;
            frequency *= overrideLacunarity;
        }

        return total / maxValue;
    }

    /**
     * 2D billow шум — округлые холмы.
     * Multifractal: billow = 1 - ridged (как в TerraForged BillowNoise).
     */
    public double sampleBillow2D(double x, double z) {
        if (!ENABLE_MULTIFRACTAL) return sampleBillow2DLegacy(x, z);
        return 1.0 - sampleRidged2D(x, z);
    }

    public double sampleBillow2D(double x, double z, double overridePersistence, double overrideLacunarity) {
        if (!ENABLE_MULTIFRACTAL) return sampleBillow2DLegacy(x, z, overridePersistence, overrideLacunarity);
        return 1.0 - sampleRidged2D(x, z, overridePersistence, overrideLacunarity);
    }

    // OLD: abs-based billow
    private double sampleBillow2DLegacy(double x, double z) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double noiseValue = OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ);
            noiseValue = Math.abs(noiseValue);  // Billow: abs создаёт округлые формы

            total += noiseValue * amplitude;
            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return total / maxValue;
    }

    // OLD: abs-based billow with override
    private double sampleBillow2DLegacy(double x, double z, double overridePersistence, double overrideLacunarity) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double noiseValue = OpenSimplex2S.noise2(octaveSeeds[i], sampleX, sampleZ);
            noiseValue = Math.abs(noiseValue);

            total += noiseValue * amplitude;
            maxValue += amplitude;
            amplitude *= overridePersistence;
            frequency *= overrideLacunarity;
        }

        return total / maxValue;
    }

    /**
     * 2D cellular шум (Worley/Voronoi distance) — для скалистых областей, badlands
     * Возвращает расстояние до ближайшей точки Voronoi
     */
    public double sampleCellular2D(double x, double z) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double cellValue = cellularNoise2D(octaveSeeds[i], sampleX, sampleZ);

            total += cellValue * amplitude;
            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return total / maxValue;
    }

    public double sampleCellular2D(double x, double z, double overridePersistence, double overrideLacunarity) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleZ = z / scale * frequency;

            double cellValue = cellularNoise2D(octaveSeeds[i], sampleX, sampleZ);

            total += cellValue * amplitude;
            maxValue += amplitude;
            amplitude *= overridePersistence;
            frequency *= overrideLacunarity;
        }

        return total / maxValue;
    }

    /**
     * Базовый cellular noise — расстояние до ближайшей точки
     */
    private double cellularNoise2D(long seed, double x, double z) {
        int xi = (int) Math.floor(x);
        int zi = (int) Math.floor(z);

        double minDist = Double.MAX_VALUE;

        // Проверяем 3x3 окрестность
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                int cx = xi + dx;
                int cz = zi + dz;

                // Jittered point внутри ячейки
                long hash = hashCell(seed, cx, cz);
                double jitterX = (hash & 0xFFFF) / 65535.0;
                double jitterZ = ((hash >> 16) & 0xFFFF) / 65535.0;

                double pointX = cx + jitterX;
                double pointZ = cz + jitterZ;

                // Евклидово расстояние
                double deltaX = pointX - x;
                double deltaZ = pointZ - z;
                double dist = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }

        // Нормализуем примерно в 0-1 (максимум ~0.7 для unit cell)
        return Math.min(minDist * 1.4, 1.0);
    }

    private long hashCell(long seed, int x, int z) {
        long h = seed ^ (x * 0x27BB2EE687B0B0FDL) ^ (z * 0xB4823D217E233F9L);
        h = (h ^ (h >> 27)) * 0x94D049BB133111EBL;
        return h;
    }

    /**
     * 3D шум — для пещер и 3D структур
     * noise3_ImproveXY: X,Z — горизонталь, Y — вертикаль (Minecraft)
     */
    public double sample3D(double x, double y, double z) {
        double total = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            double sampleX = x / scale * frequency;
            double sampleY = y / scale * frequency;
            double sampleZ = z / scale * frequency;

            total += OpenSimplex2S.noise3_ImproveXY(octaveSeeds[i], sampleX, sampleZ, sampleY) * amplitude;

            maxValue += amplitude;
            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return total / maxValue;
    }

    // === Геттеры ===
    public long getSeed() { return baseSeed; }
    public int getOctaves() { return octaves; }
    public double getScale() { return scale; }

    // ========== PATTERN-SYSTEM OPS (RTF-style) ==========

    /**
     * Alpha operation (RTF Noises.alpha): сжимает диапазон шума в сторону единицы.
     * Принимает значение шума в [-1, 1] и возвращает его в [1 - a, 1].
     * При a = 0.45 → [0.55, 1.0]. Используется как модулирующая mask:
     * pattern.value * noise.sampleAsAlpha(...) приглушает рельеф там, где mask низкий.
     *
     * Статический: не зависит от instance state — операция чисто над числом.
     */
    public static double alpha(double noiseValue, double a) {
        double normalized = (noiseValue + 1.0) * 0.5; // [-1,1] -> [0,1]
        return (1.0 - a) + a * normalized;
    }

    /**
     * Сэмплирует sample2D и сразу применяет {@link #alpha(double, double)}.
     * Удобно для mask-операций в pattern-формулах.
     */
    public double sampleAsAlpha(double x, double z, double alphaValue) {
        return alpha(sample2D(x, z), alphaValue);
    }
}