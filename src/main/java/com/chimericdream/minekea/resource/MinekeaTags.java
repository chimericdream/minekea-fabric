package com.chimericdream.minekea.resource;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.Tool;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.util.Identifier;

import static com.chimericdream.minekea.resource.MinekeaResourcePack.RESOURCE_PACK;

public class MinekeaTags {
    public static final JTag MINEABLE_AXE = new JTag();
    public static final JTag MINEABLE_HOE = new JTag();
    public static final JTag MINEABLE_PICKAXE = new JTag();
    public static final JTag MINEABLE_SHEARS = new JTag();
    public static final JTag MINEABLE_SHOVEL = new JTag();

    public static final JTag JAR_STORABLE = new JTag();
    public static final JTag LANTERNS = new JTag();

    public static final BlockTagGroup BARRELS = new BlockTagGroup("barrels");
    public static final BlockTagGroup BEAMS = new BlockTagGroup("beams");
    public static final BlockTagGroup BOOKSHELVES = new BlockTagGroup("bookshelves");
    public static final BlockTagGroup CHAIRS = new BlockTagGroup("chairs");
    public static final BlockTagGroup COVERS = new BlockTagGroup("covers");
    public static final BlockTagGroup CRATES = new BlockTagGroup("crates");
    public static final BlockTagGroup DISPLAY_CASES = new BlockTagGroup("display_cases");
    public static final BlockTagGroup DOORS = new BlockTagGroup("doors");
    public static final BlockTagGroup FLOATING_SHELVES = new BlockTagGroup("floating_shelves");
    public static final BlockTagGroup SEATING = new BlockTagGroup("seating");
    public static final BlockTagGroup SHELVES = new BlockTagGroup("shelves");
    public static final BlockTagGroup SLABS = new BlockTagGroup("slabs");
    public static final BlockTagGroup STAIRS = new BlockTagGroup("stairs");
    public static final BlockTagGroup STOOLS = new BlockTagGroup("stools");
    public static final BlockTagGroup STORAGE_BOOKSHELVES = new BlockTagGroup("storage_bookshelves");
    public static final BlockTagGroup TABLES = new BlockTagGroup("tables");
    public static final BlockTagGroup TRAPDOORS = new BlockTagGroup("trapdoors");
    public static final BlockTagGroup VERTICAL_STAIRS = new BlockTagGroup("vertical_stairs");
    public static final BlockTagGroup WALLS = new BlockTagGroup("walls");

    public static void addToolTag(Tool tool, Identifier blockId) {
        switch (tool) {
            case AXE -> MINEABLE_AXE.add(blockId);
            case HOE -> MINEABLE_HOE.add(blockId);
            case PICKAXE -> MINEABLE_PICKAXE.add(blockId);
            case SHEARS -> MINEABLE_SHEARS.add(blockId);
            case SHOVEL -> MINEABLE_SHOVEL.add(blockId);
            default -> {
            }
        }
    }

    public static void register() {
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/axe"), MINEABLE_AXE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/hoe"), MINEABLE_HOE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/pickaxe"), MINEABLE_PICKAXE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/shears"), MINEABLE_SHEARS);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/shovel"), MINEABLE_SHOVEL);

        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "items/glass_jar_storable"), JAR_STORABLE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/lanterns"), LANTERNS);

        BARRELS.register();
        BEAMS.register();
        BOOKSHELVES.register();
        CHAIRS.register();
        COVERS.register();
        CRATES.register();
        DISPLAY_CASES.register();
        DOORS.register();
        FLOATING_SHELVES.register();
        SEATING.register();
        SHELVES.register();
        SLABS.register();
        STAIRS.register();
        STOOLS.register();
        STORAGE_BOOKSHELVES.register();
        TABLES.register();
        TRAPDOORS.register();
        VERTICAL_STAIRS.register();
        WALLS.register();
    }

    public static class BlockTagGroup {
        protected final JTag BASE = new JTag();
        protected final JTag NON_WOODEN = new JTag();
        protected final JTag WOODEN = new JTag();

        protected final String baseName;

        public BlockTagGroup(String baseName) {
            this.baseName = baseName;
        }

        public void add(Identifier blockId) {
            this.add(blockId, false);
        }

        public void add(Identifier blockId, boolean isWooden) {
            BASE.add(blockId);

            if (isWooden) {
                WOODEN.add(blockId);
            } else {
                NON_WOODEN.add(blockId);
            }
        }

        public void register() {
            RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, String.format("blocks/%s", baseName)), BASE);
            RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, String.format("blocks/non_wooden_%s", baseName)), NON_WOODEN);
            RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, String.format("blocks/wooden_%s", baseName)), WOODEN);
        }
    }
}
