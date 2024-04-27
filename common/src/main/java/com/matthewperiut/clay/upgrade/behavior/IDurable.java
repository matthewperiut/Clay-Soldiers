package com.matthewperiut.clay.upgrade.behavior;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.nbt.NbtCompound;

public interface IDurable {
    String NBT_KEY = "durable";

    short getDurability(SoldierDollEntity soldier);

    default void writeNBTDurability(NbtCompound compound, SoldierDollEntity soldier) {
        compound.putShort(NBT_KEY, getDurability(soldier));
    }

    default void reduceNBTDurability(NbtCompound compound, SoldierDollEntity soldier) {
        compound.putShort(NBT_KEY, (short) (getDurability(soldier) - 1));
    }

}
