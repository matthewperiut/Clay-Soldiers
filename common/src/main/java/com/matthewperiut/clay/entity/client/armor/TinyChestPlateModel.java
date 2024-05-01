package com.matthewperiut.clay.entity.client.armor;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.item.armor.TinyChestplateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TinyChestPlateModel extends GeoModel<TinyChestplateArmorItem> {
    @Override
    public Identifier getModelResource(TinyChestplateArmorItem animatable) {
        return new Identifier(ClayMod.MOD_ID, "geo/tiny_chestplate.geo.json");
    }

    @Override
    public Identifier getTextureResource(TinyChestplateArmorItem animatable) {
        return new Identifier(ClayMod.MOD_ID, "textures/item/armor/tiny_chestplate.png");
    }

    @Override
    public Identifier getAnimationResource(TinyChestplateArmorItem animatable) {
        return new Identifier(ClayMod.MOD_ID, "animations/tiny_chestplate.animation.json");
    }
}
