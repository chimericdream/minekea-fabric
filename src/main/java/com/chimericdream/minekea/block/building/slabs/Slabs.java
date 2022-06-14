package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab.BookshelfSlabSettings;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock.SlabSettings;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Slabs implements MinekeaBlockCategory {
    public static final GenericBookshelfSlab ACACIA_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BIRCH_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CRIMSON_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab DARK_OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab JUNGLE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab MANGROVE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab SPRUCE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab WARPED_BOOKSHELF_SLAB;

    public static final Map<String, GenericSlabBlock> SLABS = new LinkedHashMap<>();
    public static final List<GenericBookshelfSlab> BOOKSHELF_SLABS = new ArrayList<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasSlab()) {
                SLABS.put(blockSettings.getMainMaterial(), new GenericSlabBlock(new SlabSettings(blockSettings)));
            }
        }

        ACACIA_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        MANGROVE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.MANGROVE).addMaterial("bookshelf", Bookshelves.MANGROVE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));

        BOOKSHELF_SLABS.addAll(List.of(
            ACACIA_BOOKSHELF_SLAB,
            BIRCH_BOOKSHELF_SLAB,
            CRIMSON_BOOKSHELF_SLAB,
            DARK_OAK_BOOKSHELF_SLAB,
            JUNGLE_BOOKSHELF_SLAB,
            MANGROVE_BOOKSHELF_SLAB,
            OAK_BOOKSHELF_SLAB,
            SPRUCE_BOOKSHELF_SLAB,
            WARPED_BOOKSHELF_SLAB
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericSlabBlock block : SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS) {
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

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS) {
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
