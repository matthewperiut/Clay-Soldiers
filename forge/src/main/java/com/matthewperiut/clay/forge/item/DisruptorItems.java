package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.item.disruptor.ClayMaterial;
import com.matthewperiut.clay.item.disruptor.DisruptorDispenserBehavior;
import com.matthewperiut.clay.item.disruptor.DisruptorItem;
import com.matthewperiut.clay.item.disruptor.TerracottaMaterial;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;

public class DisruptorItems
{
    public static final DisruptorDispenserBehavior disruptorBehavior = new DisruptorDispenserBehavior();

    public static final RegistryObject<Item> CLAY_DISRUPTOR = ITEMS.register("disruptor/clay", () -> new DisruptorItem(new ClayMaterial(), new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> TERRACOTTA_DISRUPTOR = ITEMS.register("disruptor/terracotta", () -> new DisruptorItem(new TerracottaMaterial(), new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> OBSIDIAN_DISRUPTOR = ITEMS.register("disruptor/obsidian", () -> new DisruptorItem(new Item.Settings().maxCount(1)));

    public static void register()
    {

    }

    public static void post()
    {
        DispenserBlock.registerBehavior(CLAY_DISRUPTOR.get(), disruptorBehavior);
        DispenserBlock.registerBehavior(TERRACOTTA_DISRUPTOR.get(), disruptorBehavior);
        DispenserBlock.registerBehavior(OBSIDIAN_DISRUPTOR.get(), disruptorBehavior);
    }
}
