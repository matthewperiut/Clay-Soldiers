package com.matthewperiut.clay.item.common;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ClayTag
{
    public static final TagKey<Item> SOLDIERS = TagKey.of(Registries.ITEM.getKey(), new Identifier(ClayMod.MOD_ID, "soldiers"));
}
