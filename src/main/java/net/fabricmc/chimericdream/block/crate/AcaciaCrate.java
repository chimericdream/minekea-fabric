package net.fabricmc.chimericdream.block.crate;

import net.fabricmc.chimericdream.ModInfo;
import net.fabricmc.chimericdream.block.crate.entity.AcaciaCrateBlockEntity;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class AcaciaCrate extends AbstractCrate implements BlockEntityProvider {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "acacia_crate");

    public AcaciaCrate() {
        super(Settings.copy(Blocks.ACACIA_PLANKS));

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AcaciaCrateBlockEntity(pos, state);
    }
}
