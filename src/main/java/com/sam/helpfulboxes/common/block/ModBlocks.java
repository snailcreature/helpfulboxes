package com.sam.helpfulboxes.common.block;

import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.block.box.HopBox;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Dictionary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModBlocks {

    public static ArrayList<Block> modBlocks = new ArrayList<>();
    public static ArrayList<Item> modBlockItems = new ArrayList<>();

    // List blocks here
    public static BlockMod HOP_BOX = new HopBox();

    // List blockItems here
    public static ItemBlockMod IHOP_BOX = new ItemBlockMod(Dictionary.Block.HOP_BOX, HOP_BOX);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)  {
        IForgeRegistry<Block> reggy = event.getRegistry();

        modBlocks.forEach(reggy::register);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)   {
        IForgeRegistry<Item> reggy = event.getRegistry();

        modBlockItems.forEach(reggy::register);
    }

}
