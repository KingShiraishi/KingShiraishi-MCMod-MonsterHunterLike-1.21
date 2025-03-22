package com.kingshiraishi.mcm_monsterhunterlike;

import com.kingshiraishi.mcm_monsterhunterlike.block.ModBlocks;
import com.kingshiraishi.mcm_monsterhunterlike.block.entity.ModEntityBlockEntities;
import com.kingshiraishi.mcm_monsterhunterlike.block.entity.renderer.PedestalEntityBlockEntityRenderer;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModCreativeModeTabs;
import com.kingshiraishi.mcm_monsterhunterlike.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MonsterHunterLikeMod.MOD_ID)
public class MonsterHunterLikeMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mcm_monsterhunterlike";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public MonsterHunterLikeMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityBlockEntities.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerBlockEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModEntityBlockEntities.PEDESTAL_BLOCKENTITY.get(), PedestalEntityBlockEntityRenderer::new);
        }
    }
}
