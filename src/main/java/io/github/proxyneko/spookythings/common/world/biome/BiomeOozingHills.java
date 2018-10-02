package io.github.proxyneko.spookythings.common.world.biome;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.math.BlockPos;

public class BiomeOozingHills extends FoggyBiome {

    public BiomeOozingHills() {
        super(new BiomeProperties("Oozing Hills").setTemperature(0.25F).setRainfall(0.9F).setBaseHeight(0.05F).setHeightVariation(0.65F));
        setRegistryName("oozing_hills");
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 5, 1, 4));
        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 4;
        decorator.generateFalls = true;
        //fogColor = 0xff5605;
        //fogDensity = 0.500F;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x85E21F;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x85E21F;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x85E21F;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x85E21F;
    }

    @Override
    public float getSpawningChance() {
        return 0.2F;
    }
}
