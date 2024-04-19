package com.matthewperiut.clay;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Random;

public class ClayMod
{
    public static Random random = new Random();
    public static final String MOD_ID = "clay";

    public static void init()
    {
        ClayRegistries.init();
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ClayRegistries.initClient();
    }
}
