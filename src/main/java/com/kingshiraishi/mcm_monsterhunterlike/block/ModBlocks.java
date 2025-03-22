package com.kingshiraishi.mcm_monsterhunterlike.block;

import com.kingshiraishi.mcm_monsterhunterlike.MonsterHunterLikeMod;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MonsterHunterLikeMod.MOD_ID);

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Template
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

//    public static final RegistryObject<Block> BLOCK_NAME = MOD_BLOCKS.register(
//            "block_name", () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()
//                    .sound(SoundType.STONE)
//            ));
//
//    public static final RegistryObject<Block> BLOCK_NAME_RANDOM_DROP = registerBlock(
//            "block_name_random_drop", () -> new DropExperienceBlock(
//                    UniformInt.of(1, 10),
//                    BlockBehaviour.Properties.of()
//                            .strength(1f)
//                            .requiresCorrectToolForDrops()
//            ));

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Blocks
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<Block> BLOCK__RED_ORB_BLOCK = registerBlock(
            "block__red_orb_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final RegistryObject<Block> BLOCK__BLUE_ORB_BLOCK = registerBlock(
            "block__blue_orb_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = MOD_BLOCKS.register(name, block);
        registerBlockItem(name, registryObject);
        return registryObject;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.MOD_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus i) { MOD_BLOCKS.register(i); }
}
