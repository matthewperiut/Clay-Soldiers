package com.matthewperiut.clay.fabric.item;

import com.matthewperiut.clay.ClayMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClayItemGroup
{
    /*
    public static final ItemGroup CLAY_GROUP = FabricItemGroupBuilder(
            new Identifier(ClayMod.MOD_ID, "clay_group"), () -> new ItemStack(SoldierDollItems.CLAY_SOLDIER));

    public static final ItemGroup CLAY_MISC_GROUP = FabricItemGroupBuilder.build(
            new Identifier(ClayMod.MOD_ID, "clay_misc_group"), () -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR));
    */

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
}
