package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Objects;

public class GenericCoverBlock extends CarpetBlock implements MinekeaBlock {
    public static final DirectionProperty FACING;

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public GenericCoverBlock(CoverSettings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public Identifier getBlockID() {
        return ((CoverSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, ((CoverSettings) this.settings).getBlockId(), this);
        Registry.register(Registry.ITEM, ((CoverSettings) this.settings).getBlockId(), new BlockItem(this, new Item.Settings().group(ItemGroups.COVERS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaResourcePack.addToolTag(settings.getTool(), getBlockID());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Map<String, Identifier> materials = ((CoverSettings) this.settings).getMaterials();
        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(((CoverSettings) this.settings).getBlockId());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(((CoverSettings) this.settings).getBlockId());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            ((CoverSettings) this.settings).getBlockId(),
            JRecipe.shaped(
                JPattern.pattern("X X", "   ", "X X"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(((CoverSettings) this.settings).getBlockId().toString(), 16)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(((CoverSettings) this.settings).getBlockId()), LootTable.dropSelf(((CoverSettings) this.settings).getBlockId()));

        JTextures textures = new JTextures()
            .var("end", Texture.getBlockTextureID(end).toString())
            .var("side", Texture.getBlockTextureID(side).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/cover").textures(textures),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north", new JBlockModel(MODEL_ID))
                    .put("facing=east", new JBlockModel(MODEL_ID).y(90))
                    .put("facing=south", new JBlockModel(MODEL_ID).y(180))
                    .put("facing=west", new JBlockModel(MODEL_ID).y(270))
            ),
            ((CoverSettings) this.settings).getBlockId()
        );
    }

    public static class CoverSettings extends MinekeaBlockSettings<CoverSettings> {
        public CoverSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Cover");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/covers/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
