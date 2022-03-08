package net.fabricmc.chimericdream.model;

import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;

public class AcaciaStorageShelfModelProvider implements ModelResourceProvider {
    public static final Identifier ACACIA_STORAGE_SHELF_MODEL = new Identifier("shelfstorage:block/acacia_storage_shelf");
    public static final Identifier ACACIA_STORAGE_SHELF_MODEL_ITEM = new Identifier("shelfstorage:item/acacia_storage_shelf");

    @Override
    public UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) throws ModelProviderException {
        if(identifier.equals(ACACIA_STORAGE_SHELF_MODEL) || identifier.equals(ACACIA_STORAGE_SHELF_MODEL_ITEM)) {
            return new AcaciaStorageShelfModel();
        } else {
            return null;
        }
    }
}
