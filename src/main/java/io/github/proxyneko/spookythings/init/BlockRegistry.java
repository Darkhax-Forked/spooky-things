package io.github.proxyneko.spookythings.init;

import java.util.ArrayList;
import java.util.List;

import io.github.proxyneko.spookythings.SpookyThings;
import io.github.proxyneko.spookythings.common.blocks.BasicLog;
import io.github.proxyneko.spookythings.common.blocks.BasicSapling;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = SpookyThings.MODID)
@GameRegistry.ObjectHolder(SpookyThings.MODID)
public class BlockRegistry {

    private static List<Block> blocks = new ArrayList<>();
    private static List<Item> blockItems = new ArrayList<>();
    
    public static final Block BLOCK_BLOOD_LOG = registerBlock(new BasicLog(), "block_blood_log");
    public static final Block BLOCK_OOZING_LOG = registerBlock(new BasicLog(), "block_ooozing_log");
    //TODO Enable these and find the cause of the crash on startup. - Proxy
    //public static final Block BLOCK_BLOOD_LEAVES = registerBlock(new BasicLeaves(BlockRegistry.BLOCK_BLOOD_SAPLING), "block_blood_leaves");
    //public static final Block BLOCK_OOZING_LEAVES = registerBlock(new BasicLeaves(BlockRegistry.BLOCK_OOZING_SAPLING), "block_oozing_leaves");
    public static final Block BLOCK_BLOOD_PLANKS = registerBlock(new Block(Material.WOOD), "block_blood_leaves");
    public static final Block BLOCK_OOZING_PLANKS = registerBlock(new Block(Material.WOOD), "block_oozing_leaves");
    //TODO Create world generator stuff and change the things the saplings generate. - Proxy
    public static final Block BLOCK_BLOOD_SAPLING = registerBlock(new BasicSapling(new WorldGenBigMushroom()), "block_blood_sapling");
    public static final Block BLOCK_OOZING_SAPLING = registerBlock(new BasicSapling(new WorldGenBirchTree(true, true)), "block_oozing_sapling");
    
    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
    	
        IForgeRegistry<Block> registry = event.getRegistry();
        
        for (Block block : blocks) {
        	
        	registry.register(block);
        }
    }
    
    @SubscribeEvent
    public static void onRegisterItemBlock(RegistryEvent.Register<Item> event) {
    	
        IForgeRegistry<Item> registry = event.getRegistry();
        
        for (Item item : blockItems) {
        	
        	registry.register(item);
        }
    }

    private static Block registerBlock(Block block, String name) {
        block
                .setRegistryName(name)
                .setTranslationKey(SpookyThings.MODID + "." + name)
                .setCreativeTab(SpookyThings.SPOOKY_TAB);
        
        blocks.add(block);
        
        Item blockItem = new ItemBlock(block);
        blockItem.setRegistryName(name);
        blockItems.add(blockItem);
        return block;
    }
}
