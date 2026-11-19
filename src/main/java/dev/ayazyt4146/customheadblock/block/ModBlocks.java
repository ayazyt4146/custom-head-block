package dev.ayazyt4146.customheadblock.block;

import dev.ayazyt4146.customheadblock.CustomHeadBlockMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ModBlocks {
    public static final Block CUSTOM_HEAD_BLOCK = register();

    private static Block register() {
        Identifier id = Identifier.fromNamespaceAndPath(CustomHeadBlockMod.MOD_ID, "custom_head_block");
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        // Minecraft 26.2 requires the registry key before the Block is constructed.
        Block block = new CustomHeadBlock(
                BlockBehaviour.Properties.of()
                        .setId(blockKey)
                        .strength(1.5F)
                        .sound(SoundType.STONE)
        );

        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                new BlockItem(block, new Item.Properties()
                        .setId(itemKey)
                        .useBlockDescriptionPrefix())
        );
        return block;
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(entries -> entries.accept(CUSTOM_HEAD_BLOCK));
    }

    private ModBlocks() {}
}
