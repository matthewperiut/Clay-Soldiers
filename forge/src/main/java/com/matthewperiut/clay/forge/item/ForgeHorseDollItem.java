package com.matthewperiut.clay.forge.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

public class ForgeHorseDollItem extends ForgeSoldierDollItem
{

    public ForgeHorseDollItem(EntityType<? extends MobEntity> defaultType, Settings settings, int color)
    {
        super(defaultType, settings, color);
    }

    public ForgeHorseDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }
}
