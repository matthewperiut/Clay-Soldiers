package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ClayItemGroup
{
    public static final ItemGroup CLAY_GROUP = new ItemGroup(ClayMod.MOD_ID + ".clay_group")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(SoldierDollItems.CLAY_SOLDIER.get());
        }
    };

    public static final ItemGroup CLAY_MISC_GROUP = new ItemGroup(ClayMod.MOD_ID + ".clay_misc_group")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(DisruptorItems.CLAY_DISRUPTOR.get());
        }
    };
}
