package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.tag.MinecraftBlockTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class WheatSeedsStorageBlock extends GenericStorageBlock {
    public WheatSeedsStorageBlock() {
        super(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP), Items.WHEAT_SEEDS, "wheat_seeds", true);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinecraftBlockTags.MINEABLE_HOE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Wheat Seeds");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.configureBaggedBlockModels(blockStateModelGenerator);
    }
}
