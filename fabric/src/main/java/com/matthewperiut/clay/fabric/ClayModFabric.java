package com.matthewperiut.clay.fabric;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class ClayModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ClayMod.init();
        ItemRegistry.post();
    }
}