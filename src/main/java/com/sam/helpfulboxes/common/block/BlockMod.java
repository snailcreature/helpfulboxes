package com.sam.helpfulboxes.common.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockMod extends Block {

    public BlockMod(String id, Block.Properties properties) {
        super(properties);
        setRegistryName(id);
        ModBlocks.modBlocks.add(this);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return super.createTileEntity(state, world);
    }
}
