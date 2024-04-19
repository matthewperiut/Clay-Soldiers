package com.matthewperiut.clay.item.horse;

import com.matthewperiut.clay.item.common.SpawnDollItem;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.function.Supplier;

public class HorseDollItem extends SpawnDollItem
{

    public HorseDollItem(ArrayList<Supplier<EntityType<?>>> types, Settings settings)
    {
        super(types, settings);
    }

    public HorseDollItem(Supplier<EntityType<?>> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }
}
