package net.sima.bfme.item.client.armor_models;

import net.minecraft.resources.ResourceLocation;
import net.sima.bfme.BFME;
import net.sima.bfme.item.custom.armor_item.GondorianArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GondorianArmorModel extends GeoModel<GondorianArmorItem> {
    @Override
    public ResourceLocation getModelResource(GondorianArmorItem animatable) {
        return BFME.resource("geo/gondorian_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GondorianArmorItem animatable) {
        return BFME.resource("textures/armor/gondorian_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GondorianArmorItem animatable) {
        return null;
    }
}
