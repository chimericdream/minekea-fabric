package com.chimericdream.minekea.block.redstone.buttons;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.MinekeaTags;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class GenericButton extends AbstractButtonBlock implements MinekeaBlock {
    public GenericButton(ButtonSettings settings) {
        // Wool buttons behave like wood ones
        super(settings.isWooden() || settings.isWool(), settings);
    }

    @Override
    protected void playClickSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, boolean powered) {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;

        // Wool buttons are silent
        if (settings.isWool()) {
            return;
        }

        world.playSound(powered ? player : null, pos, this.getClickSound(powered), SoundCategory.BLOCKS, 0.3F, powered ? 0.6F : 0.5F);
    }

    @Override
    protected SoundEvent getClickSound(boolean powered) {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        if (settings.isWooden()) {
            return powered ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
        }

        return powered ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaTags.BUTTONS.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier ingredient = settings.getMaterial("ingredient");
        Identifier texture = settings.getBlockTexture("main");

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier INVENTORY_MODEL_ID = new Identifier(BASE_MODEL_ID + "_inventory");
        Identifier PRESSED_MODEL_ID = new Identifier(BASE_MODEL_ID + "_pressed");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(ingredient.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures().var("texture", texture.toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/button").textures(textures),
            BASE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/button_inventory").textures(textures),
            INVENTORY_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/button_pressed").textures(textures),
            PRESSED_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(INVENTORY_MODEL_ID.toString()), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("face=ceiling,facing=east,powered=false", new JBlockModel(BASE_MODEL_ID).x(180).y(270))
                    .put("face=ceiling,facing=east,powered=true", new JBlockModel(PRESSED_MODEL_ID).x(180).y(270))
                    .put("face=ceiling,facing=north,powered=false", new JBlockModel(BASE_MODEL_ID).x(180).y(180))
                    .put("face=ceiling,facing=north,powered=true", new JBlockModel(PRESSED_MODEL_ID).x(180).y(180))
                    .put("face=ceiling,facing=south,powered=false", new JBlockModel(BASE_MODEL_ID).x(180))
                    .put("face=ceiling,facing=south,powered=true", new JBlockModel(PRESSED_MODEL_ID).x(180))
                    .put("face=ceiling,facing=west,powered=false", new JBlockModel(BASE_MODEL_ID).x(180).y(90))
                    .put("face=ceiling,facing=west,powered=true", new JBlockModel(PRESSED_MODEL_ID).x(180).y(90))
                    .put("face=floor,facing=east,powered=false", new JBlockModel(BASE_MODEL_ID).y(90))
                    .put("face=floor,facing=east,powered=true", new JBlockModel(PRESSED_MODEL_ID).y(90))
                    .put("face=floor,facing=north,powered=false", new JBlockModel(BASE_MODEL_ID))
                    .put("face=floor,facing=north,powered=true", new JBlockModel(PRESSED_MODEL_ID))
                    .put("face=floor,facing=south,powered=false", new JBlockModel(BASE_MODEL_ID).y(180))
                    .put("face=floor,facing=south,powered=true", new JBlockModel(PRESSED_MODEL_ID).y(180))
                    .put("face=floor,facing=west,powered=false", new JBlockModel(BASE_MODEL_ID).y(270))
                    .put("face=floor,facing=west,powered=true", new JBlockModel(PRESSED_MODEL_ID).y(270))
                    .put("face=wall,facing=east,powered=false", new JBlockModel(BASE_MODEL_ID).uvlock().x(90).y(90))
                    .put("face=wall,facing=east,powered=true", new JBlockModel(PRESSED_MODEL_ID).uvlock().x(90).y(90))
                    .put("face=wall,facing=north,powered=false", new JBlockModel(BASE_MODEL_ID).uvlock().x(90))
                    .put("face=wall,facing=north,powered=true", new JBlockModel(PRESSED_MODEL_ID).uvlock().x(90))
                    .put("face=wall,facing=south,powered=false", new JBlockModel(BASE_MODEL_ID).uvlock().x(90).y(180))
                    .put("face=wall,facing=south,powered=true", new JBlockModel(PRESSED_MODEL_ID).uvlock().x(90).y(180))
                    .put("face=wall,facing=west,powered=false", new JBlockModel(BASE_MODEL_ID).uvlock().x(90).y(270))
                    .put("face=wall,facing=west,powered=true", new JBlockModel(PRESSED_MODEL_ID).uvlock().x(90).y(270))
            ),
            getBlockID()
        );
    }

    public static class ButtonSettings extends MinekeaBlockSettings<ButtonSettings> {
        public ButtonSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Button");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sredstone/buttons/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
