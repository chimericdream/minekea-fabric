package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class StickStorageBlock extends GenericStorageBlock {
    public StickStorageBlock() {
        super(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)).item(Items.STICK).material("stick"));
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.AXE_MINEABLE)
            .setReplace(false)
            .add(this);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Stick");
    }
}
