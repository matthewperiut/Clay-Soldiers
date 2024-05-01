package com.matthewperiut.clay.entity.client.layer;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SoldierDollLeatherArmorLayer extends GeoRenderLayer<SoldierDollEntity> {
    public static final Identifier TEXTURE = new Identifier(ClayMod.MOD_ID, "textures/item/armor/tiny_chestplate.png");

    public SoldierDollLeatherArmorLayer(GeoRenderer<SoldierDollEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void renderForBone(MatrixStack poseStack, SoldierDollEntity animatable, GeoBone bone, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        super.renderForBone(poseStack, animatable, bone, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
    }

    @Override
    public void render(MatrixStack poseStack, SoldierDollEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        RenderLayer armorRenderType = RenderLayer.getArmorCutoutNoCull(TEXTURE);
        poseStack.scale(1, 1f, 1);
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotation(45f));
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.packUv(0, 1),
                1, 1, 1, 1);
    }
}
