package net.sima.bfme.worldgen.map;

import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomesData;
import org.joml.Vector2i;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BFMEMapRuntime {
    private static BFMEMapRuntime single_instance = null;
    HashMap<Vector2i, BFMEMapRegion> regions;
    HashMap<UUID, Vector2i> regionByUuids;
    private LoggerUtil loggerUtil;
    private BFMEMapUtils bfmeMapUtils;

    private int latestValidationTick = 0;
    private int currentValidationBlockCount = 0;

    // Кэш биомов для быстрого доступа (ключ = packed coords)
    private final ConcurrentHashMap<Long, BFMEBiome> biomeCache = new ConcurrentHashMap<>();
    private static final int BIOME_CACHE_MAX_SIZE = 500000;

    public static synchronized BFMEMapRuntime getInstance()
    {
        if (single_instance == null)
            single_instance = new BFMEMapRuntime();

        return single_instance;
    }

    public BFMEMapRuntime() {
        regions = new HashMap<>();
        regionByUuids = new HashMap<>();

        loggerUtil = LoggerUtil.getInstance();
        bfmeMapUtils = BFMEMapUtils.getInstance();
    }

    public BFMEBiome getBiome(int posX, int posZ) {
        // Проверяем кэш сначала
        long cacheKey = ((long) posX << 32) | (posZ & 0xFFFFFFFFL);
        BFMEBiome cached = biomeCache.get(cacheKey);
        if (cached != null) {
            return cached;
        }

        // Вычисляем биом
        BFMEBiome result;
        if (!bfmeMapUtils.isWorldCoordinateInBorder(posX, posZ)) {
            result = BFMEBiomesData.defaultBiome;
        } else {
            BFMEMapRegion region = getRegionToUseNoValidation(bfmeMapUtils.getRegionByWorldCoordinate(posX, posZ));
            if (region == null) {
                result = BFMEBiomesData.defaultBiome;
            } else {
                result = region.getBiome(getImageCoordinates(posX, posZ));
            }
        }

        // Кэшируем
        if (biomeCache.size() >= BIOME_CACHE_MAX_SIZE) {
            biomeCache.clear();
        }
        biomeCache.put(cacheKey, result);

        return result;
    }

    // Версия без purgeRegions для быстрого доступа во время генерации
    private BFMEMapRegion getRegionToUseNoValidation(Vector2i regionCoordinate) {
        BFMEMapRegion region = regions.get(regionCoordinate);
        if (region != null) {
            return region;
        }

        // Создаём и кладём в map
        BFMEMapRegion newRegion = new BFMEMapRegion(regionCoordinate);
        regions.put(regionCoordinate, newRegion);

        return newRegion;
    }

    private Vector2i getImageCoordinates(int posX, int posZ){
        return new Vector2i(
                (int)((float)posX / BFMEMapConfigs.PIXEL_WEIGHT % BFMEMapConfigs.REGION_SIZE),
                (int)((float)posZ / BFMEMapConfigs.PIXEL_WEIGHT % BFMEMapConfigs.REGION_SIZE)
        );
    }

    private BFMEMapRegion getRegionToUse(Vector2i regionCoordinate) {

        purgeRegions(); // Очистка регионов

        BFMEMapRegion region = regions.get(regionCoordinate);
        if (region != null) {
            return region;
        }

        // Создаём и кладём в map
        BFMEMapRegion newRegion = new BFMEMapRegion(regionCoordinate);
        regions.put(regionCoordinate, newRegion);

        return newRegion;
    }


    private void purgeRegions() {
        // Block delay
        currentValidationBlockCount ++;
        if(currentValidationBlockCount < BFMEMapConfigs.BIOME_VALIDATION_BLOCK_DELAY) return;
        currentValidationBlockCount = 0;

        // Tick delay
        int serverTick = bfmeMapUtils.getTick();
        if(serverTick - latestValidationTick < BFMEMapConfigs.BIOME_VALIDATION_TICK_DELAY) return;
        latestValidationTick = serverTick;

        // Create purge array
        List<Vector2i> toPurge = new ArrayList<>();
        List<Vector2i> playerCoordinates = new ArrayList<>();
        for(ServerPlayer player : bfmeMapUtils.getPlayers()){
            playerCoordinates.add(new Vector2i(player.getBlockX(), player.getBlockZ()));
        }

        try{
            bfmeMapUtils.getPlayers();
            regions.forEach((key, value) -> {
                boolean hasPlayerInRange = false;
                for(Vector2i coordinate : playerCoordinates){
                    if(value.isInRange(coordinate)){
                        hasPlayerInRange = true;
                        break;
                    }
                }
                if(!hasPlayerInRange)
                    toPurge.add(key);
            });

            // Purging
            //loggerUtil.logDebugMsg("Purging [%s] regions (tick : %s)".formatted(toPurge.size(), serverTick));
            for (Vector2i region : toPurge){
                regions.remove(region);
            }
        } catch(Exception exception){
            loggerUtil.logError("%s : %s".formatted(toString(), exception.getMessage()));
        }
    }
}

