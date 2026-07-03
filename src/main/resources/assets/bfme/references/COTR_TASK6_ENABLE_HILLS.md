# ЗАДАЧА 6: Включить холмы и подготовить к тестированию

## Контекст

Эта задача выполняется ПОСЛЕ задач 1-5 из COTR_REFACTORING_PROMPT_v2.md. К этому моменту:
- Legacy V11 удалён (задача 1)
- 12 шумов (4 типа × 3 масштаба) + перегрузки OctaveNoise + 12 весов в профиле (задача 2)
- baseHeight из профиля + Voronoi blend без стенки (задача 3)
- MountainGroup удалён, динамический список горных биомов (задача 4)
- Кеши с частичной очисткой (задача 5)

## Что сделать

### В BFMEHeightMapV11.java:

1. Изменить `DISABLE_HILLS = false`
2. `DISABLE_EROSION` оставить `true`

### Проверить что calculateHills корректно работает:

- Принимает `VoronoiHeightResult` как параметр (из задачи 3), НЕ вызывает `voronoiLayer.getHeightWithOwner()` повторно
- Собирает 12 весов из `params[P_NOISE_WEIGHTS_START + 0..11]`
- Читает `lacunarity` из `params[P_NOISE_LACUNARITY]` и `persistence` из `params[P_NOISE_PERSISTENCE]`
- Вызывает `noise.getMultiScaleTerrain(x, z, noiseWeights, warpStrength, lacunarity, persistence)` вместо старого `getBlendedTerrain`
- Не содержит V11 legacy ветку (`else` с getOrComputeNoise)
- `applyCurveAndBias` применяется к результату если `heightCurve != 1.0` или `heightBias != 0`
- Результат масштабируется: `delta = delta * 60.0 * reliefScale`

### BiomeProfileRegistry:

- Все текущие вызовы `blendWeights(4 аргумента)` работают без изменений — shorthand с автораспределением 60/30/10
- Не менять существующие профили биомов — только убедиться что компилируется и запускается
