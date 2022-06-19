package com.chimericdream.minekea.item.currency;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaItem;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NuggetBag extends Item implements MinekeaItem {
    protected NuggetSettings settings;

    public NuggetBag(NuggetSettings settings) {
        super(settings);

        this.settings = settings;
    }

    @Override
    public Identifier getItemID() {
        return settings.getItemId();
    }

    @Override
    public void register() {
        // ignore me
    }

    public void register(NuggetBag self) {
        Registry.register(Registry.ITEM, getItemID(), self);
        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.itemRespect(
            this,
            String.format("%s Bag", Text.translatable(Registry.ITEM.get(settings.getIngredient()).getTranslationKey()).getString())
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getItemID(),
            JRecipe.shaped(
                JPattern.pattern("##", "##"),
                JKeys.keys().key("#", JIngredient.ingredient().item(settings.getIngredient().toString())),
                JResult.result(getItemID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(getItemID() + "_reverse"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(getItemID().toString())),
                JResult.stackedResult(settings.getIngredient().toString(), 4)
            )
        );
    }

    public static class NuggetSettings extends FabricItemSettings {
        private Identifier itemId;
        private final String material;
        private final Identifier ingredient;

        public NuggetSettings(String material, Identifier ingredient) {
            super();

            this.group(ItemGroup.MISC);

            this.material = material;
            this.ingredient = ingredient;
        }

        public String getMaterial() {
            return this.material;
        }

        public Identifier getIngredient() {
            return this.ingredient;
        }

        public Identifier getItemId() {
            if (itemId == null) {
                itemId = new Identifier(ModInfo.MOD_ID, String.format("currency/%s_nugget_bag", material));
            }

            return itemId;
        }
    }
}
