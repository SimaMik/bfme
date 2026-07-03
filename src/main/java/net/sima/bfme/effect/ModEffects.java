package net.sima.bfme.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;

import java.util.function.Supplier;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, BFME.MOD_ID);

    public static final Holder<MobEffect> STUN = MOB_EFFECTS.register("stun", () -> new StunEffect(MobEffectCategory.HARMFUL, 0x5A6C81));
    public static void register (IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
