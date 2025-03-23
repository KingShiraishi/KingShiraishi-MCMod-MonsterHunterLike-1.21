package com.kingshiraishi.mcm_monsterhunterlike.event;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.entity.ModEntities;
import com.kingshiraishi.mcm_monsterhunterlike.entity.client.FourlegsModel;
import com.kingshiraishi.mcm_monsterhunterlike.entity.custom.FourlegsEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MonsterHunterLikeMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FourlegsModel.LAYER_LOCATION, FourlegsModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FOURLEGS.get(), FourlegsEntity.createAttributes().build());
    }
}
