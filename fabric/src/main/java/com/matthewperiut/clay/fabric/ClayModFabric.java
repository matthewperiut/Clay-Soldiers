package com.matthewperiut.clay.fabric;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.fabric.entity.HorseEntities;
import com.matthewperiut.clay.fabric.entity.SoldierEntities;
import com.matthewperiut.clay.fabric.item.ClayItems;
import net.fabricmc.api.ModInitializer;

public class ClayModFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        ClayMod.init();
        SoldierEntities.register();
        HorseEntities.register();
        ClayItems.registerItems();
    }
}