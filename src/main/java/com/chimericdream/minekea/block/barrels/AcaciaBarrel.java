package com.chimericdream.minekea.block.barrels;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AcaciaBarrel extends GenericBarrel {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "barrels/acacia_barrel");
    public static final Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, "block/barrels/jungle_barrel");
    public static final Identifier OPEN_MODEL_ID = new Identifier(ModInfo.MOD_ID, "block/barrels/jungle_barrel_open");
    public static final String PLANK_MATERIAL = "minecraft:acacia_planks";
    public static final String SLAB_MATERIAL = "minecraft:acacia_slab";

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources(new Identifier[]{BLOCK_ID, MODEL_ID, OPEN_MODEL_ID}, new String[]{PLANK_MATERIAL, SLAB_MATERIAL});
    }
}
