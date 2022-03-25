package net.fabricmc.chimericdream.block.crate;

import net.fabricmc.chimericdream.block.crate.entity.GenericCrateBlockEntity;
import net.fabricmc.chimericdream.screen.crate.CrateScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
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

    public static BlockEntityType<GenericCrateBlockEntity> CRATE_BLOCK_ENTITY;

    public static ScreenHandlerType<CrateScreenHandler> ACACIA_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> BIRCH_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> CRIMSON_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> DARK_OAK_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> JUNGLE_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> OAK_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> SPRUCE_CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<CrateScreenHandler> WARPED_CRATE_SCREEN_HANDLER;

    static {
        ACACIA_CRATE = new AcaciaCrate();
        BIRCH_CRATE = new BirchCrate();
        CRIMSON_CRATE = new CrimsonCrate();
        DARK_OAK_CRATE = new DarkOakCrate();
        JUNGLE_CRATE = new JungleCrate();
        OAK_CRATE = new OakCrate();
        SPRUCE_CRATE = new SpruceCrate();
        WARPED_CRATE = new WarpedCrate();

        ACACIA_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(ACACIA_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(ACACIA_CRATE_SCREEN_HANDLER, syncId, inventory));
        BIRCH_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BIRCH_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(BIRCH_CRATE_SCREEN_HANDLER, syncId, inventory));
        CRIMSON_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CRIMSON_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(CRIMSON_CRATE_SCREEN_HANDLER, syncId, inventory));
        DARK_OAK_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(DARK_OAK_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(DARK_OAK_CRATE_SCREEN_HANDLER, syncId, inventory));
        JUNGLE_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(JUNGLE_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(JUNGLE_CRATE_SCREEN_HANDLER, syncId, inventory));
        OAK_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(OAK_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(OAK_CRATE_SCREEN_HANDLER, syncId, inventory));
        SPRUCE_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SPRUCE_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(SPRUCE_CRATE_SCREEN_HANDLER, syncId, inventory));
        WARPED_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WARPED_CRATE.getBlockID(), (syncId, inventory) -> new CrateScreenHandler(WARPED_CRATE_SCREEN_HANDLER, syncId, inventory));
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
            "shelfstorage:crate_block_entity",
            FabricBlockEntityTypeBuilder.create(GenericCrateBlockEntity::new, BIRCH_CRATE, CRIMSON_CRATE, DARK_OAK_CRATE, JUNGLE_CRATE, OAK_CRATE, SPRUCE_CRATE, WARPED_CRATE).build(null)
        );
    }
}
