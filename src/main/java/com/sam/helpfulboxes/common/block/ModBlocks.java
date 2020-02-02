package com.sam.helpfulboxes.common.block;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import com.sam.helpfulboxes.common.block.box.BlockHopBox;
import com.sam.helpfulboxes.common.block.tileentity.ModTileEntity;
import com.sam.helpfulboxes.common.block.tileentity.TEHopBox;
import com.sam.helpfulboxes.common.lib.Dictionary;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Dictionary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModBlocks {

    public static ArrayList<Block> modBlocks = new ArrayList<>();
    public static ArrayList<Item> modBlockItems = new ArrayList<>();

    public static ArrayList<Supplier<? extends ModTileEntity>> modTileEntities = new ArrayList<>();

    private static void addTileEntity(Supplier<? extends ModTileEntity> tileEntity)    {
        modTileEntities.add(tileEntity);
    }

    // List blocks here
    public static BlockMod HOP_BOX = new BlockHopBox();

    // List blockItems here
    public static ItemBlockMod IHOP_BOX = new ItemBlockMod(Dictionary.Block.HOP_BOX, HOP_BOX);

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
    public static void registerTEs(RegistryEvent.Register<TileEntityType<?>> event)    {
        IForgeRegistry<TileEntityType<?>> reggy = event.getRegistry();

        // List tileEntities here
        addTileEntity(TEHopBox::new);

        for (Supplier<? extends ModTileEntity> entity : modTileEntities)    {
            register(entity.get().id, TileEntityType.Builder.create(entity, entity.get().validBlock));
        }
    }

    private static ResourceLocation floating(ResourceLocation orig) {
        return new ResourceLocation(orig.getNamespace(), "floating_" + orig.getPath());
    }

    private static <T extends ModTileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
        Type<?> type = null;

        try {
            type = DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getVersion().getWorldVersion())).getChoiceType(TypeReferences.BLOCK_ENTITY, key);
        } catch (IllegalArgumentException illegalStatException) {
            if (SharedConstants.developmentMode) {
                throw illegalStatException;
            }
        }

        return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
    }

}
