package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.block.containers.crates.GenericCrate.CrateSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Crates implements MinekeaBlockCategory {
    public static final GenericCrate ACACIA_CRATE;
    public static final GenericCrate BIRCH_CRATE;
    public static final GenericCrate CRIMSON_CRATE;
    public static final GenericCrate DARK_OAK_CRATE;
    public static final GenericCrate JUNGLE_CRATE;
    public static final GenericCrate OAK_CRATE;
    public static final GenericCrate SPRUCE_CRATE;
    public static final GenericCrate WARPED_CRATE;

    public static final List<GenericCrate> CRATES = new ArrayList<>();

    public static BlockEntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY;
    public static ScreenHandlerType<CrateScreenHandler> CRATE_SCREEN_HANDLER;

    static {
        ACACIA_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.ACACIA));
        BIRCH_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.BIRCH));
        CRIMSON_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.JUNGLE));
        OAK_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.OAK));
        SPRUCE_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.SPRUCE));
        WARPED_CRATE = new GenericCrate(new CrateSettings(BaseBlockSettings.WARPED));

        CRATES.addAll(List.of(
            ACACIA_CRATE,
            BIRCH_CRATE,
            CRIMSON_CRATE,
            DARK_OAK_CRATE,
            JUNGLE_CRATE,
            OAK_CRATE,
            SPRUCE_CRATE,
            WARPED_CRATE
        ));

        CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            CrateScreenHandler.SCREEN_ID,
            (syncId, inventory) -> new CrateScreenHandler(CRATE_SCREEN_HANDLER, syncId, inventory)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        ScreenRegistry.register(CRATE_SCREEN_HANDLER, CrateScreen::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericCrate crate : CRATES) {
            crate.register();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericCrate> crates = new ArrayList<>(CRATES);

        for (ModCompatLayer mod : otherMods) {
            crates.addAll(mod.getCrates());
        }

        CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            CrateBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                CrateBlockEntity::new,
                crates.toArray(new Block[0])
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
