package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class DisplayCases implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("acacia").materialName("Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).ingredient("stripped_log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).ingredient("stripped_log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("birch").materialName("Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).ingredient("stripped_log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("cherry").materialName("Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).ingredient("stripped_log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("crimson").materialName("Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM).ingredient("stripped_log", Blocks.STRIPPED_CRIMSON_STEM)));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("jungle").materialName("Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).ingredient("stripped_log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).ingredient("stripped_log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("oak").materialName("Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_OAK_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("spruce").materialName("Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).ingredient("stripped_log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("warped").materialName("Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM).ingredient("stripped_log", Blocks.STRIPPED_WARPED_STEM)));

        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/acacia").materialName("Stripped Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/bamboo").materialName("Stripped Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/birch").materialName("Stripped Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/cherry").materialName("Stripped Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/crimson").materialName("Stripped Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/dark_oak").materialName("Stripped Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/jungle").materialName("Stripped Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/mangrove").materialName("Stripped Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/oak").materialName("Stripped Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/spruce").materialName("Stripped Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericDisplayCase(new BlockConfig().material("stripped/warped").materialName("Stripped Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        BlockEntityRendererFactories.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void registerBlockEntities() {
        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            DisplayCaseBlockEntity.ENTITY_ID,
            BlockEntityType.Builder.create(
                DisplayCaseBlockEntity::new,
                BLOCKS.toArray(new Block[0])
            ).build(null)
        );
    }
}
