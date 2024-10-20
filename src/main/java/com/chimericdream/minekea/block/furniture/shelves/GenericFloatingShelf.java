package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GenericFloatingShelf extends GenericShelf {
    public GenericFloatingShelf(BlockConfig config) {
        super(
            config,
            Identifier.of(ModInfo.MOD_ID, String.format("furniture/shelves/floating/%s", config.getMaterial()))
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        return switch (wall) {
            case EAST -> Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0);
            case SOUTH -> Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0);
            case WEST -> Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0);
            default -> Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0);
        };
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block slabIngredient = config.getIngredient("slab");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 3)
            .pattern("XXX")
            .pattern("# #")
            .pattern("XXX")
            .input('X', slabIngredient)
            .input('#', Items.IRON_INGOT)
            .criterion(FabricRecipeProvider.hasItem(slabIngredient),
                FabricRecipeProvider.conditionsFromItem(slabIngredient))
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Floating Shelf", config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.PLANKS, TextureMap.getId(plankIngredient));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", FLOATING_SHELF_MODEL, unused -> textures);

        ModelUtils.registerBlockWithWallSide(blockStateModelGenerator, WALL_SIDE, this, subModelId);
    }
}
