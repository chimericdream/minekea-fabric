package com.chimericdream.minekea.data;

import com.chimericdream.minekea.crops.WarpedWartPlantBlock;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.chimericdream.minekea.block.building.BuildingBlocks.BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CHISELED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.COBBLED_END_STONE_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK;
import static com.chimericdream.minekea.crops.Crops.WARPED_WART_ITEM;
import static com.chimericdream.minekea.crops.Crops.WARPED_WART_PLANT_BLOCK;

public class MinekeaDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(MinekeaModelGenerator::new);
        pack.addProvider(MinekeaEnglishLangProvider::new);
        pack.addProvider(MinekeaBlockLootTables::new);
        pack.addProvider(MinekeaBlockTagGenerator::new);
        pack.addProvider(MinekeaRecipeGenerator::new);
    }

    private static class MinekeaRecipeGenerator extends FabricRecipeProvider {
        public MinekeaRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .input('#', Blocks.SMOOTH_BASALT)
                .criterion(FabricRecipeProvider.hasItem(Blocks.SMOOTH_BASALT),
                    FabricRecipeProvider.conditionsFromItem(Blocks.SMOOTH_BASALT))
                .offerTo(exporter);

            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, Blocks.SMOOTH_BASALT, 1);
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT, BASALT_BRICKS_BLOCK, 1);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_BRICKS_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .input('#', BASALT_BRICKS_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                    FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
                .offerTo(exporter);

            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_BRICKS_BLOCK, BASALT_BRICKS_BLOCK, 1);
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, CHISELED_BASALT_BRICKS_BLOCK, 1);
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT, CHISELED_BASALT_BRICKS_BLOCK, 1);
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_BRICKS_BLOCK, Blocks.SMOOTH_BASALT, 1);

            RecipeProvider.offerSmelting(exporter, List.of(BASALT_BRICKS_BLOCK), RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_BRICKS_BLOCK, 0.1f, 200, "minekea");
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_BRICKS_BLOCK, BASALT_BRICKS_BLOCK, 1);
            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, CRACKED_BASALT_BRICKS_BLOCK, 1);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_BASALT_BRICKS_BLOCK, 1)
                .input(BASALT_BRICKS_BLOCK)
                .input(Blocks.WEEPING_VINES)
                .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                    FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Blocks.WEEPING_VINES),
                    FabricRecipeProvider.conditionsFromItem(Blocks.WEEPING_VINES))
                .offerTo(exporter);

            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, CRIMSON_BASALT_BRICKS_BLOCK, 1);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BASALT_BRICKS_BLOCK, 1)
                .input(BASALT_BRICKS_BLOCK)
                .input(Blocks.VINE)
                .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                    FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Blocks.VINE),
                    FabricRecipeProvider.conditionsFromItem(Blocks.VINE))
                .offerTo(exporter);

            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, MOSSY_BASALT_BRICKS_BLOCK, 1);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_BASALT_BRICKS_BLOCK, 1)
                .input(BASALT_BRICKS_BLOCK)
                .input(Blocks.TWISTING_VINES)
                .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                    FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Blocks.TWISTING_VINES),
                    FabricRecipeProvider.conditionsFromItem(Blocks.TWISTING_VINES))
                .offerTo(exporter);

            RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, WARPED_BASALT_BRICKS_BLOCK, 1);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_NETHER_BRICKS_BLOCK, 1)
                .pattern("AB")
                .pattern("BA")
                .input('A', WARPED_WART_ITEM)
                .input('B', Items.NETHER_BRICK)
                .criterion(FabricRecipeProvider.hasItem(WARPED_WART_ITEM),
                    FabricRecipeProvider.conditionsFromItem(WARPED_WART_ITEM))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHER_BRICK),
                    FabricRecipeProvider.conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_WART_ITEM, 9)
                .input(Blocks.WARPED_WART_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(Blocks.WARPED_WART_BLOCK),
                    FabricRecipeProvider.conditionsFromItem(Blocks.WARPED_WART_BLOCK))
                .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_WART_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', WARPED_WART_ITEM)
                .criterion(FabricRecipeProvider.hasItem(WARPED_WART_ITEM),
                    FabricRecipeProvider.conditionsFromItem(WARPED_WART_ITEM))
                .offerTo(exporter);
        }
    }

    private static class MinekeaBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
        private static final TagKey<Block> MINEABLE_AXE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/axe"));
        private static final TagKey<Block> MINEABLE_HOE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/hoe"));
        private static final TagKey<Block> MINEABLE_PICKAXE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/pickaxe"));
        private static final TagKey<Block> MINEABLE_SHOVEL = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/shovel"));

        public MinekeaBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(MINEABLE_PICKAXE)
                .setReplace(false)
                .add(BASALT_BRICKS_BLOCK)
                .add(CHISELED_BASALT_BRICKS_BLOCK)
                .add(COBBLED_END_STONE_BLOCK)
                .add(CRACKED_BASALT_BRICKS_BLOCK)
                .add(CRIMSON_BASALT_BRICKS_BLOCK)
                .add(MOSSY_BASALT_BRICKS_BLOCK)
                .add(WARPED_BASALT_BRICKS_BLOCK)
                .add(WARPED_NETHER_BRICKS_BLOCK);
        }
    }

    private static class MinekeaBlockLootTables extends FabricBlockLootTableProvider {
        protected MinekeaBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

            addDrop(BASALT_BRICKS_BLOCK);
            addDrop(CHISELED_BASALT_BRICKS_BLOCK);
            addDrop(COBBLED_END_STONE_BLOCK);
            addDrop(CRACKED_BASALT_BRICKS_BLOCK);
            addDrop(CRIMSON_BASALT_BRICKS_BLOCK);
            addDrop(MOSSY_BASALT_BRICKS_BLOCK);
            addDrop(WARPED_BASALT_BRICKS_BLOCK);
            addDrop(WARPED_NETHER_BRICKS_BLOCK);
            addDrop(
                WARPED_WART_PLANT_BLOCK,
                (block) -> LootTable.builder()
                    .pool(
                        (LootPool.Builder) this.applyExplosionDecay(
                            block,
                            LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(
                                    ItemEntry.builder(WARPED_WART_ITEM)
                                        .apply(
                                            SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))
                                                .conditionally(
                                                    BlockStatePropertyLootCondition
                                                        .builder(block)
                                                        .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                                )
                                        )
                                        .apply(
                                            ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))
                                                .conditionally(
                                                    BlockStatePropertyLootCondition
                                                        .builder(block)
                                                        .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                                )
                                        )
                                )
                        )
                    )
            );
        }
    }

    private static class MinekeaEnglishLangProvider extends FabricLanguageProvider {
        protected MinekeaEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
            translationBuilder.add(BASALT_BRICKS_BLOCK, "Basalt Bricks");
            translationBuilder.add(CHISELED_BASALT_BRICKS_BLOCK, "Chiseled Basalt Bricks");
            translationBuilder.add(COBBLED_END_STONE_BLOCK, "Cobbled End Stone");
            translationBuilder.add(CRACKED_BASALT_BRICKS_BLOCK, "Cracked Basalt Bricks");
            translationBuilder.add(CRIMSON_BASALT_BRICKS_BLOCK, "Crimson Basalt Bricks");
            translationBuilder.add(MOSSY_BASALT_BRICKS_BLOCK, "Mossy Basalt Bricks");
            translationBuilder.add(WARPED_BASALT_BRICKS_BLOCK, "Warped Basalt Bricks");
            translationBuilder.add(WARPED_NETHER_BRICKS_BLOCK, "Warped Nether Bricks");

            translationBuilder.add(WARPED_WART_PLANT_BLOCK, "Warped Wart");
            translationBuilder.add(WARPED_WART_ITEM, "Warped Wart");
        }
    }

    private static class MinekeaModelGenerator extends FabricModelProvider {
        private MinekeaModelGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(COBBLED_END_STONE_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(CRIMSON_BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(MOSSY_BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(WARPED_BASALT_BRICKS_BLOCK);
            blockStateModelGenerator.registerSimpleCubeAll(WARPED_NETHER_BRICKS_BLOCK);

            blockStateModelGenerator.registerCrop(WARPED_WART_PLANT_BLOCK, Properties.AGE_3, 0, 1, 1, 2);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            // ...
        }
    }
}