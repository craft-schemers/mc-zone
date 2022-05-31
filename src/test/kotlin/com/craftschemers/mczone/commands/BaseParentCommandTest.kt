package com.craftschemers.mczone.commands

import assertk.assertThat
import assertk.assertions.isTrue
import com.craftschemers.mczone.BukkitTestCase
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.junit.jupiter.api.Test

class BaseParentCommandTest : BukkitTestCase() {

    lateinit var command: BaseParentCommand
    lateinit var subcommand: BaseMcZoneCommand

    @Test
    fun `subcommand is executed`() {

        val commandManager = CommandManager()

        val subcommand = object : BaseMcZoneCommand {
            override val name: String = "subcommand"
            override val aliases: List<String> = listOf()
            var called = false

            override fun onCommand(
                sender: CommandSender,
                command: Command,
                label: String,
                args: Array<out String>,
            ): Boolean {
                called = true
                return true
            }

        }

        val command = object : BaseParentCommand() {
            override val subcommands: List<BaseMcZoneCommand> = listOf(subcommand)
            override val name: String = "mczone"
            override val aliases: List<String> = listOf()

            override fun onCommand(
                sender: CommandSender,
                command: Command,
                label: String,
                args: Array<out String>,
            ): Boolean {
                dispatchSubcommand(sender, command, label, args)
                return true
            }

        }
        commandManager.registerCommand(command)
        server.dispatchCommand(server.addPlayer(), "mczone subcommand")
        assertThat(subcommand.called).isTrue()

    }

}
