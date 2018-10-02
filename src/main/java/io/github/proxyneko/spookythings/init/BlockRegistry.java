package io.github.proxyneko.spookythings.init;

import io.github.proxyneko.spookythings.SpookyThings;
import io.github.proxyneko.spookythings.common.blocks.BasicLog;
import io.github.proxyneko.spookythings.common.blocks.BasicSapling;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
    public static void onRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> register = event.getRegistry();
        register.registerAll
                (
                        BLOCK_BLOOD_LOG,
                        BLOCK_OOZING_LOG,
                        //BLOCK_BLOOD_LEAVES,
                        //BLOCK_OOZING_LEAVES,
                        BLOCK_BLOOD_PLANKS,
                        BLOCK_OOZING_PLANKS,
                        BLOCK_BLOOD_SAPLING,
                        BLOCK_OOZING_SAPLING
                );
    }

    private static Block registerBlock(Block block, String name) {
        block
                .setRegistryName(name)
                .setTranslationKey(SpookyThings.MODID + "." + name)
                .setCreativeTab(SpookyThings.SPOOKY_TAB);
        return block;
    }
}
