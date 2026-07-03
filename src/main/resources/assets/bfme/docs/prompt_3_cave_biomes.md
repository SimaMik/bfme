# Задача: 3 кастомных пещерных биома (без структур и аметистов)

## Контекст
Мод COTR, NeoForge 1.21.1. Пакет `net.sima.bfme`.
Пещерные биомы назначаются через `BFMEBiomeSource.getNoiseBiome()` по Y-координате.
Ванильные lush_caves и dripstone_caves уже зарегистрированы в `ModDimensions.bootstrapStem()`.
Нужно заменить их на кастомные без mineshafts, amethyst geodes, strongholds и прочих структур.
Ванильная система features (`super.generateFeatures()`) размещает декор автоматически — нужно только правильно настроить GenerationSettings биома.

## Что сделать

### 1. BFMEBiomeKeys.java — добавить ключи

Рядом с другими ключами биомов добавить:

```java
public static final ResourceKey<Biome> CAVE_LUSH = register("cave_lush");
public static final ResourceKey<Biome> CAVE_DRIPSTONE = register("cave_dripstone");
public static final ResourceKey<Biome> CAVE_CRYSTAL = register("cave_crystal");
```

### 2. BFMEBiomes.java — датаген биомов

В метод `bootstrap(BootstrapContext<Biome> context)` добавить три биома.

Каждый биом должен:
- НЕ иметь структур (не добавлять структуры через GenerationSettings)
- НЕ иметь amethyst geodes
- НЕ иметь mineshafts
- Иметь базовые руды (iron, gold, copper, coal, diamond и т.п.)
- Иметь свои уникальные features

```java
// === CAVE_LUSH — пышные пещеры ===
// Как ванильные lush caves: мох, светящиеся ягоды, лианы, spore blossom, глина
// Но без mineshafts, geodes, strongholds
{
    BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
            context.lookup(Registries.PLACED_FEATURE),
            context.lookup(Registries.CONFIGURED_CARVER)
    );
    
    // Руды (стандартные)
    BiomeDefaultFeatures.addDefaultOres(genSettings);
    
    // Lush caves features
    BiomeDefaultFeatures.addLushCavesVegetationFeatures(genSettings);
    BiomeDefaultFeatures.addLushCavesDecorationFeatures(genSettings); // clay pools
    
    // НЕ добавляем:
    // BiomeDefaultFeatures.addDefaultUndergroundVariety — содержит geodes
    // Никаких структур
    
    context.register(BFMEBiomeKeys.CAVE_LUSH, new Biome.Builder()
            .hasPrecipitation(true)
            .temperature(0.5f)
            .downfall(0.5f)
            .specialEffects(new BiomeSpecialEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x050533)
                    .fogColor(0xC0D8FF)
                    .skyColor(0x7BA5FF)
                    .grassColorOverride(0x59AE30)  // зеленее чем обычно
                    .foliageColorOverride(0x59AE30)
                    .build())
            .generationSettings(genSettings.build())
            .mobSpawnSettings(MobSpawnSettings.EMPTY)
            .build());
}

// === CAVE_DRIPSTONE — капельниковые пещеры ===
// Как ванильные dripstone caves: сталактиты, сталагмиты, pointed dripstone
// Но без mineshafts, geodes, strongholds
{
    BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
            context.lookup(Registries.PLACED_FEATURE),
            context.lookup(Registries.CONFIGURED_CARVER)
    );
    
    BiomeDefaultFeatures.addDefaultOres(genSettings);
    
    // Dripstone features
    BiomeDefaultFeatures.addDripstone(genSettings);
    
    context.register(BFMEBiomeKeys.CAVE_DRIPSTONE, new Biome.Builder()
            .hasPrecipitation(true)
            .temperature(0.5f)
            .downfall(0.5f)
            .specialEffects(new BiomeSpecialEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x050533)
                    .fogColor(0xC0D8FF)
                    .skyColor(0x7BA5FF)
                    .build())
            .generationSettings(genSettings.build())
            .mobSpawnSettings(MobSpawnSettings.EMPTY)
            .build());
}

// === CAVE_CRYSTAL — кристаллические пещеры ===
// Кастомный биом: аметистовые блоки, кальцит, гладкий базальт на стенах
// Prismarine пятна, glow lichen для освещения
{
    BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder(
            context.lookup(Registries.PLACED_FEATURE),
            context.lookup(Registries.CONFIGURED_CARVER)
    );
    
    BiomeDefaultFeatures.addDefaultOres(genSettings);
    
    // Glow lichen для атмосферы
    BiomeDefaultFeatures.addDefaultUndergroundDecorations(genSettings);
    // ^^^ если это добавляет geodes — убрать и добавить только glow_lichen вручную
    
    context.register(BFMEBiomeKeys.CAVE_CRYSTAL, new Biome.Builder()
            .hasPrecipitation(true)
            .temperature(0.3f)
            .downfall(0.3f)
            .specialEffects(new BiomeSpecialEffects.Builder()
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x050533)
                    .fogColor(0xD0C8FF)  // слегка фиолетовый туман
                    .skyColor(0x9B8FFF)  // фиолетовое небо
                    .build())
            .generationSettings(genSettings.build())
            .mobSpawnSettings(MobSpawnSettings.EMPTY)
            .build());
}
```

### 3. ModDimensions.java — зарегистрировать биомы

В `bootstrapStem()` (или где регистрируются биомы для измерения), найти где добавляются LUSH_CAVES и DRIPSTONE_CAVES. Заменить или добавить рядом:

```java
// Кастомные пещерные биомы
biomes.getOrThrow(BFMEBiomeKeys.CAVE_LUSH);
biomes.getOrThrow(BFMEBiomeKeys.CAVE_DRIPSTONE);
biomes.getOrThrow(BFMEBiomeKeys.CAVE_CRYSTAL);
```

### 4. BFMEBiomeSource.java — назначать пещерные биомы

В методе `getNoiseBiome()`, заменить ванильные cave biomes на кастомные:

Найти (примерно):
```java
if (worldY < 40) return LUSH_CAVES;
```

Заменить на (используя getCaveBiome из WorldNoiseGenerator):

```java
if (worldY < surfaceHeight) {
    int caveBiomeIdx = noise.getCaveBiome(worldX, worldY, worldZ);
    return switch (caveBiomeIdx) {
        case 1 -> holders.getOrThrow(BFMEBiomeKeys.CAVE_LUSH);
        case 2 -> holders.getOrThrow(BFMEBiomeKeys.CAVE_DRIPSTONE);
        case 3 -> holders.getOrThrow(BFMEBiomeKeys.CAVE_CRYSTAL);
        default -> /* наземный биом */;
    };
}
```

ВАЖНО: Точная реализация зависит от текущего кода getNoiseBiome. Не ломать существующую логику наземных биомов. Пещерные биомы назначаются ТОЛЬКО под поверхностью.

### 5. WorldNoiseGenerator.java — getCaveBiome (если ещё нет)

Если метод getCaveBiome ещё не реализован или использует старую логику, заменить на:

```java
/**
 * Определяет подземный биом.
 * 0 = default (наземный биом), 1 = lush, 2 = dripstone, 3 = crystal
 */
public int getCaveBiome(int x, int y, int z) {
    checkInit();
    
    double temp = OpenSimplex2S.noise3_ImproveXY(caveBiomeSeed1,
            x * 0.001, z * 0.001, y * 0.003);
    double humid = OpenSimplex2S.noise3_ImproveXY(caveBiomeSeed2,
            x * 0.0015, z * 0.0015, y * 0.004);

    // Зоны — большая часть default (камень без декора)
    if (temp > 0.3 && humid > 0.1) return 1;   // lush
    if (temp < -0.3 && humid > 0.1) return 2;   // dripstone
    if (humid < -0.3) return 3;                   // crystal
    return 0;  // default — наземный биом
}
```

### Что должно получиться

- **CAVE_LUSH**: мох на полу/потолке, glow berries свисают, spore blossom, лианы, глиняные лужи. Зелёная атмосфера.
- **CAVE_DRIPSTONE**: сталактиты и сталагмиты из pointed dripstone, dripstone блоки пятнами. Каменная суровая атмосфера.
- **CAVE_CRYSTAL**: glow lichen на стенах для освещения. Пока без кастомных кристаллов — просто чистый биом с особым туманом. Кастомные features добавим потом.

### Что НЕ менять
- WorldNoiseGenerator.computeCaveDensity — не трогать
- CaveInterpolator — не трогать
- BFMEChunkGenerator — не трогать
- Наземные биомы — не трогать
- Существующие features наземных биомов — не трогать

### ВАЖНО про BiomeDefaultFeatures
Нужно проверить какие методы BiomeDefaultFeatures содержат geodes и structures:
- `addDefaultUndergroundVariety` — может содержать geodes, проверить
- `addDefaultUndergroundDecorations` — может содержать glow lichen, проверить
- Если метод содержит нежелательные features — не вызывать его, добавить нужные features вручную

### Как тестировать
1. Создать новый мир
2. Телепортироваться под землю (y = -50)
3. Летать в spectator
4. Должны быть зоны с мохом (lush), зоны с сталактитами (dripstone), зоны с glow lichen (crystal)
5. НЕ должно быть: mineshafts, amethyst geodes, strongholds
