package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.CompressedBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_COUNT;
import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_LEVEL;

public class CompressedBlocks implements MinekeaBlockCategory {
    public static final ItemGroup COMPRESSED_BLOCK_GROUP = FabricItemGroupBuilder
        .create(new Identifier(ModInfo.MOD_ID, "blocks.compressed"))
        .icon(() -> new ItemStack(CompressedBlocks.COBBLESTONE.get(8)))
        .build();

    public static final List<GenericCompressedBlock> AMETHYST = new ArrayList<>();
    public static final List<GenericCompressedBlock> ANDESITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BASALT = new ArrayList<>();
    public static final List<GenericCompressedBlock> BASALT_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLACKSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CALCITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> CLAY = new ArrayList<>();
    public static final List<GenericCompressedBlock> COBBLED_DEEPSLATE = new ArrayList<>();
    public static final List<GenericCompressedBlock> COBBLED_END_STONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> COBBLESTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRACKED_BASALT_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRACKED_DEEPSLATE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRACKED_DEEPSLATE_TILE = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRACKED_STONE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRIMSON_BASALT_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRYING_OBSIDIAN = new ArrayList<>();
    public static final List<GenericCompressedBlock> CUT_RED_SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> CUT_SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> DARK_PRISMARINE = new ArrayList<>();
    public static final List<GenericCompressedBlock> DEEPSLATE = new ArrayList<>();
    public static final List<GenericCompressedBlock> DEEPSLATE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> DEEPSLATE_TILE = new ArrayList<>();
    public static final List<GenericCompressedBlock> DIORITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> DIRT = new ArrayList<>();
    public static final List<GenericCompressedBlock> END_STONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> END_STONE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRANITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRAVEL = new ArrayList<>();
    public static final List<GenericCompressedBlock> MOSSY_BASALT_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> MOSSY_COBBLESTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> MOSSY_STONE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> NETHERRACK = new ArrayList<>();
    public static final List<GenericCompressedBlock> NETHER_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> OBSIDIAN = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_ANDESITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_BASALT = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_BLACKSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_BLACKSTONE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_DEEPSLATE = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_DIORITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> POLISHED_GRANITE = new ArrayList<>();
    public static final List<GenericCompressedBlock> PRISMARINE = new ArrayList<>();
    public static final List<GenericCompressedBlock> PRISMARINE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPUR = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPUR_PILLAR = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_NETHER_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> SAND = new ArrayList<>();
    public static final List<GenericCompressedBlock> SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> SMOOTH_BASALT = new ArrayList<>();
    public static final List<GenericCompressedBlock> SMOOTH_RED_SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> SMOOTH_SANDSTONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> SMOOTH_STONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> SOUL_SAND = new ArrayList<>();
    public static final List<GenericCompressedBlock> STONE = new ArrayList<>();
    public static final List<GenericCompressedBlock> STONE_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> TUFF = new ArrayList<>();
    public static final List<GenericCompressedBlock> WARPED_BASALT_BRICK = new ArrayList<>();
    public static final List<GenericCompressedBlock> WARPED_NETHER_BRICK = new ArrayList<>();

    public static final List<GenericCompressedBlock> IRON_BLOCK = new ArrayList<>();

    public static final List<GenericCompressedBlock> WHITE_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> ORANGE_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> MAGENTA_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_BLUE_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> YELLOW_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIME_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> PINK_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRAY_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_GRAY_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> CYAN_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPLE_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLUE_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BROWN_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> GREEN_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLACK_TERRACOTTA = new ArrayList<>();

    public static final List<GenericCompressedBlock> WHITE_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> ORANGE_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> MAGENTA_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_BLUE_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> YELLOW_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIME_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> PINK_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRAY_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_GRAY_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> CYAN_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPLE_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLUE_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BROWN_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> GREEN_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_GLAZED_TERRACOTTA = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLACK_GLAZED_TERRACOTTA = new ArrayList<>();

    public static final List<GenericCompressedBlock> WHITE_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> ORANGE_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> MAGENTA_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_BLUE_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> YELLOW_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIME_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> PINK_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRAY_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_GRAY_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> CYAN_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPLE_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLUE_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BROWN_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> GREEN_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_CONCRETE = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLACK_CONCRETE = new ArrayList<>();

    public static final List<GenericCompressedBlock> WHITE_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> ORANGE_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> MAGENTA_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_BLUE_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> YELLOW_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIME_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> PINK_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> GRAY_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> LIGHT_GRAY_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> CYAN_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> PURPLE_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLUE_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> BROWN_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> GREEN_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> RED_STAINED_GLASS = new ArrayList<>();
    public static final List<GenericCompressedBlock> BLACK_STAINED_GLASS = new ArrayList<>();

    public static final List<GenericCompressedBlock> ACACIA_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> ACACIA_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> BIRCH_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> BIRCH_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRIMSON_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> CRIMSON_STEM = new ArrayList<>();
    public static final List<GenericCompressedBlock> DARK_OAK_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> DARK_OAK_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> JUNGLE_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> JUNGLE_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> OAK_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> OAK_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> SPRUCE_LOG = new ArrayList<>();
    public static final List<GenericCompressedBlock> SPRUCE_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> WARPED_PLANK = new ArrayList<>();
    public static final List<GenericCompressedBlock> WARPED_STEM = new ArrayList<>();

    public static final List<GenericCompressedBlock> BLOCKS = new ArrayList<>();

    static {
        for (int i = 1; i <= 9; i += 1) {
            AMETHYST.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.AMETHYST).compressionLevel(i)));
            ANDESITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ANDESITE).compressionLevel(i)));
            BASALT.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BASALT).compressionLevel(i)));
            BASALT_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BASALT_BRICK).compressionLevel(i)));
            BLACKSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLACKSTONE).compressionLevel(i)));
            BONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BONE).compressionLevel(i)));
            BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BRICK).compressionLevel(i)));
            CALCITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CALCITE).compressionLevel(i)));
            CLAY.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CLAY).compressionLevel(i)));
            COBBLED_DEEPSLATE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.COBBLED_DEEPSLATE).compressionLevel(i)));
            COBBLED_END_STONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.COBBLED_END_STONE).compressionLevel(i)));
            COBBLESTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.COBBLESTONE).compressionLevel(i)));
            CRACKED_BASALT_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRACKED_BASALT_BRICK).compressionLevel(i)));
            CRACKED_DEEPSLATE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK).compressionLevel(i)));
            CRACKED_DEEPSLATE_TILE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE).compressionLevel(i)));
            CRACKED_STONE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRACKED_STONE_BRICK).compressionLevel(i)));
            CRIMSON_BASALT_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK).compressionLevel(i)));
            CRYING_OBSIDIAN.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRYING_OBSIDIAN).compressionLevel(i)));
            CUT_RED_SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CUT_RED_SANDSTONE).compressionLevel(i)));
            CUT_SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CUT_SANDSTONE).compressionLevel(i)));
            DARK_PRISMARINE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DARK_PRISMARINE).compressionLevel(i)));
            DEEPSLATE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DEEPSLATE).compressionLevel(i)));
            DEEPSLATE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DEEPSLATE_BRICK).compressionLevel(i)));
            DEEPSLATE_TILE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DEEPSLATE_TILE).compressionLevel(i)));
            DIORITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DIORITE).compressionLevel(i)));
            DIRT.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DIRT).compressionLevel(i)));
            END_STONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.END_STONE).compressionLevel(i)));
            END_STONE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.END_STONE_BRICK).compressionLevel(i)));
            GRANITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRANITE).compressionLevel(i)));
            GRAVEL.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRAVEL).compressionLevel(i)));
            MOSSY_BASALT_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MOSSY_BASALT_BRICK).compressionLevel(i)));
            MOSSY_COBBLESTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MOSSY_COBBLESTONE).compressionLevel(i)));
            MOSSY_STONE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MOSSY_STONE_BRICK).compressionLevel(i)));
            NETHERRACK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.NETHERRACK).compressionLevel(i)));
            NETHER_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.NETHER_BRICK).compressionLevel(i)));
            OBSIDIAN.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.OBSIDIAN).compressionLevel(i)));
            POLISHED_ANDESITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_ANDESITE).compressionLevel(i)));
            POLISHED_BASALT.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_BASALT).compressionLevel(i)));
            POLISHED_BLACKSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_BLACKSTONE).compressionLevel(i)));
            POLISHED_BLACKSTONE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK).compressionLevel(i)));
            POLISHED_DEEPSLATE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_DEEPSLATE).compressionLevel(i)));
            POLISHED_DIORITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_DIORITE).compressionLevel(i)));
            POLISHED_GRANITE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.POLISHED_GRANITE).compressionLevel(i)));
            PRISMARINE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PRISMARINE).compressionLevel(i)));
            PRISMARINE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PRISMARINE_BRICK).compressionLevel(i)));
            PURPUR.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPUR).compressionLevel(i)));
            PURPUR_PILLAR.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPUR_PILLAR).compressionLevel(i)));
            RED_NETHER_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_NETHER_BRICK).compressionLevel(i)));
            RED_SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_SANDSTONE).compressionLevel(i)));
            SAND.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SAND).compressionLevel(i)));
            SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SANDSTONE).compressionLevel(i)));
            SMOOTH_BASALT.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SMOOTH_BASALT).compressionLevel(i)));
            SMOOTH_RED_SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SMOOTH_RED_SANDSTONE).compressionLevel(i)));
            SMOOTH_SANDSTONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SMOOTH_SANDSTONE).compressionLevel(i)));
            SMOOTH_STONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SMOOTH_STONE).compressionLevel(i)));
            SOUL_SAND.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SOUL_SAND).compressionLevel(i)));
            STONE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.STONE).compressionLevel(i)));
            STONE_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.STONE_BRICK).compressionLevel(i)));
            TUFF.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.TUFF).compressionLevel(i)));
            WARPED_BASALT_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WARPED_BASALT_BRICK).compressionLevel(i)));
            WARPED_NETHER_BRICK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WARPED_NETHER_BRICK).compressionLevel(i)));

            IRON_BLOCK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.IRON_BLOCK).compressionLevel(i)));

            WHITE_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WHITE_TERRACOTTA).compressionLevel(i)));
            ORANGE_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ORANGE_TERRACOTTA).compressionLevel(i)));
            MAGENTA_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MAGENTA_TERRACOTTA).compressionLevel(i)));
            LIGHT_BLUE_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA).compressionLevel(i)));
            YELLOW_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.YELLOW_TERRACOTTA).compressionLevel(i)));
            LIME_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIME_TERRACOTTA).compressionLevel(i)));
            PINK_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PINK_TERRACOTTA).compressionLevel(i)));
            GRAY_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRAY_TERRACOTTA).compressionLevel(i)));
            LIGHT_GRAY_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA).compressionLevel(i)));
            CYAN_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CYAN_TERRACOTTA).compressionLevel(i)));
            PURPLE_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPLE_TERRACOTTA).compressionLevel(i)));
            BLUE_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLUE_TERRACOTTA).compressionLevel(i)));
            BROWN_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BROWN_TERRACOTTA).compressionLevel(i)));
            GREEN_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GREEN_TERRACOTTA).compressionLevel(i)));
            RED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_TERRACOTTA).compressionLevel(i)));
            BLACK_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLACK_TERRACOTTA).compressionLevel(i)));

            WHITE_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA).compressionLevel(i)));
            ORANGE_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA).compressionLevel(i)));
            MAGENTA_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA).compressionLevel(i)));
            LIGHT_BLUE_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA).compressionLevel(i)));
            YELLOW_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA).compressionLevel(i)));
            LIME_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA).compressionLevel(i)));
            PINK_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA).compressionLevel(i)));
            GRAY_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA).compressionLevel(i)));
            LIGHT_GRAY_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA).compressionLevel(i)));
            CYAN_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA).compressionLevel(i)));
            PURPLE_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA).compressionLevel(i)));
            BLUE_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA).compressionLevel(i)));
            BROWN_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA).compressionLevel(i)));
            GREEN_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA).compressionLevel(i)));
            RED_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA).compressionLevel(i)));
            BLACK_GLAZED_TERRACOTTA.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA).compressionLevel(i)));

            WHITE_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WHITE_CONCRETE).compressionLevel(i)));
            ORANGE_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ORANGE_CONCRETE).compressionLevel(i)));
            MAGENTA_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MAGENTA_CONCRETE).compressionLevel(i)));
            LIGHT_BLUE_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE).compressionLevel(i)));
            YELLOW_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.YELLOW_CONCRETE).compressionLevel(i)));
            LIME_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIME_CONCRETE).compressionLevel(i)));
            PINK_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PINK_CONCRETE).compressionLevel(i)));
            GRAY_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRAY_CONCRETE).compressionLevel(i)));
            LIGHT_GRAY_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE).compressionLevel(i)));
            CYAN_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CYAN_CONCRETE).compressionLevel(i)));
            PURPLE_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPLE_CONCRETE).compressionLevel(i)));
            BLUE_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLUE_CONCRETE).compressionLevel(i)));
            BROWN_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BROWN_CONCRETE).compressionLevel(i)));
            GREEN_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GREEN_CONCRETE).compressionLevel(i)));
            RED_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_CONCRETE).compressionLevel(i)));
            BLACK_CONCRETE.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLACK_CONCRETE).compressionLevel(i)));

            WHITE_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WHITE_STAINED_GLASS).compressionLevel(i)));
            ORANGE_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ORANGE_STAINED_GLASS).compressionLevel(i)));
            MAGENTA_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.MAGENTA_STAINED_GLASS).compressionLevel(i)));
            LIGHT_BLUE_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_BLUE_STAINED_GLASS).compressionLevel(i)));
            YELLOW_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.YELLOW_STAINED_GLASS).compressionLevel(i)));
            LIME_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIME_STAINED_GLASS).compressionLevel(i)));
            PINK_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PINK_STAINED_GLASS).compressionLevel(i)));
            GRAY_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GRAY_STAINED_GLASS).compressionLevel(i)));
            LIGHT_GRAY_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.LIGHT_GRAY_STAINED_GLASS).compressionLevel(i)));
            CYAN_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CYAN_STAINED_GLASS).compressionLevel(i)));
            PURPLE_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.PURPLE_STAINED_GLASS).compressionLevel(i)));
            BLUE_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLUE_STAINED_GLASS).compressionLevel(i)));
            BROWN_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BROWN_STAINED_GLASS).compressionLevel(i)));
            GREEN_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.GREEN_STAINED_GLASS).compressionLevel(i)));
            RED_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.RED_STAINED_GLASS).compressionLevel(i)));
            BLACK_STAINED_GLASS.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BLACK_STAINED_GLASS).compressionLevel(i)));

            ACACIA_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ACACIA_LOG).compressionLevel(i)));
            ACACIA_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.ACACIA).compressionLevel(i)));
            BIRCH_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BIRCH_LOG).compressionLevel(i)));
            BIRCH_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.BIRCH).compressionLevel(i)));
            CRIMSON_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRIMSON).compressionLevel(i)));
            CRIMSON_STEM.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.CRIMSON_STEM).compressionLevel(i)));
            DARK_OAK_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DARK_OAK_LOG).compressionLevel(i)));
            DARK_OAK_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.DARK_OAK).compressionLevel(i)));
            JUNGLE_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.JUNGLE_LOG).compressionLevel(i)));
            JUNGLE_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.JUNGLE).compressionLevel(i)));
            OAK_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.OAK_LOG).compressionLevel(i)));
            OAK_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.OAK).compressionLevel(i)));
            SPRUCE_LOG.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SPRUCE_LOG).compressionLevel(i)));
            SPRUCE_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.SPRUCE).compressionLevel(i)));
            WARPED_PLANK.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WARPED).compressionLevel(i)));
            WARPED_STEM.add(new GenericCompressedBlock(new CompressedBlockSettings(BaseBlockSettings.WARPED_STEM).compressionLevel(i)));
        }

        BLOCKS.addAll(AMETHYST);
        BLOCKS.addAll(ANDESITE);
        BLOCKS.addAll(BASALT);
        BLOCKS.addAll(BASALT_BRICK);
        BLOCKS.addAll(BLACKSTONE);
        BLOCKS.addAll(BONE);
        BLOCKS.addAll(BRICK);
        BLOCKS.addAll(CALCITE);
        BLOCKS.addAll(CLAY);
        BLOCKS.addAll(COBBLED_DEEPSLATE);
        BLOCKS.addAll(COBBLED_END_STONE);
        BLOCKS.addAll(COBBLESTONE);
        BLOCKS.addAll(CRACKED_BASALT_BRICK);
        BLOCKS.addAll(CRACKED_DEEPSLATE_BRICK);
        BLOCKS.addAll(CRACKED_DEEPSLATE_TILE);
        BLOCKS.addAll(CRACKED_STONE_BRICK);
        BLOCKS.addAll(CRIMSON_BASALT_BRICK);
        BLOCKS.addAll(CRYING_OBSIDIAN);
        BLOCKS.addAll(CUT_RED_SANDSTONE);
        BLOCKS.addAll(CUT_SANDSTONE);
        BLOCKS.addAll(DARK_PRISMARINE);
        BLOCKS.addAll(DEEPSLATE);
        BLOCKS.addAll(DEEPSLATE_BRICK);
        BLOCKS.addAll(DEEPSLATE_TILE);
        BLOCKS.addAll(DIORITE);
        BLOCKS.addAll(DIRT);
        BLOCKS.addAll(END_STONE);
        BLOCKS.addAll(END_STONE_BRICK);
        BLOCKS.addAll(GRANITE);
        BLOCKS.addAll(GRAVEL);
        BLOCKS.addAll(MOSSY_BASALT_BRICK);
        BLOCKS.addAll(MOSSY_COBBLESTONE);
        BLOCKS.addAll(MOSSY_STONE_BRICK);
        BLOCKS.addAll(NETHERRACK);
        BLOCKS.addAll(NETHER_BRICK);
        BLOCKS.addAll(OBSIDIAN);
        BLOCKS.addAll(POLISHED_ANDESITE);
        BLOCKS.addAll(POLISHED_BASALT);
        BLOCKS.addAll(POLISHED_BLACKSTONE);
        BLOCKS.addAll(POLISHED_BLACKSTONE_BRICK);
        BLOCKS.addAll(POLISHED_DEEPSLATE);
        BLOCKS.addAll(POLISHED_DIORITE);
        BLOCKS.addAll(POLISHED_GRANITE);
        BLOCKS.addAll(PRISMARINE);
        BLOCKS.addAll(PRISMARINE_BRICK);
        BLOCKS.addAll(PURPUR);
        BLOCKS.addAll(PURPUR_PILLAR);
        BLOCKS.addAll(RED_NETHER_BRICK);
        BLOCKS.addAll(RED_SANDSTONE);
        BLOCKS.addAll(SAND);
        BLOCKS.addAll(SANDSTONE);
        BLOCKS.addAll(SMOOTH_BASALT);
        BLOCKS.addAll(SMOOTH_RED_SANDSTONE);
        BLOCKS.addAll(SMOOTH_SANDSTONE);
        BLOCKS.addAll(SMOOTH_STONE);
        BLOCKS.addAll(SOUL_SAND);
        BLOCKS.addAll(STONE);
        BLOCKS.addAll(STONE_BRICK);
        BLOCKS.addAll(TUFF);
        BLOCKS.addAll(WARPED_BASALT_BRICK);
        BLOCKS.addAll(WARPED_NETHER_BRICK);

        BLOCKS.addAll(IRON_BLOCK);

        BLOCKS.addAll(WHITE_TERRACOTTA);
        BLOCKS.addAll(ORANGE_TERRACOTTA);
        BLOCKS.addAll(MAGENTA_TERRACOTTA);
        BLOCKS.addAll(LIGHT_BLUE_TERRACOTTA);
        BLOCKS.addAll(YELLOW_TERRACOTTA);
        BLOCKS.addAll(LIME_TERRACOTTA);
        BLOCKS.addAll(PINK_TERRACOTTA);
        BLOCKS.addAll(GRAY_TERRACOTTA);
        BLOCKS.addAll(LIGHT_GRAY_TERRACOTTA);
        BLOCKS.addAll(CYAN_TERRACOTTA);
        BLOCKS.addAll(PURPLE_TERRACOTTA);
        BLOCKS.addAll(BLUE_TERRACOTTA);
        BLOCKS.addAll(BROWN_TERRACOTTA);
        BLOCKS.addAll(GREEN_TERRACOTTA);
        BLOCKS.addAll(RED_TERRACOTTA);
        BLOCKS.addAll(BLACK_TERRACOTTA);

        BLOCKS.addAll(WHITE_GLAZED_TERRACOTTA);
        BLOCKS.addAll(ORANGE_GLAZED_TERRACOTTA);
        BLOCKS.addAll(MAGENTA_GLAZED_TERRACOTTA);
        BLOCKS.addAll(LIGHT_BLUE_GLAZED_TERRACOTTA);
        BLOCKS.addAll(YELLOW_GLAZED_TERRACOTTA);
        BLOCKS.addAll(LIME_GLAZED_TERRACOTTA);
        BLOCKS.addAll(PINK_GLAZED_TERRACOTTA);
        BLOCKS.addAll(GRAY_GLAZED_TERRACOTTA);
        BLOCKS.addAll(LIGHT_GRAY_GLAZED_TERRACOTTA);
        BLOCKS.addAll(CYAN_GLAZED_TERRACOTTA);
        BLOCKS.addAll(PURPLE_GLAZED_TERRACOTTA);
        BLOCKS.addAll(BLUE_GLAZED_TERRACOTTA);
        BLOCKS.addAll(BROWN_GLAZED_TERRACOTTA);
        BLOCKS.addAll(GREEN_GLAZED_TERRACOTTA);
        BLOCKS.addAll(RED_GLAZED_TERRACOTTA);
        BLOCKS.addAll(BLACK_GLAZED_TERRACOTTA);

        BLOCKS.addAll(WHITE_CONCRETE);
        BLOCKS.addAll(ORANGE_CONCRETE);
        BLOCKS.addAll(MAGENTA_CONCRETE);
        BLOCKS.addAll(LIGHT_BLUE_CONCRETE);
        BLOCKS.addAll(YELLOW_CONCRETE);
        BLOCKS.addAll(LIME_CONCRETE);
        BLOCKS.addAll(PINK_CONCRETE);
        BLOCKS.addAll(GRAY_CONCRETE);
        BLOCKS.addAll(LIGHT_GRAY_CONCRETE);
        BLOCKS.addAll(CYAN_CONCRETE);
        BLOCKS.addAll(PURPLE_CONCRETE);
        BLOCKS.addAll(BLUE_CONCRETE);
        BLOCKS.addAll(BROWN_CONCRETE);
        BLOCKS.addAll(GREEN_CONCRETE);
        BLOCKS.addAll(RED_CONCRETE);
        BLOCKS.addAll(BLACK_CONCRETE);

        BLOCKS.addAll(WHITE_STAINED_GLASS);
        BLOCKS.addAll(ORANGE_STAINED_GLASS);
        BLOCKS.addAll(MAGENTA_STAINED_GLASS);
        BLOCKS.addAll(LIGHT_BLUE_STAINED_GLASS);
        BLOCKS.addAll(YELLOW_STAINED_GLASS);
        BLOCKS.addAll(LIME_STAINED_GLASS);
        BLOCKS.addAll(PINK_STAINED_GLASS);
        BLOCKS.addAll(GRAY_STAINED_GLASS);
        BLOCKS.addAll(LIGHT_GRAY_STAINED_GLASS);
        BLOCKS.addAll(CYAN_STAINED_GLASS);
        BLOCKS.addAll(PURPLE_STAINED_GLASS);
        BLOCKS.addAll(BLUE_STAINED_GLASS);
        BLOCKS.addAll(BROWN_STAINED_GLASS);
        BLOCKS.addAll(GREEN_STAINED_GLASS);
        BLOCKS.addAll(RED_STAINED_GLASS);
        BLOCKS.addAll(BLACK_STAINED_GLASS);

        BLOCKS.addAll(ACACIA_LOG);
        BLOCKS.addAll(ACACIA_PLANK);
        BLOCKS.addAll(BIRCH_LOG);
        BLOCKS.addAll(BIRCH_PLANK);
        BLOCKS.addAll(CRIMSON_PLANK);
        BLOCKS.addAll(CRIMSON_STEM);
        BLOCKS.addAll(DARK_OAK_LOG);
        BLOCKS.addAll(DARK_OAK_PLANK);
        BLOCKS.addAll(JUNGLE_LOG);
        BLOCKS.addAll(JUNGLE_PLANK);
        BLOCKS.addAll(OAK_LOG);
        BLOCKS.addAll(OAK_PLANK);
        BLOCKS.addAll(SPRUCE_LOG);
        BLOCKS.addAll(SPRUCE_PLANK);
        BLOCKS.addAll(WARPED_PLANK);
        BLOCKS.addAll(WARPED_STEM);
    }

    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), BLOCKS.toArray(new Block[0]));
    }

    @Override
    public void registerBlocks() {
        for (GenericCompressedBlock block : BLOCKS) {
            block.register();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.compressed", "Compressed Blocks");
        MinekeaResourcePack.EN_US.entry(TOOLTIP_LEVEL, "%dx Compressed");
        MinekeaResourcePack.EN_US.entry(TOOLTIP_COUNT, "(%s blocks)");
    }
}
