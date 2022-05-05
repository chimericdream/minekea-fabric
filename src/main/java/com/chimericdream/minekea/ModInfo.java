package com.chimericdream.minekea;

import net.minecraft.util.Identifier;

public class ModInfo {
    public static final String MOD_ID = "minekea";

    public static final Identifier DISPLAY_CASE_BLOCK_ENTITY_PACKET_ID = new Identifier(MOD_ID, "networking/blocks/entities/display_case");
    public static final Identifier JAR_BLOCK_ENTITY_PACKET_ID = new Identifier(MOD_ID, "networking/blocks/entities/jar");
    public static final Identifier SHELF_BLOCK_ENTITY_PACKET_ID = new Identifier(MOD_ID, "networking/blocks/entities/shelf");

    public static String getModPrefix(String modId) {
        if (modId.equals(MOD_ID)) {
            return "";
        }

        return String.format("%s/", modId);
    }
}
