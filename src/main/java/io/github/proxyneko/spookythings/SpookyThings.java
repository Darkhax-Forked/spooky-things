package io.github.proxyneko.spookythings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = SpookyThings.MODID, name = SpookyThings.NAME, version = SpookyThings.VERSION, acceptedMinecraftVersions = SpookyThings.MC_VERSION, certificateFingerprint = SpookyThings.FINGERPRINT, updateJSON = SpookyThings.UPDATE_JSON)
public class SpookyThings {

    public static final String MODID = "spookythings";
    public static final String NAME = "Spooky Things";
    public static final String VERSION = "@version@";
    public static final String MC_VERSION = "@mc_version@";
    public static final String FINGERPRINT = "@fingerprint@";
    public static final String UPDATE_JSON = "@update_json@";
    public static final Logger LOGGER = LogManager.getLogger(NAME);
    public static final CreativeTabs SPOOKY_TAB = new CreativeTabs(MODID) {

        @Override
        public CreativeTabs setBackgroundImageName(String texture) {
            return super.setBackgroundImageName("item_search.png");
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        FMLLog.bigWarning("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported by Proxy!");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Did I hear someone say SpookyJam???");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Time to get spooky >:3");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("AH! Not that spookty!! Run Scooby Doo!!");
    }
}