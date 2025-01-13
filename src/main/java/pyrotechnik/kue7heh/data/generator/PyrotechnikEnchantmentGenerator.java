package pyrotechnik.kue7heh.data.generator;

import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.tag.EntityTypeTags;
import pyrotechnik.kue7heh.enchantments.effects.ExplosiveArrowsEnchantmentEffect;
import pyrotechnik.kue7heh.init.EnchantmentInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class PyrotechnikEnchantmentGenerator extends FabricDynamicRegistryProvider {
    public PyrotechnikEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);

        register(entries, EnchantmentInit.EXPLOSIVE_ARROWS_KEY, Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.CROSSBOW_ENCHANTABLE),
                                5, // probability of showing up in the enchantment table
                                3, // max level
                                Enchantment.leveledCost(1, 10), // cost per level (base)
                                Enchantment.leveledCost(1, 20), // cost per level (max)
                                4, // anvil applying cost
                                AttributeModifierSlot.HAND
                        ))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new ExplosiveArrowsEnchantmentEffect(EnchantmentLevelBasedValue.linear(1F, 0.5F)))
                .addEffect(EnchantmentEffectComponentTypes.HIT_BLOCK,
                        new ExplosiveArrowsEnchantmentEffect(EnchantmentLevelBasedValue.linear(1F, 0.5F)))
                .addEffect(
                        EnchantmentEffectComponentTypes.DAMAGE,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(-1F)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityTarget.DIRECT_ATTACKER, EntityPredicate.Builder.create().type(EntityTypeTags.ARROWS).build())
                ));
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "Enchantment Generator";
    }
}