package net.sima.bfme.mixin;

import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.sima.bfme.worldgen.chunkgen.BFMEChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.atomic.AtomicLong;

/**
 * DIAG: таймер ВАНИЛЬНОЙ генерации для сравнения с BFME GenProfiler.
 *
 * <p>Таргетит {@code NoiseBasedChunkGenerator.doFill} — синхронную работу генерации
 * (fillFromNoise async через supplyAsync, мерить надо doFill). Это аналог нашего
 * полного fillFromNoise = full-chunk время. Печатает avg мс/чанк каждые 200 чанков.</p>
 *
 * <p>Чтобы сравнить: полетай в ВАНИЛЬНОМ овервулде → смотри [VANILLA GEN], потом в BFME →
 * смотри BFME GEN PROFILE (full chunk). Одна метрика — синхронная работа на чанк.</p>
 */
@Mixin(NoiseBasedChunkGenerator.class)
public class VanillaGenTimingMixin {

    private static final ThreadLocal<Long> bfme$start = new ThreadLocal<>();
    private static final AtomicLong bfme$totalNs = new AtomicLong();
    private static final AtomicLong bfme$count = new AtomicLong();

    @Inject(method = "doFill", at = @At("HEAD"))
    private void bfme$doFillStart(Blender blender, StructureManager structureManager, RandomState random,
                                  ChunkAccess chunk, int minCellY, int cellCountY,
                                  CallbackInfoReturnable<ChunkAccess> cir) {
        if (!BFMEChunkGenerator.PROFILE_GEN) return;   // гейт: молчит при выключенном профилировании
        bfme$start.set(System.nanoTime());
    }

    @Inject(method = "doFill", at = @At("RETURN"))
    private void bfme$doFillEnd(Blender blender, StructureManager structureManager, RandomState random,
                                ChunkAccess chunk, int minCellY, int cellCountY,
                                CallbackInfoReturnable<ChunkAccess> cir) {
        if (!BFMEChunkGenerator.PROFILE_GEN) return;
        Long s = bfme$start.get();
        if (s == null) return;
        long ns = System.nanoTime() - s;
        long total = bfme$totalNs.addAndGet(ns);
        long n = bfme$count.incrementAndGet();
        if (n % 200 == 0) {
            System.out.printf("[VANILLA GEN] %d chunks | avg %.3f ms/chunk%n", n, total / 1e6 / n);
        }
    }
}
