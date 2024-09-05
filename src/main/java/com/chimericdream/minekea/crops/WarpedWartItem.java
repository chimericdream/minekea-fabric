package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WarpedWartItem extends AliasedBlockItem implements MinekeaItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "crops/warped_wart");

    public WarpedWartItem() {
        super(Crops.WARPED_WART_PLANT_BLOCK, new Item.Settings());
    }

    @Override
    public Identifier getItemID() {
        return ITEM_ID;
    }

    @Override
    public void register() {
        Registry.register(Registries.ITEM, ITEM_ID, this);
        setupResources();
    }

    @Override
    public void setupResources() {
    }
}
