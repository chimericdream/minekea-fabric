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
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock BASALT_BRICKS_BLOCK;
    public static final ChiseledBasaltBricksBlock CHISELED_BASALT_BRICKS_BLOCK;
    public static final CobbledEndStoneBlock COBBLED_END_STONE_BLOCK;
    public static final CrackedBasaltBricksBlock CRACKED_BASALT_BRICKS_BLOCK;
    public static final CrimsonBasaltBricksBlock CRIMSON_BASALT_BRICKS_BLOCK;
    public static final MossyBasaltBricksBlock MOSSY_BASALT_BRICKS_BLOCK;
    public static final WarpedBasaltBricksBlock WARPED_BASALT_BRICKS_BLOCK;
    public static final WarpedNetherBricksBlock WARPED_NETHER_BRICKS_BLOCK;

    public static final Beams BEAMS;
    public static final CompressedBlocks COMPRESSED_BLOCKS;
    public static final Covers COVERS;
    public static final Slabs SLABS;
    public static final Stairs STAIRS;
    public static final StorageBlocks STORAGE_BLOCKS;
    public static final Walls WALLS;

    private static final List<MinekeaBlock> BLOCKS = new ArrayList<>();
    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
        COBBLED_END_STONE_BLOCK = new CobbledEndStoneBlock();
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();

        BLOCKS.addAll(List.of(
            BASALT_BRICKS_BLOCK,
            CHISELED_BASALT_BRICKS_BLOCK,
            COBBLED_END_STONE_BLOCK,
            CRACKED_BASALT_BRICKS_BLOCK,
            CRIMSON_BASALT_BRICKS_BLOCK,
            MOSSY_BASALT_BRICKS_BLOCK,
            WARPED_BASALT_BRICKS_BLOCK,
            WARPED_NETHER_BRICKS_BLOCK
        ));

        BEAMS = new Beams();
        COMPRESSED_BLOCKS = new CompressedBlocks();
        COVERS = new Covers();
        SLABS = new Slabs();
        STAIRS = new Stairs();
        STORAGE_BLOCKS = new StorageBlocks();
        WALLS = new Walls();

        BLOCK_GROUPS.addAll(List.of(
            BEAMS,
            COMPRESSED_BLOCKS,
            COVERS,
            SLABS,
            STAIRS,
            STORAGE_BLOCKS,
            WALLS
        ));
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
