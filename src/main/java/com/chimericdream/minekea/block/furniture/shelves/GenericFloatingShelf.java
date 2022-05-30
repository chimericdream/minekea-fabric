package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Map;

public class GenericFloatingShelf extends GenericShelf {
    public GenericFloatingShelf(FloatingShelfSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((FloatingShelfSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        switch (wall) {
            case EAST:
                return Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0);

            case SOUTH:
                return Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0);

            case WEST:
                return Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0);

            case NORTH:
            default:
                return Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0);
        }
    }

    @Override
    public void setupResources() {
        Map<String, Identifier> materials = ((FloatingShelfSettings) this.settings).getMaterials();

        Identifier planks = materials.getOrDefault("planks", materials.get("main"));
        Identifier slab = materials.getOrDefault("slab", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "XXX"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item("minecraft:iron_ingot")),
                JResult.stackedResult(getBlockID().toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel
                .model(ModInfo.MOD_ID + ":block/furniture/shelves/floating")
                .textures(new JTextures().var("planks", Texture.getBlockTextureID(planks).toString())),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("wall_side=north", new JBlockModel(MODEL_ID))
                    .put("wall_side=east", new JBlockModel(MODEL_ID).y(90))
                    .put("wall_side=south", new JBlockModel(MODEL_ID).y(180))
                    .put("wall_side=west", new JBlockModel(MODEL_ID).y(270))
            ),
            getBlockID()
        );
    }

    public static class FloatingShelfSettings extends SupportedShelfSettings {
        public FloatingShelfSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/shelves/floating/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
