package dev.ayazyt4146.customheadblock;

import dev.ayazyt4146.customheadblock.block.ModBlocks;
import dev.ayazyt4146.customheadblock.block.entity.ModBlockEntities;
import dev.ayazyt4146.customheadblock.network.ModNetworking;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CustomHeadBlockMod implements ModInitializer {
    public static final String MOD_ID = "customheadblock";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ModBlockEntities.initialize();
        ModNetworking.initialize();
        LOGGER.info("Custom Head Block initialized.");
    }
}
