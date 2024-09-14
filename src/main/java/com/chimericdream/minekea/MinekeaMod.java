package com.chimericdream.minekea;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.crops.Crops;
import com.chimericdream.minekea.fluid.Fluids;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.item.ModItems;
import com.chimericdream.minekea.network.ServerNetworking;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinekeaMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final BuildingBlocks BUILDING_BLOCKS;
    public static final ContainerBlocks CONTAINER_BLOCKS;
    public static final Crops CROPS;
    public static final DecorationBlocks DECORATION_BLOCKS;
    public static final Fluids FLUIDS;
    public static final FurnitureBlocks FURNITURE_BLOCKS;

    public static final MinekeaBlockCategory[] BLOCK_CATEGORIES;

    public static final ModItems ITEMS;
    public static final MinekeaItemGroups ITEM_GROUPS;

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

        ITEMS = new ModItems();
        ITEM_GROUPS = new MinekeaItemGroups();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("[minekea] Initializing server networking");
        ServerNetworking.init();

        LOGGER.info("[minekea] Registering item groups");
        ITEM_GROUPS.register();

        LOGGER.info("[minekea] Registering blocks");
        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.registerBlocks();
        }

        LOGGER.info("[minekea] Registering entities");
        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.registerBlockEntities();
            category.registerEntities();
        }

//        LOGGER.info("[minekea] Registering villager points of interest");
//        MinekeaPointOfInterestTypes.init();

        LOGGER.info("[minekea] Registering items");
        ITEMS.register();

        LOGGER.info("[minekea] Registering colored blocks");
        registerVanillaColoredBlocks();
    }

    private void registerVanillaColoredBlocks() {
        ColoredBlocksRegistry.addBlock(Blocks.WHITE_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_CONCRETE, "minecraft:concrete", ColoredBlocksRegistry.BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_CONCRETE_POWDER, "minecraft:concrete_powder", ColoredBlocksRegistry.BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_WOOL, "minecraft:wool", ColoredBlocksRegistry.BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.NONE);
        ColoredBlocksRegistry.addBlock(Blocks.WHITE_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_TERRACOTTA, "minecraft:terracotta", ColoredBlocksRegistry.BlockColor.BLACK);

        ColoredBlocksRegistry.addBlock(Blocks.WHITE_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.WHITE);
        ColoredBlocksRegistry.addBlock(Blocks.ORANGE_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.ORANGE);
        ColoredBlocksRegistry.addBlock(Blocks.MAGENTA_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.MAGENTA);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_BLUE_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.YELLOW_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.YELLOW);
        ColoredBlocksRegistry.addBlock(Blocks.LIME_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.LIME);
        ColoredBlocksRegistry.addBlock(Blocks.PINK_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.PINK);
        ColoredBlocksRegistry.addBlock(Blocks.GRAY_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.LIGHT_GRAY_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
        ColoredBlocksRegistry.addBlock(Blocks.CYAN_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.CYAN);
        ColoredBlocksRegistry.addBlock(Blocks.PURPLE_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.PURPLE);
        ColoredBlocksRegistry.addBlock(Blocks.BLUE_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.BLUE);
        ColoredBlocksRegistry.addBlock(Blocks.BROWN_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.BROWN);
        ColoredBlocksRegistry.addBlock(Blocks.GREEN_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.GREEN);
        ColoredBlocksRegistry.addBlock(Blocks.RED_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.RED);
        ColoredBlocksRegistry.addBlock(Blocks.BLACK_STAINED_GLASS, "minecraft:stained_glass", ColoredBlocksRegistry.BlockColor.BLACK);
    }
}
