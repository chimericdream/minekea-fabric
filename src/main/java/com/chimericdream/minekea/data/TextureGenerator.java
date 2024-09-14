/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * Copyright © 2024 Jaxydog
 *
 * This file is part of Astral.
 *
 * Astral is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * Astral is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with Astral. If not, see <https://www.gnu.org/licenses/>.
 */

package com.chimericdream.minekea.data;

import com.chimericdream.minekea.MinekeaMod;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput.OutputType;
import net.minecraft.data.DataOutput.PathResolver;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides a simple data generation API for textures. Adapted from the Astral mod.
 *
 * @author Jaxydog
 * @author chimericdream
 * @link https://github.com/Jaxydog/Astral
 */
public class TextureGenerator implements DataProvider {
    private static final String BASE_PATH = "assets/minecraft/textures";
    private static final String BASE_MINEKEA_PATH = "assets/minekea/textures";

    private static final String MINEKEA_ENV_KEY = "minekea.datagen.resource-path";
    private static final @Nullable String MINEKEA_RESOURCE_PATH = System.getenv(MINEKEA_ENV_KEY);

    private static @Nullable TextureGenerator instance;

    private final Map<RegistryKey<? extends Registry<?>>, Instance<?>> instances = new Object2ObjectOpenHashMap<>();
    private final Pack pack;

    public TextureGenerator(Pack pack) {
        this.pack = pack;

        assert instance == null;

        instance = this;
    }

    public static boolean hasInstance() {
        return instance != null;
    }

    public static @NotNull TextureGenerator getInstance() {
        assert instance != null;

        return instance;
    }

    /**
     * Generates a new item texture.
     *
     * @param registryKey The target registry.
     * @param consumer    A consumer that takes in the generator instance.
     * @param <T>         The registry's associated type.
     */
    @SuppressWarnings("unchecked")
    public <T> void generate(RegistryKey<? extends Registry<T>> registryKey, Consumer<Instance<T>> consumer) {
        consumer.accept((Instance<T>) this.instances.computeIfAbsent(registryKey,
            (key) -> this.pack.addProvider((output, future) -> new Instance<>(output, registryKey, future))
        ));
    }

    @Override
    public String getName() {
        return "Textures";
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return CompletableFuture.allOf((CompletableFuture<?>[]) this.instances.values()
            .stream()
            .map(v -> v.run(writer))
            .toArray());
    }

    /**
     * An instance of a texture generator.
     *
     * @param <T> The associated registry type.
     * @author Jaxydog
     */
    public static class Instance<T> implements DataProvider {
        private static final Map<String, BufferedImage> IMAGE_CACHE = new Object2ObjectOpenHashMap<>();
        private static final Map<String, BufferedImage> MINEKEA_IMAGE_CACHE = new Object2ObjectOpenHashMap<>();

        private final Map<Identifier, BufferedImage> images = new Object2ObjectOpenHashMap<>();

        private final RegistryKey<? extends Registry<T>> registryKey;
        private final CompletableFuture<WrapperLookup> lookupFuture;
        private final PathResolver pathResolver;

        private Instance(
            FabricDataOutput output,
            RegistryKey<? extends Registry<T>> registryKey,
            CompletableFuture<WrapperLookup> lookupFuture
        ) {
            this.registryKey = registryKey;
            this.lookupFuture = lookupFuture;
            this.pathResolver = output.getResolver(OutputType.RESOURCE_PACK,
                "textures/" + registryKey.getValue().getPath()
            );
        }

        /**
         * Creates a copy of the provided image.
         *
         * @param image The source image.
         * @return A copy of the given image.
         */
        private static @NotNull BufferedImage copyImage(@NotNull BufferedImage image) {
            final BufferedImage copy;

            if (image.getColorModel() instanceof IndexColorModel model) {
                copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType(), model);
            } else {
                copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            }

            image.copyData(copy.getRaster());

            return image;
        }

        /**
         * Generates a new texture.
         *
         * @param identifier The texture's identifier.
         * @param image      The texture.
         */
        public void generate(Identifier identifier, BufferedImage image) {
            this.images.put(identifier, image);
        }

        public Optional<BufferedImage> getMinekeaImage(String path) {
            // Early return to prevent duplicate file reads.
            // Intentionally checked *before* checking for Jar access in case any values are still set.
            if (MINEKEA_IMAGE_CACHE.containsKey(path)) {
                return Optional.of(copyImage(MINEKEA_IMAGE_CACHE.get(path)));
            }

            try {
                final String imagePath = "%s/%s/%s.png".formatted(MINEKEA_RESOURCE_PATH, BASE_MINEKEA_PATH, path);

                File imageFile = new File(imagePath);

                if (!imageFile.canRead()) {
                    return Optional.empty();
                }

                FileInputStream stream = new FileInputStream(imageFile);

                final BufferedImage image = ImageIO.read(stream);

                if (image != null) {
                    MINEKEA_IMAGE_CACHE.put(path, copyImage(image));
                }

                return Optional.ofNullable(image);
            } catch (IOException exception) {
                MinekeaMod.LOGGER.error(exception.toString());

                return Optional.empty();
            }
        }

        public Optional<BufferedImage> getImage(String path) {
            // Early return to prevent duplicate file reads.
            // Intentionally checked *before* checking for Jar access in case any values are still set.
            if (IMAGE_CACHE.containsKey(path)) return Optional.of(copyImage(IMAGE_CACHE.get(path)));
            if (!JarAccess.canLoad()) return Optional.empty();

            // We currently only support loading directly from the Minecraft jar.
            // As such, we can safely assume all file paths are within `BASE_PATH`.
            final String jarPath = "%s/%s/%s.png".formatted(BASE_PATH, this.registryKey.getValue().getPath(), path);

            return JarAccess.getInputStream(jarPath).flatMap(stream -> {
                try {
                    final BufferedImage image = ImageIO.read(stream);

                    if (image != null) IMAGE_CACHE.put(path, copyImage(image));

                    return Optional.ofNullable(image);
                } catch (IOException exception) {
                    MinekeaMod.LOGGER.error(exception.toString());

                    return Optional.empty();
                }
            });
        }

        @Override
        public String getName() {
            return "Textures for " + this.registryKey;
        }

        @SuppressWarnings("UnstableApiUsage")
        @Override
        public CompletableFuture<?> run(DataWriter writer) {
            return this.lookupFuture.thenCompose(lookup -> CompletableFuture.allOf(this.images.entrySet()
                .stream()
                .map(entry -> CompletableFuture.runAsync(() -> {

                    // Images are typically ~250-350 bytes, so overshooting prevents repeated reallocation.
                    // 512 bytes should be enough that most images never exceed the buffer size, with a few exceptions.
                    final ByteArrayOutputStream output = new ByteArrayOutputStream(512);
                    // For hashing, we don't need anything cryptographic, just consistent between runs.
                    // For this case, `sha1` works perfectly fine, as it's fast and stupid.
                    @SuppressWarnings("deprecation") final HashingOutputStream hash = new HashingOutputStream(Hashing.sha1(), output);
                    final Path path = this.pathResolver.resolve(entry.getKey(), "png");

                    try (final ImageOutputStream stream = ImageIO.createImageOutputStream(hash)) {
                        ImageIO.write(entry.getValue(), "png", stream);

                        // Ensure that all bytes are written to the stream before writing the file.
                        stream.flush();
                        writer.write(path, output.toByteArray(), hash.hash());
                    } catch (IOException exception) {
                        MinekeaMod.LOGGER.error("Failed to save file to {}", path);
                        MinekeaMod.LOGGER.error(exception.getLocalizedMessage());
                    }
                }, Util.getMainWorkerExecutor()))
                .toArray(CompletableFuture[]::new)));
        }
    }
}
