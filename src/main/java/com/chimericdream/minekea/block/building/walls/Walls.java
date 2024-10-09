package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Walls implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        BLOCKS.add(new GenericWallBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }
}
