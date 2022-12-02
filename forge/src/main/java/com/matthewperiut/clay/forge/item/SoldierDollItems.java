package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.forge.ClayModForge;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;

public class SoldierDollItems
{
    public static final DispenserBehavior dollDispenserBehavior = new DollDispenserBehavior();

    public static final RegistryObject<Item> BRICK_SOLDIER = ITEMS.register("soldier/brick",
            () -> new Item(new Item.Settings().fireproof().maxCount(16).group(ClayItemGroup.CLAY_MISC_GROUP)));

    public static final RegistryObject<Item> CLAY_SOLDIER = registerClaySoldierItem("soldier/clay", EntityType.BEE, 0xAFB5C6);
    public static final RegistryObject<Item> RED_SOLDIER = registerClaySoldierItem("soldier/red", EntityType.BEE, 0xF54E42);
    public static final RegistryObject<Item> YELLOW_SOLDIER = registerClaySoldierItem("soldier/yellow", EntityType.BEE, 0xF3CA2F);
    public static final RegistryObject<Item> GREEN_SOLDIER = registerClaySoldierItem("soldier/green", EntityType.BEE, 0x536D1B);
    public static final RegistryObject<Item> BLUE_SOLDIER = registerClaySoldierItem("soldier/blue", EntityType.BEE, 0x353A9F);
    public static final RegistryObject<Item> ORANGE_SOLDIER = registerClaySoldierItem("soldier/orange", EntityType.BEE, 0xE66E10);
    public static final RegistryObject<Item> MAGENTA_SOLDIER = registerClaySoldierItem("soldier/magenta", EntityType.BEE, 0xBF4CBB);
    public static final RegistryObject<Item> LIGHTBLUE_SOLDIER = registerClaySoldierItem("soldier/lightblue", EntityType.BEE, 0x3FB2DB);
    public static final RegistryObject<Item> LIME_SOLDIER = registerClaySoldierItem("soldier/lime", EntityType.BEE, 0x73BA1A);
    public static final RegistryObject<Item> PINK_SOLDIER = registerClaySoldierItem("soldier/pink", EntityType.BEE, 0xE791B0);
    public static final RegistryObject<Item> CYAN_SOLDIER = registerClaySoldierItem("soldier/cyan", EntityType.BEE, 0x148C93);
    public static final RegistryObject<Item> PURPLE_SOLDIER = registerClaySoldierItem("soldier/purple", EntityType.BEE, 0x792AAB);
    public static final RegistryObject<Item> BROWN_SOLDIER = registerClaySoldierItem("soldier/brown", EntityType.BEE, 0x744A2B);
    public static final RegistryObject<Item> BLACK_SOLDIER = registerClaySoldierItem("soldier/black", EntityType.BEE, 0x18181D);
    public static final RegistryObject<Item> GRAY_SOLDIER = registerClaySoldierItem("soldier/gray", EntityType.BEE, 0x51585D);
    public static final RegistryObject<Item> WHITE_SOLDIER = registerClaySoldierItem("soldier/white", EntityType.BEE, 0xE2E6EA);

    public static RegistryObject<Item> registerClaySoldierItem(String name, EntityType<? extends MobEntity> entity, int color)
    {
        RegistryObject<Item> item = ITEMS.register(name, () -> new SoldierDollItem(entity, new Item.Settings().maxCount(1).group(ClayItemGroup.CLAY_GROUP)));
        // DispenserBlock.registerBehavior(item.get(), dollDispenserBehavior);
        // (fabric) ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, item);
        // ClayModForge.clayItemsColorProvider.addColoredItem(item.get(), color);
        return item;
    }

    public static void register()
    {

    }
}
