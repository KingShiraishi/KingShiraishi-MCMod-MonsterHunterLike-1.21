package com.kingshiraishi.mcm_monsterhunterlike.item;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MonsterHunterLikeMod.MOD_ID);

    public static final RegistryObject<Item> ITEM_NAME = MOD_ITEMS.register(
            "item_name", () -> new Item(new Item.Properties()));

    public static void register(IEventBus i) { MOD_ITEMS.register(i); }
}
