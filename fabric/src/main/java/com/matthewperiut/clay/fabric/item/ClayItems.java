package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ClayItems
{
    public static Item registerMiscItem(String name, Item item)
    {
        Item final_item = Registry.register(Registries.ITEM, new Identifier(ClayMod.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(ClayItemGroup.CLAY_MISC_GROUP).register(entries -> entries.add(final_item));
        return final_item;
    }

    public static void registerItems()
    {
        DisruptorItems.register();
        SoldierDollItems.register();
        HorseDollItems.register();
    }
}