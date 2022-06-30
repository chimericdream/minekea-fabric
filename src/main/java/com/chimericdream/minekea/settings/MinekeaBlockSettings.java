package com.chimericdream.minekea.settings;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.Tool;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class MinekeaBlockSettings<T extends MinekeaBlockSettings<?>> extends FabricBlockSettings {
    protected Block baseBlock;
    protected Identifier blockId;
    protected int burnSpread = 0;
    protected int burnTime = 0;
    protected int fuelTime = 0;
    protected boolean isColumn = false;
    protected boolean isFlammable = false;
    protected boolean isTranslucent = false;
    protected boolean isWooden = false;
    protected boolean isWool = false;
    protected String mainMaterial;
    protected Map<String, Identifier> materials;
    protected Map<String, Identifier> blockTextures = new HashMap<>();
    protected String modId = ModInfo.MOD_ID;
    protected String name = null;
    protected String namePatternOverride = null;
    protected Tool tool = Tool.PICKAXE;
    protected Supplier<Boolean> isEnabled = () -> true;

    protected MinekeaBlockSettings(Block block) {
        this(FabricBlockSettings.copyOf(block));

        this.baseBlock = block;
    }

    protected MinekeaBlockSettings(DefaultSettings settings) {
        super(settings);

        copySettings(settings);
    }

    protected MinekeaBlockSettings(AbstractBlock.Settings settings) {
        super(settings);

        if (settings instanceof DefaultSettings) {
            copySettings((DefaultSettings) settings);
        }
    }

    protected void copySettings(DefaultSettings settings) {
        this.baseBlock = settings.baseBlock;
        this.blockId = settings.blockId;
        this.burnSpread = settings.burnSpread;
        this.burnTime = settings.burnTime;
        this.fuelTime = settings.fuelTime;
        this.isColumn = settings.isColumn;
        this.isFlammable = settings.isFlammable;
        this.isTranslucent = settings.isTranslucent;
        this.isWooden = settings.isWooden;
        this.isWool = settings.isWool;
        this.mainMaterial = settings.mainMaterial;
        this.materials = settings.materials;
        this.blockTextures = settings.blockTextures;
        this.modId = settings.modId;
        this.name = settings.name;
        this.namePatternOverride = settings.namePatternOverride;
        this.tool = settings.tool;
    }

    abstract public Identifier getBlockId();

    abstract public String getNamePattern();

    public String getIngredientName() {
        if (this.name != null) {
            return this.name;
        }

        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        return Registry.ITEM.get(ingredient).getName().getString();
    }

    public float getHardness() {
        return this.getBaseBlock().getHardness();
    }

    public float getResistance() {
        return this.getBaseBlock().getBlastResistance();
    }

    public String getModId() {
        return this.modId;
    }

    public String getMainMaterial() {
        return this.mainMaterial;
    }

    public Tool getTool() {
        return this.tool;
    }

    public boolean isEnabled() {
        return true;
    }

    public Identifier getMaterial(String key) {
        if (this.materials.containsKey(key)) {
            return this.materials.get(key);
        }

        return this.materials.get("main");
    }

    public Identifier getMaterial(String key, String fallback) {
        if (this.materials.containsKey(key)) {
            return this.materials.get(key);
        }

        if (this.materials.containsKey(fallback)) {
            return this.materials.get(fallback);
        }

        return this.materials.get("main");
    }

    public Identifier getMaterial(String key, Identifier fallback) {
        if (this.materials.containsKey(key)) {
            return this.materials.get(key);
        }

        return fallback;
    }

    public Identifier getBlockTexture(String key) {
        if (this.blockTextures.containsKey(key)) {
            return this.blockTextures.get(key);
        }

        Identifier textureId = Texture.getBlockTextureID(this.getMaterial(key));

        this.blockTextures.put(key, textureId);

        return textureId;
    }

    public Identifier getBlockTexture(String key, String fallback) {
        if (this.blockTextures.containsKey(key)) {
            return this.blockTextures.get(key);
        }

        if (this.blockTextures.containsKey(fallback)) {
            return this.blockTextures.get(fallback);
        }

        Identifier textureId = Texture.getBlockTextureID(this.getMaterial(key, fallback));

        if (this.materials.containsKey(key)) {
            this.blockTextures.put(key, textureId);
        } else if (this.materials.containsKey(fallback)) {
            this.blockTextures.put(fallback, textureId);
        }

        return textureId;
    }

    public T texture(String key, Identifier id) {
        this.blockTextures.put(key, id);
        // noinspection unchecked
        return (T) this;
    }

    public Map<String, Identifier> getMaterials() {
        return this.materials;
    }

    public Block getBaseBlock() {
        return this.baseBlock;
    }

    public boolean isColumn() {
        return this.isColumn;
    }

    public boolean isFlammable() {
        return this.isFlammable;
    }

    public boolean isTranslucent() {
        return this.isTranslucent;
    }

    public boolean isWooden() {
        return this.isWooden;
    }

    public boolean isWool() {
        return this.isWool;
    }

    public T modId(String modId) {
        this.modId = modId;
        // noinspection unchecked
        return (T) this;
    }

    public T enabled(Supplier<Boolean> predicate) {
        this.isEnabled = predicate;
        // noinspection unchecked
        return (T) this;
    }

    public T namePattern(String pattern) {
        this.namePatternOverride = pattern;
        // noinspection unchecked
        return (T) this;
    }

    public T ingredientName(String name) {
        this.name = name;
        // noinspection unchecked
        return (T) this;
    }

    public T baseBlock(Block baseBlock) {
        this.baseBlock = baseBlock;
        // noinspection unchecked
        return (T) this;
    }

    public T tool(Tool tool) {
        this.tool = tool;
        // noinspection unchecked
        return (T) this;
    }

    public T wooden() {
        this.isWooden = true;
        // noinspection unchecked
        return (T) this;
    }

    public T wool() {
        this.isWool = true;
        // noinspection unchecked
        return (T) this;
    }

    public T burnSpread(int spread) {
        this.burnSpread = spread;
        // noinspection unchecked
        return (T) this;
    }

    public T burnTime(int time) {
        this.burnTime = time;
        // noinspection unchecked
        return (T) this;
    }

    public T fuelTime(int time) {
        this.fuelTime = time;
        // noinspection unchecked
        return (T) this;
    }

    public T column() {
        this.isColumn = true;
        // noinspection unchecked
        return (T) this;
    }

    public T flammable() {
        this.isFlammable = true;
        // noinspection unchecked
        return (T) this;
    }

    public T nonFlammable() {
        this.isFlammable = false;
        // noinspection unchecked
        return (T) this;
    }

    public T translucent() {
        this.isTranslucent = true;
        // noinspection unchecked
        return (T) this;
    }

    public T opaque() {
        this.isTranslucent = false;
        // noinspection unchecked
        return (T) this;
    }

    public T materials(Map<String, Identifier> materials) {
        validateMaterials(materials);
        this.materials = new HashMap<>(materials);
        // noinspection unchecked
        return (T) this;
    }

    public T addMaterial(String key, Identifier value) {
        this.materials.put(key, value);
        // noinspection unchecked
        return (T) this;
    }

    public T addMaterial(String key, String value) {
        this.materials.put(key, new Identifier(value));
        // noinspection unchecked
        return (T) this;
    }

    public T material(String material) {
        this.mainMaterial = material;
        // noinspection unchecked
        return (T) this;
    }

    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"main"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public static class DefaultSettings extends MinekeaBlockSettings<DefaultSettings> {
        public String bookshelfId = null;
        public String bookshelfModel = null;

        private boolean hasBeam = false;
        private boolean hasCompressedBlock = false;
        private boolean hasCover = false;
        private boolean hasSlab = false;
        private boolean hasBookshelfSlab = false;
        private boolean hasStairs = false;
        private boolean hasVerticalStairs = false;
        private boolean hasBookshelfStairs = false;
        private boolean hasVerticalBookshelfStairs = false;
        private boolean hasWall = false;
        private boolean hasBookshelf = false;
        private boolean hasStorageBookshelf = false;
        private boolean hasDisplayCase = false;
        private boolean hasStrippedDisplayCase = false;
        private boolean hasBookshelfDoor = false;
        private boolean hasChair = false;
        private boolean hasStool = false;
        private boolean hasShelf = false;
        private boolean hasFloatingShelf = false;
        private boolean hasTable = false;
        private boolean hasBookshelfTrapdoor = false;
        private boolean hasButton = false;
        private boolean hasPressurePlate = false;

        public DefaultSettings(Block block) {
            super(block);
        }

        public DefaultSettings bookshelfId(String id) {
            this.bookshelfId = id;
            return this;
        }

        public DefaultSettings bookshelfModel(String id) {
            this.bookshelfModel = id;
            return this;
        }

        public Identifier getBookshelfId() {
            if (this.bookshelfId != null) {
                return new Identifier(this.bookshelfId);
            }

            return Bookshelves.BOOKSHELVES.get(this.mainMaterial).getBlockID();
        }

        public Identifier getBookshelfModel() {
            if (this.bookshelfModel != null) {
                return new Identifier(this.bookshelfModel);
            }

            return null;
        }

        public boolean hasBeam() {
            return this.isEnabled() && this.hasBeam;
        }

        public DefaultSettings withBeam() {
            this.hasBeam = true;
            return this;
        }

        public boolean hasButton() {
            return this.isEnabled() && this.hasButton;
        }

        public DefaultSettings withButton() {
            this.hasButton = true;
            return this;
        }

        public boolean hasPressurePlate() {
            return this.isEnabled() && this.hasPressurePlate;
        }

        public DefaultSettings withPressurePlate() {
            this.hasPressurePlate = true;
            return this;
        }

        public boolean hasCompressedBlock() {
            return this.isEnabled() && this.hasCompressedBlock;
        }

        public DefaultSettings withCompressedBlock() {
            this.hasCompressedBlock = true;
            return this;
        }

        public boolean hasCover() {
            return this.isEnabled() && this.hasCover;
        }

        public DefaultSettings withCover() {
            this.hasCover = true;
            return this;
        }

        public boolean hasSlab() {
            return this.isEnabled() && this.hasSlab;
        }

        public DefaultSettings withSlab() {
            this.hasSlab = true;
            return this;
        }

        public boolean hasBookshelfSlab() {
            return this.isEnabled() && this.hasBookshelfSlab;
        }

        public DefaultSettings withBookshelfSlab() {
            this.hasBookshelfSlab = true;
            return this;
        }

        public boolean hasStairs() {
            return this.isEnabled() && this.hasStairs;
        }

        public DefaultSettings withStairs() {
            this.hasStairs = true;
            return this;
        }

        public boolean hasVerticalStairs() {
            return this.isEnabled() && this.hasVerticalStairs;
        }

        public DefaultSettings withVerticalStairs() {
            this.hasVerticalStairs = true;
            return this;
        }

        public boolean hasBookshelfStairs() {
            return this.isEnabled() && this.hasBookshelfStairs;
        }

        public DefaultSettings withBookshelfStairs() {
            this.hasBookshelfStairs = true;
            return this;
        }

        public boolean hasVerticalBookshelfStairs() {
            return this.isEnabled() && this.hasVerticalBookshelfStairs;
        }

        public DefaultSettings withVerticalBookshelfStairs() {
            this.hasVerticalBookshelfStairs = true;
            return this;
        }

        public boolean hasWall() {
            return this.isEnabled() && this.hasWall;
        }

        public DefaultSettings withWall() {
            this.hasWall = true;
            return this;
        }

        public boolean hasBookshelf() {
            return this.isEnabled() && this.hasBookshelf;
        }

        public DefaultSettings withBookshelf() {
            this.hasBookshelf = true;
            return this;
        }

        public boolean hasStorageBookshelf() {
            return this.isEnabled() && this.hasStorageBookshelf;
        }

        public DefaultSettings withStorageBookshelf() {
            this.hasStorageBookshelf = true;
            return this;
        }

        public boolean hasDisplayCase() {
            return this.isEnabled() && this.hasDisplayCase;
        }

        public DefaultSettings withDisplayCase() {
            this.hasDisplayCase = true;
            return this;
        }

        public boolean hasStrippedDisplayCase() {
            return this.isEnabled() && this.hasStrippedDisplayCase;
        }

        public DefaultSettings withStrippedDisplayCase() {
            this.hasStrippedDisplayCase = true;
            return this;
        }

        public boolean hasBookshelfDoor() {
            return this.isEnabled() && this.hasBookshelfDoor;
        }

        public DefaultSettings withBookshelfDoor() {
            this.hasBookshelfDoor = true;
            return this;
        }

        public boolean hasChair() {
            return this.isEnabled() && this.hasChair;
        }

        public DefaultSettings withChair() {
            this.hasChair = true;
            return this;
        }

        public boolean hasStool() {
            return this.isEnabled() && this.hasStool;
        }

        public DefaultSettings withStool() {
            this.hasStool = true;
            return this;
        }

        public boolean hasShelf() {
            return this.isEnabled() && this.hasShelf;
        }

        public DefaultSettings withShelf() {
            this.hasShelf = true;
            return this;
        }

        public boolean hasFloatingShelf() {
            return this.isEnabled() && this.hasFloatingShelf;
        }

        public DefaultSettings withFloatingShelf() {
            this.hasFloatingShelf = true;
            return this;
        }

        public boolean hasTable() {
            return this.isEnabled() && this.hasTable;
        }

        public DefaultSettings withTable() {
            this.hasTable = true;
            return this;
        }

        public boolean hasBookshelfTrapdoor() {
            return this.isEnabled() && this.hasBookshelfTrapdoor;
        }

        public DefaultSettings withBookshelfTrapdoor() {
            this.hasBookshelfTrapdoor = true;
            return this;
        }

        @Override
        public Identifier getBlockId() {
            return null;
        }

        @Override
        public String getNamePattern() {
            return null;
        }
    }
}
