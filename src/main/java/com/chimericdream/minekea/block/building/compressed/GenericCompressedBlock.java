package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricItemGroupEventHelpers;
import com.chimericdream.lib.registries.RegistryHelpers;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GenericCompressedBlock extends Block implements FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public static final String TOOLTIP_LEVEL = "block.minekea.building.compressed.tooltip.level";
    public static final String TOOLTIP_COUNT = "block.minekea.building.compressed.tooltip.count";

    public static final EnumProperty<Direction.Axis> AXIS;

    protected Identifier PARENT_BLOCK_ID;
    protected final int compressionLevel;

    static {
        AXIS = Properties.AXIS;
    }

    public GenericCompressedBlock(BlockConfig config, int compressionLevel) {
        super(AbstractBlock.Settings.copy(config.getIngredient()).strength(
            getHardness(compressionLevel, config.getIngredient().getHardness()),
            getResistance(compressionLevel, config.getIngredient().getBlastResistance())
        ).requiresTool());

        this.compressionLevel = compressionLevel;
        this.config = config;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", config.getMaterial(), compressionLevel));

        if (compressionLevel > 1) {
            PARENT_BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", config.getMaterial(), compressionLevel - 1));
        } else {
            PARENT_BLOCK_ID = Registries.BLOCK.getId(config.getIngredient());
        }

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    public BlockConfig getConfig() {
        return config;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        DecimalFormat df = new DecimalFormat("###,###,###");

        tooltip.add(Text.translatable(TOOLTIP_LEVEL, compressionLevel));
        tooltip.add(Text.translatable(TOOLTIP_COUNT, df.format(Math.pow(9, compressionLevel))));
    }

    protected static float getHardness(int level, float baseHardness) {
        return (float) (baseHardness * Math.pow(3, level));
    }

    protected static float getResistance(int level, float baseResistance) {
        return (float) (baseResistance * Math.pow(3, level));
    }

    public void register() {
        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
        FabricItemGroupEventHelpers.addBlockToItemGroup(this, MinekeaItemGroups.COMPRESSED_BLOCK_ITEM_GROUP_KEY);
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(this);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block parentBlock = Registries.BLOCK.get(PARENT_BLOCK_ID);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', parentBlock)
            .criterion(FabricRecipeProvider.hasItem(parentBlock),
                FabricRecipeProvider.conditionsFromItem(parentBlock))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, parentBlock, 9)
            .input(this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter, PARENT_BLOCK_ID.withSuffixedPath("_from_compressed"));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("Compressed %s", config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }

    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> source = instance.getImage(config.getMaterial());

            if (source.isPresent()) {
                BufferedImage sourceImage = source.get();
                BufferedImage overlayImage = instance.getMinekeaImage(String.format("block/building/compressed/level-%d", compressionLevel)).orElse(null);

                int w = sourceImage.getWidth();
                int h = sourceImage.getHeight();

                BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

                Graphics g = combined.getGraphics();
                g.drawImage(sourceImage, 0, 0, null);
                g.drawImage(overlayImage, 0, 0, w, h, null);

                g.dispose();

                instance.generate(BLOCK_ID, combined);
            }
        });
    }
}
