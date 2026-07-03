# Install notes

Copy these files into your project:

```text
src/main/java/net/sima/bfme/worldgen/tree/custom/RootedBranchingTrunkPlacer.java
src/main/java/net/sima/bfme/worldgen/tree/custom/OvalClusterFoliagePlacer.java
src/main/java/net/sima/bfme/worldgen/tree/custom/LayeredConiferFoliagePlacer.java
```

Then merge these registrations into your existing classes:

```text
src/main/java/net/sima/bfme/worldgen/tree/ModTrunkPlacerTypes.java
src/main/java/net/sima/bfme/worldgen/tree/ModFoliagePlacerTypes.java
```

In your main mod constructor, register both registries on the mod event bus:

```java
ModTrunkPlacerTypes.register(modEventBus);
ModFoliagePlacerTypes.register(modEventBus);
```

If you already have `ModFoliagePlacerTypes`, do not overwrite blindly. Add only:

```java
OVAL_CLUSTER_FOLIAGE_PLACER
LAYERED_CONIFER_FOLIAGE_PLACER
```

and keep your old:

```java
STRAIGHT_FOLIAGE_PLACER
```

The included `StraightFoliagePlacer.java` is just your existing file copied into the archive so the folder is complete.
