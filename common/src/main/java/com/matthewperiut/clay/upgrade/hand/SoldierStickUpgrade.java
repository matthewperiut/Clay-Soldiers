package com.matthewperiut.clay.upgrade.hand;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.UpgradeManager;
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

    short maxDurability = 20;

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
        soldier.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STICK, 1));
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":solder_stick_upgrade", 2, EntityAttributeModifier.Operation.ADDITION);
        if (attackInstance != null && attackInstance.hasModifier(attributeModifier))
            attackInstance.addPersistentModifier(attributeModifier);
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        soldier.equipStack(EquipmentSlot.MAINHAND, null);
        soldier.playSoundIfNotSilent(SoundEvents.ENTITY_ITEM_BREAK);
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackInstance != null)
            attackInstance.tryRemoveModifier(MODIFIER_ID);
    }

    @Override
    public void onKill(SoldierDollEntity dyingSoldier, SoldierDollEntity attacker) {
        maxDurability--;
        if (maxDurability <= 0) {
            UpgradeManager.INSTANCE.removeUpgrade(attacker, this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IDENTIFIER.toString());
    }

    @Override
    public void readCustomNBTData(NbtCompound nbt) {
        maxDurability = readNBTDurability(nbt);
    }

    @Override
    public void writeCustomNBTData(NbtCompound nbt) {
        writeNBTDurability(nbt);
    }

    @Override
    public short getDurability() {
        return maxDurability;
    }
}
