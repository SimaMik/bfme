# Задача: 4 масштаба cheese + Spaghetti 3D

## Контекст
Мод COTR, NeoForge 1.21.1. Кастомный ChunkGenerator с cheese caves.
Пещеры вырезаются в `WorldNoiseGenerator.isCave()`.

## Текущее состояние isCave()
- 2 cheese масштаба: normal (x/1.5, y, z/1.5) и large (x/3, y/2.5, z/3)
- Surface protection для surfaceHeight < 90
- Depth gradient: 0.05 + 0.1 * (y/300f)
- Pillars с vanilla формулой
- sampleCheeseNoise принимает double параметры

---

## Часть 1: 4 масштаба cheese

### WorldNoiseGenerator.java — изменить isCave()

Найти текущий код cheese noise в isCave() (две строки sampleCheeseNoise) и заменить на четыре масштаба.

Было (примерно):
```java
double cheeseNormal = sampleCheeseNoise(x / 1.5, (double)y, z / 1.5);
double cheeseLarge = sampleCheeseNoise(x / 3.0, y / 2.5, z / 3.0);
```

Стало:
```java
// 4 масштаба cheese: от мелких ниш до гигантских залов
double cheeseSuperLarge = sampleCheeseNoise(x / 3.0, y / 2.0, z / 3.0);   // гигантские залы, редко
double cheeseLarge = sampleCheeseNoise(x / 2.0, (double)y, z / 2.0);       // большие пещеры
double cheeseMedium = sampleCheeseNoise((double)x, (double)y, (double)z);   // стандартные
double cheeseSmall = sampleCheeseNoise(x * 1.5, y * 1.5, z * 1.5);        // мелкие ниши
```

Заменить расчёт density. Было:
```java
float normalDensity = (float) cheeseNormal + normalOffset + depthGradient;
float largeDensity = (float) cheeseLarge + largeOffset + depthGradient;

float finalDensity = Math.min(normalDensity, largeDensity) + surfaceProtection;
```

Стало:
```java
float superLargeOffset = 0.38f;  // самые редкие, но когда есть — гигантские
float largeOffset = 0.33f;       // реже чем medium
float mediumOffset = 0.28f;      // основные пещеры
float smallOffset = 0.32f;       // мелкие ниши, умеренно

float superLargeDensity = (float) cheeseSuperLarge + superLargeOffset + depthGradient;
float largeDensity = (float) cheeseLarge + largeOffset + depthGradient;
float mediumDensity = (float) cheeseMedium + mediumOffset + depthGradient;
float smallDensity = (float) cheeseSmall + smallOffset + depthGradient;

float finalDensity = Math.min(
    Math.min(superLargeDensity, largeDensity),
    Math.min(mediumDensity, smallDensity)
) + surfaceProtection;
```

ВАЖНО: НЕ менять surfaceProtection, depthGradient, pillars — оставить как есть.

---

## Часть 2: Spaghetti 3D

### WorldNoiseGenerator.java — добавить поля для spaghetti

Рядом с pillarSeed добавить:
```java
private long spaghettiSeed1;
private long spaghettiSeed2;
private long spaghettiRarenessSeed;
```

В метод инициализации (где присваиваются seed'ы) добавить:
```java
spaghettiSeed1 = seed + 80010L;
spaghettiSeed2 = seed + 80011L;
spaghettiRarenessSeed = seed + 80015L;
```

### WorldNoiseGenerator.java — добавить метод isSpaghettiCave

Добавить новый метод ПЕРЕД isCave():
```java
/**
 * Spaghetti 3D — круглые туннели.
 * Два noise берутся в abs(), их сумма близка к 0 = туннель.
 * Rareness noise подавляет туннели в некоторых регионах.
 */
private boolean isSpaghettiCave(int x, int y, int z) {
    // Основные два noise — разные seeds, немного разный масштаб
    double XZ_SCALE = 0.012;   // ~80 блоков между туннелями
    double Y_SCALE = 0.012;

    double spaghetti1 = OpenSimplex2S.noise3_ImproveXY(spaghettiSeed1,
            x * XZ_SCALE, z * XZ_SCALE, y * Y_SCALE);
    double spaghetti2 = OpenSimplex2S.noise3_ImproveXY(spaghettiSeed2,
            x * XZ_SCALE * 0.9, z * XZ_SCALE * 0.9, y * Y_SCALE * 1.1);

    // abs() создаёт "щель" около нуля — два noise пересекаются = туннель
    double tunnelValue = Math.abs(spaghetti1) + Math.abs(spaghetti2);

    // Rareness — подавляет туннели в некоторых регионах
    double rareness = OpenSimplex2S.noise3_ImproveXY(spaghettiRarenessSeed,
            x * 0.003, z * 0.003, y * 0.003);

    // Порог: чем ниже tunnelValue, тем ближе к центру туннеля
    // rareness смещает порог — при rareness > 0.3 туннели не генерируются
    float threshold = 0.06f + (float) Math.max(0, rareness * 0.15);

    return tunnelValue < threshold;
}
```

### WorldNoiseGenerator.java — подключить spaghetti в isCave()

В конце метода isCave(), ПЕРЕД `return true;` (после проверки pillars), добавить проверку spaghetti как АЛЬТЕРНАТИВНЫЙ путь.

НО — spaghetti должен работать НЕЗАВИСИМО от cheese. Если cheese не создал пещеру, spaghetti может создать туннель.

Для этого нужно изменить логику isCave(). Сейчас:
```java
if (finalDensity >= 0) return false;
// pillars...
if (pillarDensity + edgeBoost > 0.03f) return false;
return true;
```

Заменить на:
```java
boolean isCheeseCave = finalDensity < 0;

// Pillars — только внутри cheese пещер
if (isCheeseCave) {
    // ... существующий код pillars ...
    if (pillarDensity + edgeBoost > 0.03f) return false;  // pillar блокирует
    return true;
}

// Spaghetti — независимо от cheese, может создать туннель в камне
if (isSpaghettiCave(x, y, z)) {
    return true;
}

return false;
```

ВАЖНО: Весь блок pillars остаётся внутри `if (isCheeseCave)`. Spaghetti проверяется только если cheese не создал пещеру.

---

## Что НЕ менять
- surfaceProtection — оставить как есть
- depthGradient — оставить как есть
- Pillars — оставить как есть (формула, константы)
- sampleCheeseNoise — оставить как есть (double параметры, 9 октав)
- getCaveBiome — не трогать
- BFMEChunkGenerator — не трогать
- BFMEBiomeSource — не трогать

## Как тестировать
1. Создать новый мир
2. Телепортироваться под землю
3. Проверить:
   - Мелкие ниши (small) — 5-15 блоков
   - Средние пещеры (medium) — 20-60 блоков
   - Большие пещеры (large) — 60-120 блоков
   - Гигантские залы (super large) — 120-200+ блоков
   - Spaghetti туннели — круглые проходы 5-10 блоков ширины, соединяют cheese пещеры
4. В горах пещеры должны прорезать склоны (surfaceProtection = 0 выше 90)
5. На равнинах (ниже 90) поверхность защищена

## Параметры для тюнинга потом
- Offsets (superLargeOffset, largeOffset, mediumOffset, smallOffset) — частота/размер каждого типа
- Spaghetti XZ_SCALE — расстояние между туннелями (меньше = ближе)
- Spaghetti threshold — толщина туннелей (меньше = тоньше)
- Spaghetti rareness * 0.15 — как сильно подавляются туннели
