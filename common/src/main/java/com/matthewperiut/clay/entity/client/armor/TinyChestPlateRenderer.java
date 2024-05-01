package com.matthewperiut.clay.entity.client.armor;

import com.matthewperiut.clay.item.armor.TinyChestplateArmorItem;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TinyChestPlateRenderer extends GeoArmorRenderer<TinyChestplateArmorItem> {
    public TinyChestPlateRenderer() {
        super(new TinyChestPlateModel());
    }

    @Override
    public GeoBone getBodyBone() {
        return this.model.getBone("torso").orElse(null);
    }

    @Override
    public GeoBone getRightArmBone() {
        return this.model.getBone("rarm").orElse(null);
    }

    @Override
    public GeoBone getLeftArmBone() {
        return this.model.getBone("larm").orElse(null);
    }
}
