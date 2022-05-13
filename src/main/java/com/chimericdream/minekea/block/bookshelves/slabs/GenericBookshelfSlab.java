package com.chimericdream.minekea.block.bookshelves.slabs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericBookshelfSlab extends SlabBlock {
    private final String modId;
    private final String woodType;
    private final Identifier BLOCK_ID;
    private final Map<String, Identifier> materials;

    public GenericBookshelfSlab(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericBookshelfSlab(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD));

        validateMaterials(materials);

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("slabs/%s%s_bookshelf_slab", ModInfo.getModPrefix(modId), woodType));
    }

    protected void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"bookshelf", "planks"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    protected void setupResources() {
        Identifier shelf = materials.get("bookshelf");
        Identifier planks = materials.get("planks");

        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, "item/" + BLOCK_ID.getPath());

        Identifier SLAB_MODEL_ID = new Identifier(ModInfo.MOD_ID, "block/" + BLOCK_ID.getPath());
        Identifier TOP_SLAB_MODEL_ID = new Identifier(ModInfo.MOD_ID, "block/" + BLOCK_ID.getPath() + "_top");
        Identifier DOUBLE_MODEL_ID = materials.getOrDefault(
            "model",
            new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s%s/shelf0", ModInfo.getModPrefix(modId), woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            new Identifier(BLOCK_ID.getNamespace(), "blocks/" + BLOCK_ID.getPath()),
            LootTable.slabLootTable(BLOCK_ID)
        );

        JTextures textures = new JTextures()
            .var("planks", Texture.getBlockTextureID(planks).toString())
            .var("shelf", ModInfo.MOD_ID + ":block/bookshelves/shelf0");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_slab").textures(textures),
            SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_slab_top").textures(textures),
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
            BLOCK_ID
        );
    }
}
