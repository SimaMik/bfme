# COTR WorldGen — Промпты для Claude Code (по одному)

Выполнять строго по порядку. После каждого — компиляция и проверка.

---

## Промпт 1: ALPINE в createShapeParams (критический баг)

```
В VoronoiMountainLayer.java метод createShapeParams() — switch по MountainShape не обрабатывает ALPINE. При этом WHITE_MOUNTAINS, WHITE_MOUNTAINS_PEAKS и WHITE_MOUNTAINS_HIGH_PEAKS используют MountainShape.ALPINE в своих профилях (BiomeProfileRegistry). Без обработки ALPINE — params.exponent остаётся дефолтным 2.0f без рандомизации, все ALPINE горы идентичны.

Добавь case ALPINE в switch. Exponent должен быть между SOFT_PEAK (1.4-1.9) и DOME (1.8-2.5) — примерно 1.5 + rand.nextFloat() * 0.7f (диапазон 1.5-2.2). ALPINE — это "округлый у основания, острее к вершине", промежуточная форма.

Скомпилируй и проверь.
```

---

## Промпт 2: Убрать reset() из VoronoiMountainLayer.initialize()

```
В VoronoiMountainLayer.java метод initialize(long seed) первой строкой (после clear кэшей) вызывает BiomeProfileRegistry.getInstance().reset(). Это сбрасывает ВСЕ профили биомов. Проблема: reset() вызывается ДО early return (if initialized && same seed), то есть при каждом вызове initialize — даже повторном.

Работает только потому, что BiomeProfileRegistry.getProfile() делает ленивую инициализацию. Но это хрупко и делает лишнюю работу.

Убери строку BiomeProfileRegistry.getInstance().reset() из VoronoiMountainLayer.initialize(). Реестр профилей не должен очищаться при инициализации Voronoi слоя — это ответственность HeightMap.

Скомпилируй и проверь что ничего не сломалось.
```

---

## Промпт 3: BiomeProfileRegistry — всегда перезагружать профили

```
В BiomeProfileRegistry.java метод initialize() начинается с "if (initialized) return". Это означает, что после первой инициализации профили НИКОГДА не перезагружаются. При hot-reload (разработка с IDE) изменения в профилях не применяются.

Замени "if (initialized) return" на "profiles.clear(); mountainBiomes = Set.of();" — чтобы initialize() всегда перезагружал профили с нуля. В конце метода initialized = true всё равно ставится.

Скомпилируй и проверь.
```

---

## Промпт 4: Ridge redistribution — сохранять totalWeight

```
В BFMEHeightMapV11.java метод calculateHills, секция "ВЫСОТНАЯ МОДУЛЯЦИЯ RIDGE" (строки с ridgeFactor):

Текущий код: убранный ridge вес → 50% к billow, 50% теряется.
Проблема: getMultiScaleTerrain нормализует (total / totalWeight). При потере веса totalWeight уменьшается → оставшиеся каналы УСИЛИВАЮТСЯ. На равнинах шум громче чем задумано.

Замени:
  noiseWeights[6 + s] += reduced * 0.5f; // redistribute to billow
На:
  noiseWeights[0 + s] += reduced; // redistribute to simplex (same scale)

Это перераспределяет 100% убранного ridge к simplex того же масштаба. totalWeight остаётся стабильным.

Скомпилируй и проверь.
```

---

## Промпт 5: BFMEBiomeSource — кэш с eviction вместо заморозки

```
В BFMEBiomeSource.java метод getNoiseBiome — кэш замораживается при заполнении:
  if (biomeCache.size() < CACHE_MAX_SIZE) { biomeCache.put(cacheKey, result); }

Когда кэш заполняется (65536 записей), новые записи НИКОГДА не кэшируются. Игрок уходит от стартовой зоны → все старые записи бесполезны → 100% cache miss.

Замени на evictPartial: при переполнении удалять 25% записей, потом put. Точно так же как уже сделано в BFMEHeightMapV11.evictPartial().

Скомпилируй и проверь.
```

---

## Промпт 6: getNoiseWeightsRef() — убрать clone в hot path

```
В BiomeTerrainProfile.java метод getNoiseWeights() делает .clone() на каждый вызов. Это вызывается в computeBlurredParams (BFMEHeightMapV11) для каждого пикселя в Gaussian kernel (~300 раз). 300 аллокаций float[12] на пиксель.

Добавь метод getNoiseWeightsRef() который возвращает массив БЕЗ clone (с javadoc "НЕ модифицировать возвращённый массив"). Оставь getNoiseWeights() с clone для безопасного использования.

Затем в BFMEHeightMapV11.java замени вызовы getNoiseWeights() на getNoiseWeightsRef() в двух местах:
1. computeBlurredParams — "float[] nw = p.getNoiseWeights()"
2. blendWithOwnerProfile — "float[] ownerWeights = ownerProfile.getNoiseWeights()"

Оба места только ЧИТАЮТ массив, не модифицируют — clone не нужен.

Скомпилируй и проверь.
```

---

## Промпт 7: Мёртвый код — удалить

```
Удали мёртвый код:

1. BFMEChunkGenerator.java — поле DISABLE_EROSION (строка ~68). Объявлено, но нигде не используется. Реальный DISABLE_EROSION — в BFMEHeightMapV11.

2. BFMEHeightMapV11.java — метод getHeight(int x, int z, boolean asFloat). Нигде не вызывается. К тому же он теряет дробную часть (вызывает int-версию getHeight, потом кастит к float).

Скомпилируй и проверь что нет обращений к удалённому коду.
```

---

## Промпт 8: Диагностика кэшей (ПЕРЕД заменой)

```
У нас есть готовые LossyCache и FloatCache в util/cache/, но они нигде не используются. При этом все кэши на ConcurrentHashMap с ручной eviction. Раньше при попытке использовать LossyCache/FloatCache мир зависал.

Прежде чем менять кэши — нужно понять почему зависало. Проанализируй:

1. LossyCache и FloatCache используют hash(key) & mask для индекса. При плохом хеше множество ключей попадут в один слот → постоянные cache miss → рехеш каждый раз. Проверь: hash функция в LossyCache/FloatCache хорошо распределяет packCoords(x, z)?

2. LossyCache.computeIfAbsent принимает LongFunction<T> — это boxing Long. В tight loop это может быть дороже чем ConcurrentHashMap.

3. Размер кэша — если слишком маленький, hit rate падает и каждый запрос = вычисление + запись. При 262144 слотах и мире с radius 1000 чанков — хватает ли?

4. Нет ли ситуации где один кэш вызывает другой кэш при miss — каскадные промахи при малом размере.

Покажи результаты анализа, НЕ меняй ничего пока.
```

---

## Примечания

- Промпты 1-7 — безопасные изменения, можно делать подряд
- Промпт 8 — диагностика ПЕРЕД любыми изменениями кэшей
- После промптов 1-7 запустить мир и визуально проверить рельеф
- Тюнинг профилей биомов — отдельная итерация после подтверждения что всё работает
