package com.craftschemers.mczone.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object ListGamesCommand : TopLevelCommand {

    override val name: String = "listgames"
    override val aliases: List<String> = listOf()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        TODO("Not yet implemented")
    }

}
