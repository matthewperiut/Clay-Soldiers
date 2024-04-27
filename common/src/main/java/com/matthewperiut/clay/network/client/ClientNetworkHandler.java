package com.matthewperiut.clay.network.client;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.registry.UpgradeRegistry;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static com.matthewperiut.clay.network.UpgradeAdded.UPGRADE_ADDED_PACKET;
import static com.matthewperiut.clay.network.UpgradeRemoved.UPGRADE_REMOVED_PACKET;

@Environment(EnvType.CLIENT)
public class ClientNetworkHandler {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, UPGRADE_ADDED_PACKET, (buf, context) -> {
            Optional<SoldierUpgradeContainer> optionalSoldier = handleIncomingUpgradePacket(buf, context);
            if (optionalSoldier.isEmpty())
                return;
            SoldierUpgradeContainer container = optionalSoldier.get();
            container.soldier.upgrades.add(container.upgrade);
            container.upgrade.onAdd(container.soldier);
        });
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, UPGRADE_REMOVED_PACKET, (buf, context) -> {
            Optional<SoldierUpgradeContainer> optionalSoldier = handleIncomingUpgradePacket(buf, context);
            if (optionalSoldier.isEmpty())
                return;
            SoldierUpgradeContainer container = optionalSoldier.get();
            container.soldier.upgrades.remove(container.upgrade);
            container.upgrade.onRemove(container.soldier);

        });
    }

    private static Optional<SoldierUpgradeContainer> handleIncomingUpgradePacket(PacketByteBuf buf, NetworkManager.PacketContext context) {
        int soldierEntityId = buf.readInt();
        Identifier upgradeIdentifier = buf.readIdentifier();
        ISoldierUpgrade upgrade = UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.get(upgradeIdentifier);
        if (upgrade == null) {
            ClayMod.LOGGER.warn("Unknown upgrade id {}", upgradeIdentifier);
            return Optional.empty();
        }
        Entity entity = context.getPlayer().getEntityWorld().getEntityById(soldierEntityId);
        if (entity instanceof SoldierDollEntity soldier) {
            return Optional.of(new SoldierUpgradeContainer(upgrade, soldier));
        }
        return Optional.empty();
    }


    static class SoldierUpgradeContainer {
        public SoldierDollEntity soldier;
        public ISoldierUpgrade upgrade;

        SoldierUpgradeContainer(ISoldierUpgrade _upgrade, SoldierDollEntity _soldier) {
            upgrade = _upgrade;
            soldier = _soldier;
        }
    }
}
