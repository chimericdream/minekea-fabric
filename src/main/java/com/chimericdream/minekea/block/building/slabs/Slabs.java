package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab.BookshelfSlabSettings;
import com.chimericdream.minekea.block.building.slabs.GenericSlabBlock.SlabSettings;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Slabs implements MinekeaBlockCategory {
    public static final GenericSlabBlock AMETHYST_SLAB;
    public static final GenericSlabBlock BASALT_BRICK_SLAB;
    public static final GenericSlabBlock BASALT_SLAB;
    public static final GenericSlabBlock BONE_SLAB;
    public static final GenericSlabBlock CALCITE_SLAB;
    public static final GenericSlabBlock COARSE_DIRT_SLAB;
    public static final GenericSlabBlock COBBLED_END_STONE_SLAB;
    public static final GenericSlabBlock CRACKED_BASALT_BRICK_SLAB;
    public static final GenericSlabBlock CRACKED_DEEPSLATE_BRICK_SLAB;
    public static final GenericSlabBlock CRACKED_DEEPSLATE_TILE_SLAB;
    public static final GenericSlabBlock CRACKED_STONE_BRICK_SLAB;
    public static final GenericSlabBlock CRIMSON_BASALT_BRICK_SLAB;
    public static final GenericSlabBlock CRYING_OBSIDIAN_SLAB;
    public static final GenericSlabBlock DEEPSLATE_SLAB;
    public static final GenericSlabBlock DIRT_SLAB;
    public static final GenericSlabBlock END_STONE_SLAB;
    public static final GenericSlabBlock GRAVEL_SLAB;
    public static final GenericSlabBlock MOSSY_BASALT_BRICK_SLAB;
    public static final GenericSlabBlock NETHERRACK_SLAB;
    public static final GenericSlabBlock OBSIDIAN_SLAB;
    public static final GenericSlabBlock POLISHED_BASALT_SLAB;
    public static final GenericSlabBlock PURPUR_PILLAR_SLAB;
    public static final GenericSlabBlock RED_SAND_SLAB;
    public static final GenericSlabBlock ROOTED_DIRT_SLAB;
    public static final GenericSlabBlock SAND_SLAB;
    public static final GenericSlabBlock SMOOTH_BASALT_SLAB;
    public static final GenericSlabBlock TUFF_SLAB;
    public static final GenericSlabBlock WARPED_BASALT_BRICK_SLAB;
    public static final GenericSlabBlock WARPED_NETHER_BRICK_SLAB;

    public static final GenericSlabBlock WHITE_TERRACOTTA_SLAB;
    public static final GenericSlabBlock ORANGE_TERRACOTTA_SLAB;
    public static final GenericSlabBlock MAGENTA_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIGHT_BLUE_TERRACOTTA_SLAB;
    public static final GenericSlabBlock YELLOW_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIME_TERRACOTTA_SLAB;
    public static final GenericSlabBlock PINK_TERRACOTTA_SLAB;
    public static final GenericSlabBlock GRAY_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIGHT_GRAY_TERRACOTTA_SLAB;
    public static final GenericSlabBlock CYAN_TERRACOTTA_SLAB;
    public static final GenericSlabBlock PURPLE_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BLUE_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BROWN_TERRACOTTA_SLAB;
    public static final GenericSlabBlock GREEN_TERRACOTTA_SLAB;
    public static final GenericSlabBlock RED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BLACK_TERRACOTTA_SLAB;

    public static final GenericSlabBlock WHITE_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock ORANGE_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock MAGENTA_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock YELLOW_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIME_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock PINK_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock GRAY_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock CYAN_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock PURPLE_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BLUE_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BROWN_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock GREEN_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock RED_GLAZED_TERRACOTTA_SLAB;
    public static final GenericSlabBlock BLACK_GLAZED_TERRACOTTA_SLAB;

    public static final GenericSlabBlock WHITE_CONCRETE_SLAB;
    public static final GenericSlabBlock ORANGE_CONCRETE_SLAB;
    public static final GenericSlabBlock MAGENTA_CONCRETE_SLAB;
    public static final GenericSlabBlock LIGHT_BLUE_CONCRETE_SLAB;
    public static final GenericSlabBlock YELLOW_CONCRETE_SLAB;
    public static final GenericSlabBlock LIME_CONCRETE_SLAB;
    public static final GenericSlabBlock PINK_CONCRETE_SLAB;
    public static final GenericSlabBlock GRAY_CONCRETE_SLAB;
    public static final GenericSlabBlock LIGHT_GRAY_CONCRETE_SLAB;
    public static final GenericSlabBlock CYAN_CONCRETE_SLAB;
    public static final GenericSlabBlock PURPLE_CONCRETE_SLAB;
    public static final GenericSlabBlock BLUE_CONCRETE_SLAB;
    public static final GenericSlabBlock BROWN_CONCRETE_SLAB;
    public static final GenericSlabBlock GREEN_CONCRETE_SLAB;
    public static final GenericSlabBlock RED_CONCRETE_SLAB;
    public static final GenericSlabBlock BLACK_CONCRETE_SLAB;

    public static final GenericSlabBlock WHITE_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock ORANGE_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock MAGENTA_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock LIGHT_BLUE_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock YELLOW_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock LIME_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock PINK_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock GRAY_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock LIGHT_GRAY_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock CYAN_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock PURPLE_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock BLUE_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock BROWN_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock GREEN_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock RED_STAINED_GLASS_SLAB;
    public static final GenericSlabBlock BLACK_STAINED_GLASS_SLAB;

    public static final GenericSlabBlock ACACIA_LOG_SLAB;
    public static final GenericSlabBlock BIRCH_LOG_SLAB;
    public static final GenericSlabBlock CRIMSON_STEM_SLAB;
    public static final GenericSlabBlock DARK_OAK_LOG_SLAB;
    public static final GenericSlabBlock JUNGLE_LOG_SLAB;
    public static final GenericSlabBlock MANGROVE_LOG_SLAB;
    public static final GenericSlabBlock OAK_LOG_SLAB;
    public static final GenericSlabBlock SPRUCE_LOG_SLAB;
    public static final GenericSlabBlock WARPED_STEM_SLAB;

    public static final GenericBookshelfSlab ACACIA_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BIRCH_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CRIMSON_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab DARK_OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab JUNGLE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab MANGROVE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab SPRUCE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab WARPED_BOOKSHELF_SLAB;

    public static final List<GenericSlabBlock> SLABS = new ArrayList<>();
    public static final List<GenericBookshelfSlab> BOOKSHELF_SLABS = new ArrayList<>();

    static {
        AMETHYST_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.AMETHYST));
        BASALT_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BASALT_BRICK));
        BASALT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BASALT));
        BONE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BONE));
        CALCITE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CALCITE));
        COARSE_DIRT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.COARSE_DIRT));
        COBBLED_END_STONE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.COBBLED_END_STONE));
        CRACKED_BASALT_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRACKED_DEEPSLATE_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK));
        CRACKED_DEEPSLATE_TILE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE));
        CRACKED_STONE_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRACKED_STONE_BRICK));
        CRIMSON_BASALT_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        CRYING_OBSIDIAN_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRYING_OBSIDIAN));
        DEEPSLATE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.DEEPSLATE));
        DIRT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.DIRT));
        END_STONE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.END_STONE));
        GRAVEL_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GRAVEL));
        MOSSY_BASALT_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        NETHERRACK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.NETHERRACK));
        OBSIDIAN_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.OBSIDIAN));
        POLISHED_BASALT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.POLISHED_BASALT));
        PURPUR_PILLAR_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PURPUR_PILLAR));
        RED_SAND_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.RED_SAND));
        ROOTED_DIRT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ROOTED_DIRT));
        SAND_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.SAND));
        SMOOTH_BASALT_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.SMOOTH_BASALT));
        TUFF_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.TUFF));
        WARPED_BASALT_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        CRIMSON_STEM_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CRIMSON_STEM));
        WARPED_STEM_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WARPED_STEM));

        WHITE_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WHITE_TERRACOTTA));
        ORANGE_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ORANGE_TERRACOTTA));
        MAGENTA_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MAGENTA_TERRACOTTA));
        LIGHT_BLUE_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA));
        YELLOW_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.YELLOW_TERRACOTTA));
        LIME_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIME_TERRACOTTA));
        PINK_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PINK_TERRACOTTA));
        GRAY_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GRAY_TERRACOTTA));
        LIGHT_GRAY_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA));
        CYAN_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CYAN_TERRACOTTA));
        PURPLE_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PURPLE_TERRACOTTA));
        BLUE_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLUE_TERRACOTTA));
        BROWN_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BROWN_TERRACOTTA));
        GREEN_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GREEN_TERRACOTTA));
        RED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.RED_TERRACOTTA));
        BLACK_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLACK_TERRACOTTA));

        WHITE_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA));
        ORANGE_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA));
        MAGENTA_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA));
        LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA));
        YELLOW_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA));
        LIME_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA));
        PINK_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA));
        GRAY_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA));
        LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA));
        CYAN_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA));
        PURPLE_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA));
        BLUE_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA));
        BROWN_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA));
        GREEN_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA));
        RED_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA));
        BLACK_GLAZED_TERRACOTTA_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA));

        WHITE_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WHITE_CONCRETE));
        ORANGE_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ORANGE_CONCRETE));
        MAGENTA_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MAGENTA_CONCRETE));
        LIGHT_BLUE_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE));
        YELLOW_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.YELLOW_CONCRETE));
        LIME_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIME_CONCRETE));
        PINK_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PINK_CONCRETE));
        GRAY_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GRAY_CONCRETE));
        LIGHT_GRAY_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE));
        CYAN_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CYAN_CONCRETE));
        PURPLE_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PURPLE_CONCRETE));
        BLUE_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLUE_CONCRETE));
        BROWN_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BROWN_CONCRETE));
        GREEN_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GREEN_CONCRETE));
        RED_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.RED_CONCRETE));
        BLACK_CONCRETE_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLACK_CONCRETE));

        WHITE_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.WHITE_STAINED_GLASS));
        ORANGE_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ORANGE_STAINED_GLASS));
        MAGENTA_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MAGENTA_STAINED_GLASS));
        LIGHT_BLUE_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_BLUE_STAINED_GLASS));
        YELLOW_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.YELLOW_STAINED_GLASS));
        LIME_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIME_STAINED_GLASS));
        PINK_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PINK_STAINED_GLASS));
        GRAY_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GRAY_STAINED_GLASS));
        LIGHT_GRAY_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.LIGHT_GRAY_STAINED_GLASS));
        CYAN_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.CYAN_STAINED_GLASS));
        PURPLE_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.PURPLE_STAINED_GLASS));
        BLUE_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLUE_STAINED_GLASS));
        BROWN_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BROWN_STAINED_GLASS));
        GREEN_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.GREEN_STAINED_GLASS));
        RED_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.RED_STAINED_GLASS));
        BLACK_STAINED_GLASS_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BLACK_STAINED_GLASS));

        ACACIA_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.ACACIA_LOG));
        BIRCH_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.BIRCH_LOG));
        DARK_OAK_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.DARK_OAK_LOG));
        JUNGLE_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.JUNGLE_LOG));
        MANGROVE_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.MANGROVE_LOG));
        OAK_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.OAK_LOG));
        SPRUCE_LOG_SLAB = new GenericSlabBlock(new SlabSettings(BaseBlockSettings.SPRUCE_LOG));

        ACACIA_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        MANGROVE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.MANGROVE).addMaterial("bookshelf", Bookshelves.MANGROVE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_SLAB = new GenericBookshelfSlab(new BookshelfSlabSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));

        SLABS.addAll(List.of(
            AMETHYST_SLAB,
            BASALT_BRICK_SLAB,
            BASALT_SLAB,
            BONE_SLAB,
            CALCITE_SLAB,
            COARSE_DIRT_SLAB,
            COBBLED_END_STONE_SLAB,
            CRACKED_BASALT_BRICK_SLAB,
            CRACKED_DEEPSLATE_BRICK_SLAB,
            CRACKED_DEEPSLATE_TILE_SLAB,
            CRACKED_STONE_BRICK_SLAB,
            CRIMSON_BASALT_BRICK_SLAB,
            CRYING_OBSIDIAN_SLAB,
            DEEPSLATE_SLAB,
            DIRT_SLAB,
            END_STONE_SLAB,
            GRAVEL_SLAB,
            MOSSY_BASALT_BRICK_SLAB,
            NETHERRACK_SLAB,
            OBSIDIAN_SLAB,
            POLISHED_BASALT_SLAB,
            PURPUR_PILLAR_SLAB,
            RED_SAND_SLAB,
            ROOTED_DIRT_SLAB,
            SAND_SLAB,
            SMOOTH_BASALT_SLAB,
            TUFF_SLAB,
            WARPED_BASALT_BRICK_SLAB,
            WARPED_NETHER_BRICK_SLAB,

            WHITE_TERRACOTTA_SLAB,
            ORANGE_TERRACOTTA_SLAB,
            MAGENTA_TERRACOTTA_SLAB,
            LIGHT_BLUE_TERRACOTTA_SLAB,
            YELLOW_TERRACOTTA_SLAB,
            LIME_TERRACOTTA_SLAB,
            PINK_TERRACOTTA_SLAB,
            GRAY_TERRACOTTA_SLAB,
            LIGHT_GRAY_TERRACOTTA_SLAB,
            CYAN_TERRACOTTA_SLAB,
            PURPLE_TERRACOTTA_SLAB,
            BLUE_TERRACOTTA_SLAB,
            BROWN_TERRACOTTA_SLAB,
            GREEN_TERRACOTTA_SLAB,
            RED_TERRACOTTA_SLAB,
            BLACK_TERRACOTTA_SLAB,

            WHITE_GLAZED_TERRACOTTA_SLAB,
            ORANGE_GLAZED_TERRACOTTA_SLAB,
            MAGENTA_GLAZED_TERRACOTTA_SLAB,
            LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB,
            YELLOW_GLAZED_TERRACOTTA_SLAB,
            LIME_GLAZED_TERRACOTTA_SLAB,
            PINK_GLAZED_TERRACOTTA_SLAB,
            GRAY_GLAZED_TERRACOTTA_SLAB,
            LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB,
            CYAN_GLAZED_TERRACOTTA_SLAB,
            PURPLE_GLAZED_TERRACOTTA_SLAB,
            BLUE_GLAZED_TERRACOTTA_SLAB,
            BROWN_GLAZED_TERRACOTTA_SLAB,
            GREEN_GLAZED_TERRACOTTA_SLAB,
            RED_GLAZED_TERRACOTTA_SLAB,
            BLACK_GLAZED_TERRACOTTA_SLAB,

            WHITE_CONCRETE_SLAB,
            ORANGE_CONCRETE_SLAB,
            MAGENTA_CONCRETE_SLAB,
            LIGHT_BLUE_CONCRETE_SLAB,
            YELLOW_CONCRETE_SLAB,
            LIME_CONCRETE_SLAB,
            PINK_CONCRETE_SLAB,
            GRAY_CONCRETE_SLAB,
            LIGHT_GRAY_CONCRETE_SLAB,
            CYAN_CONCRETE_SLAB,
            PURPLE_CONCRETE_SLAB,
            BLUE_CONCRETE_SLAB,
            BROWN_CONCRETE_SLAB,
            GREEN_CONCRETE_SLAB,
            RED_CONCRETE_SLAB,
            BLACK_CONCRETE_SLAB,

            WHITE_STAINED_GLASS_SLAB,
            ORANGE_STAINED_GLASS_SLAB,
            MAGENTA_STAINED_GLASS_SLAB,
            LIGHT_BLUE_STAINED_GLASS_SLAB,
            YELLOW_STAINED_GLASS_SLAB,
            LIME_STAINED_GLASS_SLAB,
            PINK_STAINED_GLASS_SLAB,
            GRAY_STAINED_GLASS_SLAB,
            LIGHT_GRAY_STAINED_GLASS_SLAB,
            CYAN_STAINED_GLASS_SLAB,
            PURPLE_STAINED_GLASS_SLAB,
            BLUE_STAINED_GLASS_SLAB,
            BROWN_STAINED_GLASS_SLAB,
            GREEN_STAINED_GLASS_SLAB,
            RED_STAINED_GLASS_SLAB,
            BLACK_STAINED_GLASS_SLAB,

            ACACIA_LOG_SLAB,
            BIRCH_LOG_SLAB,
            CRIMSON_STEM_SLAB,
            DARK_OAK_LOG_SLAB,
            JUNGLE_LOG_SLAB,
            MANGROVE_LOG_SLAB,
            OAK_LOG_SLAB,
            SPRUCE_LOG_SLAB,
            WARPED_STEM_SLAB
        ));

        BOOKSHELF_SLABS.addAll(List.of(
            ACACIA_BOOKSHELF_SLAB,
            BIRCH_BOOKSHELF_SLAB,
            CRIMSON_BOOKSHELF_SLAB,
            DARK_OAK_BOOKSHELF_SLAB,
            JUNGLE_BOOKSHELF_SLAB,
            MANGROVE_BOOKSHELF_SLAB,
            OAK_BOOKSHELF_SLAB,
            SPRUCE_BOOKSHELF_SLAB,
            WARPED_BOOKSHELF_SLAB
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericSlabBlock block : SLABS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericSlabBlock block : SLABS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelfSlab block : BOOKSHELF_SLABS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
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
    }
}
