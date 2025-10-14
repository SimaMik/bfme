package net.sima.bfme.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import org.checkerframework.checker.units.qual.A;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, BFME.MOD_ID);

public static final Holder<ArmorMaterial> GONDORIAN_INGOT =
        ARMOR_MATERIALS.register("gondorian_ingot", () -> new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 2);
                    map.put(ArmorItem.Type.LEGGINGS, 5);
                    map.put(ArmorItem.Type.CHESTPLATE, 7);
                    map.put(ArmorItem.Type.HELMET, 2);
                    map.put(ArmorItem.Type.BODY, 6);
                }), 20, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(ModItems.GONDORIAN_INGOT.get()),
                List.of(new ArmorMaterial.Layer(BFME.resource("gondorian"))), 0, 0
        ));

    public static void register(IEventBus eventBus){
        ARMOR_MATERIALS.register(eventBus);
    }
}
