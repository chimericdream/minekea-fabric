package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class GenericCompressedBlock extends Block implements MinekeaBlock {
    protected final Identifier BLOCK_ID;
    protected final Identifier BASE_BLOCK_ID;
    protected final Identifier PARENT_BLOCK_ID;

    public static final String TOOLTIP_LEVEL = "block.minekea.building.compressed.tooltip.level";
    public static final String TOOLTIP_COUNT = "block.minekea.building.compressed.tooltip.count";

    public static final EnumProperty<Direction.Axis> AXIS;

    static {
        AXIS = Properties.AXIS;
    }

    public GenericCompressedBlock(CompressedBlockSettings settings) {
        super(settings.strength(
            getHardness(settings.getCompressionLevel(), settings.getHardness()),
            getResistance(settings.getCompressionLevel(), settings.getResistance())
        ).requiresTool());

        BASE_BLOCK_ID = settings.getMaterials().getOrDefault("ingredient", settings.getMaterials().get("main"));

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", settings.getMainMaterial(), settings.getCompressionLevel()));

        if (settings.getCompressionLevel() > 1) {
            PARENT_BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", settings.getMainMaterial(), settings.getCompressionLevel() - 1));
        } else {
            PARENT_BLOCK_ID = settings.getMaterials().getOrDefault("ingredient", settings.getMaterials().get("main"));
        }

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        CompressedBlockSettings settings = (CompressedBlockSettings) this.settings;

        DecimalFormat df = new DecimalFormat("###,###,###");

        tooltip.add(Text.translatable(TOOLTIP_LEVEL, settings.getCompressionLevel()));
        tooltip.add(Text.translatable(TOOLTIP_COUNT, df.format(Math.pow(9, settings.getCompressionLevel()))));
    }

    @Override
    public String getTranslationKey() {
        return Registry.BLOCK.get(BASE_BLOCK_ID).getTranslationKey();
    }

    protected static float getHardness(int level, float baseHardness) {
        return (float) (baseHardness * Math.pow(3, level));
    }

    protected static float getResistance(int level, float baseResistance) {
        return (float) (baseResistance * Math.pow(3, level));
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroups.COMPRESSED_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        CompressedBlockSettings settings = (CompressedBlockSettings) this.settings;

        Map<String, Identifier> materials = settings.getMaterials();

        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");

        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "###", "###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(PARENT_BLOCK_ID.toString())),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            Recipe.getRecipeID(PARENT_BLOCK_ID, String.format("_from_compressed_%dx", settings.getCompressionLevel())),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(BLOCK_ID.toString())),
                JResult.stackedResult(PARENT_BLOCK_ID.toString(), 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures()
            .var("side", Texture.getBlockTextureID(side).toString())
            .var("end", Texture.getBlockTextureID(end).toString())
            .var("overlay", String.format(ModInfo.MOD_ID + ":block/building/compressed/level-%d", settings.getCompressionLevel()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/building/compressed_block").textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        if (settings.isColumn()) {
            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                JState.state(
                    JState.variant()
                        .put("axis=x", new JBlockModel(MODEL_ID).x(90).y(90))
                        .put("axis=y", new JBlockModel(MODEL_ID))
                        .put("axis=z", new JBlockModel(MODEL_ID).x(90))
                ),
                BLOCK_ID
            );
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                JState.state(JState.variant(new JBlockModel(MODEL_ID))),
                BLOCK_ID
            );
        }
    }

    public static class CompressedBlockSettings extends MinekeaBlockSettings<CompressedBlockSettings> {
        protected int compressionLevel = 1;

        public CompressedBlockSettings(DefaultSettings settings) {
            super(settings);
        }

        public int getCompressionLevel() {
            return this.compressionLevel;
        }

        public CompressedBlockSettings compressionLevel(int level) {
            this.compressionLevel = level;
            return this;
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/compressed/%s/%dx", ModInfo.getModPrefix(modId), mainMaterial, compressionLevel));
            }

            return blockId;
        }

        @Override
        public String getNamePattern() {
            return null;
        }
    }
}
