package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
import net.minecraft.util.Identifier;

public class GenericSlabBlock extends SlabBlock implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public GenericSlabBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/%s", config.getMaterial()));
        this.config = config;
    }

    public BlockConfig getConfig() {
        return config;
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, (Block) this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem((Block) this, new Item.Settings()));

        if (config.isFlammable()) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this, generator.slabDrops(this));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Slab", config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier textureId = config.getTexture();

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
