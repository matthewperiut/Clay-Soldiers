package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.registry.RegistryKeys.ITEM_GROUP;

public class ClayItemGroup
{
    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(ITEM_GROUP, ClayMod.MOD_ID);
    public static final RegistryObject<ItemGroup> CLAY_MISC_GROUP = TABS.register("clay_misc_group", () -> ItemGroup.builder().displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_misc_group")).icon(() -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR.get())).entries((displayContext, entries) ->
    {
        entries.add(DisruptorItems.CLAY_DISRUPTOR.get());
        entries.add(DisruptorItems.TERRACOTTA_DISRUPTOR.get());
        entries.add(DisruptorItems.OBSIDIAN_DISRUPTOR.get());
        entries.add(HorseDollItems.BRICK_HORSE.get());
        entries.add(SoldierDollItems.BRICK_SOLDIER.get());
    }).build());

    public static final RegistryObject<ItemGroup> CLAY_GROUP = TABS.register("clay_group", () -> ItemGroup.builder().displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_group")).icon(() -> new ItemStack(SoldierDollItems.CLAY_SOLDIER.get())).entries((displayContext, entries) ->
    {
        for (ForgeDollItem doll : ForgeDollItem.dolls)
        {
            entries.add(doll);
        }
    }).build());
}
