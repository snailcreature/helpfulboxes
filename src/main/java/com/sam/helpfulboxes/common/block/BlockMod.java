package com.sam.helpfulboxes.common.block;


import net.minecraft.block.Block;

public class BlockMod extends Block {

    public BlockMod(String id, Properties properties) {
        super(properties);
        setRegistryName(id);
        ModBlocks.modBlocks.add(this);
    }

}
