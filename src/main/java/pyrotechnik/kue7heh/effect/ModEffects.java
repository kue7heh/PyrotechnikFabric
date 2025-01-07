package pyrotechnik.kue7heh.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import pyrotechnik.kue7heh.Pyrotechnik;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> AFLAME = registerStatusEffect("aflame",
            new FireEffect(StatusEffectCategory.NEUTRAL, 0xff6f00)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Pyrotechnik.MOD_ID, "aflame"), -0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> FROZEN = registerStatusEffect("frozen",
            new FreezeEffect(StatusEffectCategory.NEUTRAL, 0x9effff)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Pyrotechnik.MOD_ID, "frozen"), -0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Pyrotechnik.MOD_ID, name),statusEffect);
    }

    public static void registerEffects() {
        Pyrotechnik.LOGGER.info("Registering mod effects for " + Pyrotechnik.MOD_ID);
    }
}
