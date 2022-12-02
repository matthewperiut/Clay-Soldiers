package com.matthewperiut.clay.forge;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.forge.item.ClayItems;
import com.matthewperiut.clay.forge.item.ClayItemsColorProvider;
import com.matthewperiut.clay.forge.item.SoldierDollItems;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
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
    public static ClayItemsColorProvider clayItemsColorProvider = new ClayItemsColorProvider();;

    public ClayModForge()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ClayMod.init();
        ClayItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public void registerItemColors(RegisterColorHandlersEvent.Item event){
            /*
            event.register(clayItemsColorProvider,
                    SoldierDollItems.CLAY_SOLDIER.get(),
                    SoldierDollItems.RED_SOLDIER.get(),
                    SoldierDollItems.YELLOW_SOLDIER.get(),
                    SoldierDollItems.GREEN_SOLDIER.get(),
                    SoldierDollItems.BLUE_SOLDIER.get(),
                    SoldierDollItems.ORANGE_SOLDIER.get(),
                    SoldierDollItems.MAGENTA_SOLDIER.get(),
                    SoldierDollItems.LIGHTBLUE_SOLDIER.get(),
                    SoldierDollItems.LIME_SOLDIER.get(),
                    SoldierDollItems.PINK_SOLDIER.get(),
                    SoldierDollItems.CYAN_SOLDIER.get(),
                    SoldierDollItems.PURPLE_SOLDIER.get(),
                    SoldierDollItems.BROWN_SOLDIER.get(),
                    SoldierDollItems.BLACK_SOLDIER.get(),
                    SoldierDollItems.GRAY_SOLDIER.get(),
                    SoldierDollItems.WHITE_SOLDIER.get());*/
        }
    }
}
