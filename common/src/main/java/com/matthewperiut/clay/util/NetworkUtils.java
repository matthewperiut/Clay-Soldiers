package com.matthewperiut.clay.util;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.util.Identifier;

public class NetworkUtils {
    private NetworkUtils() {
    }

    public static Iterable<ServerPlayerEntity> getTrackingPlayers(Entity entity) {
        return ((ServerChunkManager) entity.getWorld().getChunkManager()).threadedAnvilChunkStorage.getPlayersWatchingChunk(entity.getChunkPos(), false);
    }

    public static PacketByteBuf getBufferForUpgrades(int entityId, Identifier upgradeIdentifier) {
        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
        buffer.writeInt(entityId);
        buffer.writeIdentifier(upgradeIdentifier);
        return buffer;
    }
}
