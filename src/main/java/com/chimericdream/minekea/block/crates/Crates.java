package com.chimericdream.minekea.block.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Crates {
    public static final GenericCrate ACACIA_CRATE;
    public static final GenericCrate BIRCH_CRATE;
    public static final GenericCrate CRIMSON_CRATE;
    public static final GenericCrate DARK_OAK_CRATE;
    public static final GenericCrate JUNGLE_CRATE;
    public static final GenericCrate OAK_CRATE;
    public static final GenericCrate SPRUCE_CRATE;
    public static final GenericCrate WARPED_CRATE;

    public static BlockEntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY;
    public static ScreenHandlerType<CrateScreenHandler> CRATE_SCREEN_HANDLER;

    static {
        ACACIA_CRATE = new GenericCrate(
            "acacia",
            new Identifier[]{new Identifier("minecraft:acacia_planks"), new Identifier("minecraft:acacia_log")}
        );
        BIRCH_CRATE = new GenericCrate(
            "birch",
            new Identifier[]{new Identifier("minecraft:birch_planks"), new Identifier("minecraft:birch_log")}
        );
        CRIMSON_CRATE = new GenericCrate(
            "crimson",
            new Identifier[]{new Identifier("minecraft:crimson_planks"), new Identifier("minecraft:crimson_stem")}
        );
        DARK_OAK_CRATE = new GenericCrate(
            "dark_oak",
            new Identifier[]{new Identifier("minecraft:dark_oak_planks"), new Identifier("minecraft:dark_oak_log")}
        );
        JUNGLE_CRATE = new GenericCrate(
            "jungle",
            new Identifier[]{new Identifier("minecraft:jungle_planks"), new Identifier("minecraft:jungle_log")}
        );
        OAK_CRATE = new GenericCrate(
            "oak",
            new Identifier[]{new Identifier("minecraft:oak_planks"), new Identifier("minecraft:oak_log")}
        );
        SPRUCE_CRATE = new GenericCrate(
            "spruce",
            new Identifier[]{new Identifier("minecraft:spruce_planks"), new Identifier("minecraft:spruce_log")}
        );
        WARPED_CRATE = new GenericCrate(
            "warped",
            new Identifier[]{new Identifier("minecraft:warped_planks"), new Identifier("minecraft:warped_stem")}
        );

        CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            ACACIA_CRATE.getBlockID(),
            (syncId, inventory) -> new CrateScreenHandler(CRATE_SCREEN_HANDLER, syncId, inventory)
        );
    }

    public void register() {
        ACACIA_CRATE.register();
        BIRCH_CRATE.register();
        CRIMSON_CRATE.register();
        DARK_OAK_CRATE.register();
        JUNGLE_CRATE.register();
        OAK_CRATE.register();
        SPRUCE_CRATE.register();
        WARPED_CRATE.register();

        CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "crates/crate_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                CrateBlockEntity::new,
                ACACIA_CRATE,
                BIRCH_CRATE,
                CRIMSON_CRATE,
                DARK_OAK_CRATE,
                JUNGLE_CRATE,
                OAK_CRATE,
                SPRUCE_CRATE,
                WARPED_CRATE
            ).build(null)
        );
    }
}
