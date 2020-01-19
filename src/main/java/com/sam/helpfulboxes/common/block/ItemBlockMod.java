package com.sam.helpfulboxes.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class ItemBlockMod extends BlockItem {
    public ItemBlockMod(String id, Block block, Properties properties) {
        super(block, properties);
        setRegistryName(id);
        ModBlocks.modBlockItems.add(this);
    }

    public ItemBlockMod(String id, Block block) {
        this(id, block, new Properties().group(ItemGroup.BUILDING_BLOCKS));
    }
}
