package com.matthewperiut.clay.fabric;

import com.matthewperiut.clay.ClayMod;
import net.fabricmc.api.ModInitializer;

public class ClayModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ClayMod.init();
        ClayMod.post();
    }
}