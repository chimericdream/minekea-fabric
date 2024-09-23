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

public class SpruceCrate extends GenericCrate {
    public SpruceCrate() {
        super(Settings.copy(Blocks.BARREL));

        this.BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/crates/spruce");
    }

    @Override
    public void register() {
        register(true);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        this.registerRecipe(exporter, Items.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Spruce Crate");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(Blocks.STRIPPED_SPRUCE_LOG).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(Blocks.SPRUCE_PLANKS).withPrefixedPath("block/"));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", CRATE_MODEL, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, AXIS, this, subModelId);
    }
}
