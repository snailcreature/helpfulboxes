package com.sam.helpfulboxes.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemMod extends Item {

    public ItemMod(String id, Properties properties)    {
        super(properties.group(ItemGroup.MISC)); // TODO: Creative tab
        setRegistryName(id);
        ModItems.modItems.add(this);
    }

}
