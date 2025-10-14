package net.sima.bfme.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.sima.bfme.block.ModBlocks;
import net.sima.bfme.entity.ModEntities;
import net.sima.bfme.item.ModItems;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);
    private static final String TAG_TYPE = "type";

    public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.blocksBuilding = true;
    }

    public ModBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.MOD_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    public Type getModVariant() {
        return Type.byId(this.getEntityData().get(DATA_ID_TYPE));
    }
    @Override
    public Item getDropItem() {
       return switch (this.getModVariant()) {
            case ALMOND -> ModItems.ALMOND_BOAT.get();
            case APPLE -> ModItems.APPLE_BOAT.get();
            case ASPEN -> ModItems.ASPEN_BOAT.get();
            case BAOBAB -> ModItems.BAOBAB_BOAT.get();
            case BANANA -> ModItems.BANANA_BOAT.get();
            case BEECH -> ModItems.BEECH_BOAT.get();
            case CEDAR -> ModItems.CEDAR_BOAT.get();
            case CHESTNUT -> ModItems.CHESTNUT_BOAT.get();
            case CYPRESS -> ModItems.CYPRESS_BOAT.get();
            case DATE_PALM -> ModItems.DATE_PALM_BOAT.get();
            case FIR -> ModItems.FIR_BOAT.get();
            case GREEN_OAK -> ModItems.GREEN_OAK_BOAT.get();
            case HOLLY -> ModItems.HOLLY_BOAT.get();
            case KUNTZ -> ModItems.KUNTZ_BOAT.get();
            case LAIRELOSSE -> ModItems.LAIRELOSSE_BOAT.get();
            case LARCH -> ModItems.LARCH_BOAT.get();
            case LEBETHRON -> ModItems.LEBETHRON_BOAT.get();
            case LEMON -> ModItems.LEMON_BOAT.get();
            case LIME -> ModItems.LIME_BOAT.get();
            case MALLORN -> ModItems.MALLORN_BOAT.get();
            case MANGO -> ModItems.MANGO_BOAT.get();
            case MAPLE -> ModItems.MAPLE_BOAT.get();
            case MIRK_OAK -> ModItems.MIRK_OAK_BOAT.get();
            case OLIVE -> ModItems.OLIVE_BOAT.get();
            case ORANGE -> ModItems.ORANGE_BOAT.get();
            case PALM -> ModItems.PALM_BOAT.get();
            case PEAR -> ModItems.PEAR_BOAT.get();
            case PINE -> ModItems.PINE_BOAT.get();
            case PLUM -> ModItems.PLUM_BOAT.get();
            case POMEGRANATE -> ModItems.POMEGRANATE_BOAT.get();
            case RED_OAK -> ModItems.RED_OAK_BOAT.get();
            case REDWOOD -> ModItems.REDWOOD_BOAT.get();
            case RED_MAHOGANY -> ModItems.RED_MAHOGANY_BOAT.get();
            case WILLOW -> ModItems.WILLOW_BOAT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.getEntityData().set(DATA_ID_TYPE, pVariant.ordinal());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, Type.ALMOND.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString(TAG_TYPE, this.getModVariant().getName());
    }
    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains(TAG_TYPE, CompoundTag.TAG_STRING)) {
            this.setVariant(Type.getTypeFromString(tag.getString(TAG_TYPE)));
        }
    }


    public enum Type{
        ALMOND(ModBlocks.ALMOND_PLANKS.get(),"almond"),
        APPLE(ModBlocks.APPLE_PLANKS.get(), "apple"),
        ASPEN(ModBlocks.ASPEN_PLANKS.get(), "aspen"),
        BAOBAB(ModBlocks.BAOBAB_PLANKS.get(), "baobab"),
        BANANA(ModBlocks.BANANA_PLANKS.get(), "banana"),
        BEECH(ModBlocks.BEECH_PLANKS.get(), "beech"),
        CEDAR(ModBlocks.CEDAR_PLANKS.get(), "cedar"),
        CHESTNUT(ModBlocks.CHESTNUT_PLANKS.get(), "chestnut"),
        CYPRESS(ModBlocks.CYPRESS_PLANKS.get(), "cypress"),
        DATE_PALM(ModBlocks.DATE_PALM_PLANKS.get(), "date_palm"),
        FIR(ModBlocks.FIR_PLANKS.get(), "fir"),
        GREEN_OAK(ModBlocks.GREEN_OAK_PLANKS.get(), "green_oak"),
        HOLLY(ModBlocks.HOLLY_PLANKS.get(), "holly"),
        KUNTZ(ModBlocks.KUNTZ_PLANKS.get(), "kuntz"),
        LAIRELOSSE(ModBlocks.LAIRELOSSE_PLANKS.get(), "lairelosse"),
        LARCH(ModBlocks.LARCH_PLANKS.get(), "larch"),
        LEBETHRON(ModBlocks.LEBETHRON_PLANKS.get(), "lebethron"),
        LEMON(ModBlocks.LEMON_PLANKS.get(), "lemon"),
        LIME(ModBlocks.LIME_PLANKS.get(), "lime"),
        MALLORN(ModBlocks.MALLORN_PLANKS.get(), "mallorn"),
        MANGO(ModBlocks.MANGO_PLANKS.get(), "mango"),
        MAPLE(ModBlocks.MAPLE_PLANKS.get(), "maple"),
        MIRK_OAK(ModBlocks.MIRK_OAK_PLANKS.get(), "mirk_oak"),
        OLIVE(ModBlocks.OLIVE_PLANKS.get(), "olive"),
        ORANGE(ModBlocks.ORANGE_PLANKS.get(), "orange"),
        PALM(ModBlocks.PALM_PLANKS.get(), "palm"),
        PEAR(ModBlocks.PEAR_PLANKS.get(), "pear"),
        PINE(ModBlocks.PINE_PLANKS.get(), "pine"),
        PLUM(ModBlocks.PLUM_PLANKS.get(), "plum"),
        POMEGRANATE(ModBlocks.POMEGRANATE_PLANKS.get(), "pomegranate"),
        RED_OAK(ModBlocks.RED_OAK_PLANKS.get(), "red_oak"),
        RED_MAHOGANY(ModBlocks.RED_MAHOGANY_PLANKS.get(), "red_mahogany"),
        REDWOOD(ModBlocks.REDWOOD_PLANKS.get(), "redwood"),
        WILLOW(ModBlocks.WILLOW_PLANKS.get(), "willow");

        private final String name;
        private final Block planks;

        Type(Block planks, String name) {
            this.name = name;
            this.planks = planks;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int id) {
            Type[] modelType = values();
            if (id < 0 || id >= modelType.length) {
                id = 0;
            }
                return modelType[id];
        }

        public static Type getTypeFromString(String name) {
            Type[] modelType = values();
            for (Type type : modelType) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }

            return modelType[0];
        }
    }
}