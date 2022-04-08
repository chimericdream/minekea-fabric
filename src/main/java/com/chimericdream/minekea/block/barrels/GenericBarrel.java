package com.chimericdream.minekea.block.barrels;

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
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GenericBarrel extends BarrelBlock {
    private final String woodType;
    private final Identifier BLOCK_ID;

    public GenericBarrel(String woodType) {
        super(FabricBlockSettings.copyOf(Blocks.BARREL).sounds(BlockSoundGroup.WOOD));

        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("barrels/%s_barrel", woodType));
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    protected void setupResources() {
        String PLANK_MATERIAL = String.format("minecraft:%s_planks", woodType);
        String SLAB_MATERIAL = String.format("minecraft:%s_slab", woodType);
        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/barrels/%s_barrel", woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/barrels/%s_barrel", woodType));
        Identifier OPEN_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/barrels/%s_barrel_open", woodType));

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
            JModel.model("minecraft:block/cube_bottom_top")
                .textures(
                    new JTextures()
                        .var("top", String.format("minekea:block/barrels/%s/barrel_top", woodType))
                        .var("bottom", String.format("minekea:block/barrels/%s/barrel_bottom", woodType))
                        .var("side", String.format("minekea:block/barrels/%s/barrel_side", woodType))
                ),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_bottom_top")
                .textures(
                    new JTextures()
                        .var("top", String.format("minekea:block/barrels/%s/barrel_top_open", woodType))
                        .var("bottom", String.format("minekea:block/barrels/%s/barrel_bottom", woodType))
                        .var("side", String.format("minekea:block/barrels/%s/barrel_side", woodType))
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
