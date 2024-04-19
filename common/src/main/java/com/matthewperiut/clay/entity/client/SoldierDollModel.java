package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

@Environment(EnvType.CLIENT)
public class SoldierDollModel extends GeoModel<SoldierDollEntity>
{
    Identifier texture_id;

    public SoldierDollModel(Identifier texture_id)
    {
        this.texture_id = texture_id;
    }

    @Override
    public Identifier getModelResource(SoldierDollEntity object)
    {
        return new Identifier(ClayMod.MOD_ID, "geo/clay_soldier.geo.json");
    }

    @Override
    public Identifier getTextureResource(SoldierDollEntity object)
    {
        return texture_id;
    }

    @Override
    public Identifier getAnimationResource(SoldierDollEntity animatable)
    {
        return new Identifier(ClayMod.MOD_ID, "animations/clay_soldier.animation.json");
    }
}
