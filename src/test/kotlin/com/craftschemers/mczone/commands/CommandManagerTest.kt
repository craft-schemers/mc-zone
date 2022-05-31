package com.craftschemers.mczone.commands

import assertk.assertThat
import assertk.assertions.isTrue
import com.craftschemers.mczone.BukkitTestCase
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.junit.jupiter.api.Test

class CommandManagerTest : BukkitTestCase() {

    @Test
    fun `command manager executes command`() {

        val commandManager = CommandManager()
        val command = object : BaseMcZoneCommand {
            override val name: String = "mczone"
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
        commandManager.registerCommand(command)
        server.dispatchCommand(server.addPlayer(), "mczone")
        assertThat(command.called).isTrue()

    }

}
