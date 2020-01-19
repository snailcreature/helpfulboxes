package com.sam.helpfulboxes.data;

import com.sam.helpfulboxes.common.block.ModBlocks;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.lib.TagDict;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class BlockTagProvider extends BlockTagsProvider {

    public BlockTagProvider(DataGenerator generator)    {
        super(generator);
    }

    @Override
    protected void registerTags() {
        Predicate<Block> helpfulBoxes = h -> Dictionary.MOD_ID.equals(h.getRegistryName().getNamespace());

        getBuilder(TagDict.Blocks.HOP_BOX).add(ModBlocks.HOP_BOX);
    }

    @Nonnull
    @Override
    public String getName() {
        return "HelpfulBoxes block tags";
    }
}
