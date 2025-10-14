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
        if(!bfmeMapUtils.isWorldCoordinateInBorder(posX, posZ)) return BFMEBiomesData.defaultBiome;

        BFMEMapRegion region = getRegionToUse(bfmeMapUtils.getRegionByWorldCoordinate(posX, posZ));
        if(region == null) return BFMEBiomesData.defaultBiome;

        return region.getBiome(getImageCoordinates(posX, posZ));
    }

    public Color getHeight(int posX, int posZ) {
        if(!bfmeMapUtils.isWorldCoordinateInBorder(posX, posZ)) return null;

        BFMEMapRegion region = getRegionToUse(bfmeMapUtils.getRegionByWorldCoordinate(posX, posZ));
        if(region == null) return null;

        return region.getHeightColor(getImageCoordinates(posX, posZ));
    }

    private Vector2i getImageCoordinates(int posX, int posZ){
        return new Vector2i(
                (int)((float)posX / BFMEMapConfigs.PIXEL_WEIGHT % BFMEMapConfigs.REGION_SIZE),
                (int)((float)posZ / BFMEMapConfigs.PIXEL_WEIGHT % BFMEMapConfigs.REGION_SIZE)
        );
    }

    private BFMEMapRegion getRegionToUse(Vector2i regionCoordinate) {

        purgeRegions(); // Очистка регионов

        if (regions.containsKey(regionCoordinate)) {
            return regions.get(regionCoordinate);
        }

        return regions.put(regionCoordinate, new BFMEMapRegion(regionCoordinate));
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

