package net.sima.bfme.faction;
import java.util.HashMap;
import java.util.Map;

public class FactionRelationship {
    public enum Relationship {
        NEUTRAL,
        FRIEND,
        ALLY,
        ENEMY
    }

    private static final Map<Faction, Map<Faction, Relationship>> relationships = new HashMap<>();

    static {
        // Пример: если отношения симметричны, можно сразу установить оба направления
        setSymmetricRelationship(Faction.GONDOR, Faction.ROHAN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.LOTHLORIEN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.MIRKWOOD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.RIVENDELL, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.IRON_HILLS, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GONDOR, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.GONDOR, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.GONDOR, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.ROHAN, Faction.LOTHLORIEN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.MIRKWOOD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.RIVENDELL, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.IRON_HILLS, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ROHAN, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.ROHAN, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ROHAN, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.MIRKWOOD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.RIVENDELL, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.IRON_HILLS, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LOTHLORIEN, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.MIRKWOOD, Faction.RIVENDELL, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.IRON_HILLS, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.MIRKWOOD, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.MIRKWOOD, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.RIVENDELL, Faction.IRON_HILLS, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.RIVENDELL, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RIVENDELL, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.IRON_HILLS, Faction.EREBOR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.IRON_HILLS, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.IRON_HILLS, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.EREBOR, Faction.HOBBIT, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.EREBOR, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.EREBOR, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.EREBOR, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.HOBBIT, Faction.DALE, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HOBBIT, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.HOBBIT, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.HOBBIT, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.DALE, Faction.RANGER_NORTH, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DALE, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DALE, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DALE, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DALE, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DALE, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.DALE, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DALE, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.LINDON, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.RANGER_NORTH, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.LINDON, Faction.FANGORN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LINDON, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LINDON, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.LINDON, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.LINDON, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.LINDON, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.FANGORN, Faction.ERED_LUIN, Relationship.FRIEND);
        setSymmetricRelationship(Faction.FANGORN, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.FANGORN, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.FANGORN, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FANGORN, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.ERED_LUIN, Faction.DORWINION, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.ERED_LUIN, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.ERED_LUIN, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.DORWINION, Faction.FORODWAITH, Relationship.FRIEND);

        setSymmetricRelationship(Faction.DORWINION, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.DORWINION, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.FORODWAITH, Faction.MORDOR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.ISENGARD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.ANGMAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.DOL_GULDUR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.GUNDABAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.DUNLAND, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.HARAD, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.UMBAR, Relationship.ENEMY);
        setSymmetricRelationship(Faction.FORODWAITH, Faction.RHUN, Relationship.ENEMY);

        setSymmetricRelationship(Faction.MORDOR, Faction.ISENGARD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.ANGMAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.DOL_GULDUR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.GUNDABAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.DUNLAND, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.MORDOR, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.ISENGARD, Faction.ANGMAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.DOL_GULDUR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.GUNDABAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.DUNLAND, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ISENGARD, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.ANGMAR, Faction.DOL_GULDUR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ANGMAR, Faction.GUNDABAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ANGMAR, Faction.DUNLAND, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ANGMAR, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ANGMAR, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.ANGMAR, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.DOL_GULDUR, Faction.GUNDABAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DOL_GULDUR, Faction.DUNLAND, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DOL_GULDUR, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DOL_GULDUR, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DOL_GULDUR, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.GUNDABAD, Faction.DUNLAND, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GUNDABAD, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GUNDABAD, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.GUNDABAD, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.DUNLAND, Faction.HARAD, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DUNLAND, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.DUNLAND, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.HARAD, Faction.UMBAR, Relationship.FRIEND);
        setSymmetricRelationship(Faction.HARAD, Faction.RHUN, Relationship.FRIEND);

        setSymmetricRelationship(Faction.UMBAR, Faction.RHUN, Relationship.FRIEND);
        // Добавьте другие симметричные отношения по аналогии
    }

    private static void setRelationship(Faction faction1, Faction faction2, Relationship relationship) {
        relationships.computeIfAbsent(faction1, k -> new HashMap<>()).put(faction2, relationship);
    }

    private static void setSymmetricRelationship(Faction faction1, Faction faction2, Relationship relationship) {
        setRelationship(faction1, faction2, relationship);
        setRelationship(faction2, faction1, relationship);
    }

    public static Relationship getRelationship(Faction faction1, Faction faction2) {
        return relationships.getOrDefault(faction1, new HashMap<>()).getOrDefault(faction2, Relationship.NEUTRAL);
    }
}