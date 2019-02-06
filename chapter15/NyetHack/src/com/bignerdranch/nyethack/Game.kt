package com.bignerdranch.nyethack

import java.lang.Exception

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

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

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
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("The $direction direction is out of range.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, move to the ${newRoom.name} in the $direction direction "
        } catch (e: Exception) {
            println(e)
            "Wrong direction: $directionInput"
        }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            else -> commentNotFound()
        }

        private fun commentNotFound() = "This is an invalid command."
    }
}
