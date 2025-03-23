package com.kingshiraishi.mcm_monsterhunterlike.entity.client;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.entity.custom.FourlegsEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FourlegsRenderer extends MobRenderer<FourlegsEntity, FourlegsModel<FourlegsEntity>> {
    public FourlegsRenderer(EntityRendererProvider.Context pc) {
        super(pc, new FourlegsModel<>(pc.bakeLayer(FourlegsModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(FourlegsEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(MonsterHunterLikeMod.MOD_ID, "textures/entity/fourlegs/fourlegs.png");
    }

    @Override
    public void render(FourlegsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(5f, 5f, 5f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
