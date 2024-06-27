package com.matthewperiut.entris.neoforge;

import com.matthewperiut.clay.ClayMod;
import dev.architectury.utils.EnvExecutor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static software.bernie.geckolib.GeckoLibConstants.MODID;

@Mod(ClayMod.MOD_ID)
public class ClayModNeoForge {
    // Define mod id in a common place for everything to reference
    // Directly reference a slf4j logger

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ClayModNeoForge(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ClayMod.init();
        NeoForge.EVENT_BUS.register(this);
        EnvExecutor.runInEnv(Dist.CLIENT, () -> ClayMod::initClient);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ClayMod.post();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
/*
    @EventBusSubscriber(modid = ClayMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ClayMod.initClient();
        }
    }*/
}
