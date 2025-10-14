package net.sima.bfme.worldgen.map;

import net.sima.bfme.util.FileUtils;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomesData;
import org.joml.Vector2i;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class BFMEMapRegion {
    public final static int CALC_REGION_SIZE = BFMEMapConfigs.REGION_SIZE * BFMEMapConfigs.PIXEL_WEIGHT;
    public final Vector2i coordinate;
    private final BufferedImage biomeImage;
    private final BufferedImage heightImage;
    public BFMEMapRegion(Vector2i coordinate) {
        this.coordinate = coordinate;

        String biomePath = BFMEMapConfigs.BIOME_PATH.formatted(BFMEMapConfigs.MAP_ITERATION)
                + BFMEMapConfigs.IMAGE_NAME.formatted(coordinate.x, coordinate.y);
        String heightPath = BFMEMapConfigs.HEIGHT_PATH
                + BFMEMapConfigs.IMAGE_NAME.formatted(coordinate.x, coordinate.y);

        LoggerUtil.getInstance().logDebugMsg("Loading biome image: " + biomePath);
        biomeImage = FileUtils.getInstance().getRunImage(biomePath);

        if (biomeImage == null) {
            LoggerUtil.getInstance().logError("Biome image missing: " + biomePath);
        }

        LoggerUtil.getInstance().logDebugMsg("Loading height image: " + heightPath);
        heightImage = FileUtils.getInstance().getRunImage(heightPath);

        if (heightImage == null) {
            LoggerUtil.getInstance().logError("Height image missing: " + heightPath);
        }
    }

    public BFMEBiome getBiome(Vector2i imageCoordinates) {
        if (biomeImage != null) {
            int color = biomeImage.getRGB(imageCoordinates.x, imageCoordinates.y);
            BFMEBiome biome = BFMEBiomesData.getBiomeByColor(color);
            return biome;
        }
        LoggerUtil.getInstance().logError("Biome image is null for region: [%d, %d]".formatted(coordinate.x, coordinate.y));
        return BFMEBiomesData.defaultBiome;
    }


    public Color getHeightColor(Vector2i imageCoordinates) {
        if(heightImage != null){
            return new Color(heightImage.getRGB(imageCoordinates.x, imageCoordinates.y));
        }
        return new Color(Math.abs(BFMEBiomesData.defaultBiome.height), 1, 0);
    }

    public boolean isInRange(Vector2i playerCoord) {
        int middleCoordinateX = CALC_REGION_SIZE * (coordinate.x + 1) - CALC_REGION_SIZE / 2;
        int middleCoordinateZ = CALC_REGION_SIZE * (coordinate.y + 1) - CALC_REGION_SIZE / 2;
        double distance = calculateDistance(playerCoord.x, playerCoord.y, middleCoordinateX, middleCoordinateZ);
        //LoggerUtil.getInstance().logDebugMsg("IsInRange : [%s,%s] = [%s]".formatted(coordinate.x, coordinate.y, distance));
        return distance < (CALC_REGION_SIZE / 2) + BFMEMapConfigs.BIOME_VALIDATION_DIST_CHECK;
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        return Point2D.distance(x1, y1, x2, y2);
    }
    public BufferedImage getBiomeImage() {
        return this.biomeImage;
    }

}