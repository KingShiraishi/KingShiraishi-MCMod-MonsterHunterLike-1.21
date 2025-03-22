package com.kingshiraishi.mcm_monsterhunterlike.datagen;

import com.kingshiraishi.mcm_monsterhunterlike.block.ModBlocks;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK__RED_ORB_BLOCK.get())
                .pattern("## ")
                .pattern("## ")
                .pattern("   ")
                .define('#', ModItems.ITEM__RED_ORB.get())
                .unlockedBy(getHasName(ModItems.ITEM__RED_ORB.get()), has(ModItems.ITEM__RED_ORB.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK__BLUE_ORB_BLOCK.get())
                .pattern("## ")
                .pattern("## ")
                .pattern("   ")
                .define('#', ModItems.ITEM__BLUE_ORB.get())
                .unlockedBy(getHasName(ModItems.ITEM__BLUE_ORB.get()), has(ModItems.ITEM__BLUE_ORB.get()))
                .save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ITEM__RED_ORB.get(), 4)
                .requires(ModBlocks.BLOCK__RED_ORB_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK__RED_ORB_BLOCK.get()), has(ModBlocks.BLOCK__RED_ORB_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ITEM__BLUE_ORB.get(), 4)
                .requires(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get()), has(ModBlocks.BLOCK__BLUE_ORB_BLOCK.get()))
                .save(pRecipeOutput);
    }
}
