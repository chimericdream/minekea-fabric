package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.chimericdream.minekea.item.ItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class DisplayCases implements MinekeaBlockCategory {
    public static final GenericDisplayCase ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase CHERRY_DISPLAY_CASE;
    public static final GenericDisplayCase CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase OAK_DISPLAY_CASE;
    public static final GenericDisplayCase SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase WARPED_DISPLAY_CASE;

    public static final GenericDisplayCase STRIPPED_ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CHERRY_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_MANGROVE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_WARPED_DISPLAY_CASE;

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        ACACIA_DISPLAY_CASE = new AcaciaDisplayCase();
        BIRCH_DISPLAY_CASE = new BirchDisplayCase();
        CHERRY_DISPLAY_CASE = new CherryDisplayCase();
        CRIMSON_DISPLAY_CASE = new CrimsonDisplayCase();
        DARK_OAK_DISPLAY_CASE = new DarkOakDisplayCase();
        JUNGLE_DISPLAY_CASE = new JungleDisplayCase();
        MANGROVE_DISPLAY_CASE = new MangroveDisplayCase();
        OAK_DISPLAY_CASE = new OakDisplayCase();
        SPRUCE_DISPLAY_CASE = new SpruceDisplayCase();
        WARPED_DISPLAY_CASE = new WarpedDisplayCase();

        STRIPPED_ACACIA_DISPLAY_CASE = new StrippedAcaciaDisplayCase();
        STRIPPED_BIRCH_DISPLAY_CASE = new StrippedBirchDisplayCase();
        STRIPPED_CHERRY_DISPLAY_CASE = new StrippedCherryDisplayCase();
        STRIPPED_CRIMSON_DISPLAY_CASE = new StrippedCrimsonDisplayCase();
        STRIPPED_DARK_OAK_DISPLAY_CASE = new StrippedDarkOakDisplayCase();
        STRIPPED_JUNGLE_DISPLAY_CASE = new StrippedJungleDisplayCase();
        STRIPPED_MANGROVE_DISPLAY_CASE = new StrippedMangroveDisplayCase();
        STRIPPED_OAK_DISPLAY_CASE = new StrippedOakDisplayCase();
        STRIPPED_SPRUCE_DISPLAY_CASE = new StrippedSpruceDisplayCase();
        STRIPPED_WARPED_DISPLAY_CASE = new StrippedWarpedDisplayCase();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),
            ACACIA_DISPLAY_CASE,
            BIRCH_DISPLAY_CASE,
            CHERRY_DISPLAY_CASE,
            CRIMSON_DISPLAY_CASE,
            DARK_OAK_DISPLAY_CASE,
            JUNGLE_DISPLAY_CASE,
            MANGROVE_DISPLAY_CASE,
            OAK_DISPLAY_CASE,
            SPRUCE_DISPLAY_CASE,
            WARPED_DISPLAY_CASE,
            STRIPPED_ACACIA_DISPLAY_CASE,
            STRIPPED_BIRCH_DISPLAY_CASE,
            STRIPPED_CHERRY_DISPLAY_CASE,
            STRIPPED_CRIMSON_DISPLAY_CASE,
            STRIPPED_DARK_OAK_DISPLAY_CASE,
            STRIPPED_JUNGLE_DISPLAY_CASE,
            STRIPPED_MANGROVE_DISPLAY_CASE,
            STRIPPED_OAK_DISPLAY_CASE,
            STRIPPED_SPRUCE_DISPLAY_CASE,
            STRIPPED_WARPED_DISPLAY_CASE
        );

        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        ACACIA_DISPLAY_CASE.register();
        BIRCH_DISPLAY_CASE.register();
        CHERRY_DISPLAY_CASE.register();
        CRIMSON_DISPLAY_CASE.register();
        DARK_OAK_DISPLAY_CASE.register();
        JUNGLE_DISPLAY_CASE.register();
        MANGROVE_DISPLAY_CASE.register();
        OAK_DISPLAY_CASE.register();
        SPRUCE_DISPLAY_CASE.register();
        WARPED_DISPLAY_CASE.register();
        STRIPPED_ACACIA_DISPLAY_CASE.register();
        STRIPPED_BIRCH_DISPLAY_CASE.register();
        STRIPPED_CHERRY_DISPLAY_CASE.register();
        STRIPPED_CRIMSON_DISPLAY_CASE.register();
        STRIPPED_DARK_OAK_DISPLAY_CASE.register();
        STRIPPED_JUNGLE_DISPLAY_CASE.register();
        STRIPPED_MANGROVE_DISPLAY_CASE.register();
        STRIPPED_OAK_DISPLAY_CASE.register();
        STRIPPED_SPRUCE_DISPLAY_CASE.register();
        STRIPPED_WARPED_DISPLAY_CASE.register();

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ACACIA_DISPLAY_CASE);
            itemGroup.add(STRIPPED_ACACIA_DISPLAY_CASE);
            itemGroup.add(BIRCH_DISPLAY_CASE);
            itemGroup.add(STRIPPED_BIRCH_DISPLAY_CASE);
            itemGroup.add(CHERRY_DISPLAY_CASE);
            itemGroup.add(STRIPPED_CHERRY_DISPLAY_CASE);
            itemGroup.add(CRIMSON_DISPLAY_CASE);
            itemGroup.add(STRIPPED_CRIMSON_DISPLAY_CASE);
            itemGroup.add(DARK_OAK_DISPLAY_CASE);
            itemGroup.add(STRIPPED_DARK_OAK_DISPLAY_CASE);
            itemGroup.add(JUNGLE_DISPLAY_CASE);
            itemGroup.add(STRIPPED_JUNGLE_DISPLAY_CASE);
            itemGroup.add(MANGROVE_DISPLAY_CASE);
            itemGroup.add(STRIPPED_MANGROVE_DISPLAY_CASE);
            itemGroup.add(OAK_DISPLAY_CASE);
            itemGroup.add(STRIPPED_OAK_DISPLAY_CASE);
            itemGroup.add(SPRUCE_DISPLAY_CASE);
            itemGroup.add(STRIPPED_SPRUCE_DISPLAY_CASE);
            itemGroup.add(WARPED_DISPLAY_CASE);
            itemGroup.add(STRIPPED_WARPED_DISPLAY_CASE);
        });
    }

    @Override
    public void registerBlockEntities() {
        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            DisplayCaseBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                DisplayCaseBlockEntity::new,
                ACACIA_DISPLAY_CASE,
                BIRCH_DISPLAY_CASE,
                CHERRY_DISPLAY_CASE,
                CRIMSON_DISPLAY_CASE,
                DARK_OAK_DISPLAY_CASE,
                JUNGLE_DISPLAY_CASE,
                MANGROVE_DISPLAY_CASE,
                OAK_DISPLAY_CASE,
                SPRUCE_DISPLAY_CASE,
                WARPED_DISPLAY_CASE,
                STRIPPED_ACACIA_DISPLAY_CASE,
                STRIPPED_BIRCH_DISPLAY_CASE,
                STRIPPED_CHERRY_DISPLAY_CASE,
                STRIPPED_CRIMSON_DISPLAY_CASE,
                STRIPPED_DARK_OAK_DISPLAY_CASE,
                STRIPPED_JUNGLE_DISPLAY_CASE,
                STRIPPED_MANGROVE_DISPLAY_CASE,
                STRIPPED_OAK_DISPLAY_CASE,
                STRIPPED_SPRUCE_DISPLAY_CASE,
                STRIPPED_WARPED_DISPLAY_CASE
            ).build(null)
        );
    }
}
