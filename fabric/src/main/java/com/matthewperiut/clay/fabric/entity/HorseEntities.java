package com.matthewperiut.clay.fabric.entity;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HorseEntities
{
    private static final float height = 0.3f;
    private static final float width = 0.3f;

    public static final EntityType<HorseDollEntity> DIRT_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/dirt"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> GRASS_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/grass"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> MYCELIUM_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/mycelium"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> SNOW_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/snow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> SAND_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/sand"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> GRAVEL_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/gravel"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> FULL_SNOW_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/snowy"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> FULL_GRASS_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/grassy"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> LAPIS_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/lapis"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> CARROT_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/carrot"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> CLAY_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/clay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> SOUL_SAND_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/soul_sand"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<HorseDollEntity> CAKE_HORSE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "horse/cake"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HorseDollEntity::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());

    public static void register()
    {
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

    private static void registerHorse(EntityType<? extends HorseDollEntity> entityType, Identifier textureID)
    {
        FabricDefaultAttributeRegistry.register(entityType, HorseDollEntity.setAttributes());
        new ClientInfoStorage(entityType, textureID, ClientInfoStorage.RendererType.horse.ordinal());
        //EntityRendererRegistry.register(entityType, (context) -> { return new HorseDollRenderer(context, new HorseDollModel(textureID), textureID); });
    }
}
