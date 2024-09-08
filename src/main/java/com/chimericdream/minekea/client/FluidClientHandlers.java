package com.chimericdream.minekea.client;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static com.chimericdream.minekea.fluid.Fluids.FLOWING_HONEY;
import static com.chimericdream.minekea.fluid.Fluids.FLOWING_MILK;
import static com.chimericdream.minekea.fluid.Fluids.HONEY;
import static com.chimericdream.minekea.fluid.Fluids.MILK;

public class FluidClientHandlers {
    public static void setupHandlers() {
        setupMilkHandlers();
        setupHoneyHandlers();
    }

    private static void setupMilkHandlers() {
        FluidRenderHandlerRegistry.INSTANCE.register(MILK, FLOWING_MILK, new SimpleFluidRenderHandler(
            Identifier.of(ModInfo.MOD_ID, "block/fluids/milk"),
            Identifier.of(ModInfo.MOD_ID, "block/fluids/milk/flowing"),
            0xFFFFFF
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), MILK, FLOWING_MILK);
    }

    private static void setupHoneyHandlers() {
        FluidRenderHandlerRegistry.INSTANCE.register(HONEY, FLOWING_HONEY, new SimpleFluidRenderHandler(
            Identifier.of(ModInfo.MOD_ID, "block/fluids/honey"),
            Identifier.of(ModInfo.MOD_ID, "block/fluids/honey/flowing"),
            0xFFFFFF
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), HONEY, FLOWING_HONEY);
    }
}
