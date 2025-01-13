package pyrotechnik.kue7heh;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyrotechnik.kue7heh.config.PyrotechnikConfig;
import pyrotechnik.kue7heh.effect.ModEffects;
import pyrotechnik.kue7heh.init.EnchantmentInit;
import pyrotechnik.kue7heh.potion.ModPotions;

public class Pyrotechnik implements ModInitializer {
	public static final String MOD_ID = "pyrotechnik";
	public static final PyrotechnikConfig CONFIG = PyrotechnikConfig.createAndLoad();
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		EnchantmentInit.load();

		LOGGER.info("Hello Fabric world!");

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.FIRE_RESISTANCE, Items.FIRE_CHARGE, ModPotions.FIRE_POTION);
			builder.registerPotionRecipe(Potions.SLOWNESS, Items.BLUE_ICE, ModPotions.FREEZE_POTION);
			builder.registerPotionRecipe(Potions.AWKWARD, Items.TNT, ModPotions.EXPLOSIVE_POTION);
		});

	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}