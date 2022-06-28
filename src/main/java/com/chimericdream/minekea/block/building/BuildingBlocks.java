package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.general.*;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.walls.Walls;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock BASALT_BRICKS_BLOCK;
    public static final ChiseledBasaltBricksBlock CHISELED_BASALT_BRICKS_BLOCK;
    public static CobbledEndStoneBlock COBBLED_END_STONE_BLOCK = null;
    public static final CrackedBasaltBricksBlock CRACKED_BASALT_BRICKS_BLOCK;
    public static final CrimsonBasaltBricksBlock CRIMSON_BASALT_BRICKS_BLOCK;
    public static final MossyBasaltBricksBlock MOSSY_BASALT_BRICKS_BLOCK;
    public static final WarpedBasaltBricksBlock WARPED_BASALT_BRICKS_BLOCK;
    public static final WarpedNetherBricksBlock WARPED_NETHER_BRICKS_BLOCK;

    public static Beams BEAMS = null;
    public static CompressedBlocks COMPRESSED_BLOCKS = null;
    public static Covers COVERS = null;
    public static Slabs SLABS = null;
    public static Stairs STAIRS = null;
    public static final StorageBlocks STORAGE_BLOCKS;
    public static Walls WALLS = null;

    private static final List<MinekeaBlock> BLOCKS = new ArrayList<>();
    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
        if (config.enableCobbledEndStone) {
            COBBLED_END_STONE_BLOCK = new CobbledEndStoneBlock();
        }
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();

        BLOCKS.addAll(List.of(BASALT_BRICKS_BLOCK, CHISELED_BASALT_BRICKS_BLOCK));

        if (config.enableCobbledEndStone) {
            BLOCKS.add(COBBLED_END_STONE_BLOCK);
        }

        BLOCKS.addAll(List.of(
            CRACKED_BASALT_BRICKS_BLOCK,
            CRIMSON_BASALT_BRICKS_BLOCK,
            MOSSY_BASALT_BRICKS_BLOCK,
            WARPED_BASALT_BRICKS_BLOCK,
            WARPED_NETHER_BRICKS_BLOCK
        ));

        if (config.enableBeams) {
            BEAMS = new Beams();
            BLOCK_GROUPS.add(BEAMS);
        }

        if (config.enableCompressedBlocks) {
            COMPRESSED_BLOCKS = new CompressedBlocks();
            BLOCK_GROUPS.add(COMPRESSED_BLOCKS);
        }

        if (config.enableCovers) {
            COVERS = new Covers();
            BLOCK_GROUPS.add(COVERS);
        }

        if (config.enableSlabs) {
            SLABS = new Slabs();
            BLOCK_GROUPS.add(SLABS);
        }

        if (config.enableStairs) {
            STAIRS = new Stairs();
            BLOCK_GROUPS.add(STAIRS);
        }

        if (config.enableWalls) {
            WALLS = new Walls();
            BLOCK_GROUPS.add(WALLS);
        }

        STORAGE_BLOCKS = new StorageBlocks();
        BLOCK_GROUPS.add(STORAGE_BLOCKS);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.initializeClient();
        }
    }

    @Override
    public void registerBlocks() {
        for (MinekeaBlock block : BLOCKS) {
            block.register();
        }

        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlocks();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities(otherMods);
        }
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities(otherMods);
        }
    }

    @Override
    public void setupResources() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }
    }
}
