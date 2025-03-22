package com.kingshiraishi.mcm_monsterhunterlike.datagen;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MonsterHunterLikeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ICON__KING_CROWN.get());
        basicItem(ModItems.ITEM__RED_ORB.get());
        basicItem(ModItems.ITEM__BLUE_ORB.get());
    }
}
