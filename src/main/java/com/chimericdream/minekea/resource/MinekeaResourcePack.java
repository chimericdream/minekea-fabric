package com.chimericdream.minekea.resource;

import com.chimericdream.minekea.ModInfo;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.util.Identifier;

public class MinekeaResourcePack {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(new Identifier(ModInfo.MOD_ID, "dynamic_resources"));

    public void register() {
        RRPCallback.BEFORE_VANILLA.register(packs -> packs.add(RESOURCE_PACK));
    }
}
