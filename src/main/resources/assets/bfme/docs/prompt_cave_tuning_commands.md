# Задача: Тюнинг cheese caves через команды в игре

## Контекст
Уже есть команда `/bfme reload` которая перезагружает чанки.
Уже есть debug настройка параметров BiomeTerrainProfile через команды.
Нужно аналогичное для cave offsets — менять значения и видеть результат без перезапуска.

## Что сделать

### 1. WorldNoiseGenerator.java — статические переменные для тюнинга

Добавить в начало класса (рядом с другими константами):

```java
// === CAVE TUNING (debug, меняются командой) ===
public static float CAVE_OFFSET_SUPER_LARGE = 0.36f;
public static float CAVE_OFFSET_LARGE = 0.33f;
public static float CAVE_OFFSET_MEDIUM = 0.28f;
public static float CAVE_OFFSET_SMALL = 0.32f;
public static float CAVE_SPAGHETTI_THRESHOLD = 0.055f;
public static float CAVE_SPAGHETTI_RARENESS = 0.0f;

// Depth fade от поверхности (per-scale)
public static float CAVE_FADE_SUPER_LARGE_DEPTH = 80f;
public static float CAVE_FADE_SUPER_LARGE_STRENGTH = 0.25f;
public static float CAVE_FADE_LARGE_DEPTH = 40f;
public static float CAVE_FADE_LARGE_STRENGTH = 0.2f;
public static float CAVE_FADE_MEDSMALL_DEPTH = 15f;
public static float CAVE_FADE_MEDSMALL_STRENGTH = 0.15f;
```

### 2. WorldNoiseGenerator.java — computeCaveDensity использует переменные

Заменить метод computeCaveDensity на:

```java
public float computeCaveDensity(int x, int y, int z, int surfaceHeight) {
    double cheeseSuperLarge = sampleCheeseNoise(x / 3.0, y / 2.0, z / 3.0);
    double cheeseLarge = sampleCheeseNoise(x / 2.0, (double) y, z / 2.0);
    double cheeseMedium = sampleCheeseNoise((double) x, (double) y, (double) z);
    double cheeseSmall = sampleCheeseNoise(x * 1.5, y * 1.5, z * 1.5);

    int depth = surfaceHeight - y;
    float surfaceProtection = 0f;
    if (surfaceHeight < 90 && depth < 15) {
        surfaceProtection = 0.5f * (1f - depth / 15f);
    }

    // === Per-scale depth fade от поверхности ===
    float superLargeDepthFade = 0f;
    if (depth < CAVE_FADE_SUPER_LARGE_DEPTH) {
        superLargeDepthFade = CAVE_FADE_SUPER_LARGE_STRENGTH * (1f - depth / CAVE_FADE_SUPER_LARGE_DEPTH);
    }

    float largeDepthFade = 0f;
    if (depth < CAVE_FADE_LARGE_DEPTH) {
        largeDepthFade = CAVE_FADE_LARGE_STRENGTH * (1f - depth / CAVE_FADE_LARGE_DEPTH);
    }

    float medSmallDepthFade = 0f;
    if (depth < CAVE_FADE_MEDSMALL_DEPTH) {
        medSmallDepthFade = CAVE_FADE_MEDSMALL_STRENGTH * (1f - depth / CAVE_FADE_MEDSMALL_DEPTH);
    }

    // === Density per scale ===
    float superLargeDensity = (float) cheeseSuperLarge + CAVE_OFFSET_SUPER_LARGE + superLargeDepthFade;
    float largeDensity = (float) cheeseLarge + CAVE_OFFSET_LARGE + largeDepthFade;
    float mediumDensity = (float) cheeseMedium + CAVE_OFFSET_MEDIUM + medSmallDepthFade;
    float smallDensity = (float) cheeseSmall + CAVE_OFFSET_SMALL + medSmallDepthFade;

    // === Min всех четырёх ===
    float finalDensity = Math.min(
            Math.min(superLargeDensity, largeDensity),
            Math.min(mediumDensity, smallDensity)
    ) + surfaceProtection;

    // === Bottom fade — от дна мира ===
    if (y < CAVE_MIN_Y + 25) {
        float bottomFade = 0.3f * (1f - (float) (y - CAVE_MIN_Y) / 25f);
        finalDensity += bottomFade;
    }

    return finalDensity;
}
```

### 3. WorldNoiseGenerator.java — computeSpaghettiModifier использует переменные

В методе computeSpaghettiModifier заменить хардкод на переменные:

Найти:
```java
if (rareness > 0.0) return 1.0f;
```
Заменить на:
```java
if (rareness > CAVE_SPAGHETTI_RARENESS) return 1.0f;
```

Найти:
```java
float threshold = 0.055f + (float) Math.max(0, rareness * 0.15);
```
Заменить на:
```java
float threshold = CAVE_SPAGHETTI_THRESHOLD + (float) Math.max(0, rareness * 0.15);
```

### 4. Команда для тюнинга — добавить в существующий command handler

Найти файл где обрабатываются `/bfme` команды (вероятно BFMECommand.java или ProfileCommand.java или аналог).

Добавить subcommand `cave`:

```java
// /bfme cave <parameter> <value>
// Примеры:
// /bfme cave superLargeOffset 0.36
// /bfme cave largeOffset 0.33
// /bfme cave mediumOffset 0.28
// /bfme cave smallOffset 0.32
// /bfme cave spaghettiThreshold 0.055
// /bfme cave spaghettiRareness 0.0
// /bfme cave superLargeFadeDepth 80
// /bfme cave superLargeFadeStrength 0.25

private static int handleCaveCommand(CommandContext<CommandSourceStack> context) {
    String param = StringArgumentType.getString(context, "parameter");
    float value = FloatArgumentType.getFloat(context, "value");
    
    switch (param) {
        case "superLargeOffset" -> WorldNoiseGenerator.CAVE_OFFSET_SUPER_LARGE = value;
        case "largeOffset" -> WorldNoiseGenerator.CAVE_OFFSET_LARGE = value;
        case "mediumOffset" -> WorldNoiseGenerator.CAVE_OFFSET_MEDIUM = value;
        case "smallOffset" -> WorldNoiseGenerator.CAVE_OFFSET_SMALL = value;
        case "spaghettiThreshold" -> WorldNoiseGenerator.CAVE_SPAGHETTI_THRESHOLD = value;
        case "spaghettiRareness" -> WorldNoiseGenerator.CAVE_SPAGHETTI_RARENESS = value;
        case "superLargeFadeDepth" -> WorldNoiseGenerator.CAVE_FADE_SUPER_LARGE_DEPTH = value;
        case "superLargeFadeStrength" -> WorldNoiseGenerator.CAVE_FADE_SUPER_LARGE_STRENGTH = value;
        case "largeFadeDepth" -> WorldNoiseGenerator.CAVE_FADE_LARGE_DEPTH = value;
        case "largeFadeStrength" -> WorldNoiseGenerator.CAVE_FADE_LARGE_STRENGTH = value;
        case "medSmallFadeDepth" -> WorldNoiseGenerator.CAVE_FADE_MEDSMALL_DEPTH = value;
        case "medSmallFadeStrength" -> WorldNoiseGenerator.CAVE_FADE_MEDSMALL_STRENGTH = value;
        default -> {
            context.getSource().sendFailure(Component.literal("Unknown cave param: " + param));
            return 0;
        }
    }
    
    context.getSource().sendSuccess(() -> 
        Component.literal("Cave " + param + " = " + value + ". Use /bfme reload to see changes."), true);
    return 1;
}
```

Регистрация команды (добавить к существующим):

```java
dispatcher.register(Commands.literal("bfme")
    .then(Commands.literal("cave")
        .then(Commands.argument("parameter", StringArgumentType.word())
            .then(Commands.argument("value", FloatArgumentType.floatArg(-10f, 10f))
                .executes(ctx -> handleCaveCommand(ctx))
            )
        )
    )
);
```

### 5. ВАЖНО: CaveInterpolator кеширование

После изменения параметров и `/bfme reload`, CaveInterpolator пересоздаётся для каждого чанка — автоматически подхватывает новые значения. Дополнительных действий не нужно.

## Как тестировать

1. Зайти в мир
2. `/bfme cave superLargeOffset 0.36`
3. `/bfme reload`
4. Полетать, посмотреть результат
5. `/bfme cave superLargeOffset 0.40`
6. `/bfme reload`
7. Сравнить

## Workflow тюнинга по одному масштабу

Чтобы тестировать каждый масштаб отдельно, поставь остальные на 10.0 (гарантированно камень):

```
/bfme cave largeOffset 10.0
/bfme cave mediumOffset 10.0
/bfme cave smallOffset 10.0
/bfme cave superLargeOffset 0.36
/bfme reload
```

Теперь видишь только superLarge. Настроил → переключаешься на large:

```
/bfme cave superLargeOffset 10.0
/bfme cave largeOffset 0.33
/bfme reload
```

И так по очереди. Потом включаешь все вместе с финальными значениями.

## Что НЕ менять
- sampleCheeseNoise — не трогать
- CaveInterpolator — не трогать
- BFMEChunkGenerator — не трогать
- BFMEBiomeSource — не трогать
- Существующие команды — не трогать, только добавить cave subcommand
