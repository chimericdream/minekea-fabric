package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.minekea.block.furniture.seating.GenericChair.ChairSettings;
import com.chimericdream.minekea.block.furniture.seating.GenericStool.StoolSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.mounts.SeatEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class Seats implements MinekeaBlockCategory {
    public static final GenericChair ACACIA_CHAIR;
    public static final GenericChair BIRCH_CHAIR;
    public static final GenericChair CRIMSON_CHAIR;
    public static final GenericChair DARK_OAK_CHAIR;
    public static final GenericChair JUNGLE_CHAIR;
    public static final GenericChair OAK_CHAIR;
    public static final GenericChair SPRUCE_CHAIR;
    public static final GenericChair WARPED_CHAIR;

    public static final GenericStool ACACIA_STOOL;
    public static final GenericStool BIRCH_STOOL;
    public static final GenericStool CRIMSON_STOOL;
    public static final GenericStool DARK_OAK_STOOL;
    public static final GenericStool JUNGLE_STOOL;
    public static final GenericStool OAK_STOOL;
    public static final GenericStool SPRUCE_STOOL;
    public static final GenericStool WARPED_STOOL;

    public static EntityType<SeatEntity> SEAT_ENTITY;

    static {
        ACACIA_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.ACACIA));
        BIRCH_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.BIRCH));
        CRIMSON_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.JUNGLE));
        OAK_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.OAK));
        SPRUCE_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.SPRUCE));
        WARPED_CHAIR = new GenericChair(new ChairSettings(BaseBlockSettings.WARPED));

        ACACIA_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.ACACIA));
        BIRCH_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.BIRCH));
        CRIMSON_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.JUNGLE));
        OAK_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.OAK));
        SPRUCE_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.SPRUCE));
        WARPED_STOOL = new GenericStool(new StoolSettings(BaseBlockSettings.WARPED));
    }

    @Override
    public void initializeClient() {
        EntityRendererRegistry.register(SEAT_ENTITY, SeatEntity.EmptyRenderer::new);
    }

    @Override
    public void registerBlocks() {
        ACACIA_CHAIR.register();
        BIRCH_CHAIR.register();
        CRIMSON_CHAIR.register();
        DARK_OAK_CHAIR.register();
        JUNGLE_CHAIR.register();
        OAK_CHAIR.register();
        SPRUCE_CHAIR.register();
        WARPED_CHAIR.register();

        ACACIA_STOOL.register();
        BIRCH_STOOL.register();
        CRIMSON_STOOL.register();
        DARK_OAK_STOOL.register();
        JUNGLE_STOOL.register();
        OAK_STOOL.register();
        SPRUCE_STOOL.register();
        WARPED_STOOL.register();

        SEAT_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            SeatEntity.ENTITY_ID,
            FabricEntityTypeBuilder.<SeatEntity>create(SpawnGroup.MISC, SeatEntity::new).build()
        );
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
