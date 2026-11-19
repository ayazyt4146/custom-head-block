package dev.ayazyt4146.customheadblock.block;

import com.mojang.serialization.MapCodec;
import dev.ayazyt4146.customheadblock.block.entity.CustomHeadBlockEntity;
import dev.ayazyt4146.customheadblock.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

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
}
