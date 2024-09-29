package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class TrappedCrate extends GenericCrate {
    protected final Block BASE_CRATE;

    public TrappedCrate(Settings settings) {
        super(settings);
        BASE_CRATE = Crates.CRATES.get(0);
    }

    public TrappedCrate(String material, String materialName, Block ingredient1, TagKey<Item> ingredient2, Block braceMaterial, boolean isFlammable, Block baseCrate) {
        super(material, materialName, ingredient1, ingredient2, braceMaterial, isFlammable);

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("containers/crates/trapped/%s", material));
        BASE_CRATE = baseCrate;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY, pos, state, true);
    }

    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return MathHelper.clamp(CrateBlockEntity.getPlayersLookingInCrateCount(world, pos), 0, 15);
    }

    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.getWeakRedstonePower(world, pos, direction);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .input(BASE_CRATE)
            .input(Items.TRIPWIRE_HOOK)
            .criterion(FabricRecipeProvider.hasItem(BASE_CRATE),
                FabricRecipeProvider.conditionsFromItem(BASE_CRATE))
            .criterion(FabricRecipeProvider.hasItem(Items.TRIPWIRE_HOOK),
                FabricRecipeProvider.conditionsFromItem(Items.TRIPWIRE_HOOK))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("Trapped %s Crate", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(braceMaterial).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, BLOCK_ID.withPrefixedPath("block/").withSuffixedPath("_material"));

        this.configureBlockStateModels(blockStateModelGenerator, textures);
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> source = instance.getImage(String.format("%s_planks", material));

            if (source.isPresent()) {
                BufferedImage sourceImage = source.get();
                BufferedImage overlayImage = instance.getMinekeaImage("block/crates/trapped_overlay").orElse(null);

                int w = sourceImage.getWidth();
                int h = sourceImage.getHeight();

                BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

                Graphics g = combined.getGraphics();
                g.drawImage(sourceImage, 0, 0, null);
                g.drawImage(overlayImage, 0, 0, w, h, null);

                g.dispose();

                instance.generate(BLOCK_ID.withSuffixedPath("_material"), combined);
            }
        });
    }
}
