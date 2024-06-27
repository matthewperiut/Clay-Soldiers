package com.matthewperiut.clay.upgrade.extension;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.UUID;

import static com.matthewperiut.clay.registry.UpgradeRegistry.STICK_UPGRADE;

public class SoldierFlintUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/flint_upgrade");
    protected static final UUID MODIFIER_ID = UUID.randomUUID();

    @Override
    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.FLINT, 1);
    }

    @Override
    public Identifier getUpgradeIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return !soldier.upgrades.contains(this) && itemStack.isOf(Items.FLINT) && soldier.upgrades.contains(STICK_UPGRADE.get());
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        soldier.playSoundIfNotSilent(SoundEvents.BLOCK_ANVIL_USE);
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":soldier_flint_upgrade", 1, EntityAttributeModifier.Operation.ADD_VALUE);
        if (attackInstance != null && !attackInstance.hasModifier(attributeModifier))
            attackInstance.addPersistentModifier(attributeModifier);
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackInstance != null)
            attackInstance.tryRemoveModifier(MODIFIER_ID);
    }

    @Override
    public ISoldierUpgrade dependentsOn() {
        return STICK_UPGRADE.get();
    }
}
