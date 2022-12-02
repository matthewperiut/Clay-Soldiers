package com.matthewperiut.clay.item.soldier;

import com.matthewperiut.clay.item.common.SpawnDollItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

public class SoldierDollItem extends SpawnDollItem
{
    public SoldierDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }
}
