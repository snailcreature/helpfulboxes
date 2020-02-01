package com.sam.helpfulboxes.common.block.tileentity;

import com.google.common.collect.ImmutableSet;
import com.sam.helpfulboxes.common.block.ModBlocks;
import com.sam.helpfulboxes.common.lib.Dictionary;
import net.minecraft.block.Block;
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

    public TEHopBox()   {
        super(TYPE);
        setValues(Dictionary.Block.HOP_BOX, ModBlocks.HOP_BOX);
        System.out.println("HopBox created at " + pos.toString());
    }

    public boolean link(BlockPos block, boolean source)  {
        if (!getWorld().isRemote)   {
            TEHopBox entity = (TEHopBox) getWorld().getTileEntity(block);
            linkPos = block;
            written = true;
//            System.out.println("Linking to " + linkPos.toString());
//            if (source) {
//                return entity.link(pos, false);
//            }
            System.out.println("Linked to " + linkPos.toString());
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

    public boolean isWritten()  {
        return written;
    }

    @Override
    public void writePacketNBT(CompoundNBT cmp) {
        if (written) {
            cmp.putInt(TAG_linkPosX, linkPos.getX());
            cmp.putInt(TAG_linkPosY, linkPos.getY());
            cmp.putInt(TAG_linkPosZ, linkPos.getZ());
        }   else    {
            cmp.putInt(TAG_linkPosX, 0);
            cmp.putInt(TAG_linkPosY, 0);
            cmp.putInt(TAG_linkPosZ, 0);
        }
    }

    @Override
    public void readPacketNBT(CompoundNBT cmp)  {
        if (written) {
            linkPos = new BlockPos(
                    cmp.getInt(TAG_linkPosX),
                    cmp.getInt(TAG_linkPosY),
                    cmp.getInt(TAG_linkPosZ)
            );
        }
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
