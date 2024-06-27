package com.matthewperiut.clay.network;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.network.payload.SyncUpgradesPayload;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.util.NetworkUtils;
import dev.architectury.networking.NetworkManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;


public class UpgradeAdded {

    public static void sendPacket(Iterable<ServerPlayerEntity> players, int entityId, ISoldierUpgrade upgrade) {
        NetworkManager.sendToPlayers(players, new SyncUpgradesPayload(entityId, SyncUpgradesPayload.Action.ADD, List.of(upgrade)));
    }
}
