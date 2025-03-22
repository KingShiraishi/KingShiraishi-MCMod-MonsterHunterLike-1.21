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

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Template
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

//     public static final RegistryObject<Item> ITEM_NAME = MOD_ITEMS.register(
//             "item_name", () -> new Item(new Item.Properties()));

//        public static final RegistryObject<Item> ITEM_NAME_WITH_CUSTOM_TOOLTIP = MOD_ITEMS.register(
//                "item_name_with_custom_tooltip", () -> new Item(new Item.Properties()) {
//                @Override
//                public void appendHoverText(ItemStack ps, TooltipContext pc, List<Component> pTooltipComponents, TooltipFlag f) {
//                        pTooltipComponents.add(Component.translatable(Screen.hasShiftDown()
//                                ? "tooltip.kingshiraishi.item_name.shift_down"
//                                : "tooltip.kingshiraishi.item_name"));
//                super.appendHoverText(ps, pc, pTooltipComponents, f);
//                }});

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Items
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<Item> ICON__KING_CROWN = MOD_ITEMS.register(
            "icon__king_crown", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ITEM__RED_ORB = MOD_ITEMS.register(
            "item__red_orb", () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack ps, TooltipContext pc, List<Component> pTooltipComponents, TooltipFlag f) {
                    pTooltipComponents.add(Component.translatable(Screen.hasShiftDown()
                            ? "tooltip.kingshiraishi.item__red_orb.shift_down"
                            : "tooltip.kingshiraishi.item__red_orb"));
                    super.appendHoverText(ps, pc, pTooltipComponents, f);
                }});

    public static final RegistryObject<Item> ITEM__BLUE_ORB = MOD_ITEMS.register(
            "item__blue_orb", () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack ps, TooltipContext pc, List<Component> pTooltipComponents, TooltipFlag f) {
                    pTooltipComponents.add(Component.translatable(Screen.hasShiftDown()
                            ? "tooltip.kingshiraishi.item__blue_orb.shift_down"
                            : "tooltip.kingshiraishi.item__blue_orb"));
                    super.appendHoverText(ps, pc, pTooltipComponents, f);
                }});

    public static void register(IEventBus i) { MOD_ITEMS.register(i); }
}
