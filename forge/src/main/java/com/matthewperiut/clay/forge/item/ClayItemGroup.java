package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.forge.entity.SoldierDollEntities;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ClayItemGroup
{
    /*
    public static final ItemGroup CLAY_GROUP = new ItemGroup(ClayMod.MOD_ID + ".clay_group")
    {
        @Override
        public ItemStack getIcon()
        {
            return new ItemStack(SoldierDollItems.CLAY_SOLDIER.get());
        }
    };

    public static final ItemGroup TEST = ItemGroup.create(ItemGroup.Row.TOP,1)
            .icon()
            .displayName().build();

    public static final ItemGroup CLAY_MISC_GROUP = new ItemGroup(ClayMod.MOD_ID + ".clay_misc_group")
    {
        @Override
        public ItemStack getIcon()
        {
            return new ItemStack(DisruptorItems.CLAY_DISRUPTOR.get());
        }
    };*/
    //public static final ItemGroup CLAY_GROUP = event.

    static List<RegistryObject<Item>> item_regs = new ArrayList<>();
    static List<ItemConvertible> items = new ArrayList<>();
    static List<ItemConvertible> miscs = new ArrayList<>();
    public static ItemGroup CLAY_GROUP;
    public static ItemGroup CLAY_MISC_GROUP;

    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event)
    {
        for (ForgeDollItem doll : ForgeDollItem.dolls)
        {
            items.add(doll);
        }

        miscs.add(DisruptorItems.CLAY_DISRUPTOR.get());
        miscs.add(DisruptorItems.TERRACOTTA_DISRUPTOR.get());
        miscs.add(DisruptorItems.OBSIDIAN_DISRUPTOR.get());
        miscs.add(HorseDollItems.BRICK_HORSE.get());
        miscs.add(SoldierDollItems.BRICK_SOLDIER.get());

        CLAY_GROUP = event.registerCreativeModeTab(new Identifier(ClayMod.MOD_ID, "clay_group"),
                builder -> builder.icon(() -> new ItemStack(SoldierDollItems.CLAY_SOLDIER.get()))
                        .displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_group"))
                        .entries((features, output, hasPermissions) -> { for (int i = 0; i < items.size(); i++) output.add(items.get(i)); }));
        CLAY_MISC_GROUP = event.registerCreativeModeTab(new Identifier(ClayMod.MOD_ID, "clay_misc_group"),
                builder -> builder.icon(() -> new ItemStack(DisruptorItems.CLAY_DISRUPTOR.get()))
                        .displayName(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_misc_group"))
                        .entries((features, output, hasPermissions) -> { for (int i = 0; i < miscs.size(); i++) output.add(miscs.get(i)); }));

    }
}
