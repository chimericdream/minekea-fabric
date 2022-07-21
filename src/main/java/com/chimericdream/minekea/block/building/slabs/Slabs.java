package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab.BookshelfSlabSettings;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock.SlabSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Slabs implements MinekeaBlockCategory {
    public static final Map<String, GenericSlabBlock> SLABS = new LinkedHashMap<>();
    public static final Map<String, GenericBookshelfSlab> BOOKSHELF_SLABS = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasSlab()) {
                SLABS.put(settings.getMainMaterial(), new GenericSlabBlock(new SlabSettings(settings)));
            }

            if (settings.hasBookshelfSlab()) {
                BOOKSHELF_SLABS.put(
                    settings.getMainMaterial(),
                    new GenericBookshelfSlab(
                        new BookshelfSlabSettings(settings)
                            .addMaterial("bookshelf", settings.getBookshelfId())
                            .addMaterial("model", settings.getBookshelfModel())
                    )
                );
            }

            if (config.enableDyedBlocks && settings.hasDyedBlocks()) {
                for (String color : Colors.getColors()) {
                    SLABS.put(String.format("%s/%s", settings.getMainMaterial(), color), new GenericSlabBlock(new SlabSettings(new DyedBlockSettings(settings).color(color).asDefaultSettings())));
                }
            }
        }
    }

    @Override
    public void initializeClient() {
        for (GenericSlabBlock block : SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericSlabBlock block : SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
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
    }
}
