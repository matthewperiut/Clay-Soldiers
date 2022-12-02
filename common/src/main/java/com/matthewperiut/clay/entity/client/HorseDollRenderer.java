package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HorseDollRenderer extends GeoEntityRenderer<HorseDollEntity>
{
    public Identifier texture_id;
    public HorseDollRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<HorseDollEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureResource(HorseDollEntity animatable)
    {
        return texture_id;
    }
}
