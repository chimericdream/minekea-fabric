package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.ModInfo;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RodBlock;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EndlessRod extends RodBlock implements BlockDataGenerator, FabricBlockDataGenerator, RegisterableBlock {
    public final static Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/lighting/endless_rod");
    public static final MapCodec<EndlessRod> CODEC = createCodec(EndlessRod::new);

    public MapCodec<EndlessRod> getCodec() {
        return CODEC;
    }

    public EndlessRod(Settings settings) {
        this();
    }

    public EndlessRod() {
        super(AbstractBlock.Settings.copy(Blocks.END_ROD));

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));

        return blockState.isOf(this) && blockState.get(FACING) == direction
            ? this.getDefaultState().with(FACING, direction.getOpposite())
            : this.getDefaultState().with(FACING, direction);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);

        double d = (double) pos.getX() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double e = (double) pos.getY() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double f = (double) pos.getZ() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double g = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;

        if (random.nextInt(5) == 0) {
            world.addParticle(
                ParticleTypes.END_ROD,
                d + (double) direction.getOffsetX() * g,
                e + (double) direction.getOffsetY() * g,
                f + (double) direction.getOffsetZ() * g,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005
            );
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
            .register(itemGroup -> itemGroup.add(this.asItem()));
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .input(Items.END_ROD)
            .criterion(FabricRecipeProvider.hasItem(Items.END_ROD),
                FabricRecipeProvider.conditionsFromItem(Items.END_ROD))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.END_ROD, 1)
            .input(this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "End(less) Rod");
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }
}
