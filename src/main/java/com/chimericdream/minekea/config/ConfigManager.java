//package com.chimericdream.minekea.config;
//
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import me.shedaniel.autoconfig.AutoConfig;
//import me.shedaniel.autoconfig.ConfigHolder;
//import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
//
//import java.util.Objects;
//import java.util.function.Consumer;
//
//public class ConfigManager {
//    private static ConfigHolder<MinekeaConfig> holder;
//
//    static {
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.title", "Minekea Configuration");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.reset", "Restore Defaults");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableBeams", "Enable Beams");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableCompressedBlocks", "Enable Compressed Blocks");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableCovers", "Enable Covers");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableSlabs", "Enable Slabs");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableStairs", "Enable Stairs");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableVerticalStairs", "Enable Vertical Stairs");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableWalls", "Enable Walls");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableBarrels", "Enable Barrels");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableCrates", "Enable Crates");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableBookshelves", "Enable Bookshelves");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableStorageBookshelves", "Enable Storage Bookshelves");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableDisplayCases", "Enable Display Cases");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableDoors", "Enable Doors");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enablePillows", "Enable Pillows");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableChairs", "Enable Chairs");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableStools", "Enable Stools");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableShelves", "Enable Shelves");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableShutters", "Enable Shutters");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableTables", "Enable Tables");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableTrapdoors", "Enable Trapdoors");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableButtons", "Enable Buttons");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enablePressurePlates", "Enable Pressure Plates");
//
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.overrideVanillaBarrelTexture", "Override Vanilla Barrel Texture");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.overrideVanillaBookshelfTexture", "Override Vanilla Bookshelf Texture");
//        MinekeaResourcePack.EN_US.entry("text.autoconfig.minekea.option.enableCobbledEndStone", "Enable Cobbled End Stone");
//    }
//
//    public static final Consumer<MinekeaConfig> DEFAULT = (config) -> {
//        config.reset = "Erase to reset";
//        config.enableBeams = true;
//        config.enableCompressedBlocks = true;
//        config.enableCovers = true;
//        config.enableSlabs = true;
//        config.enableStairs = true;
//        config.enableVerticalStairs = true;
//        config.enableWalls = true;
//        config.enableBarrels = true;
//        config.enableCrates = true;
//        config.enableBookshelves = true;
//        config.enableStorageBookshelves = true;
//        config.enableDisplayCases = true;
//        config.enableDoors = true;
//        config.enablePillows = true;
//        config.enableChairs = true;
//        config.enableStools = true;
//        config.enableShelves = true;
//        config.enableShutters = true;
//        config.enableTables = true;
//        config.enableTrapdoors = true;
//        config.enableButtons = true;
//        config.enablePressurePlates = true;
//
//        config.overrideVanillaBarrelTexture = true;
//        config.overrideVanillaBookshelfTexture = true;
//        config.enableCobbledEndStone = true;
//    };
//
//    public static void registerAutoConfig() {
//        if (holder != null) {
//            throw new IllegalStateException("Configuration already registered");
//        }
//
//        holder = AutoConfig.register(MinekeaConfig.class, JanksonConfigSerializer::new);
//
//        if (holder.getConfig().reset == null || Objects.equals(holder.getConfig().reset, "")) {
//            DEFAULT.accept(holder.getConfig());
//        }
//
//        holder.save();
//    }
//
//    public static MinekeaConfig getConfig() {
//        if (holder == null) {
//            return new MinekeaConfig();
//        }
//
//        return holder.getConfig();
//    }
//
//    public static void load() {
//        if (holder == null) {
//            registerAutoConfig();
//        }
//
//        holder.load();
//    }
//
//    public static void save() {
//        if (holder == null) {
//            registerAutoConfig();
//        }
//
//        holder.save();
//    }
//}
