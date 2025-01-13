package pyrotechnik.kue7heh.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;
import java.util.Optional;

import static java.lang.Boolean.getBoolean;
import static pyrotechnik.kue7heh.config.config.explosive_arrows_enchantment_destroys_blocks;

public record ExplosiveArrowsEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {

    private static final ExplosionBehavior EXPLOSION_BEHAVIOR = new AdvancedExplosionBehavior
            (getBoolean(Boolean.toString(explosive_arrows_enchantment_destroys_blocks)), true, Optional.of(0.3F),Optional.empty());

    public static final MapCodec<ExplosiveArrowsEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(ExplosiveArrowsEnchantmentEffect::amount)
            ).apply(instance, ExplosiveArrowsEnchantmentEffect::new));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {

        if(target instanceof LivingEntity living) {
            float power = this.amount.getValue(level);

            BlockPos targetPosition = living.getBlockPos();
            {
                world.createExplosion(
                        null,
                        null,
                        EXPLOSION_BEHAVIOR,
                        target.getX(),
                        target.getY(),
                        target.getZ(),
                        power,
                        false,
                        World.ExplosionSourceType.TRIGGER);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}