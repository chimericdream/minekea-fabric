package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab.BookshelfSlabSettings;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock.SlabSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
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
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasSlab()) {
                SLABS.put(blockSettings.getMainMaterial(), new GenericSlabBlock(new SlabSettings(blockSettings)));
            }

            if (blockSettings.hasBookshelfSlab()) {
                BOOKSHELF_SLABS.put(
                    blockSettings.getMainMaterial(),
                    new GenericBookshelfSlab(
                        new BookshelfSlabSettings(blockSettings)
                            .addMaterial("bookshelf", blockSettings.getBookshelfId())
                            .addMaterial("model", blockSettings.getBookshelfModel())
                    )
                );
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
