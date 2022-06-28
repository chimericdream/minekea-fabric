package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.MinekeaTags;
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

public class GenericBookshelfStairs extends StairsBlock implements MinekeaBlock {
    public GenericBookshelfStairs(BookshelfStairsSettings settings) {
        super(settings.getBaseBlock().getDefaultState(), settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((BookshelfStairsSettings) this.settings).getBlockId();
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
        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
        MinekeaTags.STAIRS.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier shelf = settings.getMaterial("bookshelf");
        Identifier plankTexture = settings.getBlockTexture("planks");

        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier MAIN_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier INNER_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_inner");
        Identifier OUTER_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_outer");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("#  ", "## ", "###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
                JResult.stackedResult(getBlockID().toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("planks", plankTexture.toString())
            .var("shelf", ModInfo.MOD_ID + ":block/furniture/bookshelves/shelf0");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/building/stairs/bookshelves/main").textures(textures),
            MAIN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/building/stairs/bookshelves/inner").textures(textures),
            INNER_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/building/stairs/bookshelves/outer").textures(textures),
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

    public static class BookshelfStairsSettings extends MinekeaBlockSettings<BookshelfStairsSettings> {
        public BookshelfStairsSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Bookshelf Stairs");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/stairs/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
