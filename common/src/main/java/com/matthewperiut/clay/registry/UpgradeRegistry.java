package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.armor.SoldierLeatherUpgrade;
import com.matthewperiut.clay.upgrade.extension.SoldierFlintUpgrade;
import com.matthewperiut.clay.upgrade.extension.SoldierWoolUpgrade;
import com.matthewperiut.clay.upgrade.hand.SoldierStickUpgrade;
import com.matthewperiut.clay.upgrade.misc.SoldierGlowstoneUpgrade;
import com.matthewperiut.clay.upgrade.misc.SoldierGoldIngotUpgrade;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class UpgradeRegistry {
    public static final Identifier REGISTRY_ID = Identifier.of(ClayMod.MOD_ID, "upgrades");
    public static final RegistryKey<Registry<ISoldierUpgrade>> UPGRADES_KEY =
            RegistryKey.ofRegistry(REGISTRY_ID);
    public static final Registrar<ISoldierUpgrade> SOLDIER_UPGRADE_REGISTER = RegistrarManager.get(ClayMod.MOD_ID).<ISoldierUpgrade>builder(REGISTRY_ID)
            .syncToClients()
            .build();

    public static final RegistrySupplier<ISoldierUpgrade> STICK_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierStickUpgrade.IDENTIFIER, SoldierStickUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> GLOWSTONE_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierGlowstoneUpgrade.IDENTIFIER, SoldierGlowstoneUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> FLINT_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierFlintUpgrade.IDENTIFIER, SoldierFlintUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> WOOL_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierWoolUpgrade.IDENTIFIER, SoldierWoolUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> LEATHER_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierLeatherUpgrade.IDENTIFIER, SoldierLeatherUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> GOLD_INGOT_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierGoldIngotUpgrade.IDENTIFIER, SoldierGoldIngotUpgrade::new);

    public static void init() {
    }
}
