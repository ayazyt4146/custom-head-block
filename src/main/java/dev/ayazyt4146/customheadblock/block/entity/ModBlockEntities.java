package dev.ayazyt4146.customheadblock.block.entity;

import dev.ayazyt4146.customheadblock.CustomHeadBlockMod;
import dev.ayazyt4146.customheadblock.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public final class ModBlockEntities {
    public static final BlockEntityType<CustomHeadBlockEntity> CUSTOM_HEAD_BLOCK_ENTITY =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(CustomHeadBlockMod.MOD_ID, "custom_head"),
                    FabricBlockEntityTypeBuilder.<CustomHeadBlockEntity>create(
                            CustomHeadBlockEntity::new, ModBlocks.CUSTOM_HEAD_BLOCK
                    ).build()
            );

    public static void initialize() {}

    private ModBlockEntities() {}
}
