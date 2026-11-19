package dev.ayazyt4146.customheadblock.block;

import dev.ayazyt4146.customheadblock.CustomHeadBlockMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
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
        Block block = new CustomHeadBlock(
                BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.STONE)
        );
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        Registry.register(
                BuiltInRegistries.ITEM,
                id,
                new BlockItem(block, new Item.Properties())
        );
        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(entries -> entries.accept(CUSTOM_HEAD_BLOCK));
    }

    private ModBlocks() {}
}
