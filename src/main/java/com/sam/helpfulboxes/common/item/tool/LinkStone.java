package com.sam.helpfulboxes.common.item.tool;

import com.sam.helpfulboxes.common.Dictionary;
import com.sam.helpfulboxes.common.item.ItemMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LinkStone extends ItemMod {

    public LinkStone() {
        super(Dictionary.Item.LINK_STONE, new Properties());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
