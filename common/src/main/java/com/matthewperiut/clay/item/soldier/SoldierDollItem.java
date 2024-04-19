package com.matthewperiut.clay.item.soldier;

import com.matthewperiut.clay.item.common.SpawnDollItem;
import net.minecraft.entity.EntityType;

import java.util.function.Supplier;

public class SoldierDollItem extends SpawnDollItem
{
    public SoldierDollItem(Supplier<EntityType<?>> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }
}
