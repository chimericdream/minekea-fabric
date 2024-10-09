package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.entities.blocks.containers.MinekeaBarrelBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Barrels implements MinekeaBlockCategory {
    public static final List<Block> BARRELS = new ArrayList<>();
    public static BlockEntityType<MinekeaBarrelBlockEntity> MINEKEA_BARREL_BLOCK_ENTITY;

    static {
        BARRELS.add(new GenericBarrel(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("slab", Blocks.ACACIA_SLAB), "acacia_planks", "stripped_acacia_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("slab", Blocks.BAMBOO_SLAB), "bamboo_planks", "stripped_bamboo_block"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("slab", Blocks.BIRCH_SLAB), "birch_planks", "stripped_birch_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("slab", Blocks.CHERRY_SLAB), "cherry_planks", "stripped_cherry_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("slab", Blocks.CRIMSON_SLAB), "crimson_planks", "stripped_crimson_stem"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("slab", Blocks.DARK_OAK_SLAB), "dark_oak_planks", "stripped_dark_oak_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("slab", Blocks.JUNGLE_SLAB), "jungle_planks", "stripped_jungle_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("slab", Blocks.MANGROVE_SLAB), "mangrove_planks", "stripped_mangrove_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("slab", Blocks.SPRUCE_SLAB), "spruce_planks", "stripped_spruce_log"));
        BARRELS.add(new GenericBarrel(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("slab", Blocks.WARPED_SLAB), "warped_planks", "stripped_warped_stem"));
    }

    public List<Block> getCategoryBlocks() {
        return BARRELS;
    }

    @Override
    public void registerBlockEntities() {
        MINEKEA_BARREL_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            MinekeaBarrelBlockEntity.ENTITY_ID,
            BlockEntityType.Builder.create(
                MinekeaBarrelBlockEntity::new,
                BARRELS.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void generateTextures() {
        MinekeaBlockCategory.super.generateTextures();

        GenericBarrel.generateTextures("stripped_oak_log", "oak_planks", Registries.BLOCK.getId(Blocks.BARREL));
    }
}
