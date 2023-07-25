package com.matthewperiut.clay.forge.entity;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.entity.soldier.variant.*;
import com.matthewperiut.clay.util.ClientInfoStorage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraftforge.registries.RegistryObject;

import static com.matthewperiut.clay.forge.entity.ClayEntityTypes.ENTITY_TYPES;

public class SoldierDollEntities
{
    private static final float height = 0.5f;
    private static final float width = 0.25f;

    public static final RegistryObject<EntityType<RegularSoldierDoll>> CLAY_SOLDIER = ENTITY_TYPES.register("soldier/clay", () -> EntityType.Builder.create(RegularSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/clay").toString()));
    public static final RegistryObject<EntityType<RedSoldierDoll>> RED_SOLDIER = ENTITY_TYPES.register("soldier/red", () -> EntityType.Builder.create(RedSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/red").toString()));
    public static final RegistryObject<EntityType<YellowSoldierDoll>> YELLOW_SOLDIER = ENTITY_TYPES.register("soldier/yellow", () -> EntityType.Builder.create(YellowSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/yellow").toString()));
    public static final RegistryObject<EntityType<GreenSoldierDoll>> GREEN_SOLDIER = ENTITY_TYPES.register("soldier/green", () -> EntityType.Builder.create(GreenSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/green").toString()));
    public static final RegistryObject<EntityType<BlueSoldierDoll>> BLUE_SOLDIER = ENTITY_TYPES.register("soldier/blue", () -> EntityType.Builder.create(BlueSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/blue").toString()));
    public static final RegistryObject<EntityType<OrangeSoldierDoll>> ORANGE_SOLDIER = ENTITY_TYPES.register("soldier/orange", () -> EntityType.Builder.create(OrangeSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/orange").toString()));
    public static final RegistryObject<EntityType<MagentaSoldierDoll>> MAGENTA_SOLDIER = ENTITY_TYPES.register("soldier/magenta", () -> EntityType.Builder.create(MagentaSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/magenta").toString()));
    public static final RegistryObject<EntityType<LightblueSoldierDoll>> LIGHTBLUE_SOLDIER = ENTITY_TYPES.register("soldier/lightblue", () -> EntityType.Builder.create(LightblueSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/lightblue").toString()));
    public static final RegistryObject<EntityType<LimeSoldierDoll>> LIME_SOLDIER = ENTITY_TYPES.register("soldier/lime", () -> EntityType.Builder.create(LimeSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/lime").toString()));
    public static final RegistryObject<EntityType<PinkSoldierDoll>> PINK_SOLDIER = ENTITY_TYPES.register("soldier/pink", () -> EntityType.Builder.create(PinkSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/pink").toString()));
    public static final RegistryObject<EntityType<CyanSoldierDoll>> CYAN_SOLDIER = ENTITY_TYPES.register("soldier/cyan", () -> EntityType.Builder.create(CyanSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/cyan").toString()));
    public static final RegistryObject<EntityType<PurpleSoldierDoll>> PURPLE_SOLDIER = ENTITY_TYPES.register("soldier/purple", () -> EntityType.Builder.create(PurpleSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/purple").toString()));
    public static final RegistryObject<EntityType<BrownSoldierDoll>> BROWN_SOLDIER = ENTITY_TYPES.register("soldier/brown", () -> EntityType.Builder.create(BrownSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/brown").toString()));
    public static final RegistryObject<EntityType<BlackSoldierDoll>> BLACK_SOLDIER = ENTITY_TYPES.register("soldier/black", () -> EntityType.Builder.create(BlackSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/black").toString()));
    public static final RegistryObject<EntityType<GraySoldierDoll>> GRAY_SOLDIER = ENTITY_TYPES.register("soldier/gray", () -> EntityType.Builder.create(GraySoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/gray").toString()));
    public static final RegistryObject<EntityType<WhiteSoldierDoll>> WHITE_SOLDIER = ENTITY_TYPES.register("soldier/white", () -> EntityType.Builder.create(WhiteSoldierDoll::new, SpawnGroup.CREATURE).setDimensions(width, height).build(new Identifier(ClayMod.MOD_ID, "soldier/white").toString()));


    public static void clientRegister()
    {
        registerSoldier(CLAY_SOLDIER.get(), SoldierDollEntity.TEXTURE_ID);
        registerSoldier(RED_SOLDIER.get(), RedSoldierDoll.TEXTURE_ID);
        registerSoldier(YELLOW_SOLDIER.get(), YellowSoldierDoll.TEXTURE_ID);
        registerSoldier(GREEN_SOLDIER.get(), GreenSoldierDoll.TEXTURE_ID);
        registerSoldier(BLUE_SOLDIER.get(), BlueSoldierDoll.TEXTURE_ID);
        registerSoldier(ORANGE_SOLDIER.get(), OrangeSoldierDoll.TEXTURE_ID);
        registerSoldier(MAGENTA_SOLDIER.get(), MagentaSoldierDoll.TEXTURE_ID);
        registerSoldier(LIGHTBLUE_SOLDIER.get(), LightblueSoldierDoll.TEXTURE_ID);
        registerSoldier(LIME_SOLDIER.get(), LimeSoldierDoll.TEXTURE_ID);
        registerSoldier(PINK_SOLDIER.get(), PinkSoldierDoll.TEXTURE_ID);
        registerSoldier(CYAN_SOLDIER.get(), CyanSoldierDoll.TEXTURE_ID);
        registerSoldier(PURPLE_SOLDIER.get(), PurpleSoldierDoll.TEXTURE_ID);
        registerSoldier(BROWN_SOLDIER.get(), BrownSoldierDoll.TEXTURE_ID);
        registerSoldier(BLACK_SOLDIER.get(), BlackSoldierDoll.TEXTURE_ID);
        registerSoldier(GRAY_SOLDIER.get(), GraySoldierDoll.TEXTURE_ID);
        registerSoldier(WHITE_SOLDIER.get(), WhiteSoldierDoll.TEXTURE_ID);
    }

    private static void registerSoldier(EntityType<? extends SoldierDollEntity> soldierType, Identifier texture)
    {
        new ClientInfoStorage(soldierType, texture, ClientInfoStorage.RendererType.soldier.ordinal());
    }

    public static void register()
    {

    }

    // Suppliers
    public static EntityType<?> getClaySoldier()
    {
        return CLAY_SOLDIER.get();
    }

    public static EntityType<?> getRedSoldier()
    {
        return RED_SOLDIER.get();
    }

    public static EntityType<?> getYellowSoldier()
    {
        return YELLOW_SOLDIER.get();
    }

    public static EntityType<?> getGreenSoldier()
    {
        return GREEN_SOLDIER.get();
    }

    public static EntityType<BlueSoldierDoll> getBlueSoldier()
    {
        return BLUE_SOLDIER.get();
    }

    public static EntityType<OrangeSoldierDoll> getOrangeSoldier()
    {
        return ORANGE_SOLDIER.get();
    }

    public static EntityType<MagentaSoldierDoll> getMagentaSoldier()
    {
        return MAGENTA_SOLDIER.get();
    }

    public static EntityType<LightblueSoldierDoll> getLightBlueSoldier()
    {
        return LIGHTBLUE_SOLDIER.get();
    }

    public static EntityType<LimeSoldierDoll> getLimeSoldier()
    {
        return LIME_SOLDIER.get();
    }

    public static EntityType<PinkSoldierDoll> getPinkSoldier()
    {
        return PINK_SOLDIER.get();
    }

    public static EntityType<CyanSoldierDoll> getCyanSoldier()
    {
        return CYAN_SOLDIER.get();
    }

    public static EntityType<PurpleSoldierDoll> getPurpleSoldier()
    {
        return PURPLE_SOLDIER.get();
    }

    public static EntityType<BrownSoldierDoll> getBrownSoldier()
    {
        return BROWN_SOLDIER.get();
    }

    public static EntityType<BlackSoldierDoll> getBlackSoldier()
    {
        return BLACK_SOLDIER.get();
    }

    public static EntityType<GraySoldierDoll> getGraySoldier()
    {
        return GRAY_SOLDIER.get();
    }

    public static EntityType<WhiteSoldierDoll> getWhiteSoldier()
    {
        return WHITE_SOLDIER.get();
    }
}
