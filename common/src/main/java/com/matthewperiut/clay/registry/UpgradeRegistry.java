package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.hand.SoldierStickUpgrade;
import com.matthewperiut.clay.upgrade.misc.SoldierGlowstoneUpgrade;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class UpgradeRegistry {
    public static final Identifier REGISTRY_ID = new Identifier(ClayMod.MOD_ID, "upgrades");
    public static final RegistryKey<Registry<ISoldierUpgrade>> UPGRADES_KEY =
            RegistryKey.ofRegistry(REGISTRY_ID);
    public static final Registrar<ISoldierUpgrade> SOLDIER_UPGRADE_REGISTER = RegistrarManager.get(ClayMod.MOD_ID).<ISoldierUpgrade>builder(REGISTRY_ID)
            .syncToClients()
            .build();

    public static final RegistrySupplier<ISoldierUpgrade> STICK_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierStickUpgrade.IDENTIFIER, SoldierStickUpgrade::new);
    public static final RegistrySupplier<ISoldierUpgrade> GLOWSTONE_UPGRADE = SOLDIER_UPGRADE_REGISTER.register(SoldierGlowstoneUpgrade.IDENTIFIER, SoldierGlowstoneUpgrade::new);

    public static void init() {

    }
}
