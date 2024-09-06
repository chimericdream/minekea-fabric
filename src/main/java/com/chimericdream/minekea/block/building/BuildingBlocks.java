package com.chimericdream.minekea.block.building;

//import com.chimericdream.minekea.block.building.beams.Beams;
//import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
//import com.chimericdream.minekea.block.building.covers.Covers;

import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.ChiseledBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CobbledEndStoneBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

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

//    public static Beams BEAMS = null;
//    public static CompressedBlocks COMPRESSED_BLOCKS = null;
//    public static Covers COVERS = null;
//    public static Slabs SLABS = null;
//    public static Stairs STAIRS = null;
//    public static final StorageBlocks STORAGE_BLOCKS;
//    public static Walls WALLS = null;

    private static final List<MinekeaBlock> BLOCKS = new ArrayList<>();
    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
//        MinekeaConfig config = ConfigManager.getConfig();

        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
//        if (config.enableCobbledEndStone) {
        COBBLED_END_STONE_BLOCK = new CobbledEndStoneBlock();
//        }
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();

        BLOCKS.addAll(List.of(BASALT_BRICKS_BLOCK, CHISELED_BASALT_BRICKS_BLOCK));

//        if (config.enableCobbledEndStone) {
        BLOCKS.add(COBBLED_END_STONE_BLOCK);
//        }

        BLOCKS.addAll(List.of(
            CRACKED_BASALT_BRICKS_BLOCK,
            CRIMSON_BASALT_BRICKS_BLOCK,
            MOSSY_BASALT_BRICKS_BLOCK,
            WARPED_BASALT_BRICKS_BLOCK,
            WARPED_NETHER_BRICKS_BLOCK
        ));

//        if (config.enableBeams) {
//            BEAMS = new Beams();
//            BLOCK_GROUPS.add(BEAMS);
//        }
//
//        if (config.enableCompressedBlocks) {
//            COMPRESSED_BLOCKS = new CompressedBlocks();
//            BLOCK_GROUPS.add(COMPRESSED_BLOCKS);
//        }
//
//        if (config.enableCovers) {
//            COVERS = new Covers();
//            BLOCK_GROUPS.add(COVERS);
//        }
//
//        if (config.enableSlabs) {
//            SLABS = new Slabs();
//            BLOCK_GROUPS.add(SLABS);
//        }
//
//        if (config.enableStairs) {
//            STAIRS = new Stairs();
//            BLOCK_GROUPS.add(STAIRS);
//        }
//
//        if (config.enableWalls) {
//            WALLS = new Walls();
//            BLOCK_GROUPS.add(WALLS);
//        }
//
//        STORAGE_BLOCKS = new StorageBlocks();
//        BLOCK_GROUPS.add(STORAGE_BLOCKS);
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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> {
                itemGroup.add(BASALT_BRICKS_BLOCK);
                itemGroup.add(CHISELED_BASALT_BRICKS_BLOCK);
                itemGroup.add(CRACKED_BASALT_BRICKS_BLOCK);
                itemGroup.add(CRIMSON_BASALT_BRICKS_BLOCK);
                itemGroup.add(MOSSY_BASALT_BRICKS_BLOCK);
                itemGroup.add(WARPED_BASALT_BRICKS_BLOCK);
                itemGroup.add(WARPED_NETHER_BRICKS_BLOCK);
            });
    }

    @Override
    public void registerBlockEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities();
        }
    }

    @Override
    public void registerEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities();
        }
    }

    @Override
    public void setupResources() {
//        MinekeaConfig config = ConfigManager.getConfig();

        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }

//        Identifier myEndStone = Identifier.of("minekea:end_stone");
//
//        if (config.enableCobbledEndStone) {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(
//                JModel.model("minecraft:block/cube_all")
//                    .textures(
//                        new JTextures().var("all", "minekea:block/building/general/end_stone")
//                    ),
//                Model.getBlockModelID(myEndStone)
//            );
//
//            MinekeaResourcePack.RESOURCE_PACK.addLootTable(
//                LootTable.blockID(myEndStone),
//                JLootTable.loot("minecraft:block")
//                    .pool(
//                        JLootTable.pool()
//                            .rolls(1)
//                            .entry(
//                                new JEntry()
//                                    .type("minecraft:alternatives")
//                                    .child(
//                                        new JEntry()
//                                            .type("minecraft:item")
//                                            .name("minecraft:end_stone")
//                                            .condition(
//                                                new JCondition()
//                                                    .condition("minecraft:match_tool")
//                                                    .parameter("predicate", LootTable.silkTouchPredicate())
//                                            )
//                                    )
//                                    .child(new JEntry().type("minecraft:item").name(COBBLED_END_STONE_BLOCK.getBlockID().toString()))
//                            )
//                            .condition(new JCondition().condition("minecraft:survives_explosion"))
//                    )
//            );
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(
//                JModel.model("minecraft:block/cube_all")
//                    .textures(
//                        new JTextures().var("all", "minekea:block/building/general/cobbled_end_stone")
//                    ),
//                Model.getBlockModelID(myEndStone)
//            );
//
//            MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(myEndStone), LootTable.dropSelf(Identifier.of("minecraft:end_stone")));
//        }
    }
}
