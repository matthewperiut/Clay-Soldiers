package com.matthewperiut.clay.upgrade.behavior;

import net.minecraft.nbt.NbtCompound;

public interface IDurable {
    String NBT_KEY = "durable";

    short getDurability();

    default void writeNBTDurability(NbtCompound compound) {
        compound.putShort(NBT_KEY, getDurability());
    }

    default short readNBTDurability(NbtCompound compound) {
        return compound.getShort(NBT_KEY);
    }

}
