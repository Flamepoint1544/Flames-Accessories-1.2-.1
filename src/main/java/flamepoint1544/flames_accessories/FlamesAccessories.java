package flamepoint1544.flames_accessories;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlamesAccessories implements ModInitializer {
	public static final String MOD_ID = "flames_accessories";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing the mod");
		ModItems.initialize();
	}
}