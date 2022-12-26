package net.cyndaqua.sunburn;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndWorldTick;
import net.minecraft.server.world.ServerWorld;

public class DaylightCycleEvent implements EndWorldTick {

    @Override
    public void onEndTick(ServerWorld world) {
        
        if (world.getTimeOfDay() == 1) {
            System.out.println("Morning.");
            //PlayerEntity.sendMessage(Text.literal("The sun reigns supreme... the heat is too much."), false);
        }
        else if (world.getTimeOfDay() == 13000) {
            System.out.println("Night.");
            //PlayerEntity.sendMessage(Text.literal("The sun is falling... come out and play."), false);
        }
    }
}
