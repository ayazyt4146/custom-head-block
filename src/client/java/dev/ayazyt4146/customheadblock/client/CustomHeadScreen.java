package dev.ayazyt4146.customheadblock.client;

import dev.ayazyt4146.customheadblock.network.SaveSkinPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public final class CustomHeadScreen extends Screen {
    private final BlockPos pos;
    private final String savedName;
    private final String savedUrl;
    private EditBox nameField;
    private EditBox urlField;

    public CustomHeadScreen(BlockPos pos, String savedName, String savedUrl) {
        super(Component.literal("Custom Head Block"));
        this.pos = pos;
        this.savedName = savedName;
        this.savedUrl = savedUrl;
    }

    @Override
    protected void init() {
        int left = this.width / 2 - 125;
        int top = this.height / 2 - 65;

        nameField = new EditBox(this.font, left, top + 25, 250, 20, Component.literal("Player name"));
        nameField.setMaxLength(16);
        nameField.setHint(Component.literal("Minecraft player name"));
        nameField.setValue(savedName);
        addRenderableWidget(nameField);

        urlField = new EditBox(this.font, left, top + 68, 250, 20, Component.literal("Nova Skin URL"));
        urlField.setMaxLength(512);
        urlField.setHint(Component.literal("Nova Skin shared skin URL"));
        urlField.setValue(savedUrl);
        addRenderableWidget(urlField);

        addRenderableWidget(Button.builder(Component.literal("Apply"), button -> {
            ClientPlayNetworking.send(new SaveSkinPayload(pos, nameField.getValue(), urlField.getValue()));
            onClose();
        }).bounds(left, top + 105, 120, 20).build());

        addRenderableWidget(Button.builder(Component.literal("Cancel"), button -> onClose())
                .bounds(left + 130, top + 105, 120, 20).build());
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);
        int left = this.width / 2 - 125;
        int top = this.height / 2 - 65;
        graphics.text(this.font, "Enter a player name or a Nova Skin link", left, top + 7, 0xFFFFFFFF, true);
        graphics.text(this.font, "Player name", left, top + 14, 0xFFAAAAAA, true);
        graphics.text(this.font, "Nova Skin URL", left, top + 57, 0xFFAAAAAA, true);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
