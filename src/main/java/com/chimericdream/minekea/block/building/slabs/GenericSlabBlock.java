package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericSlabBlock extends SlabBlock implements MinekeaBlock {
    public GenericSlabBlock(SlabSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((SlabSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Slab", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));

        Map<String, Identifier> materials = ((SlabSettings) this.settings).getMaterials();

        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier SLAB_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier TOP_SLAB_MODEL_ID = new Identifier(ModInfo.MOD_ID, SLAB_MODEL_ID.getPath() + "_top");
        Identifier DOUBLE_MODEL_ID = Model.getItemModelID(ingredient);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(getBlockID().toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.slabLootTable(getBlockID()));

        JTextures textures = new JTextures()
            .var("bottom", Texture.getBlockTextureID(end).toString())
            .var("top", Texture.getBlockTextureID(end).toString())
            .var("side", Texture.getBlockTextureID(side).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/slab").textures(textures),
            SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/slab_top").textures(textures),
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
            getBlockID()
        );
    }

    public static class SlabSettings extends MinekeaBlockSettings<SlabSettings> {
        public SlabSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/slabs/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
