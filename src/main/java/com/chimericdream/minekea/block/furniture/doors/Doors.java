package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Doors implements MinekeaBlockCategory {
    public static final Map<String, Block> BLOCKS = new LinkedHashMap<>();

    static {
        BLOCKS.put("acacia", new GenericBookshelfDoor(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Bookshelves.BOOKSHELVES.get("acacia")).ingredient("planks", Blocks.ACACIA_PLANKS)));
        BLOCKS.put("bamboo", new GenericBookshelfDoor(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Bookshelves.BOOKSHELVES.get("bamboo")).ingredient("planks", Blocks.BAMBOO_PLANKS)));
        BLOCKS.put("birch", new GenericBookshelfDoor(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Bookshelves.BOOKSHELVES.get("birch")).ingredient("planks", Blocks.BIRCH_PLANKS)));
        BLOCKS.put("cherry", new GenericBookshelfDoor(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Bookshelves.BOOKSHELVES.get("cherry")).ingredient("planks", Blocks.CHERRY_PLANKS)));
        BLOCKS.put("crimson", new GenericBookshelfDoor(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Bookshelves.BOOKSHELVES.get("crimson")).ingredient("planks", Blocks.CRIMSON_PLANKS)));
        BLOCKS.put("dark_oak", new GenericBookshelfDoor(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Bookshelves.BOOKSHELVES.get("dark_oak")).ingredient("planks", Blocks.DARK_OAK_PLANKS)));
        BLOCKS.put("jungle", new GenericBookshelfDoor(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Bookshelves.BOOKSHELVES.get("jungle")).ingredient("planks", Blocks.JUNGLE_PLANKS)));
        BLOCKS.put("mangrove", new GenericBookshelfDoor(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Bookshelves.BOOKSHELVES.get("mangrove")).ingredient("planks", Blocks.MANGROVE_PLANKS)));
        BLOCKS.put("oak", new GenericBookshelfDoor(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.BOOKSHELF).ingredient("planks", Blocks.OAK_PLANKS)));
        BLOCKS.put("spruce", new GenericBookshelfDoor(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Bookshelves.BOOKSHELVES.get("spruce")).ingredient("planks", Blocks.SPRUCE_PLANKS)));
        BLOCKS.put("warped", new GenericBookshelfDoor(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Bookshelves.BOOKSHELVES.get("warped")).ingredient("planks", Blocks.WARPED_PLANKS)));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS.values().stream().toList();
    }
}
