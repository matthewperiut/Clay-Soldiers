package com.matthewperiut.clay.upgrade.hand;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.behavior.IDurable;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.UUID;

public class SoldierStickUpgrade implements ISoldierUpgrade, IDurable {

    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/stick_upgrade");
    private static final short durability = 20;
    protected static final UUID MODIFIER_ID = UUID.randomUUID();


    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.STICK, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return !soldier.upgrades.contains(this) && itemStack.isOf(Items.STICK);
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        soldier.upgradeInstances.get(this).nbtCompound().putShort(IDurable.NBT_KEY, durability);
        soldier.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STICK, 1));
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":soldier_stick_upgrade", 2, EntityAttributeModifier.Operation.ADDITION);
        if (attackInstance != null && !attackInstance.hasModifier(attributeModifier))
            attackInstance.addPersistentModifier(attributeModifier);
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        soldier.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackInstance != null)
            attackInstance.tryRemoveModifier(MODIFIER_ID);
        if (getDurability(soldier) <= 0)
            soldier.playSoundIfNotSilent(SoundEvents.ENTITY_ITEM_BREAK);
    }

    @Override
    public void onKill(SoldierDollEntity dyingSoldier, SoldierDollEntity attacker) {
        reduceNBTDurability(attacker.upgradeInstances.get(this).nbtCompound(), attacker);
        if (getDurability(attacker) <= 0) {
            attacker.removeUpgrades.add(this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IDENTIFIER.toString());
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
