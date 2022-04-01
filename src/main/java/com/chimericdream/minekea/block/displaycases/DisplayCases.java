package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.displaycases.entity.GenericDisplayCaseBlockEntity;
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

    public static BlockEntityType<GenericDisplayCaseBlockEntity> ACACIA_DISPLAY_CASE_BLOCK_ENTITY;

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

        ACACIA_DISPLAY_CASE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "displaycases/acacia_display_case_block_entity"), FabricBlockEntityTypeBuilder.create(GenericDisplayCaseBlockEntity::new, ACACIA_DISPLAY_CASE).build(null));
    }
}
