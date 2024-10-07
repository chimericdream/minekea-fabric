package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.resource.ModelUtils;
import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class AppleStorageBlock extends GenericStorageBlock {
    public AppleStorageBlock() {
        super(new ModBlock.Config().settings(AbstractBlock.Settings.copy(Blocks.MELON).sounds(BlockSoundGroup.WOOD)).item(Items.APPLE).material("apple"));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.HOE_MINEABLE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Apple");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_bottom", BLOCK_ID.getPath())))
            .put(TextureKey.SIDE, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK_ID.getPath())))
            .put(TextureKey.TOP, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_top", BLOCK_ID.getPath())));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", COMPRESSED_COLUMN_BLOCK_MODEL, unused -> textures);

        ModelUtils.registerBlockWithFacing(blockStateModelGenerator, FACING, this, subModelId);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
