package com.craftschemers.mczone

import com.craftschemers.mczone.commands.CommandManager
import com.craftschemers.mczone.commands.JoinCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File
import java.util.logging.Level

class McZonePlugin(
    loader: JavaPluginLoader,
    description: PluginDescriptionFile,
    dataFolder: File,
    file: File,
) : JavaPlugin(loader, description, dataFolder, file) {

    companion object {
        lateinit var mcZone: McZonePlugin
    }

    private val commandManager = CommandManager()

    override fun onEnable() {
        logger.log(Level.INFO, "enabled!")
        mcZone = this
        listOf(
            JoinCommand
        ).forEach {
            commandManager.registerCommand(it)
        }
    }

    override fun onDisable() {
        logger.log(Level.INFO, "disabled!")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return commandManager.onCommand(sender, command, label, args)
    }

}
