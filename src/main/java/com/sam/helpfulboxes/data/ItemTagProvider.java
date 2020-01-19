package com.sam.helpfulboxes.data;


import com.sam.helpfulboxes.common.item.ModItems;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.lib.TagDict;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;

import java.util.function.Predicate;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags()   {
        Predicate<Item> helpfulBoxes = h -> Dictionary.MOD_ID.equals(h.getRegistryName().getNamespace());

        getBuilder(TagDict.Items.LINK_STONE).add(ModItems.LINK_STONE);
    }

}
