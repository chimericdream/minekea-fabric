package com.chimericdream.minekea.client.render.entity.feature;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

import java.util.Iterator;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class ArmorireFeatureRenderer<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Map<String, Identifier> ARMOR_TEXTURE_CACHE = Maps.newHashMap();

    private final A leggingsModel;
    private final A bodyModel;
    private final SpriteAtlasTexture armorTrimsAtlas;

    public ArmorireFeatureRenderer(FeatureRendererContext<T, M> context, A leggingsModel, A bodyModel, BakedModelManager bakery) {
        super(context);

        this.leggingsModel = leggingsModel;
        this.bodyModel = bodyModel;
        this.armorTrimsAtlas = bakery.getAtlas(TexturedRenderLayers.ARMOR_TRIMS_ATLAS_TEXTURE);
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.CHEST, i, this.getArmor(EquipmentSlot.CHEST));
        this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.LEGS, i, this.getArmor(EquipmentSlot.LEGS));
    }

    private void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model) {
        ItemStack itemStack = entity.getEquippedStack(armorSlot);

        if (itemStack.getItem() instanceof ArmorItem) {
            ArmorItem armorItem = (ArmorItem) itemStack.getItem();
            if (armorItem.getSlotType() == armorSlot) {
                ((BipedEntityModel) this.getContextModel()).copyBipedStateTo(model);
                this.setVisible(model, armorSlot);

//                boolean bl = this.usesSecondLayer(armorSlot);
//                boolean bl2 = itemStack.hasGlint();

                boolean bl = this.usesInnerModel(armorSlot);
                ArmorMaterial armorMaterial = (ArmorMaterial) armorItem.getMaterial().value();
                int i = itemStack.isIn(ItemTags.DYEABLE) ? ColorHelper.Argb.fullAlpha(DyedColorComponent.getColor(itemStack, -6265536)) : -1;
                Iterator var12 = armorMaterial.layers().iterator();

                while (var12.hasNext()) {
                    ArmorMaterial.Layer layer = (ArmorMaterial.Layer) var12.next();
                    int j = layer.isDyeable() ? i : -1;
                    this.renderArmorParts(matrices, vertexConsumers, light, model, j, layer.getTexture(bl));
                }

                ArmorTrim armorTrim = (ArmorTrim) itemStack.get(DataComponentTypes.TRIM);
                if (armorTrim != null) {
                    this.renderTrim(armorItem.getMaterial(), matrices, vertexConsumers, light, armorTrim, model, bl);
                }

                if (itemStack.hasGlint()) {
                    this.renderGlint(matrices, vertexConsumers, light, model);
                }

//                if (armorItem instanceof DyeableArmorItem) {
//                    int i = ((DyeableArmorItem) armorItem).getColor(itemStack);
//                    float f = (float) (i >> 16 & 255) / 255.0F;
//                    float g = (float) (i >> 8 & 255) / 255.0F;
//                    float h = (float) (i & 255) / 255.0F;
//
//                    this.renderArmorParts(matrices, vertexConsumers, light, armorItem, bl2, model, bl, f, g, h, (String) null);
//                    this.renderArmorParts(matrices, vertexConsumers, light, armorItem, bl2, model, bl, 1.0F, 1.0F, 1.0F, "overlay");
//                } else {
//                    this.renderArmorParts(matrices, vertexConsumers, light, armorItem, bl2, model, bl, 1.0F, 1.0F, 1.0F, (String) null);
//                }

            }
        }
    }

    protected void setVisible(A bipedModel, EquipmentSlot slot) {
        bipedModel.setVisible(false);

        switch (slot) {
            case CHEST -> {
                bipedModel.body.visible = true;
                bipedModel.rightArm.visible = true;
                bipedModel.leftArm.visible = true;
            }
            case LEGS -> {
                bipedModel.body.visible = true;
                bipedModel.rightLeg.visible = true;
                bipedModel.leftLeg.visible = true;
            }
        }

    }

    private void renderArmorParts(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, A model, int i, Identifier identifier) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getArmorCutoutNoCull(identifier));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, i);
    }

    private A getArmor(EquipmentSlot slot) {
        return this.usesSecondLayer(slot) ? this.leggingsModel : this.bodyModel;
    }

    private boolean usesSecondLayer(EquipmentSlot slot) {
        return slot == EquipmentSlot.LEGS;
    }

    private void renderTrim(RegistryEntry<ArmorMaterial> armorMaterial, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArmorTrim trim, A model, boolean leggings) {
        Sprite sprite = this.armorTrimsAtlas.getSprite(leggings ? trim.getLeggingsModelId(armorMaterial) : trim.getGenericModelId(armorMaterial));
        VertexConsumer vertexConsumer = sprite.getTextureSpecificVertexConsumer(vertexConsumers.getBuffer(TexturedRenderLayers.getArmorTrims(((ArmorTrimPattern) trim.getPattern().value()).decal())));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
    }

    private void renderGlint(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, A model) {
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getArmorEntityGlint()), light, OverlayTexture.DEFAULT_UV);
    }

    private boolean usesInnerModel(EquipmentSlot slot) {
        return slot == EquipmentSlot.LEGS;
    }
}
