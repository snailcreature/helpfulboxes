package com.sam.helpfulboxes.common.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class ModTileEntity extends TileEntity {

    public ModTileEntity(TileEntityType<?> tileEntityTypeIn)  {
        super(tileEntityTypeIn);

    }

}
