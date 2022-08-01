package com.chimericdream.minekea.compat.betterend;

import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab;
import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.block.containers.crates.GenericCrate.CrateSettings;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericBookshelf;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.block.furniture.doors.GenericBookshelfDoor;
import com.chimericdream.minekea.block.furniture.seating.GenericChair;
import com.chimericdream.minekea.block.furniture.seating.GenericStool;
import com.chimericdream.minekea.block.furniture.shelves.GenericFloatingShelf;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf;
import com.chimericdream.minekea.block.furniture.tables.GenericTable;
import com.chimericdream.minekea.block.furniture.trapdoors.GenericBookshelfTrapdoor;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BetterEndBlocks implements ModCompatLayer {
    public static final Map<String, GenericBookshelfSlab> BOOKSHELF_SLABS = new LinkedHashMap<>();
    public static final Map<String, GenericBookshelfStairs> BOOKSHELF_STAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericVerticalBookshelfStairs> VERTICAL_BOOKSHELF_STAIRS = new LinkedHashMap<>();

    public static final Map<String, GenericCrate> CRATES = new LinkedHashMap<>();

    public static final Map<String, GenericBookshelfDoor> BOOKSHELF_DOORS = new LinkedHashMap<>();
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();
    public static final Map<String, GenericDisplayCase> DISPLAY_CASES = new LinkedHashMap<>();
    public static final Map<String, GenericChair> CHAIRS = new LinkedHashMap<>();
    public static final Map<String, GenericStool> STOOLS = new LinkedHashMap<>();
    public static final Map<String, GenericShelf> SHELVES = new LinkedHashMap<>();
    public static final Map<String, GenericFloatingShelf> FLOATING_SHELVES = new LinkedHashMap<>();
    public static final Map<String, GenericStorageBookshelf> STORAGE_BOOKSHELVES = new LinkedHashMap<>();
    public static final Map<String, GenericTable> TABLES = new LinkedHashMap<>();
    public static final Map<String, GenericBookshelfTrapdoor> BOOKSHELF_TRAPDOORS = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (MinekeaBlockSettings.DefaultSettings blockSettings : BetterEndBlockSettings.ALL_SETTINGS) {
            if (config.enableBookshelves && blockSettings.hasBookshelfSlab()) {
                BOOKSHELF_SLABS.put(
                    blockSettings.getMainMaterial(),
                    new GenericBookshelfSlab(
                        new GenericBookshelfSlab.BookshelfSlabSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                            .addMaterial("model", blockSettings.getBookshelfModel())
                    )
                );
            }

            if (config.enableBookshelves && blockSettings.hasBookshelfStairs()) {
                BOOKSHELF_STAIRS.put(
                    blockSettings.getMainMaterial(),
                    new GenericBookshelfStairs(
                        new GenericBookshelfStairs.BookshelfStairsSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                            .addMaterial("model", blockSettings.getBookshelfModel())
                    )
                );
            }

            if (config.enableBookshelves && blockSettings.hasVerticalBookshelfStairs()) {
                VERTICAL_BOOKSHELF_STAIRS.put(
                    blockSettings.getMainMaterial(),
                    new GenericVerticalBookshelfStairs(
                        new GenericVerticalBookshelfStairs.VerticalBookshelfStairsSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                            .addMaterial("model", blockSettings.getBookshelfModel())
                    )
                );
            }

            if (blockSettings.hasCrate()) {
                CRATES.put(blockSettings.getMainMaterial(), new GenericCrate(new CrateSettings(blockSettings)));
            }

            if (config.enableBookshelves && blockSettings.hasBookshelfDoor()) {
                BOOKSHELF_DOORS.put(
                    blockSettings.getMainMaterial(),
                    new GenericBookshelfDoor(
                        new GenericBookshelfDoor.BookshelfDoorSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                    )
                );
            }

            if (config.enableBookshelves && blockSettings.hasBookshelf()) {
                BOOKSHELVES.put(blockSettings.getMainMaterial(), new GenericBookshelf(new GenericBookshelf.BookshelfSettings(blockSettings)));
            }

            if (config.enableDisplayCases && blockSettings.hasDisplayCase()) {
                DISPLAY_CASES.put(blockSettings.getMainMaterial(), new GenericDisplayCase(new GenericDisplayCase.DisplayCaseSettings(blockSettings)));
            }

            if (config.enableDisplayCases && blockSettings.hasStrippedDisplayCase()) {
                DISPLAY_CASES.put("stripped_" + blockSettings.getMainMaterial(), new GenericDisplayCase(new GenericDisplayCase.DisplayCaseSettings(blockSettings).stripped()));
            }

            if (config.enableChairs && blockSettings.hasChair()) {
                CHAIRS.put(blockSettings.getMainMaterial(), new GenericChair(new GenericChair.ChairSettings(blockSettings)));
            }

            if (config.enableStools && blockSettings.hasStool()) {
                STOOLS.put(blockSettings.getMainMaterial(), new GenericStool(new GenericStool.StoolSettings(blockSettings)));
            }

            if (config.enableShelves && blockSettings.hasShelf()) {
                SHELVES.put(blockSettings.getMainMaterial(), new GenericShelf(new GenericShelf.SupportedShelfSettings(blockSettings)));
            }

            if (config.enableShelves && blockSettings.hasFloatingShelf()) {
                FLOATING_SHELVES.put(blockSettings.getMainMaterial(), new GenericFloatingShelf(new GenericFloatingShelf.FloatingShelfSettings(blockSettings)));
            }

            if (config.enableStorageBookshelves && blockSettings.hasStorageBookshelf()) {
                STORAGE_BOOKSHELVES.put(
                    blockSettings.getMainMaterial(),
                    new GenericStorageBookshelf(
                        new GenericStorageBookshelf.StorageBookshelfSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                    )
                );
            }

            if (config.enableTables && blockSettings.hasTable()) {
                TABLES.put(blockSettings.getMainMaterial(), new GenericTable(new GenericTable.TableSettings(blockSettings)));
            }

            if (config.enableBookshelves && blockSettings.hasBookshelfTrapdoor()) {
                BOOKSHELF_TRAPDOORS.put(
                    blockSettings.getMainMaterial(),
                    new GenericBookshelfTrapdoor(
                        new GenericBookshelfTrapdoor.BookshelfTrapdoorSettings(blockSettings)
                            .addMaterial("bookshelf", GenericBookshelf.BookshelfSettings.makeBlockId("betterend", blockSettings.getMainMaterial()))
                    )
                );
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (GenericBookshelfSlab block : BOOKSHELF_SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void register() {
        for (GenericBookshelfSlab block : BOOKSHELF_SLABS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelfStairs block : BOOKSHELF_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericVerticalBookshelfStairs block : VERTICAL_BOOKSHELF_STAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericCrate block : CRATES.values()) {
            block.register();
        }

        for (GenericBookshelfDoor block : BOOKSHELF_DOORS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelf block : BOOKSHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericDisplayCase block : DISPLAY_CASES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericChair block : CHAIRS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericStool block : STOOLS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericShelf block : SHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericFloatingShelf block : FLOATING_SHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericStorageBookshelf block : STORAGE_BOOKSHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericTable block : TABLES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericBookshelfTrapdoor block : BOOKSHELF_TRAPDOORS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public List<GenericCrate> getCrates() {
        return CRATES.values().stream().toList();
    }

    @Override
    public List<GenericDisplayCase> getDisplayCases() {
        return DISPLAY_CASES.values().stream().toList();
    }

    @Override
    public List<GenericShelf> getShelves() {
        List<GenericShelf> shelves = new ArrayList<>();

        shelves.addAll(SHELVES.values());
        shelves.addAll(FLOATING_SHELVES.values());

        return shelves;
    }

    @Override
    public List<GenericStorageBookshelf> getStorageShelves() {
        return STORAGE_BOOKSHELVES.values().stream().toList();
    }

    @Override
    public void setupResources() {
    }
}
