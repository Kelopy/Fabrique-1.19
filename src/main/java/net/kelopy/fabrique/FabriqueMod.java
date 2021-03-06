package net.kelopy.fabrique;

import net.fabricmc.api.ModInitializer;
import net.kelopy.fabrique.block.ModBlocks;
import net.kelopy.fabrique.item.ModItems;
import net.kelopy.fabrique.painting.ModPaintings;
import net.kelopy.fabrique.util.ModLootTableModifiers;
import net.kelopy.fabrique.villager.ModVillagers;
import net.kelopy.fabrique.world.feature.ModConfiguredFeatures;
import net.kelopy.fabrique.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabriqueMod implements ModInitializer {

	public static final String MOD_ID = "fabrique";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();
		ModOreGeneration.generateOres();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModVillagers.registerVillagers();
        ModVillagers.registerTrades();
        ModPaintings.registerPaintings();
        ModLootTableModifiers.modifyLootTables();
	}

}
