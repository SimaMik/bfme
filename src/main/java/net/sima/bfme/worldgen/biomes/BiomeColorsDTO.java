package net.sima.bfme.worldgen.biomes;

public class BiomeColorsDTO {
    public int skyColor;
    public int fogColor;
    public int waterColor;
    public int waterFogColor;
    public int grassColor;
    public int foliageColor;

    // Конструктор копирования
    public BiomeColorsDTO(BiomeColorsDTO copy) {
        this.skyColor = copy.skyColor;
        this.fogColor = copy.fogColor;
        this.waterColor = copy.waterColor;
        this.waterFogColor = copy.waterFogColor;
        this.grassColor = copy.grassColor;
        this.foliageColor = copy.foliageColor;
    }

    // Конструктор с базовыми значениями (для травы и листвы)
    public BiomeColorsDTO(int grassColor, int foliageColor) {
        // Значения по умолчанию, аналогичные ванильным
        this.skyColor = 7907327; // Цвет неба
        this.fogColor = 12638463; // Цвет тумана
        this.waterColor = 4159204; // Цвет воды
        this.waterFogColor = 329011; // Цвет воды в тумане
        this.grassColor = grassColor; // Цвет травы
        this.foliageColor = foliageColor; // Цвет листвы
    }

    // Полный конструктор с кастомными значениями
    public BiomeColorsDTO(int skyColor, int fogColor, int waterColor, int waterFogColor, int grassColor, int foliageColor) {
        this.skyColor = skyColor;
        this.fogColor = fogColor;
        this.waterColor = waterColor;
        this.waterFogColor = waterFogColor;
        this.grassColor = grassColor;
        this.foliageColor = foliageColor;
    }
}
