package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.Tool;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class GenericSlabBlock extends SlabBlock implements MinekeaBlock {
    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block ingredient;
    protected final Identifier textureId;
    protected final Tool miningTool;

    public GenericSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient, Tool miningTool) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient), miningTool);
    }

    public GenericSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        this(materialName, material, isFlammable, ingredient, textureId, Tool.PICKAXE);
    }

    public GenericSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId, Tool miningTool) {
        super(AbstractBlock.Settings.copy(ingredient));

        this.materialName = materialName;
        this.material = material;
        this.isFlammable = isFlammable;
        this.ingredient = ingredient;
        this.textureId = textureId;
        this.miningTool = miningTool;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/%s", material));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(this.miningTool.getMineableTag())
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Slab", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, textureId)
            .put(TextureKey.TOP, textureId)
            .put(TextureKey.ALL, textureId);

        Identifier coreModelId = blockStateModelGenerator.createSubModel(this, "", Models.SLAB, unused -> textures);
        Identifier topModelId = blockStateModelGenerator.createSubModel(this, "_top", Models.SLAB_TOP, unused -> textures);
        Identifier doubleModelId = blockStateModelGenerator.createSubModel(this, "_double", Models.CUBE_ALL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(TYPE, SlabType.BOTTOM),
                        BlockStateVariant.create().put(VariantSettings.MODEL, coreModelId)
                    )
                    .with(
                        When.create().set(TYPE, SlabType.TOP),
                        BlockStateVariant.create().put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create().set(TYPE, SlabType.DOUBLE),
                        BlockStateVariant.create().put(VariantSettings.MODEL, doubleModelId)
                    )
            );
    }
}
