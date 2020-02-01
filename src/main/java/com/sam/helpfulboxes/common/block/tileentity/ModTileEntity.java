package com.sam.helpfulboxes.common.block.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class ModTileEntity extends TileEntity {

    public String id;

    public ModTileEntity(TileEntityType<?> tileEntityTypeIn)  {
        super(tileEntityTypeIn);
    }

}
