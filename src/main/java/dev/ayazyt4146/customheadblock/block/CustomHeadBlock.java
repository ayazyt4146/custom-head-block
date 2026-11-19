package dev.ayazyt4146.customheadblock.block;

import com.mojang.serialization.MapCodec;
import dev.ayazyt4146.customheadblock.block.entity.CustomHeadBlockEntity;
import dev.ayazyt4146.customheadblock.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.TagValueOutput;

public final class CustomHeadBlock extends BaseEntityBlock {
    public static final MapCodec<CustomHeadBlock> CODEC = simpleCodec(CustomHeadBlock::new);

    public CustomHeadBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CustomHeadBlockEntity(pos, state);
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack stack = super.getCloneItemStack(level, pos, state, includeData);
        if (includeData && level.getBlockEntity(pos) instanceof CustomHeadBlockEntity head) {
            TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, level.registryAccess());
            head.saveCustomOnly(output);
            BlockItem.setBlockEntityData(stack, ModBlockEntities.CUSTOM_HEAD_BLOCK_ENTITY, output);
        }
        return stack;
    }
}
