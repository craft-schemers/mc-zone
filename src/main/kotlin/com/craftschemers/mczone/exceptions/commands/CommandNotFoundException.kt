package com.craftschemers.mczone.exceptions.commands

open class CommandNotFoundException (
    name: String,
    fullCommand: String? = null,
) : Throwable("Command '$name' not found" + (fullCommand?.let { ": /$it" } ?: ""))

class SubcommandNotFoundException(
    name: String,
    fullCommand: String? = null,
) : CommandNotFoundException(name, fullCommand)

