package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.CompressedBlockSettings;
import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_COUNT;
import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_LEVEL;

public class CompressedBlocks implements MinekeaBlockCategory {
    public static final Map<String, List<GenericCompressedBlock>> BLOCK_MAP = new LinkedHashMap<>();
    public static final List<GenericCompressedBlock> BLOCKS = new ArrayList<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasCompressedBlock()) {
                List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

                for (int i = 1; i <= 9; i += 1) {
                    compressedBlocks.add(new GenericCompressedBlock(new CompressedBlockSettings(settings).compressionLevel(i)));
                }

                BLOCKS.addAll(compressedBlocks);

                BLOCK_MAP.put(settings.getMainMaterial(), compressedBlocks);
            }

            if (config.enableDyedBlocks && settings.hasDyedBlocks()) {
                for (String color : Colors.getColors()) {
                    List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

                    for (int i = 1; i <= 9; i += 1) {
                        compressedBlocks.add(new GenericCompressedBlock(new CompressedBlockSettings(new DyedBlockSettings(settings).color(color).asDefaultSettings()).compressionLevel(i)));
                    }

                    BLOCKS.addAll(compressedBlocks);

                    BLOCK_MAP.put(String.format("%s/%s", settings.getMainMaterial(), color), compressedBlocks);
                }
            }
        }
    }

    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), BLOCKS.toArray(new Block[0]));
    }

    @Override
    public void registerBlocks() {
        for (GenericCompressedBlock block : BLOCKS) {
            block.register();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.entry(TOOLTIP_LEVEL, "%dx Compressed");
        MinekeaResourcePack.EN_US.entry(TOOLTIP_COUNT, "(%s blocks)");
    }
}
