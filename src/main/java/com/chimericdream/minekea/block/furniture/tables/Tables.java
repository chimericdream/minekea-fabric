package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.minekea.block.furniture.tables.GenericTable.TableSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class Tables implements MinekeaBlockCategory {
    public static final GenericTable ACACIA_TABLE;
    public static final GenericTable BIRCH_TABLE;
    public static final GenericTable CRIMSON_TABLE;
    public static final GenericTable DARK_OAK_TABLE;
    public static final GenericTable JUNGLE_TABLE;
    public static final GenericTable MANGROVE_TABLE;
    public static final GenericTable OAK_TABLE;
    public static final GenericTable SPRUCE_TABLE;
    public static final GenericTable WARPED_TABLE;

    static {
        ACACIA_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.ACACIA));
        BIRCH_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.BIRCH));
        CRIMSON_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.JUNGLE));
        MANGROVE_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.MANGROVE));
        OAK_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.OAK));
        SPRUCE_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.SPRUCE));
        WARPED_TABLE = new GenericTable(new TableSettings(BaseBlockSettings.WARPED));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_TABLE.register();
        BIRCH_TABLE.register();
        CRIMSON_TABLE.register();
        DARK_OAK_TABLE.register();
        JUNGLE_TABLE.register();
        MANGROVE_TABLE.register();
        OAK_TABLE.register();
        SPRUCE_TABLE.register();
        WARPED_TABLE.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.entry(GenericTable.TOOLTIP_KEY, "Simple design, but somehow LACKing...");
    }
}
