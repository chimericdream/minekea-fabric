package com.chimericdream.minekea.block.trapdoors;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GenericBookshelfTrapdoor extends TrapdoorBlock {
    private final String woodType;
    private final Identifier BLOCK_ID;

    public GenericBookshelfTrapdoor(String woodType) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD));

        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/trapdoors/%s_bookshelf_trapdoor", woodType));
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));

        setupResources();
    }

    protected void setupResources() {
        String BOOKSHELF_TYPE = woodType.equals("oak") ? "minecraft:bookshelf" : String.format("minekea:bookshelves/%s_bookshelf", woodType);

        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/" + BLOCK_ID.getPath(), woodType));

        Identifier BOTTOM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_bottom", woodType));
        Identifier OPEN_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_open", woodType));
        Identifier TOP_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_top", woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(BOOKSHELF_TYPE)),
                JResult.stackedResult(BLOCK_ID.toString(), 12)
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
                                .type("minecraft:item")
                                .name(BLOCK_ID.toString())
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        JTextures textures = new JTextures().var(
            "texture",
            String.format("minekea:block/bookshelves/%s/shelf0", woodType)
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_orientable_trapdoor_bottom").textures(textures),
            BOTTOM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_orientable_trapdoor_open").textures(textures),
            OPEN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_orientable_trapdoor_top").textures(textures),
            TOP_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(BOTTOM_MODEL_ID.toString()), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=east,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(90))
                    .put("facing=north,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID))
                    .put("facing=south,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(180))
                    .put("facing=west,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(270))
                    .put("facing=east,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(90))
                    .put("facing=north,half=top,open=false", new JBlockModel(TOP_MODEL_ID))
                    .put("facing=south,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(180))
                    .put("facing=west,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(270))
                    .put("facing=east,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(90))
                    .put("facing=north,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID))
                    .put("facing=south,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(180))
                    .put("facing=west,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(270))
                    .put("facing=east,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(270))
                    .put("facing=north,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(180))
                    .put("facing=south,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(0))
                    .put("facing=west,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(90))
            ),
            BLOCK_ID
        );
    }
}
