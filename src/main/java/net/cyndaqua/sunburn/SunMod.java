package net.cyndaqua.sunburn;

import net.cyndaqua.sunburn.Events.DaylightCycleEvent;
import net.cyndaqua.sunburn.Events.PlayerDeath;
import net.cyndaqua.sunburn.Events.WeatherCycleEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SunMod implements ModInitializer {
	private static final String MODID = "sunburn";
	private static final String Sundeaths_Statname = "sun_deaths";

	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final Identifier Sundeaths = new Identifier(MODID, Sundeaths_Statname);

	@Override
	public void onInitialize() {
		LOGGER.info("The sun soaks the world in a hellstorm...");

		ServerTickEvents.END_WORLD_TICK.register(new DaylightCycleEvent());

		ServerTickEvents.END_WORLD_TICK.register(new WeatherCycleEvent());

		ServerLivingEntityEvents.AFTER_DEATH.register(new PlayerDeath());

		Registry.register(Registries.CUSTOM_STAT, Sundeaths_Statname, Sundeaths);
		Stats.CUSTOM.getOrCreateStat(Sundeaths, StatFormatter.DEFAULT);
	}
}
