package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.entity.soldier.variant.RegularSoldierDoll;
import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;

public class SoldierDollItems
{
    public static final DispenserBehavior dollDispenserBehavior = new DollDispenserBehavior();

    public static final RegistryObject<Item> BRICK_SOLDIER = ITEMS.register("soldier/brick",
            () -> new Item(new Item.Settings().fireproof().maxCount(16).group(ClayItemGroup.CLAY_MISC_GROUP)));

    public static final RegistryObject<Item> CLAY_SOLDIER = registerClaySoldierItem("soldier/clay", SoldierDollEntities.CLAY_SOLDIER, 0xAFB5C6);
    public static final RegistryObject<Item> RED_SOLDIER = registerClaySoldierItem("soldier/red", SoldierDollEntities.RED_SOLDIER, 0xF54E42);
    public static final RegistryObject<Item> YELLOW_SOLDIER = registerClaySoldierItem("soldier/yellow", SoldierDollEntities.YELLOW_SOLDIER, 0xF3CA2F);
    public static final RegistryObject<Item> GREEN_SOLDIER = registerClaySoldierItem("soldier/green", SoldierDollEntities.GREEN_SOLDIER, 0x536D1B);
    public static final RegistryObject<Item> BLUE_SOLDIER = registerClaySoldierItem("soldier/blue", SoldierDollEntities.BLUE_SOLDIER, 0x353A9F);
    public static final RegistryObject<Item> ORANGE_SOLDIER = registerClaySoldierItem("soldier/orange", SoldierDollEntities.ORANGE_SOLDIER, 0xE66E10);
    public static final RegistryObject<Item> MAGENTA_SOLDIER = registerClaySoldierItem("soldier/magenta", SoldierDollEntities.MAGENTA_SOLDIER, 0xBF4CBB);
    public static final RegistryObject<Item> LIGHTBLUE_SOLDIER = registerClaySoldierItem("soldier/lightblue", SoldierDollEntities.LIGHTBLUE_SOLDIER, 0x3FB2DB);
    public static final RegistryObject<Item> LIME_SOLDIER = registerClaySoldierItem("soldier/lime", SoldierDollEntities.LIME_SOLDIER, 0x73BA1A);
    public static final RegistryObject<Item> PINK_SOLDIER = registerClaySoldierItem("soldier/pink", SoldierDollEntities.PINK_SOLDIER, 0xE791B0);
    public static final RegistryObject<Item> CYAN_SOLDIER = registerClaySoldierItem("soldier/cyan", SoldierDollEntities.CYAN_SOLDIER, 0x148C93);
    public static final RegistryObject<Item> PURPLE_SOLDIER = registerClaySoldierItem("soldier/purple", SoldierDollEntities.PURPLE_SOLDIER, 0x792AAB);
    public static final RegistryObject<Item> BROWN_SOLDIER = registerClaySoldierItem("soldier/brown", SoldierDollEntities.BROWN_SOLDIER, 0x744A2B);
    public static final RegistryObject<Item> BLACK_SOLDIER = registerClaySoldierItem("soldier/black", SoldierDollEntities.BLACK_SOLDIER, 0x18181D);
    public static final RegistryObject<Item> GRAY_SOLDIER = registerClaySoldierItem("soldier/gray", SoldierDollEntities.GRAY_SOLDIER, 0x51585D);
    public static final RegistryObject<Item> WHITE_SOLDIER = registerClaySoldierItem("soldier/white", SoldierDollEntities.WHITE_SOLDIER, 0xE2E6EA);

    public static RegistryObject<Item> registerClaySoldierItem(String name, RegistryObject<?> entity, int color)
    {
        RegistryObject<EntityType<SoldierDollEntity>> use = (RegistryObject<EntityType<SoldierDollEntity>>) entity;
        RegistryObject<Item> item = ITEMS.register(name, () -> new ForgeSoldierDollItem(use.get(), new Item.Settings().maxCount(16).group(ClayItemGroup.CLAY_GROUP), color));
        return item;
    }

    public static void register()
    {

    }

    public static void post()
    {
        DispenserBlock.registerBehavior(CLAY_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(RED_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(YELLOW_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(GREEN_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(BLUE_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(ORANGE_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(MAGENTA_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(LIGHTBLUE_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(LIME_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(PINK_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(CYAN_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(PURPLE_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(BROWN_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(BLACK_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(GRAY_SOLDIER.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(WHITE_SOLDIER.get(), dollDispenserBehavior);
    }
}
