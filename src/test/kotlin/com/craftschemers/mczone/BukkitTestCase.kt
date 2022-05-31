package com.craftschemers.mczone

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class BukkitTestCase {

    lateinit var server: ServerMock
    lateinit var plugin: McZonePlugin

    @BeforeEach
    fun setup() {
        server = MockBukkit.mock()
        plugin = MockBukkit.load(McZonePlugin::class.java) as McZonePlugin
    }

    @AfterEach
    fun tearDown() {
        MockBukkit.unmock()
    }

}
