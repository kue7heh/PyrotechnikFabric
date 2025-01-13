package pyrotechnik.kue7heh.init;

import com.mojang.serialization.MapCodec;
import pyrotechnik.kue7heh.Pyrotechnik;
import pyrotechnik.kue7heh.enchantments.effects.ExplosiveArrowsEnchantmentEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EnchantmentInit {
    public static final RegistryKey<Enchantment> EXPLOSIVE_ARROWS_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Pyrotechnik.id("explosive_arrows"));

    public static final MapCodec<ExplosiveArrowsEnchantmentEffect> EXPLOSIVE_ARROWS = register("explosive_arrows", ExplosiveArrowsEnchantmentEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Pyrotechnik.id(name), codec);
    }

    public static void load() {}
}
