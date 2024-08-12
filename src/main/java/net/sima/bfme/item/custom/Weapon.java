package net.sima.bfme.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.UUID;

public class Weapon extends Item {
    private final float attackDamage;
    private final float attackSpeed;
    private final float attackKnockback;
    private final float reach;
    private final int durability;
    private final int enchantability;
    protected static final UUID BASE_ATTACK_KNOCKBACK_UUID = UUID.randomUUID();
    protected static final UUID BASE_ATTACK_REACH_UUID = UUID.randomUUID();
    protected static final ResourceLocation BASE_ATTACK_KNOCKBACK_ID = ResourceLocation.withDefaultNamespace("base_attack_knockback");
    protected static final ResourceLocation BASE_ATTACK_REACH_ID = ResourceLocation.withDefaultNamespace("base_attack_reach");


    public Weapon(float attackDamage, float attackSpeed, float reach, float attackKnockback, int durability, int enchantability, Properties properties) {
        super(properties.attributes(Weapon.createAttributes(attackDamage, reach, attackSpeed, attackKnockback)));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackKnockback = attackKnockback;
        this.reach = reach;
        this.durability = durability;
        this.enchantability = enchantability;
    }

    public static ItemAttributeModifiers createAttributes(double attackDamage, double reach, double attackSpeed, double attackKnockback) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID,
                                attackDamage,
                                AttributeModifier.Operation.ADD_VALUE
                        ), EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(
                                BASE_ATTACK_SPEED_ID,
                                attackSpeed,
                                AttributeModifier.Operation.ADD_VALUE
                        ), EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(
                                BASE_ATTACK_REACH_ID,
                                reach,
                                AttributeModifier.Operation.ADD_VALUE
                        ), EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.ATTACK_KNOCKBACK,
                        new AttributeModifier(
                                BASE_ATTACK_KNOCKBACK_ID,
                                attackKnockback,
                                AttributeModifier.Operation.ADD_VALUE
                        ), EquipmentSlotGroup.MAINHAND
                ).build();
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return createAttributes(this.attackDamage, this.reach, this.attackSpeed, this.attackKnockback);
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return ItemAttributeModifiers.EMPTY;
    }
    public float getAttackDamage() {
        return this.attackDamage;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public float getAttackKnockback() {
        return this.attackKnockback;
    }

    public float getReach() {
        return this.reach;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return state.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    @Override
    public boolean mineBlock(ItemStack stackIn, Level level, BlockState state, BlockPos pos, LivingEntity playerIn) {
        if (state.getDestroySpeed(level, pos) != 0.0F) {
            stackIn.hurtAndBreak(1, playerIn, EquipmentSlot.MAINHAND);
        }
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(Blocks.COBWEB);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.durability;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
//        tooltip.add(Component.literal("Attack Damage: " + this.getAttackDamage()).withStyle(ChatFormatting.GRAY));
//        tooltip.add(Component.literal("Attack Speed: " + this.getAttackSpeed()).withStyle(ChatFormatting.GRAY));
//        tooltip.add(Component.literal("Attack Knockback: " + this.getAttackKnockback()).withStyle(ChatFormatting.GRAY));
//        tooltip.add(Component.literal("Reach: " + this.getReach()).withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.literal("Durability: " + (this.getMaxDamage(stack) - stack.getDamageValue()) + "/" + this.getMaxDamage(stack)).withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }
}
