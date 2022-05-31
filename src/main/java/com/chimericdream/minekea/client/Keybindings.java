package com.chimericdream.minekea.client;

import com.chimericdream.minekea.network.ServerNetworking;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

import static com.chimericdream.minekea.resource.MinekeaResourcePack.CYCLE_PAINTER_KEYBIND;
import static com.chimericdream.minekea.resource.MinekeaResourcePack.MINEKEA_CATEGORY;

@Environment(EnvType.CLIENT)
public class Keybindings {
    public static final KeyBinding CYCLE_PAINTER_COLOR;

    static {
        CYCLE_PAINTER_COLOR = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            CYCLE_PAINTER_KEYBIND,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_EQUAL,
            MINEKEA_CATEGORY
        ));
    }

    public void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (CYCLE_PAINTER_COLOR.wasPressed()) {
                ClientPlayNetworking.send(ServerNetworking.CYCLE_PAINTER_COLOR, new PacketByteBuf(Unpooled.buffer()));
            }
        });
    }
}
