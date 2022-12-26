package net.cyndaqua.sunburn;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SunMod implements ModInitializer {
	private static final String MODID = "sunburn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("The sun soaks the world in a hellstorm...");
	}
}