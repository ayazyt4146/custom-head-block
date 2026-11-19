package dev.ayazyt4146.customheadblock.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record SaveSkinPayload(BlockPos pos, String playerName, String skinUrl) implements CustomPacketPayload {
    public static final Type<SaveSkinPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath("customheadblock", "save_skin"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SaveSkinPayload> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, SaveSkinPayload::pos,
            ByteBufCodecs.STRING_UTF8, SaveSkinPayload::playerName,
            ByteBufCodecs.STRING_UTF8, SaveSkinPayload::skinUrl,
            SaveSkinPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
