//package com.chimericdream.minekea.item.containers;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.fluid.Fluids;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.BucketItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.Items;
//import net.minecraft.sound.SoundCategory;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.event.GameEvent;
//import org.jetbrains.annotations.Nullable;
//
//public class HoneyBucket extends BucketItem {
//    public static Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "containers/honey_bucket");
//
//    public HoneyBucket() {
//        super(Fluids.HONEY, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ItemGroup.MISC));
//    }
//
//    @Override
//    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
//        world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0F, 1.0F);
//        world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
//    }
//}
