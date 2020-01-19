package com.sam.helpfulboxes.common.block.box;

import com.sam.helpfulboxes.common.Dictionary;
import com.sam.helpfulboxes.common.block.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class HopBox extends BlockMod {

    public HopBox()    {
        super(Dictionary.Block.HOP_BOX, Block.Properties.create(Material.WOOD));
    }

}
