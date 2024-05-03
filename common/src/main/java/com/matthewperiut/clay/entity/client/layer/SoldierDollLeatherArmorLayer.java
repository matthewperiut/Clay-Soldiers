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

import static com.matthewperiut.clay.registry.UpgradeRegistry.LEATHER_UPGRADE;
import static com.matthewperiut.clay.registry.UpgradeRegistry.WOOL_UPGRADE;

public class SoldierDollLeatherArmorLayer extends GeoRenderLayer<SoldierDollEntity> {
    static final Identifier BASE_TEXTURE = new Identifier(ClayMod.MOD_ID, "textures/entity/upgrade/tiny_chestplate.png");
    static final Identifier UPGRADED_TEXTURE = new Identifier(ClayMod.MOD_ID, "textures/entity/upgrade/tiny_chestplate_with_wool.png");
    static final RenderLayer BASE_ARMOR_RENDER_TYPE = RenderLayer.getArmorCutoutNoCull(BASE_TEXTURE);
    static final RenderLayer UPGRADED_ARMOR_RENDER_TYPE = RenderLayer.getArmorCutoutNoCull(UPGRADED_TEXTURE);


    public SoldierDollLeatherArmorLayer(GeoRenderer<SoldierDollEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack poseStack, SoldierDollEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!animatable.upgrades.contains(LEATHER_UPGRADE.get())) return;

        RenderLayer renderLayer = BASE_ARMOR_RENDER_TYPE;

        if (animatable.upgrades.contains(WOOL_UPGRADE.get())) renderLayer = UPGRADED_ARMOR_RENDER_TYPE;

        super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);

        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderLayer,
                bufferSource.getBuffer(renderLayer), partialTick, packedLight, OverlayTexture.DEFAULT_UV,
                1, 1, 1, 1);
    }
}
