package com.matthewperiut.clay.upgrade;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public interface ISoldierUpgrade {
    ItemStack getUpgradeItem();

    Identifier getUpgradeIdentifier();

    // TODO maybe make a default implementation for not contains and itemStack has item
    boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier);

    default boolean shouldSyncToClient() {
        return false;
    }

    default void onAdd(SoldierDollEntity soldier) {
    }

    default void onRemove(SoldierDollEntity soldier) {
    }

    default void onDeath(SoldierDollEntity soldier) {
    }

    default void writeCustomNBTData(NbtCompound nbt) {
    }

    default void readCustomNBTData(NbtCompound nbt) {
    }

    default void onKill(SoldierDollEntity dyingSoldier, SoldierDollEntity attacker) {
    }

    @Override
    int hashCode();
}
