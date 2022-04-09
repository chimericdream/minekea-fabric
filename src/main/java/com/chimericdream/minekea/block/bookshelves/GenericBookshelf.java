package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JFunction;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GenericBookshelf extends Block {
    private final String woodType;
    public final Identifier BLOCK_ID;

    GenericBookshelf(String woodType) {
        super(AbstractBlock.Settings.copy(Blocks.BOOKSHELF));

        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/%s_bookshelf", woodType));
    }

    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    protected void setupResources() {
        String MATERIAL = String.format("minecraft:%s_planks", woodType);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "XXX", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(MATERIAL))
                    .key("X", JIngredient.ingredient().item("minecraft:book")),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            new Identifier(BLOCK_ID.getNamespace(), "blocks/" + BLOCK_ID.getPath()),
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
                                        .name(BLOCK_ID.toString())
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

        for (int i = 0; i <= 6; i++) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minecraft:block/cube_column")
                    .textures(
                        new JTextures()
                            .var("end", String.format("minecraft:block/%s_planks", woodType))
                            .var("side", String.format("minekea:block/bookshelves/%s/shelf%d", woodType, i))
                    ),
                new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf%d", woodType, i))
            );
        }

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(String.format("minekea:block/bookshelves/%s/shelf0", woodType)),
            new Identifier(ModInfo.MOD_ID, String.format("item/bookshelves/%s_bookshelf", woodType))
        );

        // This is bugged in ARRP
        // See: https://github.com/Devan-Kerman/ARRP/issues/62
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf0", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf1", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf2", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf3", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf4", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf5", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf6", woodType))))
//            ),
//            BLOCK_ID
//        );
    }
}
