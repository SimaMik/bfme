
package net.sima.bfme.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.sima.bfme.BFME;
public record PrivateBlockPayload(
        int xPositive, int xNegative,
        int yPositive, int yNegative,
        int zPositive, int zNegative,
        String playerName,
        BlockPos blockPos,
        boolean allowInteraction,
        boolean allowBreaking,
        boolean allowPlacing
) implements CustomPacketPayload {

    public static final Type<PrivateBlockPayload> TYPE = new Type<>(BFME.resource("private_block"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PrivateBlockPayload> STREAM_CODEC = StreamCodec.of(
            (buf, payload) -> {
                buf.writeVarInt(payload.xPositive());
                buf.writeVarInt(payload.xNegative());
                buf.writeVarInt(payload.yPositive());
                buf.writeVarInt(payload.yNegative());
                buf.writeVarInt(payload.zPositive());
                buf.writeVarInt(payload.zNegative());
                buf.writeUtf(payload.playerName());
                buf.writeBlockPos(payload.blockPos());
                buf.writeBoolean(payload.allowInteraction());
                buf.writeBoolean(payload.allowBreaking());
                buf.writeBoolean(payload.allowPlacing());
            },
            buf -> new PrivateBlockPayload(
                    buf.readVarInt(),
                    buf.readVarInt(),
                    buf.readVarInt(),
                    buf.readVarInt(),
                    buf.readVarInt(),
                    buf.readVarInt(),
                    buf.readUtf(),
                    buf.readBlockPos(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean()
            )
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}