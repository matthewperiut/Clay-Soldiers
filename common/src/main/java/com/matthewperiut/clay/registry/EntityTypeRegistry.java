package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.entity.soldier.variant.*;
import com.matthewperiut.clay.util.ClientInfoStorage;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.ClayRegistries.getIdentifier;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_SOLDIERS = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<EntityType<?>>>) Registries.ENTITY_TYPE.getKey());
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_HORSES = DeferredRegister.create(ClayMod.MOD_ID, (RegistryKey<Registry<EntityType<?>>>) Registries.ENTITY_TYPE.getKey());
    private static final float SOLDIER_HEIGHT = 0.5f;
    private static final float SOLDIER_WIDTH = 0.25f;

    // Soldiers
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> CLAY_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/clay", () -> EntityType.Builder.create(RegularSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/clay").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> RED_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/red", () -> EntityType.Builder.create(RedSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/red").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> YELLOW_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/yellow", () -> EntityType.Builder.create(YellowSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/yellow").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> GREEN_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/green", () -> EntityType.Builder.create(GreenSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/green").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> BLUE_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/blue", () -> EntityType.Builder.create(BlueSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/blue").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> ORANGE_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/orange", () -> EntityType.Builder.create(OrangeSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/orange").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> MAGENTA_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/magenta", () -> EntityType.Builder.create(MagentaSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/magenta").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> LIGHTBLUE_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/lightblue", () -> EntityType.Builder.create(LightblueSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/lightblue").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> LIME_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/lime", () -> EntityType.Builder.create(LimeSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/lime").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> PINK_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/pink", () -> EntityType.Builder.create(PinkSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/pink").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> CYAN_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/cyan", () -> EntityType.Builder.create(CyanSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/cyan").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> PURPLE_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/purple", () -> EntityType.Builder.create(PurpleSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/purple").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> BROWN_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/brown", () -> EntityType.Builder.create(BrownSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/brown").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> BLACK_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/black", () -> EntityType.Builder.create(BlackSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/black").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> GRAY_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/gray", () -> EntityType.Builder.create(GraySoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/gray").toString()));
    public static final RegistrySupplier<EntityType<? extends SoldierDollEntity>> WHITE_SOLDIER = ENTITY_TYPES_SOLDIERS.register("soldier/white", () -> EntityType.Builder.create(WhiteSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(SOLDIER_WIDTH, SOLDIER_HEIGHT).build(getIdentifier("soldier/white").toString()));

    private static final float HORSE_HEIGHT = 0.3f;
    private static final float HORSE_WIDTH = 0.3f;
    // Horses
    public static final RegistrySupplier<EntityType<HorseDollEntity>> DIRT_HORSE = ENTITY_TYPES_HORSES.register("horse/dirt", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/dirt").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> GRASS_HORSE = ENTITY_TYPES_HORSES.register("horse/grass", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/grass").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> MYCELIUM_HORSE = ENTITY_TYPES_HORSES.register("horse/mycelium", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/mycelium").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> SNOW_HORSE = ENTITY_TYPES_HORSES.register("horse/snow", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/snow").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> SAND_HORSE = ENTITY_TYPES_HORSES.register("horse/sand", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/sand").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> GRAVEL_HORSE = ENTITY_TYPES_HORSES.register("horse/gravel", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/gravel").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> FULL_SNOW_HORSE = ENTITY_TYPES_HORSES.register("horse/snowy", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/snowy").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> FULL_GRASS_HORSE = ENTITY_TYPES_HORSES.register("horse/grassy", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/grassy").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> LAPIS_HORSE = ENTITY_TYPES_HORSES.register("horse/lapis", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/lapis").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> CARROT_HORSE = ENTITY_TYPES_HORSES.register("horse/carrot", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/carrot").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> CLAY_HORSE = ENTITY_TYPES_HORSES.register("horse/clay", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/clay").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> SOUL_SAND_HORSE = ENTITY_TYPES_HORSES.register("horse/soul_sand", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/soul_sand").toString()));
    public static final RegistrySupplier<EntityType<HorseDollEntity>> CAKE_HORSE = ENTITY_TYPES_HORSES.register("horse/cake", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(HORSE_WIDTH, HORSE_HEIGHT).build(getIdentifier("horse/cake").toString()));

    public static void init() {
        ENTITY_TYPES_HORSES.register();
        ENTITY_TYPES_SOLDIERS.register();
    }

    @Environment(EnvType.CLIENT)
    public static void clientRegister() {
        registerSoldier(CLAY_SOLDIER, SoldierDollEntity.TEXTURE_ID);
        registerSoldier(RED_SOLDIER, RedSoldierDoll.TEXTURE_ID);
        registerSoldier(YELLOW_SOLDIER, YellowSoldierDoll.TEXTURE_ID);
        registerSoldier(GREEN_SOLDIER, GreenSoldierDoll.TEXTURE_ID);
        registerSoldier(BLUE_SOLDIER, BlueSoldierDoll.TEXTURE_ID);
        registerSoldier(ORANGE_SOLDIER, OrangeSoldierDoll.TEXTURE_ID);
        registerSoldier(MAGENTA_SOLDIER, MagentaSoldierDoll.TEXTURE_ID);
        registerSoldier(LIGHTBLUE_SOLDIER, LightblueSoldierDoll.TEXTURE_ID);
        registerSoldier(LIME_SOLDIER, LimeSoldierDoll.TEXTURE_ID);
        registerSoldier(PINK_SOLDIER, PinkSoldierDoll.TEXTURE_ID);
        registerSoldier(CYAN_SOLDIER, CyanSoldierDoll.TEXTURE_ID);
        registerSoldier(PURPLE_SOLDIER, PurpleSoldierDoll.TEXTURE_ID);
        registerSoldier(BROWN_SOLDIER, BrownSoldierDoll.TEXTURE_ID);
        registerSoldier(BLACK_SOLDIER, BlackSoldierDoll.TEXTURE_ID);
        registerSoldier(GRAY_SOLDIER, GraySoldierDoll.TEXTURE_ID);
        registerSoldier(WHITE_SOLDIER, WhiteSoldierDoll.TEXTURE_ID);

        registerHorse(DIRT_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt1.png"));
        registerHorse(GRASS_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt2.png"));
        registerHorse(MYCELIUM_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt3.png"));
        registerHorse(SNOW_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt4.png"));
        registerHorse(SAND_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/sand.png"));
        registerHorse(GRAVEL_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/gravel3.png"));
        registerHorse(FULL_GRASS_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/grass1.png"));
        registerHorse(FULL_SNOW_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/snow.png"));
        registerHorse(LAPIS_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/lapis1.png"));
        registerHorse(CARROT_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/carrot1.png"));
        registerHorse(CLAY_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/clay.png"));
        registerHorse(SOUL_SAND_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/soulsand1.png"));
        registerHorse(CAKE_HORSE, new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/cake.png"));
    }

    @Environment(EnvType.CLIENT)
    private static void registerHorse(RegistrySupplier<EntityType<HorseDollEntity>> entityType, Identifier texture) {
        ClientInfoStorage.add(entityType::get, texture, ClientInfoStorage.RendererType.horse.ordinal());
    }

    @Environment(EnvType.CLIENT)
    private static void registerSoldier(RegistrySupplier<EntityType<? extends SoldierDollEntity>> soldierType, Identifier texture) {
        ClientInfoStorage.add(soldierType::get, texture, ClientInfoStorage.RendererType.soldier.ordinal());
    }
}
