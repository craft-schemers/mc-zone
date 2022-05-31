package com.craftschemers.mczone.commands

import com.craftschemers.mczone.exceptions.commands.SubcommandNotFoundException
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

abstract class BaseParentCommand : BaseMcZoneCommand {
    abstract val subcommands: List<BaseMcZoneCommand>

    fun dispatchSubcommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (subcommands.isEmpty() || args.isEmpty()) {
            return false
        }

        val subcommandName = args[0]
        val subcommand = subcommands.find { it.name == subcommandName || it.aliases.contains(subcommandName) }
            ?: throw SubcommandNotFoundException(
                name = subcommandName,
                fullCommand = "$label ${args.joinToString(" ")}",
            )

        subcommand.onCommand(sender, command, label, args.copyOfRange(1, args.size))
        return true

    }

}
