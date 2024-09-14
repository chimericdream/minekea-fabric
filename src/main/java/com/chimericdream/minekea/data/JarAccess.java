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
import com.mojang.serialization.DataResult;
import net.minecraft.util.PathUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Provides safe access to the Minecraft Jar file's assets. This file was adapted from the Astral mod.
 * <p>
 * The location of the jar itself should be specified via the {@value #ENV_KEY} environment variable.
 *
 * @author Jaxydog
 * @author chimericdrea
 * @link https://github.com/Jaxydog/Astral
 */
public final class JarAccess {
    // Formatted to be akin to Fabric's style of environment variable names.
    private static final String ENV_KEY = "minekea.datagen.minecraft-jar-path";
    private static final int MAX_HINTS = 5;
    private static @Nullable JarAccess instance;

    private final @Nullable String path = System.getenv(ENV_KEY);
    private @Nullable JarFile file;
    private boolean closed = false;

    private JarAccess() {
        if (this.path == null) {
            MinekeaMod.LOGGER.warn("The '{}' environment variable is unset, some generators may not load.", ENV_KEY);
        }
    }

    /**
     * Simple method to ensure that an instance exists when needed, but *only* when needed.
     *
     * @return The instance.
     */
    private static @NotNull JarAccess getInstance() {
        if (instance == null) instance = new JarAccess();

        return instance;
    }

    /**
     * Returns whether the Jar can be loaded.
     *
     * @return If the Jar can load;
     */
    public static boolean canLoad() {
        return getInstance().path != null;
    }

    /**
     * Returns the handle for the opened Jar file.
     * <p>
     * If closed, the jar will automatically re-open itself when requested again.
     *
     * @return The jar file.
     */
    public static @NotNull JarFile getJar() {
        final JarAccess access = getInstance();

        if (access.path == null) {
            throw new RuntimeException("The '%s' has not been set".formatted(ENV_KEY));
        }

        if (access.file == null || access.closed) {
            try {
                access.file = new JarFile(access.path) {

                    @Override
                    public void close() throws IOException {
                        // Track when the Jar is closed, so that we know when we need to re-open it.
                        access.closed = true;

                        super.close();
                    }
                };
            } catch (IOException exception) {
                throw new IllegalArgumentException("Unable to load Jar file", exception);
            }
        }

        return access.file;
    }

    /**
     * Returns an entry from the Jar, if it exists.
     *
     * @param path      The requested Jar path.
     * @param allowDirs Whether directories are allowed to be returned.
     * @return The optional Jar entry.
     */
    public static Optional<JarEntry> getJarEntry(String path, boolean allowDirs) {
        final JarFile jar = getJar();
        final JarEntry entry = jar.getJarEntry(path);

        if (entry == null) {
            MinekeaMod.LOGGER.warn("Unable to load entry '{}'", path);

            final Predicate<JarEntry> filter = e -> {
                if (!allowDirs && e.isDirectory()) return false;

                final DataResult<List<String>> maybeParts = PathUtil.split(e.getName());
                // This converts the returned optional list into a concrete list of distinct parts.
                final List<String> parts = maybeParts.result().stream().flatMap(List::stream).distinct().toList();

                if (parts.isEmpty()) return false;

                // Accept if the number of matching parts is greater than half of the total part count.
                // Basically a really simple, *really* dumb fuzzy find.
                return parts.stream().mapToLong(s -> path.contains(s) ? 1L : 0L).sum() > parts.size() / 2;
            };

            final List<String> matches = jar.stream().filter(filter).distinct().map(JarEntry::getName).toList();

            if (!matches.isEmpty()) {
                final StringBuilder builder = new StringBuilder();

                // Scary method chain to combine possible valid paths into a list.
                matches.stream().sorted().limit(MAX_HINTS).forEach(s -> builder.append("- ").append(s).append("\n"));

                // Adds a little ellipsis if the number of possible paths exceeds the defined limit.
                if (matches.size() > MAX_HINTS) builder.append("  ...");

                MinekeaMod.LOGGER.warn("Valid entries:\n{}", builder);
            } else {
                MinekeaMod.LOGGER.warn("No valid entries found.");
            }
        } else if (!allowDirs && entry.isDirectory()) {
            MinekeaMod.LOGGER.warn("Entry '{}' is a directory", path);

            return Optional.empty();
        }

        return Optional.ofNullable(entry);

        // scary method
    }

    /**
     * Returns an input stream corresponding to an entry within the Jar, if it exists.
     *
     * @param path The requested Jar path.
     * @return The optional input stream.
     */
    public static Optional<InputStream> getInputStream(String path) {
        return getJarEntry(path, false).flatMap(entry -> {
            try {
                return Optional.ofNullable(getJar().getInputStream(entry));
            } catch (IOException exception) {
                MinekeaMod.LOGGER.error(exception.getLocalizedMessage());

                return Optional.empty();
            }
        });
    }
}
