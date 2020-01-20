package com.sam.helpfulboxes.common.block.box;

import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.block.BlockMod;
import com.sam.helpfulboxes.common.lib.TagDict;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import javax.annotation.Nullable;


public class HopBox extends BlockMod {

    private BlockPos linkPos = null;
    private DimensionType linkDim = null;
    private BlockPos thisPos;
    private DimensionType thisDim;

    public HopBox()    {
        super(Dictionary.Block.HOP_BOX, Block.Properties.create(Material.WOOD));
    }

    public BlockPos getLinkPos()    {
        return linkPos;
    }
    public DimensionType getLinkDim()   {
        return linkDim;
    }

    public boolean setLink(BlockPos pos, DimensionType dim, World world) {
        linkPos = pos;
        linkDim = dim;

        Block linkedBlock = world.getBlockState(pos).getBlock();
        if (linkedBlock.getTags().contains(TagDict.Blocks.HOP_BOX)) {
            return ((HopBox) linkedBlock).setLink(thisPos, thisDim);
        }
        return false;
    }

    public boolean setLink(BlockPos pos, DimensionType dim)    {
        linkPos = pos;
        linkDim = dim;
        return true;
    }

    public boolean isWritten()  {
        return linkPos != null;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        thisPos = pos;
        thisDim = worldIn.getDimension().getType();
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
}
