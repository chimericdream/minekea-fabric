package net.fabricmc.chimericdream.model;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.chimericdream.ShelfStorageMod;
import net.fabricmc.chimericdream.block.bookshelf.AcaciaStorageShelfBlockEntity;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class AcaciaStorageShelfModel implements UnbakedModel, BakedModel, FabricBakedModel {
    private static final Identifier DEFAULT_BLOCK_MODEL = new Identifier("minecraft:block/block");
    private ModelTransformation transformation;
    private static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("shelfstorage:block/bookshelves/acacia/shelf0")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft:block/acacia_planks")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("shelfstorage:block/bookshelves/acacia/empty_shelf")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("shelfstorage:block/bookshelves/acacia/one_quarter_shelf")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("shelfstorage:block/bookshelves/acacia/one_half_shelf")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("shelfstorage:block/bookshelves/acacia/three_quarters_shelf")),
    };
    private Sprite[] SPRITES = new Sprite[6];
    private Mesh defaultMesh;
    private Mesh emptyMesh;
    private Mesh oneQuarterMesh;
    private Mesh oneHalfMesh;
    private Mesh threeQuartersMesh;

    @Override
    public Collection<Identifier> getModelDependencies() {
        return Arrays.asList(DEFAULT_BLOCK_MODEL);
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Arrays.asList(SPRITE_IDS); // The textures this model (and all its model dependencies, and their dependencies, etc...!) depends on.
    }

    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
        // Load the default block model
        JsonUnbakedModel defaultBlockModel = (JsonUnbakedModel) loader.getOrLoadModel(DEFAULT_BLOCK_MODEL);

        // Get its ModelTransformation
        transformation = defaultBlockModel.getTransformations();

        // Get the sprites
        for (int i = 0; i < 6; ++i) {
            SPRITES[i] = textureGetter.apply(SPRITE_IDS[i]);
        }

        // Build the mesh using the Renderer API
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderer.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        for (Direction direction : Direction.values()) {
            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? 1 : 0;

            // Add a new face to the mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);

            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);

            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);

            // Add the quad to the mesh
            emitter.emit();
        }

        defaultMesh = builder.build();
        emitter = builder.getEmitter();

        for (Direction direction : Direction.values()) {
            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? 1 : 2;

            // Add a new face to the mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);

            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);

            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);

            // Add the quad to the mesh
            emitter.emit();
        }

        emptyMesh = builder.build();
        emitter = builder.getEmitter();

        for (Direction direction : Direction.values()) {
            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? 1 : 3;

            // Add a new face to the mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);

            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);

            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);

            // Add the quad to the mesh
            emitter.emit();
        }

        oneQuarterMesh = builder.build();
        emitter = builder.getEmitter();

        for (Direction direction : Direction.values()) {
            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? 1 : 4;

            // Add a new face to the mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);

            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);

            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);

            // Add the quad to the mesh
            emitter.emit();
        }

        oneHalfMesh = builder.build();
        emitter = builder.getEmitter();

        for (Direction direction : Direction.values()) {
            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? 1 : 5;

            // Add a new face to the mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);

            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);

            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);

            // Add the quad to the mesh
            emitter.emit();
        }

        threeQuartersMesh = builder.build();

        return this;
    }

    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction face, Random random) {
        // Don't need because we use FabricBakedModel instead. However, it's better to not return null in case some mod decides to call this function.
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true; // we want the block to have a shadow depending on the adjacent blocks
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public Sprite getParticleSprite() {
        return SPRITES[1]; // Block break particle, let's use furnace_top
    }

    @Override
    public ModelTransformation getTransformation() {
        return transformation;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false; // False to trigger FabricBakedModel rendering
    }

    @Override
    public void emitBlockQuads(BlockRenderView view, BlockState state, BlockPos pos, Supplier<Random> supplier, RenderContext context) {
        AcaciaStorageShelfBlockEntity entity = (AcaciaStorageShelfBlockEntity) view.getBlockEntity(pos);

        AcaciaStorageShelfBlockEntity actualEntity = (AcaciaStorageShelfBlockEntity) entity.getWorld().getBlockEntity(pos);

        if (actualEntity == null) {
            ShelfStorageMod.LOGGER.info("Entity is null");
        }

        if (entity == null) {
            ShelfStorageMod.LOGGER.info("Entity is null");
            context.meshConsumer().accept(emptyMesh);
            return;
        }

        DefaultedList<ItemStack> items = entity.getItems();
        DefaultedList<ItemStack> actualItems = actualEntity.getItems();

        ShelfStorageMod.LOGGER.info(String.format("item count: %d", items.size()));
        ShelfStorageMod.LOGGER.info(String.format("actual item count: %d", actualItems.size()));

        long actual_slots_used = actualItems.stream().filter(stack -> {
            ShelfStorageMod.LOGGER.info(String.format("actual stack count: %d", stack.getCount()));
            ShelfStorageMod.LOGGER.info(String.format("actual stack contents: %s", stack.getItem().getTranslationKey()));
            return !stack.equals(ItemStack.EMPTY);
        }).count();

        long slots_used = items.stream().filter(stack -> {
            ShelfStorageMod.LOGGER.info(String.format("stack count: %d", stack.getCount()));
            ShelfStorageMod.LOGGER.info(String.format("stack contents: %s", stack.getItem().getTranslationKey()));
            return !stack.equals(ItemStack.EMPTY);
        }).count();

        if (slots_used == 9) {
            context.meshConsumer().accept(defaultMesh);
            return;
        }

        if (slots_used > 6) {
            context.meshConsumer().accept(threeQuartersMesh);
            return;
        }

        if (slots_used > 3) {
            context.meshConsumer().accept(oneHalfMesh);
            return;
        }

        if (slots_used > 0) {
            context.meshConsumer().accept(oneQuarterMesh);
            return;
        }

        context.meshConsumer().accept(emptyMesh);
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> supplier, RenderContext context) {
        context.meshConsumer().accept(defaultMesh);
    }
}
