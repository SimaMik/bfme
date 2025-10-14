package net.sima.bfme.item.custom.armor_item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.sima.bfme.item.client.armor_models.IthilienRangerArmorModel;
import net.sima.bfme.item.client.armor_renderers.IthilienRangerArmorRenderer;
import net.sima.bfme.item.custom.BFMEArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IthilienRangerArmorItem extends BFMEArmorItem {
    public IthilienRangerArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new IthilienRangerArmorRenderer(new IthilienRangerArmorModel());
    }
}
