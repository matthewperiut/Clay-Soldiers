package com.matthewperiut.clay.forge;

import com.matthewperiut.clay.entity.client.HorseDollRenderer;
import com.matthewperiut.clay.entity.client.SoldierDollRenderer;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.forge.entity.HorseDollEntities;
import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.EntityType;
public class ClayModClientForge
{
    public static void setupEntityRenderers()
    {
        SoldierDollEntities.clientRegister();
        HorseDollEntities.clientRegister();

        for (ClientInfoStorage.RendererDataBundle bundle : ClientInfoStorage.rendererDataBundleList)
        {
            if (bundle.type == ClientInfoStorage.RendererType.soldier.ordinal())
            {
                EntityRenderers.register((EntityType<? extends SoldierDollEntity>) bundle.entityType, ctx -> new SoldierDollRenderer(ctx, bundle.textureID));
            }
            if (bundle.type == ClientInfoStorage.RendererType.horse.ordinal())
            {
                EntityRenderers.register((EntityType<? extends HorseDollEntity>) bundle.entityType, ctx -> new HorseDollRenderer(ctx, bundle.textureID));
            }
        }
    }
}