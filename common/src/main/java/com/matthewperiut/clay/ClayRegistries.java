package com.matthewperiut.clay;

import com.matthewperiut.clay.registry.*;
import net.minecraft.util.Identifier;

public class ClayRegistries {

    public static void init() {

        EntityTypeRegistry.init();
        AttributeRegistry.init();
        TabsRegistry.init();
        ItemRegistry.init();

    }

    public static void initClient() {
        EntityTypeRegistry.clientRegister();
        ItemRegistry.clientRegister();
        RenderRegistry.init();
    }


    public static Identifier getIdentifier(String name) {
        return new Identifier(ClayMod.MOD_ID, name);
    }

}
