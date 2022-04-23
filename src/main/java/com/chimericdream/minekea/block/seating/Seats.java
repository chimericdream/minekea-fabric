package com.chimericdream.minekea.block.seating;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class Seats implements MinekeaBlockCategory {
    public static final GenericChair ACACIA_CHAIR;
    public static final GenericChair BIRCH_CHAIR;
    public static final GenericChair CRIMSON_CHAIR;
    public static final GenericChair DARK_OAK_CHAIR;
    public static final GenericChair JUNGLE_CHAIR;
    public static final GenericChair OAK_CHAIR;
    public static final GenericChair SPRUCE_CHAIR;
    public static final GenericChair WARPED_CHAIR;

    public static EntityType<SeatEntity> SEAT_ENTITY;

    static {
        ACACIA_CHAIR = new GenericChair(
            "acacia",
            Map.of(
                "planks", new Identifier("minecraft:acacia_planks"),
                "log", new Identifier("minecraft:acacia_log")
            )
        );
        BIRCH_CHAIR = new GenericChair(
            "birch",
            Map.of(
                "planks", new Identifier("minecraft:birch_planks"),
                "log", new Identifier("minecraft:birch_log")
            )
        );
        CRIMSON_CHAIR = new GenericChair(
            "crimson",
            Map.of(
                "planks", new Identifier("minecraft:crimson_planks"),
                "log", new Identifier("minecraft:crimson_stem")
            )
        );
        DARK_OAK_CHAIR = new GenericChair(
            "dark_oak",
            Map.of(
                "planks", new Identifier("minecraft:dark_oak_planks"),
                "log", new Identifier("minecraft:dark_oak_log")
            )
        );
        JUNGLE_CHAIR = new GenericChair(
            "jungle",
            Map.of(
                "planks", new Identifier("minecraft:jungle_planks"),
                "log", new Identifier("minecraft:jungle_log")
            )
        );
        OAK_CHAIR = new GenericChair(
            "oak",
            Map.of(
                "planks", new Identifier("minecraft:oak_planks"),
                "log", new Identifier("minecraft:oak_log")
            )
        );
        SPRUCE_CHAIR = new GenericChair(
            "spruce",
            Map.of(
                "planks", new Identifier("minecraft:spruce_planks"),
                "log", new Identifier("minecraft:spruce_log")
            )
        );
        WARPED_CHAIR = new GenericChair(
            "warped",
            Map.of(
                "planks", new Identifier("minecraft:warped_planks"),
                "log", new Identifier("minecraft:warped_stem")
            )
        );
    }

    public void register() {
        ACACIA_CHAIR.register();
        BIRCH_CHAIR.register();
        CRIMSON_CHAIR.register();
        DARK_OAK_CHAIR.register();
        JUNGLE_CHAIR.register();
        OAK_CHAIR.register();
        SPRUCE_CHAIR.register();
        WARPED_CHAIR.register();

        SEAT_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "seats/seat_entity"),
            FabricEntityTypeBuilder.<SeatEntity>create(SpawnGroup.MISC, SeatEntity::new).build()
        );
    }

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(SEAT_ENTITY, SeatEntity.EmptyRenderer::new);
    }
}
