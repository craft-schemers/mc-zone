package com.craftschemers.mczone

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

class McZonePlugin: JavaPlugin() {

    override fun onEnable() {
        logger.log(Level.INFO, "enabled!")
    }

    override fun onDisable() {
        logger.log(Level.INFO, "disabled!")
    }

}
