package com.craftschemers.mczone.commands

interface TopLevelCommand : BaseMcZoneCommand {
    override val name: String
    override val aliases: List<String>
}
