package com.bignerdranch.nyethack

/**
 * object expression
 */
val abandonedTownSquare = object : TownSquare() {
    override fun load() = "I expected you to be welcome, but nobody here."
}

fun main(args: Array<String>) {

    Game.play()
}

/**
 * object declaration
 */
object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    init {
        println("Welcome to visit.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Please enter a command: ")
            println("Recent commands: ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }
}
