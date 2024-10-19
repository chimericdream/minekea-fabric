package com.chimericdream.minekea.block.building.walls;

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
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
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
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class GenericWallBlock extends WallBlock implements MinekeaBlock {
    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block ingredient;
    protected final Identifier textureId;
    protected final Tool miningTool;

    public GenericWallBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericWallBlock(String materialName, String material, boolean isFlammable, Block ingredient, Tool miningTool) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient), miningTool);
    }

    public GenericWallBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        this(materialName, material, isFlammable, ingredient, textureId, Tool.PICKAXE);
    }

    public GenericWallBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId, Tool miningTool) {
        super(AbstractBlock.Settings.copy(ingredient));

        this.materialName = materialName;
        this.material = material;
        this.isFlammable = isFlammable;
        this.ingredient = ingredient;
        this.textureId = textureId;
        this.miningTool = miningTool;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/walls/%s", material));
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
        getBuilder.apply(BlockTags.WALLS)
            .setReplace(false)
            .add(this);

        getBuilder.apply(miningTool.getMineableTag())
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .pattern("###")
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
        translationBuilder.add(this, String.format("%s Wall", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.WALL, textureId);

        Identifier inventoryModelId = blockStateModelGenerator.createSubModel(this, "", Models.WALL_INVENTORY, unused -> textures);
        Identifier postModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_POST, unused -> textures);
        Identifier sideModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_SIDE, unused -> textures);
        Identifier sideTallModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_SIDE_TALL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(UP, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, postModelId)
                    )
                    .with(
                        When.create().set(NORTH_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(EAST_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(SOUTH_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(WEST_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(NORTH_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(EAST_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(SOUTH_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(WEST_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );

        blockStateModelGenerator.registerParentedItemModel(this, inventoryModelId);
    }
}
