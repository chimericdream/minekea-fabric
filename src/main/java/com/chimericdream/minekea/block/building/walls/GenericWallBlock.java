package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JWhen;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericWallBlock extends WallBlock implements MinekeaBlock {
    public GenericWallBlock(WallSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((WallSettings) this.settings).getBlockId();
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
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Wall", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));
        MinekeaResourcePack.WALL_TAG.add(getBlockID());

        Map<String, Identifier> materials = ((WallSettings) this.settings).getMaterials();

        Identifier main = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier INVENTORY_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_inventory");
        Identifier POST_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_post");
        Identifier SIDE_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side");
        Identifier SIDE_TALL_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side_tall");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(getBlockID().toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures().var("wall", Texture.getBlockTextureID(main).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/wall_inventory").textures(textures),
            INVENTORY_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_post").textures(textures),
            POST_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_side").textures(textures),
            SIDE_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_side_tall").textures(textures),
            SIDE_TALL_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(INVENTORY_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.multipart(new JBlockModel(POST_MODEL_ID))
                    .when(new JWhen().add("up", "true")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).uvlock())
                    .when(new JWhen().add("north", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(90).uvlock())
                    .when(new JWhen().add("east", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(180).uvlock())
                    .when(new JWhen().add("south", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(270).uvlock())
                    .when(new JWhen().add("west", "low")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).uvlock())
                    .when(new JWhen().add("north", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(90).uvlock())
                    .when(new JWhen().add("east", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(180).uvlock())
                    .when(new JWhen().add("south", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(270).uvlock())
                    .when(new JWhen().add("west", "tall"))
            ),
            getBlockID()
        );
    }

    public static class WallSettings extends MinekeaBlockSettings<WallSettings> {
        public WallSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/walls/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
