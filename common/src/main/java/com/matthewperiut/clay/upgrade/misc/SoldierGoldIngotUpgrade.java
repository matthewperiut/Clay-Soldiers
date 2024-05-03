package com.matthewperiut.clay.upgrade.misc;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class SoldierGoldIngotUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/gold_ingot_upgrade");

    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.GOLD_INGOT, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return itemStack.isOf(Items.GOLD_INGOT) && !soldier.upgrades.contains(this);
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {

    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {

    }

    @Override
    public void onDeath(DamageSource source, SoldierDollEntity soldier) {
        if (source.getAttacker() instanceof SoldierDollEntity) {
            // REVENGE THE KING
        }
    }
}
