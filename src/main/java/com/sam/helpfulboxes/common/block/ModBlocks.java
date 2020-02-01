package com.sam.helpfulboxes.common.block;

import com.google.common.collect.ImmutableList;
import com.sam.helpfulboxes.common.block.tileentity.HopBoxTileEntity;
import com.sam.helpfulboxes.common.block.tileentity.ModTileEntity;
import com.sam.helpfulboxes.common.lib.Dictionary;
import com.sam.helpfulboxes.common.block.box.HopBox;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Dictionary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModBlocks {

    public static ArrayList<Block> modBlocks = new ArrayList<>();
    public static ArrayList<Item> modBlockItems = new ArrayList<>();
    public static ArrayList<TileEntity> modTileEntities = new ArrayList<>();

    // List blocks here
    public static BlockMod HOP_BOX = new HopBox();

    // List blockItems here
    public static ItemBlockMod IHOP_BOX = new ItemBlockMod(Dictionary.Block.HOP_BOX, HOP_BOX);

    public static final List<Pair<Supplier<? extends TileEntity>, ResourceLocation>> TYPES = ImmutableList.<Pair<Supplier<? extends TileEntity>, ResourceLocation>>of(
            // List tileEntities here
            // Pair.of(<tile>::new, Dictionary.Tile.<block_name>),
            Pair.of(HopBoxTileEntity::new, Dictionary.Tile.HOP_BOX)
    );


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)  {
        IForgeRegistry<Block> reggy = event.getRegistry();

        modBlocks.forEach(reggy::register);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)   {
        IForgeRegistry<Item> reggy = event.getRegistry();

        modBlockItems.forEach(reggy::register);
    }

    @SubscribeEvent
    public static void registerTEs(RegistryEvent.Register<TileEntityType<?>> event) {
        IForgeRegistry<Block> b = ForgeRegistries.BLOCKS;
        IForgeRegistry<TileEntityType<?>> reggy = event.getRegistry();

        for (Pair<Supplier<? extends TileEntity>, ResourceLocation> type : TYPES){
            Block block = b.getValue(type.getRight());
            Block floating = b.getValue(floating(type.getRight()));
            register(reggy, TileEntityType.Builder.create(type.getLeft(), block, floating).build(null), type.getRight());
        }
    }

    private static ResourceLocation floating(ResourceLocation orig) {
        return new ResourceLocation(orig.getNamespace(), "floating_" + orig.getPath());
    }

    private static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> entry, ResourceLocation name) {
        reg.register(entry.setRegistryName(name));
    }

}
