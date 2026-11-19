package dev.ayazyt4146.customheadblock.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ayazyt4146.customheadblock.block.entity.CustomHeadBlockEntity;
import net.minecraft.client.renderer.PlayerSkinRenderCache;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.phys.Vec3;

public final class CustomHeadBlockRenderer implements BlockEntityRenderer<CustomHeadBlockEntity, CustomHeadRenderState> {
    private final SkullModelBase model;
    private final PlayerSkinRenderCache skinCache;

    public CustomHeadBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.model = SkullBlockRenderer.createModel(context.entityModelSet(), SkullBlock.Types.PLAYER);
        this.skinCache = context.playerSkinRenderCache();
    }

    @Override
    public CustomHeadRenderState createRenderState() {
        return new CustomHeadRenderState();
    }

    @Override
    public void extractRenderState(CustomHeadBlockEntity blockEntity, CustomHeadRenderState state, float tickProgress, Vec3 cameraPos,
                                   net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
        state.playerName = blockEntity.getPlayerName();
    }

    @Override
    public void submit(CustomHeadRenderState state, PoseStack poseStack, SubmitNodeCollector queue, CameraRenderState cameraState) {
        if (state.playerName == null || state.playerName.isBlank() || model == null) return;

        var profile = ResolvableProfile.createUnresolved(state.playerName);
        var renderType = skinCache.getOrDefault(profile).renderType();

        poseStack.pushPose();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        SkullBlockRenderer.submitSkull(
                0.0F, poseStack, queue, state.lightCoords, model, renderType, 0, state.breakProgress
        );
        poseStack.popPose();
    }
}
