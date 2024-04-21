package com.matthewperiut.clay.forge;

import com.matthewperiut.clay.ClayMod;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.matthewperiut.clay.ClayMod.MOD_ID;

@Mod(MOD_ID)
public class ClayModForge {
    public ClayModForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(MOD_ID, modEventBus);

        ClayMod.init();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClayMod::initClient);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ClayMod.post();
    }
}
