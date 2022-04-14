package com.chimericdream.minekea;

public class ModInfo {
    public static final String MOD_ID = "minekea";

    public static String getModPrefix(String modId) {
        if (modId.equals(MOD_ID)) {
            return "";
        }

        return String.format("%s/", modId);
    }
}
