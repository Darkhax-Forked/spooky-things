package io.github.proxyneko.spookythings.common.world.biome;

import net.minecraft.entity.monster.EntityVex;
import net.minecraft.util.math.BlockPos;

public class BiomeBloodiedForest extends FoggyBiome {

    public BiomeBloodiedForest() {
        super(new BiomeProperties("Bloodied Forest").setTemperature(0.50F).setRainfall(0.5F).setBaseHeight(0.01F).setHeightVariation(0.05F));
        setRegistryName("bloodied_forest");
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityVex.class, 1, 1, 1));
        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = 2;
        decorator.generateFalls = true;
        //fogColor = 0xFF5605;
        //fogDensity = 0.500F;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x8F0000;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x8F0000;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x8F0000;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x8F0000;
    }

    @Override
    public float getSpawningChance() {
        return 0.2F;
    }
}
