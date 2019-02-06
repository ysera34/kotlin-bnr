package com.bignerdranch.nyethack

import java.lang.Exception
import kotlin.system.exitProcess

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
    private var exitCode = ""

    init {
        println("Welcome to visit.")
        player.castFireball()
    }

    fun play() {
        while (exitCode != "end") {
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

    private fun displayCurrentPosition(): String {
        var result = ""

        worldMap.forEachIndexed { listIndex, list ->
            list.forEachIndexed { roomIndex, room ->
                if (listIndex == player.currentPosition.y
                    && roomIndex == player.currentPosition.x) {
                    result += "X "
                } else {
                    result += "O "
                }
            }
            if (worldMap.size != listIndex + 1) {
                result += "\n"
            }
        }
        return result
    }

    private fun ring(): String =
        if (currentRoom is TownSquare) {
            (currentRoom as TownSquare).ringBell()
        } else {
            "You can not hit a bell in this space."
        }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }

        "The fight is over."
    } ?: "There are no monsters to fight here."

    private fun slay(monster: Monster) {
        println("${monster.name} -- ${monster.attack(player)} damaged!!")
        println("${player.name} -- ${player.attack(monster)} damaged!!")

        if (player.healthPoints <= 0) {
            println(">>> You are lost. End the game. <<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>> Repel the ${monster.name}!! <<<")
        }
    }
    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.toLowerCase()) {
            "fight" -> fight()
            "move" -> move(argument)
            "map" -> displayCurrentPosition()
            "ring" -> ring()
            "quit" -> finish()
            "exit" -> finish()
            else -> commandNotFound()
        }

        private fun finish(): String {
            exitCode = "end"
            return "Finish game."
        }

        private fun commandNotFound() = "This is an invalid command."
    }
}
