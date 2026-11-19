package dev.ayazyt4146.customheadblock.block.entity;

import dev.ayazyt4146.customheadblock.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public final class CustomHeadBlockEntity extends BlockEntity {
    private String playerName = "";
    private String skinUrl = "";

    public CustomHeadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CUSTOM_HEAD_BLOCK_ENTITY, pos, state);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSkinUrl() {
        return skinUrl;
    }

    public void setSkin(String playerName, String skinUrl) {
        this.playerName = playerName == null ? "" : playerName.trim();
        this.skinUrl = skinUrl == null ? "" : skinUrl.trim();
        setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putString("PlayerName", playerName);
        output.putString("SkinUrl", skinUrl);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        playerName = input.getStringOr("PlayerName", "");
        skinUrl = input.getStringOr("SkinUrl", "");
    }
}
