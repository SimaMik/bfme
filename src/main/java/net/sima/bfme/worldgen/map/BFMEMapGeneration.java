package net.sima.bfme.worldgen.map;

import net.sima.bfme.util.FileType;
import net.sima.bfme.util.FileUtils;
import net.sima.bfme.worldgen.chunkgen.map.ImageUtils;
import net.sima.bfme.util.LoggerUtil;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Генерация PNG карты биомов через subdivide.
 */
public class BFMEMapGeneration {
    private FileUtils fileUtils;
    private LoggerUtil loggerUtil;

    public BFMEMapGeneration() throws Exception {
        fileUtils = FileUtils.getInstance();
        loggerUtil = LoggerUtil.getInstance();

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

    private void generateBiomes(BufferedImage initialImage, int missingIterationAmount) {
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

                        BufferedImage[][] subdividedRegions = ImageUtils.subdivide(fileUtils.getRunImage(path));

                        if (subdividedRegions == null || subdividedRegions.length == 0) {
                            loggerUtil.logError("Subdivision failed for: " + path);
                            return;
                        }

                        for (int j = 0; j < 2; j++) {
                            for (int k = 0; k < 2; k++) {
                                String savePath = BFMEMapConfigs.BIOME_PATH.formatted(finalI);
                                String fileName = BFMEMapConfigs.IMAGE_NAME.formatted((finalX * 2) + j, (finalY * 2) + k);

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
    }

    private void generateInitialBiomes(BufferedImage initialImage) {
        loggerUtil.logInfoMsg("Splitting initial image into regions.");

        if (initialImage.getWidth() != BFMEMapConfigs.REGION_SIZE ||
                initialImage.getWidth() != BFMEMapConfigs.REGION_SIZE) {
            for (int i = 0; i < initialImage.getWidth() / BFMEMapConfigs.REGION_SIZE; i++) {
                for (int j = 0; j < initialImage.getHeight() / BFMEMapConfigs.REGION_SIZE; j++) {
                    BufferedImage newImage = initialImage.getSubimage(
                            BFMEMapConfigs.REGION_SIZE * i,
                            BFMEMapConfigs.REGION_SIZE * j,
                            BFMEMapConfigs.REGION_SIZE,
                            BFMEMapConfigs.REGION_SIZE);

                    String savePath = BFMEMapConfigs.BIOME_PATH.formatted(0);
                    String fileName = BFMEMapConfigs.IMAGE_NAME.formatted(i, j);
                    fileUtils.saveImage(newImage, savePath, fileName, FileType.Png);
                }
            }
        } else {
            String savePath = BFMEMapConfigs.BIOME_PATH.formatted(0);
            String fileName = BFMEMapConfigs.IMAGE_NAME.formatted(0, 0);
            fileUtils.saveImage(initialImage, savePath, fileName, FileType.Png);
        }
    }

}