package net.sima.bfme.item.client.armor_models;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.sima.bfme.BFME;
import net.sima.bfme.item.custom.armor_item.GondorianArmorItem;
import net.sima.bfme.item.custom.armor_item.IthilienRangerArmorItem;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;

public class IthilienRangerArmorModel extends GeoModel<IthilienRangerArmorItem> {
    @Override
    public ResourceLocation getModelResource(IthilienRangerArmorItem animatable) {
        return BFME.resource("geo/ithilien_ranger_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IthilienRangerArmorItem animatable) {
        return BFME.resource("textures/armor/ithilien_ranger_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IthilienRangerArmorItem animatable) {
        return null;
    }

    @Override
    public void setCustomAnimations(IthilienRangerArmorItem animatable, long instanceId, AnimationState<IthilienRangerArmorItem> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        // Используем массив для обхода ограничения final
        final boolean[] isHelmetEquipped = {false};

        // Получаем сущность из AnimationState
        Object entity = animationState.getData(DataTickets.ENTITY);

        if (entity instanceof LivingEntity livingEntity) {
            ItemStack helmetStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
            isHelmetEquipped[0] = helmetStack.getItem() instanceof IthilienRangerArmorItem;
        }

        // Управление видимостью плаща и воротника
        getBone("cloak").ifPresent(cloak -> cloak.setHidden(!isHelmetEquipped[0]));
        getBone("collar").ifPresent(collar -> collar.setHidden(!isHelmetEquipped[0]));
    }



}
