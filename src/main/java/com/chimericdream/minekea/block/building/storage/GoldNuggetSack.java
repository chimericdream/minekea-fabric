package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.MinecraftBlockTags;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class GoldNuggetSack extends GenericStorageBlock {
    public GoldNuggetSack() {
        super(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL), Items.GOLD_NUGGET, "gold_nugget", true);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinecraftBlockTags.MINEABLE_PICKAXE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Gold Nugget Sack");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.CONTENTS, Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/gold_nugget_bag"))
            .put(TextureKey.ALL, Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/gold_nugget_bag"));

        this.configureBaggedBlockModels(blockStateModelGenerator, textures);
    }
}
