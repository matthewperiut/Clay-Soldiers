package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HorseDollRenderer extends GeoEntityRenderer<HorseDollEntity>
{
    public Identifier texture_id;
    public HorseDollRenderer(EntityRendererFactory.Context renderManager, GeoModel<HorseDollEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    public HorseDollRenderer(EntityRendererFactory.Context renderManager, Identifier texture_id)
    {
        super(renderManager, new HorseDollModel(texture_id));
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }
}
