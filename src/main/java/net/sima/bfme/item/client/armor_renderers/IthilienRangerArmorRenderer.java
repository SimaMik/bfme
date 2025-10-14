package net.sima.bfme.item.client.armor_renderers;

import net.sima.bfme.item.client.armor_models.IthilienRangerArmorModel;
import net.sima.bfme.item.custom.armor_item.IthilienRangerArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IthilienRangerArmorRenderer extends GeoArmorRenderer<IthilienRangerArmorItem> {
    public IthilienRangerArmorRenderer(IthilienRangerArmorModel model) {
        super(new IthilienRangerArmorModel());
    }
}
