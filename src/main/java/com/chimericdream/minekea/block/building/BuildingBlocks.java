package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.general.*;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.walls.Walls;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

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
    public static DyedBlocks DYED_BLOCKS = null;
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

        DYED_BLOCKS = new DyedBlocks();
        BLOCK_GROUPS.add(DYED_BLOCKS);

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
        MinekeaConfig config = ConfigManager.getConfig();

        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }

        Identifier myEndStone = new Identifier("minekea:end_stone");

        if (config.enableCobbledEndStone) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minecraft:block/cube_all")
                    .textures(
                        new JTextures().var("all", "minekea:block/building/general/end_stone")
                    ),
                Model.getBlockModelID(myEndStone)
            );

            MinekeaResourcePack.RESOURCE_PACK.addLootTable(
                LootTable.blockID(myEndStone),
                JLootTable.loot("minecraft:block")
                    .pool(
                        JLootTable.pool()
                            .rolls(1)
                            .entry(
                                new JEntry()
                                    .type("minecraft:alternatives")
                                    .child(
                                        new JEntry()
                                            .type("minecraft:item")
                                            .name("minecraft:end_stone")
                                            .condition(
                                                new JCondition()
                                                    .condition("minecraft:match_tool")
                                                    .parameter("predicate", LootTable.silkTouchPredicate())
                                            )
                                    )
                                    .child(new JEntry().type("minecraft:item").name(COBBLED_END_STONE_BLOCK.getBlockID().toString()))
                            )
                            .condition(new JCondition().condition("minecraft:survives_explosion"))
                    )
            );
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minecraft:block/cube_all")
                    .textures(
                        new JTextures().var("all", "minekea:block/building/general/cobbled_end_stone")
                    ),
                Model.getBlockModelID(myEndStone)
            );

            MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(myEndStone), LootTable.dropSelf(new Identifier("minecraft:end_stone")));
        }
    }
}
