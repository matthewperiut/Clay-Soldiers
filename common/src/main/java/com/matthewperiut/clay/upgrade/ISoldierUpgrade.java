package com.matthewperiut.clay.upgrade;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

@SuppressWarnings("ALL")
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

    /**
     * When the read of nbt data was a success and the upgrade needs to reapply its effect
     *
     * @param entity soldier for whom the upgrade apply
     */
    default void onLoad(SoldierDollEntity entity) {
    }

    default void writeCustomNBTData(SoldierDollEntity soldier, NbtCompound nbt) {
    }

    default void readCustomNBTData(SoldierDollEntity soldier, NbtCompound nbt) {
    }

    /**
     * When the attacker is killing another soldier
     *
     * @param dyingSoldier killed object
     * @param attacker     soldier with this upgrade who killed
     */
    default void onKill(SoldierDollEntity dyingSoldier, SoldierDollEntity attacker) {
    }

    /**
     * @param source  by what the soldier was killed
     * @param soldier the soldier who died with this upgrade
     */
    default void onDeath(DamageSource source, SoldierDollEntity soldier) {
    }

    /**
     * On a successful attack on the target
     *
     * @param target   soldier which got hit
     * @param attacker soldier with this upgrade who attacked
     */
    default void onAttack(SoldierDollEntity target, SoldierDollEntity attacker) {
    }

    /**
     * @param attacker who attacked
     * @param soldier  the soldier with this upgrade who got attacked
     */
    default void onHit(SoldierDollEntity attacker, SoldierDollEntity soldier) {
    }

    /**
     * If an Upgrade depends on other upgrades, it should be declared here,
     * so it can be removed when the dependency is missing
     */
    default ISoldierUpgrade dependentsOn() {
        return null;
    }

    @Override
    int hashCode();
}
