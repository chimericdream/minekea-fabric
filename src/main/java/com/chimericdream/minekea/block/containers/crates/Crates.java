package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import com.chimericdream.minekea.screen.crate.DoubleCrateScreen;
import com.chimericdream.minekea.screen.crate.DoubleCrateScreenHandler;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Crates implements MinekeaBlockCategory {
    public static final List<GenericCrate> CRATES = new ArrayList<>();

    public static BlockEntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY;
    public static ScreenHandlerType<CrateScreenHandler> CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<DoubleCrateScreenHandler> DOUBLE_CRATE_SCREEN_HANDLER;

    static {
        CRATES.add(new GenericCrate("acacia", "Acacia", Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS, Blocks.STRIPPED_ACACIA_LOG, true));
        CRATES.add(new GenericCrate("bamboo", "Bamboo", Blocks.BAMBOO_PLANKS, ItemTags.BAMBOO_BLOCKS, Blocks.STRIPPED_BAMBOO_BLOCK, true));
        CRATES.add(new GenericCrate("birch", "Birch", Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS, Blocks.STRIPPED_BIRCH_LOG, true));
        CRATES.add(new GenericCrate("cherry", "Cherry", Blocks.CHERRY_PLANKS, ItemTags.CHERRY_LOGS, Blocks.STRIPPED_CHERRY_LOG, true));
        CRATES.add(new GenericCrate("crimson", "Crimson", Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS, Blocks.STRIPPED_CRIMSON_STEM, true));
        CRATES.add(new GenericCrate("dark_oak", "Dark Oak", Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS, Blocks.STRIPPED_DARK_OAK_LOG, true));
        CRATES.add(new GenericCrate("jungle", "Jungle", Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS, Blocks.STRIPPED_JUNGLE_LOG, true));
        CRATES.add(new GenericCrate("mangrove", "Mangrove", Blocks.MANGROVE_PLANKS, ItemTags.MANGROVE_LOGS, Blocks.STRIPPED_MANGROVE_LOG, true));
        CRATES.add(new GenericCrate("oak", "Oak", Blocks.OAK_PLANKS, ItemTags.OAK_LOGS, Blocks.STRIPPED_OAK_LOG, true));
        CRATES.add(new GenericCrate("spruce", "Spruce", Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS, Blocks.STRIPPED_SPRUCE_LOG, true));
        CRATES.add(new GenericCrate("warped", "Warped", Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS, Blocks.STRIPPED_WARPED_STEM, true));

        List<GenericCrate> trapped = new ArrayList<>();
        CRATES.forEach(crate -> {
            trapped.add(new TrappedCrate(crate.material, crate.materialName, crate.ingredient1, crate.ingredient2, crate.braceMaterial, crate.isFlammable, crate));
        });
        CRATES.addAll(trapped);

        CRATE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            CrateScreenHandler.SCREEN_ID,
            new ScreenHandlerType<>(CrateScreenHandler::new, FeatureSet.empty())
        );

        DOUBLE_CRATE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            DoubleCrateScreenHandler.SCREEN_ID,
            new ScreenHandlerType<>(DoubleCrateScreenHandler::new, FeatureSet.empty())
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        HandledScreens.register(CRATE_SCREEN_HANDLER, CrateScreen::new);
        HandledScreens.register(DOUBLE_CRATE_SCREEN_HANDLER, DoubleCrateScreen::new);
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
        translationBuilder.add("minekea:screens/container/double_crate", "Large Crate");
        translationBuilder.add("minekea:screens/container/crate/trapped", "Trapped Crate");
        translationBuilder.add("minekea:screens/container/double_crate/trapped", "Trapped Large Crate");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        CRATES.forEach(crate -> crate.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        CRATES.forEach(crate -> crate.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        CRATES.forEach(GenericCrate::generateTextures);
    }
}
