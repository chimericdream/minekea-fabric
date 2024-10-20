package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Stairs implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericStairsBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))));

        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("acacia_planks").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("birch_planks").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("cherry_planks").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("crimson_planks").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("dark_oak_planks").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("jungle_planks").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("mangrove_planks").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("oak_planks").materialName("Oak").ingredient(Blocks.OAK_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("spruce_planks").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).flammable().tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("warped_planks").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("andesite").materialName("Andesite").ingredient(Blocks.ANDESITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("bamboo_mosaic").materialName("Bamboo Mosaic").ingredient(Blocks.BAMBOO_MOSAIC).tool(Tool.AXE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("blackstone").materialName("Blackstone").ingredient(Blocks.BLACKSTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("bricks").materialName("Brick").ingredient(Blocks.BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("cobbled_deepslate").materialName("Cobbled Deepslate").ingredient(Blocks.COBBLED_DEEPSLATE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("cobblestone").materialName("Cobblestone").ingredient(Blocks.COBBLESTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("deepslate_bricks").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("deepslate_tiles").materialName("Deepslate Tile").ingredient(Blocks.DEEPSLATE_TILES)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("diorite").materialName("Diorite").ingredient(Blocks.DIORITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("end_stone_bricks").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("granite").materialName("Granite").ingredient(Blocks.GRANITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("mossy_cobblestone").materialName("Mossy Cobblestone").ingredient(Blocks.MOSSY_COBBLESTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("mossy_stone_bricks").materialName("Mossy Stone Brick").ingredient(Blocks.MOSSY_STONE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("mud_bricks").materialName("Mud Brick").ingredient(Blocks.MUD_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("nether_bricks").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_blackstone_bricks").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("prismarine_bricks").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("purpur_block").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("quartz_block").materialName("Quartz").ingredient(Blocks.QUARTZ_BLOCK).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_top"))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("red_nether_bricks").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("red_sandstone").materialName("Red Sandstone").ingredient(Blocks.RED_SANDSTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("sandstone").materialName("Sandstone").ingredient(Blocks.SANDSTONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("quartz_block_bottom").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("red_sandstone_top").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("sandstone_top").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("stone_bricks").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("stone").materialName("Stone").ingredient(Blocks.STONE)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("tuff_bricks").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("tuff").materialName("Tuff").ingredient(Blocks.TUFF)));

        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("cut_copper").materialName("Cut Copper").ingredient(Blocks.CUT_COPPER)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("waxed_cut_copper").materialName("Waxed Cut Copper").ingredient(Blocks.WAXED_CUT_COPPER).texture(TextureUtils.block(Blocks.CUT_COPPER))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("exposed_cut_copper").materialName("Exposed Cut Copper").ingredient(Blocks.EXPOSED_CUT_COPPER)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("waxed_exposed_cut_copper").materialName("Waxed Exposed Cut Copper").ingredient(Blocks.WAXED_EXPOSED_CUT_COPPER).texture(TextureUtils.block(Blocks.EXPOSED_CUT_COPPER))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("weathered_cut_copper").materialName("Weathered Cut Copper").ingredient(Blocks.WEATHERED_CUT_COPPER)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("waxed_weathered_cut_copper").materialName("Waxed Weathered Cut Copper").ingredient(Blocks.WAXED_WEATHERED_CUT_COPPER).texture(TextureUtils.block(Blocks.WEATHERED_CUT_COPPER))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("oxidized_cut_copper").materialName("Oxidized Cut Copper").ingredient(Blocks.OXIDIZED_CUT_COPPER)));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("waxed_oxidized_cut_copper").materialName("Waxed Oxidized Cut Copper").ingredient(Blocks.WAXED_OXIDIZED_CUT_COPPER).texture(TextureUtils.block(Blocks.OXIDIZED_CUT_COPPER))));

        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericVerticalStairsBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }
}
