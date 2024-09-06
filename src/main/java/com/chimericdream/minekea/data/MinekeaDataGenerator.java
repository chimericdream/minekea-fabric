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
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
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
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.chimericdream.minekea.block.building.BuildingBlocks.BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CHISELED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.COBBLED_END_STONE_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.building.BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.ACACIA_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.BIRCH_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.CHERRY_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.CRIMSON_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.DARK_OAK_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.JUNGLE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.MANGROVE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.OAK_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.SPRUCE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_ACACIA_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_BIRCH_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_CHERRY_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_CRIMSON_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_DARK_OAK_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_JUNGLE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_MANGROVE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_OAK_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_SPRUCE_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.STRIPPED_WARPED_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.displaycases.DisplayCases.WARPED_DISPLAY_CASE;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.BLACK_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.BLUE_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.BROWN_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.CYAN_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.GRAY_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.GREEN_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.LIGHT_BLUE_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.LIGHT_GRAY_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.LIME_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.MAGENTA_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.ORANGE_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.PINK_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.PURPLE_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.RED_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.WHITE_PILLOW;
import static com.chimericdream.minekea.block.furniture.pillows.Pillows.YELLOW_PILLOW;
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

            translationBuilder.add(WHITE_PILLOW, "White Pillow");
            translationBuilder.add(ORANGE_PILLOW, "Orange Pillow");
            translationBuilder.add(MAGENTA_PILLOW, "Magenta Pillow");
            translationBuilder.add(LIGHT_BLUE_PILLOW, "Light Blue Pillow");
            translationBuilder.add(YELLOW_PILLOW, "Yellow Pillow");
            translationBuilder.add(LIME_PILLOW, "Lime Pillow");
            translationBuilder.add(PINK_PILLOW, "Pink Pillow");
            translationBuilder.add(GRAY_PILLOW, "Gray Pillow");
            translationBuilder.add(LIGHT_GRAY_PILLOW, "Light Gray Pillow");
            translationBuilder.add(CYAN_PILLOW, "Cyan Pillow");
            translationBuilder.add(PURPLE_PILLOW, "Purple Pillow");
            translationBuilder.add(BLUE_PILLOW, "Blue Pillow");
            translationBuilder.add(BROWN_PILLOW, "Brown Pillow");
            translationBuilder.add(GREEN_PILLOW, "Green Pillow");
            translationBuilder.add(RED_PILLOW, "Red Pillow");
            translationBuilder.add(BLACK_PILLOW, "Black Pillow");


            translationBuilder.add(WARPED_WART_PLANT_BLOCK, "Warped Wart");
            translationBuilder.add(WARPED_WART_ITEM, "Warped Wart");

            translationBuilder.add("item_group.minekea.blocks.building.beams", "Minekea: Beams");
            translationBuilder.add("item_group.minekea.blocks.building.compressed", "Minekea: Compressed Blocks");
            translationBuilder.add("item_group.minekea.blocks.building.covers", "Minekea: Covers");
            translationBuilder.add("item_group.minekea.blocks.furniture", "Minekea: Furniture");

//            translationBuilder.add(TOOLTIP_LEVEL, "%dx Compressed");
//            translationBuilder.add(TOOLTIP_COUNT, "(%s blocks)");

            translationBuilder.add(ACACIA_DISPLAY_CASE, "Acacia Display Case");
            translationBuilder.add(BIRCH_DISPLAY_CASE, "Birch Display Case");
            translationBuilder.add(CHERRY_DISPLAY_CASE, "Cherry Display Case");
            translationBuilder.add(CRIMSON_DISPLAY_CASE, "Crimson Display Case");
            translationBuilder.add(DARK_OAK_DISPLAY_CASE, "Dark Oak Display Case");
            translationBuilder.add(JUNGLE_DISPLAY_CASE, "Jungle Display Case");
            translationBuilder.add(MANGROVE_DISPLAY_CASE, "Mangrove Display Case");
            translationBuilder.add(OAK_DISPLAY_CASE, "Oak Display Case");
            translationBuilder.add(SPRUCE_DISPLAY_CASE, "Spruce Display Case");
            translationBuilder.add(WARPED_DISPLAY_CASE, "Warped Display Case");
            translationBuilder.add(STRIPPED_ACACIA_DISPLAY_CASE, "Stripped Acacia Display Case");
            translationBuilder.add(STRIPPED_BIRCH_DISPLAY_CASE, "Stripped Birch Display Case");
            translationBuilder.add(STRIPPED_CHERRY_DISPLAY_CASE, "Stripped Cherry Display Case");
            translationBuilder.add(STRIPPED_CRIMSON_DISPLAY_CASE, "Stripped Crimson Display Case");
            translationBuilder.add(STRIPPED_DARK_OAK_DISPLAY_CASE, "Stripped Dark Oak Display Case");
            translationBuilder.add(STRIPPED_JUNGLE_DISPLAY_CASE, "Stripped Jungle Display Case");
            translationBuilder.add(STRIPPED_MANGROVE_DISPLAY_CASE, "Stripped Mangrove Display Case");
            translationBuilder.add(STRIPPED_OAK_DISPLAY_CASE, "Stripped Oak Display Case");
            translationBuilder.add(STRIPPED_SPRUCE_DISPLAY_CASE, "Stripped Spruce Display Case");
            translationBuilder.add(STRIPPED_WARPED_DISPLAY_CASE, "Stripped Warped Display Case");
        }
    }

    private static class MinekeaModelGenerator extends FabricModelProvider {
        private final TextureKey MATERIAL = TextureKey.of("material");
        private final TextureKey STRIPPED_MATERIAL = TextureKey.of("stripped_material");

        private final Model DISPLAY_CASE_MODEL = new Model(
            Optional.of(Identifier.of("minekea:block/furniture/display_case")),
            Optional.empty(),
            MATERIAL,
            STRIPPED_MATERIAL
        );

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

            blockStateModelGenerator.registerSimpleCubeAll(WHITE_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(ORANGE_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(MAGENTA_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(LIGHT_BLUE_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(YELLOW_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(LIME_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(PINK_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(GRAY_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(LIGHT_GRAY_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(CYAN_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(PURPLE_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(BLUE_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(BROWN_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(GREEN_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(RED_PILLOW);
            blockStateModelGenerator.registerSimpleCubeAll(BLACK_PILLOW);

            blockStateModelGenerator.registerCrop(WARPED_WART_PLANT_BLOCK, Properties.AGE_3, 0, 1, 1, 2);

            TextureMap acaciaTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.ACACIA_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_ACACIA_LOG));

            blockStateModelGenerator.registerSingleton(
                ACACIA_DISPLAY_CASE,
                acaciaTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap birchTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.BIRCH_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_BIRCH_LOG));

            blockStateModelGenerator.registerSingleton(
                BIRCH_DISPLAY_CASE,
                birchTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap cherryTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.CHERRY_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_CHERRY_LOG));

            blockStateModelGenerator.registerSingleton(
                CHERRY_DISPLAY_CASE,
                cherryTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap crimsonTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.CRIMSON_STEM))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_CRIMSON_STEM));

            blockStateModelGenerator.registerSingleton(
                CRIMSON_DISPLAY_CASE,
                crimsonTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap darkOakTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.DARK_OAK_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_DARK_OAK_LOG));

            blockStateModelGenerator.registerSingleton(
                DARK_OAK_DISPLAY_CASE,
                darkOakTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap jungleTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.JUNGLE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_JUNGLE_LOG));

            blockStateModelGenerator.registerSingleton(
                JUNGLE_DISPLAY_CASE,
                jungleTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap mangroveTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.MANGROVE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_MANGROVE_LOG));

            blockStateModelGenerator.registerSingleton(
                MANGROVE_DISPLAY_CASE,
                mangroveTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap oakTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.OAK_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_OAK_LOG));

            blockStateModelGenerator.registerSingleton(
                OAK_DISPLAY_CASE,
                oakTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap spruceTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.SPRUCE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_SPRUCE_LOG));

            blockStateModelGenerator.registerSingleton(
                SPRUCE_DISPLAY_CASE,
                spruceTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap warpedTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.WARPED_STEM))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_WARPED_STEM));

            blockStateModelGenerator.registerSingleton(
                WARPED_DISPLAY_CASE,
                warpedTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedAcaciaTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_ACACIA_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_ACACIA_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_ACACIA_DISPLAY_CASE,
                strippedAcaciaTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedBirchTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_BIRCH_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_BIRCH_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_BIRCH_DISPLAY_CASE,
                strippedBirchTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedCherryTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_CHERRY_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_CHERRY_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_CHERRY_DISPLAY_CASE,
                strippedCherryTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedCrimsonTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_CRIMSON_STEM))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_CRIMSON_STEM));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_CRIMSON_DISPLAY_CASE,
                strippedCrimsonTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedDarkOakTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_DARK_OAK_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_DARK_OAK_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_DARK_OAK_DISPLAY_CASE,
                strippedDarkOakTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedJungleTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_JUNGLE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_JUNGLE_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_JUNGLE_DISPLAY_CASE,
                strippedJungleTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedMangroveTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_MANGROVE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_MANGROVE_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_MANGROVE_DISPLAY_CASE,
                strippedMangroveTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedOakTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_OAK_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_OAK_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_OAK_DISPLAY_CASE,
                strippedOakTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedSpruceTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_SPRUCE_LOG))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_SPRUCE_LOG));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_SPRUCE_DISPLAY_CASE,
                strippedSpruceTextures,
                DISPLAY_CASE_MODEL
            );

            TextureMap strippedWarpedTextures = new TextureMap()
                .put(MATERIAL, TextureMap.getId(Blocks.STRIPPED_WARPED_STEM))
                .put(STRIPPED_MATERIAL, TextureMap.getId(Blocks.STRIPPED_WARPED_STEM));

            blockStateModelGenerator.registerSingleton(
                STRIPPED_WARPED_DISPLAY_CASE,
                strippedWarpedTextures,
                DISPLAY_CASE_MODEL
            );
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            // ...
        }
    }
}

/*
        Identifier myEndStone = Identifier.of("minekea:end_stone");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(
                    new JTextures().var("all", "minekea:block/building/general/end_stone")
                ),
            Model.getBlockModelID(myEndStone)
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.blockID(myEndStone),
            JLootTable.loot("minecraft:block")
                .pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(
                            new JEntry()
                                .type("minecraft:alternatives")
                                .child(
                                    new JEntry()
                                        .type("minecraft:item")
                                        .name("minecraft:end_stone")
                                        .condition(
                                            new JCondition()
                                                .condition("minecraft:match_tool")
                                                .parameter("predicate", LootTable.silkTouchPredicate())
                                        )
                                )
                                .child(new JEntry().type("minecraft:item").name(COBBLED_END_STONE_BLOCK.getBlockID().toString()))
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );
 */