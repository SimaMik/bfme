package net.sima.bfme.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sima.bfme.BFME;
import net.sima.bfme.entity.custom.Eagle;
import net.sima.bfme.entity.custom.Rhino;
import net.sima.bfme.entity.layers.ModModelLayers;

public class EagleRenderer extends MobRenderer<Eagle, EagleModel<Eagle>> {
public static final ResourceLocation EAGLE_LOCATION = new ResourceLocation(BFME.MOD_ID, "textures/entity/animals/eagle.png");

    public EagleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EagleModel<>(pContext.bakeLayer(ModModelLayers.EAGLE_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Eagle pEntity) {
//        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
        return EAGLE_LOCATION;
    }

    @Override
    public void render(Eagle pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.65f, 0.65f, 0.65f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}