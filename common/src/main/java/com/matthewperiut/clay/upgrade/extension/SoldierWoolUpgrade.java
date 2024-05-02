package com.matthewperiut.clay.upgrade.extension;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.registry.UpgradeRegistry.LEATHER_UPGRADE;

public class SoldierWoolUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/wool_upgrade");

    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.WHITE_WOOL, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return itemStack.isIn(ItemTags.WOOL) && soldier.upgrades.contains(LEATHER_UPGRADE.get()) && !soldier.upgrades.contains(this);
    }

    @Override
    public boolean shouldSyncToClient() {
        return true;
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {

    }
}
