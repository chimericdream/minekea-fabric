package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.end_stone.*;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickSlabBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickStairsBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
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

    public static final EndStoneSlabBlock END_STONE_SLAB_BLOCK;
    public static final EndStoneStairsBlock END_STONE_STAIRS_BLOCK;

    public static final CobbledEndStoneBlock COBBLED_END_STONE_BLOCK;
    public static final CobbledEndStoneSlabBlock COBBLED_END_STONE_SLAB_BLOCK;
    public static final CobbledEndStoneStairsBlock COBBLED_END_STONE_STAIRS_BLOCK;
    public static final CobbledEndStoneWallBlock COBBLED_END_STONE_WALL_BLOCK;

    public static final Beams BEAMS;
    public static final Covers COVERS;
    public static final Slabs SLABS;
    public static final Stairs STAIRS;
    public static final StorageBlocks STORAGE_BLOCKS;

    private static final List<MinekeaBlock> BLOCKS = new ArrayList<>();
    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

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

        END_STONE_SLAB_BLOCK = new EndStoneSlabBlock();
        END_STONE_STAIRS_BLOCK = new EndStoneStairsBlock();

        COBBLED_END_STONE_BLOCK = new CobbledEndStoneBlock();
        COBBLED_END_STONE_SLAB_BLOCK = new CobbledEndStoneSlabBlock();
        COBBLED_END_STONE_STAIRS_BLOCK = new CobbledEndStoneStairsBlock();
        COBBLED_END_STONE_WALL_BLOCK = new CobbledEndStoneWallBlock();

        BLOCKS.addAll(List.of(
            BASALT_BRICKS_BLOCK,
            BASALT_BRICK_SLAB_BLOCK,
            BASALT_BRICK_STAIRS_BLOCK,
            CRACKED_BASALT_BRICKS_BLOCK,
            CRACKED_BASALT_BRICK_SLAB_BLOCK,
            CRACKED_BASALT_BRICK_STAIRS_BLOCK,
            CRIMSON_BASALT_BRICKS_BLOCK,
            CRIMSON_BASALT_BRICK_SLAB_BLOCK,
            CRIMSON_BASALT_BRICK_STAIRS_BLOCK,
            MOSSY_BASALT_BRICKS_BLOCK,
            MOSSY_BASALT_BRICK_SLAB_BLOCK,
            MOSSY_BASALT_BRICK_STAIRS_BLOCK,
            WARPED_BASALT_BRICKS_BLOCK,
            WARPED_BASALT_BRICK_SLAB_BLOCK,
            WARPED_BASALT_BRICK_STAIRS_BLOCK,
            CHISELED_BASALT_BRICKS_BLOCK,
            WARPED_NETHER_BRICK_SLAB_BLOCK,
            WARPED_NETHER_BRICK_STAIRS_BLOCK,
            WARPED_NETHER_BRICKS_BLOCK,
            END_STONE_SLAB_BLOCK,
            END_STONE_STAIRS_BLOCK,
            COBBLED_END_STONE_BLOCK,
            COBBLED_END_STONE_SLAB_BLOCK,
            COBBLED_END_STONE_STAIRS_BLOCK,
            COBBLED_END_STONE_WALL_BLOCK
        ));

        BEAMS = new Beams();
        COVERS = new Covers();
        SLABS = new Slabs();
        STAIRS = new Stairs();
        STORAGE_BLOCKS = new StorageBlocks();

        BLOCK_GROUPS.addAll(List.of(
            BEAMS,
            COVERS,
            SLABS,
            STAIRS,
            STORAGE_BLOCKS
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
