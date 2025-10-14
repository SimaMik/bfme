package net.sima.bfme.worldgen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DebugLogger {
    private static PrintWriter writer;

    public static void init(String filePath) throws IOException {
        if (writer != null) return; // Убедитесь, что файл открыт только один раз
        writer = new PrintWriter(new FileWriter(new File(filePath), true)); // Открываем файл в режиме дозаписи
    }

    public static void log(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush(); // Сохраняем после каждой записи
        }
    }

    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
