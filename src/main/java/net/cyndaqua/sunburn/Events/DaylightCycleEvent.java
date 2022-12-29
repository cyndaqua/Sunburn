package net.cyndaqua.sunburn.Events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndWorldTick;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class DaylightCycleEvent implements EndWorldTick {

    Text dayStart = Text.literal("The sun reigns supreme... the heat is too much.").fillStyle(Style.EMPTY.withColor(Formatting.RED).withBold(true));
    Text nightStart = Text.literal("The sun is falling... come out and play.").fillStyle(Style.EMPTY.withColor(Formatting.GRAY).withBold(true));

    @Override
    public void onEndTick(ServerWorld world) {
        if (world.getTimeOfDay() == 1) {
            PlayerLookup.world(world).forEach((player) -> player.sendMessage(dayStart, true));
        }
        else if (world.getTimeOfDay() == 13000) {
            PlayerLookup.world(world).forEach((player) -> player.sendMessage(nightStart, true));
        }
    }
}