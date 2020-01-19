package com.sam.helpfulboxes.common.block.box;

import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.block.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.Dimension;


public class HopBox extends BlockMod {

    private BlockPos linkPos = null;
    private Dimension linkDim = null;

    public HopBox()    {
        super(Dictionary.Block.HOP_BOX, Block.Properties.create(Material.WOOD));
    }

    public BlockPos getLinkPos()    {
        return linkPos;
    }

    public Dimension getLinkDim()   {
        return linkDim;
    }

    public boolean isWritten()  {
        return linkPos != null;
    }

}
