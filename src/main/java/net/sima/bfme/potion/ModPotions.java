package net.sima.bfme.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sima.bfme.BFME;
import net.sima.bfme.effect.ModEffects;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, BFME.MOD_ID);
    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }

    public static final RegistryObject<Potion> SLIMEY_POTION = POTIONS.register("slimey_potion",
            ()-> new Potion(new MobEffectInstance(ModEffects.SLIMEY_EFFECT.get(), 200, 0)));

}
