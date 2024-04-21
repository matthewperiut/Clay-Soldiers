package com.matthewperiut.clay.upgrade;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.item.ItemStack;

public interface ISoldierUpgrade {
    ItemStack getUpgradeItem();

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
}
