package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs.BookshelfStairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericStairsBlock.StairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs.VerticalBookshelfStairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock.VerticalStairsSettings;
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

public class Stairs implements MinekeaBlockCategory {
    public static final GenericVerticalStairsBlock ANDESITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BLACKSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock COBBLED_DEEPSLATE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock COBBLESTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRACKED_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRIMSON_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DARK_PRISMARINE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DEEPSLATE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DEEPSLATE_TILE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DIORITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock END_STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock GRANITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_COBBLESTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock NETHER_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_ANDESITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_BLACKSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_DEEPSLATE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_DIORITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_GRANITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PRISMARINE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PRISMARINE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PURPUR_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock QUARTZ_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock RED_NETHER_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock RED_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_QUARTZ_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock STONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_NETHER_BRICK_VERTICAL_STAIRS;

    public static final GenericVerticalStairsBlock CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock EXPOSED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WEATHERED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock OXIDIZED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS;

    public static final GenericVerticalStairsBlock ACACIA_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock ACACIA_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BIRCH_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BIRCH_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRIMSON_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRIMSON_STEM_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DARK_OAK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DARK_OAK_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock JUNGLE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock JUNGLE_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock OAK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock OAK_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SPRUCE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SPRUCE_LOG_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_STEM_VERTICAL_STAIRS;

    public static final GenericVerticalBookshelfStairs ACACIA_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs BIRCH_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs CRIMSON_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs DARK_OAK_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs JUNGLE_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs OAK_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs SPRUCE_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs WARPED_VERTICAL_BOOKSHELF_STAIRS;

    public static final GenericStairsBlock AMETHYST_STAIRS;
    public static final GenericStairsBlock BASALT_BRICK_STAIRS;
    public static final GenericStairsBlock BASALT_STAIRS;
    public static final GenericStairsBlock BONE_STAIRS;
    public static final GenericStairsBlock CALCITE_STAIRS;
    public static final GenericStairsBlock COBBLED_END_STONE_STAIRS;
    public static final GenericStairsBlock CRACKED_BASALT_BRICK_STAIRS;
    public static final GenericStairsBlock CRACKED_DEEPSLATE_BRICK_STAIRS;
    public static final GenericStairsBlock CRACKED_DEEPSLATE_TILE_STAIRS;
    public static final GenericStairsBlock CRACKED_STONE_BRICK_STAIRS;
    public static final GenericStairsBlock CRIMSON_BASALT_BRICK_STAIRS;
    public static final GenericStairsBlock CRYING_OBSIDIAN_STAIRS;
    public static final GenericStairsBlock CUT_RED_SANDSTONE_STAIRS;
    public static final GenericStairsBlock CUT_SANDSTONE_STAIRS;
    public static final GenericStairsBlock DEEPSLATE_STAIRS;
    public static final GenericStairsBlock END_STONE_STAIRS;
    public static final GenericStairsBlock MOSSY_BASALT_BRICK_STAIRS;
    public static final GenericStairsBlock NETHERRACK_STAIRS;
    public static final GenericStairsBlock OBSIDIAN_STAIRS;
    public static final GenericStairsBlock POLISHED_BASALT_STAIRS;
    public static final GenericStairsBlock PURPUR_PILLAR_STAIRS;
    public static final GenericStairsBlock SMOOTH_BASALT_STAIRS;
    public static final GenericStairsBlock SMOOTH_STONE_STAIRS;
    public static final GenericStairsBlock TUFF_STAIRS;
    public static final GenericStairsBlock WARPED_BASALT_BRICK_STAIRS;
    public static final GenericStairsBlock WARPED_NETHER_BRICK_STAIRS;

    public static final GenericStairsBlock WHITE_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock ORANGE_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock MAGENTA_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIGHT_BLUE_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock YELLOW_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIME_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock PINK_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock GRAY_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIGHT_GRAY_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock CYAN_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock PURPLE_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BLUE_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BROWN_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock GREEN_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock RED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BLACK_TERRACOTTA_STAIRS;

    public static final GenericStairsBlock WHITE_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock ORANGE_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock MAGENTA_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock YELLOW_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIME_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock PINK_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock GRAY_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock CYAN_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock PURPLE_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BLUE_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BROWN_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock GREEN_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock RED_GLAZED_TERRACOTTA_STAIRS;
    public static final GenericStairsBlock BLACK_GLAZED_TERRACOTTA_STAIRS;

    public static final GenericStairsBlock WHITE_CONCRETE_STAIRS;
    public static final GenericStairsBlock ORANGE_CONCRETE_STAIRS;
    public static final GenericStairsBlock MAGENTA_CONCRETE_STAIRS;
    public static final GenericStairsBlock LIGHT_BLUE_CONCRETE_STAIRS;
    public static final GenericStairsBlock YELLOW_CONCRETE_STAIRS;
    public static final GenericStairsBlock LIME_CONCRETE_STAIRS;
    public static final GenericStairsBlock PINK_CONCRETE_STAIRS;
    public static final GenericStairsBlock GRAY_CONCRETE_STAIRS;
    public static final GenericStairsBlock LIGHT_GRAY_CONCRETE_STAIRS;
    public static final GenericStairsBlock CYAN_CONCRETE_STAIRS;
    public static final GenericStairsBlock PURPLE_CONCRETE_STAIRS;
    public static final GenericStairsBlock BLUE_CONCRETE_STAIRS;
    public static final GenericStairsBlock BROWN_CONCRETE_STAIRS;
    public static final GenericStairsBlock GREEN_CONCRETE_STAIRS;
    public static final GenericStairsBlock RED_CONCRETE_STAIRS;
    public static final GenericStairsBlock BLACK_CONCRETE_STAIRS;

    public static final GenericStairsBlock WHITE_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock ORANGE_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock MAGENTA_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock LIGHT_BLUE_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock YELLOW_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock LIME_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock PINK_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock GRAY_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock LIGHT_GRAY_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock CYAN_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock PURPLE_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock BLUE_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock BROWN_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock GREEN_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock RED_STAINED_GLASS_STAIRS;
    public static final GenericStairsBlock BLACK_STAINED_GLASS_STAIRS;

    public static final GenericStairsBlock ACACIA_LOG_STAIRS;
    public static final GenericStairsBlock BIRCH_LOG_STAIRS;
    public static final GenericStairsBlock CRIMSON_STEM_STAIRS;
    public static final GenericStairsBlock DARK_OAK_LOG_STAIRS;
    public static final GenericStairsBlock JUNGLE_LOG_STAIRS;
    public static final GenericStairsBlock OAK_LOG_STAIRS;
    public static final GenericStairsBlock SPRUCE_LOG_STAIRS;
    public static final GenericStairsBlock WARPED_STEM_STAIRS;

    public static final GenericBookshelfStairs ACACIA_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs BIRCH_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs CRIMSON_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs DARK_OAK_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs JUNGLE_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs OAK_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs SPRUCE_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs WARPED_BOOKSHELF_STAIRS;

    public static final List<GenericStairsBlock> STAIRS = new ArrayList<>();
    public static final List<GenericVerticalStairsBlock> VERTICAL_STAIRS = new ArrayList<>();

    static {
        ANDESITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.ANDESITE));
        BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.BASALT_BRICK));
        BLACKSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.BLACKSTONE));
        BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.BRICK));
        COBBLED_DEEPSLATE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.COBBLED_DEEPSLATE));
        COBBLESTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.COBBLESTONE));
        CRACKED_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRIMSON_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        DARK_PRISMARINE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DARK_PRISMARINE));
        DEEPSLATE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DEEPSLATE_BRICK));
        DEEPSLATE_TILE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DEEPSLATE_TILE));
        DIORITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DIORITE));
        END_STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.END_STONE_BRICK));
        GRANITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.GRANITE));
        MOSSY_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        MOSSY_COBBLESTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.MOSSY_COBBLESTONE));
        MOSSY_STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.MOSSY_STONE_BRICK));
        NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.NETHER_BRICK));
        POLISHED_ANDESITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_ANDESITE));
        POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK));
        POLISHED_BLACKSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_BLACKSTONE));
        POLISHED_DEEPSLATE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_DEEPSLATE));
        POLISHED_DIORITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_DIORITE));
        POLISHED_GRANITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.POLISHED_GRANITE));
        PRISMARINE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.PRISMARINE_BRICK));
        PRISMARINE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.PRISMARINE));
        PURPUR_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.PURPUR));
        QUARTZ_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.QUARTZ));
        RED_NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.RED_NETHER_BRICK));
        RED_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.RED_SANDSTONE));
        SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SANDSTONE));
        SMOOTH_QUARTZ_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SMOOTH_QUARTZ));
        SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SMOOTH_RED_SANDSTONE));
        SMOOTH_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SMOOTH_SANDSTONE));
        STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.STONE_BRICK));
        STONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.STONE));
        WARPED_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.CUT_COPPER));
        EXPOSED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.EXPOSED_CUT_COPPER));
        WEATHERED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WEATHERED_CUT_COPPER));
        OXIDIZED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.OXIDIZED_CUT_COPPER));
        WAXED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WAXED_CUT_COPPER));
        WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WAXED_EXPOSED_CUT_COPPER));
        WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WAXED_WEATHERED_CUT_COPPER));
        WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WAXED_OXIDIZED_CUT_COPPER));

        ACACIA_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.ACACIA));
        ACACIA_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.ACACIA_LOG));
        BIRCH_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.BIRCH));
        BIRCH_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.BIRCH_LOG));
        CRIMSON_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.CRIMSON));
        CRIMSON_STEM_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.CRIMSON_STEM));
        DARK_OAK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DARK_OAK));
        DARK_OAK_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.DARK_OAK_LOG));
        JUNGLE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.JUNGLE));
        JUNGLE_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.JUNGLE_LOG));
        OAK_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.OAK));
        OAK_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.OAK_LOG));
        SPRUCE_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SPRUCE));
        SPRUCE_LOG_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.SPRUCE_LOG));
        WARPED_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WARPED));
        WARPED_STEM_VERTICAL_STAIRS = new GenericVerticalStairsBlock(new VerticalStairsSettings(BaseBlockSettings.WARPED_STEM));

        ACACIA_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));

        VERTICAL_STAIRS.addAll(List.of(
            ANDESITE_VERTICAL_STAIRS,
            BASALT_BRICK_VERTICAL_STAIRS,
            BLACKSTONE_VERTICAL_STAIRS,
            BRICK_VERTICAL_STAIRS,
            COBBLED_DEEPSLATE_VERTICAL_STAIRS,
            COBBLESTONE_VERTICAL_STAIRS,
            CRACKED_BASALT_BRICK_VERTICAL_STAIRS,
            CRIMSON_BASALT_BRICK_VERTICAL_STAIRS,
            DARK_PRISMARINE_VERTICAL_STAIRS,
            DEEPSLATE_BRICK_VERTICAL_STAIRS,
            DEEPSLATE_TILE_VERTICAL_STAIRS,
            DIORITE_VERTICAL_STAIRS,
            END_STONE_BRICK_VERTICAL_STAIRS,
            GRANITE_VERTICAL_STAIRS,
            MOSSY_BASALT_BRICK_VERTICAL_STAIRS,
            MOSSY_COBBLESTONE_VERTICAL_STAIRS,
            MOSSY_STONE_BRICK_VERTICAL_STAIRS,
            NETHER_BRICK_VERTICAL_STAIRS,
            POLISHED_ANDESITE_VERTICAL_STAIRS,
            POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS,
            POLISHED_BLACKSTONE_VERTICAL_STAIRS,
            POLISHED_DEEPSLATE_VERTICAL_STAIRS,
            POLISHED_DIORITE_VERTICAL_STAIRS,
            POLISHED_GRANITE_VERTICAL_STAIRS,
            PRISMARINE_BRICK_VERTICAL_STAIRS,
            PRISMARINE_VERTICAL_STAIRS,
            PURPUR_VERTICAL_STAIRS,
            QUARTZ_VERTICAL_STAIRS,
            RED_NETHER_BRICK_VERTICAL_STAIRS,
            RED_SANDSTONE_VERTICAL_STAIRS,
            SANDSTONE_VERTICAL_STAIRS,
            SMOOTH_QUARTZ_VERTICAL_STAIRS,
            SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS,
            SMOOTH_SANDSTONE_VERTICAL_STAIRS,
            STONE_BRICK_VERTICAL_STAIRS,
            STONE_VERTICAL_STAIRS,
            WARPED_BASALT_BRICK_VERTICAL_STAIRS,
            WARPED_NETHER_BRICK_VERTICAL_STAIRS,

            CUT_COPPER_VERTICAL_STAIRS,
            EXPOSED_CUT_COPPER_VERTICAL_STAIRS,
            WEATHERED_CUT_COPPER_VERTICAL_STAIRS,
            OXIDIZED_CUT_COPPER_VERTICAL_STAIRS,
            WAXED_CUT_COPPER_VERTICAL_STAIRS,
            WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS,
            WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS,
            WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS,

            ACACIA_VERTICAL_STAIRS,
            ACACIA_LOG_VERTICAL_STAIRS,
            BIRCH_VERTICAL_STAIRS,
            BIRCH_LOG_VERTICAL_STAIRS,
            CRIMSON_VERTICAL_STAIRS,
            CRIMSON_STEM_VERTICAL_STAIRS,
            DARK_OAK_VERTICAL_STAIRS,
            DARK_OAK_LOG_VERTICAL_STAIRS,
            JUNGLE_VERTICAL_STAIRS,
            JUNGLE_LOG_VERTICAL_STAIRS,
            OAK_VERTICAL_STAIRS,
            OAK_LOG_VERTICAL_STAIRS,
            SPRUCE_VERTICAL_STAIRS,
            SPRUCE_LOG_VERTICAL_STAIRS,
            WARPED_VERTICAL_STAIRS,
            WARPED_STEM_VERTICAL_STAIRS
        ));

        AMETHYST_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.AMETHYST));
        BASALT_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BASALT_BRICK));
        BASALT_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BASALT));
        BONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BONE));
        CALCITE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CALCITE));
        COBBLED_END_STONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.COBBLED_END_STONE));
        CRACKED_BASALT_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRACKED_DEEPSLATE_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK));
        CRACKED_DEEPSLATE_TILE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE));
        CRACKED_STONE_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRACKED_STONE_BRICK));
        CRIMSON_BASALT_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        CRYING_OBSIDIAN_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRYING_OBSIDIAN));
        CUT_RED_SANDSTONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CUT_RED_SANDSTONE));
        CUT_SANDSTONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CUT_SANDSTONE));
        DEEPSLATE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.DEEPSLATE));
        END_STONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.END_STONE));
        MOSSY_BASALT_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        NETHERRACK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.NETHERRACK));
        OBSIDIAN_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.OBSIDIAN));
        POLISHED_BASALT_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.POLISHED_BASALT));
        PURPUR_PILLAR_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PURPUR_PILLAR));
        SMOOTH_BASALT_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.SMOOTH_BASALT));
        SMOOTH_STONE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.SMOOTH_STONE));
        TUFF_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.TUFF));
        WARPED_BASALT_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        WHITE_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WHITE_TERRACOTTA));
        ORANGE_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.ORANGE_TERRACOTTA));
        MAGENTA_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.MAGENTA_TERRACOTTA));
        LIGHT_BLUE_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA));
        YELLOW_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.YELLOW_TERRACOTTA));
        LIME_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIME_TERRACOTTA));
        PINK_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PINK_TERRACOTTA));
        GRAY_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GRAY_TERRACOTTA));
        LIGHT_GRAY_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA));
        CYAN_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CYAN_TERRACOTTA));
        PURPLE_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PURPLE_TERRACOTTA));
        BLUE_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLUE_TERRACOTTA));
        BROWN_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BROWN_TERRACOTTA));
        GREEN_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GREEN_TERRACOTTA));
        RED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.RED_TERRACOTTA));
        BLACK_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLACK_TERRACOTTA));

        WHITE_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA));
        ORANGE_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA));
        MAGENTA_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA));
        LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA));
        YELLOW_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA));
        LIME_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA));
        PINK_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA));
        GRAY_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA));
        LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA));
        CYAN_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA));
        PURPLE_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA));
        BLUE_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA));
        BROWN_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA));
        GREEN_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA));
        RED_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA));
        BLACK_GLAZED_TERRACOTTA_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA));

        WHITE_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WHITE_CONCRETE));
        ORANGE_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.ORANGE_CONCRETE));
        MAGENTA_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.MAGENTA_CONCRETE));
        LIGHT_BLUE_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE));
        YELLOW_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.YELLOW_CONCRETE));
        LIME_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIME_CONCRETE));
        PINK_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PINK_CONCRETE));
        GRAY_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GRAY_CONCRETE));
        LIGHT_GRAY_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE));
        CYAN_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CYAN_CONCRETE));
        PURPLE_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PURPLE_CONCRETE));
        BLUE_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLUE_CONCRETE));
        BROWN_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BROWN_CONCRETE));
        GREEN_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GREEN_CONCRETE));
        RED_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.RED_CONCRETE));
        BLACK_CONCRETE_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLACK_CONCRETE));

        WHITE_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WHITE_STAINED_GLASS));
        ORANGE_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.ORANGE_STAINED_GLASS));
        MAGENTA_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.MAGENTA_STAINED_GLASS));
        LIGHT_BLUE_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_BLUE_STAINED_GLASS));
        YELLOW_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.YELLOW_STAINED_GLASS));
        LIME_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIME_STAINED_GLASS));
        PINK_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PINK_STAINED_GLASS));
        GRAY_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GRAY_STAINED_GLASS));
        LIGHT_GRAY_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.LIGHT_GRAY_STAINED_GLASS));
        CYAN_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CYAN_STAINED_GLASS));
        PURPLE_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.PURPLE_STAINED_GLASS));
        BLUE_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLUE_STAINED_GLASS));
        BROWN_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BROWN_STAINED_GLASS));
        GREEN_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.GREEN_STAINED_GLASS));
        RED_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.RED_STAINED_GLASS));
        BLACK_STAINED_GLASS_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BLACK_STAINED_GLASS));

        ACACIA_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.ACACIA_LOG));
        BIRCH_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.BIRCH_LOG));
        CRIMSON_STEM_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.CRIMSON_STEM));
        DARK_OAK_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.DARK_OAK_LOG));
        JUNGLE_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.JUNGLE_LOG));
        OAK_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.OAK_LOG));
        SPRUCE_LOG_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.SPRUCE_LOG));
        WARPED_STEM_STAIRS = new GenericStairsBlock(new StairsSettings(BaseBlockSettings.WARPED_STEM));

        ACACIA_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));

        STAIRS.addAll(List.of(
            AMETHYST_STAIRS,
            BASALT_BRICK_STAIRS,
            BASALT_STAIRS,
            BONE_STAIRS,
            CALCITE_STAIRS,
            COBBLED_END_STONE_STAIRS,
            CRACKED_BASALT_BRICK_STAIRS,
            CRACKED_DEEPSLATE_BRICK_STAIRS,
            CRACKED_DEEPSLATE_TILE_STAIRS,
            CRACKED_STONE_BRICK_STAIRS,
            CRIMSON_BASALT_BRICK_STAIRS,
            CRYING_OBSIDIAN_STAIRS,
            CUT_RED_SANDSTONE_STAIRS,
            CUT_SANDSTONE_STAIRS,
            DEEPSLATE_STAIRS,
            END_STONE_STAIRS,
            MOSSY_BASALT_BRICK_STAIRS,
            NETHERRACK_STAIRS,
            OBSIDIAN_STAIRS,
            POLISHED_BASALT_STAIRS,
            PURPUR_PILLAR_STAIRS,
            SMOOTH_BASALT_STAIRS,
            SMOOTH_STONE_STAIRS,
            TUFF_STAIRS,
            WARPED_BASALT_BRICK_STAIRS,
            WARPED_NETHER_BRICK_STAIRS,

            WHITE_TERRACOTTA_STAIRS,
            ORANGE_TERRACOTTA_STAIRS,
            MAGENTA_TERRACOTTA_STAIRS,
            LIGHT_BLUE_TERRACOTTA_STAIRS,
            YELLOW_TERRACOTTA_STAIRS,
            LIME_TERRACOTTA_STAIRS,
            PINK_TERRACOTTA_STAIRS,
            GRAY_TERRACOTTA_STAIRS,
            LIGHT_GRAY_TERRACOTTA_STAIRS,
            CYAN_TERRACOTTA_STAIRS,
            PURPLE_TERRACOTTA_STAIRS,
            BLUE_TERRACOTTA_STAIRS,
            BROWN_TERRACOTTA_STAIRS,
            GREEN_TERRACOTTA_STAIRS,
            RED_TERRACOTTA_STAIRS,
            BLACK_TERRACOTTA_STAIRS,

            WHITE_GLAZED_TERRACOTTA_STAIRS,
            ORANGE_GLAZED_TERRACOTTA_STAIRS,
            MAGENTA_GLAZED_TERRACOTTA_STAIRS,
            LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS,
            YELLOW_GLAZED_TERRACOTTA_STAIRS,
            LIME_GLAZED_TERRACOTTA_STAIRS,
            PINK_GLAZED_TERRACOTTA_STAIRS,
            GRAY_GLAZED_TERRACOTTA_STAIRS,
            LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS,
            CYAN_GLAZED_TERRACOTTA_STAIRS,
            PURPLE_GLAZED_TERRACOTTA_STAIRS,
            BLUE_GLAZED_TERRACOTTA_STAIRS,
            BROWN_GLAZED_TERRACOTTA_STAIRS,
            GREEN_GLAZED_TERRACOTTA_STAIRS,
            RED_GLAZED_TERRACOTTA_STAIRS,
            BLACK_GLAZED_TERRACOTTA_STAIRS,

            WHITE_CONCRETE_STAIRS,
            ORANGE_CONCRETE_STAIRS,
            MAGENTA_CONCRETE_STAIRS,
            LIGHT_BLUE_CONCRETE_STAIRS,
            YELLOW_CONCRETE_STAIRS,
            LIME_CONCRETE_STAIRS,
            PINK_CONCRETE_STAIRS,
            GRAY_CONCRETE_STAIRS,
            LIGHT_GRAY_CONCRETE_STAIRS,
            CYAN_CONCRETE_STAIRS,
            PURPLE_CONCRETE_STAIRS,
            BLUE_CONCRETE_STAIRS,
            BROWN_CONCRETE_STAIRS,
            GREEN_CONCRETE_STAIRS,
            RED_CONCRETE_STAIRS,
            BLACK_CONCRETE_STAIRS,

            WHITE_STAINED_GLASS_STAIRS,
            ORANGE_STAINED_GLASS_STAIRS,
            MAGENTA_STAINED_GLASS_STAIRS,
            LIGHT_BLUE_STAINED_GLASS_STAIRS,
            YELLOW_STAINED_GLASS_STAIRS,
            LIME_STAINED_GLASS_STAIRS,
            PINK_STAINED_GLASS_STAIRS,
            GRAY_STAINED_GLASS_STAIRS,
            LIGHT_GRAY_STAINED_GLASS_STAIRS,
            CYAN_STAINED_GLASS_STAIRS,
            PURPLE_STAINED_GLASS_STAIRS,
            BLUE_STAINED_GLASS_STAIRS,
            BROWN_STAINED_GLASS_STAIRS,
            GREEN_STAINED_GLASS_STAIRS,
            RED_STAINED_GLASS_STAIRS,
            BLACK_STAINED_GLASS_STAIRS,

            ACACIA_LOG_STAIRS,
            BIRCH_LOG_STAIRS,
            CRIMSON_STEM_STAIRS,
            DARK_OAK_LOG_STAIRS,
            JUNGLE_LOG_STAIRS,
            OAK_LOG_STAIRS,
            SPRUCE_LOG_STAIRS,
            WARPED_STEM_STAIRS
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericStairsBlock block : STAIRS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }

        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericStairsBlock block : STAIRS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        ACACIA_BOOKSHELF_STAIRS.register();
        BIRCH_BOOKSHELF_STAIRS.register();
        CRIMSON_BOOKSHELF_STAIRS.register();
        DARK_OAK_BOOKSHELF_STAIRS.register();
        JUNGLE_BOOKSHELF_STAIRS.register();
        OAK_BOOKSHELF_STAIRS.register();
        SPRUCE_BOOKSHELF_STAIRS.register();
        WARPED_BOOKSHELF_STAIRS.register();

        ACACIA_VERTICAL_BOOKSHELF_STAIRS.register();
        BIRCH_VERTICAL_BOOKSHELF_STAIRS.register();
        CRIMSON_VERTICAL_BOOKSHELF_STAIRS.register();
        DARK_OAK_VERTICAL_BOOKSHELF_STAIRS.register();
        JUNGLE_VERTICAL_BOOKSHELF_STAIRS.register();
        OAK_VERTICAL_BOOKSHELF_STAIRS.register();
        SPRUCE_VERTICAL_BOOKSHELF_STAIRS.register();
        WARPED_VERTICAL_BOOKSHELF_STAIRS.register();
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
