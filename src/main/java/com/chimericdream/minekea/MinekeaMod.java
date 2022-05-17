package com.chimericdream.minekea;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.compat.byg.BygBlocks;
import com.chimericdream.minekea.crops.Crops;
import com.chimericdream.minekea.fluid.Fluids;
import com.chimericdream.minekea.item.Items;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.tag.CommonBlockTags;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MinekeaMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final Bookshelves BOOKSHELVES;
    public static final BuildingBlocks BUILDING_BLOCKS;
    public static final ContainerBlocks CONTAINER_BLOCKS;
    public static final Crops CROPS;
    public static final DecorationBlocks DECORATION_BLOCKS;
    public static final Fluids FLUIDS;
    public static final FurnitureBlocks FURNITURE_BLOCKS;

    public static final MinekeaBlockCategory[] BLOCK_CATEGORIES;

    public static final Items ITEMS;

    public static final CommonBlockTags COMMON_TAGS;
    public static final MinekeaTags TAGS;
    public static final MinekeaResourcePack RESOURCES;
    public static final List<ModCompatLayer> OTHER_MODS = new ArrayList<>();

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

        BOOKSHELVES = new Bookshelves();
        BUILDING_BLOCKS = new BuildingBlocks();
        CONTAINER_BLOCKS = new ContainerBlocks();
        CROPS = new Crops();
        DECORATION_BLOCKS = new DecorationBlocks();
        FLUIDS = new Fluids();
        FURNITURE_BLOCKS = new FurnitureBlocks();

        BLOCK_CATEGORIES = new MinekeaBlockCategory[]{
            BOOKSHELVES,
            BUILDING_BLOCKS,
            CONTAINER_BLOCKS,
            CROPS,
            DECORATION_BLOCKS,
            FLUIDS,
            FURNITURE_BLOCKS
        };

        ITEMS = new Items();

        COMMON_TAGS = new CommonBlockTags();
        TAGS = new MinekeaTags();
        RESOURCES = new MinekeaResourcePack();

        FabricLoader loader = FabricLoader.getInstance();

        if (loader.isModLoaded("byg")) {
            LOGGER.info("[minekea][compat] BYG detected! initializing mod compat layer");
            OTHER_MODS.add(new BygBlocks());
        }
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
     * [ ] block covers (veneer/plate/"carpet")
     * [ ] iron shelves
     * [ ] variant crafting tables
     * [ ] variant ladders
     */

    @Override
    public void onInitialize() {
        LOGGER.info("[minekea] Registering block and item tags");
        COMMON_TAGS.init();
        TAGS.init();

        LOGGER.info("[minekea] Registering blocks");
        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.registerBlocks();
            category.setupResources();
        }

        for (ModCompatLayer mod : OTHER_MODS) {
            mod.register();
            mod.setupResources();
        }

        LOGGER.info("[minekea] Registering entities");
        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.registerBlockEntities(OTHER_MODS);
            category.registerEntities(OTHER_MODS);
        }

        ITEMS.register();

        // This _must_ be the last thing
        RESOURCES.register();
    }

    @Environment(EnvType.CLIENT)
    public static void onInitializeClient() {
        LOGGER.info("[minekea] Initializing client code");

        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.initializeClient();
        }
    }
}
