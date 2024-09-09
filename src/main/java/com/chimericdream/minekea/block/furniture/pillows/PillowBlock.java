package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.function.Function;

public class PillowBlock extends Block implements MinekeaBlock {
    public final Identifier BLOCK_ID;
    protected final String color;

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);

    public PillowBlock(String color) {
        super(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).mapColor(DyeColor.byName(color, DyeColor.WHITE)));

        this.color = color;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("furniture/pillows/%s", color));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_WOOL_STEP, 1.0F, 1.0F);
        if (entity.handleFallDamage(fallDistance, 0F, world.getDamageSources().fall())) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaTags.PILLOWS)
            .setReplace(false)
            .add(this);

        getBuilder.apply(MinekeaTags.MINEABLE_SHEARS)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block wool = Colors.getWool(color);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .pattern("##")
            .pattern("##")
            .input('#', wool)
            .criterion(FabricRecipeProvider.hasItem(wool),
                FabricRecipeProvider.conditionsFromItem(wool))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, wool, 4)
            .input(this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Pillow", Colors.getName(color)));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
