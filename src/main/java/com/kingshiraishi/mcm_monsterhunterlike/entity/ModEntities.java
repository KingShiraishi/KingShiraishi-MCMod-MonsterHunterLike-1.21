package com.kingshiraishi.mcm_monsterhunterlike.entity;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.entity.custom.FourlegsEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MonsterHunterLikeMod.MOD_ID);

    public static final RegistryObject<EntityType<FourlegsEntity>> FOURLEGS = ENTITY_TYPES.register(
            "fourlegs",
            () -> EntityType.Builder.of(FourlegsEntity::new, MobCategory.CREATURE)
                    .sized(5.0f, 5.0f)
                    .build(MonsterHunterLikeMod.MOD_ID + ":fourlegs"));


    public static void register(IEventBus i) { ENTITY_TYPES.register(i); }
}
