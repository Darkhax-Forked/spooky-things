package io.github.proxyneko.spookythings.common.blocks;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BasicSapling extends BlockSapling {

    private WorldGenerator tree;

    public BasicSapling(WorldGenerator tree) {
        setSoundType(SoundType.PLANT);
        this.tree = tree;
    }

    public void growTree(World world, BlockPos pos, IBlockState state, Random random) {
        if (!TerrainGen.saplingGrowTree(world, random, pos)) {
            return;
        }

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 1);
        if (!tree.generate(world, random, pos))
            world.setBlockState(pos, getDefaultState(), 4);
    }

    @Override
    public void grow(World world, BlockPos pos, IBlockState state, Random random) {
        if (state.getValue(STAGE) == 0) {
            world.setBlockState(pos, state.cycleProperty(STAGE), 4);
        } else {
            growTree(world, pos, state, random);
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        list.add(new ItemStack(this, 1, 0));
    }
}