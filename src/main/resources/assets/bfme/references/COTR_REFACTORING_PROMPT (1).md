# COTR WorldGen — Рефакторинг генерации рельефа

## Контекст проекта

Мод "Chronicles of the Realms" для NeoForge 1.21.1. Воссоздание Средиземья. Биомы читаются с PNG карты, каждый пиксель = 16 блоков (PIXEL_WEIGHT). Система генерации полностью своя, не ванильная.

Пакет: `net.sima.bfme`

## Текущая архитектура (как работает сейчас)

Пайплайн высоты:
```
BFMEChunkGenerator.getHeight(x, z)
  → BFMEHeightMapV11.getHeight(x, z)
    → getBaseHeight(x, z)
      → BASE_LEVEL = 70 (константа!)
      → + VoronoiMountainLayer.getHeight(x, z)
      → + calculateHills(x, z)  // ОТКЛЮЧЕНО флагом DISABLE_HILLS = true
    → FlowErosion  // ОТКЛЮЧЕНО флагом DISABLE_EROSION = true
```

Параметры биомов интерполируются двухступенчато:
1. Gaussian blur на уровне пикселей карты (radius=10)
2. Бикубическая (Catmull-Rom) интерполяция на уровне блоков

Результат — массив float[17] `blurredParams` с весами шумов, baseHeight, reliefScale и т.д.

## Файлы для изменения

Все файлы находятся в проекте мода. Основные:

### Ядро генерации:
- `worldgen/chunkgen/BFMEChunkGenerator.java` — главный ChunkGenerator
- `worldgen/chunkgen/map/BFMEHeightMapV11.java` — расчёт высоты (ГЛАВНЫЙ ФАЙЛ)
- `worldgen/noise/WorldNoiseGenerator.java` — синглтон с шумами
- `worldgen/noise/OctaveNoise.java` — октавный шум (OpenSimplex2S)

### Профили и Voronoi:
- `worldgen/terrain/BiomeTerrainProfile.java` — профиль рельефа биома (Builder)
- `worldgen/terrain/BiomeProfileRegistry.java` — реестр всех профилей
- `worldgen/terrain/voronoi/VoronoiMountainLayer.java` — Voronoi горы
- `worldgen/terrain/voronoi/VoronoiCell.java` — данные ячейки
- `worldgen/terrain/voronoi/MountainGroup.java` — УДАЛИТЬ (см. ниже)
- `worldgen/terrain/voronoi/MountainShape.java` — формы гор (не трогать)
- `worldgen/terrain/voronoi/ErosionConfig.java` — конфиг эрозии (не трогать)
- `worldgen/terrain/voronoi/RidgeConnectionConfig.java` — конфиг хребтов (не трогать)

---

## ЗАДАЧИ — выполнять строго по порядку

---

### ЗАДАЧА 1: Удалить legacy V11 систему

**Проблема:** BiomeTerrainProfile содержит одновременно V11 поля (hillsLargeWeight, hillsSmallWeight, detailWeight) и V12 поля (simplexWeight, ridgeWeight, billowWeight, cellularWeight). Все биомы в BiomeProfileRegistry используют V12 через `blendWeights(...)`. V11 — мёртвый код, создающий путаницу.

**В BiomeTerrainProfile.java:**
- Удалить поля: `hillsLargeWeight`, `hillsSmallWeight`, `detailWeight`
- Удалить соответствующие геттеры
- Удалить все `@Deprecated` legacy stubs (getContinentWeight, getValleyWeight, getPeaksWeight, getRidgeWeight, getErosionWeight, getMinHeight, getMaxHeight)
- Удалить метод `usesBlendSystem()` — теперь всегда V12
- Удалить пресет `PLAINS_FLAT` (V11)
- В Builder: удалить hillsLargeWeight, hillsSmallWeight, detailWeight и их сеттеры

**В BFMEHeightMapV11.java:**
- В `blurredParams`: удалить индексы P_HILLS_LARGE, P_HILLS_SMALL, P_DETAIL. Сдвинуть оставшиеся индексы. Уменьшить BLURRED_PARAMS_COUNT
- В `computeBlurredParams`: убрать строки с `p.getHillsLargeWeight()`, `p.getHillsSmallWeight()`, `p.getDetailWeight()`
- В `calculateHills`: удалить ветку `else` (legacy V11 system, строки ~413-431). Оставить только V12 blend path
- Удалить `getOrComputeNoise` и связанный `noiseCache` — это legacy V11
- Удалить `getBicubicHillWeights` — не используется в V12
- Удалить константы N_DETAIL, N_SMALL, N_LARGE, NOISE_COUNT

**В WorldNoiseGenerator.java:**
- Удалить legacy поля: `hillsLargeNoise`, `hillsSmallNoise`, `detailNoise`
- Удалить legacy геттеры: `getHillsLarge`, `getHillsMedium`, `getHillsSmall`, `getDetail`, `getPeaks`, `getSharpPeaks`, `getErosion`, `getSlopeVariation`
- Удалить stubs которые просто возвращают другой шум
- Оставить: `getSimplex`, `getRidge`, `getBillow`, `getCellular`, `getDetailHF`, `getBlendedTerrain`, warp геттеры, пещерные шумы, 3D cliff шумы

---

### ЗАДАЧА 2: Исправить baseHeight — использовать профиль вместо константы 70

**Проблема:** `getBaseHeight()` использует `float height = BASE_LEVEL` (70) для всего мира. Профильный baseHeight (70, 80, 85, 90) участвует только в blur параметров, но не в реальной высоте земли. Предгорья (base=85) и равнины (base=70) на одном уровне без Voronoi.

**Проблема стенки:** Если просто подставить профильный baseHeight, то Voronoi гора из горного биома (base=90), заходящая на равнину (base=70), создаст уступ 20 блоков у подножия.

**Решение — blend baseHeight по влиянию Voronoi.**

В `BFMEHeightMapV11.getBaseHeight(int x, int z)` заменить:

```java
// БЫЛО:
float height = BASE_LEVEL;
float voronoiHeight = voronoiLayer.getHeight(x, z);
height += voronoiHeight;

// СТАЛО:
float[] params = getBicubicBlendedParams(x, z);
float localBase = params[P_BASE];

VoronoiHeightResult vr = voronoiLayer.getHeightWithOwner(x, z);
float voronoiHeight = vr.height();

float height = localBase;

// Где Voronoi гора заходит на чужой биом — плавно поднимаем base
if (voronoiHeight > 0 && vr.terrainOwner() != null) {
    float ownerBase = biomeProfiles.getProfile(vr.terrainOwner()).getBaseHeight();
    // Чем сильнее Voronoi — тем больше base тянется к горному
    float influence = smoothstepRange(voronoiHeight, 5f, 60f);
    height = lerp(localBase, ownerBase, influence);
}

height += voronoiHeight;
```

**Важно:** Voronoi теперь вызывается один раз здесь. Передать VoronoiHeightResult в calculateHills, чтобы не вызывать дважды. Рефакторить calculateHills чтобы принимал VoronoiHeightResult параметром.

Также: удалить константу `BASE_LEVEL = 70` — она больше не нужна.

---

### ЗАДАЧА 3: Добавить параметры шума в BiomeTerrainProfile

**Проблема:** Все биомы используют одинаковые шумы (одна persistence=0.5, одна lacunarity=2.0). Различия только через веса. Шир и Мордор звучат одинаково, просто с разной громкостью. Для 300+ биомов это неприемлемо.

**В OctaveNoise.java — добавить перегрузку:**

```java
/**
 * 2D шум с кастомными параметрами октав.
 * Seed'ы остаются те же, меняется только суммирование.
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
```

Аналогично добавить для `sampleRidged2D`, `sampleBillow2D`, `sampleCellular2D`.

**В BiomeTerrainProfile.java — добавить поля:**

```java
private final float noiseLacunarity;   // default 2.0
private final float noisePersistence;  // default 0.5
private final float noiseBaseScale;    // множитель к scale шумов, default 1.0
```

С геттерами и Builder-сеттерами. Дефолты: lacunarity=2.0, persistence=0.5, noiseBaseScale=1.0.

**В blurredParams — добавить индексы:**

```java
private static final int P_NOISE_LACUNARITY = ...; // новый индекс
private static final int P_NOISE_PERSISTENCE = ...; // новый индекс  
private static final int P_NOISE_BASE_SCALE = ...; // новый индекс
```

Увеличить `BLURRED_PARAMS_COUNT`. Добавить в `computeBlurredParams`.

**В WorldNoiseGenerator.getBlendedTerrain — добавить параметры:**

Изменить сигнатуру:
```java
public double getBlendedTerrain(double x, double z,
                                float simplexW, float ridgeW, float billowW, float cellularW,
                                float warpStrength,
                                float lacunarity, float persistence, float baseScale)
```

Внутри: передавать lacunarity и persistence в перегруженные sample методы. baseScale умножать на координаты.

**В calculateHills — передавать новые параметры из blurredParams в getBlendedTerrain.**

**Примеры использования в BiomeProfileRegistry:**

```java
// Мордор — хаотичный, рваный рельеф
.noiseLacunarity(2.8f)
.noisePersistence(0.6f)

// Шир — плавный, мягкий
.noiseLacunarity(1.8f)
.noisePersistence(0.4f)

// Белые горы — стандартный, но крупнее
.noiseBaseScale(1.2f)
```

---

### ЗАДАЧА 4: Удалить MountainGroup, перевести Voronoi на единый цикл

**Проблема:** MountainGroup.java дублирует информацию, которая уже есть в BiomeTerrainProfile (gridSize, warpStrength). VoronoiMountainLayer.MOUNTAIN_BIOMES — захардкоженный список из 6 биомов, дублирующий MountainGroup.

Кроме того, `getHeightWithOwner` итерирует по каждому горному биому отдельно, делая полный Voronoi lookup (9 ячеек) для каждого. 6 биомов × 9 ячеек = 54 lookup'а. При добавлении Мглистых гор, Железных холмов и т.д. будет 15+ биомов × 9 = 135+ lookup'ов на точку.

**Решение:** Один Voronoi pass для всех горных биомов.

**Удалить MountainGroup.java целиком.**

**В BiomeTerrainProfile — добавить флаг:**

```java
private final boolean isMountainBiome; // default false
```

Биом считается горным если `mountainChance > 0 && voronoiGridSize > 0`. Геттер:
```java
public boolean isMountainBiome() { return mountainChance > 0 && voronoiGridSize > 0; }
```

**В BiomeProfileRegistry — добавить метод:**

```java
/** Возвращает все ResourceKey биомов, у которых isMountainBiome() == true */
public Set<ResourceKey<Biome>> getMountainBiomes() { ... }
```

Кешировать результат при initialize().

**В VoronoiMountainLayer — переписать getHeightWithOwner:**

Вместо итерации по MOUNTAIN_BIOMES и вызова `getHeightForBiome` для каждого:

1. Определить пиксель карты для (worldX, worldZ)
2. Собрать все горные биомы в радиусе ~3 пикселей (чтобы захватить горы из соседних биомов). Это маленькое множество, обычно 1-3 биома
3. Для каждого найденного горного биома — один Voronoi lookup (9 ячеек)
4. smoothMax всех результатов

Или проще: единая сетка. Один gridSize для всего мира (например, взять максимальный из всех профилей). Ячейка создаётся, определяется биом в её центре, параметры горы берутся из профиля этого биома. Это даёт один Voronoi pass вместо N.

**Рекомендованный подход — единая сетка:**

```java
private static final int GLOBAL_GRID_SIZE = 200; // или параметр

public VoronoiHeightResult getHeightWithOwner(int worldX, int worldZ) {
    // Domain warping
    // ...
    
    // Одна сетка, 9 ячеек
    int gridX = Math.floorDiv(wx, GLOBAL_GRID_SIZE);
    int gridZ = Math.floorDiv(wz, GLOBAL_GRID_SIZE);
    
    VoronoiCell[] cells = new VoronoiCell[9];
    for (int dx = -1; dx <= 1; dx++) {
        for (int dz = -1; dz <= 1; dz++) {
            cells[idx++] = getOrCreateCell(GLOBAL_GRID_SIZE, gridX + dx, gridZ + dz);
        }
    }
    
    // smoothMax всех гор из всех ячеек
    // ...
}
```

В `createCell` — определить биом в центре ячейки, если это горный биом → создать гору с параметрами из его профиля. Если нет → пустая ячейка.

**ВАЖНО:** Если у разных горных биомов разный gridSize в профиле (сейчас 150 и 200-250), нужно решить: либо единый gridSize (проще), либо группировать по gridSize (сложнее, но гибче). Рекомендую единый gridSize=200 для начала, потом можно оптимизировать. Значение gridSize из профиля всё ещё полезно — можно его использовать как mountainChance модификатор (крупная сетка → реже горы).

Убрать `MOUNTAIN_BIOMES` список. Убрать импорт MountainGroup везде.

---

### ЗАДАЧА 5: Исправить кеши — LRU вместо полной очистки

**Проблема:** Во всех кешах (VoronoiMountainLayer, BFMEHeightMapV11) паттерн:
```java
if (cache.size() >= MAX) cache.clear();
```
Это вызывает периодические фризы — весь кеш сбрасывается и пересчитывается.

**Решение: при переполнении удалять ~25% случайных записей вместо полной очистки.**

Создать утилитный метод:

```java
private static <K, V> void evictPartial(ConcurrentHashMap<K, V> cache, int maxSize) {
    if (cache.size() < maxSize) return;
    // Удаляем ~25% записей
    int toRemove = maxSize / 4;
    var iterator = cache.keySet().iterator();
    int removed = 0;
    while (iterator.hasNext() && removed < toRemove) {
        iterator.next();
        iterator.remove();
        removed++;
    }
}
```

Заменить все `if (cache.size() >= MAX) cache.clear()` на `evictPartial(cache, MAX)`.

Применить во всех кешах: heightCache, baseHeightCache, blurredParamsCache, bicubicParamsCache, noiseCache в BFMEHeightMapV11 и cellCache, heightCache в VoronoiMountainLayer.

---

### ЗАДАЧА 6: Включить холмы и подготовить к тестированию

**В BFMEHeightMapV11.java:**
- Изменить `DISABLE_HILLS = false`
- `DISABLE_EROSION` оставить `true` (эрозия позже)

**Убедиться что calculateHills работает с новой системой:**
- Принимает VoronoiHeightResult как параметр (из задачи 2)
- Использует новые параметры шума lacunarity/persistence (из задачи 3)
- Не содержит V11 legacy путь (из задачи 1)

---

## Порядок выполнения и тестирование

1. **Задача 1** (удалить legacy) → компилируется без ошибок
2. **Задача 5** (кеши) → компилируется
3. **Задача 4** (Voronoi единая сетка) → компилируется
4. **Задача 2** (baseHeight из профиля) → компилируется
5. **Задача 3** (параметры шума) → компилируется
6. **Задача 6** (включить холмы) → компилируется, готово к тестированию в игре

Каждую задачу — отдельным коммитом. После каждой задачи проверять что проект компилируется.

---

## Что НЕ трогать

- `OpenSimplex2.java`, `OpenSimplex2S.java` — шумовые примитивы, работают
- `MountainShape.java` — формы гор, работают
- `ErosionConfig.java` — конфиг эрозии, работает
- `RidgeConnectionConfig.java` — конфиг хребтов, работает
- `VoronoiCell.java` — данные ячейки, работают (может потребоваться мелкая правка конструктора при задаче 4)
- `FlowErosion.java`, `TerrainModifierManager.java` — отключены, рефакторить позже
- `BFMEBiomeSource.java`, `BFMEBiomesData.java` — data классы, не трогать
- Surface rules и SlopeMap — не связаны с рефакторингом

## Стиль кода

- Java 17+, NeoForge 1.21.1
- Singltons через `getInstance()` (уже установленный паттерн)
- Builder pattern для конфигов
- ConcurrentHashMap для кешей (многопоточная генерация чанков)
- Комментарии на русском допустимы
- Без Lombok, без Spring, чистая Java
