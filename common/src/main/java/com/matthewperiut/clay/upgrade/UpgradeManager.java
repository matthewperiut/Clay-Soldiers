package com.matthewperiut.clay.upgrade;

import com.google.common.base.Suppliers;
import com.matthewperiut.clay.ClayMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class UpgradeManager {

    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(ClayMod.MOD_ID));
    public static final RegistryKey<Registry<SoldierUpgrade>> UPGRADES_KEY =
            RegistryKey.ofRegistry(new Identifier(ClayMod.MOD_ID, "upgrades"));
    public static final DeferredRegister<SoldierUpgrade> SOLDIER_UPGRADE_REGISTER = DeferredRegister.create(ClayMod.MOD_ID, UPGRADES_KEY);

    public SoldierUpgrade getSoldierUpgrade(ItemStack stack) {
        return null;
    }
}
