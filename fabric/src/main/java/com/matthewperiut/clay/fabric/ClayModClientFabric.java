package com.matthewperiut.clay.fabric;

import com.matthewperiut.clay.entity.client.HorseDollModel;
import com.matthewperiut.clay.entity.client.HorseDollRenderer;
import com.matthewperiut.clay.entity.client.SoldierDollModel;
import com.matthewperiut.clay.entity.client.SoldierDollRenderer;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class ClayModClientFabric implements ClientModInitializer
{
    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient()
    {
        for (ClientInfoStorage.RendererDataBundle bundle : ClientInfoStorage.rendererDataBundleList)
        {
            if (bundle.type == ClientInfoStorage.RendererType.soldier.ordinal())
            {
                EntityRendererRegistry.register((EntityType<? extends SoldierDollEntity>) bundle.entityType, (context) -> { return new SoldierDollRenderer(context, new SoldierDollModel(bundle.textureID), bundle.textureID); });
            }
            if (bundle.type == ClientInfoStorage.RendererType.horse.ordinal())
            {
                EntityRendererRegistry.register((EntityType<? extends HorseDollEntity>) bundle.entityType, (context) -> { return new HorseDollRenderer(context, new HorseDollModel(bundle.textureID), bundle.textureID); });
            }
        }

        for (ClientInfoStorage.ColoredItemDataBundle bundle : ClientInfoStorage.coloredItemDataBundleList)
        {
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> bundle.color, bundle.item);
        }
    }
}
