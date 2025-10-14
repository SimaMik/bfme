package net.sima.bfme.item.custom.armor_item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.item.client.armor_models.GondorianArmorModel;
import net.sima.bfme.item.client.armor_renderers.GondorianArmorRenderer;
import net.sima.bfme.item.custom.BFMEArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GondorianArmorItem extends BFMEArmorItem {
    public GondorianArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GondorianArmorRenderer(new GondorianArmorModel());
    }
}
