package com.matthewperiut.clay.network;

import com.matthewperiut.clay.ClayMod;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;


public class UpgradeAdded {
    public static final Identifier UPGRADE_ADDED_PACKET = new Identifier(ClayMod.MOD_ID, "upgrade_added");

    //@Environment(EnvType.SERVER) Why is this filtered out incorrectly?
    public static void sendPacket(Iterable<ServerPlayerEntity> players, int entityId, Identifier upgradeIdentifier) {
        NetworkManager.sendToPlayers(players, UPGRADE_ADDED_PACKET, getBuffer(entityId, upgradeIdentifier));
    }

    private static PacketByteBuf getBuffer(int entityId, Identifier upgradeIdentifier) {
        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
        buffer.writeInt(entityId);
        buffer.writeIdentifier(upgradeIdentifier);
        return buffer;
    }

    public static void sendSinglePacket(ServerPlayerEntity player, int entityId, Identifier upgradeIdentifier) {
        NetworkManager.sendToPlayer(player, UPGRADE_ADDED_PACKET, getBuffer(entityId, upgradeIdentifier));
    }

}
