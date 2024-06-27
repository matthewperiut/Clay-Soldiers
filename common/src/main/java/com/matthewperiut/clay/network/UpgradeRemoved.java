package com.matthewperiut.clay.network;

import com.matthewperiut.clay.network.payload.SyncUpgradesPayload;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import dev.architectury.networking.NetworkManager;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.List;

public class UpgradeRemoved {
    public static void sendPacket(Iterable<ServerPlayerEntity> players, int entityId, ISoldierUpgrade upgrade) {
        NetworkManager.sendToPlayers(players, new SyncUpgradesPayload(entityId, SyncUpgradesPayload.Action.REMOVE, List.of(upgrade)));
    }
}
