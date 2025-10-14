package net.sima.bfme.item.client.armor_renderers;

import net.sima.bfme.item.client.armor_models.GondorianArmorModel;
import net.sima.bfme.item.custom.armor_item.GondorianArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GondorianArmorRenderer extends GeoArmorRenderer<GondorianArmorItem> {
    public GondorianArmorRenderer(GondorianArmorModel model) {
        super(new GondorianArmorModel());
    }
}
