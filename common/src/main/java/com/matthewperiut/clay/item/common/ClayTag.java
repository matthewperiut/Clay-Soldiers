package com.matthewperiut.clay.item.common;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClayTag
{
    public static final TagKey<Item> SOLDIERS = TagKey.of(Registry.ITEM_KEY, new Identifier(ClayMod.MOD_ID, "soldiers"));
}
