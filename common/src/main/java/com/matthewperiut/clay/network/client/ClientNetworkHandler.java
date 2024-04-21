package com.matthewperiut.clay.network.client;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.registry.UpgradeRegistry;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.network.UpgradeAdded.UPGRADE_ADDED_PACKET;

@Environment(EnvType.CLIENT)
public class ClientNetworkHandler {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, UPGRADE_ADDED_PACKET, (buf, context) -> {
            int soldierEntityId = buf.readInt();
            Identifier upgradeIdentifier = buf.readIdentifier();

            ISoldierUpgrade upgrade = UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.get(upgradeIdentifier);
            Entity entity = context.getPlayer().getEntityWorld().getEntityById(soldierEntityId);
            if (entity instanceof SoldierDollEntity) {
                ((SoldierDollEntity) entity).upgrades.add(upgrade);
            }
        });
    }
}
