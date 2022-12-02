package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class ForgeSoldierDollItem extends SoldierDollItem
{
    private static final List<ForgeSoldierDollItem> soldiers = new ArrayList<>();
    int color;

    public ForgeSoldierDollItem(EntityType<? extends MobEntity> defaultType, Settings settings, int color)
    {
        super(defaultType, settings);
        this.color = color;

        soldiers.add(this);
    }

    public ForgeSoldierDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(defaultType, settings);
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ClayMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerItemColors(RegisterColorHandlersEvent.Item event)
        {
            for (ForgeSoldierDollItem soldier : soldiers)
            {
                event.register((stack, tintIndex) -> soldier.color, soldier);
            }
        }
    }
}
