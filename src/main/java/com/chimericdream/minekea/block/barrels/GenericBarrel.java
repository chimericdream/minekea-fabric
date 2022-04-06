package com.chimericdream.minekea.block.barrels;

import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public abstract class GenericBarrel extends BarrelBlock {
    public GenericBarrel() {
        super(FabricBlockSettings.copyOf(Blocks.BARREL).sounds(BlockSoundGroup.WOOD));
    }

    abstract public void register();

    protected void setupResources(Identifier[] ids, String[] materials) {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            ids[0],
            JRecipe.shaped(
                JPattern.pattern("PSP", "P P", "PSP"),
                JKeys.keys()
                    .key("P", JIngredient.ingredient().item(materials[0]))
                    .key("S", JIngredient.ingredient().item(materials[1])),
                JResult.result(ids[0].toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=down,open=false", new JBlockModel(ids[1]).x(180))
                    .put("facing=east,open=false", new JBlockModel(ids[1]).x(90).y(90))
                    .put("facing=north,open=false", new JBlockModel(ids[1]).x(90))
                    .put("facing=south,open=false", new JBlockModel(ids[1]).x(90).y(180))
                    .put("facing=up,open=false", new JBlockModel(ids[1]))
                    .put("facing=west,open=false", new JBlockModel(ids[1]).x(90).y(270))

                    .put("facing=down,open=true", new JBlockModel(ids[2]).x(180))
                    .put("facing=east,open=true", new JBlockModel(ids[2]).x(90).y(90))
                    .put("facing=north,open=true", new JBlockModel(ids[2]).x(90))
                    .put("facing=south,open=true", new JBlockModel(ids[2]).x(90).y(180))
                    .put("facing=up,open=true", new JBlockModel(ids[2]))
                    .put("facing=west,open=true", new JBlockModel(ids[2]).x(90).y(270))
            ),
            ids[0]
        );
    }
}
