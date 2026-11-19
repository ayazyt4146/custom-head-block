package dev.ayazyt4146.customheadblock.client;

import dev.ayazyt4146.customheadblock.block.ModBlocks;
import dev.ayazyt4146.customheadblock.block.entity.CustomHeadBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;

public final class CustomHeadBlockClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UseBlockCallback.EVENT.register((player, level, hand, hit) -> {
            if (!level.isClientSide()) return InteractionResult.PASS;
            if (!level.getBlockState(hit.getBlockPos()).is(ModBlocks.CUSTOM_HEAD_BLOCK)) {
                return InteractionResult.PASS;
            }
            if (player.isSpectator()) return InteractionResult.PASS;

            var blockEntity = level.getBlockEntity(hit.getBlockPos());
            String name = blockEntity instanceof CustomHeadBlockEntity head ? head.getPlayerName() : "";
            String url = blockEntity instanceof CustomHeadBlockEntity head ? head.getSkinUrl() : "";
            Minecraft.getInstance().gui.setScreen(new CustomHeadScreen(hit.getBlockPos(), name, url));
            return InteractionResult.SUCCESS;
        });
    }
}
