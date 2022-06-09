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
import java.util.List;

public class DisplayCases implements MinekeaBlockCategory {
    public static final GenericDisplayCase ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase OAK_DISPLAY_CASE;
    public static final GenericDisplayCase SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase WARPED_DISPLAY_CASE;

    public static final GenericDisplayCase STRIPPED_ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_WARPED_DISPLAY_CASE;

    public static final List<GenericDisplayCase> DISPLAY_CASES = new ArrayList<>();

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        ACACIA_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.ACACIA));
        BIRCH_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.BIRCH));
        CRIMSON_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.JUNGLE));
        MANGROVE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.MANGROVE));
        OAK_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.OAK));
        SPRUCE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.SPRUCE));
        WARPED_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.WARPED));

        STRIPPED_ACACIA_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.ACACIA).stripped());
        STRIPPED_BIRCH_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.BIRCH).stripped());
        STRIPPED_CRIMSON_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.CRIMSON).stripped());
        STRIPPED_DARK_OAK_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.DARK_OAK).stripped());
        STRIPPED_JUNGLE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.JUNGLE).stripped());
        STRIPPED_MANGROVE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.MANGROVE).stripped());
        STRIPPED_OAK_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.OAK).stripped());
        STRIPPED_SPRUCE_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.SPRUCE).stripped());
        STRIPPED_WARPED_DISPLAY_CASE = new GenericDisplayCase(new DisplayCaseSettings(BaseBlockSettings.WARPED).stripped());

        DISPLAY_CASES.addAll(List.of(
            ACACIA_DISPLAY_CASE,
            BIRCH_DISPLAY_CASE,
            CRIMSON_DISPLAY_CASE,
            DARK_OAK_DISPLAY_CASE,
            JUNGLE_DISPLAY_CASE,
            MANGROVE_DISPLAY_CASE,
            OAK_DISPLAY_CASE,
            SPRUCE_DISPLAY_CASE,
            WARPED_DISPLAY_CASE,

            STRIPPED_ACACIA_DISPLAY_CASE,
            STRIPPED_BIRCH_DISPLAY_CASE,
            STRIPPED_CRIMSON_DISPLAY_CASE,
            STRIPPED_DARK_OAK_DISPLAY_CASE,
            STRIPPED_JUNGLE_DISPLAY_CASE,
            STRIPPED_MANGROVE_DISPLAY_CASE,
            STRIPPED_OAK_DISPLAY_CASE,
            STRIPPED_SPRUCE_DISPLAY_CASE,
            STRIPPED_WARPED_DISPLAY_CASE
        ));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (GenericDisplayCase block : DISPLAY_CASES) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericDisplayCase block : DISPLAY_CASES) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericDisplayCase> displayCases = new ArrayList<>(DISPLAY_CASES);

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
