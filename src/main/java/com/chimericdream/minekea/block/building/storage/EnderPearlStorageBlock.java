package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.BlockSoundGroup;

public class EnderPearlStorageBlock extends GenericStorageBlock {
    public EnderPearlStorageBlock() {
        super(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).sounds(BlockSoundGroup.SHROOMLIGHT)).item(Items.ENDER_PEARL).material("ender_pearl"));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Ender Pearl");
    }
}
