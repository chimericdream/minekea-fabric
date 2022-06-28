package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.MinekeaTags;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.google.gson.JsonObject;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.DoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class GenericBookshelfDoor extends DoorBlock implements MinekeaBlock {
    public GenericBookshelfDoor(BookshelfDoorSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((BookshelfDoorSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));

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
        MinekeaTags.DOORS.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier shelf = settings.getMaterial("bookshelf");
        Identifier plankTexture = settings.getBlockTexture("planks");

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier BOTTOM_MODEL_ID = new Identifier(BASE_MODEL_ID + "_bottom");
        Identifier BOTTOM_HINGE_MODEL_ID = new Identifier(BASE_MODEL_ID + "_bottom_hinge");
        Identifier TOP_MODEL_ID = new Identifier(BASE_MODEL_ID + "_top");
        Identifier TOP_HINGE_MODEL_ID = new Identifier(BASE_MODEL_ID + "_top_hinge");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("##", "##", "##"),
                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
                JResult.stackedResult(getBlockID().toString(), 3)
            )
        );

        JsonObject lowerHalf = new JsonObject();
        lowerHalf.addProperty("half", "lower");

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.getLootTableID(getBlockID()),
            JLootTable.loot("minecraft:block")
                .pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(
                            new JEntry()
                                .type("minecraft:item")
                                .name(getBlockID().toString())
                                .condition(
                                    new JCondition()
                                        .condition("minecraft:block_state_property")
                                        .parameter("block", getBlockID())
                                        .parameter("properties", lowerHalf)
                                )
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        JTextures doorBottom = new JTextures()
            .var("material", plankTexture.toString())
            .var("shelf", "minekea:block/furniture/bookshelves/shelf0");

        JTextures doorTop = new JTextures()
            .var("material", plankTexture.toString())
            .var("shelf", "minekea:block/furniture/bookshelves/shelf1");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/doors/bookshelves/bottom").textures(doorBottom),
            BOTTOM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/doors/bookshelves/bottom_rh").textures(doorBottom),
            BOTTOM_HINGE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/doors/bookshelves/top").textures(doorTop),
            TOP_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/doors/bookshelves/top_rh").textures(doorTop),
            TOP_HINGE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:item/furniture/doors/bookshelf").textures(doorBottom),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=east,half=lower,hinge=left,open=false", new JBlockModel(BOTTOM_MODEL_ID))
                    .put("facing=east,half=lower,hinge=right,open=true", new JBlockModel(BOTTOM_MODEL_ID).y(270))
                    .put("facing=north,half=lower,hinge=left,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(270))
                    .put("facing=north,half=lower,hinge=right,open=true", new JBlockModel(BOTTOM_MODEL_ID).y(180))
                    .put("facing=south,half=lower,hinge=left,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(90))
                    .put("facing=south,half=lower,hinge=right,open=true", new JBlockModel(BOTTOM_MODEL_ID))
                    .put("facing=west,half=lower,hinge=left,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(180))
                    .put("facing=west,half=lower,hinge=right,open=true", new JBlockModel(BOTTOM_MODEL_ID).y(90))
                    .put("facing=east,half=lower,hinge=left,open=true", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(90))
                    .put("facing=east,half=lower,hinge=right,open=false", new JBlockModel(BOTTOM_HINGE_MODEL_ID))
                    .put("facing=north,half=lower,hinge=left,open=true", new JBlockModel(BOTTOM_HINGE_MODEL_ID))
                    .put("facing=north,half=lower,hinge=right,open=false", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(270))
                    .put("facing=south,half=lower,hinge=left,open=true", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(180))
                    .put("facing=south,half=lower,hinge=right,open=false", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(90))
                    .put("facing=west,half=lower,hinge=left,open=true", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(270))
                    .put("facing=west,half=lower,hinge=right,open=false", new JBlockModel(BOTTOM_HINGE_MODEL_ID).y(180))
                    .put("facing=east,half=upper,hinge=left,open=false", new JBlockModel(TOP_MODEL_ID))
                    .put("facing=east,half=upper,hinge=right,open=true", new JBlockModel(TOP_MODEL_ID).y(270))
                    .put("facing=north,half=upper,hinge=left,open=false", new JBlockModel(TOP_MODEL_ID).y(270))
                    .put("facing=north,half=upper,hinge=right,open=true", new JBlockModel(TOP_MODEL_ID).y(180))
                    .put("facing=south,half=upper,hinge=left,open=false", new JBlockModel(TOP_MODEL_ID).y(90))
                    .put("facing=south,half=upper,hinge=right,open=true", new JBlockModel(TOP_MODEL_ID))
                    .put("facing=west,half=upper,hinge=left,open=false", new JBlockModel(TOP_MODEL_ID).y(180))
                    .put("facing=west,half=upper,hinge=right,open=true", new JBlockModel(TOP_MODEL_ID).y(90))
                    .put("facing=east,half=upper,hinge=left,open=true", new JBlockModel(TOP_HINGE_MODEL_ID).y(90))
                    .put("facing=east,half=upper,hinge=right,open=false", new JBlockModel(TOP_HINGE_MODEL_ID))
                    .put("facing=north,half=upper,hinge=left,open=true", new JBlockModel(TOP_HINGE_MODEL_ID))
                    .put("facing=north,half=upper,hinge=right,open=false", new JBlockModel(TOP_HINGE_MODEL_ID).y(270))
                    .put("facing=south,half=upper,hinge=left,open=true", new JBlockModel(TOP_HINGE_MODEL_ID).y(180))
                    .put("facing=south,half=upper,hinge=right,open=false", new JBlockModel(TOP_HINGE_MODEL_ID).y(90))
                    .put("facing=west,half=upper,hinge=left,open=true", new JBlockModel(TOP_HINGE_MODEL_ID).y(270))
                    .put("facing=west,half=upper,hinge=right,open=false", new JBlockModel(TOP_HINGE_MODEL_ID).y(180))
            ),
            getBlockID()
        );
    }

    public static class BookshelfDoorSettings extends MinekeaBlockSettings<BookshelfDoorSettings> {
        public BookshelfDoorSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Bookshelf Door");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/doors/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
