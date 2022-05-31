package com.chimericdream.minekea.resource;

import com.chimericdream.minekea.ModInfo;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.minecraft.util.Identifier;

public class MinekeaResourcePack {
    public static final String MINEKEA_CATEGORY = "category.minekea";
    public static final String CYCLE_PAINTER_KEYBIND = "key.minekea.items.painter.cycle_color";

    public static final JLang EN_US = new JLang();
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(new Identifier(ModInfo.MOD_ID, "dynamic_resources"));

    public void register() {
        MinekeaResourcePack.EN_US.entry(MINEKEA_CATEGORY, "Minekea");
        MinekeaResourcePack.EN_US.entry(CYCLE_PAINTER_KEYBIND, "Block Painter: Cycle Color");

        RESOURCE_PACK.addLang(new Identifier(ModInfo.MOD_ID, "en_us"), EN_US);

        RRPCallback.BEFORE_VANILLA.register(packs -> packs.add(RESOURCE_PACK));
    }
}
