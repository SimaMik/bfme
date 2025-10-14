package net.sima.bfme.faction;

import java.awt.*;
import java.util.*;

public enum Faction {
    GONDOR(16382457, "Gondor", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    ROHAN(3508007, "Rohan", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    LOTHLORIEN(15716696, "Lothlorien", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)),
    MIRKWOOD(3774030, "Mirkwood", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)),
    RIVENDELL(13035007, "Rivendell", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)),
    IRON_HILLS(4940162, "Iron Hills", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_DWARF)),
    EREBOR(4940162, "Erebor", false, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_DWARF)),

    MORDOR(3481375, "Mordor", true, true, EnumSet.of(FactionType.TYPE_ORC, FactionType.TYPE_TROLL)),
    ISENGARD(3356723, "Isengard", true, true, EnumSet.of(FactionType.TYPE_ORC)),
    ANGMAR(9858132, "Angmar", true, true, EnumSet.of(FactionType.TYPE_ORC, FactionType.TYPE_TROLL)),
    DOL_GULDUR(3488580, "Dol Guldur", true, true, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    GUNDABAD(9858132, "Gundabad", true, true, EnumSet.of(FactionType.TYPE_ORC, FactionType.TYPE_TROLL)),
    DUNLAND(11048079, "Dunland", true, true, EnumSet.of(FactionType.TYPE_MAN)),
    HARAD(11868955, "Harad", true, true, EnumSet.of(FactionType.TYPE_MAN)),


    HOBBIT(5885518, "Hobbit", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    DALE(13535071, "Dale", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    RANGER_NORTH(3823170, "Ranger North" , false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    LINDON(5885518, "Lindon", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    FANGORN(4831058, "Fangorn", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    ERED_LUIN(6132172, "Ered Luin", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    UMBAR(5885518, "Umbar", true, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    RHUN(5885518, "Rhun", true, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),
    DORWINION(7155816, "Dorwinion", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)),//?
    FORODWAITH(5885518, "Forodwaith", false, false, EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)); //?







    private String factionName;
    private Color factionColor;
    private Map<Float, float[]> facRGBCache;
    private Set<FactionType> factionTypes;
    public boolean approvesWarCrimes;
    public boolean availableToPlay;


    private Faction(int color, String factionName, boolean approvesWarCrimes, boolean availableToPlay, EnumSet types) {
        this.facRGBCache = new HashMap();
        this.factionTypes = new HashSet();
        this.approvesWarCrimes = true;
        this.availableToPlay = true;
        this.factionColor = new Color(color);
        this.factionName = factionName;
        if (types != null) {
            this.factionTypes.addAll(types);
        }

    }
    public String getFactionName(){
        return factionName;
    }
    public FactionRelationship.Relationship getRelationshipWith(Faction otherFaction) {
        return FactionRelationship.getRelationship(this, otherFaction);
    }
    public static enum FactionType {
        TYPE_FREE,
        TYPE_ELF,
        TYPE_MAN,
        TYPE_DWARF,
        TYPE_ORC,
        TYPE_TROLL,
        TYPE_TREE;

        private FactionType() {
        }
    }

    public int getFactionColor() {
        return this.factionColor.getRGB();
    }

    public float[] getFactionRGB() {
        return this.getFactionRGB_MinBrightness(0.0F);
    }

    public float[] getFactionRGB_MinBrightness(float minBrightness) {
        float[] rgb = (float[])this.facRGBCache.get(minBrightness);
        if (rgb == null) {
            float[] hsb = Color.RGBtoHSB(this.factionColor.getRed(), this.factionColor.getGreen(), this.factionColor.getBlue(), (float[])null);
            hsb[2] = Math.max(hsb[2], minBrightness);
            int alteredColor = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
            rgb = (new Color(alteredColor)).getColorComponents((float[])null);
            this.facRGBCache.put(minBrightness, rgb);
        }

        return rgb;
    }
    public String codeName() {
        return this.name();
    }
}
