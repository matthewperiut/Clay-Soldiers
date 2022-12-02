package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayItems
{
    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(ClayMod.MOD_ID, name), item);
    }

    public static void registerItems()
    {
        DisruptorItems.register();
        SoldierDollItems.register();
        HorseDollItems.register();
    }
}