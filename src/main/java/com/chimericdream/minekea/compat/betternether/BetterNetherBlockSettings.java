package com.chimericdream.minekea.compat.betternether;

import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class BetterNetherBlockSettings {
    public static DefaultSettings ANCHOR_TREE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("anchor_tree")
        .ingredientName("Anchor Tree")
        .materials(
            Map.of(
                "main", new Identifier("betternether:anchor_tree_planks"),
                "slab", new Identifier("betternether:anchor_tree_slab"),
                "log", new Identifier("betternether:anchor_tree_log"),
                "stripped_log", new Identifier("betternether:anchor_tree_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/anchor_tree_log_side"))
        .texture("stripped_log", new Identifier("betternether:block/anchor_tree_stripped_log_side_1"))
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

    public static DefaultSettings MUSHROOM_FIR = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("mushroom_fir")
        .ingredientName("Mushroom Fir")
        .materials(
            Map.of(
                "main", new Identifier("betternether:mushroom_fir_planks"),
                "slab", new Identifier("betternether:mushroom_fir_slab"),
                "log", new Identifier("betternether:mushroom_fir_log"),
                "stripped_log", new Identifier("betternether:mushroom_fir_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/mushroom_fir_stripped_log_side"))
        .texture("stripped_log", new Identifier("betternether:block/mushroom_fir_stripped_log_side"))
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

    public static DefaultSettings NETHER_REED = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("nether_reed")
        .ingredientName("Nether Reed")
        .materials(
            Map.of(
                "main", new Identifier("betternether:nether_reed_planks"),
                "slab", new Identifier("betternether:nether_reed_slab"),
                "log", new Identifier("betternether:nether_reed_roof"),
                "stripped_log", new Identifier("betternether:nether_reed_roof")
            )
        )
        .texture("planks", new Identifier("betternether:block/nether_reed_planks_side"))
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalBookshelfStairs()
        .withCrate()
        .withBookshelfDoor()
        .withBookshelf()
        .withDisplayCase()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withStorageBookshelf()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings NETHER_SAKURA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("nether_sakura")
        .ingredientName("Nether Sakura")
        .materials(
            Map.of(
                "main", new Identifier("betternether:nether_sakura_planks"),
                "slab", new Identifier("betternether:nether_sakura_slab"),
                "log", new Identifier("betternether:nether_sakura_log"),
                "stripped_log", new Identifier("betternether:nether_sakura_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/nether_sakura_log_side"))
        .texture("stripped_log", new Identifier("betternether:block/nether_sakura_stripped_log_side"))
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

    public static DefaultSettings RUBEUS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("rubeus")
        .ingredientName("Rubeus")
        .materials(
            Map.of(
                "main", new Identifier("betternether:rubeus_planks"),
                "slab", new Identifier("betternether:rubeus_slab"),
                "log", new Identifier("betternether:rubeus_log"),
                "stripped_log", new Identifier("betternether:stripped_rubeus_log")
            )
        )
        .texture("log", new Identifier("betternether:block/rubeus_log_side"))
        // Typo in actual BetterNether repo
        .texture("stripped_log", new Identifier("betternether:block/striped_rubeus_log_side"))
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

    public static DefaultSettings STALAGNATE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("stalagnate")
        .ingredientName("Stalagnate")
        .materials(
            Map.of(
                "main", new Identifier("betternether:stalagnate_planks"),
                "slab", new Identifier("betternether:stalagnate_slab"),
                "log", new Identifier("betternether:stalagnate_log"),
                "stripped_log", new Identifier("betternether:stalagnate_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/stalagnate_bark_side"))
        .texture("stripped_log", new Identifier("betternether:block/stalagnate_stripped_log_side"))
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

    public static DefaultSettings WART = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("wart")
        .ingredientName("Wart")
        .materials(
            Map.of(
                "main", new Identifier("betternether:wart_planks"),
                "slab", new Identifier("betternether:wart_slab"),
                "log", new Identifier("betternether:wart_log"),
                "stripped_log", new Identifier("betternether:wart_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/wart_bark"))
        .texture("stripped_log", new Identifier("betternether:block/wart_stripped_log_side"))
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

    public static DefaultSettings WILLOW = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("betternether")
        .wooden()
        .material("willow")
        .ingredientName("Willow")
        .materials(
            Map.of(
                "main", new Identifier("betternether:willow_planks"),
                "slab", new Identifier("betternether:willow_slab"),
                "log", new Identifier("betternether:willow_log"),
                "stripped_log", new Identifier("betternether:willow_stripped_log")
            )
        )
        .texture("log", new Identifier("betternether:block/willow_bark"))
        .texture("stripped_log", new Identifier("betternether:block/willow_stripped_log_side"))
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
        ANCHOR_TREE,
        MUSHROOM_FIR,
        NETHER_REED,
        NETHER_SAKURA,
        RUBEUS,
        STALAGNATE,
        WART,
        WILLOW
    );
}
