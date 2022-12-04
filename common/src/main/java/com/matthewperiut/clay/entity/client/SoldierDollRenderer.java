package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SoldierDollRenderer extends GeoEntityRenderer<SoldierDollEntity>
{
    public Identifier texture_id;
    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<SoldierDollEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    public SoldierDollRenderer(EntityRendererFactory.Context renderManager, Identifier texture_id)
    {
        super(renderManager, new SoldierDollModel(texture_id));
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureLocation(SoldierDollEntity animatable)
    {
        return texture_id;
    }
}
