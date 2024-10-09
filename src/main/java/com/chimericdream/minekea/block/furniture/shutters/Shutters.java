package com.chimericdream.minekea.block.furniture.shutters;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Shutters implements MinekeaBlockCategory {
    public static final Map<String, Block> SHUTTERS = new LinkedHashMap<>();
    public static final Map<String, Block> OPEN_SHUTTER_HALVES = new LinkedHashMap<>();

    static {
        SHUTTERS.put("acacia", new ShutterBlock(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        SHUTTERS.put("bamboo", new ShutterBlock(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        SHUTTERS.put("birch", new ShutterBlock(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        SHUTTERS.put("cherry", new ShutterBlock(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        SHUTTERS.put("crimson", new ShutterBlock(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        SHUTTERS.put("dark_oak", new ShutterBlock(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        SHUTTERS.put("jungle", new ShutterBlock(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        SHUTTERS.put("mangrove", new ShutterBlock(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        SHUTTERS.put("oak", new ShutterBlock(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        SHUTTERS.put("spruce", new ShutterBlock(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        SHUTTERS.put("warped", new ShutterBlock(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        SHUTTERS.put("stripped_acacia", new ShutterBlock(BlockSetType.ACACIA, new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        SHUTTERS.put("stripped_bamboo", new ShutterBlock(BlockSetType.BAMBOO, new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        SHUTTERS.put("stripped_birch", new ShutterBlock(BlockSetType.BIRCH, new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        SHUTTERS.put("stripped_cherry", new ShutterBlock(BlockSetType.CHERRY, new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        SHUTTERS.put("stripped_crimson", new ShutterBlock(BlockSetType.CRIMSON, new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        SHUTTERS.put("stripped_dark_oak", new ShutterBlock(BlockSetType.DARK_OAK, new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        SHUTTERS.put("stripped_jungle", new ShutterBlock(BlockSetType.JUNGLE, new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        SHUTTERS.put("stripped_mangrove", new ShutterBlock(BlockSetType.MANGROVE, new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        SHUTTERS.put("stripped_oak", new ShutterBlock(BlockSetType.OAK, new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        SHUTTERS.put("stripped_spruce", new ShutterBlock(BlockSetType.SPRUCE, new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        SHUTTERS.put("stripped_warped", new ShutterBlock(BlockSetType.WARPED, new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));

        OPEN_SHUTTER_HALVES.put("acacia", new OpenShutterHalf(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("bamboo", new OpenShutterHalf(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        OPEN_SHUTTER_HALVES.put("birch", new OpenShutterHalf(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("cherry", new OpenShutterHalf(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("crimson", new OpenShutterHalf(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        OPEN_SHUTTER_HALVES.put("dark_oak", new OpenShutterHalf(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("jungle", new OpenShutterHalf(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("mangrove", new OpenShutterHalf(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("oak", new OpenShutterHalf(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("spruce", new OpenShutterHalf(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("warped", new OpenShutterHalf(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        OPEN_SHUTTER_HALVES.put("stripped_acacia", new OpenShutterHalf(BlockSetType.ACACIA, new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_bamboo", new OpenShutterHalf(BlockSetType.BAMBOO, new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_birch", new OpenShutterHalf(BlockSetType.BIRCH, new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_cherry", new OpenShutterHalf(BlockSetType.CHERRY, new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_crimson", new OpenShutterHalf(BlockSetType.CRIMSON, new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        OPEN_SHUTTER_HALVES.put("stripped_dark_oak", new OpenShutterHalf(BlockSetType.DARK_OAK, new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_jungle", new OpenShutterHalf(BlockSetType.JUNGLE, new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_mangrove", new OpenShutterHalf(BlockSetType.MANGROVE, new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_oak", new OpenShutterHalf(BlockSetType.OAK, new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_spruce", new OpenShutterHalf(BlockSetType.SPRUCE, new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_warped", new OpenShutterHalf(BlockSetType.WARPED, new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
    }

    public List<Block> getCategoryBlocks() {
        List<Block> blocks = new ArrayList<>();

        blocks.addAll(SHUTTERS.values());
        blocks.addAll(OPEN_SHUTTER_HALVES.values());

        return blocks;
    }
}
