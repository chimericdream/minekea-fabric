package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaItem;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PainterItem extends Item implements MinekeaItem {
    private final Identifier ITEM_ID;

    public PainterItem() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS));

        this.ITEM_ID = new Identifier(ModInfo.MOD_ID, "tools/painter");
    }

    @Override
    public Identifier getItemID() {
        return ITEM_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, ITEM_ID, Items.PAINTER_ITEM);
        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            ITEM_ID,
            JRecipe.shaped(
                JPattern.pattern(" NW", " SN", "S  "),
                JKeys.keys()
                    .key("N", JIngredient.ingredient().item(net.minecraft.item.Items.IRON_NUGGET))
                    .key("S", JIngredient.ingredient().item(net.minecraft.item.Items.STICK))
                    .key("W", JIngredient.ingredient().item(net.minecraft.item.Items.WHITE_WOOL)),
                JResult.result(ITEM_ID.toString())
            )
        );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        BlockPos pos = context.getBlockPos();
//        BlockState state = world.getBlockState(pos);
//
//        if (
//            context.getPlayer() == null
//                || world.isClient()
//                || state.getBlock() instanceof ChestBlock
//                || state.getBlock() instanceof BedBlock
//        ) {
//            return ActionResult.PASS;
//        }
        return ActionResult.PASS;
    }
}
