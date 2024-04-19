package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

@Environment(EnvType.CLIENT)
public class SoldierDollRenderer extends GeoEntityRenderer<SoldierDollEntity>
{
    private static final String LEFT_HAND = "lhand";
    private static final String RIGHT_HAND = "rhand";

    private final BlockAndItemGeoLayer<SoldierDollEntity> itemLayer = new BlockAndItemGeoLayer<>(this) {
        @Override
        protected ItemStack getStackForBone(GeoBone bone, SoldierDollEntity animatable) {
            return switch (bone.getName()) {
                case LEFT_HAND -> animatable.getStackInHand(Hand.MAIN_HAND);
                case RIGHT_HAND -> animatable.getStackInHand(Hand.OFF_HAND);
                default -> super.getStackForBone(bone, animatable);
            };
        }

        @Override
        protected void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack, SoldierDollEntity animatable, VertexConsumerProvider bufferSource,
                                          float partialTick, int packedLight, int packedOverlay) {
            if (stack.isOf(Items.STICK)) {
                poseStack.multiply(RotationAxis.NEGATIVE_X.rotation(105));
                poseStack.scale(0.2f, 0.4f, 0.2f);
                poseStack.translate(0.15f, -0.5f, 0f);
                poseStack.multiply(RotationAxis.NEGATIVE_Z.rotation(90));
            }
            super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
        }
    };

    public Identifier texture_id;

    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, GeoModel<SoldierDollEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
        this.addRenderLayer(itemLayer);
    }

    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, Identifier texture_id)
    {
        super(renderManager, new SoldierDollModel(texture_id));
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
        this.addRenderLayer(itemLayer);
    }

    @Override
    protected int getBlockLight(SoldierDollEntity entity, BlockPos pos) {
        // TODO make it depending on Glowstone Upgrade
        return 15;
    }
}
