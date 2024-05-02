package com.matthewperiut.clay.upgrade.armor;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.UUID;


public class SoldierLeatherUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/leather_upgrade");
    protected static final UUID MODIFIER_ID = UUID.randomUUID();


    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.LEATHER, 1);
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
        return itemStack.isOf(Items.LEATHER) && !soldier.upgrades.contains(this);
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) {
            soldier.setHasArmor(true);
            return;
        }
        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":soldier_leather_upgrade", 2, EntityAttributeModifier.Operation.ADDITION);
        if (armorInstance != null && !armorInstance.hasModifier(attributeModifier)) {
            armorInstance.addPersistentModifier(attributeModifier);
        }
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) return;

        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        if (armorInstance != null) {
            armorInstance.removeModifier(MODIFIER_ID);
        }
    }
}
