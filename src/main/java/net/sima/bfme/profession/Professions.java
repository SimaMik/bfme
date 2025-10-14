package net.sima.bfme.profession;

public enum Professions {
    MINER("Miner", new ProfessionLevel[]{
            new ProfessionLevel(0, "Standard", 0),
            new ProfessionLevel(1, "Improved Speed", 100),
            new ProfessionLevel(2, "Extra Ore Chance", 200),
            new ProfessionLevel(3, "Better Speed", 300),
            new ProfessionLevel(4, "More Ore", 400),
            new ProfessionLevel(5, "Ultimate Mining", 500)
    }),
    FARMER("Farmer", new ProfessionLevel[]{
            new ProfessionLevel(0, "Standard", 0),
            new ProfessionLevel(1, "Improved Growth", 100),
            new ProfessionLevel(2, "Extra Harvest", 200),
            new ProfessionLevel(3, "Better Growth", 300),
            new ProfessionLevel(4, "More Harvest", 400),
            new ProfessionLevel(5, "Ultimate Farming", 500)
    }),
    LUMBERJACK("Lumberjack", new ProfessionLevel[]{
            new ProfessionLevel(0, "Standard", 0),
            new ProfessionLevel(1, "Improved Speed", 100),
            new ProfessionLevel(2, "Extra Logs", 200),
            new ProfessionLevel(3, "Better Speed", 300),
            new ProfessionLevel(4, "More Logs", 400),
            new ProfessionLevel(5, "Ultimate Logging", 500)
    });

    private final String name;
    private final ProfessionLevel[] levels;

    Professions(String name, ProfessionLevel[] levels) {
        this.name = name;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public ProfessionLevel getLevel(int level) {
        if (level >= 0 && level < levels.length) {
            return levels[level];
        }
        throw new IllegalArgumentException("Invalid level: " + level);
    }

    public int getMaxLevel() {
        return levels.length - 1;
    }
}
