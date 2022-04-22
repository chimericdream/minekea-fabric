package com.chimericdream.minekea.block.scales;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GenericScaledBlock extends Block implements MinekeaBlock {
    private final String modId;
    private final Identifier material;

    public final Identifier BLOCK_ID;

    public GenericScaledBlock(Identifier material) {
        this(ModInfo.MOD_ID, material);
    }

    public GenericScaledBlock(String modId, Identifier material) {
        super(AbstractBlock.Settings.copy(Blocks.BOOKSHELF));

        this.material = material;
        this.modId = modId;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("scales/%sscaled_%s", ModInfo.getModPrefix(modId), material.getPath()));
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

    protected Identifier getTexture() {
        return material;
    }

    @Override
    public void setupResources() {
        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("# #", " # ", "# #"),
                JKeys.keys().key("#", JIngredient.ingredient().item(material.toString())),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            Recipe.getRecipeID(material, "_from_scaled"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(BLOCK_ID.toString())),
                JResult.result(material.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/scaled_block")
                .textures(
                    new JTextures()
                        .var("material", Texture.getBlockTextureID(getTexture()).toString())
                        .var("overlay", ModInfo.MOD_ID + ":block/scales/scales_overlay")
                ),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
