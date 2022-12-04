package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SoldierDollModel extends AnimatedGeoModel<SoldierDollEntity>
{
    Identifier texture_id;
    public SoldierDollModel(Identifier texture_id)
    {
        this.texture_id = texture_id;
    }
    public SoldierDollModel()
    {
        this.texture_id = new Identifier(ClayMod.MOD_ID, "textures/entity/soldier/lightgray.png");
    }

    @Override
    public Identifier getModelLocation(SoldierDollEntity object) {
        return new Identifier(ClayMod.MOD_ID, "geo/clay_soldier.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SoldierDollEntity object) {
        return texture_id;
    }


    @Override
    public Identifier getAnimationFileLocation(SoldierDollEntity animatable) {
        return new Identifier(ClayMod.MOD_ID, "animations/clay_soldier.animation.json");
    }
}
