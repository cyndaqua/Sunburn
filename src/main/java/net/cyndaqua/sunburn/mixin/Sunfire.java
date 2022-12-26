package net.cyndaqua.sunburn.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class Sunfire extends Entity { //Intended to damage players if the conditions are met.

	public Sunfire(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "tick", at = @At("RETURN"))
	private void onTick(CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;

		if (livingEntity instanceof PlayerEntity player && !world.isClient) {
			if (world.isDay() && !world.isRaining() && !player.isSubmergedInWater() && 13000 < world.getTime() && 11 < world.getLightLevel(LightType.SKY, player.getBlockPos())) {
				player.damage(DamageSource.IN_FIRE, 4);
			}
		}
	}
}