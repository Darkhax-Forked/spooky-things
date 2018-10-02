package io.github.proxyneko.spookythings.init;

import io.github.proxyneko.spookythings.SpookyThings;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = SpookyThings.MODID)
@GameRegistry.ObjectHolder(SpookyThings.MODID)
public class ItemRegistry {

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> register = event.getRegistry();
        register.registerAll();
    }
}
