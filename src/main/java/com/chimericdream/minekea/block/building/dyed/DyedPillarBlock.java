package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class DyedPillarBlock extends PillarBlock implements MinekeaBlock {
    public static final EnumProperty<Direction.Axis> AXIS;

    static {
        AXIS = Properties.AXIS;
    }

    public final Identifier BLOCK_ID;
    protected final Identifier PARENT_BLOCK_ID;

    protected final String materialName;
    protected final String endTextureKey;
    protected final String sideTextureKey;
    protected final DyeColor color;
    protected final Block baseBlock;

    public DyedPillarBlock(DyeColor color, String materialName, String endTextureKey, String sideTextureKey, Block baseBlock) {
        this(Settings.copy(baseBlock), color, materialName, endTextureKey, sideTextureKey, baseBlock);
    }

    public DyedPillarBlock(
        Settings settings,
        DyeColor color,
        String materialName,
        String endTextureKey,
        String sideTextureKey,
        Block baseBlock
    ) {
        super(settings.mapColor(color));

        this.color = color;
        this.materialName = materialName;
        this.endTextureKey = endTextureKey;
        this.sideTextureKey = sideTextureKey;
        this.baseBlock = baseBlock;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/dyed/%s/%s", Registries.BLOCK.getId(baseBlock).getPath(), color));

        PARENT_BLOCK_ID = Registries.BLOCK.getId(baseBlock);

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));

        ItemGroupEvents.modifyEntriesEvent(MinekeaItemGroups.DYED_BLOCK_ITEM_GROUP_KEY)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block parentBlock = Registries.BLOCK.get(PARENT_BLOCK_ID);
        Item dye = Colors.getDye(color);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 8)
            .pattern("###")
            .pattern("#D#")
            .pattern("###")
            .input('#', parentBlock)
            .input('D', dye)
            .criterion(FabricRecipeProvider.hasItem(parentBlock),
                FabricRecipeProvider.conditionsFromItem(parentBlock))
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Dyed %s", Colors.getName(color), materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.END, BLOCK_ID.withPrefixedPath("block/").withSuffixedPath("_end"))
            .put(TextureKey.SIDE, BLOCK_ID.withPrefixedPath("block/").withSuffixedPath("_side"));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", Models.CUBE_COLUMN, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, AXIS, this, subModelId);
    }

//    @Override
//    public void setupResources() {
//        DyedBlockSettings settings = (DyedBlockSettings) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        if (settings.getBlockTag() != null) {
//            settings.getBlockTag().add(getBlockID());
//        }
//
//        MinekeaResourcePack.EN_US.blockRespect(
//            this,
//            String.format(settings.getNamePattern(), settings.getColorName(), settings.getIngredientName(false))
//        );
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        Identifier dye = settings.getDye();
//
//        Identifier ingredient = settings.getMaterial("ingredient");
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        Identifier textureId = Texture.getBlockTextureID(getBlockID());
//
//        if (settings.isColumn()) {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(
//                JModel.model("minecraft:block/cube_column")
//                    .textures(
//                        new JTextures()
//                            .var("end", textureId + "_end")
//                            .var("side", textureId + "_side")
//                    ),
//                MODEL_ID
//            );
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(
//                JModel.model("minecraft:block/cube_all")
//                    .textures(new JTextures().var("all", textureId.toString())),
//                MODEL_ID
//            );
//        }
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        if (settings.isColumn()) {
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(
//                    JState.variant()
//                        .put("axis=x", new JBlockModel(MODEL_ID).x(90).y(90))
//                        .put("axis=y", new JBlockModel(MODEL_ID))
//                        .put("axis=z", new JBlockModel(MODEL_ID).x(90))
//                ),
//                getBlockID()
//            );
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
//                getBlockID()
//            );
//        }
//
//        if (getBlockID().toString().contains("bone_block")) {
//            String thing = "";
//        }
//    }
//
//    public static class DyedBlockSettings extends MinekeaBlockSettings<DyedBlockSettings> {
//        protected String color = "";
//        protected JTag blockTag = null;
//
//        public DyedBlockSettings(DefaultSettings settings) {
//            super(settings);
//        }
//
//        public DefaultSettings asDefaultSettings() {
//            DefaultSettings settings = new DefaultSettings(this.getBaseBlock())
//                .material(String.format("%s/%s", getMainMaterial(), getColor()))
//                .materials(Map.of("main", getBlockId()))
//                .ingredientName(String.format("%s Dyed %s", Colors.getName(color), getIngredientName()));
//
//            if (this.isColumn()) {
//                settings.materials(
//                    Map.of(
//                        "main", new Identifier(getBlockId() + "_side"),
//                        "end", new Identifier(getBlockId() + "_end"),
//                        "ingredient", getBlockId()
//                    )
//                );
//            }
//
//            return settings;
//        }
//
//        public String getColor() {
//            return this.color;
//        }
//
//        public DyedBlockSettings color(String color) {
//            this.color = color;
//            return this;
//        }
//
//        public String getColorName() {
//            return Colors.getName(this.color);
//        }
//
//        public Identifier getDye() {
//            return Colors.getDye(this.color);
//        }
//
//        public JTag getBlockTag() {
//            return this.blockTag;
//        }
//
//        public DyedBlockSettings blockTag(JTag blockTag) {
//            this.blockTag = blockTag;
//            return this;
//        }
//
//        public String getName() {
//            return String.format(getNamePattern(), getColorName(), getIngredientName(false));
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Dyed %s");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = new Identifier(ModInfo.MOD_ID, String.format("building/dyed/%s/%s", getMaterial("ingredient").getPath(), color));
//            }
//
//            return blockId;
//        }
//    }
}
