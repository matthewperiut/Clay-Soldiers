package com.matthewperiut.clay.network;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.util.NetworkUtils;
import dev.architectury.networking.NetworkManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class UpgradeRemoved {
    public static final Identifier UPGRADE_REMOVED_PACKET = new Identifier(ClayMod.MOD_ID, "upgrade_removed_packet");

    public static void sendPacket(Iterable<ServerPlayerEntity> players, int entityId, Identifier upgradeIdentifier) {
        NetworkManager.sendToPlayers(players, UPGRADE_REMOVED_PACKET, NetworkUtils.getBufferForUpgrades(entityId, upgradeIdentifier));
    }
}
