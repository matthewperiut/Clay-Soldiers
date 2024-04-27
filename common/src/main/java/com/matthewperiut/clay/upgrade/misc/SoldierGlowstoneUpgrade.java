package com.matthewperiut.clay.upgrade.misc;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class SoldierGlowstoneUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/glowstone_upgrade");

    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.GLOWSTONE_DUST, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean shouldSyncToClient() {
        return true;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return !soldier.upgrades.contains(this) && itemStack.isOf(Items.GLOWSTONE_DUST);
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient())
            soldier.setLightBlockUnaffected(true);
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient())
            soldier.setLightBlockUnaffected(false);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IDENTIFIER.toString());
    }
}
