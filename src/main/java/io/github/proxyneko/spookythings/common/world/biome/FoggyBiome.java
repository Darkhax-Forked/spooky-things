package io.github.proxyneko.spookythings.common.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class FoggyBiome extends Biome {

    public int fogColor = -1;
    public float fogDensity = 1.0F;

    public FoggyBiome(BiomeProperties properties) {
        super(properties);
    }

    public int getFogColor(BlockPos pos) {
        return fogColor;
    }

    public float getFogDensity(BlockPos pos) {
        return fogDensity;
    }
}
