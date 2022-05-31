package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaItem;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WarpedWartItem extends AliasedBlockItem implements MinekeaItem {
    public static final Identifier ITEM_ID = new Identifier(ModInfo.MOD_ID, "crops/warped_wart");

    public WarpedWartItem() {
        super(Crops.WARPED_WART_BLOCK, (new Item.Settings()).group(ItemGroup.MATERIALS));
    }

    @Override
    public Identifier getItemID() {
        return ITEM_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, ITEM_ID, this);
        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.itemRespect(this, "Warped Wart");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            ITEM_ID,
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item("minecraft:warped_wart_block")),
                JResult.stackedResult(ITEM_ID.toString(), 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "blocks/warped_wart_block_from_crop"),
            JRecipe.shaped(
                JPattern.pattern("###", "###", "###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(ITEM_ID.toString())),
                JResult.result("minecraft:warped_wart_block")
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:item/generated")
                .textures(new JTextures().layer0(Texture.getItemTextureID(ITEM_ID).toString())),
            Model.getItemModelID(ITEM_ID)
        );
    }
}
