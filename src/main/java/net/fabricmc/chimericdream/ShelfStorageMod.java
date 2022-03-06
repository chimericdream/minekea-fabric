package net.fabricmc.chimericdream;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.chimericdream.block.bookshelf.*;
import net.fabricmc.chimericdream.tag.ShelfStorageTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShelfStorageMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	public static final Bookshelves BOOKSHELVES = new Bookshelves();

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
	 * [ ] empty bookshelves in all wood types (no storage, just shelves without books)
	 * [ ] storage version of all bookshelves
	 * [ ]   - works for enchanting (variable power based on contents)
	 * [ ] crates in all wood types
	 * [ ] variant barrels
	 * [ ] variant crafting tables
	 * [ ] variant ladders
	 * [ ] fake bookshelves in all wood types (look like bookshelf, tooltip says bookshelf, functions like a door)
	 * [ ] bookshelves in non-wood varieties
	 * [ ]   - quartz
	 * [ ]   - stone bricks
	 * [ ]   - polished stones
	 * [ ]   - purpur
	 * [ ]   - bone
	 * [ ]   - prismarine & dark prismarine
	 */

	@Override
	public void onInitialize() {
		LOGGER.info("Registering tags for Shelf Storage");
		ShelfStorageTags.init();

		LOGGER.info("Registering blocks for Shelf Storage");
		BOOKSHELVES.register();
	}
}
