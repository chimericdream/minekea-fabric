package com.chimericdream.minekea;

import com.chimericdream.minekea.block.barrels.Barrels;
import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.crates.Crates;
import com.chimericdream.minekea.block.displaycases.DisplayCases;
import com.chimericdream.minekea.block.doors.Doors;
import com.chimericdream.minekea.block.slabs.BookshelfSlabs;
import com.chimericdream.minekea.block.stairs.BookshelfStairs;
import com.chimericdream.minekea.block.trapdoors.Trapdoors;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.tag.MinekeaTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MinekeaMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final Bookshelves BOOKSHELVES;
    public static final Doors DOORS;
    public static final Trapdoors TRAPDOORS;
    public static final Crates CRATES;
    public static final Barrels BARRELS;
    public static final DisplayCases DISPLAY_CASES;
    public static final BookshelfStairs BOOKSHELF_STAIRS;
    public static final BookshelfSlabs BOOKSHELF_SLABS;

    public static final MinekeaResourcePack RESOURCES;
    public static final List<ModCompatLayer> OTHER_MODS = new ArrayList<>();

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
        BOOKSHELVES = new Bookshelves();
        DOORS = new Doors();
        TRAPDOORS = new Trapdoors();
        CRATES = new Crates();
        BARRELS = new Barrels();
        DISPLAY_CASES = new DisplayCases();
        BOOKSHELF_STAIRS = new BookshelfStairs();
        BOOKSHELF_SLABS = new BookshelfSlabs();

        RESOURCES = new MinekeaResourcePack();
    }

    /*
     * Inspiration:
     * https://www.curseforge.com/minecraft/mc-mods/bookshelving
     * https://www.curseforge.com/minecraft/mc-mods/market-crates
     * https://www.curseforge.com/minecraft/mc-mods/secret-bookshelf
     * https://www.curseforge.com/minecraft/mc-mods/giacomos-bookshelf
     * https://www.curseforge.com/minecraft/mc-mods/bookinit
     * https://www.curseforge.com/minecraft/mc-mods/beholders-bookshelves
     *
     * [ ] iron shelves
     * [x] variant bookshelves
     * [x]   - works for enchanting
     * [x] storage version of all bookshelves
     * [x]   - works for enchanting
     * [ ]   - works for enchanting (variable power based on contents)
     * [x] secret door bookshelves in all wood types
     * [x] crates in all wood types
     * [x] variant barrels
     * [ ] variant crafting tables
     * [ ] variant ladders
     * [ ] bookshelves in non-wood varieties
     * [ ]   - quartz
     * [ ]   - smooth quartz
     * [ ]   - smooth stone
     * [ ]   - polished granite
     * [ ]   - polished andesite
     * [ ]   - polished diorite
     * [ ]   - polished blackstone
     * [ ]   - polished blackstone bricks
     * [ ]   - polished deepslate
     * [ ]   - polished basalt
     * [ ]   - stone bricks
     * [ ]   - deepslate bricks
     * [ ]   - endstone bricks
     * [ ]   - nether bricks
     * [ ]   - red nether bricks
     * [ ]   - prismarine bricks
     * [ ]   - quartz bricks
     * [ ]   - purpur
     * [ ]   - bone
     * [ ]   - prismarine
     * [ ]   - dark prismarine
     */

    @Override
    public void onInitialize() {
        LOGGER.info("[minekea] Registering block and item tags");
        MinekeaTags.init();

        LOGGER.info("[minekea] Registering blocks");
        BOOKSHELVES.register();
        DOORS.register();
        TRAPDOORS.register();
        CRATES.register();
        BARRELS.register();
        DISPLAY_CASES.register();
        BOOKSHELF_STAIRS.register();
        BOOKSHELF_SLABS.register();

        for (ModCompatLayer mod : OTHER_MODS) {
            mod.register();
        }

        // This must be the last thing
        RESOURCES.register();
    }
}
