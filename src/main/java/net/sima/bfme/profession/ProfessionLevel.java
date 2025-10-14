package net.sima.bfme.profession;

public class ProfessionLevel {
    private final int level;
    private final String name;
    private final int experienceRequired;

    public ProfessionLevel(int level, String name, int experienceRequired) {
        this.level = level;
        this.name = name;
        this.experienceRequired = experienceRequired;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }
}
