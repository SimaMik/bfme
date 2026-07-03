package net.sima.bfme.worldgen.chunkgen;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Лёгкий профайлер генерации чанков (ручная инструментация, ТОЛЬКО per-stage).
 *
 * Включается через {@link BFMEChunkGenerator#PROFILE_GEN}. Потокобезопасен:
 * AtomicLong на этап + ConcurrentHashMap на биом. Per-block счётчики/тайминги УБРАНЫ
 * (давали observer effect ~370k атомарных операций/чанк) — мерим чистые per-stage числа.
 *
 * Каждые {@link #REPORT_EVERY} чанков печатает разбивку этапов + per-biome в System.out.
 */
public final class GenProfiler {

    private GenProfiler() {}

    public static final String[] STAGE_NAMES = {
            "heightmap", "cave-setup", "cave-fill", "cave-erosion", "column(surface)"
    };
    public static final int HEIGHTMAP = 0, CAVE_SETUP = 1, CAVE_FILL = 2, CAVE_EROSION = 3, COLUMN = 4;
    private static final int N_STAGES = STAGE_NAMES.length;

    private static final int REPORT_EVERY = 200;

    private static final AtomicLong[] stageNs = new AtomicLong[N_STAGES];
    static { for (int i = 0; i < N_STAGES; i++) stageNs[i] = new AtomicLong(); }
    private static final AtomicLong chunkCount = new AtomicLong();
    private static final AtomicLong totalChunkNs = new AtomicLong();

    /** Per-biome {totalNs, count} по ключу биома центра чанка. */
    private static final ConcurrentHashMap<String, long[]> perBiome = new ConcurrentHashMap<>();

    public static void recordStage(int stage, long ns) {
        stageNs[stage].addAndGet(ns);
    }

    public static void chunkDone(String biomeKey, long totalNs) {
        totalChunkNs.addAndGet(totalNs);
        long[] bucket = perBiome.computeIfAbsent(biomeKey, k -> new long[2]);
        synchronized (bucket) { bucket[0] += totalNs; bucket[1]++; }

        long n = chunkCount.incrementAndGet();
        if (n % REPORT_EVERY == 0) report(n);
    }

    private static synchronized void report(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== BFME GEN PROFILE (").append(n).append(" chunks) ==========\n");

        double totalMs = totalChunkNs.get() / 1e6;
        double avgChunkMs = totalMs / n;
        sb.append(String.format("Avg full chunk: %.3f ms  →  ~%.0f chunks/sec/thread%n",
                avgChunkMs, 1000.0 / avgChunkMs));

        sb.append("--- Per-stage (avg ms/chunk, %% of chunk) ---\n");
        double stageSum = 0;
        for (int i = 0; i < N_STAGES; i++) stageSum += stageNs[i].get();
        for (int i = 0; i < N_STAGES; i++) {
            double ms = stageNs[i].get() / 1e6 / n;
            double pct = stageSum > 0 ? 100.0 * stageNs[i].get() / stageSum : 0;
            sb.append(String.format("  %-16s %.4f ms  (%.1f%%)%n", STAGE_NAMES[i], ms, pct));
        }

        sb.append("--- Per-biome (center biome, avg full chunk ms) ---\n");
        perBiome.forEach((biome, bucket) -> {
            long tot, cnt;
            synchronized (bucket) { tot = bucket[0]; cnt = bucket[1]; }
            sb.append(String.format("  %-40s %.3f ms  (n=%d)%n", biome, tot / 1e6 / cnt, cnt));
        });
        sb.append("==================================================\n");
        System.out.print(sb);
    }

    public static void reset() {
        for (AtomicLong a : stageNs) a.set(0);
        chunkCount.set(0);
        totalChunkNs.set(0);
        perBiome.clear();
    }
}
