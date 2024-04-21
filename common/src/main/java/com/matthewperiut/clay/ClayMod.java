package com.matthewperiut.clay;

import com.matthewperiut.clay.network.client.ClientNetworkHandler;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;

public class ClayMod
{
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "clay";

    public static void init()
    {
        ClayRegistries.init();
    }

    public static void post() {
        ClayRegistries.post();
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ClayRegistries.initClient();
        ClientNetworkHandler.init();
    }
}
