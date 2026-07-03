# Задача: Гладкий superLarge cheese + оптимизация интерполяции

## Контекст
SuperLarge cheese использует sampleCheeseNoise с делением координат на 3 — слишком много октав создают мелкие изолированные карманы вместо гигантских гладких залов. Нужен отдельный простой noise для superLarge.

## Что сделать

### 1. WorldNoiseGenerator.java — добавить метод sampleSuperLargeCave

Добавить рядом с sampleCheeseNoise:

```java
/**
 * Отдельный гладкий noise для гигантских пещер.
 * Всего 2 октавы — максимально гладкая граница, никаких мелких карманов.
 * Масштаб задан внутри метода, координаты передавать БЕЗ деления.
 */
private double sampleSuperLargeCave(double x, double y, double z) {
    double v1 = OpenSimplex2S.noise3_ImproveXY(cheeseOctaveSeeds[0],
            x * 0.003, z * 0.003, y * 0.004);
    double v2 = OpenSimplex2S.noise3_ImproveXY(cheeseOctaveSeeds[1],
            x * 0.006, z * 0.006, y * 0.008);
    return (v1 + v2 * 0.5) / 1.5;
}
```

### 2. WorldNoiseGenerator.java — изменить computeCaveDensity

Заменить ВЕСЬ метод computeCaveDensity на:

```java
public float computeCaveDensity(int x, int y, int z, int surfaceHeight) {
    // SuperLarge: отдельный гладкий noise (2 октавы, свой масштаб)
    double cheeseSuperLarge = sampleSuperLargeCave((double) x, (double) y, (double) z);
    // Остальные: обычный cheese noise
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

### 3. Убедиться что статические переменные на месте

Если ещё не добавлены из предыдущего промпта, добавить в начало WorldNoiseGenerator:

```java
// === CAVE TUNING (debug, меняются командой) ===
public static float CAVE_OFFSET_SUPER_LARGE = 0.36f;
public static float CAVE_OFFSET_LARGE = 0.33f;
public static float CAVE_OFFSET_MEDIUM = 0.28f;
public static float CAVE_OFFSET_SMALL = 0.32f;

// Depth fade от поверхности (per-scale)
public static float CAVE_FADE_SUPER_LARGE_DEPTH = 80f;
public static float CAVE_FADE_SUPER_LARGE_STRENGTH = 0.25f;
public static float CAVE_FADE_LARGE_DEPTH = 40f;
public static float CAVE_FADE_LARGE_STRENGTH = 0.2f;
public static float CAVE_FADE_MEDSMALL_DEPTH = 15f;
public static float CAVE_FADE_MEDSMALL_STRENGTH = 0.15f;
```

### 4. CaveInterpolator.java — убедиться что работает правильно

CaveInterpolator вызывает computeCaveDensity на сетке STEP=4, потом интерполирует.
SuperLarge с 2 октавами и масштабом 0.003 = формы ~300+ блоков. STEP=4 идеально для этого.
Spaghetti остаётся поблочно в isCave().

НЕ менять CaveInterpolator — он уже правильно настроен.

### 5. Удалить лишнее

Если были добавлены методы sampleCheeseNoiseSmooth или sampleCheeseMedSmooth — удалить их. Нужен только sampleSuperLargeCave.

Старый depthGradient (`0.05f + 0.1f * (y / 300f)`) — если остался в коде, удалить. Заменён на per-scale depth fade.

## Что НЕ менять
- sampleCheeseNoise — не трогать (используется для large, medium, small)
- computeSpaghettiModifier — не трогать
- CaveInterpolator — не трогать
- BFMEChunkGenerator — не трогать
- Команды — не трогать

## Как тестировать
1. Создать мир
2. Закомментировать large, medium, small — оставить только superLarge
3. SuperLarge должен создавать ГЛАДКИЕ огромные залы без мелких карманов
4. Включить все 4 — medium и small добавят детали внутри залов
5. Тюнить offsets через команды:
   - `/bfme cave superLargeOffset 0.36` → reload / полёт в новые чанки
   - `/bfme cave largeOffset 0.33` и т.д.
