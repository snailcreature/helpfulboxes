package com.sam.helpfulboxes.common.block.tileentity;

import com.google.common.collect.ImmutableSet;
import com.sam.helpfulboxes.common.block.ModBlocks;
import com.sam.helpfulboxes.common.lib.Dictionary;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.Set;


public class TEHopBox extends ModTileEntity {

    public static TileEntityType<TEHopBox> TYPE;

    private BlockPos linkPos = null;
    private Boolean written = false;

    private static final String TAG_linkPosX = "linkPosX";
    private static final String TAG_linkPosY = "linkPosY";
    private static final String TAG_linkPosZ = "linkPosZ";
    private static final String TAG_written  = "written" ;

    public TEHopBox()   {
        super(TYPE);
        setValues(Dictionary.Block.HOP_BOX, ModBlocks.HOP_BOX);
        System.out.println("HopBox created at " + pos.toString());
    }

    public boolean link(BlockPos block)  {
        if (!getWorld().isRemote)   {
            TEHopBox entity = (TEHopBox) getWorld().getTileEntity(block);
            linkPos = entity.pos;
            written = true;
            System.out.println(pos.toString() + " linked to " + linkPos.toString());
            return true;
        }
        return false;
    }

    public boolean unlink() {
        linkPos = null;
        written = false;
        System.out.println("Unlinked");
        return true;
    }

    public boolean teleport(Entity entityIn)    {
        if (written) {
            double x = linkPos.getX();
            double y = linkPos.getY();
            double z = linkPos.getZ();
            if (!getWorld().isRemote) {
                entityIn.setPosition(x + 1, y + 1, z + 1);
                System.out.println(entityIn.getName().getFormattedText() + " teleported to " + entityIn.getPosition().toString());
            }
            return true;
        }
        return false;
    }

    public boolean isWritten()  {
        return written;
    }

    @Override
    public void writePacketNBT(CompoundNBT cmp) {
        cmp.putBoolean(TAG_written, written);
        if (written) {
            cmp.putInt(TAG_linkPosX, linkPos.getX());
            cmp.putInt(TAG_linkPosY, linkPos.getY());
            cmp.putInt(TAG_linkPosZ, linkPos.getZ());
        }   else    {
            cmp.putInt(TAG_linkPosX, 0);
            cmp.putInt(TAG_linkPosY, 0);
            cmp.putInt(TAG_linkPosZ, 0);
        }
        System.out.println("Writing done");
    }

    @Override
    public void readPacketNBT(CompoundNBT cmp)  {
        cmp.getBoolean(TAG_written);
        if (written) {
            linkPos = new BlockPos(
                    cmp.getInt(TAG_linkPosX),
                    cmp.getInt(TAG_linkPosY),
                    cmp.getInt(TAG_linkPosZ)
            );
        }
        System.out.println("Reading done");
    }

    public BlockPos getLinkPos() {
        return linkPos;
    }

    public String getId()   {
        return id;
    }

    public Block getValidBlock()  {
        return validBlock;
    }
}
