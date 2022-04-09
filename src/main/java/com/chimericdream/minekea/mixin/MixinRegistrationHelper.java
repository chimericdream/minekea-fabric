package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinRegistrationHelper implements IMixinConfigPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID + "_mixins");

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("com.chimericdream.minekea.mixin.EnchantmentScreenHandlerMixin")) {
            boolean isBCLibLoaded = FabricLoader.getInstance().isModLoaded("bclib");

            if (isBCLibLoaded) {
                LOGGER.info("[minekea_mixins] BCLib is loaded. Disabling EnchantmentScreenHandlerMixin");
                return false;
            }

            LOGGER.info("[minekea_mixins] BCLib is not loaded. Enabling EnchantmentScreenHandlerMixin");
            return true;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}