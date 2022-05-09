package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
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
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericBookshelf extends Block {
    private final String modId;
    private final String woodType;
    private final Map<String, Identifier> materials;

    public final Identifier BLOCK_ID;

    public GenericBookshelf(String woodType) {
        this(woodType, ModInfo.MOD_ID);
    }

    public GenericBookshelf(String woodType, String modId) {
        this(woodType, modId, Map.of("planks", new Identifier(String.format("minecraft:%s_planks", woodType))));
    }

    public GenericBookshelf(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericBookshelf(String woodType, Map<String, Identifier> materials, Block copyOf) {
        this(woodType, ModInfo.MOD_ID, materials, copyOf);
    }

    public GenericBookshelf(String woodType, String modId, Map<String, Identifier> materials) {
        this(woodType, modId, materials, Blocks.BOOKSHELF);
    }

    public GenericBookshelf(String woodType, String modId, Map<String, Identifier> materials, Block copyOf) {
        super(AbstractBlock.Settings.copy(copyOf));

        validateMaterials(materials);

        this.materials = materials;
        this.modId = modId;
        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/%s%s_bookshelf", ModInfo.getModPrefix(modId), woodType));
    }

    protected void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
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
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "XXX", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(materials.get("planks").toString()))
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

        Identifier plankTextureId = materials.getOrDefault("plank_texture", materials.get("planks"));

        // Block model variations
        for (int i = 0; i <= 6; i++) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/bookshelf_variant")
                    .textures(
                        new JTextures()
                            .var("material", Texture.getBlockTextureID(plankTextureId).toString())
                            .var("shelf", String.format("minekea:block/bookshelves/shelf%d", i))
                    ),
                new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s%s/shelf%d", ModInfo.getModPrefix(modId), woodType, i))
            );
        }

        // Item model
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(String.format("minekea:block/bookshelves/%s%s/shelf0", ModInfo.getModPrefix(modId), woodType)),
            new Identifier(ModInfo.MOD_ID, String.format("item/bookshelves/%s%s_bookshelf", ModInfo.getModPrefix(modId), woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s%s/shelf0", ModInfo.getModPrefix(modId), woodType))))),
            BLOCK_ID
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
