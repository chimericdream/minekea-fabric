//package com.chimericdream.minekea.block.containers.barrels;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
//import net.fabricmc.fabric.api.registry.FuelRegistry;
//import net.minecraft.block.BarrelBlock;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import java.util.Objects;
//
//public class GenericBarrel extends BarrelBlock implements MinekeaBlock {
//    public GenericBarrel(BarrelSettings settings) {
//        super(settings);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((BarrelSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));
//
//        if (isFlammable) {
//            FuelRegistry.INSTANCE.add(this, 300);
//            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
//        }
//
//        setupResources();
//    }
//
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.BARRELS.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        String PLANK_MATERIAL = settings.getMaterial("planks").toString();
//        String SLAB_MATERIAL = settings.getMaterial("slab").toString();
//
//        Identifier LOG_TEXTURE = settings.getBlockTexture("stripped_log");
//        Identifier PLANK_TEXTURE = settings.getBlockTexture("planks");
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//        Identifier OPEN_MODEL_ID = Identifier.of(MODEL_ID + "_open");
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("PSP", "P P", "PSP"),
//                JKeys.keys()
//                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL))
//                    .key("S", JIngredient.ingredient().item(SLAB_MATERIAL)),
//                JResult.result(getBlockID().toString())
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("face", LOG_TEXTURE.toString())
//            .var("sides", PLANK_TEXTURE.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/containers/barrel").textures(textures),
//            MODEL_ID
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/containers/barrel_open").textures(textures),
//            OPEN_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID.toString()), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("facing=down,open=false", new JBlockModel(MODEL_ID).x(180))
//                    .put("facing=east,open=false", new JBlockModel(MODEL_ID).x(90).y(90))
//                    .put("facing=north,open=false", new JBlockModel(MODEL_ID).x(90))
//                    .put("facing=south,open=false", new JBlockModel(MODEL_ID).x(90).y(180))
//                    .put("facing=up,open=false", new JBlockModel(MODEL_ID))
//                    .put("facing=west,open=false", new JBlockModel(MODEL_ID).x(90).y(270))
//
//                    .put("facing=down,open=true", new JBlockModel(OPEN_MODEL_ID).x(180))
//                    .put("facing=east,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(90))
//                    .put("facing=north,open=true", new JBlockModel(OPEN_MODEL_ID).x(90))
//                    .put("facing=south,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(180))
//                    .put("facing=up,open=true", new JBlockModel(OPEN_MODEL_ID))
//                    .put("facing=west,open=true", new JBlockModel(OPEN_MODEL_ID).x(90).y(270))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class BarrelSettings extends MinekeaBlockSettings<BarrelSettings> {
//        public BarrelSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Barrel");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%scontainers/barrels/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
