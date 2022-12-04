package com.matthewperiut.clay.util;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ClientInfoStorage
{
    public enum RendererType { soldier, horse }
    public static class RendererDataBundle
    {
        public int type;
        public EntityType<?> entityType;
        public Identifier textureID;

        public RendererDataBundle(EntityType<?> entityType, Identifier textureID, int type)
        {
            this.type = type;
            this.entityType = entityType;
            this.textureID = textureID;
        }
    }

    public static List<RendererDataBundle> rendererDataBundleList = new ArrayList<>();

    public ClientInfoStorage(EntityType<?> entityType, Identifier textureID, int type)
    {
        rendererDataBundleList.add(new RendererDataBundle(entityType, textureID, type));
    }

    public static class ColoredItemDataBundle
    {
        public Item item;
        public int color;

        public ColoredItemDataBundle(Item item, int color)
        {
            this.item = item;
            this.color = color;
        }
    }

    public static List<ColoredItemDataBundle> coloredItemDataBundleList = new ArrayList<>();
    public ClientInfoStorage(Item item, int color)
    {
        coloredItemDataBundleList.add(new ColoredItemDataBundle(item, color));
    }
}
