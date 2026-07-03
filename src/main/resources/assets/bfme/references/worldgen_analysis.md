# COTR WorldGen — Полный анализ кодовой базы

## Краткое резюме

Архитектура в целом **хорошая и правильная**. Система слоёв (base + voronoi + hills) логична, Builder pattern для профилей удобен, мультимасштабные шумы реализованы грамотно. Основные проблемы — в деталях: баги инициализации, аллокации в hot path, и несколько мест с неправильной логикой.

Ниже всё по категориям.

---

## 1. КРИТИЧЕСКИЕ БАГИ

### 1.1 BiomeProfileRegistry.reset() в VoronoiMountainLayer.initialize()

**Файл:** `VoronoiMountainLayer.java:66-68`

```java
public void initialize(long seed) {
    cellCache.clear();
    heightCache.clear();
    BiomeProfileRegistry.getInstance().reset();  // ← ОПАСНО

    if (initialized && this.worldSeed == seed) return;  // ← early return, но registry уже reset!
```

**Проблема:** При каждом вызове `initialize()` (даже повторном с тем же seed) реестр профилей СБРАСЫВАЕТСЯ. При early return (тот же seed) `gridSizeToWarp` не перестраивается, хотя оно ссылается на данные из уже очищенного реестра.

Работает только потому, что `BiomeProfileRegistry.getProfile()` имеет ленивую инициализацию (`if (!initialized) initialize()`), которая заново создаёт профили. Но это хрупко и делает лишнюю работу.

**Исправление:** Убрать `reset()` из VoronoiMountainLayer. Реестр профилей не должен очищаться при каждой инициализации Voronoi. Если нужна повторная инициализация — пусть HeightMap управляет этим явно:

```java
public void initialize(long seed) {
    cellCache.clear();
    heightCache.clear();
    // НЕ трогаем BiomeProfileRegistry!

    if (initialized && this.worldSeed == seed) return;
    this.worldSeed = seed;

    // Пересобираем gridSizeToWarp из актуальных профилей
    rebuildGridSizeMap();
    this.initialized = true;
}
```

### 1.2 BiomeProfileRegistry.initialize() — не перезагружает профили

**Файл:** `BiomeProfileRegistry.java:38-39`

```java
public void initialize() {
    if (initialized) return;  // ← Никогда не обновляет профили после первой инициализации
```

В `BFMEHeightMapV11.initialize()` вызывается `biomeProfiles.initialize()`, но если реестр уже initialized (и не был reset), профили никогда не перезагрузятся. При hot-reload (разработка с IDE) это означает, что изменения в профилях не применятся.

**Исправление:** В HeightMapV11.initialize, вместо полагания на `initialized` флаг, добавить `forceReload`:

```java
public void initialize() {
    profiles.clear();
    mountainBiomes = Set.of();
    // ... заполнение профилей ...
    initialized = true;
}
```

### 1.3 BFMEBiomeSource — кэш замораживается при заполнении

**Файл:** `BFMEBiomeSource.java:104-107`

```java
if (biomeCache.size() < CACHE_MAX_SIZE) {
    biomeCache.put(cacheKey, result);
}
```

Когда кэш заполняется до 65536 записей, новые записи **никогда не кэшируются**. Игрок уходит далеко от стартовой зоны → все старые записи в кэше бесполезны → каждый запрос = cache miss → деградация производительности.

**Исправление:** Использовать ту же `evictPartial` стратегию что в HeightMap, или заменить на `LossyCache`:

```java
// Вариант 1: evictPartial
evictPartial(biomeCache, CACHE_MAX_SIZE);
biomeCache.put(cacheKey, result);

// Вариант 2: LossyCache (лучше)
private final LossyCache<Holder<Biome>> biomeCache = new LossyCache<>(65536);
```

### 1.4 PIXEL_WEIGHT = 4, а не 16

**Файл:** `BFMEMapConfigs.java:14`

```java
public static final int PIXEL_WEIGHT = 4;
```

Контекстный документ утверждает "каждый пиксель = 16 блоков", но в коде `PIXEL_WEIGHT = 4` → 1 пиксель = 4 блока. Если это намеренное изменение — обновите документацию. Если ошибка — PIXEL_WEIGHT должен быть 16.

При PIXEL_WEIGHT = 4, Gaussian blur radius = 10 пикселей = 40 блоков. При 300+ биомах с картой 1000×1000 пикселей, территория = 4000×4000 блоков, что довольно мало для Средиземья.

---

## 2. БАГИ ЛОГИКИ

### 2.1 Ridge height modulation — перераспределение к billow некорректно

**Файл:** `BFMEHeightMapV11.java:357-362`

```java
for (int s = 0; s < 3; s++) {
    float ridgeW = noiseWeights[3 + s]; // W_RIDGE_L/M/S
    float reduced = ridgeW * (1.0f - ridgeFactor);
    noiseWeights[3 + s] = ridgeW * ridgeFactor;
    noiseWeights[6 + s] += reduced * 0.5f; // redistribute to billow
}
```

**Проблема:** `reduced` вычисляется правильно, но затем `noiseWeights[3 + s]` перезаписывается, и `reduced` уже не используется для чего-то ещё. Однако `reduced * 0.5` означает, что 50% убранного ridge-веса просто теряется (не перераспределяется). Это может быть намеренно (чтобы внизу было тише), но тогда общий вес шума падает в низинах, и `totalWeight` в `getMultiScaleTerrain` нормализует к меньшему значению, что может дать неожиданный эффект усиления.

**Рекомендация:** Если хочется просто уменьшить ridge внизу без замены — лучше перераспределять 100% к simplex (не billow), чтобы не терять энергию:

```java
noiseWeights[0 + s] += reduced; // Весь removed ridge → simplex того же масштаба
```

### 2.2 getMultiScaleTerrain — baseScale применяется как множитель к warped координатам

**Файл:** `WorldNoiseGenerator.java:168-169`

```java
double sx = wx * baseScale;
double sz = wz * baseScale;
```

`baseScale` масштабирует координаты **после** domain warp. Это значит, что при baseScale ≠ 1.0, warp-смещение тоже масштабируется, изменяя его визуальный эффект. При baseScale = 2.0, warp выглядит в 2 раза сильнее.

**Исправление:** Применять baseScale только к координатам шума, а не к warped координатам. Или документировать это как фичу.

### 2.3 FlowErosion вызывает voronoi 50 раз

**Файл:** `FlowErosion.java:57-68`

```java
float voronoiHeight = (voronoi.getHeight(x, z)
        + voronoi.getHeight(x + blur, z) + ...) / 5f;
float peakHeight = voronoi.getPeakHeight(x, z);
float jf = (voronoi.getJunctionFactor(x, z)
        + voronoi.getJunctionFactor(x + blur, z) + ...) / 5f;
```

`getHeight()`, `getPeakHeight()`, `getJunctionFactor()` — все внутри вызывают `getHeightWithOwner()`. Для 5 точек blur × 4 метода = 20 вызовов `getHeightWithOwner`. Кэш спасает для повторных точек, но это всё равно избыточно.

**Исправление:** Вызвать `getHeightWithOwner()` один раз для каждой точки и извлечь все данные:

```java
VoronoiHeightResult vr = voronoi.getHeightWithOwner(x, z);
float voronoiHeight = vr.height();
float peakHeight = vr.peakHeight();
float jf = vr.junctionFactor();
// Для blur — тоже getHeightWithOwner для каждой из 4 дополнительных точек
```

### 2.4 heightProvider в FlowErosion вызывает getBaseHeight рекурсивно

**Файл:** `BFMEHeightMapV11.java:117`

```java
FlowErosion.getInstance().initialize(this::getBaseHeight, worldSeed);
```

**Файл:** `FlowErosion.java:78-81`

```java
float hE = heightProvider.apply(x + step, z);
```

`heightProvider` = `this::getBaseHeight`, а `getBaseHeight` вызывает `calculateHills` → `getBicubicBlendedParams` → `getBlurredParams` → `computeBlurredParams` → `getRawProfile`. Для вычисления градиента вызывается `getBaseHeight` для 4 соседних точек. Каждый из них тоже может быть cache miss.

Это не баг (кэш baseHeightCache спасает), но при включённых hills + erosion вычислительная нагрузка значительна. Градиент эрозии по сути считает полный heightmap для 4 дополнительных точек.

---

## 3. ПРОБЛЕМЫ ПРОИЗВОДИТЕЛЬНОСТИ

### 3.1 getNoiseWeights().clone() в hot path

**Файл:** `BiomeTerrainProfile.java:116`

```java
public float[] getNoiseWeights() { return noiseWeights.clone(); }
```

Вызывается в `computeBlurredParams` для каждого пикселя в Gaussian kernel (~300 пикселей при radius=10). Каждый clone() = 12-элементный float[] массив = аллокация + GC давление.

**Исправление:**

```java
// Добавить unsafe getter для hot path (без clone)
public float[] getNoiseWeightsUnsafe() { return noiseWeights; }
```

Или передавать target массив:

```java
public void getNoiseWeights(float[] target, int offset) {
    System.arraycopy(noiseWeights, 0, target, offset, NOISE_WEIGHT_COUNT);
}
```

### 3.2 ConcurrentHashMap overhead

**Файлы:** Все кэши используют `ConcurrentHashMap`.

Minecraft worldgen — single-threaded per dimension. CAS-операции ConcurrentHashMap добавляют ~2-5x overhead на get/put по сравнению с HashMap. При миллионах обращений к кэшу это существенно.

**Исправление:** Заменить основные кэши на `LossyCache` (уже есть в проекте!) — он O(1), фиксированный размер, не нужна очистка:

```java
// Было:
private final ConcurrentHashMap<Long, Float> baseHeightCache = new ConcurrentHashMap<>();

// Стало:
private final FloatCache baseHeightCache = new FloatCache(262144);
```

`FloatCache` и `LossyCache` уже написаны и лежат в `util/cache/` — но **нигде не используются**! Это готовое решение.

### 3.3 Gaussian blur — O(n²) на каждый пиксель

**Файл:** `BFMEHeightMapV11.java:466-497`

При radius=10, Gaussian kernel содержит ~300 точек. Для каждой вызывается `getRawProfile()` → `biomeSource.getBiomeKey()` → `mapRuntime.getBiome()`. Кэш `blurredParamsCache` помогает, но при первом проходе по новой территории это дорого.

**Рекомендация (на будущее):** Сепарабельный Gaussian blur (два прохода: горизонтальный + вертикальный) сократит O(r²) до O(2r) = в 15 раз быстрее при r=10.

### 3.4 Бикубическая интерполяция — 16 getBlurredParams на блок

**Файл:** `BFMEHeightMapV11.java:413-418`

```java
for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
        allBlurred[i * 4 + j] = getBlurredParams(px0 - 1 + i, pz0 - 1 + j);
    }
}
```

16 вызовов getBlurredParams для каждого блока. Внутри PIXEL_WEIGHT = 4, значит соседние блоки в пределах одного пикселя будут запрашивать те же 16 blurred params. Кэш bicubicParamsCache кэширует результат по блоку, но можно оптимизировать: для 4×4 блоков одного пикселя загрузить blurred params один раз.

### 3.5 new float[12] в calculateHills

**Файл:** `BFMEHeightMapV11.java:342`

```java
float[] noiseWeights = new float[NOISE_WEIGHT_COUNT];
System.arraycopy(params, P_NOISE_WEIGHTS, noiseWeights, 0, NOISE_WEIGHT_COUNT);
```

Аллокация 12-элементного массива для каждого блока. Лучше передавать params напрямую с offset:

```java
// В WorldNoiseGenerator — принимать params[] + offset вместо отдельного weights[]
public double getMultiScaleTerrain(double x, double z, float[] params, int weightsOffset, ...)
```

---

## 4. ПОТЕНЦИАЛЬНЫЕ ПРОБЛЕМЫ С МНОГОПОТОЧНОСТЬЮ

### 4.1 Singleton mutable state

Все ключевые классы — синглтоны с mutable state:

- `BFMEHeightMapV11.instance` — `initialized`, `seed`, `biomeSource`
- `WorldNoiseGenerator.instance` — noise instances
- `VoronoiMountainLayer.instance` — caches, gridSizeToWarp
- `BiomeProfileRegistry.instance` — profiles map

При обращении из нескольких dimension-threads (если добавятся другие измерения), возможны race conditions. Текущий паттерн `synchronized` на `getInstance()` защищает создание, но не доступ к полям.

**Рекомендация:** Пока одно измерение — не проблема. При добавлении измерений — перейти от синглтонов к injection через конструктор ChunkGenerator.

### 4.2 debugCounter — data race

**Файл:** `BFMEHeightMapV11.java:205-206`

```java
debugCounter++;
if (debugCounter % 10000 == 0) {
```

Не atomic, не volatile. При многопоточном доступе — data race. Не критично (только debug), но стоит сделать `AtomicInteger` или убрать.

---

## 5. МЁРТВЫЙ КОД И ДУБЛИРОВАНИЕ

### 5.1 TerrainModifierManager — пуст

**Файл:** `TerrainModifierManager.java`

Менеджер инициализируется в HeightMap, но не содержит ни одного модификатора. Метод `applyAll()` нигде не вызывается. Можно удалить до момента, когда реально понадобятся модификаторы (террасы).

### 5.2 Неиспользуемые кэш-классы

**Файлы:** `FloatCache.java`, `LossyCache.java`, `LongCache.java`, `ThreadLocalCache.java`

Все четыре кэш-класса написаны, но **нигде не используются**. При этом в HeightMap и VoronoiMountainLayer используется ConcurrentHashMap с ручной eviction. Нужно либо перейти на эти кэши, либо удалить мёртвый код.

### 5.3 Неиспользуемые шумы в WorldNoiseGenerator

- `continentNoise`, `mountainMaskNoise`, `valleyNoise` — создаются но не используются в HeightMap pipeline (используются только через getContinent/getMountainMask/getValley, которые нигде не вызываются)
- `detailNoiseHF` — создаётся, `getDetailNoise()` определён, но нигде не вызывается в calculateHills

### 5.4 getHeight(int, int, boolean) — cast float к int и обратно

**Файл:** `BFMEHeightMapV11.java:618-620`

```java
public float getHeight(int x, int z, boolean asFloat) {
    return (float) getHeight(x, z);  // getHeight возвращает int!
}
```

Вызывает int-версию, которая делает `Mth.floor(height)`, потом кастит обратно к float. Теряется дробная часть. Если нужна float высота — надо вызывать getBaseHeight напрямую.

### 5.5 MountainGroup уже удалён

Контекстный документ упоминает "удалить MountainGroup.java", но файл уже отсутствует в архиве. Задача выполнена ✓

### 5.6 evictPartial дублируется

**Файлы:** `BFMEHeightMapV11.java:671-681`, `VoronoiMountainLayer.java:371-381`

Идентичная реализация evictPartial в двух файлах. Вынести в утилитный класс или использовать LossyCache.

---

## 6. ГОТОВНОСТЬ К МАСШТАБИРОВАНИЮ (300+ биомов)

### 6.1 BiomeProfileRegistry — HashMap по ResourceKey

Текущий `HashMap<ResourceKey<Biome>, BiomeTerrainProfile>` — O(1) lookup, масштабируется нормально. Но **все профили захардкожены** в `initialize()`. При 300+ биомах это будет 300+ вызовов `profiles.put(...)` в одном методе — нечитабельно.

**Рекомендация:** Вынести профили в отдельные классы по регионам (GondorProfiles, MordorProfiles, ShireProfiles), каждый регистрирующий свои биомы.

### 6.2 Gaussian blur — линейно зависит от числа уникальных профилей в окрестности

При 300+ биомах, blur radius 10 будет чаще натыкаться на разные биомы. Производительность blur не меняется (зависит от radius, не от числа биомов), но **качество** может ухудшиться — при 5+ биомах в радиусе интерполяция может давать бессмысленные промежуточные значения.

**Рекомендация:** Планируемые "Transition profiles" решат эту проблему. Приоритизировать их при 50+ биомах.

### 6.3 VoronoiMountainLayer — gridSizeToWarp растёт с числом горных биомов

Каждый уникальный `gridSize` добавляет 9 ячеек в проверку. При 10 горных биомах с уникальными gridSize — 90 ячеек на точку (MAX_CELLS = 36 не хватит!).

**Проблема:** `MAX_CELLS = 36` достаточно для ~4 уникальных gridSize. При 300+ биомах может быть 10+ разных gridSize.

**Исправление:** Группировать горные биомы по gridSize (уже делается в `gridSizeToWarp`), но убедиться что при масштабировании хватает MAX_CELLS, или проверять только gridSize из биомов в окрестности текущей точки, а не все глобально.

### 6.4 BFMEBiomeKeys — ручное добавление

При 300+ биомах, ручное объявление ResourceKey для каждого биома — источник ошибок. Рассмотреть автогенерацию из конфига.

---

## 7. КОНКРЕТНЫЙ ПЛАН РЕАЛИЗАЦИИ

Приоритеты: сначала заставить холмы работать правильно, потом оптимизация.

### Шаг 1: Исправить инициализацию (30 мин)

1. Убрать `BiomeProfileRegistry.getInstance().reset()` из `VoronoiMountainLayer.initialize()`
2. Заменить `if (initialized) return` в BiomeProfileRegistry на полную пере-инициализацию (clear + refill)
3. В HeightMapV11.initialize — всегда вызывать biomeProfiles.initialize() (не полагаться на ленивую инициализацию)

### Шаг 2: Перейти на LossyCache / FloatCache (1 час)

Заменить ConcurrentHashMap кэши:
- `heightCache` → `FloatCache(262144)` (не нужен — int хранится как float)
- `baseHeightCache` → `FloatCache(262144)`
- `blurredParamsCache` → `LossyCache<float[]>(262144)`
- `bicubicParamsCache` → `LossyCache<float[]>(262144)`
- `VoronoiMountainLayer.heightCache` → `LossyCache<VoronoiHeightResult>(262144)`
- `VoronoiMountainLayer.cellCache` → `LossyCache<VoronoiCell>(65536)`
- `BFMEBiomeSource.biomeCache` → `LossyCache<Holder<Biome>>(65536)`

### Шаг 3: Убрать аллокации в hot path (30 мин)

1. `getNoiseWeights()` → добавить `getNoiseWeightsUnsafe()` (без clone)
2. `calculateHills` — убрать `new float[12]`, передавать params + offset напрямую
3. `getBicubicErosionParams` — возвращает `new float[2]`, можно заменить на два отдельных вызова

### Шаг 4: Включить DISABLE_HILLS = false и проверить (текущее состояние)

DISABLE_HILLS уже = false в текущем коде. Система холмов по коду выглядит корректно. Основные моменты для тестирования:

- **relief scale** — проверить что V12_PLAINS с reliefScale=0.25 даёт адекватные 2-5 блоков разницы
- **ridge height modulation** — ridge должен появляться только выше 140 блоков (горы), в равнинах = 0
- **valley modulation** — рельеф в долинах (ниже 75) должен быть 30% от нормы
- **domain warp** — проверить что warpStrength не создаёт артефактов

### Шаг 5: Тестовые профили и отладка (итеративно)

1. Установить `DISABLE_EROSION = true` (уже так)
2. Запустить с текущими профилями
3. Визуально проверить:
   - Pelennor Plains — почти плоские (reliefScale 0.15)
   - Ithilien — мягкие холмы (0.7)
   - White Mountains — видимые горы + ridge на высоте
   - Ephel Duath — мрачные пики с cellular текстурой
4. Подстроить параметры по результату

---

## 8. АРХИТЕКТУРНЫЕ РЕКОМЕНДАЦИИ (НЕ СРОЧНО)

### 8.1 Вынести константы модуляции

RIDGE_HEIGHT_MIN/MAX, VALLEY_HEIGHT_MIN/MAX, VORONOI_DETAIL_MIN/MAX — хардкожены в HeightMap. Для 300+ биомов могут понадобиться per-biome значения. Добавить в BiomeTerrainProfile:

```java
.ridgeHeightRange(140f, 200f)  // Ridge начинается с высоты 140
.valleyHeightRange(75f, 110f)  // Valley modulation range
```

### 8.2 Domain warp координаты

В `getMultiScaleTerrain`, warp применяется один раз для всех масштабов. В TerraForged warp применяется отдельно для каждого масштаба (с разной силой). Это даёт более реалистичные формы, но увеличивает число noise вызовов.

### 8.3 Сепарабельный Gaussian blur

Текущий 2D Gaussian blur — O(r²) на пиксель. Сепарабельная версия (горизонтальный + вертикальный проход) — O(2r). При r=10: 300 → 40 операций. Требует буфера для промежуточных результатов, но при 300+ биомах экономия значительна.

### 8.4 Chunk-level caching

Сейчас кэширование по-блочное. Для чанка 16×16 = 256 блоков, каждый независимо обращается к кэшам. Можно предвычислять blurredParams для всего чанка за один проход (один пиксель карты = 4×4 блока при PIXEL_WEIGHT=4).
