package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;

public class SoldierDollItems
{
    public static final RegistryObject<Item> BRICK_SOLDIER = ITEMS.register("soldier/brick",
            () -> new Item(new Item.Settings().fireproof().maxCount(16)));

    public static final RegistryObject<Item> CLAY_SOLDIER =
            ITEMS.register("soldier/clay", () -> new ForgeDollItem(SoldierDollEntities::getClaySoldier, settings(), 0xAFB5C6));
    public static final RegistryObject<Item> RED_SOLDIER =
            ITEMS.register("soldier/red", () -> new ForgeDollItem(SoldierDollEntities::getRedSoldier, settings(), 0xF54E42));
    public static final RegistryObject<Item> YELLOW_SOLDIER =
            ITEMS.register("soldier/yellow", () -> new ForgeDollItem(SoldierDollEntities::getYellowSoldier, settings(), 0xF3CA2F));
    public static final RegistryObject<Item> GREEN_SOLDIER =
            ITEMS.register("soldier/green", () -> new ForgeDollItem(SoldierDollEntities::getGreenSoldier, settings(), 0x536D1B));
    public static final RegistryObject<Item> BLUE_SOLDIER =
            ITEMS.register("soldier/blue", () -> new ForgeDollItem(SoldierDollEntities::getBlueSoldier, settings(), 0x353A9F));
    public static final RegistryObject<Item> ORANGE_SOLDIER =
            ITEMS.register("soldier/orange", () -> new ForgeDollItem(SoldierDollEntities::getOrangeSoldier, settings(), 0xE66E10));
    public static final RegistryObject<Item> MAGENTA_SOLDIER =
            ITEMS.register("soldier/magenta", () -> new ForgeDollItem(SoldierDollEntities::getMagentaSoldier, settings(), 0xBF4CBB));
    public static final RegistryObject<Item> LIGHTBLUE_SOLDIER =
            ITEMS.register("soldier/lightblue", () -> new ForgeDollItem(SoldierDollEntities::getLightBlueSoldier, settings(), 0x3FB2DB));
    public static final RegistryObject<Item> LIME_SOLDIER =
            ITEMS.register("soldier/lime", () -> new ForgeDollItem(SoldierDollEntities::getLimeSoldier, settings(), 0x73BA1A));
    public static final RegistryObject<Item> PINK_SOLDIER =
            ITEMS.register("soldier/pink", () -> new ForgeDollItem(SoldierDollEntities::getPinkSoldier, settings(), 0xE791B0));
    public static final RegistryObject<Item> CYAN_SOLDIER =
            ITEMS.register("soldier/cyan", () -> new ForgeDollItem(SoldierDollEntities::getCyanSoldier, settings(), 0x148C93));
    public static final RegistryObject<Item> PURPLE_SOLDIER =
            ITEMS.register("soldier/purple", () -> new ForgeDollItem(SoldierDollEntities::getPurpleSoldier, settings(), 0x792AAB));
    public static final RegistryObject<Item> BROWN_SOLDIER =
            ITEMS.register("soldier/brown", () -> new ForgeDollItem(SoldierDollEntities::getBrownSoldier, settings(), 0x744A2B));
    public static final RegistryObject<Item> BLACK_SOLDIER =
            ITEMS.register("soldier/black", () -> new ForgeDollItem(SoldierDollEntities::getBlackSoldier, settings(), 0x18181D));
    public static final RegistryObject<Item> GRAY_SOLDIER =
            ITEMS.register("soldier/gray", () -> new ForgeDollItem(SoldierDollEntities::getGraySoldier, settings(), 0x51585D));
    public static final RegistryObject<Item> WHITE_SOLDIER =
            ITEMS.register("soldier/white", () -> new ForgeDollItem(SoldierDollEntities::getWhiteSoldier, settings(), 0xE2E6EA));

    public static Item.Settings settings()
    {
        return new Item.Settings().maxCount(16);
    }

    public static void register()
    {
        //ClayItemGroup.items.add(new ItemStack(BRICK_SOLDIER.get(), 1));


    }

    public static void post()
    {

    }
}
