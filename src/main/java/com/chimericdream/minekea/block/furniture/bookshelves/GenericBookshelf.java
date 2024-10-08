package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class GenericBookshelf extends Block implements MinekeaBlock {
    protected static final Model BOOKSHELF_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/bookshelf")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );

    public final Identifier BLOCK_ID;

    protected final Block ingredient;
    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Identifier textureId;

    public GenericBookshelf(String materialName, Block ingredient) {
        this(materialName, true, ingredient);
    }

    public GenericBookshelf(String materialName, String material, Block ingredient) {
        this(materialName, material, true, ingredient);
    }

    public GenericBookshelf(String materialName, boolean isFlammable, Block ingredient) {
        this(materialName, materialName, isFlammable, ingredient);
    }

    public GenericBookshelf(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericBookshelf(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        super(AbstractBlock.Settings.copy(ingredient));

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("furniture/bookshelves/%s", material));

        this.materialName = materialName;
        this.material = material;
        this.ingredient = ingredient;
        this.isFlammable = isFlammable;
        this.textureId = textureId;
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.ENCHANTMENT_POWER_PROVIDER).setReplace(false).add(this);
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 3)
            .pattern("###")
            .pattern("XXX")
            .pattern("###")
            .input('#', ingredient)
            .input('X', Items.BOOK)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .criterion(FabricRecipeProvider.hasItem(Items.BOOK),
                FabricRecipeProvider.conditionsFromItem(Items.BOOK))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this, generator.drops(this, Items.BOOK, ConstantLootNumberProvider.create(3)));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Bookshelf", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap().put(MinekeaTextures.MATERIAL, textureId);

        Identifier variant0Id = blockStateModelGenerator.createSubModel(this, "_v0", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0")));
        Identifier variant1Id = blockStateModelGenerator.createSubModel(this, "_v1", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf1")));
        Identifier variant2Id = blockStateModelGenerator.createSubModel(this, "_v2", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf2")));
        Identifier variant3Id = blockStateModelGenerator.createSubModel(this, "_v3", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf3")));
        Identifier variant4Id = blockStateModelGenerator.createSubModel(this, "_v4", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf4")));
        Identifier variant5Id = blockStateModelGenerator.createSubModel(this, "_v5", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf5")));
        Identifier variant6Id = blockStateModelGenerator.createSubModel(this, "_v6", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf6")));

        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(
                this,
                BlockStateVariant.create().put(VariantSettings.MODEL, variant0Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant1Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant2Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant3Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant4Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant5Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant6Id)
            )
        );

        blockStateModelGenerator.registerParentedItemModel(this, variant0Id);
    }
}
