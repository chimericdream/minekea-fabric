package com.chimericdream.minekea.block.bookshelves.doors;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import com.google.gson.JsonObject;
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
import net.minecraft.block.DoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericBookshelfDoor extends DoorBlock {
    private final Map<String, Identifier> materials;
    private final String modId;
    private final String woodType;

    public final Identifier BLOCK_ID;

    public GenericBookshelfDoor(String woodType) {
        this(woodType, ModInfo.MOD_ID);
    }

    public GenericBookshelfDoor(String woodType, String modId) {
        this(
            woodType,
            modId,
            Map.of(
                "bookshelf", new Identifier(getDefaultBookshelfId(woodType, modId)),
                "planks", new Identifier(String.format("minecraft:%s_planks", woodType))
            )
        );
    }

    public GenericBookshelfDoor(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).sounds(BlockSoundGroup.WOOD));

        validateMaterials(materials);

        this.materials = materials;
        this.modId = modId;
        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/doors/%s%s_bookshelf_door", ModInfo.getModPrefix(modId), woodType));
    }

    private static String getDefaultBookshelfId(String woodType, String modId) {
        if (woodType.equals("oak")) {
            return "minecraft:bookshelf";
        } else {
            return String.format("minekea:%sfurniture/bookshelves/%s", ModInfo.getModPrefix(modId), woodType);
        }
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
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));

        setupResources();
    }

    protected void setupResources() {
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/" + BLOCK_ID.getPath(), woodType));

        Identifier BOTTOM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_bottom", woodType));
        Identifier BOTTOM_HINGE_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_bottom_hinge", woodType));
        Identifier TOP_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_top", woodType));
        Identifier TOP_HINGE_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/" + BLOCK_ID.getPath() + "_top_hinge", woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("##", "##", "##"),
                JKeys.keys().key("#", JIngredient.ingredient().item(materials.get("bookshelf").toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        JsonObject lowerHalf = new JsonObject();
        lowerHalf.addProperty("half", "lower");

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
                                .condition(
                                    new JCondition()
                                        .condition("minecraft:block_state_property")
                                        .parameter("block", String.format("minekea:bookshelves/doors/%s%s_bookshelf_door", ModInfo.getModPrefix(modId), woodType))
                                        .parameter("properties", lowerHalf)
                                )
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        JTextures doorBottom = new JTextures()
            .var("material", Texture.getBlockTextureID(materials.get("planks")).toString())
            .var("shelf", "minekea:block/furniture/bookshelves/shelf0");

        JTextures doorTop = new JTextures()
            .var("material", Texture.getBlockTextureID(materials.get("planks")).toString())
            .var("shelf", "minekea:block/furniture/bookshelves/shelf1");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_door_bottom").textures(doorBottom),
            BOTTOM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_door_bottom_rh").textures(doorBottom),
            BOTTOM_HINGE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_door_top").textures(doorTop),
            TOP_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelf_door_top_rh").textures(doorTop),
            TOP_HINGE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:item/door_item").textures(doorBottom),
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
            BLOCK_ID
        );
    }
}
