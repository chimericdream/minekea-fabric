package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.minekea.block.furniture.armoires.GenericArmoireBlock.ArmoireSettings;
import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Armoires implements MinekeaBlockCategory {
    public static final GenericArmoireBlock ACACIA_ARMOIRE;
    public static final GenericArmoireBlock BIRCH_ARMOIRE;
    public static final GenericArmoireBlock CRIMSON_ARMOIRE;
    public static final GenericArmoireBlock DARK_OAK_ARMOIRE;
    public static final GenericArmoireBlock JUNGLE_ARMOIRE;
    public static final GenericArmoireBlock OAK_ARMOIRE;
    public static final GenericArmoireBlock SPRUCE_ARMOIRE;
    public static final GenericArmoireBlock WARPED_ARMOIRE;

    public static BlockEntityType<ArmoireBlockEntity> ARMOIRE_BLOCK_ENTITY;

    static {
        ACACIA_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.ACACIA));
        BIRCH_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.BIRCH));
        CRIMSON_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.JUNGLE));
        OAK_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.OAK));
        SPRUCE_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.SPRUCE));
        WARPED_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.WARPED));
    }

    @Override
    public void initializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(ARMOIRE_BLOCK_ENTITY, ArmoireBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        ACACIA_ARMOIRE.register();
        BIRCH_ARMOIRE.register();
        CRIMSON_ARMOIRE.register();
        DARK_OAK_ARMOIRE.register();
        JUNGLE_ARMOIRE.register();
        OAK_ARMOIRE.register();
        SPRUCE_ARMOIRE.register();
        WARPED_ARMOIRE.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericArmoireBlock> armoires = new ArrayList<>(List.of(
            ACACIA_ARMOIRE,
            BIRCH_ARMOIRE,
            CRIMSON_ARMOIRE,
            DARK_OAK_ARMOIRE,
            JUNGLE_ARMOIRE,
            OAK_ARMOIRE,
            SPRUCE_ARMOIRE,
            WARPED_ARMOIRE
        ));

        for (ModCompatLayer mod : otherMods) {
            armoires.addAll(mod.getArmoires());
        }

        ARMOIRE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            ArmoireBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                ArmoireBlockEntity::new,
                armoires.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
