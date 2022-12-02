package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.forge.entity.HorseDollEntities;
import com.matthewperiut.clay.item.horse.HorseDollItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.item.ClayItems.ITEMS;
import static com.matthewperiut.clay.forge.item.SoldierDollItems.dollDispenserBehavior;

public class HorseDollItems
{
    public static final RegistryObject<Item> BRICK_HORSE = ITEMS.register("horse/brick",
            () -> new Item(new Item.Settings().fireproof().maxCount(16).group(ClayItemGroup.CLAY_MISC_GROUP)));

    public static final RegistryObject<Item> DIRT_HORSE = registerHorseDollItem("horse/dirt", HorseDollEntities.DIRT_HORSE, 0x593A35);
    public static final RegistryObject<Item> SAND_HORSE = registerHorseDollItem("horse/sand", HorseDollEntities.SAND_HORSE);
    public static final RegistryObject<Item> GRAVEL_HORSE = registerHorseDollItem("horse/gravel", HorseDollEntities.GRAVEL_HORSE, 0xAA9F9E);
    public static final RegistryObject<Item> FULL_GRASS_HORSE = registerHorseDollItem("horse/grassy", HorseDollEntities.FULL_GRASS_HORSE, 0x27B019);
    public static final RegistryObject<Item> FULL_SNOW_HORSE = registerHorseDollItem("horse/snowy", HorseDollEntities.FULL_SNOW_HORSE, 0xDCEAF2);
    public static final RegistryObject<Item> LAPIS_HORSE = registerHorseDollItem("horse/lapis", HorseDollEntities.LAPIS_HORSE, 0x3E2EBC);
    public static final RegistryObject<Item> CARROT_HORSE = registerHorseDollItem("horse/carrot", HorseDollEntities.CARROT_HORSE, 0xFD6800);
    public static final RegistryObject<Item> CLAY_HORSE = registerHorseDollItem("horse/clay", HorseDollEntities.CLAY_HORSE, 0x969BBA);
    public static final RegistryObject<Item> SOUL_SAND_HORSE = registerHorseDollItem("horse/soul_sand", HorseDollEntities.SOUL_SAND_HORSE, 0x49372C);
    public static final RegistryObject<Item> CAKE_HORSE = registerHorseDollItem("horse/cake", HorseDollEntities.CAKE_HORSE);

    public static void register()
    {

    }

    public static RegistryObject<Item> registerHorseDollItem(String name, RegistryObject<?> entity, int color)
    {
        RegistryObject<EntityType<HorseDollEntity>> use = (RegistryObject<EntityType<HorseDollEntity>>) entity;
        RegistryObject<Item> item = ITEMS.register(name, () -> new ForgeHorseDollItem(use.get(), new Item.Settings().maxCount(16).group(ClayItemGroup.CLAY_GROUP), color));
        return item;
    }

    public static RegistryObject<Item> registerHorseDollItem(String name, RegistryObject<?> entity)
    {
        RegistryObject<EntityType<HorseDollEntity>> use = (RegistryObject<EntityType<HorseDollEntity>>) entity;
        RegistryObject<Item> item = ITEMS.register(name, () -> new ForgeHorseDollItem(use.get(), new Item.Settings().maxCount(16).group(ClayItemGroup.CLAY_GROUP)));
        return item;
    }

    public static void post()
    {
        DispenserBlock.registerBehavior(DIRT_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(SAND_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(GRAVEL_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(FULL_GRASS_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(FULL_SNOW_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(LAPIS_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(CARROT_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(CLAY_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(SOUL_SAND_HORSE.get(), dollDispenserBehavior);
        DispenserBlock.registerBehavior(CAKE_HORSE.get(), dollDispenserBehavior);

        ((ForgeHorseDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities.GRASS_HORSE.get());
        ((ForgeHorseDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities.MYCELIUM_HORSE.get());
        ((ForgeHorseDollItem) DIRT_HORSE.get()).types.add(HorseDollEntities.SNOW_HORSE.get());
    }
}
