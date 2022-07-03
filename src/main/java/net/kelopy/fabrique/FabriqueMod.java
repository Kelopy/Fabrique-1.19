package net.kelopy.fabrique;

import net.fabricmc.api.ModInitializer;
import net.kelopy.fabrique.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabriqueMod implements ModInitializer {

	public static final String MOD_ID = "fabrique";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}

}
