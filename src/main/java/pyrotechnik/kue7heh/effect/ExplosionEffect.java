package pyrotechnik.kue7heh.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;
import java.util.Optional;

import static java.lang.Math.random;

public class ExplosionEffect extends StatusEffect {
    private static final ExplosionBehavior EXPLOSION_BEHAVIOR = new AdvancedExplosionBehavior
            (false, true, Optional.of(2.0F),Optional.empty());
    public ExplosionEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        World world = entity.getWorld();
        float chance = 0.05f;
        float n = (float) random();
        if(n < chance)
        {
            float x = (float) random();
            float z = (float) random();
            world.createExplosion(
                    null,
                    null,
                    EXPLOSION_BEHAVIOR,
                    entity.getX()+(x-0.5),
                    (entity.getHeight()*0.5F)+entity.getY(),
                    entity.getZ()+(z-0.5),
                    1F,false,
                    World.ExplosionSourceType.NONE);
        }
        else return super.applyUpdateEffect(entity, amplifier);
        return super.applyUpdateEffect(entity, amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}