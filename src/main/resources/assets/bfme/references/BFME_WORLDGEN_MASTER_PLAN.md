# BFME WorldGen — Мастер-план реализации

> **Версия:** 2.0
> **Дата:** 30.01.2026
> **Обновлено:** V12 TerraForged-style Blend System, упрощённые шумы
> **Цель:** Генерация мира уровня референсов (90%+ качества TerraForged)
> **Сроки:** 3-4 месяца до альфа-теста

---

## ОГЛАВЛЕНИЕ

1. [Архитектура системы](#1-архитектура-системы)
2. [Фазы реализации](#2-фазы-реализации)
3. [Фаза 1: Voronoi Mountain System](#3-фаза-1-voronoi-mountain-system)
4. [Фаза 2: Улучшение модификаторов](#4-фаза-2-улучшение-модификаторов)
5. [**ФАЗА 2.5: V12 Terrain Blend System (TerraForged-style)**](#5-фаза-25-v12-terrain-blend-system)
6. [Фаза 3: 3D Cave System](#6-фаза-3-3d-cave-system)
7. [Фаза 4: Пещерные биомы](#7-фаза-4-пещерные-биомы)
8. [Фаза 5: Деревья и растительность](#8-фаза-5-деревья-и-растительность)
9. [Фаза 6: Структуры](#9-фаза-6-структуры)
10. [Технические константы](#10-технические-константы)
11. [Файловая структура](#11-файловая-структура)
12. [Критерии успеха](#12-критерии-успеха)
13. [Риски и решения](#13-риски-и-решения)

---

## 1. АРХИТЕКТУРА СИСТЕМЫ

### 1.1 Общая схема генерации

```
┌─────────────────────────────────────────────────────────────────┐
│                    BFME WORLD GENERATION                        │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────┐         │
│  │  PNG BIOME  │───►│   BIOME     │───►│  TERRAIN    │         │
│  │    MAP      │    │   SOURCE    │    │  PROFILE    │         │
│  │ (8x8 tiles) │    │             │    │  REGISTRY   │         │
│  └─────────────┘    └─────────────┘    └─────────────┘         │
│         │                                     │                 │
│         ▼                                     ▼                 │
│  ┌─────────────────────────────────────────────────────┐       │
│  │              HEIGHTMAP GENERATOR (V11+)              │       │
│  ├─────────────────────────────────────────────────────┤       │
│  │  Layer 1: Voronoi Structure (горы/пики)             │       │
│  │  Layer 2: Shape Functions (dome/jagged/plateau)     │       │
│  │  Layer 3: Ridge Connection (хребты)                 │       │
│  │  Layer 4: Noise Layers (hills/valleys/detail)       │       │
│  │  Layer 5: Modifiers (erosion/terrace/cliff)         │       │
│  └─────────────────────────────────────────────────────┘       │
│                           │                                     │
│                           ▼                                     │
│  ┌─────────────────────────────────────────────────────┐       │
│  │              3D DENSITY CARVER                       │       │
│  ├─────────────────────────────────────────────────────┤       │
│  │  - Spaghetti Caves (длинные туннели)                │       │
│  │  - Cheese Caves (большие залы)                      │       │
│  │  - Noodle Caves (узкие проходы)                     │       │
│  │  - Aquifers (подземные реки/озёра)                  │       │
│  │  - Regional Caves (кристальные, мифриловые)         │       │
│  └─────────────────────────────────────────────────────┘       │
│                           │                                     │
│                           ▼                                     │
│  ┌─────────────────────────────────────────────────────┐       │
│  │              SURFACE DECORATOR                       │       │
│  ├─────────────────────────────────────────────────────┤       │
│  │  - SlopeMap (блоки по углу наклона)                 │       │
│  │  - Height-based snow/rock                           │       │
│  │  - Biome-specific surfaces                          │       │
│  └─────────────────────────────────────────────────────┘       │
│                           │                                     │
│                           ▼                                     │
│  ┌─────────────────────────────────────────────────────┐       │
│  │              FEATURE PLACEMENT                       │       │
│  ├─────────────────────────────────────────────────────┤       │
│  │  - Trees (30+ типов, 1x1 до 4x4)                    │       │
│  │  - Vegetation (трава, цветы, кусты)                 │       │
│  │  - Structures (руины, POI)                          │       │
│  │  - Ores (руды по регионам)                          │       │
│  └─────────────────────────────────────────────────────┘       │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

### 1.2 Поток данных

```
PNG Map (32000x32000 блоков). (8х8 карт по 1000 пикселей каждая, размер пикселя - 4 блока)
    │
    ▼
BFMEMapRuntime.getBiome(x, z) → BFMEBiome
    │
    ▼
BiomeProfileRegistry.getProfile(biome) → BiomeTerrainProfile
    │
    ▼
BFMEHeightMapV11.getHeight(x, z)
    ├── VoronoiMountainLayer.getStructure(x, z)
    ├── ShapeFunction.apply(distance, params)
    ├── RidgeConnector.connect(cellA, cellB)
    ├── NoiseGenerator.sample(x, z)
    └── TerrainModifiers.apply(height, profile)
    │
    ▼
CaveCarver3D.carve(x, y, z) → boolean isCave
    │
    ▼
BFMEChunkGenerator.generateColumn()
    ├── Bedrock/Deepslate/Stone layers
    ├── Surface blocks (SlopeMap)
    ├── Cave carving
    └── Water filling
    │
    ▼
FeatureDecorator.decorate()
    ├── TreePlacer.place()
    ├── VegetationPlacer.place()
    └── StructurePlacer.place()
```

---

## 2. ФАЗЫ РЕАЛИЗАЦИИ

### Таймлайн

```
Месяц 1: Фаза 1 + Фаза 2 (2D ландшафт)
├── Неделя 1-2: Voronoi Mountain System
├── Неделя 3: Ridge Connection
└── Неделя 4: Erosion/Cliff modifiers

Месяц 2: Фаза 3 (Пещеры)
├── Неделя 1-2: Базовые 3D caves
├── Неделя 3: Подземные реки
└── Неделя 4: Арки и нависания

Месяц 3: Фаза 4 + Фаза 5 (Биомы + Деревья)
├── Неделя 1: Пещерные биомы
├── Неделя 2-3: Система деревьев
└── Неделя 4: Тестирование, фиксы

Месяц 4: Фаза 6 + Полировка
├── Неделя 1-2: Структуры
├── Неделя 3: Оптимизация
└── Неделя 4: Альфа-тест
```

### Приоритеты

| Приоритет | Компонент | Влияние на wow-эффект |
|-----------|-----------|----------------------|
| 🔴 P0 | Voronoi горы | Критично |
| 🔴 P0 | Ridge connection | Критично |
| 🔴 P0 | Erosion промоины | Критично |
| 🟠 P1 | Cliff обрывы | Высокое |
| 🟠 P1 | 3D caves базовые | Высокое |
| 🟠 P1 | Подземные реки | Высокое |
| 🟡 P2 | Пещерные биомы | Среднее |
| 🟡 P2 | Деревья красивые | Среднее |
| 🟢 P3 | Структуры | Низкое (для альфы) |
| 🟢 P3 | Водопады | Низкое |

---

## 3. ФАЗА 1: VORONOI MOUNTAIN SYSTEM

### 3.1 Концепция

Voronoi диаграмма определяет где будут горные пики. Каждая ячейка = один пик с параметрами.

**ВАЖНО:** Используем **Domain Warping** чтобы убрать видимую регулярность сетки!

```
Обычный Voronoi (видна сетка):     С Domain Warping (натурально):
┌─────┬─────┬─────┐                ┌─────────────────┐
│  *  │  *  │  *  │                │   *    *        │
├─────┼─────┼─────┤      ──►       │      ╱──────*   │
│  *  │  *  │  *  │                │ *   ╱    *      │
├─────┼─────┼─────┤                │    ╱  *      *  │
│  *  │  *  │  *  │                │   *       *     │
└─────┴─────┴─────┘                └─────────────────┘
     Паттерн!                        Хаотично!
```

**Domain Warping** — искажаем координаты noise'ом ПЕРЕД Voronoi lookup:
```java
// Вместо query(x, z) делаем:
float wx = x + noise.getWarpX(x, z) * warpStrength;  // warpStrength = 60-80
float wz = z + noise.getWarpZ(x, z) * warpStrength;
return queryInternal(wx, wz);
```

Это ломает регулярность сетки, но сохраняет все преимущества Voronoi (соседи, хребты).

### 3.1.1 Почему Domain Warping, а не Poisson Disk?

**Рассмотренная альтернатива:** Poisson Disk Sampling — полностью случайное распределение точек.

| Критерий | Voronoi + Warp | Poisson Disk |
|----------|----------------|--------------|
| Случайность | 85% (warp маскирует сетку) | 100% |
| Поиск соседей | O(1) — легко | O(n) или spatial hash |
| Хребты между пиками | Тривиально | Нужна Delaunay триангуляция |
| Производительность | Быстрее | Медленнее |
| Сложность кода | Проще | Сложнее |

**Главная проблема Poisson Disk — хребты:**
```
Voronoi — соседи очевидны:        Poisson — кто сосед?
[A]───[B]───[C]                   A     B        C
 │╲   │   ╱│                         D     E  
[D]───[E]───[F]                   F       G    H

Хребет A→B: просто соедини        Хребет от A к кому? KNN поиск...
```

**Решение:** Voronoi + Strong Warp (60-80 блоков). Warp достаточно сильный чтобы убить видимый паттерн.

### 3.1.2 voronoiGridSize как параметр биома

**voronoiGridSize** — минимальное расстояние между центрами пиков (в блоках).

**Правило:** gridSize **единый внутри горной группы**. Если foothills и peaks имеют разный gridSize — сетки не совпадут, хребты сломаются.

```
┌───────────────────────────────────────────────────────────────┐
│ Горная группа         │ gridSize │ Биомы внутри              │
├───────────────────────────────────────────────────────────────┤
│ White Mountains       │   200    │ foothills, mountains,     │
│                       │          │ peaks, high_peaks         │
├───────────────────────────────────────────────────────────────┤
│ Ephel Duath           │   150    │ base, peaks, black_peaks  │
├───────────────────────────────────────────────────────────────┤
│ Ered Luin (будущее)   │   180    │ все уровни                │
├───────────────────────────────────────────────────────────────┤
│ Равнины               │   любой  │ mountainChance = 0        │
└───────────────────────────────────────────────────────────────┘
```

**Разницу между foothills и peaks делать через:**
- `mountainChance` (0.3 для foothills → 0.95 для peaks)
- `peakHeight` (60-120 foothills → 260-400 high peaks)
- `radius` (80-150 foothills → 80-200 peaks)

Это позволяет иметь **разный характер** горных массивов (White Mountains — величественные редкие, Ephel Duath — хаотичные частые) при правильной работе хребтов внутри каждой группы.

**Решение:** warpStrength 60-80 блоков достаточно чтобы убить видимый паттерн.
Если через месяц увидим регулярность — переделаем на Poisson.

### 3.2 Новые классы

#### VoronoiMountainLayer.java

```java
package net.sima.bfme.worldgen.terrain.voronoi;

/**
 * Генерирует Voronoi структуру для размещения гор.
 * 
 * Алгоритм:
 * 1. Разбиваем мир на регулярную сетку (gridSize = 180)
 * 2. В каждой ячейке jitter-ом смещаем точку
 * 3. DOMAIN WARPING: искажаем координаты запроса noise'ом
 * 4. Для warped координат находим ближайшие N ячеек
 * 5. Интерполируем влияние каждой ячейки
 */
public class VoronoiMountainLayer {
    
    // === КОНСТАНТЫ ===
    private static final int GRID_SIZE = 180;    // Фиксированный размер сетки
    private static final float BASE_JITTER = 0.4f;  // Базовый jitter
    
    // === КЭШИ ===
    private final ConcurrentHashMap<Long, VoronoiCell> cellCache;
    private final ConcurrentHashMap<Long, VoronoiResult> resultCache;
    
    private final WorldNoiseGenerator noise;
    private final BiomeProfileRegistry profiles;
    private long worldSeed;
    
    /**
     * Данные одной Voronoi ячейки (одной горы)
     */
    public static class VoronoiCell {
        public final int centerX, centerZ;      // Центр ячейки
        public final float peakHeight;          // Высота пика (180-400)
        public final float radius;              // Радиус влияния (80-250)
        public final MountainShape shape;       // DOME, JAGGED, PLATEAU, VOLCANIC
        public final float ridgeAngle;          // Направление главного хребта
        public final boolean hasMountain;       // false если ячейка пустая (равнина)
        public final long seed;                 // Для детерминизма
    }
    
    /**
     * Результат Voronoi запроса для точки
     */
    public static class VoronoiResult {
        public final VoronoiCell primaryCell;   // Ближайшая ячейка
        public final VoronoiCell[] neighbors;   // Соседние ячейки (для blend)
        public final float[] weights;           // Веса каждой ячейки
        public final float distToPrimary;       // Расстояние до центра
        public final float distToEdge;          // Расстояние до границы
    }
    
    /**
     * Главный метод — получить структуру для точки
     */
    public VoronoiResult query(int worldX, int worldZ) {
        // === DOMAIN WARPING — ключевое отличие! ===
        // Искажаем координаты ПЕРЕД Voronoi lookup
        BiomeTerrainProfile profile = getProfileAt(worldX, worldZ);
        float warpStrength = profile.getVoronoiWarpStrength();  // 60-80 для гор
        
        float warpX = noise.getWarpX(worldX, worldZ) * warpStrength;
        float warpZ = noise.getWarpZ(worldX, worldZ) * warpStrength;
        
        // Warped координаты для Voronoi
        int wx = worldX + (int) warpX;
        int wz = worldZ + (int) warpZ;
        
        // 1. Определяем ячейку сетки по WARPED координатам
        int gridX = Math.floorDiv(wx, GRID_SIZE);
        int gridZ = Math.floorDiv(wz, GRID_SIZE);
        
        // 2. Собираем 9 соседних ячеек (3x3)
        VoronoiCell[] candidates = new VoronoiCell[9];
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                candidates[(dx+1)*3 + (dz+1)] = getOrCreateCell(gridX + dx, gridZ + dz);
            }
        }
        
        // 3. Находим ближайшую (по warped координатам) и вычисляем веса
        // ... (сортировка по расстоянию, smooth blend)
        
        return new VoronoiResult(...);
    }
    
    /**
     * Создание ячейки с детерминированными параметрами
     */
    private VoronoiCell getOrCreateCell(int gridX, int gridZ) {
        long key = packCoords(gridX, gridZ);
        return cellCache.computeIfAbsent(key, k -> {
            // Детерминированный random от координат
            Random rand = new Random(worldSeed ^ key);
            
            // Jitter центра
            float jx = (rand.nextFloat() - 0.5f) * 2 * BASE_JITTER;
            float jz = (rand.nextFloat() - 0.5f) * 2 * BASE_JITTER;
            int centerX = gridX * GRID_SIZE + (int)(GRID_SIZE * (0.5f + jx));
            int centerZ = gridZ * GRID_SIZE + (int)(GRID_SIZE * (0.5f + jz));
            
            // Параметры горы из профиля биома в этой точке
            BiomeTerrainProfile profile = getProfileAt(centerX, centerZ);
            
            // === MOUNTAIN CHANCE — может не быть горы! ===
            boolean hasMountain = rand.nextFloat() < profile.getMountainChance();
            if (!hasMountain) {
                return new VoronoiCell(centerX, centerZ, 0, 0, null, 0, false, key);
            }
            
            // Параметры горы
            float peakHeight = profile.getMinPeakHeight() + 
                rand.nextFloat() * (profile.getMaxPeakHeight() - profile.getMinPeakHeight());
            
            float radius = profile.getMinRadius() + 
                rand.nextFloat() * (profile.getMaxRadius() - profile.getMinRadius());
            
            MountainShape shape = profile.pickRandomShape(rand);
            
            return new VoronoiCell(centerX, centerZ, peakHeight, radius, shape, 
                rand.nextFloat() * 360f, true, key);
        });
    }
}
```

#### MountainShape.java

```java
package net.sima.bfme.worldgen.terrain.voronoi;

/**
 * Формы гор — функции высоты от расстояния до центра
 */
public enum MountainShape {
    
    /**
     * Округлая гора (старые горы, White Mountains)
     * h = peak * (1 - (d/r)^2)^exponent
     */
    DOME {
        @Override
        public float getHeight(float distNormalized, float peakHeight, ShapeParams params) {
            if (distNormalized >= 1.0f) return 0;
            float t = 1.0f - distNormalized * distNormalized;
            return peakHeight * (float) Math.pow(t, params.exponent);
        }
    },
    
    /**
     * Острый пик (альпийские горы, Ephel Duath)
     * h = peak * (1 - d/r)^exponent + ridgeNoise
     */
    JAGGED {
        @Override
        public float getHeight(float distNormalized, float peakHeight, ShapeParams params) {
            if (distNormalized >= 1.0f) return 0;
            float base = (float) Math.pow(1.0f - distNormalized, params.exponent);
            // Ridge noise добавляет зубцы
            float ridge = params.ridgeNoise * (1.0f - distNormalized);
            return peakHeight * (base + ridge * 0.3f);
        }
    },
    
    /**
     * Плато с обрывами (Emyn Arnen)
     * Плоская вершина, крутые края
     */
    PLATEAU {
        @Override
        public float getHeight(float distNormalized, float peakHeight, ShapeParams params) {
            if (distNormalized >= 1.0f) return 0;
            if (distNormalized < params.plateauRadius) {
                // Плоская вершина
                return peakHeight;
            }
            // Крутой склон
            float edgeDist = (distNormalized - params.plateauRadius) / (1.0f - params.plateauRadius);
            return peakHeight * (1.0f - smoothstep(edgeDist));
        }
    },
    
    /**
     * Вулкан с кратером (Mount Doom)
     */
    VOLCANIC {
        @Override
        public float getHeight(float distNormalized, float peakHeight, ShapeParams params) {
            if (distNormalized >= 1.0f) return 0;
            // Конус с кратером
            float cone = 1.0f - distNormalized;
            float crater = distNormalized < params.craterRadius 
                ? -0.3f * (1.0f - distNormalized / params.craterRadius) 
                : 0;
            return peakHeight * (cone + crater);
        }
    };
    
    public abstract float getHeight(float distNormalized, float peakHeight, ShapeParams params);
    
    public static class ShapeParams {
        public float exponent = 2.0f;       // Крутизна
        public float ridgeNoise = 0.0f;     // Для JAGGED
        public float plateauRadius = 0.3f;  // Для PLATEAU
        public float craterRadius = 0.15f;  // Для VOLCANIC
    }
}
```

#### RidgeConnector.java

```java
package net.sima.bfme.worldgen.terrain.voronoi;

/**
 * Соединяет пики в хребты.
 * 
 * Алгоритм:
 * 1. Для каждой пары соседних Voronoi ячеек
 * 2. Если profile.ridgeConnection > rand → соединяем
 * 3. Хребет = raised height вдоль линии между центрами
 */
public class RidgeConnector {
    
    /**
     * Добавляет высоту хребта между двумя пиками
     */
    public float getRidgeHeight(int x, int z, VoronoiCell cellA, VoronoiCell cellB, 
                                 float ridgeStrength) {
        if (ridgeStrength < 0.01f) return 0;
        
        // Проекция точки на линию между центрами
        float ax = cellA.centerX, az = cellA.centerZ;
        float bx = cellB.centerX, bz = cellB.centerZ;
        
        float dx = bx - ax, dz = bz - az;
        float len = (float) Math.sqrt(dx*dx + dz*dz);
        if (len < 1) return 0;
        
        // Параметр t вдоль линии (0 = A, 1 = B)
        float t = ((x - ax) * dx + (z - az) * dz) / (len * len);
        t = clamp(t, 0, 1);
        
        // Ближайшая точка на линии
        float px = ax + t * dx;
        float pz = az + t * dz;
        
        // Расстояние от точки до линии
        float distToLine = (float) Math.sqrt((x - px)*(x - px) + (z - pz)*(z - pz));
        
        // Ширина хребта зависит от высоты пиков
        float ridgeWidth = Math.min(cellA.radius, cellB.radius) * 0.4f;
        if (distToLine > ridgeWidth) return 0;
        
        // Высота хребта — интерполяция между пиками, с понижением в середине
        float heightA = cellA.peakHeight;
        float heightB = cellB.peakHeight;
        float ridgeBaseHeight = lerp(heightA, heightB, t) * 0.7f; // 70% от пиков
        
        // Поперечный профиль хребта (выше в центре)
        float crossProfile = 1.0f - (distToLine / ridgeWidth);
        crossProfile = crossProfile * crossProfile; // Квадратичный
        
        // Продольная вариация (не идеально ровный)
        float variation = noise.getRidge((int)(t * 100), 0) * 0.2f + 0.9f;
        
        return ridgeBaseHeight * crossProfile * ridgeStrength * variation;
    }
}
```

### 3.3 Интеграция в HeightMap

```java
// В BFMEHeightMapV11.java

public int getHeight(int x, int z) {
    // 1. Получаем Voronoi структуру
    VoronoiResult voronoi = voronoiLayer.query(x, z);
    
    // 2. Базовая высота от ближайшего пика
    float mountainHeight = 0;
    for (int i = 0; i < voronoi.neighbors.length; i++) {
        VoronoiCell cell = voronoi.neighbors[i];
        float weight = voronoi.weights[i];
        
        float dist = distance(x, z, cell.centerX, cell.centerZ);
        float distNorm = dist / cell.radius;
        
        float h = cell.shape.getHeight(distNorm, cell.peakHeight, shapeParams);
        mountainHeight += h * weight;
    }
    
    // 3. Добавляем хребты между соседними пиками
    float ridgeHeight = ridgeConnector.getRidgeHeight(x, z, 
        voronoi.primaryCell, voronoi.neighbors, profile.getRidgeConnection());
    
    // 4. Существующие noise layers (hills, valleys, detail)
    float noiseHeight = applyNoiseParams(getNoises(x, z), blendedParams);
    
    // 5. Комбинируем
    float baseHeight = blendedParams[P_BASE];
    float totalHeight = baseHeight + mountainHeight + ridgeHeight + noiseHeight;
    
    // 6. Модификаторы
    totalHeight = applyModifiers(totalHeight, x, z, blendedParams);
    
    return clamp(totalHeight, minY, maxY);
}
```

### 3.4 Новые параметры BiomeTerrainProfile

```java
// Добавить в BiomeTerrainProfile.java

// === VORONOI ПАРАМЕТРЫ ===
// Сетка фиксированная (180), но warp ломает регулярность!
private final float voronoiWarpStrength;     // Сила искажения (0=выкл, 60-80 для гор)
private final float mountainChance;          // Шанс что ячейка = гора (0.0-1.0)

private final float minPeakHeight;           // Минимальная высота пика
private final float maxPeakHeight;           // Максимальная высота пика
private final float minRadius;               // Минимальный радиус горы
private final float maxRadius;               // Максимальный радиус горы

private final MountainShape[] allowedShapes; // Разрешённые формы
private final float[] shapeWeights;          // Веса форм

private final float ridgeConnection;         // Вероятность хребта (0.0-1.0)
private final float ridgeWidth;              // Ширина хребта (0.2-0.6 от radius)

// === В Builder ===
public Builder voronoiWarpStrength(float val) { ... }  // 0 = выкл, 60-80 = норма
public Builder mountainChance(float val) { ... }       // 0.0-1.0
public Builder peakHeightRange(float min, float max) { ... }
public Builder radiusRange(float min, float max) { ... }
public Builder allowedShapes(MountainShape... shapes) { ... }
public Builder shapeWeights(float... weights) { ... }
public Builder ridgeConnection(float val) { ... }
```

### 3.5 Таблица параметров по биомам

| Биом | warpStr | mtnChance | peakH | radius | shapes | ridge |
|------|---------|-----------|-------|--------|--------|-------|
| PELENNOR_PLAINS | 0 | 0.0 | - | - | - | - |
| FOOTHILLS | 40 | 0.3 | 60-120 | 80-150 | DOME 100% | 0.3 |
| WHITE_MOUNTAINS | 60 | 0.75 | 180-320 | 100-200 | DOME 50%, JAGGED 50% | 0.7 |
| HIGH_PEAKS | 50 | 0.95 | 260-400 | 80-160 | JAGGED 80%, DOME 20% | 0.85 |
| EPHEL_DUATH | 70 | 0.8 | 160-300 | 90-180 | JAGGED 90%, VOLCANIC 10% | 0.6 |

### 3.6 Обновлённые профили биомов

```java
// В BiomeProfileRegistry.java

// WHITE MOUNTAINS — главная цель
profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS, new BiomeTerrainProfile.Builder()
    .baseHeight(120)
    .minHeight(90)
    .maxHeight(400)
    
    // Voronoi параметры с Domain Warping
    .voronoiWarpStrength(60f)        // Ломает регулярность сетки
    .mountainChance(0.75f)           // 75% ячеек = горы
    .peakHeightRange(180, 320)       // Высокие пики
    .radiusRange(100, 200)           // Широкие основания
    
    // Формы
    .allowedShapes(MountainShape.DOME, MountainShape.JAGGED)
    .shapeWeights(0.5f, 0.5f)        // 50/50
    
    // Хребты
    .ridgeConnection(0.7f)           // Часто соединены
    .ridgeWidth(0.4f)
    
    // Модификаторы
    .erosionStrength(0.6f)           // Сильные промоины
    .cliffStrength(0.5f)
    .terraceStrength(0.0f)           // Без террас
    
    // Noise веса (уменьшены, т.к. Voronoi даёт основу)
    .peaksWeight(0.3f)               // Дополнительные мелкие пики
    .ridgeWeight(0.4f)               // Дополнительные гребни
    .hillsLargeWeight(0.2f)
    .detailWeight(0.4f)
    
    .build());

// WHITE MOUNTAINS HIGH PEAKS
profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS_HIGH_PEAKS, new BiomeTerrainProfile.Builder()
    .baseHeight(180)
    .minHeight(150)
    .maxHeight(448)
    
    .voronoiWarpStrength(50f)        // Чуть меньше warp на пиках
    .mountainChance(0.95f)           // Почти все ячейки = горы
    .peakHeightRange(260, 400)       // Выше
    .radiusRange(80, 160)            // Уже
    
    .allowedShapes(MountainShape.JAGGED, MountainShape.DOME)
    .shapeWeights(0.8f, 0.2f)        // 80% острые
    
    .ridgeConnection(0.85f)          // Почти все соединены
    
    .erosionStrength(0.7f)
    .cliffStrength(0.7f)
    
    .build());

// WHITE MOUNTAINS FOOTHILLS
profiles.put(BFMEBiomeKeys.WHITE_MOUNTAINS_FOOTHILLS, new BiomeTerrainProfile.Builder()
    .baseHeight(95)
    .minHeight(75)
    .maxHeight(200)
    
    .voronoiWarpStrength(40f)        // Меньше warp
    .mountainChance(0.3f)            // Редкие горы
    .peakHeightRange(60, 120)        // Низкие
    .radiusRange(80, 150)            // Средние
    
    .allowedShapes(MountainShape.DOME)
    .shapeWeights(1.0f)              // Только округлые
    
    .ridgeConnection(0.3f)           // Редко соединены
    
    .build());

// PELENNOR PLAINS — без Voronoi гор
profiles.put(BFMEBiomeKeys.PELENNOR_PLAINS, new BiomeTerrainProfile.Builder()
    .baseHeight(70)
    .minHeight(66)
    .maxHeight(90)
    
    .voronoiWarpStrength(0f)         // ВЫКЛЮЧЕНО
    .mountainChance(0f)              // Нет гор
    
    .hillsLargeWeight(0.4f)
    .hillsSmallWeight(0.5f)
    .detailWeight(0.4f)
    
    .build());

// EPHEL DUATH — тёмные горы Мордора
profiles.put(BFMEBiomeKeys.EPHEL_DUATH, new BiomeTerrainProfile.Builder()
    .baseHeight(140)
    .minHeight(110)
    .maxHeight(380)
    
    .voronoiWarpStrength(70f)        // Сильный warp — хаотичнее
    .mountainChance(0.8f)
    .peakHeightRange(160, 300)
    .radiusRange(90, 180)
    
    .allowedShapes(MountainShape.JAGGED, MountainShape.VOLCANIC)
    .shapeWeights(0.9f, 0.1f)        // 90% острые, 10% вулканы
    
    .ridgeConnection(0.6f)
    
    .build());
```

---

## 4. ФАЗА 2: УЛУЧШЕНИЕ МОДИФИКАТОРОВ

### 4.1 ErosionModifier — КРИТИЧНО

Текущий код работает, но нужно усилить эффект.

```java
// Улучшения в ErosionModifier.java

@Override
public float modify(float height, int x, int z, BiomeTerrainProfile profile) {
    float strength = profile.getErosionGrooveStrength();
    if (strength <= 0.001f || heightProvider == null) return height;

    // === УЛУЧШЕНИЕ 1: Направленный шум вдоль склона ===
    float hE = heightProvider.getHeight(x + 2, z);
    float hW = heightProvider.getHeight(x - 2, z);
    float hS = heightProvider.getHeight(x, z + 2);
    float hN = heightProvider.getHeight(x, z - 2);

    float slopeX = (hE - hW) / 4f;
    float slopeZ = (hS - hN) / 4f;
    float slopeMagnitude = (float) Math.sqrt(slopeX * slopeX + slopeZ * slopeZ);

    if (slopeMagnitude < 0.1f) return height;  // Только на склонах

    // Направление склона
    float dirX = slopeX / slopeMagnitude;
    float dirZ = slopeZ / slopeMagnitude;

    // === УЛУЧШЕНИЕ 2: Ridged noise для V-образных промоин ===
    float grooveScale = profile.getErosionGrooveScale();
    
    // Сэмплируем ВДОЛЬ направления склона (как текут ручьи)
    float ridgedNoise = noise.getRidge(
        (int)(x + dirX * grooveScale * 0.5f),
        (int)(z + dirZ * grooveScale * 0.5f)
    );
    
    // === УЛУЧШЕНИЕ 3: Каскадная эрозия (глубже внизу) ===
    float heightFactor = Math.max(0, (height - 100) / 200f);  // Выше = глубже промоины
    float cascadeFactor = 1.0f + heightFactor * 0.5f;
    
    // === УЛУЧШЕНИЕ 4: Вариация ширины промоин ===
    float widthNoise = (float) noise.getDetail(x * 0.05, z * 0.05);
    float grooveWidth = 0.5f + widthNoise * 0.3f;  // 0.2-0.8
    
    // Финальная глубина
    float depth = ridgedNoise * strength * slopeMagnitude * cascadeFactor * 6f;
    
    return height - Math.max(0, depth);
}
```

### 4.2 CliffModifier — усиление обрывов

```java
// Улучшения в CliffModifier.java

@Override
public float modify(float height, int x, int z, BiomeTerrainProfile profile) {
    float strength = profile.getCliffStrength();
    if (strength <= 0.001f || heightProvider == null) return height;

    // Градиент с большим радиусом для стабильности
    float hE = heightProvider.getHeight(x + 3, z);
    float hW = heightProvider.getHeight(x - 3, z);
    float hS = heightProvider.getHeight(x, z + 3);
    float hN = heightProvider.getHeight(x, z - 3);

    float slopeX = (hE - hW) / 6f;
    float slopeZ = (hS - hN) / 6f;
    float slopeMagnitude = (float) Math.sqrt(slopeX * slopeX + slopeZ * slopeZ);

    // === УЛУЧШЕНИЕ: Более агрессивное усиление крутых склонов ===
    float cliffThreshold = 0.5f;  // ~27°
    if (slopeMagnitude < cliffThreshold) return height;

    // Экспоненциальное усиление
    float cliffFactor = (slopeMagnitude - cliffThreshold) / (1.5f - cliffThreshold);
    cliffFactor = cliffFactor * cliffFactor;  // Квадратичное
    cliffFactor = clamp(cliffFactor, 0f, 1f);

    // Определяем направление — вверх или вниз
    float avgNeighbor = (hE + hW + hS + hN) / 4f;
    float diff = height - avgNeighbor;

    // === УЛУЧШЕНИЕ: Ступенчатость для скальных обрывов ===
    float stepNoise = noise.getDetail(x * 0.1, z * 0.1);
    float step = (float) Math.floor(height / 8) * 8;  // Ступени по 8 блоков
    float stepBlend = cliffFactor * strength * 0.3f;
    
    float cliffBoost = diff * cliffFactor * strength * 0.6f;
    float steppedHeight = lerp(height, step + (height % 8) * 0.3f, stepBlend);
    
    return steppedHeight + cliffBoost;
}
```

### 4.3 RadialRidgeModifier — НОВЫЙ

Для острых пиков с "лучами" (референс 10).

```java
package net.sima.bfme.worldgen.terrain.modifiers;

/**
 * Создаёт радиальные хребты от вершины горы.
 * Эффект "короны" на острых пиках.
 */
public class RadialRidgeModifier implements TerrainModifier {
    
    private final WorldNoiseGenerator noise = WorldNoiseGenerator.getInstance();
    private VoronoiMountainLayer voronoiLayer;
    
    public void setVoronoiLayer(VoronoiMountainLayer layer) {
        this.voronoiLayer = layer;
    }
    
    @Override
    public float modify(float height, int x, int z, BiomeTerrainProfile profile) {
        if (voronoiLayer == null) return height;
        
        float strength = profile.getRadialRidgeStrength();
        if (strength <= 0.01f) return height;
        
        VoronoiResult voronoi = voronoiLayer.query(x, z);
        VoronoiCell cell = voronoi.primaryCell;
        
        // Только для JAGGED форм
        if (cell.shape != MountainShape.JAGGED) return height;
        
        // Направление от центра
        float dx = x - cell.centerX;
        float dz = z - cell.centerZ;
        float dist = (float) Math.sqrt(dx * dx + dz * dz);
        if (dist < 1) return height;
        
        float angle = (float) Math.atan2(dz, dx);
        float distNorm = dist / cell.radius;
        
        // Радиальные "лучи" — ridged noise от угла
        int numRidges = 6 + (int)(cell.seed % 4);  // 6-9 хребтов
        float ridgeNoise = (float) Math.abs(Math.sin(angle * numRidges + cell.seed * 0.01f));
        ridgeNoise = ridgeNoise * ridgeNoise;  // Заострение
        
        // Затухание к краям
        float falloff = 1.0f - smoothstep(distNorm);
        
        // Высота хребта
        float ridgeHeight = cell.peakHeight * 0.15f * ridgeNoise * falloff * strength;
        
        return height + ridgeHeight;
    }
    
    @Override
    public int getPriority() {
        return 15;  // После террас, до эрозии
    }
}
```

---

## 5. ФАЗА 2.5: V12 TERRAIN BLEND SYSTEM

### 5.1 Концепция (TerraForged-style)

**Проблема V10/V11:** Использовали несколько шумов одного типа (hills_large, hills_medium, hills_small) с разными весами. Это создавало:
- Накладывающиеся паттерны
- Сложность настройки (много параметров)
- Одинаковый "характер" рельефа везде

**Решение V12:** TerraForged использует РАЗНЫЕ ТИПЫ шумов, а не разные веса одного типа.

```
V11 (плохо):                         V12 (TerraForged):
┌─────────────────────────┐          ┌─────────────────────────┐
│ hillsLarge  × 0.4       │          │ simplex  (500)  × 0.3   │ ← стандартный
│ hillsMedium × 0.3       │   →      │ ridge    (900)  × 0.5   │ ← острые хребты
│ hillsSmall  × 0.2       │          │ billow   (700)  × 0.1   │ ← округлые
│ detail      × 0.1       │          │ cellular (350)  × 0.1   │ ← скалистые
└─────────────────────────┘          └─────────────────────────┘
     Всё одинаковое!                     Разный характер!
```

### 5.2 Четыре типа шумов

| Тип | Масштаб | Октавы | Характер | Использование |
|-----|---------|--------|----------|---------------|
| **Simplex** | 500 | 5 | Плавный, холмистый | Равнины, базовый рельеф |
| **Ridge** | 900 | 4 | Острые хребты | Горы, скалы |
| **Billow** | 700 | 4 | Округлые холмы | Предгорья, мягкий рельеф |
| **Cellular** | 350 | 3 | Скалистый, ячеистый | Mesa, badlands |

**ВАЖНО:** Масштабы РАЗНЫЕ чтобы избежать наложения паттернов!

### 5.3 Реализация в OctaveNoise

```java
// Стандартный simplex (sample2D)
public double sample2D(double x, double z) {
    // Обычный OpenSimplex2
    return OpenSimplex2S.noise2_ImproveX(seed, x / scale, z / scale);
}

// Ridge — острые гребни (abs инвертирован)
public double sampleRidged2D(double x, double z) {
    double total = 0, amplitude = 1.0, maxAmp = 0;
    for (int i = 0; i < octaves; i++) {
        double freq = Math.pow(lacunarity, i);
        double n = OpenSimplex2S.noise2_ImproveX(seed + i, x * freq / scale, z * freq / scale);
        // Ridge = 1 - abs(n) — инвертируем впадины в хребты
        n = 1.0 - Math.abs(n);
        total += n * amplitude;
        maxAmp += amplitude;
        amplitude *= persistence;
    }
    return total / maxAmp;
}

// Billow — округлые формы (abs)
public double sampleBillow2D(double x, double z) {
    // abs(noise) — впадины становятся холмами
    double n = Math.abs(OpenSimplex2S.noise2_ImproveX(...));
    return total / maxAmp;
}

// Cellular — ячеистый/скалистый (Worley distance)
public double sampleCellular2D(double x, double z) {
    // Расстояние до ближайшей точки Voronoi-сетки
    // Создаёт характерный "скалистый" паттерн
    return minDist / maxDist;
}
```

### 5.4 Параметры в BiomeTerrainProfile

```java
// V12 Blend Weights
private final float simplexWeight;   // 0.0-1.0, стандартный рельеф
private final float ridgeWeight;     // 0.0-1.0, острые хребты
private final float billowWeight;    // 0.0-1.0, округлые формы
private final float cellularWeight;  // 0.0-1.0, скалистые формы

// Модификаторы результата
private final float heightCurve;     // >1 = острее вершины, <1 = площе
private final float heightBias;      // <0 больше низин, >0 больше возвышенностей
private final float clampMax;        // Ограничение высоты (для плато), 0 = без ограничения
private final float warpStrength;    // Сила domain warp (органичность форм)

// Builder
public Builder blendWeights(float simplex, float ridge, float billow, float cellular) {
    this.simplexWeight = simplex;
    this.ridgeWeight = ridge;
    this.billowWeight = billow;
    this.cellularWeight = cellular;
    return this;
}
```

### 5.5 WorldNoiseGenerator упрощение

**Было (V11):** 10+ разных шумов с перекрывающимися масштабами
**Стало (V12):** 4 шума с РАЗНЫМИ масштабами

```java
// V12 SIMPLIFIED: один шум каждого типа
simplexNoise  = new OctaveNoise(seed, 5, 500.0, 0.5, 2.0);  // 5 октав
ridgeNoise    = new OctaveNoise(seed, 4, 900.0, 0.5, 2.0);  // 4 октавы
billowNoise   = new OctaveNoise(seed, 4, 700.0, 0.5, 2.0);  // 4 октавы
cellularNoise = new OctaveNoise(seed, 3, 350.0, 0.5, 2.0);  // 3 октавы

// Legacy шумы сохранены как алиасы для обратной совместимости
hillsLargeNoise = simplexNoise;  // Переиспользуем
```

### 5.6 getBlendedTerrain()

```java
/**
 * V12 SIMPLIFIED: Один шум каждого типа.
 *
 * @param x, z координаты
 * @param simplexW вес simplex (стандартный рельеф)
 * @param ridgeW вес ridge (острые гребни)
 * @param billowW вес billow (округлые формы)
 * @param cellularW вес cellular (скалистые)
 * @param warpStrength сила domain warp (0 = без warp)
 * @return значение terrain в диапазоне примерно 0..1
 */
public double getBlendedTerrain(double x, double z,
                                float simplexW, float ridgeW, float billowW, float cellularW,
                                float warpStrength) {
    // Domain warp для органичных форм
    double wx = x, wz = z;
    if (warpStrength > 0) {
        wx += warpXNoise.sample2D(x, z) * warpStrength * 60.0;
        wz += warpZNoise.sample2D(x, z) * warpStrength * 60.0;
    }

    double total = 0, totalWeight = 0;

    if (simplexW > 0) {
        total += simplexNoise.sample2D(wx, wz) * simplexW;
        totalWeight += simplexW;
    }
    if (ridgeW > 0) {
        total += ridgeNoise.sampleRidged2D(wx, wz) * ridgeW;
        totalWeight += ridgeW;
    }
    if (billowW > 0) {
        total += billowNoise.sampleBillow2D(wx, wz) * billowW;
        totalWeight += billowW;
    }
    if (cellularW > 0) {
        total += cellularNoise.sampleCellular2D(wx, wz) * cellularW;
        totalWeight += cellularW;
    }

    return totalWeight > 0 ? total / totalWeight : 0;
}
```

### 5.7 Интеграция с HeightMap (TODO: FIX)

**ПРОБЛЕМА:** Текущая формула создаёт артефакты.

```java
// ТЕКУЩАЯ ФОРМУЛА (СЛОМАНА):
delta = noise.getBlendedTerrain(x, z, simplexW, ridgeW, billowW, cellularW, warpStrength);
delta = (delta - 0.5) * 80.0 * reliefScale;  // ← Создаёт отрицательные значения!

// ПОЧЕМУ СЛОМАНО:
// - getBlendedTerrain возвращает 0..1
// - (delta - 0.5) превращает в -0.5..0.5
// - При delta близком к 0, получаем ОТРИЦАТЕЛЬНУЮ высоту → озёра вместо холмов
```

**НУЖНО ИСПРАВИТЬ:**

```java
// ВАРИАНТ 1: Без центрирования
delta = noise.getBlendedTerrain(...);
delta = delta * 60.0 * reliefScale;  // 0..1 → 0..60 (только положительные)

// ВАРИАНТ 2: С curve/bias
delta = noise.getBlendedTerrain(...);
delta = WorldNoiseGenerator.applyCurveAndBias(delta, heightCurve, heightBias);
delta = delta * 80.0 * reliefScale;

// ВАРИАНТ 3: Сохранить legacy логику для V11, новая для V12
if (profile.usesBlendSystem()) {
    // V12 логика
} else {
    // Legacy V11 логика (работает)
}
```

### 5.8 Пресеты для биомов

```java
// === РАВНИНЫ — мягкие округлые формы ===
public static final BiomeTerrainProfile V12_PLAINS = new Builder()
    .baseHeight(70)
    .reliefScale(0.25f)
    .blendWeights(0.3f, 0.0f, 0.7f, 0.0f)  // simplex 30%, billow 70%
    .warpStrength(0.2f)
    .build();

// === ХОЛМЫ — смесь стандартного и округлого ===
public static final BiomeTerrainProfile V12_HILLS = new Builder()
    .baseHeight(72)
    .reliefScale(0.6f)
    .blendWeights(0.5f, 0.1f, 0.4f, 0.0f)  // simplex 50%, ridge 10%, billow 40%
    .warpStrength(0.3f)
    .build();

// === ГОРЫ — острые хребты доминируют ===
public static final BiomeTerrainProfile V12_MOUNTAINS = new Builder()
    .baseHeight(75)
    .reliefScale(1.2f)
    .blendWeights(0.2f, 0.7f, 0.1f, 0.0f)  // ridge 70%
    .warpStrength(0.5f)
    .heightCurve(1.3f)  // Острее вершины
    .build();

// === MESA/BADLANDS — скалистые ===
public static final BiomeTerrainProfile V12_MESA = new Builder()
    .baseHeight(75)
    .reliefScale(0.8f)
    .blendWeights(0.2f, 0.2f, 0.1f, 0.5f)  // cellular 50%
    .terraceStrength(0.7f)
    .terraceStep(6)
    .warpStrength(0.3f)
    .build();
```

### 5.9 Взаимодействие с Voronoi

V12 Blend System работает ВМЕСТЕ с Voronoi горами:

```
┌─────────────────────────────────────────────────────────────┐
│ СЛОЙ 1: Voronoi Structure                                   │
│         ↓ Даёт макро-структуру гор (пики, хребты)          │
├─────────────────────────────────────────────────────────────┤
│ СЛОЙ 2: V12 Blend Terrain                                   │
│         ↓ Даёт текстуру рельефа (холмы, гребни, скалы)     │
├─────────────────────────────────────────────────────────────┤
│ СЛОЙ 3: Modifiers (erosion, terrace, cliff)                 │
│         ↓ Добавляет детали                                  │
└─────────────────────────────────────────────────────────────┘
```

**Для горных биомов:**
- Voronoi даёт СТРУКТУРУ (где пики)
- V12 Ridge даёт ТЕКСТУРУ (гребни на склонах)
- Erosion даёт ДЕТАЛИ (промоины)

**Для равнин:**
- Voronoi ВЫКЛЮЧЕН (mountainChance = 0)
- V12 Simplex+Billow даёт мягкий рельеф
- Minimal modifiers

### 5.10 Текущий статус

| Компонент | Статус | Примечание |
|-----------|--------|------------|
| OctaveNoise.sampleRidged2D() | ✅ Готово | |
| OctaveNoise.sampleBillow2D() | ✅ Готово | |
| OctaveNoise.sampleCellular2D() | ✅ Готово | |
| WorldNoiseGenerator 4 шума | ✅ Готово | Масштабы: 500, 900, 700, 350 |
| BiomeTerrainProfile blend params | ✅ Готово | |
| getBlendedTerrain() | ✅ Готово | |
| HeightMap V12 интеграция | ⚠️ СЛОМАНО | Формула даёт отрицательные значения |
| Профили биомов V12 | ❌ Откачено | Все используют legacy V11 |

### 5.11 TODO

1. **КРИТИЧНО:** Исправить формулу в BFMEHeightMapV11.calculateHills()
2. Протестировать V12 на ОДНОМ биоме (PELENNOR_PLAINS)
3. После успешного теста — постепенно переводить биомы
4. Убедиться что Voronoi + V12 работают вместе
5. Удалить legacy hills_large/medium/small после полного перехода

---

## 6. ФАЗА 3: 3D CAVE SYSTEM

### 5.1 Архитектура пещер

```
┌─────────────────────────────────────────────────────────────┐
│                    CAVE SYSTEM                               │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  CaveCarver3D (главный класс)                               │
│  ├── SpaghettiCaveCarver    — длинные туннели               │
│  ├── CheeseCaveCarver       — большие залы                  │
│  ├── NoodleCaveCarver       — узкие проходы                 │
│  ├── AquiferCarver          — подземные реки/озёра          │
│  └── RegionalCaveCarver     — биом-специфичные              │
│                                                              │
│  CaveBiomeProvider                                          │
│  ├── CRYSTAL_CAVES          — White Mountains               │
│  ├── MITHRIL_CAVES          — Misty Mountains               │
│  ├── LAVA_TUBES             — Mordor                        │
│  ├── FLOODED_CAVES          — Ithilien                      │
│  └── DWARVEN_HALLS          — Везде (редкие)                │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

### 5.2 Основные классы

#### CaveCarver3D.java

```java
package net.sima.bfme.worldgen.caves;

/**
 * Главный 3D карвер пещер.
 * Работает ПОСЛЕ heightmap — вырезает пустоты.
 */
public class CaveCarver3D {
    
    private static CaveCarver3D instance;
    
    private final SpaghettiCaveCarver spaghetti;
    private final CheeseCaveCarver cheese;
    private final NoodleCaveCarver noodle;
    private final AquiferCarver aquifer;
    private final RegionalCaveCarver regional;
    
    private long worldSeed;
    private boolean initialized = false;
    
    // Кэш результатов (chunk-based)
    private final ConcurrentHashMap<Long, boolean[]> caveCache;
    
    public void initialize(long seed) {
        this.worldSeed = seed;
        spaghetti.initialize(seed);
        cheese.initialize(seed ^ 0x1234);
        noodle.initialize(seed ^ 0x5678);
        aquifer.initialize(seed ^ 0x9ABC);
        regional.initialize(seed ^ 0xDEF0);
        initialized = true;
    }
    
    /**
     * Проверяет, является ли блок частью пещеры
     * 
     * @return CaveResult с типом пещеры и флагом воды
     */
    public CaveResult carve(int x, int y, int z, int surfaceHeight, ResourceKey<Biome> biome) {
        if (!initialized) throw new IllegalStateException("Not initialized!");
        
        // Не карвим выше поверхности
        if (y >= surfaceHeight - 2) return CaveResult.SOLID;
        
        // Не карвим слишком глубоко (bedrock zone)
        if (y < -180) return CaveResult.SOLID;
        
        // Региональные пещеры (приоритет)
        CaveResult regional = this.regional.carve(x, y, z, biome);
        if (regional.isCave()) return regional;
        
        // Spaghetti (длинные туннели)
        if (spaghetti.isCave(x, y, z)) {
            // Проверяем aquifer для воды
            if (aquifer.isFlooded(x, y, z)) {
                return CaveResult.WATER_CAVE;
            }
            return CaveResult.AIR_CAVE;
        }
        
        // Cheese (большие залы)
        if (cheese.isCave(x, y, z)) {
            if (aquifer.isFlooded(x, y, z)) {
                return CaveResult.WATER_CAVE;
            }
            return CaveResult.AIR_CAVE;
        }
        
        // Noodle (узкие)
        if (noodle.isCave(x, y, z)) {
            return CaveResult.AIR_CAVE;
        }
        
        return CaveResult.SOLID;
    }
    
    public enum CaveResult {
        SOLID,          // Не пещера
        AIR_CAVE,       // Воздух
        WATER_CAVE,     // Вода
        LAVA_CAVE       // Лава (глубоко)
    }
}
```

#### SpaghettiCaveCarver.java

```java
package net.sima.bfme.worldgen.caves;

/**
 * Spaghetti caves — длинные извилистые туннели.
 * Используем 2 пересекающихся 3D noise для создания туннелей.
 */
public class SpaghettiCaveCarver {
    
    private OctaveNoise noise1;
    private OctaveNoise noise2;
    
    // Параметры
    private static final float TUNNEL_THRESHOLD = 0.015f;  // Меньше = уже туннели
    private static final float NOISE_SCALE = 800.0f;       // Больше = длиннее без разрывов
    private static final float Y_STRETCH = 0.7f;           // Сжатие по Y (туннели более горизонтальные)
    
    public void initialize(long seed) {
        noise1 = new OctaveNoise(seed, 2, NOISE_SCALE, 0.5, 2.0);
        noise2 = new OctaveNoise(seed ^ 0xABCDEF, 2, NOISE_SCALE * 0.8, 0.5, 2.0);
    }
    
    public boolean isCave(int x, int y, int z) {
        // Y растягиваем для более горизонтальных туннелей
        float yStretched = y * Y_STRETCH;
        
        float n1 = (float) noise1.sample3D(x, yStretched, z);
        float n2 = (float) noise2.sample3D(x, yStretched, z);
        
        // Сумма квадратов близка к 0 = туннель
        float tunnelValue = n1 * n1 + n2 * n2;
        
        // Глубина влияет на размер туннелей
        float depthFactor = getDepthFactor(y);
        
        return tunnelValue < TUNNEL_THRESHOLD * depthFactor;
    }
    
    private float getDepthFactor(int y) {
        // Больше пещер на средней глубине
        if (y > 50) return 0.5f;        // Мало у поверхности
        if (y > 0) return 1.0f;         // Норма
        if (y > -64) return 1.3f;       // Больше в deepslate
        return 0.8f;                     // Меньше у bedrock
    }
}
```

#### AquiferCarver.java

```java
package net.sima.bfme.worldgen.caves;

/**
 * Aquifers — подземные водоёмы.
 * Заполняют пещеры водой ниже определённого уровня.
 */
public class AquiferCarver {
    
    private OctaveNoise aquiferNoise;
    private OctaveNoise levelNoise;
    
    // Параметры
    private static final int BASE_WATER_LEVEL = -10;       // Базовый уровень воды
    private static final float LEVEL_VARIATION = 30.0f;    // Вариация уровня
    private static final float AQUIFER_SCALE = 400.0f;     // Размер водоёмов
    
    public void initialize(long seed) {
        aquiferNoise = new OctaveNoise(seed, 2, AQUIFER_SCALE, 0.5, 2.0);
        levelNoise = new OctaveNoise(seed ^ 0x11111, 2, 200.0, 0.5, 2.0);
    }
    
    /**
     * Проверяет, затоплена ли эта точка
     */
    public boolean isFlooded(int x, int y, int z) {
        // Локальный уровень воды (варьируется)
        float localLevel = BASE_WATER_LEVEL + 
            (float) levelNoise.sample2D(x, z) * LEVEL_VARIATION;
        
        if (y > localLevel) return false;
        
        // Не все области ниже уровня затоплены
        float aquiferValue = (float) aquiferNoise.sample2D(x, z);
        return aquiferValue > 0.3f;  // 70% шанс воды
    }
    
    /**
     * Для длинных подземных рек — специальный режим
     */
    public boolean isUndergroundRiver(int x, int y, int z) {
        // Река = узкая полоса воды
        float riverNoise = (float) aquiferNoise.sample2D(x * 0.5, z * 0.5);
        
        // Близко к 0 = река
        if (Math.abs(riverNoise) > 0.05f) return false;
        
        // Уровень реки
        int riverLevel = (int) (levelNoise.sample2D(x, z) * 20 - 30);
        
        return y >= riverLevel - 3 && y <= riverLevel;
    }
}
```

#### RegionalCaveCarver.java

```java
package net.sima.bfme.worldgen.caves;

/**
 * Региональные пещеры — уникальные для биомов.
 */
public class RegionalCaveCarver {
    
    private OctaveNoise hallNoise;
    private OctaveNoise crystalNoise;
    
    public void initialize(long seed) {
        hallNoise = new OctaveNoise(seed, 2, 150.0, 0.5, 2.0);
        crystalNoise = new OctaveNoise(seed ^ 0x22222, 3, 50.0, 0.6, 2.0);
    }
    
    public CaveCarver3D.CaveResult carve(int x, int y, int z, ResourceKey<Biome> biome) {
        // White Mountains — кристальные пещеры
        if (isWhiteMountainsBiome(biome)) {
            if (isCrystalCave(x, y, z)) {
                return CaveCarver3D.CaveResult.AIR_CAVE;
                // TODO: Пометить для декорирования кристаллами
            }
        }
        
        // Mordor — лавовые трубы
        if (isMordorBiome(biome)) {
            if (isLavaTube(x, y, z)) {
                if (y < -50) return CaveCarver3D.CaveResult.LAVA_CAVE;
                return CaveCarver3D.CaveResult.AIR_CAVE;
            }
        }
        
        // Везде — редкие большие залы
        if (isDwarvenHall(x, y, z)) {
            return CaveCarver3D.CaveResult.AIR_CAVE;
        }
        
        return CaveCarver3D.CaveResult.SOLID;
    }
    
    /**
     * Большие залы (будущие гномьи чертоги)
     */
    private boolean isDwarvenHall(int x, int y, int z) {
        // Редкие, но большие
        float n = (float) hallNoise.sample3D(x, y * 0.5, z);
        return n > 0.75f;  // Только 25% верхних значений
    }
    
    /**
     * Кристальные пещеры — кластеры маленьких полостей
     */
    private boolean isCrystalCave(int x, int y, int z) {
        if (y > -20 || y < -100) return false;  // Только на глубине
        
        float n = (float) crystalNoise.sample3D(x, y, z);
        return n > 0.6f;
    }
}
```

### 5.3 Интеграция в ChunkGenerator

```java
// В BFMEChunkGenerator.java — модифицированный generateColumn

private void generateColumn(ChunkAccess chunk, BlockPos.MutableBlockPos pos,
                            int localX, int localZ, int worldX, int worldZ,
                            int surfaceHeight, BFMEBiome biome, ResourceKey<Biome> biomeKey) {
    
    // ... существующий код для bedrock, deepslate, stone ...
    
    // === CAVE CARVING ===
    for (int y = minY + BEDROCK_LAYERS; y < surfaceHeight; y++) {
        CaveCarver3D.CaveResult caveResult = caveCarver.carve(worldX, y, worldZ, surfaceHeight, biomeKey);
        
        switch (caveResult) {
            case AIR_CAVE:
                chunk.setBlockState(pos.set(localX, y, localZ), Blocks.AIR.defaultBlockState(), false);
                break;
            case WATER_CAVE:
                chunk.setBlockState(pos.set(localX, y, localZ), Blocks.WATER.defaultBlockState(), false);
                break;
            case LAVA_CAVE:
                chunk.setBlockState(pos.set(localX, y, localZ), Blocks.LAVA.defaultBlockState(), false);
                break;
            case SOLID:
                // Обычный блок (уже установлен)
                break;
        }
    }
    
    // ... остальной код ...
}
```

---

## 7. ФАЗА 4: ПЕЩЕРНЫЕ БИОМЫ

### 6.1 Система декорирования пещер

```java
package net.sima.bfme.worldgen.caves.decoration;

/**
 * Декорирует пещеры после карвинга
 */
public class CaveDecorator {
    
    /**
     * Вызывается после генерации чанка
     */
    public void decorate(ChunkAccess chunk, ResourceKey<Biome> surfaceBiome) {
        CaveBiome caveBiome = getCaveBiome(surfaceBiome, chunk);
        
        for (BlockPos pos : getCaveFloorPositions(chunk)) {
            // Пол пещеры
            decorateFloor(chunk, pos, caveBiome);
        }
        
        for (BlockPos pos : getCaveCeilingPositions(chunk)) {
            // Потолок
            decorateCeiling(chunk, pos, caveBiome);
        }
        
        for (BlockPos pos : getCaveWallPositions(chunk)) {
            // Стены
            decorateWalls(chunk, pos, caveBiome);
        }
    }
    
    private void decorateFloor(ChunkAccess chunk, BlockPos pos, CaveBiome biome) {
        switch (biome) {
            case CRYSTAL_CAVES:
                // Кристаллы растут с пола
                if (random.nextFloat() < 0.1f) {
                    placeCrystalCluster(chunk, pos, CrystalType.AMETHYST);
                }
                break;
                
            case FLOODED_CAVES:
                // Светящиеся водоросли
                if (isUnderwater(chunk, pos) && random.nextFloat() < 0.2f) {
                    chunk.setBlockState(pos, Blocks.GLOW_LICHEN.defaultBlockState(), false);
                }
                break;
                
            case LUSH_CAVES:
                // Мох, азалия
                if (random.nextFloat() < 0.3f) {
                    chunk.setBlockState(pos, Blocks.MOSS_BLOCK.defaultBlockState(), false);
                }
                break;
        }
    }
    
    private void decorateCeiling(ChunkAccess chunk, BlockPos pos, CaveBiome biome) {
        switch (biome) {
            case CRYSTAL_CAVES:
                // Сталактиты
                if (random.nextFloat() < 0.15f) {
                    placeStalactite(chunk, pos);
                }
                break;
                
            case FLOODED_CAVES:
                // Светящиеся лианы
                if (random.nextFloat() < 0.1f) {
                    placeGlowVines(chunk, pos, 3 + random.nextInt(5));
                }
                break;
        }
    }
}
```

### 6.2 Типы пещерных биомов

```java
public enum CaveBiome {
    // Общие
    STANDARD,           // Обычные пещеры
    DRIPSTONE,          // Сталактиты/сталагмиты
    LUSH,               // Пышные (ваниль)
    
    // Региональные
    CRYSTAL_CAVES,      // Кристаллы (White Mountains)
    MITHRIL_VEINS,      // Мифрил (Misty Mountains)
    LAVA_TUBES,         // Лавовые трубы (Mordor)
    FLOODED_GROTTOS,    // Затопленные гроты (Ithilien)
    FUNGAL_DEPTHS,      // Грибные (Mirkwood underground)
    DWARVEN_RUINS       // Руины гномов (везде, редко)
}
```

---

## 8. ФАЗА 5: ДЕРЕВЬЯ И РАСТИТЕЛЬНОСТЬ

### 7.1 Архитектура системы деревьев

```
┌─────────────────────────────────────────────────────────────┐
│                    TREE SYSTEM                               │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  TreeRegistry                                                │
│  ├── registerTree(TreeType, TreeGenerator)                  │
│  └── getGenerator(TreeType) → TreeGenerator                 │
│                                                              │
│  TreeGenerator (interface)                                   │
│  ├── generate(world, pos, random) → boolean                 │
│  ├── getMinHeight() → int                                   │
│  ├── getMaxHeight() → int                                   │
│  └── getSaplingSize() → SaplingSize (1x1, 2x2, 3x3, 4x4)   │
│                                                              │
│  Implementations:                                            │
│  ├── OakTreeGenerator                                        │
│  ├── PineTreeGenerator                                       │
│  ├── MallornTreeGenerator (гигантский, 4x4)                 │
│  ├── LebethronTreeGenerator (Gondor)                        │
│  ├── FirTreeGenerator (разные размеры)                      │
│  └── ... (30+ типов)                                        │
│                                                              │
│  TreePlacer                                                  │
│  ├── placeTreesInChunk(chunk, biome)                        │
│  └── canPlaceTree(pos, size, slope) → boolean               │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

### 7.2 Базовый генератор деревьев

```java
package net.sima.bfme.worldgen.trees;

/**
 * Базовый класс для генераторов деревьев
 */
public abstract class BaseTreeGenerator implements TreeGenerator {
    
    protected final int minHeight;
    protected final int maxHeight;
    protected final SaplingSize saplingSize;
    
    // Блоки
    protected final Block logBlock;
    protected final Block leavesBlock;
    
    @Override
    public boolean generate(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        int height = minHeight + random.nextInt(maxHeight - minHeight + 1);
        
        // Проверяем место
        if (!canGrow(level, pos, height)) return false;
        
        // Генерируем ствол
        generateTrunk(level, pos, height, random);
        
        // Генерируем крону
        generateCanopy(level, pos.above(height), height, random);
        
        // Дополнительные элементы (корни, ветки)
        generateExtras(level, pos, height, random);
        
        return true;
    }
    
    protected abstract void generateTrunk(ServerLevelAccessor level, BlockPos pos, 
                                          int height, RandomSource random);
    
    protected abstract void generateCanopy(ServerLevelAccessor level, BlockPos top, 
                                           int height, RandomSource random);
    
    protected void generateExtras(ServerLevelAccessor level, BlockPos pos, 
                                  int height, RandomSource random) {
        // По умолчанию ничего
    }
    
    /**
     * Проверка места для роста
     */
    protected boolean canGrow(ServerLevelAccessor level, BlockPos pos, int height) {
        // Проверяем землю
        BlockState ground = level.getBlockState(pos.below());
        if (!ground.is(BlockTags.DIRT)) return false;
        
        // Проверяем пространство
        for (int y = 0; y < height + 4; y++) {
            int radius = y < height * 0.6 ? 1 : 3;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = pos.offset(x, y, z);
                    if (!level.getBlockState(checkPos).isAir() && 
                        !level.getBlockState(checkPos).is(BlockTags.LEAVES)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
```

### 7.3 Пример: Генератор сосны

```java
package net.sima.bfme.worldgen.trees.types;

/**
 * Генератор сосны с разнообразием форм
 */
public class PineTreeGenerator extends BaseTreeGenerator {
    
    public enum PineVariant {
        TALL_THIN,      // Высокая узкая
        STANDARD,       // Обычная
        SNOW_LADEN,     // Со снегом
        ANCIENT         // Старая раскидистая
    }
    
    public PineTreeGenerator() {
        super(8, 20, SaplingSize.SIZE_1X1, ModBlocks.PINE_LOG.get(), ModBlocks.PINE_LEAVES.get());
    }
    
    @Override
    protected void generateTrunk(ServerLevelAccessor level, BlockPos pos, 
                                 int height, RandomSource random) {
        for (int y = 0; y < height; y++) {
            level.setBlock(pos.above(y), logBlock.defaultBlockState(), 3);
        }
    }
    
    @Override
    protected void generateCanopy(ServerLevelAccessor level, BlockPos top, 
                                  int height, RandomSource random) {
        PineVariant variant = pickVariant(random);
        
        switch (variant) {
            case TALL_THIN:
                generateThinCanopy(level, top, height, random);
                break;
            case STANDARD:
                generateStandardCanopy(level, top, height, random);
                break;
            case SNOW_LADEN:
                generateSnowCanopy(level, top, height, random);
                break;
            case ANCIENT:
                generateAncientCanopy(level, top, height, random);
                break;
        }
    }
    
    private void generateStandardCanopy(ServerLevelAccessor level, BlockPos top, 
                                        int height, RandomSource random) {
        // Конусообразная крона
        int canopyStart = height / 3;
        int canopyHeight = height - canopyStart;
        
        for (int y = 0; y < canopyHeight; y++) {
            // Радиус уменьшается к верху
            float progress = (float) y / canopyHeight;
            int radius = (int) ((1 - progress) * 4) + 1;
            
            // Слои листвы с промежутками
            if (y % 2 == 0 || y == canopyHeight - 1) {
                for (int x = -radius; x <= radius; x++) {
                    for (int z = -radius; z <= radius; z++) {
                        float dist = (float) Math.sqrt(x*x + z*z);
                        if (dist <= radius + 0.5f) {
                            // Рваные края
                            if (dist > radius - 0.5f && random.nextFloat() < 0.3f) continue;
                            
                            BlockPos leafPos = top.offset(x, -canopyHeight + y, z);
                            if (level.getBlockState(leafPos).isAir()) {
                                level.setBlock(leafPos, leavesBlock.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
        }
        
        // Верхушка
        level.setBlock(top, leavesBlock.defaultBlockState(), 3);
    }
    
    private PineVariant pickVariant(RandomSource random) {
        float roll = random.nextFloat();
        if (roll < 0.4f) return PineVariant.STANDARD;
        if (roll < 0.7f) return PineVariant.TALL_THIN;
        if (roll < 0.9f) return PineVariant.SNOW_LADEN;
        return PineVariant.ANCIENT;
    }
}
```

### 7.4 Гигантские деревья (3x3, 4x4)

```java
package net.sima.bfme.worldgen.trees.types;

/**
 * Мэллорн — гигантское дерево Лотлориэна
 * Размер саженца: 4x4
 */
public class MallornTreeGenerator extends BaseTreeGenerator {
    
    public MallornTreeGenerator() {
        super(40, 70, SaplingSize.SIZE_4X4, ModBlocks.MALLORN_LOG.get(), ModBlocks.MALLORN_LEAVES.get());
    }
    
    @Override
    protected void generateTrunk(ServerLevelAccessor level, BlockPos pos, 
                                 int height, RandomSource random) {
        // Ствол 2x2 (центрирован в 4x4)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < 2; x++) {
                for (int z = 0; z < 2; z++) {
                    level.setBlock(pos.offset(x, y, z), logBlock.defaultBlockState(), 3);
                }
            }
        }
        
        // Корни-buttress
        generateButtressRoots(level, pos, random);
    }
    
    @Override
    protected void generateCanopy(ServerLevelAccessor level, BlockPos top, 
                                  int height, RandomSource random) {
        // Огромная раскидистая крона
        int canopyRadius = 12 + random.nextInt(6);
        int canopyHeight = 15 + random.nextInt(8);
        
        // Главные ветки
        int numBranches = 5 + random.nextInt(4);
        for (int i = 0; i < numBranches; i++) {
            float angle = (float) (i * Math.PI * 2 / numBranches) + random.nextFloat() * 0.5f;
            generateMajorBranch(level, top, angle, canopyRadius, random);
        }
        
        // Заполняем листвой
        for (int y = -5; y < canopyHeight; y++) {
            int layerRadius = (int) (canopyRadius * (1 - Math.abs(y - canopyHeight/2f) / canopyHeight));
            fillLeafLayer(level, top.above(y), layerRadius, random);
        }
    }
    
    private void generateButtressRoots(ServerLevelAccessor level, BlockPos pos, 
                                       RandomSource random) {
        // 4-6 выступающих корней
        int numRoots = 4 + random.nextInt(3);
        for (int i = 0; i < numRoots; i++) {
            float angle = (float) (i * Math.PI * 2 / numRoots);
            int length = 3 + random.nextInt(4);
            
            for (int r = 1; r <= length; r++) {
                int x = (int) (Math.cos(angle) * r);
                int z = (int) (Math.sin(angle) * r);
                int y = Math.max(0, 2 - r);  // Понижается к земле
                
                BlockPos rootPos = pos.offset(x, y, z);
                level.setBlock(rootPos, logBlock.defaultBlockState(), 3);
            }
        }
    }
}
```

### 7.5 TreePlacer — размещение деревьев

```java
package net.sima.bfme.worldgen.trees;

/**
 * Размещает деревья в чанке согласно биому
 */
public class TreePlacer {
    
    private final TreeRegistry registry;
    
    public void placeTreesInChunk(ServerLevelAccessor level, ChunkAccess chunk, 
                                   ResourceKey<Biome> biome, RandomSource random) {
        BiomeTreeConfig config = getTreeConfig(biome);
        if (config == null || config.treeDensity <= 0) return;
        
        ChunkPos chunkPos = chunk.getPos();
        int attempts = config.getPlacementAttempts();
        
        for (int i = 0; i < attempts; i++) {
            int x = chunkPos.getMinBlockX() + random.nextInt(16);
            int z = chunkPos.getMinBlockZ() + random.nextInt(16);
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
            
            BlockPos pos = new BlockPos(x, y, z);
            
            // Проверяем уклон
            float slope = getSlopeAt(level, pos);
            if (slope > config.maxSlope) continue;
            
            // Выбираем тип дерева
            TreeType treeType = config.pickTreeType(random);
            TreeGenerator generator = registry.getGenerator(treeType);
            
            // Проверяем размер саженца
            if (!canPlaceSapling(level, pos, generator.getSaplingSize())) continue;
            
            // Генерируем
            generator.generate(level, pos, random);
        }
    }
    
    private boolean canPlaceSapling(ServerLevelAccessor level, BlockPos pos, SaplingSize size) {
        int s = size.getSize();
        for (int x = 0; x < s; x++) {
            for (int z = 0; z < s; z++) {
                BlockPos checkPos = pos.offset(x, -1, z);
                if (!level.getBlockState(checkPos).is(BlockTags.DIRT)) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

---

## 9. ФАЗА 6: СТРУКТУРЫ

### 8.1 Типы структур

```
┌─────────────────────────────────────────────────────────────┐
│                    STRUCTURES                                │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  POI (Points of Interest):                                  │
│  ├── Ruins (руины)                                          │
│  ├── Camps (лагеря)                                         │
│  ├── Towers (башни)                                         │
│  └── Shrines (святилища)                                    │
│                                                              │
│  Major Structures:                                          │
│  ├── Minas Tirith (уникальная)                             │
│  ├── Osgiliath (уникальная)                                │
│  ├── Villages (деревни по биомам)                          │
│  └── Fortresses (крепости)                                  │
│                                                              │
│  Underground:                                                │
│  ├── Mine shafts                                            │
│  ├── Dwarven halls                                          │
│  └── Tombs                                                  │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

### 8.2 Для альфа-теста (минимум)

- Простые руины (template structures)
- Небольшие лагеря
- Базовые POI маркеры

**Полноценные структуры — после альфы.**

---

## 10. ТЕХНИЧЕСКИЕ КОНСТАНТЫ

```java
// === МИРОВЫЕ КОНСТАНТЫ ===
public static final int WORLD_MIN_Y = -192;
public static final int WORLD_MAX_Y = 448;
public static final int SEA_LEVEL = 64;
public static final int WORLD_HEIGHT = WORLD_MAX_Y - WORLD_MIN_Y;  // 640

// === КАРТА ===
public static final int PIXEL_WEIGHT = 4;           // 1 пиксель = 4 блока
public static final int MAP_TILES = 8;              // 8x8 тайлов
public static final int TILE_SIZE_PIXELS = 1000;    // 1000x1000 пикселей
public static final int WORLD_SIZE_BLOCKS = MAP_TILES * TILE_SIZE_PIXELS * PIXEL_WEIGHT;  // 32000

// === VORONOI ===
// ВАЖНО: voronoiGridSize — ПАРАМЕТР БИОМА, не глобальная константа!
// Но единый внутри горной группы (foothills+mountains+peaks = одна сетка)
public static final float VORONOI_BASE_JITTER = 0.4f;  // Базовый jitter центров
public static final float VORONOI_WARP_MIN = 0f;       // Выкл для равнин
public static final float VORONOI_WARP_MAX = 80f;      // Макс для хаотичных гор

// voronoiGridSize по горным группам (примеры):
// White Mountains (все уровни): 200 → массивные, редкие пики
// Ephel Duath (все уровни):     150 → хаотичные, частые пики
// Равнины: без разницы, mountainChance = 0

// === ПЕЩЕРЫ ===
public static final float SPAGHETTI_THRESHOLD = 0.015f;
public static final float SPAGHETTI_SCALE = 800.0f;
public static final float CHEESE_THRESHOLD = 0.75f;
public static final int AQUIFER_BASE_LEVEL = -10;

// === КЭШИ ===
public static final int CACHE_MAX_SIZE = 262144;    // ~1MB per cache
public static final int VORONOI_CACHE_SIZE = 65536;
public static final int CAVE_CACHE_SIZE = 131072;

// === ПРОИЗВОДИТЕЛЬНОСТЬ ===
public static final int TARGET_CHUNK_GEN_MS = 5;    // Цель: <5мс на чанк
public static final int MAX_RAM_MB = 8192;          // 8GB
```

---

## 11. ФАЙЛОВАЯ СТРУКТУРА

```
src/main/java/net/sima/bfme/worldgen/
├── biomes/
│   ├── surface/
│   │   ├── BFMEBiome.java              [существует]
│   │   ├── BFMEBiomes.java             [существует]
│   │   ├── BFMEBiomesData.java         [существует]
│   │   ├── BFMEBiomeSource.java        [существует]
│   │   ├── SlopeMap.java               [существует]
│   │   └── SlopeMaps.java              [существует]
│   └── BFMEBiomeKeys.java              [существует]
│
├── chunkgen/
│   ├── BFMEChunkGenerator.java         [существует, модифицировать]
│   └── map/
│       ├── BFMEHeightMapV10.java       [существует]
│       └── BFMEHeightMapV11.java       [СОЗДАТЬ]
│
├── terrain/
│   ├── BiomeProfileRegistry.java       [существует, расширить]
│   ├── BiomeTerrainProfile.java        [существует, расширить]
│   │   └── Новые параметры:
│   │       - voronoiGridSize (int)     // размер Voronoi сетки
│   │       - mountainChance (float)    // вероятность пика в ячейке
│   │       - peakHeightMin/Max (int)   // диапазон высот пиков
│   │       - mountainRadiusMin/Max     // диапазон радиусов
│   │       - ridgeChance (float)       // вероятность хребта к соседу
│   │       - warpStrength (float)      // сила domain warping
│   ├── TerrainType.java                [существует]
│   ├── voronoi/                        [СОЗДАТЬ]
│   │   ├── VoronoiMountainLayer.java
│   │   ├── VoronoiCell.java
│   │   ├── VoronoiResult.java
│   │   ├── MountainShape.java
│   │   └── RidgeConnector.java
│   └── modifiers/
│       ├── TerrainModifier.java        [существует]
│       ├── TerrainModifierManager.java [существует]
│       ├── TerraceModifier.java        [существует]
│       ├── ErosionModifier.java        [существует, улучшить]
│       ├── CliffModifier.java          [существует, улучшить]
│       └── RadialRidgeModifier.java    [СОЗДАТЬ]
│
├── caves/                              [СОЗДАТЬ]
│   ├── CaveCarver3D.java
│   ├── SpaghettiCaveCarver.java
│   ├── CheeseCaveCarver.java
│   ├── NoodleCaveCarver.java
│   ├── AquiferCarver.java
│   ├── RegionalCaveCarver.java
│   └── decoration/
│       ├── CaveDecorator.java
│       └── CaveBiome.java
│
├── trees/                              [СОЗДАТЬ]
│   ├── TreeRegistry.java
│   ├── TreeGenerator.java
│   ├── BaseTreeGenerator.java
│   ├── TreePlacer.java
│   ├── SaplingSize.java
│   └── types/
│       ├── PineTreeGenerator.java
│       ├── OakTreeGenerator.java
│       ├── MallornTreeGenerator.java
│       └── ... (30+ типов)
│
├── noise/
│   ├── WorldNoiseGenerator.java        [существует]
│   ├── OctaveNoise.java                [существует]
│   ├── OpenSimplex2.java               [существует]
│   └── OpenSimplex2S.java              [существует]
│
└── map/
    ├── BFMEMapRuntime.java             [существует]
    └── BFMEMapConfigs.java             [существует]
```

---

## 12. КРИТЕРИИ УСПЕХА

### Фаза 1: Voronoi Mountains
- [ ] Горы формируются как отдельные пики
- [ ] Пики соединяются в хребты
- [ ] Разные формы (DOME, JAGGED) видны
- [ ] Переходы между биомами плавные
- [ ] **Визуально похоже на референс 11**

### Фаза 2: Modifiers
- [ ] Эрозионные промоины видны на склонах
- [ ] Обрывы на крутых участках
- [ ] Радиальные хребты на острых пиках
- [ ] **Визуально похоже на референсы 5, 6**

### Фаза 2.5: V12 Terrain Blend System
- [ ] Формула высоты исправлена (нет отрицательных значений)
- [ ] Ridge noise создаёт видимые острые хребты на горах
- [ ] Billow noise создаёт мягкий рельеф на равнинах
- [ ] Cellular noise работает для mesa-style биомов
- [ ] Domain warp убирает регулярные паттерны
- [ ] V12 работает вместе с Voronoi горами
- [ ] **Разный характер рельефа для разных биомов**

### Фаза 3: Caves
- [ ] Spaghetti caves работают (длинные туннели)
- [ ] Подземные реки 500+ блоков
- [ ] Большие залы генерируются
- [ ] Нет дыр в поверхности
- [ ] **Производительность <5мс на чанк**

### Фаза 4: Cave Biomes
- [ ] Кристальные пещеры в White Mountains
- [ ] Лавовые трубы в Mordor
- [ ] Декорации размещаются корректно

### Фаза 5: Trees
- [ ] Все 30 типов деревьев генерируются
- [ ] 3x3 и 4x4 саженцы работают
- [ ] Плотность соответствует биому
- [ ] Деревья не висят в воздухе

### Фаза 6: Structures
- [ ] Базовые руины размещаются
- [ ] Не конфликтуют с террейном

### Общие критерии
- [ ] RAM < 6GB при генерации
- [ ] Chunk gen < 5мс среднее
- [ ] Совместимость с Distant Horizons
- [ ] Нет крашей при 2 часах игры

---

## 13. РИСКИ И РЕШЕНИЯ

| Риск | Вероятность | Решение |
|------|-------------|---------|
| Переходы между биомами артефактят | Высокая | Увеличить blur radius, добавить transition biomes |
| Производительность < целевой | Средняя | LOD для дальних чанков, агрессивнее кэшировать |
| Voronoi создаёт регулярные паттерны | Низкая | **РЕШЕНО:** Domain Warping (warpStrength 60-80) ломает сетку |
| Пещеры пробивают поверхность | Средняя | Проверка surfaceHeight перед карвингом |
| Деревья на воде/склонах | Низкая | Строгие проверки canPlace |
| OOM при больших мирах | Низкая | Лимиты кэшей, очистка по LRU |
| V12 формула создаёт артефакты | **АКТИВНО** | Исправить формулу: delta не должен уходить в минус |
| V12 масштабы шумов накладываются | Низкая | **РЕШЕНО:** Разные масштабы (500, 900, 700, 350) |

---

## СЛЕДУЮЩИЙ ШАГ

### Немедленно (V12 Blend System):
1. **КРИТИЧНО:** Исправить формулу в `BFMEHeightMapV11.calculateHills()`:
   - Текущая: `delta = (delta - 0.5) * 80.0 * reliefScale` → создаёт минусы
   - Нужно: формула без отрицательных значений
2. Протестировать V12 на ОДНОМ биоме (PELENNOR_PLAINS)
3. После успеха — применить к остальным равнинам
4. Проверить совместимость V12 + Voronoi на горных биомах

### После V12:
5. Улучшить ErosionModifier (направленные промоины)
6. Протестировать полный pipeline: Voronoi → V12 → Erosion
7. Оптимизация и кэширование

### Voronoi (завершено ранее):
- ✅ VoronoiMountainLayer.java
- ✅ MountainShape.java
- ✅ BiomeTerrainProfile Voronoi params
- ✅ BFMEHeightMapV11.java интеграция

---

*Документ создан: 25.01.2026*
*Обновлён: 30.01.2026 — добавлена секция V12 Terrain Blend System*
*Автор: Claude AI + Mikita*
