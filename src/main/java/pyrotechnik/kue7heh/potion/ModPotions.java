package pyrotechnik.kue7heh.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import pyrotechnik.kue7heh.Pyrotechnik;
import pyrotechnik.kue7heh.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> FIRE_POTION = registerPotion("fire_potion",
            new Potion(new StatusEffectInstance(ModEffects.AFLAME,200,0)));

    public static final RegistryEntry<Potion> FREEZE_POTION = registerPotion("freeze_potion",
            new Potion(new StatusEffectInstance(ModEffects.FROZEN,600,0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Pyrotechnik.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Pyrotechnik.LOGGER.info("Registering mod potions for " + Pyrotechnik.MOD_ID);
    }
}
