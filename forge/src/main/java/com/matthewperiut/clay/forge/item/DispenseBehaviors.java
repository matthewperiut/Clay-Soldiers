package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import net.minecraft.block.DispenserBlock;

public class DispenseBehaviors
{
    public static void setupDispenserBehaviors()
    {
        DispenserBlock.registerBehavior(SoldierDollItems.CLAY_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.RED_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.YELLOW_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.GREEN_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.BLUE_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.ORANGE_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.MAGENTA_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.LIGHTBLUE_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.LIME_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.PINK_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.CYAN_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.PURPLE_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.BROWN_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.BLACK_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.GRAY_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(SoldierDollItems.WHITE_SOLDIER.get(), DollDispenserBehavior.DOLL_DISPENSE);

        DispenserBlock.registerBehavior(HorseDollItems.DIRT_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.SAND_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.GRAVEL_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.FULL_GRASS_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.FULL_SNOW_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.LAPIS_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.CARROT_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.CLAY_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.SOUL_SAND_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
        DispenserBlock.registerBehavior(HorseDollItems.CAKE_HORSE.get(), DollDispenserBehavior.DOLL_DISPENSE);
    }
}
