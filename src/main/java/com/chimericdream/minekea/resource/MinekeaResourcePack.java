//package com.chimericdream.minekea.resource;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.util.Tool;
//import net.minecraft.util.Identifier;
//import pers.solid.brrp.v1.api.RuntimeResourcePack;
//import pers.solid.brrp.v1.fabric.api.RRPCallback;
//
//public class MinekeaResourcePack {
//    public static final String MINEKEA_CATEGORY = "category.minekea";
//    public static final String CYCLE_PAINTER_KEYBIND = "key.minekea.items.painter.cycle_color";
//
//    public static final JTag WALL_TAG = new JTag();
//
//    public static final JLang EN_US = new JLang();
//    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(Identifier.of(ModInfo.MOD_ID, "dynamic_resources"));
//
//    public static void addToolTag(Tool tool, Identifier blockId) {
//    }
//
//    public void register() {
//        EN_US.entry(MINEKEA_CATEGORY, "Minekea");
//        EN_US.entry(CYCLE_PAINTER_KEYBIND, "Block Painter: Cycle Color");
//
//        RESOURCE_PACK.addLang(Identifier.of(ModInfo.MOD_ID, "en_us"), EN_US);
//
//        MinekeaTags.register();
//
//        RRPCallback.BEFORE_VANILLA.register(packs -> packs.add(RESOURCE_PACK));
//    }
//}
