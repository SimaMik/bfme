package net.sima.bfme.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BFME.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", ()->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", ()->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new).build(null));

    public static void register (IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
