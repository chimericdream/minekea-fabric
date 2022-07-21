package com.chimericdream.minekea.compat.betterend;

import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class BetterEndBlockSettings {
    public static DefaultSettings MOSSY_GLOWSHROOM = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("mossy_glowshroom")
        .ingredientName("Mossy Glowshroom")
        .materials(
            Map.of(
                "main", new Identifier("betterend:mossy_glowshroom_planks"),
                "slab", new Identifier("betterend:mossy_glowshroom_slab"),
                "log", new Identifier("betterend:mossy_glowshroom_log"),
                "stripped_log", new Identifier("betterend:mossy_glowshroom_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/mossy_glowshroom_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/mossy_glowshroom_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings PYTHADENDRON = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("pythadendron")
        .ingredientName("Pythadendron")
        .materials(
            Map.of(
                "main", new Identifier("betterend:pythadendron_planks"),
                "slab", new Identifier("betterend:pythadendron_slab"),
                "log", new Identifier("betterend:pythadendron_log"),
                "stripped_log", new Identifier("betterend:pythadendron_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/pythadendron_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/pythadendron_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings END_LOTUS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("end_lotus")
        .ingredientName("End Lotus")
        .materials(
            Map.of(
                "main", new Identifier("betterend:end_lotus_planks"),
                "slab", new Identifier("betterend:end_lotus_slab"),
                "log", new Identifier("betterend:end_lotus_log"),
                "stripped_log", new Identifier("betterend:end_lotus_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/end_lotus_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/end_lotus_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings LACUGROVE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("lacugrove")
        .ingredientName("Lacugrove")
        .materials(
            Map.of(
                "main", new Identifier("betterend:lacugrove_planks"),
                "slab", new Identifier("betterend:lacugrove_slab"),
                "log", new Identifier("betterend:lacugrove_log"),
                "stripped_log", new Identifier("betterend:lacugrove_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/lacugrove_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/lacugrove_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings DRAGON_TREE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("dragon_tree")
        .ingredientName("Dragon Tree")
        .materials(
            Map.of(
                "main", new Identifier("betterend:dragon_tree_planks"),
                "slab", new Identifier("betterend:dragon_tree_slab"),
                "log", new Identifier("betterend:dragon_tree_log"),
                "stripped_log", new Identifier("betterend:dragon_tree_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/dragon_tree_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/dragon_tree_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings TENANEA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("tenanea")
        .ingredientName("Tenanea")
        .materials(
            Map.of(
                "main", new Identifier("betterend:tenanea_planks"),
                "slab", new Identifier("betterend:tenanea_slab"),
                "log", new Identifier("betterend:tenanea_log"),
                "stripped_log", new Identifier("betterend:tenanea_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/tenanea_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/tenanea_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings HELIX_TREE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("helix_tree")
        .ingredientName("Helix Tree")
        .materials(
            Map.of(
                "main", new Identifier("betterend:helix_tree_planks"),
                "slab", new Identifier("betterend:helix_tree_slab"),
                "log", new Identifier("betterend:helix_tree_log"),
                "stripped_log", new Identifier("betterend:helix_tree_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/helix_tree_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/helix_tree_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings UMBRELLA_TREE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("umbrella_tree")
        .ingredientName("Umbrella Tree")
        .materials(
            Map.of(
                "main", new Identifier("betterend:umbrella_tree_planks"),
                "slab", new Identifier("betterend:umbrella_tree_slab"),
                "log", new Identifier("betterend:umbrella_tree_log"),
                "stripped_log", new Identifier("betterend:umbrella_tree_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/umbrella_tree_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/umbrella_tree_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings JELLYSHROOM = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("jellyshroom")
        .ingredientName("Jellyshroom")
        .materials(
            Map.of(
                "main", new Identifier("betterend:jellyshroom_planks"),
                "slab", new Identifier("betterend:jellyshroom_slab"),
                "log", new Identifier("betterend:jellyshroom_log"),
                "stripped_log", new Identifier("betterend:jellyshroom_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/jellyshroom_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/jellyshroom_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings LUCERNIA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betterend")
        .wooden()
        .material("lucernia")
        .ingredientName("Lucernia")
        .materials(
            Map.of(
                "main", new Identifier("betterend:lucernia_planks"),
                "slab", new Identifier("betterend:lucernia_slab"),
                "log", new Identifier("betterend:lucernia_log"),
                "stripped_log", new Identifier("betterend:lucernia_stripped_log")
            )
        )
        .texture("log", new Identifier("betterend:block/lucernia_log_side"))
        .texture("stripped_log", new Identifier("betterend:block/lucernia_stripped_log_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static final List<DefaultSettings> ALL_SETTINGS = List.of(
        MOSSY_GLOWSHROOM,
        PYTHADENDRON,
        END_LOTUS,
        LACUGROVE,
        DRAGON_TREE,
        TENANEA,
        HELIX_TREE,
        UMBRELLA_TREE,
        JELLYSHROOM,
        LUCERNIA
    );
}
