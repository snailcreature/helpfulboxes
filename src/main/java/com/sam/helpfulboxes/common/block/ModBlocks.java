package com.sam.helpfulboxes.common.block;

import com.sam.helpfulboxes.common.Dictionary;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Dictionary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModBlocks {

    public static ArrayList<Block> modBlocks = new ArrayList<>();

    // List blocks here

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)  {
        IForgeRegistry<Block> reggy = event.getRegistry();

        modBlocks.forEach(reggy::register);
    }

}
