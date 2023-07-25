package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.fabric.entity.HorseEntities;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import com.matthewperiut.clay.item.horse.HorseDollItem;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.fabric.item.ClayItems.registerMiscItem;

public class HorseDollItems
{
    public static final Item BRICK_HORSE = registerMiscItem("horse/brick", new Item(new FabricItemSettings().fireproof().maxCount(16)));

    public static final HorseDollItem DIRT_HORSE = registerHorseDollItem("horse/dirt", HorseEntities.DIRT_HORSE, 0x593A35);
    public static final HorseDollItem SAND_HORSE = registerHorseDollItem("horse/sand", HorseEntities.SAND_HORSE);
    public static final HorseDollItem GRAVEL_HORSE = registerHorseDollItem("horse/gravel", HorseEntities.GRAVEL_HORSE, 0xAA9F9E);
    public static final HorseDollItem FULL_GRASS_HORSE = registerHorseDollItem("horse/grassy", HorseEntities.FULL_GRASS_HORSE, 0x27B019);
    public static final HorseDollItem FULL_SNOW_HORSE = registerHorseDollItem("horse/snowy", HorseEntities.FULL_SNOW_HORSE, 0xDCEAF2);
    public static final HorseDollItem LAPIS_HORSE = registerHorseDollItem("horse/lapis", HorseEntities.LAPIS_HORSE, 0x3E2EBC);
    public static final HorseDollItem CARROT_HORSE = registerHorseDollItem("horse/carrot", HorseEntities.CARROT_HORSE, 0xFD6800);
    public static final HorseDollItem CLAY_HORSE = registerHorseDollItem("horse/clay", HorseEntities.CLAY_HORSE, 0x969BBA);
    public static final HorseDollItem SOUL_SAND_HORSE = registerHorseDollItem("horse/soul_sand", HorseEntities.SOUL_SAND_HORSE, 0x49372C);
    public static final HorseDollItem CAKE_HORSE = registerHorseDollItem("horse/cake", HorseEntities.CAKE_HORSE);

    public static void register()
    {
        DIRT_HORSE.types.add(HorseEntities.GRASS_HORSE);
        DIRT_HORSE.types.add(HorseEntities.MYCELIUM_HORSE);
        DIRT_HORSE.types.add(HorseEntities.SNOW_HORSE);
    }

    public static HorseDollItem registerHorseDollItem(String name, EntityType<? extends HorseDollEntity> entity, int color)
    {
        HorseDollItem item = registerHorseDollItem(name, entity);
        DispenserBlock.registerBehavior(item, DollDispenserBehavior.DOLL_DISPENSE);
        new ClientInfoStorage(item, color);
        //ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, item);
        return item;
    }

    public static HorseDollItem registerHorseDollItem(String name, EntityType<? extends HorseDollEntity> entity)
    {
        HorseDollItem item = Registry.register(Registries.ITEM, new Identifier(ClayMod.MOD_ID, name), new HorseDollItem(entity, new FabricItemSettings().maxCount(16)));
        ItemGroupEvents.modifyEntriesEvent(ClayItemGroup.CLAY_GROUP).register(entries -> entries.add(item));
        return item;
    }
}
