package dev.ayazyt4146.customheadblock.network;

import dev.ayazyt4146.customheadblock.block.entity.CustomHeadBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class ModNetworking {
    public static void initialize() {
        PayloadTypeRegistry.serverboundPlay().register(SaveSkinPayload.TYPE, SaveSkinPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(SaveSkinPayload.TYPE, (payload, context) -> {
            var player = context.player();
            BlockPos pos = payload.pos();
            if (player.blockPosition().distSqr(pos) > 64.0) return;
            BlockEntity blockEntity = player.level().getBlockEntity(pos);
            if (blockEntity instanceof CustomHeadBlockEntity head) {
                String name = payload.playerName().length() > 16 ? payload.playerName().substring(0, 16) : payload.playerName();
                String url = payload.skinUrl().length() > 512 ? "" : payload.skinUrl();
                head.setSkin(name, url);
                player.level().sendBlockUpdated(pos, head.getBlockState(), head.getBlockState(), 3);
            }
        });
    }

    private ModNetworking() {}
}
