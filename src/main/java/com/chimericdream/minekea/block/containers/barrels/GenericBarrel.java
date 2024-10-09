package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.entities.blocks.containers.MinekeaBarrelBlockEntity;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.function.Function;

public class GenericBarrel extends BlockWithEntity implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    public static final MapCodec<GenericBarrel> CODEC = createCodec(GenericBarrel::new);

    public final Identifier BLOCK_ID;
    public final BlockConfig config;
    public final String sideTextureKey;
    public final String faceTextureKey;

    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    static {
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }

    public GenericBarrel(Settings settings) {
        this(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("slab", Blocks.ACACIA_SLAB), "acacia_planks", "stripped_acacia_log");
    }

    @Override
    protected MapCodec<GenericBarrel> getCodec() {
        return CODEC;
    }

    public GenericBarrel(BlockConfig config, String sideTextureKey, String faceTextureKey) {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("containers/barrels/%s", config.getMaterial()));
        this.config = config;
        this.sideTextureKey = sideTextureKey;
        this.faceTextureKey = faceTextureKey;

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, false));
    }

    public BlockConfig getConfig() {
        return config;
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MinekeaBarrelBlockEntity) {
                player.openHandledScreen((MinekeaBarrelBlockEntity) blockEntity);
                player.incrementStat(Stats.OPEN_BARREL);
                PiglinBrain.onGuardedBlockInteracted(player, true);
            }

            return ActionResult.CONSUME;
        }
    }

    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MinekeaBarrelBlockEntity) {
            ((MinekeaBarrelBlockEntity) blockEntity).tick();
        }

    }

    @Override
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MinekeaBarrelBlockEntity(pos, state);
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (config.isFlammable()) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(itemGroup -> {
            itemGroup.add(this);
        });
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(this);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block plankIngredient = config.getIngredient();
        Block slabIngredient = config.getIngredient("slab");

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

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Barrel", config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier bottomTexture = TextureUtils.block(BLOCK_ID, "_bottom");
        Identifier sideTexture = TextureUtils.block(BLOCK_ID, "_side");
        Identifier topTexture = TextureUtils.block(BLOCK_ID, "_top");
        Identifier topOpenTexture = TextureUtils.block(BLOCK_ID, "_top_open");

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
