package com.chimericdream.minekea.block.scales;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class ScaledBlocks implements MinekeaBlockCategory {
    public static final GenericScaledBlock SCALED_POLISHED_ANDESITE;
    public static final GenericScaledBlock SCALED_POLISHED_BLACKSTONE;
    public static final GenericScaledBlock SCALED_POLISHED_DIORITE;
    public static final GenericScaledBlock SCALED_POLISHED_GRANITE;

    public static final GenericScaledBlock SCALED_SMOOTH_STONE;
    public static final GenericScaledBlock SCALED_SMOOTH_SANDSTONE;
    public static final GenericScaledBlock SCALED_SMOOTH_RED_SANDSTONE;
    public static final GenericScaledBlock SCALED_SMOOTH_QUARTZ;

    public static final GenericScaledBlock SCALED_WHITE_TERRACOTTA;
    public static final GenericScaledBlock SCALED_ORANGE_TERRACOTTA;
    public static final GenericScaledBlock SCALED_MAGENTA_TERRACOTTA;
    public static final GenericScaledBlock SCALED_LIGHT_BLUE_TERRACOTTA;
    public static final GenericScaledBlock SCALED_YELLOW_TERRACOTTA;
    public static final GenericScaledBlock SCALED_LIME_TERRACOTTA;
    public static final GenericScaledBlock SCALED_PINK_TERRACOTTA;
    public static final GenericScaledBlock SCALED_GRAY_TERRACOTTA;
    public static final GenericScaledBlock SCALED_LIGHT_GRAY_TERRACOTTA;
    public static final GenericScaledBlock SCALED_CYAN_TERRACOTTA;
    public static final GenericScaledBlock SCALED_PURPLE_TERRACOTTA;
    public static final GenericScaledBlock SCALED_BLUE_TERRACOTTA;
    public static final GenericScaledBlock SCALED_BROWN_TERRACOTTA;
    public static final GenericScaledBlock SCALED_GREEN_TERRACOTTA;
    public static final GenericScaledBlock SCALED_RED_TERRACOTTA;
    public static final GenericScaledBlock SCALED_BLACK_TERRACOTTA;
    public static final GenericScaledBlock SCALED_TERRACOTTA;

    public static final GenericScaledBlock SCALED_WHITE_CONCRETE;
    public static final GenericScaledBlock SCALED_ORANGE_CONCRETE;
    public static final GenericScaledBlock SCALED_MAGENTA_CONCRETE;
    public static final GenericScaledBlock SCALED_LIGHT_BLUE_CONCRETE;
    public static final GenericScaledBlock SCALED_YELLOW_CONCRETE;
    public static final GenericScaledBlock SCALED_LIME_CONCRETE;
    public static final GenericScaledBlock SCALED_PINK_CONCRETE;
    public static final GenericScaledBlock SCALED_GRAY_CONCRETE;
    public static final GenericScaledBlock SCALED_LIGHT_GRAY_CONCRETE;
    public static final GenericScaledBlock SCALED_CYAN_CONCRETE;
    public static final GenericScaledBlock SCALED_PURPLE_CONCRETE;
    public static final GenericScaledBlock SCALED_BLUE_CONCRETE;
    public static final GenericScaledBlock SCALED_BROWN_CONCRETE;
    public static final GenericScaledBlock SCALED_GREEN_CONCRETE;
    public static final GenericScaledBlock SCALED_RED_CONCRETE;
    public static final GenericScaledBlock SCALED_BLACK_CONCRETE;

    public static final GenericScaledBlock SCALED_STRIPPED_ACACIA_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_BIRCH_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_CRIMSON_STEM;
    public static final GenericScaledBlock SCALED_STRIPPED_DARK_OAK_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_JUNGLE_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_OAK_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_SPRUCE_LOG;
    public static final GenericScaledBlock SCALED_STRIPPED_WARPED_STEM;


    static {
        SCALED_POLISHED_ANDESITE = new GenericScaledBlock(new Identifier("minecraft:polished_andesite"));
        SCALED_POLISHED_BLACKSTONE = new GenericScaledBlock(new Identifier("minecraft:polished_blackstone"));
        SCALED_POLISHED_DIORITE = new GenericScaledBlock(new Identifier("minecraft:polished_diorite"));
        SCALED_POLISHED_GRANITE = new GenericScaledBlock(new Identifier("minecraft:polished_granite"));
        SCALED_SMOOTH_STONE = new GenericScaledBlock(new Identifier("minecraft:smooth_stone"));
        SCALED_SMOOTH_SANDSTONE = new GenericScaledBlock(new Identifier("minecraft:smooth_sandstone")) {
            @Override
            protected Identifier getTexture() {
                return new Identifier("minecraft:sandstone_top");
            }
        };
        SCALED_SMOOTH_RED_SANDSTONE = new GenericScaledBlock(new Identifier("minecraft:smooth_red_sandstone")) {
            @Override
            protected Identifier getTexture() {
                return new Identifier("minecraft:red_sandstone_top");
            }
        };
        SCALED_SMOOTH_QUARTZ = new GenericScaledBlock(new Identifier("minecraft:smooth_quartz")) {
            @Override
            protected Identifier getTexture() {
                return new Identifier("minecraft:quartz_block_bottom");
            }
        };
        SCALED_WHITE_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:white_terracotta"));
        SCALED_ORANGE_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:orange_terracotta"));
        SCALED_MAGENTA_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:magenta_terracotta"));
        SCALED_LIGHT_BLUE_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:light_blue_terracotta"));
        SCALED_YELLOW_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:yellow_terracotta"));
        SCALED_LIME_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:lime_terracotta"));
        SCALED_PINK_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:pink_terracotta"));
        SCALED_GRAY_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:gray_terracotta"));
        SCALED_LIGHT_GRAY_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:light_gray_terracotta"));
        SCALED_CYAN_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:cyan_terracotta"));
        SCALED_PURPLE_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:purple_terracotta"));
        SCALED_BLUE_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:blue_terracotta"));
        SCALED_BROWN_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:brown_terracotta"));
        SCALED_GREEN_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:green_terracotta"));
        SCALED_RED_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:red_terracotta"));
        SCALED_BLACK_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:black_terracotta"));
        SCALED_TERRACOTTA = new GenericScaledBlock(new Identifier("minecraft:terracotta"));
        SCALED_WHITE_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:white_concrete"));
        SCALED_ORANGE_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:orange_concrete"));
        SCALED_MAGENTA_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:magenta_concrete"));
        SCALED_LIGHT_BLUE_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:light_blue_concrete"));
        SCALED_YELLOW_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:yellow_concrete"));
        SCALED_LIME_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:lime_concrete"));
        SCALED_PINK_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:pink_concrete"));
        SCALED_GRAY_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:gray_concrete"));
        SCALED_LIGHT_GRAY_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:light_gray_concrete"));
        SCALED_CYAN_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:cyan_concrete"));
        SCALED_PURPLE_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:purple_concrete"));
        SCALED_BLUE_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:blue_concrete"));
        SCALED_BROWN_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:brown_concrete"));
        SCALED_GREEN_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:green_concrete"));
        SCALED_RED_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:red_concrete"));
        SCALED_BLACK_CONCRETE = new GenericScaledBlock(new Identifier("minecraft:black_concrete"));
        SCALED_STRIPPED_ACACIA_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_acacia_log"));
        SCALED_STRIPPED_BIRCH_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_birch_log"));
        SCALED_STRIPPED_CRIMSON_STEM = new GenericScaledBlock(new Identifier("minecraft:stripped_crimson_stem"));
        SCALED_STRIPPED_DARK_OAK_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_dark_oak_log"));
        SCALED_STRIPPED_JUNGLE_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_jungle_log"));
        SCALED_STRIPPED_OAK_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_oak_log"));
        SCALED_STRIPPED_SPRUCE_LOG = new GenericScaledBlock(new Identifier("minecraft:stripped_spruce_log"));
        SCALED_STRIPPED_WARPED_STEM = new GenericScaledBlock(new Identifier("minecraft:stripped_warped_stem"));
    }

    public void register() {
        SCALED_POLISHED_ANDESITE.register();
        SCALED_POLISHED_BLACKSTONE.register();
        SCALED_POLISHED_DIORITE.register();
        SCALED_POLISHED_GRANITE.register();

        SCALED_SMOOTH_STONE.register();
        SCALED_SMOOTH_SANDSTONE.register();
        SCALED_SMOOTH_RED_SANDSTONE.register();
        SCALED_SMOOTH_QUARTZ.register();

        SCALED_WHITE_TERRACOTTA.register();
        SCALED_ORANGE_TERRACOTTA.register();
        SCALED_MAGENTA_TERRACOTTA.register();
        SCALED_LIGHT_BLUE_TERRACOTTA.register();
        SCALED_YELLOW_TERRACOTTA.register();
        SCALED_LIME_TERRACOTTA.register();
        SCALED_PINK_TERRACOTTA.register();
        SCALED_GRAY_TERRACOTTA.register();
        SCALED_LIGHT_GRAY_TERRACOTTA.register();
        SCALED_CYAN_TERRACOTTA.register();
        SCALED_PURPLE_TERRACOTTA.register();
        SCALED_BLUE_TERRACOTTA.register();
        SCALED_BROWN_TERRACOTTA.register();
        SCALED_GREEN_TERRACOTTA.register();
        SCALED_RED_TERRACOTTA.register();
        SCALED_BLACK_TERRACOTTA.register();
        SCALED_TERRACOTTA.register();

        SCALED_WHITE_CONCRETE.register();
        SCALED_ORANGE_CONCRETE.register();
        SCALED_MAGENTA_CONCRETE.register();
        SCALED_LIGHT_BLUE_CONCRETE.register();
        SCALED_YELLOW_CONCRETE.register();
        SCALED_LIME_CONCRETE.register();
        SCALED_PINK_CONCRETE.register();
        SCALED_GRAY_CONCRETE.register();
        SCALED_LIGHT_GRAY_CONCRETE.register();
        SCALED_CYAN_CONCRETE.register();
        SCALED_PURPLE_CONCRETE.register();
        SCALED_BLUE_CONCRETE.register();
        SCALED_BROWN_CONCRETE.register();
        SCALED_GREEN_CONCRETE.register();
        SCALED_RED_CONCRETE.register();
        SCALED_BLACK_CONCRETE.register();

        SCALED_STRIPPED_ACACIA_LOG.register();
        SCALED_STRIPPED_BIRCH_LOG.register();
        SCALED_STRIPPED_CRIMSON_STEM.register();
        SCALED_STRIPPED_DARK_OAK_LOG.register();
        SCALED_STRIPPED_JUNGLE_LOG.register();
        SCALED_STRIPPED_OAK_LOG.register();
        SCALED_STRIPPED_SPRUCE_LOG.register();
        SCALED_STRIPPED_WARPED_STEM.register();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            SCALED_POLISHED_ANDESITE,
            SCALED_POLISHED_BLACKSTONE,
            SCALED_POLISHED_DIORITE,
            SCALED_POLISHED_GRANITE,

            SCALED_SMOOTH_STONE,
            SCALED_SMOOTH_SANDSTONE,
            SCALED_SMOOTH_RED_SANDSTONE,
            SCALED_SMOOTH_QUARTZ,

            SCALED_WHITE_TERRACOTTA,
            SCALED_ORANGE_TERRACOTTA,
            SCALED_MAGENTA_TERRACOTTA,
            SCALED_LIGHT_BLUE_TERRACOTTA,
            SCALED_YELLOW_TERRACOTTA,
            SCALED_LIME_TERRACOTTA,
            SCALED_PINK_TERRACOTTA,
            SCALED_GRAY_TERRACOTTA,
            SCALED_LIGHT_GRAY_TERRACOTTA,
            SCALED_CYAN_TERRACOTTA,
            SCALED_PURPLE_TERRACOTTA,
            SCALED_BLUE_TERRACOTTA,
            SCALED_BROWN_TERRACOTTA,
            SCALED_GREEN_TERRACOTTA,
            SCALED_RED_TERRACOTTA,
            SCALED_BLACK_TERRACOTTA,
            SCALED_TERRACOTTA,

            SCALED_WHITE_CONCRETE,
            SCALED_ORANGE_CONCRETE,
            SCALED_MAGENTA_CONCRETE,
            SCALED_LIGHT_BLUE_CONCRETE,
            SCALED_YELLOW_CONCRETE,
            SCALED_LIME_CONCRETE,
            SCALED_PINK_CONCRETE,
            SCALED_GRAY_CONCRETE,
            SCALED_LIGHT_GRAY_CONCRETE,
            SCALED_CYAN_CONCRETE,
            SCALED_PURPLE_CONCRETE,
            SCALED_BLUE_CONCRETE,
            SCALED_BROWN_CONCRETE,
            SCALED_GREEN_CONCRETE,
            SCALED_RED_CONCRETE,
            SCALED_BLACK_CONCRETE,

            SCALED_STRIPPED_ACACIA_LOG,
            SCALED_STRIPPED_BIRCH_LOG,
            SCALED_STRIPPED_CRIMSON_STEM,
            SCALED_STRIPPED_DARK_OAK_LOG,
            SCALED_STRIPPED_JUNGLE_LOG,
            SCALED_STRIPPED_OAK_LOG,
            SCALED_STRIPPED_SPRUCE_LOG,
            SCALED_STRIPPED_WARPED_STEM
        );
    }
}
