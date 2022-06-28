package com.chimericdream.minekea.block.building.slabs;

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
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class GenericBookshelfSlab extends SlabBlock implements MinekeaBlock {
    public GenericBookshelfSlab(BookshelfSlabSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((BookshelfSlabSettings) this.settings).getBlockId();
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
        MinekeaTags.SLABS.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier shelf = settings.getMaterial("bookshelf");

        Identifier plankTexture = settings.getBlockTexture("planks");

        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier defaultDoubleModelId = new Identifier(ModInfo.MOD_ID, String.format("block/%sfurniture/bookshelves/%s0", ModInfo.getModPrefix(settings.getModId()), settings.getMainMaterial()));

        Identifier SLAB_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier TOP_SLAB_MODEL_ID = new Identifier(SLAB_MODEL_ID + "_top");
        Identifier DOUBLE_MODEL_ID = settings.getMaterial("model", defaultDoubleModelId);

        if (DOUBLE_MODEL_ID == null) {
            DOUBLE_MODEL_ID = defaultDoubleModelId;
        }

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
                JResult.stackedResult(getBlockID().toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.slabLootTable(getBlockID()));

        JTextures textures = new JTextures()
            .var("planks", plankTexture.toString())
            .var("shelf", ModInfo.MOD_ID + ":block/furniture/bookshelves/shelf0");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/slabs/bookshelves/bottom").textures(textures),
            SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/slabs/bookshelves/top").textures(textures),
            TOP_SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SLAB_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("type=bottom", new JBlockModel(SLAB_MODEL_ID))
                    .put("type=double", new JBlockModel(DOUBLE_MODEL_ID))
                    .put("type=top", new JBlockModel(TOP_SLAB_MODEL_ID))
            ),
            getBlockID()
        );
    }

    public static class BookshelfSlabSettings extends MinekeaBlockSettings<BookshelfSlabSettings> {
        public BookshelfSlabSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Bookshelf Slab");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/slabs/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
