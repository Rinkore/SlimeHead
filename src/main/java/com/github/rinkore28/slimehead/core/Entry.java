package com.github.rinkore28.slimehead.core;

import com.github.rinkore28.slimehead.core.registry.entities.EntityRegister;
import com.github.rinkore28.slimehead.core.registry.items.ItemRegister;
import com.github.rinkore28.slimehead.core.registry.items.SpawnEgg;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Entry implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "slimehead";
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("slimehead loading!");
        ItemRegister.init();
        EntityRegister.init();
    }
    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }
}
