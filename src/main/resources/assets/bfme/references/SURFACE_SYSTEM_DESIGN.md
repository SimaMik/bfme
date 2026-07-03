# BFME Surface System — Полный дизайн

## Концепция

Каждый биом имеет SurfaceConfig — набор правил, которые определяют какой блок ставить на поверхность. Правила проверяются по приоритету (первое совпадение). Каждое правило учитывает slope (крутизну) и height (высоту), с шумовым размытием границ.

Поверх правил — система patches: органические пятна альтернативных блоков, привязанные к определённым правилам.

---

## Классы

### SurfacePatch (record)
```java
Block block;           // Альтернативный блок
float chance;          // Порог шума (0.0-1.0). Выше = реже. 0.03 = ~3% площади
float minHeight;       // Мин. абсолютная высота (-999 = без ограничения)
float maxHeight;       // Макс. абсолютная высота (999 = без ограничения)
int noiseIndex;        // Автоматический индекс для уникального шума
```

### SurfaceRule (record)
```java
Block block;              // Основной блок
float slopeMin;           // Мин. угол склона (default 0°)
float slopeMax;           // Макс. угол склона (default 90°)
float heightMin;          // Мин. высота (default -999)
float heightMax;          // Макс. высота (default 999)
float slopeBlur;          // ±N° шумового размытия порога slope (default 4°)
float heightBlur;         // ±N блоков шумового размытия порога height (default 8)
List<SurfacePatch> patches; // Пятна альтернативных блоков
```

### SurfaceConfig
```java
List<SurfaceRule> rules;      // Приоритетный список
Block fallback;               // Если ничего не совпало
Block underSurface;           // null = AUTO (dirt под травой, stone под камнем)
int underLayers;              // Толщина подповерхности (default 4)

// Метод:
Block evaluate(float height, float slopeAngle, int x, int z, float baseHeight)
```

### SurfaceNoise (singleton)
```java
// Один шум для размытия границ (scale ~50, 3 октавы)
// Отдельный шум для patches (scale ~35, с domain warp, 2 октавы)
// Domain warp для patches: scale ~80, strength ~12 блоков
// Всё инициализируется один раз с world seed
```

---

## Логика evaluate()

```
1. boundaryNoise = surfaceNoise.sample(x, z)  // [0..1]
   bias = (boundaryNoise - 0.5) * 2            // [-1..+1]

2. Для каждого правила (по приоритету):
   effSlopeMin = rule.slopeMin + bias * rule.slopeBlur
   effSlopeMax = rule.slopeMax + bias * rule.slopeBlur
   effHeightMin = rule.heightMin + bias * rule.heightBlur
   effHeightMax = rule.heightMax + bias * rule.heightBlur
   
   if (slopeAngle >= effSlopeMin && slopeAngle <= effSlopeMax &&
       height >= effHeightMin && height <= effHeightMax):
       
       // Проверяем patches
       for each patch in rule.patches:
           if (height >= patch.minHeight && height <= patch.maxHeight):
               patchNoise = patchNoiseGenerator.sample(x, z, patch.noiseIndex)
               if (patchNoise > 1.0 - patch.chance):
                   return patch.block
       
       return rule.block

3. return fallback
```

---

## Under-surface логика (AUTO)

```
surfaceBlock → underBlock:
  GRASS_BLOCK, PODZOL, MYCELIUM → DIRT (N слоёв)
  SNOW_BLOCK → STONE (1 слой) 
  SAND → SAND (3 слоя), потом SANDSTONE (2 слоя)
  GRAVEL → GRAVEL (2 слоя), потом STONE
  Всё остальное → копия surfaceBlock (1 слой)
```

---

## Конфиги биомов

### PELENNOR PLAINS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(38).slopeBlur(5).build()
    .rule(Blocks.COARSE_DIRT).slopeMin(25).slopeMax(42).slopeBlur(4).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Плоские поля. Камень только на редких крутых обрывах. Coarse dirt на средних склонах. Остальное трава.

### LOSSARNACH FARMLANDS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(40).slopeBlur(5).build()
    .rule(Blocks.COARSE_DIRT).slopeMin(28).slopeMax(44).slopeBlur(4).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Похоже на Pelennor, чуть выше пороги — мягче.

### NORTH ITHILIEN
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(42).slopeBlur(5)
        .patch(Blocks.MOSSY_COBBLESTONE, 0.08)  // Замшелый камень в лесу
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(25).slopeMax(45).slopeBlur(4).build()
    .rule(Blocks.PODZOL).slopeMax(20).slopeBlur(4)
        .patch(Blocks.MOSS_BLOCK, 0.06)         // Пятна мха
        .build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Лесной биом. Podzol на пологих, мох, замшелый камень на обрывах.

### DRUADAN FOREST
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(40).slopeBlur(5)
        .patch(Blocks.MOSSY_COBBLESTONE, 0.12)  // Больше мха — дикий лес
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(22).slopeMax(44).slopeBlur(5).build()
    .rule(Blocks.PODZOL).slopeMax(18).slopeBlur(4)
        .patch(Blocks.MOSS_BLOCK, 0.10)
        .patch(Blocks.COARSE_DIRT, 0.05)         // Пятна грубой земли
        .build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Ещё более дикий. Больше мха, больше грязи.

### EILENACH MOORLANDS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(35).slopeBlur(5)
        .patch(Blocks.COBBLESTONE, 0.06)
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(20).slopeMax(40).slopeBlur(4).build()
    .rule(Blocks.COARSE_DIRT).slopeMax(15).slopeBlur(3)  // Вересковые пустоши — грубая земля даже на ровном
        .patch(Blocks.GRASS_BLOCK, 0.40)                  // 40% — трава пробивается пятнами
        .build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Пустоши: основа coarse dirt, трава пятнами. Открытый, продуваемый.

### WHITE MOUNTAINS FOOTHILLS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(35).slopeBlur(5)
        .patch(Blocks.COBBLESTONE, 0.05)
        .patch(Blocks.ANDESITE, 0.03)
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(22).slopeMax(40).slopeBlur(5).build()
    .rule(Blocks.GRASS_BLOCK).slopeMax(25).slopeBlur(4)
        .patch(Blocks.COARSE_DIRT, 0.08)  // Пятна грубой земли на лугах
        .build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Переход к горам. Больше камня, пятна земли.

### WHITE MOUNTAINS
```java
SurfaceConfig.builder()
    // Снег на пологих вершинах (абсолютная высота > 220)
    .rule(Blocks.SNOW_BLOCK).slopeMax(40).heightMin(220).slopeBlur(5).heightBlur(15)
        .patch(Blocks.POWDER_SNOW, 0.08)         // Пятна рыхлого снега
        .build()
    // Снег+камень на крутых вершинах
    .rule(Blocks.STONE).slopeMin(35).heightMin(200).slopeBlur(5).heightBlur(12)
        .patch(Blocks.SNOW_BLOCK, 0.15)           // Снег пятнами на камне
        .patch(Blocks.CALCITE, 0.06)              // Белый камень — White Mountains
        .build()
    // Гравий на осыпях (очень крутое)
    .rule(Blocks.GRAVEL).slopeMin(48).slopeBlur(4).build()
    // Камень на крутых склонах
    .rule(Blocks.STONE).slopeMin(30).slopeBlur(5)
        .patch(Blocks.DIORITE, 0.04, 150, 999)    // Диорит выше 150
        .patch(Blocks.CALCITE, 0.05, 180, 999)    // Кальцит выше 180
        .patch(Blocks.ANDESITE, 0.03)              // Андезит везде
        .build()
    // Coarse dirt на средних склонах
    .rule(Blocks.COARSE_DIRT).slopeMin(20).slopeMax(35).slopeBlur(5).build()
    // Трава внизу
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Полная горная палитра: снег → камень с кальцитом → гравий → coarse dirt → трава. White Mountains "белые" благодаря calcite + diorite + snow.

### WHITE MOUNTAINS PEAKS
```java
SurfaceConfig.builder()
    .rule(Blocks.SNOW_BLOCK).slopeMax(45).heightMin(200).slopeBlur(5).heightBlur(15)
        .patch(Blocks.POWDER_SNOW, 0.10)
        .build()
    .rule(Blocks.STONE).slopeMin(30).heightMin(180).slopeBlur(5).heightBlur(10)
        .patch(Blocks.SNOW_BLOCK, 0.20)           // Много снега на камне
        .patch(Blocks.CALCITE, 0.08)
        .build()
    .rule(Blocks.GRAVEL).slopeMin(50).slopeBlur(4).build()
    .rule(Blocks.STONE).slopeMin(28).slopeBlur(5)
        .patch(Blocks.DIORITE, 0.05, 140, 999)
        .patch(Blocks.CALCITE, 0.07, 160, 999)
        .patch(Blocks.ANDESITE, 0.03)
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(18).slopeMax(32).slopeBlur(5).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Как WHITE_MOUNTAINS, но снег ниже (от 200), больше снега, больше кальцита. Высочайшие пики — почти целиком камень и снег.

### WHITE MOUNTAINS HIGH PEAKS
```java
SurfaceConfig.builder()
    .rule(Blocks.SNOW_BLOCK).slopeMax(50).heightMin(180).slopeBlur(5).heightBlur(20)
        .patch(Blocks.POWDER_SNOW, 0.12)
        .patch(Blocks.ICE, 0.04, 280, 999)        // Лёд на самых высоких
        .build()
    .rule(Blocks.GRAVEL).slopeMin(52).slopeBlur(4).build()
    .rule(Blocks.STONE).slopeMin(20).slopeBlur(5)
        .patch(Blocks.SNOW_BLOCK, 0.25)            // Очень много снега
        .patch(Blocks.CALCITE, 0.10)
        .patch(Blocks.DIORITE, 0.05)
        .build()
    .fallback(Blocks.STONE)                         // Даже ровное = камень, не трава
    .build()
```
Почти целиком камень и снег. Трава не растёт. Fallback = stone, не grass.

### AMON DIN HILLS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(35).slopeBlur(5)
        .patch(Blocks.COBBLESTONE, 0.06)
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(22).slopeMax(40).slopeBlur(4).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Маяковый холм. Камень на крутых, трава на пологих.

### EMYN ARNEN HILLS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(38).slopeBlur(5)
        .patch(Blocks.MOSSY_COBBLESTONE, 0.05)     // Зелёные холмы Фарамира
        .build()
    .rule(Blocks.COARSE_DIRT).slopeMin(24).slopeMax(42).slopeBlur(4).build()
    .rule(Blocks.GRASS_BLOCK).slopeMax(20).slopeBlur(3)
        .patch(Blocks.PODZOL, 0.05)                 // Немного podzol
        .build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Зелёные холмы с руинами. Замшелый камень.

### CAIR ANDROS
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(40).slopeBlur(5).build()
    .rule(Blocks.SAND).slopeMax(8).heightMax(68).heightBlur(3).build()  // Песок у воды
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Речной остров. Песок у кромки воды.

### RIVER ANDUIN
```java
SurfaceConfig.builder()
    .rule(Blocks.CLAY).slopeMax(5).heightMax(63).heightBlur(2).build()  // Глина на дне
    .rule(Blocks.SAND).slopeMax(12).heightMax(66).heightBlur(3).build() // Песок у берега
    .rule(Blocks.GRAVEL).slopeMax(15).heightMax(67).heightBlur(2).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```

### ANDUIN BANKS
```java
SurfaceConfig.builder()
    .rule(Blocks.SAND).slopeMax(8).heightMax(68).heightBlur(4).build()
    .rule(Blocks.GRAVEL).slopeMax(12).heightMax(70).heightBlur(3).build()
    .fallback(Blocks.GRASS_BLOCK)
    .build()
```
Пойменные берега. Песок и гравий у воды, трава выше.

### DAGORLAD WASTES
```java
SurfaceConfig.builder()
    .rule(Blocks.STONE).slopeMin(30).slopeBlur(4)
        .patch(Blocks.GRAVEL, 0.08)
        .build()
    .rule(Blocks.GRAVEL).slopeMin(15).slopeMax(35).slopeBlur(4).build()
    .rule(Blocks.COARSE_DIRT).slopeMax(20).slopeBlur(4)
        .patch(Blocks.GRAVEL, 0.15)                // Каменистая пустошь
        .patch(Blocks.DEAD_BUSH, 0.0)              // (dead bush через features, не surface)
        .build()
    .fallback(Blocks.COARSE_DIRT)                   // Мёртвая земля, не трава
    .build()
```
Мёртвая равнина. Gravel, coarse dirt. Никакой травы.

### GORGOROTH PLAINS
```java
SurfaceConfig.builder()
    .rule(Blocks.BASALT).slopeMin(25).slopeBlur(4)
        .patch(Blocks.BLACKSTONE, 0.08)
        .build()
    .rule(Blocks.BLACKSTONE).slopeMin(12).slopeMax(30).slopeBlur(4)
        .patch(Blocks.BASALT, 0.10)
        .build()
    .rule(Blocks.GRAVEL).slopeMax(15).slopeBlur(3)
        .patch(Blocks.BASALT, 0.12)                 // Базальтовые выходы
        .patch(Blocks.MAGMA_BLOCK, 0.02)            // Редкая магма — трещины
        .patch(Blocks.BLACKSTONE, 0.08)
        .build()
    .fallback(Blocks.GRAVEL)                         // Пепел и гравий
    .build()
```
Вулканическое плато. Basalt, blackstone, магма. Никакой жизни.

### EPHEL DUATH
```java
SurfaceConfig.builder()
    .rule(Blocks.BLACKSTONE).slopeMin(40).slopeBlur(5)
        .patch(Blocks.BASALT, 0.10)
        .patch(Blocks.OBSIDIAN, 0.02, 180, 999)    // Обсидиан на вершинах
        .build()
    .rule(Blocks.BASALT).slopeMin(25).slopeMax(45).slopeBlur(5)
        .patch(Blocks.BLACKSTONE, 0.12)
        .build()
    .rule(Blocks.GRAVEL).slopeMin(48).slopeBlur(4).build()  // Осыпи
    .rule(Blocks.COARSE_DIRT).slopeMax(28).slopeBlur(4)
        .patch(Blocks.BLACKSTONE, 0.08)
        .patch(Blocks.BASALT, 0.06)
        .build()
    .fallback(Blocks.COARSE_DIRT)                    // Тёмная мёртвая земля
    .build()
```
Горы Тени. Тёмная палитра: blackstone, basalt, obsidian. Мрачно.

### EPHEL DUATH PEAKS
```java
SurfaceConfig.builder()
    .rule(Blocks.BLACKSTONE).slopeMin(35).slopeBlur(5)
        .patch(Blocks.BASALT, 0.12)
        .patch(Blocks.OBSIDIAN, 0.04, 160, 999)
        .build()
    .rule(Blocks.GRAVEL).slopeMin(50).slopeBlur(4).build()
    .rule(Blocks.BASALT).slopeMin(20).slopeMax(40).slopeBlur(5)
        .patch(Blocks.BLACKSTONE, 0.15)
        .build()
    .fallback(Blocks.BLACKSTONE)                     // Даже ровное — чёрный камень
    .build()
```

### EPHEL DUATH BLACK PEAKS
```java
SurfaceConfig.builder()
    .rule(Blocks.GRAVEL).slopeMin(52).slopeBlur(4).build()
    .rule(Blocks.BLACKSTONE).slopeMin(20).slopeBlur(5)
        .patch(Blocks.BASALT, 0.15)
        .patch(Blocks.OBSIDIAN, 0.06)
        .build()
    .fallback(Blocks.BLACKSTONE)
    .build()
```
Самые чёрные вершины. Почти целиком blackstone + basalt.

---

## Принципы дизайна

1. **Градиент по slope**: пологое → земля/трава, среднее → coarse dirt, крутое → камень, обрыв → гравий
2. **Градиент по высоте**: низко → трава, средне → камень, высоко → снег (только для White Mountains)
3. **Биом = палитра**: WM = светлый (calcite, diorite, snow), ED = тёмный (basalt, blackstone, obsidian), Ithilien = зелёный (podzol, moss)
4. **Patches = геология**: пятна разных пород создают ощущение что гора не из одного блока
5. **Шумовое размытие**: все границы "дышат" — не резкая линия на 30°, а волнистая полоса 26-34°

---

## Файлы

```
worldgen/surface/SurfacePatch.java       — record
worldgen/surface/SurfaceRule.java        — record + builder
worldgen/surface/SurfaceConfig.java      — список правил + evaluate + builder
worldgen/surface/SurfaceConfigs.java     — все конфиги биомов (static)
worldgen/surface/SurfaceNoise.java       — singleton, шумы для размытия и patches
```

## Интеграция

В BFMEChunkGenerator.generateColumn():
- Получить SurfaceConfig из биома
- surfaceBlock = config.evaluate(surfaceHeight, slopeAngle, worldX, worldZ, baseHeight)
- Заменить весь текущий блок выбора surface (SlopeMap, getDecorativeStoneBlock)
