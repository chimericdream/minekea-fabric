package net.fabricmc.chimericdream;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.chimericdream.block.IronShelf;
import net.fabricmc.chimericdream.block.bookshelf.Bookshelves;
import net.fabricmc.chimericdream.tag.ShelfStorageTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShelfStorageMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final Bookshelves BOOKSHELVES;
    public static final IronShelf IRON_SHELF;

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
        BOOKSHELVES = new Bookshelves();
        IRON_SHELF = new IronShelf();
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
     * [ ] secret door bookshelves in all wood types
     * [ ] crates in all wood types
     * [ ] variant barrels
     * [ ] variant crafting tables
     * [ ] variant ladders
     * [ ] fake bookshelves in all wood types (look like bookshelf, tooltip says bookshelf, functions like a door)
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
        IRON_SHELF.register();
    }
}
