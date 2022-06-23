package com.chimericdream.minekea.block.containers.barrels;

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
import net.minecraft.block.BarrelBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Objects;

public class GenericBarrel extends BarrelBlock implements MinekeaBlock {
    public GenericBarrel(BarrelSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((BarrelSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaResourcePack.addToolTag(settings.getTool(), getBlockID());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Map<String, Identifier> materials = ((BarrelSettings) this.settings).getMaterials();

        String PLANK_MATERIAL = materials.getOrDefault("planks", materials.get("main")).toString();
        String SLAB_MATERIAL = materials.getOrDefault("slab", materials.get("main")).toString();
        String LOG_MATERIAL = materials.getOrDefault("stripped_log", materials.get("main")).toString();

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
        Identifier OPEN_MODEL_ID = new Identifier(MODEL_ID + "_open");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("PSP", "P P", "PSP"),
                JKeys.keys()
                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL))
                    .key("S", JIngredient.ingredient().item(SLAB_MATERIAL)),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("face", Texture.getBlockTextureID(LOG_MATERIAL).toString())
            .var("sides", Texture.getBlockTextureID(PLANK_MATERIAL).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/containers/barrel").textures(textures),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/containers/barrel_open").textures(textures),
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
            getBlockID()
        );
    }

    public static class BarrelSettings extends MinekeaBlockSettings<BarrelSettings> {
        public BarrelSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Barrel");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%scontainers/barrels/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
