package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.currency.NuggetBag;
import com.chimericdream.minekea.item.currency.NuggetBag.NuggetSettings;
import com.chimericdream.minekea.item.tools.PainterItem;
import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.screen.item.BlockPainterScreen;
import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Items {
    public static final NuggetBag GOLD_NUGGET_BAG;
    public static final NuggetBag IRON_NUGGET_BAG;
    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;

    static {
        GOLD_NUGGET_BAG = new NuggetBag(new NuggetSettings("gold", new Identifier("minecraft:gold_nugget")));
        IRON_NUGGET_BAG = new NuggetBag(new NuggetSettings("iron", new Identifier("minecraft:iron_nugget")));
        PAINTER_ITEM = new PainterItem();
        WRENCH_ITEM = new WrenchItem();

        BLOCK_PAINTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
            new Identifier(ModInfo.MOD_ID, "screens/items/block_painter"),
            BlockPainterScreenHandler::new
        );
    }

    public void register() {
        GOLD_NUGGET_BAG.register(GOLD_NUGGET_BAG);
        IRON_NUGGET_BAG.register(IRON_NUGGET_BAG);
        PAINTER_ITEM.register();
        WRENCH_ITEM.register();
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
        ScreenRegistry.register(BLOCK_PAINTER_SCREEN_HANDLER, BlockPainterScreen::new);
    }

    public void setupResources() {
        MinekeaResourcePack.EN_US.entry("category.minekea", "Minekea");
    }
}
