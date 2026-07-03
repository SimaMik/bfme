# Задача: Оптимизация пещер — интерполяция на сетке 4×4×4

## Проблема
isCave() вызывается для каждого блока в столбце (~480 блоков × 256 столбцов = 122880 раз на чанк).
Каждый вызов считает 4 cheese noise (по 7 октав каждый) + spaghetti (3 noise).
Итого ~37 noise вызовов × 122880 = ~4.5 миллиона noise вызовов на чанк. Очень медленно.

## Решение
Как ванилла: считаем cheese noise на РЕДКОЙ сетке (каждые 4 блока), между ними интерполируем.
Вместо 122880 блоков считаем ~3000 точек сетки. В ~40 раз быстрее.

## Архитектура

### Новый класс: CaveInterpolator.java
Пакет: `net.sima.bfme.worldgen.noise`

```java
package net.sima.bfme.worldgen.noise;

/**
 * Предвычисляет cave density на сетке 4×4×4 для всего чанка,
 * затем трилинейно интерполирует для каждого блока.
 * 
 * Вместо ~122000 вызовов sampleCheeseNoise → ~3000.
 * Ускорение ~40 раз.
 */
public class CaveInterpolator {

    private static final int STEP = 4;  // размер ячейки интерполяции
    
    // Размеры сетки для одного чанка
    private static final int GRID_X = 16 / STEP + 1;  // 5
    private static final int GRID_Z = 16 / STEP + 1;  // 5
    
    private final int minY;
    private final int maxY;
    private final int gridY;
    
    // Предвычисленные density значения [x][z][y]
    // Хранит финальную density (после offset + depthGradient) для каждой точки сетки
    private final float[][][] densityGrid;
    
    // Предвычисленная spaghetti [x][z][y] — boolean нельзя интерполировать,
    // поэтому храним float значение tunnelValue
    private final float[][][] spaghettiGrid;
    
    // Координаты чанка в мире
    private final int chunkStartX;
    private final int chunkStartZ;
    
    /**
     * Создаёт интерполятор и предвычисляет сетку для чанка.
     * 
     * @param noise WorldNoiseGenerator
     * @param chunkX координата чанка (не блока!)
     * @param chunkZ координата чанка
     * @param surfaceHeights массив высот поверхности [16][16] для этого чанка
     */
    public CaveInterpolator(WorldNoiseGenerator noise, int chunkX, int chunkZ, int[][] surfaceHeights) {
        this.chunkStartX = chunkX * 16;
        this.chunkStartZ = chunkZ * 16;
        
        // Определяем диапазон Y для сетки
        this.minY = -180;  // CAVE_MIN_Y
        this.maxY = 300;   // CAVE_MAX_Y
        this.gridY = (maxY - minY) / STEP + 1;
        
        this.densityGrid = new float[GRID_X][GRID_Z][gridY];
        this.spaghettiGrid = new float[GRID_X][GRID_Z][gridY];
        
        // Предвычисляем все точки сетки
        precompute(noise, surfaceHeights);
    }
    
    private void precompute(WorldNoiseGenerator noise, int[][] surfaceHeights) {
        for (int gx = 0; gx < GRID_X; gx++) {
            for (int gz = 0; gz < GRID_Z; gz++) {
                int worldX = chunkStartX + gx * STEP;
                int worldZ = chunkStartZ + gz * STEP;
                
                // Берём surfaceHeight из ближайшей точки
                int localX = Math.min(gx * STEP, 15);
                int localZ = Math.min(gz * STEP, 15);
                int surfaceHeight = surfaceHeights[localX][localZ];
                
                for (int gy = 0; gy < gridY; gy++) {
                    int worldY = minY + gy * STEP;
                    
                    // Быстрые проверки
                    if (worldY > surfaceHeight) {
                        densityGrid[gx][gz][gy] = 1.0f;  // камень (не пещера)
                        spaghettiGrid[gx][gz][gy] = 1.0f; // не туннель
                        continue;
                    }
                    
                    // Вычисляем cheese density (как в isCave, но без boolean)
                    densityGrid[gx][gz][gy] = noise.computeCaveDensity(worldX, worldY, worldZ, surfaceHeight);
                    
                    // Вычисляем spaghetti tunnel value
                    spaghettiGrid[gx][gz][gy] = noise.computeSpaghettiValue(worldX, worldY, worldZ);
                }
            }
        }
    }
    
    /**
     * Интерполированная проверка пещеры.
     * Замена isCave() — в ~40 раз быстрее.
     * 
     * @param localX 0-15 внутри чанка
     * @param localZ 0-15 внутри чанка
     * @param y мировая Y координата
     * @param surfaceHeight высота поверхности
     * @return true если пещера
     */
    public boolean isCave(int localX, int localZ, int y, int surfaceHeight) {
        if (y > surfaceHeight) return false;
        if (y < minY || y > maxY) return false;
        
        // Координаты в сетке (дробные)
        float gx = (float) localX / STEP;
        float gz = (float) localZ / STEP;
        float gy = (float) (y - minY) / STEP;
        
        // Индексы ячейки
        int gx0 = Math.min((int) gx, GRID_X - 2);
        int gz0 = Math.min((int) gz, GRID_Z - 2);
        int gy0 = Math.min((int) gy, gridY - 2);
        
        // Дробная часть для интерполяции (0..1)
        float fx = gx - gx0;
        float fz = gz - gz0;
        float fy = gy - gy0;
        
        // Трилинейная интерполяция density
        float density = trilinear(densityGrid, gx0, gz0, gy0, fx, fz, fy);
        
        // Cheese cave
        if (density < 0) {
            // TODO: pillars можно добавить потом (они дешёвые)
            return true;
        }
        
        // Spaghetti — интерполируем tunnel value
        float spaghettiValue = trilinear(spaghettiGrid, gx0, gz0, gy0, fx, fz, fy);
        if (spaghettiValue < 0) {
            return true;
        }
        
        return false;
    }
    
    private float trilinear(float[][][] grid, int x0, int z0, int y0, float fx, float fz, float fy) {
        // 8 углов ячейки
        float c000 = grid[x0][z0][y0];
        float c100 = grid[x0 + 1][z0][y0];
        float c010 = grid[x0][z0 + 1][y0];
        float c110 = grid[x0 + 1][z0 + 1][y0];
        float c001 = grid[x0][z0][y0 + 1];
        float c101 = grid[x0 + 1][z0][y0 + 1];
        float c011 = grid[x0][z0 + 1][y0 + 1];
        float c111 = grid[x0 + 1][z0 + 1][y0 + 1];
        
        // Интерполяция по X
        float c00 = c000 + (c100 - c000) * fx;
        float c10 = c010 + (c110 - c010) * fx;
        float c01 = c001 + (c101 - c001) * fx;
        float c11 = c011 + (c111 - c011) * fx;
        
        // Интерполяция по Z
        float c0 = c00 + (c10 - c00) * fz;
        float c1 = c01 + (c11 - c01) * fz;
        
        // Интерполяция по Y
        return c0 + (c1 - c0) * fy;
    }
}
```

### WorldNoiseGenerator.java — добавить два новых метода

Эти методы вычисляют density БЕЗ boolean результата — возвращают float для интерполяции.

```java
/**
 * Вычисляет cave density для одной точки (для интерполяции).
 * Возвращает finalDensity: < 0 = пещера, >= 0 = камень.
 * НЕ включает pillars (они добавляются потом).
 */
public float computeCaveDensity(int x, int y, int z, int surfaceHeight) {
    checkInit();
    
    double cheeseSuperLarge = sampleCheeseNoise(x / 3.0, y / 2.0, z / 3.0);
    double cheeseLarge = sampleCheeseNoise(x / 2.0, (double)y, z / 2.0);
    double cheeseMedium = sampleCheeseNoise((double)x, (double)y, (double)z);
    double cheeseSmall = sampleCheeseNoise(x * 1.5, y * 1.5, z * 1.5);

    int depth = surfaceHeight - y;
    float surfaceProtection = 0f;
    if (surfaceHeight < 90 && depth < 15) {
        surfaceProtection = 0.5f * (1f - depth / 15f);
    }

    float depthGradient = 0.05f + 0.1f * (y / 300f);

    float superLargeDensity = (float) cheeseSuperLarge + 0.38f + depthGradient;
    float largeDensity = (float) cheeseLarge + 0.33f + depthGradient;
    float mediumDensity = (float) cheeseMedium + 0.28f + depthGradient;
    float smallDensity = (float) cheeseSmall + 0.32f + depthGradient;

    return Math.min(
        Math.min(superLargeDensity, largeDensity),
        Math.min(mediumDensity, smallDensity)
    ) + surfaceProtection;
}

/**
 * Вычисляет spaghetti tunnel value для одной точки (для интерполяции).
 * Возвращает: < 0 = туннель, >= 0 = камень.
 */
public float computeSpaghettiValue(int x, int y, int z) {
    checkInit();
    
    double XZ_SCALE = 0.012;
    double Y_SCALE = 0.012;

    double spaghetti1 = OpenSimplex2S.noise3_ImproveXY(spaghettiSeed1,
            x * XZ_SCALE, z * XZ_SCALE, y * Y_SCALE);
    double spaghetti2 = OpenSimplex2S.noise3_ImproveXY(spaghettiSeed2,
            x * XZ_SCALE * 0.9, z * XZ_SCALE * 0.9, y * Y_SCALE * 1.1);

    double tunnelValue = Math.abs(spaghetti1) + Math.abs(spaghetti2);

    double rareness = OpenSimplex2S.noise3_ImproveXY(spaghettiRarenessSeed,
            x * 0.003, z * 0.003, y * 0.003);

    float threshold = 0.06f + (float) Math.max(0, rareness * 0.15);
    
    // Возвращаем tunnelValue - threshold: < 0 = туннель
    return (float)(tunnelValue - threshold);
}
```

### BFMEChunkGenerator.java — использовать CaveInterpolator

Добавить import:
```java
import net.sima.bfme.worldgen.noise.CaveInterpolator;
```

В методе `fillFromNoise` (или `buildSurface` — где генерируются все столбцы чанка), 
ПЕРЕД циклом по столбцам добавить:

```java
// Предвычисляем высоты для всего чанка
int[][] surfaceHeights = new int[16][16];
for (int lx = 0; lx < 16; lx++) {
    for (int lz = 0; lz < 16; lz++) {
        int wx = chunkPos.getMinBlockX() + lx;
        int wz = chunkPos.getMinBlockZ() + lz;
        surfaceHeights[lx][lz] = (int) heightMapV11.getHeight(wx, wz);
    }
}

// Создаём интерполятор — предвычисляет сетку density
CaveInterpolator caveInterpolator = new CaveInterpolator(noise, chunkPos.x, chunkPos.z, surfaceHeights);
```

Передать `caveInterpolator` в `generateColumn()` как параметр.

В `generateColumn()` — заменить все вызовы `noise.isCave(worldX, y, worldZ, surfaceHeight)` на `caveInterpolator.isCave(localX, localZ, y, surfaceHeight)`.

ВАЖНО: localX и localZ это 0-15 (внутри чанка), не мировые координаты!

### Что НЕ менять
- WorldNoiseGenerator.isCave() — оставить как есть (для debug, потом можно удалить)
- sampleCheeseNoise — не трогать
- getCaveBiome — не трогать  
- BFMEBiomeSource — не трогать
- Pillars — пока пропускаем в интерполяторе (можно добавить потом, они дешёвые)

### Как тестировать
1. Создать новый мир
2. Пещеры должны выглядеть почти как раньше (чуть сглаженнее — это нормально)
3. Генерация должна быть ЗНАЧИТЕЛЬНО быстрее
4. Если пещеры выглядят слишком сглаженными — уменьшить STEP до 2 (медленнее но детальнее)

### Числа
- Было: ~4.5M noise вызовов на чанк
- Стало: ~100K noise вызовов на чанк (сетка 5×5×120 × ~37 noise)
- Ускорение: ~45 раз для cave noise
- RAM: ~150KB на чанк (массивы density), освобождается после генерации
