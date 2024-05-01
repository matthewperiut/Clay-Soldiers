package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.entity.client.HorseDollRenderer;
import com.matthewperiut.clay.entity.client.SoldierDollRenderer;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.util.ClientInfoStorage;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;

@Environment(EnvType.CLIENT)
public class RenderRegistry {

    public static void init() {
        for (ClientInfoStorage.RendererDataBundle bundle : ClientInfoStorage.rendererDataBundleList) {
            if (bundle.type == ClientInfoStorage.RendererType.soldier.ordinal()) {
                EntityRendererRegistry.register(() -> (EntityType<? extends SoldierDollEntity>) bundle.entityType.get(), ctx -> new SoldierDollRenderer(ctx, bundle.textureID));
            }
            if (bundle.type == ClientInfoStorage.RendererType.horse.ordinal()) {
                EntityRendererRegistry.register(() -> (EntityType<? extends HorseDollEntity>) bundle.entityType.get(), ctx -> new HorseDollRenderer(ctx, bundle.textureID));
            }
        }
        for (ClientInfoStorage.ColoredItemDataBundle bundle : ClientInfoStorage.coloredItemDataBundleList) {
            ColorHandlerRegistry.registerItemColors((stack, tintIndex) -> bundle.color, bundle.item);
        }
    }

}
