package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase.DisplayCaseSettings;
import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DisplayCases implements MinekeaBlockCategory {
    public static final Map<String, GenericDisplayCase> DISPLAY_CASES = new LinkedHashMap<>();

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasDisplayCase()) {
                DISPLAY_CASES.put(blockSettings.getMainMaterial(), new GenericDisplayCase(new DisplayCaseSettings(blockSettings)));
            }

            if (blockSettings.hasStrippedDisplayCase()) {
                DISPLAY_CASES.put("stripped_" + blockSettings.getMainMaterial(), new GenericDisplayCase(new DisplayCaseSettings(blockSettings).stripped()));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), DISPLAY_CASES.values().toArray(new Block[0]));
        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericDisplayCase block : DISPLAY_CASES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericDisplayCase> displayCases = new ArrayList<>(DISPLAY_CASES.values());

        for (ModCompatLayer mod : otherMods) {
            displayCases.addAll(mod.getDisplayCases());
        }

        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            DisplayCaseBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                DisplayCaseBlockEntity::new,
                displayCases.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
