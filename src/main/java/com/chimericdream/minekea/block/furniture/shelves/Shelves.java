package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.client.render.block.ShelfBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.ShelfBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Shelves implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static BlockEntityType<ShelfBlockEntity> SHELF_BLOCK_ENTITY;

    static {
        BLOCKS.add(new GenericShelf(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericShelf(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS)));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).flammable()));
        BLOCKS.add(new GenericFloatingShelf(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS)));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockEntityRendererFactories.register(SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void registerBlockEntities() {
        SHELF_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            ShelfBlockEntity.ENTITY_ID,
            BlockEntityType.Builder.create(
                ShelfBlockEntity::new,
                BLOCKS.toArray(new Block[0])
            ).build(null)
        );
    }
}
