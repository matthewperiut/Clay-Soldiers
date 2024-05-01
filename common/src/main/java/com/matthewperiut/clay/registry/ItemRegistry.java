package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.item.armor.TinyChestplateArmorItem;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import com.matthewperiut.clay.item.disruptor.ClayMaterial;
import com.matthewperiut.clay.item.disruptor.DisruptorDispenserBehavior;
import com.matthewperiut.clay.item.disruptor.DisruptorItem;
import com.matthewperiut.clay.item.disruptor.TerracottaMaterial;
import com.matthewperiut.clay.item.horse.HorseDollItem;
import com.matthewperiut.clay.item.soldier.SoldierDollItem;
import com.matthewperiut.clay.util.ClientInfoStorage;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

import java.util.function.Supplier;

import static com.matthewperiut.clay.registry.EntityTypeRegistry.*;
import static com.matthewperiut.clay.registry.TabsRegistry.CLAY_GROUP;
import static com.matthewperiut.clay.registry.TabsRegistry.CLAY_MISC_GROUP;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<Item>>) Registries.ITEM.getKey());
    public static final DeferredRegister<Item> HORSE_ITEMS = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<Item>>) Registries.ITEM.getKey());
    public static final DeferredRegister<Item> MISC_ITEMS = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<Item>>) Registries.ITEM.getKey());
    public static final DeferredRegister<Item> INTERNAL_ITEMS = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<Item>>) Registries.ITEM.getKey());

    // Soldiers
    public static final RegistrySupplier<Item> BRICK_SOLDIER = registerMiscItem("soldier/brick", () -> new Item(miscSettings()));

    public static final RegistrySupplier<Item> CLAY_SOLDIER_ITEM = registerItem("soldier/clay", CLAY_SOLDIER);
    public static final RegistrySupplier<Item> RED_SOLDIER_ITEM = registerItem("soldier/red", RED_SOLDIER);
    public static final RegistrySupplier<Item> YELLOW_SOLDIER_ITEM = registerItem("soldier/yellow", YELLOW_SOLDIER);
    public static final RegistrySupplier<Item> GREEN_SOLDIER_ITEM = registerItem("soldier/green", GREEN_SOLDIER);
    public static final RegistrySupplier<Item> BLUE_SOLDIER_ITEM = registerItem("soldier/blue", BLUE_SOLDIER);
    public static final RegistrySupplier<Item> ORANGE_SOLDIER_ITEM = registerItem("soldier/orange", ORANGE_SOLDIER);
    public static final RegistrySupplier<Item> MAGENTA_SOLDIER_ITEM = registerItem("soldier/magenta", MAGENTA_SOLDIER);
    public static final RegistrySupplier<Item> LIGHTBLUE_SOLDIER_ITEM = registerItem("soldier/lightblue", LIGHTBLUE_SOLDIER);
    public static final RegistrySupplier<Item> LIME_SOLDIER_ITEM = registerItem("soldier/lime", LIME_SOLDIER);
    public static final RegistrySupplier<Item> PINK_SOLDIER_ITEM = registerItem("soldier/pink", PINK_SOLDIER);
    public static final RegistrySupplier<Item> CYAN_SOLDIER_ITEM = registerItem("soldier/cyan", CYAN_SOLDIER);
    public static final RegistrySupplier<Item> PURPLE_SOLDIER_ITEM = registerItem("soldier/purple", PURPLE_SOLDIER);
    public static final RegistrySupplier<Item> BROWN_SOLDIER_ITEM = registerItem("soldier/brown", BROWN_SOLDIER);
    public static final RegistrySupplier<Item> BLACK_SOLDIER_ITEM = registerItem("soldier/black", BLACK_SOLDIER);
    public static final RegistrySupplier<Item> GRAY_SOLDIER_ITEM = registerItem("soldier/gray", GRAY_SOLDIER);
    public static final RegistrySupplier<Item> WHITE_SOLDIER_ITEM = registerItem("soldier/white", WHITE_SOLDIER);

    // horses
    public static final RegistrySupplier<Item> BRICK_HORSE = registerMiscItem("horse/brick", () -> new Item(miscSettings()));

    public static final RegistrySupplier<Item> DIRT_HORSE_ITEM = registerHorseDollItem("horse/dirt", DIRT_HORSE);
    public static final RegistrySupplier<Item> SAND_HORSE_ITEM = registerHorseDollItem("horse/sand", SAND_HORSE);
    public static final RegistrySupplier<Item> GRAVEL_HORSE_ITEM = registerHorseDollItem("horse/gravel", GRAVEL_HORSE);
    public static final RegistrySupplier<Item> FULL_GRASS_HORSE_ITEM = registerHorseDollItem("horse/grassy", FULL_GRASS_HORSE);
    public static final RegistrySupplier<Item> FULL_SNOW_HORSE_ITEM = registerHorseDollItem("horse/snowy", FULL_SNOW_HORSE);
    public static final RegistrySupplier<Item> LAPIS_HORSE_ITEM = registerHorseDollItem("horse/lapis", LAPIS_HORSE);
    public static final RegistrySupplier<Item> CARROT_HORSE_ITEM = registerHorseDollItem("horse/carrot", CARROT_HORSE);
    public static final RegistrySupplier<Item> CLAY_HORSE_ITEM = registerHorseDollItem("horse/clay", CLAY_HORSE);
    public static final RegistrySupplier<Item> SOUL_SAND_HORSE_ITEM = registerHorseDollItem("horse/soul_sand", SOUL_SAND_HORSE);
    public static final RegistrySupplier<Item> CAKE_HORSE_ITEM = registerHorseDollItem("horse/cake", CAKE_HORSE);


    // misc
    public static RegistrySupplier<Item> CLAY_DISRUPTOR = registerMiscItem("disruptor/clay", () -> new DisruptorItem(new ClayMaterial(), new Item.Settings().maxCount(1).arch$tab(CLAY_MISC_GROUP)));
    public static RegistrySupplier<Item> TERRACOTTA_DISRUPTOR = registerMiscItem("disruptor/terracotta", () -> new DisruptorItem(new TerracottaMaterial(), new Item.Settings().maxCount(1).arch$tab(CLAY_MISC_GROUP)));
    public static RegistrySupplier<Item> OBSIDIAN_DISRUPTOR = registerMiscItem("disruptor/obsidian", () -> new DisruptorItem(new Item.Settings().maxCount(1).arch$tab(CLAY_MISC_GROUP)));


    // internal
    public static RegistrySupplier<Item> TINY_CHESTPLATE = INTERNAL_ITEMS.register("armor/tiny_chestplate", () -> new TinyChestplateArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings()));

    public static void init() {
        ITEMS.register();
        HORSE_ITEMS.register();
        MISC_ITEMS.register();
        INTERNAL_ITEMS.register();
    }

    public static void post() {
        HORSE_ITEMS.forEach(e -> {
            DispenserBlock.registerBehavior(e.get(), DollDispenserBehavior.DOLL_DISPENSE);
        });
        ITEMS.forEach(e -> {
            DispenserBlock.registerBehavior(e.get(), DollDispenserBehavior.DOLL_DISPENSE);
        });

        DisruptorDispenserBehavior dispenserBehavior = new DisruptorDispenserBehavior();

        DispenserBlock.registerBehavior(CLAY_DISRUPTOR.get(), dispenserBehavior);
        DispenserBlock.registerBehavior(TERRACOTTA_DISRUPTOR.get(), dispenserBehavior);
        DispenserBlock.registerBehavior(OBSIDIAN_DISRUPTOR.get(), dispenserBehavior);

        HorseDollItem dirtHorseItem = ((HorseDollItem) DIRT_HORSE_ITEM.get());
        dirtHorseItem.types.add(GRASS_HORSE::get);
        dirtHorseItem.types.add(MYCELIUM_HORSE::get);
        dirtHorseItem.types.add(SNOW_HORSE::get);
    }

    @Environment(EnvType.CLIENT)
    public static void clientRegister() {
        ClientInfoStorage.add(CLAY_SOLDIER_ITEM, 0xAFB5C6);
        ClientInfoStorage.add(RED_SOLDIER_ITEM, 0xF54E42);
        ClientInfoStorage.add(YELLOW_SOLDIER_ITEM, 0xF3CA2F);
        ClientInfoStorage.add(GREEN_SOLDIER_ITEM, 0x536D1B);
        ClientInfoStorage.add(BLUE_SOLDIER_ITEM, 0x353A9F);
        ClientInfoStorage.add(ORANGE_SOLDIER_ITEM, 0xE66E10);
        ClientInfoStorage.add(MAGENTA_SOLDIER_ITEM, 0xBF4CBB);
        ClientInfoStorage.add(LIGHTBLUE_SOLDIER_ITEM, 0x3FB2DB);
        ClientInfoStorage.add(LIME_SOLDIER_ITEM, 0x73BA1A);
        ClientInfoStorage.add(PINK_SOLDIER_ITEM, 0xE791B0);
        ClientInfoStorage.add(CYAN_SOLDIER_ITEM, 0x148C93);
        ClientInfoStorage.add(PURPLE_SOLDIER_ITEM, 0x792AAB);
        ClientInfoStorage.add(BROWN_SOLDIER_ITEM, 0x744A2B);
        ClientInfoStorage.add(BLACK_SOLDIER_ITEM, 0x18181D);
        ClientInfoStorage.add(GRAY_SOLDIER_ITEM, 0x51585D);
        ClientInfoStorage.add(WHITE_SOLDIER_ITEM, 0xE2E6EA);

        // Horses
        ClientInfoStorage.add(DIRT_HORSE_ITEM, 0x593A35);
        ClientInfoStorage.add(GRAVEL_HORSE_ITEM, 0xAA9F9E);
        ClientInfoStorage.add(FULL_GRASS_HORSE_ITEM, 0x27B019);
        ClientInfoStorage.add(FULL_SNOW_HORSE_ITEM, 0xDCEAF2);
        ClientInfoStorage.add(LAPIS_HORSE_ITEM, 0x3E2EBC);
        ClientInfoStorage.add(CARROT_HORSE_ITEM, 0xFD6800);
        ClientInfoStorage.add(CLAY_HORSE_ITEM, 0x969BBA);
        ClientInfoStorage.add(SOUL_SAND_HORSE_ITEM, 0x49372C);
    }

    public static RegistrySupplier<Item> registerItem(String name, RegistrySupplier<EntityType<? extends SoldierDollEntity>> entity) {
        return ITEMS.register(name, () -> new SoldierDollItem(entity::get, settings()));
    }

    public static RegistrySupplier<Item> registerHorseDollItem(String name, RegistrySupplier<EntityType<HorseDollEntity>> entity) {
        return HORSE_ITEMS.register(name, () -> new HorseDollItem(entity::get, settings()));
    }

    public static RegistrySupplier<Item> registerMiscItem(String name, Supplier<Item> item) {
        return MISC_ITEMS.register(name, item);
    }

    private static Item.Settings settings() {
        return new Item.Settings().maxCount(16).arch$tab(CLAY_GROUP);
    }

    private static Item.Settings miscSettings() {
        return new Item.Settings().fireproof().maxCount(16).arch$tab(CLAY_MISC_GROUP);
    }
}
