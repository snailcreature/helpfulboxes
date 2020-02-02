package com.sam.helpfulboxes.common.block.box;

import com.sam.helpfulboxes.common.block.tileentity.TEHopBox;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.block.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public class HopBox extends BlockMod {

    public HopBox()    {
        super(Dictionary.Block.HOP_BOX, Block.Properties.create(Material.WOOD));
    }

    public boolean setLink(BlockPos pos, World world) {
        TileEntity ent = world.getTileEntity(pos);
        if (ent instanceof TEHopBox) {
            TEHopBox entity = (TEHopBox) ent;
            return entity.link(pos, true);
        }
        return false;
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world)  {
        return new TEHopBox();
    }

    @Override
    public boolean hasTileEntity(BlockState state)  {   return true;    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        System.out.println("onFallenUpon triggered");
        TEHopBox box = (TEHopBox) worldIn.getTileEntity(pos);
        box.teleport(entityIn);
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }

    @Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
        unlink(pos, world);
        super.onBlockExploded(state, world, pos, explosion);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        unlink(pos, worldIn);
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    public boolean unlink(BlockPos pos, World world) {
        if (!world.isRemote) {
            TileEntity ent = world.getTileEntity(pos);
            if (ent instanceof TEHopBox) {
                BlockPos linkedPos = ((TEHopBox) ent).getLinkPos();
                TEHopBox linkedEnt = (TEHopBox) world.getTileEntity(linkedPos);
                if (linkedEnt != null)  {
                    return linkedEnt.unlink();
                }
            }
        }
        return false;
    }
}
