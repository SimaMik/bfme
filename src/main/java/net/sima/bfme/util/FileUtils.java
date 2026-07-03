package net.sima.bfme.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileUtils {

    private static FileUtils single_instance = null;

    public static synchronized FileUtils getInstance() {
        if (single_instance == null)
            single_instance = new FileUtils(ClassLoader.getSystemClassLoader());

        return single_instance;
    }

    private ClassLoader classLoader;

    public FileUtils(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public BufferedImage getResourceImage(String path) {
        try {
            URL resource = getClass().getClassLoader().getResource(path);
            return ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace(); // Для отладки ошибок чтения изображения
            return null;
        }
    }

    public BufferedImage getRunImage(String path) {
        try {
            File f = new File(path);
            if (!f.exists())
                return null;
            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace(); // Для отладки ошибок чтения изображения
            return null;
        }
    }

    public void saveImage(BufferedImage bufferedImage, String path, String fileName, FileType fileType) {
        try {
            new File(path).mkdirs();
            File f = new File(path + fileName);
            ImageIO.write(bufferedImage, fileType.extension, f);
        } catch (Exception e) {
            System.err.println("Error: Could not save image to " + path + fileName);
            e.printStackTrace(); // Для отладки ошибок сохранения изображения
        }
    }

}
