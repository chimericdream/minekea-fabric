package com.chimericdream.minekea;

import com.chimericdream.minekea.client.FluidClientHandlers;
import com.chimericdream.minekea.client.Keybindings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static com.chimericdream.minekea.MinekeaMod.*;

@Environment(EnvType.CLIENT)
public class MinekeaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("[minekea] Initializing client code");

        Keybindings.initialize();

        ITEMS.initializeClient();

        FluidClientHandlers.setupHandlers();

        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.initializeClient();
        }

        for (ModCompatLayer mod : MinekeaMod.OTHER_MODS) {
            mod.initializeClient();
        }
    }
}
