package com.newwind.nwtweaks;

import com.newwind.nwtweaks.joymix.JoyMixNWTweaks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.newwind.nwtweaks.joymix.registry.Blocks;
import com.newwind.nwtweaks.joymix.registry.Items;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("nwtweaks")
public class NWTweaks {

    public static final String modid = "nwtweaks";

    public static final Logger LOGGER = LogManager.getLogger();

    public static JoyMixNWTweaks joyMix = null;

    // Slight workaround for Exceptions
    public static NWTweaksConfigExceptions exceptionToBeThrown = NWTweaksConfigExceptions.NONE;
    public static Exception NO_MODPACK_NAME_EXCEPTION = new Exception("No Moadpack Specified in NWTweaks Config File!");
    public static Exception INVALID_MODPACK_NAME_EXCEPTION = new Exception("Invalid Modpack Name!");

    public NWTweaks() throws Exception {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.SPEC, "nwtweaks-common.toml");

        if (ConfigManager.modpackName.get() == "joymix") {
            joyMix = new JoyMixNWTweaks();
        } else if (ConfigManager.modpackName.get() == "") {
            exceptionToBeThrown = NWTweaksConfigExceptions.NO_MODPACK_NAME;
        } else {
            exceptionToBeThrown = NWTweaksConfigExceptions.INVALID_MODPACK_NAME;
        }
    }

    @SubscribeEvent
    public static void onLoadingFinished(FMLLoadCompleteEvent event) throws Exception {
        if (exceptionToBeThrown == NWTweaksConfigExceptions.NO_MODPACK_NAME) {
            throw NO_MODPACK_NAME_EXCEPTION;
        }

        if (exceptionToBeThrown == NWTweaksConfigExceptions.INVALID_MODPACK_NAME) {
            throw INVALID_MODPACK_NAME_EXCEPTION;
        }
    }

}
