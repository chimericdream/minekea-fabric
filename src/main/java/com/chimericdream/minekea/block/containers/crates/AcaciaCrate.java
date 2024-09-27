package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class AcaciaCrate extends GenericCrate {
    public AcaciaCrate() {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        this.BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/crates/acacia");
    }

    @Override
    public void register() {
        register(true);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        this.registerRecipe(exporter, Items.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Acacia Crate");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(Blocks.STRIPPED_ACACIA_LOG).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(Blocks.ACACIA_PLANKS).withPrefixedPath("block/"));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", CRATE_MODEL, unused -> textures);
        Identifier halfModelId = blockStateModelGenerator.createSubModel(this, "_double_half", HALF_DOUBLE_CRATE_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, true)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, true)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, true)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, true)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
            );
    }
}
