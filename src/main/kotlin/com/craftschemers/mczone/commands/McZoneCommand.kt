package com.craftschemers.mczone.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object McZoneCommand : BaseParentCommand(), TopLevelCommand {

    override val name: String = "mczone"
    override val aliases: List<String> = listOf("mcz")
    override val subcommands: List<BaseMcZoneCommand> = listOf(
        JoinCommand,
        ListGamesCommand,
    )

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        dispatchSubcommand(sender, command, label, args)
        return true
    }

}
