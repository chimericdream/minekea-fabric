package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.resource.ModelUtils;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GenericFloatingShelf extends GenericShelf {
    public GenericFloatingShelf(
        String materialName,
        Block slabIngredient,
        Block plankIngredient,
        Block logIngredient
    ) {
        this(materialName, slabIngredient, plankIngredient, logIngredient, false);
    }

    public GenericFloatingShelf(
        String materialName,
        Block slabIngredient,
        Block plankIngredient,
        Block logIngredient,
        boolean isFlammable
    ) {
        super(
            materialName,
            slabIngredient,
            plankIngredient,
            logIngredient,
            isFlammable,
            makeBlockId(materialName)
        );
    }

    public static Identifier makeBlockId(String materialName) {
        String material = materialName.toLowerCase().replaceAll(" ", "_");

        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/shelves/floating/%s", material));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
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

    @Override
    public void configureRecipes(RecipeExporter exporter) {
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

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Floating Shelf", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.PLANKS, TextureMap.getId(plankIngredient));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", FLOATING_SHELF_MODEL, unused -> textures);

        ModelUtils.registerBlockWithWallSide(blockStateModelGenerator, WALL_SIDE, this, subModelId);
    }
}
