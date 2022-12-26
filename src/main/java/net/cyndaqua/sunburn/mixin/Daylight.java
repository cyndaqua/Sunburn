package net.cyndaqua.sunburn.mixin;

import java.io.IOException;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

@Mixin(World.class)
public abstract class Daylight extends World { //Intended to broadcast to chat when it's safe to go above ground.

    protected Daylight(MutableWorldProperties properties, RegistryKey<World> registryRef,
            RegistryEntry<DimensionType> dimension, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld,
            long seed, int maxChainedNeighborUpdates) {
        super(properties, registryRef, dimension, profiler, isClient, debugWorld, seed, maxChainedNeighborUpdates);
    }
    
    @Inject(method = "tick", at = @At("RETURN")) //Unable to determine descriptor for @Inject target method
    private void onTick (CallbackInfo info) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        try (World world = (World) (Object) this) { 
            if (world.getTime() == 0) {
                player.sendMessage(Text.literal("The sun reigns supreme... the heat is too much."));
            }
            else if (world.getTimeOfDay() == 13000) {
                player.sendMessage(Text.literal("The sun is falling... come out and play."));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
