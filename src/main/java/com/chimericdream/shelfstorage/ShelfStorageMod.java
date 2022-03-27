package com.chimericdream.shelfstorage;

import com.chimericdream.shelfstorage.block.barrels.Barrels;
import com.chimericdream.shelfstorage.block.bookshelves.Bookshelves;
import com.chimericdream.shelfstorage.block.crates.Crates;
import com.chimericdream.shelfstorage.block.doors.Doors;
import com.chimericdream.shelfstorage.block.trapdoors.Trapdoors;
import com.chimericdream.shelfstorage.tag.ShelfStorageTags;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShelfStorageMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final Bookshelves BOOKSHELVES;
    public static final Doors DOORS;
    public static final Trapdoors TRAPDOORS;
    public static final Crates CRATES;
    public static final Barrels BARRELS;

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
        BOOKSHELVES = new Bookshelves();
        DOORS = new Doors();
        TRAPDOORS = new Trapdoors();
        CRATES = new Crates();
        BARRELS = new Barrels();
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
        LOGGER.info("Registering tags for Shelf Storage");
        ShelfStorageTags.init();

        LOGGER.info("Registering blocks for Shelf Storage");
        BOOKSHELVES.register();
        DOORS.register();
        TRAPDOORS.register();
        CRATES.register();
        BARRELS.register();
    }
}
