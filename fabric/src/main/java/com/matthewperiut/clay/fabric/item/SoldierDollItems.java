package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.fabric.entity.SoldierEntities;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.fabric.item.ClayItems.registerMiscItem;

public class SoldierDollItems
{
    public static final DispenserBehavior dollDispenserBehavior = new DollDispenserBehavior();
    public static final Item BRICK_SOLDIER = registerMiscItem("soldier/brick", new Item(new FabricItemSettings().fireproof().maxCount(16)));

    public static final Item CLAY_SOLDIER = registerClaySoldierItem("soldier/clay", SoldierEntities.CLAY_SOLDIER, 0xAFB5C6);
    public static final Item RED_SOLDIER = registerClaySoldierItem("soldier/red", SoldierEntities.RED_SOLDIER, 0xF54E42);
    public static final Item YELLOW_SOLDIER = registerClaySoldierItem("soldier/yellow", SoldierEntities.YELLOW_SOLDIER, 0xF3CA2F);
    public static final Item GREEN_SOLDIER = registerClaySoldierItem("soldier/green", SoldierEntities.GREEN_SOLDIER, 0x536D1B);
    public static final Item BLUE_SOLDIER = registerClaySoldierItem("soldier/blue", SoldierEntities.BLUE_SOLDIER, 0x353A9F);
    public static final Item ORANGE_SOLDIER = registerClaySoldierItem("soldier/orange", SoldierEntities.ORANGE_SOLDIER, 0xE66E10);
    public static final Item MAGENTA_SOLDIER = registerClaySoldierItem("soldier/magenta", SoldierEntities.MAGENTA_SOLDIER, 0xBF4CBB);
    public static final Item LIGHTBLUE_SOLDIER = registerClaySoldierItem("soldier/lightblue", SoldierEntities.LIGHTBLUE_SOLDIER, 0x3FB2DB);
    public static final Item LIME_SOLDIER = registerClaySoldierItem("soldier/lime", SoldierEntities.LIME_SOLDIER, 0x73BA1A);
    public static final Item PINK_SOLDIER = registerClaySoldierItem("soldier/pink", SoldierEntities.PINK_SOLDIER, 0xE791B0);
    public static final Item CYAN_SOLDIER = registerClaySoldierItem("soldier/cyan", SoldierEntities.CYAN_SOLDIER, 0x148C93);
    public static final Item PURPLE_SOLDIER = registerClaySoldierItem("soldier/purple", SoldierEntities.PURPLE_SOLDIER, 0x792AAB);
    public static final Item BROWN_SOLDIER = registerClaySoldierItem("soldier/brown", SoldierEntities.BROWN_SOLDIER, 0x744A2B);
    public static final Item BLACK_SOLDIER = registerClaySoldierItem("soldier/black", SoldierEntities.BLACK_SOLDIER, 0x18181D);
    public static final Item GRAY_SOLDIER = registerClaySoldierItem("soldier/gray", SoldierEntities.GRAY_SOLDIER, 0x51585D);
    public static final Item WHITE_SOLDIER = registerClaySoldierItem("soldier/white", SoldierEntities.WHITE_SOLDIER, 0xE2E6EA);

    public static Item registerClaySoldierItem(String name, EntityType<? extends SoldierDollEntity> entity, int color)
    {
        Item item = Registry.register(Registries.ITEM, new Identifier(ClayMod.MOD_ID, name), new SoldierDollItem(entity, new FabricItemSettings().maxCount(16)));
        ItemGroupEvents.modifyEntriesEvent(ClayItemGroup.CLAY_GROUP).register(entries -> entries.add(item));
        DispenserBlock.registerBehavior(item, dollDispenserBehavior);
        new ClientInfoStorage(item, color);
        return item;
    }
    public static void register()
    {

    }
}
