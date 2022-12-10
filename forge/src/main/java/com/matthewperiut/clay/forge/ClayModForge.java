package com.matthewperiut.clay.forge;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.forge.entity.ClayEntityTypes;
import com.matthewperiut.clay.forge.entity.HorseDollEntities;
import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import com.matthewperiut.clay.forge.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.matthewperiut.clay.ClayMod.MOD_ID;

@Mod(MOD_ID)
public class ClayModForge
{
    public ClayModForge()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ClayMod.init();
        ClayEntityTypes.register(modEventBus);
        ClayItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(EventPriority.LOWEST, ClayItemGroup::registerCreativeModeTab);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private static void postEntity()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModSetup {
        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            postEntity();
            DisruptorItems.post();
            SoldierDollItems.post();
            HorseDollItems.post();
        }

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void onRegisterAttributes(final EntityAttributeCreationEvent event) {
            // I'll get around to caching these with a list and using that but im tired now
            event.put(SoldierDollEntities.CLAY_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.RED_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.YELLOW_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.GREEN_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.BLUE_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.ORANGE_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.MAGENTA_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.LIGHTBLUE_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.LIME_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.PINK_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.CYAN_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.PURPLE_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.BROWN_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.BLACK_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.GRAY_SOLDIER.get(), SoldierDollEntity.setAttributes());
            event.put(SoldierDollEntities.WHITE_SOLDIER.get(), SoldierDollEntity.setAttributes());

            event.put(HorseDollEntities.DIRT_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.GRASS_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.MYCELIUM_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.SNOW_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.SAND_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.GRAVEL_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.FULL_GRASS_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.FULL_SNOW_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.LAPIS_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.CARROT_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.CLAY_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.SOUL_SAND_HORSE.get(), HorseDollEntity.setAttributes());
            event.put(HorseDollEntities.CAKE_HORSE.get(), HorseDollEntity.setAttributes());
        }

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void clientSetup(FMLClientSetupEvent event)
        {
            ClayModClientForge.setupEntityRenderers();
        }
    }
}
