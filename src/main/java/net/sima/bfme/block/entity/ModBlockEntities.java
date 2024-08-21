package net.sima.bfme.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.block.ModBlocks;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries. BLOCK_ENTITY_TYPE, BFME.MOD_ID);
    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
        ModBlocks.APPLE_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get(),
        ModBlocks.PEAR_SIGN.get(), ModBlocks.PEAR_WALL_SIGN.get(),
        ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get(),
        ModBlocks.MALLORN_SIGN.get(), ModBlocks.MALLORN_WALL_SIGN.get(),
        ModBlocks.CHARRED_SIGN.get(), ModBlocks.CHARRED_WALL_SIGN.get(),
        ModBlocks.WILLOW_SIGN.get(), ModBlocks.WILLOW_WALL_SIGN.get(),
        ModBlocks.BEECH_SIGN.get(), ModBlocks.BEECH_WALL_SIGN.get(),
        ModBlocks.BAOBAB_SIGN.get(), ModBlocks.BAOBAB_WALL_SIGN.get(),
        ModBlocks.PINE_SIGN.get(), ModBlocks.PINE_WALL_SIGN.get(),
        ModBlocks.HOLLY_SIGN.get(), ModBlocks.HOLLY_WALL_SIGN.get(),
        ModBlocks.GREEN_OAK_SIGN.get(), ModBlocks.GREEN_OAK_WALL_SIGN.get(),
        ModBlocks.RED_OAK_SIGN.get(), ModBlocks.RED_OAK_WALL_SIGN.get(),
        ModBlocks.MIRK_OAK_SIGN.get(), ModBlocks.MIRK_OAK_WALL_SIGN.get(),
        ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get(),
        ModBlocks.PALM_SIGN.get(), ModBlocks.PALM_WALL_SIGN.get(),
        ModBlocks.CHESTNUT_SIGN.get(), ModBlocks.CHESTNUT_WALL_SIGN.get(),
        ModBlocks.ASPEN_SIGN.get(), ModBlocks.ASPEN_WALL_SIGN.get(),
        ModBlocks.CEDAR_SIGN.get(), ModBlocks.CEDAR_WALL_SIGN.get(),
        ModBlocks.FIR_SIGN.get(), ModBlocks.FIR_WALL_SIGN.get(),
        ModBlocks.LARCH_SIGN.get(), ModBlocks.LARCH_WALL_SIGN.get(),
        ModBlocks.LAIRELOSSE_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_SIGN.get(),
        ModBlocks.ALMOND_SIGN.get(), ModBlocks.ALMOND_WALL_SIGN.get(),
        ModBlocks.BANANA_SIGN.get(), ModBlocks.BANANA_WALL_SIGN.get(),
        ModBlocks.CYPRESS_SIGN.get(), ModBlocks.CYPRESS_WALL_SIGN.get(),
        ModBlocks.DATE_PALM_SIGN.get(), ModBlocks.DATE_PALM_WALL_SIGN.get(),
        ModBlocks.KUNTZ_SIGN.get(), ModBlocks.KUNTZ_WALL_SIGN.get(),
        ModBlocks.LEBETHRON_SIGN.get(), ModBlocks.LEBETHRON_WALL_SIGN.get(),
        ModBlocks.LEMON_SIGN.get(), ModBlocks.LEMON_WALL_SIGN.get(),
        ModBlocks.LIME_SIGN.get(), ModBlocks.LIME_WALL_SIGN.get(),
        ModBlocks.MANGO_SIGN.get(), ModBlocks.MANGO_WALL_SIGN.get(),
        ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get(),
        ModBlocks.POMERGRANATE_SIGN.get(), ModBlocks.POMERGRANATE_WALL_SIGN.get(),
        ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get(),
        ModBlocks.RED_MAHOGANY_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_SIGN.get(),
        ModBlocks.OLIVE_SIGN.get(), ModBlocks.OLIVE_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", ()->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
     ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
            ModBlocks.PEAR_HANGING_SIGN.get(), ModBlocks.PEAR_WALL_HANGING_SIGN.get(),
            ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(),
            ModBlocks.MALLORN_HANGING_SIGN.get(), ModBlocks.MALLORN_WALL_HANGING_SIGN.get(),
            ModBlocks.CHARRED_HANGING_SIGN.get(), ModBlocks.CHARRED_WALL_HANGING_SIGN.get(),
            ModBlocks.WILLOW_HANGING_SIGN.get(), ModBlocks.WILLOW_WALL_HANGING_SIGN.get(),
            ModBlocks.BEECH_HANGING_SIGN.get(), ModBlocks.BEECH_WALL_HANGING_SIGN.get(),
            ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(),
            ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
            ModBlocks.HOLLY_HANGING_SIGN.get(), ModBlocks.HOLLY_WALL_HANGING_SIGN.get(),
            ModBlocks.GREEN_OAK_HANGING_SIGN.get(), ModBlocks.GREEN_OAK_WALL_HANGING_SIGN.get(),
            ModBlocks.RED_OAK_HANGING_SIGN.get(), ModBlocks.RED_OAK_WALL_HANGING_SIGN.get(),
            ModBlocks.MIRK_OAK_HANGING_SIGN.get(), ModBlocks.MIRK_OAK_WALL_HANGING_SIGN.get(),
            ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
            ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get(),
            ModBlocks.CHESTNUT_HANGING_SIGN.get(), ModBlocks.CHESTNUT_WALL_HANGING_SIGN.get(),
            ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(),
            ModBlocks.CEDAR_HANGING_SIGN.get(), ModBlocks.CEDAR_WALL_HANGING_SIGN.get(),
            ModBlocks.FIR_HANGING_SIGN.get(), ModBlocks.FIR_WALL_HANGING_SIGN.get(),
            ModBlocks.LARCH_HANGING_SIGN.get(), ModBlocks.LARCH_WALL_HANGING_SIGN.get(),
            ModBlocks.LAIRELOSSE_HANGING_SIGN.get(), ModBlocks.LAIRELOSSE_WALL_HANGING_SIGN.get(),
            ModBlocks.ALMOND_HANGING_SIGN.get(), ModBlocks.ALMOND_WALL_HANGING_SIGN.get(),
            ModBlocks.BANANA_HANGING_SIGN.get(), ModBlocks.BANANA_WALL_HANGING_SIGN.get(),
            ModBlocks.CYPRESS_HANGING_SIGN.get(), ModBlocks.CYPRESS_WALL_HANGING_SIGN.get(),
            ModBlocks.DATE_PALM_HANGING_SIGN.get(), ModBlocks.DATE_PALM_WALL_HANGING_SIGN.get(),
            ModBlocks.KUNTZ_HANGING_SIGN.get(), ModBlocks.KUNTZ_WALL_HANGING_SIGN.get(),
            ModBlocks.LEBETHRON_HANGING_SIGN.get(), ModBlocks.LEBETHRON_WALL_HANGING_SIGN.get(),
            ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
            ModBlocks.LIME_HANGING_SIGN.get(), ModBlocks.LIME_WALL_HANGING_SIGN.get(),
            ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
            ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
            ModBlocks.POMERGRANATE_HANGING_SIGN.get(), ModBlocks.POMERGRANATE_WALL_HANGING_SIGN.get(),
            ModBlocks.REDWOOD_HANGING_SIGN.get(), ModBlocks.REDWOOD_WALL_HANGING_SIGN.get(),
            ModBlocks.RED_MAHOGANY_HANGING_SIGN.get(), ModBlocks.RED_MAHOGANY_WALL_HANGING_SIGN.get(),
            ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get()).build(null));
//
//    public static final RegistryObject<BlockEntityType<ChestBlockEntity>> MOD_CHEST =
//            BLOCK_ENTITIES.register("mod_chest", () ->
//                    BlockEntityType.Builder.of(ChestBlockEntity::new,
//                            ModBlocks.OAK_CHEST.get(),ModBlocks.SPRUCE_CHEST.get(),
//                            ModBlocks.BIRCH_CHEST.get(),ModBlocks.ACACIA_CHEST.get(),
//                            ModBlocks.CHERRY_CHEST.get(),ModBlocks.ALMOND_CHEST.get(),
//                            ModBlocks.APPLE_CHEST.get(),ModBlocks.ASPEN_CHEST.get(),
//                            ModBlocks.BANANA_CHEST.get(),ModBlocks.BAOBAB_CHEST.get(),
//                            ModBlocks.BEECH_CHEST.get(),ModBlocks.CEDAR_CHEST.get(),
//                            ModBlocks.CHARRED_WOOD_CHEST.get(),ModBlocks.CHESTNUT_CHEST.get(),
//                            ModBlocks.CYPRESS_CHEST.get(),ModBlocks.DATE_PALM_CHEST.get(),
//                            ModBlocks.FIR_CHEST.get(),ModBlocks.GREEN_OAK_CHEST.get(),
//                            ModBlocks.HOLLY_CHEST.get(),ModBlocks.KUNTZ_CHEST.get(),
//                            ModBlocks.LAIRELOSSE_CHEST.get(),ModBlocks.LARCH_CHEST.get(),
//                            ModBlocks.LEBETHRON_CHEST.get(),ModBlocks.LEMON_CHEST.get(),
//                            ModBlocks.LIME_CHEST.get(),ModBlocks.MALLORN_CHEST.get(),
//                            ModBlocks.MANGO_CHEST.get(),ModBlocks.MAPLE_CHEST.get(),ModBlocks.MIRK_OAK_CHEST.get(),
//                            ModBlocks.OLIVE_CHEST.get(),ModBlocks.ORANGE_CHEST.get(),
//                            ModBlocks.PALM_CHEST.get(),ModBlocks.PEAR_CHEST.get(),
//                            ModBlocks.PINE_CHEST.get(),ModBlocks.PLUM_CHEST.get(),
//                            ModBlocks.POMERGRANATE_CHEST.get(),ModBlocks.RED_OAK_CHEST.get(),
//                            ModBlocks.RED_WOOD_CHEST.get(),ModBlocks.RED_MAHOGANY_CHEST.get(),
//                            ModBlocks.SEQUOIA_CHEST.get(),ModBlocks.WILLOW_CHEST.get()).build(null));
//

//    public static final RegistryObject<BlockEntityType<ModFurnaceBlockEntity>> MOD_FURNACE_BE =
//            BLOCK_ENTITIES.register("mod_furnace_block_entity", ()->
//                    BlockEntityType.Builder.of(ModFurnaceBlockEntity::new,).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
