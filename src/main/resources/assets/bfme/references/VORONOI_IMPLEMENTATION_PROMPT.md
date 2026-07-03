# VORONOI MOUNTAIN SYSTEM — Промпт для реализации

## КОНТЕКСТ

Реализуем систему генерации гор на основе Voronoi диаграммы для BFME мода (NeoForge 1.21.1).
Текущая проблема: горы обрезаются на границах биомов. Нужна архитектура где пик принадлежит ЯЧЕЙКЕ, а не биому.

---

## КЛЮЧЕВАЯ АРХИТЕКТУРА

### Принцип: ПИК ПРИНАДЛЕЖИТ ЯЧЕЙКЕ, НЕ БИОМУ

```
НЕПРАВИЛЬНО:                          ПРАВИЛЬНО:
┌─────────┬─────────┐                 ┌─────────┬─────────┐
│ PEAKS   │FOOTHILLS│                 │ PEAKS   │FOOTHILLS│
│   🏔️    │   🏔️    │ ← два пика     │      🏔️           │ ← ОДИН пик
│  (обрез)│(обрез)  │                 │    (плавно)       │
└─────────┴─────────┘                 └─────────┴─────────┘

Пик по биому → обрезается            Пик по ячейке → влияет на все биомы
```

### Mountain Regions

Каждый горный массив = отдельная Voronoi сетка:

```java
public enum MountainRegion {
    WHITE_MOUNTAINS(200, 1),  // gridSize=200, seedOffset=1
    EPHEL_DUATH(150, 2),      // gridSize=150, seedOffset=2
    NONE(0, 0);               // нет гор — холмы через шум
    
    public final int gridSize;
    public final int seedOffset;
}
```

**Определение региона:** по биому в ЦЕНТРЕ ячейки.

```java
MountainRegion getRegion(ResourceKey<Biome> biome) {
    return switch (biome) {
        case WHITE_MOUNTAINS, WHITE_MOUNTAINS_PEAKS, 
             WHITE_MOUNTAINS_HIGH_PEAKS, WHITE_MOUNTAINS_FOOTHILLS 
             -> MountainRegion.WHITE_MOUNTAINS;
             
        case EPHEL_DUATH, EPHEL_DUATH_PEAKS, EPHEL_DUATH_BLACK_PEAKS 
             -> MountainRegion.EPHEL_DUATH;
             
        default -> MountainRegion.NONE;
    };
}
```

### Критичное правило

**Между горными регионами ВСЕГДА есть буферные зоны (равнины, холмы).** 
Если пики разных регионов случайно пересеклись: `height = max(peakA, peakB)` — это ОК, шумы замаскируют.

---

## АЛГОРИТМ ГЕНЕРАЦИИ

### Шаг 1: Определение ячейки

```java
VoronoiResult query(int blockX, int blockZ) {
    // Domain Warping — убирает регулярность сетки
    float warpStrength = 70f;  // 60-80 блоков
    float wx = blockX + warpNoise.sample(blockX, blockZ) * warpStrength;
    float wz = blockZ + warpNoise.sample(blockX + 31337, blockZ + 31337) * warpStrength;
    
    // Находим ячейку
    int cellX = floor(wx / gridSize);
    int cellZ = floor(wz / gridSize);
    
    // Проверяем 3x3 соседей, находим ближайший центр
    ...
}
```

### Шаг 2: Генерация пика (один раз на ячейку, кэшируется)

```java
VoronoiCell getOrCreateCell(int cellX, int cellZ, long worldSeed) {
    long cellKey = packCoords(cellX, cellZ);
    
    return cellCache.computeIfAbsent(cellKey, k -> {
        // Центр ячейки с jitter
        Random cellRandom = new Random(worldSeed ^ cellKey);
        float jitter = 0.4f;
        float centerX = (cellX + 0.5f + (cellRandom.nextFloat() - 0.5f) * jitter) * gridSize;
        float centerZ = (cellZ + 0.5f + (cellRandom.nextFloat() - 0.5f) * jitter) * gridSize;
        
        // Биом в ЦЕНТРЕ ячейки определяет параметры
        Biome centerBiome = getBiome(centerX, centerZ);
        BiomeTerrainProfile profile = getProfile(centerBiome);
        MountainRegion region = getRegion(centerBiome);
        
        // Решаем, есть ли пик
        if (region == NONE || cellRandom.nextFloat() > profile.getMountainChance()) {
            return new VoronoiCell(centerX, centerZ, null);  // нет пика
        }
        
        // Генерируем пик
        MountainPeak peak = new MountainPeak(
            height: randomRange(profile.peakHeightMin, profile.peakHeightMax),
            radius: randomRange(profile.radiusMin, profile.radiusMax),
            shape:  profile.getRandomShape(cellRandom),  // DOME, JAGGED, PLATEAU
            ridgeChance: profile.ridgeChance
        );
        
        return new VoronoiCell(centerX, centerZ, peak);
    });
}
```

### Шаг 3: Расчёт высоты для блока

```java
float getMountainHeight(int blockX, int blockZ) {
    // Собираем влияние от ближайших ячеек (5x5 для больших радиусов)
    float totalHeight = 0;
    
    for (VoronoiCell cell : getNearestCells(blockX, blockZ, searchRadius: 2)) {
        if (cell.peak == null) continue;
        
        float dist = distance(blockX, blockZ, cell.centerX, cell.centerZ);
        float influence = cell.peak.getInfluence(dist);  // затухает к краю
        
        // Пик влияет НЕЗАВИСИМО от биома текущего блока!
        totalHeight = max(totalHeight, influence);
    }
    
    // Хребты между соседними пиками
    totalHeight += getRidgeHeight(blockX, blockZ);
    
    return totalHeight;
}
```

### Шаг 4: Shape Functions

```java
// В MountainPeak.getInfluence(dist)
float getInfluence(float dist) {
    if (dist > radius) return 0;
    
    float t = dist / radius;  // 0 в центре, 1 на краю
    
    return switch (shape) {
        case DOME -> height * (1 - t * t);                    // Купол: плавно
        case JAGGED -> height * (1 - t) * (1 + ridgeNoise * 0.3f);  // Рваные края
        case PLATEAU -> height * smoothstep(1 - t, 0.3f, 0.7f);     // Плоская вершина
        case CONE -> height * (1 - t);                        // Линейное затухание
    };
}
```

### Шаг 5: Ridge Connection (хребты)

```java
float getRidgeHeight(int x, int z) {
    VoronoiCell cellA = getNearestCell(x, z);
    if (cellA.peak == null) return 0;
    
    float totalRidge = 0;
    
    for (VoronoiCell cellB : getAdjacentCells(cellA)) {
        if (cellB.peak == null) continue;
        
        // Проверяем шанс хребта (детерминированно по паре ячеек)
        long pairSeed = cellA.id ^ cellB.id;
        if (new Random(pairSeed).nextFloat() > cellA.peak.ridgeChance) continue;
        
        // Расстояние от линии A→B
        float distToLine = pointToLineDistance(x, z, cellA.center, cellB.center);
        float ridgeWidth = 30f;  // ширина хребта в блоках
        
        if (distToLine > ridgeWidth) continue;
        
        // Позиция вдоль хребта (0 = у A, 1 = у B)
        float alongRidge = projectOntoLine(x, z, cellA.center, cellB.center);
        alongRidge = clamp(alongRidge, 0, 1);
        
        // Высота хребта = интерполяция между пиками
        float ridgeHeight = lerp(cellA.peak.height, cellB.peak.height, alongRidge);
        ridgeHeight *= 0.7f;  // хребет ниже пиков
        
        // Затухание от центра хребта
        float falloff = 1 - (distToLine / ridgeWidth);
        falloff = falloff * falloff;  // квадратичное
        
        totalRidge = max(totalRidge, ridgeHeight * falloff);
    }
    
    return totalRidge;
}
```

---

## ИНТЕГРАЦИЯ С HEIGHTMAP

```java
// В BFMEHeightMapV11.getHeight(x, z)
public int getHeight(int x, int z) {
    // 1. Базовая высота из профиля биома (через бикубическую интерполяцию)
    float[] params = getBicubicBlendedParams(x, z);
    float baseHeight = params[P_BASE];
    
    // 2. Voronoi горы (НОВОЕ)
    float mountainHeight = voronoiLayer.getMountainHeight(x, z);
    
    // 3. Шумовые слои (существующие)
    double[] noise = getOrComputeNoise(x, z);
    float noiseContribution = applyNoiseParams(noise, params);
    
    // 4. Комбинируем
    // Горы ДОБАВЛЯЮТСЯ к базе, шум МОДУЛИРУЕТСЯ склоном/высотой
    float height = baseHeight + mountainHeight;
    
    // Шум сильнее на склонах и высоких участках
    float slopeFactor = calculateSlopeFactor(x, z);
    float heightFactor = clamp((height - baseHeight) / 100f, 0, 1);
    height += noiseContribution * (0.3f + 0.7f * slopeFactor * heightFactor);
    
    // 5. Модификаторы (erosion, cliff, terrace)
    height = modifiers.apply(height, x, z, params);
    
    return clamp(height, params[P_MIN], params[P_MAX]);
}
```

---

## ПАРАМЕТРЫ В BiomeTerrainProfile

Добавить новые поля:

```java
// === VORONOI ПАРАМЕТРЫ ===
private final float mountainChance;     // 0.0-1.0, шанс пика в ячейке
private final int peakHeightMin;        // минимальная высота пика над базой
private final int peakHeightMax;        // максимальная высота пика
private final int radiusMin;            // минимальный радиус влияния
private final int radiusMax;            // максимальный радиус
private final float ridgeChance;        // шанс хребта к соседу
private final MountainShape[] shapes;   // допустимые формы (DOME, JAGGED...)
private final float warpStrength;       // сила domain warping (0 = выкл)
```

Примеры значений:

```java
// WHITE_MOUNTAINS (основной)
.mountainChance(0.85f)
.peakHeightMin(120).peakHeightMax(200)
.radiusMin(100).radiusMax(160)
.ridgeChance(0.7f)
.shapes(DOME, JAGGED)
.warpStrength(70f)

// WHITE_MOUNTAINS_PEAKS
.mountainChance(0.95f)
.peakHeightMin(180).peakHeightMax(320)
.radiusMin(80).radiusMax(140)
.ridgeChance(0.8f)
.shapes(JAGGED)
.warpStrength(60f)

// WHITE_MOUNTAINS_FOOTHILLS — НЕТ своих пиков!
.mountainChance(0f)  // получают горы от соседних ячеек через radius
.hillsLargeWeight(1.2f)
.hillsSmallWeight(0.6f)

// Равнины
.mountainChance(0f)
.warpStrength(0f)
```

---

## ПРЕДГОРЬЯ — ВАЖНО!

**Предгорья НЕ генерируют свои пики.** Они получают горы "бесплатно":

```
WHITE_MOUNTAINS_PEAKS        FOOTHILLS           PLAINS
mountainChance=0.95          chance=0            chance=0

         🏔️ ←── пик здесь (radius=150)
        ╱│╲
       ╱ │ ╲
      ╱  │  ╲ ←── влияние САМО распространяется
     ╱   │   ╲
────┴────┴────┴────
    PEAKS  FOOTHILLS

Предгорья = подножия от radius + холмы от hillsWeight
```

---

## КЭШИРОВАНИЕ

```java
// Кэш на уровне ЯЧЕЕК (не блоков!) — огромная экономия
ConcurrentHashMap<Long, VoronoiCell> cellCache;      // ~65536 записей

// Ячейка кэшируется навсегда (детерминированная)
// Очистка только при смене мира
```

---

## ФАЙЛЫ ДЛЯ СОЗДАНИЯ

```
worldgen/terrain/voronoi/
├── VoronoiMountainLayer.java    // главный класс, query + getMountainHeight
├── VoronoiCell.java             // данные ячейки (center, peak)
├── MountainPeak.java            // данные пика (height, radius, shape)
├── MountainShape.java           // enum DOME, JAGGED, PLATEAU, CONE
├── MountainRegion.java          // enum WHITE_MOUNTAINS, EPHEL_DUATH, NONE
└── RidgeConnector.java          // логика хребтов между пиками
```

---

## ПОРЯДОК РЕАЛИЗАЦИИ

1. `MountainRegion.java` + `MountainShape.java` — enums
2. `VoronoiCell.java` + `MountainPeak.java` — data classes
3. `VoronoiMountainLayer.java` — query, getCell, getMountainHeight (БЕЗ хребтов)
4. Тест: горы должны плавно затухать, не обрезаться на границах биомов
5. `RidgeConnector.java` — добавить хребты
6. Интеграция в `BFMEHeightMapV11.java`
7. Параметры в `BiomeTerrainProfile.java`
8. Настройка в `BiomeProfileRegistry.java`

---

## КРИТЕРИИ УСПЕХА

- [ ] Гора, начавшаяся в PEAKS, плавно затухает в FOOTHILLS
- [ ] Между пиками видны хребты
- [ ] Разные формы (DOME vs JAGGED) визуально отличаются
- [ ] Предгорья холмистые, но без случайных пиков посередине
- [ ] Равнины плоские
- [ ] Производительность: кэш ячеек работает, нет повторных вычислений
