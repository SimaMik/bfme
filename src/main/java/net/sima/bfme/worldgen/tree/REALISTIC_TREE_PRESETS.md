# BFME realistic tree placer presets

These are constructor presets. Use them inside your configured feature registration.

Important:
- `RootedBranchingTrunkPlacer` places visible surface roots using the same trunk provider as the trunk.
- If your trunk provider is `*_log`, roots are horizontal logs.
- For true `*_wood` roots with bark on every side, you need a separate custom tree config with `rootProvider` later.
- Keep your old `StraightFoliagePlacer` only for old configured features. New trees should use these formula-based placers.

---

## 1. Pine / сосна

Real shape: tall, narrow, mostly straight, branches start high, crown is conical and not too wide.

```java
new RootedBranchingTrunkPlacer(
        13, 5, 3,
        0, 1,
        2, 4,
        45,
        70,
        30,
        100,
        3, 5,
        3,
        30,
        10,
        15
)
```

```java
new LayeredConiferFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        10,
        3,
        0,
        1,
        2,
        78,
        38,
        1,
        15
)
```

---

## 2. Fir / spruce / пихта / ель

Real shape: darker, denser, more triangular than pine, lower branches wider.

```java
new RootedBranchingTrunkPlacer(
        11, 4, 3,
        0, 1,
        2, 4,
        35,
        62,
        20,
        100,
        3, 5,
        3,
        35,
        8,
        18
)
```

```java
new LayeredConiferFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        12,
        4,
        0,
        1,
        1,
        86,
        28,
        0,
        10
)
```

---

## 3. Cypress / кипарис

Real shape: very narrow vertical column.

```java
new RootedBranchingTrunkPlacer(
        10, 5, 2,
        0, 0,
        1, 2,
        15,
        80,
        0,
        100,
        2, 4,
        2,
        15,
        0,
        8
)
```

```java
new LayeredConiferFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        11,
        2,
        1,
        0,
        1,
        92,
        18,
        0,
        5
)
```

---

## 4. Birch / Aspen / берёза / осина

Real shape: tall light tree, not massive, upper branches spread out, crown is airy and uneven.

```java
new RootedBranchingTrunkPlacer(
        9, 4, 2,
        2, 4,
        3, 6,
        80,
        55,
        75,
        80,
        2, 4,
        2,
        25,
        8,
        8
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        3, 3, 3,
        1,
        72,
        45,
        3,
        70,
        0,
        0
)
```

---

## 5. Beech / chestnut / бук / каштан

Real shape: tall deciduous tree with broad but calmer crown than oak.

```java
new RootedBranchingTrunkPlacer(
        10, 4, 3,
        4, 7,
        3, 6,
        70,
        45,
        65,
        85,
        4, 7,
        3,
        35,
        15,
        18
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        4, 3, 4,
        1,
        86,
        28,
        3,
        55,
        0,
        0
)
```

---

## 6. Oak / Green Oak / Mirk Oak / дуб / старый лес

Real shape: heavy trunk, visible roots, wide crown, many large branches.

```java
new RootedBranchingTrunkPlacer(
        8, 4, 3,
        6, 10,
        4, 8,
        130,
        35,
        45,
        70,
        6, 10,
        4,
        60,
        35,
        45
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        5, 3, 5,
        2,
        88,
        22,
        4,
        75,
        0,
        0
)
```

---

## 7. Willow / ива

Real shape: curved trunk, crown not too high, many hanging leaves.

```java
new RootedBranchingTrunkPlacer(
        7, 3, 2,
        4, 7,
        4, 7,
        150,
        45,
        20,
        75,
        4, 7,
        3,
        45,
        20,
        25
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        4, 3, 4,
        1,
        82,
        30,
        3,
        65,
        75,
        5
)
```

---

## 8. Olive / Harad acacia-like / олива / акациеподобное дерево

Real shape: lower, crooked, strong sideways branches, flat wide crown.

```java
new RootedBranchingTrunkPlacer(
        5, 2, 1,
        2, 4,
        4, 7,
        260,
        45,
        10,
        35,
        4, 7,
        4,
        55,
        30,
        35
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        5, 1, 5,
        1,
        84,
        40,
        2,
        85,
        0,
        0
)
```

---

## 9. Lebethron / noble Gondor tree

Fantasy-realistic: tall, elegant, not too chaotic, visible roots, high oval crowns.

```java
new RootedBranchingTrunkPlacer(
        10, 4, 2,
        4, 7,
        3, 6,
        65,
        58,
        90,
        85,
        4, 6,
        3,
        30,
        15,
        18
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        3, 4, 3,
        1,
        88,
        28,
        3,
        55,
        0,
        0
)
```

---

## 10. Mallorn / elven golden tree

Fantasy-realistic: tall, graceful, larger crown, smoother than Fangorn trees.

```java
new RootedBranchingTrunkPlacer(
        12, 4, 3,
        5, 8,
        4, 7,
        75,
        52,
        85,
        90,
        4, 7,
        4,
        40,
        18,
        24
)
```

```java
new OvalClusterFoliagePlacer(
        ConstantInt.of(0), ConstantInt.of(0),
        5, 4, 5,
        1,
        90,
        22,
        4,
        65,
        0,
        0
)
```
