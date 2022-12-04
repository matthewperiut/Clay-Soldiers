package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.forge.entity.HorseDollEntities;
import net.minecraft.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;
import static com.matthewperiut.clay.forge.item.SoldierDollItems.settings;

public class HorseDollItems
{
    public static final RegistryObject<Item> BRICK_HORSE = ITEMS.register("horse/brick",
            () -> new Item(new Item.Settings().fireproof().maxCount(16).group(ClayItemGroup.CLAY_MISC_GROUP)));

    public static final RegistryObject<Item> DIRT_HORSE =
            ITEMS.register("horse/dirt", () -> new ForgeDollItem(HorseDollEntities::getDirtHorse, settings(), 0x593A35));
    public static final RegistryObject<Item> SAND_HORSE =
            ITEMS.register("horse/sand", () -> new ForgeDollItem(HorseDollEntities::getSandHorse, settings()));
    public static final RegistryObject<Item> GRAVEL_HORSE =
            ITEMS.register("horse/gravel", () -> new ForgeDollItem(HorseDollEntities::getGravelHorse, settings(), 0xAA9F9E));
    public static final RegistryObject<Item> FULL_GRASS_HORSE =
            ITEMS.register("horse/grassy", () -> new ForgeDollItem(HorseDollEntities::getFullGrassHorse, settings(), 0x27B019));
    public static final RegistryObject<Item> FULL_SNOW_HORSE =
            ITEMS.register("horse/snowy", () -> new ForgeDollItem(HorseDollEntities::getFullSnowHorse, settings(), 0xDCEAF2));
    public static final RegistryObject<Item> LAPIS_HORSE =
            ITEMS.register("horse/lapis", () -> new ForgeDollItem(HorseDollEntities::getLapisHorse, settings(), 0x3E2EBC));
    public static final RegistryObject<Item> CARROT_HORSE =
            ITEMS.register("horse/carrot", () -> new ForgeDollItem(HorseDollEntities::getCarrotHorse, settings(), 0xFD6800));
    public static final RegistryObject<Item> CLAY_HORSE =
            ITEMS.register("horse/clay", () -> new ForgeDollItem(HorseDollEntities::getClayHorse, settings(), 0x969BBA));
    public static final RegistryObject<Item> SOUL_SAND_HORSE =
            ITEMS.register("horse/soul_sand", () -> new ForgeDollItem(HorseDollEntities::getSoulSandHorse, settings(), 0x49372C));
    public static final RegistryObject<Item> CAKE_HORSE =
            ITEMS.register("horse/cake", () -> new ForgeDollItem(HorseDollEntities::getCakeHorse, settings()));

    public static void register()
    {

    }

    public static void post()
    {

        ((ForgeDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities::getGrassHorse);
        ((ForgeDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities::getMyceliumHorse);
        ((ForgeDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities::getSnowHorse);
    }
}
