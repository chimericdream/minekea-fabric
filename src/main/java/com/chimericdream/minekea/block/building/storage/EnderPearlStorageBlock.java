package com.chimericdream.minekea.block.building.storage;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class EnderPearlStorageBlock extends GenericStorageBlock {
    public EnderPearlStorageBlock() {
        super(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).sounds(BlockSoundGroup.SHROOMLIGHT), Items.ENDER_PEARL, "ender_pearl");
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.PICKAXE_MINEABLE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Ender Pearl");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }
}
