package com.sam.helpfulboxes.common.lib;

import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class Dictionary {

    public static final String MOD_ID = "helpfulboxes";

    public static class Item    {
        // List item IDs here
        // public static final String EXAMPLE_ITEM = "example_item";

        public static final String LINK_STONE = "link_stone";

    }

    public static class Block   {
        // List block IDs here

        public static final String HOP_BOX = "hop_box";
    }

    public static class Tile    {
        // List tile ResourceLocations here

        public static final ResourceLocation HOP_BOX = prefix(Block.HOP_BOX);
    }

    public static ResourceLocation prefix(String path)  {
        return new ResourceLocation(MOD_ID, path);
    }

}
