package com.matthewperiut.clay.entity.client.layer;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SoldierDollLeatherArmorLayer extends GeoRenderLayer<SoldierDollEntity> {
    static final Identifier TEXTURE = new Identifier(ClayMod.MOD_ID, "textures/entity/upgrade/tiny_chestplate.png");
    static final RenderLayer armorRenderType = RenderLayer.getArmorCutoutNoCull(TEXTURE);


    public SoldierDollLeatherArmorLayer(GeoRenderer<SoldierDollEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack poseStack, SoldierDollEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!animatable.hasArmor()) return;
        super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);

        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.DEFAULT_UV,
                1, 1, 1, 1);
    }
}
