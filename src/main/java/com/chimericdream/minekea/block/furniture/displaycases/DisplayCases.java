package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

import static com.chimericdream.minekea.item.ItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class DisplayCases implements MinekeaBlockCategory {
    public static final GenericDisplayCase ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase CHERRY_DISPLAY_CASE;
    public static final GenericDisplayCase CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase OAK_DISPLAY_CASE;
    public static final GenericDisplayCase SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase WARPED_DISPLAY_CASE;

    public static final GenericDisplayCase STRIPPED_ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CHERRY_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_WARPED_DISPLAY_CASE;

    public static final List<GenericDisplayCase> DISPLAY_CASES;
    public static final List<GenericDisplayCase> STRIPPED_DISPLAY_CASES;

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        ACACIA_DISPLAY_CASE = new AcaciaDisplayCase();
        BIRCH_DISPLAY_CASE = new BirchDisplayCase();
        CHERRY_DISPLAY_CASE = new CherryDisplayCase();
        CRIMSON_DISPLAY_CASE = new CrimsonDisplayCase();
        DARK_OAK_DISPLAY_CASE = new DarkOakDisplayCase();
        JUNGLE_DISPLAY_CASE = new JungleDisplayCase();
        MANGROVE_DISPLAY_CASE = new MangroveDisplayCase();
        OAK_DISPLAY_CASE = new OakDisplayCase();
        SPRUCE_DISPLAY_CASE = new SpruceDisplayCase();
        WARPED_DISPLAY_CASE = new WarpedDisplayCase();

        DISPLAY_CASES = List.of(
            ACACIA_DISPLAY_CASE,
            BIRCH_DISPLAY_CASE,
            CHERRY_DISPLAY_CASE,
            CRIMSON_DISPLAY_CASE,
            DARK_OAK_DISPLAY_CASE,
            JUNGLE_DISPLAY_CASE,
            MANGROVE_DISPLAY_CASE,
            OAK_DISPLAY_CASE,
            SPRUCE_DISPLAY_CASE,
            WARPED_DISPLAY_CASE
        );

        STRIPPED_ACACIA_DISPLAY_CASE = new StrippedAcaciaDisplayCase();
        STRIPPED_BIRCH_DISPLAY_CASE = new StrippedBirchDisplayCase();
        STRIPPED_CHERRY_DISPLAY_CASE = new StrippedCherryDisplayCase();
        STRIPPED_CRIMSON_DISPLAY_CASE = new StrippedCrimsonDisplayCase();
        STRIPPED_DARK_OAK_DISPLAY_CASE = new StrippedDarkOakDisplayCase();
        STRIPPED_JUNGLE_DISPLAY_CASE = new StrippedJungleDisplayCase();
        STRIPPED_MANGROVE_DISPLAY_CASE = new StrippedMangroveDisplayCase();
        STRIPPED_OAK_DISPLAY_CASE = new StrippedOakDisplayCase();
        STRIPPED_SPRUCE_DISPLAY_CASE = new StrippedSpruceDisplayCase();
        STRIPPED_WARPED_DISPLAY_CASE = new StrippedWarpedDisplayCase();

        STRIPPED_DISPLAY_CASES = List.of(
            STRIPPED_ACACIA_DISPLAY_CASE,
            STRIPPED_BIRCH_DISPLAY_CASE,
            STRIPPED_CHERRY_DISPLAY_CASE,
            STRIPPED_CRIMSON_DISPLAY_CASE,
            STRIPPED_DARK_OAK_DISPLAY_CASE,
            STRIPPED_JUNGLE_DISPLAY_CASE,
            STRIPPED_MANGROVE_DISPLAY_CASE,
            STRIPPED_OAK_DISPLAY_CASE,
            STRIPPED_SPRUCE_DISPLAY_CASE,
            STRIPPED_WARPED_DISPLAY_CASE
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DISPLAY_CASES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
        STRIPPED_DISPLAY_CASES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        DISPLAY_CASES.forEach(MinekeaBlock::register);
        STRIPPED_DISPLAY_CASES.forEach(MinekeaBlock::register);

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            DISPLAY_CASES.forEach(itemGroup::add);
            STRIPPED_DISPLAY_CASES.forEach(itemGroup::add);
        });
    }

    @Override
    public void registerBlockEntities() {
        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            DisplayCaseBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                DisplayCaseBlockEntity::new,
                ACACIA_DISPLAY_CASE,
                BIRCH_DISPLAY_CASE,
                CHERRY_DISPLAY_CASE,
                CRIMSON_DISPLAY_CASE,
                DARK_OAK_DISPLAY_CASE,
                JUNGLE_DISPLAY_CASE,
                MANGROVE_DISPLAY_CASE,
                OAK_DISPLAY_CASE,
                SPRUCE_DISPLAY_CASE,
                WARPED_DISPLAY_CASE,
                STRIPPED_ACACIA_DISPLAY_CASE,
                STRIPPED_BIRCH_DISPLAY_CASE,
                STRIPPED_CHERRY_DISPLAY_CASE,
                STRIPPED_CRIMSON_DISPLAY_CASE,
                STRIPPED_DARK_OAK_DISPLAY_CASE,
                STRIPPED_JUNGLE_DISPLAY_CASE,
                STRIPPED_MANGROVE_DISPLAY_CASE,
                STRIPPED_OAK_DISPLAY_CASE,
                STRIPPED_SPRUCE_DISPLAY_CASE,
                STRIPPED_WARPED_DISPLAY_CASE
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockTags(registryLookup, getBuilder));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemTags(registryLookup, getBuilder));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureRecipes(exporter));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockLootTables(registryLookup, generator));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureTranslations(registryLookup, translationBuilder));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockStateModels(blockStateModelGenerator));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemModels(itemModelGenerator));
        STRIPPED_DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemModels(itemModelGenerator));
    }
}
