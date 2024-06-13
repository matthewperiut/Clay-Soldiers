package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.client.layer.SoldierDollLeatherArmorLayer;
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
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

@Environment(EnvType.CLIENT)
public class SoldierDollRenderer extends GeoEntityRenderer<SoldierDollEntity> {
    private static final String LEFT_HAND = "lhand";
    private static final String RIGHT_HAND = "rhand";
    private static final String TORSO = "torso";
    private static final String RIGHT_ARM = "rarm";
    private static final String LEFT_ARM = "larm";

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
                poseStack.scale(0.2f, 0.2f, 0.2f);
                poseStack.translate(0.06f, -0.5f, 0f);
                poseStack.multiply(RotationAxis.NEGATIVE_Z.rotation(2.4f));
            }
            super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
        }
    };


    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, Identifier texture_id) {
        super(renderManager, new SoldierDollModel(texture_id));
        this.shadowRadius = 0.1f;
        this.addRenderLayer(itemLayer);
        this.addRenderLayer(new SoldierDollLeatherArmorLayer(this));
    }

    @Override
    protected int getBlockLight(SoldierDollEntity entity, BlockPos pos) {
        return entity.isLightBlockUnaffected() ? 15 : super.getBlockLight(entity, pos);
    }
}
