package net.sima.bfme.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.sima.bfme.effect.ModEffects;

import java.util.Random;

public class HammerItem extends Weapon {
    private static final Random random = new Random();

    public HammerItem(float attackDamage, float attackSpeed, float reach, float attackKnockback, int durability, int enchantability, Properties properties) {
        super(attackDamage, attackSpeed, reach, attackKnockback, durability, enchantability, properties);
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            if (random.nextDouble() < 0.9) {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.STUN, 400), player);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);

    }
}