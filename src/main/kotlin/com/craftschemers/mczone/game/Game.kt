package com.craftschemers.mczone.game

class Game(
    private val players: MutableList<GamePlayer> = mutableListOf(),
    val map: GameMap
) {

    fun addPlayer(player: GamePlayer) {
        players += player
    }

    fun start() {
        TODO()
    }

}
