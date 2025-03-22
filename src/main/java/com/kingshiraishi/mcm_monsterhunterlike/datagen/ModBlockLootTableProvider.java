package com.kingshiraishi.mcm_monsterhunterlike.datagen;

import com.kingshiraishi.mcm_monsterhunterlike.block.ModBlocks;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }


    @Override
    protected void generate() {

////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Template
//
////////////////////////////////////////////////////////////////////////////////////////////////////

//        dropSelf(ModBlocks.BLOCK__RED_ORB_BLOCK.get());
//
//        this.add(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get(), block -> createMultipleItemDrops(
//                ModBlocks.BLOCK__BLUE_ORB_BLOCK.get(),
//                ModItems.ITEM__BLUE_ORB.get(),
//                4.0F,
//                8.0F
//        ));

////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Loot Tables
//
////////////////////////////////////////////////////////////////////////////////////////////////////

        dropSelf(ModBlocks.BLOCK__RED_ORB_BLOCK.get());

        this.add(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get(), block -> createMultipleItemDrops(
                ModBlocks.BLOCK__BLUE_ORB_BLOCK.get(),
                ModItems.ITEM__BLUE_ORB.get(),
                4.0F,
                8.0F
        ));


    }



    protected LootTable.Builder createMultipleItemDrops(Block pBlock, Item item, float dropAmountMin, float dropAmountMax) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(dropAmountMin, dropAmountMax)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.MOD_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
