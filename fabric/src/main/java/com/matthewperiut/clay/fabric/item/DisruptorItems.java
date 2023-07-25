package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.item.disruptor.ClayMaterial;
import com.matthewperiut.clay.item.disruptor.DisruptorDispenserBehavior;
import com.matthewperiut.clay.item.disruptor.DisruptorItem;
import com.matthewperiut.clay.item.disruptor.TerracottaMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;

import static com.matthewperiut.clay.fabric.item.ClayItems.registerMiscItem;

public class DisruptorItems
{
    public static final DisruptorDispenserBehavior disruptorBehavior = new DisruptorDispenserBehavior();
    public static Item CLAY_DISRUPTOR = registerMiscItem("disruptor/clay", new DisruptorItem(new ClayMaterial(), new FabricItemSettings().maxCount(1)));
    public static Item TERRACOTTA_DISRUPTOR = registerMiscItem("disruptor/terracotta", new DisruptorItem(new TerracottaMaterial(), new FabricItemSettings().maxCount(1)));
    public static Item OBSIDIAN_DISRUPTOR = registerMiscItem("disruptor/obsidian", new DisruptorItem(new FabricItemSettings().maxCount(1)));

    public static void register()
    {
        DispenserBlock.registerBehavior(CLAY_DISRUPTOR, disruptorBehavior);
        DispenserBlock.registerBehavior(TERRACOTTA_DISRUPTOR, disruptorBehavior);
        DispenserBlock.registerBehavior(OBSIDIAN_DISRUPTOR, disruptorBehavior);
    }
}
