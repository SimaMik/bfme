package net.sima.bfme.worldgen.map;

import net.sima.bfme.util.FileType;
import net.sima.bfme.util.FileUtils;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiome;
import net.sima.bfme.worldgen.chunkgen.map.ImageUtils;
import net.sima.bfme.util.LoggerUtil;
import net.sima.bfme.worldgen.biomes.surface.BFMEBiomesData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class BFMEMapGeneration {
    private FileUtils fileUtils;
    private LoggerUtil loggerUtil;
    private static final int WATER_BUFFER = 28;
    private static final float WATER_HEIGHT_MULTIPLIER = 1.0f;

    public BFMEMapGeneration() throws Exception {
        fileUtils = FileUtils.getInstance();
        loggerUtil = LoggerUtil.getInstance(); // Инициализация

        generate();
    }

    public void generate() throws Exception {
        loggerUtil.logInfoMsg("================ BFMEMapGeneration START ================");

        BufferedImage initialMap = getInitialImage();

        if (initialMap == null) {
            throw new Exception("The image of the map in resource has created an error and operation cannot continue.");
        }

        loggerUtil.logInfoMsg("Validating BIOME generation availability;");

        int iterationToGenerate = (BFMEMapConfigs.FORCE_GENERATION)
                ? BFMEMapConfigs.MAP_ITERATION + 1
                : findAmountOfIterationToGenerate(initialMap);

        loggerUtil.logInfoMsg("Iterations to generate: " + iterationToGenerate);

        if (iterationToGenerate > 0) {
            loggerUtil.logInfoMsg("Begin BIOME generation;");
            generateBiomes(initialMap, iterationToGenerate);
        }

        loggerUtil.logInfoMsg("Validating HEIGHT generation availability;");
        if (!validateHeightDatas(initialMap)) {
            loggerUtil.logInfoMsg("Begin HEIGHT generation;");
            generateHeight(initialMap);
        }
        exportUniqueColors("colors.txt", 7000, 7000);

        loggerUtil.logInfoMsg("================ BFMEMapGeneration COMPLETE ================");
    }

    private BufferedImage getInitialImage() {
        loggerUtil.logInfoMsg("Validating ORIGINAL image existence;");
        BufferedImage initialImage = fileUtils.getResourceImage(BFMEMapConfigs.INITIAL_IMAGE);

        if (initialImage == null) {
            loggerUtil.logError("Initial map image couldn't be found! Path: " + BFMEMapConfigs.INITIAL_IMAGE);
            return null;
        }

        loggerUtil.logInfoMsg("Loaded initial image: Width = " + initialImage.getWidth() + ", Height = " + initialImage.getHeight());

        if (initialImage.getWidth() % BFMEMapConfigs.REGION_SIZE != 0 ||
                initialImage.getHeight() % BFMEMapConfigs.REGION_SIZE != 0) {
            loggerUtil.logError("Initial map image has the wrong size! Ensure it is divisible by REGION_SIZE.");
            return null;
        }

        return initialImage;
    }
    public void exportUniqueColors(String outputFilePath, int posX, int posZ) {
        try {
            // Рассчитываем региональные координаты
            int regionX = posX / (BFMEMapConfigs.REGION_SIZE * BFMEMapConfigs.PIXEL_WEIGHT);
            int regionZ = posZ / (BFMEMapConfigs.REGION_SIZE * BFMEMapConfigs.PIXEL_WEIGHT);

            // Загружаем изображение региона
            String regionPath = BFMEMapConfigs.BIOME_PATH.formatted(BFMEMapConfigs.MAP_ITERATION)
                    + BFMEMapConfigs.IMAGE_NAME.formatted(regionX, regionZ);

            LoggerUtil.getInstance().logDebugMsg("Loading region image: " + regionPath);
            BufferedImage regionImage = FileUtils.getInstance().getRunImage(regionPath);

            if (regionImage == null) {
                throw new Exception("Не удалось загрузить изображение региона: " + regionPath);
            }

            // Рассчитываем пиксельные координаты внутри региона
            int pixelX = (posX / BFMEMapConfigs.PIXEL_WEIGHT) % BFMEMapConfigs.REGION_SIZE;
            int pixelZ = (posZ / BFMEMapConfigs.PIXEL_WEIGHT) % BFMEMapConfigs.REGION_SIZE;

            // Получаем цвет пикселя
            int colorAtPosition = regionImage.getRGB(pixelX, pixelZ);
            int r = (colorAtPosition >> 16) & 0xFF;
            int g = (colorAtPosition >> 8) & 0xFF;
            int b = colorAtPosition & 0xFF;

            // Получаем биом по цвету
            BFMEBiome biome = BFMEBiomesData.getBiomeByColor(colorAtPosition);

            System.out.printf("Color at [%d, %d] in region [%d, %d] -> Pixel: (%d, %d) | RGB: (%d, %d, %d) | HEX: #%06X | Biome Color: %d\n",
                    posX, posZ, regionX, regionZ, pixelX, pixelZ, r, g, b, colorAtPosition & 0xFFFFFF, colorAtPosition);

            // Проверка, если биом null
            if (biome == null) {
                LoggerUtil.getInstance().logError("Biome not found for color: " + colorAtPosition);
            }

        } catch (Exception e) {
            System.err.println("Ошибка при выгрузке цветов: " + e.getMessage());
            e.printStackTrace();
        }
    }




    private int findAmountOfIterationToGenerate(BufferedImage initialMap) {
        loggerUtil.logInfoMsg("Checking existing biome files for iteration completion.");

        int currentRegionAmountX = initialMap.getWidth() / BFMEMapConfigs.REGION_SIZE;
        int currentRegionAmountY = initialMap.getHeight() / BFMEMapConfigs.REGION_SIZE;
        int absoluteMapIteration = BFMEMapConfigs.MAP_ITERATION + 1;

        for (int i = 0; i < absoluteMapIteration; i++) {
            if (i > 0) {
                currentRegionAmountX *= 2;
                currentRegionAmountY *= 2;
            }

            loggerUtil.logInfoMsg("Checking iteration: " + i + " with Regions: X = " + currentRegionAmountX + ", Y = " + currentRegionAmountY);

            for (int x = 0; x < currentRegionAmountX; x++) {
                for (int y = 0; y < currentRegionAmountY; y++) {
                    String path = BFMEMapConfigs.BIOME_PATH.formatted(i) + BFMEMapConfigs.IMAGE_NAME.formatted(x, y);
                    if (fileUtils.getRunImage(path) == null) {
                        loggerUtil.logError("Biome file missing: " + path);
                        return absoluteMapIteration - i;
                    }
                }
            }
        }
        return 0;
    }

    private BufferedImage[][][] generateBiomes(BufferedImage initialImage, int missingIterationAmount) {
        loggerUtil.logInfoMsg("Starting biome generation for missing iterations: " + missingIterationAmount);

        int startingIteration = BFMEMapConfigs.MAP_ITERATION + 1 - missingIterationAmount;
        if (startingIteration == 0) {
            loggerUtil.logInfoMsg("Generating initial biomes.");
            generateInitialBiomes(initialImage);
            startingIteration++;
        }

        for (int i = startingIteration; i < BFMEMapConfigs.MAP_ITERATION + 1; i++) {
            ExecutorService executorService = Executors.newFixedThreadPool(BFMEMapConfigs.THREAD_POOL_SIZE);

            int regionAmountX = (int) (initialImage.getWidth() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, i - 1));
            int regionAmountY = (int) (initialImage.getHeight() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, i - 1));

            loggerUtil.logInfoMsg("Iteration: " + i + " Regions: X = " + regionAmountX + ", Y = " + regionAmountY);

            for (int x = 0; x < regionAmountX; x++) {
                for (int y = 0; y < regionAmountY; y++) {
                    int finalI = i;
                    int finalX = x;
                    int finalY = y;

                    executorService.submit(() -> {
                        String path = BFMEMapConfigs.BIOME_PATH.formatted(finalI - 1) + BFMEMapConfigs.IMAGE_NAME.formatted(finalX, finalY);
                        loggerUtil.logDebugMsg("Loading biome region image: " + path);

                        BufferedImage[][] subdividedRegions = ImageUtils.subdivide(fileUtils.getRunImage(path));

                        if (subdividedRegions == null || subdividedRegions.length == 0) {
                            loggerUtil.logError("Subdivision failed for: " + path);
                            return;
                        }

                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {
                                String savePath = BFMEMapConfigs.BIOME_PATH.formatted(finalI);
                                String fileName = BFMEMapConfigs.IMAGE_NAME.formatted((finalX * 2) + j, (finalY * 2) + k);

                                loggerUtil.logDebugMsg("Saving subdivided region: " + savePath + fileName);
                                fileUtils.saveImage(subdividedRegions[j][k], savePath, fileName, FileType.Png);
                            }
                        }
                    });
                }
            }

            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(20, TimeUnit.MINUTES)) {
                    loggerUtil.logError("Biome generation tasks timed out.");
                }
            } catch (InterruptedException e) {
                loggerUtil.logError("Biome generation interrupted: " + e.getMessage());
            }
        }
        return new BufferedImage[0][][];
    }

    private void generateInitialBiomes(BufferedImage initialImage) {
        loggerUtil.logInfoMsg("Splitting initial image into regions.");

        if (initialImage.getWidth() != BFMEMapConfigs.REGION_SIZE ||
                initialImage.getWidth() != BFMEMapConfigs.REGION_SIZE) {
            loggerUtil.logError("Initial image dimensions not matching REGION_SIZE. Splitting required.");
            for (int i = 0; i < initialImage.getWidth() / BFMEMapConfigs.REGION_SIZE; i++) {
                for (int j = 0; j < initialImage.getHeight() / BFMEMapConfigs.REGION_SIZE; j++) {
                    BufferedImage newImage = initialImage.getSubimage(
                            BFMEMapConfigs.REGION_SIZE * i,
                            BFMEMapConfigs.REGION_SIZE * j,
                            BFMEMapConfigs.REGION_SIZE,
                            BFMEMapConfigs.REGION_SIZE);

                    String savePath = BFMEMapConfigs.BIOME_PATH.formatted(0);
                    String fileName = BFMEMapConfigs.IMAGE_NAME.formatted(i, j);
                    loggerUtil.logDebugMsg("Saving region: " + savePath + fileName);
                    fileUtils.saveImage(newImage, savePath, fileName, FileType.Png);
                }
            }
        } else {
            String savePath = BFMEMapConfigs.BIOME_PATH.formatted(0);
            String fileName = BFMEMapConfigs.IMAGE_NAME.formatted(0, 0);
            loggerUtil.logDebugMsg("Saving full initial image as single region: " + savePath + fileName);
            fileUtils.saveImage(initialImage, savePath, fileName, FileType.Png);
        }
    }

    private boolean validateHeightDatas(BufferedImage initialImage) {
        loggerUtil.logInfoMsg("Validating existing height data files.");

        int regionAmountX = (int) (initialImage.getWidth() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, BFMEMapConfigs.MAP_ITERATION));
        int regionAmountY = (int) (initialImage.getHeight() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, BFMEMapConfigs.MAP_ITERATION));

        for (int x = 0; x < regionAmountX; x++) {
            for (int y = 0; y < regionAmountY; y++) {
                String path = BFMEMapConfigs.HEIGHT_PATH + BFMEMapConfigs.IMAGE_NAME.formatted(x, y);
                if (fileUtils.getRunImage(path) == null) {
                    loggerUtil.logError("Missing height file: " + path);
                    return false;
                }
            }
        }

        loggerUtil.logInfoMsg("All height data files validated.");
        return true;
    }

    private void generateHeight(BufferedImage initialImage) {
        loggerUtil.logInfoMsg("Generating height data.");

        ExecutorService executorService = Executors.newFixedThreadPool(BFMEMapConfigs.THREAD_POOL_SIZE);

        int regionAmountX = (int) (initialImage.getWidth() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, BFMEMapConfigs.MAP_ITERATION));
        int regionAmountY = (int) (initialImage.getHeight() / BFMEMapConfigs.REGION_SIZE * Math.pow(2, BFMEMapConfigs.MAP_ITERATION));

        for (int x = 0; x < regionAmountX; x++) {
            for (int y = 0; y < regionAmountY; y++) {
                int finalX = x;
                int finalY = y;

                executorService.submit(() -> {
                    String path = BFMEMapConfigs.BIOME_PATH.formatted(BFMEMapConfigs.MAP_ITERATION) + BFMEMapConfigs.IMAGE_NAME.formatted(finalX, finalY);
                    BufferedImage blurredImage = FileUtils.blur(processHeightRegion(fileUtils.getRunImage(path), BFMEMapConfigs.REGION_SIZE), 16, 1.0f / (16 * 16));

                    fileUtils.saveImage(blurredImage, BFMEMapConfigs.HEIGHT_PATH, BFMEMapConfigs.IMAGE_NAME.formatted(finalX, finalY), FileType.Png);
                    loggerUtil.logDebugMsg("Height data generated and saved: " + BFMEMapConfigs.HEIGHT_PATH + BFMEMapConfigs.IMAGE_NAME.formatted(finalX, finalY));
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(15, TimeUnit.MINUTES)) {
                loggerUtil.logError("Height generation tasks timed out.");
            }
        } catch (InterruptedException e) {
            loggerUtil.logError("Height generation interrupted: " + e.getMessage());
        }
    }

    private static BufferedImage processHeightRegion(BufferedImage biomeImage, int size) {
        BufferedImage newHeightRegion = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                try {
                    int height = BFMEBiomesData.getBiomeByColor(biomeImage.getRGB(x, y)).height;
                    if (height > 255) {
                        height = 255;
                    }
                    int water = 0;
                    if (height < 0) {
                        water = (int) Math.abs((height * WATER_HEIGHT_MULTIPLIER) - WATER_BUFFER);
                        height = 0;
                    }
                    byte decimal = 0;

                    newHeightRegion.setRGB(x, y, new Color(Math.abs(height), decimal, water).getRGB());
                } catch (Exception e) {
                    throw new RuntimeException("BFMEMapGeneration.processHeightRegion : Failed to create color for the height.", e);
                }
            }
        }

        return newHeightRegion;
    }
}
