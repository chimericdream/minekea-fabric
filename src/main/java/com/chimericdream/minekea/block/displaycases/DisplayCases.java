package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DisplayCases {
    public static final GenericDisplayCase ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase OAK_DISPLAY_CASE;
    public static final GenericDisplayCase SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase WARPED_DISPLAY_CASE;

    public static final GenericDisplayCase STRIPPED_ACACIA_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_BIRCH_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_CRIMSON_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_DARK_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_JUNGLE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_OAK_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_SPRUCE_DISPLAY_CASE;
    public static final GenericDisplayCase STRIPPED_WARPED_DISPLAY_CASE;

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        ACACIA_DISPLAY_CASE = new GenericDisplayCase(
            "acacia",
            new Identifier[]{new Identifier("minecraft:acacia_planks"), new Identifier("minecraft:acacia_log")}
        );
        BIRCH_DISPLAY_CASE = new GenericDisplayCase(
            "birch",
            new Identifier[]{new Identifier("minecraft:birch_planks"), new Identifier("minecraft:birch_log")}
        );
        CRIMSON_DISPLAY_CASE = new GenericDisplayCase(
            "crimson",
            new Identifier[]{new Identifier("minecraft:crimson_planks"), new Identifier("minecraft:crimson_stem")}
        );
        DARK_OAK_DISPLAY_CASE = new GenericDisplayCase(
            "dark_oak",
            new Identifier[]{new Identifier("minecraft:dark_oak_planks"), new Identifier("minecraft:dark_oak_log")}
        );
        JUNGLE_DISPLAY_CASE = new GenericDisplayCase(
            "jungle",
            new Identifier[]{new Identifier("minecraft:jungle_planks"), new Identifier("minecraft:jungle_log")}
        );
        OAK_DISPLAY_CASE = new GenericDisplayCase(
            "oak",
            new Identifier[]{new Identifier("minecraft:oak_planks"), new Identifier("minecraft:oak_log")}
        );
        SPRUCE_DISPLAY_CASE = new GenericDisplayCase(
            "spruce",
            new Identifier[]{new Identifier("minecraft:spruce_planks"), new Identifier("minecraft:spruce_log")}
        );
        WARPED_DISPLAY_CASE = new GenericDisplayCase(
            "warped",
            new Identifier[]{new Identifier("minecraft:warped_planks"), new Identifier("minecraft:warped_stem")}
        );

        STRIPPED_ACACIA_DISPLAY_CASE = new GenericDisplayCase(
            "acacia",
            new Identifier[]{new Identifier("minecraft:acacia_planks"), new Identifier("minecraft:stripped_acacia_log")},
            true
        );
        STRIPPED_BIRCH_DISPLAY_CASE = new GenericDisplayCase(
            "birch",
            new Identifier[]{new Identifier("minecraft:birch_planks"), new Identifier("minecraft:stripped_birch_log")},
            true
        );
        STRIPPED_CRIMSON_DISPLAY_CASE = new GenericDisplayCase(
            "crimson",
            new Identifier[]{new Identifier("minecraft:crimson_planks"), new Identifier("minecraft:stripped_crimson_stem")},
            true
        );
        STRIPPED_DARK_OAK_DISPLAY_CASE = new GenericDisplayCase(
            "dark_oak",
            new Identifier[]{new Identifier("minecraft:dark_oak_planks"), new Identifier("minecraft:stripped_dark_oak_log")},
            true
        );
        STRIPPED_JUNGLE_DISPLAY_CASE = new GenericDisplayCase(
            "jungle",
            new Identifier[]{new Identifier("minecraft:jungle_planks"), new Identifier("minecraft:stripped_jungle_log")},
            true
        );
        STRIPPED_OAK_DISPLAY_CASE = new GenericDisplayCase(
            "oak",
            new Identifier[]{new Identifier("minecraft:oak_planks"), new Identifier("minecraft:stripped_oak_log")},
            true
        );
        STRIPPED_SPRUCE_DISPLAY_CASE = new GenericDisplayCase(
            "spruce",
            new Identifier[]{new Identifier("minecraft:spruce_planks"), new Identifier("minecraft:stripped_spruce_log")},
            true
        );
        STRIPPED_WARPED_DISPLAY_CASE = new GenericDisplayCase(
            "warped",
            new Identifier[]{new Identifier("minecraft:warped_planks"), new Identifier("minecraft:stripped_warped_stem")},
            true
        );
    }

    public void register() {
        ACACIA_DISPLAY_CASE.register();
        BIRCH_DISPLAY_CASE.register();
        CRIMSON_DISPLAY_CASE.register();
        DARK_OAK_DISPLAY_CASE.register();
        JUNGLE_DISPLAY_CASE.register();
        OAK_DISPLAY_CASE.register();
        SPRUCE_DISPLAY_CASE.register();
        WARPED_DISPLAY_CASE.register();

        STRIPPED_ACACIA_DISPLAY_CASE.register();
        STRIPPED_BIRCH_DISPLAY_CASE.register();
        STRIPPED_CRIMSON_DISPLAY_CASE.register();
        STRIPPED_DARK_OAK_DISPLAY_CASE.register();
        STRIPPED_JUNGLE_DISPLAY_CASE.register();
        STRIPPED_OAK_DISPLAY_CASE.register();
        STRIPPED_SPRUCE_DISPLAY_CASE.register();
        STRIPPED_WARPED_DISPLAY_CASE.register();

        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "displaycases/display_case_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                DisplayCaseBlockEntity::new,
                ACACIA_DISPLAY_CASE,
                BIRCH_DISPLAY_CASE,
                CRIMSON_DISPLAY_CASE,
                DARK_OAK_DISPLAY_CASE,
                JUNGLE_DISPLAY_CASE,
                OAK_DISPLAY_CASE,
                SPRUCE_DISPLAY_CASE,
                WARPED_DISPLAY_CASE,
                STRIPPED_ACACIA_DISPLAY_CASE,
                STRIPPED_BIRCH_DISPLAY_CASE,
                STRIPPED_CRIMSON_DISPLAY_CASE,
                STRIPPED_DARK_OAK_DISPLAY_CASE,
                STRIPPED_JUNGLE_DISPLAY_CASE,
                STRIPPED_OAK_DISPLAY_CASE,
                STRIPPED_SPRUCE_DISPLAY_CASE,
                STRIPPED_WARPED_DISPLAY_CASE
            ).build(null)
        );
    }
}
