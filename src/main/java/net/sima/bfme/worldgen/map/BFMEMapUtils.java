package net.sima.bfme.worldgen.map;

import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.sima.bfme.util.FileUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.sima.bfme.util.LoggerUtil;
import org.joml.Vector2i;

import java.awt.image.BufferedImage;
import java.util.List;

public class BFMEMapUtils {
    private static BFMEMapUtils single_instance = null;

    private final float ratioX;
    private final float ratioZ;
    private final int maxImageCoordinateX;
    private final int maxImageCoordinateZ;

    private MinecraftServer server;

    public static synchronized BFMEMapUtils getInstance() {
        if (single_instance == null) {
            single_instance = new BFMEMapUtils();
        }
        return single_instance;
    }

    private BFMEMapUtils() {
        BufferedImage initial = FileUtils.getInstance().getResourceImage(BFMEMapConfigs.INITIAL_IMAGE);

        ratioX = (float) (BFMEMapConfigs.REGION_SIZE / initial.getWidth() * Math.pow(2, BFMEMapConfigs.MAP_ITERATION) * BFMEMapConfigs.PIXEL_WEIGHT);
        ratioZ = (float) (BFMEMapConfigs.REGION_SIZE / initial.getHeight() * Math.pow(2, BFMEMapConfigs.MAP_ITERATION) * BFMEMapConfigs.PIXEL_WEIGHT);
        maxImageCoordinateX = (int) (initial.getWidth() * ratioX);
        maxImageCoordinateZ = (int) (initial.getHeight() * ratioZ);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        this.server = event.getServer();
    }

    public List<ServerPlayer> getPlayers() {
        if (server == null) return List.of();
        return server.getPlayerList().getPlayers();
    }

    public int getTick() {
        if (server == null) return 1;
        return server.getTickCount();
    }

    public Vector2i getWorldCoordinateFromInitialMap(int x, int z) {
        return new Vector2i((int) (x * ratioX), (int) (z * ratioZ));
    }
    public Vector2i getRegionByWorldCoordinate(int x, int z) {
        // Возвращаем null для отрицательных координат
        if (x < 0 || z < 0) return null;

        x /= BFMEMapConfigs.PIXEL_WEIGHT;
        z /= BFMEMapConfigs.PIXEL_WEIGHT;

        Vector2i region = new Vector2i(
                x / BFMEMapConfigs.REGION_SIZE,
                z / BFMEMapConfigs.REGION_SIZE
        );

        return region;
    }


    public boolean isWorldCoordinateInBorder(int x, int z) {
        // Отбрасываем отрицательные координаты
        if (x < 0 || z < 0) {
            return false;
        }
        return x < maxImageCoordinateX && z < maxImageCoordinateZ;
    }

    public MinecraftServer getServer() {
        return server;
    }
}
