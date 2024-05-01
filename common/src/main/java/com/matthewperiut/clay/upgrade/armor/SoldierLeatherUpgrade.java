package com.matthewperiut.clay.upgrade.armor;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.registry.ItemRegistry.TINY_CHESTPLATE;

public class SoldierLeatherUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/leather_upgrade");


    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.LEATHER, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return itemStack.isOf(Items.LEATHER) && !soldier.upgrades.contains(this);
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        soldier.equipStack(EquipmentSlot.CHEST, new ItemStack(TINY_CHESTPLATE.get()));
    }
}
