package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs.BookshelfStairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericStairsBlock.StairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs.VerticalBookshelfStairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock.VerticalStairsSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Stairs implements MinekeaBlockCategory {
    public static final Map<String, GenericStairsBlock> STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericBookshelfStairs> BOOKSHELF_STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericVerticalStairsBlock> VERTICAL_STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericVerticalBookshelfStairs> VERTICAL_BOOKSHELF_STAIRS = new LinkedHashMap<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasStairs()) {
                STAIRS.put(blockSettings.getMainMaterial(), new GenericStairsBlock(new StairsSettings(blockSettings)));
            }

            if (blockSettings.hasBookshelfStairs()) {
                BOOKSHELF_STAIRS.put(blockSettings.getMainMaterial(), new GenericBookshelfStairs(new BookshelfStairsSettings(blockSettings)));
            }

            if (blockSettings.hasVerticalStairs()) {
                VERTICAL_STAIRS.put(blockSettings.getMainMaterial(), new GenericVerticalStairsBlock(new VerticalStairsSettings(blockSettings)));
            }

            if (blockSettings.hasVerticalBookshelfStairs()) {
                VERTICAL_BOOKSHELF_STAIRS.put(blockSettings.getMainMaterial(), new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(blockSettings)));
            }
        }
    }

    @Override
    public void initializeClient() {
        for (GenericStairsBlock block : STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }

        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericStairsBlock block : STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelfStairs block : BOOKSHELF_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericVerticalBookshelfStairs block : VERTICAL_BOOKSHELF_STAIRS.values()) {
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
