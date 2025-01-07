package pyrotechnik.kue7heh;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyrotechnik.kue7heh.effect.ModEffects;
import pyrotechnik.kue7heh.potion.ModPotions;

public class Pyrotechnik implements ModInitializer {
	public static final String MOD_ID = "pyrotechnik";

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

		LOGGER.info("Hello Fabric world!");

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.FIRE_RESISTANCE, Items.BLAZE_POWDER, ModPotions.FIRE_POTION);
			builder.registerPotionRecipe(Potions.AWKWARD, Items.BLUE_ICE, ModPotions.FREEZE_POTION);
		});
	}
}