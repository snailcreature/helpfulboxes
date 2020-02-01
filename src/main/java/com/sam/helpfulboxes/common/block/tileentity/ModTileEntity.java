package com.sam.helpfulboxes.common.block.tileentity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;
import java.util.Set;

public abstract class ModTileEntity extends TileEntity {

    public String id;
    public Block validBlock;

    public ModTileEntity(TileEntityType<?> tileEntityTypeIn)  {
        super(tileEntityTypeIn);
    }

    public void setValues(String id, Block validBlock)   {
        this.id = id;
        this.validBlock = validBlock;
    }

    @Nonnull
    @Override
    public CompoundNBT write(CompoundNBT nbtToWrite)    {
        CompoundNBT ret = super.write(nbtToWrite);
        writePacketNBT(ret);
        return ret;
    }

    @Override
    public void read(CompoundNBT nbtToRead) {
        super.read(nbtToRead);
        readPacketNBT(nbtToRead);
    }

    public void writePacketNBT(CompoundNBT cmp) { }

    public void readPacketNBT(CompoundNBT cmp)  { }

    @Nonnull
    @Override
    public final CompoundNBT getUpdateTag() {   return write(new CompoundNBT());    }

    @Override
    public final SUpdateTileEntityPacket getUpdatePacket()  {
        CompoundNBT tag = new CompoundNBT();
        writePacketNBT(tag);
        return new SUpdateTileEntityPacket(pos, -999, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)    {
        super.onDataPacket(net, packet);
        readPacketNBT(packet.getNbtCompound());
    }

}
