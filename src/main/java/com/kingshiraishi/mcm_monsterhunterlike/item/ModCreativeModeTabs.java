package com.kingshiraishi.mcm_monsterhunterlike.item;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonsterHunterLikeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB_NAME =
            CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(
                    "tab_name", () -> CreativeModeTab.builder().icon(
                            () -> new ItemStack(ModItems.ICON__KING_CROWN.get()))
                            .title(Component.translatable("creativetab.mcm_monsterhunterlike.tab_name"))
                            .displayItems((itemDisplayParameters, o) -> {
                                o.accept(ModItems.ITEM__RED_ORB.get());
                                o.accept(ModItems.ITEM__BLUE_ORB.get());
                                o.accept(ModBlocks.BLOCK__RED_ORB_BLOCK.get());
                                o.accept(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get());
                            })
                            .build()
                    );

    public static void register(IEventBus i) { CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(i); }
}
