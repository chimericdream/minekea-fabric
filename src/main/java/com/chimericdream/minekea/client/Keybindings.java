package com.chimericdream.minekea.client;

import com.chimericdream.minekea.network.CyclePainterColorPayload;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class Keybindings {
    public static final KeyBinding CYCLE_PAINTER_COLOR;

    static {
        CYCLE_PAINTER_COLOR = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.minekea.items.painter.cycle_color",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_EQUAL,
            "category.minekea"
        ));
    }

    public static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (CYCLE_PAINTER_COLOR.wasPressed()) {
                ClientPlayNetworking.send(new CyclePainterColorPayload(true));
            }
        });
    }
}
