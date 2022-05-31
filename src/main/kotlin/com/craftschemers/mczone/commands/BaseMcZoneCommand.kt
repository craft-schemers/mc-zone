package com.craftschemers.mczone.commands

import org.bukkit.command.CommandExecutor

interface BaseMcZoneCommand: CommandExecutor {
    val name: String
    val aliases: List<String>
}
