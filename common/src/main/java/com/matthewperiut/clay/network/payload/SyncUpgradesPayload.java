package com.matthewperiut.clay.network.payload;

import com.matthewperiut.clay.network.ClayNetworkingConstants;
import com.matthewperiut.clay.registry.UpgradeRegistry;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.UpgradeManager;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public record SyncUpgradesPayload(int entityId, Action action, List<ISoldierUpgrade> upgrades) implements CustomPayload {
    public enum Action {
        ADD,
        REMOVE,
        SET
    }

    public static final PacketCodec<ByteBuf, Action> ACTION_CODEC = new PacketCodec<ByteBuf, Action>() {

        @Override
        public void encode(ByteBuf buf, Action value) {
            buf.writeInt(value.ordinal());
        }

        @Override
        public Action decode(ByteBuf buf) {
            return Action.values()[buf.readInt()];
        }
    };

    public static final PacketCodec<ByteBuf, List<ISoldierUpgrade>> UPGRADES_CODEC = new PacketCodec<ByteBuf, List<ISoldierUpgrade>>() {
        @Override
        public void encode(ByteBuf buf, List<ISoldierUpgrade> upgrades) {
            buf.writeInt(upgrades.size());
            for (ISoldierUpgrade upgrade : upgrades) {
                String identifier = upgrade.getUpgradeIdentifier().toString();
                byte[] identifierBytes = identifier.getBytes(StandardCharsets.UTF_8);
                buf.writeInt(identifierBytes.length);
                buf.writeBytes(identifierBytes);
            }
        }

        @Override
        public List<ISoldierUpgrade> decode(ByteBuf byteBuf) {
            int size = byteBuf.readInt(); // Read the size of the list
            List<ISoldierUpgrade> upgrades = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                int identifierLength = byteBuf.readInt();
                byte[] identifierBytes = new byte[identifierLength];
                byteBuf.readBytes(identifierBytes);
                String identifierStr = new String(identifierBytes, StandardCharsets.UTF_8);
                Identifier identifier = new Identifier(identifierStr);
                ISoldierUpgrade upgrade = UpgradeManager.INSTANCE.getUpgrade(identifier);
                if (upgrade != null) {
                    upgrades.add(upgrade);
                }
            }
            return upgrades;
        }
    };

    public static final CustomPayload.Id<SyncUpgradesPayload> ID = new CustomPayload.Id<>(ClayNetworkingConstants.SYNC_UPGRADES_PACKET_ID);
     public static final PacketCodec<RegistryByteBuf, SyncUpgradesPayload> CODEC = PacketCodec.tuple(
        PacketCodecs.INTEGER, SyncUpgradesPayload::entityId,
        ACTION_CODEC, SyncUpgradesPayload::action,
        UPGRADES_CODEC, SyncUpgradesPayload::upgrades,
        SyncUpgradesPayload::new
     );

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}