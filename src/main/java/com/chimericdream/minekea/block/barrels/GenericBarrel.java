package com.chimericdream.minekea.block.barrels;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericBarrel extends BarrelBlock {
    private final String modId;
    private final String woodType;
    private final Identifier BLOCK_ID;
    private final Map<String, Identifier> materials;

    public GenericBarrel(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericBarrel(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.BARREL).sounds(BlockSoundGroup.WOOD));

        validateMaterials(materials);

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("barrels/%s%s_barrel", ModInfo.getModPrefix(modId), woodType));
    }

    protected void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks", "slab", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    protected void setupResources() {
        String PLANK_MATERIAL = materials.get("planks").toString();
        String SLAB_MATERIAL = materials.get("slab").toString();
        String LOG_MATERIAL = materials.get("log").toString();

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/barrels/%s%s_barrel", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/barrels/%s%s_barrel", ModInfo.getModPrefix(modId), woodType));
        Identifier OPEN_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/barrels/%s%s_barrel_open", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("PSP", "P P", "PSP"),
                JKeys.keys()
                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL))
                    .key("S", JIngredient.ingredient().item(SLAB_MATERIAL)),
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
                                .type("minecraft:item")
                                .name(BLOCK_ID.toString())
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/barrel_variant")
                .textures(
                    new JTextures()
                        .var("face", Texture.getBlockTextureID(LOG_MATERIAL).toString())
                        .var("sides", Texture.getBlockTextureID(PLANK_MATERIAL).toString())
                ),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/barrel_variant_open")
                .textures(
                    new JTextures()
                        .var("face", Texture.getBlockTextureID(LOG_MATERIAL).toString())
                        .var("sides", Texture.getBlockTextureID(PLANK_MATERIAL).toString())
                ),
            OPEN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID.toString()), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=down,open=false", new JBlockModel(MODEL_ID).x(180))
                    .put("facing=east,open=false", new JBlockModel(MODEL_ID).x(90).y(90))
                    .put("facing=north,open=false", new JBlockModel(MODEL_ID).x(90))
                    .put("facing=south,open=false", new JBlockModel(MODEL_ID).x(90).y(180))
                    .put("facing=up,open=false", new JBlockModel(MODEL_ID))
                    .put("facing=west,open=false", new JBlockModel(MODEL_ID).x(90).y(270))

                    .put("facing=down,open=true", new JBlockModel(OPEN_MODEL_ID).x(180))
                    .put("facing=east,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(90))
                    .put("facing=north,open=true", new JBlockModel(OPEN_MODEL_ID).x(90))
                    .put("facing=south,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(180))
                    .put("facing=up,open=true", new JBlockModel(OPEN_MODEL_ID))
                    .put("facing=west,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(270))
            ),
            BLOCK_ID
        );
    }
}
