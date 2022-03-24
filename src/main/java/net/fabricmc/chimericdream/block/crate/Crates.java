package net.fabricmc.chimericdream.block.crate;

import net.fabricmc.chimericdream.block.crate.entity.*;
import net.fabricmc.chimericdream.screen.crate.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

public class Crates {
    public static final AbstractCrate ACACIA_CRATE;
    public static final AbstractCrate BIRCH_CRATE;
    public static final AbstractCrate CRIMSON_CRATE;
    public static final AbstractCrate DARK_OAK_CRATE;
    public static final AbstractCrate JUNGLE_CRATE;
    public static final AbstractCrate OAK_CRATE;
    public static final AbstractCrate SPRUCE_CRATE;
    public static final AbstractCrate WARPED_CRATE;

    public static BlockEntityType<AcaciaCrateBlockEntity> ACACIA_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<BirchCrateBlockEntity> BIRCH_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<CrimsonCrateBlockEntity> CRIMSON_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<DarkOakCrateBlockEntity> DARK_OAK_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<JungleCrateBlockEntity> JUNGLE_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<OakCrateBlockEntity> OAK_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<SpruceCrateBlockEntity> SPRUCE_CRATE_BLOCK_ENTITY;
    public static BlockEntityType<WarpedCrateBlockEntity> WARPED_CRATE_BLOCK_ENTITY;

    public static ScreenHandlerType<AcaciaCrateScreenHandler> ACACIA_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<BirchCrateScreenHandler> BIRCH_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrimsonCrateScreenHandler> CRIMSON_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<DarkOakCrateScreenHandler> DARK_OAK_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<JungleCrateScreenHandler> JUNGLE_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<OakCrateScreenHandler> OAK_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<SpruceCrateScreenHandler> SPRUCE_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<WarpedCrateScreenHandler> WARPED_CRATE_SCREEN_HANDLER;

    static {
        ACACIA_CRATE = new AcaciaCrate();
        BIRCH_CRATE = new BirchCrate();
        CRIMSON_CRATE = new CrimsonCrate();
        DARK_OAK_CRATE = new DarkOakCrate();
        JUNGLE_CRATE = new JungleCrate();
        OAK_CRATE = new OakCrate();
        SPRUCE_CRATE = new SpruceCrate();
        WARPED_CRATE = new WarpedCrate();

        ACACIA_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(AcaciaCrate.BLOCK_ID, AcaciaCrateScreenHandler::new);
        BIRCH_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BirchCrate.BLOCK_ID, BirchCrateScreenHandler::new);
        CRIMSON_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CrimsonCrate.BLOCK_ID, CrimsonCrateScreenHandler::new);
        DARK_OAK_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(DarkOakCrate.BLOCK_ID, DarkOakCrateScreenHandler::new);
        JUNGLE_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(JungleCrate.BLOCK_ID, JungleCrateScreenHandler::new);
        OAK_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(OakCrate.BLOCK_ID, OakCrateScreenHandler::new);
        SPRUCE_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SpruceCrate.BLOCK_ID, SpruceCrateScreenHandler::new);
        WARPED_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WarpedCrate.BLOCK_ID, WarpedCrateScreenHandler::new);
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

        ACACIA_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:acacia_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(AcaciaCrateBlockEntity::new, ACACIA_CRATE).build(null)
        );
        BIRCH_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:birch_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(BirchCrateBlockEntity::new, BIRCH_CRATE).build(null)
        );
        CRIMSON_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:crimson_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(CrimsonCrateBlockEntity::new, CRIMSON_CRATE).build(null)
        );
        DARK_OAK_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:dark_oak_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(DarkOakCrateBlockEntity::new, DARK_OAK_CRATE).build(null)
        );
        JUNGLE_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:jungle_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(JungleCrateBlockEntity::new, JUNGLE_CRATE).build(null)
        );
        OAK_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:oak_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(OakCrateBlockEntity::new, OAK_CRATE).build(null)
        );
        SPRUCE_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:spruce_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(SpruceCrateBlockEntity::new, SPRUCE_CRATE).build(null)
        );
        WARPED_CRATE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:wearped_crate_block_entity",
            FabricBlockEntityTypeBuilder.create(WarpedCrateBlockEntity::new, WARPED_CRATE).build(null)
        );
    }
}
