package net.cyndaqua.sunburn.Events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndWorldTick;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class WeatherCycleEvent implements EndWorldTick {

    private static boolean wasRaining;

    Text rainStart = Text.literal("The rain exhausts the heat...").fillStyle(Style.EMPTY.withColor(Formatting.BLUE).withBold(true));
    Text rainEnd = Text.literal("The rain is evaporating away...").fillStyle(Style.EMPTY.withColor(Formatting.RED).withBold(true));

    @Override
    public void onEndTick(ServerWorld world) {
        if (!wasRaining && world.isRaining() && world.getRegistryKey() == World.OVERWORLD) {
            PlayerLookup.world(world).forEach((player) -> player.sendMessage(rainStart, false));
        }
        else if (wasRaining && !world.isRaining() && world.getRegistryKey() == World.OVERWORLD) {
            PlayerLookup.world(world).forEach((player) -> player.sendMessage(rainEnd, false));
        }
        if (world.getRegistryKey() == World.OVERWORLD) {
            wasRaining = world.isRaining();
        }
    }
    
}
