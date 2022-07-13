package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks.DyedBlockSettings;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.Tool;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class DyedPrismarineBricksBlock extends Block implements MinekeaBlock {
    public DyedPrismarineBricksBlock(DyedBlockSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        DyedBlockSettings settings = (DyedBlockSettings) this.settings;
        MinekeaTags.addToolTag(Tool.PICKAXE, getBlockID());
        MinekeaTags.DARK_PRISMARINE.add(getBlockID());

        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getColorName()));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier dye = settings.getDye();

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###", "#D#", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item("minecraft:prismarine_bricks"))
                    .key("D", JIngredient.ingredient().item(dye.toString())),
                JResult.stackedResult(getBlockID().toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(new JTextures().var("all", Texture.getBlockTextureID(getBlockID()).toString())),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class DyedPrismarineBricksSettings extends DyedBlockSettings {
        public DyedPrismarineBricksSettings(DefaultSettings settings) {
            super(settings);
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Dyed Prismarine Bricks");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("building/dyed/prismarine_bricks/" + color));
            }

            return blockId;
        }
    }
}
