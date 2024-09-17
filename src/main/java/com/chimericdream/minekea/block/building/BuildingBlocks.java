package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.ChiseledBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock BASALT_BRICKS_BLOCK;
    public static final ChiseledBasaltBricksBlock CHISELED_BASALT_BRICKS_BLOCK;
    public static final CrackedBasaltBricksBlock CRACKED_BASALT_BRICKS_BLOCK;
    public static final CrimsonBasaltBricksBlock CRIMSON_BASALT_BRICKS_BLOCK;
    public static final MossyBasaltBricksBlock MOSSY_BASALT_BRICKS_BLOCK;
    public static final WarpedBasaltBricksBlock WARPED_BASALT_BRICKS_BLOCK;
    public static final WarpedNetherBricksBlock WARPED_NETHER_BRICKS_BLOCK;

    public static Beams BEAMS;
    public static CompressedBlocks COMPRESSED_BLOCKS;
    public static DyedBlocks DYED_BLOCKS;
    public static Stairs STAIRS;
    public static final StorageBlocks STORAGE_BLOCKS;

    private static final List<MinekeaBlock> BLOCKS = new ArrayList<>();
    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();

        BLOCKS.addAll(List.of(BASALT_BRICKS_BLOCK, CHISELED_BASALT_BRICKS_BLOCK));

        BLOCKS.addAll(List.of(
            CRACKED_BASALT_BRICKS_BLOCK,
            CRIMSON_BASALT_BRICKS_BLOCK,
            MOSSY_BASALT_BRICKS_BLOCK,
            WARPED_BASALT_BRICKS_BLOCK,
            WARPED_NETHER_BRICKS_BLOCK
        ));

        BEAMS = new Beams();
        BLOCK_GROUPS.add(BEAMS);

        COMPRESSED_BLOCKS = new CompressedBlocks();
        BLOCK_GROUPS.add(COMPRESSED_BLOCKS);

        DYED_BLOCKS = new DyedBlocks();
        BLOCK_GROUPS.add(DYED_BLOCKS);

        STAIRS = new Stairs();
        BLOCK_GROUPS.add(STAIRS);

        STORAGE_BLOCKS = new StorageBlocks();
        BLOCK_GROUPS.add(STORAGE_BLOCKS);
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::initializeClient);
    }

    @Override
    public void registerBlocks() {
        BLOCKS.forEach(MinekeaBlock::register);
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerBlocks);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> {
                itemGroup.add(BASALT_BRICKS_BLOCK);
                itemGroup.add(CHISELED_BASALT_BRICKS_BLOCK);
                itemGroup.add(CRACKED_BASALT_BRICKS_BLOCK);
                itemGroup.add(CRIMSON_BASALT_BRICKS_BLOCK);
                itemGroup.add(MOSSY_BASALT_BRICKS_BLOCK);
                itemGroup.add(WARPED_BASALT_BRICKS_BLOCK);
                itemGroup.add(WARPED_NETHER_BRICKS_BLOCK);
            });
    }

    @Override
    public void registerBlockEntities() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerBlockEntities);
    }

    @Override
    public void registerEntities() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerEntities);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
        BLOCK_GROUPS.forEach(group -> group.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
        BLOCK_GROUPS.forEach(group -> group.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> block.configureRecipes(exporter));
        BLOCK_GROUPS.forEach(group -> group.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
        BLOCK_GROUPS.forEach(group -> group.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
        BLOCK_GROUPS.forEach(group -> group.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
        BLOCK_GROUPS.forEach(group -> group.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
        BLOCK_GROUPS.forEach(group -> group.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        BLOCKS.forEach(MinekeaBlock::generateTextures);
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::generateTextures);
    }
}
