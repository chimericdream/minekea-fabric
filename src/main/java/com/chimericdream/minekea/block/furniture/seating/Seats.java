package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.minekea.block.furniture.seating.GenericChair.ChairSettings;
import com.chimericdream.minekea.block.furniture.seating.GenericStool.StoolSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.entities.mounts.SeatEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Seats implements MinekeaBlockCategory {
    public static final Map<String, GenericChair> CHAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericStool> STOOLS = new LinkedHashMap<>();

    public static EntityType<SeatEntity> SEAT_ENTITY;

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasChair() && config.enableChairs) {
                CHAIRS.put(blockSettings.getMainMaterial(), new GenericChair(new ChairSettings(blockSettings)));
            }

            if (blockSettings.hasStool() && config.enableStools) {
                STOOLS.put(blockSettings.getMainMaterial(), new GenericStool(new StoolSettings(blockSettings)));
            }
        }
    }

    @Override
    public void initializeClient() {
        EntityRendererRegistry.register(SEAT_ENTITY, SeatEntity.EmptyRenderer::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericChair block : CHAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericStool block : STOOLS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

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
