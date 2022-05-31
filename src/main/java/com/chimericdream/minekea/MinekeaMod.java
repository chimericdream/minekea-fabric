package com.chimericdream.minekea;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.client.Keybindings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.compat.byg.BygBlocks;
import com.chimericdream.minekea.crops.Crops;
import com.chimericdream.minekea.fluid.Fluids;
import com.chimericdream.minekea.item.Items;
import com.chimericdream.minekea.network.ServerNetworking;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry.BlockColor;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.tag.CommonBlockTags;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MinekeaMod implements ModInitializer {
    public static final Logger LOGGER;

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

    public static final Keybindings KEYBINDINGS;

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

        BUILDING_BLOCKS = new BuildingBlocks();
        CONTAINER_BLOCKS = new ContainerBlocks();
        CROPS = new Crops();
        DECORATION_BLOCKS = new DecorationBlocks();
        FLUIDS = new Fluids();
        FURNITURE_BLOCKS = new FurnitureBlocks();

        BLOCK_CATEGORIES = new MinekeaBlockCategory[]{
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

        KEYBINDINGS = new Keybindings();

        FabricLoader loader = FabricLoader.getInstance();

        if (loader.isModLoaded("byg")) {
            LOGGER.info("[minekea][compat] BYG detected! initializing mod compat layer");
            OTHER_MODS.add(new BygBlocks());
        }
    }

    @Override
    public void onInitialize() {
        LOGGER.info("[minekea] Initializing server networking");
        ServerNetworking.init();

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

        LOGGER.info("[minekea] Registering items");
        ITEMS.register();
        ITEMS.setupResources();

        LOGGER.info("[minekea] Registering colored blocks");
        registerVanillaColoredBlocks();

        LOGGER.info("[minekea] Registering dynamic resource pack");
        // This _must_ be the last thing
        RESOURCES.register();
    }

    private void registerVanillaColoredBlocks() {
        ColoredBlocksRegistry.addBlock(Blocks.WHITE_CONCRETE, "minecraft:concrete", BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_CONCRETE, "minecraft:concrete", BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_CONCRETE, "minecraft:concrete", BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_CONCRETE, "minecraft:concrete", BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_CONCRETE, "minecraft:concrete", BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_CONCRETE, "minecraft:concrete", BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_CONCRETE, "minecraft:concrete", BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_CONCRETE, "minecraft:concrete", BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_CONCRETE, "minecraft:concrete", BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_CONCRETE, "minecraft:concrete", BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_CONCRETE, "minecraft:concrete", BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_CONCRETE, "minecraft:concrete", BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_CONCRETE, "minecraft:concrete", BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_CONCRETE, "minecraft:concrete", BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_CONCRETE, "minecraft:concrete", BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_CONCRETE, "minecraft:concrete", BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_WOOL, "minecraft:wool", BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_WOOL, "minecraft:wool", BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_WOOL, "minecraft:wool", BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_WOOL, "minecraft:wool", BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_WOOL, "minecraft:wool", BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_WOOL, "minecraft:wool", BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_WOOL, "minecraft:wool", BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_WOOL, "minecraft:wool", BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_WOOL, "minecraft:wool", BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_WOOL, "minecraft:wool", BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_WOOL, "minecraft:wool", BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_WOOL, "minecraft:wool", BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_WOOL, "minecraft:wool", BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_WOOL, "minecraft:wool", BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_WOOL, "minecraft:wool", BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_WOOL, "minecraft:wool", BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.TERRACOTTA, "minecraft:terracotta", BlockColor.NONE);
        ColoredBlocksRegistry.addBlock(Blocks.WHITE_TERRACOTTA, "minecraft:terracotta", BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_TERRACOTTA, "minecraft:terracotta", BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_TERRACOTTA, "minecraft:terracotta", BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_TERRACOTTA, "minecraft:terracotta", BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_TERRACOTTA, "minecraft:terracotta", BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_TERRACOTTA, "minecraft:terracotta", BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_TERRACOTTA, "minecraft:terracotta", BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_TERRACOTTA, "minecraft:terracotta", BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_TERRACOTTA, "minecraft:terracotta", BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_TERRACOTTA, "minecraft:terracotta", BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_TERRACOTTA, "minecraft:terracotta", BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_TERRACOTTA, "minecraft:terracotta", BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_TERRACOTTA, "minecraft:terracotta", BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_TERRACOTTA, "minecraft:terracotta", BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_TERRACOTTA, "minecraft:terracotta", BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_TERRACOTTA, "minecraft:terracotta", BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_STAINED_GLASS, "minecraft:stained_glass", BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_STAINED_GLASS, "minecraft:stained_glass", BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_STAINED_GLASS, "minecraft:stained_glass", BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_STAINED_GLASS, "minecraft:stained_glass", BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_STAINED_GLASS, "minecraft:stained_glass", BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BLACK);
    }

    @Environment(EnvType.CLIENT)
    public static void onInitializeClient() {
        LOGGER.info("[minekea] Initializing client code");

        KEYBINDINGS.initialize();

        ITEMS.initializeClient();

        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.initializeClient();
        }
    }
}
