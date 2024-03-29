package com.chimericdream.minekea;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.block.redstone.RedstoneBlocks;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.compat.PatchouliCompat;
import com.chimericdream.minekea.compat.betterend.BetterEndBlocks;
import com.chimericdream.minekea.compat.betternether.BetterNetherBlocks;
import com.chimericdream.minekea.compat.byg.BygBlocks;
import com.chimericdream.minekea.compat.mythicmetals.MythicMetalsBlocks;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.crops.Crops;
import com.chimericdream.minekea.fluid.Fluids;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.item.Items;
import com.chimericdream.minekea.network.ServerNetworking;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry.BlockColor;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.tag.CommonBlockTags;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.world.poi.MinekeaPointOfInterestTypes;
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
    public static final RedstoneBlocks REDSTONE_BLOCKS;

    public static final MinekeaBlockCategory[] BLOCK_CATEGORIES;

    public static final Items ITEMS;
    public static final ItemGroups ITEM_GROUPS;

    public static final CommonBlockTags COMMON_TAGS;
    public static final MinekeaTags TAGS;
    public static final MinekeaResourcePack RESOURCES;

    public static final List<ModCompatLayer> OTHER_MODS = new ArrayList<>();

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

        LOGGER.info("[minekea] Registering auto-config");
        ConfigManager.registerAutoConfig();

        BUILDING_BLOCKS = new BuildingBlocks();
        CONTAINER_BLOCKS = new ContainerBlocks();
        CROPS = new Crops();
        DECORATION_BLOCKS = new DecorationBlocks();
        FLUIDS = new Fluids();
        FURNITURE_BLOCKS = new FurnitureBlocks();
        REDSTONE_BLOCKS = new RedstoneBlocks();

        BLOCK_CATEGORIES = new MinekeaBlockCategory[]{
            BUILDING_BLOCKS,
            CONTAINER_BLOCKS,
            CROPS,
            DECORATION_BLOCKS,
            FLUIDS,
            FURNITURE_BLOCKS,
            REDSTONE_BLOCKS
        };

        ITEMS = new Items();
        ITEM_GROUPS = new ItemGroups();

        COMMON_TAGS = new CommonBlockTags();
        TAGS = new MinekeaTags();
        RESOURCES = new MinekeaResourcePack();

        FabricLoader loader = FabricLoader.getInstance();

        if (loader.isModLoaded("betterend")) {
            LOGGER.info("[minekea][compat] BetterEnd detected! initializing mod compat layer");
            OTHER_MODS.add(new BetterEndBlocks());
        }

        if (loader.isModLoaded("betternether")) {
            LOGGER.info("[minekea][compat] BetterNether detected! initializing mod compat layer");
            OTHER_MODS.add(new BetterNetherBlocks());
        }

        if (loader.isModLoaded("byg")) {
            LOGGER.info("[minekea][compat] BYG detected! initializing mod compat layer");
            OTHER_MODS.add(new BygBlocks());
        }

        if (loader.isModLoaded("mythicmetals")) {
            LOGGER.info("[minekea][compat] Mythic Metals detected! initializing mod compat layer");
            OTHER_MODS.add(new MythicMetalsBlocks());
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

        LOGGER.info("[minekea] Registering villager points of interest");
        MinekeaPointOfInterestTypes.init();

        LOGGER.info("[minekea] Registering entities");
        for (MinekeaBlockCategory category : BLOCK_CATEGORIES) {
            category.registerBlockEntities(OTHER_MODS);
            category.registerEntities(OTHER_MODS);
        }

        LOGGER.info("[minekea] Registering items");
        ITEMS.register();
        ITEMS.setupResources();
        ITEM_GROUPS.setupResources();

        LOGGER.info("[minekea] Registering colored blocks");
        registerMinekeaColoredBlocks();
        registerVanillaColoredBlocks();

        FabricLoader loader = FabricLoader.getInstance();

        if (loader.isModLoaded("patchouli")) {
            PatchouliCompat.init();
        }

        LOGGER.info("[minekea] Registering dynamic resource pack");
        // This _must_ be the last thing
        RESOURCES.register();
    }

    private void registerMinekeaColoredBlocks() {
        MinekeaConfig config = ConfigManager.getConfig();

        if (!config.enableDyedBlocks) {
            return;
        }

        for (MinekeaBlockSettings.DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasDyedBlocks()) {
                String material = settings.getMainMaterial();
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "white"), "minekea:dyed_" + material, BlockColor.WHITE);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "orange"), "minekea:dyed_" + material, BlockColor.ORANGE);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "magenta"), "minekea:dyed_" + material, BlockColor.MAGENTA);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "light_blue"), "minekea:dyed_" + material, BlockColor.LIGHT_BLUE);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "yellow"), "minekea:dyed_" + material, BlockColor.YELLOW);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "lime"), "minekea:dyed_" + material, BlockColor.LIME);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "pink"), "minekea:dyed_" + material, BlockColor.PINK);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "gray"), "minekea:dyed_" + material, BlockColor.GRAY);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "light_gray"), "minekea:dyed_" + material, BlockColor.LIGHT_GRAY);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "cyan"), "minekea:dyed_" + material, BlockColor.CYAN);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "purple"), "minekea:dyed_" + material, BlockColor.PURPLE);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "blue"), "minekea:dyed_" + material, BlockColor.BLUE);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "brown"), "minekea:dyed_" + material, BlockColor.BROWN);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "green"), "minekea:dyed_" + material, BlockColor.GREEN);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "red"), "minekea:dyed_" + material, BlockColor.RED);
                ColoredBlocksRegistry.addBlock(DyedBlocks.BLOCKS.get(material + "black"), "minekea:dyed_" + material, BlockColor.BLACK);
            }
        }
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
}
