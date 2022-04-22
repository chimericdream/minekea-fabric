package com.chimericdream.minekea;

import com.chimericdream.minekea.compat.ModCompatLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MinekeaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MinekeaMod.onInitializeClient();

        for (ModCompatLayer mod : MinekeaMod.OTHER_MODS) {
            mod.initializeClient();
        }
    }
}
