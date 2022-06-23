package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class GenericStairsBlock extends StairsBlock implements MinekeaBlock {
    public GenericStairsBlock(StairsSettings settings) {
        super(settings.getBaseBlock().getDefaultState(), settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((StairsSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

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

        Identifier ingredient = settings.getMaterial("ingredient");
        Identifier endTexture = settings.getBlockTexture("end");
        Identifier sideTexture = settings.getBlockTexture("main");

        Identifier MAIN_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier INNER_MODEL_ID = new Identifier(ModInfo.MOD_ID, MAIN_MODEL_ID.getPath() + "_inner");
        Identifier OUTER_MODEL_ID = new Identifier(ModInfo.MOD_ID, MAIN_MODEL_ID.getPath() + "_outer");
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("#  ", "## ", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(getBlockID().toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("bottom", endTexture.toString())
            .var("top", endTexture.toString())
            .var("side", sideTexture.toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/stairs").textures(textures),
            MAIN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/inner_stairs").textures(textures),
            INNER_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/outer_stairs").textures(textures),
            OUTER_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MAIN_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=east,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(270).uvlock())
                    .put("facing=east,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID))
                    .put("facing=east,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(270).uvlock())
                    .put("facing=east,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID))
                    .put("facing=east,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID))
                    .put("facing=east,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).uvlock())
                    .put("facing=east,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=east,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).uvlock())
                    .put("facing=east,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=east,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(180).uvlock())
                    .put("facing=north,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(180).uvlock())
                    .put("facing=north,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=north,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=north,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=south,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID))
                    .put("facing=south,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID))
                    .put("facing=south,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=south,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=south,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=south,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=south,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=west,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=west,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=west,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=west,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(180).uvlock())
            ),
            getBlockID()
        );
    }

    public static class StairsSettings extends MinekeaBlockSettings<StairsSettings> {
        public StairsSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Stairs");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/stairs/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
