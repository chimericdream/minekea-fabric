package com.chimericdream.minekea.resource;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.Tool;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.util.Identifier;

public class MinekeaResourcePack {
    public static final String MINEKEA_CATEGORY = "category.minekea";
    public static final String CYCLE_PAINTER_KEYBIND = "key.minekea.items.painter.cycle_color";

    public static final JTag MINEABLE_AXE = new JTag();
    public static final JTag MINEABLE_HOE = new JTag();
    public static final JTag MINEABLE_PICKAXE = new JTag();
    public static final JTag MINEABLE_SHEARS = new JTag();
    public static final JTag MINEABLE_SHOVEL = new JTag();

    public static final JTag JAR_STORABLE_TAG = new JTag();
    public static final JTag WALL_TAG = new JTag();

    public static final JLang EN_US = new JLang();
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(new Identifier(ModInfo.MOD_ID, "dynamic_resources"));

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

    public void register() {
        EN_US.entry(MINEKEA_CATEGORY, "Minekea");
        EN_US.entry(CYCLE_PAINTER_KEYBIND, "Block Painter: Cycle Color");

        RESOURCE_PACK.addLang(new Identifier(ModInfo.MOD_ID, "en_us"), EN_US);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/walls"), WALL_TAG);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "items/glass_jar_storable"), JAR_STORABLE_TAG);

        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/axe"), MINEABLE_AXE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/hoe"), MINEABLE_HOE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/pickaxe"), MINEABLE_PICKAXE);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/shears"), MINEABLE_SHEARS);
        RESOURCE_PACK.addTag(new Identifier(ModInfo.MOD_ID, "blocks/mineable/shovel"), MINEABLE_SHOVEL);

        RRPCallback.BEFORE_VANILLA.register(packs -> packs.add(RESOURCE_PACK));
    }
}
