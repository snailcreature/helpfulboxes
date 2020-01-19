package com.sam.helpfulboxes.common.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class TagDict {

    public static class Items   {

        public static final Tag<Item> LINK_STONE = tag(Dictionary.Item.LINK_STONE);

        private static Tag<Item> tag(String name)   {
            return new ItemTags.Wrapper(new ResourceLocation(Dictionary.MOD_ID, name));
        }

    }

    public static class Blocks  {

        public static final Tag<Block> HOP_BOX = tag(Dictionary.Block.HOP_BOX);

        private static Tag<Block> tag(String name)  {
            return new BlockTags.Wrapper(new ResourceLocation(Dictionary.MOD_ID, name));
        }

    }

}
