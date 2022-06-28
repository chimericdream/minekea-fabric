package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.Tool;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CobbledEndStoneBlock extends Block implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "building/general/cobbled_end_stone");

    public CobbledEndStoneBlock() {
        super(FabricBlockSettings.copyOf(Blocks.END_STONE));
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaTags.addToolTag(Tool.PICKAXE, getBlockID());
        MinekeaResourcePack.EN_US.blockRespect(this, "Cobbled End Stone");

        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.blockID(new Identifier("minecraft:end_stone")),
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
                                        .name("minecraft:end_stone")
                                        .condition(
                                            new JCondition()
                                                .condition("minecraft:match_tool")
                                                .parameter("predicate", LootTable.silkTouchPredicate())
                                        )
                                )
                                .child(new JEntry().type("minecraft:item").name(getBlockID().toString()))
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );
        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(new JTextures().var("all", Texture.getBlockTextureID(BLOCK_ID).toString().replace("cobbled_", ""))),
            new Identifier("minecraft:end_stone")
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(new JTextures().var("all", Texture.getBlockTextureID(BLOCK_ID).toString())),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
