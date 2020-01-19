package com.sam.helpfulboxes.common.item.tool;

import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.item.ItemMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;

public class LinkStone extends ItemMod {

    private BlockPos linkPos = null;
    private Dimension linkDim = null;

    public LinkStone() {
        super(Dictionary.Item.LINK_STONE, new Properties());
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        Block block = world.getBlockState(pos).getBlock();

        return super.onItemUse(context);
    }

    public boolean isWritten()  {
        return linkPos != null;
    }
}
