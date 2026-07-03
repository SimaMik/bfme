package net.sima.bfme.worldgen.chunkgen.map;

import com.google.common.base.Stopwatch;

import java.awt.image.BufferedImage;
import java.util.*;

public class ImageUtils {
    private static byte[] SEED = generateSeed(50);
    private static int SEED_INDEX = 0;

    public static BufferedImage[][] subdivide(BufferedImage parent) {
        BufferedImage[][] subidivedImages = new BufferedImage[2][2];
        int width = parent.getWidth();
        int height = parent.getHeight();

        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                subidivedImages[x][y] = createChildFromParentImage(
                        new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB), parent, width / 2, x, y
                );
            }
        }

        return subidivedImages;
    }


    private static BufferedImage createChildFromParentImage(BufferedImage child, BufferedImage parent, int halfRegionSize, int xIndex, int yIndex) {
        for(int x = halfRegionSize * xIndex; x < halfRegionSize * (xIndex+1); x++) {
            for(int y = halfRegionSize * yIndex; y < halfRegionSize * (yIndex+1); y++) {
                /* Debug
                    final int color = parent.getRGB(x, y);
                    final Short id = MEBiomesData.getBiomeIdByBiome(MEBiomesData.getBiomeByColor(color));
                    if(id == null){
                        String errMessage = "ImageUtils::Cannot subdivide map image, no biome found for color %s at (%s, %s)".formatted(color, x, y);
                        System.out.println(errMessage);
                        throw new RuntimeException(errMessage);
                    }
                 */
                child.setRGB((x - (halfRegionSize * xIndex)) * 2, (y - (halfRegionSize * yIndex)) * 2, parent.getRGB(x, y));
            }
        }
        return fillImage(child);
    }

    private static BufferedImage fillImage(BufferedImage image) {
        final Stopwatch stopwatch = Stopwatch.createUnstarted();
        final int width = image.getWidth();
        final int height = image.getHeight();

        // Create the average values with neighbors
        List<Integer> biomeColors = new ArrayList<>();

        for(int x = 0; x < width; x ++){
            for(int y = 0; y < height; y ++){
                boolean xIsUneven = x % 2 == 1;
                boolean yIsUneven = y % 2 == 1;

                if(xIsUneven ^ yIsUneven){
                    if(xIsUneven){
                        if(x < width - 1)
                            biomeColors.add(image.getRGB(x + 1,y));
                        biomeColors.add(image.getRGB(x - 1,y));
                    }
                    if(yIsUneven){
                        if(y < height - 1)
                            biomeColors.add(image.getRGB(x,y + 1));
                        biomeColors.add(image.getRGB(x,y - 1));
                    }

                    image.setRGB(x,y, getRandomInteger(biomeColors));

                    biomeColors.clear();

                    if(yIsUneven && x > 1){
                        biomeColors.add(image.getRGB(x,y));
                        biomeColors.add(image.getRGB(x - 2,y));
                        if(y < height - 1)
                            biomeColors.add(image.getRGB(x - 1,y + 1));
                        biomeColors.add(image.getRGB(x - 1,y - 1));

                        image.setRGB(x - 1,y, getRandomInteger(biomeColors));
                        biomeColors.clear();
                    }
                } else if(x == width - 1){ // TODO : Find another solution instead of only taking the one from the left
                    image.setRGB(x,y, image.getRGB(x - 1, y));
                }
            }
        }
        stopwatch.reset();
        return applyMajorityFilter(image);
    }

    private static BufferedImage applyMajorityFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int centerColor = image.getRGB(x, y);

                // Collect 3x3 neighborhood colors
                Map<Integer, Integer> colorCount = new HashMap<>();
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int nx = Math.min(Math.max(x + dx, 0), width - 1);
                        int ny = Math.min(Math.max(y + dy, 0), height - 1);
                        int c = image.getRGB(nx, ny);
                        colorCount.merge(c, 1, Integer::sum);
                    }
                }

                // Find majority color
                int bestColor = centerColor;
                int bestCount = 0;
                for (var entry : colorCount.entrySet()) {
                    if (entry.getValue() > bestCount) {
                        bestCount = entry.getValue();
                        bestColor = entry.getKey();
                    }
                }

                result.setRGB(x, y, bestColor);
            }
        }
        return result;
    }

    private static Integer getRandomInteger(List<Integer> list) {
        byte index = -1;
        for (int i = 0; i < list.size(); i++) {
            if(getNextSeed() >= 5){
                index += 1;
            }
        }
        if(index == -1){
            index = 0;
        }
        return list.get(index);
    }

    public static byte[] generateSeed(int bound){
        String piString = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        byte[] piBytes = new byte[piString.length()];
        for (int i = 0; i < piString.length(); i++) {
            piBytes[i] = Byte.parseByte(String.valueOf(piString.charAt(i)));
        }

        SEED = piBytes;
        SEED_INDEX = bound % piBytes.length;

        return SEED;
    }

    public static byte getNextSeed(){
        SEED_INDEX ++;
        if(SEED_INDEX >= SEED.length){
            SEED_INDEX = 0;
        }
        return SEED[SEED_INDEX];
    }
}