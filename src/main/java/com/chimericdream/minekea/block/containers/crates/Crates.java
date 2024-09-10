package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Crates implements MinekeaBlockCategory {
    public static final GenericCrate ACACIA_CRATE;
    public static final GenericCrate BIRCH_CRATE;
    public static final GenericCrate CHERRY_CRATE;
    public static final GenericCrate CRIMSON_CRATE;
    public static final GenericCrate DARK_OAK_CRATE;
    public static final GenericCrate JUNGLE_CRATE;
    public static final GenericCrate MANGROVE_CRATE;
    public static final GenericCrate OAK_CRATE;
    public static final GenericCrate SPRUCE_CRATE;
    public static final GenericCrate WARPED_CRATE;

    public static final List<GenericCrate> CRATES = new ArrayList<>();

    public static BlockEntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY;
    public static ScreenHandlerType<CrateScreenHandler> CRATE_SCREEN_HANDLER;

    static {
        ACACIA_CRATE = new AcaciaCrate();
        BIRCH_CRATE = new BirchCrate();
        CHERRY_CRATE = new CherryCrate();
        CRIMSON_CRATE = new CrimsonCrate();
        DARK_OAK_CRATE = new DarkOakCrate();
        JUNGLE_CRATE = new JungleCrate();
        MANGROVE_CRATE = new MangroveCrate();
        OAK_CRATE = new OakCrate();
        SPRUCE_CRATE = new SpruceCrate();
        WARPED_CRATE = new WarpedCrate();

        CRATES.addAll(List.of(
            ACACIA_CRATE,
            BIRCH_CRATE,
            CHERRY_CRATE,
            CRIMSON_CRATE,
            DARK_OAK_CRATE,
            JUNGLE_CRATE,
            MANGROVE_CRATE,
            OAK_CRATE,
            SPRUCE_CRATE,
            WARPED_CRATE
        ));

        CRATE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            CrateScreenHandler.SCREEN_ID,
            new ScreenHandlerType<>(CrateScreenHandler::new, FeatureSet.empty())
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        HandledScreens.register(CRATE_SCREEN_HANDLER, CrateScreen::new);
    }

    @Override
    public void registerBlocks() {
        CRATES.forEach(GenericCrate::register);
    }

    @Override
    public void registerBlockEntities() {
        List<GenericCrate> crates = new ArrayList<>(CRATES);

        CRATE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            CrateBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                CrateBlockEntity::new,
                crates.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        CRATES.forEach(crate -> crate.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        CRATES.forEach(crate -> crate.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        CRATES.forEach(crate -> crate.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        CRATES.forEach(crate -> crate.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        CRATES.forEach(crate -> crate.configureTranslations(registryLookup, translationBuilder));
        translationBuilder.add("minekea:screens/container/crate", "Crate");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        CRATES.forEach(crate -> crate.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        CRATES.forEach(crate -> crate.configureItemModels(itemModelGenerator));
    }
}
