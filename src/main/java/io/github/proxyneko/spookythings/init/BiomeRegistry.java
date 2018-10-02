package io.github.proxyneko.spookythings.init;

import io.github.proxyneko.spookythings.SpookyThings;
import io.github.proxyneko.spookythings.common.world.biome.BiomeBloodiedForest;
import io.github.proxyneko.spookythings.common.world.biome.BiomeOozingHills;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = SpookyThings.MODID)
@GameRegistry.ObjectHolder(SpookyThings.MODID)
public class BiomeRegistry {

    private static final BiomeOozingHills OOZING_HILLS = new BiomeOozingHills();
    private static final BiomeBloodiedForest BLOODIED_FOREST = new BiomeBloodiedForest();

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.registerAll
                (
                        OOZING_HILLS,
                        BLOODIED_FOREST
                );
        registerBiomeTypes();
    }

    public static void registerBiomeTypes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(OOZING_HILLS, 25));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLOODIED_FOREST, 25));

        BiomeManager.addSpawnBiome(OOZING_HILLS);
        BiomeManager.addSpawnBiome(BLOODIED_FOREST);

        BiomeManager.addStrongholdBiome(OOZING_HILLS);
        BiomeManager.addStrongholdBiome(BLOODIED_FOREST);

        BiomeDictionary.addTypes(OOZING_HILLS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET);
        BiomeDictionary.addTypes(BLOODIED_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
    }
}