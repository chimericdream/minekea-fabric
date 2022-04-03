package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.displaycases.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DisplayCases {
    public static final GenericDisplayCase ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase WARPED_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_WARPED_DISPLAY_CASE;

    public static BlockEntityType<AcaciaDisplayCaseBlockEntity> ACACIA_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedAcaciaDisplayCaseBlockEntity> STRIPPED_ACACIA_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<BirchDisplayCaseBlockEntity> BIRCH_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedBirchDisplayCaseBlockEntity> STRIPPED_BIRCH_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<CrimsonDisplayCaseBlockEntity> CRIMSON_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedCrimsonDisplayCaseBlockEntity> STRIPPED_CRIMSON_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<DarkOakDisplayCaseBlockEntity> DARK_OAK_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedDarkOakDisplayCaseBlockEntity> STRIPPED_DARK_OAK_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<JungleDisplayCaseBlockEntity> JUNGLE_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedJungleDisplayCaseBlockEntity> STRIPPED_JUNGLE_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<OakDisplayCaseBlockEntity> OAK_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedOakDisplayCaseBlockEntity> STRIPPED_OAK_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<SpruceDisplayCaseBlockEntity> SPRUCE_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedSpruceDisplayCaseBlockEntity> STRIPPED_SPRUCE_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<WarpedDisplayCaseBlockEntity> WARPED_DISPLAY_CASE_BLOCK_ENTITY;
    public static BlockEntityType<StrippedWarpedDisplayCaseBlockEntity> STRIPPED_WARPED_DISPLAY_CASE_BLOCK_ENTITY;

    static {
        ACACIA_DISPLAY_CASE = new AcaciaDisplayCase();
        STRIPPED_ACACIA_DISPLAY_CASE = new StrippedAcaciaDisplayCase();
        BIRCH_DISPLAY_CASE = new BirchDisplayCase();
        STRIPPED_BIRCH_DISPLAY_CASE = new StrippedBirchDisplayCase();
        CRIMSON_DISPLAY_CASE = new CrimsonDisplayCase();
        STRIPPED_CRIMSON_DISPLAY_CASE = new StrippedCrimsonDisplayCase();
        DARK_OAK_DISPLAY_CASE = new DarkOakDisplayCase();
        STRIPPED_DARK_OAK_DISPLAY_CASE = new StrippedDarkOakDisplayCase();
        JUNGLE_DISPLAY_CASE = new JungleDisplayCase();
        STRIPPED_JUNGLE_DISPLAY_CASE = new StrippedJungleDisplayCase();
        OAK_DISPLAY_CASE = new OakDisplayCase();
        STRIPPED_OAK_DISPLAY_CASE = new StrippedOakDisplayCase();
        SPRUCE_DISPLAY_CASE = new SpruceDisplayCase();
        STRIPPED_SPRUCE_DISPLAY_CASE = new StrippedSpruceDisplayCase();
        WARPED_DISPLAY_CASE = new WarpedDisplayCase();
        STRIPPED_WARPED_DISPLAY_CASE = new StrippedWarpedDisplayCase();
    }

    public void register() {
        ACACIA_DISPLAY_CASE.register();
        STRIPPED_ACACIA_DISPLAY_CASE.register();
        BIRCH_DISPLAY_CASE.register();
        STRIPPED_BIRCH_DISPLAY_CASE.register();
        CRIMSON_DISPLAY_CASE.register();
        STRIPPED_CRIMSON_DISPLAY_CASE.register();
        DARK_OAK_DISPLAY_CASE.register();
        STRIPPED_DARK_OAK_DISPLAY_CASE.register();
        JUNGLE_DISPLAY_CASE.register();
        STRIPPED_JUNGLE_DISPLAY_CASE.register();
        OAK_DISPLAY_CASE.register();
        STRIPPED_OAK_DISPLAY_CASE.register();
        SPRUCE_DISPLAY_CASE.register();
        STRIPPED_SPRUCE_DISPLAY_CASE.register();
        WARPED_DISPLAY_CASE.register();
        STRIPPED_WARPED_DISPLAY_CASE.register();

        ACACIA_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/acacia_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(AcaciaDisplayCaseBlockEntity::new, ACACIA_DISPLAY_CASE).build(null)
        );
        STRIPPED_ACACIA_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_acacia_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedAcaciaDisplayCaseBlockEntity::new, STRIPPED_ACACIA_DISPLAY_CASE).build(null)
        );
        BIRCH_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/birch_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(BirchDisplayCaseBlockEntity::new, BIRCH_DISPLAY_CASE).build(null)
        );
        STRIPPED_BIRCH_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_birch_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedBirchDisplayCaseBlockEntity::new, STRIPPED_BIRCH_DISPLAY_CASE).build(null)
        );
        CRIMSON_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/acacia_crimson_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(CrimsonDisplayCaseBlockEntity::new, CRIMSON_DISPLAY_CASE).build(null)
        );
        STRIPPED_CRIMSON_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_crimson_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedCrimsonDisplayCaseBlockEntity::new, STRIPPED_CRIMSON_DISPLAY_CASE).build(null)
        );
        DARK_OAK_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/dark_oak_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(DarkOakDisplayCaseBlockEntity::new, DARK_OAK_DISPLAY_CASE).build(null)
        );
        STRIPPED_DARK_OAK_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_dark_oak_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedDarkOakDisplayCaseBlockEntity::new, STRIPPED_DARK_OAK_DISPLAY_CASE).build(null)
        );
        JUNGLE_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/jungle_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(JungleDisplayCaseBlockEntity::new, JUNGLE_DISPLAY_CASE).build(null)
        );
        STRIPPED_JUNGLE_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_jungle_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedJungleDisplayCaseBlockEntity::new, STRIPPED_JUNGLE_DISPLAY_CASE).build(null)
        );
        OAK_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/oak_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(OakDisplayCaseBlockEntity::new, OAK_DISPLAY_CASE).build(null)
        );
        STRIPPED_OAK_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_oak_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedOakDisplayCaseBlockEntity::new, STRIPPED_OAK_DISPLAY_CASE).build(null)
        );
        SPRUCE_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/spruce_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(SpruceDisplayCaseBlockEntity::new, SPRUCE_DISPLAY_CASE).build(null)
        );
        STRIPPED_SPRUCE_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_spruce_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedSpruceDisplayCaseBlockEntity::new, STRIPPED_SPRUCE_DISPLAY_CASE).build(null)
        );
        WARPED_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/warped_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(WarpedDisplayCaseBlockEntity::new, WARPED_DISPLAY_CASE).build(null)
        );
        STRIPPED_WARPED_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/stripped_warped_display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(StrippedWarpedDisplayCaseBlockEntity::new, STRIPPED_WARPED_DISPLAY_CASE).build(null)
        );
    }
}
