//package com.chimericdream.minekea.block.furniture.trapdoors;
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
//import net.minecraft.block.TrapdoorBlock;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import java.util.Objects;
//
//public class GenericBookshelfTrapdoor extends TrapdoorBlock implements MinekeaBlock {
//    public GenericBookshelfTrapdoor(BookshelfTrapdoorSettings settings) {
//        super(settings);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((BookshelfTrapdoorSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
//
//        if (isFlammable) {
//            FuelRegistry.INSTANCE.add(this, 300);
//            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
//        }
//
//        setupResources();
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.TRAPDOORS.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier shelf = settings.getMaterial("bookshelf");
//        Identifier plankTexture = settings.getBlockTexture("planks");
//
//        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        Identifier BOTTOM_MODEL_ID = Identifier.of(BASE_MODEL_ID + "_bottom");
//        Identifier OPEN_MODEL_ID = Identifier.of(BASE_MODEL_ID + "_open");
//        Identifier TOP_MODEL_ID = Identifier.of(BASE_MODEL_ID + "_top");
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("###", "###"),
//                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
//                JResult.stackedResult(getBlockID().toString(), 12)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("material", plankTexture.toString())
//            .var("shelf", "minekea:block/furniture/bookshelves/shelf0");
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/trapdoors/bookshelves/bottom").textures(textures),
//            BOTTOM_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/trapdoors/bookshelves/open").textures(textures),
//            OPEN_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/trapdoors/bookshelves/top").textures(textures),
//            TOP_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(BOTTOM_MODEL_ID.toString()), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("facing=east,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(90))
//                    .put("facing=north,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID))
//                    .put("facing=south,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(180))
//                    .put("facing=west,half=bottom,open=false", new JBlockModel(BOTTOM_MODEL_ID).y(270))
//                    .put("facing=east,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(90))
//                    .put("facing=north,half=top,open=false", new JBlockModel(TOP_MODEL_ID))
//                    .put("facing=south,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(180))
//                    .put("facing=west,half=top,open=false", new JBlockModel(TOP_MODEL_ID).y(270))
//                    .put("facing=east,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(90))
//                    .put("facing=north,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID))
//                    .put("facing=south,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(180))
//                    .put("facing=west,half=bottom,open=true", new JBlockModel(OPEN_MODEL_ID).y(270))
//                    .put("facing=east,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(270))
//                    .put("facing=north,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(180))
//                    .put("facing=south,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(0))
//                    .put("facing=west,half=top,open=true", new JBlockModel(OPEN_MODEL_ID).x(180).y(90))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class BookshelfTrapdoorSettings extends MinekeaBlockSettings<BookshelfTrapdoorSettings> {
//        public BookshelfTrapdoorSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Bookshelf Trapdoor");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sfurniture/trapdoors/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
