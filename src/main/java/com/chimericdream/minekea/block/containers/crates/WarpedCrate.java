package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class WarpedCrate extends GenericCrate {
    public WarpedCrate() {
        super(Settings.copy(Blocks.BARREL));

        this.BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/crates/warped");
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        this.registerRecipe(exporter, Items.WARPED_PLANKS, ItemTags.WARPED_STEMS);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Warped Crate");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(Blocks.STRIPPED_WARPED_STEM).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(Blocks.WARPED_PLANKS).withPrefixedPath("block/"));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", CRATE_MODEL, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, AXIS, this, subModelId);
    }
}
