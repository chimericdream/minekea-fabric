package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public abstract class GenericBookshelf extends Block {
    GenericBookshelf() {
        super(AbstractBlock.Settings.copy(Blocks.BOOKSHELF));
    }

    GenericBookshelf(Settings settings) {
        super(settings);
    }

    abstract public void register();

    protected void setupResources(Identifier id, String material) {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            id,
            JRecipe.shaped(
                JPattern.pattern("###", "XXX", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(material))
                    .key("X", JIngredient.ingredient().item("minecraft:book")),
                JResult.result(id.toString())
            )
        );
    }
}
