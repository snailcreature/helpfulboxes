package com.sam.helpfulboxes.common.core;

import com.sam.helpfulboxes.common.Dictionary;
import com.sam.helpfulboxes.common.item.ItemMod;
import com.sam.helpfulboxes.common.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public final class HelpfulBoxesCreativeTab extends ItemGroup {

    public static final HelpfulBoxesCreativeTab instance = new HelpfulBoxesCreativeTab();
    private NonNullList<ItemStack> list;

    public HelpfulBoxesCreativeTab()    {
        super(Dictionary.MOD_ID);
        setNoTitle();
    }

    @Override
    public ItemStack createIcon() {
        return null;
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public void fill(@Nonnull NonNullList<ItemStack> items) {
        list = items;

        for (Item item : ModItems.modItems)  {
            addItem(item);
        }
    }

    private void addItem(IItemProvider item)    {
        item.asItem().fillItemGroup(this, list);
    }
}
