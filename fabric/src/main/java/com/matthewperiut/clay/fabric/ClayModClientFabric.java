package com.matthewperiut.clay.fabric;

import com.matthewperiut.clay.ClayMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ClayModClientFabric implements ClientModInitializer {
    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        ClayMod.initClient();
    }
}
