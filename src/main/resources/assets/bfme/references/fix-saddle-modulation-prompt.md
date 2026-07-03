# Fix: артефактный гребень на стыке Voronoi гор — Noise-Modulated Saddle

## Контекст

Пайплайн: VoronoiMountainLayer (горы) → smoothMaxHeight (слияние) → FlowErosion (глобальная эрозия).

На стыке двух гор smoothMaxHeight создаёт гребень — линию пересечения двух конусов. FlowErosion не может его срезать, потому что на гребне slope ≈ 0 (локальный максимум по перпендикулярному направлению). Все попытки убрать гребень постфактум (depression, изотропная эрозия, weighted blend) создавали артефакты — ямки, полки, торчащие ridge connections.

## Решение: Saddle Modulation

Вместо ровного понижения — noise-модуляция стыка. Гребень становится неровным: чередуются перевалы (ниже) и бугры (выше), как настоящий горный хребет. Noise ломает монотонность → нет полок и ямок.

Применяется ПОСЛЕ smoothMax цикла по ячейкам, но ПЕРЕД ridge connections. Ridge connections добавляются поверх через smoothMax и работают корректно — если хребет выше седловины, он виден; если ниже — smoothMax берёт седловину.

## Что менять

Файл: `VoronoiMountainLayer.java`
Метод: `getHeightForGroupWithOwner()`

### Вставить блок Saddle Modulation

Место: ПОСЛЕ строки `float finalHeight = mountainHeight;` (строка ~313) и ПЕРЕД блоком ridge connections (строка ~323, `if (ownerProfile != null && ownerProfile.isRidgeConnectionsEnabled())`).

Сейчас между ними стоит закомментированный блок "ПОНИЖЕНИЕ НА СТЫКЕ — ОТКЛЮЧЕНО". Заменить его на:

```java
// === SADDLE MODULATION: разбиваем гребень на стыке в естественные перевалы ===
if (secondH > 1f && maxH > 1f) {
    float overlap = secondH / maxH; // 0..1, насколько равны две горы
    if (overlap > 0.2f) {
        // Плавное нарастание эффекта
        float saddleT = (overlap - 0.2f) / 0.6f;
        saddleT = Math.min(1.0f, saddleT);
        saddleT = saddleT * saddleT * (3f - 2f * saddleT); // smoothstep

        // Low-frequency noise: делает гребень неровным
        // Масштаб 0.014 ≈ один перевал на ~70 блоков
        float ridgeNoise = (float) OpenSimplex2S.noise2(
            worldSeed + 777777L, worldX * 0.014, worldZ * 0.014);

        // Базовое понижение 8% ± шум 7%
        // Итого от 1% до 15% высоты в разных точках вдоль стыка
        float saddleDepth = 0.08f + ridgeNoise * 0.07f;
        saddleDepth = Math.max(0.01f, saddleDepth);

        float depression = finalHeight * saddleDepth * saddleT;
        finalHeight -= depression;
        if (finalHeight < 0) finalHeight = 0;
    }
}
```

Переменные `maxH`, `secondH`, `worldX`, `worldZ`, `worldSeed` уже доступны в этом методе. `OpenSimplex2S` уже импортирован.

### Убрать старый закомментированный блок

Удалить комментарий:
```java
// === ПОНИЖЕНИЕ НА СТЫКЕ — ОТКЛЮЧЕНО ===
// Создавало странную форму с "полками"
```

Он заменяется новым блоком.

## Больше ничего не менять

FlowErosion, BFMEHeightMapV11, ridge connections, junctionFactor — всё остаётся как есть. Одно изменение в одном методе.

## Параметры для тюнинга

| Параметр | Значение | Что крутить |
|---|---|---|
| `0.014` | масштаб шума | Меньше = реже перевалы, крупнее. Больше = чаще, мельче |
| `0.08f` | базовое понижение | Средняя глубина перевалов (% от высоты) |
| `0.07f` | амплитуда шума | Разброс: 0.08±0.07 = от 1% до 15% |
| `0.2f` | порог overlap | Когда начинается эффект (ниже = раньше) |
| `777777L` | seed шума | Любое число, лишь бы отличалось от других шумов |
