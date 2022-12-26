package net.cyndaqua.sunburn;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndWorldTick;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class DaylightCycleEvent implements EndWorldTick{

    @Override
    public void onEndTick(ServerWorld world) {
        
        if (world.getTime() == 0) {
            world.getPlayers().get(0).sendMessage(Text.of("The sun reigns supreme... the heat is too much."), true);
        }
        else if (world.getTimeOfDay() == 13000) {
            world.getPlayers().get(0).sendMessage(Text.literal("The sun is falling... come out and play."), true);
        }
    }  
}
