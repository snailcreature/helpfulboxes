package com.sam.helpfulboxes.common.block.tileentity;

import com.sam.helpfulboxes.common.block.box.HopBox;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

public class HopBoxTileEntity extends ModTileEntity {

    private BlockPos linkPos = null;
    private DimensionType linkDim = null;
    private BlockPos thisPos;
    private DimensionType thisDim;
    private HopBox linkedBox;

    public HopBoxTileEntity()   {
        super(TileEntityType.STRUCTURE_BLOCK);
    }

}
