package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickSlabBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickStairsBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.List;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock BASALT_BRICKS_BLOCK;
    public static final BasaltBrickSlabBlock BASALT_BRICK_SLAB_BLOCK;
    public static final BasaltBrickStairsBlock BASALT_BRICK_STAIRS_BLOCK;

    public static final CrackedBasaltBricksBlock CRACKED_BASALT_BRICKS_BLOCK;
    public static final CrackedBasaltBrickSlabBlock CRACKED_BASALT_BRICK_SLAB_BLOCK;
    public static final CrackedBasaltBrickStairsBlock CRACKED_BASALT_BRICK_STAIRS_BLOCK;

    public static final CrimsonBasaltBricksBlock CRIMSON_BASALT_BRICKS_BLOCK;
    public static final CrimsonBasaltBrickSlabBlock CRIMSON_BASALT_BRICK_SLAB_BLOCK;
    public static final CrimsonBasaltBrickStairsBlock CRIMSON_BASALT_BRICK_STAIRS_BLOCK;

    public static final MossyBasaltBricksBlock MOSSY_BASALT_BRICKS_BLOCK;
    public static final MossyBasaltBrickSlabBlock MOSSY_BASALT_BRICK_SLAB_BLOCK;
    public static final MossyBasaltBrickStairsBlock MOSSY_BASALT_BRICK_STAIRS_BLOCK;

    public static final WarpedBasaltBricksBlock WARPED_BASALT_BRICKS_BLOCK;
    public static final WarpedBasaltBrickSlabBlock WARPED_BASALT_BRICK_SLAB_BLOCK;
    public static final WarpedBasaltBrickStairsBlock WARPED_BASALT_BRICK_STAIRS_BLOCK;

    public static final ChiseledBasaltBricksBlock CHISELED_BASALT_BRICKS_BLOCK;

    public static final WarpedNetherBrickSlabBlock WARPED_NETHER_BRICK_SLAB_BLOCK;
    public static final WarpedNetherBrickStairsBlock WARPED_NETHER_BRICK_STAIRS_BLOCK;
    public static final WarpedNetherBricksBlock WARPED_NETHER_BRICKS_BLOCK;

    public static final Beams BEAMS;
    public static final Covers COVERS;
    public static final Stairs STAIRS;
    public static final StorageBlocks STORAGE_BLOCKS;

    static {
        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        BASALT_BRICK_SLAB_BLOCK = new BasaltBrickSlabBlock();
        BASALT_BRICK_STAIRS_BLOCK = new BasaltBrickStairsBlock();

        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRACKED_BASALT_BRICK_SLAB_BLOCK = new CrackedBasaltBrickSlabBlock();
        CRACKED_BASALT_BRICK_STAIRS_BLOCK = new CrackedBasaltBrickStairsBlock();

        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        CRIMSON_BASALT_BRICK_SLAB_BLOCK = new CrimsonBasaltBrickSlabBlock();
        CRIMSON_BASALT_BRICK_STAIRS_BLOCK = new CrimsonBasaltBrickStairsBlock();

        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        MOSSY_BASALT_BRICK_SLAB_BLOCK = new MossyBasaltBrickSlabBlock();
        MOSSY_BASALT_BRICK_STAIRS_BLOCK = new MossyBasaltBrickStairsBlock();

        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
        WARPED_BASALT_BRICK_SLAB_BLOCK = new WarpedBasaltBrickSlabBlock();
        WARPED_BASALT_BRICK_STAIRS_BLOCK = new WarpedBasaltBrickStairsBlock();

        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();

        WARPED_NETHER_BRICK_SLAB_BLOCK = new WarpedNetherBrickSlabBlock();
        WARPED_NETHER_BRICK_STAIRS_BLOCK = new WarpedNetherBrickStairsBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();

        BEAMS = new Beams();
        COVERS = new Covers();
        STAIRS = new Stairs();
        STORAGE_BLOCKS = new StorageBlocks();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BEAMS.initializeClient();
        COVERS.initializeClient();
        STAIRS.initializeClient();
        STORAGE_BLOCKS.initializeClient();
    }

    @Override
    public void registerBlocks() {
        BASALT_BRICKS_BLOCK.register();
        BASALT_BRICK_SLAB_BLOCK.register();
        BASALT_BRICK_STAIRS_BLOCK.register();

        CRACKED_BASALT_BRICKS_BLOCK.register();
        CRACKED_BASALT_BRICK_SLAB_BLOCK.register();
        CRACKED_BASALT_BRICK_STAIRS_BLOCK.register();

        CRIMSON_BASALT_BRICKS_BLOCK.register();
        CRIMSON_BASALT_BRICK_SLAB_BLOCK.register();
        CRIMSON_BASALT_BRICK_STAIRS_BLOCK.register();

        MOSSY_BASALT_BRICKS_BLOCK.register();
        MOSSY_BASALT_BRICK_SLAB_BLOCK.register();
        MOSSY_BASALT_BRICK_STAIRS_BLOCK.register();

        WARPED_BASALT_BRICKS_BLOCK.register();
        WARPED_BASALT_BRICK_SLAB_BLOCK.register();
        WARPED_BASALT_BRICK_STAIRS_BLOCK.register();

        CHISELED_BASALT_BRICKS_BLOCK.register();

        WARPED_NETHER_BRICK_SLAB_BLOCK.register();
        WARPED_NETHER_BRICK_STAIRS_BLOCK.register();
        WARPED_NETHER_BRICKS_BLOCK.register();

        BEAMS.registerBlocks();
        COVERS.registerBlocks();
        STAIRS.registerBlocks();
        STORAGE_BLOCKS.registerBlocks();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        BEAMS.registerBlockEntities(otherMods);
        COVERS.registerBlockEntities(otherMods);
        STAIRS.registerBlockEntities(otherMods);
        STORAGE_BLOCKS.registerBlockEntities(otherMods);
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        BEAMS.registerEntities(otherMods);
        COVERS.registerEntities(otherMods);
        STAIRS.registerEntities(otherMods);
        STORAGE_BLOCKS.registerEntities(otherMods);
    }

    @Override
    public void setupResources() {
        BEAMS.setupResources();
        COVERS.setupResources();
        STAIRS.setupResources();
        STORAGE_BLOCKS.setupResources();
    }
}
