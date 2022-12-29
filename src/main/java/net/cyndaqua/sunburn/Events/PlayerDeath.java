package net.cyndaqua.sunburn.Events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cyndaqua.sunburn.SunMod;
import net.cyndaqua.sunburn.DamageSources.SunDamage;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerDeath implements ServerLivingEntityEvents.AfterDeath{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerDeath.class);

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        if (entity instanceof PlayerEntity player) {
            if (damageSource == SunDamage.SUN || damageSource == SunDamage.SUNGrass)
                LOGGER.info(":skull:");
                player.incrementStat(SunMod.Sundeaths);
        }        
    }
    
}
