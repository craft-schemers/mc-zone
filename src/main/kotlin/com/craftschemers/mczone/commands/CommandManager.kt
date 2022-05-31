package com.craftschemers.mczone.commands

import com.craftschemers.mczone.McZonePlugin
import com.craftschemers.mczone.exceptions.commands.CommandNotFoundException
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CommandManager : CommandExecutor {

    val commands = listOf<BaseMcZoneCommand>()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        commands.forEach {
            if (it.aliases.contains(label)) {
                it.onCommand(sender, command, label, args)
            }
        }
        return true
    }

    fun registerCommand(command: BaseMcZoneCommand) {
        getBukkitCommand(command.name).setExecutor(command)
    }

    private fun getBukkitCommand(name: String) =
        McZonePlugin.mcZone.getCommand(name) ?: throw CommandNotFoundException(name)

}
