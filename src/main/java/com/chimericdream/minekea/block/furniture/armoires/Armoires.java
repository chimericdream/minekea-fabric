package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
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

public class Armoires implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static BlockEntityType<ArmoireBlockEntity> ARMOIRE_BLOCK_ENTITY;

    static {
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Acacia").material("acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).ingredient("slab", Blocks.ACACIA_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Bamboo").material("bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).ingredient("slab", Blocks.BAMBOO_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Birch").material("birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).ingredient("slab", Blocks.BIRCH_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Cherry").material("cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).ingredient("slab", Blocks.CHERRY_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Crimson").material("crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM).ingredient("slab", Blocks.CRIMSON_SLAB)));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Dark Oak").material("dark_oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).ingredient("slab", Blocks.DARK_OAK_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Jungle").material("jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).ingredient("slab", Blocks.JUNGLE_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Mangrove").material("mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).ingredient("slab", Blocks.MANGROVE_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Oak").material("oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).ingredient("slab", Blocks.OAK_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Spruce").material("spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).ingredient("slab", Blocks.SPRUCE_SLAB).flammable()));
        BLOCKS.add(new GenericArmoireBlock(new BlockConfig().materialName("Warped").material("warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM).ingredient("slab", Blocks.WARPED_SLAB)));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        BlockEntityRendererFactories.register(ARMOIRE_BLOCK_ENTITY, ArmoireBlockEntityRenderer::new);
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void registerBlockEntities() {
        ARMOIRE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            ArmoireBlockEntity.ENTITY_ID,
            BlockEntityType.Builder.create(
                ArmoireBlockEntity::new,
                BLOCKS.toArray(new Block[0])
            ).build(null)
        );
    }
}
