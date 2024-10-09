package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Seats implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static EntityType<SimpleSeatEntity> SEAT_ENTITY;
    public static Identifier SEAT_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/mounts/seat");

    static {
        BLOCKS.add(new GenericChair(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        BLOCKS.add(new GenericChair(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericChair(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));

        BLOCKS.add(new GenericStool(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        BLOCKS.add(new GenericStool(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericStool(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void initializeClient() {
        EntityRendererRegistry.register(SEAT_ENTITY, SimpleSeatEntity.EmptyRenderer::new);
    }

    @Override
    public void registerEntities() {
        SEAT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            SEAT_ENTITY_ID,
            /*
             * @TODO: change this to `EntityType.Builder.create` and update `GenericStool` and `GenericChair` afterward.
             *        The reason this hasn't been done yet is that I apparently need to write a datafixer for
             *        the entity type.
             */
            // EntityType.Builder.create(SimpleSeatEntity::new, SpawnGroup.MISC).build(SEAT_ENTITY_ID.toString())
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SimpleSeatEntity::new).build()
        );
    }
}
