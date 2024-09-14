package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.function.Function;

public class GenericBarrel extends BarrelBlock implements MinekeaBlock {
    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String sideTextureKey;
    protected final String faceTextureKey;
    protected final Block plankIngredient;
    protected final Block slabIngredient;
    protected final boolean isFlammable;

    public GenericBarrel(
        String materialName,
        String sideTextureKey,
        String faceTextureKey,
        Block plankIngredient,
        Block slabIngredient
    ) {
        this(
            materialName,
            sideTextureKey,
            faceTextureKey,
            plankIngredient,
            slabIngredient,
            true
        );
    }

    public GenericBarrel(
        String materialName,
        String sideTextureKey,
        String faceTextureKey,
        Block plankIngredient,
        Block slabIngredient,
        boolean isFlammable
    ) {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        BLOCK_ID = makeBlockId(materialName);

        this.materialName = materialName;
        this.sideTextureKey = sideTextureKey;
        this.faceTextureKey = faceTextureKey;
        this.plankIngredient = plankIngredient;
        this.slabIngredient = slabIngredient;
        this.isFlammable = isFlammable;
    }

    public static Identifier makeBlockId(String materialName) {
        String material = materialName.toLowerCase().replaceAll(" ", "_");

        return Identifier.of(ModInfo.MOD_ID, String.format("containers/barrels/%s", material));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(itemGroup -> {
            itemGroup.add(this);
        });
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .pattern("PSP")
            .pattern("P P")
            .pattern("PSP")
            .input('P', plankIngredient)
            .input('S', slabIngredient)
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(slabIngredient),
                FabricRecipeProvider.conditionsFromItem(slabIngredient))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Barrel", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier bottomTexture = BLOCK_ID.withSuffixedPath("_bottom").withPrefixedPath("block/");
        Identifier sideTexture = BLOCK_ID.withSuffixedPath("_side").withPrefixedPath("block/");
        Identifier topTexture = BLOCK_ID.withSuffixedPath("_top").withPrefixedPath("block/");
        Identifier topOpenTexture = BLOCK_ID.withSuffixedPath("_top_open").withPrefixedPath("block/");

        TextureMap baseTextures = new TextureMap()
            .put(TextureKey.BOTTOM, bottomTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, topTexture);

        TextureMap openTextures = new TextureMap()
            .put(TextureKey.BOTTOM, bottomTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, topOpenTexture);

        Identifier baseModelId = blockStateModelGenerator.createSubModel(this, "", Models.CUBE_BOTTOM_TOP, unused -> baseTextures);
        Identifier openModelId = blockStateModelGenerator.createSubModel(this, "_open", Models.CUBE_BOTTOM_TOP, unused -> openTextures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(FACING, Direction.DOWN)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(FACING, Direction.UP)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId))
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                    .with(
                        When.create()
                            .set(FACING, Direction.DOWN)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(FACING, Direction.UP)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId))
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))
            );
    }

    @Override
    public void generateTextures() {
        generateTextures(faceTextureKey, sideTextureKey, BLOCK_ID);
    }

    public static void generateTextures(String faceKey, String sideKey, Identifier blockId) {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> faceTexture = instance.getImage(faceKey);
            final Optional<BufferedImage> sideTexture = instance.getImage(sideKey);

            if (faceTexture.isPresent() && sideTexture.isPresent()) {
                BufferedImage faceImage = faceTexture.get();
                BufferedImage sideImage = sideTexture.get();

                BufferedImage bandsImage = instance.getMinekeaImage("block/barrels/barrel_bands").orElse(null);
                BufferedImage bottomOverlayImage = instance.getMinekeaImage("block/barrels/barrel_bottom_overlay").orElse(null);
                BufferedImage sideOverlayImage = instance.getMinekeaImage("block/barrels/barrel_side_overlay").orElse(null);
                BufferedImage topOverlayImage = instance.getMinekeaImage("block/barrels/barrel_top_overlay").orElse(null);
                BufferedImage topOpenOverlayImage = instance.getMinekeaImage("block/barrels/barrel_top_open_overlay").orElse(null);

                int fw = faceImage.getWidth();
                int fh = faceImage.getHeight();

                int sw = sideImage.getWidth();
                int sh = sideImage.getHeight();

                BufferedImage bottomCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage sideCombined = new BufferedImage(sw, sh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage topCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage topOpenCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);

                Graphics bg = bottomCombined.getGraphics();
                bg.drawImage(faceImage, 0, 0, null);
                bg.drawImage(bottomOverlayImage, 0, 0, fw, fh, null);
                bg.dispose();

                Graphics sg = sideCombined.getGraphics();
                sg.drawImage(sideImage, 0, 0, null);
                sg.drawImage(sideOverlayImage, 0, 0, sw, sh, null);
                sg.drawImage(bandsImage, 0, 0, sw, sh, null);
                sg.dispose();

                Graphics tg = topCombined.getGraphics();
                tg.drawImage(faceImage, 0, 0, null);
                tg.drawImage(topOverlayImage, 0, 0, fw, fh, null);
                tg.dispose();

                Graphics tog = topOpenCombined.getGraphics();
                tog.drawImage(faceImage, 0, 0, null);
                tog.drawImage(topOpenOverlayImage, 0, 0, fw, fh, null);
                tog.dispose();

                instance.generate(blockId.withSuffixedPath("_bottom"), bottomCombined);
                instance.generate(blockId.withSuffixedPath("_side"), sideCombined);
                instance.generate(blockId.withSuffixedPath("_top"), topCombined);
                instance.generate(blockId.withSuffixedPath("_top_open"), topOpenCombined);
            }
        });
    }
}
