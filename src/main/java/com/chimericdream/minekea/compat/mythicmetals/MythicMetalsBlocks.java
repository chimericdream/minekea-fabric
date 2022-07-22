package com.chimericdream.minekea.compat.mythicmetals;

import com.chimericdream.minekea.block.building.beams.GenericBeamBlock;
import com.chimericdream.minekea.block.building.beams.GenericBeamBlock.BeamSettings;
import com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock;
import com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.CompressedBlockSettings;
import com.chimericdream.minekea.block.building.covers.GenericCoverBlock;
import com.chimericdream.minekea.block.building.covers.GenericCoverBlock.CoverSettings;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock.SlabSettings;
import com.chimericdream.minekea.block.building.stairs.GenericStairsBlock;
import com.chimericdream.minekea.block.building.stairs.GenericStairsBlock.StairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock.VerticalStairsSettings;
import com.chimericdream.minekea.block.building.walls.GenericWallBlock;
import com.chimericdream.minekea.block.building.walls.GenericWallBlock.WallSettings;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MythicMetalsBlocks implements ModCompatLayer {
    public static final Map<String, GenericBeamBlock> BEAMS = new LinkedHashMap<>();
    public static final Map<String, List<GenericCompressedBlock>> COMPRESSED_BLOCK_MAP = new LinkedHashMap<>();
    public static final List<GenericCompressedBlock> COMPRESSED_BLOCKS = new ArrayList<>();
    public static final Map<String, GenericCoverBlock> COVERS = new LinkedHashMap<>();
    public static final Map<String, GenericSlabBlock> SLABS = new LinkedHashMap<>();
    public static final Map<String, GenericStairsBlock> STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericVerticalStairsBlock> VERTICAL_STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericWallBlock> WALLS = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : MythicMetalsBlockSettings.ALL_SETTINGS) {
            if (config.enableBeams && settings.hasBeam()) {
                BEAMS.put(settings.getMainMaterial(), new GenericBeamBlock(new BeamSettings(settings)));
            }

            if (config.enableCompressedBlocks && settings.hasCompressedBlock()) {
                List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

                for (int i = 1; i <= 9; i += 1) {
                    compressedBlocks.add(new GenericCompressedBlock(new CompressedBlockSettings(settings).compressionLevel(i)));
                }

                COMPRESSED_BLOCKS.addAll(compressedBlocks);

                COMPRESSED_BLOCK_MAP.put(settings.getMainMaterial(), compressedBlocks);
            }

            if (config.enableCovers && settings.hasCover()) {
                COVERS.put(settings.getMainMaterial(), new GenericCoverBlock(new CoverSettings(settings)));
            }

            if (config.enableSlabs && settings.hasSlab()) {
                SLABS.put(settings.getMainMaterial(), new GenericSlabBlock(new SlabSettings(settings)));
            }

            if (config.enableStairs && settings.hasStairs()) {
                STAIRS.put(settings.getMainMaterial(), new GenericStairsBlock(new StairsSettings(settings)));
            }

            if (config.enableVerticalStairs && settings.hasVerticalStairs()) {
                VERTICAL_STAIRS.put(settings.getMainMaterial(), new GenericVerticalStairsBlock(new VerticalStairsSettings(settings)));
            }

            if (config.enableWalls && settings.hasWall()) {
                WALLS.put(settings.getMainMaterial(), new GenericWallBlock(new WallSettings(settings)));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), COMPRESSED_BLOCKS.toArray(new Block[0]));
    }

    @Override
    public void register() {
        for (GenericBeamBlock block : BEAMS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericCompressedBlock block : COMPRESSED_BLOCKS) {
            block.register();
        }

        for (GenericCoverBlock block : COVERS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericSlabBlock block : SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericStairsBlock block : STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericWallBlock block : WALLS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public List<GenericCrate> getCrates() {
        return new ArrayList<>();
    }

    @Override
    public List<GenericDisplayCase> getDisplayCases() {
        return new ArrayList<>();
    }

    @Override
    public List<GenericShelf> getShelves() {
        return new ArrayList<>();
    }

    @Override
    public List<GenericStorageBookshelf> getStorageShelves() {
        return new ArrayList<>();
    }

    @Override
    public void setupResources() {
    }
}
