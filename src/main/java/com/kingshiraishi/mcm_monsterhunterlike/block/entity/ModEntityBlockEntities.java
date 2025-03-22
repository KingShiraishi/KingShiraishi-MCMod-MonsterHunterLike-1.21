package com.kingshiraishi.mcm_monsterhunterlike.block.entity;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.block.ModBlocks;
import com.kingshiraishi.mcm_monsterhunterlike.block.entity.custom.PedestalEntityBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> ENTITY_BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MonsterHunterLikeMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PedestalEntityBlockEntity>> PEDESTAL_BLOCKENTITY = ENTITY_BLOCK_ENTITIES.register(
            "pedestal_entity", () -> BlockEntityType.Builder.of(
                    PedestalEntityBlockEntity::new, ModBlocks.ENTITY_BLOCK__PEDESTAL.get())
                    .build(null));

    public static void register(IEventBus i) { ENTITY_BLOCK_ENTITIES.register(i); }
}
