package com.matthewperiut.clay.upgrade.extension;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.UUID;

import static com.matthewperiut.clay.registry.UpgradeRegistry.LEATHER_UPGRADE;

public class SoldierWoolUpgrade implements ISoldierUpgrade {
    public static final Identifier IDENTIFIER = Identifier.of(ClayMod.MOD_ID, "upgrades/soldier/wool_upgrade");
    protected static final Identifier SOLDIER_WOOL_UPGRADE = Identifier.of(ClayMod.MOD_ID, "soldier_wool_upgrade");


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
    public ISoldierUpgrade dependentsOn() {
        return LEATHER_UPGRADE.get();
    }

    @Override
    public boolean shouldSyncToClient() {
        return true;
    }

    @Override
    public void onAdd(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) return;

        soldier.playSoundIfNotSilent(SoundEvents.BLOCK_WOOL_PLACE);

        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        EntityAttributeModifier attributeModifier = new EntityAttributeModifier(SOLDIER_WOOL_UPGRADE, 2, EntityAttributeModifier.Operation.ADD_VALUE);
        if (armorInstance != null && !armorInstance.hasModifier(attributeModifier.id())) {
            armorInstance.addPersistentModifier(attributeModifier);
        }
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) return;

        EntityAttributeInstance armorInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        if (armorInstance != null)
            armorInstance.removeModifier(SOLDIER_WOOL_UPGRADE);
    }
}
