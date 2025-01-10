package pyrotechnik.kue7heh.effect;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireEffect extends StatusEffect {
    public FireEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        BlockPos blockPos = entity.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        world.getBlockState(blockPos);
        return !blockState.isAir() || world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}