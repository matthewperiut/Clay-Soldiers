package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

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
                poseStack.scale(0.2f, 0.4f, 0.2f);
                poseStack.translate(0.15f, -0.5f, 0f);
                poseStack.multiply(RotationAxis.NEGATIVE_Z.rotation(90));
            }
            super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
        }
    };

    private final ItemArmorGeoLayer<SoldierDollEntity> armorLayer = new ItemArmorGeoLayer<>(this) {
        @Override
        protected ItemStack getArmorItemForBone(GeoBone bone, SoldierDollEntity animatable) {
            if (bone.getName().equals(TORSO) || bone.getName().equals(RIGHT_ARM) || bone.getName().equals(LEFT_ARM)) {
                return animatable.getEquippedStack(EquipmentSlot.CHEST);
            }
            return super.getArmorItemForBone(bone, animatable);
        }


        @Override
        protected @NotNull BipedEntityModel<?> getModelForItem(GeoBone bone, EquipmentSlot slot, ItemStack stack, SoldierDollEntity animatable) {
            BipedEntityModel<?> model = super.getModelForItem(bone, slot, stack, animatable);
            return model;
        }

        @Override
        protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, SoldierDollEntity animatable, BipedEntityModel<?> baseModel) {
            return switch (bone.getName()) {
                case RIGHT_ARM -> baseModel.rightArm;
                case LEFT_ARM -> baseModel.leftArm;
                case TORSO -> baseModel.body;
                default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
            };
        }
    };

    public Identifier texture_id;

    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, GeoModel<SoldierDollEntity> modelProvider, Identifier texture_id) {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
        this.addRenderLayer(itemLayer);
    }

    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, Identifier texture_id) {
        super(renderManager, new SoldierDollModel(texture_id));
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
        this.addRenderLayer(itemLayer);
        this.addRenderLayer(armorLayer);
        //this.addRenderLayer(new SoldierDollLeatherArmorLayer(this));
    }

    @Override
    protected int getBlockLight(SoldierDollEntity entity, BlockPos pos) {
        return entity.isLightBlockUnaffected() ? 15 : super.getBlockLight(entity, pos);
    }
}
