package net.cyndaqua.sunburn.DamageSources;
import net.minecraft.entity.damage.DamageSource;

public class SunDamage extends DamageSource {

    public static final DamageSource SUN = new SunDamage("sun");
    public static final DamageSource SUNGrass = new SunDamage("grass");
    
    protected SunDamage(String name) {
        super(name);
    }
}