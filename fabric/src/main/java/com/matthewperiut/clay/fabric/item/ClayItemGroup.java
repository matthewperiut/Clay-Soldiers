package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClayItemGroup
{
    /* pre 1.19
    public static final ItemGroup CLAY_GROUP = FabricItemGroupBuilder(
            new Identifier(ClayMod.MOD_ID, "clay_group"), () -> new ItemStack(SoldierDollItems.CLAY_SOLDIER));

    public static final ItemGroup CLAY_MISC_GROUP = FabricItemGroupBuilder.build(
            new Identifier(ClayMod.MOD_ID, "clay_misc_group"), () -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR));
    */

    /* pre-1.20
        public static final ItemGroup CLAY_GROUP = FabricItemGroup.builder(
            new Identifier(ClayMod.MOD_ID, "clay_group"))
            .displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_group"))
            .icon(() -> new ItemStack(SoldierDollItems.CLAY_SOLDIER))
            .build();

    public static final ItemGroup CLAY_MISC_GROUP = FabricItemGroup.builder(
                    new Identifier(ClayMod.MOD_ID, "clay_misc_group"))
            .displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_misc_group"))
            .icon(() -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR))
            .build();
     */

    public static final RegistryKey<ItemGroup> CLAY_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ClayMod.MOD_ID, "clay_group"));
    public static final RegistryKey<ItemGroup> CLAY_MISC_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ClayMod.MOD_ID, "clay_misc_group"));

    public static void makeItemGroups()
    {
        Registry.register(Registries.ITEM_GROUP, CLAY_GROUP, FabricItemGroup.builder().icon(() -> new ItemStack(SoldierDollItems.CLAY_SOLDIER)).displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_group")).build());

        Registry.register(Registries.ITEM_GROUP, CLAY_MISC_GROUP, FabricItemGroup.builder().icon(() -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR)).displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_misc_group")).build());
    }
}
