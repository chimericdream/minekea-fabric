package com.chimericdream.minekea.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chimericdream.minekea.ModInfo;

public class IdentifierUpdateHelper {

    private static final List<StringReplacement> replacementsV1V2 = new ArrayList<>();
    private static final List<PatternReplacement> replacementsV2V3 = new ArrayList<>();
    private static final List<PatternReplacement> fromPannotiasParcels = new ArrayList<>();

    static {
        // Changes made in 2.2.0
        replaceV1V2("^bookshelves/storage/[_a-z]+storage_shelf_block_entity$", "bookshelves/storage/storage_shelf_block_entity");
        replaceV1V2("^crates/[_a-z]+crate_block_entity$", "crates/crate_block_entity");
        replaceV1V2("^displaycases/[_a-z]+case_block_entity$", "displaycases/display_case_block_entity");

        // Changes made in 2.8.0
        replaceV2V3("^beams/([^/]+/)?([./_a-z]+)_plank_beam$", "$1building/beams/$2");
        replaceV2V3("^beams/([^/]+/)?([./_a-z]+)_beam$", "$1building/beams/$2");
        replaceV2V3("^slabs/([^/]+/)?([./_a-z]+)_bookshelf_slab$", "$1building/slabs/bookshelves/$2");
        replaceV2V3("^slabs/([^/]+/)?([./_a-z]+)_slab$", "$1building/slabs/$2");
        replaceV2V3("^stairs/([^/]+/)?([./_a-z]+)_bookshelf_stairs$", "$1building/stairs/bookshelves/$2");
        replaceV2V3("^stairs/([^/]+/)?([./_a-z]+)_stairs$", "$1building/stairs/$2");
        replaceV2V3("^covers/([^/]+/)?([./_a-z]+)_plank_cover$", "$1building/covers/$2");
        replaceV2V3("^covers/([^/]+/)?([./_a-z]+)_cover$", "$1building/covers/$2");
        replaceV2V3("^building/stairs/([^/]+/)?([./_a-z]+)_vertical_bookshelf_stairs$", "$1building/stairs/vertical/bookshelves/$2");
        replaceV2V3("^building/stairs/([^/]+/)?([./_a-z]+)_vertical_stairs$", "$1building/stairs/vertical/$2");
        replaceV2V3("^storage/compressed_([./_a-z]+)$", "storage/compressed/$1");
        replaceV2V3("^storage/dyes/compressed_([./_a-z]+)$", "storage/dyes/$1");
        replaceV2V3("^crates/([^/]+/)?([./_a-z]+)_crate$", "$1containers/crates/$2");
        replaceV2V3("^barrels/([^/]+/)?([./_a-z]+)_barrel$", "$1containers/barrels/$2");
        replaceV2V3("^displaycases/([^/]+/)?stripped_([./_a-z]+)_display_case$", "$1furniture/display_cases/stripped/$2");
        replaceV2V3("^displaycases/([^/]+/)?([./_a-z]+)_display_case$", "$1furniture/display_cases/$2");
        replaceV2V3("^seating/stools/([^/]+/)?([./_a-z]+)_stool", "$1furniture/seating/stools/$2");
        replaceV2V3("^seating/chairs/([^/]+/)?([./_a-z]+)_chair", "$1furniture/seating/chairs/$2");
        replaceV2V3("^tables/([^/]+/)?([./_a-z]+)_table", "$1furniture/tables/$2");
        replaceV2V3("^shelves/([^/]+/)?([./_a-z]+)_supported_shelf$", "$1furniture/shelves/supported/$2");
        replaceV2V3("^shelves/([^/]+/)?([./_a-z]+)_floating_shelf$", "$1furniture/shelves/floating/$2");
        replaceV2V3("^bookshelves/storage/([^/]+/)?([./_a-z]+)_storage_shelf$", "$1furniture/bookshelves/storage/$2");
        replaceV2V3("^bookshelves/([^/]+/)?([./_a-z]+)_bookshelf$", "$1furniture/bookshelves/$2");
        replaceV2V3("^bookshelves/doors/([^/]+/)?([./_a-z]+)_bookshelf_door$", "$1furniture/doors/bookshelves/$2");
        replaceV2V3("^bookshelves/trapdoors/([^/]+/)?([./_a-z]+)_bookshelf_trapdoor$", "$1furniture/trapdoors/bookshelves/$2");

        // Blocks moved over in 2.8.0
        moveFromPannotiasParcels("^compressed_([a-zA-Z_-]+)_([0-9])x$", "building/compressed/$1/$2x");
        moveFromPannotiasParcels("^bamboo_bundle$", "storage/compressed/bamboo");
        moveFromPannotiasParcels("^cane_bundle$", "storage/compressed/sugar_cane");
        moveFromPannotiasParcels("^stick_bundle$", "storage/compressed/stick");
    }

    private static void replaceV1V2(String pattern, String replacement) {
        replacementsV1V2.add(new StringReplacement(pattern, replacement));
    }

    private static void replaceV2V3(String pattern, String replacement) {
        replacementsV2V3.add(new PatternReplacement(pattern, replacement));
    }

    private static void moveFromPannotiasParcels(String pattern, String replacement) {
        fromPannotiasParcels.add(new PatternReplacement(pattern, replacement));
    }

    public static void updateIdsV1V2(String[] id) {
        for (StringReplacement repl : replacementsV1V2) {
            String with = repl.apply(id[1]);
            if (with != null) {
                id[1] = with;
            }
        }
    }

    public static void updateIdsV2V3(String[] id) {
        for (PatternReplacement repl : replacementsV2V3) {
            String with = repl.apply(id[1]);
            if (with != null) {
                id[1] = with;
            }
        }
    }

    public static void convertPannotiasParcelsIds(String[] id) {
        if (!id[0].equals("pannotiasparcels")) {
            return;
        }

        for (PatternReplacement repl : fromPannotiasParcels) {
            String with = repl.apply(id[1]);
            if (with != null) {
                id[0] = ModInfo.MOD_ID;
                id[1] = with;
            }
        }
    }

    static final class StringReplacement {
        final Pattern pattern;
        final String replacement;

        StringReplacement(String pattern, String replacement) {
            this.pattern = Pattern.compile(pattern);
            this.replacement = replacement;
        }

        String apply(String input) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return replacement;
            } else {
                return null;
            }
        }
    }

    static final class PatternReplacement {
        final Pattern pattern;
        final String replacement;

        PatternReplacement(String pattern, String replacement) {
            this.pattern = Pattern.compile(pattern);
            this.replacement = replacement;
        }

        String apply(String input) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return matcher.replaceAll(replacement);
            } else {
                return null;
            }
        }
    }
}
