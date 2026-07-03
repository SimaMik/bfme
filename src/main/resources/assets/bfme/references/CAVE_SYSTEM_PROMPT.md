# Задача: Полная переработка cave системы на основе ванильных density functions

## Контекст
Мод COTR (NeoForge 1.21.1), пакет `net.sima.bfme`. Полностью переписываем `isCave()` в `WorldNoiseGenerator.java` на основе реальных ванильных формул из density functions. Проект использует `OpenSimplex2S.noise3_ImproveXY(long seed, double x, double z, double y)` (порядок: seed, x, z, y) и `OpenSimplex2S.noise2(long seed, double x, double z)`. Также есть `OctaveNoise` с методом `sample3D(x, y, z)` для многооктавного шума.

## Ключевое архитектурное изменение

Вместо boolean-подхода (каждый тип возвращает true/false) переходим на **density-based** подход как в ванилле:
- Каждый компонент возвращает `float density`
- Отрицательное значение = воздух (пещера)
- Положительное = камень
- `min()` всех компонентов = пещера где ЛЮБОЙ тип говорит "пещера"  
- `max()` с pillars = камень где pillars перекрывают пещеру
- Результат: `density < 0` → isCave = true

## Ванильные noise параметры (из реальных JSON)

Формула пересчёта в наш масштаб: `ourScale = xz_scale * 2^(firstOctave)`

| Noise | firstOctave | Octaves | xz_scale | y_scale | Наш XZ scale | Наш Y scale |
|-------|-------------|---------|----------|---------|--------------|-------------|
| cave_cheese | -8 | 9 | 1.0 | 1.0 | ~0.0039 (через OctaveNoise scale=256) | ~0.0039 |
| cave_layer | -8 | 1 | 1.0 | — | 0.0039 | 2D noise |
| cave_entrance | -7 | 3 | 0.75 | 0.5 | 0.00586 | 0.0039 |
| spaghetti_3d_1/2 | -7 | 1 | ~1.0* | ~1.0* | 0.0078 | 0.0078 |
| spaghetti_3d_rarity | -11 | 1 | 2.0 | 1.0 | 0.000977 | 0.000488 |
| spaghetti_3d_thickness | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |
| spaghetti_roughness | -5 | 1 | 1.0 | 1.0 | 0.03125 | 0.03125 |
| spaghetti_roughness_mod | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |
| spaghetti_2d | -7 | 1 | ~1.0* | ~1.0* | 0.0078 | 0.0078 |
| spaghetti_2d_elevation | -8 | 1 | 1.0 | 0.0 | 0.0039 | 2D noise |
| spaghetti_2d_modulator | -11 | 1 | 2.0 | 1.0 | 0.000977 | 0.000488 |
| spaghetti_2d_thickness | -11 | 1 | 2.0 | 1.0 | 0.000977 | 0.000488 |
| noodle (toggle) | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |
| noodle_ridge_a/b | -7 | 1 | 2.667 | 2.667 | 0.0208 | 0.0208 |
| noodle_thickness | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |
| pillar | -7 | 2 | 25.0 | 0.3 | 0.195 | 0.00234 |
| pillar_rareness | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |
| pillar_thickness | -8 | 1 | 1.0 | 1.0 | 0.0039 | 0.0039 |

*spaghetti_3d и spaghetti_2d используют weird_scaled_sampler — частота модулируется rarity/modulator noise.

## Файл: `WorldNoiseGenerator.java`

### Удалить все старые cave константы и seeds

Удалить ВСЕ существующие cave-related константы (SPAGHETTI_*, CHEESE_*, NOODLE_*, PILLAR_*, SP3D_*, SP2D_*, CAVE_*, ENTRANCE_*) и cave seed поля (spaghetti3dSeedA, caveCheeseSeed и т.д.).

### Новые seed поля:

```java
// === Cave system seeds ===
private long cheeseLayerSeed;

private long spaghetti3dSeed1;
private long spaghetti3dSeed2;
private long spaghetti3dRaritySeed;
private long spaghetti3dThicknessSeed;
private long spaghettiRoughnessSeed;
private long spaghettiRoughnessModSeed;

private long spaghetti2dModulatorSeed;
private long spaghetti2dElevationSeed;
private long spaghetti2dThicknessSeed;

private long entranceSeed;

private long noodleToggleSeed;
private long noodleRidgeASeed;
private long noodleRidgeBSeed;
private long noodleThicknessSeed;

private long pillarSeed;
private long pillarRarenessSeed;
private long pillarThicknessSeed;
```

### Новое поле для cheese OctaveNoise:

```java
private OctaveNoise cheeseNoise;
```

### Инициализация (в методе где задаётся world seed):

```java
// Cave seeds
cheeseLayerSeed = seed + 80001L;

spaghetti3dSeed1 = seed + 80010L;
spaghetti3dSeed2 = seed + 80011L;
spaghetti3dRaritySeed = seed + 80012L;
spaghetti3dThicknessSeed = seed + 80013L;
spaghettiRoughnessSeed = seed + 80014L;
spaghettiRoughnessModSeed = seed + 80015L;

spaghetti2dModulatorSeed = seed + 80020L;
spaghetti2dElevationSeed = seed + 80021L;
spaghetti2dThicknessSeed = seed + 80022L;

entranceSeed = seed + 80030L;

noodleToggleSeed = seed + 80040L;
noodleRidgeASeed = seed + 80041L;
noodleRidgeBSeed = seed + 80042L;
noodleThicknessSeed = seed + 80043L;

pillarSeed = seed + 80050L;
pillarRarenessSeed = seed + 80051L;
pillarThicknessSeed = seed + 80052L;

// Cheese: многооктавный шум (ванилла использует 9 октав с firstOctave=-8)
// OctaveNoise(seed, octaves, scale, persistence, lacunarity)
// scale=256 соответствует firstOctave=-8 (1/256 = 2^-8)
cheeseNoise = new OctaveNoise(seed + 80000L, 6, 256.0, 0.75, 2.0);
```

### Новые константы:

```java
// ============================================================
// VANILLA-BASED CAVE SYSTEM PARAMETERS
// ============================================================

// --- Boundaries ---
private static final int CAVE_MIN_Y = -60;   // Ванилла: пещеры от y=-60
private static final int CAVE_MAX_Y = 128;
private static final int CAVE_SURFACE_MARGIN = 6;

// --- Cheese caves ---
// cave_layer: firstOctave=-8 → scale 0.0039
private static final double CHEESE_LAYER_SCALE = 0.0039;
// Hollowness offset (ванилла: 0.27)
private static final float CHEESE_OFFSET = 0.27f;

// --- Spaghetti 3D ---
private static final double SP3D_BASE_SCALE = 0.0078;  // firstOctave=-7
private static final double SP3D_RARITY_XZ = 0.000977;  // firstOctave=-11, xz=2.0
private static final double SP3D_RARITY_Y = 0.000488;
private static final double SP3D_THICKNESS_SCALE = 0.0039;  // firstOctave=-8
// Ванильные константы из entrances.json:
private static final float SP3D_THICKNESS_OFFSET = -0.0765f;
private static final float SP3D_THICKNESS_FACTOR = -0.0115f;

// --- Spaghetti roughness ---
private static final double ROUGHNESS_SCALE = 0.03125;  // firstOctave=-5
private static final double ROUGHNESS_MOD_SCALE = 0.0039;  // firstOctave=-8

// --- Spaghetti 2D ---
private static final double SP2D_BASE_SCALE = 0.0078;  // firstOctave=-7
private static final double SP2D_ELEVATION_SCALE = 0.0039;  // firstOctave=-8, y=0 (2D)
private static final double SP2D_MODULATOR_XZ = 0.000977;  // firstOctave=-11, xz=2.0
private static final double SP2D_MODULATOR_Y = 0.000488;
private static final double SP2D_THICKNESS_XZ = 0.000977;
private static final double SP2D_THICKNESS_Y = 0.000488;

// --- Entrances ---
private static final double ENTRANCE_XZ = 0.00586;  // firstOctave=-7, xz=0.75
private static final double ENTRANCE_Y = 0.0039;    // firstOctave=-7, y=0.5

// --- Noodle ---
private static final double NOODLE_TOGGLE_SCALE = 0.0039;  // firstOctave=-8
private static final double NOODLE_RIDGE_SCALE = 0.0208;   // firstOctave=-7, xz=2.667
private static final double NOODLE_THICKNESS_SCALE = 0.0039;  // firstOctave=-8

// --- Pillars ---
private static final double PILLAR_XZ = 0.195;    // firstOctave=-7, xz=25.0
private static final double PILLAR_Y = 0.00234;   // firstOctave=-7, y=0.3
private static final double PILLAR_RARE_SCALE = 0.0039;  // firstOctave=-8
private static final double PILLAR_THICK_SCALE = 0.0039; // firstOctave=-8
```

### Метод isCave() — полная замена:

```java
/**
 * Ванильная cave система через density functions.
 * Каждый компонент возвращает float density (negative = cave, positive = stone).
 * 
 * Формула: density = max(min(cheese, entrances, spaghetti, noodle), pillars)
 * isCave = density < 0
 */
public boolean isCave(int x, int y, int z, int surfaceHeight) {
    // === Быстрые проверки ===
    if (y > surfaceHeight - CAVE_SURFACE_MARGIN) return false;
    if (y < CAVE_MIN_Y) return false;
    if (y > CAVE_MAX_Y) return false;

    // === 1. CHEESE CAVES ===
    // Многооктавный 3D шум + горизонтальное слоение + surface fade
    
    // cave_layer: 2D шум создающий горизонтальные "этажи" пещер
    // square * 4 = всегда положительное, больше = меньше пещер
    // Там где layer ≈ 0, cave_layer_fade ≈ 0, пещеры свободно генерируются
    double caveLayer = OpenSimplex2S.noise2(cheeseLayerSeed, x * CHEESE_LAYER_SCALE, z * CHEESE_LAYER_SCALE);
    float caveLayerFade = (float)(4.0 * caveLayer * caveLayer);
    
    // Многооктавный cheese noise: [-1, 1] 
    double cheeseValue = cheeseNoise.sample3D(x, y, z);
    float cheeseClamped = Math.max(-1f, Math.min(1f, (float)cheeseValue));
    
    // Surface fade: у поверхности добавляем позитив (блокируем пещеры)
    int depth = surfaceHeight - y;
    float surfaceFade = 0f;
    if (depth < 40) {
        surfaceFade = 0.5f * (1f - depth / 40f);
    }
    
    // cheese density: отрицательное = пещера
    // Ванилла: caveLayerFade + (cheeseClamped + 0.27) + surfaceFade
    float cheeseDensity = caveLayerFade + cheeseClamped + CHEESE_OFFSET + surfaceFade;

    // === 2. SPAGHETTI 3D + ROUGHNESS (из entrances.json) ===
    
    // Rarity noise модулирует частоту spaghetti
    // type_1 mapper: rarity > 0 → scale * 0.75, rarity < 0 → scale * 2.0
    double rarity = OpenSimplex2S.noise3_ImproveXY(spaghetti3dRaritySeed,
            x * SP3D_RARITY_XZ, z * SP3D_RARITY_XZ, y * SP3D_RARITY_Y);
    double freqMult = rarity > 0 ? (0.75 + 0.25 * (1.0 - rarity)) : (2.0 + rarity * 1.25);
    // Плавная интерполяция: rarity=1 → 0.75, rarity=0 → 1.375, rarity=-1 → 2.0
    double sp3dScale = SP3D_BASE_SCALE * freqMult;
    
    // Два spaghetti 3D noise
    double sp3d1 = OpenSimplex2S.noise3_ImproveXY(spaghetti3dSeed1,
            x * sp3dScale, z * sp3dScale, y * sp3dScale);
    double sp3d2 = OpenSimplex2S.noise3_ImproveXY(spaghetti3dSeed2,
            x * sp3dScale, z * sp3dScale, y * sp3dScale);
    
    // max(sp1, sp2): пещера только где ОБА шума близки к нулю
    double sp3dMax = Math.max(sp3d1, sp3d2);
    
    // Thickness modulator
    double thicknessNoise = OpenSimplex2S.noise3_ImproveXY(spaghetti3dThicknessSeed,
            x * SP3D_THICKNESS_SCALE, z * SP3D_THICKNESS_SCALE, y * SP3D_THICKNESS_SCALE);
    float sp3dThickness = SP3D_THICKNESS_OFFSET + SP3D_THICKNESS_FACTOR * (float)thicknessNoise;
    // Vanilla range: ~ -0.088 to -0.065
    
    // Spaghetti 3D density = max(sp1, sp2) + thickness
    float sp3dDensity = Math.max(-1f, Math.min(1f, (float)sp3dMax + sp3dThickness));
    
    // Roughness: мелкий шум для шероховатости стен
    // Формула: (-0.05 + -0.05 * modulator) * (-0.4 + abs(roughness))
    double roughMod = OpenSimplex2S.noise3_ImproveXY(spaghettiRoughnessModSeed,
            x * ROUGHNESS_MOD_SCALE, z * ROUGHNESS_MOD_SCALE, y * ROUGHNESS_MOD_SCALE);
    double roughness = OpenSimplex2S.noise3_ImproveXY(spaghettiRoughnessSeed,
            x * ROUGHNESS_SCALE, z * ROUGHNESS_SCALE, y * ROUGHNESS_SCALE);
    float roughnessValue = (float)((-0.05 + -0.05 * roughMod) * (-0.4 + Math.abs(roughness)));
    
    // Spaghetti 3D с roughness
    float spaghetti3dWithRoughness = roughnessValue + sp3dDensity;

    // === 3. CAVE ENTRANCES ===
    // entrance = min(entrance_noise + y_gradient, spaghetti3d_with_roughness)
    // OctaveNoise аппроксимация (3 октавы в ванилле)
    double entranceNoise = OpenSimplex2S.noise3_ImproveXY(entranceSeed,
            x * ENTRANCE_XZ, z * ENTRANCE_XZ, y * ENTRANCE_Y);
    // y_gradient: 0.3 at y=-10, 0.0 at y=30 (ванилла)
    float yGradient;
    if (y < -10) yGradient = 0.3f;
    else if (y > 30) yGradient = 0.0f;
    else yGradient = 0.3f * (30f - y) / 40f;
    
    float entranceDensity = 0.37f + (float)entranceNoise + yGradient;
    // entrance использует spaghetti 3D форму, берёт минимум
    entranceDensity = Math.min(entranceDensity, spaghetti3dWithRoughness);

    // === 4. SPAGHETTI 2D (горизонтальные коридоры) ===
    
    // Modulator: модулирует частоту 2D spaghetti (аналог weird_scaled)
    double sp2dMod = OpenSimplex2S.noise3_ImproveXY(spaghetti2dModulatorSeed,
            x * SP2D_MODULATOR_XZ, z * SP2D_MODULATOR_XZ, y * SP2D_MODULATOR_Y);
    double sp2dFreqMult = sp2dMod > 0 ? (0.5 + 0.5 * (1.0 - sp2dMod)) : (3.0 + sp2dMod * 2.5);
    double sp2dScale = SP2D_BASE_SCALE * sp2dFreqMult;
    
    // 2D spaghetti shape (горизонтальный контур)
    double sp2dShape = OpenSimplex2S.noise3_ImproveXY(spaghetti2dModulatorSeed + 1L,
            x * sp2dScale, z * sp2dScale, y * sp2dScale);
    
    // Thickness modulator (ванилла: -0.95 + -0.35 * thickness_noise)
    double sp2dThickNoise = OpenSimplex2S.noise3_ImproveXY(spaghetti2dThicknessSeed,
            x * SP2D_THICKNESS_XZ, z * SP2D_THICKNESS_XZ, y * SP2D_THICKNESS_Y);
    float sp2dThickness = (float)(-0.95 + -0.35 * sp2dThickNoise);
    // Range: [-1.3, -0.6], always negative
    
    // Elevation: на какой Y-высоте проходит коридор (2D noise, y_scale=0)
    double sp2dElevation = OpenSimplex2S.noise2(spaghetti2dElevationSeed,
            x * SP2D_ELEVATION_SCALE, z * SP2D_ELEVATION_SCALE);
    // Ванилла: 8 * elevation_noise + y_gradient(8 at y=-64, -40 at y=320)
    float elevationOffset = 8f * (float)sp2dElevation;
    float elevationYGrad = 8f + (y + 64f) / 384f * -48f; // от 8 (y=-64) до -40 (y=320)
    float distFromCorridor = Math.abs(elevationOffset + elevationYGrad);
    
    // spaghetti 2D density = max(shape + thickness_contrib, cube(distFromCorridor + thickness))
    float sp2dDensity1 = (float)sp2dShape + 0.083f * sp2dThickness;
    float sp2dDensity2 = (distFromCorridor + sp2dThickness);
    sp2dDensity2 = sp2dDensity2 * sp2dDensity2 * sp2dDensity2; // cube
    float sp2dDensity = Math.max(sp2dDensity1, sp2dDensity2);
    sp2dDensity = Math.max(-1f, Math.min(1f, sp2dDensity));
    
    // Spaghetti 2D + roughness
    float spaghetti2dWithRoughness = sp2dDensity + roughnessValue;

    // === 5. NOODLE (тонкие связующие туннели) ===
    
    // Toggle: noodle_noise < 0 → нет noodle (density = 64, т.е. камень)
    double noodleToggle = OpenSimplex2S.noise3_ImproveXY(noodleToggleSeed,
            x * NOODLE_TOGGLE_SCALE, z * NOODLE_TOGGLE_SCALE, y * NOODLE_TOGGLE_SCALE);
    
    float noodleDensity = 64f; // по умолчанию = камень (нет noodle)
    if (noodleToggle >= 0 && y >= CAVE_MIN_Y && y < 320) {
        // Thickness: -0.075 + -0.025 * noise. Range: [-0.1, -0.05]
        double noodleThickNoise = OpenSimplex2S.noise3_ImproveXY(noodleThicknessSeed,
                x * NOODLE_THICKNESS_SCALE, z * NOODLE_THICKNESS_SCALE, y * NOODLE_THICKNESS_SCALE);
        float noodleThickness = (float)(-0.075 + -0.025 * noodleThickNoise);
        
        // Два ridge noise — пересечение для круглого сечения
        double ridgeA = OpenSimplex2S.noise3_ImproveXY(noodleRidgeASeed,
                x * NOODLE_RIDGE_SCALE, z * NOODLE_RIDGE_SCALE, y * NOODLE_RIDGE_SCALE);
        double ridgeB = OpenSimplex2S.noise3_ImproveXY(noodleRidgeBSeed,
                x * NOODLE_RIDGE_SCALE, z * NOODLE_RIDGE_SCALE, y * NOODLE_RIDGE_SCALE);
        
        // noodle = thickness + 1.5 * max(abs(ridgeA), abs(ridgeB))
        noodleDensity = noodleThickness + 1.5f * (float)Math.max(Math.abs(ridgeA), Math.abs(ridgeB));
    }

    // === 6. PILLARS (каменные столбы внутри cheese caves) ===
    // Формула: (2 * pillar_noise + (-1 + -1 * rareness)) * cube(0.55 + 0.55 * thickness)
    
    // pillar noise: очень высокий XZ (тонкие), очень низкий Y (высокие)
    // firstOctave=-7, 2 октавы — аппроксимируем двумя вызовами
    double pillarN1 = OpenSimplex2S.noise3_ImproveXY(pillarSeed,
            x * PILLAR_XZ, z * PILLAR_XZ, y * PILLAR_Y);
    double pillarN2 = OpenSimplex2S.noise3_ImproveXY(pillarSeed + 1L,
            x * PILLAR_XZ * 2, z * PILLAR_XZ * 2, y * PILLAR_Y * 2);
    double pillarNoise = (pillarN1 + pillarN2 * 0.5) / 1.5; // нормализованные 2 октавы
    
    // Rareness: где столбы появляются (крупный масштаб)
    double pillarRareness = OpenSimplex2S.noise3_ImproveXY(pillarRarenessSeed,
            x * PILLAR_RARE_SCALE, z * PILLAR_RARE_SCALE, y * PILLAR_RARE_SCALE);
    
    // Thickness: контролирует толщину, cube() даёт резкий falloff
    double pillarThickness = OpenSimplex2S.noise3_ImproveXY(pillarThicknessSeed,
            x * PILLAR_THICK_SCALE, z * PILLAR_THICK_SCALE, y * PILLAR_THICK_SCALE);
    double thickCubeInput = 0.55 + 0.55 * pillarThickness;
    double thickCube = thickCubeInput * thickCubeInput * thickCubeInput;
    
    // pillar density
    float pillarDensity = (float)((2.0 * pillarNoise + (-1.0 + -1.0 * pillarRareness)) * thickCube);

    // === СБОРКА: ванильная формула ===
    // underground = max(
    //   min(cheese, entrances, spaghetti_2d + roughness),
    //   pillars > 0.03 ? pillars : -1000000
    // )
    // final = min(underground, noodle)
    
    float caveDensity = Math.min(cheeseDensity, entranceDensity);
    caveDensity = Math.min(caveDensity, spaghetti2dWithRoughness);
    
    // Pillars: если pillar > 0.03, добавляем камень обратно
    float withPillars;
    if (pillarDensity > 0.03f) {
        withPillars = Math.max(caveDensity, pillarDensity);
    } else {
        withPillars = caveDensity;
    }
    
    // Noodle: отдельно в самом конце
    float finalDensity = Math.min(withPillars, noodleDensity);
    
    return finalDensity < 0;
}
```

### Удалить старый метод `isCave()` полностью.

## Файл: `BFMEChunkGenerator.java`

Без изменений в логике. Метод `isCave()` вызывается с той же сигнатурой `(int x, int y, int z, int surfaceHeight)`. `applyCarvers()` остаётся пустым. Секция лавы уже заменена на deepslate с cave check.

## Что НЕ трогать
- `OctaveNoise.java` — используем как есть
- `OpenSimplex2S.java` — используем как есть  
- `BFMEChunkGenerator.java` — вызов `isCave()` уже интегрирован
- Surface, snow, water, Voronoi, heightmap
- `applyCarvers()` — остаётся пустым

## Важные детали
- `OpenSimplex2S.noise3_ImproveXY(seed, x, z, y)` — порядок аргументов x, z, y (НЕ x, y, z)
- `OpenSimplex2S.noise2(seed, x, z)` — 2D шум
- `OctaveNoise.sample3D(x, y, z)` — порядок x, y, z (внутри класс сам переставляет для OpenSimplex2S)
- Пещеры = воздух. Никакой воды в пещерах.
- Cheese noise использует OctaveNoise для многооктавности (6 октав). Все остальные шумы — одиночные вызовы OpenSimplex2S.
- OctaveNoise конструктор: `new OctaveNoise(seed, octaves, scale, persistence, lacunarity)`
  - scale=256 соответствует ванильному firstOctave=-8 (x / 256 = x * 2^-8)
  - persistence=0.75 и lacunarity=2.0 аппроксимируют ванильные амплитуды cheese
