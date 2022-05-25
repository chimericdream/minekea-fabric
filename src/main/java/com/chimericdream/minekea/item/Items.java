package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.screen.item.BlockPainterScreen;
import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Items {
    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;

    static {
        PAINTER_ITEM = new PainterItem();
        WRENCH_ITEM = new WrenchItem();

        BLOCK_PAINTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
            new Identifier(ModInfo.MOD_ID, "screens/items/block_painter"),
            BlockPainterScreenHandler::new
        );
    }

    public void register() {
        PAINTER_ITEM.register();
        WRENCH_ITEM.register();
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
        ScreenRegistry.register(BLOCK_PAINTER_SCREEN_HANDLER, BlockPainterScreen::new);
    }
}
