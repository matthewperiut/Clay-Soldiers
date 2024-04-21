package com.matthewperiut.clay.network;

import com.matthewperiut.clay.ClayMod;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;


public class UpgradeAdded {
    public static final Identifier UPGRADE_ADDED_PACKET = new Identifier(ClayMod.MOD_ID, "upgrade_added");

    @Environment(EnvType.SERVER)
    public static void sendPacket(Iterable<ServerPlayerEntity> players, int entityId, Identifier upgradeIdentifier) {

        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
        buffer.writeInt(entityId);
        buffer.writeIdentifier(upgradeIdentifier);
        NetworkManager.sendToPlayers(players, UPGRADE_ADDED_PACKET, buffer);
    }

}
