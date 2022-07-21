package com.newwind.nwtweaks.joymix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.newwind.nwtweaks.joymix.registry.Blocks;
import com.newwind.nwtweaks.joymix.registry.Items;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
public class JoyMixNWTweaks {

	public static final String modid = "nwtweaks";

	public static final Logger LOGGER = LogManager.getLogger();

	public JoyMixNWTweaks() {
		Blocks.register();
		Items.register();

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

}
