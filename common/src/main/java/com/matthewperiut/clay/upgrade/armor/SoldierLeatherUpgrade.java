package com.matthewperiut.clay.upgrade.armor;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.behavior.IDurable;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.UUID;


public class SoldierLeatherUpgrade implements ISoldierUpgrade, IDurable {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/leather_upgrade");
    protected static final UUID MODIFIER_ID = UUID.randomUUID();
    private static final short durability = 20;


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
        if (soldier.getWorld().isClient()) return;

        soldier.playSoundIfNotSilent(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER);

        soldier.upgradeInstances.get(this).nbtCompound().putShort(IDurable.NBT_KEY, durability);

        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":soldier_leather_upgrade", 3, EntityAttributeModifier.Operation.ADDITION);
        if (armorInstance != null && !armorInstance.hasModifier(attributeModifier)) {
            armorInstance.addPersistentModifier(attributeModifier);
        }
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) return;

        soldier.playSoundIfNotSilent(SoundEvents.ENTITY_ITEM_BREAK);

        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        if (armorInstance != null) {
            armorInstance.removeModifier(MODIFIER_ID);
        }
    }

    @Override
    public void onHit(SoldierDollEntity attacker, SoldierDollEntity soldier) {
        reduceNBTDurability(attacker.upgradeInstances.get(this).nbtCompound(), attacker);
        if (getDurability(attacker) <= 0) {
            attacker.removeUpgrades.add(this);
        }
    }

    @Override
    public void writeCustomNBTData(SoldierDollEntity soldier, NbtCompound nbt) {
        writeNBTDurability(nbt, soldier);
    }

    @Override
    public void readCustomNBTData(SoldierDollEntity soldier, NbtCompound nbt) {
        soldier.upgradeInstances.get(this).nbtCompound().copyFrom(nbt);
    }

    @Override
    public short getDurability(SoldierDollEntity soldier) {
        return soldier.upgradeInstances.get(this).nbtCompound().getShort(IDurable.NBT_KEY);
    }
}
