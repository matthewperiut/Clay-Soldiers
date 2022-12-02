package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ClayItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClayMod.MOD_ID);

    public static RegistryObject<Item> registerItem(String name, Item item)
    {
        return ITEMS.register(name, () -> new Item(new Item.Settings().maxCount(1).group(ClayItemGroup.CLAY_GROUP)));
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
        DisruptorItems.register();
        SoldierDollItems.register();
        HorseDollItems.register();
    }
}
