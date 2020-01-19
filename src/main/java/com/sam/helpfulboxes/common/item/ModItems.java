package com.sam.helpfulboxes.common.item;

import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.item.tool.LinkStone;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Dictionary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static ArrayList<Item> modItems = new ArrayList<>();

    // List items here
    // public static ItemMod EXAMPLE_ITEM = new ItemMod(Dictionary.Item.EXAMPLE_ITEM);

    public static ItemMod LINK_STONE = new LinkStone();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)    {
        IForgeRegistry<Item> reggy = event.getRegistry();

        modItems.forEach(reggy::register);
    }

}
