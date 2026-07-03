package net.sima.bfme.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.entity.custom.Eagle;
import net.sima.bfme.entity.custom.ModBoatEntity;
import net.sima.bfme.entity.custom.ModChestBoatEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, BFME.MOD_ID);



    public static final Supplier<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final Supplier<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));

    public static final Supplier<EntityType<Eagle>> EAGLE =
            ENTITY_TYPES.register("eagle", () -> EntityType.Builder.<Eagle>of(Eagle::new, MobCategory.CREATURE)
                    .sized(1.4f, 1.0f).build("eagle"));

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EAGLE.get(), Eagle.createAttributes().build());
    }
}
