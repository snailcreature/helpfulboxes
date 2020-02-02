package com.sam.helpfulboxes.common.item.tool;

import com.sam.helpfulboxes.common.block.box.BlockHopBox;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.item.ItemMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLinkStone extends ItemMod {

    private BlockPos linkPos = null;
    private boolean written = false;

    public ItemLinkStone() {
        super(Dictionary.Item.LINK_STONE, new Properties().maxStackSize(1));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        System.out.println("onItemUse triggered");
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        Block block = world.getBlockState(pos).getBlock();

        if (!world.isRemote)    {
            if (block instanceof BlockHopBox)    {
                if (written) {
                    if (!pos.equals(linkPos)) {
                        System.out.println("Linking to " + linkPos.toString());
                        ((BlockHopBox) block).setLink(linkPos, world, pos);
                        linkPos = null;
                        written = false;
                        System.out.println("Stone used");
                    }
                }
                else    {
                    linkPos = pos;
                    written = true;
                    System.out.println("Stone written");
                }
            }
        }

        return super.onItemUse(context);
    }

    public boolean isWritten()  {
        return written;
    }
}
