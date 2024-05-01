package com.matthewperiut.clay.item.armor;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class ClayAmorMaterial implements ArmorMaterial {
    @Override
    public int getDurability(ArmorItem.Type type) {
        return 1;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return ClayMod.MOD_ID + ":clay_armor";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
