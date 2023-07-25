package com.matthewperiut.clay.forge.entity;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.entity.ClayEntityTypes.ENTITY_TYPES;

public class HorseDollEntities
{
    private static final float height = 0.3f;
    private static final float width = 0.3f;

    public static final RegistryObject<EntityType<HorseDollEntity>> DIRT_HORSE = ENTITY_TYPES.register("horse/dirt", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/dirt").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> GRASS_HORSE = ENTITY_TYPES.register("horse/grass", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/grass").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> MYCELIUM_HORSE = ENTITY_TYPES.register("horse/mycelium", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/mycelium").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> SNOW_HORSE = ENTITY_TYPES.register("horse/snow", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/snow").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> SAND_HORSE = ENTITY_TYPES.register("horse/sand", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/sand").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> GRAVEL_HORSE = ENTITY_TYPES.register("horse/gravel", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/gravel").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> FULL_SNOW_HORSE = ENTITY_TYPES.register("horse/snowy", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/snowy").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> FULL_GRASS_HORSE = ENTITY_TYPES.register("horse/grassy", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/grassy").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> LAPIS_HORSE = ENTITY_TYPES.register("horse/lapis", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/lapis").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> CARROT_HORSE = ENTITY_TYPES.register("horse/carrot", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/carrot").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> CLAY_HORSE = ENTITY_TYPES.register("horse/clay", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/clay").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> SOUL_SAND_HORSE = ENTITY_TYPES.register("horse/soul_sand", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/soul_sand").toString()));
    public static final RegistryObject<EntityType<HorseDollEntity>> CAKE_HORSE = ENTITY_TYPES.register("horse/cake", () -> EntityType.Builder.create(HorseDollEntity::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "horse/cake").toString()));

    public static void clientRegister()
    {
        registerHorse(DIRT_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt1.png"));
        registerHorse(GRASS_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt2.png"));
        registerHorse(MYCELIUM_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt3.png"));
        registerHorse(SNOW_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/dirt4.png"));
        registerHorse(SAND_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/sand.png"));
        registerHorse(GRAVEL_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/gravel3.png"));
        registerHorse(FULL_GRASS_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/grass1.png"));
        registerHorse(FULL_SNOW_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/snow.png"));
        registerHorse(LAPIS_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/lapis1.png"));
        registerHorse(CARROT_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/carrot1.png"));
        registerHorse(CLAY_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/clay.png"));
        registerHorse(SOUL_SAND_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/soulsand1.png"));
        registerHorse(CAKE_HORSE.get(), new Identifier(ClayMod.MOD_ID, "textures/entity/mount/horse/cake.png"));
    }

    private static void registerHorse(EntityType<? extends HorseDollEntity> entityType, Identifier texture)
    {
        new ClientInfoStorage(entityType, texture, ClientInfoStorage.RendererType.horse.ordinal());
    }

    public static void register()
    {

    }

    // Suppliers
    public static EntityType<HorseDollEntity> getDirtHorse()
    {
        return DIRT_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getGrassHorse()
    {
        return GRASS_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getMyceliumHorse()
    {
        return MYCELIUM_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getSnowHorse()
    {
        return SNOW_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getSandHorse()
    {
        return SAND_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getGravelHorse()
    {
        return GRAVEL_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getFullGrassHorse()
    {
        return FULL_GRASS_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getFullSnowHorse()
    {
        return FULL_SNOW_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getLapisHorse()
    {
        return LAPIS_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getCarrotHorse()
    {
        return CARROT_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getClayHorse()
    {
        return CLAY_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getSoulSandHorse()
    {
        return SOUL_SAND_HORSE.get();
    }

    public static EntityType<HorseDollEntity> getCakeHorse()
    {
        return CAKE_HORSE.get();
    }
}
