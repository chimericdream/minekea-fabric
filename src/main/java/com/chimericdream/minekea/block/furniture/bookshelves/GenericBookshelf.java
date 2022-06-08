package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JFunction;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Objects;

public class GenericBookshelf extends Block implements MinekeaBlock {
    public GenericBookshelf(BookshelfSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((BookshelfSettings) this.settings).getBlockId();
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
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Map<String, Identifier> materials = ((BookshelfSettings) this.settings).getMaterials();

        Identifier ingredient = materials.getOrDefault(
            "ingredient",
            materials.getOrDefault("planks", materials.get("main"))
        );
        Identifier sideTexture = materials.getOrDefault("side_texture", ingredient);

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###", "XXX", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(ingredient.toString()))
                    .key("X", JIngredient.ingredient().item("minecraft:book")),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.getLootTableID(getBlockID()),
            JLootTable.loot("minecraft:block")
                .pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(
                            new JEntry()
                                .type("minecraft:alternatives")
                                .child(
                                    new JEntry()
                                        .type("minecraft:item")
                                        .name(getBlockID().toString())
                                        .condition(
                                            new JCondition()
                                                .condition("minecraft:match_tool")
                                                .parameter("predicate", LootTable.silkTouchPredicate())
                                        )
                                )
                                .child(
                                    new JEntry()
                                        .type("minecraft:item")
                                        .name("minecraft:book")
                                        .function(
                                            new JFunction("minecraft:set_count")
                                                .parameter("count", 3)
                                                .parameter("add", false)
                                        )
                                        .function(new JFunction("minecraft:explosion_decay"))
                                )
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        // Block model variations
        for (int i = 0; i <= 6; i++) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                    .textures(
                        new JTextures()
                            .var("material", Texture.getBlockTextureID(sideTexture).toString())
                            .var("shelf", String.format("minekea:block/furniture/bookshelves/shelf%d", i))
                    ),
                new Identifier(String.format("%s%d", BASE_MODEL_ID, i))
            );
        }

        // Item model
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s0", BASE_MODEL_ID)), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(new Identifier(String.format("%s0", BASE_MODEL_ID))))),
            getBlockID()
        );

        // This is bugged in ARRP
        // See: https://github.com/Devan-Kerman/ARRP/issues/62
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("", new JBlockModel(new Identifier(String.format("%s0", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s1", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s2", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s3", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s4", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s5", BASE_MODEL_ID))))
//                    .put("", new JBlockModel(new Identifier(String.format("%s6", BASE_MODEL_ID))))
//            ),
//            getBlockID()
//        );
    }

    public static class BookshelfSettings extends MinekeaBlockSettings<BookshelfSettings> {
        public BookshelfSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Bookshelf");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
