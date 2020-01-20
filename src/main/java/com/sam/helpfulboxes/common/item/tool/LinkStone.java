package com.sam.helpfulboxes.common.item.tool;

import com.sam.helpfulboxes.common.block.box.HopBox;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.item.ItemMod;
import com.sam.helpfulboxes.common.lib.TagDict;
import net.minecraft.block.Block;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class LinkStone extends ItemMod {

    private BlockPos linkPos = null;
    private DimensionType linkDim = null;

    public LinkStone() {
        super(Dictionary.Item.LINK_STONE, new Properties());
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        Block block = world.getBlockState(pos).getBlock();

        if (block.getTags().contains(TagDict.Blocks.HOP_BOX))   {
            if (isWritten()) {
                if (!((HopBox) block).isWritten()) {
                    Boolean check = ((HopBox) block).setLink(linkPos, linkDim, world);
                    if (check) {
                        System.out.println("Block Write SUCCESS");
                        return ActionResultType.SUCCESS;
                    }
                    System.out.println("Block Write FAIL");
                    return ActionResultType.FAIL;
                }
            }
            else    {
                if (((HopBox) block).isWritten())   {
                    linkPos = pos;
                    linkDim = world.getDimension().getType();
                    System.out.println("Stone Write SUCCESS");
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onItemUse(context);
    }

    public boolean isWritten()  {
        return linkPos != null;
    }
}
