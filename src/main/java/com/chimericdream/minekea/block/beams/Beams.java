package com.chimericdream.minekea.block.beams;

import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class Beams implements MinekeaBlockCategory {
    public static final GenericBeamBlock ANDESITE_BEAM;
    public static final GenericBeamBlock BASALT_BEAM;
    public static final GenericBeamBlock BLACKSTONE_BEAM;
    public static final GenericBeamBlock BONE_BEAM;
    public static final GenericBeamBlock BRICK_BEAM;
    public static final GenericBeamBlock CALCITE_BEAM;
    public static final GenericBeamBlock COBBLED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock COBBLESTONE_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock CRACKED_STONE_BRICK_BEAM;
    public static final GenericBeamBlock CRYING_OBSIDIAN_BEAM;
    public static final GenericBeamBlock CUT_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock CUT_SANDSTONE_BEAM;
    public static final GenericBeamBlock DARK_PRISMARINE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock DIORITE_BEAM;
    public static final GenericBeamBlock END_STONE_BEAM;
    public static final GenericBeamBlock END_STONE_BRICK_BEAM;
    public static final GenericBeamBlock GRANITE_BEAM;
    public static final GenericBeamBlock MOSSY_COBBLESTONE_BEAM;
    public static final GenericBeamBlock MOSSY_STONE_BRICK_BEAM;
    public static final GenericBeamBlock NETHER_BRICK_BEAM;
    public static final GenericBeamBlock NETHERRACK_BEAM;
    public static final GenericBeamBlock OBSIDIAN_BEAM;
    public static final GenericBeamBlock POLISHED_ANDESITE_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BRICK_BEAM;
    public static final GenericBeamBlock POLISHED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock POLISHED_DIORITE_BEAM;
    public static final GenericBeamBlock POLISHED_GRANITE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BRICK_BEAM;
    public static final GenericBeamBlock PURPUR_BEAM;
    public static final GenericBeamBlock PURPUR_PILLAR_BEAM;
    public static final GenericBeamBlock RED_NETHER_BRICK_BEAM;
    public static final GenericBeamBlock RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_BASALT_BEAM;
    public static final GenericBeamBlock SMOOTH_STONE_BEAM;
    public static final GenericBeamBlock STONE_BEAM;
    public static final GenericBeamBlock STONE_BRICK_BEAM;
    public static final GenericBeamBlock TUFF_BEAM;
    public static final GenericBeamBlock WARPED_NETHER_BRICK_BEAM;

    public static final GenericBeamBlock AMETHYST_BEAM;
    public static final GenericBeamBlock POLISHED_BASALT_BEAM;
    public static final GenericBeamBlock SMOOTH_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_SANDSTONE_BEAM;

    static {
        ANDESITE_BEAM = new GenericBeamBlock("andesite", Map.of("main", new Identifier("minecraft:andesite")));
        BLACKSTONE_BEAM = new GenericBeamBlock("blackstone", Map.of("main", new Identifier("minecraft:blackstone")));
        BRICK_BEAM = new GenericBeamBlock("brick", Map.of("main", new Identifier("minecraft:bricks")));
        CALCITE_BEAM = new GenericBeamBlock("calcite", Map.of("main", new Identifier("minecraft:calcite")));
        COBBLED_DEEPSLATE_BEAM = new GenericBeamBlock("cobbled_deepslate", Map.of("main", new Identifier("minecraft:cobbled_deepslate")));
        COBBLESTONE_BEAM = new GenericBeamBlock("cobblestone", Map.of("main", new Identifier("minecraft:cobblestone")));
        CRACKED_DEEPSLATE_BRICK_BEAM = new GenericBeamBlock("cracked_deepslate_brick", Map.of("main", new Identifier("minecraft:cracked_deepslate_bricks")));
        CRACKED_DEEPSLATE_TILE_BEAM = new GenericBeamBlock("cracked_deepslate_tile", Map.of("main", new Identifier("minecraft:cracked_deepslate_tiles")));
        CRACKED_STONE_BRICK_BEAM = new GenericBeamBlock("cracked_stone_brick", Map.of("main", new Identifier("minecraft:cracked_stone_bricks")));
        CRYING_OBSIDIAN_BEAM = new GenericBeamBlock("crying_obsidian", Map.of("main", new Identifier("minecraft:crying_obsidian")));
        CUT_RED_SANDSTONE_BEAM = new GenericBeamBlock("cut_red_sandstone", Map.of("main", new Identifier("minecraft:cut_red_sandstone")));
        CUT_SANDSTONE_BEAM = new GenericBeamBlock("cut_sandstone", Map.of("main", new Identifier("minecraft:cut_sandstone")));
        DARK_PRISMARINE_BEAM = new GenericBeamBlock("dark_prismarine", Map.of("main", new Identifier("minecraft:dark_prismarine")));
        DEEPSLATE_BEAM = new GenericBeamBlock("deepslate", Map.of("main", new Identifier("minecraft:deepslate")));
        DEEPSLATE_BRICK_BEAM = new GenericBeamBlock("deepslate_brick", Map.of("main", new Identifier("minecraft:deepslate_bricks")));
        DEEPSLATE_TILE_BEAM = new GenericBeamBlock("deepslate_tile", Map.of("main", new Identifier("minecraft:deepslate_tiles")));
        DIORITE_BEAM = new GenericBeamBlock("diorite", Map.of("main", new Identifier("minecraft:diorite")));
        END_STONE_BEAM = new GenericBeamBlock("end_stone", Map.of("main", new Identifier("minecraft:end_stone")));
        END_STONE_BRICK_BEAM = new GenericBeamBlock("end_stone_brick", Map.of("main", new Identifier("minecraft:end_stone_bricks")));
        GRANITE_BEAM = new GenericBeamBlock("granite", Map.of("main", new Identifier("minecraft:granite")));
        MOSSY_COBBLESTONE_BEAM = new GenericBeamBlock("mossy_cobblestone", Map.of("main", new Identifier("minecraft:mossy_cobblestone")));
        MOSSY_STONE_BRICK_BEAM = new GenericBeamBlock("mossy_stone_brick", Map.of("main", new Identifier("minecraft:mossy_stone_bricks")));
        NETHER_BRICK_BEAM = new GenericBeamBlock("nether_brick", Map.of("main", new Identifier("minecraft:nether_bricks")));
        NETHERRACK_BEAM = new GenericBeamBlock("netherrack", Map.of("main", new Identifier("minecraft:netherrack")));
        OBSIDIAN_BEAM = new GenericBeamBlock("obsidian", Map.of("main", new Identifier("minecraft:obsidian")));
        POLISHED_ANDESITE_BEAM = new GenericBeamBlock("polished_andesite", Map.of("main", new Identifier("minecraft:polished_andesite")));
        POLISHED_BLACKSTONE_BEAM = new GenericBeamBlock("polished_blackstone", Map.of("main", new Identifier("minecraft:polished_blackstone")));
        POLISHED_BLACKSTONE_BRICK_BEAM = new GenericBeamBlock("polished_blackstone_brick", Map.of("main", new Identifier("minecraft:polished_blackstone_bricks")));
        POLISHED_DEEPSLATE_BEAM = new GenericBeamBlock("polished_deepslate", Map.of("main", new Identifier("minecraft:polished_deepslate")));
        POLISHED_DIORITE_BEAM = new GenericBeamBlock("polished_diorite", Map.of("main", new Identifier("minecraft:polished_diorite")));
        POLISHED_GRANITE_BEAM = new GenericBeamBlock("polished_granite", Map.of("main", new Identifier("minecraft:polished_granite")));
        PRISMARINE_BEAM = new GenericBeamBlock("prismarine", Map.of("main", new Identifier("minecraft:prismarine")));
        PRISMARINE_BRICK_BEAM = new GenericBeamBlock("prismarine_brick", Map.of("main", new Identifier("minecraft:prismarine_bricks")));
        PURPUR_PILLAR_BEAM = new GenericBeamBlock("purpur_pillar", Map.of("main", new Identifier("minecraft:purpur_pillar")));
        RED_NETHER_BRICK_BEAM = new GenericBeamBlock("red_nether_brick", Map.of("main", new Identifier("minecraft:red_nether_bricks")));
        RED_SANDSTONE_BEAM = new GenericBeamBlock("red_sandstone", Map.of("main", new Identifier("minecraft:red_sandstone")));
        SANDSTONE_BEAM = new GenericBeamBlock("sandstone", Map.of("main", new Identifier("minecraft:sandstone")));
        SMOOTH_BASALT_BEAM = new GenericBeamBlock("smooth_basalt", Map.of("main", new Identifier("minecraft:smooth_basalt")));
        SMOOTH_STONE_BEAM = new GenericBeamBlock("smooth_stone", Map.of("main", new Identifier("minecraft:smooth_stone")));
        STONE_BEAM = new GenericBeamBlock("stone", Map.of("main", new Identifier("minecraft:stone")));
        STONE_BRICK_BEAM = new GenericBeamBlock("stone_brick", Map.of("main", new Identifier("minecraft:stone_bricks")));
        TUFF_BEAM = new GenericBeamBlock("tuff", Map.of("main", new Identifier("minecraft:tuff")));
        WARPED_NETHER_BRICK_BEAM = new GenericBeamBlock("warped_nether_brick", Map.of("main", WarpedNetherBricksBlock.BLOCK_ID));

        AMETHYST_BEAM = new GenericBeamBlock(
            "amethyst",
            Map.of(
                "main", new Identifier("minecraft:amethyst_block"),
                "ingredient", new Identifier("minecraft:amethyst_shard")
            )
        );
        BASALT_BEAM = new GenericBeamBlock(
            "basalt",
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );
        BONE_BEAM = new GenericBeamBlock(
            "bone",
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );
        POLISHED_BASALT_BEAM = new GenericBeamBlock(
            "polished_basalt",
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );
        PURPUR_BEAM = new GenericBeamBlock(
            "purpur",
            Map.of(
                "main", new Identifier("minecraft:purpur_block"),
                "ingredient", new Identifier("minecraft:purpur")
            )
        );
        SMOOTH_RED_SANDSTONE_BEAM = new GenericBeamBlock(
            "smooth_red_sandstone",
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );
        SMOOTH_SANDSTONE_BEAM = new GenericBeamBlock(
            "smooth_sandstone",
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );
    }

    @Override
    public void registerBlocks() {
        AMETHYST_BEAM.register(false);
        ANDESITE_BEAM.register(false);
        BASALT_BEAM.register(false);
        BLACKSTONE_BEAM.register(false);
        BONE_BEAM.register(false);
        BRICK_BEAM.register(false);
        CALCITE_BEAM.register(false);
        COBBLED_DEEPSLATE_BEAM.register(false);
        COBBLESTONE_BEAM.register(false);
        CRACKED_DEEPSLATE_BRICK_BEAM.register(false);
        CRACKED_DEEPSLATE_TILE_BEAM.register(false);
        CRACKED_STONE_BRICK_BEAM.register(false);
        CRYING_OBSIDIAN_BEAM.register(false);
        CUT_RED_SANDSTONE_BEAM.register(false);
        CUT_SANDSTONE_BEAM.register(false);
        DARK_PRISMARINE_BEAM.register(false);
        DEEPSLATE_BEAM.register(false);
        DEEPSLATE_BRICK_BEAM.register(false);
        DEEPSLATE_TILE_BEAM.register(false);
        DIORITE_BEAM.register(false);
        END_STONE_BEAM.register(false);
        END_STONE_BRICK_BEAM.register(false);
        GRANITE_BEAM.register(false);
        MOSSY_COBBLESTONE_BEAM.register(false);
        MOSSY_STONE_BRICK_BEAM.register(false);
        NETHER_BRICK_BEAM.register(false);
        NETHERRACK_BEAM.register(false);
        OBSIDIAN_BEAM.register(false);
        POLISHED_ANDESITE_BEAM.register(false);
        POLISHED_BASALT_BEAM.register(false);
        POLISHED_BLACKSTONE_BEAM.register(false);
        POLISHED_BLACKSTONE_BRICK_BEAM.register(false);
        POLISHED_DEEPSLATE_BEAM.register(false);
        POLISHED_DIORITE_BEAM.register(false);
        POLISHED_GRANITE_BEAM.register(false);
        PRISMARINE_BEAM.register(false);
        PRISMARINE_BRICK_BEAM.register(false);
        PURPUR_BEAM.register(false);
        PURPUR_PILLAR_BEAM.register(false);
        RED_NETHER_BRICK_BEAM.register(false);
        RED_SANDSTONE_BEAM.register(false);
        SANDSTONE_BEAM.register(false);
        SMOOTH_BASALT_BEAM.register(false);
        SMOOTH_RED_SANDSTONE_BEAM.register(false);
        SMOOTH_SANDSTONE_BEAM.register(false);
        SMOOTH_STONE_BEAM.register(false);
        STONE_BEAM.register(false);
        STONE_BRICK_BEAM.register(false);
        TUFF_BEAM.register(false);
        WARPED_NETHER_BRICK_BEAM.register(false);
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
