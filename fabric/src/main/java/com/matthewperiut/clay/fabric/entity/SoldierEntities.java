package com.matthewperiut.clay.fabric.entity;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.entity.soldier.variant.*;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoldierEntities
{
    private static final float height = 0.5f;
    private static final float width = 0.25f;

    public static final EntityType<RegularSoldierDoll> CLAY_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/clay"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RegularSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<RedSoldierDoll> RED_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/red"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<YellowSoldierDoll> YELLOW_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/yellow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, YellowSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<GreenSoldierDoll> GREEN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/green"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GreenSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BlueSoldierDoll> BLUE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/blue"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlueSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<OrangeSoldierDoll> ORANGE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/orange"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OrangeSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<MagentaSoldierDoll> MAGENTA_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/magenta"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MagentaSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<LightblueSoldierDoll> LIGHTBLUE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/lightblue"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LightblueSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<LimeSoldierDoll> LIME_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/lime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LimeSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<PinkSoldierDoll> PINK_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/pink"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PinkSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<CyanSoldierDoll> CYAN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/cyan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CyanSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<PurpleSoldierDoll> PURPLE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/purple"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PurpleSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BrownSoldierDoll> BROWN_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/brown"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BrownSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<BlackSoldierDoll> BLACK_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/black"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlackSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<GraySoldierDoll> GRAY_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/gray"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GraySoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());
    public static final EntityType<WhiteSoldierDoll> WHITE_SOLDIER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ClayMod.MOD_ID, "soldier/white"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WhiteSoldierDoll::new)
                    .dimensions(EntityDimensions.fixed(width, height)).build());

    public static void register()
    {
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
    }

    private static void registerSoldier(EntityType<? extends SoldierDollEntity> entityType, Identifier textureID)
    {
        FabricDefaultAttributeRegistry.register(entityType, RegularSoldierDoll.setAttributesBuilder());
        new ClientInfoStorage(entityType, textureID, ClientInfoStorage.RendererType.soldier.ordinal());
        //EntityRendererRegistry.register(entityType, (context) -> { return new SoldierDollRenderer(context, new SoldierDollModel(textureID), textureID); });
    }
}
