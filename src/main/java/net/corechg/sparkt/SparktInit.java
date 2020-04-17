package net.corechg.sparkt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class SparktInit implements ModInitializer {

    public static final Logger LOG = LogManager.getFormatterLogger("Sparkt|Init");
    public static final String MODID = "sparkt";

    @Override
    public void onInitialize() {
        LOG.info("Preparing to spark a reaction!");
        BlockRegister.register(MODID);
    }

}